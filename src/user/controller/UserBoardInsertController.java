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

public class UserBoardInsertController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("vo");
		String content = request.getParameter("content");
		String subject = request.getParameter("subject");
		String sort = null;
//		sort=request.getParameter("sort");
		
		/*
		 * if(sort.equals("질문")) {
		 * 
		 * sort="qna";
		 * 
		 * }else if(sort.equals("건의사항")) {
		 * 
		 * sort="suggestion"; }
		 */
		//추가로 해결하기 전까지 고정
		sort="suggestion";
		
		
		
		String nextView=null;
		
		NBUserDAO dao = new NBUserDAO();
		
		int cnt = dao.BoardWrite(vo, content,subject,sort);
		
		if(cnt>0) {
			System.out.println("게시판 글쓰기 완료");			
		}
		else {
			System.out.println("게시판 글쓰기 실패");
			
		}
		
		List<BoardVO> list =dao.BoardGetAllList();
		
		request.setAttribute("boardlist", list);
		
		//nextView="userViews/userBoard";
		nextView="redirect:/userboard.do";
		
		return nextView;
	}

}
