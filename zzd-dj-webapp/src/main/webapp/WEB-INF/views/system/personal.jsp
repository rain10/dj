 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="/WEB-INF/views/system/common.jsp"></jsp:include>
<head>
    <meta charset="UTF-8">
    
    
    <style type="text/css">
        #index {
            padding: 15px;
            display: flex;
            justify-content: space-between;
            flex-wrap: wrap;
            opacity: 0;
            font-size: 12px;
        }
        .index-l {
            padding: 10px;
            width: 48%;
            overflow: auto;
        }
    </style>
</head>

<body>
<div id="index">
    <div class="contentWrapper">
          	<!--tab-->
	    <div class="index-l">
	        <div id="tt" class="easyui-tabs" data-options="tabHeight:31" style="width:100%;">
	            <div title="" style="padding:20px;display:none;">
	            <div class="contentWrapper">
	             
                     <div class="form-item" style="width: 100%">
                        <label for="" class="label-top">&nbsp;&nbsp;&nbsp;&nbsp;原密码：</label>
                        <input id="oldpassword" class="easyui-passwordbox" prompt="Password" 
                               data-options="required:true" style="width: 60%;" >
                    
                    </div>
                    <br/>
                      <div class="form-item" style="width: 100%">
                        <label for="" class="label-top">&nbsp;&nbsp;&nbsp;&nbsp;新密码：</label>
                        <input id="newpassword" class="easyui-passwordbox" prompt="Password" 
                               data-options="required:true" style="width: 60%;" >
                    
                    </div>
                    <br/>
                      <div class="form-item" style="width: 100%">
                        <label for="" class="label-top">&nbsp;确定密码：</label>
                        <input id="surepassword" class="easyui-passwordbox" prompt="Password" 
                               data-options="required:true" style="width: 60%;" >
                    
                    </div>
                  
                  
                    
                    </div>
                    </div>
	    </div>      
   	 </div>
   	 		<div style="margin-top: 10px">
   	 			 <a id="persave" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-gears'" style="border-left-width: 1px;margin-left: 23%;">保存</a>
   	 			 <a id="perclose" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-tags'" style="border-left-width: 1px;">取消</a>
   	 		</div>
  		
</div>
</div>

<script type="text/javascript">

  $("#perclose").click(function(){
	$("#personwin").dialog('close')
	});
	
$("#persave").click(function(){
	var oldpassword = $("#oldpassword").val();
	var newpassword = $("#newpassword").val();
	var surepassword = $("#surepassword").val();
	if($.trim(oldpassword) == '' || $.trim(newpassword) == '' || $.trim(surepassword) == '') {
		return;
	}
	if($.trim(newpassword) !=  $.trim(surepassword)) {
		$.messager.alert('消息','两次密码不一样！');
		return;
	}
	
	$.ajax({
		url:'${pageContent.request.contentPath}/personal/user/password.do',
		data:{
			oldpassword:oldpassword,
			newpassword:newpassword
		},
		type: 'POST',
		dataType:'json',
		success: function(data){
				if (data.status ==200) {
					$.messager.alert('消息','保存成功');
					 	$("#persave").hide();
					 	$("#perclose").hide();
					 	$.ajax({
					 		url:'${pageContent.request.contentPath}/system/login/logout.do',
					 		type: 'POST',
							dataType:'json',
							success: function(data){
								if (data.status ==200) {
									document.location.href = "${pageContent.request.contentPath}/system/login";
								}
							}
					 	})
				} else if(data.status ==203) {
					$.messager.alert('消息',data.msg);
				}
			},
			error:function(data) {
				
				console.log(data.data);	
			}
		})
	});

   </script>
</body>

</html>