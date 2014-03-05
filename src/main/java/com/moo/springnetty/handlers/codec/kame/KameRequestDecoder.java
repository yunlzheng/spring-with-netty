package com.moo.springnetty.handlers.codec.kame;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * .
 * User: zheng
 * Date: 14-3-5
 * Time: 上午10:03
 * 自定义协议解码器
 */
public class KameRequestDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        if (in.readableBytes() < 12) {
            return;
        }

        byte encode = in.readByte();
        byte encrypt = in.readByte();
        byte extend1 = in.readByte();
        byte extend2 = in.readByte();
        int sessionId = in.readInt();
        int command = in.readInt();

        // TODO 根据length大小获取数据包大小
        KameRequest request = new KameRequest();
        request.setEncode(encode);
        request.setEncrypt(encrypt);
        request.setExtend1(extend1);
        request.setExtend2(extend2);
        request.setSessionId(sessionId);
        request.setCommand(command);

        System.out.println("KameRequestDecoder:" + request);

        out.add(request);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}
