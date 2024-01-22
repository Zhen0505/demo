<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
    </head>
    <body>
    	Hello world
    	
    	<h2>${result}</h2>
    	<form id='testform' action="/example/test" method="POST">
    	<button type="submit" value="提交">新增送出</button>
    	</form>
    	<br>
    	<h2>${update}</h2>
    	<form id='testform' action="/example/test" method="POST">
    	<button type="submit" value="提交">修改送出</button>
    	</form>
    	<br>
    	<h2>${delete}</h2>
    	<form id='testform' action="/example/test" method="POST">
    	<button type="submit" value="提交">刪除送出</button>
    	</form>
    </body>
</html>