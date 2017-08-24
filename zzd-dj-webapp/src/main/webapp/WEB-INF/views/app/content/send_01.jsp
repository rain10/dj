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
	            <div title="推送信息" style="padding:20px;display:none;">
	            <div class="contentWrapper">
	            <input type="hidden" name="contentId" value="${content.id }">
                          <div class="form-item">
                        <label for="" class="label-top">被推送人员：</label>
                        <select id="user_id"  class="easyui-combogrid" 
                                name="userId" style="width: 88%;height: 30px"  data-options="required:true">
                        </select>
                    </div>
                    
                    <br>
                         <div class="form-item">
                        <label for="" class="label-top">推送时间：</label>
                        <input id="propelling_time_" type="propellingTime" name="propellingTime" class="easyui-datetimebox" style="width: 90%;height: 30px" required="true" value="${starttime }"/>
                    </div>
                    
           
   	 		<div>
   	 			 <a id="send_save" onclick="submitForm()" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-gears'" style="height: 30px;border-left-width: 1px;margin-left: 40%;">推送</a>
   	 			 <a id="send_close" onclick="closeWin('conten_grid')" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-tags'" style="height: 30px;border-left-width: 1px;">取消</a>
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

$('#user_id').combogrid({
	delay: 500,    
    mode: 'remote',    
    url: '${pageContent.request.contentPath}/system/user/load_combogrid',    
    idField: 'id_',    
    textField: 'username_', 
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
        {field:'id_',title:'ID',width:120,sortable:true,hidden:'true',},    
        {field:'username_',title:'用户名',width:400,sortable:true},
        {field:'realname_',title:'真实姓名',width:400,sortable:true}
    ]],
    onLoadSuccess: function () { //加载完成后,设置选中第一项 
    	if(paperType != null) {
    		$('#user_id').combogrid('grid').datagrid('selectRecord',paperType);
    	} 
    	    	
    	 } 
    
})
		
		function submitForm(){
			
			$('#exam_form').form('submit',{
				url:'${pageContent.request.contentPath}/app/content/send.do',
				onSubmit:function(){
					return $(this).form('enableValidation').form('validate');
				},
				 success: function (data) {
					 if (JSON.parse(data).status ==200) {
	 						$.messager.alert('消息','推送成功');
	 						 	$("#send_save").hide();
	 						 	$("#send_close").hide();
	 					} else {
	 						$.messager.alert('消息',JSON.parse(data).msg);
	 					}
				 }
			});
		}
		


 	</script>
</body>

</html>