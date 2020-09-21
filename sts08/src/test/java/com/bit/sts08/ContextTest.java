package com.bit.sts08;

import static org.junit.Assert.assertSame;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class ContextTest {

	Logger log = LoggerFactory.getLogger(this.getClass());
	/*
	 * @Inject DataSource dataSource;
	 * 
	 * @Test public void testDataSource() throws SQLException {
	 * log.debug(dataSource.toString()); for(int i = 0; i < 20; i++) { Connection
	 * conn = dataSource.getConnection(); log.debug(conn.toString()); //
	 * conn.close(); } }
	 */
	
	@Inject
	JdbcTemplate jdbcTemplate;
	
	@Test
	public void testJDBC() {
		assertSame(7, jdbcTemplate.queryForList("SELECT * FROM dept03").size());
		jdbcTemplate.update("INSERT INTO dept03 (dname, loc) VALUES ('jdbcpool', 'jdbcpool')");
		assertSame(8, jdbcTemplate.queryForList("SELECT * FROM dept03").size());
	}
}
