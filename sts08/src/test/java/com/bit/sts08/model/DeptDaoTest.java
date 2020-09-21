package com.bit.sts08.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class DeptDaoTest {
	
	@Inject
	SqlSession sqlSession;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testSelectAll() throws SQLException {
//		assertNotNull(sqlSession.getMapper(DeptDao.class));
		assertSame(7, sqlSession.getMapper(DeptDao.class).selectAll().size());
	}

	@Test
	public void testSelectOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteOne() {
		fail("Not yet implemented");
	}

}
