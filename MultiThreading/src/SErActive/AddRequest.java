package SErActive;

public class AddRequest extends MethodRequest<String>{
	private String x,y;
	
	public AddRequest(Servant servant, FutureResult<String> future,String x,String y) {
		super(servant, future);
		this.x=x;
		this.y=y;
	}

	public void execute() {
		Result<String> result=servant.add(x, y);
		future.setResult(result);
	}

}
