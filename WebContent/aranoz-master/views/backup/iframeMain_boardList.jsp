<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.util.*"  %>
<%@page import="NorthBears.model.*"%>
    
<% String ctx = request.getContextPath(); 
   MemberVO vo = (MemberVO)session.getAttribute("vo");
   List<BoardVO> list=(List<BoardVO>)request.getAttribute("boardlist");
%> 
	
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style type="text/css">
/* ............ */

</style>

</head>
<body>





	
	<table width = "900px" height = "550px" border = 1px>
		
		
		<tr width = "100%" height = "10%" align = "center">
			<td colspan = "5">
				<h1>게시글 목록</h1>
			</td>
		</tr>
		

		<tr width = "100%" height = "5%">
		
			<td>게시판번호</td>
			<td>작성내용</td>
			<td>작성자</td>
			<td>작성날짜</td>	
		</tr>
				
		
						<%
				for(BoardVO bvo:list){
							%>
				<tr width = "100%" height = "5%" align = center>
					<td><a href="<%=ctx%>/boardcontent.do?no=<%=bvo.getBoard_no()%>"><%=bvo.getBoard_no() %></a></td>
					<td><%=bvo.getBoard_name() %></td>
					<td><%=bvo.getBoard_content() %></td>
					<td><%=bvo.getBoard_date() %></td>		
				</tr>
					<%
				}
			%>
		
		<tr width = "100%" height = "65%">
			<td colspan = 5>
				
			</td>
		</tr>
				
		<tr width = "100%" height = "10%" align = "center">
			<td colspan = "5">
			<div class="page">
				<a href="#" class="bt">첫 페이지</a> <a href="#" class="bt">이전 페이지</a> <a
					href="#" class="num on">1</a> <a href="#" class="num">2</a> <a
					href="#" class="num">3</a> <a href="#" class="bt">다음 페이지</a> <a
					href="#" class="bt">마지막 페이지</a> 
					<a href="/boardwriteform.do" class="write">글쓰기</a>
			</div>
		</td>
		</tr>	
		
	</table>
</body>
</html>