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
	            <div title="字典配置" style="padding:20px;display:none;">
	            <div class="contentWrapper">
	               <div class="form-item">
                        <label for="" class="label-top">字典类型：</label>
                        <input id="type" class="easyui-validatebox easyui-textbox" 
                               data-options="required:true" style="width: 90%;" value="${dict.type }">
                    
                    </div>
                     <br>
                    <div class="form-item">
                        <label for="" class="label-top">字典名称：</label>
                        <input id="dicname" class="easyui-validatebox easyui-textbox" 
                               data-options="required:true" style="width: 90%;" value="${dict.name }">
                    
                    </div>
                     <br>
                    <div class="form-item">
                        <label for="" class="label-top">字典本值：</label>
                        <input id="dictvalue" class="easyui-validatebox easyui-textbox" 
                               data-options="required:true" style="width: 90%;" value="${dict.value }">
                    
                    </div>
                     <br>
                    <div class="form-item">
                        <label for="" class="label-top">展示的值：</label>
                        <input id="dictdisplay" class="easyui-validatebox easyui-textbox" 
                               data-options="required:true" style="width: 90%;" value="${dict.display }">
                    
                    </div>
                     <br>
                    <div class="form-item">
                        <label for="" class="label-top">字典排序：</label>
                        <input id="dictsort" class="easyui-validatebox easyui-numberbox" 
                               data-options="required:false" style="width: 90%;" value="${dict.sort }">
                    
                    </div>
                     <br>
                    <c:if test="${dict.enabled == null  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="dctenable" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="dictenabled" style="width: 90%;">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                    </c:if>
                      <c:if test="${dict.enabled == 1  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="dctenable" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="dictenable" style="width: 90%;">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                    </c:if>
                      <c:if test="${dict.enabled == 0  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="dctenable" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="dictenable" style="width: 90%;">
                            <option value="0">否</option>
                            <option value="1">是</option>
                            
                        </select>
                    </div>
                    </c:if>
                    </div>
                    </div>
	    </div>      
   	 </div>
   	 		<div>
   	 			 <a id="dictsave" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-gears'" style="height: 30px;border-left-width: 1px;margin-left: 40%;">保存</a>
   	 			 <a id="dictclose" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-tags'" style="height: 30px;border-left-width: 1px;">取消</a>
   	 		</div>
  		
</div>
</div>

<script type="text/javascript">
  $("#dictclose").click(function(){
	$("#dictWin").dialog('close')
	});
	
$("#dictsave").click(function(){
	var dicttype = $("#type").val();
	var dictname = $("#dicname").val();
	var dictvalue = $("#dictvalue").val();
	var dictdisplay = $("#dictdisplay").val();
	var dictsort = $("#dictsort").val();
	var dictenable = $("#dctenable").val();
	var savetype = "${type}";
	if(savetype == null) {
		savetype=null;
	}
	$.ajax({
		url:'${pageContent.request.contentPath}/system/dict/save.do',
		data:{
			type:dicttype,
			name:dictname,
			value:dictvalue,
			display:dictdisplay,
			sort:dictsort,
			enabled:dictenable,
			actionType:savetype,
		},
		type: 'POST',
		dataType:'json',
		success: function(data){
				if (data.status ==200) {
					$.messager.alert('消息','保存成功');
					 	$("#dictsave").hide();
					 	$("#dictclose").hide();
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