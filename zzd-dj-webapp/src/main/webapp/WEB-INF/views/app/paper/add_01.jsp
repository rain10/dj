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
	            <div title="基本信息" style="padding:20px;display:none;">
	            <div class="contentWrapper">
	               <div class="form-item">
	               <input type="hidden" id="news_id" value="${paper.id }">
                        <label for="" class="label-top">试卷名称：</label>
                        <input id="papertitle" class="easyui-validatebox easyui-textbox" 
                               data-options="required:true,validType:'length[0,30]'" style="width: 90%;" value="${paper.title }">
                    
                    </div>
                    <br>
                          <div class="form-item">
                        <label for="" class="label-top">所属类型：</label>
                        <select id="paper_answer_type" class="easyui-combobox" 
                                name="paper_answer_type" style="width: 90%;" value="${question.type}">
                        </select>
                    </div>
                    <br>
                     <!--表格-->
                     <div class="form-item">
			       		<input id="paper_question_search"  class="easyui-textbox" style="width: 35%;" data-options="iconCls:'fa fa-user',iconAlign:'left'"
                               prompt="搜索题目">
                               	</div>
					    <div class="index-l">
					        <table id="question_dg"></table>
					    </div>
                     <br>
<%--                     <c:if test="${paper.ing == null  }"> --%>
<!--                           <div class="form-item"> -->
<!--                         <label for="" class="label-top">是否开始：</label> -->
<!--                         <select id="paper_ing" class="easyui-combobox" data-options="editable:false,panelHeight:null" -->
<!--                                 name="paper_ing" style="width: 90%;"> -->
<!--                             <option value="1">是</option> -->
<!--                             <option value="0">否</option> -->
<!--                         </select> -->
<!--                     </div> -->
<%--                     </c:if> --%>
<%--                       <c:if test="${paper.ing == 1  }"> --%>
<!--                           <div class="form-item"> -->
<!--                         <label for="" class="label-top">是否开始：</label> -->
<!--                         <select id="paper_ing" class="easyui-combobox" data-options="editable:false,panelHeight:null" -->
<!--                                 name="paper_ing" style="width: 90%;"> -->
<!--                             <option value="1">是</option> -->
<!--                             <option value="0">否</option> -->
<!--                         </select> -->
<!--                     </div> -->
<%--                     </c:if> --%>
<%--                       <c:if test="${paper.ing == 0  }"> --%>
<!--                           <div class="form-item"> -->
<!--                         <label for="" class="label-top">是否开始：</label> -->
<!--                         <select id="paper_ing" class="easyui-combobox" data-options="editable:false,panelHeight:null" -->
<!--                                 name="paper_ing" style="width: 90%;"> -->
<!--                             <option value="0">否</option> -->
<!--                             <option value="1">是</option> -->
                            
<!--                         </select> -->
<!--                     </div> -->
<%--                     </c:if> --%>
<!--                      <br> -->
                    <c:if test="${paper.enabled == null  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="paper_enabled" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="paper_enabled" style="width: 90%;">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                    </c:if>
                      <c:if test="${paper.enabled == 1  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="paper_enabled" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="paper_enabled" style="width: 90%;">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                    </c:if>
                      <c:if test="${paper.enabled == 0  }">
                          <div class="form-item">
                        <label for="" class="label-top">是否可用：</label>
                        <select id="paper_enabled" class="easyui-combobox" data-options="editable:false,panelHeight:null"
                                name="paper_enabled" style="width: 90%;">
                            <option value="0">否</option>
                            <option value="1">是</option>
                            
                        </select>
                    </div>
                    </c:if>
                    <br>
    </div>
    </div>
	    </div>      
   	 </div>
   	 		<div>
   	 			 <a id="paper_save" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-gears'" style="height: 30px;border-left-width: 1px;margin-left: 40%;">保存</a>
   	 			 <a id="paper_close" onclick="closeWin()" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'fa fa-tags'" style="height: 30px;border-left-width: 1px;">取消</a>
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
var type = '${questionids}';
// alert(type)
var typeArray=type.split(",");
$('#paper_answer_type').combobox({ 
	valueField:'id',
	textField:'text',
	multiple:true,
	url:'${pageContent.request.contentPath}/app/type/load_type',
//     onLoadSuccess: function () { //加载完成后,设置选中第一项 
//         var val = $(this).combobox("getData"); 
//          for (var i = 0;i<val.length;i++ ) { 
//         	 for(var j=0;j<typeArray.length;j++) {
//         		 if(val[i].id == typeArray[j]) {
//         			 $(this).combobox("select",val[i].id); 
//         		 }
//         	 }
//         } 
//     } 
}); 
$("#paper_save").click(function(){
	var array=new Array()
	array[0]="papertitle";
	var re = AM.validata(array);
	if(re == false) {
		return ;
	}
	var oo = $('#question_dg').datagrid('getSelections');
	var arr = [];
	if(oo!=null) {
		for(var i=0;i<oo.length;i++){
			arr.push(oo[i].ID_);
		}
	}
	var id = '${paper.id }';
	var title = $("#papertitle").val();
	var enabled = $("#paper_enabled").combobox('getValue');
// 	var ing = $("#paper_ing").combobox('getValue');
	var queations = arr.toString();
	$.ajax({
		url:'${pageContent.request.contentPath}/app/paper/save.do',
		data:{
			id:id,
			title:title,
			enabled:enabled,
			questions:queations,
// 			ing:ing
		},
		type: 'POST',
		dataType:'json',
		success: function(data){
				if (data.status ==200) {
					$.messager.alert('消息','保存成功');
					 	$("#paper_save").hide();
					 	$("#paper_close").hide();
				}
			},
			error:function(data) {
				
				console.log(data.data);	
			}
		})
	});
	
jQuery('#question_dg').datagrid({
    url: '${pageContent.request.contentPath}/app/examination/paper_loadgrid.do',
    pagination : true,//分页控件
    pageList: [10, 20, 30, 40, 50],
    fit: false,   //自适应大小
    border:false,
    nowrap: true,//数据长度超出列宽时将会自动截取。
    rownumbers:true,//行号
    fitColumns:true,//自动使列适应表格宽度以防止出现水平滚动。
    singleSelect:false,
    collapsible:true,
    idField:'ID_',
    columns: [
        [{
            field: 'ID_',
            title: 'id',
            align: 'center',
            hidden:'true',
            sortable: true
        }, 
        {
            field: 'title_',
            title: '题目',
            width: 100,
            align: 'center',
            sortable: true
        }, 
        {
            field: 'manager_',
            title: '经办人',
            width: 100,
            align: 'center',
            sortable: true
        }, {
            field: 'manager_time_',
            title: '经办时间',
            width: 100,
            align: 'center',
            sortable: true
        }]
    ],
    onLoadSuccess: function () { //加载完成后,设置选中第一项 
if(type[0] != null) {
	 //获取数据列表中的所有数据
    var rows = $("#question_dg").datagrid("getRows");
    //循环数据找出列表中ID和需要选中数据的ID相等的数据并选中
    for(var i=0;i<rows.length;i++){
      var rowId = rows[i].ID_;
      for(var j=0;j<typeArray.length;j++){
        if(rowId==typeArray[j]){
          var index = $("#question_dg").datagrid("getRowIndex",rows[i])
          $("#question_dg").datagrid("selectRow",index);
        }
      }
    }

} 
    	
 } 
});

$('#paper_question_search').textbox({  
	onChange: function(value) {
        $('#question_dg').datagrid('load', {    
  		  title: $("#paper_question_search").textbox("getValue")
  		});  
    }
});

$('#paper_answer_type').combobox({ 
	onChange:function(value){
		answertype=$('#paper_answer_type').combobox('getValues');
		var type = answertype.toString();
		$('#question_dg').datagrid('load', {    
			type:type
	  	});  
	}
})
 	</script>
</body>

</html>