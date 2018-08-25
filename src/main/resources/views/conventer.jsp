<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div id="resp"></div>
<input type="button" onclick="req();" value="请求"/>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" ></script>
<script>
function req() {
    $.ajax({
        url:"convert",
        data:"1-shichong",
        type:"POST",
        contentType:"application/x-wisely",
        success:function (data) {
            $("#resp").html(data);
        }
    })
}</script>


</html>