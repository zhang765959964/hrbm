<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>缴费记录管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">

</head>
<body>
			<div class="moduleWrapNobg">
				<div class="moduleTit">存档信息</div>
				<div class="moduleCont">
					<form:form modelAttribute="archivesPersonForm" method="post" action="">
					   <input type="hidden" id="personId"  value="${personId}"/>
					   <input type="hidden"  value="${lzStatus }" id="lzStatus" />
					   <input type="hidden"  value="${jsStatus }" id="jsStatus" />
					   <input type="hidden"  value="${daStatus }" id="daStatus" />
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
	                              <span class="input-group-addon">
	                                  <i class="icon-calendar bigger-110"></i>
	                              </span>
                           </div>
							<label class="col-xs-12 col-sm-2" for="inputError">档案出生日期:</label>
							<div class="col-xs-12 input-group col-sm-2"  style="padding-left:15px">
                              <form:input  class="form-control" type="text"  path="archiveBirthDate" readonly="true"></form:input>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
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
                             	 <span class="input-group-addon">
                                  	<i class="icon-calendar bigger-110"></i>
                              	</span>
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
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="expEntrustCompany" readonly="true"></form:input>
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError">合同编号:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="contractCode" readonly="true"></form:input>
							</div>
						</div>
					</form:form>
				</div>
			</div>	
				<div class="moduleWrapNob">
				<div class="moduleTit">缴费明细</div>
				<div class="moduleCont">
					<div class="mgy10">
					    <c:if test="${type!='search'}">
						<a href="javascript:void(0)" id="addPaymentRecord" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus align-top"></i>添加</a>
						<a href="javascript:void(0)"  id="delPaymentRecord" role="button" class="btn btn-danger" ><i class="icon-trash align-top"></i>删除</a>
						</c:if>
					</div>
					<div class="row">
						<div class="col-xs-12">
								<table id="paymentRecordList"  class="datagridClass"  ></table>
								<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
			</div>	
<script type="text/javascript" src="${ctx}/js/business/personagency/payment/paymentRecordList.js?version=201611021121"></script>
<script>
$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [	   {name:'fdPaymentDate',label:'缴费日期',align:'center'},
	                   {name:'fdStartDate',label:'开始缴费日期',align:'center'},
	                   {name:'fdEndDate',label:'终止缴费日期',align:'center'},
	                   {name:'fdPaymentMonths',label:'缴费月数',align:'center'},
	                   {name:'fdPaymentStandard',label:'缴费标准',align:'center'},
	                   {name:'fdPaymentAmount',label:'缴费金额',align:'center'},	                   
	                   {name:'fdPaymentType',label:'缴费类型',align:'center'},	                  
	                   {name:'fdPaymentStatus',label:'缴费状态',align:'center'},
	                   {name:'fdDerateStatus',label:'减免标记',align:'center'},
	                   {name:'fdDesc',label:'备注',align:'center'},	                   
	                   {name:'fdCreaterName',label:'经办人',align:'center'},
	                   {name:'fdCreaterOrgName',label:'经办机构',align:'center'},
	                   {name:'fdCreaterDate',label:'经办日期',align:'center'},	                   
	                   {name:'pkId',label:'操作',hidden:true,width:100,key:true}
      	        	];
	$("#paymentRecordList").jqGrid({
           mtype: "GET",
		   url:CTX+'/business/personagency/payment/paymentRecord/listJson.xf?fkPersonId=${personId}',
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
//            multiselect:true,
           autowidth: true,
           height:'100%',
           altRows:true
       });
	

	
})

</script>
</body>		
</html>


