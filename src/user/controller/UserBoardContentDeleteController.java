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

public class UserBoardContentDeleteController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	

		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("vo");

		String boardno=request.getParameter("boardno");
		String nextView=null;
		
		NBUserDAO dao = new NBUserDAO();
		
		int cnt= dao.BoardDelete(vo, boardno);
		
		
		if(cnt>0) {
			System.out.println("글삭제 완료");			
		}
		else {
			System.out.println("글쓰기 실패");
			
		}
		
		//List<BoardVO> list =dao.BoardGetAllList();
		
		//request.setAttribute("boardlist", list);
		
		//nextView="userViews/userBoard";
		nextView="redirect:/userboard.do";
		
		return nextView;
	}

}
