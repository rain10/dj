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
	            <div title="基础配置" style="padding:20px;display:none;">
	            <div class="contentWrapper">
	            <input type="hidden" id="reid" value="${sysResource.id }">
	                 <div class="form-item">
                        <label for="" class="label-top">资源名称：</label>
                        <input id="resoname" class="easyui-validatebox easyui-textbox" 
                               data-options="required:true" style="width: 90%;" value="${sysResource.name }">
                    
                    </div>
                     <br>
                    <div class="form-item">
                        <label for="" class="label-top">资源地址：</label>
                        <input id="target" class="easyui-validatebox easyui-textbox" 
                               data-options="required:false" style="width: 90%;" value="${sysResource.target }">
                    
                    </div>
                     <br>
                    <div class="form-item">
                        <label for="" class="label-top">所属资源：</label>
                        <input id="pid" class="easyui-combotree" style="width: 90%;height: 30px;" value="${sysResource.pid }"  data-options="editable:false,panelHeight:null" name="pid" >
                    </div>
                     <br>
                    <div class="form-item">
                        <label for="" class="label-top">资源排序：</label>
                        <input id="sort" class="easyui-validatebox easyui-textbox" 
                               data-options="required:true" style="width: 90%;" value="${sysResource.sort }">
                    
                    </div>
                     <br>
                    <c:if test="${sysResource.enabled == null }">
                    	<div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="enable" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="enabled" style="width: 90%;">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                    
                    </c:if>

 					  <c:if test="${sysResource.enabled == 1 }">
                    	<div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="enable" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="enabled" style="width: 90%;">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                    
                    </c:if>
                    
                    
                       <c:if test="${sysResource.enabled == 0 }">
                    	<div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="enable" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="enabled" style="width: 90%;">
                             <option value="0">否</option>
                            <option value="1">是</option>
                        </select>
                    </div>
                    
                    </c:if>
                     <br>
                     <div class="form-item">
                        <label for="" class="label-top">资源描述：</label>
                        <input id="author" class="easyui-validatebox easyui-textbox" 
                               data-options="required:false" style="width: 90%;" ${sysResource.author }>
                    
                    </div>
	            </div>
	            </div>
	            <div title="功能配置" style="overflow:auto;padding:20px;display:none;">
	            <c:if test="${sysResource.id  != null}">
	               	<table id="addg" class="easyui-datagrid" title="" style="width:100%;height:auto"
							data-options="
								iconCls: 'icon-edit',
								singleSelect: true,
								toolbar: '#tb',
								url: '${pageContent.request.contentPath}/system/resource/load_edit_grid.do?pid='+${sysResource.id },
								method: 'get',
								onClickRow: onClickRow
							">
							</c:if>
							
				<c:if test="${sysResource.id  == null}">
	               	<table id="addg" class="easyui-datagrid" title="" style="width:100%;height:auto" data-options="
								iconCls: 'icon-edit',
								singleSelect: true,
								toolbar: '#tb',
								url: '',
								method: 'get',
								onClickRow: onClickRow
							">
							</c:if>
		<thead>
			<tr>
				<th id="rname" data-options="field:'name',width:150,editor:{type:'textbox',options:{required:true}}">名称</th>
				<th  id="rtarget" data-options="field:'target',width:250,editor:{type:'textbox',options:{required:true}}">地址</th>
				<th id="renabled" data-options="field:'enabled',width:170,formatter:function(value,row){
							return row.enabledname;
						},
						editor:{
							type:'combobox',
							options:{
								valueField:'id',
								textField:'etext',
								method:'get',
								url:'${pageContent.request.contentPath }/system/dictionary/load_enabled.do',
								required:true
							}
						}">状态</th>
				<th id="power" data-options="field:'power',width:170,formatter:function(value,row){
							return row.pwoername;
						},
						editor:{
							type:'combobox',
							options:{
								valueField:'id',
								textField:'ptext',
								method:'get',
								url:'${pageContent.request.contentPath }/system/dictionary/load_power.do',
								required:true
							}
						}">是否授权</th>
			</tr>
		</thead>
	</table>
	
	<div id="tb" style="height:auto">
		<a href="javascript:void(0)" class="easyui-linkbutton info" onclick="append()" id="btn">新增</a>
		<a href="javascript:void(0)" class="easyui-linkbutton warning" data-options="plain:true" onclick="removeit()">删除</a>
	</div>
	
	            </div>
	        </div>
	    </div>      
   	 </div>
   	 		<div>
   	 			 <a id="rsave" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-gears'" style="height: 30px;border-left-width: 1px;margin-left: 40%;">保存</a>
   	 			 <a id="rclose" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-tags'" style="height: 30px;border-left-width: 1px;">取消</a>
   	 		</div>
  		
</div>
<script type="text/javascript" src="/admin/js/arain.js"></script>
<script type="text/javascript">

var editIndex = undefined;
function endEditing(){
	if (editIndex == undefined){return true}
	if ($('#addg').datagrid('validateRow', editIndex)){
		var ed = $('#addg').datagrid('getEditor', {index:editIndex,field:'enabled'});
		var productname = $(ed.target).combobox('getText');
		$('#addg').datagrid('getRows')[editIndex]['enabledname'] = productname;
		var ed1 = $('#addg').datagrid('getEditor', {index:editIndex,field:'power'});
		var pwoername = $(ed1.target).combobox('getText');
		$('#addg').datagrid('getRows')[editIndex]['pwoername'] = pwoername;
		$('#addg').datagrid('endEdit', editIndex);
		editIndex = undefined;
		return true;
	} else {
		return false;
	}
}
function onClickRow(index){
	if (editIndex != index){
		if (endEditing()){
			$('#addg').datagrid('selectRow', index)
					.datagrid('beginEdit', index);
			editIndex = index;
		} else {
			$('#addg').datagrid('selectRow', editIndex);
		}
	}
}
function append(){
	if (endEditing()){
		$('#addg').datagrid('appendRow',{enabled:1,power:1});
		editIndex = $('#addg').datagrid('getRows').length-1;
		$('#addg').datagrid('selectRow', editIndex)
				.datagrid('beginEdit', editIndex);
	}
}
function removeit(){
	if (editIndex == undefined){return}
	$('#addg').datagrid('cancelEdit', editIndex)
			.datagrid('deleteRow', editIndex);
	editIndex = undefined;
}
function accept(){
	if (endEditing()){
		$('#addg').datagrid('acceptChanges');
	}
}
function reject(){
	$('#addg').datagrid('rejectChanges');
	editIndex = undefined;
}
function getChanges(){
	var rows = $('#addg').datagrid('getChanges');
	alert(rows.length+' rows are changed!');
}


	





$("#rclose").click(function(){
	$("#comonWin").dialog('close')
	});
	
	
$("#rsave").click(function(){
	var array=new Array("resoname","sort")
	var re = AM.validata(array);
	if(re == false) {
		return ;
	}
	var name = $("#resoname").val();
	var id = $("#reid").val();
	var sort = $("#sort").val();
	var enable = $("#enable").val();
	var author = $("#author").val();
	var pid = $("#pid").combotree("getValue"); 
	var target = $("#target").val();
	

	if (endEditing()){
 		jQuery('#addg').datagrid('acceptChanges');
	}
	
	var count = $("#addg").datagrid('getRows').length;
	var arr = new Array();
	var  a = $('#addg').datagrid('getData');
	
	for(var i=0;i<count;i++) {
 		var rname = a.rows[i].name;
 		var rtarget = a.rows[i].target;
 		var renabled = a.rows[i].enabled;
 		var power = a.rows[i].power;
		var resourceJson = '{"enabled":"'+renabled+'","id":"","name":"'+rname+'","target":"'+rtarget+'","authorization":"'+power+'"}';
		arr.push(resourceJson);
	}
	var resourceJsons = "["+arr.toString()+"]";
	$.ajax({
		url:'${pageContent.request.contentPath}/system/resource/save.do',
		data:{
			name:name,
			id:id,
			sort:sort,
			enabled:enable,
			author:author,
			pid:pid,
			target:target,
			resourceJsons:resourceJsons
			
		},
		type: 'POST',
		dataType:'json',
		success: function(data){
				if (data.status ==200) {
					$.messager.alert('消息','保存成功！');
					$("#rsave").hide();
					$("#rclose").hide();
				}
			},
			error:function(data) {
				
				console.log(data.data);	
			}
		})
	});
	
	
	//url="${pageContext.request.contextPath }/system/resource/load_tree.do"
	$(function () {
		
		var parentId = '${sysResource.pid}';
		var reid = '${sysResource.id}';
		
		$('#pid').combotree({    
		    url: '${pageContext.request.contextPath }/system/resource/load_tree.do',    
		    required: false ,
		    onLoadSuccess: function (node, data) {
		    	console.log(parentId)
		    	if(parentId != null && parentId !='' && parentId != 0) {
		    	var t = $("#pid").combotree('tree');//获取tree  
		            node= t.tree("find",parentId);  
		            t.tree('select', node.target);
		    	}
			}
		});
	
// 		if(parentId != null && reid != null) {
// 			$.ajax({
// 				url:'${pageContent.request.contentPath}/system/resource/load_edit_grid.do',
// 				data:{
// 					pid:reid
// 				},
// 				type: 'POST',
// 				dataType:'json',
// 				success: function(data){
// 						if (data.status ==200) {
// 							console.log(data.data.length)
// 							for (var i = 0; i < data.data.length; i++) {
// 								$('#btn').trigger("click");
// 								var ed = $('#addg').datagrid('getEditor', {index:editIndex,field:'name'});
// 								$(ed.target).textbox('setValue',data.data[i].name);

// 								var ed1 = $('#addg').datagrid('getEditor', {index:editIndex,field:'target'});
// 								$(ed1.target).textbox('setValue',data.data[i].target);
								
								
// 								var ed2 = $('#addg').datagrid('getEditor', {index:editIndex,field:'enabled'});
// 								$(ed2.target).combobox('setText',data.data[i].enabled == 1?'可用':'不可用');
								
// 								var ed3 = $('#addg').datagrid('getEditor', {index:editIndex,field:'power'});
// 								$(ed3.target).combobox('setText',data.data[i].enabled == 1?'授权':'不授权');

// 							}
// 						}
// 					},
// 					error:function(data) {
						
// 						console.log(data.data);	
// 					}
// 				})
			
			
// 		}
		
		
	})
   </script>
</body>

</html>