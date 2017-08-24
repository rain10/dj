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
	               <input type="hidden" id="news_id" value="${question.id }">
	               	<input type="hidden" id="attachmentsType" value="2">
                        <label for="" class="label-top">题&emsp;&emsp;目：</label>
                        <input id="answer_title" class="easyui-validatebox easyui-textbox" 
                               data-options="required:true,validType:'length[0,30]'" style="width: 90%;" value="${question.title }">
                    
                    </div>
                    <br>
                          <div class="form-item">
                        <label for="" class="label-top">所属类型：</label>
                        <select id="answer_type" class="easyui-combobox" 
                                name="answer_type" style="width: 90%;" value="${question.type}" data-options="required:true">
                        </select>
                    </div>
                    
                     <br>
                    <c:if test="${news.enabled == null  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="answer_enabled" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="answer_enabled" style="width: 90%;">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                    </c:if>
                      <c:if test="${news.enabled == 1  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="answer_enabled" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="answer_enabled" style="width: 90%;">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                    </c:if>
                      <c:if test="${news.enabled == 0  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="answer_enabled" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="answer_enabled" style="width: 90%;">
                            <option value="0">否</option>
                            <option value="1">是</option>
                            
                        </select>
                    </div>
                    </c:if>
                    <br>
    </div>
    </div>
             	<div title="题目选项" style="overflow:auto;padding:20px;display:none;">
             	<div id="a_tb" style="height:auto">
					<a href="javascript:void(0)" class="easyui-linkbutton info" onclick="append()" id="btn">新增</a>
					<a href="javascript:void(0)" class="easyui-linkbutton warning" data-options="plain:true" onclick="removeit()">删除</a>
				</div>
				
				 <c:if test="${question.id !=null }">
	               	<table id="answer_grid" class="easyui-datagrid" title="" style="width:100%;height:auto"
							data-options="
								iconCls: 'icon-edit',
								singleSelect: true,
								toolbar: '#tb',
								url: '${pageContent.request.contentPath}/app/examination/load_edit_grid?questionId='+${question.id },
								method: 'get',
								onClickRow: onClickRow
							">
							</c:if>
					<c:if test="${question.id ==null }">		
	            <table id="answer_grid" class="easyui-datagrid" title="" style="width:100%;height:auto" data-options="
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
						<th id="a_option" data-options="field:'name',width:50,editor:{type:'textbox',options:{required:true}}">选项</th>
						<th  id="a_content" data-options="field:'target',width:650,editor:{type:'textbox',options:{required:true}}">答案</th>
						<th id="answer" data-options="field:'answer',width:100,formatter:function(value,row){
							return row.answername;
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
						}">是否正确答案</th>
					</tr>
				</thead>
	</table>
	    </div>      
   	 </div>
   	 		<div>
   	 			 <a id="question_save" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-gears'" style="height: 30px;border-left-width: 1px;margin-left: 40%;">保存</a>
   	 			 <a id="news_close" onclick="closeWin('conten_grid')" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-tags'" style="height: 30px;border-left-width: 1px;">取消</a>
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
var type = '${question.type}';
var typeArray=type.split(",");
console.log(typeArray)
$('#answer_type').combobox({ 
	valueField:'id',
	textField:'text',
	multiple:true,
	url:'${pageContent.request.contentPath}/app/type/load_type',
    onLoadSuccess: function () { //加载完成后,设置选中第一项 
        var val = $(this).combobox("getData"); 
         for (var i = 0;i<val.length;i++ ) { 
        	 if(type!=null &&  $.trim(type)!='') {
        		 for(var j=0;j<typeArray.length;j++) {
            		 if(val[i].id == typeArray[j]) {
            			 $(this).combobox("select",val[i].id); 
            		 }
            	 }
        	 } else {
        		 $(this).combobox("select",val[0].id);  
        	 }
        	
        } 
    } 
});       
//data-options="valueField:'id',textField:'text',multiple:true,url:'${pageContent.request.contentPath}/app/type/load_type'"
    var editIndex = undefined;
    function endEditing(){
    	if (editIndex == undefined){return true}
    	if ($('#answer_grid').datagrid('validateRow', editIndex)){
    		var ed = $('#answer_grid').datagrid('getEditor', {index:editIndex,field:'answer'});
    		var productname = $(ed.target).combobox('getText');
    		$('#answer_grid').datagrid('getRows')[editIndex]['answername'] = productname;
    		$('#answer_grid').datagrid('endEdit', editIndex);
    		editIndex = undefined;
    		return true;
    	} else {
    		return false;
    	}
    }
    function onClickRow(index){
    	if (editIndex != index){
    		if (endEditing()){
    			$('#answer_grid').datagrid('selectRow', index)
    					.datagrid('beginEdit', index);
    			editIndex = index;
    		} else {
    			$('#answer_grid').datagrid('selectRow', editIndex);
    		}
    	}
    }
    function append(){
    	var count = $("#answer_grid").datagrid('getRows').length;
    	if (endEditing()){
    		var option = count_option(count);
    		$('#answer_grid').datagrid('appendRow',{answer:0,name:option});
    		editIndex = $('#answer_grid').datagrid('getRows').length-1;
    		$('#answer_grid').datagrid('selectRow', editIndex)
    				.datagrid('beginEdit', editIndex);
    		
    		count++;
    	}
    }
    function removeit(){
    	if (editIndex == undefined){return}
    	$('#answer_grid').datagrid('cancelEdit', editIndex)
    			.datagrid('deleteRow', editIndex);
    	editIndex = undefined;
    }
    function accept(){
    	if (endEditing()){
    		$('#answer_grid').datagrid('acceptChanges');
    	}
    }
    function reject(){
    	$('#answer_grid').datagrid('rejectChanges');
    	editIndex = undefined;
    }
    function getChanges(){
    	var rows = $('#answer_grid').datagrid('getChanges');
    	alert(rows.length+' rows are changed!');
    }

	function count_option(count) {
		var arr=new Array("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z")
		return arr[count];
	}
	
	
	$("#question_save").click(function(){
		var array=new Array()
		array[0]="answer_title";
		var re = AM.validata(array);
		if(re == false) {
			return ;
		}
		
		if (endEditing()){
	 		jQuery('#answer_grid').datagrid('acceptChanges');
		}
		var count = $("#answer_grid").datagrid('getRows').length;
		var arr = new Array();
		var  a = $('#answer_grid').datagrid('getData');
		for(var i=0;i<count;i++) {
	 		var aname = a.rows[i].name;
	 		var atarget = a.rows[i].target;
	 		var aanswer = a.rows[i].answer;
			var resourceJson = '{"answer":"'+aanswer+'","id":"","option":"'+aname+'","content":"'+atarget+'"}';
			arr.push(resourceJson);
		}
		var answerJson = "["+arr.toString()+"]";
		
		
		var id = '${question.id }';
		var title = $("#answer_title").val();
		var answertype = $('#answer_type').combobox('getValues');
		var enabled = $("#answer_enabled").combobox('getValue');
		var type = answertype.toString();
		$.ajax({
			url:'${pageContent.request.contentPath}/app/examination/save.do',
			data:{
	 			id:id,
	 			title:title,
	 			type:type,
	 			enabled:enabled,
				answerJson:answerJson
			},
			type: 'POST',
			dataType:'json',
			success: function(data){
					if (data.status ==200) {
						$.messager.alert('消息','保存成功');
						 	$("#question_save").hide();
						 	$("#news_close").hide();
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