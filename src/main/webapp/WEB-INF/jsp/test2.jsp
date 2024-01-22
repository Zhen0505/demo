<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
function loadtestlist() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      var dataList = JSON.parse(this.responseText);
	      var tableHTML = '<h2>內容</h2><table border="1" style="width: 100px;text-align: center;"><tr><th>ID</th><th>Name</th></tr>';
	      
	      dataList.forEach(function(data) {
	        tableHTML += '<tr><td>' + data.id + '</td><td>' + data.name + '</td></tr>';
	      });
	      
	      tableHTML += '</table>';
	      document.getElementById("demo").innerHTML = tableHTML;
	    }
	  };
	  xhttp.open("GET", "/api/test/testlist", true);
	  xhttp.send();
}

function deleteRecord() {
    // 获取输入框中的 ID
    var id = document.getElementById('id').value;

    // 确保 ID 不为空
    if (id.trim() !== '') {
        // 构造删除页面的 URL，假设删除页面路径为 "/example/delete"
        var deleteUrl = "/example/delete?id=" + encodeURIComponent(id);

        // 执行页面跳转
        window.location.href = deleteUrl;
    } else {
        // 提示用户输入 ID
        alert('请输入要删除的记录的 ID。');
    }
}
</script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        Hello world
        ${message}
        
        
        <form id='testform' action="/example/create" method="POST">
			For Run in JSP: ${message}<br> 
			ID:<input type='text' id='id' name='id'><br> 
			NAME:<input type='text' name='name'><br>
			<button type="submit" value="提交">新增</button>
			<button type="button" onclick="deleteRecord()">Delete</button>
		</form>
	<hr/>
	
	<form id='updateform' action="/example/update" method="POST">
			For Run in JSP: ${message}<br> 
			ID:<input type='text' id='id' name='id'><br> 
			NAME:<input type='text' name='name'><br>
			<button type="submit" value="提交">編輯</button>
		</form>
	<hr/>
	
	<div id="demo">
	<h2>測試字串</h2>
 		<button type="button" onclick="loadtestlist()">顯示內容</button>
	</div>
    </body>
</html>