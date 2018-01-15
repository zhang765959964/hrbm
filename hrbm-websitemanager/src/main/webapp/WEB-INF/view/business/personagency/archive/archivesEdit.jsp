<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 人员档案表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
	<script type="text/javascript">
	 $(function(){

		 initFormSubimt();
			  $("#receiveDate").xfdaterangepicker({singleDatePicker:true,
				  "opens":"right",
				  "drops": "up",
	              "locale": {
	                  "format": "YYYY-MM-DD"
	              }
	          });
			  $("#archiveBirthDate").xfdaterangepicker({singleDatePicker:true,
				  "opens":"right",
				  "drops": "up",
	              "locale": {
	                  "format": "YYYY-MM-DD"
	              }
	          });
			  $("#planRetiredDate").xfdaterangepicker({singleDatePicker:true,
				  "opens":"right",
				  "drops": "up",
	              "locale": {
	                  "format": "YYYY-MM-DD"
	              }
	          });
			  $("#storageDate").xfdaterangepicker({singleDatePicker:true,
				  "opens":"right",
				  "drops": "up",
	              "locale": {
	                  "format": "YYYY-MM-DD"
	              }
	          });
			  $("#archiveReceiveDate").xfdaterangepicker({singleDatePicker:true,
				  "opens":"right",
				  "drops": "up",
	              "locale": {
	                  "format": "YYYY-MM-DD"
	              }
	          });
			  $("#archiveStorageDate").xfdaterangepicker({singleDatePicker:true,
				  "opens":"right",
				  "drops": "up",
	              "locale": {
	                  "format": "YYYY-MM-DD"
	              }
	          });
	 })
     function initFormSubimt(){
         $('#archivesForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   //发布名称
                   demoField: {
                       validators: {
                           notEmpty: {
                           },
                           stringLength: {
                               min: 2,
                               max: 50
                           }
                       }
                   }
               }
           }).on('success.form.bv', function(e) {
                    e.preventDefault();
                    var $form = $(e.target);
                    var bv = $form.data('bootstrapValidator');
                    $.post($form.attr('action'), $form.serialize(), function(data) {
                        $(".btn-submit").removeAttr("disabled");
                        bootbox.alert({
                            size: 'small',
                            width:"100px",
                            message: data.message,
                            callback: function(){
                            	var parentIframe=xfui.getParentIframe();
            			    	if(parentIframe){
            			    		parentIframe.refresh();
            			    	}
                            	closeItem();

                            }
                        })

                    }, 'json');

                });
       }
	  function closeItem(){

		  xfui.closeDialog();
	  }
	</script>
</head>
<body>
   	  <form:form modelAttribute="archivesForm" method="post" action="${ctx}/business/personagency/archive/archives/save.xf">
			<form:hidden path="id" ></form:hidden>
				 <div class="modal-body overflow-visible reportWrap">
				    <div class="row" style="padding:0 30px;">
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案编号：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="archiveCode" ></form:input>
							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案接收日期：</label>
							<div class="col-xs-8 col-sm-6">
							  <div class="input-group">
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								    <form:input  class="form-control" type="text"  path="receiveDate" ></form:input>
								</div>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案名称：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="archiveName" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案出生日期：</label>
							<div class="col-xs-8 col-sm-6">
							  <div class="input-group">
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								    <form:input  class="form-control" type="text"  path="archiveBirthDate" ></form:input>
								</div>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">退休年数：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="retiredAge" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">退休参考日期：</label>
							<div class="col-xs-8 col-sm-6">
							  <div class="input-group">
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								    <form:input  class="form-control" type="text"  path="planRetiredDate" ></form:input>
								</div>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">存档类型：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="archiveType" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">市场位置：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="marketPosition" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">合同编号：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="contractCode" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案状态：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="archiveStatus" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">人员Id：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="personId" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案排号：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="cabinetsCode" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案层号：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="cabinetsLayer" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案组号：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="cabinetsLattice" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案存放备注：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="receiveDesc" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案接收人ID：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="archiveReceiveUserid" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案入库人ID：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="archiveStorageUserid" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案入库日期：</label>
							<div class="col-xs-8 col-sm-6">
							  <div class="input-group">
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								    <form:input  class="form-control" type="text"  path="storageDate" ></form:input>
								</div>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">流转状态：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="archiveFlowStatus" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">方位 南北：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="cabinetsPositionStatus" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案来源：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="archiveSource" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案库号：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="cabinetsLibrary" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案接收人姓名：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="archiveReceiveName" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案接收经办机构id：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="archiveReceiveOrgId" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案接收经办机构名称：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="archiveReceiveOrgName" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案接收经办日期：</label>
							<div class="col-xs-8 col-sm-6">
							  <div class="input-group">
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								    <form:input  class="form-control" type="text"  path="archiveReceiveDate" ></form:input>
								</div>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案入库人姓名：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="archiveStorageName" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案入库经办机构id：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="archiveStorageOrgId" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案入库经办机构名称：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="archiveStorageOrgName" ></form:input>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案入库经办日期：</label>
							<div class="col-xs-8 col-sm-6">
							  <div class="input-group">
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								    <form:input  class="form-control" type="text"  path="archiveStorageDate" ></form:input>
								</div>

							</div>
						</div>
					   <div class="col-xs-12 col-sm-6" >
							<label class="col-xs-2" for="inputError">档案接收状态（0-未入库，1-已入库）：</label>
							<div class="col-xs-8 col-sm-6">
								 <form:input  class="form-control" type="text"  path="archiveReceiveStatus" ></form:input>

							</div>
						</div>
				  </div>
				 </div>
					<div class="modal-footer">
						<button class="btn btn-sm" data-dismiss="modal" onclick="closeItem()">
							<i class="icon-remove"></i>
							关闭
						</button>

						<button class="btn btn-sm btn-primary" type="submit">
							<i class="icon-ok"></i>
							保存
						</button>
					</div>
        </form:form>
</body>
</html>
