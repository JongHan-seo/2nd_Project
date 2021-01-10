package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NorthBears.model.NBUserDAO;

@WebServlet("/UserDeleteController")
public class UserDeleteController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String member_no = request.getParameter("member_no");
		NBUserDAO dao = new NBUserDAO();

		int cnt = dao.userDelete(member_no);

		if (cnt > 0) {
			response.sendRedirect("/WEB-INF/views/main/main.jsp");
		} else {
			throw new ServletException("error");
		}

	}
}