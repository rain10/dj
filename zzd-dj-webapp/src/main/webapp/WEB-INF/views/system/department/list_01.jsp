 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <!--表格-->
    <div class="index-l">
     <div id="tt" class="easyui-tabs" data-options="tabHeight:31" style="width:100%;">
            <div title="组织机构" style="padding:20px;display:none;">
                 <div class="form-item" >
                        <input type="hidden" value="${orgid}" id="orgid_id">
                        <input type="hidden" value="${group.id}" id="group_id">
                    </div>
                     <div class="form-item">
	                <input type="hidden" id="u_type" value="1">
                        <label for="" class="label-top">&emsp;党建名称：</label>
                        <input id="group_name" class="easyui-validatebox easyui-textbox" 
                               data-options="required:true" style="width: 90%;" value="${group.name }">
                    
                    </div>
                    <br>
                    <div class="form-item">
                        <label for="" class="label-top">&emsp;地&emsp;&emsp;址：</label>
                        <input id="group_address" class="easyui-validatebox easyui-textbox" 
                               data-options="required:false" style="width: 90%;" value="${group.address }">
                    
                    </div>
                     <br>
                    <div class="form-item">
                        <label for="" class="label-top">&emsp;书记名字：</label>
                        <input id="group_person" class="easyui-validatebox easyui-textbox" 
                               data-options="required:false" style="width: 90%;" value="${group.secretary }">
                    
                    </div>
                     <br>
                     <div class="form-item">
                        <label for="" class="label-top">&emsp;联系电话：</label>
                        <input id="group_phone" class="easyui-numberbox" style="width: 90%;height: 30px;" value="${group.phone }" data-options="validType:'length[0,11]'">
                    
                    </div>
                    <br>
                    <div class="form-item">
                        <label for="" class="label-top">党组织类型：</label>
                        <input id="group_type" class="easyui-combobox" 
                                name="group_type" style="width: 90%;" data-options="editable:false,panelHeight:null" value="" data-options="required:true">
                    </div>
            </div>
            <div title="部门管理" style="overflow:auto;padding:20px;display:none;">
                 <div class="form-item" style="margin-top: 0.5%">
		     		 <table id="dept_grid" class="easyui-datagrid" title="" style="width:100%;height:auto" data-options="
								iconCls: 'icon-edit',
								singleSelect: true,
								toolbar: '#tb',
								url: '${pageContent.request.contentPath}/system/department/load_edit_grid?orgid='+${orgid },
								method: 'get',
								onClickRow: onClickRow,
							">
				<thead>
					<tr>
						<th id="a_option" data-options="field:'name',width:550,editor:{type:'textbox',options:{required:true}}">部门名称</th>
						<th  id="a_content" data-options="field:'target',width:900,editor:{type:'textbox',options:{required:true}}">部门联系方式（可多填）</th>
						<th id="dept" data-options="field:'dept',width:170,formatter:function(value,row){
							return row.deptname;
						},
						editor:{
							type:'combobox',
							options:{
								valueField:'id',
								textField:'text',
								method:'get',
								url:'${pageContent.request.contentPath }/system/dictionary/load_enabled2.do',
								required:true
							}
						}">是否可用</th>
					</tr>
				</thead>
	</table>
	 <div id="a_tb" style="height:auto">
					<a href="javascript:void(0)" class="easyui-linkbutton info" onclick="append()" id="btn">新增</a>
					<a href="javascript:void(0)" class="easyui-linkbutton warning" data-options="plain:true" onclick="removeit()">删除</a>
				</div>
		      </div>
            </div>
        </div>
        
		      <div>
   	 			 <a id="department_save" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-gears'" style="height: 30px;border-left-width: 1px;margin-left: 40%;">保存</a>
   	 		</div>
</div>
</div>
<script type="text/javascript">

var group_type = '${group.type}'
	$('#group_type').combobox({ 
		valueField:'id',
		textField:'text',
		multiple:false,
		url:'${pageContent.request.contentPath}/system/dictionary/load_group_type.do',
	    onLoadSuccess: function () { //加载完成后,设置选中第一项 
	        var val = $(this).combobox("getData"); 
	         for (var i = 0;i<val.length;i++ ) { 
	        	 if(group_type!=null &&  $.trim(group_type)!='' && dept != 0) {
	            		 if(val[i].id == group_type) {
	            			 $(this).combobox("select",val[i].id); 
	            	 }
	        	 } else {
	        		 $(this).combobox("select",val[0].id);  
	        	 }
	        	
	        } 
	    } 
	});


var editIndex = undefined;
function endEditing(){
	if (editIndex == undefined){return true}
	if ($('#dept_grid').datagrid('validateRow', editIndex)){
		var ed = $('#dept_grid').datagrid('getEditor', {index:editIndex,field:'dept'});
		var productname = $(ed.target).combobox('getText');
		$('#dept_grid').datagrid('getRows')[editIndex]['deptname'] = productname;
		$('#dept_grid').datagrid('endEdit', editIndex);
		editIndex = undefined;
		return true;
	} else {
		return false;
	}
}
function onClickRow(index){
	if (editIndex != index){
		if (endEditing()){
			$('#dept_grid').datagrid('selectRow', index)
					.datagrid('beginEdit', index);
			editIndex = index;
		} else {
			$('#dept_grid').datagrid('selectRow', editIndex);
		}
	}
}
function append(){
	if (endEditing()){
		$('#dept_grid').datagrid('appendRow',{dept:1});
		editIndex = $('#dept_grid').datagrid('getRows').length-1;
		$('#dept_grid').datagrid('selectRow', editIndex)
				.datagrid('beginEdit', editIndex);
		
	}
}
function removeit(){
	if (editIndex == undefined){return}
	$('#dept_grid').datagrid('cancelEdit', editIndex)
			.datagrid('deleteRow', editIndex);
	editIndex = undefined;
}
function accept(){
	if (endEditing()){
		$('#dept_grid').datagrid('acceptChanges');
	}
}
function reject(){
	$('#dept_grid').datagrid('rejectChanges');
	editIndex = undefined;
}
function getChanges(){
	var rows = $('#dept_grid').datagrid('getChanges');
	alert(rows.length+' rows are changed!');
}
    
$("#department_save").click(function(){
	if($.trim($("#group_name").val()) == '') {
		return false;
	} 
	
	if (endEditing()){
 		jQuery('#dept_grid').datagrid('acceptChanges');
	}
	var count = $("#dept_grid").datagrid('getRows').length;
	var arr = new Array();
	var  a = $('#dept_grid').datagrid('getData');
	for(var i=0;i<count;i++) {
 		var aname = a.rows[i].name;
 		var atarget = a.rows[i].target;
 		var adept = a.rows[i].dept;
		var resourceJson = '{"enabled":"'+adept+'","id":"","name":"'+aname+'","number":"'+atarget+'"}';
		arr.push(resourceJson);
	}
	var answerJson = "["+arr.toString()+"]";
	
	
	var id = '${orgid}';
	var group_id = '${group.id}';
	var name = $("#group_name").val();
	var address = $("#group_address").val();
	var person = $("#group_person").val();
	var phone = $("#group_phone").val();
	var type = $("#group_type").combotree("getValue"); 
	$.ajax({
		url:'${pageContent.request.contentPath}/system/department/save.do',
		data:{
			oid:id,
 			dept:answerJson,
 			name:name,
			address:address,
			phone:phone,
			type:type,
			secretary:person,
			id:group_id
			
		},
		type: 'POST',
		dataType:'json',
		success: function(data){
				if (data.status ==200) {
					$.messager.alert('消息','保存成功');
					 	$("#department_save").hide();
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