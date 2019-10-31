package 职责链;

public abstract class Support {
	private String dealmName;
	private Support next;
	
	public Support(String dealmName){
		this.dealmName=dealmName;
	}
	
	public Support setNext(Support next) {//这里set的返回值是support
		this.next = next;
		return next;
	}

	protected abstract boolean resolve(Trouble trouble);
	
	protected void done(Trouble trouble){
		System.out.println("solve "+trouble+" done by "+this);	//done by this
	}
	
	protected void fail(Trouble trouble){
		System.out.println("solve "+trouble+" fail");
	}
	
	public final void support(Trouble trouble){
		if(resolve(trouble))
			done(trouble);
		else if(next!=null)
			next.support(trouble);
		else
			fail(trouble);
	}
	
	@Override
	public String toString() {
		return "Support " + dealmName;
	}
	
	public final void support2(Trouble trouble){
		for(Support s=this;true;s=s.next){
			if(s.resolve(trouble)){
				s.done(trouble);
				break ;
			}else if(s.next==null){
				s.fail(trouble);
				break ;
			}
		}
	}
	
}
