package aboutIo;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
//C:\Users\USER\Desktop\�ļ��ݴ�
public class FIleOp {
	public static void main(String[] args) throws IOException {
		File dirFile=new File("C:\\Users\\USER\\Desktop\\�ļ��ݴ�\\IO����");//�����ļ���
		if(!dirFile.exists())
			dirFile.mkdir();
		
		for (int i = 0; i < 3; i++) {
			File file=new File("C:\\Users\\USER\\Desktop\\�ļ��ݴ�\\IO����","File"+i+".txt");//�����ļ�
			if(!file.exists())
				file.createNewFile();
		}
		
		File files[]=dirFile.listFiles();
		for(File f:files)
			System.out.println(f.getName());//�г��ļ����������ļ�������
		
		String[] fileName=dirFile.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				if(name.endsWith(".txt"))
					return true;//���������˺�׺����.txt���ļ����г����ǵ��ļ���
				return false;
			}
		});
		for(String s:fileName)
			System.out.println(s);
		
	}
}
