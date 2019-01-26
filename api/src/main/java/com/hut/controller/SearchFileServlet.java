package com.hut.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hut.model.serviceImpl.FileListServiceImpl;

/**
 * @author Allen
 * a servlet about reasch file,returing json file
 */


public class SearchFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private FileListServiceImpl FLService;


	public SearchFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
     	super.init();
     	System.out.print(1);
    	ApplicationContext app 
    	            = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
    	this.FLService = (FileListServiceImpl)app.getBean("FileListService");
    	
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String Filekey = request.getParameter("Filekey");
	
	    String offset = request.getParameter("FileOffset");
	    System.out.println("offset:"+offset);
	    out.write(FLService.selectFileByName(Filekey, 
	    		                 offset==null?0:Integer.parseInt(offset)));
	    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
