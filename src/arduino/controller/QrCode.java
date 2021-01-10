package arduino.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NorthBears.model.MemberDAO;
import controller.Controller;

public class QrCode implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String qr = request.getParameter("qr");
		
		System.out.println("qr :"+qr);
		
		MemberDAO dao = new MemberDAO();
		String id=null;
		
		
		
		
		if(qr!="167130187180"){
			
			//id=dao.passConfirm(address, pass);
			id="sweetykr";
			
			
			response.getWriter().print("/"+id+" Welcome/");
			
			
		}
		
		
		
		
		
		return null;
	}

}
