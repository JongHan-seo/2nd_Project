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
                <td height=20 align= center bgcolor=#ccc><font color=white> �۾���</font></td>
                </tr>
                <tr>
                <td bgcolor=white>
                <table class = "table2">
                        <tr>
                        <td>�ۼ���</td>
                        <td><input type = text name = name size=20> </td>
                        </tr>
 
                        <tr>
                        <td>����</td>
                        <td><input type = text name = title size=60></td>
                        </tr>
 
                        <tr>
                        <td>����</td>
                        <td><textarea name = content cols=85 rows=15></textarea></td>
                        </tr>
 
                        <tr>
                        <td>��й�ȣ</td>
                        <td><input type = password name = pw size=10 maxlength=10></td>
                        </tr>
                        </table>
 
                        <center>
                        <input type = "submit" value="�ۼ�">
                        </center>
                </td>
                </tr>
        </table>
        </form>







<!-- �Խ��� -->

	<!-- <div class="container">

		<div class="row">

			<form method="post" action="writeAction.jsp">

				<table class="table table-striped"

					style="text-align: center; border: 1px solid #dddddd">

					<thead>

						<tr>

							<th colspan="2"

								style="background-color: #eeeeee; text-align: center;">�Խ���

								�۾���</th>

						</tr>

					</thead>

					<tbody>

						<tr>

							<td><input type="text" class="form-control" placeholder="�� ����" name="bbsTitle" maxlength="50"/></td>

						</tr>

						<tr>

							<td><textarea class="form-control" placeholder="�� ����" name="bbsContent" maxlength="2048" style="height: 350px;"></textarea></td>

						</tr>

					</tbody>

				</table>	

				<input type="submit" class="btn btn-primary pull-right" value="�۾���" />

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
		
			<th>ȸ�� ��ȣ</th>
			<th>ȸ�� ���̵�</th>
			<th>ȸ�� ��й�ȣ</th>
			<th>ȸ�� �̸���</th>
			<th>ȸ�� ��������Ʈ</th>
			<th>ȸ�� �ܰ�</th>
		</tr>
				
		<tr width = "100%" height = "5%" align = center>
			<td class="number">2</td>
			<td class="tit"><a href="#">ȯ���մϴ�.</a></td>
			<td class="">������</td>
			<td class="">2020-11-05</td>
			<td class="">12</td>
			<td class="">12</td>
		</tr>
					
		<tr width = "100%" height = "5%" align = center>
			<td>1</td>
			<td class="tit"><a href="#">��������</a></td>
			<td>������</td>
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
				<a href="#" class="bt">ù ������</a> <a href="#" class="bt">���� ������</a> <a
					href="#" class="num on">1</a> <a href="#" class="num">2</a> <a
					href="#" class="num">3</a> <a href="#" class="bt">���� ������</a> <a
					href="#" class="bt">������ ������</a> <a href="userWrite.jsp"
					class="write">�۾���</a>
			</div>
		</td>
		</tr>	
		
	</table> -->
</body>
</html>