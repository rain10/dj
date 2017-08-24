<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<!--easyui-->
		<script src="/admin/easyui/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="/admin/easyui/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="/admin/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
		<script src="/admin/easyui/jquery.cookie.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="/admin/error/lib/layer/2.4/layer.js"></script>
		<!--字体图标-->
		<link rel="stylesheet" type="text/css" href="/admin/easyui/themes/icons/css/font-awesome.min.css" />
		<!--皮肤-->
		<link id="theme" rel="stylesheet" type="text/css" href="/admin/easyui/themes/gray/easyui.css" />
		<link  id="easyuiTheme" rel="stylesheet" type="text/css" href="/admin/css/dark.css" />

		<script src="/admin/js/super.js" type="text/javascript" charset="utf-8"></script>
		<style>
		.spanstyle:hover {
			color:#3498db;
			cursor:pointer;
		}
		
		.divStyle{
        line-height: 28px;
        text-align: center;
        font-size: 12px;
    	}
	    .divStyle:hover {
	        background-color: #c7c7cc;
	        cursor: pointer;
	    }
		</style>
	</head>

	<body id="main" class="easyui-layout">
		<div data-options="region:'north',border:false" class="super-north" style="height: 50px;">
			<!--顶部-->
			<div class="super-navigation">
				<div class="super-navigation-title">Party building</div>
				<div class="super-navigation-main">
					<div class="super-setting-left">
						<ul>
							<li id="send_do"><i class="fa fa-commenting-o" style="display:inline-block;line-height:50px;padding:0;width:70%;float:left"></i><span id="send_msg" style="line-height:16px;margin-top:10px;display:inline-block;width:30%;float:left;background-color: #E33A33;border-radius: 50%;color: white;" ></span></li>
<!-- 							<li><i class="fa fa-envelope-o"></i></li> -->
<!-- 							<li><i class="fa fa-bell-o"></i></li> -->
								<a href="javascript:void(0)" style="color:#fff;width: 120px;" id="mb" class="easyui-menubutton"
           									data-options="menu:'#quickmm',noline:true,iconCls:'fa fa-star-o'">快捷菜单</a>
						</ul>
						
						<div id="quickmm" class="easyui-menu">
<%-- 								<c:forEach items="${quick }" var="qic"> --%>
<%-- 									<a class="spanstyle" style="width:20px;float: right;line-height:28px" onclick="delete_quick(${qic.id })">×</a> --%>
<%-- 									<div  onclick="open_tab(this.id)"  id="${qic.id }">${qic.name }</div> --%>
<!-- 									<div class="menu-sep"></div> -->
<%-- 								</c:forEach>	 --%>
							</div>
					</div>
							
								
					<div class="super-setting-right">
						<ul>
							<li class="user">
								<span class="user-icon" id="head"><img src="${userInfo.prphone }"/></span>
								${userInfo.realname }
							</li>
							<li>
								<div class="super-setting-icon">
									<i class="fa fa-gears"></i>
								</div>
								<div id="mm" class="easyui-menu">
									<div id="themeSetting">主题</div>
									<div id="personal">修改密码</div>
									<div class="menu-sep"></div>
									<div id="logout">退出</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		
		<div id="easyui-layout-west" data-options="region:'west',title:'MAIN NAVIGATION',border:false">
			<!--左侧导航-->
			<div class="easyui-accordion" data-options="border:false,fit:true,selected:true">
				<c:forEach items="${menu }" var="menu">
				<div title="${menu.name }" id="${menu.id }" data-options="iconCls:'${menu.icon }'">
					<ul id="ul">
						<c:forEach items="${menu.children }" var="child">
							<li class="li" id="${child.id }"  data-url='${child.target }' onmouseover ="mouseUp(this.id)">${child.name }</li>
						</c:forEach>
					</ul>
				</div>
				</c:forEach>
			</div>
		</div>
		<div data-options="region:'center'" style="padding-top: 2px;" id="tabs">
			<!--主要内容-->
			<div id="tt" class="easyui-tabs" data-options="border:false,fit:true">
				<div title="首页" data-options="iconCls:'fa fa-home'">
					<iframe src="${pageContent.request.contentPath }/system/index_statistics" width="100%" height="99%" frameborder="no">
					</iframe>
				</div>
			</div>
		</div>
		<div data-options="region:'south'" class="super-south">
			<!--页脚-->
			<div class="super-footer-info">
				<span><i class="fa fa-info-circle"></i> 关于我们：Arain&nbsp;&nbsp;</span>
				<span id="nowTime" style="margin:0 auto;padding-left: 40%;"><i class="fa fa-copyright"></i></span>
				<span><i class="fa fa-copyright"></i> CopyRight 2017版权所有 <i class="fa fa-caret-right"></i></span>
			</div>
		</div>
<!-- <iframe frameborder="no" border="0" marginwidth="0" marginheight="0" width=330 height=86 src="//music.163.com/outchain/player?type=2&id=474567044&auto=1&height=66"></iframe> -->
	<div id="personwin"></div>
	<div id="headsonwin"></div>
	
	
	<span style="font-family:KaiTi_GB2312;font-size:18px;">  <!-- 这里是tabs页面的右键 -->  
	  <div id="rcmenu" class="easyui-menu" style="">  
	    <div id="closeall">关闭全部</div>  
	    <div id="closeother">关闭其他</div>
	  </div>
	  <div id="quickmenu" class="easyui-menu" >
	    <div id="savequick" style="line-height:26px"><p class="fa fa-star-o" style="padding-right:2px"></p> 加入快捷菜单</div>
	    <input type="hidden" id="quick_id">  
	  </div>
	  </span> 
	  
	  <!--主题设置弹窗-->
		<div id="themeswin">
			<div class="themeItem">
				<ul>
					<li>
						<div class="PETER-RIVER" onclick="javascript:changeTheme('blue.css')">海军蓝</div>
					</li>
					<li>
						<div class="WET-ASPHALT" onclick="javascript:changeTheme('dark.css')">特种灰</div>
					</li>
					<li>
						<div class="ALIZARIN" onclick="javascript:changeTheme('red.css')">中国红</div>
					</li>
					<li>
						<div class="EMERALD" onclick="javascript:changeTheme('green.css')">草原绿</div>
					</li>
					<li>
						<div class="CARROT" onclick="javascript:changeTheme('yellow.css')">党徽金</div>
					</li>
				</ul>
			</div>
		</div>
		
	  <div id="comonWin" style="display: none;"> 
	</body>
	<script type="text/javascript">
	setInterval("document.getElementById('nowTime').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
		 
		/*退出系统*/
	$("#logout").on('click', function() {
		$.messager.confirm('提示', '确定退出系统？', function(r) {
			if(r) {
				$.ajax({
					url:'${pageContent.request.contentPath}/system/login/logout.do',
					type: 'POST',
					dataType:'json',
					success: function(data){
							if (data.status ==200) {
								document.location.href = "${pageContent.request.contentPath}/system/login";
							}
						},
						error:function(data) {
							
							console.log(data.data);	
						}
					});
			}
		});
	});
		
	$("#personal").on('click', function() {
	     $('#personwin').window({
	            width: 255,
	            height: 300,
	            title:"修改密码",
	            href:"${pageContent.request.contentPath}/personal/user/info",
	            modal: true,
	            constrain: true,
	        });
		
	});
	
	$("#head").on('click', function() {
		 $('#headsonwin').window({
	            width: 300,
	            height: 420,
	            title:"上传头像",
	            href:"${pageContent.request.contentPath}/personal/user/head",
	            modal: true,
	            constrain: true,
	        });
	});
	
	
	$("#send_do").on('click', function() {
		 $('#comonWin').window({
	            width: 1000,
	            height: 500,
	            title:"接收推文",
	            href:"${pageContent.request.contentPath}/app/content/load_send.do",
	            modal: true,
	            constrain: true,
	        });
	});
	
	 $(function(){  
         $(".easyui-tabs").bind('contextmenu',function(e){         
        e.preventDefault();  
           $('#rcmenu').menu('show', {  
               left: e.pageX,  
               top: e.pageY  
           });  
       });  
         
       //关闭所有标签页  
       $("#closeall").bind("click",function(){  
           var tablist = $('#tt').tabs('tabs');  
           for(var i=tablist.length-1;i>=1;i--){  
               $('#tt').tabs('close',i);  
           }  
       });  
       //关闭其他页面（先关闭右侧，再关闭左侧）  
       $("#closeother").bind("click",function(){  
           var tablist = $('#tt').tabs('tabs');  
           var tab = $('#tt').tabs('getSelected');  
           var index = $('#tt').tabs('getTabIndex',tab);  
           for(var i=tablist.length-1;i>index;i--){  
               $('#tt').tabs('close',i);  
           }  
           var num = index-1;  
           if(num < 1){  
               return;  
           }else{  
               for(var i=num;i>=1;i--){  
                   $('#tt').tabs('close',i);  
               }  
               $("#tt").tabs("select", 1);  
           }  
       });  
       
       $("#savequick").bind("click",function(){  
    	   var id = $("#quick_id").val();
    		jQuery.ajax({ 
    			type: "post",
    			url: "/meun/quick_meun_check.do",
    			data:{resourceId:id},
    			dataType: "json",
    			success: function(data){
    				if(data.status == 200) {
    			    	 	jQuery.ajax({ 
    			    			type: "post",
    			    			url: "/meun/quick_meun.do",
    			    			data:{resourceId:id},
    			    			dataType: "json",
    			    			success: function(data){
    			    			if(data.status == 200) {
    			    				layer.msg("添加成功！",{icon:1,time:3000});
    			    				break_quick();
    			    			};
    			    		}
    			     })	
    			} else {
    				layer.msg(data.msg,{icon:2,time:3000});
    			}
    		}
       	})
    	 
       }) 
    	   
       
       
   	jQuery.ajax({ 
		type: "post",
		url: "/messges.do",
		dataType: "json",
		success: function(data){
			if(data.status == 200) {
					$.messager.show({
						title:'安全提醒！',
						msg:"<div style='width:320px;height:100px' >上次登录IP："+data.data.tLastIp+"<br/><br/><br/>上次登录地点： "+data.data.tLastAddress+"</div><div style='margin-top:28px;' align=\"center\">" ,
						timeout:10000,
						showType:'slide',
						width:'300px',
						height:'200px',
					});
				}
		}});
   	
	jQuery.ajax({ 
		type: "post",
		url: "/send_messges.do",
		dataType: "json",
		success: function(data){
			if(data.status == 200) {
				$('#send_msg').text(data.data.total);
				if(data.data.total!=0) {
					var msg = "您有"+data.data.total+"条消息待处理，请及时处理"
					sound(msg);
				}
			}
		}});
	
	
	jQuery.ajax({ 
		type: "post",
		url: "/meun/load_quick_meun.do",
		dataType: "json",
		success: function(data){
			if(data.status == 200) {
				var div = $('#quickmm');
				for(var i =0;i<data.data.length;i++) {
					var a = $("<a class=\"spanstyle\" style=\"width:20px;float: right;line-height:28px\" onclick=\"delete_quick("+data.data[i].id+")\">×</a>");
					var b = $("<div class=\"divStyle\" onclick='open_tab("+data.data[i].id+")' id="+data.data[i].id+">"+data.data[i].name+"</div>");
 					var c = $("<div class=\"menu-sep\"></div>");
 					
 					div.append(a);
 					div.append(b);
 					div.append(c);
				}
				console.log(data);
				$.parser.parse(div)
			}
		}});
   });
	 
	 
	 function send_change() {
		 jQuery.ajax({ 
				type: "post",
				url: "/send_messges.do",
				dataType: "json",
				success: function(data){
					if(data.status == 200) {
						$('#send_msg').text(data.data.total);
					}
				}});
	}
	 
	 
	 function addWin(url,witdth,height) {
		 if(witdth==null) {
			 witdth=850;
		 }
		 if(height==null) {
			 height=650;
		 }
		 
		 $('#comonWin').window({
          width: witdth,
          height: height,
          title:"新增",
          href:"${pageContent.request.contentPath}"+url,
          modal: true,
          constrain: true,
      });
	}
	 
	 
	 
	 function editWin(id,url,witdth,height) {
		 if(witdth==null) {
			 witdth=850;
		 }
		 if(height==null) {
			 height=650;
		 }
		 console.log(id+url);
		 var data = $("#"+id).datagrid('getSelected');
			if(data == null) {
				$.messager.alert('消息','没有选中行！');
				return;
			}
			
	        $('#comonWin').window({
	            width: witdth,
	            height: height,
	            title:"编辑",
	            href:"${pageContent.request.contentPath}"+url+"?id="+data.ID_,
	            modal: true,
	            constrain: true,
	        });
	}
	 
	 function refresh(id) {
		  	$('#'+id).datagrid('reload'); 
	}
	 
	 function closeWin(id) {
		 $("#comonWin").dialog('close');
		 refresh(id);
	}
	 
	 changeTheme = function(type){  
		    var $easyuiTheme = $('#easyuiTheme');  
// 		    var theme = $('#theme');
// 		    var url = $easyuiTheme.attr('href');  
		    var theme_url = $easyuiTheme.attr('href');  
// 		    console.info(theme_url);  
// 		    var href = url.substring(0, url.indexOf('easyui'))+ 'easyui/themes/' + type + '/easyui.css';
		    var href_theme = theme_url.substring(0, theme_url.indexOf('css'))+ 'css/'+type;
// 		    console.info(href_theme);  
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
		    $.cookie('easyuiThemeName', type, {  
		        expires : 7  
		    });  
		};  
		
		if ($.cookie('easyuiThemeName')) {
			changeTheme($.cookie('easyuiThemeName'));
		} else {
			changeTheme('dark.css');
		}
		
		
	
		  function sound(str){  
			  console.log()
			   //var request=  new URLRequest();
		        var url = "http://tts.baidu.com/text2audio?lan=zh&ie=UTF-8&text=" + encodeURI(str);        // baidu
		              //url = "http://translate.google.cn/translate_tts?ie=UTF-8&tl=zh-CN&total=1&idx=0&textlen=19&prev=input&q=" + encodeURI(str); // google
		            
		　　         //request.url = encodeURI(url);
		            // request.contentType = "audio/mp3"; // for baidu
		            //request.contentType = "audio/mpeg"; // for google

		        　　var n = new Audio(url);

		       　　 n.src = url;

		       　　 n.play();
		        　　
		       　　 // $("...").play();
		        　　// var sound = new Sound(request);
		        　　// sound.play()
          }  

		function mouseUp(data) {
			  $(".li").mouseover('contextmenu',function(e){   
			        e.preventDefault();  
			           $('#quickmenu').menu('show', {  
			               left: e.pageX+40,  
			               top: e.pageY 
			           });  
			       }); 
			$("#quick_id").val(data);
		}
		
		function open_tab(data) {
			var li = $(".li");
			for(var i=0;i<li.length;i++) {
				if(li[i].id==data) {
					$('#'+data).click();
				}
			}
		}
		
		function  delete_quick(data) {
			jQuery.ajax({ 
    			type: "post",
    			url: "/meun/delete_quick_meun.do",
    			data:{resourceId:data},
    			dataType: "json",
    			success: function(data){
    			if(data.status == 200) {
    				layer.msg("删除成功！",{icon:1,time:3000});
    				break_quick();
    			};
    		}
     })	
		}
		
		function break_quick() {
			jQuery.ajax({ 
				type: "post",
				url: "/meun/load_quick_meun.do",
				dataType: "json",
				success: function(data){
					var div = $('#quickmm');
					if(data.status == 200) {
						div.empty();
						for(var i =0;i<data.data.length;i++) {
							var a = $("<a class=\"spanstyle\" style=\"width:20px;float: right;line-height:28px\" onclick=\"delete_quick("+data.data[i].id+")\">×</a>");
							var b = $("<div class=\"divStyle\" onclick='open_tab("+data.data[i].id+")' id="+data.data[i].id+">"+data.data[i].name+"</div>");
		 					var c = $("<div class=\"menu-sep\"></div>");
		 					
		 					div.append(a);
		 					div.append(b);
		 					div.append(c);
						}
						console.log(data);
						$.parser.parse(div)
					}else {
						div.empty();
					}
				}});
		}
	</script>

</html>
