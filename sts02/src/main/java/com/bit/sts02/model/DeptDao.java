package com.bit.sts02.model;

import java.sql.SQLException;
import java.util.List;

import com.bit.sts02.model.entity.DeptVo;

public interface DeptDao {

	List<DeptVo> selectAll() throws SQLException;
	void insertOne(DeptVo vo) throws SQLException;
	DeptVo selectOne(int deptno) throws SQLException;
	int updateOne(DeptVo vo) throws SQLException;
	int deleteOne(int deptno) throws SQLException;

}