package netty.userguide.Time;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeClientHandler extends ChannelInboundHandlerAdapter{
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg){
		UnixTime m = (UnixTime) msg;
		System.out.println(m);
		ctx.close();
	//		ByteBuf m = (ByteBuf) msg;
	//		try{
	//			long currentTimeMillis = (m.readUnsignedInt() - TimeServerHandler.secSince1900) * 1000L;
	//			System.out.println(new Date(currentTimeMillis));
	//			ctx.close();
	//		} finally {
	//			m.release();
	//		}
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable c)
			throws Exception {
		c.printStackTrace();
		ctx.close();
	}
}
