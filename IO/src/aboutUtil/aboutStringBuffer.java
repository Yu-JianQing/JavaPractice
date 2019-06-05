package aboutUtil;

public class aboutStringBuffer {
	public static void main(String[] args) {
//		String str="xmnl  xml  html ";
//		String str2=str.trim();
//		System.out.println(str.hashCode()+"  "+str2.hashCode());
//		
//		StringBuffer sBuffer=new StringBuffer("xmnl  xml  html ");
//		StringBuffer sBuffer2=sBuffer.append("java");
//		System.out.println(sBuffer.hashCode()+"   "+sBuffer2.hashCode());
		
		StringBuffer sBuffer3=new StringBuffer(10);
		
		int capacity=sBuffer3.capacity();
		int lenth=sBuffer3.length();
		System.out.println("sBuffer3.capacity="+capacity+"   sBuffer3.length="+lenth);
		
		sBuffer3.append("xxxxxxxxxx");
		sBuffer3.append(111111111);
		System.out.println(sBuffer3);
		
		char c=sBuffer3.charAt(5);
		System.out.println(c);
		
		sBuffer3.insert(4, "mmm");
		System.out.println(sBuffer3);
		
		StringBuffer sBuffer4=sBuffer3.reverse();
		System.out.println(sBuffer4);
		
		sBuffer3.delete(7, 11);
		System.out.println(sBuffer3);
		
		sBuffer3.replace(0, 3, "ggg");
		System.out.println(sBuffer3);
	}
}
