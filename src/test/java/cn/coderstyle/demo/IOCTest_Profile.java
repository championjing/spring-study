package cn.coderstyle.demo;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.coderstyle.demo.config.MainConfigOfProfile;

public class IOCTest_Profile {
	
	//1.使用命令行动态参数方式：在虚拟机参数位置加载 -Dspring.profiles.active=dev
	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
		printBeans(applicationContext);
		System.out.println("print beans-----");
		String[] beanNames= applicationContext.getBeanNamesForType(DataSource.class);
		for (String name : beanNames) {
			System.out.println(name);
		}
		applicationContext.close();
	}
	
	@Test
	public void test02() {
		//1.创建applicationContext对象
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext();
		//2.设置需要激活的环境
		applicationContext.getEnvironment().setActiveProfiles("test","dev");
		//3.注册主配置类
		applicationContext.register(MainConfigOfProfile.class);
		//4.启动刷新容器
		applicationContext.refresh();
		
		System.out.println("test02 print beans-----");
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
