$(function(){
	initCorpDatagrid();
	
});

var columns=[[
				{field:'id',checkbox:true,width:100},
				{field:'title',title:'标题',width:100},
				{field:'code',title:'配置项',width:150},
				{field:'content',title:'内容',width:150},
				{field:'url',title:'URL',width:150},
				{field:'description',title:'描述',width:100},
	            {field:'createTime',title:'创建时间',width:150},
	             {field:'createUserName',title:'创建者',width:150} 
            ]];
 
function initCorpDatagrid(){
	$("#dgConfig").datagrid({
		url:CTX+"/sys/config/sysConfig/listJson.xf",
		pagination:true,
		rownumbers:true,
		onLoadSuccess:function(data){
			console.info(data);
			if(data.total>0){
				$(this).datagrid("selectRow",0);
			}
			
		},
		singleSelect:true,
		fitColumns:true,
		columns:columns
	});
}
function refresh(){
	$("#dgConfig").datagrid("reload");
}


function addConfig(){
	 
	xfui.open_dialog({    
	    title: '添加配置信息',    
	    width: 800,  
	    height:300,
	    closed: false,    
	    cache: false,    
	    url: CTX+"/sys/config/sysConfig/edit.xf",    
	    modal: true   
	})		
}

function editConfig(){
	var row = $("#dgConfig").datagrid("getSelected");
	if(row){
		xfui.open_dialog({    
		    title: '修改配置信息',    
		    width: 800,  
		    height:300,
		    closed: false,    
		    cache: false,    
		    url: CTX+"/sys/config/sysConfig/edit.xf?id="+row.id,    
		    modal: true   
		})	
	}else{
		$.messager.alert("提示","请选择要操作的行！","info");
	}
		
}


/**
 * 删除人员信息
 */
function delConfig(){
	datagrid_del({
		url:CTX+'/sys/config/sysConfig/ajaxDel.xf',
		selector:"#dgConfig",
		callback:function(data){
			if (data.result==1){
                $('#dgConfig').datagrid('reload');    // reload the user data
            } else {
            	$.messager.alert("提示","删除失败"+data.message,"error");

            }
		}
	});
}

 
 
function datagrid_del(opt){
	var url=opt.url;
	var dg_selector = opt.selector;
	var select_rows =$(dg_selector).datagrid("getSelections");
	if (select_rows.length == 0) {
		$.messager.alert('警告','请选择要删除的行！');
        return;
    }
 
    $.messager.confirm('确认','您确定要删除吗?',function(r){
         if (r){
        	   var select_ids="";
         		$.each(select_rows, function (index, item) {
         			select_ids += item["id"]+ ",";
                 });
                 $.post(url,{id:select_ids},function(data){
                	 opt.callback(data);
                 },'json');
             }
    });
}
