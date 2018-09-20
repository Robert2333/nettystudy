package echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.CharsetUtil;

@ChannelHandler.Sharable
public  class EchoServerOutHandler extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
//        ByteBuf in = (ByteBuf) msg;
//        if(in.toString(CharsetUtil.UTF_8).equals("xujunchao")){
//            ByteBuf byteBuf= Unpooled.copiedBuffer("徐俊超第一次数据\r\n", //2
//                    CharsetUtil.UTF_8);
//            ctx.write(byteBuf);
//            //会死锁
//            //ctx.pipeline().write(byteBuf);
//            //ctx.flush();
////            ctx.writeAndFlush(byteBuf);
////            ctx.flush();
//            //ctx.close();
//        }
//        else {
//            ctx.write(Unpooled.copiedBuffer("我是没有被替换的诗句\r\n", //2
//                    CharsetUtil.UTF_8));
//        }
    }


}