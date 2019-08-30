package ch3;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MagicExistsCondition implements Condition{//bean创建时的条件类，实现Condition接口

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		//conditionContext是一个接口，metadata是一个接口
		//接口中含有一些方法可以检查bean的定义、是否存在、属性以及环境变量
		Environment env=context.getEnvironment();
		return env.containsProperty("magic");
	}

}
