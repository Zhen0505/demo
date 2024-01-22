<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
    <p>請確認轉帳資訊</p>
    <p>轉出帳號：${fromid}</p>
    <p>轉入帳號：${toid}</p>
    <p>轉帳金額：${money}</p>
    <hr/>
    <form id='check' action="/practice/check" method="POST">
    		<input type='hidden'  name='fromid' value= "${fromid}" >
    		<input type='hidden'  name='toid' value= "${toid}" >
    		<input type='hidden'  name='money' value= "${money}" >
			<button type="submit" value="提交">確認轉帳</button>
		</form>
		
    </body>
</html>