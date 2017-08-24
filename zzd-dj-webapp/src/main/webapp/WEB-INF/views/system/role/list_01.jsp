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
			       <label for="" style=" padding-left: 20%;" class="label-top" >角色名称：</label>
			       <input type="text" class="easyui-textbox" id="name" data-options="min:0,precision:2"/>
			       
			       <label for="" class="label-top" style="padding-left: 14%;">是否可用：</label>
<!--                         <select id="renable" class="easyui-combobox" data-options="editable:false,panelHeight:null" -->
<!--                                 name="dept"> -->
<!--                             <option value="YES">YES</option> -->
<!--                             <option value="NO">NO</option> -->
<!--                         </select> -->
					<input id="renable" class="easyui-combobox" name="dept"   
					    data-options="valueField:'id',textField:'text',url:'${pageContent.request.contentPath}/system/dictionary/load_enabled2.do'" value="1"/>  
		      		<a id="rsearch"   href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true">搜索</a>
		      </div>
	      <div style="margin-top: 0.5%">
	      	 <a href="javascript:void(0)" data-options="iconCls:'fa fa-area-chart'" onclick="addWin('/system/role/add_01')" id="roleadd" class="easyui-linkbutton primary" style="height: 32px;border-left-width: 1px;margin-left: 29px;">新增</a>
       		  <a href="javascript:void(0)" onclick="editWin('dg','/system/role/edit_01')" class="easyui-linkbutton error" data-options="iconCls:'fa fa-gears'" id="roleedit">修改</a>
       		  <a href="javascript:void(0)" onclick="refresh('dg')" id="rbreak" class="easyui-linkbutton success" data-options="iconCls:'fa fa-desktop'">刷新</a>
	      </div>
	      </div>
	   <div class="index-1" style="opacity: 1;width:100%;min-height:620px;margin-top: 0.5%">
	        <table id="dg"></table>
    	</div>
</div>

<script type="text/javascript">
  

jQuery('#dg').datagrid({
    url: '${pageContent.request.contentPath}/system/role/load_datagrid.do',
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
            field: 'NAME_',
            title: '名称',
            width: 100,
            align: 'center',
            sortable: true
        }, 
        {
            field: 'SORT_',
            title: '排序',
            width: 100,
            align: 'center',
            sortable: true
        }, {
            field: 'OPERATOR_',
            title: '经办人',
            width: 100,
            align: 'center',
            sortable: true
        }, {
            field: 'OP_TIME_',
            title: '经办时间',
            width: 100,
            align: 'center',
            sortable: true
        }, {
            field: 'ENABLED_',
            title: '是否可用',
            width: 100,
            align: 'center',
            sortable: true
        }]
    ]
});

$("#rsearch").click(function() {
	  var username = $("#name").val();
	  var enable = $("#renable").combobox('getValue');
	  $('#dg').datagrid('load', {    
		  name: username,    
		  enable:enable,
		});  
	});
   </script>
</body>

</html>