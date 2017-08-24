 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="UTF-8">
    
    <jsp:include page="/WEB-INF/views/system/common.jsp"></jsp:include>
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
	            <div title="基本信息" style="padding:20px;display:none;">
	            <div class="contentWrapper">
	               <div class="form-item">
	               <input type="hidden" id="news_id" value="${type.id }">
                        <label for="" class="label-top">标&emsp;&emsp;题：</label>
                        <input id="typetitle" class="easyui-validatebox easyui-textbox" 
                               data-options="required:true,validType:'length[0,30]'" style="width: 90%;" value="${type.title }">
                    
                    </div>
                    <br>
                    
                     <br>
                    <c:if test="${type.enabled == null  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="type_enabled" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="type_enabled" style="width: 90%;">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                    </c:if>
                      <c:if test="${type.enabled == 1  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="type_enabled" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="type_enabled" style="width: 90%;">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                    </c:if>
                      <c:if test="${type.enabled == 0  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="type_enabled" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="type_enabled" style="width: 90%;">
                            <option value="0">否</option>
                            <option value="1">是</option>
                            
                        </select>
                    </div>
                    </c:if>
                    <br>
    </div>
    </div>
	    </div>      
   	 </div>
   	 		<div>
   	 			 <a id="type_save" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-gears'" style="height: 30px;border-left-width: 1px;margin-left: 40%;">保存</a>
   	 			 <a id="type_close" onclick="closeWin()" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-tags'" style="height: 30px;border-left-width: 1px;">取消</a>
   	 		</div>
  		
</div>
</div>
<script type="text/javascript" src="/admin/js/arain.js"></script>
<script type="text/javascript" charset="utf-8" src="/admin/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/admin/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="/admin/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
$("#type_save").click(function(){
	var array=new Array()
	array[0]="typetitle";
	var re = AM.validata(array);
	if(re == false) {
		return ;
	}
	
	var id = '${type.id }';
	var title = $("#typetitle").val();
	var enabled = $("#type_enabled").combobox('getValue');
	
	$.ajax({
		url:'${pageContent.request.contentPath}/app/type/save.do',
		data:{
			id:id,
			title:title,
			enabled:enabled,
		},
		type: 'POST',
		dataType:'json',
		success: function(data){
				if (data.status ==200) {
					$.messager.alert('消息','保存成功');
					 	$("#type_save").hide();
					 	$("#type_close").hide();
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