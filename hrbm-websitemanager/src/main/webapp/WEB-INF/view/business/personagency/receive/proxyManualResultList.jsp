<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>代理手册合同书查询结果页面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<script type="text/javascript" src="${ctx}/js/ui/data.exp.js?verson=20170106"></script>
	<script type="text/javascript" src="${ctx}/js/ui/data.imp.js?version=201609231006"></script>
	<script type="text/javascript" src="${ctx}/js/business/personagency/receive/proxyManualResultList.js?verson=20170106001"></script>
<script>
$(function(){
	initDataExp();
})
$(function(){
	var columns= [
					   {name:'PMID',label:'',align:'center',hidden:true,key:true,frozen : true},
	                   {name:'AAC002',label:'身份证号',align:'center',frozen : true},
	                   {name:'AAC003',label:'姓名',align:'center',frozen : true},
	                   {name:'GENDERNAME',label:'性别',align:'center',frozen : true},
	                   {name:'AAC006',label:'出生日期',align:'center',frozen : true},
	                   {name:'LSSUINGDATE',label:'发放时间',align:'center'},
	                   {name:'PROXYISSUER',label:'发放人',align:'center'},
	                   /* {name:'PROXYREASEON',label:'发放原因',align:'center'}, */
	                   {name:'PROXYTYPENAME',label:'发放原因',align:'center'},
	                  /*  {name:'EFFECTIVEMARK',label:'有效标记',align:'center'}, */
	                   {name:'DESCRIPTION',label:'备注',align:'center'},
	                   {name:'CREATERNAME',label:'经办人',align:'center'},
	                   {name:'CREATERORGNAME',label:'经办机构',align:'center'},
	                   {name:'CREATERDATE',label:'经办日期',align:'center'},
	                   {name:'ARCHIVECODE',label:'档案编号',align:'center'},
	                   {name:'ARCHIVENAME',label:'档案姓名',align:'center'},
	                   {name:'ARCHIVEBIRTHDATE',label:'档案出生日期',align:'center'},
	                   {name:'ARCHIVESTATUSNAME',label:'档案状态',align:'center'},
	                   {name:'RECEIVEDATE',label:'档案转入日期',align:'center'},
	                   {name:'ARCHIVETYPENAME',label:'存档类型',align:'center'},
	                   {name:'EXPPERSONPHONE',label:'联系电话',align:'center'},
	                   {name:'AAE005',label:'手机号',align:'center'},
	                   {name:'ARCHIVESOURCE',label:'档案来源',align:'center'}
	                   
      	        	];

	$("#proxyManualList").jqGrid({
		url:'${ctx}/business/personagency/receive/proxyManual/listJson.xf?personId=${personId}',
        mtype: "GET",
		styleUI : 'Bootstrap',
        datatype: "json",
        colModel: columns,
		viewrecords: true,
        rowNum: 10,
        rowList:[10,20,30],
        pager: "#jqGridPager",
        pagerpos:'left',
        regional : 'cn',
        recordpos:'right',
        shrinkToFit: false,
        multiselect:true,
        autowidth: true,
        altRows:true,
        height:'100%'
    });

	$("#proxyManualList").jqGrid('setFrozenColumns');

})

function refresh(){
	$("#proxyManualList").jqGrid("setGridParam",{datatype: "json",url:'${ctx}/business/personagency/receive/proxyManual/listJson.xf?personId=${personId}'}).trigger("reloadGrid");
}

function addProxyManual(){
	var personId = ${personId};
	var id = ${id};
	if(personId>0){
		if(id>0){
			xfui.open_dialog({
			    title: '代理手册合同书发放',
			    width: 1050,
			    height: 550,
			    closed: false,
			    cache: false,
			    url: "${ctx}/business/personagency/receive/proxyManual/add.xf?personId=${personId}",
			    modal: true
			})
		}else{
			bootbox.alert('目前只有个人信息，没有档案信息！');
		}
	}else{
		 bootbox.alert('请先选择档案信息！');
	}
}
//导出
function initDataExp(){
	var personId = ${personId};
	$('#exp').dataexp({
		gridId:"proxyManualList",
		serviceId:'archivesExpServiceImpl',
		fileName:'代理手册合同书',
		sheetName:'代理手册合同书',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			            var ids=$("#proxyManualList").jqGrid("getDataIDs");
						if(ids&&ids.length>0){
							return {menuNumber:'4',personId : personId};
						}else{
							bootbox.alert('无可导出的数据！');
							return false;
						}
		           }},
			        {title:"导出当前页数据",paramCallBack:function(){
			        		var ids=$("#proxyManualList").jqGrid("getDataIDs");
			      		    if(ids&&ids.length>0){
					      		return {menuNumber:'4',pmIds:ids};
				      	    }else{
					      		  bootbox.alert('当前页没有记录');
					      		  return false;
				      	    }	
		  				}
				    }
		     ]
		
	});
}
</script>
</head>
	<div class="moduleWrapNobg">
		<div class="moduleTit">存档信息</div>
		<div class="moduleCont">
			<form:form modelAttribute="archivesPersonForm" method="post" action="">
				<div class="row">
					<label class="col-xs-12 col-sm-2" for="inputError">身份证号码:</label>
					<div class="col-xs-12 col-sm-2">
						 <form:input  class="form-control" type="text"  path="AAC002" readonly="true"></form:input>
					</div>
					<label class="col-xs-12 col-sm-2" for="inputError">姓名:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="AAC003" readonly="true"></form:input>
					</div>
					<label class="col-xs-12 col-sm-2" for="inputError">联系电话:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="expPersonPhone" readonly="true"></form:input>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-12 col-sm-2" for="inputError">性别:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="genderName" readonly="true"></form:input>
					</div>
					<label class="col-xs-12 col-sm-2" for="inputError">出生日期:</label>
					<div class="col-xs-12 input-group col-sm-2"  style="padding-left:15px">
                        <form:input  class="form-control" type="text"  path="AAC006" readonly="true"></form:input>
                        <span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
                    </div>
					<label class="col-xs-12 col-sm-2" for="inputError">档案出生日期:</label>
					<div class="col-xs-12 input-group col-sm-2"  style="padding-left:15px">
                       <form:input  class="form-control" type="text"  path="archiveBirthDate" readonly="true"></form:input>
                       <span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
                    </div>
				</div>
				<div class="row">
					<label class="col-xs-12 col-sm-2" for="inputError">档案编号:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveCode" readonly="true"></form:input>
					</div>
					<label class="col-xs-12 col-sm-2" for="inputError">档案姓名:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveName" readonly="true"></form:input>
					</div>
					<label class="col-xs-12 col-sm-2" for="inputError">档案接收人:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveReceiveName" readonly="true"></form:input>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-12 col-sm-2" for="inputError">档案转入日期:</label>
					<div class="col-xs-12 input-group col-sm-2"  style="padding-left:15px">
                          	 <form:input  class="form-control" type="text"  path="receiveDate" readonly="true"></form:input>
                          	 <span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
                       </div>
					<label class="col-xs-12 col-sm-2" for="inputError">档案状态:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveStatusName" readonly="true"></form:input>
					</div>
					<label class="col-xs-12 col-sm-2" for="inputError">手机号:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="AAE005" readonly="true"></form:input>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-12 col-sm-2" for="inputError">存档类型:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveTypeName" readonly="true"></form:input>
					</div>
					<label class="col-xs-12 col-sm-2" for="inputError">所属单位名称:</label>
					<div class="col-xs-12 col-sm-6">
						<form:input  class="form-control" type="text"  path="expEntrustCompany" readonly="true"></form:input>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<div class="moduleWrapNob">
		<div class="moduleTit">代理合同书信息</div>
		<div class="moduleCont">
			<div class="mgy10">
				<a role="button" class="btn btn-primary" href="javascript:addProxyManual()" ><i class="icon-plus"></i>添加</a>
				<a role="button" class="btn btn-danger"  href="javascript:delProxyManual()" ><i class="icon-trash"></i>删除</a>
				<div class="keep-open  btn-group vat" title="">
					<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
						<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i>
					</a>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<table id="proxyManualList" class="datagridClass"></table>
					<div id="jqGridPager"></div>
				</div>
			</div>
		</div>	
	</div>
</html>