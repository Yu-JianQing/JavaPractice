package ch6;

import java.lang.reflect.Method;

public class Container {
	
	public static LoginBean getBean(){
		LoginBean loginBean=new LoginBean();
		
		if(LoginBean.class.isAnnotationPresent(AnnoTest.class)){
			Method[] methods=LoginBean.class.getDeclaredMethods();
			
			for(Method method:methods){
				if(method.isAnnotationPresent(AnnoTest.class)){
					AnnoTest annoTest=method.getAnnotation(AnnoTest.class);
					System.out.println("loginBean's "+method.getName()+
							" annotation msg:"+annoTest.msg());
					
					UserLogin userLogin;
					try {
						userLogin=(UserLogin)Class.forName("ch6."+annoTest.msg()).newInstance();
						loginBean.setUserLogin(userLogin);
					} catch (Exception e) {
						System.out.println(e.getCause().getMessage());
					}
				}
			}
		}else {
			System.out.println("no annotation");
		}
		
		
		return loginBean;
	}
	
}
