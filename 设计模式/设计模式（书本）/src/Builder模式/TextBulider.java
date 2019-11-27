package Builderģʽ;

public class TextBulider extends Builder{
	private StringBuffer buffer=new StringBuffer();

	@Override
	public void makeTitle(String title) {
		buffer.append("it is "+ title+"\n");
	}

	@Override
	public void makeContent(String content) {
		buffer.append("it is "+content+"\n");
	}

	@Override
	public void makeNote(String note) {
		buffer.append("it is "+ note +"\n");
	}

	@Override
	public void close() {
		buffer.append("===============");
	}
	
	public String getRS(){
		return buffer.toString();
	}

}
