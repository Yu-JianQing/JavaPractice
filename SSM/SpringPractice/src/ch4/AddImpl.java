package ch4;

public class AddImpl implements Add{

	@Override
	public int add(int i, int j) {
		System.out.println("adding");
		return i+j;
	}

}
