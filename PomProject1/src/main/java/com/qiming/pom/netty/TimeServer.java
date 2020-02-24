package com.qiming.pom.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.buffer.ByteBuf;
import java.util.Date;

public class TimeServer {

  public void bind(int port) {
    //配置服务端的NIO线程组
    //NioEventLoopGroup是个线程组，它包含一组NIO线程，专门用于网络事件的处理，实际上它们就是Reactor线程组，这里创建两个的原因是一个用于服务端接受客户端的连接，另一个用于进行SocketChannel网络
    //读写，ServerBootstrap对象，它是Netty用于启动NIO服务端的辅助启动类，目的是降低服务端的开发复杂度，调用group方法，创建NioServerSocketChannel的Channel，它的功能跟JDK的NIO库中的
    //ServerSocketChannel类似，然后配置NioServerSocketChannel的TCP参数，此处将它的backlog设置为1024，最后绑定I/O事件的处理类ChildChannelHandler，它的作用类似于Reactor模式中的Handler类
    //主要用于处理网络I/O事件，例如记录日志，对消息进行编解码等
    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    try {
      ServerBootstrap b = new ServerBootstrap();
      b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).option(
          ChannelOption.SO_BACKLOG, 1024).childHandler(new ChildChannelHandler());
      //绑定端口，调动bing方法绑定监听端口，随后调用它的同步阻塞方法sync等待绑定操作的完成，完成之后Netty会返回一个ChannelFuture，主要用于异步操作的通知回调
      ChannelFuture f = b.bind(port).sync();

      //等到服务器端监听端口关闭，使用方法进行阻塞，等待服务器链路关闭之后main函数才退出
      f.channel().closeFuture().sync();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      //优雅退出，释放线程池资源
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }


  }

  private class ChildChannelHandler extends ChannelInitializer {

    @Override
    protected void initChannel(Channel channel) throws Exception {
      channel.pipeline().addLast(new TimeServerHandler());
    }
  }

  public static void main(String[] args) {
    int port = 8080;
    if (args != null && args.length > 0) {
      port = Integer.valueOf(args[0]);
    }
    new TimeServer().bind(port);
  }

}

/**
 * TimeServerHandler继承自ChannelHandlerAdapter，它用于对网络事件进行读写操作，关注channelRead和exceptionCaught方法
 *
 */
class TimeServerHandler extends ChannelHandlerAdapter {

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{

    //ByteBuf，类似JDK的ByteBuffer
    ByteBuf buf = (ByteBuf)msg;
    byte[] req = new byte[buf.readableBytes()];
    buf.readBytes(req);
    String body = new String(req, "UTF-8");
    System.out.println("The time server receive order : " + body);
    String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
    ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
    //write方法并不直接将消息写入SocketChannel中，调用write方法只是把待发送的消息放到发送缓冲数组，再通过调用flush方法，将发送缓冲区中的消息全部写到SocketChannel
    ctx.write(resp);

  }

  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) {
    //将消息发送队列中的消息写入到SocketChannel中发送给对方
    ctx.flush();
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    //发生异常时，关闭ChannelHandlerContext，释放和ChannelHandlerContext相关联的句柄等资源
    ctx.close();
  }

}