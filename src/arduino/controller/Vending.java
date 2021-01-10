package arduino.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NorthBears.model.MemberDAO;
import controller.Controller;

public class Vending implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String vending = request.getParameter("vending");
		
		System.out.println("vending :"+vending);
		
		MemberDAO dao = new MemberDAO();
		String id=null;
		String nextView=null;
		String ctx=request.getContextPath();
		id=dao.RfidFind(vending);
		
		
		System.out.println("id : "+id);
		
		if(id!=null){
			
			response.getWriter().print("/"+id+" Welcome/");
			
		}
		
		
		
		
		
		return null;
	}

}
