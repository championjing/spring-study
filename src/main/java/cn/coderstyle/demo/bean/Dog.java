package cn.coderstyle.demo.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Dog {

	public Dog() {
		System.out.println("dog... constructor..");
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("dog... postConstruct..");
	}
	@PreDestroy
	public void preDestroy() {
		System.out.println("dog... preDestroy..");		
	}
}
