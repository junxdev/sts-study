package com.bit.sts05.dept.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bit.sts05.service.DeptService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class DeptDaoTest {
	
	@Autowired
	DeptDao deptDao;
	
	@Autowired
	DeptService deptService;

	@Test
	public void testSelectAll() {
		deptDao.selectAll(2);
	}
	
	@Test
	public void testService() {
		deptService.list(null);
	}

}
