package ch4_9;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EncoreableAspect {
	
	@DeclareParents(value="ch4_9.Performance+",defaultImpl=EncoreableImpl.class)
	public static Encoreable encoreable;

}
