package com.metanet.rcd.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.metanet.rcd.dto.FileVO;

@Mapper
@Repository
public interface FileDAO {
	Integer maxFileId() throws SQLException;
	FileVO selectFile(int id) throws SQLException;
	void insertFile(FileVO filevo) throws SQLException;
}
