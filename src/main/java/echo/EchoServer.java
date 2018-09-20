package echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import nio.Channel;

import java.net.InetSocketAddress;

public class EchoServer {
    private static int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException {
        new EchoServer(8080).start();
    }

    private static void start() throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            //out必须在前面
//            serverBootstrap.group(group).channel(NioServerSocketChannel.class).localAddress(new InetSocketAddress(port)).childHandler(new ChannelInitializer<SocketChannel>() { //7
//                @Override
//                public void initChannel(SocketChannel ch)
//                        throws Exception {
//                    ChannelPipeline pipeline=ch.pipeline();
//                    ch.pipeline().addLast("handler1",new EchoServerOutHandler()).addLast(
//                            "handler2",new EchoServerHandler());
//                }
//            });
            //添加HTTP支持
            serverBootstrap.group(group).channel(NioServerSocketChannel.class).localAddress(new InetSocketAddress(port)).childHandler(new HttpInitial());
            ChannelFuture f = serverBootstrap.bind().sync();            //8
            System.out.println(EchoServer.class.getName() + " started and listen on " + f.channel().localAddress());
            f.channel().closeFuture().sync();            //9
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully().sync();
        }
    }
}
