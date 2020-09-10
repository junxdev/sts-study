package com.bit.sts01.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class Ex03Controller {

	@RequestMapping("/ex03")
	public View ex03() {
		return new View() {
			
			@Override
			public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
				PrintWriter out = response.getWriter();
				out.print("<html><head><meta charset=\"utf-8\"></head><body>");
				out.print("<h1>View Interface 시험 중</h1>");
				out.print("</body></html>");
			}
			
			@Override
			public String getContentType() {
				return "text/html; charset=utf-8";
			}
		};
	}
	
	@RequestMapping("/ex04")
	public String ex04() {
		return "home";
	}
}
