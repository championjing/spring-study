package cn.coderstyle.demo;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.coderstyle.demo.config.MainConfigOfAutowired;
import cn.coderstyle.demo.controller.BookController;

public class IOCTest_Autowired {
	
	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
		printBeans(applicationContext);
		System.out.println("===============");
		BookController bookController = (BookController) applicationContext.getBean("bookController");
//		System.out.println(bookService);
		bookController.print();
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
