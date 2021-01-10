<%@page import="NorthBears.model.ProgressVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%
    List<ProgressVO> list=(List<ProgressVO>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<!-- 진행사항 페이지인데
진행사항은 "내 캐릭터" 밑에 위치시킬건데.... 없애도 될것도 같아요..
우선은 그냥 둘게요 -->

<table border="1">
	<tr>
	<td name="name"></td>
	<td name="count">쓰레기통</td>
	<td name="count">에코백</td>
	<td name="count">자판기</td>
	<td name="count">총 point</td>
	</tr>
	<tr>
	<td name="trash">횟수</td>
	<td name="trashCount" align="center"><%=list.get(1)%></td>
	<td name="trashCount" align="center"><%=list.get(2)%></td>
	<td name="trashCount" align="center"><%=list.get(3)%></td>
	<td name="count" align="center"><%=list.get(0)%></td>
	</tr>



</body>
</html>