package com.ikaz.demo.tftp.Client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/***
 * Create a new ChannelPipeline from a new channel.
 ***/
public class TFTPClientInitializer extends ChannelInitializer<SocketChannel> {
	
	private static final StringDecoder DECODER = new StringDecoder();
	private static final StringEncoder ENCODER = new StringEncoder();	
	
	private static final TFTPClientHandler CLIENT_HANDLER = new TFTPClientHandler();
	
	public TFTPClientInitializer(){
		super();
	}	
	
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		
		//add txt line codec
		pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
		pipeline.addLast(DECODER);
		pipeline.addLast(ENCODER);
		
		//add biz logic
		pipeline.addLast(CLIENT_HANDLER);
	}
}
