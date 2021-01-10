package user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NorthBears.model.BoardVO;
import NorthBears.model.NBUserDAO;
import controller.Controller;

public class UserBoardInsertFormController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		String nextView=null;
		
				
		
		nextView="userViews/iframeMain_boardWrite";		
		
		return nextView;
		
		
	}

}
