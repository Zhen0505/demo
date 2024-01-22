<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
        <script>
            function Register() {
                var registerUrl = "/practice/register";
                window.location.href = registerUrl;
            }
            function Login() {
                var loginUrl = "/practice/login";
                window.location.href = loginUrl;
            }
        </script>
    </head>
    <body>
        <form>
            <button type="button" onclick="Register()">註冊</button>
            <button type="button" onclick="Login()">登入</button>
        </form>
    </body>
</html>
