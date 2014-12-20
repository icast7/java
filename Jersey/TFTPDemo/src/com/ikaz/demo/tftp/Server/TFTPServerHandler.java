package com.ikaz.demo.tftp.Server;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;

import java.net.InetAddress;
import java.util.Date;

/**
 * Handle the channel on the server side
 * */
@Sharable
public class TFTPServerHandler extends SimpleChannelInboundHandler<DatagramPacket>{
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception{
		//Welcome a new connection
		ctx.write("Welcome to TFTP " + InetAddress.getLocalHost().getHostName()+"!\r\n");
		ctx.write("It is " + new Date() + " now.\r\n" );
		ctx.flush();
	}
	//File is sent in fixed length blocks of 512 bytes
	//A data packet of less than 512 bytes signals termination of a transfer
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket request) throws Exception {
		//Generate/write response
		String response;
		boolean close = false;
		if (request.toString().isEmpty()){
			response = "PLEASE Type something.\r\n";
		} else if ("bye".equals(request.toString().toLowerCase())){
			response = "Have a good day!\r\n";
			close = true;
		} else {
			response = "You said: '" + request +"'\r\n";
		}
		//No need for a ChannelBuffer... encoder inserted at the TelnetPipeline will do the conversion.
		ChannelFuture future = ctx.write(response);
		
		//Close connection after saying good bye
		if (close){
			future.addListener(ChannelFutureListener.CLOSE);
		}
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx){
		ctx.flush();
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
		cause.printStackTrace();
		ctx.close();
	}
}
