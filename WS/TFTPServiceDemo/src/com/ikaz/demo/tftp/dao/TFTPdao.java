

package com.ikaz.demo.tftp.dao;

import java.util.HashMap;
import java.util.Map;

import com.ikaz.demo.tftp.model.TFTPFile;

/**
 * @author icastillejos
 * @version 0.0.1
 */
public enum TFTPdao {
	INSTANCE;
	
	private Map<String, TFTPFile> contentProvider = new HashMap<String, TFTPFile>();
	
	private TFTPdao(){
		TFTPFile todo = new TFTPFile("1","Learn REST");
		contentProvider.put("1", todo);
		
		todo = new TFTPFile("2","Do something");
		contentProvider.put("2", todo);
	}
	
	public Map<String, TFTPFile> getModel(){
		return contentProvider;
	}	
}
