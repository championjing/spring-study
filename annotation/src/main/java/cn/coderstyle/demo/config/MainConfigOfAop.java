package cn.coderstyle.demo.config;

import org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import cn.coderstyle.demo.aop.LogAspects;
import cn.coderstyle.demo.aop.MathCalculator;

/**
 * AOP: [本质动态代理]
 * 		指在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式：
 * 
 *	步骤：1 . 导入aop依赖：Spring AOP;
 *		2.定义一个业务逻辑类(MathCalculator)，在业务逻辑运行的时候将日志进行打印（参数和运行结果，过程中异常）
 *		3.定义一个日志切面类（LogAspects）：切面类里面的方法需要动态感知业务方法的运行状态
 *			通知方法：
 *				1)前置通知(@Before)：logStart 在目标方法之前运行
 *				2)后置通知(@After)：logEnd 在目标方法之后运行
 *				3)返回通知(@AfterReturning)：logReturn 在目标方法正常返回之后运行
 *				4)异常通知(@AfterThrowing)：logException 在运行异常后运行
 *				5)环绕通知(@Around)：动态代理，手动推进目标方法运行（joinPoint.procced() ）
 * 		4.给切面类的目标方法标注何时何地运行(通知注解)
 * 		5.将切面类和业务逻辑类（将要被切入的目标）都加入到容器中
 * 		6.必须告诉Spring容器哪个是切面类，只需给切面类加一个注解@Aspect
 * 		7.给配置类中加入@EnableAspectJAutoProxy ,开启基于注解的aop模式
 * 			spring中有很多的@EnableXXX，来开启某项功能
 * 
 * 主要3步：
 * 	1.将业务类和切面类加入到容器，并告诉spring容器哪个是切面类（@Aspect）
 * 	2.在切面类上的每一个通知方法上标注通知注解，告诉spring何时何地运行（切入点表达式）
 * 	3.开启给予注解的aop模式
 * 
 * AOP原理：查看给容器中注册了什么组件,这个组件什么时候工作，有什么功能
 * 	1.@EnableAspectJAutoProxy：
 * 		@Import({AspectJAutoProxyRegistrar.class})给容器中导入AspectJAutoProxyRegistrar
 * 		利用AspectJAutoProxyRegistrar自定义给容器中注册bean:internalAutoProxyCreator=AnnotationAwareAspectJAutoProxyCreator,
 * 		给容器中注册一个AnnotationAwareAspectJAutoProxyCreator（自动代理创建器）
 * 	2.探索AnnotationAwareAspectJAutoProxyCreator的功能
 * 		这个类的集成关系
 * 		AnnotationAwareAspectJAutoProxyCreator
 * 			->AspectJAwareAdvisorAutoProxyCreator
 * 				->AbstractAdvisorAutoProxyCreator
 * 					->AbstractAutoProxyCreator
 * 						->SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 * 							关注SmartInstantiationAwareBeanPostProcessor中的后置处理器（bean初始化前后做的事情）、自动装配BeanFactory
 * 		AbstractAutoProxyCreator.setBeanFactory()
 * 								.postProcessxxx() 后置处理器的实现
 * 		AbstractAdvisorAutoProxyCreator	
 * 					
 * 	流程：
 * 		1.传入配置类，创建ioc容器;
 * 		2.注册撇脂类，调用refresh() 刷新容器;
 * 		3.registerBeanPostProcessors(beanFactory);注册bean的后置处理器来拦截bean的创建
 * 			1）、先获取ioc容器已经定义了的需要创建对象的所有BeanPostProcessor
 * 			2）、给容器中加别的BeanPostProcessor
 * 			3）、优先注册实现了PriorityOrdered接口的BeanPostProcessor
 * 			4）、再给容器中注册实现了Ordered接口的BeanPostProcessor
 * 			5）、注册没实现优先级接口的BeanPostProcessor
 * 			6）、注册BeanPostProcessor，实际上创建BeanPostProcessor对象，保存再容器中
 * 				创建internalAutoProxyCreator=AnnotationAwareAspectJAutoProxyCreator
 * 
 * @author champion
 *
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAop {
	//第5步将业务逻辑类加入容器
	@Bean
	public MathCalculator calculator() {
		return new MathCalculator();
	}
	//第5步将切面类加入容器
	@Bean
	public LogAspects logAspects() {
		return new LogAspects();
	}
}
