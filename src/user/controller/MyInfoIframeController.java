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

public class MyInfoIframeController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nextView=null;
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("vo");
		
		NBUserDAO dao = new NBUserDAO();
		
		
		
		List<MemberVO> list =dao.memberContentList(vo.getMember_no());
		
		request.setAttribute("memberlist", list);
			
		
		nextView="userViews/iframeMain_userinfo";
		
		
		return nextView;
	}

}
