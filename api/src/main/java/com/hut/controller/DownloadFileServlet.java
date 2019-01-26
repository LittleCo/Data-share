package com.hut.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hut.model.serviceImpl.FileListServiceImpl;

/**
 * Servlet implementation class DownloadFileServlet
 */
public class DownloadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileListServiceImpl FLService;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ApplicationContext app =
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		FLService = (FileListServiceImpl)app.getBean("FileListService");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
	
	    String filePath = request.getParameter("path");
	    String fileName = request.getParameter("filename");
		ServletOutputStream out = response.getOutputStream();
		File file = new File(request.getSession().getServletContext().getRealPath("")+"upload//"+filePath);
	    
		if(file.exists()){
		    
			response.addHeader("content-Type", "application/octet-stream");
			response.addHeader("content-Disposition", "attachement;filename="+fileName);
			 
		    FLService.downloadFileByPath(file, out);
		}
		else{
			System.out.println("文件未找到,path"+ file.getAbsolutePath());
		    response.sendRedirect("static/fileNotFound.html");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
