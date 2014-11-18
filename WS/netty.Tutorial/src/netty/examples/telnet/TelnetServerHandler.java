package netty.examples.telnet;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.net.InetAddress;
import java.util.Date;

/**
 * Handle the channel on the server side
 * */
@Sharable
public class TelnetServerHandler extends SimpleChannelInboundHandler<String>{
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception{
		//Welcome a new connection
		ctx.write("Welcome to " + InetAddress.getLocalHost().getHostName()+"!\r\n");
		ctx.write("It is " + new Date() + " now.\r\n" );
		ctx.flush();
	}
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String request) throws Exception {
		//Generate/write response
		String response;
		boolean close = false;
		if (request.isEmpty()){
			response = "PLEASE Type something.\r\n";
		} else if ("bye".equals(request.toLowerCase())){
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
