package com.moo.springnetty.test;

import com.moo.springnetty.handlers.codec.kame.KameRequestEncoder;
import com.moo.springnetty.handlers.codec.kame.KameResponseDecoder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * Creates a newly configured {@link io.netty.channel.ChannelPipeline} for a new channel.
 */

/**
 * Creates a newly configured {@link ChannelPipeline} for a new channel.
 */
public class TestClientInitializer extends ChannelInitializer<SocketChannel> {
    private static final KameResponseDecoder DECODER = new KameResponseDecoder();
    private static final KameRequestEncoder ENCODER = new KameRequestEncoder();
    private static final TestClientHandler CLIENTHANDLER = new TestClientHandler();

    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        // Add the text line codec combination first,
        pipeline.addLast("decoder", DECODER);
        pipeline.addLast("encoder", ENCODER);

        // and then business logic.
        pipeline.addLast("handler", CLIENTHANDLER);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
