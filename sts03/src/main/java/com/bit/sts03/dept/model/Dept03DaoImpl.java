package com.bit.sts03.dept.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bit.sts03.dept.model.entity.Dept03Vo;

public class Dept03DaoImpl implements Dept03Dao {
	
	private JdbcTemplate jdbcTemplate;
	private RowMapper<Dept03Vo> rowMapper = new RowMapper<Dept03Vo>() {
		
		@Override
		public Dept03Vo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Dept03Vo(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
		}
	};
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Dept03Vo> selectAll() {
		String sql = "SELECT * FROM dept03";
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	@Override
	public Dept03Vo	selectOne(int deptno) {
		String sql = "SELECT * FROM dept03 WHERE deptno = ?";
		return jdbcTemplate.queryForObject(sql, rowMapper, deptno);
	}
	
	@Override
	public void insertOne(Dept03Vo bean) throws SQLException {
		jdbcTemplate.update("INSERT INTO dept03 (dname, loc) VALUES (?, ?)", bean.getDname(), bean.getLoc());
	}
	
	@Override
	public int updateOne(Dept03Vo bean) throws SQLException {
		return jdbcTemplate.update("UPDATE dept03 SET dname = ?, loc = ? WHERE deptno = ?", bean.getDname(), bean.getLoc(), bean.getDeptno());
	}
	
	@Override
	public int zdeleteOne(int deptno) throws SQLException {
		return jdbcTemplate.update("DELETE FROM dept03 WHERE deptno = ?", deptno);
	}
}
