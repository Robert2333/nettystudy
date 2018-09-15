##chennel
### chennel生命周期
> ChannelUnregistered->ChannelRegistered->ChannelActive->ChannelInactive
### chennelHandler生命周期
> handlerAdded(当把 ChannelHandler 添加到 ChannelPipeline 中时被调用)->handlerRemoved(当从 ChannelPipeline 中移除 ChannelHandler 时被调用)->exceptionCaught(当处理过程中在 ChannelPipeline 中有错误产生时被调用)

Netty 定义了下面两个重要的 ChannelHandler 子接口：
* ChannelInboundHandler——处理入站数据以及各种状态变化；
* ChannelOutboundHandler——处理出站数据并且允许拦截所有的操作。