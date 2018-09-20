package echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import nio.Channel;

//适配器类
@ChannelHandler.Sharable//表明所有的channel中可以分享
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    //每个信息入栈都会调用
    public void channelRead(ChannelHandlerContext ctx,
                            Object msg) {
//        ByteBuf in = (ByteBuf) msg;
////        if(in.toString(CharsetUtil.UTF_8).equals("helloencode")){
////            ChannelPipeline pipeline=ctx.pipeline();
////            pipeline.replace("handler1","替换后的",new 替换handler测试());
////        }
//        System.out.println("Server received: " + in.toString(CharsetUtil.UTF_8));        //2
//        ctx.writeAndFlush(in);
//        ctx.writeAndFlush(in);//3
        HttpRequest request;
        if (msg instanceof HttpRequest) {
            request = (HttpRequest) msg;

            String uri = request.uri();
            System.out.println("Uri:" + uri);
        }
        if (msg instanceof HttpContent) {
            HttpContent content = (HttpContent) msg;
            ByteBuf buf = content.content();
            System.out.println(buf.toString(io.netty.util.CharsetUtil.UTF_8));
            buf.release();

            String res = "I am OK";
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_0, HttpResponseStatus.OK);
            response.headers().set("CONTENT_TYPE", "text/plain");
            response.headers().set("CONTENT_LENGTH", response.content().readableBytes());
            ctx.write(response);
            ctx.flush();
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
////        ctx.writeAndFlush(Unpooled.copiedBuffer("读完输出", //2
////                CharsetUtil.UTF_8))//4
////                .addListener(ChannelFutureListener.CLOSE);
//        //FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_0, HttpResponseStatus.OK);
//        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_0, HttpResponseStatus.OK);
//        response.headers().set("CONTENT_TYPE", "text/plain");
//        response.headers().set("CONTENT_LENGTH", response.content().readableBytes());
//        ctx.write(response);
//        ctx.flush();
////        ctx.close();
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {
        cause.printStackTrace();                //5
        ctx.close();                            //6
    }

}
