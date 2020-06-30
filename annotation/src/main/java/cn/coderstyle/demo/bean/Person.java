package cn.coderstyle.demo.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {
	/**
	 * 使用@Value赋值
	 * 1. 基本数值赋值
	 * 2. 使用SpEL:#{}
	 * 3. &{}取出配置文件中的值（在运行环境变量中的值）
	 */
	@Value("张三")
	private String name;
	@Value("#{20-2}")
	private int age;
	@Value("${person.nickName}")
	private String nickName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", nickName=" + nickName + "]";
	}

}
