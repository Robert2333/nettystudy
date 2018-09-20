package echo;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.*;

public class HttpInitial extends ChannelInitializer<Channel> {
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline pipeline=channel.pipeline();
//        pipeline.addLast("decoder",new HttpServerCodec());
        pipeline.addLast(new HttpRequestDecoder());
        pipeline.addLast(new HttpResponseEncoder());


        pipeline.addLast(new HttpServerHandler());
    }
}
