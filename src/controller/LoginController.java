package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import NorthBears.model.ManagerVO;
import NorthBears.model.MemberVO;
import NorthBears.model.NBManagerDAO;
import NorthBears.model.NBUserDAO;
import NorthBears.model.NorthBearsDAO;
@WebServlet("/LoginController")
public class LoginController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nextView=null;
		
		
		String id=request.getParameter("your_name");
		String pw=request.getParameter("your_pass");
		String ctx = request.getContextPath();
		
		
		HttpSession session=request.getSession();
				
		
		NorthBearsDAO nbDao=new NorthBearsDAO();
		NBUserDAO dao=new NBUserDAO();
		
		String manager_no=nbDao.ManagerLogin(id, pw);
		System.out.println(manager_no);
		
		if(manager_no==null) {
			String member_no=nbDao.memberLogin(id, pw);
			System.out.println("성공함?");
			
			if(member_no==null) {
				System.out.print("회원로그인실패");
						
				nextView="main/loginform";
			}else if(member_no!=null) {
				MemberVO vo=dao.memberContent(member_no);
				System.out.print("회원로그인성공");
				session.setAttribute("vo", vo);

				nextView="/userViews/userMain";
				
				
			}
			
		}else if(manager_no!=null) {
			System.out.print("관리자로그인성공");
			ManagerVO mvo=new ManagerVO(manager_no);
			session.setAttribute("manager_no", manager_no);
			request.setAttribute("mvo", mvo);
			RequestDispatcher rd=request.getRequestDispatcher("managerViews/managerMain.jsp");
			rd.forward(request, response); 
		}
		
		
		
		
		
		
		
		
		
		
		return nextView;
	}

}




