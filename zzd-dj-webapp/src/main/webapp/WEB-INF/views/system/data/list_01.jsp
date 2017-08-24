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
	<div class="index-l">
		<div  style="margin-top: 0.5%">
       		  <a href="javascript:void(0)" style="margin-left: 29px;" onclick="dataEdit()" id="dataEdit" class="easyui-linkbutton error" data-options="iconCls:'fa fa-gears'">备份</a>
	      </div>
    
	   <div class="index-1" style="opacity: 1;width:100%;height:620px;margin-top: 0.5%">
	        <table id="datagrid" class="easyui-datagrid" data-options="${dataGrid }"></table>
    	</div>
	</div>
</div>
<script type="text/javascript">
$("#dataEdit").click(function() {
		var data = $("#datagrid").datagrid('getSelected');
		if(data == null) {
			$.messager.alert('消息','没有选中行！');
			return;
		}
		
		 $.messager.confirm('确认', '您确认想要备份'+data.tableName+'吗？', function (r) {
	            if (r) {
	            	$.ajax({
	        			url:'${pageContent.request.contentPath}/system/data/backup',
	        			type: 'POST',
	        			dataType:'json',
	        			success: function(data){
	        					if (data.status ==200) {
	        						$.messager.alert('消息','备份成功');
	        					}
	        				},
	        				error:function(data) {
	        					
	        					console.log(data.data);	
	        				}
	        			})
	            }
	        });
		
		
})
	</script>
</body>

</html>