package cn.coderstyle.demo;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import cn.coderstyle.demo.bean.Person;
import cn.coderstyle.demo.config.MainConfigLifeOfCycle;
import cn.coderstyle.demo.config.MainConfigOfPropertyValues;

public class IOCTestPropertyValue {
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

	@Test
	public void test01() {
		printBeans(applicationContext);
		System.out.println("===============");
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
		
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String nickName = environment.getProperty("person.nickName");
		System.out.println(nickName);
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
