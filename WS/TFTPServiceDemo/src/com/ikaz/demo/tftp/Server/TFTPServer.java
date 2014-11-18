package com.ikaz.demo.tftp.Server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;


/**  TFTP Server class
 * 
 * @author icastillejos
 * @version 0.0.1
 */
public final class TFTPServer {
	//Set the port to 8069 for testing purposes
	private final int PORT = 8069;
	
	public static void main(String[] args) throws Exception{
		new TFTPServer().run();
	}
	
	public TFTPServer(){
		super();
	}
	
	public void run() throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
			.channel(NioServerSocketChannel.class)
			.handler(new LoggingHandler(LogLevel.INFO))
			.childHandler(new TFTPServerInitializer());
		
			b.bind(PORT).sync().channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}
}
