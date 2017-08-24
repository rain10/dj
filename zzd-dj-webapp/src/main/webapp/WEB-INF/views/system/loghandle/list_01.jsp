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
			       <input type="text" class="easyui-textbox" id="username2" data-options="min:0,precision:2"/>

		      		<a id="log2search" href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true">搜索</a>
		      </div>
	      <div style="margin-top: 0.5%">
       		  <a href="javascript:void(0)" id="log2break" style="margin-left: 29px;" class="easyui-linkbutton success" data-options="iconCls:'fa fa-desktop'">刷新</a>
	      </div>
	      </div>
	   <div class="index-1" style="opacity: 1;width:100%;min-height:620px;margin-top: 0.5%">
	        <table id="handlegd"  class="easyui-datagrid" data-options="${dataGrid }"></table>
    	</div>
</div>

<script type="text/javascript">
  
$("#log2break").click(function() {
	$('#handlegd').datagrid('reload'); 
});

	$("#log2search").click(function() {
		  var name = $("#username2").val();
		
		  $('#handlegd').datagrid('load', {    
			  username: name,    
			});  
		});
    
   </script>
</body>

</html>