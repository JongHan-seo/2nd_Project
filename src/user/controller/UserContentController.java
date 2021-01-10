package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import NorthBears.model.MemberVO;
import NorthBears.model.NBUserDAO;

@WebServlet("/UserContentController")
public class UserContentController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		MemberVO vo=(MemberVO)session.getAttribute("vo");

		
		NBUserDAO dao=new NBUserDAO();
		MemberVO mvo=dao.memberContent(vo.getMember_no());
		
		request.setAttribute("mvo", mvo);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/userViews/userInfo.jsp");
		rd.forward(request, response);
	}

}
