<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
    歡迎:${lid}<br>
    您的餘額是:${price}
            <form action="/example/result" method="POST">
                <input type='hidden' id='lid' name='lid' value= "${lid}" >
                <input type='hidden' name='lpassword' value="${lpractice}"> 
            </form>
    </body>
</html>