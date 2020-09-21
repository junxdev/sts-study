package com.bit.sts08.model;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.bit.sts08.model.entity.DeptVo;

public interface DeptDao {

	@Select("SELECT * FROM dept03")
	List<DeptVo> selectAll() throws SQLException;
	DeptVo selectOne() throws SQLException;
	void insertOne() throws SQLException;
	int updateOne() throws SQLException;
	int deleteOne() throws SQLException;
	
}
