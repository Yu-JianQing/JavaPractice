package aboutIo;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
//C:\Users\USER\Desktop\文件暂存
public class FIleOp {
	public static void main(String[] args) throws IOException {
		File dirFile=new File("C:\\Users\\USER\\Desktop\\文件暂存\\IO测试");//创建文件夹
		if(!dirFile.exists())
			dirFile.mkdir();
		
		for (int i = 0; i < 3; i++) {
			File file=new File("C:\\Users\\USER\\Desktop\\文件暂存\\IO测试","File"+i+".txt");//创建文件
			if(!file.exists())
				file.createNewFile();
		}
		
		File files[]=dirFile.listFiles();
		for(File f:files)
			System.out.println(f.getName());//列出文件夹下所有文件的名称
		
		String[] fileName=dirFile.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				if(name.endsWith(".txt"))
					return true;//过滤器过滤后缀名是.txt的文件并列出他们的文件名
				return false;
			}
		});
		for(String s:fileName)
			System.out.println(s);
		
	}
}
