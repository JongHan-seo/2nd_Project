package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

	//추상 메서드, 시작과 끝이 없다.{}넣으면 오히려 에러남
		//정의부만 있고, 구현부{}가 없다.
		public String requestHandler(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException ;
	
	
}
