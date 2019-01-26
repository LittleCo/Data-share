package com.hut.entity;

import org.springframework.stereotype.Repository;

@Repository("LocalFile")
public class LocalFile {
   private int id;
   private String name;
   private String path;
   private long size;
  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	
	public LocalFile(int id, String name, String path, long size) {
		super();
		this.id = id;
		this.name = name;
		this.path = path;
		this.size = size;
	}
	public LocalFile(String name, String path, long size) {
		super();
		this.name = name;
		this.path = path;
		this.size = size;
	}
	public LocalFile( ) {
		super();
	}
	@Override
	public String toString() {
		return "File [id=" + id + ", filename=" + name + ", path=" + path +",size= "+size+"]";
	}
	   
   
}
