package cn.coderstyle.demo.config;


import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.coderstyle.demo.bean.Yellow;


/**
 * Profile:
 * 		Spring提供的可以根据当前环境配置项，动态激活和切换一系列组件的功能
 * 
 * 	开发环境、测试环境、生产环境
   * 数据库：/A    /B      /C
 * 
 * @Profile:指定组件再哪个环境中才能被注册到容器中：
 * 1）加了环境标识的bean，只有这个环境被激活时注册进入容器，默认时default环境
 * 	修改激活profile的方式：
 * 		1.使用命令行动态参数方式：在虚拟机参数位置加载 -Dspring.profiles.active=dev
 * 		2.使用代码方式激活（见test02()）
 * 2)可以使用在配置类上，只有指定的环境时，整个类才能生效
 * 3)没有标注环境标识profile的bean，在任何环境下都能加载
 * 
 * @author champion
 *
 */
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware{
	
	@Value("${db.user}")
	private String user;
	
	private StringValueResolver valueResolver;
	private String driverClass;
	
	@Bean
	public Yellow Yellow() {
		return new Yellow();
	}
	
//	@Profile("default")
	@Profile("test")
	@Bean("testDataSource")
	public DataSource dataSourceTest(@Value("${db.password}")String pwd)throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}
	@Profile("dev")
	@Bean("devDataSource")
	public DataSource dataSourceDev(@Value("${db.password}")String pwd) throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dev");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}
	@Profile("prod")
	@Bean("prodDataSource")
	public DataSource dataSourceProd(@Value("${db.password}")String pwd) throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/prod");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}
	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		this.valueResolver = resolver;
		driverClass = valueResolver.resolveStringValue("${db.driverClass}");
	}
	
}
