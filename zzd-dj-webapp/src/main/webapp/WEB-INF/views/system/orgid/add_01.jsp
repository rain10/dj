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
<div id="index">
    <div class="contentWrapper">
          	<!--tab-->
	    <div class="index-l">
	        <div id="tt" class="easyui-tabs" data-options="tabHeight:31" style="width:100%;">
	            <div title="机构设置" style="padding:20px;display:none;">
	               <div class="form-item">
	                <input type="hidden" id="orgidid" value="${orgid.id }">
                        <label for="" class="label-top">机构名称：</label>
                        <input id="orgidname" class="easyui-validatebox easyui-textbox" 
                               data-options="required:true" style="width: 90%;" value="${orgid.name }">
                    
                    </div>
                     <br>
                    <c:if test="${orgid.enabled == null  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="orgidenable" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="orgidenabled" style="width: 90%;">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                    </c:if>
                      <c:if test="${orgid.enabled == 1  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="orgidenable" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="orgidenable" style="width: 90%;">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                    </c:if>
                      <c:if test="${orgid.enabled == 0  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="orgidenable" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="orgidenable" style="width: 90%;">
                            <option value="0">否</option>
                            <option value="1">是</option>
                            
                        </select>
                    </div>
                    </c:if>
                     <br>
                   <div class="form-item">
                        <label for="" class="label-top">所属机构：</label>
                        <input id="orgidpid" class="easyui-combotree" style="width: 90%;height: 30px;" value="${orgid.pid }"  data-options="editable:false,panelHeight:null" name="pid" >
                    </div>
                    
                    </div>
                    </div>
	    </div>      
   	 </div>
   	 		
  		
</div>

			<div>
   	 			 <a id="orgidsave" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-gears'" style="height: 30px;border-left-width: 1px;margin-left: 40%;">保存</a>
   	 			 <a id="orgidclose" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-tags'" style="height: 30px;border-left-width: 1px;">取消</a>
   	 		</div>
</div>
<script type="text/javascript" src="/admin/js/arain.js"></script>
<script type="text/javascript">
  $("#orgidclose").click(function(){
	$("#orgidWin").dialog('close')
	});
	
$("#orgidsave").click(function(){
	var array=new Array("orgidname")
	var re = AM.validata(array);
	if(re == false) {
		return ;
	}
	
	var pid = $("#orgidpid").combotree("getValue"); 
	var enabled = $("#orgidenable").val();
	var name = $("#orgidname").val();
	var id = $("#orgidid").val();
	$.ajax({
		url:'${pageContent.request.contentPath}/system/orgid/save.do',
		data:{
			name:name,
			enabled:enabled,
			pid:pid,
			id:id
		},
		type: 'POST',
		dataType:'json',
		success: function(data){
				if (data.status ==200) {
					$.messager.alert('消息','保存成功');
					 	$("#orgidsave").hide();
					 	$("#orgidclose").hide();
				}
			},
			error:function(data) {
				
				console.log(data.data);	
			}
		})
	});
$(function () {
var parentId = '${orgid.pid}';

$('#orgidpid').combotree({    
    url: '${pageContext.request.contextPath }/system/orgid/load_tree.do',    
    required: false ,
    onLoadSuccess: function (node, data) {
    	console.log(parentId)
    	if(parentId != null && parentId !='' && parentId != 0) {
    	var t = $("#orgidpid").combotree('tree');//获取tree  
            node= t.tree("find",parentId);  
            $("#orgidpid").combotree('tree').tree('select', node.target);
    	}
	}
});
		
})
   </script>
</body>

</html>