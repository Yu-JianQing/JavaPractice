package SanShuJu;

public class Coding {
	private static byte byteVal=101;
	private static short shorVal=10001;
	private static int intVal=100000001;
	private static long longVal=1000000000001L;
	
	private static final int BSize=Byte.SIZE;
	private static final int SSize=Short.SIZE;
	private static final int ISize=Integer.SIZE;
	private static final int LSize=Long.SIZE;
	
	private static final int ByteMask=0xFF;
	
	public static String byteArrayToString(byte [] bArray){
		StringBuilder builder=new StringBuilder();
		for(byte b:bArray)
			builder.append(b&ByteMask).append("  ");
		return builder.toString();
	}
	
	public static int encodeIntBig(byte[] dst,long val,int offset,int size){
		for(int i=0;i<size;i++)
			dst[offset++]=(byte)(val>>((size-i-1)*Byte.SIZE));
		return offset;
	}
	
	public static long decodeIntBig(byte[] val,int offset,int size){
		long L=0;
		for(int i=0;i<size;i++)
			L=(L<<Byte.SIZE)|((long) val[offset+i]&ByteMask);
		return L;
	}
	
	public static void main(String[] args) {
		byte[] msg=new byte[BSize+SSize+ISize+LSize];
		
		int offset=encodeIntBig(msg, byteVal, 0, BSize);
		offset=encodeIntBig(msg, shorVal, offset, SSize);
		offset=encodeIntBig(msg, intVal, offset, ISize);
		encodeIntBig(msg, longVal, offset, LSize);
		System.out.println("�Ѿ���������Ϣ�ǣ�"+byteArrayToString(msg));
		
		long value=decodeIntBig(msg, BSize, SSize);
		System.out.println("short �͵����ǣ�"+value);
		value=decodeIntBig(msg, BSize+SSize+ISize,LSize);
		System.out.println("long �͵����ǣ�"+value);
		
		offset=0;
		value=decodeIntBig(msg, offset, BSize);
		System.out.println("��"+offset+"��ʼ���룬��ȡ�ĳ����ǣ�"+BSize+" ����Ϊ��"+value);
		byte bval=(byte)decodeIntBig(msg, offset, BSize);
		System.out.println("byte �͵����ǣ�"+bval);
		
	}
	
	
}
