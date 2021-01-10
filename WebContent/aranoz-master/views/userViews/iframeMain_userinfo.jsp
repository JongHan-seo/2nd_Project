<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.util.*"  %>
<%@page import="NorthBears.model.*"  %>
    
<% String ctx = request.getContextPath(); 
   MemberVO vo = (MemberVO)session.getAttribute("vo");
   List<MemberVO> list=(List<MemberVO>)request.getAttribute("memberlist");
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





	<form action="/memberupdate.do" method="post">
	<table width = "700px" height = "550px" border = 1px class="table table-hover" id="myinfo">
		
		
		
		

		<tr width = "100%" height = "5%" align = center bgcolor="#FFD8D8">
		
			<td col span="3"><strong><h4><%=vo.getMember_id()%>의 MyInfo</strong></h4></td>
			
		</tr>
				
						<%
				for(MemberVO mvo:list){
							%>
				<tr width = "100%" height = "5%" align = center>
					<td bgcolor="#EAEAEA">ID</td>
					<td><%=mvo.getMember_id() %></td>							
				</tr>
				<tr width = "100%" height = "5%" align = center>
					<td bgcolor="#EAEAEA">PW</td>
					<td><input name ="Member_pw" value="<%=mvo.getMember_pw() %>"></td>							
				</tr>
				<tr width = "100%" height = "5%" align = center>
					<td bgcolor="#EAEAEA">이름</td>
					<td><input name ="Member_name"value ="<%=mvo.getMember_name() %>"></td>							
				</tr>
				<tr width = "100%" height = "5%" align = center>
					<td bgcolor="#EAEAEA">email</td>
					<td><input name = "Member_email"value="<%=mvo.getMember_email() %>"></td>							
				</tr>
				<tr width = "100%" height = "5%" align = center>
					<td bgcolor="#EAEAEA">point</td>
					<td><%=mvo.getMember_point() %></td>							
				</tr>
				<tr width = "100%" height = "5%" align = center>
					<td bgcolor="#EAEAEA">Story단계</td>
					<td><%=mvo.getMember_step() %></td>							
				</tr>
				<tr width = "100%" height = "5%" align = center>
					<td bgcolor="#EAEAEA">RF번호</td>
					<td><%=mvo.getMember_rf() %></td>							
				</tr>
					<%
				}
			%>
	</table>
	<div align="right" id="write">
	<input type="submit" name = "update" value="정보수정">
	</div>
		
	
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