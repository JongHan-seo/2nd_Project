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

<!-- �Խ��� �ۼ�ȭ�� -->
<form action="<%=ctx %>/boardwrite.do" method="POST">
	<table border="1">
		<tr>
			<td>�ۼ���</td>
			<td>����</td>			
		</tr>	
		<tr>
			<td><%=vo.getMember_name() %></td>
			<td>
				<textarea name="content" row ="20" cols="50" width="390px" height="500px" placeholder="���� �Է����ּ���."/></textarea>
			</td>			
		</tr>
		<tr>
			<td>
			<input type="submit" value="Ȯ��">
			</td>
			<td>			
			<input type="button" value="���" onclick="location.href='<%=ctx%>/userboard.do'">
			</td>
		</tr>
	</table>
</form>
</body>
</html>