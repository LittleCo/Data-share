package com.hut.entity;

/*
 * 这是一个 mapper中的辅助实体类
 * 
 */
public class SearchTools {
    private String name;
    private int offset;
    private int limit;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public SearchTools(String name, int offset, int limit) {
		super();
		this.name = name;
		this.offset = offset;
		this.limit = limit;
	}
	@Override
	public String toString() {
		return "SearchTools [name=" + name + ", offset=" + offset + ", limit=" + limit + "]";
	}
    
}
