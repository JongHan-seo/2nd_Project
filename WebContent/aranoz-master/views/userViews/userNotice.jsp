<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.*"  %>
<%@page import="NorthBears.model.*"  %>
    
<% String ctx = request.getContextPath(); 
   MemberVO vo = (MemberVO)session.getAttribute("vo");
   List<NoticeVO> list=(List<NoticeVO>)request.getAttribute("noticelist");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1">

		<tr>
			<td>������ȣ</td>
			<td>�ۼ�����</td>
			<td>�ۼ���</td>
			<td>�ۼ���¥</td>		
		</tr>


<%
	for(NoticeVO nvo:list){
				%>
		<tr>
		<td><%=nvo.getNotice_no() %></td>
		<td><%=nvo.getNotice_content() %></td>
		<td><%=nvo.getNotice_name() %></td>
		<td><%=nvo.getNotice_date() %></td>		
	</tr>
		<%
	}
%>
</table>

</body>
</html>