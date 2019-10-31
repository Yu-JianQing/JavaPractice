package Builder模式;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class HtmlBuilder extends Builder{
	private String filePath;
	private PrintWriter writer;
	
	public HtmlBuilder(){
		this.filePath="C:\\Users\\USER\\Desktop\\文件暂存\\IO测试\\File2.txt";
		try {
			this.writer=new PrintWriter(filePath);
		} catch (FileNotFoundException e) {}
	}
	
	@Override
	public void makeTitle(String title) {
		writer.println("<html><body><title>"+title+"</title>");
	}
	
	@Override
	public void makeContent(String content) {
		writer.println("<br>it is "+content+" <br>");
	}
	
	@Override
	public void makeNote(String note) {
		writer.println("<br>it is "+note+" <br>");
	}
	
	@Override
	public void close() {
		writer.println("</body></html>");
		writer.close();
	}
	
}
