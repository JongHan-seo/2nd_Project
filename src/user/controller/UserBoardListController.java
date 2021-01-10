package user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NorthBears.model.BoardVO;
import NorthBears.model.NBUserDAO;
import controller.Controller;

public class UserBoardListController implements Controller {


	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextView=null;
		
		NBUserDAO dao = new NBUserDAO();
		List<BoardVO> list =dao.BoardGetAllList();
		
		request.setAttribute("boardlist", list);
		
				
		
		nextView="userViews/iframeMain_boardList";		
		
		return nextView;
		
		
		
		
	}

}
