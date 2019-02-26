package cn.coderstyle.demo.controller;

import org.aspectj.weaver.tools.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import cn.coderstyle.demo.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Qualifier("bookService")
	@Autowired(required=false) //默认required是true，是必须装配的
	private BookService bookService2;

	@RequestMapping(value = "/hello")
	public String print() {
		System.out.println("controller:"+bookService2);
		return "hello";
	}
	/**
	 * 当时直接使用方法中参数方式获取request中的参数，这种形式相当于@RequestParam(name="abc",required = false)
	 * @param abc
	 */
	@RequestMapping(value="/test",method=RequestMethod.POST)
	public void testParam( @RequestParam(name="abc")String abc) {
		
		System.out.println("abc:"+abc);
		
	}
}
