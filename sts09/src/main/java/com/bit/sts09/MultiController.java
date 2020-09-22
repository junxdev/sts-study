package com.bit.sts09;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MultiController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/multi")
	public void form() {}
	
	@RequestMapping(value = "/uploads", method = RequestMethod.POST)
	public String uploads(String test_id, MultipartFile[] files, Model model) throws IllegalStateException, IOException {
//	public void uploads(String test_id, ArrayList<MultipartFile> files) {
		List<String> names = new ArrayList<String>();
		for(MultipartFile file : files) {
			String origin = file.getOriginalFilename();
			if(origin.isEmpty()) continue;
			String newName = System.currentTimeMillis() + "_" + origin;
			File result = new File("C:\\\\Users\\\\User\\\\Documents\\\\downloads\\\\" + newName);
			file.transferTo(result);
			names.add(newName);
		}
		model.addAttribute("list", names);
		return "downloads";
	}
}
