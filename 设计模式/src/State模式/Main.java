package Stateģʽ;

public class Main {
	public static void main(String[] args) {
		SafeFrame frame=new SafeFrame("safe");
		while(true){
			for(int i=0;i<24;i++){
				frame.setClock(i);
				try {
					Thread.sleep(1000);
				} catch (Exception e) {}
			}
		}
		
	}
}
