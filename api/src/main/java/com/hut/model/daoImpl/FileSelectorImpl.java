package com.hut.model.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import com.hut.entity.LocalFile;
import com.hut.entity.SearchTools;
import com.hut.mapper.FileMapper;

@Component("FileSelector")
public class FileSelectorImpl implements FileMapper{
	@Autowired
	private FileMapper fileMapper;
	public void setFileMapper(FileMapper fileMapper) {
		this.fileMapper = fileMapper;
	}
	@Autowired
	private LocalFile file;

	public void setFile(LocalFile file) {
		this.file = file;
	}
	
	public List<LocalFile> selectFileByName(SearchTools tool){	
		 return fileMapper.selectFileByName(tool);
	}


	public void insertAFile(LocalFile file) {
		 System.out.println(file);
		 fileMapper.insertAFile(file);
		
	};
	
}
