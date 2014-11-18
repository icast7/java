package com.ikaz.demo.tftp.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This POJO represents a file
 * @author icastillejos
 * @version 0.0.1
 */
@XmlRootElement
public class TFTPFile {
	private String id;
	private String filePath;
	
	public TFTPFile(){
		super();
	}
	
	public TFTPFile(String id, String filePath){
		super();
		this.id = id;
		this.filePath = filePath;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
