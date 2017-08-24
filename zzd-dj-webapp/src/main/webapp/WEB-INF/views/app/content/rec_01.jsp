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
        .easyui-datagrid td  div
        {
            background: #EEE;
            width: 410px;
            height: 3em;
            margin: 1em;
            overflow: hidden !important;
            text-overflow: ellipsis;

        }
        #rec_grid tr {
        	 height: 3em;
        	 overflow:hidden;
        	  text-overflow: ellipsis;
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
				<table id="rec_grid" class="easyui-datagrid"></table>
           
   	 		<div>
   	 			 <a  onclick="closeWin('rec_grid')" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-tags'" style="margin-top: 10px;margin-left: 45%;height: 30px;border-left-width: 48%;">关闭</a>
   	 		</div>
  		
</div>
</form>
</div>
 <script src="/admin/easyui/datagrid-detailview.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="/admin/js/arain.js"></script>
<script type="text/javascript" charset="utf-8" src="/admin/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/admin/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="/admin/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">

jQuery('#rec_grid').datagrid({
    url: '${pageContent.request.contentPath}/app/content/load_send_data.do',
    pagination : false,//分页控件
    pageList: [10, 20, 30, 40, 50],
    fit: false,   //自适应大小
    border:false,
    nowrap: true,//数据长度超出列宽时将会自动截取。
    rownumbers:true,//行号
    fitColumns:true,//自动使列适应表格宽度以防止出现水平滚动。
    singleSelect:true,
    collapsible:true,
    idField:'content_id_',
    columns: [
        [{
            field: 'content_id_',
            title: 'id',
            align: 'center',
            hidden:'true',
            sortable: true
        }, 
        {
            field: 'user_id_',
            title: 'userId',
            width: 100,
            align: 'center',
            hidden:'true',
            sortable: true
        }, 
        {
            field: 'title_',
            title: '标题',
            width: 100,
            align: 'center',
            sortable: true
        }, {
            field: 'content_',
            title: '标题',
            width: 100,
            align: 'center',
            hidden:'true',
            sortable: true
        },{
            field: 'propelling_time_',
            title: '推送时间',
            width: 100,
            align: 'center',
            sortable: true
        },
        {field:'action',title:'操作',width:100,align:'center',
			formatter:function(value,row,index){
					var s = '<a href="javascript:void(0);"  style="display:inline-block;padding:3px 5px;background-color:#49CE1E;color:white;margin-right:5px"  onclick="saverow('+row.content_id_+','+row.user_id_+')">接收</a> ';
					var c = '<a href="javascript:void(0);"  style="display:inline-block;padding:3px 5px;background-color:red;color:white" onclick="cancelrow('+row.content_id_+','+row.user_id_+')">拒绝</a>';
					return s+c;
			}
		}
        ]
    ],
    view:detailview,
	detailFormatter: function(rowIndex, rowData){
		return '<p>详细内容: ' + rowData.content_ + '</p>'
	}

    	
});
	
	function saverow(contentId,userId) {
		 $.messager.confirm('确认', '您确认想要接收推送吗？', function (r) {
	            if (r) {
	            	$.ajax({
    	        		url:'${pageContent.request.contentPath}/app/content/updata',
    	        		data:{
    	        			userId:userId,
    	        			contentId:contentId,
    	        			action:2
    	        		},
    	        		type: 'POST',
    	        		dataType:'json',
    	        		success: function(data){
    	        				if (data.status ==200) {
    	        					$.messager.alert('消息','推送接收成功');
    	        					jQuery('#rec_grid').datagrid('reload');
    	        					send_change();
    	        				} else {
    	        					$.messager.alert('消息',data.msg);
    	        					send_change();
    	        				}
    	        			},
    	        			error:function(data) {
    	        				
    	        				console.log(data.msg);	
    	        			}
    	        		})
	            }
	        });
	}
	
	function cancelrow(contentId,userId) {
		 $.messager.confirm('确认', '您确认想要拒绝推送吗？', function (r) {
	            if (r) {
	            	$.ajax({
    	        		url:'${pageContent.request.contentPath}/app/content/updata',
    	        		data:{
    	        			userId:userId,
    	        			contentId:contentId,
    	        			action:3
    	        		},
    	        		type: 'POST',
    	        		dataType:'json',
    	        		success: function(data){
    	        				if (data.status ==200) {
    	        					$.messager.alert('消息','推送已拒绝');
    	        					jQuery('#rec_grid').datagrid('reload');
    	        					send_change();
    	        				} else {
    	        					$.messager.alert('消息',data.msg);
    	        					send_change();
    	        				}
    	        			},
    	        			error:function(data) {
    	        				console.log(data.msg);	
    	        			}
    	        		})
	            }
	        });
	}
	
 	</script>
</body>

</html>