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

<!-- ������� �������ε�
��������� "�� ĳ����" �ؿ� ��ġ��ų�ǵ�.... ���ֵ� �ɰ͵� ���ƿ�..
�켱�� �׳� �ѰԿ� -->

<table border="1">
	<tr>
	<td name="name"></td>
	<td name="count">��������</td>
	<td name="count">���ڹ�</td>
	<td name="count">���Ǳ�</td>
	<td name="count">�� point</td>
	</tr>
	<tr>
	<td name="trash">Ƚ��</td>
	<td name="trashCount" align="center"><%=list.get(1)%></td>
	<td name="trashCount" align="center"><%=list.get(2)%></td>
	<td name="trashCount" align="center"><%=list.get(3)%></td>
	<td name="count" align="center"><%=list.get(0)%></td>
	</tr>



</body>
</html>