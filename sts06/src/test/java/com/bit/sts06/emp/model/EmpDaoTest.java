package com.bit.sts06.emp.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class EmpDaoTest {

	@Autowired
	EmpDao empDao;
	
	@Test
	public void testSelectAll() throws SQLException {
		assertNotNull(empDao.selectAll());
	}

	@Test
	public void testSelectAllInt() throws SQLException {
		assertTrue(empDao.selectAll(1).size() > 0);
	}

	@Test
	public void testSelectOne() {
		fail("Not yet implemented");
	}

}
