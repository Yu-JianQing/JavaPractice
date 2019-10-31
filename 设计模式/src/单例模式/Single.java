package µ¥ÀýÄ£Ê½;

public class Single {
	private static Single single;
	
	private Single(){}
	
	public static Single getSingle(){
		if(single==null){
			synchronized (Single.class) {
				if(single==null)
					single=new Single();
			}
		}
		return single;
	}
}
