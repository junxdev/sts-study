package com.bit.sts07;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class ContextTest {

//	@Inject
//	SqlSessionFactory sqlSessionFactory;
	
	@Inject
	SqlSession sqlSession;
	
	@Test
	public void testBean() {
		assertNotNull(sqlSession);
	}
}
