package DButil;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class PstmtTest {
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	String name=scanner.next();
	Connection conn=null;
	Statement state=null;
	try {
		conn=DButil.getConnection();
		state=conn.createStatement();
		String sql="insert into studnet values"
				+ "("+name+")";
		int count =state.executeUpdate(sql);
		System.out.println(count);
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		DButil.close(null, state, conn);
	}
}
}
