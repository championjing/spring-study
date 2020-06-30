package cn.coderstyle.demo;

import cn.coderstyle.demo.async.AsyncDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import cn.coderstyle.demo.bean.Blue;
import cn.coderstyle.demo.bean.Person;
import cn.coderstyle.demo.config.MainConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringStudyApplicationTests {
	
	@Autowired
	private AsyncDemo asyncDemo;

	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
//	@Test
//	public void contextLoads() {
//	}
	@Test
	public void testImport() {
		printBeans(context);
		Blue bean = context.getBean(Blue.class);
		System.out.println(bean);
		
		Object bean2 = context.getBean("colorFactoryBean");
		Object bean3 = context.getBean("colorFactoryBean");
		System.out.println("bean的类型:"+bean2.getClass());
		System.out.println(bean2 == bean3);
		
		Object bean4 = context.getBean("&colorFactoryBean");
		System.out.println("bean4的类型:"+bean4.getClass());
	}
	
	public void printBeans(AnnotationConfigApplicationContext context) {
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		System.out.println("------------------");
		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}
	}
	
	@Test
	public void testEnv() {
		String[] beanNamesForType = context.getBeanNamesForType(Person.class);
		ConfigurableEnvironment env = context.getEnvironment();
		String osName = env.getProperty("os.name");
		System.out.println("osName:"+osName);
		System.out.println("beans:"+beanNamesForType.length);
		for (String name : beanNamesForType) {
			System.out.println("name:"+name);
		}
		
	}
	@Test
	public void testAsync(){
		System.out.println("start1");
		asyncDemo.add(1,"a");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("end");
		}
		System.out.println("start2----------");
		asyncDemo.add(1000,"b");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("end");
		}
	}
}
