package user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import NorthBears.model.BoardVO;
import NorthBears.model.MemberVO;
import NorthBears.model.NBUserDAO;
import controller.Controller;

public class UserBoardContentController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String nextView=null;
		
		NBUserDAO dao = new NBUserDAO();
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("vo");
		
		String board_no=request.getParameter("no");
		List<BoardVO> list =dao.myBoardContent(vo,board_no);
				
		
		request.setAttribute("boardlist", list);
		request.setAttribute("boardno", board_no);
				
		
		nextView="userViews/userBoardContent";		
		
		return nextView;
		
		
	}

}
