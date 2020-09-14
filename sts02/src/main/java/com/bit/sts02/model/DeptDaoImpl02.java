package com.bit.sts02.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bit.sts02.model.entity.DeptVo;

public class DeptDaoImpl02 implements DeptDao {

	JdbcTemplate jdbcTemplate;
	RowMapper<DeptVo> rowMapper = new RowMapper<DeptVo>() {
		
		@Override
		public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new DeptVo(rs.getInt(1), rs.getString(2), rs.getString(3));
		}
	};
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<DeptVo> selectAll() throws SQLException {
		String sql = "SELECT * FROM dept ORDER BY deptno DESC";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public void insertOne(DeptVo vo) throws SQLException {
		String sql = " INSERT INTO dept VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, vo.getDeptno(), vo.getDname(), vo.getLoc());
	}

	@Override
	public DeptVo selectOne(int deptno) throws SQLException {
		String sql = "SELECT * FROM dept WHERE deptno = ?";
		return jdbcTemplate.queryForObject(sql, rowMapper, deptno);
	}

	@Override
	public int updateOne(DeptVo vo) throws SQLException {
		String sql = "UPDATE dept SET dname = ?, loc = ? WHERE deptno = ?";
		return jdbcTemplate.update(sql, vo.getDname(), vo.getLoc(), vo.getDeptno());
	}

	@Override
	public int deleteOne(int deptno) throws SQLException {
		String sql = "DELETE FROM dept WHERE deptno = ?";
		return jdbcTemplate.update(sql, deptno);
	}
}
