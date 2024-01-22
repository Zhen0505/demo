<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
        
        <style>
	        .button-container {
	            text-align: center; /* 居中对齐 */
	            margin-top: 20px; /* 设置按钮之间的垂直间距 */
	        }
	
	        .button-container button {
	            margin-bottom: 10px; /* 设置按钮之间的垂直间距 */
	        }
        </style>
        
        <style>
	        .form-container {
	            text-align: center; /* 居中对齐 */
	        }
	
	        .form-container input {
	            width: 200px; /* 设置输入框的宽度 */
	            margin-bottom: 10px; /* 设置输入框之间的垂直间距 */
	        }
    	</style>
    </head>
    <body>
    	<div class="form-container">
    	<div class="button-container">
        <form id='testform1' action="/api/example/exresult" method="POST">
		${message}<br> 
		<input type='hidden' name='num'>
		<input type='hidden' id='act' name='act' value='add'> 
		ID:<input type='text' id='id' name='id'><br> 
		NAME:<input type='text' name='name'><br>
		<button type="submit" value="提交">註冊</button>
		</form>
		</div>
    	</div>
        
		
    </body>
</html>