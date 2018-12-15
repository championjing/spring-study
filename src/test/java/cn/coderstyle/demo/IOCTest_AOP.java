package cn.coderstyle.demo;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.coderstyle.demo.aop.MathCalculator;
import cn.coderstyle.demo.config.MainConfigOfAop;

public class IOCTest_AOP {
	
	//1.使用命令行动态参数方式：在虚拟机参数位置加载 -Dspring.profiles.active=dev
	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAop.class);
		MathCalculator bean = applicationContext.getBean(MathCalculator.class);
		bean.div(1, 1);
		applicationContext.close();
	}
	
	public void printBeans(AnnotationConfigApplicationContext context) {
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		System.out.println("------------------");
		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}
	}
}
