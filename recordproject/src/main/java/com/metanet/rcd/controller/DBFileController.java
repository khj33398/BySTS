package com.metanet.rcd.controller;

import java.io.File;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.metanet.rcd.dto.FileVO;
import com.metanet.rcd.service.FileUploadService;

@Controller
public class DBFileController {
	@Autowired
	FileUploadService fileUploadService;

	@Autowired
	ServletContext servletContext;
	
	@GetMapping("/")
	public String main() {
		return "voice_save";
	}

	@ResponseBody
	@PostMapping("/dbupload")
	public String dbupload(@RequestParam("data") MultipartFile file) {
		try {
			if(file!=null && !file.isEmpty()) {
				String path = servletContext.getRealPath("/fileupload/");
				FileVO filevo = new FileVO();
				filevo.setId(fileUploadService.getFileId());
				filevo.setDirectory_name(path);
				filevo.setName(file.getOriginalFilename());
				filevo.setTsize(file.getSize());
				filevo.setContent_type(file.getContentType());
				filevo.setData(file.getBytes());
				filevo.setUpload_date(new Date(22,06,02));
				//DB 저장
				fileUploadService.fileDBUpload(filevo);
				//폴더에 저장
				File upfile = new File(path+filevo.getId());
				file.transferTo(upfile);
				return "녹음 파일이 저장되었습니다.";
			}else {
				return "녹음 파일이 비어있습니다.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "녹음 파일 저장에 실패하였습니다.";
		}
	}
	
	@GetMapping("/voice")
	public String voice() {
		return "voice_receive";
	}
	
	@ResponseBody
	@PostMapping("/voice")
	public void voice(@RequestParam("fileId") Integer fileId, HttpServletResponse response) {
		try {
			FileVO fileVO = fileUploadService.getFile(fileId);
			OutputStream out = response.getOutputStream();
			FileCopyUtils.copy(fileVO.getData(), out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/voicep")
	public String voicep(@RequestParam("id") Integer id, Model model) {
		model.addAttribute("id", id);
		return "voice_play";
	}
	
	@ResponseBody
	@GetMapping("/voice/{id}")
	public void voicep(@PathVariable Integer id, HttpServletResponse response) {
		try {
			FileVO fileVO = fileUploadService.getFile(id);
			OutputStream out = response.getOutputStream();
			FileCopyUtils.copy(fileVO.getData(), out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
