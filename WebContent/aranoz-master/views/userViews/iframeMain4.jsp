<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style type="text/css">
</style>

<style>
        table.table2{
                border-collapse: separate;
                border-spacing: 1px;
                text-align: left;
                line-height: 1.5;
                border-top: 1px solid #ccc;
                margin : 20px 10px;
        }
        table.table2 tr {
                 width: 50px;
                 padding: 10px;
                font-weight: bold;
                vertical-align: top;
                border-bottom: 1px solid #ccc;
        }
        table.table2 td {
                 width: 100px;
                 padding: 10px;
                 vertical-align: top;
                 border-bottom: 1px solid #ccc;
        }
 
</style>


</head>
<body>

 <form method = "get" action = "write_action.php">
        <table  style="padding-top:50px" align = center width=700 border=0 cellpadding=2 >
                <tr>
                <td height=20 align= center bgcolor=#ccc><font color=white> 글쓰기</font></td>
                </tr>
                <tr>
                <td bgcolor=white>
                <table class = "table2">
                        <tr>
                        <td>작성자</td>
                        <td><input type = text name = name size=20> </td>
                        </tr>
 
                        <tr>
                        <td>제목</td>
                        <td><input type = text name = title size=60></td>
                        </tr>
 
                        <tr>
                        <td>내용</td>
                        <td><textarea name = content cols=85 rows=15></textarea></td>
                        </tr>
 
                        <tr>
                        <td>비밀번호</td>
                        <td><input type = password name = pw size=10 maxlength=10></td>
                        </tr>
                        </table>
 
                        <center>
                        <input type = "submit" value="작성">
                        </center>
                </td>
                </tr>
        </table>
        </form>







<!-- 게시판 -->

	<!-- <div class="container">

		<div class="row">

			<form method="post" action="writeAction.jsp">

				<table class="table table-striped"

					style="text-align: center; border: 1px solid #dddddd">

					<thead>

						<tr>

							<th colspan="2"

								style="background-color: #eeeeee; text-align: center;">게시판

								글쓰기</th>

						</tr>

					</thead>

					<tbody>

						<tr>

							<td><input type="text" class="form-control" placeholder="글 제목" name="bbsTitle" maxlength="50"/></td>

						</tr>

						<tr>

							<td><textarea class="form-control" placeholder="글 내용" name="bbsContent" maxlength="2048" style="height: 350px;"></textarea></td>

						</tr>

					</tbody>

				</table>	

				<input type="submit" class="btn btn-primary pull-right" value="글쓰기" />

			</form>

		</div>

	</div>
 -->









	
	<!-- <table width = "900px" height = "550px" border = 1px>
		
		
		<tr width = "100%" height = "10%" align = "center">
			<td colspan = "6">
				<h1>Member List</h1>
			</td>
		</tr>
		

		<tr width = "100%" height = "5%">
		
			<th>회원 번호</th>
			<th>회원 아이디</th>
			<th>회원 비밀번호</th>
			<th>회원 이메일</th>
			<th>회원 보유포인트</th>
			<th>회원 단계</th>
		</tr>
				
		<tr width = "100%" height = "5%" align = center>
			<td class="number">2</td>
			<td class="tit"><a href="#">환영합니다.</a></td>
			<td class="">관리자</td>
			<td class="">2020-11-05</td>
			<td class="">12</td>
			<td class="">12</td>
		</tr>
					
		<tr width = "100%" height = "5%" align = center>
			<td>1</td>
			<td class="tit"><a href="#">공지사항</a></td>
			<td>관리자</td>
			<td>2020-11-04</td>
			<td>10</td>
			<td>10</td>
		</tr>
		
		<tr width = "100%" height = "65%">
			<td colspan = 6>
				
			</td>
		</tr>
				
		<tr width = "100%" height = "10%" align = "center">
			<td colspan = "6">
			<div class="page">
				<a href="#" class="bt">첫 페이지</a> <a href="#" class="bt">이전 페이지</a> <a
					href="#" class="num on">1</a> <a href="#" class="num">2</a> <a
					href="#" class="num">3</a> <a href="#" class="bt">다음 페이지</a> <a
					href="#" class="bt">마지막 페이지</a> <a href="userWrite.jsp"
					class="write">글쓰기</a>
			</div>
		</td>
		</tr>	
		
	</table> -->
</body>
</html>