package com.bit.backpackers.test;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ContextTest {
	
	@Inject
	SqlSession sqlSession;

//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//		System.out.println("setUpBeforeClass");
//		
//		ApplicationContext ac = null;
//		ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
//		dataSource = (DataSource) ac.getBean("dataSource");
//	}
	
	@Test
	public void dataSource() {
		System.out.println(sqlSession);
	}

}
