package echo.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class Encoder  extends MessageToByteEncoder<String>{
    protected void encode(ChannelHandlerContext channelHandlerContext, String msg, ByteBuf byteBuf) throws Exception {
        byteBuf.writeBytes((msg+"encode").getBytes());
    }
}
