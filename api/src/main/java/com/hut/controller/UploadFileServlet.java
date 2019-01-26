package com.hut.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hut.model.serviceImpl.FileListServiceImpl;
import com.hut.utils.Json;

/**
 * Servlet implementation class UploadFileServlet
 */
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileListServiceImpl FLService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFileServlet() {
        super();
     
    }
      @Override
    public void init() throws ServletException {
    	super.init();
      // TODO Auto-generated constructor stub	super.init();
    	ApplicationContext app =
    		   WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
    	       FLService = (FileListServiceImpl)app.getBean("FileListService");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
	
		if(isMultipart){

			try{
				DiskFileItemFactory factory = new DiskFileItemFactory();
		    	//配置设置上传文件时 用到的临时文件的大小DiskFileItemFactory
		    	factory.setSizeThreshold(10240);//设置临时缓冲文件大小，缓冲区是为了让cpu不需等待比较慢的IO操作
		        factory.setRepository(new File("respository","cacheResposity"));
		       ///最大文件空间设置 upload.setSizeMax(20480);
				 ServletFileUpload upload = new ServletFileUpload(factory);
				 List<FileItem> items = upload.parseRequest(request);
				 String path = request.getSession().getServletContext().getRealPath("upload");
				 
				 String status = FLService.uploadFile(items, path);
			 	 Json json = new Json();
			 	 String result = json.addElements("code", status);
			 	 response.getWriter().write(result);
			 	 
			}catch (FileUploadException e) {
			 	 e.printStackTrace();
			}
    }
 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
