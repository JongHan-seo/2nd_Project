package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NorthBears.model.MemberVO;
import NorthBears.model.NBUserDAO;
import controller.Controller;

public class MemberIdConfirm implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8"); //받을때
		response.setCharacterEncoding("UTF-8"); //내보낼때
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		System.out.println("id확인 : "+id);
		
		MemberVO vo = new MemberVO();
		
		NBUserDAO dao = new NBUserDAO();
		
		vo.setMember_id(id);
		
		String resultid=dao.IdConfirm(vo);
		
		System.out.println("resultid : "+resultid);
		
		if(resultid!=null) {
			out.print("1");
		}
		else {
			out.print("2");
		}
		
		
		
		
		return null;
	}

}
