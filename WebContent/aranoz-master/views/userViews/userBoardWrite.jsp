<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.*"  %>
<%@page import="NorthBears.model.*"  %>
<% String ctx = request.getContextPath(); 
   MemberVO vo = (MemberVO)session.getAttribute("vo");   
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<!-- 게시판 작성화면 -->
<form action="<%=ctx %>/boardwrite.do" method="POST">
	<table border="1">
		<tr>
			<td>작성자</td>
			<td>내용</td>			
		</tr>	
		<tr>
			<td><%=vo.getMember_name() %></td>
			<td>
				<textarea name="content" row ="20" cols="50" width="390px" height="500px" placeholder="글을 입력해주세요."/></textarea>
			</td>			
		</tr>
		<tr>
			<td>
			<input type="submit" value="확인">
			</td>
			<td>			
			<input type="button" value="취소" onclick="location.href='<%=ctx%>/userboard.do'">
			</td>
		</tr>
	</table>
</form>
</body>
</html>