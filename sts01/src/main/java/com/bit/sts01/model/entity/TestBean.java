package com.bit.sts01.model.entity;

public class TestBean {
	private int num;
	private String name;
	
	public TestBean() {
	}

	public TestBean(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TestBean [num=" + num + ", name=" + name + "]";
	}
	
}
