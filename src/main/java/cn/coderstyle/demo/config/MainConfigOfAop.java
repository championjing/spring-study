package cn.coderstyle.demo.config;

import org.springframework.context.annotation.Configuration;

/**
 * AOP: [本质动态代理]
 * 		指在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式：
 * 
 *	步骤：1 . 导入aop依赖：Spring AOP;
 *		2.定义一个业务逻辑类(MathCalculator)，在业务逻辑运行的时候将日志进行打印（参数和运行结果，过程中异常）
 *		3.定义一个日志切面类（LogAspects）：切面类里面的方法需要动态感知业务方法的运行状态
 *			通知方法：
 *				1.前置通知：logStart 在目标方法之前运行
 *				2.后置通知：logEnd 在目标方法之后运行
 *				3.返回通知：logReturn 在目标方法正常返回之后运行
 *				4.异常通知：logException 在运行异常后运行
 *				5.环绕通知：动态代理，手动推进目标方法运行（joinPoint.procced() ）
 * 
 * @author champion
 *
 */
@Configuration
public class MainConfigOfAop {
	
}
