<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>servlet asyne support</title>
</head>
<body>
<div id="msgFormPush"></div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" ></script>
<script type="text/javascript">
    deferred();//页面打开就向后台发送请求

    function deferred() {
        $.get('deferr',function (data) {
           console.log(data);//控制台输出服务端推送数据
           deferred();//一次请求完成后再向后台发送数据
        });
    }
</script>


</html>