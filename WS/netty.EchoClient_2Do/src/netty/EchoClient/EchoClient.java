package netty.EchoClient;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;

/**
 * Send msg and echo back
 * */	
public final class EchoClient {
	
		static final boolean SSL = System.getProperty("ssl") != null;
		static final String HOST = System.getProperty("host", "127.0.0.1");
		static final int PORT = Integer.parseInt(System.getProperty("port", "8007"));
		static final int SIZE = Integer.parseInt(System.getProperty("size","256"));
				
		
		public static void main(String[] args) throws Exception{
			//Configure ssl
			final SslContext sslCtx;
			if (SSL) {
				sslCtx = SslContext.newClientContext(InsecureTrustManagerFactory.INSTANCE);
			} else {
				sslCtx = null;
			}
			
			//Configure client
			EventLoopGroup group = new NioEventLoopGroup();
			try {
				Bootstrap b = new Bootstrap();
				b.group(group)
				.channel(NioSocketChannel.class)
				.option(ChannelOption.TCP_NODELAY, true)
				.handler(new ChannelInitializer<SocketChannel>(){
					@Override
					public void initChannel(SocketChannel ch) throws Exception{
						ChannelPipeline p = ch.pipeline();
						if (sslCtx != null){
							p.addLast(sslCtx.newHandler(ch.alloc(), HOST, PORT));
						}
						p.addLast(new EchoClientHandler());
					}
				});
				//Start
				ChannelFuture f = b.connect(HOST, PORT).sync();
				f.channel().closeFuture();
				
			} finally {
				//Shut down event - terminate all threads
				group.shutdownGracefully();
			}
		}
	}
