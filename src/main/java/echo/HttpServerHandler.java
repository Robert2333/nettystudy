package echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

class HttpServerHandler extends SimpleChannelInboundHandler<Object> {
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) throws Exception {
        System.out.println(fullHttpRequest.uri());
        System.out.println(fullHttpRequest.method());
    }

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        String x="ss";
        System.out.println(x);
    }


//    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
//        System.out.println(msg.getClass().getName());
//
//        System.out.println(msg.uri());
////        if (msg instanceof HttpRequest) {
////            HttpRequest httpRequest = (HttpRequest) msg;
////            System.out.println("请求方法名： " + httpRequest.method().name());
////            //对不同的路径进行处理
////            URI uri = new URI(httpRequest.uri());
////            if ("/favicon.ico".equals(uri.getPath())) {
////                System.out.println("请求favicon.ico");
////            }
////            // 返回的内容
////            ByteBuf content = Unpooled.copiedBuffer("Hello World", CharsetUtil.UTF_8);
////            // http的响应
////            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
////            //响应头设置
////            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
////            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
////            // 把响应内容写回到客户端
////            ctx.writeAndFlush(response);
////        }
//    }


}