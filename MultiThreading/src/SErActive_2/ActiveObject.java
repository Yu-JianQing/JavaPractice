package SErActive_2;

import java.util.concurrent.Future;

public interface ActiveObject {
	public abstract Future<String> MakingString(int count,char fillchar);
	public abstract void DisplayString(String string);
	public abstract Future<String> Add(String x,String y);
	public abstract void shutdown();
}
