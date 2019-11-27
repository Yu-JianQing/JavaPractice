package Ö°ÔðÁ´;

public class NoSupport extends Support{

	public NoSupport(String dealmName) {
		super(dealmName);
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		return false;
	}

}
