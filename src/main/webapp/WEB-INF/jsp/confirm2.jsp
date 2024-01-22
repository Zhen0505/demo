<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <h2>刪除 ID:${id}</h2>
        <form id='id' action="/example/check" method="Post">
        <input type='hidden' id='id' name='id' value= "${id}" >
			<button type="submit" value="提交">確認刪除</button>
		</form>
    </body>
</html>