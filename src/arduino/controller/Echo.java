package arduino.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import NorthBears.model.MemberDAO;


public class Echo implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String echo = request.getParameter("echo");
		
		System.out.println("echo :"+echo);
		
		MemberDAO dao = new MemberDAO();
		String id=null;
		String nextView=null;
		String ctx=request.getContextPath();
		id=dao.RfidFind(echo);
		
		
		System.out.println("id : "+id);
		
		if(id!=null){
			
			response.getWriter().print("/"+id+" Welcome/");
			
		}
		
		
		
		return nextView;
	}

}
