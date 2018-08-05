package bytebuf;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

import java.nio.charset.Charset;

public class ByteBufTest {
    public static Charset utf8=Charset.forName("utf-8");
    public static ByteBuf testByteBuf= Unpooled.copiedBuffer("This is test ByteBuf",utf8);

    //get和set不会改变ByteBuf索引
    @Test
    public void getAndSet(){
        this.printByteBuf(0);
        int readIndex=testByteBuf.readerIndex();
        int writeIndex=testByteBuf.writerIndex();
        testByteBuf.setByte(0,(byte)'t');
        this.printByteBuf(0);
        assert readIndex==testByteBuf.readerIndex();//这两个都是true，说明这两个索引都没有变，虽然改变了值，但是索引值都不变。
        assert writeIndex==testByteBuf.writerIndex();
    }

    @Test
    public void 索引会变(){
        this.printByteBuf(0);
        int readIndex=testByteBuf.readerIndex();
        int writeIndex=testByteBuf.writerIndex();
        testByteBuf.writeByte((byte)'徐');
        assert readIndex==testByteBuf.readerIndex();
        assert writeIndex!=testByteBuf.writerIndex();//这里就不等于了，因为使用了write方法
    }

    @Test
    public void 派生拷贝(){
        Charset charset=Charset.forName("utf-8");
        ByteBuf byteBuf= Unpooled.copiedBuffer("this.is",charset);

        /*
         * 派生是引用，如果要一个新的对象的话，那么就用copy
         */
        ByteBuf 派生Buf=byteBuf.slice(0,7);
        System.out.print(派生Buf.toString(charset));
        派生Buf.setByte(0,(byte)'T');
        assert byteBuf.getByte(0)==派生Buf.getByte(0);
        System.out.print(byteBuf.toString(charset));//true，这里不一样了
    }

    @Test
    public void copy拷贝(){
        Charset charset=Charset.forName("utf-8");
        ByteBuf byteBuf= Unpooled.copiedBuffer("this.is",charset);

        /*
         * 派生是引用，如果要一个新的对象的话，那么就用copy
         */
        ByteBuf copyBuf=byteBuf.copy(0,7);
        System.out.print(copyBuf.toString(charset));
        copyBuf.setByte(0,(byte)'T');
        assert byteBuf.getByte(0)==copyBuf.getByte(0);
        System.out.print(byteBuf.toString(charset));//false，这里不一样了，不是一块内存
    }

    @Test
    public void 读取(){
        Charset charset=Charset.forName("utf-8");
        ByteBuf byteBuf= Unpooled.copiedBuffer("this.is",charset);
        /*
            读取操作
         */
        for(int i=0;i<byteBuf.capacity();i++){
            System.out.print((char)byteBuf.getByte(i));
        }
        while(byteBuf.isReadable()){
            System.out.print((char)byteBuf.readByte());
        }
    }

    private static void printByteBuf(int index){
        System.out.println((char)testByteBuf.getByte(index));
    }
}
