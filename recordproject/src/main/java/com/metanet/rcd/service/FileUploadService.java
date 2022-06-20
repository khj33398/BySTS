package com.metanet.rcd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.rcd.dao.FileDAO;
import com.metanet.rcd.dto.FileVO;

@Service
public class FileUploadService {
	@Autowired
	FileDAO fileDAO;
	
	public void fileDBUpload(FileVO filevo) throws Exception {
		fileDAO.insertFile(filevo);
	}
	
	public int getFileId() throws Exception {
		Integer id = fileDAO.maxFileId();
		if(id==null) id=0;
		return id+1;
	}
	
	public FileVO getFile(int id) throws Exception {
		return fileDAO.selectFile(id);
	}
	
}
