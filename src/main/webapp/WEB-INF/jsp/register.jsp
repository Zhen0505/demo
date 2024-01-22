<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <form id='registerform' action="/practice/register" method="POST">
			ID:<input type='text' id='id' name='id'><br> 
			PASSWOED:<input type='text' name='password'><br>
			<button type="submit" value="提交">註冊</button>
		</form>
    </body>
</html>