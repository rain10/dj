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
	    <div class="index-l" >
	             
                     <div class="form-item" >
                       <span style="width: 98%;height:290px;padding:1% 1%;display: block;" class="user-icon" id="head"><img id="img" style="width: 100%;height: 98%;" src="${sysUser.prphone }"/></span>
                    </div>
                    
                     <div class="form-item">
                        <label for="" class="label-top" style="padding-left:5px">头像选择：</label>
                        <input name="image"  id="image" class="easyui-filebox"  data-options="buttonText:'上传头像',buttonIcon:'fa fa-upload'">
                    </div>
	    	
   	 </div>
   	 		<div style=" padding-top: 10px;">
   	 			 <a id="headsave" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-gears'" style="height: 30px;border-left-width: 1px;margin-left: 85px;">保存</a>
   	 			 <a id="headclose" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-tags'" style="height: 30px;border-left-width: 1px;">取消</a>
   	 		</div>
  		
</div>
</div>
<script type="text/javascript" src="/admin/js/ajaxfileupload.js"></script>
<script type="text/javascript">
	function change() {
		 alert("xxx")
	}
	
  $("#headclose").click(function(){
	$("#headsonwin").dialog('close')
	});
	
  $("#headsave").click(function(){
	  var image_id= $("input[name='image']").attr("id");
	  console.log(name)
	  $.ajaxFileUpload({
		 	url:'${pageContent.request.contentPath}/images/upload', 
			fileElementId:image_id,
			secureuri:false,
			dataType:'json',
			type:'post',
			
			success:function(data){
				if(data.code == 0) {
					$("#img").attr("src",data.url);
					$.messager.alert('消息',data.message);
				} else if (data.code == 1) {
					$.messager.alert('消息',data.message);
				}
			}
	  });
  })
   </script>
</body>

</html>