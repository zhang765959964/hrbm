<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>档案移库页面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
		<div class="moduleWrapNobg">
			<div class="moduleTit">存档信息</div>
			<div class="moduleCont">
				<form:form modelAttribute="storageArchivesPersonForm" method="post" action="">
					<div class="row">
						<label class="col-xs-3 col-sm-2" for="inputError">身份证号:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="aac002" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="aac003" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">姓名拼音码:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="aac022" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">出生日期:</label>
						<div class="col-xs-9 input-group col-sm-2">
                          	<form:input  class="form-control" type="text"  path="aac006" readonly="true"></form:input>
                          	<span class="input-group-addon">
                              	<i class="icon-calendar bigger-110"></i>
                          	</span>
                        </div>
						<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="genderName" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">民族:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="nationName" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">婚姻状况:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="MaritalStatusName" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">配偶姓名:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="faName" readonly="true"></form:input>
						</div>
                        <label class="col-xs-3 col-sm-2" for="inputError">文化程度:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="educationName" readonly="true"></form:input>
						</div>
                        <label class="col-xs-3 col-sm-2" for="inputError">政治面貌:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="politicalLandScape" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">参加工作时间:</label>
						<div class="col-xs-9 input-group col-sm-2">
                          	<form:input  class="form-control" type="text"  path="expStartJobDate" readonly="true"></form:input>
                          	<span class="input-group-addon">
                              	<i class="icon-calendar bigger-110"></i>
                          	</span>
                        </div>
						<label class="col-xs-3 col-sm-2" for="inputError" title="是否军转干部">是否军转干部:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="expIsCadreName" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError" title="联系电话">联系电话:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="expPersonPhone" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError" title="手机号">手机号:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="aae005" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError" title="是否享有再就业优惠证标准">是否享有再就业优惠证标准:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="expISDiscount" readonly="true"></form:input>
						</div>
						<div class="col-xs-12 col-sm-8 mgb0">
							<div class="row mgb0">
								<label class="col-xs-3 col-sm-3" for="inputError" title="现居住地址">现居住地址:</label>
								<div class="col-xs-12 col-sm-9">
									<form:input  class="form-control" type="text"  path="aab301" readonly="true"></form:input>
								</div>
							</div>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError" title="档案编号">档案编号:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="archiveCode" readonly="true"></form:input>
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
                        <label class="col-xs-3 col-sm-2" for="inputError" title="档案姓名">档案姓名:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="archiveName" readonly="true"></form:input>
						</div>
                        <label class="col-xs-3 col-sm-2" for="inputError" title="退休年数">退休年数:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="retiredAge" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">退休参考日期:</label>
						<div class="col-xs-9 input-group col-sm-2">
                          	<form:input  class="form-control" type="text"  path="planRetiredDate" readonly="true"></form:input>
                          	<span class="input-group-addon">
                              	<i class="icon-calendar bigger-110"></i>
                          	</span>
                        </div>
						<label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">档案状态:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="archiveStatusName" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">个人编号:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="expPersonNumber" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">委托单位名称:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="expEntrustCompany" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">存档类型:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="archiveTypeName" readonly="true"></form:input>
						</div>
						<div class="col-xs-12 col-sm-12 threeCol">
							<div class="row rowTextarea">
								<label class="col-xs-3 col-sm-2" for="inputError" title="备注">备注:</label>
								<div class="col-xs-9 col-sm-10">
									<form:textarea  type="text"  path="aae013" row="2" col="5" readonly="true"></form:textarea>
								</div>
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<!-- 查询条件结束 -->
		<!-- 查询结果开始 -->
		<form:form modelAttribute="storageArchivesSaveForm" method="post" action="${ctx}/business/personagency/storage/storage/save.xf">
			<div class="moduleWrapNobg">
				<div class="moduleTit">档案移库信息</div>
				<div class="moduleCont">
						<form:hidden path="id" ></form:hidden>
						<form:hidden path="archiveReceiveStatus" ></form:hidden>
						<form:hidden path="archiveStorageUserid" ></form:hidden>
						<form:hidden path="archiveStorageOrgId" ></form:hidden>
						<div class="row" >
							<label class="col-xs-3 col-sm-2" for="inputError">市场位置:</label>
							<div class="col-xs-9 col-sm-2">
							 	<xf:select  tableName="RSDA_TAB_MARKET_POSITION" valueField="code" textField="name" name="marketPosition"  
							 		value='${storageArchivesSaveForm.marketPosition}' hasDefault="0" selectClass="form-control"></xf:select>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">区:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input  class="form-control" type="text" path="cabinetsLibrary"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">柜:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input  class="form-control" type="text" path="cabinetsCode"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">排:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input  class="form-control" type="text" path="cabinetsLayer"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">列:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input  class="form-control" type="text" path="cabinetsLattice"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">档案来源:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input  class="form-control" type="text" path="archiveSource"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">接收状态:</label>
							<div class="col-xs-9 col-sm-2">
								<c:if test="${storageArchivesSaveForm.archiveReceiveStatus==null }">
									<input type="text" value="" class="form-control" readonly="true">
								</c:if>
								<c:if test="${storageArchivesSaveForm.archiveReceiveStatus==1 }">
									<input type="text" value="未入库" class="form-control" readonly="true">
								</c:if>
								<c:if test="${storageArchivesSaveForm.archiveReceiveStatus==2 }">
									<input type="text" value="已入库" class="form-control" readonly="true">
								</c:if>
							</div>
							<div class="col-xs-12 col-sm-12 threeCol">
								<div class="row rowTextarea">
									<label class="col-xs-3 col-sm-2" for="inputError" title="档案存放位置备注">档案存放位置备注:</label>
									<div class="col-xs-9 col-sm-10">
										<form:textarea  type="text"  path="archiveReceiveDesc" row="2" col="5"></form:textarea>
									</div>
								</div>
							</div>
						</div>
				</div>
			</div>
			<hr />
			<div class="col-xs-12 col-sm-12">
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
					<div class="col-xs-9 col-sm-2">
	                    <form:input  class="form-control" type="text" path="archiveStorageDate" readonly="true"></form:input>
	                </div>
					<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" path="archiveStorageOrgName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" path="archiveStorageName" readonly="true"></form:input>
					</div>
				</div>
			</div>
	    </form:form>
	    <div class="bottomBtn">
	   		<div class="h50">&nbsp;</div>
	   		<div class="floatBtn">
		   		<a  role="button" class="btn btn-primary" href="javascript:submitForm('${archiveId}')"><i class="icon-save"></i>保存</a>
		   		<a  role="button" class="btn btn-success" href="javascript:registerNewUser()"><i class="icon-plus"></i>新增</a>
		   		<a  role="button" class="btn btn-success" onclick=""><i class="icon-barcode"></i>打印条码标签</a>
	   		</div>
	   	</div>
<script type="text/javascript">
		$(function() {
			initFormSubimt();
		});
		
		function submitForm(archiveId){
			if(archiveId>0){
				$('#storageArchivesSaveForm').submit();
			}else{
				bootbox.alert('请先选择档案信息！');
			}
		}
		
		//档案接收保存
		function initFormSubimt(){
	         $('#storageArchivesSaveForm').bootstrapValidator({
	               message: 'This value is not valid',
	               feedbackIcons: {
	                   valid: 'glyphicon glyphicon-ok',
	                   invalid: 'glyphicon glyphicon-remove',
	                   validating: 'glyphicon glyphicon-refresh'
	               },
	               fields: {
	            	   archiveSource : {
	                       validators: {
	                           stringLength: {
	                               min: 0,
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
	                    	console.info(data);
	                        $(".btn-submit").removeAttr("disabled");
	                        bootbox.alert({ 
	                            size: 'small',
	                            width:"100px",
	                            message: data.message, 
	                            callback: function(){ 
	                            	$("#storageArchivesResultList").load("${ctx}/business/personagency/storage/storage/resultList.xf?personId=${personId}");
	                            }
	                        })
	                    }, 'json');

	                });
	       }
	//登记新户
	function registerNewUser(){
		$("#storageArchivesResultList").load("${ctx}/business/personagency/storage/storage/resultList.xf");
	}
</script>	
</body>		
</html>