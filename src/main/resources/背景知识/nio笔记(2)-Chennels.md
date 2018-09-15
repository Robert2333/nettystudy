# nio笔记(二)
## Channels

Java NIO的通道类似流，但又有些不同：

* 既可以从通道中读取数据，又可以写数据到通道。但流的读写通常是单向的。
* 通道可以异步地读写。
* 通道中的数据总是要先读到一个Buffer，或者总是要从一个Buffer中写入。

Channel的实现
这些是Java NIO中最重要的通道的实现：

* FileChannel
> FileChannel 从文件中读写数据。
* DatagramChannel
> DatagramChannel 能通过UDP读写网络中的数据。
* SocketChannel
> SocketChannel 能通过TCP读写网络中的数据。
* ServerSocketChannel
> ServerSocketChannel可以监听新进来的TCP连接，像Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel。

```java
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Channel {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile=new RandomAccessFile("D:\\netty-study\\src\\main\\resources\\static\\channelTxt.txt","rw");
        FileChannel inChannel=randomAccessFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(4);
        //通道里的数据读到buffer中
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        randomAccessFile.close();
    }
}

```