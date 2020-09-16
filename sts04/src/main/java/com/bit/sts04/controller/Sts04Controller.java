package com.bit.sts04.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Sts04Controller {
	
	@Autowired
	DataSource dataSource;

	@RequestMapping("/")
	public String home(Model model) {
		System.out.println(dataSource);
		String[] arr = {
				"ERIC-JOHNSON-SIGNATURE-STRATOCASTER-THINLINE.jpg",
				"KURT-COBAIN-JAGUAR-LEFT-HAND.jpg",
				"SHAWN-MENDES-FOUNDATION-MUSICMASTER.jpg"
		};
		model.addAttribute("imgs", arr);
		return "home";
	}
}
