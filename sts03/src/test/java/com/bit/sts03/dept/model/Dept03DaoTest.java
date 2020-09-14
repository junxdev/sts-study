package com.bit.sts03.dept.model;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.sts03.dept.model.entity.Dept03Vo;

public class Dept03DaoTest {

	Dept03Dao dept03Dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
		
		ApplicationContext ac = null;
		ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
		DataSource dataSource = (DataSource) ac.getBean("dataSource");
		
		Connection conn = dataSource.getConnection();
		
		/* Create table */
//		conn.prepareStatement("CREATE TABLE IF NOT EXISTS `dept03` (" + 
		conn.prepareStatement("CREATE TABLE `dept03` (" + 
				"	`deptno` INT NOT NULL AUTO_INCREMENT," + 
				"	`dname` VARCHAR(50) NULL DEFAULT NULL," + 
				"	`loc` VARCHAR(50) NULL DEFAULT NULL," + 
				"	PRIMARY KEY (`deptno`)\r\n" + 
				")").execute();
		/* Insert dummy data*/
		conn.prepareStatement("INSERT INTO dept03 (dname, loc) VALUES ('test', 'test')").executeUpdate();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
		
		File file = new File("C:\\Users\\User\\Documents\\sts-study\\data\\xeTest.mv.db");
		if(file.exists()) {
			file.delete();
		}
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
		
		ApplicationContext ac = null;
		ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
		dept03Dao = (Dept03Dao) ac.getBean("dept03Dao");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("teadDown");
	}

	@Test
	public void testSelectAll() {
//		ApplicationContext ac = null;
//		ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
//		Dept03Dao dept03Dao = (Dept03Dao) ac.getBean("dept03Dao");
//		assertNotNull(dept03Dao.selectAll()); 
		assertSame(0, dept03Dao.selectAll().size());
//		List<Dept03Vo> list = dept03Dao.selectAll();
//		for(Dept03Vo vo : list) {
//			System.out.println(vo);
//		}
//		fail("Not yet implemented");
	}
	
	@Test
	public void testSelectOne() {
		Dept03Vo target = new Dept03Vo(1, "test", "test");
		
//		ApplicationContext ac = null;
//		ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
//		Dept03Dao dept03Dao = (Dept03Dao) ac.getBean("dept03Dao");
		
		assertEquals(target, dept03Dao.selectOne(target.getDeptno()));
	}
	
//	@Test
//	public void testFirst() throws SQLException {
//		ApplicationContext ac = null;
//		ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
//		Dept03Dao dept03Dao = (Dept03Dao) ac.getBean("dept03Dao");
//		System.out.println(dept03Dao);
//		DataSource dataSource = (DataSource) ac.getBean("dataSource");
//		Connection conn = dataSource.getConnection();
//		/* Create table */
//		conn.prepareStatement("CREATE TABLE IF NOT EXISTS `dept03` (" + 
//				"	`deptno` INT NOT NULL AUTO_INCREMENT," + 
//				"	`dname` VARCHAR(50) NULL DEFAULT NULL," + 
//				"	`loc` VARCHAR(50) NULL DEFAULT NULL," + 
//				"	PRIMARY KEY (`deptno`)\r\n" + 
//				")").execute();
		/* Insert dummy data*/
//		conn.prepareStatement("INSERT INTO dept03 (dname, loc) VALUES ('test', 'test')").executeUpdate();
//	}

}
