package nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Channel {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile=new RandomAccessFile("D:\\netty-study\\src\\main\\resources\\static\\channelTxt.txt","rw");
        FileChannel inChannel=randomAccessFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(4);
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
