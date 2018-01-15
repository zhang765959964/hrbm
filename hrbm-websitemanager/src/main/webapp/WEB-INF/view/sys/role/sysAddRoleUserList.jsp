<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp" %>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />

<link rel="stylesheet" href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css" type="text/css">
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/jquery/bootstrap-contextmenu.js"></script>
<title>角色人员管理</title>
	<script>
	$(function(){
		/**
		 初始化表格显示
		*/
		var columns= [[ {field:'acd230',title:'Id号',width:100,align:'center',visible:false},
		                {field:'state',title:'Id号',checkbox:'true',width:'5%',align:'center'},
		                {field:'cczh01',title:'账户名',width:'15%',align:'center'},
	      	        	{field:'aac003',title:'姓名',width:'15%',align:'center'},
	      	        	{field:'aae005',title:'联系电话',width:'10%',align:'center'},
		              	{field:'aac002',title:'身份证号',width:'10%',align:'center'},
		             	{field:'acd202',title:'所属机构',width:'35%',align:'center'},
	      	        	{field:'dep002',title:'所属部门',width:'10%',align:'center'}
// 		        	    ,{field:'aac001',title:'个人编号',width:150,align:'center'}	        	        
		        	    ]];
		$('#userList').bootstrapTable({
		    url:'${ctx}/sys/role/sysRoleUser/listJsonUsers.xf?roleId=${roleId}&acd200=${acd200}',
		    title:"角色 [ ${sysRole.rolename} ] 下已分配人员",
		    columns:columns,
		    method:"post",
		    contentType:"application/x-www-form-urlencoded",
			pagination:true,
			pageSize:10,
			pageList:[10, 15, 20],
		    clickToSelect:true,
		    singleSelect: false,
		    sidePagination:"server",
		    queryParams : getSeachJson,
		    striped:true
		});
	})
	function getSeachJson(params) {
		if(isDosearch){
			params.offset = 0;
			isDosearch = false;
		}
		return $("form").serialize()+"&limit="+params.limit+"&offset="+params.offset+"&order="+params.order;
	}
	function saveSubmit(){
		   var roleId='${roleId}';
		   var row = $('#userList').bootstrapTable('getAllSelections');
		   $(".btn-submit").attr("disabled");
		   if(row&&row.length>0){
			var acd230="";
			$.each(row,function(i,e){
				if(i==0){
					acd230+=e.acd230;
				}else{
					acd230+=","+e.acd230;
				}
			});
	        $.post('${ctx}/sys/role/sysRoleUser/saveCheckUsers.xf',{'roleId':roleId,'acd230':acd230}, function(data) {
                $(".btn-submit").removeAttr("disabled");
                bootbox.alert({ 
                   size: 'small',
                   width:"100px",
                   message: data.message, 
                   callback: function(){ 
                   	var parentIframe=xfui.getParentIframe();
   			    	if(parentIframe){
   			    		parentIframe.refresh();
   			    	}
                   	closeItem(); 
                   }
               })
               
           }, 'json');
	       }else{
	    		bootbox.alert('请选择一条信息');
	       }
	}
	

	function addUser(row){
		
		handerUser(row,'${ctx}/sys/role/sysRoleUser/addRoleUser.xf','id')
	 	
	}
	function removeUser(){
		var row = $('#userList').datagrid('getSelections');
		if(row&&row.length>0){
			handerUser(row,'${ctx}/sys/role/sysRoleUser/removeRoleUser.xf','acd230')		
		}else{
			$.messager.alert('提示',"请选择记录"); 
		}		
	}
	
	function handerUser(row,url,pId){
		var roleId=$("#roleId").val();
		var userIds="";
		$.each(row,function(i,e){
			if(i==0){
				userIds+=e[pId];
			}else{
				userIds+=","+e[pId];
			}
			
		});
		$.ajax({ url: url,
    		data:{roleId:roleId,userIds:userIds},
    		dataType:'json',
    		success: function(data){
    			if(data.message){
    				$.messager.alert('提示',data.message); 	
    			}else{
    				$.messager.alert('提示',"未知错误"); 
    			}
    			
    			refresh();
             }
    	});	
		
	}
	
	function refresh(){
		$('#userList').bootstrapTable('refresh');
	}
	var isDosearch = false;
	function doSearch(){
		isDosearch = true;
		$('#searchText').val($.trim($('#searchText').val()));
// 		var json=$("#searchForm").serializeJson();
		$("#userList").bootstrapTable('refresh', {	
			query: getSeachJson
		})
	}
	function doClear(){
		$("#searchText").val('');
	}
	function closeItem(){
		  xfui.closeDialog();
	}
	</script>	
</head>
<body>
	 <div class="container-fluid">
	<div class="row" style="height: 100%">
				<div class="col-xs-12 marginbottom20">
						<form id="searchForm">
							<div class="form-group">
								<div class="col-sm-12">
								<div class="col-sm-1"></div>
									<div class="col-sm-6 marginbottom20">
									    <input type="hidden" id="acd200" value='${acd200}'/>
									 	<input type="hidden" id="roleId" value='${roleId}'/>
									 	<label class="col-sm-4">查询：</label>
									 	<div class="col-sm-8">
										<input class="form-control" id="searchText" type="text" name="Q_findKeyword_SL" placeholder="姓名/账户名/联系电话/所属机构/部门" title="姓名/账户名/联系电话所属机构/部门" data-placement="bottom" />
									</div></div>
									<div class="col-sm-5 marginbottom20">
										<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary btn-border1 mhyBtnLeft">
										<i class="icon-search"></i>
										查询</a>
										<a href="#modal-form" role="button" onclick="doClear()" class="btn btn-info btn-border1" >
										<i class="icon-repeat"></i>
										重置</a>
									</div>
								</div>
							</div>
						</form>
					</div>
					<form id="userForm" method="post">
					<div class="col-xs-12">
					  <table id="userList" ></table>
					</div>
    	</form>
    </div>
    </div> 
    <div class="bottomBtn">
    <div class="h60"> </div>
    <div class="floatBtn">
		<button class="btn btn-info mhyBtnLeft" data-dismiss="modal" type="button" onclick="closeItem()">
			<i class="icon-remove"></i>
			关闭
		</button>
		<button class="btn btn-primary" type="button" onclick="saveSubmit()">
			<i class="icon-save"></i>
			保存
		</button>
	</div></div>	
</body>
</html>