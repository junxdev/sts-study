package com.bit.sts05.dept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.sts05.service.DeptService;

@Controller
public class DeptController {
	
	@Autowired
	DeptService deptService;
	
	public DeptController() {
		System.out.println("DeptController");
	}

	@RequestMapping("/dept")
	public String list(Model model) {
		deptService.list(model);
		return "list";
	}
}
