package cn.coderstyle.demo.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WinCondition implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// TODO Auto-generated method stub
		Environment environment = context.getEnvironment();
		String osName = environment.getProperty("os.name");
		if(osName.contains("Win")) {
			return true;
		}
		return false;
	}

}
