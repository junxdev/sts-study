package com.bit.sts07.service;

import java.sql.SQLException;

import org.springframework.ui.Model;

import com.bit.sts07.model.entity.DeptVo;

public interface DeptService {

	void listService(Model model) throws SQLException;

	void addOneService(DeptVo bean) throws SQLException;

	void detailService(Model model, int deptno) throws SQLException;

	void editOneService(DeptVo bean) throws SQLException;

	void deleteOneService(int deptno) throws SQLException;

}