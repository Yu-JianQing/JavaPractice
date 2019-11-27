package Stateģʽ;

public interface Context {
	public abstract void changeState(State state);
	
	public abstract void setClock(int hour);
	
	public abstract void dealCall(String msg);
	public abstract void recordLog(String msg);
}
