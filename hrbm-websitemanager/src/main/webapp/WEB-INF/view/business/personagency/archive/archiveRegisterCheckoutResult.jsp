<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>档案借阅返还登记</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<script type="text/javascript" src="${ctx}/js/business/personagency/archive/archiveRegisterCheckoutResult.js?verson=20170109"></script>
<script>
$(function(){
	var columns= [
	              	   {name:'checkoutTypeName',label:'借阅类别',align:'center',frozen : true},
	              	   {name:'checkoutDate',label:'借阅日期',align:'center',frozen : true},
	              	   {name:'checkoutPeriodDate',label:'到期时间',align:'center',frozen : true},
	              	   {name:'checkoutStatusName',label:'借阅状态',align:'center'},
	              	   {name:'checkoutCorp',label:'借阅单位',align:'center'},
	              	   {name:'checkoutPerson',label:'借阅人',align:'center'},
	              	   {name:'checkoutPersonPhone',label:'借阅人联系电话',align:'center'},
	              	   //{name:'seizureMaterialName',label:'暂扣材料',align:'center'},
	              	   {name:'checkoutMortgage',label:'暂扣材料',align:'center'},
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
	                   {name:'id',label:'',align:'center',hidden:true}

      	        	];

	$("#archiveRegisterCheckout").jqGrid({
		url:'${ctx}/business/personagency/archive/archiveCheckout/listJson.xf?archiveId=${id}',
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
        //multiselect:true ,
        multiboxonly:true,
        autowidth: true,
        height:'100%'
        
    });

	$("#archiveRegisterCheckout").jqGrid('setFrozenColumns');
})
//借阅登记
function addRegisterCheckout(){
	var personId = ${personId};
	var id = ${id};
	var archiveFlowStatus = ${archiveFlowStatus};
	var archiveReceiveStatus = ${archiveReceiveStatus};
	if(personId>0){
		if(id>0){
			if(archiveReceiveStatus==2){
				if(archiveFlowStatus==9||archiveFlowStatus==4){
					xfui.open_dialog({
					    title: '档案借阅记录新增',
					    width: 1000,
					    height: 550,
					    closed: false,
					    cache: false,
					    url: "${ctx}/business/personagency/archive/archiveCheckout/add.xf?archiveId=${id}",
					    modal: true
					})
				}else{
					if(archiveFlowStatus==1){
						bootbox.alert('当前个人档案正在“借阅登记”，不能重复借阅登记！');
					}else if(archiveFlowStatus==2){
						bootbox.alert('当前个人档案正在“借阅确认”，暂不能借阅登记！');
					}else if(archiveFlowStatus==3){
						bootbox.alert('当前个人档案正在“返还登记”，暂不能借阅登记！');
					}else if(archiveFlowStatus==5){
						bootbox.alert('当前个人档案正在“调出登记”，暂不能借阅登记！');
					}
				}
			}else{
				if(archiveFlowStatus==2){
					bootbox.alert('当前个人档案正在“借阅确认”，暂不能借阅登记！');
				}else if(archiveFlowStatus==6){
					bootbox.alert('当前个人档案正在“调出确认”，不在库，暂不能借阅登记！');
				}else if(archiveFlowStatus==3){
					bootbox.alert('当前个人档案正在“返还登记”，暂不能借阅登记！');
				}else{
					bootbox.alert('目前档案没有在库，不能借阅！');
				}
			}
		}else{
			bootbox.alert('目前只有个人信息，没有档案信息！');
		}
	}else{
		 bootbox.alert('存档信息不能为空！');
	}
}

function refresh(){
	$("#archiveRegisterCheckoutList").load("${ctx}/business/personagency/archive/archiveCheckout/registerResultList.xf?personId=${personId}");
}
</script>
</head>
	<div class="moduleWrapNobg">
		<div class="moduleTit">存档信息</div>
		<div class="moduleCont">
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
		<div class="moduleTit">借阅信息</div>
		<div class="moduleCont">
			<div class="mgy10">
				<a href="javascript:addRegisterCheckout()" role="button" class="btn btn-primary"><i class="icon-pencil"></i>借阅登记</a>
				<a href="javascript:delRegisterCheckout()" role="button" class="btn btn-danger"><i class="icon-trash align-top"></i>删除</a>
				<a href="javascript:addReturnRegisterCheckout()"  role="button" class="btn btn-primary"><i class="icon-pencil"></i>返还登记</a>
				<div class="keep-open  btn-group vat" title="">
					<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
						<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i>
					</a>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<table id="archiveRegisterCheckout" class="datagridClass"></table>
					<div id="jqGridPager"></div>
				</div>
			</div>
		</div>
	</div>
</html>