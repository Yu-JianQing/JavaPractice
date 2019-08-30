package num5;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import(TomConfig.class)
@ImportResource("classpath:num5.xml")
public class Config {

}
