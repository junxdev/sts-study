package com.bit.sts01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex01Controller {

	@RequestMapping(value = "/ex01.bit")
	public ModelAndView ex01() {
		
		return new ModelAndView("ex01");
	}

}
