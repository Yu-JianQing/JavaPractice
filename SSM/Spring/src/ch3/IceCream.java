package ch3;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary//利用primary设置自动装配的bean的首选项。component和primary的配合
public class IceCream implements Dessert{
	
}