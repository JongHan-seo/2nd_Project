package frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;


//Mapping web.xml에 추가함.
public class MemberFrontController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String reqUrl = request.getRequestURI();
		
		String ctx = request.getContextPath();
		
		String command = reqUrl.substring(ctx.length());
		
		Controller controller=null;
		String nextView=null;
		
		HandlerMapping mappings = new HandlerMapping();
		controller = mappings.getController(command);
		System.out.println(command);
		
		nextView = controller.requestHandler(request,response);
		
		
		if(nextView!=null) {
			
			if(nextView.indexOf("redirect:")!=-1) {
				response.sendRedirect(nextView.split(":")[1]);	
				
				
				
			}else if(nextView.indexOf("dispatcher:")!=-1) {
				
				RequestDispatcher rd = request.getRequestDispatcher(nextView.split(":")[1]);				
				rd.forward(request, response);		
				System.out.println("dispatcher 함수 통과");
			}
			else {				
				RequestDispatcher rd = request.getRequestDispatcher("/aranoz-master/views/"+nextView+".jsp");				
				rd.forward(request, response);
				
			}
			
			
			
		}
		
		
	}

}
