package com.moo.springnetty.handlers.codec.kame;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * Created with IntelliJ IDEA.
 * User: zheng
 * Date: 14-3-4
 * Time: 下午9:16
 * 自定义协议编码器
 */
public class KameEncoder extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        KameResponse response = (KameResponse)msg;
        ByteBuf encoded = ctx.alloc().buffer(16);
        encoded.writeByte(response.getEncode());
        encoded.writeByte(response.getEncrypt());
        encoded.writeByte(response.getExtend1());
        encoded.writeByte(response.getExtend2());
        encoded.writeInt(response.getSessionId());
        encoded.writeInt(response.getResult());

        // TODO 计算response的数据大小并写入
        // ChannelBuffer dataBuffer=ProtocolUtil.encode(response.getEncode(),response.getValues());
        // int length=dataBuffer.readableBytes();
        encoded.writeInt(10);

        // TODO 将response的数据转换为Bytes写入encode
        //encoded.writeBytes();
        ctx.write(encoded, promise);
    }
}
