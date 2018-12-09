package cn.coderstyle.demo;

import javax.activation.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.coderstyle.demo.config.MainConfigOfProfile;

public class IOCTest_Profile {
	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
		String[] beanNames= applicationContext.getBeanNamesForType(DataSource.class);
		for (String name : beanNames) {
			System.out.println(name);
		}
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
