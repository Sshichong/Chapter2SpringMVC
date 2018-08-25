<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SSE demo</title>
</head>
<body>
<div id="msgFormPush"></div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" ></script>
<script type="text/javascript">
if (!!window.EventSource){//EventSource对象只有新浏览器才有，EventSource是SSE的客户端
    var source =new EventSource('push');
    s ='';
    source.addEventListener("message",function (e) { //添加SSE客户端监听，在此获得服务端推送消息
        s+=e.data+"<br/>";
        $("#msgFormPush").html(s);
    });

    source.addEventListener('open',function (e) {
        console.log("连接打开");
    },false);

    source.addEventListener('error',function (e) {
        if (EventSource.CLOSED == e.readyState){
            console.log("连接关闭");
        } else{
            console.log(e.readyState);
        }
    },false);
}else{
    console.log("你的浏览器不支持SSE");
}
</script>


</html>