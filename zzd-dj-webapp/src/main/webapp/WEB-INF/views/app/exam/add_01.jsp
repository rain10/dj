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
	<form id="exam_form" class="easyui-form" method="post" data-options="novalidate:true">
    <div class="contentWrapper">
          	<!--tab-->
	    <div class="index-l">
	        <div id="tt" class="easyui-tabs" data-options="tabHeight:31" style="width:100%;">
	            <div title="考试信息" style="padding:20px;display:none;">
	            <div class="contentWrapper">
	               <div class="form-item">
	               <input type="hidden" id="id" name="id" value="${exam.id }">
                        <label for="" class="label-top">考试标题：</label>
                        <input id="exam_title" name="title" class="easyui-validatebox easyui-textbox" 
                               data-options="required:true,validType:'length[0,30]'" style="width: 90%;" value="${exam.title }">
                    
                    </div>
                    <br>
                          <div class="form-item">
                        <label for="" class="label-top">考试试卷：</label>
                        <select id="paper_type"  class="easyui-combogrid" 
                                name="paperId" style="width: 90%;height: 30px"  data-options="required:true">
                        </select>
                    </div>
                    
                    <br>
                         <div class="form-item">
                        <label for="" class="label-top">活动开始时间：</label>
                        <input id="dd" type="text" name="start" class="easyui-datetimebox" style="width: 36%;height: 30px" required="required" value="${starttime }"/>
                        <label for="" class="label-top">&emsp;&emsp;活动结束时间：</label>
                        <input id="dd" type="text"  name="end" class="easyui-datetimebox" style="width: 37%;height: 30px" required="required" value="${endtime }"/>
                    </div>
                    
                    <br>
                    <c:if test="${exam.ingTime !=null}">
                    <div class="form-item">
                        <label for="" class="label-top">考试进行时间(分钟)：</label>
                        <input class="easyui-slider" name="ingTime"  value="${exam.ingTime }" style="width: 98%;" data-options="showTip:true"/>
                    </div>
                    </c:if>
                     <c:if test="${exam.ingTime ==null}">
                    <div class="form-item">
                        <label for="" class="label-top">考试进行时间(分钟)：</label>
                        <input class="easyui-slider" name="ingTime"  value="60" style="width: 98%;" data-options="showTip:true"/>
                    </div>
                    </c:if>
                     <br>
                     <div class="form-item">
                        <label for="" class="label-top">考试类型：</label>
                        <select id="examtype" class="easyui-combobox" 
                                name="type" style="width: 90%;" value="${exam.type}" required="required">
                        </select>
                    </div>
                    <br>
                    <c:if test="${exam.enabled == null  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否有效：</label>
                        <select id="exam_enabled" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="enabled" style="width: 90%;">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                    </c:if>
                      <c:if test="${exam.enabled == 1  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否有效：</label>
                        <select id="exam_enabled" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="enabled" style="width: 90%;">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                    </c:if>
                      <c:if test="${exam.enabled == 0  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否有效：</label>
                        <select id="exam_enabled" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="enabled" style="width: 90%;">
                            <option value="0">否</option>
                            <option value="1">是</option>
                            
                        </select>
                    </div>
                    </c:if>
                    <br>
    </div>
    </div>
    
    	<div title="考试学习资料" style="overflow:auto;padding:20px;display:none;">
					<div id="tb" style="height:auto">
						<div class="form-item">
                        <script id="editor" type="text/plain" style="width:100%;height:90%;"></script>
                    </div>
					</div>
	            </div>
	            <input name="content" type="hidden" id="exam_content"> 
	            
	            	<div title="考试规则" style="overflow:auto;padding:20px;display:none;">
					<div id="tb" style="height:auto">
						<div class="form-item">
                        <script id="editor1"  type="text/plain" style="width:100%;height:90%;"></script>
                    </div>
					</div>
	            </div>
             	<input name="rule" type="hidden" id="exam_rule"> 
   	 </div>
   	 		<div>
   	 			 <a id="exam_save" onclick="submitForm()" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-gears'" style="height: 30px;border-left-width: 1px;margin-left: 40%;">保存</a>
   	 			 <a id="news_close" onclick="closeWin('conten_grid')" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-tags'" style="height: 30px;border-left-width: 1px;">取消</a>
   	 		</div>
  		
</div>
</form>
</div>
<script type="text/javascript" src="/admin/js/arain.js"></script>
<script type="text/javascript" charset="utf-8" src="/admin/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/admin/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="/admin/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
var ue = UE.getEditor('editor');
var ue1 = UE.getEditor('editor1');

var paperType = '${exam.paperId}'
var type = '${exam.type}';
var typeArray=type.split(",");
console.log(typeArray)
$('#examtype').combobox({ 
	valueField:'id',
	textField:'text',
	multiple:false,
	url:'${pageContent.request.contentPath}/system/dictionary/load_exam_type.do',
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

$('#paper_type').combogrid({
	delay: 500,    
    mode: 'remote',    
    url: '${pageContent.request.contentPath}/app/paper/load_combogrid',    
    idField: 'id_',    
    textField: 'title_', 
    pagination : true,//分页控件
    pageList: [10, 20, 30, 40, 50],
    fit: false,   //自适应大小
    border:false,
    nowrap: true,//数据长度超出列宽时将会自动截取。
    rownumbers:true,//行号
    fitColumns:true,//自动使列适应表格宽度以防止出现水平滚动。
    singleSelect:false,
    collapsible:true,
    columns: [[    
        {field:'id_',title:'ID',width:120,sortable:true},    
        {field:'title_',title:'试卷名称',width:400,sortable:true},
        {field:'manager_time_',title:'经办时间',width:190,sortable:true}
    ]],
    onLoadSuccess: function () { //加载完成后,设置选中第一项 
    	if(paperType != null) {
    		$('#paper_type').combogrid('grid').datagrid('selectRecord',paperType);
    	} 
    	    	
    	 } 
    
})
		
		function submitForm(){
			$("#exam_content").val(UE.getEditor('editor').getContent());
			$("#exam_rule").val(UE.getEditor('editor1').getContent());
			
			$('#exam_form').form('submit',{
				url:'${pageContent.request.contentPath}/app/exam/save.do',
				onSubmit:function(){
					return $(this).form('enableValidation').form('validate');
				},
				 success: function (data) {
					 if (JSON.parse(data).status ==200) {
	 						$.messager.alert('消息','保存成功');
	 						 	$("#exam_save").hide();
	 						 	$("#news_close").hide();
	 					} else {
	 						$.messager.alert('消息',JSON.parse(data).msg);
	 					}
				 }
			});
		}
		
		
ue.addListener("ready", function () {  
    // editor准备好之后才可以使用  
    var news_content = '${exam.content}';
//		console.log(news_content)
	if(news_content!=null) {
	ue.setContent(news_content);
}

}); 

ue1.addListener("ready", function () {  
    // editor准备好之后才可以使用  
    var news_content = '${exam.rule}';
//		console.log(news_content)
	if(news_content!=null) {
	ue1.setContent(news_content);
}

}); 


UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
UE.Editor.prototype.getActionUrl = function(action) {
if (action == 'uploadimage' || action == 'uploadscrawl' || action == 'uploadimage') {
    var url = 'http://127.0.0.1:8080/common/upload?attachmentsType=2';
    return url;
} else if (action == 'uploadvideo') {
    return 'http://127.0.0.1:8080/common/upload?attachmentsType=2';
} else {
    return this._bkGetActionUrl.call(this, action);
}
}

 	</script>
</body>

</html>