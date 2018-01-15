<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>RSDA_BS_DEMO管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<script>

$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [
                   	{name:'name',label:'NAME',align:'left'},
                    {name:'address',label:'ADDRESS',align:'left'},
                    {name:'phone',label:'PHONE',align:'left'},
                    {name:'sex',label:'SEX',align:'left'},
                    {name:'age',label:'AGE',align:'left'},
                    {name:'num',label:'NUM',align:'left'},
                    {name:'num2',label:'NUM2',align:'left'},
	                {name:'id',label:'操作',width:100,formatter: function(cellvalue, options, rowObject){
				        	return "<a href=\"javascript:void(0)\" onclick=\"stickTop('"+cellvalue+"')\" >编辑</a>|"+
								"<a href=\"javascript:void(0)\" onclick=\"previewArticle('"+cellvalue+"')\" >删除</a>";
							}
				 	}
      	        ];
	$("#demotestList").jqGrid({
		   url:'${ctx}/business/personagency/demo/demotest/listJson.xf',
           mtype: "GET",
		   styleUI : 'Bootstrap',
           datatype: "json",
           colModel: columns,
		   viewrecords: true,
		   height:'auto',
           rowNum: 10,
           rowList:[10,20,30],
           altRows: true,
           pager: "#jqGridPager",
           pagerpos:'left',
           regional : 'cn',
           recordpos:'right',
           shrinkToFit: false,
           multiselect:true,
           autowidth: true
       });
})

function addDemotest(){
		xfui.open_dialog({
		    title: '新增RSDA_BS_DEMO',
		    width: 800,
		    height: 500,
		    closed: false,
		    cache: false,
		    url: "${ctx}/business/personagency/party/add.xf",
		    modal: true
		})
}
function editDemotest(){
	//var row = $('#demotestList').bootstrapTable('getAllSelections');
	var id=$("#demotestList").jqGrid("getGridParam","selrow");
	if(id){
		var id=id;
		xfui.open_dialog({
	  		    title: '编辑RSDA_BS_DEMO',
	  		    width: 800,
	  		    height: 500,
	  		    closed: false,
	  		    cache: false,
	  		    url: "${ctx}/business/personagency/party/edit.xf?id="+id,
	  		    modal: true
	  		})
	}else{
		bootbox.alert('请选择记录');
	}
}

function delDemotest(){

	var ids=$("#demotestList").jqGrid("getGridParam","selarrrow");
	if(ids&&ids.length>0){
		var id="";
		$.each(ids,function(i,e){
			if(i==0){
				id+=e;
			}else{
				id+=","+e;
			}

		});
		bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){
		    if (r){
		    	$.ajax({ url: '${ctx}/business/personagency/demo/demotest/del.xf',
		    		data:{id:id},
		    		dataType:'json',
		    		success: function(data){
		    			if(data.message){
		    				bootbox.alert(data.message);
		    			}else{
		    				bootbox.alert("未知错误");
		    			}

		    			refresh();
		             }
		    	});
		    }
		}});
	  }else{
		 bootbox.alert('请选择记录');
	 }
}
function refresh(){
	$("#demotestList").trigger("reloadGrid");
}
function doSearch(){

	var json=$("#searchForm").serializeJson();
	$("#demotestList").jqGrid("setGridParam",{postData:json}).trigger("reloadGrid");
}
</script>
</head>
<body>
	<div class="main-container">
		<div class="container-fluid">
			<div class="row">
			    <div class="moduleWrapNobg">
					<div class="moduleTit">查询条件</div>
					<div class="moduleCont">
						<form id="searchForm">
							<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError">NAME:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name="name" data-placement="bottom" />
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">ADDRESS:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name="address" data-placement="bottom" />
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">PHONE:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name="phone" data-placement="bottom" />
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">SEX:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name="sex" data-placement="bottom" />
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">AGE:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name="age" data-placement="bottom" />
									</div>
							</div>
							<div class="row">
								<div class="col-sm-12 mgb20 tar pdx20">
									<a href="#" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-zoom-in"></i>查询</a>
									<a href="javascript:void(0)" class="btn btn-primary highSearch" ><i class="icon-plus"></i>高级查询</a>
									<a href="#modal-form" role="button" class="btn btn-border1" ><i class="icon-repeat"></i>重置</a>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="moduleWrapNob">
					<div class="moduleTit">查询结果</div>
					<div class="moduleCont">
						<div class="mgy10">
							<a href="javascript:void(0)" onclick="addDemotest()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus align-top"></i>添加</a>
							<a href="javascript:void(0)" onclick="editDemotest()" role="button" class="btn btn-info" data-toggle="modal"><i class="icon-pencil align-top"></i>修改</a>
							<a href="javascript:void(0)"  onclick="delDemotest()" role="button" class="btn btn-danger" ><i class="icon-trash align-top"></i>移除</a>
							<a href="javascript:void(0)"  role="button" class="btn  btn-light" ><i class="icon-edit align-top"></i>导入</a>
							<a href="javascript:void(0)"  role="button" class="btn btn-grey" ><i class="icon-external-link align-top"></i>导出</a>
							<!-- <a href="javascript:void(0)" role="button" onclick="delCorp()" class="btn btn-danger" data-toggle="modal"><i class="icon-trash align-top"></i>删除</a> -->
						</div>
						<div class="row">
							<div class="col-xs-12">
								<table id="demotestList"  class="datagridClass"  ></table>
								<div id="jqGridPager"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


