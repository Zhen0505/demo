<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
    </head>
    <body>
    	${message}
    	${id}:${name}
    	<form id='testform' action="/example/result" method="POST">
		For Run in JSP: ${message}<br> 
		<input type='hidden' name='id' value='${id}'>
		<input type='hidden' name='name' value='${name}'> 
		<button type="submit" value="確認">新增確認</button>
	    </form>
	    <br>
	    ${id}:${name}
	    <form id='testform' action="/example/update" method="POST">
		For Run in JSP: ${message}<br> 
		<input type='hidden' name='uid' value='${id}'>
		<input type='hidden' name='uname' value='${name}'> 
		<button type="submit" value="確認">修改確認</button>
	    </form>
	    <br>
	    ${id}:${name}
	    <form id='testform' action="/example/delete" method="POST">
		For Run in JSP: ${message}<br> 
		<input type='hidden' name='did' value='${id}'>
		<input type='hidden' name='dname' value='${name}'> 
		<button type="submit" value="確認">刪除確認</button>
	    </form>
    </body>
</html>