package com.bit.sts01.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ImgController {

	@RequestMapping("/img.jpg")
	public ModelAndView img(HttpServletRequest req, HttpServletResponse res) throws IOException {
		File file = new File("C:\\Users\\User\\Documents\\sts-study\\sts01\\src\\main\\webapp\\img.jpg");
		InputStream is = new FileInputStream(file);
		OutputStream os = res.getOutputStream();
		int su = -1;
		while((su = is.read()) != -1) {
			os.write(su);
		}
		os.close();
		is.close();
		return null;
	}
}
