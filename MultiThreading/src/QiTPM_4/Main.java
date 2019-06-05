package QiTPM_4;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			new MiniService(8889).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
