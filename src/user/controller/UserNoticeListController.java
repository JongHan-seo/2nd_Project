package user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NorthBears.model.NBUserDAO;
import NorthBears.model.NoticeVO;
import controller.Controller;

public class UserNoticeListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nextView=null;
		
		NBUserDAO dao = new NBUserDAO();
		List<NoticeVO> list =dao.noticeGetAllList();
		
		request.setAttribute("noticelist", list);
		
		
				
		
		nextView="userViews/iframeMain_noticeList";		
		
		return nextView;
	}

}
