package com.bit.sts06.emp.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public interface EmpService {

	public void list(HttpServletRequest req) throws SQLException;
}