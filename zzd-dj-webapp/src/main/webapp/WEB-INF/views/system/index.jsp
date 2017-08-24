 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<jsp:include page="/WEB-INF/views/system/common.jsp"></jsp:include>
<style>
</style>
<body style="margin: 0px;">
<%--     <img alt="welcom" width="820px;" height="385px" style="position: absolute;top: -70px;bottom: 0;left: 0;right: 0;margin: auto;" src="${pageContent.request.contentPath }/admin/img/welcome.jpg"> --%>
	<div style="margin-top: 0.5%">
		  	<div  style="opacity: 1;width:50%;height:46%; float:left " id="content_statistics" ></div>
		  	
		  	<div  style="opacity: 1;width:50%;height:46%; float:right " id="content_type" ></div>
		</div>
		
		<div style="margin-top: 3%">
		  	<div  style="opacity: 1;width:90%;height:46%; float:center " id="line_01" ></div>
		</div>
</body>
<script type="text/javascript" src="/admin/build/dist/echarts.js"></script>
<script type="text/javascript">
//路径配置
require.config({
    paths: {
        echarts: '/admin/build/dist'
    }
});
// 使用
require(
    [
        'echarts',
        'echarts/chart/line', // 使用柱状图就加载bar模块，按需加载
        'echarts/chart/pie',
        'echarts/chart/bar'
    ],
    function (ec) {
    	var main = document.getElementById('content_statistics');
    	
    	var type = document.getElementById('content_type');
    	
    	var line = document.getElementById('line_01');

    	var myChart = ec.init(main);
    	var myType =  ec.init(type);
    	var myLine =  ec.init(line);
    	do_count(myChart);
    	do_type(myType);
    	do_line(myLine);
    }
   )
   
   function do_count(myChart) {
  	var time=[];
	var count = [];

    //图表显示提示信息
    myChart.showLoading();
    //定义图表options
    var options = {
    	    tooltip : {
    	        trigger: 'axis'
    	    },
    	    legend: {
    	        data:['一周文章发布或修改量']
    	    },
    	    toolbox: {
    	        show : true,
    	        feature : {
    	        	dataView: {show: true, readOnly: false},
    	        	restore : {show: true},
    	            saveAsImage : {show: true}
    	        }
    	    },
    	    calculable : true,
    	    xAxis : [
    	        {
    	            type : 'category',
    	            boundaryGap : false,
    	            data : []
    	        }
    	    ],
    	    yAxis : [
    	        {
    	            type : 'value',
    	            axisLabel : {
    	                formatter: '{value} 次'
    	            }
    	        }
    	    ],
    	    series : [
    	        {
    	            type:'line',
    	            data:[],
    	        }
    	    ]
    };

    //通过Ajax获取数据
    $.ajax({
        type : "post",
        async : false, //同步执行
        url : "${pageContent.request.contentPath}/content/count",
        dataType : "json", //返回数据形式为json
        success : function(result) {
            if (result.status==200) {
                //将返回的category和series对象赋值给options对象内的category和series
                //因为xAxis是一个数组 这里需要是xAxis[i]的形式
                for(var i = 0;i<result.data.length;i++) {
                	time.push(result.data[i].time);
                	count.push(result.data[i].count);
           		 }
                options.xAxis[0].data = time;
                options.series[0].data = count;

                myChart.hideLoading();
                myChart.setOption(options);
            }
        },
        error : function(errorMsg) {
            alert("图表请求数据失败啦!");
        }
    });
}
	function do_type(myChart) {
		var lenarr = [];
		//图表显示提示信息
	    myChart.showLoading();
	    option = {
	    	    title : {
	    	        x:'right',
	    	        y:'bottom'
	    	    },
	    	    tooltip : {
	    	        trigger: 'item',
	    	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    	    },
	    	    legend: {
	    	        orient : 'vertical',
	    	        x : 'left',
	    	        data:[]
	    	    },
	    	    toolbox: {
	    	        show : true,
	    	        feature : {
	    	        	dataView: {show: true, readOnly: false},
	    	        	restore : {show: true},
	    	            saveAsImage : {show: true}
	    	        }
	    	    },
	    	    calculable : false,
	    	    series : (function (){
	    	        var series = [];
	    	        for (var i = 0; i < 30; i++) {
	    	            series.push({
	    	                name:'文章发布分布',
	    	                type:'pie',
	    	                itemStyle : {normal : {
	    	                    label : {show : i > 28},
	    	                    labelLine : {show : i > 28, length:20}
	    	                }},
	    	                radius : [i * 4 + 40, i * 4 + 43],
	    	                data:[
	    	                ]
	    	            })
	    	        }
	    	        series[0].markPoint = {
	    	            symbol:'emptyCircle',
	    	            symbolSize:series[0].radius[0],
	    	            effect:{show:true,scaleSize:12,color:'rgba(250,225,50,0.8)',shadowBlur:10,period:30},
	    	            data:[{x:'50%',y:'50%'}]
	    	        };
	    	        return series;
	    	    })()
	    	};
	    	setTimeout(function (){
	    	    var _ZR = myChart.getZrender();
	    	    var TextShape = require('zrender/shape/Text');
	    	    // 补充千层饼
	    	    _ZR.addShape(new TextShape({
	    	        style : {
	    	            x : _ZR.getWidth() / 2,
	    	            y : _ZR.getHeight() / 2,
	    	            color: '#666',
	    	            text : '文章发布占比',
	    	            textAlign : 'center'
	    	        }
	    	    }));
	    	    _ZR.addShape(new TextShape({
	    	        style : {
	    	            x : _ZR.getWidth() / 2 + 200,
	    	            y : _ZR.getHeight() / 2,
	    	            brushType:'fill',
	    	            color: 'orange',
	    	            textAlign : 'left',
	    	            textFont:'normal 20px 微软雅黑'
	    	        }
	    	    }));
	    	    _ZR.refresh();
	    	}, 2000);

	    	        
	        //通过Ajax获取数据
	        $.ajax({
	            type : "post",
	            async : false, //同步执行
	            url : "${pageContent.request.contentPath}/content/type",
	            dataType : "json", //返回数据形式为json
	            success : function(result) {
	                if (result.status==200) {
	                	console.log(option.series)
	                	for (var i = 0; i < 30; i++) {
	                		option.series[i].data=result.data;
	                	}
	                	
	                	for(var i = 0;i<result.data.length;i++) {
	                		lenarr.push(result.data[i].name);
	               		 }
	                	option.legend.data = lenarr;
	                	
	                    myChart.hideLoading();
	                    myChart.setOption(option);
	                }
	            },
	            error : function(errorMsg) {
	                alert("图表请求数据失败啦!");
	            }
	        });
	    
	    
	    	                    
	}
	   function do_line(myChart) {

		    //图表显示提示信息
		    myChart.showLoading();
		    //定义图表options
		    var option = {
		    	    title: {
		    	        x: 'center',
		    	        text: '考试人数统计',
		    	    },
		    	    tooltip: {
		    	        trigger: 'item'
		    	    },
		    	    toolbox: {
		    	        show: true,
		    	        feature: {
		    	            dataView: {show: true, readOnly: false},
		    	            restore: {show: true},
		    	            saveAsImage: {show: true}
		    	        }
		    	    },
		    	    calculable: true,
		    	    grid: {
		    	        borderWidth: 0,
		    	        y: 80,
		    	        y2: 60
		    	    },
		    	    xAxis: [
		    	        {
		    	            type: 'category',
		    	            show: false,
		    	            data: []
		    	        }
		    	    ],
		    	    yAxis: [
		    	        {
		    	            type: 'value',
		    	            show: false
		    	        }
		    	    ],
		    	    series: [
		    	        {
		    	            name: '考试人数',
		    	            type: 'bar',
		    	            itemStyle: {
		    	                normal: {
		    	                    color: function(params) {
		    	                        // build a color map as your need.
		    	                        var colorList = [
		    	                          '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
		    	                           '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
		    	                           '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
		    	                        ];
		    	                        return colorList[params.dataIndex]
		    	                    },
		    	                    label: {
		    	                        show: true,
		    	                        position: 'top',
		    	                        formatter: '{b}\n{c}'
		    	                    }
		    	                }
		    	            },
		    	            data: [12,21,10,4,12,5,6,5,25,23,7],
		    	            markPoint: {
		    	                tooltip: {
		    	                    trigger: 'item',
		    	                    backgroundColor: 'rgba(0,0,0,0)',
		    	                    formatter: function(params){
		    	                        return '<img src="' 
		    	                                + params.data.symbol.replace('image://', '')
		    	                                + '"/>';
		    	                    }
		    	                },
		    	                data: [
		    	                ]
		    	            }
		    	        }
		    	    ]
		    	};
		    
		    
		    
	        //通过Ajax获取数据
	        $.ajax({
	            type : "post",
	            async : false, //同步执行
	            url : "${pageContent.request.contentPath}/exam/statistics",
	            dataType : "json", //返回数据形式为json
	            success : function(result) {
	                if (result.status==200) {
	                	
	                	option.series[0].data = result.data.count;
	                	option.series[0].markPoint.data=result.data.statistics;
	                	option.xAxis[0].data=result.data.name;
						
	                	myChart.hideLoading();
	                    myChart.setOption(option);
	                }
	            },
	            error : function(errorMsg) {
	                alert("图表请求数据失败啦!");
	            }
	        });
		    	                    
		    
		 
		}
</script>
</html>