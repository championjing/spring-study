package cn.coderstyle.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import cn.coderstyle.demo.service.BookService;

/**
 * 自动装配：
 * 		Spring利用依赖注入（DI），完成对IOC容器中各组件的依赖关系赋值S
 * 1) @Autowired
 * 	1.默认优先按照类型去容器中找对应的组件：
 * 		applicationContext.getBean(BookService.class);
 * 
 * 	2.如果找到多个相同类型的组件，再将属性的名称作为组建的id去容器中查找：
 * 		applicationContext.getBean("bookService");
 * 	3.使用@Qualifier("bookService"):使用该注解制定需要装配的组件id，而不是使用属性名
 * 	4.自动装配注解下，一定要将属性赋值好，没有就会报错
 * 		可以使用 @Autowired(required=false)，在没有bean时就不装配
 * 	5.@Primary:让Spring进行自动装配时，将bean设置成首选装配,@Qualifier仍然生效
 * 
 * @author champion
 *
 */
@Configuration
@ComponentScan({"cn.coderstyle.demo.service","cn.coderstyle.demo.controller"})
public class MainConfigOfAutowired {
	
	@Primary
	@Bean("bookService2")
	public BookService bookService() {
		BookService bookService = new BookService();
		bookService.setLableString("2");
		return bookService;
	}
}
