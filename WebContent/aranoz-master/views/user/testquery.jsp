<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<% String ctx=null; %>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type = "text/javascript">
	function deleteFn(num){
		location.href="<%=ctx%>/delete.do?num="+num;
		
	}
</head>
<body>
<input type="button" value="�۾���" onclick="location.href='<%=ctx%>/list.do'"></tr>
<input type="button" value="����" onclick="deleteFn(<%=vo.getNum() %>)">

</body>
</html>