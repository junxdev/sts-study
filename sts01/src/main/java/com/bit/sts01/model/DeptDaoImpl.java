package com.bit.sts01.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bit.sts01.model.entity.DeptVo;

public class DeptDaoImpl implements DeptDao {

	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<DeptVo> selectAll() throws SQLException {
		List<DeptVo> list = new ArrayList<DeptVo>();
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM dept");
				ResultSet rs = ps.executeQuery();
				) {
			while(rs.next()) {
				list.add(new DeptVo(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		}
		return list;
	}
}
