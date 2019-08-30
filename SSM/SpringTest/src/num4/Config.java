package num4;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({TomConfig.class,JerryConfig.class})
@ImportResource("classpath:num4.xml")
public class Config {

}
