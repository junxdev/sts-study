package com.bit.sts08.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.sts08.model.entity.DeptVo;
import com.bit.sts08.service.DeptService;
//import com.google.gson.Gson;

@Controller
public class DeptController {

	@Inject
	DeptService deptService;
	
//	@RequestMapping(value = "/dept/", method = RequestMethod.GET)
//	public String list(Model model) {
//		try {
//			deptService.list(model);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return "deptListJson";
//	}
	
//	@RequestMapping(value = "/dept/", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
	@RequestMapping(value = "/dept/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> list(Model model) {
		try {
//			deptService.list(model);
			return deptService.list();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		Map<String, Object> map = new HashMap<String, Object>();
//		List<Object> list = new ArrayList<Object>();
//		list.add(new DeptVo());
//		list.add(new DeptVo());
//		list.add(new DeptVo());
//		map.put("root", list);
//		return map;
		return null;
	}
	
//	@RequestMapping(value = "/dept/", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
//	@ResponseBody
//	public String list(Model model) {
//		try {
//			deptService.list(model);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		Gson gson = new Gson();
//		ArrayList list = new ArrayList();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		Map map = new HashMap();
//		map.put("root", model.asMap().get("list"));
//		//		return "{\"root\":[{\"deptno\":1000,\"dname\":\"test\",\"loc\":\"test2\"}]}";
//		return gson.toJson(map);
//	}
	
	@RequestMapping(value = "/dept/{deptno}")
	@ResponseBody
	public DeptVo detail(@PathVariable int deptno) throws SQLException {
		return deptService.detail(deptno);
	}
}
