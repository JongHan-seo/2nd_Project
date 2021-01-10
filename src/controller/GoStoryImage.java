package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import NorthBears.model.BoardVO;
import NorthBears.model.EventVO;
import NorthBears.model.MemberVO;
import NorthBears.model.NBUserDAO;
import NorthBears.model.ProgressVO;

public class GoStoryImage implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextView=null;
		String imageStep = null;
		String videoStep = null;
		NBUserDAO dao = new NBUserDAO();
		
		HttpSession session=request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("vo");
		
		//1.�̹��� �Ѱܾ��� , 2.������� ǥ �Ѱܾ���, 3.Event�Ѱܾ���.
		imageStep=dao.GetImage(vo);
			
		
		//2.������� ǥ
		ProgressVO pvo = new ProgressVO();
		pvo=dao.Progress(vo);
		
		//3.Event �������
		List<EventVO> evolist = dao.eventGetAllList(vo);
		
		//4.video
		videoStep=dao.GetVideo(vo);
		
		
		
		
		
		//1.�̹����ѱ��, 2.�������, 3.Event�������
		request.setAttribute("imageStep", imageStep);
		request.setAttribute("videoStep", videoStep);
		request.setAttribute("pvo", pvo);
		request.setAttribute("evolist", evolist);
		
		
		
		System.out.println("imageStep : "+imageStep);
		System.out.println("videoStep : "+videoStep);
		nextView="userViews/iframeMain_userMain";
				
		return nextView;
	}

}
