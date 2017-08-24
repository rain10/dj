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
	            <div class="contentWrapper">
	               <div class="form-item">
	               <input type="hidden" id="uid" value="${sysUser.id }">
	                <input type="hidden" id="upassword" value="${sysUser.password }">
	                <input type="hidden" id="uhead" value="${sysUser.prphone }">
	                <input type="hidden" id="utype" value="0">
                        <label for="" class="label-top">用户名称：</label>
                        <input id="uname" class="easyui-validatebox easyui-textbox" 
                               data-options="required:true,validType:'length[3,10]'" style="width: 90%;" value="${sysUser.username }">
                    
                    </div>
                    <br>
                    <div class="form-item">
                        <label for="" class="label-top">真实姓名：</label>
                        <input id="rname" class="easyui-validatebox easyui-textbox" 
                               data-options="required:true" style="width: 90%;" value="${sysUser.realname }">
                    
                    </div>
                     <br>
                    <div class="form-item">
                        <label for="" class="label-top">电话号码：</label>
                        <input id="phone" class="easyui-validatebox easyui-textbox" 
                               data-options="required:false" style="width: 90%;" value="${sysUser.phone }">
                    
                    </div>
                     <br>
                    <div class="form-item">
                        <label for="" class="label-top">电子邮件：</label>
                        <input id="email" class="easyui-validatebox easyui-textbox" 
                               data-options="required:false" style="width: 90%;" value="${sysUser.email }">
                    
                    </div>
                     <br>
                     <div class="form-item">
                        <label for="" class="label-top">所在机构：</label>
                        <input id="orgid" class="easyui-combotree" style="width: 90%;height: 30px;" value="${sysUser.orgid }"  data-options="editable:false,panelHeight:null" name="orgid" >
                    
                    </div>
                    <br>
                    <div class="form-item">
                        <label for="" class="label-top">所属部门：</label>
                        <input id="user_dept" class="easyui-combobox" 
                                name="user_dept" style="width: 90%;" data-options="editable:false,panelHeight:null" value="" data-options="required:true">
                    </div>
                     <br>
                    <c:if test="${sysUser.enabled == null  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="enable" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="enabled" style="width: 90%;">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                    </c:if>
                      <c:if test="${sysUser.enabled == 1  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="enable" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="enabled" style="width: 90%;">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                    </c:if>
                      <c:if test="${sysUser.enabled == 0  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="enable" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="enabled" style="width: 90%;">
                            <option value="0">否</option>
                            <option value="1">是</option>
                            
                        </select>
                    </div>
                    </c:if>
                    </div>
                    </div>
             	<div title="角色配置" style="overflow:auto;padding:20px;display:none;">
					<div id="tb" style="height:auto">
						<div class="form-item">
                        <label for="" class="label-top">角色名称：</label>
                        <c:forEach items="${roles }" var="role">
                        <c:if test="${ role.checked == ''}">
                        <input id="${role.id }" name="role" type="checkbox"  value="${role.id }">${role.name }
                        </c:if>
                         <c:if test="${ role.checked == 'checked'}">
                        <input id="${role.id }" name="role" type="checkbox" checked="checked" value="${role.id }">${role.name }
                        </c:if>
                        </c:forEach>
                    </div>
					</div>
	            </div>
	    </div>      
   	 </div>
   	 		<div>
   	 			 <a id="usave" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-gears'" style="height: 30px;border-left-width: 1px;margin-left: 40%;">保存</a>
   	 			 <a id="uclose" onclick="closeWin()" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-tags'" style="height: 30px;border-left-width: 1px;">取消</a>
   	 		</div>
  		
</div>
</div>
<script type="text/javascript" src="/admin/js/arain.js"></script>
<script type="text/javascript">
var dept = '${sysUser.depid}'
$('#user_dept').combobox({ 
	valueField:'id',
	textField:'text',
	multiple:false,
	url:'${pageContent.request.contentPath}/system/department/load_01',
    onLoadSuccess: function () { //加载完成后,设置选中第一项 
        var val = $(this).combobox("getData"); 
         for (var i = 0;i<val.length;i++ ) { 
        	 if(dept!=null &&  $.trim(dept)!='' && dept != 0) {
            		 if(val[i].id == dept) {
            			 $(this).combobox("select",val[i].id); 
            	 }
        	 } else {
        		 $(this).combobox("select",val[0].id);  
        	 }
        	
        } 
    } 
}); 

$("#usave").click(function(){
	var array=new Array()
	array[0]="uname";
	array[1]="rname";
	var re = AM.validata(array);
	if(re == false) {
		return ;
	}
	
	var id = $("#uid").val();
	var head = $("#uhead").val();
	var type = $("#utype").val();
	var password = $("#upassword").val();
	var username = $("#uname").val();
	var realname = $("#rname").val();
	var phone = $("#phone").val();
	var email = $("#email").val();
	var enable = $("#enable").val();
	var orgid = $("#orgid").combotree("getValue"); 
	var dept = $("#user_dept").combobox("getValue");
	var chk_value =[]; 
	$('input[name="role"]:checked').each(function(){ 
	chk_value.push($(this).val()); 
	}); 
	
	var role = chk_value.toString();
	$.ajax({
		url:'${pageContent.request.contentPath}/system/user/save.do',
		data:{
			id:id,
			password:password,
			username:username,
			realname:realname,
			phone:phone,
			email:email,
			enabled:enable,
			roles:role,
			orgid:orgid,
			depid:dept,
			usertype:type,
			prphone:head
		},
		type: 'POST',
		dataType:'json',
		success: function(data){
				if (data.status ==200) {
					$.messager.alert('消息','保存成功');
					 	$("#usave").hide();
					 	$("#uclose").hide();
				} else {
					$.messager.alert('消息',data.msg);
				}
			},
			error:function(data) {
				
				console.log(data.data);	
			}
		})
	});
	
		var orgid = '${sysUser.orgid }';
		var orgid_f = '${orgid }'
		$('#orgid').combotree({    
		    url: '${pageContext.request.contextPath }/system/orgid/load_datagrid.do',    
		    required: true ,
		    onLoadSuccess: function (node, data) {
		    	if(orgid == null || orgid =='' || orgid == 0) {
		    		orgid = orgid_f;
				}
		    	$("#orgid").combotree('setValue',orgid);
		    	var t = $("#orgid").combotree('tree');//获取tree  
	            node= t.tree("find",orgid);  
	            console.log(node.target)
	            t.tree('select', node.target);
		}
		});
		

   </script>
</body>

</html>