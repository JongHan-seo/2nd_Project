<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.util.*"  %>
<%@page import="NorthBears.model.*"%>
    
<% 
   MemberVO vo = (MemberVO)session.getAttribute("vo");
   
%> 



<!DOCTYPE html>

<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>NorthBears</title>
   <!--  <link rel="icon" href="img/favicon.png"> ·Î°í »ðÀÔ-->
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
	
	#sendmsg{
		margin-right : 100px;
	}

</style>

</head>
<body>














 <div id="colorlib-main">
			<div class="hero-wrap hero-wrap-2 js-fullheight"
				style="background-image: url(images/bg_4.jpg);"
				data-stellar-background-ratio="0.5">
				<div class="overlay">

					<div class="board_list_wrap">
						<form action="/boardwrite.do">
							<div class="form-group">							
							</div>							
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Subject" name="subject" width="500px">
							</div>
							<div class="form-group">
								<textarea name="content" cols="20" rows="10" class="form-control"
									placeholder="Message"></textarea>
							</div>
							<div class="form-group" id="sendmsg" align="right">
								<input type="submit" value="Send Message"
									class="btn btn-primary py-3 px-5">
							</div>
							
						</form>

					</div>
					<!-- /. PAGE INNER  -->
				</div>
			<!-- 	/. PAGE WRAPPER  -->
			</div>

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