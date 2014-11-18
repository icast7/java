package netty.userguide.Discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter{
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg){
		
		//DISCARD PROTOCOL
		//((ByteBuf) msg).release();
		//		
		//	
		//"DISCARD" PROTOCOL Logging to console 
		ByteBuf in = (ByteBuf) msg;
		try {
		//	//Write to console: Write  1 char at a time
		//	while(in.isReadable())	{
		//	System.out.print((char) in.readByte());
		// 	System.out.flush();
		//  }
		//	//Write to console: to string
			System.out.print(in.toString(io.netty.util.CharsetUtil.US_ASCII));
			System.out.flush();
		} finally {
			ReferenceCountUtil.release(msg);
		}		
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){//4
		//Close connection
		cause.printStackTrace();
		ctx.close();
	}	
}
