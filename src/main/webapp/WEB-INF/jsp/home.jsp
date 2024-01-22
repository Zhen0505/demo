<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
    歡迎:${name}<br>
    您的餘額是:${price}
    <hr/>
    <form id='transferform' action="/practice/transfer" method="POST">
    		<input type='hidden' id='id' name='fromid' value= "${id}" >
    		<h2>轉帳</h2>
			對方帳號:<input type='text' name='toid'><br> 
			金額:<input type='text' name='money'><br>
			<button type="submit" value="提交">轉帳</button>
		</form>
		
    </body>
</html>