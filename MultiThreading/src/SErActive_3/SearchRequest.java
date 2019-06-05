package SErActive_3;

public class SearchRequest extends MethodRequest{
	private final String word;
	
	public SearchRequest(Servant servant, FutureResult future,String word) {
		super(servant, future);
		this.word=word;
	}

	public void execute() {
		Result<String> result=servant.search(word);
		future.set(result);
	}

}
