package com.moo.springnetty.handlers.codec.kame;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zheng
 * Date: 14-3-4
 * Time: 下午9:16
 * 自定义协议解码器
 */
public class KameResponseDecoder extends ByteToMessageDecoder{

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("KameResponseDecoder:" +in.readableBytes());

        if(in.readableBytes()<12) {
            return;
        }
        byte encode = in.readByte();
        byte encrypt = in.readByte();
        byte extend1 = in.readByte();
        byte extend2 = in.readByte();
        int sessionId = in.readInt();
        int result = in.readInt();

        KameResponse response = new KameResponse();
        response.setEncode(encode);
        response.setEncrypt(encrypt);
        response.setExtend1(extend1);
        response.setExtend2(extend2);
        response.setSessionId(sessionId);
        response.setResult(result);

        System.out.println("KameResponseDecoder:" + response);

        out.add(response);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
