<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
            function showTestForm() {
                var idValue = "${id}";

                if (idValue && idValue.trim() !== '') {
                    document.getElementById('testform').style.display = 'block';
                } else {
                    document.getElementById('testform').style.display = 'none';
                }
                var idValue = "${uid}";

                if (idValue && idValue.trim() !== '') {
                    document.getElementById('updateform').style.display = 'block';
                } else {
                    document.getElementById('updateform').style.display = 'none';
                }
            }
        </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body onload="showTestForm()">
        <div id="testform" style="display: none;">
            <h2>新增 ID:${id}、NAME:${name} </h2>
            <form action="/example/result" method="POST">
                <input type='hidden' id='id' name='id' value= "${id}" >
                <input type='hidden' name='name' value="${name}"> 
                <button type="submit" value="提交">確認新增</button>
            </form>
        </div>
		<div id="updateform" style="display: none;">
		<h2>編輯 ID:${uid}、NAME:${uname} </h2>
        <form id='updateform' action="/example/result2" method="POST">
        <input type='hidden' id='id' name='id' value= "${uid}" >
		<input type='hidden' name='name' value="${uname}"> 
			<button type="submit" value="提交">確認編輯</button>
		</form>
		</div>
    </body>
</html>