package numx2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Tom implements Person{
	
	@Override
	public List<String> Hobbits(String h1, String h2) {
		List<String> list=new ArrayList<String>();
		list.add(h1);
		list.add(h2);
		System.out.println("toming");
		return list;
	}

}
