<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>档案借阅归还确认页面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<script type="text/javascript" src='${ctx}/js/util/util.js'></script>
	<script type="text/javascript" src="${ctx}/js/business/personagency/archive/archiveConfirmCheckoutResult.js?verson=20170109"></script>
<script>
	$(function() {
		initTable();
		loadData();
	})
	function initTable(){
		var columns= [
						   {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
						   {name:'aac003',label:'姓名',align:'center',frozen : true},
		              	   {name:'checkoutTypeName',label:'借阅类别',align:'center',frozen : true},
		              	   {name:'checkoutDate',label:'借阅日期',align:'center'},
		                   {name:'checkoutPeriodDate',label:'到期时间',align:'center'},
		              	   {name:'checkoutStatusName',label:'借阅状态',align:'center'},
		              	   {name:'checkoutCorp',label:'借阅单位',align:'center'},
		              	   {name:'checkoutPerson',label:'借阅人',align:'center'},
		              	   {name:'checkoutPersonPhone',label:'借阅人联系电话',align:'center'},
		              	   {name:'seizureMaterialName',label:'暂扣材料',align:'center'},
		                   {name:'checkoutReason',label:'借阅原因',align:'center'},
		                   {name:'checkoutContent',label:'借阅内容',align:'center'},
		                   {name:'checkoutPeriodDate',label:'借阅时间至',align:'center'},
		                   {name:'checkoutRegisterName',label:'窗口借阅经办人',align:'center'},
		                   {name:'checkoutRegisterOrgName',label:'窗口借阅经办机构',align:'center'},
		                   {name:'checkoutRegisterDate',label:'窗口借阅经办日期',align:'center'},
		                   {name:'checkoutConfirmName',label:'档案借阅经办人',align:'center'},
		                   {name:'checkoutConfirmOrgName',label:'档案借阅经办机构',align:'center'},
		                   {name:'checkoutConfirmDate',label:'档案借阅经办日期',align:'center'},
		                   {name:'checkinName',label:'窗口返还经办人',align:'center'},
		                   {name:'checkinOrgName',label:'窗口返还经办机构',align:'center'},
		                   {name:'checkinDate',label:'窗口返还经办日期',align:'center'},
		                   {name:'checkinConfirmName',label:'档案室返还经办人',align:'center'},
		                   {name:'checkinConfirmOrgName',label:'档案室返还经办机构',align:'center'},
		                   {name:'checkinConfirmDate',label:'档案室返还经办日期',align:'center'},
		                   {name:'checkoutStatus',label:'',align:'center',hidden:true},
		                   {name:'aac001',label:'',align:'center',hidden:true}
	      	        	];
	
		$("#archiveConfirmCheckout").jqGrid({
	        mtype: "GET",
			styleUI : 'Bootstrap',
	        datatype: "local",
	        colModel: columns,
			viewrecords: true,
	        rowNum: 10,
	        rowList:[10,20,30],
	        pager: "#jqGridPager",
	        pagerpos:'left',
	        regional : 'cn',
	        recordpos:'right',
	        shrinkToFit: false,
	        multiselect:false,
	        autowidth: true,
	        height:'100%',
	        onSelectRow:function(rowId){
		    	  var rowData=$(this).jqGrid("getRowData",rowId);
		    	  var aac001 = rowData.aac001;
		          $("#archivesPersonFormDiv").load("${ctx}/business/personagency/archive/archiveCheckout/freshArchives.xf?personId="+aac001);
		    }
	        
	    });
		$("#archiveConfirmCheckout").jqGrid('setFrozenColumns');
	}
	
	function refresh(){
		$("#archiveConfirmCheckoutList").load("${ctx}/business/personagency/archive/archiveCheckout/confirmResultList.xf?personId=${personId}");
	}
	
	function loadData(){
		var archiveId = ${id};
		if(archiveId>0){
			$("#archiveConfirmCheckout").jqGrid("setGridParam",{datatype: "json",url:'${ctx}/business/personagency/archive/archiveCheckout/listJson.xf?archiveId=${id}&checkoutStatusValue=1,3'}).trigger("reloadGrid");
			//$('#checkoutStatusValue option:first').attr('selected','selected');
		}else{
			$("#archiveConfirmCheckout").jqGrid("setGridParam",{datatype: "json",url:'${ctx}/business/personagency/archive/archiveCheckout/listJson.xf?checkoutStatusValue=1'}).trigger("reloadGrid");
			$("#checkoutStatusValue option[value='"+1+"']").attr("selected", "selected"); 
		}
	}
	
</script>
</head>
<div class="moduleWrapNobg">
	<div class="moduleTit">存档信息</div>
	<div class="moduleCont" id="archivesPersonFormDiv">
		<form:form modelAttribute="archivesPersonForm" method="post" action="">
			<div class="row">
				<label class="col-xs-3 col-sm-2" for="inputError">身份证号码:</label>
				<div class="col-xs-9 col-sm-2">
					 <form:input  class="form-control" type="text"  path="AAC002" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
				<div class="col-xs-9 col-sm-2">
					<form:input  class="form-control" type="text"  path="AAC003" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">联系电话:</label>
				<div class="col-xs-9 col-sm-2">
					<form:input  class="form-control" type="text"  path="expPersonPhone" readonly="true"></form:input>
				</div>
			</div>
			<div class="row">
				<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
				<div class="col-xs-9 col-sm-2">
					<form:input  class="form-control" type="text"  path="genderName" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">出生日期:</label>
				<div class="col-xs-9 input-group col-sm-2"  style="padding-left:15px">
                    	  <form:input  class="form-control" type="text"  path="AAC006" readonly="true"></form:input>
                         <span class="input-group-addon">
                             <i class="icon-calendar bigger-110"></i>
                         </span>
                   </div>
				<label class="col-xs-3 col-sm-2" for="inputError">档案出生日期:</label>
				<div class="col-xs-9 input-group col-sm-2"  style="padding-left:15px">
                     <form:input  class="form-control" type="text"  path="archiveBirthDate" readonly="true"></form:input>
                     <span class="input-group-addon">
                         <i class="icon-calendar bigger-110"></i>
                     </span>
                   </div>
			</div>
			<div class="row">
				<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
				<div class="col-xs-9 col-sm-2">
					<form:input  class="form-control" type="text"  path="archiveCode" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">档案姓名:</label>
				<div class="col-xs-9 col-sm-2">
					<form:input  class="form-control" type="text"  path="archiveName" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">档案接收人:</label>
				<div class="col-xs-9 col-sm-2">
					<form:input  class="form-control" type="text"  path="archiveReceiveName" readonly="true"></form:input>
				</div>
			</div>
			<div class="row">
				<label class="col-xs-3 col-sm-2" for="inputError">档案转入日期:</label>
				<div class="col-xs-9 input-group col-sm-2"  style="padding-left:15px">
                    	 <form:input  class="form-control" type="text"  path="receiveDate" readonly="true"></form:input>
                    	 <span class="input-group-addon">
                         	<i class="icon-calendar bigger-110"></i>
                     	</span>
                  </div>
				<label class="col-xs-3 col-sm-2" for="inputError">档案状态:</label>
				<div class="col-xs-9 col-sm-2">
					<form:input  class="form-control" type="text"  path="archiveStatusName" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">手机号:</label>
				<div class="col-xs-9 col-sm-2">
					<form:input  class="form-control" type="text"  path="AAE005" readonly="true"></form:input>
				</div>
			</div>
			<div class="row">
				<label class="col-xs-3 col-sm-2" for="inputError">存档类型:</label>
				<div class="col-xs-9 col-sm-2">
					<form:input  class="form-control" type="text"  path="archiveTypeName" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">所属单位名称:</label>
				<div class="col-xs-9 col-sm-6">
					<form:input  class="form-control" type="text"  path="expEntrustCompany" readonly="true"></form:input>
				</div>
			</div>
		</form:form>
	</div>
</div>
<div class="moduleWrapNob">
	<div class="moduleTit"><span>借阅归还信息</span>
		<span class="fr mgr15 mgt4">
			<select style='width: 205px' class='easyui-combobox' editable='false' id='checkoutStatusValue' onchange="searchArchiveCheckout()">
				<option value="1,3">全部</option>
				<option value="1" <c:if test="${archiveFlowStatus==1 }">selected="selected"</c:if> >借阅待确认</option>
				<option value="3" <c:if test="${archiveFlowStatus==3 }">selected="selected"</c:if>>返还待确认</option>
			</select>
		</span>
	</div>
	<div class="moduleCont">
		<div class="mgy10">
			<a href="javascript:registerComfirmCheckout()" role="button" class="btn btn-primary"><i class="icon-bookmark"></i>借阅确认</a>
			<a href="javascript:returnConfirmCheckout()"   role="button" class="btn btn-info"><i class="icon-repeat"></i>返还确认</a>
			<div class="keep-open  btn-group vat" title="">
				<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
					<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i>
				</a>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<table id="archiveConfirmCheckout" class="datagridClass"></table>
				<div id="jqGridPager"></div>
			</div>
		</div>
	</div>
</div>