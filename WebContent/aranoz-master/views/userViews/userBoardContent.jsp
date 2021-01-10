<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@page import="java.util.*"  %>
<%@page import="NorthBears.model.*"  %>
    
<% String ctx = request.getContextPath(); 
   MemberVO vo = (MemberVO)session.getAttribute("vo");
   List<BoardVO> list=(List<BoardVO>)request.getAttribute("boardlist");
   //String boardno=list.get(0).getBoard_no();
   String boardno=(String)request.getAttribute("boardno");
   System.out.println("boardno:"+boardno);
%>    
<!DOCTYPE html>
<html>

<head>
    <!-- Required meta tags -->
    <meta charset="EUC-KR">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>NorthBears</title>
   <!--  <link rel="icon" href="img/favicon.png"> 로고 삽입-->
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/aranoz-master/css/bootstrap.min.css">
    <!-- animate CSS -->
    <link rel="stylesheet" href="/aranoz-master/css/animate.css">
    <!-- owl carousel CSS -->
    <link rel="stylesheet" href="/aranoz-master/css/owl.carousel.min.css">
    <!-- font awesome CSS -->
    <link rel="stylesheet" href="/aranoz-master/css/all.css">
    <!-- flaticon CSS -->
    <link rel="stylesheet" href="/aranoz-master/css/flaticon.css">
    <link rel="stylesheet" href="/aranoz-master/css/themify-icons.css">
    <!-- font awesome CSS -->
    <link rel="stylesheet" href="/aranoz-master/css/magnific-popup.css">
    <!-- swiper CSS -->
    <link rel="stylesheet" href="/aranoz-master/css/slick.css">
    <!-- style CSS -->
    <link rel="stylesheet" href="/aranoz-master/css/style.css">

<meta charset="EUC-KR">
<title>Insert title here</title>

<style type="text/css">
	
	#tabletop{
		margin-top : 10px;
	
	
	}
	
	#bottom_menu{
		margin-right : 70px;
	
	}

</style>

</head>
<body>

<form action="<%=ctx %>/boardupdate.do?boardno=<%=boardno %>" method="POST">


<div id="tabletop"></div>


<table border="1"  class="table table-hover" align="center" >

		<tr bgcolor="#FFFFE4">
			<td>게시판번호</td>
			<td>작성내용</td>
			<td>작성자</td>
			<td>작성날짜</td>		
		</tr>


<%
	for(BoardVO bvo:list){
				%>
		<tr>
		<td><span name="boardno"><%=bvo.getBoard_no() %></span></td>
		<td><%=bvo.getBoard_name() %></td>
		<td><textarea name="content" row ="20" cols="50" width="390px" height="500px" ><%=bvo.getBoard_content()%></textarea></td>
		<td><%=bvo.getBoard_date() %></td>		
	</tr>
		<%
	}
%>
<tr><td colspan="4">
	<div align ="right" id="bottom_menu">
	<input type="submit" value="수정"> 
	<input type="button" value="취소" onclick="location.href='<%=ctx%>/userboard.do'">
	<input type="button" value="삭제" onclick="location.href='<%=ctx%>/userboarddelete.do?boardno=<%=boardno %>'">
	<input type="button" value="목록" onclick="location.href='<%=ctx%>/userboard.do'">
	</div>
</td>

</tr>
</table>
</form>






	
	 <!--::footer_part end::-->

    <!-- jquery plugins here-->
    <script src="/aranoz-master/js/jquery-1.12.1.min.js"></script>
    <!-- popper js -->
    <script src="/aranoz-master/js/popper.min.js"></script>
    <!-- bootstrap js -->
    <script src="/aranoz-master/js/bootstrap.min.js"></script>
    <!-- easing js -->
    <script src="/aranoz-master/js/jquery.magnific-popup.js"></script>
    <!-- swiper js -->
    <script src="/aranoz-master/js/swiper.min.js"></script>
    <!-- swiper js -->
    <script src="/aranoz-master/js/masonry.pkgd.js"></script>
    <!-- particles js -->
    <script src="/aranoz-master/js/owl.carousel.min.js"></script>
    <script src="/aranoz-master/js/jquery.nice-select.min.js"></script>
    <!-- slick js -->
    <script src="/aranoz-master/js/slick.min.js"></script>
    <script src="/aranoz-master/js/jquery.counterup.min.js"></script>
    <script src="/aranoz-master/js/waypoints.min.js"></script>
    <script src="/aranoz-master/js/contact.js"></script>
    <script src="/aranoz-master/js/jquery.ajaxchimp.min.js"></script>
    <script src="/aranoz-master/js/jquery.form.js"></script>
    <script src="/aranoz-master/js/jquery.validate.min.js"></script>
    <script src="/aranoz-master/js/mail-script.js"></script>
    <!-- custom js -->
    <script src="/aranoz-master/js/custom.js"></script>
	
	
	
	
	
	
</body>
</html>