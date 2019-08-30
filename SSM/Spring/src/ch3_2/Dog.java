package ch3_2;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//将bean设为原型bean，即每次获取此bean都是一个新的bean，不再共用一个
public class Dog {

}
