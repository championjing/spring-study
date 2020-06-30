package cn.coderstyle.demo.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
/**
 * 切面类
 * @author champion
 *
 *@Aspect告诉Spring当前类是一个切面类
 */
@Aspect
public class LogAspects {

	//抽取公共的切入点
	//1.如果本类引用，那么在原有切入点表达式里面写入该方法名
	//2.如果其他切面类引用，那么就使用该方法的全限定名
	@Pointcut("execution(public int cn.coderstyle.demo.aop.MathCalculator.div(int, int))")
	public void pointCut() {}

	//@Before在目标方法之前切入：切入点表达式(指定在哪个方法切入)
	//JoinPoint joinPoint一定要出现在参数表的第一位
	@Before("execution(public int cn.coderstyle.demo.aop.MathCalculator.*(..) )")
	public void logStart(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		System.out.println("方法名："+joinPoint.getSignature().getName()+"；参数:"+Arrays.asList(args));
	}
	@After("pointCut()")
	public void logEnd() {
		System.out.println("除法结束：");
	}
	@AfterReturning(value="pointCut()",returning="result")
	public void logReturn(Object result) {
		System.out.println("除法正常返回，计算结果："+result);
	}
	@AfterThrowing(value="pointCut()",throwing="exception")
	public void logException(Exception exception) {
		System.out.println("除法异常， 异常信息："+exception.getMessage());
	}
}
