package com.moo.springnetty.handlers.codec.kame;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: zheng
 * Date: 14-3-4
 * Time: 下午9:16
 * 自定义协议编码器
 */
public class KameResponseEncoder extends MessageToByteEncoder<KameResponse> {

    @Override
    protected void encode(ChannelHandlerContext ctx, KameResponse msg, ByteBuf out) throws Exception {
        System.out.println("KameResponseEncoder: " + msg);
        out.writeByte(msg.getEncode());
        out.writeByte(msg.getEncrypt());
        out.writeByte(msg.getExtend1());
        out.writeByte(msg.getExtend2());
        out.writeInt(msg.getSessionId());
        out.writeInt(msg.getResult());
    }

}
