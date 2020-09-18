package com.bit.sts07.controller;

import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.sts07.model.entity.DeptVo;
import com.bit.sts07.service.DeptService;

@Controller
@RequestMapping("/dept")
public class DeptController {
	
	@Inject
	DeptService deptService;

	@RequestMapping(value = "/", method = RequestMethod.GET )
	public String list(Model model) {
		try {
			deptService.listService(model);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "dept/list";
	}
	
	@RequestMapping(value = "/{deptno}", method = RequestMethod.GET)
	public String detail(@PathVariable int deptno, Model model) {
		try {
			deptService.detailService(model, deptno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "dept/detail";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String insert(@ModelAttribute DeptVo bean) {
		try {
			deptService.addOneService(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:./";
	}
	
	@RequestMapping("/add")
	public void add() {
	}
	
	@RequestMapping("/{deptno}/edit")
	public String edit(@PathVariable int deptno, Model model) {
		try {
			deptService.detailService(model, deptno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "dept/edit";
	}
	
	@RequestMapping(value = "/{deptno}", method = RequestMethod.PUT)
	public String update(@PathVariable int deptno, @ModelAttribute DeptVo bean) {
		System.out.println("update");
		return "redirect:." + deptno;
	}
	
	@RequestMapping(value = "/{deptno}", method = RequestMethod.DELETE)
	public String delete(@PathVariable int deptno) {
		System.out.println("delete");
		return "redirect:..";
	}
}
