var form_url="";//表单的URL
var item_url="";
//完成初始化
$(function(){
	 
});
//初始化字典类型的tree数据

//菜单的单击事件
function menuHandler(item){
	var name = item.name;
	switch(name){
		case 'new':addType();break;
		case 'edit':editType();break;
		case 'destroy':delType();break;
		default:alert("error");
	}
}
//添加字典类型
function addType(){
	var treeObj = $.fn.zTree.getZTreeObj("dicTypeTree");
	var nodes = treeObj.getSelectedNodes();
	 if(nodes&&nodes.length>0){
		 var selectedType = nodes[0];
		 console.info(selectedType);
		 xfui.open_dialog({    
			    title: '新增字典类型',    
			    width: 800,    
			    height: 300,    
			    closed: false,    
			    cache: false,    
			    url: CTX+ '/sys/dic/dictionaryType/edit.xf?parentId='+selectedType.id,    
			    modal: true   
			})	
	 
	 }
		
}
/**
 * 修改字典类型
 * 1.清除表单数据 2.加载表单数据 3.打开表单
 */
function editType(){
	var treeObj = $.fn.zTree.getZTreeObj("dicTypeTree");
	var nodes = treeObj.getSelectedNodes();
	var selectedType = nodes[0];
	xfui.open_dialog({    
	    title: '修改字典类型',    
	    width: 800,    
	    height: 300,    
	    closed: false,    
	    cache: false,    
	    url: CTX+ '/sys/dic/dictionaryType/edit.xf?id='+selectedType.id,    
	    modal: true   
	})		
}

/**
 * 
 *保存字典类型
 * */
function saveType(){
	$("#form_dictionary_type").form('submit',{
		url:form_url,
		onSubmit: function(form_data){
	        // do some check
			return $(this).form('validate');
	    },
	    success:function(data){
	    	var data = eval('(' + data + ')'); 
	    	if(data.result==1){
	    		init_tree("#tree_dictionary_type",CTX+"/sys/dic/dictionaryType/tree.xf");
	    		$("#win_dictionary_type").window("close");
	    	}
	    	show_message(data.message);
	    }
	});
}
/**
 * 
 * 删除
 */

function delType(){
	var treeObj = $.fn.zTree.getZTreeObj("dicTypeTree");
	var nodes = treeObj.getSelectedNodes();
	var selectedType = nodes[0];
		 
	if(selectedType.level==0){
		$.messager.alert("警告","不能删除根节点","warning");
		return;
	}
	$.messager.confirm('确认删除','您真的要删除'+selectedType.name+'?',function(r){
		if (r){
				$.post(CTX+"/sys/dic/dictionaryType/ajaxDel.xf",{id:selectedType.id},function(data){
			        if (data.result==1){
			        	  $.messager.alert("提示","删除成功！","info");
			        	  refreshTypeTree();
			        } 
			      
			    },'json');
		    	
		    }
	});
	 
}


/**
 * 提交表单
 */
function submit_form(form_selector,form_url,form_data){
		$(form_selector).form('submit',{
			url:form_url,
			onSubmit: function(form_data){
		        // do some check
				return $(this).form('validate');
		    },
		    success:function(data){
		    	var data = eval('(' + data + ')'); 
		    	if(data.result==1){
		    		init_tree("#tree_dictionary_type",CTX+"/sys/dic/dictionaryType/tree.xf");
		    		$("#win_dictionary_type").window("close");
		    	}
		    	show_message(data.message);
		    }
		});
	
}

 



/**
 * 消息提示
 */
function show_message(message,title){
	if(!title) title = "提示信息";
	$.messager.show({
		title:title,
		msg:message,
		timeout:5000,
		showType:'slide'
	});
};

/**
 * 删除信息
 * 
 */
function del(del_url,data){
	$.post(del_url,{id:data.id},function(data){
		var data = eval('(' + data + ')'); 
        if (data.result==1){
            show_messager("删除成功");
        } else {
        	show_messager(data.message);
        }
    },'json');
}
/**
 * 修改信息
 */
function edit(tree_selector,form_selector){
	var selected_node = $(tree_selector).tree("getSelected");
	$(form_selector).form('load',CTX+"/sys/dic/dictionaryType/getById.xf?id="+selected_node.id);
}
/**
 * 提交表单
 */
function form_submit(form_selector,data){
	$(form_selector).form('submit',{
		url:form_url,
		onSubmit: function(data){
	        // do some check
	        // return false to prevent submit;
	    },
	    success:function(data){
	    	console.info(data);
	    	var data = eval('(' + data + ')'); 
	    	if(data.result==1){
	    		add_success();
	    	}else{
	    	}
	    	show_message(data.message);
	    }
	});
}
/**
 *点击字典类型，的行为
 */
var columns = [[
                 {field:'id',checkbox:'true',width:10},
		 		 {field:'itemText',title:'名称',width:200},
		 		{field:'itemValue',title:'值',width:100},
		 		{field:'itemDesc',title:'描述',width:100}
            ]];
function init_dg_dictionary_item(tree_selector){
	var tree_selector= tree_selector?tree_selector:"#tree_dictionary_type";
	var type_node = $(tree_selector).tree("getSelected");
	$("#dg_toolbar").css("display","none");
	$("#dg_dic_item").datagrid({
		url: CTX+'/sys/dic/dictionaryItem/listJson.xf?typeId='+type_node.id,
		fitColumns:true,
		rownumbers: true,
		singleSelect: false,
		selectOnCheck: true,
		checkOnSelect: true,
		pagination: true, 
        rownumbers: true,
        multiSort:true,
        columns:columns,
        pageList:[1,5,10],
        toolbar: '#tb_type_item',
        onLoadSuccess:function(data){
        	if(data.total>0){
        		$(this).datagrid("selectRow",0);
        	}
        }
	});
}

/**
 * 刷新数据
 */
function refreash_dg_data(){
	var treeObj = $.fn.zTree.getZTreeObj("dicTypeTree");
	var nodes = treeObj.getSelectedNodes();
	 if(nodes&&nodes.length>0){
		 var selectedType = nodes[0];
		 $("#dg_toolbar").css("display","block");
		 if(selectedType.pId==0){
			 $("#dg_toolbar").css("display","none");
		 }
		 
			$("#dg_dic_item").datagrid({
				url:CTX+'/sys/dic/dictionaryItem/listJson.xf?typeId='+selectedType.id
			});
			
	 }
	
}


/**
 * 添加数据项
 */
function addItem(){
 
	var treeObj = $.fn.zTree.getZTreeObj("dicTypeTree");
	var nodes = treeObj.getSelectedNodes();
	  
		 var selectedType = nodes[0];
     xfui.open_dialog({    
 	    title: '新建字典项',    
 	    width: 800,    
 	    height: 300,    
 	    closed: false,    
 	    cache: false,    
 	    url: CTX+ '/sys/dic/dictionaryItem/edit.xf?typeId='+selectedType.id,    
 	    modal: true   
 	})		
}

//修改数据项
function editItem(){
	 var row = $('#dg_dic_item').datagrid('getSelected');
	 if(row){
		 xfui.open_dialog({    
		 	    title: '修改字典项',    
		 	    width: 800,    
		 	    height: 300,    
		 	    closed: false,    
		 	    cache: false,    
		 	    url: CTX+ '/sys/dic/dictionaryItem/edit.xf?id='+row.id,    
		 	    modal: true   
		 	})		 
	 }else{
		$.messager.alert("提示","请选择要修改的数据项！","info"); 
	 }
		 
		
}
//删除数据项
function delItem(){
	var select_rows =$('#dg_dic_item').datagrid("getSelections");
	if (select_rows.length == 0) {
		$.messager.alert('警告','请选择要删除的行！');
        return;
    }
 
    $.messager.confirm('确认','您确定要删除吗?',function(r){
         if (r){
        	   var select_ids="";
         		$.each(select_rows, function (index, item) {
         			select_ids += item.id + ",";
                 });
                 $.post(CTX+'/sys/dic/dictionaryItem/ajaxDel.xf',{id:select_ids},function(data){
                     if (data.result==1){
                         $('#dg_dic_item').datagrid('reload');    // reload the user data
                     } else {
                         show_message(data.message);
                     }
                 },'json');
             }
    });
	
}

//保存数据项
function saveItem(){
    $('#fm').form('submit',{
        url: item_url,
        onSubmit: function(){
            return $(this).form('validate');
        },
        success: function(data){
            var data = eval('('+data+')');
            if (data.result!=1){
            	show_message(data.message);
            } else {
                $('#dlg').dialog('close');        // close the dialog
                $('#dg_dic_item').datagrid('reload');    // reload the user data
            }
        }
    });
}


function refreshTypeTree(opt){
	var treeObj = $.fn.zTree.getZTreeObj("dicTypeTree");
	var nodes = treeObj.getSelectedNodes();
	 if(nodes&&nodes.length>0){
		 var selectedType = nodes[0];
		 initTypeTree();
		 
	 }
	
}


