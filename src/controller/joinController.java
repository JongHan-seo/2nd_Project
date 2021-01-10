package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NorthBears.model.MemberVO;
import NorthBears.model.NorthBearsDAO;

@WebServlet("/joinController")
public class joinController implements Controller  {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String nextView=null;
		
		
		request.setCharacterEncoding("EUC-KR");
		String member_name = request.getParameter("name");
		String member_id = request.getParameter("id");
		String member_email = request.getParameter("email");
		String member_pw = request.getParameter("pass");
		String member_rpw = request.getParameter("re_pass");
		System.out.println("name : "+member_name);
		System.out.println("id : "+member_id);
		System.out.println("email : "+member_email);
		System.out.println("pass : "+member_pw);
		

		if(member_pw.equals(member_rpw)) {
		NorthBearsDAO dao = new NorthBearsDAO();
		
		MemberVO vo = new MemberVO();

		int cnt = dao.join(member_id, member_pw, member_name, member_email);
		int cnt2 = dao.progressjoin(member_id);
		
		
		System.out.println("cnt2 : "+cnt2);
		if (cnt > 0) {
			System.out.println("회원가입성공");
			nextView="main/main";
		} else {
			System.out.println("회원가입실패");
			nextView="main/join";
		}

		}else {
			System.out.println("회원가입실패");
			nextView="main/join";
		}
	
		
		
		return nextView;
	}

}

		
	