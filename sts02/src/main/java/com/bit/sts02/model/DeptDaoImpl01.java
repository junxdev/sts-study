package com.bit.sts02.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.h2.jdbcx.JdbcConnectionPool;

import com.bit.sts02.model.entity.DeptVo;

public class DeptDaoImpl01 implements DeptDao {

	JdbcConnectionPool jdbcConnectionPool;
	
	public void setJdbcConnectionPool(JdbcConnectionPool jdbcConnectionPool) {
		this.jdbcConnectionPool = jdbcConnectionPool;
	}
	
	@Override
	public List<DeptVo> selectAll() throws SQLException {
		String sql = "SELECT * FROM dept";
		List<DeptVo> list = new ArrayList<DeptVo>();
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (
				Connection conn = jdbcConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				) {
			while(rs.next()) {
				list.add(new DeptVo(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		}
		return list;
	}

	@Override
	public void insertOne(DeptVo vo) throws SQLException {
		String sql = "INSERT INTO dept VALUES (?, ?, ?)";
		try (
				Connection conn = jdbcConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				) {
			ps.setInt(1, vo.getDeptno());
			ps.setString(2, vo.getDname());
			ps.setString(3, vo.getLoc());
			ps.executeUpdate();
		}
	}

	@Override
	public DeptVo selectOne(int deptno) throws SQLException {
		String sql = "SELECT * FROM dept WHERE deptno = ?";
		try (
				Connection conn = jdbcConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				) {
			ps.setInt(1, deptno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) return new DeptVo(
					rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		return null;
	}

	@Override
	public int updateOne(DeptVo vo) throws SQLException {
		String sql = "UPDATE dept SET dname = ?, loc = ? WHERE deptno = ?";
		try (
				Connection conn = jdbcConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				) {
			ps.setString(1, vo.getDname());
			ps.setString(2, vo.getLoc());
			ps.setInt(3, vo.getDeptno());
			return ps.executeUpdate();
		}
	}

	@Override
	public int deleteOne(int deptno) throws SQLException {
		String sql = "DELETE FROM dept WHERE deptno = ?";
		try (
				Connection conn = jdbcConnectionPool.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				) {
			ps.setInt(1, deptno);
			return ps.executeUpdate();
		}
	}
}
