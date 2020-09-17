package com.bit.sts06.emp.model.entity;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class EmpVo {

	@Getter @Setter
	private int empno;
	@Getter @Setter
	private String ename;
	@Getter @Setter
	private int sal;
	@Getter @Setter
	private Timestamp hiredate;
	@Getter @Setter
	private int deptno;
}
