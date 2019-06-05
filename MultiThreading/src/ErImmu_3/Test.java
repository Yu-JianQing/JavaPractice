package ErImmu_3;

public class Test {
	private static final long count=100000000L;
	
	private static void trail(String name,long count,Object object){
		System.out.println(name+"begin");
		long start=System.currentTimeMillis();
		for(long i=0;i<count;i++){
			object.toString();
		}
		System.out.println(name+"end");
		System.out.println("elapsed time :"+(System.currentTimeMillis()-start));
	}
	
	public static void main(String[] args) {
		trail("notSyn", count, new NotSyn());
		trail("syn", count, new Syn());
	}
	
}
