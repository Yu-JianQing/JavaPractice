package Ö°ÔðÁ´;

public class LimitSupport extends Support{
	private int limit;

	public LimitSupport(String dealmName,int limit) {
		super(dealmName);
		this.limit=limit;
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		if(trouble.getNumber()<limit)
			return true;
		return false;
	}

}
