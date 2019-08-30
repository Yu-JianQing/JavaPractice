package ch3;

import org.springframework.stereotype.Component;

@Component
@Cold//使用自定义的注解限制，效果等同于@Qualifier（“cold”）
public class Cake implements Dessert{
	
}
