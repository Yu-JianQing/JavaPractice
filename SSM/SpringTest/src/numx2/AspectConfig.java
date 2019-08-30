package numx2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectConfig {
	
	@DeclareParents(value="numx2.Person+",defaultImpl=PersonEat.class)
	public static Eat eat;
	
}
