package cn.coderstyle.demo;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.coderstyle.demo.config.MainConfigLifeOfCycle;

public class IOCTestLiftCycle {

	@Test
	public void test01() {
		//创建ioc容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigLifeOfCycle.class);
		System.out.println("容器创建完成");
		applicationContext.close();
	}
}
