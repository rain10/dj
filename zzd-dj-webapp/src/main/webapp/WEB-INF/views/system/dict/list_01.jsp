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
			       <label for="" style=" padding-left: 20%;" class="label-top" >类型：</label>
			       <input type="text" class="easyui-textbox" id="dicttype" data-options="min:0,precision:2"/>
			       
			       <label for="" style=" padding-left: 6%;" class="label-top" >名称：</label>
			       <input type="text" class="easyui-textbox" id="dictname" data-options="min:0,precision:2"/>
			       
			       <label for="" class="label-top" style="padding-left: 6%;">是否可用：</label>
					<input id="dictenable" class="easyui-combobox" name="dept"   
					    data-options="valueField:'id',textField:'text',url:'${pageContent.request.contentPath}/system/dictionary/load_enabled2.do'" value="1"/>  
		      		<a id="dictsearch" href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true">搜索</a>
		      </div>
	      <div style="margin-top: 0.5%">
	      	 <a href="javascript:void(0)" data-options="iconCls:'fa fa-area-chart'" id="dictadd" class="easyui-linkbutton primary" style="height: 32px;border-left-width: 1px;margin-left: 29px;">新增</a>
       		  <a href="javascript:void(0)" id="dictedit" class="easyui-linkbutton error" data-options="iconCls:'fa fa-gears'">修改</a>
       		  <a href="javascript:void(0)" id="dictbreak" class="easyui-linkbutton success" data-options="iconCls:'fa fa-desktop'">刷新</a>
	      </div>
	      </div>
	   <div class="index-1" style="opacity: 1;width:100%;min-height:620px;margin-top: 0.5%">
	        <table id="dictdg"></table>
    	</div>

<div id="dictWin" style="display: none;"></div></div>
<script type="text/javascript">
  

jQuery('#dictdg').datagrid({
    url: '${pageContent.request.contentPath}/system/dict/load_datagrid.do',
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
            field: 'TYPE_',
            title: '类型',
            width: 100,
            align: 'center',
            sortable: true
        }, 
        {
            field: 'NAME_',
            title: '名称',
            width: 100,
            align: '姓名',
            align: 'center',
            sortable: true
        }, 
        {
            field: 'VALUE_',
            title: '字典实际值',
            width: 100,
            align: 'center',
            sortable: true
        }, {
            field: 'DISPLAY_',
            title: '字典显示值',
            width: 100,
            align: 'center',
            sortable: true
        }, {
            field: 'SORT_',
            title: '排序',
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

	$("#dictsearch").click(function() {
		  var type = $("#dicttype").val();
		  var name = $("#dictname").val();
		  var enable = $("#dictenable").val();
		  $('#dictdg').datagrid('load', {    
			  type: type,    
			  enable:enable,
			  name:name,
			});  
		});
	
    $("#dictadd").on('click', function () {
        $('#dictWin').window({
            width: 800,
            height: 500,
            title:"新增",
            href:"${pageContent.request.contentPath}/system/dict/add_01",
            modal: true,
            constrain: true,
            
            buttons: [{
                text: '保存',
                handler: function () {
                }
            }, {
                text: '关闭',
                handler: function () {
                }
            }]
        });
    });
    
    $("#dictbreak").click(function() {
    	$('#dictdg').datagrid('reload'); 
    });
    
    $("#dictedit").click(function() {
		var data = $("#dictdg").datagrid('getSelected');
		if(data == null) {
			$.messager.alert('消息','没有选中行！');
			return;
		}
		
		$('#dictWin').window({
            width: 800,
            height: 500,
            title:"编辑",
            href:"${pageContent.request.contentPath}/system/dict/edit_01?type="+data.TYPE_+"&value="+data.VALUE_,
            modal: true,
            constrain: true,
            
            buttons: [{
                text: '保存',
                handler: function () {
                }
            }, {
                text: '关闭',
                handler: function () {
                }
            }]
        });
		console.log(data)
	});
   </script>
</body>

</html>