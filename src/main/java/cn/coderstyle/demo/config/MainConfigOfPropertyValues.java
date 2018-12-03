package cn.coderstyle.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import cn.coderstyle.demo.bean.Person;

/**
 * 与属性赋值相关的注解
 * @author champion
 *
 */
//使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中
@PropertySource(value= {"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValues {

	@Bean
	public Person person() {
		return new Person();
	}
}
