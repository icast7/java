package netty.userguide.Time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class TimeEncoder extends MessageToByteEncoder<UnixTime> {
	@Override
	protected void encode(ChannelHandlerContext ctx, UnixTime msg, ByteBuf out) throws Exception {
		out.writeInt(msg.value());
	}
}

//public class TimeEncoder extends ChannelOutboundHandlerAdapter {
//	@Override
//	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise){
//		UnixTime m = (UnixTime) msg;
//		ByteBuf encoded = ctx.alloc().buffer(4);
//		encoded.writeInt(m.value());
//		ctx.write(encoded, promise);
//	}	
//}
