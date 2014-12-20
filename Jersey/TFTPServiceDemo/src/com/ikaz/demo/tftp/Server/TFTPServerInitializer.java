package com.ikaz.demo.tftp.Server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/** This is the TFTP initializer class
 * 
 * @author icastillejos
 * @version 0.0.1
 */
public class TFTPServerInitializer extends ChannelInitializer<SocketChannel> {
	//This example works with Strings, need to implement the decoding/encoding of DatagramPackets.
	private static final StringDecoder DECODER =  new StringDecoder();
	private static final StringEncoder ENCODER = new StringEncoder();
	
	private static final TFTPServerHandler SERVER_HANDLER =  new TFTPServerHandler();

	
	public TFTPServerInitializer(){
		super();
	}
	
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		
		//File is sent in fixed length blocks of 512 bytes
		pipeline.addLast(new DelimiterBasedFrameDecoder(512, Delimiters.lineDelimiter()));
		
		//The encoder and decoder are static
		pipeline.addLast(DECODER);
		pipeline.addLast(ENCODER);
		
		//Add TFTP logic
		pipeline.addLast(SERVER_HANDLER);
	}
}
