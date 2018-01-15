<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑基本信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<script type="text/javascript" src="${ctx}/js/business/personagency/social/resultChangeAndTransfer.js?verson=20170215"></script>
<script>
	$(function() {
		initTable();
		initTransferTable();
		$("#socialsecTransferListTab").removeClass("in").removeClass("active");
		loadData();
	});
	
	function initTable() {
		var columns= [
	                   {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
	                   {name:'expPersonNumber',label:'个人编号',align:'center',frozen : true},
	                   {name:'aac003',label:'姓名',align:'center',frozen : true},
	                   {name:'isEffectiveName',label:'有效标识',align:'center'},
	                   {name:'aac002',label:'公民身份证号码',align:'center'},
	                   {name:'genderName',label:'性别',align:'center'},
	                   {name:'nationName',label:'民族',align:'center'},
	                   {name:'aac006',label:'出生日期',align:'center'},
	                   {name:'expStartJobDate',label:'参加工作时间',align:'center'},
	                   {name:'employmentFormName',label:'用工形式',align:'center'},
	                   {name:'expPersonPhone',label:'固定电话',align:'center'},
	                   {name:'aae005',label:'手机号码',align:'center'},
	                   {name:'expPensionDate',label:'参加养老保险时间',align:'center'},
	                   {name:'changeContentName',label:'变更内容',align:'center'},
	                   {name:'paymentStartDate',label:'缴费开始年月',align:'center'},
	                   {name:'paymentEndDate',label:'缴费终止年月',align:'center'},
	                   {name:'reasonsForStoppingName',label:'停保原因',align:'center'},
	                   {name:'addIsInsuranceName',label:'是否在外地参加过保险',align:'center'},
	                   {name:'checkoutSocialOrgName',label:'转出社保机构名称',align:'center'},
	                   {name:'fieldStartDate',label:'外地缴费开始时间',align:'center'},
	                   {name:'fieldEndDate',label:'外地缴费终止时间',align:'center'},
	                   {name:'pensionBaseName',label:'养老保险月缴费基数',align:'center'},
	                   {name:'stopSocialDate',label:'停保时间',align:'center'},
	                   {name:'expMedicalDate',label:'参加医疗保险时间',align:'center'}, 
	                   {name:'medicalBaseName',label:'医疗保险月缴费基数',align:'center'},
	                   {name:'description',label:'备注',align:'center'},
	                   {name:'aab301',label:'家庭住址',align:'center'},
	                   {name:'aae007',label:'邮政编码',align:'center'},
	                   {name:'createrName',label:'经办人名称',align:'center'},
	                   {name:'createrOrgName',label:'经办机构名称',align:'center'},
	                   {name:'createrDate',label:'经办日期',align:'center'},
	                   {name:'isEffective',label:'',align:'center',hidden:true}
     	        	];
		
		$("#changeReportingList").jqGrid({
		   url:'${ctx}/business/personagency/social/changeReporting/listJson.xf?archivesId=${id}',
           mtype: "GET",
		   styleUI : 'Bootstrap',
           datatype: "local",
           colModel: columns,
		   viewrecords: true,
           rowNum: 10,
           rowList:[10,20,30],
           pager: "#jqGridPager1",
           pagerpos:'left',
           regional : 'cn',
           recordpos:'right',
           shrinkToFit: false,
           multiselect:false,
           autowidth: true,
           height:'100%'
       });
		
		$("#changeReportingList").jqGrid('setFrozenColumns');
	}
	
	function initTransferTable() {
		var columns2 = [
							{name:'archiveCode',label:'档案编号',align:'center',frozen : true},
							{name:'expPersonNumber',label:'个人编号',align:'center',frozen : true},
							{name:'aac003',label:'姓名',align:'center',frozen : true},
							{name:'isEffectiveName',label:'有效标识',align:'center'},
							{name:'aac002',label:'公民身份证号码',align:'center'},
							{name:'genderName',label:'性别',align:'center'},
							{name:'nationName',label:'民族',align:'center'},
							{name:'aac006',label:'出生日期',align:'center'},
							{name:'expStartJobDate',label:'参加工作时间',align:'center'},
							{name:'employmentFormName',label:'用工形式',align:'center'},
							{name:'expPersonPhone',label:'固定电话',align:'center'},
							{name:'aae005',label:'手机号码',align:'center'},
							{name:'expPensionDate',label:'参加养老保险时间',align:'center'},
							{name:'aab301',label:'家庭住址',align:'center'},
			                {name:'aae007',label:'邮政编码',align:'center'},
		                    {name:'changeContenttwoName',label:'变更内容',align:'center'},
		                    {name:'yuanStartDate',label:'原参保地缴费起始时间',align:'center'},
		                    {name:'yuanEndDate',label:'原参保地缴费截止时间',align:'center'},
		                    {name:'yuanCorpNumber',label:'原单位编号',align:'center'},
		                    {name:'yuanCorpName',label:'原单位名称',align:'center'},
		                    {name:'yuanSocialName',label:'原社保机构名称',align:'center'},
		                    {name:'xianCorpNumber',label:'现单位编号',align:'center'},
		                    {name:'xianCorpName',label:'现单位名称',align:'center'},
		                    {name:'xianSocialName',label:'现社保机构名称',align:'center'},
		                    {name:'pensionBase',label:'养老保险月缴费基数',align:'center'},
		                    {name:'expMedicalDate',label:'参加医疗保险时间',align:'center'}, 
		                    {name:'medicalBaseName',label:'医疗保险月缴费基数',align:'center'},
		                    {name:'description',label:'备注',align:'center'},
		                    {name:'createrName',label:'经办人名称',align:'center'},
		                    {name:'createrOrgName',label:'经办机构名称',align:'center'},
		                    {name:'createrDate',label:'经办日期',align:'center'},
		                    {name:'isEffective',label:'',align:'center',hidden:true}
     	        	];
			$("#socialsecTransferList").jqGrid({
			  url:'${ctx}/business/personagency/social/socialsecTransfer/listJson.xf?archivesId=${id}',
	          mtype: "GET",
			  styleUI : 'Bootstrap',
	          datatype: "local",
	          colModel: columns2,
			   viewrecords: true,
	          rowNum: 10,
	          rowList:[10,20,30],
	          pager: "#jqGridPager2",
	          pagerpos:'left',
	          regional : 'cn',
	          recordpos:'right',
	          shrinkToFit: false,
	          multiselect:false,
	          autowidth: true,
	          height:'100%'
	      });
		/* $("#socialsecTransferList").jqGrid('setFrozenColumns'); */
	}
	
	function loadData(){
		$("#changeReportingList").jqGrid("setGridParam",{datatype: "json",url:'${ctx}/business/personagency/social/changeReporting/listJson.xf?archivesId=${id}'}).trigger("reloadGrid");
		$("#socialsecTransferList").jqGrid("setGridParam",{datatype: "json",url:'${ctx}/business/personagency/social/socialsecTransfer/listJson.xf?archivesId=${id}'}).trigger("reloadGrid");
	}
	
</script>
</head>
<body>
	<div class="moduleWrapNobg">
		<div class="moduleTit">存档信息</div>
		<div class="moduleCont">
			<form:form modelAttribute="archivesPersonForm" method="post" action="">
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">身份证号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="AAC002" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="AAC003" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="genderName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">出生日期:</label>
					<div class="col-xs-9 input-group col-sm-2">
	                  	<form:input  class="form-control" type="text"  path="AAC006" readonly="true"></form:input>
	                  	<span class="input-group-addon">
	                      	<i class="icon-calendar bigger-110"></i>
	                  	</span>
	                </div>
	                <label class="col-xs-3 col-sm-2" for="inputError" title="档案编号">档案编号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveCode" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="联系电话">联系电话:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="expPersonPhone" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="档案姓名">档案姓名:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">档案出生日期:</label>
					<div class="col-xs-9 input-group col-sm-2">
	                  	<form:input  class="form-control" type="text"  path="archiveBirthDate" readonly="true"></form:input>
	                  	<span class="input-group-addon">
	                      	<i class="icon-calendar bigger-110"></i>
	                  	</span>
	                </div>
					<label class="col-xs-3 col-sm-2" for="inputError">档案转入日期:</label>
					<div class="col-xs-9 input-group col-sm-2">
	                  	<form:input  class="form-control" type="text"  path="receiveDate" readonly="true"></form:input>
	                  	<span class="input-group-addon">
	                      	<i class="icon-calendar bigger-110"></i>
	                  	</span>
	                </div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">档案状态:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveStatusName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">存档类型:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveTypeName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="档案接收人">档案接收人:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveReceiveName" readonly="true"></form:input>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError" title="手机号">手机号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="AAE005" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">所属单位名称:</label>
					<div class="col-xs-9 col-sm-6">
						<form:input  class="form-control" type="text"  path="expEntrustCompany" readonly="true"></form:input>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<!-- tab选项卡 -->
	<div class="tabable">
		<ul class="nav nav-tabs padding-12 tab-color-blue background-blue">
			<li class="active"><a data-toggle="tab" href="#changeReportingListTab">变更申报信息</a></li>
			<li><a data-toggle="tab" href="#socialsecTransferListTab">统筹范围内转移信息</a></li>
		</ul>
		<div class="tab-content">
			<div id="changeReportingListTab" class="tab-pane in active">
				<div class="moduleWrapNob">
					<div class="moduleCont">
						<div class="mgy10">
							<a href="javascript:addChangeReporting('${id}','${archiveFlowStatus }')" role="button" class="btn btn-primary" ><i class="icon-plus"></i>新增</a>
							<a href="javascript:editChangeReporting()" role="button" class="btn btn-info" ><i class="icon-pencil"></i>修改</a>
							<a href="javascript:lookChangeReporting()" role="button" class="btn btn-success" ><i class="icon-zoom-in"></i>查看</a>
							<a href="javascript:printChangeReporting()" role="button" class="btn btn-white"><i class="icon-print"></i>打印</a>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<table id="changeReportingList" class="datagridClass"></table>
								<div id="jqGridPager1"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="socialsecTransferListTab" class="tab-pane in active">
				<div class="moduleWrapNob">
					<div class="moduleCont">
						<div class="mgy10">
							<a  href="javascript:addSocialsecTransfer('${id}','${archiveFlowStatus }')" role="button" class="btn btn-primary" ><i class="icon-plus"></i>新增</a>
							<a  href="javascript:editSocialsecTransfer()" role="button" class="btn btn-info" ><i class="icon-pencil"></i>修改</a>
							<a  href="javascript:lookSocialsecTransfer()" role="button" class="btn btn-success" ><i class="icon-zoom-in"></i>查看</a>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<table id="socialsecTransferList" class="datagridClass"></table>
								<div id="jqGridPager2"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>