<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.*"  %>
<%@page import="NorthBears.model.*"  %>
    
<% String ctx = request.getContextPath(); 
   MemberVO vo = (MemberVO)session.getAttribute("vo");
   List<BoardVO> list=(List<BoardVO>)request.getAttribute("boardlist");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type = "text/javascript">
	
</script>
</head>
<body>
<table border="1">

		<tr>
			<td>�Խ��ǹ�ȣ</td>
			<td>�ۼ���</td>
			<td>�ۼ�����</td>
			
			<td>�ۼ���¥</td>		
		</tr>


<%
	for(BoardVO bvo:list){
				%>
		<tr>
		<td><a href="<%=ctx%>/boardcontent.do?no=<%=bvo.getBoard_no()%>"><%=bvo.getBoard_no() %></a></td>
		<td><%=vo.getMember_name() %></td>
		<td><%=bvo.getBoard_content() %></td>
		<td><%=bvo.getBoard_date() %></td>		
	</tr>
		<%
	}
%>
<tr><td colspan="4">
<input type="button" value="�۾���" onclick="location.href='<%=ctx%>/boardwriteform.do'">
<input type="button" value="���" onclick="location.href='<%=ctx%>/userboard.do'">
</td>

</tr>
</table>

</body>
</html>