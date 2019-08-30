package ch3_2;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION,//将此bean设为会话bean（session范围）
		proxyMode=ScopedProxyMode.TARGET_CLASS)//将注入代理设为基于类（因为Cart1是个类）的代理模式
public class Cart1 implements Cart{

}
