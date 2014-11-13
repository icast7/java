package netty.Time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class TimeServerHandler extends ChannelInboundHandlerAdapter{
	@Override
	public void channelActive(final ChannelHandlerContext ctx){
		//TIME PROTOCOL
		final ByteBuf time = ctx.alloc().buffer(4);
		//milis/1000 -> second
		//220... number of seconds since 1900
		time.writeInt((int) (System.currentTimeMillis()/1000L + 2208988800L));
		
		final ChannelFuture f = ctx.writeAndFlush(time);
		//f.addListener(ChannelFutureListener.CLOSE);
		f.addListener(new ChannelFutureListener(){
			@Override
			public void operationComplete(ChannelFuture future) throws Exception {
				assert f == future;
				ctx.close();
			}
		});
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){//4
		//Close connection
		cause.printStackTrace();
		ctx.close();
	}	
}
