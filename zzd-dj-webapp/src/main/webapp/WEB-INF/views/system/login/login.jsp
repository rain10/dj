<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<link rel="stylesheet" type="text/css" href="/admin/login/style.css" />
<link rel="stylesheet" type="text/css" href="/admin/login/skin_/login.css" />
<script type="text/javascript" src="/admin/login/jquery.js"></script>
<script src="/admin/easyui/jquery.cookie.js" type="text/javascript" charset="utf-8"></script>
<link id="theme" rel="stylesheet" type="text/css" href="/admin/easyui/themes/gray/easyui.css" />
<link  id="easyuiTheme" rel="stylesheet" type="text/css" href="/admin/css/dark.css" />

<title>管理系统_用户登录</title>
</head>

<body>
<div id="container" class="container">
    <div id="bd">
    	<div id="main">
        	<div class="login-box">
<!--                 <div id="logo"></div> -->
<!--                 <h1></h1> -->
                <div class="input username"  id="username">
                    <label for="userName">用户名</label>
                    <span></span>
                    <input type="text" id="userName" />
                </div>
                <div class="input psw" id="psw">
                    <label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
                    <span></span>
                    <input type="password" id="password" />
                </div>
                <div class="input validate" id="validate">
                    <label for="valiDate">验证码</label>
                    <input type="text" id="valiDate" />
                    <img id="img" class="value" onclick="changeImg()" src="${pageContent.request.contentPath }/image" style=" height: 38px; padding-left: 0px;left: 206px;width: 105px; top: 0px;"/>
                </div>
                <div class="styleArea">
                	<span style="color:#F00" id="msg"></span>
                </div>
                <div id="btn" class="loginButton">
                    <input type="button" class="button" value="登录"  />
                </div>
            </div>
        </div>
    </div>
   
</div>
</body>
<script type="text/javascript">
	$(function () {
		$.ajax({
			url:'',
			
		})
	})
	var height = $(window).height() > 445 ? $(window).height() : 445;
	$("#container").height(height);
	var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
	$('#bd').css('padding-top', bdheight);
	$(window).resize(function(e) {
        var height = $(window).height() > 445 ? $(window).height() : 445;
		$("#container").height(height);
		var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
		$('#bd').css('padding-top', bdheight);
    });
	
	function changeImg() {  
	    var imgSrc = jQuery("#img");  
	    imgSrc.attr('src','${pageContent.request.contentPath }/image?rand='+Math.random());  
	}  
	
	$(document).keyup(function(event){
		  if(event.keyCode ==13){
		    $('.loginButton').trigger("click");
		  }
		});
	
	$('.loginButton').click(function(e) {
		var username = $("#userName").val();
		var password = $("#password").val();
		var valiDate = $("#valiDate").val();
		
		if($.trim(username) == '' || $.trim(password) == '') {
			$("#msg").html("用户名或密码不能为空！");
			return;
		}
		
		if($.trim(valiDate) == '') {
			$("#msg").html("验证码不能为空！");
			return;
		}
// 		console.log(username+password+valiDate);
		$.ajax({
			url:'${pageContent.request.contentPath}/system/login/login.do',
			data:{
				username:username,
				password:password,
				valiDate:valiDate
			},
			type: 'POST',
			dataType:'json',
			success: function(data){
					if (data.status ==200) {
						document.location.href = "${pageContent.request.contentPath}/container";
					} else if (data.status == 203) {
						jQuery("#img").attr('src','${pageContent.request.contentPath }/image?rand='+Math.random());  
						$("#msg").html(data.msg);
					} 
				},
				error:function(data) {
					
					console.log(data.data);	
				}
			})
		
//         document.location.href = "main.html";
    });
	
	
	changeTheme = function(type){  
	    var $easyuiTheme = $('#easyuiTheme');  
//		    var theme = $('#theme');
//		    var url = $easyuiTheme.attr('href');  
	    var theme_url = $easyuiTheme.attr('href');  
// 	    console.info(theme_url);  
//		    var href = url.substring(0, url.indexOf('easyui'))+ 'easyui/themes/' + type + '/easyui.css';
	    var href_theme = theme_url.substring(0, theme_url.indexOf('css'))+ 'css/'+type;
// 	    console.info(href_theme);  
	    $easyuiTheme.attr('href',href_theme);  
	      
	    /* 如果使用了iframe  则要添加下面这段代码、否则的话iframe中的内容不会出现样式的改变  
	    var $iframe = $('iframe');  
	    if($ifram.length > 0){  
	        for ( var i = 0; i < $iframe.length; i++) {  
	            var ifr = $iframe[i];  
	            $(ifr).contents.find('#easyuiTheme').attr('href', href);  
	              
	        }  
	    }  
	    */  
// 	    $.cookie('easyuiThemeName', type, {  
// 	        expires : 7  
// 	    });  
	};  
	
	if ($.cookie('easyuiThemeName')) {
		changeTheme($.cookie('easyuiThemeName'));
	} else {
		changeTheme('dark.css');
	}
	
</script>
</html>
    