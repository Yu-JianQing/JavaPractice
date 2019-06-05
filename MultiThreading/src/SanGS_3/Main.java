package SanGS_3;

public class Main {
	public static void main(String[] args) {
		RequestQueue input=new RequestQueue();
		RequestQueue output=new RequestQueue();
		Request request=new Request("Hello");
		input.putRequest(request);
		new TalkThread(input, output, "Tom").start();
		new TalkThread(output, input,"Jerry").start();
	}
}
