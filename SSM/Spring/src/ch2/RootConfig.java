package ch2;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@Import({DogConfig.class,PeopleConfig.class})//引入Java配置文件中的bean，可一次引入多个bean
	//虽然people中包含dog，但是将两个bean引进来之后Spring会自动识别装配

@ImportResource("classpath:ch2_DogConfig.xml")//引入xml文件中的bean
@Import(PeopleConfig.class)//引入Java配置中的bean，people自动装配dog
public class RootConfig {

}
