<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% String ctx=request.getContextPath();
	System.out.println(ctx);
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>North Bears Join Form</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="/css/style.css">
    
    <style type="text/css">
    
    	#check{
    		position : absolute;
    		right : 54%;
    		bottom : 58%;
    		
    		z-index : 100;
    	
    	}
    	#checkresult{
    		position : absolute;
    		bottom : 54%;
    		z-index : 101;
    	}
    
    
    </style>
    
    
    
</head>
<body>
    <div class="main">

        <!-- Sign up form -->
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Join Us</h2>
                        <form action="<%=ctx %>/memberinsert.do" method="POST" class="register-form" id="register-form">
                            
                            <div class="form-group">
                                <label for="id"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="id" id="id" placeholder="Your Id"/>  
                               	                        
                            </div>                            
                            <div id = "check"><input type ="button" id = "dbcheck" value="중복확인"></div>
                            <div id = "checkresult"></div>  
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="pass" id="pass" placeholder="Password"/>
                            </div>
                            <div class="form-group">
                                <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                                <input type="password" name="re_pass" id="re_pass" placeholder="Repeat your password"/>
                            </div>
                            <div class="form-group">
                               <div id="success"></div>
							   <div id="danger"></div>
                            </div>                   
                            
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="name" id="name" placeholder="Your Name"/>
                            </div>                            
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <input type="email" name="email" id="email" placeholder="Your Email"/>
                            </div>
                            <div class="form-group">
                                <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                                <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                            </div>
                            <span class="form-group form-button">
                                <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
                            </span>     
                            <span>  </span>
                            <span class="form-group form-button">
                                <input type="reset" name="cancle" id="cancle" class="form-submit" value="Cancle"/>
                            </span>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="/images/signup-image.jpg" alt="sing up image"></figure>                        
                        <a href="main.jsp" class="signup-image-link">I am already member</a>
                    </div>
                </div>
            </div>
        </section>

        

    </div>

    <!-- JS -->    
    <script src=/aranoz-master/js/jquery-3.5.1.min.js></script>

	<script type="text/javascript">
	$('#dbcheck').on('click',function(){

		$.ajax({

		url:"<%=ctx%>/memberidconfirm.do",
		type : "post",

		data : 'id='+$('#id').val(),

		success : function(result){

		//funcion()내에 result는 반환되는 값이 온다.

		if(result==2){
			$('#checkresult').html("사용 가능한 id입니다.").css('color','limegreen') 
			
		}else{

			$('#checkresult').html("중복된 id입니다.").css('color','tomato')

			}

		}

		});

		});
		
		
		 $(function(){
			
			 $("input").keyup(function(){
				var pw1=$("#pass").val();
				var pw2=$("#re_pass").val();
				
				console.log(pw1);
				console.log(pw2);
				
				if(pw1!=""||pw2!=""){
					
					if(pw1==pw2){
						$('#success').html("패스워드 확인 완료").css('color','limegreen');
						$('#danger').hide();
						$('#success').show();
						$("#submit").removeAttr("disabled");
					}
					else{
						$('#danger').html("패스워드를 확인해주세요.").css('color','red');
						$('#success').hide();
						$('#danger').show();
						$("#submit").attr("disabled","disabled");
						
					}
					
					
				}
				 
				 
			 });
		 });
		 
		 
		
	
		
	
	
	
	
	</script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
