package ´°¿ÚÄ£Ê½;

import java.io.IOException;
import java.io.Writer;

public class HtmlWriter {
	private Writer writer;
	
	public HtmlWriter(Writer writer){
		this.writer=writer;
	}
	
	public void title(String title) throws IOException{
		writer.write("<html><h1><title>"+title+"</title></h1><br>");
		writer.write("<body>");
	}
	
	public void makeMsg(String msg) throws IOException{
		writer.write(msg+"<br>");
	}
	
	public void link(String href,String content) throws IOException{
		makeMsg("<a href=\""+href+"\">"+content+"</a>");
	}
	
	public void mailto(String mailaddr,String name) throws IOException{
		link(mailaddr, name);
	}
	
	public void close() throws IOException{
		writer.write("</body></html>");
		writer.close();
	}
}
