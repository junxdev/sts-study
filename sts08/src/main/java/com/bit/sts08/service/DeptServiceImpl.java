package com.bit.sts08.service;

import java.sql.SQLException;
import java.util.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bit.sts08.model.DeptDao;
import com.bit.sts08.model.entity.DeptVo;


@Service
public class DeptServiceImpl implements DeptService {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public void list(Model model) throws SQLException {
		model.addAttribute("list", sqlSession.getMapper(DeptDao.class).selectAll());
	}

	@Override
	public Map<String, Object> list() throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("root", sqlSession.getMapper(DeptDao.class).selectAll());
		return map;
	}
	
	@Override
	public DeptVo detail(int deptno) throws SQLException {
		return sqlSession.getMapper(DeptDao.class).selectOne(deptno);
	}
}
