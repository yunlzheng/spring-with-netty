package com.moo.springnetty.handlers;

import com.moo.springnetty.handlers.codec.kame.KameDecoder;
import com.moo.springnetty.handlers.codec.kame.KameEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("KameProtocolInitializer")
public class KameProtocolInitalizer extends ChannelInitializer<SocketChannel> {

    @Autowired
    KameDecoder kameDecoder;

    @Autowired
    KameEncoder kameEncoder;

    @Autowired
    KameServerHandler KameServerHandler;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("decoder", kameDecoder);
        pipeline.addLast("handler", KameServerHandler);
        pipeline.addLast("encoder", kameEncoder);
    }

    public KameDecoder getKameDecoder() {
        return kameDecoder;
    }

    public void setKameDecoder(KameDecoder kameDecoder) {
        this.kameDecoder = kameDecoder;
    }

    public KameEncoder getKameEncoder() {
        return kameEncoder;
    }

    public void setKameEncoder(KameEncoder kameEncoder) {
        this.kameEncoder = kameEncoder;
    }

    public KameServerHandler getKameServerHandler() {
        return KameServerHandler;
    }

    public void setKameServerHandler(KameServerHandler kameServerHandler) {
        KameServerHandler = kameServerHandler;
    }
}

