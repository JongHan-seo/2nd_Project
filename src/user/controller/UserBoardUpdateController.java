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

public class UserBoardUpdateController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nextView=null;
		request.setCharacterEncoding("EUC-KR");
		NBUserDAO dao = new NBUserDAO();
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("vo");
		BoardVO bvo = new BoardVO();
		String content = request.getParameter("content");
		String board_no = request.getParameter("boardno");
		
		int cnt =dao.myBoardUpdate(content,board_no,vo.getMember_no());
		
		System.out.println("content확인 : "+content);
		System.out.println("board_no확인 : "+board_no);
		
		List<BoardVO> list =dao.myBoardContent(vo,board_no);
		request.setAttribute("boardlist", list);
		
				
		
		nextView="redirect:/userboard.do";		
		
		return nextView;
	}

}
