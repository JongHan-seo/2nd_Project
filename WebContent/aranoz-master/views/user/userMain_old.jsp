<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.*"  %>
<%@page import="NorthBears.model.*"  %>
    
<% String ctx = request.getContextPath(); 
   MemberVO vo = (MemberVO)session.getAttribute("vo");
%> 
<!DOCTYPE html>
<html class="no-js" lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>NorthBears</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="manifest" href="site.webmanifest">
    <link rel="shortcut ficon" type="image/x-icon" href="assets/img/favicon.ico">

    <!-- CSS here -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="assets/css/slicknav.css">
    <link rel="stylesheet" href="assets/css/flaticon.css">
    <link rel="stylesheet" href="assets/css/progressbar_barfiller.css">
    <link rel="stylesheet" href="assets/css/gijgo.css">
    <link rel="stylesheet" href="assets/css/animate.min.css">
    <link rel="stylesheet" href="assets/css/animated-headline.css">
    <link rel="stylesheet" href="assets/css/magnific-popup.css">
    <link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/css/themify-icons.css">
    <link rel="stylesheet" href="assets/css/slick.css">
    <link rel="stylesheet" href="assets/css/nice-select.css">
   <link rel="stylesheet" href="assets/css/style.css?20"> <!-- 배경링크: 크기설정좀 -->
</head>

<body>
    <!-- ? Preloader Start -->
    <div id="preloader-active">
        <div class="preloader d-flex align-items-center justify-content-center">
            <div class="preloader-inner position-relative">
                <div class="preloader-circle"></div>
                <div class="preloader-img pere-text">
                    <img src="assets/img/logo/loder.png" alt="">
                </div>
            </div>
        </div>
    </div>
    <!-- Preloader Start -->
    <header>
        <!-- Header Start -->
        <div class="header-area">
            <div class="main-header ">
                <div class="header-bottom  header-sticky">
                    <div class="container-fluid">
                        <div class="row align-items-center">
                            <!-- Logo -->
                            <div class="col-xl-2 col-lg-2">
                                <div class="logo">
                                    <a href="index.html"><img src="assets/img/logo/logo.png" alt=""></a>
                                </div>
                            </div>
                            <div class="col-xl-10 col-lg-10">
                                <div class="menu-wrapper  d-flex align-items-center justify-content-end">
                                    <!-- Main-menu -->
                                    <div class="main-menu d-none d-lg-block">
   <!--  메뉴바(연결해야합니다.) -->
                                <nav>
                                 <ul id="navigation">                                                                                          
                                    <li><a href="<%=ctx %>index.html">Home</a></li> <!-- 유저메인화면연결 -->
                                    <li><a href="about.html">My Info</a></li> <!-- 정보수정화면 연결 -->
                                    <li><a href="blog.html">Category</a>       <!-- 서비스목록 연결 -->
                                    <li><a href="what-do.html">Event</a></li>   <!-- 이벤트목록 연결 -->
                                    <li><a href="projects.html">Notice</a></li>   <!-- 게시판목록 연결 -->
                                    <li><a href="blog.html">Logout</a>         <!-- 로그아웃 연결 -->
                                     <!--  <ul class="submenu">
                                          <li><a href="blog.html">Blog</a></li>
                                          <li><a href="blog_details.html">Blog Details</a></li>
                                          <li><a href="elements.html">Element</a></li>
                                       </ul> -->
                                    </li>
                                    <li><a href="contact.html">Contact</a></li>
                                 </ul>
                              </nav>
         
                              </div>
                                    <!-- Header-btn -->
                                    <div class="header-right-btn d-none d-lg-block ml-20">
                                    <!--     <a href="login.jsp" class="btn header-btn">Log In</a> -->
                                    </div>
                                </div>
                            </div> 
                          
                            
                            
                            
                            <!-- Mobile Menu -->
                            <div class="col-12">
                                <div class="mobile_menu d-block d-lg-none"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Header End -->
    </header>
    <main>
         <!--  노스베어스 글씨 없앰       -->
        <!-- slider Area Start-->
         <div class="slider-area position-relative">
            <div class="slider-active dot-style">
            
            
 <table border="1">
 <tr>
 <td width="600" height="100">내 보유포인트: <%=vo.getMember_point() %> </td>
 <td rowspan="4"><img src="images/1_1800_1200.jpg"></td>
 </tr>
 
 <tr>
 <td width="600" height="100">나의 단계: <%=vo.getMember_step() %> </td>
 </tr>

 <tr>
 <td width="600" height="400" align="center">진행사항<br>
 <!-- 표삽입 -->
 </td>
 </tr>
 
 <tr>
 <td width="600" height="400" align="center">이벤트 진행사항 <br>
 <!-- 표삽입 -->
 </td>
 </tr>
  </table>
            
            
      <!--   회색바탕일듯?? -->      <!--   Single Slider -->
               <!--  <div class="single-slider hero-overly slider-height slider-bg1 d-flex align-items-center"> -->
                 <!--   <div class="container">
                        <div class="row">
                            <div class="col-xl-8 col-lg-8 col-md-8 col-sm-10">
                       <div class="hero__caption">
                                    <h1 data-animation="fadeInUp" data-delay=".2s">노스 베어스</h1>
                                   <P data-animation="fadeInUp" data-delay=".4s"><br> 나의 북극을 지켜주세요.  </P>
                                    Hero-btn
                                    <div class="hero__btn">
                                        <a href="join.jsp" class="hero-btn mb-10"  data-animation="fadeInUp" data-delay=".8s">회원 가입</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> -->
                <!-- Single Slider -->
   <!--  메인에서 동그란점 없애기   -->               <!-- <div class="single-slider hero-overly slider-height slider-bg1 d-flex align-items-center">
                    <div class="container">
                        <div class="row">
                            <div class="col-xl-8 col-lg-8 col-md-8 col-sm-10">
                                <div class="hero__caption">
                                    <h1 data-animation="fadeInUp" data-delay=".2s">North Bears</h1>
                                    <P data-animation="fadeInUp" data-delay=".4s"> <br> Save My North.</P>
                                    Hero-btn
                                     <div class="hero__btn">
                                        <a href="about.html" class="hero-btn mb-10"  data-animation="fadeInUp" data-delay=".8s">About Us</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> -->
    </main>
  
     <footer>
        <div class="footer-wrapper">
           <!-- Footer Start -->
           <div class="footer-area footer-padding">
               <div class="container ">
                   <div class="row justify-content-between">
                       <div class="col-xl-4 col-lg-3 col-md-8 col-sm-8">
                           <div class="single-footer-caption mb-50">
                               <div class="single-footer-caption mb-30">
                                   <!-- logo -->
                                   <div class="footer-logo mb-35">
                                       <a href="index.html" style="font-size:30px"><img src="assets/img/logo/logo2_footer.png" alt="" float="left">North Bears</a>
                                   </div>
                                   <div class="footer-tittle">
                                       <div class="footer-pera">
                                          <p>Zero Waste Eco Life<br> 생활 속 작은 실천으로 환경을 생각합니다.</p>
                                      <!--     메뉴선택버튼 -->
                                          
                                       </div>
                                   </div>
                                  <!--   social -->
                                   <div class="footer-social">
                                       <a href="https://twitter.com"><i class="fab fa-twitter"></i></a>
                                       <a href="https://facebook.com"><i class="fab fa-facebook-f"></i></a>
                                       <a href="https://smhrd.or.kr/"><i class="fab fa-pinterest-p"></i></a>
                                   </div> 
                                 </div>
                           </div>
                       </div>
                       <div class="col-xl-3 col-lg-4 col-md-6 col-sm-4">
                           <div class="single-footer-caption mb-50">
                               <div class="footer-tittle">
                                   <h4>Contact us</h4>
                                   <ul>
                                       <li><a href="https://smhrd.or.kr/">광주광역시 남구 송암로60</a></li>
                                       <li><a href="https://smhrd.or.kr/">광주CGI센터 2층</a></li>
                                       <li><a href="https://smhrd.or.kr/">스마트미디어인재개발원</a></li>
                                       <li class="number"><a href="https://smhrd.or.kr/">(82) 062-655-3510</a></li>
                                   </ul>
                               </div>
                           </div>
                       </div>
                   </div>
               </div>
           </div>
          
        <!--  footer-bottom area -->
           <div class="footer-bottom-area">
               <div class="container">
                   <div class="footer-border">
                       <div class="row d-flex align-items-center">
                           <div class="col-xl-12 ">
                               <div class="footer-copy-right text-center">
                                   <p>Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0.
                                      Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This service is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://smhrd.or.kr/" target="_blank">아두겐</a>
                                      Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0.</p>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
            <!--   Footer End -->
          </div>
      </footer>
     

    <!-- JS here -->

    <script src="./assets/js/vendor/modernizr-3.5.0.min.js"></script>
    <!-- Jquery, Popper, Bootstrap -->
    <script src="./assets/js/vendor/jquery-1.12.4.min.js"></script>
    <script src="./assets/js/popper.min.js"></script>
    <script src="./assets/js/bootstrap.min.js"></script>
    <!-- Jquery Mobile Menu -->
    <script src="./assets/js/jquery.slicknav.min.js"></script>

    <!-- Jquery Slick , Owl-Carousel Plugins -->
    <script src="./assets/js/owl.carousel.min.js"></script>
    <script src="./assets/js/slick.min.js"></script>
    <!-- One Page, Animated-HeadLin -->
    <script src="./assets/js/wow.min.js"></script>
    <script src="./assets/js/animated.headline.js"></script>
    <script src="./assets/js/jquery.magnific-popup.js"></script>

    <!-- Date Picker -->
    <script src="./assets/js/gijgo.min.js"></script>
    <!-- Nice-select, sticky -->
    <script src="./assets/js/jquery.nice-select.min.js"></script>
    <script src="./assets/js/jquery.sticky.js"></script>
    <!-- Progress -->
    <script src="./assets/js/jquery.barfiller.js"></script>
    
    <!-- counter , waypoint,Hover Direction -->
    <script src="./assets/js/jquery.counterup.min.js"></script>
    <script src="./assets/js/waypoints.min.js"></script>
    <script src="./assets/js/jquery.countdown.min.js"></script>
    <script src="./assets/js/hover-direction-snake.min.js"></script>

    <!-- contact js -->
    <script src="./assets/js/contact.js"></script>
    <script src="./assets/js/jquery.form.js"></script>
    <script src="./assets/js/jquery.validate.min.js"></script>
    <script src="./assets/js/mail-script.js"></script>
    <script src="./assets/js/jquery.ajaxchimp.min.js"></script>
    
    <!-- Jquery Plugins, main Jquery -->   
    <script src="./assets/js/plugins.js"></script>
    <script src="./assets/js/main.js"></script>
    
</body>
</html>