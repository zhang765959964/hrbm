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
<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />
<title>角色人员管理</title>
	<script>
	$(function(){
		/**
		 初始化表格显示
		*/
		var columns= [[{field:'acd230',title:'Id号',width:100,align:'center',visible:false},
					   {field:'status',title:'Id号',checkbox:'true',width:'5%',align:'center'},
		                {field:'cczh01',title:'账户名',width:'15%',align:'center'},
	      	        	{field:'aac003',title:'姓名',width:'15%',align:'center'},
	      	        	{field:'aae005',title:'联系电话',width:'10%',align:'center'},  
		              	{field:'aac002',title:'身份证号',width:'15%',align:'center'},
		      	       	{field:'acd202',title:'所属机构',width:'30%',align:'center'},
	      	        	{field:'dep002',title:'所属部门',width:'10%',align:'center'}
// 		        	    ,{field:'aac001',title:'个人编号',width:150,align:'center'}	        	        
		        	    ]];
		$('#userList').bootstrapTable({
		    url:'${ctx}/sys/role/sysRoleUser/listJson.xf?roleId=${roleId}',
		    columns:columns,
		    method:"post",
		    contentType:"application/x-www-form-urlencoded",
			pagination:true,
			pageSize:10,
			pageList:[10, 15, 20],
		    clickToSelect:true,
		    singleSelect: false,
		    sidePagination:"server",
		    striped:true
		});
	})
	
	function addRoleUser(){	
	    var roleId = '${roleId}';
        var aae017 = '${sysRole.aae017}';
		xfui.open_dialog({    
		    title: '添加角色人员',    
		    width: 1160,    
		    height: 800, 
		    closed: false,    
		    cache: false,    
		    url: "${ctx}/sys/role/sysRoleUser/add.xf?roleId="+roleId+'&acd200='+aae017,
		    modal: true   
		})
    }
	
	function removeUsers(){
		   var roleId='${roleId}';
		   var row = $('#userList').bootstrapTable('getAllSelections');
		   $("#removeUsers").attr("disabled");
		   if(row&&row.length>0){
			var acd230="";
			$.each(row,function(i,e){
				if(i==0){
					acd230+=e.acd230;
				}else{
					acd230+=","+e.acd230;
				}
			});
	        $.post('${ctx}/sys/role/sysRoleUser/removeCheckUser.xf',{'roleId':roleId,'acd230':acd230}, function(data) {
          $("#removeUsers").removeAttr("disabled");
          bootbox.alert({ 
             size: 'small',
             width:"100px",
             message: data.message, 
             callback: function(){ 
            	 refresh();
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
	
	function refresh(){
		$('#userList').bootstrapTable('refresh');
	}
	function doSearch(){
		$('#searchText').val($.trim($('#searchText').val()));
		var json=$("#searchForm").serializeJson();
		$("#userList").bootstrapTable('refresh', {	
			query: json
		})
	}
	function doClear(){
		$("#searchText").val('');
	}
	</script>	
</head>
<body>
	 <div class="container-fluid">
		<div class="mhyBody">
					<div class="mhySearch">
				<div class="mhyTitle">查询条件</div>
						<form id="searchForm" class="mhySearchInput">
							<div class="form-group">
								<div class="row">
								<div class="col-xs-12 col-sm-4"></div>
									<div class="col-xs-12 col-sm-6 marginbottom20">
									<label class="col-xs-2 col-sm-4">查询：</label>
									<div class="col-xs-10 col-sm-8">
									
									
										<input class="form-control" id="searchText" type="text" name="Q_findKeyword_SL" placeholder="姓名/账户名/联系电话" title="姓名/账户名/联系电话" data-placement="bottom" />
									</div></div>
									<div class="col-xs-12 col-sm-2 mhySearchRight">
										<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary mhyBtnLeft" ><i class="icon-search"></i>查询</a>
										<a href="#modal-form" role="button" onclick="doClear()" class="btn btn-info" ><i class="icon-repeat"></i>重置</a>
									</div>
								</div>
							</div>
						</form>
					</div>
					
						<div class="mhyMain">
						<div class="mhyTitle"> 查询结果 </div>
						<div class="mhyInfo">
						<div class="mgy10">
						<a href="javascript:void(0)" onclick="addRoleUser()" role="button" class="btn btn-primary mhyBtnLeft" data-toggle="modal"><i class="icon-plus"></i>添加角色人员</a>
						<a href="javascript:void(0)" id="removeUsers" onclick="removeUsers()" role="button" class="btn btn-danger mhyBtnLeft" data-toggle="modal"><i class="icon-trash"></i>删除角色人员</a>
							</div>		
						<div class="mhyConter">
					  <table id="userList" class="datagridClass tableClassNoworks"></table>
					</div>
						</div>
					</div>
					
<!-- 					<div class="col-xs-12"> -->
<!-- 						<a href="javascript:void(0)" onclick="addRoleUser()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus align-top bigger-125"></i>添加角色人员</a> -->
<!-- 						<a href="javascript:void(0)" id="removeUsers" onclick="removeUsers()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-pencil align-top bigger-125"></i>删除角色人员</a> -->
<!-- 					</div> -->
<!-- 					<div class="col-xs-12"> -->
<!-- 					  <table id="userList" ></table> -->
<!-- 					</div> -->
   					 <input type="hidden" id="roleId" value='${roleId}'/></div></div>
</body>
</html>