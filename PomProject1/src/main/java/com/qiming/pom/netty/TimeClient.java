package com.qiming.pom.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.util.logging.Logger;

public class TimeClient {

  public void connect(int port, String host) {
    //配置客户端NIO线程组
    EventLoopGroup group = new NioEventLoopGroup();

    try {
      Bootstrap b = new Bootstrap();
      //跟服务端不同的是，这边是NioSocketChannel，然后为其添加handler
      b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true).handler(
          new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
              socketChannel.pipeline().addLast(new TimeClientHandler());
            }
          });
      //发起异步连接操作
      ChannelFuture f = b.connect(host, port).sync();

      //等待客户端链路关闭
      f.channel().closeFuture().sync();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      group.shutdownGracefully();
    }
  }

  public static void main(String[] args) {
    int port = 8080;
    if (args != null && args.length > 0) {
      port = Integer.valueOf(args[0]);
    }
    new TimeClient().connect(port, "127.0.0.1");
  }

}


class TimeClientHandler extends ChannelHandlerAdapter {

  private static final Logger logger = Logger.getLogger(TimeClientHandler.class.getName());

  private final ByteBuf firstMessage;

  public TimeClientHandler() {
    byte[] req = "QUERY TIME ORDER".getBytes();
    this.firstMessage = Unpooled.buffer(req.length);
    firstMessage.writeBytes(req);
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{

    ByteBuf buf = (ByteBuf)msg;
    byte[] req = new byte[buf.readableBytes()];
    buf.readBytes(req);
    String body = new String(req, "UTF-8");
    System.out.println("Now is : " + body);

  }

  /**
   * 当客户端和服务端TCP链路成功后，Netty的NIO线程会调用channelActive方法，发送查询时间的指令给服务端
   * @param ctx
   */
  @Override
  public void channelActive(ChannelHandlerContext ctx) {
    //将请求消息发送给服务端
    ctx.writeAndFlush(firstMessage);
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    //释放资源
    logger.warning("Unexpected exception from downstream : " + cause.getMessage());
    ctx.close();
  }
}