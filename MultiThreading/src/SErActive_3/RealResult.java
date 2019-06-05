package SErActive_3;

public class RealResult extends Result<String>{
	private final String value;
	
	public RealResult(String value){
		this.value=value;
	}
	
	public String getValue() {
		return this.value;
	}

}
