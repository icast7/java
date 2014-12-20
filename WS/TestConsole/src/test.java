import java.io.IOException;
import java.nio.ByteBuffer;


public class test {

	public static void main(String[] args) throws IOException {
		ByteBuffer bb = ByteBuffer.allocate(2);
		bb.putShort((short)1);
		byte[] oso =  bb.array();
		Short s = 5;
		byte panda = s.byteValue();
		System.out.println(oso);
		
//		byte[] a = new byte[2];
//		a[0] = (byte)2;
//		a[1] = (byte)0;
//		ByteBuffer b = ByteBuffer.wrap(a);
//		
//		System.out.println(b);
//		System.out.println("Short:"+ b.getShort());
//		b.flip();
//		System.out.println("Str:"+ b.toString());
//		
//		System.out.println(a.toString());
	}
}

//int myint = 257;
//byte[] bNum = new byte[2];
//bNum[0] = (byte) (myint & 0xFF);
//bNum[1] = (byte) ((myint >> 8) & 0xFF);;
//System.out.print(bNum+"");