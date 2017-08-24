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
	            <div title="信息详情" style="padding:20px;display:none;">
	            <div class="contentWrapper">
					<div id="tb" style="height:auto">
						<div class="form-item">
                        <script id="editor" type="text/plain" style="width:100%;height:90%;"></script>
                    </div>
					</div>
	            </div>
           
</div>
</form>
</div>
<div id="seeWin" style="display: none;"> 
<script type="text/javascript" src="/admin/js/arain.js"></script>
<script type="text/javascript" charset="utf-8" src="/admin/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/admin/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="/admin/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
var ue = UE.getEditor('editor');

ue.addListener("ready", function () {  
    // editor准备好之后才可以使用  
    var news_content = '${content}';
//		console.log(news_content)
	if(news_content!=null) {
	ue.setContent(news_content);
}

}); 

 	</script>
</body>

</html>