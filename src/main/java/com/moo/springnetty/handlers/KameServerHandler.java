package com.moo.springnetty.handlers;

import com.moo.springnetty.handlers.codec.kame.KameRequest;
import com.moo.springnetty.handlers.codec.kame.KameResponse;
import io.netty.channel.*;
import io.netty.channel.ChannelHandler.Sharable;

import io.netty.util.ReferenceCountUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("serverHandler")
@Sharable
public class KameServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        try {
            KameRequest request = (KameRequest) msg;
            System.out.println("Server Reciver Data: "+ msg);
            KameResponse response = buildResponse();

            // 返回处理结果response
            ChannelFuture f = ctx.channel().writeAndFlush(response);
            f.addListener(ChannelFutureListener.CLOSE);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    public KameResponse buildResponse(){
        KameResponse response = new KameResponse();
        response.setEncode(new Byte("0"));
        response.setEncrypt(new Byte("1"));
        response.setExtend1(new Byte("1"));
        response.setExtend2(new Byte("2"));
        response.setResult(4);
        response.setSessionId(9);
        return response;
    }

}

