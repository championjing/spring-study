package cn.coderstyle.demo.service;

import org.springframework.stereotype.Service;

@Service
public class BookService {

	private String lableString="1";

	public String getLableString() {
		return lableString;
	}

	public void setLableString(String lableString) {
		this.lableString = lableString;
	}

	@Override
	public String toString() {
		return "BookService [lableString=" + lableString + ", getLableString()=" + getLableString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
