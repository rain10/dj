var AM = function(){
	return{
		validata:function(options){
			for (var i=0;i<options.length;i++){
				var data = $("#"+options[i]).val();
				console.log(data);
				if($.trim(data) == '') {
					return false;
				} 
			}
			return true;
		},
		// 编辑器参数
		kingEditorParams : {
			//指定上传文件参数名称
			filePostName  : "uploadFile",
			//指定上传文件请求的url。
			uploadJson : '/pic/upload',
			//上传类型，分别为image、flash、media、file
			dir : "image"
		},
		createEditor : function(select){
	    	return KindEditor.create(select, AM.kingEditorParams);
	    },
		
	
	
	}
}(jQuery);


