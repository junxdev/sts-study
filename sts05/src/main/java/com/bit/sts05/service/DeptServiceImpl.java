package com.bit.sts05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bit.sts05.dept.model.DeptDao;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	DeptDao deptDao;
	
	public DeptServiceImpl() {
		System.out.println("DeptService");
	}
	
	@Override
	public void list(Model model) {
		model.addAttribute("list", deptDao.selectAll());
	}
}
