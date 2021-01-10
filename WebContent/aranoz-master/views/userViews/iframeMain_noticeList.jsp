<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.util.*"  %>
<%@page import="NorthBears.model.*"  %>
    
<% String ctx = request.getContextPath(); 
   MemberVO vo = (MemberVO)session.getAttribute("vo");
   List<NoticeVO> ntlist=(List<NoticeVO>)request.getAttribute("noticelist");
%> 
	
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
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
	
	#write{
		margin-right : 70px;
	
	
	}

</style>

</head>
<body>





	
	<table width = "900px" height = "550px" border = 1px id="write" class="table table-hover">
		
		
		<tr width = "100%" height = "10%" align = "center" bgcolor="#EAEAEA">
			<td colspan = "5">
				<h1>공지사항</h1>
			</td>
		</tr>
		

		<tr width = "100%" height = "5%" align="center" bgcolor="#FFFFE4">
		
			<td>공지번호</td>
			<td>작성내용</td>			
			<td>작성자</td>
			<td>작성날짜</td>	
		</tr>
				
		
						<%
				for(NoticeVO ntvo:ntlist){
							%>
				<tr width = "100%" height = "5%" align = "center">
					<td><%=ntvo.getNotice_no() %></td>
					<td><%=ntvo.getNotice_content() %></td>
					<td>admin</td>
					<td><%=ntvo.getNotice_date() %></td>
				</tr>
					<%
				}
			%>
			
			<tr>
				<td colspan="4">
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>					

				</td>
			</tr>
			
		
		
			
		
				
		
	</table>
	
	
	
	
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