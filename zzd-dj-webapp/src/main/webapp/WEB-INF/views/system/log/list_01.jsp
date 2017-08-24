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
    <!--表格-->
    <div class="index-l">
    
		     <div class="form-item" style="margin-top: 0.5%">
			       <label for="" style=" padding-left: 20%;" class="label-top" >人员名称：</label>
			       <input type="text" class="easyui-textbox" id="username" data-options="min:0,precision:2"/>

		      		<a id="logsearch" href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true">搜索</a>
		      </div>
	      <div style="margin-top: 0.5%">
       		  <a href="javascript:void(0)" id="logbreak" style="margin-left: 29px;" class="easyui-linkbutton success" data-options="iconCls:'fa fa-desktop'">刷新</a>
	      </div>
	      </div>
	   <div class="index-1" style="opacity: 1;width:100%;min-height:620px;margin-top: 0.5%">
	        <table id="roledg"></table>
    	</div>
</div>

<script type="text/javascript">
  

jQuery('#roledg').datagrid({
    url: '${pageContent.request.contentPath}/system/log/load_datagrid.do',
    pagination : true,//分页控件
    pageList: [10, 20, 30, 40, 50],
    fit: true,   //自适应大小
    border:false,
    nowrap: true,//数据长度超出列宽时将会自动截取。
    rownumbers:true,//行号
    fitColumns:true,//自动使列适应表格宽度以防止出现水平滚动。
    singleSelect:true,
    collapsible:true,
    columns: [
        [{
            field: 'ID_',
            title: 'id',
            width: 100,
            align: 'center',
            hidden:'true',
            sortable: true
        }, 
        {
            field: 'USERNAME_',
            title: '用户名',
            width: 100,
            align: 'center',
            sortable: true
        }, 
        {
            field: 'MAC_',
            title: '平台',
            width: 100,
            align: 'center',
            sortable: true
        }, {
            field: 'LOGIN_TIME_',
            title: '登录时间',
            width: 100,
            align: 'center',
            sortable: true
        }, {
            field: 'IP_',
            title: '登录IP',
            width: 100,
            align: 'center',
            sortable: true
        }
    ]]
});
$("#logbreak").click(function() {
	$('#roledg').datagrid('reload'); 
});

	$("#logsearch").click(function() {
		  var name = $("#username").val();
		
		  $('#roledg').datagrid('load', {    
			  username: name,    
			});  
		});
    
   </script>
</body>

</html>