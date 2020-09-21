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
import org.springframework.transaction.annotation.Transactional;

import com.bit.sts08.model.entity.DeptVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
@Transactional
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
	public void testSelectOne() throws SQLException {
		assertNotNull(sqlSession.getMapper(DeptDao.class).selectOne(1));
	}

	@Test
	public void testCRUD() throws SQLException {
		assertSame(8, sqlSession.getMapper(DeptDao.class).selectAll().size());
		
		DeptVo target = new DeptVo(0, "crudtest", "crudtest");
		sqlSession.getMapper(DeptDao.class).insertOne(target);
		
		assertSame(9, sqlSession.getMapper(DeptDao.class).selectAll().size());
		target.setDeptno(sqlSession.getMapper(DeptDao.class).selectAll().get(8).getDeptno());
		target.setDname("update");
		target.setLoc("update");
		sqlSession.getMapper(DeptDao.class).updateOne(target);
		assertEquals(target, sqlSession.getMapper(DeptDao.class).selectOne(target.getDeptno()));
		
		sqlSession.getMapper(DeptDao.class).deleteOne(target.getDeptno());
		assertSame(8, sqlSession.getMapper(DeptDao.class).selectAll().size());
	}

	@Test
	public void testTx() throws SQLException {
		assertSame(8, sqlSession.getMapper(DeptDao.class).selectAll().size());
		DeptVo target = new DeptVo(0, "txtest", "rollback");
		sqlSession.getMapper(DeptDao.class).insertOne(target);
		assertSame(8, sqlSession.getMapper(DeptDao.class).selectAll().size());
		
	}

	@Test
	public void testDeleteOne() {
		fail("Not yet implemented");
	}

}
