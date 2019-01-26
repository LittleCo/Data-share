package com.hut.mapper;

import java.util.List;

import com.hut.entity.LocalFile;
import com.hut.entity.SearchTools;

public interface FileMapper {

	List<LocalFile> selectFileByName(SearchTools tool);
	
	void insertAFile(LocalFile file);
}
