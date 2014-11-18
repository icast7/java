package netty.examples.telnet;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.ssl.SslContext;

public class TelnetServerInitializer extends ChannelInitializer<SocketChannel> {
	private static final StringDecoder DECODER =  new StringDecoder();
	private static final StringEncoder ENCODER = new StringEncoder();
	
	private static final TelnetServerHandler SERVER_HANDLER =  new TelnetServerHandler();
	
	private final SslContext sslCtx;
	
	public TelnetServerInitializer(SslContext sslCtx){
		this.sslCtx = sslCtx;
	}
	
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();

		if (sslCtx != null){
			pipeline.addLast(sslCtx.newHandler(ch.alloc()));
		}
		
		//Add text line codec combination first
		pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
		
		//The encoder and decoder are static
		pipeline.addLast(DECODER);
		pipeline.addLast(ENCODER);
		
		//add biz logic
		pipeline.addLast(SERVER_HANDLER);
	}
}
