package com.bit.sts01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.sts01.model.entity.TestBean;

@Controller
public class Ex09Controller {

	@RequestMapping(value = "/ex09")
	public String ex01() {
		System.out.println("No arguments");
		return "ex09";
	}
	
	@RequestMapping(value = "/ex10")
	public String ex01(HttpServletRequest req) {
		System.out.println("id : " + req.getParameter("id"));
		req.setAttribute("id", req.getParameter("id"));
		return "ex09";
	}
	
	@RequestMapping(value = "/ex11")
	public String ex01(Model model, HttpServletRequest req) {
		model.addAttribute("id", "Model attribute");
		return "ex09";
	}

	@RequestMapping(value = "/ex12")
	public String ex01(int num) {
		System.out.println(num + 100);
		return "ex09";
	}
	
	@RequestMapping(value = "/ex13/{num}/{category}")
	public String ex02(@PathVariable("num") int num, @PathVariable String category) {
		System.out.println(category + " page : " + num + 100);
		return "ex09";
	}
	
	@RequestMapping("/ex14")
	public String ex03(@ModelAttribute("id") String id) {
		return "ex09";
	}
	
	@RequestMapping("/ex15")
	public String ex03(@ModelAttribute("bean") TestBean bean) {
		System.out.println(bean);
		return "ex15";
	}
}
