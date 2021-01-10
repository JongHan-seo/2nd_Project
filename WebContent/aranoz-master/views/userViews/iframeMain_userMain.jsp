<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.util.*"  %>
<%@page import="NorthBears.model.*"  %>
<% String ctx = request.getContextPath(); 
   MemberVO vo = (MemberVO)session.getAttribute("vo");   
   String imageStep = (String)request.getAttribute("imageStep");
   String videoStep = (String)request.getAttribute("videoStep");
   ProgressVO pvo = (ProgressVO)request.getAttribute("pvo");
   System.out.println("pvo.getCategory1() : "+pvo.getCategory1());
   List<EventVO> evolist=(List<EventVO>)request.getAttribute("evolist");
%> 
<!DOCTYPE html>
<html>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>NorthBears</title>
   <!--  <link rel="icon" href="img/favicon.png"> �ΰ� ����-->
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
	
	#totaltable{
		margin-top :10px; 
	
	}
	
	#allrights{
		margin-right : 80px;
	}
	
	#storyimage{
		margin-right : 80px;
		margin-bottom : 150px;
		}
	#storymain{
		margin-top : 20px;
	}

</style>

</head>
<body>


<div></div>
<table width = "900px" height = "500px" border = 1px class="table table-bordered" id="totaltable">
 
 <tr width = "100%" height = "10%" align = "center">
 <td width="40%" height="15%" bgcolor="#EAEAEA"><strong>��������Ʈ: <%=vo.getMember_point() %></strong></td>
 	<!-- �̹������� -->
 	
 	<td rowspan="4">
 	<div align="left" id="storymain">
 	
 		<h4><Strong>Story : <%=vo.getMember_step() %></Strong></h4>
 	
 	</div>
 		<div id="storyimage">
 			<video width="600" height="400"controls autoplay muted>
					<source src="<%=videoStep%>" type="video/mp4">
			</video>
		</div>
	</td> 
 </tr>
 
 <tr>
 <td width="40%" height="15%" align = "center" bgcolor="#EAEAEA"><strong>���� �ܰ�: <%=vo.getMember_step() %></strong></td>
 </tr>

 <tr>
 <td width="40%" height="30%" align="center" >
 	<table border="1" class="table table-hover">
 		
 		<tr><td colspan="4" align="center" bgcolor="#EAEAEA"><strong>�������</strong></tr>
 		<tr align="center">
 			<td>1.�и�����</td>
 			<td>2.���ڹ�</td>
 			<td>3.���Ǳ�</td>
 			<td>Total</td>
 		</tr>
 		<tr align="center">
 			<td><%=pvo.getCategory1() %></td>
 			<td><%=pvo.getCategory2() %></td>
 			<td><%=pvo.getCategory3() %></td>
 			<td><%=pvo.getService_sum() %></td>
 		</tr>
 	</table>
 </td>
 </tr>
 
 <tr>
 <td width="600" height="30%" align="center">
 <!-- �̺�Ʈ ǥ���� -->
 	<table border="1" class="table table-hover" align="center">
 	<tr>
 		<td colspan="4" align="center" bgcolor="#EAEAEA"><strong>�̺�Ʈ �������</strong>
 	</tr>
 	<tr align="center">
		<td>�̺�Ʈ�̸�</td>
		<td>����Ʈ</td>
		<td>Event��������</td>
		<td>Event�Ⱓ</td>		
	</tr>
 	
<%
	for(EventVO evo:evolist){
				%>
		<tr align="center">
		<td><%=evo.getEvent_name() %></td>
		<td><%=evo.getEvent_point() %></td>
		<td><%=evo.getEvent_start() %></td>
		<td><%=evo.getEvent_duration() %></td>		
	</tr>
		
		<%
	}
%>
 	
 	</table>
 </td>
 </tr>
  </table>
  
  <div align="right" id="allrights">
  <br>
  (c)2020-2020 NorthBears All Rights Reserved.
  </div>



	
	
	
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