 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<jsp:include page="/WEB-INF/views/system/common.jsp"></jsp:include>

<body style="margin: 0px;background:url(/admin/css/image/warn.jpg) no-repeat">
</body>
<script>
$(function () {
	function login() {
		window.location.href = "${pageContent.request.contentPath}/system/login";
	}
	layer.msg("登录超时！！",{icon:2,time:2000});
	setTimeout(login,2000);
	
})



</script>
</html>
