package user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import NorthBears.model.NBUserDAO;
import NorthBears.model.ProgressVO;
@WebServlet("/UserMyProgressController")
public class UserMyProgressController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//진행사항보기

		
		NBUserDAO dao=new NBUserDAO();
		HttpSession session=request.getSession();
		String member_no=(String)session.getAttribute("member_no");
		
		String sum=dao.progressSum(member_no);
		System.out.println(sum);
		System.out.println("여기까지는 완료");
		int cnt=dao.progressUpdate(member_no);
		System.out.println(cnt);
		System.out.println("여기는?");
		
		if(cnt>0) {
			List<ProgressVO> list=dao.progressGetList(member_no);
			request.setAttribute("list", list);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/userViews/userProgress.jsp");
			rd.forward(request, response);
			//	response.sendRedirect("/WEB-INF/views/userViews/userProgress.jsp");
		
		}else {
			throw new ServletException("error");
		}
	
	}

}
