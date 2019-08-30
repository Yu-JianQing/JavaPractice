package ch3_2;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION,//将bean设为会话（session）bean，相当于一个用户用一个bean
		proxyMode=ScopedProxyMode.INTERFACES)//将注入代理设为基于接口（因为Cart为一个接口）的代理模式
								//（此代理模式中的proxy或自动实现Cart接口）
public interface Cart {

}
