package cn.coderstyle.demo.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.coderstyle.demo.bean.Car;

/**
 * bean的生命周期： bean创建-->初始化-->销毁的过程
 * 容器来管理bean的生命周期
 * 
 * 我们可以自定义初始化和销毁方法；容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 * 
 * 构造（对象创建）
 * 		单实例：在容器启动时创建对象
 * 		多实例：在每次获取时创建对象
 * 
 * BeanPostProcessor.postProcessBeforeInitialization
 * 初始化：
 * 		对象创建完成，并赋值好，调用初始化方法
 * 销毁：
 * 		单实例：在容器关闭的时候；
 * 		多实例：容器不会管理这个bean，容器不会调用销毁方法；
 * 
 * 1) 指定初始化和销毁方法
 * 		之前xml方式中是：init-method和destroy-method
 * 		现在通过@Bean中的属性init="" ……
 * 2）通过让bean实现InitializingBean(定义初始化逻辑)；销毁的方法接口:DisposableBean
 * 
 * 3) 使用JSR250协议定义的
 * 		@PostConstruct：在bean创建完成，属性值赋值完成，执行的该注解标注的方法
 * 		@PreDestroy:在销毁bean前执行的方法
 * 4) BeanPostProcessor[interface],bean的后置处理器
 * 		在bean初始化前后进行一些处理工作
 * 		postProcessorBeforeInitilization:在初始化之前工作
 * 		postProcessorAfterInitilization:在初始化之后工作
 * 
 * Spirng底层对BeanPostProcessor的使用
 * 
 * --与属性赋值相关内容
 * @author champion
 *
 */
@Configuration
public class MainConfigLifeOfCycle{

	@Bean(initMethod="init",destroyMethod="destroy")
	public Car car() {
		return new Car();
	}
}
