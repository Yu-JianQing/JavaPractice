package ch9x2;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator{

	@Override
	public boolean supports(Class<?> klass) {
		return Product.class.isAssignableFrom(klass);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Product product=(Product)object;
		
		ValidationUtils.rejectIfEmpty(errors, "name", "product.name.required");
		
		ValidationUtils.rejectIfEmpty(errors, "des", "product.des.requires");
		
		if(product.getPrice()>50||product.getPrice()<0)
			errors.rejectValue("price", "product.price.invalid");
		
		Date proDate=product.getDate();
		if(proDate!=null&&proDate.after(new Date()))
			errors.rejectValue("date", "product.price.date");
		
	}

}
