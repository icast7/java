package com.ikaz.demo.tftp.Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;

/**
 * Telnet client
 */
public class TFTPClient {
	static final String HOST = System.getProperty("host", "127.0.0.1");
	static final int PORT = Integer.parseInt(System.getProperty("port","8069"));

	public static void main(String[] args) throws Exception {
		
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group)
				.channel(NioSocketChannel.class)
				.handler(new TFTPClientInitializer());
			//Attempt to connect
			Channel ch = b.connect(HOST, PORT).sync().channel();
			
			//Read commands from stdin
			ChannelFuture lastWriteFuture = null;
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			//This is equivalent to while(true)
			for (;;){
				String line = in.readLine();
				if (line == null){
					break;
				}
				
				//Send line received to the server
				lastWriteFuture = ch.writeAndFlush(line + "\r\n");
				
				//If typed 'bye' command, wait for the  sever closes the connection
				if ("bye".equals(line.toLowerCase())){
					ch.closeFuture().sync();
					break;
				}
			}			
			
			//Wait for all msgs are flushed then close channel
			if(lastWriteFuture != null){
				lastWriteFuture.sync();
			}
		} finally {
			group.shutdownGracefully();
		}
	}
}
