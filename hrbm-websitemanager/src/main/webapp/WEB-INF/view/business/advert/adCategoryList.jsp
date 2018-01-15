<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="h100p">
<head>
<title>广告类别表管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css" type="text/css">
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/jquery/bootstrap-contextmenu.js"></script>
<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />
<script>
$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [{field:'',title:'Id号',checkbox:'true',width:20,align:'center'},{field:'CAAC01',title:'操作',width:100,align:'center',
 	   formatter: function(value,row,index){
      		return "<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"editAdCategory('"+value+"')\" ><i class='icon-pencil' title='编辑'></i></a>"+
			   "<a  class='mhyNoA' href=\"javascript:void(0)\" onclick=\"delAdCategory('"+value+"')\" ><i class='icon-trash' title='删除'></i></a>";
		}
},
	                   {field:'CAAC02',title:'分类名称',width:120,align:'center'},
	                   {field:'CAAC06',title:'使用范围',width:100,align:'center',
	                	   formatter: function(value,row,index){
	                		   if(value == '1'){
	                			   return "网站广告";
	                		   }else if(value == '2'){
	                			   return "企业广告";
	                		   }else{
	                			   return "职位广告";
	                		   }
	                	   }
	                   }
	                
      	        	];
	$('#adCategoryList').bootstrapTable({
		url:"${ctx}/business/advert/adCategory/listJson.xf",
	    columns: columns,
	    queryParams:queryParams,
	    search:false,
		pagination:true,
		pageSize:10,
		pageList:[10, 15, 20],
	    clickToSelect:true,
	    sidePagination:"server",
	    striped:true
	});
});
function addAdCategory(){
		xfui.open_dialog({
		    title: '新增广告类别',
		    width: 600,
		    height: 300,
		    closed: false,
		    cache: false,
		    url: "${ctx}/business/advert/adCategory/add.xf",
		    modal: false
		})
}

function editAdCategory(value){
	var caac01=value;
	if(!caac01){
		var row = $('#adCategoryList').bootstrapTable('getAllSelections');;
		if(row){
			caac01=row[0].CAAC01;
		}
	}
	if(caac01){
		xfui.open_dialog({
  		    title: '编辑广告类别表',
  		    width: 600,
  		    height: 400,
  		    closed: false,
  		    cache: false,
  		    url: "${ctx}/business/advert/adCategory/edit.xf?caac01="+caac01,
  		    modal: true
  		});
	}else{
		bootbox.alert('请选择记录');
	}
}

function delAdCategory(value){
	var caac01="";
	if(value){
		caac01=value;
	}else{
		var row = $('#adCategoryList').bootstrapTable('getAllSelections');
		if(!row||row.length<=0){
			bootbox.alert('请选择记录');
			return;
		}else{
			$.each(row,function(i,e){
				if(i==0){
					caac01+=e.CAAC01;
				}else{
					caac01+=","+e.CAAC01;
				}

			});
		}
	}

	bootbox.confirm({
	    size: 'small',
	    message: "您确认想要删除记录吗",
	    callback: function(r){
	    	 if (r){
	 	    	$.ajax({ url: '${ctx}/business/advert/adCategory/del.xf',
	 	    		data:{caac01:caac01},
	 	    		dataType:'json',
	 	    		success: function(data){
	 	    			if(data.message){
	 	    				refresh();
	 	    			}else{
	 	    				bootbox.alert("未知错误");
	 	    			}
	 	             }
	 	    	});
	 	    }
	    }
	})
}
function refresh(){
	$("#adCategoryList").bootstrapTable('refresh');
}
function doSearch(){ debugger;
	var caac02 = $("#searchText").val();
	//encodeURIComponent(caac02)
	$("#adCategoryList").bootstrapTable('refresh', {
		query: {"caac02":encodeURIComponent(caac02)}
	})
}

function queryParams(params){
	var caac02 = $("#searchText").val();
	params["caac02"] = encodeURIComponent(caac02);
	return params;
}
function doClear(){
	 $("#searchText").val("");
	 $("#adCategoryList").bootstrapTable('refresh');
}
</script>
</head>
<body class="h100p">
	<div class="container-fluid h100p">
		<!-- 查询模块 -->
		<div class="moduleWrapNobg">
	 		<div class="moduleTit">查询条件</div>
	 		<div class="moduleCont">
				<form id="searchForm">
					<div class="row">
						<div class="col-xs-1 col-sm-4"></div>
						<div class="col-xs-6 col-sm-6">
							
					
						
									<label class="col-xs-2 col-sm-4"> 分类名称: </label>
									<div class="col-xs-10 col-sm-8">
									
									<input class="form-control" id="searchText" type="text" name="caac02" placeholder="分类名称"  data-placement="bottom" />
								</div>
		
						
						</div>
												<div class="col-xs-2 col-sm-2">
									<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary mhyBtnLeft" ><i class="icon-search"></i>查询</a>
								</div>
					</div>
				</form>
			</div>
		</div>
		<!-- 查询结果 -->
		<div class="moduleWrapNob">
			<div class="moduleTit"> 查询结果 </div>
			<div class="moduleCont">
				<div class="mgy10">
					<a href="javascript:void(0)" onclick="addAdCategory()" role="button" class="btn btn-primary mhyBtnLeft" data-toggle="modal"><i class="icon-plus"></i>
						添加</a>
					<a href="#modal-form1" onclick="editAdCategory()" role="button" class="btn btn-info mhyBtnLeft" data-toggle="modal"><i class="icon-pencil"></i>
						修改</a>
					<a href="javascript:void(0)" role="button" onclick="delAdCategory()" class="btn btn-danger" data-toggle="modal"><i class="icon-trash"></i>
						删除</a>
				</div>
				<!-- 表结果 -->
				<div class="row">
					<div class="col-xs-12">
						<table id="adCategoryList"  ></table>
					</div>
				</div>
			</div>
		</div>
		<!-- <div class="mhyBody">
			<div class="mhySearch">
			<div class="mhyTitle">查询条件w</div>
				<form id="searchForm" class="mhySearchInput">
						<div class="form-group">
							<div class="row">
								<div class="col-sm-3 marginbottom20">
									<input class="form-control" id="searchText" type="text" name="caac02" placeholder="分类名称"  data-placement="bottom" />
								</div>
								<div class="col-sm-6  mhySearchRight">
									<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary mhyBtnLeft" >查询</a>
									<a href="#modal-form" role="button" onclick="doClear()" class="btn" >重置</a>
								</div>
							</div>
						</div>
					</form>
			</div>
			<div class="mhyMain">
					<div class="mhyTitle"> 查询结果 </div>
					<div class="mhyInfo">
						<a href="javascript:void(0)" onclick="addAdCategory()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-pencil align-top bigger-125"></i>
							添加</a>
						<a href="#modal-form1" onclick="editAdCategory()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-pencil align-top bigger-125"></i>
							修改</a>
						<a href="javascript:void(0)" role="button" onclick="delAdCategory()" class="btn btn-primary" data-toggle="modal"><i class="icon-trash align-top bigger-125"></i>
							删除</a>
						<div class="mhyConter">
				  			<table id="adCategoryList"  ></table>
						</div>
					</div>
			</div>
		</div> -->
	</div>

</body>
</html>


