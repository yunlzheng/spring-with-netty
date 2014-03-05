package com.moo.springnetty.test;


import com.moo.springnetty.handlers.codec.kame.KameRequest;
import io.netty.channel.*;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.util.ReferenceCountUtil;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles a client-side channel.
 */
@Sharable
public class TestClientHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = Logger.getLogger(TestClientHandler.class.getName());

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        System.out.println("handlerAdded");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        System.out.println("handlerRemoved");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("channelActive");
        ctx.writeAndFlush(buildRequest());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try{
            System.out.println("channelRead");
            ctx.close();
        }finally {
            ReferenceCountUtil.release(msg);
        }


    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        logger.log(Level.WARNING, "Unexpected exception from downstream.", cause);
        ctx.close();
    }

    public KameRequest buildRequest(){

        int command = 1;
        int sessionId = 2;
        byte extend1 = 3;
        byte extend2 = new Byte("1");
        byte encrypt = new Byte("0");
        byte encode = new Byte("1");
        return new KameRequest(command, sessionId, extend1, extend2, encrypt, encode);

    }

}
