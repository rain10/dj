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
	            <div title="基础配置" style="padding:20px;display:none;">
	            <input type="hidden" id="roleid" value="${sysRole.id }">
	            <div class="contentWrapper">
	                 <div class="form-item">
                        <label for="" class="label-top">角色名称：</label>
                        <input id="rolename" class="easyui-validatebox easyui-textbox" 
                               data-options="required:true" style="width: 90%;" value="${sysRole.name }">
                    </div>
                     <br>
                    <div class="form-item">
                        <label for="" class="label-top">角色排序：</label>
                        <input id="rolesort" class="easyui-validatebox easyui-numberbox" 
                               data-options="required:false" style="width: 90%;" value="${sysRole.sort }">
                    </div>
                     <br>
                    <c:if test="${sysRole.enabled == null }">
                    	 <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="roleenabled" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="enabled" style="width: 90%;">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                    </c:if>
                    
                     <c:if test="${sysRole.enabled == 1 }">
                    	 <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="roleenabled" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="enabled" style="width: 90%;">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                    </c:if>
                    
                     <c:if test="${sysRole.enabled == 0 }">
                    	 <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="roleenabled" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="enabled" style="width: 90%;">
                            <option value="0">否</option>
                            <option value="1">是</option>
                        </select>
                    </div>
                    </c:if>
                     <br>
                    
                     <div class="form-item">
                        <label for="" class="label-top">角色描述：</label>
                        <input id="roledescrition" class="easyui-validatebox easyui-textbox" 
                               data-options="required:false" style="width: 90%;" value="${sysRole.description }">
                    </div>
	            </div>
	            <br>
					 <div class="form-item">
                        <label for="" class="label-top">所属资源：</label>
                         <ul id="retree"></ul>  	
                    <div>
	            	</div>
	            </div>
	
	            </div>
	        </div>
	    </div>      
   	 </div>
   	 		<div>
   	 			 <a id="rolesave" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-gears'" style="height: 30px;border-left-width: 1px;margin-left: 40%;">保存</a>
   	 			 <a onclick="closeWin()" id="roleclose" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-tags'" style="height: 30px;border-left-width: 1px;">取消</a>
   	 		</div>
  		
</div>
<script type="text/javascript" src="/admin/js/arain.js"></script>
<script type="text/javascript">
  	$(function() {
  	    
        var id = $("#roleid").val();
        if(id != "") {
        	$('#retree').tree({
             url: '${pageContent.request.contentPath}/system/resource/load_tree_role.do?id='+id,
             parentField: 'parentId',
             checkbox: true,
             animate: true
         });
        }
  	     
  	  $('#retree').tree({
          url: '${pageContent.request.contentPath}/system/resource/load_tree.do',
          parentField: 'parentId',
          checkbox: true,
          animate: true
      });
  	  
  	});
  	
  	$("#rolesave").click(function(){
  		var array=new Array()
  		array[0]="rolename";
  		var re = AM.validata(array);
  		if(re == false) {
  			return ;
  		}
  		
  		var id = $("#roleid").val();
  		var name = $("#rolename").val();
  		var sort = $("#rolesort").val();
  		var description = $("#roledescrition").val();
  		var enabled = $("#roleenabled").val();
  		
  		
  		var nodes = jQuery('#retree').tree('getChecked', [ 'checked', 'indeterminate' ]);
		var myArray = new Array();
		for (var i = 0; i < nodes.length; i++) {
			var resourcesJson = new Object();
			resourcesJson.checked = nodes[i].checked?'1':'0';
			resourcesJson.resourcesIds = nodes[i].id;
			myArray.push(resourcesJson);
		}
		var resourceIds = JSON.stringify(myArray);
  		$.ajax({
  			url:'${pageContent.request.contentPath}/system/role/save.do',
  			data:{
  				id:id,
  				name:name,
  				sort:sort,
  				description:description,
  				enabled:enabled,
  				resourceIds:resourceIds
  			},
  			type: 'POST',
  			dataType:'json',
  			success: function(data){
  					if (data.status ==200) {
  						
  						$.messager.alert('消息','保存成功！');
  						$("#rolesave").hide();
  						$("#roleclose").hide();
  					}
  				},
  				error:function(data) {
  					
  					console.log(data.data);	
  				}
  			})
		});

  	
   </script>
</body>

</html>