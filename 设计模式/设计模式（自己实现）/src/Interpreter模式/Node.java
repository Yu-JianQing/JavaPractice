package Interpreter模式;

public abstract class Node {
	public abstract void parse(Context context) throws ParseException;
}
