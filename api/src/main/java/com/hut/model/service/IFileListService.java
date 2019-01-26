package com.hut.model.service;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

public interface IFileListService {
	public String selectFileByName(String name, int offset);
	
	public void downloadFileByPath(File file, OutputStream out);
	
	public String uploadFile(List<FileItem> items,String path);
}
