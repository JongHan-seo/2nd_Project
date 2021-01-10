package arduino.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NorthBears.model.MemberDAO;
import controller.Controller;

public class TrashRfid implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String rfid = request.getParameter("rfid");
		
		System.out.println("rfid :"+rfid);
		
		MemberDAO dao = new MemberDAO();
		String id=null;
		
		id=dao.RfidFind(rfid);
		
		
		System.out.println("id : "+id);
		
		if(id!=null){
			
			response.getWriter().print("/"+id+" Welcome/");
			
		}
		
		
		
		
		
		
		
		
		return null;
	}

}
