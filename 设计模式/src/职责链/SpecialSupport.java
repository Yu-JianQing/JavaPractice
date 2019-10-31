package Ö°ÔðÁ´;

public class SpecialSupport extends Support{
	private int num;
	
	public SpecialSupport(String dealmName,int num) {
		super(dealmName);
		this.num=num;
	}
	
	@Override
	protected boolean resolve(Trouble trouble) {
		if(trouble.getNumber()==num)
			return true;
		return false;
	}

}
