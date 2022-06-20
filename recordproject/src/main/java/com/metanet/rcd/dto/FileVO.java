package com.metanet.rcd.dto;

import java.sql.Date;

public class FileVO {
	private int id;
	private String directory_name;
	private String name;
	private long tsize;
	private String content_type;
	private Date upload_date;
	private byte[] data;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDirectory_name() {
		return directory_name;
	}
	public void setDirectory_name(String directory_name) {
		this.directory_name = directory_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public long getTsize() {
		return tsize;
	}
	public void setTsize(long tsize) {
		this.tsize = tsize;
	}
	public String getContent_type() {
		return content_type;
	}
	public void setContent_type(String contenttype) {
		this.content_type = contenttype;
	}
	
	public Date getUpload_date() {
		return upload_date;
	}
	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
}
