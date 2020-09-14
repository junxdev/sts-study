package com.bit.sts02.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.bit.sts02.model.DeptDao;
import com.bit.sts02.model.entity.DeptVo;

@Controller
@RequestMapping("/dept/")
public class DeptController {
	
	DeptDao deptDao;
	
	@Autowired
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	@RequestMapping("list")
	public String list(Model model) throws SQLException {
		model.addAttribute("list", deptDao.selectAll());
		return "dept/list";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		return "dept/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String insert(@ModelAttribute DeptVo vo) throws SQLException {
		deptDao.insertOne(vo);
		return "redirect:list";
	}
	
	@RequestMapping(value = "detail")
	public String detail(int deptno, Model model) throws SQLException {
		model.addAttribute("vo", deptDao.selectOne(deptno));
		model.addAttribute("title", "Detail");
		model.addAttribute("readonly", "readonly");
		return "dept/detail";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(int deptno, Model model) throws SQLException {
		model.addAttribute("vo", deptDao.selectOne(deptno));
		model.addAttribute("title", "Edit");
		model.addAttribute("readonly", "");
		return "dept/detail";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String update(@ModelAttribute DeptVo vo) throws SQLException {
		deptDao.updateOne(vo);
		return "detail?deptno=" + vo.getDeptno();
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public ModelAndView delete(int deptno) {
		
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView delete() {
		
		return null;
	}
}
