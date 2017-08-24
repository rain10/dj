 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<jsp:include page="/WEB-INF/views/system/common.jsp"></jsp:include>

<body style="margin: 0px;background:url(/admin/css/image/warn.jpg) no-repeat">
</body>
<script>
$(function () {
// 	$.messager.confirm('消息', '权限不足！', function(r){
// 		if (r){
// 			window.history.go(-1);
// 		} else {
// 			window.history.go(-1);
// 		}
// 	});
	layer.msg("权限不足！",{icon:5,time:2000});
	setTimeout("window.history.go(-1)",2000);
})



</script>
</html>
