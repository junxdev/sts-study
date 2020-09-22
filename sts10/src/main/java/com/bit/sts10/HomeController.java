package com.bit.sts10;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/emp")
	public void emp() {
		System.out.println("emp");
//	public String emp(HttpSession session) {
//		if ("admin".equals(session.getAttribute("auth"))) {
//			return "page2";
//		} else if("member".equals(session.getAttribute("auth"))) {
//			return "page2";
//		} else {
//			return "redirect:/";
//		}
	}
	
	@RequestMapping("/dept")
	public String dept(HttpSession session) {
		System.out.println("dept");
		if ("admin".equals(session.getAttribute("auth"))) {
			return "page3";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping("/page4")
	public void page4(HttpSession session) {
		System.out.println("page4 : " + session.getId());
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest req) {
		System.out.println("login");
		HttpSession session = req.getSession();
		if(session.getAttribute("login") == null) {
			return "login";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping("/result")
	public String result(String id, String pw, HttpServletRequest req) {
		logger.info("id : " + id + ", pw : " + pw);
		HttpSession session = req.getSession();
		session.setAttribute("login", true);
		session.setAttribute("user", id);
		if(id.equals("admin")) {
			session.setAttribute("auth", "admin");
		} else if(id.equals("member")) {
			session.setAttribute("auth", "member");
		} else {
			session.setAttribute("auth", "public");
		}
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req) {
		System.out.println("logout");
		HttpSession session = req.getSession();
		session.invalidate();
		return "redirect:/";
	}
}
