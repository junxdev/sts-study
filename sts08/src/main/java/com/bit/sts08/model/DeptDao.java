package com.bit.sts08.model;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bit.sts08.model.entity.DeptVo;

public interface DeptDao {

	@Select("SELECT * FROM dept03")
	List<DeptVo> selectAll() throws SQLException;
	
	@Select("SELECT * FROM dept03 WHERE deptno = #{deptno}")
	DeptVo selectOne(@Param("deptno") int deptno) throws SQLException;
	
	@Insert("INSERT INTO dept03 (dname, loc) VALUES (#{dname}, #{loc})")
	void insertOne(DeptVo bean) throws SQLException;
	
	@Update("UPDATE dept03 SET dname = #{dname}, loc = #{loc} WHERE deptno = #{deptno}")
	int updateOne(DeptVo bean) throws SQLException;
	
	@Delete("DELETE FROM dept03 WHERE deptno = #{deptno}")
	int deleteOne(int deptno) throws SQLException;
	
}
