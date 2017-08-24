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
    <div class="index-l" style="margin-top: 0.5%">
             	<a href="javascript:void(0)" data-options="iconCls:'fa fa-area-chart'" id="orgidadd" class="easyui-linkbutton primary" style="height: 32px;border-left-width: 1px;margin-left: 29px;">新增</a>
       		  	<a href="javascript:void(0)" id="orgidedit" class="easyui-linkbutton error" data-options="iconCls:'fa fa-gears'">修改</a>
       		  	<a href="javascript:void(0)" id="orgidbreak" class="easyui-linkbutton success" data-options="iconCls:'fa fa-desktop'">刷新</a>
             </div>
		<div class="form-item" >
		<div style="margin-top: 0.5%">
		  	<div class="index-1" style="opacity: 1;width:66%;height:720px; float:left " id="iimain" ></div>
		  	<ul id="tree" style = "right:20px; top:20px;float:left"></ul> 
		  	<div>
		</div>
		  </div>
		<!-- 树形的Dom -->
		<div>
		
		</div>
	</div>
	 
</div>
<div id="orgidWin" style="display: none;"></div>
<script type="text/javascript" src="/admin/build/dist/echarts.js"></script>
<!-- ECharts单文件引入 -->
<script type="text/javascript">
    // 路径配置
    require.config({
        paths: {
            echarts: '/admin/build/dist'
        }
    });
    // 使用
    require(
        [
            'echarts',
            'echarts/chart/map' // 使用柱状图就加载bar模块，按需加载
        ],
        function (ec) {
            // 基于准备好的dom，初始化echarts图表
            var myChart = ec.init(document.getElementById('iimain')); 
            
            option = {
            	    title: {
            	        text : '机构信息分布图'
            	    },
            	    tooltip : {
            	        trigger: 'item',
            	        formatter: '{b}<br/>点击查看详情'
            	    },
            	    legend: {
            	    	show:false,
            	        orient: 'vertical',
            	        x:'right',
            	        data:['市州机构信息']
            	    },
            	    dataRange: {
            	        min: 0,
            	        max: 22,
            	        color:['pink','yellow'],
//             	        text:['高','低'],           // 文本，默认为数值文本
            	        show:false,
            	        calculable : false
            	    },
            	    series : [
            	        {
            	            name: '市州机构信息',
            	            type: 'map',
            	            mapType: '四川',
            	            selectedMode : 'single',
            	            itemStyle:{
            	                normal:{label:{show:true}},
            	                emphasis:{label:{show:true}}
            	            },
            	            data: ${mapArray}
            	        }
            	    ]
            	};
            
            // 为echarts对象加载数据 
            myChart.setOption(option,true); 
            	var ecConfig = require('echarts/config');
            	myChart.on(ecConfig.EVENT.MAP_SELECTED, function (param){
//             	    var selected = param.selected;
//             	    var str = '当前选择： ';
//             	    for (var p in selected) {
//             	        if (selected[p]) {
//             	            str += p + ' ';
//             	        }
//             	    }
            		var data = ${mapArray};
                	for(var i=0;i<data.length;i++){
                		if(data[i].name==param.target){
                			jQuery('#tree').tree({
                			    url:'/system/orgid/load_datagrid.do?city='+data[i].value   
                			}); 
              			}
                	}
            	   
            	})
        }
    );
    
   	jQuery('#tree').tree({    
	    url:'/system/orgid/load_datagrid.do'
	});

   	
   	$("#orgidbreak").click(function() {
   		$('#tree').tree('reload'); 
   	});

   	    $("#orgidadd").on('click', function () {
   	        $('#orgidWin').window({
   	            width: 800,
   	            height: 500,
   	            title:"新增",
   	            href:"${pageContent.request.contentPath}/system/orgid/add_01",
   	            modal: true,
   	            constrain: true,
   	        });
   	    });
   	    
   	    	var orgidId = null;
   	    	$("#tree").tree({
   				onSelect:function(node) {
   					orgidId = node.id;
   				}
   			})
   	    
   	    $("#orgidedit").on('click', function () {
   			if(orgidId == null) {
   				$.messager.alert('消息','没有选中行！');
   				return;
   			}
   	    	
   	        $('#orgidWin').window({
   	            width: 800,
   	            height: 500,
   	            title:"编辑",
   	            href:"${pageContent.request.contentPath}/system/orgid/edit_01?id="+orgidId,
   	            modal: true,
   	            constrain: true,
   	        });
   	    });
   </script>
</body>

</html>