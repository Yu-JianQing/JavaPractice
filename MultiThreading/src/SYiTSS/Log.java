package SYiTSS;

public class Log {
	private static final ThreadLocal<TSLog> tsLogColletion=new ThreadLocal<TSLog>();
	
	private static TSLog getTsLog(){
		TSLog tsLog=tsLogColletion.get();
		if(tsLog==null){
			tsLog=new TSLog(Thread.currentThread().getName()+"-log.txt");
			tsLogColletion.set(tsLog);
		}
		return tsLog;
	}
	
	public static void println(String s){
		getTsLog().println(s);
	}
	
	public static void close(){
		getTsLog().close();
	}
}
