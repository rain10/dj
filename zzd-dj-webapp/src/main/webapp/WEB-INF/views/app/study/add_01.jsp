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
    </style>
</head>

<body>
<script type="text/javascript" src="/admin/webuploader/webuploader.min.js"></script>
<link rel="stylesheet" href="/admin/webuploader/webuploader.css">
<script type="text/javascript" src="/admin/webuploader/upload.js"></script>
<script type="text/javascript" src="/admin/webuploader/underscore-min.js"></script>
<link rel="stylesheet" href="/admin/webuploader/style.css">
<div id="index">
    <div class="contentWrapper">
          	<!--tab-->
	    <div class="index-l">
	        <div id="tt" class="easyui-tabs" data-options="tabHeight:31" style="width:100%;">
	            <div title="基本信息" style="padding:20px;display:none;">
	            <div class="contentWrapper">
	               <div class="form-item">
	               <input type="hidden" id="news_id" value="${news.id }">
	                <input type="hidden" id="contentType" value="${contentType}">
	                <input type="hidden" id="newstype" value="${news.type }">
	               	<input type="hidden" id="attachmentsType" value="2">
                        <label for="" class="label-top">标&emsp;&emsp;题：</label>
                        <input id=newstitle class="easyui-validatebox easyui-textbox" 
                               data-options="required:true,validType:'length[0,30]'" style="width: 90%;" value="${news.title }">
                    
                    </div>
                    <br>
                    <div class="form-item">
                        <label for="" class="label-top">来源(不填为所属部门)：</label>
                        <input id="newsother" class="easyui-validatebox easyui-textbox" 
                               data-options="required:false" style="width: 81%;" value="${news.other }">
                    
                    </div>
                     <br>
                    <c:if test="${news.recommend == null  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否推荐：</label>
                        <select id="news_recommend" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="news_recommend" style="width: 90%;">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                    </c:if>
                      <c:if test="${news.recommend == 1  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否推荐：</label>
                        <select id="news_recommend" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="news_recommend" style="width: 90%;">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                    </c:if>
                      <c:if test="${news.recommend == 0  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否推荐：</label>
                        <select id="news_recommend" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="news_recommend" style="width: 90%;">
                            <option value="0">否</option>
                            <option value="1">是</option>
                            
                        </select>
                    </div>
                    </c:if>
                    
                     <br>
                    <c:if test="${news.enabled == null  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="news_enabled" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="news_enabled" style="width: 90%;">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                    </c:if>
                      <c:if test="${news.enabled == 1  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="news_enabled" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="news_enabled" style="width: 90%;">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                    </c:if>
                      <c:if test="${news.enabled == 0  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="news_enabled" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="news_enabled" style="width: 90%;">
                            <option value="0">否</option>
                            <option value="1">是</option>
                            
                        </select>
                    </div>
                    </c:if>
                    <br>
<!--                     <div id="uploadimg">  -->
<!--  						<div id="fileList" class="uploader-list"></div>  -->
<!--  						<div class="label-top"  id="imgPicker">选择图片</div>  -->
<!-- 					</div> -->
<!-- 					<div id="wrapper">
        
            <!--头部，相册选择和格式选择-->
<div id="container">
            <div id="uploader">
                <div class="queueList">
                    <div id="dndArea" class="placeholder">
                        <div id="filePicker"></div>
                        <p>或将照片拖到这里，单次最多可选10张</p>
                    </div>
                </div>
                <div class="statusBar" style="display:none;">
                    <div class="progress">
                        <span class="text">0%</span>
                        <span class="percentage"></span>
                    </div><div class="info"></div>
                    <div class="btns">
                        <div id="filePicker2"></div><div class="uploadBtn">开始上传</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
<%--     			<c:if test="${images != null }"> --%>
<!-- 					<div class="queueList"> -->
<!-- 						<ul class="filelist"> -->
<%-- 						<c:forEach items="${images }" var="image"> --%>
<!-- 							<li> -->
<!-- 								<p> -->
<%-- 									<img alt="" src="${image.url }"> --%>
<!-- 								</p> -->
<!-- 							</li> -->
<%-- 							</c:forEach> --%>
<!-- 						</ul> -->
<%-- 						</c:if> --%>
<%-- 					 <c:forEach items="${images }" var="image"> --%>
<%--                         <div id="${image.id }" class="webuploader-container"> --%>
<%-- 	                        <img src="${image.url }" /> --%>
<!-- 	                         <div class="viewThumb"></div> -->
<!--               			</div> -->
<%--               			</c:forEach> --%>
<!--       				 </div> -->
             	<div title="图文编辑" style="overflow:auto;padding:20px;display:none;">
					<div id="tb" style="height:auto">
						<div class="form-item">
                        <script id="editor" type="text/plain" style="width:100%;height:90%;"></script>
                    </div>
					</div>
	            </div>
	    </div>      
   	 </div>
   	 		<div>
   	 			 <a id="news_save" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-gears'" style="height: 30px;border-left-width: 1px;margin-left: 40%;">保存</a>
   	 			 <a id="news_close" onclick="closeWin('conten_grid')" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-tags'" style="height: 30px;border-left-width: 1px;">取消</a>
   	 		</div>
  		
</div>
</div>
<script type="text/javascript" src="/admin/js/arain.js"></script>
<script type="text/javascript" charset="utf-8" src="/admin/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/admin/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="/admin/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
var ue = UE.getEditor('editor');
var arr = [];// 创建数组
// var attachmentsType = 1;
// //a.push(1); // 添加到最后
// $('#imgPicker').diyUpload({
// 	url:'/images/upload',
// 	success:function( data ) {
// 		if(data.code==0) {
// 			arr.push(data.url);
// 			console.log(arr+"------")
// 		}
// 	},
// 	error:function( err ) {
// 		console.info( err );	
// 	}
// });
$("#news_save").click(function(){
	var array=new Array()
	array[0]="newstitle";
	var re = AM.validata(array);
	if(re == false) {
		return ;
	}
	
	
	var contentType;
	if($.trim('${news.type }') != '') {
		contentType = '${news.type }';	
	} else {
		contentType = '${contentType}';
	}
	
	var id = '${news.id }';
	var title = $("#newstitle").val();
	var other = $("#newsother").val();
	var recommend = $("#news_recommend").combobox('getValue');
	var enabled = $("#news_enabled").combobox('getValue');
	var content = UE.getEditor('editor').getContent();
	var image = arr.toString();
	
	$.ajax({
		url:'${pageContent.request.contentPath}/app/study/save.do',
		data:{
			id:id,
			title:title,
			other:other,
			recommend:recommend,
			enabled:enabled,
			newscontent:content,
			type:contentType,
			imageId:image
		},
		type: 'POST',
		dataType:'json',
		success: function(data){
				if (data.status ==200) {
					$.messager.alert('消息','保存成功');
					 	$("#news_save").hide();
					 	$("#news_close").hide();
				}
			},
			error:function(data) {
				
				console.log(data.data);	
			}
		})
	});
	
		
		
		
ue.addListener("ready", function () {  
            // editor准备好之后才可以使用  
            var news_content = '${news.content}';
// 			console.log(news_content)
			if(news_content!=null) {
			ue.setContent(news_content);
		}

    }); 
	
	
		
	
	UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
    UE.Editor.prototype.getActionUrl = function(action) {
        if (action == 'uploadimage' || action == 'uploadscrawl' || action == 'uploadimage') {
            var url = 'http://127.0.0.1:8080/common/upload?attachmentsType=2';
            return url;
        } else if (action == 'uploadvideo') {
            return 'http://127.0.0.1:8080/common/upload?attachmentsType=2';
        } else {
            return this._bkGetActionUrl.call(this, action);
        }
    }
 



 	</script>
</body>

</html>