package JiuFu_2;

public class RealData implements Data{
	private String content;
	
	public RealData(int count,char c){
		System.out.println("making real data "+count+" "+c+" begin");
		char buffer[]=new char[count];
		for (int i = 0; i < buffer.length; i++) {
			buffer[i]=c;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
		this.content=new String(buffer);
		System.out.println("making real data "+count+" "+c+" end");
	}
	
	public String getContent() {
		return content;
	}

}
