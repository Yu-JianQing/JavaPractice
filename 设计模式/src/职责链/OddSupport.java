package Ö°ÔðÁ´;

public class OddSupport extends Support{
	
	public OddSupport(String dealmName) {
		super(dealmName);
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		if(trouble.getNumber()%2==1)
			return true;
		return false;
	}

}
