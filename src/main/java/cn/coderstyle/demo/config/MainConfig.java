package cn.coderstyle.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import cn.coderstyle.demo.bean.Color;
import cn.coderstyle.demo.bean.ColorFactoryBean;
import cn.coderstyle.demo.bean.Person;
import cn.coderstyle.demo.bean.Red;
import cn.coderstyle.demo.condition.LinuxCondition;
import cn.coderstyle.demo.condition.MyImportBeanDefinitionRegistrar;
import cn.coderstyle.demo.condition.MyImportSelector;
import cn.coderstyle.demo.condition.WinCondition;

@Configuration
@Import({Color.class,Red.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class}) //导入组件，bean名默认是全限定名
public class MainConfig {
	
	@Bean
	public Person person() {
		Person person = new Person();
		person.setName("A");
		person.setAge(210);
//		System.out.println("p");
		return person;
	}
	
	@Conditional(value = { WinCondition.class })
	@Bean(value="bill")
	public Person person01() {
		Person person = new Person();
		person.setName("bill");
		person.setAge(62);
//		System.out.println("p01");
		return person;
	}
	@Conditional(value = { LinuxCondition.class })
	@Bean(value="liuns")
	public Person person02() {
		Person person = new Person();
		person.setName("liuns");
		person.setAge(51);
//		System.out.println("p02");
		return person;
	}
	/**
	 * 给容器注册组件的方式：
	 * 1. 包扫描+组件标注注解（@Controller/@Service/@Repository@Component） 【自己写的类】
	 * 2. @Bean [导入的第三方包里面的类 @Conditional 可以定义条件注入]
	 * 3. @Import [快速给容器中导入组件]
	 * 		1)直接写入类型
	 * 		2)ImportSelector：返回需要导入的组件的全限定名数组
	 * 		3)ImportBeanDefinitionRegistrar
	 * 4. 使用Spring提供的FactoryBean(工厂Bean)
	 * 		1)默认获得的是工厂bean调用getObject创建的对象
	 * 		2)获取工厂bean本身，需要给id前+&
	 * 			&colorFactoryBean
	 */
	@Bean
	public ColorFactoryBean colorFactoryBean() {
		return new ColorFactoryBean(); 
	}
}
