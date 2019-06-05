package aboutIo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class ObjectInOut {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		class Student implements Serializable{
			private String name;
			private int ID;
			public Student(String name,int ID){
				this.name=name;
				this.ID=ID;
			}
			public String toString(){
				return this.name+": id="+this.ID;
			}
		}
		/***********************************************/
		
		Student student=new Student("Tom", 666);
		
		File file =new File("C:\\Users\\USER\\Desktop\\�ļ��ݴ�\\IO����\\Object.txt");
		OutputStream out=new FileOutputStream(file);
		ObjectOutputStream objectOut=new ObjectOutputStream(out);
		
		objectOut.writeObject(student);
		
		objectOut.close();
		
		InputStream in=new FileInputStream(file);
		ObjectInputStream objectIn=new ObjectInputStream(in);
		
		Student stu=(Student) objectIn.readObject();
		System.out.println(stu);
		
		objectIn.close();
	}
}
