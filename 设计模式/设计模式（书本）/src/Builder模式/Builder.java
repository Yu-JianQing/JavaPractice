package Builderģʽ;

public abstract class Builder {
	public abstract void makeTitle(String title);
	public abstract void makeContent(String content);
	public abstract void makeNote(String note);
	public abstract void close();
}
