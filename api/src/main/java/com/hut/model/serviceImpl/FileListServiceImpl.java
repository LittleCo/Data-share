package com.hut.model.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hut.entity.LocalFile;
import com.hut.entity.SearchTools;
import com.hut.model.daoImpl.FileSelectorImpl;
import com.hut.model.service.IFileListService;
import com.hut.utils.Json;
import com.hut.utils.RandomString;

@Service("FileListService")
public class FileListServiceImpl implements IFileListService{
  
   private final int limit = 5;
   @Autowired
   private FileSelectorImpl fileSelect;
   public void setFileSelect(FileSelectorImpl fileSelect) {
		this.fileSelect = fileSelect;
	}
   @Autowired
   private RandomString randomString; 
   public void setRandomString(RandomString randomString) {
	this.randomString = randomString;
    }
   

public String selectFileByName(String name, int offset){
	   
	    SearchTools tool = new SearchTools(name,  offset,limit);
	    List fileList = fileSelect.selectFileByName(tool); 
		
	    Json<Map> json = new Json();
	    json.addElements("data", fileList);
	    json.addElements("code", 200);
	    return json.toString();
   }
   
   public void downloadFileByPath(File file, OutputStream out){
	   /*
	    * 文件下载
	    */
	   try{
         
		 InputStream in = new FileInputStream(file);
		 
		 byte[] bytes = new byte[10];
		 
		 while((in.read(bytes))!=-1){
			 out.write(bytes);
			 out.flush();
		 }
     	   in.close();
		   out.close();
	   }catch(IOException e){
		   e.printStackTrace();
	   }
	   
   };
   
	public String uploadFile(List<FileItem> items,String path){
	/*
	 *  文件上传
	 */
	 try{
		    
        Iterator<FileItem> iter = items.iterator();
        while(iter.hasNext()){
        	FileItem item = iter.next();
        	String itemName = item.getFieldName();
        	int sno = -1;
			String sname = null;
			String fileOldName;
			String fileNewName;
			
			if(item.isFormField()){
				if(itemName.equals("sno")){
					sno = Integer.parseInt(item.getString());
				}
				else if(itemName.equals("sname")){
					sname = item.getString();
				}
			}else{
			
				fileOldName = item.getName();
				String ext = fileOldName.substring(fileOldName.indexOf('.'));
			 //上传文件出错   401
				if(!ext.equals(".txt")||ext.equals(".docx")
						||ext.equals(".doc")||ext.equals(".ppt")
						||ext.equals(".pptx")||ext.equals(".xls")
						||ext.equals(".xlsx")
					 ){
					return "401";
				}
				else{
		     ////正确上传    200
					fileNewName = randomString.getRandomString(10)+ext;
					File file = new File(path, fileNewName);
					
					item.write(file);
					System.out.println(file.length());
					insertAFile(file.length(), fileOldName, fileNewName);
					return "400";
				}
			}	
        }
		
	 }catch (InterruptedException e) {
			   e.printStackTrace();
	 }catch (FileUploadException e){
			  e.printStackTrace();
	 }catch (Exception e) {
			  e.printStackTrace();
}
	              return "405";
}
	
	private void insertAFile(long size, String name, String path){
		LocalFile file = new LocalFile(name, path, size);
		fileSelect.insertAFile(file);
	}
	
}
