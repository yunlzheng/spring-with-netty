package com.moo.springnetty.handlers;

import com.moo.springnetty.handlers.codec.kame.KameRequest;
import com.moo.springnetty.handlers.codec.kame.KameResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.ChannelHandler.Sharable;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("serverHandler")
@Sharable
public class KameServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        KameRequest request = (KameRequest) msg;

        // Todo 根据request 调用业务处理方法，并将结果写入response
        KameResponse response = new KameResponse();

        // 返回处理结果response
        ctx.channel().writeAndFlush(response);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Channel is active\n");
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("\nChannel is disconnected");
        super.channelInactive(ctx);
    }

}

