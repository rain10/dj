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
			       <label for="" style=" padding-left: 20%;" class="label-top" >用户名：</label>
			       <input type="text" class="easyui-textbox" id="uasername" data-options="min:0,precision:2"/>
			       
			       <label for="" style=" padding-left: 6%;" class="label-top" >姓名：</label>
			       <input type="text" class="easyui-textbox" id="raealname" data-options="min:0,precision:2"/>
			       
			       <label for="" class="label-top" style="padding-left: 6%;">是否可用：</label>
<!--                         <select id="uenable" class="easyui-combobox" data-options="editable:false,panelHeight:null" -->
<!--                                 name="dept"> -->
<!--                             <option value="YES">YES</option> -->
<!--                             <option value="NO">NO</option> -->
<!--                         </select> -->
					<input id="uaenable" class="easyui-combobox" name="dept"   
					    data-options="valueField:'id',textField:'text',url:'${pageContent.request.contentPath}/system/dictionary/load_enabled2.do'" value="1"/>  


		      		<a id="uasearch" href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true">搜索</a>
		      </div>
	      <div style="margin-top: 0.5%">
	      	 <a href="javascript:void(0)" onclick="addWin('/system/user/add_02')" data-options="iconCls:'fa fa-area-chart'" id="uadd" class="easyui-linkbutton primary" style="height: 32px;border-left-width: 1px;margin-left: 29px;">新增</a>
       		  <a href="javascript:void(0)" onclick="editWin('uadg','/system/user/edit_02')" id="uedit" class="easyui-linkbutton error" data-options="iconCls:'fa fa-gears'">修改</a>
       		  <a href="javascript:void(0)" onclick="refresh('uadg')" id="ubreak" class="easyui-linkbutton success" data-options="iconCls:'fa fa-desktop'">刷新</a>
	      </div>
	      </div>
	   <div class="index-1" style="opacity: 1;width:100%;min-height:620px;margin-top: 0.5%">
	        <table id="uadg"></table>
    	</div>

<div id="uWin" style="display: none;"></div></div>
<script type="text/javascript">
$('#cc').combo({    
    required:true,    
    multiple:true   
});  

jQuery('#uadg').datagrid({
    url: '${pageContent.request.contentPath}/system/user/load_datagrid.do?type=0',
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
            field: 'REALNAME_',
            title: '名称',
            width: 100,
            align: '姓名',
            align: 'center',
            sortable: true
        }, 
        {
            field: 'USERNAME_',
            title: '用户名',
            width: 100,
            align: 'center',
            sortable: true
        }, {
            field: 'EMAIL_',
            title: '电子邮箱',
            width: 100,
            align: 'center',
            sortable: true
        }, {
            field: 'PHONE_',
            title: '公开号码',
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

	$("#uasearch").click(function() {
		  var username = $("#uasername").val();
		  var realname = $("#raealname").val();
		  var enable = $("#uaenable").combobox('getValue');
		  $('#uadg').datagrid('load', {    
			  username: username,    
 			  enable:enable,
			  realname:realname,
			});  
		});
	
//     $("#uadd").on('click', function () {
//         $('#uWin').window({
//             width: 800,
//             height: 500,
//             title:"新增",
//             href:"${pageContent.request.contentPath}/system/user/add_01",
//             modal: true,
//             constrain: true,
            
//             buttons: [{
//                 text: '保存',
//                 handler: function () {
//                 }
//             }, {
//                 text: '关闭',
//                 handler: function () {
//                 }
//             }]
//         });
//     });
    
//     $("#ubreak").click(function() {
//     	$('#udg').datagrid('reload'); 
//     });
    
//     $("#uedit").click(function() {
// 		var data = $("#udg").datagrid('getSelected');
// 		if(data == null) {
// 			$.messager.alert('消息','没有选中行！');
// 			return;
// 		}
		
// 		$('#uWin').window({
//             width: 800,
//             height: 500,
//             title:"编辑",
//             href:"${pageContent.request.contentPath}/system/user/edit_01?id="+data.ID_,
//             modal: true,
//             constrain: true,
            
//             buttons: [{
//                 text: '保存',
//                 handler: function () {
//                 }
//             }, {
//                 text: '关闭',
//                 handler: function () {
//                 }
//             }]
//         });
	
//     })
	</script>
</body>

</html>