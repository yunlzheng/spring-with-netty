package com.moo.springnetty.handlers.codec.kame;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * User: zheng
 * Date: 14-3-5
 * Time: 上午10:04
 * KameRequest 编码器
 */
@ChannelHandler.Sharable
public class KameRequestEncoder extends MessageToByteEncoder<KameRequest> {

    @Override
    protected void encode(ChannelHandlerContext ctx, KameRequest msg, ByteBuf out) throws Exception {
        out.writeByte(msg.getEncode());
        out.writeByte(msg.getEncrypt());
        out.writeByte(msg.getExtend1());
        out.writeByte(msg.getExtend2());
        out.writeInt(msg.getSessionId());
        out.writeInt(msg.getCommand());
        System.out.println("KameRequestEncoder:" +msg);
    }



}
