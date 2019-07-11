package cn.coderstyle.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import cn.coderstyle.demo.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
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
	 * 传入参数str_my不能识别
	 * @param strMy
	 * @return
	 */
	@RequestMapping("/test/case")
	public String testCase(String strMy){
		System.out.println(strMy);
		return strMy;
	}
}
