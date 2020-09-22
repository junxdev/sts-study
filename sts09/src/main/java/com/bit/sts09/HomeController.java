package com.bit.sts09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(String test_id, MultipartFile test_file, Model model) {
		logger.info("uploading from " + test_id);
		logger.info("uploading " + test_file.getOriginalFilename());
		String path = "C:\\Users\\User\\Documents\\downloads\\";
		String reName = System.currentTimeMillis() + "_" + test_file.getOriginalFilename();
		File file = null;
		file = new File(path + reName);
		try {
			test_file.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		Way 1
//		file = new File(path + test_file.getOriginalFilename());
//		InputStream is = null;
//		OutputStream os = null;
//		try {
//			is = test_file.getInputStream();
//			os = new FileOutputStream(file);
//			int su = -1;
//			while((su = is.read()) != -1) {
//				os.write(su);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(os != null) os.close();
//				if(is != null) is.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		logger.info("uploaded");
		model.addAttribute("name", reName);
		return "download";
	}
	
	@RequestMapping(value = "download/{fileName:.+}")
	public String download(@PathVariable String fileName, HttpServletResponse res) {
		logger.info(fileName);
		String origin = fileName.substring(fileName.indexOf('_') + 1);
		String path = "C:\\Users\\User\\Documents\\downloads\\";
		File file = new File(path + fileName);
		res.setHeader("Content-Disposition", "attachment; filename=\"" + origin +"\"");
		if(file.exists()) {
			OutputStream os = null;
			InputStream is = null;
			try {
				os = res.getOutputStream();
				is = new FileInputStream(file);
				int su = -1;
				while((su = is.read()) != -1) {
					os.write(su);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
					try {
						if(is != null) is.close();
						if(os != null) os.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
		}
		return null;
		
		
	}
}
