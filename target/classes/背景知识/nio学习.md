# nio笔记(一)
主要组成部分
* Channels
* Buffers
* Selectors

### 基本上，所有的 IO 在NIO 中都从一个Channel 开始。Channel 有点像流。 数据可以从Channel读到Buffer中，也可以从Buffer 写到Channel中。

> Channel和Buffer有好几种类型。

下面是JAVA NIO中的一些主要Channel的实现：
* FileChannel
* DatagramChannel
* SocketChannel
* ServerSocketChannel

以下是Java NIO里关键的Buffer实现：
* ByteBuffer
* CharBuffer
* DoubleBuffer
* FloatBuffer
* IntBuffer
* LongBuffer
* ShortBuffer
> 这些Buffer覆盖了你能通过IO发送的基本数据类型：byte, short, int, long, float, double 和 char。
>> Java NIO 还有个 MappedByteBuffer，用于表示内存映射文件

####  Selector
Selector允许单线程处理多个 Channel。如果你的应用打开了多个连接（通道），但每个连接的流量都很低，使用Selector就会很方便。

要使用Selector，得向Selector注册Channel，然后调用它的select()方法。这个方法会一直阻塞到某个注册的通道有事件就绪。一旦这个方法返回，线程就可以处理这些事件，事件的例子有如新连接进来，数据接收等。

