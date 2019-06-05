package ErImmu_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
	public static void main(String[] args) {
//		final List<Integer> list=Collections.synchronizedList(new ArrayList<Integer>());
		final List<Integer> list=new CopyOnWriteArrayList<Integer>();
		new WriteThread(list).start();
		new ReadThread(list).start();
	}
}
