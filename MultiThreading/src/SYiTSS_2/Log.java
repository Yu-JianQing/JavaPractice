package SYiTSS_2;

public class Log {
	private static final ThreadLocal<TSLog> tsLogColletion=new ThreadLocal<TSLog>();
	
	private static TSLog getTsLog(){
		TSLog tsLog=tsLogColletion.get();
		if(tsLog==null){
			tsLog=new TSLog(Thread.currentThread().getName()+"-log.txt");
			tsLogColletion.set(tsLog);
			watcher(tsLog);
		}
		return tsLog;
	}
	
	private static void watcher(TSLog tsLog){//监视有没有完成
		final Thread targe=Thread.currentThread();
		final Thread watch=new Thread(){
			public void run(){
				try {
					targe.join();
				} catch (InterruptedException e) {}
				tsLog.close();
			}
		};
		watch.start();
	}
	
	public static void println(String s){
		getTsLog().println(s);
	}
	
	public static void close(){
		getTsLog().close();
	}
}
