<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>培训信息设置</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<%@include file="/commons/include/bootstrapInc.jsp" %>

<script>
	$(function() {
		/**
		 初始化表格显示
		 */
		initTable();
		
		$(".mhyInputReset").click(function(){
			
			$("#searchForm")[0].reset();
		});
	})
	
	function initTable() {
		var columns= [[{field:'',title:'Id号',checkbox:'true',width:40,align:'center'},
	                
	                   {field:'caos01',title:'操作',width:80,formatter: function(value,row,index){	 
				           return "<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"editTrainSysSet('"+value+"')\" ><i class='icon-pencil' title='编辑'></i></a>";
							}
					 },
		               {field:'caos02',title:'配置名称'},
		               {field:'caos04',title:'配置值'},
	                   {field:'caos03',title:'配置说明'},
	                   {field:'aae019',title:'经办人'},
	                   {field:'aae020',title:'经办机构'},
	                   {field:'aae036',title:'经办日期',formatter:function(value,row,index){if(value)return formateDate(value);}}
      	        	]];
		$('#trainSysSetList').bootstrapTable({
			url : '${ctx}/business/dissupport/train/trainSysSet/listJson.xf',
			columns: columns,
		    method:"post",
		    contentType:"application/x-www-form-urlencoded",
			pagination:true,
			pageSize:10,
			pageList:[10, 15, 20],
		    clickToSelect:true,
		    sidePagination:"server",
		    striped:true
		});
	}

	function addTrainSysSet(){	
		 xfui.open_tabs("添加培训设置信息","${ctx}/business/dissupport/train/trainSysSet/add.xf","培训系统信息管理"); 
	}
	
	function editTrainSysSet(value){
			var caos01=value;
			xfui.open_tabs("编辑培训设置信息","${ctx}/business/dissupport/train/trainSysSet/edit.xf?caos01="+caos01,"培训系统信息管理");
	}
	
	
	function refreshTable(){
		if(leftClickTreeNode){
			var id=leftClickTreeNode.id;
			$('#trainSysSetList').bootstrapTable('refresh', {query:{
				colId: id
			  }				
			});
		}else{
			$('#laborColList').bootstrapTable('refresh');
		}				
	} 
	
	function refresh(){
		$("#trainSysSetList").bootstrapTable('refresh');
	}
	
	function doSearch(){
		/* var json = $("#searchForm").serializeJson();
		$("#trainSysSetList").bootstrapTable('refresh', {	
			query: json
		}) */
        var params=$("#searchForm").serialize();
		
		$("#trainSysSetList").bootstrapTable('refresh', 
				{url:"${ctx}/business/dissupport/train/trainSysSet/listJson.xf?"+params});
	}

</script>
</head>
<body>
		<div class="main-container">
			<div class="container-fluid">
				<div class="mhyBody">
	    		<div class="mhySearch">
					<div class="mhyTitle">
						查询条件
				    </div>
					<form id="searchForm"  class="mhySearchInput">
							<div class="row">
			                    <div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">配置名称：</label>
									<div class="col-xs-10 col-sm-8">
										<input class="form-control" type="text" name="caos02" data-placement="bottom" />
									</div>
								</div>
								
								<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-2 col-sm-4" for="inputError">配置值：</label>
										<div class="col-xs-10 col-sm-8">
											<input class="form-control" type="text" name="caos04" data-placement="bottom" />
										</div>
								</div>
								
								<div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">配置说明：</label>
									<div class="col-xs-10 col-sm-8">
										<input class="form-control" type="text" name="caos03" data-placement="bottom" />
									</div>
								</div>
						        
							    <div class="col-xs-12 col-sm-12 marginbottom20 ">
									<div class="col-xs-2 col-sm-4"></div>
									<div class="col-xs-10 col-sm-8 mhyBtn">
										<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary mhyBtnLeft" >
										<i class="icon-search"></i>
										查询
										</a>
										<a href="#modal-form" role="button" class="btn btn-info mhyInputReset" >
								<i class="icon-repeat"></i>重置
							</a>
									</div>
								</div>
						    </div>
					</form>
				</div> 
					
					<div class="mhyMain">
						<div class="mhyTitle">查询结果</div>
						<div class="mhyInfo">
							<div class="mgy10">
							
							<a href="javascript:void(0)" role="button" onclick="addTrainSysSet()" class="btn btn-primary" data-toggle="modal"><i class="icon-plus"></i>添加</a>
							</div><div class="row mhyConter">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table id="trainSysSetList"  class="datagridClass"  >
										</table>
									</div>
								</div>
							</div>
					  </div>
				</div>
			  </div>
			</div>
		</div>
	</body>
</html>


