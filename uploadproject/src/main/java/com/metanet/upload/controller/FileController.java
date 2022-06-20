package com.metanet.upload.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	@Autowired
	ServletContext servletContext;
	
	@Value("${upload.filepath}")
	private String filepath;
	
	@GetMapping("/fileupload")
	public String fileupload() {
		return "fileupload";
	}
	
	
	@PostMapping("/fileupload")
	public String fileupload(@RequestParam("file") MultipartFile file, 
			@RequestParam("text") String text, Model model) {
		String path = servletContext.getRealPath(filepath);
		File destFile = new File(path+file.getOriginalFilename());
		try {
			file.transferTo(destFile); //해당 경로에 파일 전송(저장)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("text", text);
		model.addAttribute("fileName", file.getOriginalFilename());
		return "uploadresult";
	}
	
	@GetMapping("/fileview/{filename}")
	public void fileview(@PathVariable String filename, HttpServletResponse response) {
		String path = servletContext.getRealPath(filepath);
		File file = new File(path+filename);
		FileInputStream fis = null;
		try {
			OutputStream out = response.getOutputStream();
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis!=null) fis.close();
			} catch (IOException e) {
			}
		}
	}
	
	
}
