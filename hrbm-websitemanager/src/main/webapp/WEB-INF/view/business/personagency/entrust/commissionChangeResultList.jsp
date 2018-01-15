<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>委托类型变更</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   	<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
   	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	$(function(){
		var columns= [
		               
	                   {name:'commissionTypeName',label:'变更类型',align:'center',frozen : true},
	                   {name:'commissionDate',label:'变更日期',align:'center',frozen : true},
	                   {name:'archiveCodeBefore',label:'变更前档案编号',align:'center'},
	                   {name:'archiveCodeAfter',label:'变更后档案编号',align:'center'},
	                   {name:'commissionCorpName',label:'变更委托单位名称',align:'center'},
	                   {name:'description',label:'备注',align:'center'},
	                   {name:'createrName',label:'经办人',align:'center'},
	                   {name:'createrDate',label:'经办日期',align:'center'},
	                   {name:'createrOrgName',label:'经办机构',align:'center'},
	                   {name:'id',label:'变更表id',align:'center',hidden:true}
     	        	];
		
		$("#commissionChangeList").jqGrid({
	           mtype: "GET",
			   url:CTX+'/business/personagency/entrust/commissionChange/searchListJson.xf?personId=${personId}',
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
	           multiselect:false,
	           autowidth: true,
	           rownumbers : true,
	           height:'100%',
	           onSelectRow:function(rowId){
		    	  var rowData=$(this).jqGrid("getRowData",rowId);
		    	  if(rowData.id>0){
			    	  $("#commissionDiv").load("${ctx}/business/personagency/entrust/commissionChange/commissionDivSearch.xf?id=${id}&archiveFlowStatus=${archiveFlowStatus }&bgID="+rowData.id);
			    	  if(flag==2){
			    		  
			    	  }else{
				    	  flag = 0;
			    	  }
		    	  }else{
		    		  $("#commissionDiv").load("${ctx}/business/personagency/entrust/commissionChange/commissionDiv.xf?id=${id}&archiveFlowStatus=${archiveFlowStatus }");
		    		  flag = 2;
		    	  }
			   }
	       });
		$("#commissionChangeList").jqGrid('setFrozenColumns');
	})
	
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
					<div class="col-xs-12 col-sm-6">
						<form:input  class="form-control" type="text"  path="expEntrustCompany" readonly="true"></form:input>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-12 col-sm-2" for="inputError">档案接收人:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveReceiveName" readonly="true"></form:input>
					</div>
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
	<div class="col-sm-5 pd0 moduleWrapNobg">
		<div class="moduleTit">历史变更记录</div>
		<br/>
		<div class="moduleCont resultWrap h335">
			<div class="col-xs-12">
				<table id="commissionChangeList"  class="datagridClass"></table>
				<div id="jqGridPager"></div>
			</div>
		</div>
	</div>
	<div id="commissionDiv">
		
	</div>
<script>
	var flag = 0;
	
	 $(function(){
         $("#commissionDiv").load("${ctx}/business/personagency/entrust/commissionChange/commissionDivSearch.xf?id=${id}&archiveFlowStatus=${archiveFlowStatus }");
	 })
	//新增
	function addCommissionChange(id,archiveFlowStatus){
		if(flag>0){
			if(flag==2){
				bootbox.alert("已有新增记录，请先保存！");
			}
		}else{
			if(id>0){
				if(archiveFlowStatus==1){
					bootbox.alert("当前个人档案处于【借阅登记】中，不能办理委托类型变更");
				}else if(archiveFlowStatus==2){
					bootbox.alert("当前个人档案处于【借阅确认】中，不能办理委托类型变更");
				}else if(archiveFlowStatus==3){
					bootbox.alert("当前个人档案处于【返还登记】中，不能办理委托类型变更");
				}else if(archiveFlowStatus==5){
					bootbox.alert("当前个人档案处于【调出登记】中，不能办理委托类型变更");
				}else if(archiveFlowStatus==6){
					bootbox.alert("当前个人档案处于【调出确认】中，不能办理委托类型变更");
				}else{
				    $.ajax({
				        type: "post",
				        url: "${ctx}/business/personagency/entrust/commissionChange/addjqGrid.xf",
				        data: {id:id},
				        dataType: "json",
				        success: function(data){
				           if(flag!=2){
					           $("#commissionChangeList").jqGrid("addRowData", null, data, "first");  
					           flag = 2;
				           }else{
					           flag = 1;
				           }
				           $("#commissionDiv").load("${ctx}/business/personagency/entrust/commissionChange/commissionDiv.xf?id="+id+"&archiveFlowStatus="+archiveFlowStatus);
				        }
				    });
				}
			}else{
				 bootbox.alert("请先选择档案数据");
			}
		}
	}
	
	  function initFormSubimt(){
	        $('#commissionChangeForm').bootstrapValidator({
	              message: 'This value is not valid',
	              feedbackIcons: {
	                  valid: 'glyphicon glyphicon-ok',
	                  invalid: 'glyphicon glyphicon-remove',
	                  validating: 'glyphicon glyphicon-refresh'
	              },
	              fields: {
	            	  commissionType : {
	                      validators: {
	                          notEmpty: {
	                       	   		message: '请选择变更类型'
	                          }
	                      }
	                  },
	                  //变更委托单位名称
	                  commissionCorpName : {
	                      validators: {
	                    	  notEmpty: {
	                          	   message: '变更委托单位名称不允许为空'
	                          },
	                          stringLength: {
	                              min: 0,
	                              max: 50
	                          }
	                      }
	                  },
	                  //备注
	                  description : {
	                      validators: {
	                          stringLength: {
	                              min: 0,
	                              max: 200
	                          }
	                      }
	                  }, 
	               //变更日期
	               commissionDate: {
	                        validators: { 
	                            date: {
	                                format: 'YYYY-MM-DD',
	                                message: '请输入正确的时间格式'
	                            }
	               	  	   }
	               }
	              }
	          }).on('success.form.bv', function(e) {
	                   e.preventDefault();
	                   var $form = $(e.target);
	                   var bv = $form.data('bootstrapValidator');
	                   bv.disableSubmitButtons(true);
	                   $.post($form.attr('action'), $form.serialize(), function(data) {
	                       bootbox.alert({ 
	                           size: 'small',
	                           width:"100px",
	                           message: data.message, 
	                           callback: function(){ 
	                        	   bv.disableSubmitButtons(false);
	                        	   $("#commissionChangeSearchList").load("${ctx}/business/personagency/entrust/commissionChange/resultList.xf?personId=${personId}");
	                        	   flag = 0;
	                           }
	                       })
	                       
	                   }, 'json');

	               });
	      }
	  
	//打印条形码
	function printCodeLabel(archiveId){
		if(archiveId>0){
			var param = {"id":archiveId,"type":3};
			templatePrint("archiveLabel",param);
		}else{
			bootbox.alert('没有档案信息，不能打印条码标签！');
		}
	}
	
</script>
</html>