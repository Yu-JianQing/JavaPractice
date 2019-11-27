package 轻量级模式;

public class BigString {
	private BigChar bigChar[];
	
	public BigString(String str,boolean shared){
		if(shared)
			sharedInit(str);
		else
			unsharedInit(str);
	}
	
	public void sharedInit(String str){
		bigChar=new BigChar[str.length()];
		BigCharFactory factory=BigCharFactory.getInstance();
		
		for(int i=0;i<bigChar.length;i++)
			bigChar[i]=factory.getBigChar(str.charAt(i));
	}
	
	public void unsharedInit(String str){
		bigChar=new BigChar[str.length()];
		
		for(int i=0;i<bigChar.length;i++)
			bigChar[i]=new BigChar(str.charAt(i));
	}
	
	public void print(){
		for (int i = 0; i < bigChar.length; i++) 
			System.out.println(bigChar[i].getStr());
	}
	
}
