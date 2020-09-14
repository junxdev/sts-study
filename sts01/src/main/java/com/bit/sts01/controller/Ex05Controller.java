package com.bit.sts01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Ex05Controller {

	@RequestMapping(value = "ex06")
	public void ex01() {}
	
	@RequestMapping(value = "ex/ex07") // no file
	public void ex02() {}
}
