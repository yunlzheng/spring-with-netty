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
public class KameDecoder extends ByteToMessageDecoder{

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if(in.readableBytes()<16) {
            return;
        }
        byte encode = in.readByte();
        byte encrypt = in.readByte();
        byte extend1 = in.readByte();
        byte extend2 = in.readByte();
        int sessionId = in.readInt();
        int result = in.readInt();
        int length = in.readInt();
        if(in.readableBytes()<length) {
            in.resetReaderIndex();
            return;
        }

        // TODO 根据length大小获取数据包大小

        KameResponse response = new KameResponse();
        response.setEncode(encode);
        response.setEncrypt(encrypt);
        response.setExtend1(extend1);
        response.setExtend2(extend2);
        response.setSessionId(sessionId);
        response.setResult(result);
        response.setLength(length);

        out.add(response);



    }
}
