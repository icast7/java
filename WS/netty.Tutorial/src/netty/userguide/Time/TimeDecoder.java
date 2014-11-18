package netty.userguide.Time;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
//import io.netty.handler.codec.ReplayingDecoder;

//public class TimeDecoder extends ReplayingDecoder<Void>{
//
//	@Override
//	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
//		out.add(in.readBytes(4));
//	}	
//}


public class TimeDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		if (in.readableBytes() < 4){
			return;
		}
		out.add(new UnixTime(in.readInt()));
	}
}