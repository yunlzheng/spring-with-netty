package com.moo.springnetty.handlers;

import com.moo.springnetty.handlers.codec.kame.KameRequestDecoder;
import com.moo.springnetty.handlers.codec.kame.KameResponseEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("KameProtocolInitalizer")
public class KameProtocolInitalizer extends ChannelInitializer<SocketChannel> {

    @Autowired
    private KameServerHandler serverHandler;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new KameRequestDecoder(), serverHandler, new KameResponseEncoder());

    }
}

