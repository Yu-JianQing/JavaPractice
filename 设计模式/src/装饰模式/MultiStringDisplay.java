package в╟йндёй╫;

import java.util.ArrayList;
import java.util.List;

public class MultiStringDisplay extends Display{
	private List<String> list=new ArrayList<String>();

	@Override
	public int getRows() {
		return list.size();
	}

	@Override
	public int getNumPerRow() {
		return getMaxLength();
	}
	
	public int getMaxLength(){
		int max=0;
		for(String str:list){
			if(str.length()>max)
				max=str.length();
		}
		return max;
	}

	@Override
	public String getText(int rows) {
		return list.get(rows);
	}

	public void add(String str){
		list.add(str);
	}
	
}
