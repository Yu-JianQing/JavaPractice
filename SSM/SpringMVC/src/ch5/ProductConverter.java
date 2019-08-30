package ch5;

import org.springframework.core.convert.converter.Converter;


public class ProductConverter implements Converter<String,Product>{

	@Override
	public Product convert(String source) {
		Product product=new Product();
		String s[]=source.split(",");
		if(s!=null&&s.length==3){
			product.setName(s[0]);
			product.setPrice(Double.parseDouble(s[1]));
			product.setCount(Integer.parseInt(s[2]));
		}else {
			throw new IllegalArgumentException("default");
		}
		
		return product;
	}
	
}
