package ch3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("cook")//利用qualifier设置自动装配的限制，component和qualifier配合
	//此处是用了自定义的bean描述
public class Cookies implements Dessert{
	
}