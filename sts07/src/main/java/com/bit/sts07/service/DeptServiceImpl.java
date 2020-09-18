package com.bit.sts07.service;

import java.sql.SQLException;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bit.sts07.model.DeptDao;
import com.bit.sts07.model.entity.DeptVo;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public void listService(Model model) throws SQLException {
		DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		model.addAttribute("list", deptDao.selectAll());
	}
	
	@Override
	public void addOneService(DeptVo bean) throws SQLException {
		DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		deptDao.insertOne(bean);
	}
	
	@Override
	public void detailService(Model model, int deptno) throws SQLException {
		DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		model.addAttribute("bean", deptDao.selectOne(deptno));
	}
	
	@Override
	public void editOneService(DeptVo bean) throws SQLException {
		DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		deptDao.updateOne(bean);
	}
	
	@Override
	public void deleteOneService(int deptno) throws SQLException {
		DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		deptDao.deleteOne(deptno);
	}

}
