package com.ikaz.demo.tftp.Server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class TFTPServerInitializer extends ChannelInitializer<SocketChannel> {
	private static final StringDecoder DECODER =  new StringDecoder();
	private static final StringEncoder ENCODER = new StringEncoder();
	
	private static final TFTPServerHandler SERVER_HANDLER =  new TFTPServerHandler();

	
	public TFTPServerInitializer(){
		super();
	}
	
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		
		//Add text line codec combination first
		pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
		
		//The encoder and decoder are static
		pipeline.addLast(DECODER);
		pipeline.addLast(ENCODER);
		
		//add biz logic
		pipeline.addLast(SERVER_HANDLER);
	}
}
