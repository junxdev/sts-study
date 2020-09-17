package com.bit.sts05;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bit.sts05.dept.model.entity.DeptVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class TestContext {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testDataSource() throws SQLException {
		Connection conn = dataSource.getConnection();
		log.debug(conn.toString());
		assertNotNull(conn);
	}
	
	@Test
	public void testSqlSessionFactory() {
		assertNotNull(sqlSessionFactory);
	}
	
	@Test
	public void testSelectDept() {
		try (
				SqlSession session = sqlSessionFactory.openSession()
				) {
			session.selectList("dept.selectDept", new DeptVo(0, "영업", null));
//			List<Map<String, String>> list = session.selectList("dept.selectDept");
//			for(Map<String, String> map : list) {
//				log.debug(map.toString());
//			}
			
//			Map<String, Object> map = session.selectOne("test.selectDept", 1);
//			Set<Entry<String, Object>> entrySet = map.entrySet();
//			Iterator<Entry<String, Object>> ite = entrySet.iterator();
//			while(ite.hasNext()) {
//				Entry<String, Object> entry = ite.next();
//				log.debug(entry.getKey() + " : " + entry.getValue());
//			}
			
		}
	}
	
	@Test
	public void testSelectEach() {
		try(
				SqlSession session = sqlSessionFactory.openSession();
				) {
			List list = new ArrayList<Integer>();
			list.add(3);
			list.add(4);
			list.add(5);
			session.selectList("dept.selectEach", list);
		}
	}
	
	@Test
	public void testInsertTest() {
		try (
				SqlSession session = sqlSessionFactory.openSession();
				) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("deptno", 99);
			map.put("dname", "mybatis");
			map.put("loc", "test");
			assertSame(1, session.insert("test.insertTest", map));
		}
	}
	
	@Test
	public void testDeleteTest() {
		try (
				SqlSession session = sqlSessionFactory.openSession();
				) {
			assertSame(1, session.delete("test.deleteTest", 99));
		}
	}
}
