<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>工资标准调整</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
	<script type="text/javascript" src="${ctx}/js/business/personagency/storage/wageStandardResultList.js?verson=2016122920"></script>
<script>
$(function(){
	var columns= [
					   {name:'id',label:'id',hidden:true,frozen : true},
	              	   {name:'aac003',label:'姓名',align:'center',frozen : true},
	                   {name:'genderName',label:'性别',align:'center',frozen : true},
	                   {name:'nationName',label:'民族',align:'center',frozen : true},
	                   {name:'aac011Name',label:'文化程度',align:'center'},
	                   {name:'aac006',label:'出生日期',align:'center'},
	                   {name:'expStartJobDate',label:'参加工作时间',align:'center'},
	                   {name:'adjustDate',label:'调整日期',align:'center'},
	                   {name:'positionType',label:'现岗位职位工种',align:'center'},
	                   {name:'ja01',label:'调整前执行何工资制度',align:'center'},
	                   {name:'jb01',label:'调整后执行何工资制度',align:'center'},
	                   {name:'ja02',label:'调整前技能或等级工资级别',align:'center'},
	                   {name:'jb02',label:'调整后技能或等级工资级别',align:'center'},
	                   {name:'ja03',label:'调整前技能或等级工资额（元）',align:'center'},
	                   {name:'jb03',label:'调整后技能或等级工资额（元）',align:'center'},
	                   {name:'ja04',label:'调整前岗位级工资级别',align:'center'},
	                   {name:'jb04',label:'调整后岗位级工资级别',align:'center'},
	                   {name:'ja05',label:'调整前岗位级工资额（元）',align:'center'},
	                   {name:'jb05',label:'调整后岗位级工资额（元）',align:'center'},
	                   {name:'ja06',label:'调整前连动工资额',align:'center'},
	                   {name:'jb06',label:'调整后连动工资额',align:'center'},
	                   {name:'ja07',label:'调整前工龄工资额',align:'center'},
	                   {name:'jb07',label:'调整后工龄工资额',align:'center'},
	                   {name:'ja08',label:'调整前合计',align:'center'},
	                   {name:'jb08',label:'调整后合计',align:'center'},
	                   {name:'ja09',label:'升级前等级',align:'center'},
	                   {name:'jb09',label:'升级后等级',align:'center'},
	                   {name:'ja10',label:'升级前月工资标准',align:'center'},
	                   {name:'jb10',label:'升级后月工资标准',align:'center'},
	                   {name:'createrName',label:'经办人',align:'center'},
	                   {name:'createrOrgName',label:'经办机构',align:'center'},
	                   {name:'createrDate',label:'经办日期',align:'center'}
	                
      	        	];
	$("#wageStandardList").jqGrid({
		   url:'${ctx}/business/personagency/storage/wageStandard/listJson.xf?personId=${personId}',
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
           //multiselect:true,
           autowidth: true,
           multiboxonly: true,
           rownumbers : true,
           altRows:true,
           height : '100%',
           onSelectRow:function(rowId){
	    	  var rowData=$(this).jqGrid("getRowData",rowId);
	    	  if(rowData.id>0){
		    	  $("#refreshDiv").load("${ctx}/business/personagency/storage/wageStandard/getWageStandard.xf?id="+rowData.id);
	    	  }
		   }
           
       });
	$("#wageStandardList").jqGrid('setFrozenColumns');
})

</script>
</head>
	<div class="moduleWrapNobg">
		<div class="moduleTit">档案信息</div>
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
					<label class="col-xs-12 col-sm-2" for="inputError">性别:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="genderName" readonly="true"></form:input>
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
					<label class="col-xs-12 col-sm-2" for="inputError">出生日期:</label>
					<div class="col-xs-12 input-group col-sm-2"  style="padding-left:15px">
                      	<form:input  class="form-control" type="text"  path="AAC006" readonly="true"></form:input>
                        <span class="input-group-addon">
                            <i class="icon-calendar bigger-110"></i>
                        </span>
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
					<label class="col-xs-12 col-sm-2" for="inputError">档案出生日期:</label>
					<div class="col-xs-12 input-group col-sm-2"  style="padding-left:15px">
                        <form:input  class="form-control" type="text"  path="archiveBirthDate" readonly="true"></form:input>
                        <span class="input-group-addon">
                            <i class="icon-calendar bigger-110"></i>
                        </span>
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
					<label class="col-xs-12 col-sm-2" for="inputError">档案接收人:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveReceiveName" readonly="true"></form:input>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-12 col-sm-2" for="inputError">联系电话:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="expPersonPhone" readonly="true"></form:input>
					</div>
					<label class="col-xs-12 col-sm-2" for="inputError">手机号:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="AAE005" readonly="true"></form:input>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<!-- 查询结果开始 -->
	<div class="moduleWrapNob">
		<div class="moduleTit">工资标准调整信息列表</div>
		<div class="moduleCont">
			<div class="mgy10"></div>
			<div class="row">
				<div class="col-xs-12">
					<table id="wageStandardList" class="datagridClass"></table>
					<div id="jqGridPager"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- 工资标准调整 -->
	<div id="refreshDiv">
		
	</div>
<script type="text/javascript">
	 $(function(){
          $("#refreshDiv").load("${ctx}/business/personagency/storage/wageStandard/refreshDiv.xf?personId=${personId}");
	 })
	 
	 //新增
	 function removeDiv(){
		 $("#refreshDiv").load("${ctx}/business/personagency/storage/wageStandard/refreshDiv.xf?personId=${personId}");
	 }
	 
	  function submitForm(){
		var personId = ${personId};
		var id = ${id};
		var bootstrapValidator = $("#wageStandardForm").data('bootstrapValidator');  
		if(personId>0){
			if(id>0){
		     	bootstrapValidator.setAllowSubmit(true);
			}else{
				bootbox.alert('目前只有个人信息，没有档案信息！');
				bootstrapValidator.setAllowSubmit(false);
			}
		}else{
			 bootbox.alert('请先选择某个人在操作工资标准调整！');
			 bootstrapValidator.setAllowSubmit(false);
		}
	}
  function printWageStandard(){
	  //var ids=$("#wageStandardList").jqGrid("getGridParam","selarrrow");
	  var ids=$("#wageStandardList").jqGrid("getGridParam","selrow");
	  if(ids&&ids.length>0){
			var param = {"id":ids,"type":1};
			templatePrint("storePS",param);
	  }else{
		 bootbox.alert('请选择记录');
	 }	
  }
</script>
</html>