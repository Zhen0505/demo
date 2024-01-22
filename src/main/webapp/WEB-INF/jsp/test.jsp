<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
    </head>
    <body>
        Hello world
        ${message}
        <form id='testform' action="/example/confirm" method="POST">
			For Run in JSP: ${message}<br> 
			<input type='hidden' name='num'>
			<input type='hidden' id='act' name='act' value='add'> 
			ID:<input type='text' id='id' name='id'><br> 
			NAME:<input type='text' name='name'><br>
			<button type="submit" value="提交">送出</button>
		</form>
    </body>
</html>