<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
        
    </head>
    
    <body>
		 你好！${name}<br>
		 你的帳戶名：${id}<br>
		 你的帳戶餘額：${money}元<br>
    	<form id='testform' action="/api/example/exam" method="POST">
		${message}<br> 
		<input type='hidden' name='id' value='${id}'>
		<input type='hidden' name='name' value='${name}'> 
		<input type='hidden' name='money' value='${money}'> 
		<button type="submit" value="確認">轉帳</button>
	    </form>
    </body>
</html>