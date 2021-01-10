package user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import NorthBears.model.MemberVO;
import NorthBears.model.NBManagerDAO;
import NorthBears.model.NBUserDAO;
import NorthBears.model.NoticeVO;
import controller.Controller;

public class UserUpdateController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		  request.setCharacterEncoding("EUC-KR");
		 
		  HttpSession session = request.getSession();
		  MemberVO svo = (MemberVO)session.getAttribute("vo");
		  String ctx = request.getContextPath();
		
		
	      
	      String member_name = request.getParameter("Member_name");
	      String member_pw = request.getParameter("Member_pw");
	      String member_email = request.getParameter("Member_email");
	
	      
	      System.out.println("pw : "+member_pw);
	      System.out.println("name : "+member_name);
	      System.out.println("no : "+svo.getMember_no());
	      
	      
	      MemberVO vo = new MemberVO(); // new는 객체생성, 디폴트 생성자
	      vo.setMember_no(svo.getMember_no());
	      vo.setMember_name(member_name);
	      vo.setMember_pw(member_pw);
	      vo.setMember_email(member_email);

	      
		NBManagerDAO dao = new NBManagerDAO();
		int cnt = dao.UserInfoUpdate(vo);
		System.out.println("cnt : "+cnt);
		String nextView=null;
		if(cnt>0) {
			//가입 성공후 어떤 페이지로 가면 되나요?
			nextView="redirect:"+ctx+"/userinfoiframe.do"; //mvc1/list.do
			
		}else {
			throw new ServletException("Error");
			
		}
		
		
		
		return nextView;
	}

}
