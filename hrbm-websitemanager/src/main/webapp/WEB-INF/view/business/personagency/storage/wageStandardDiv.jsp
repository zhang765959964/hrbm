<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>工资标准调整</title>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
	<script type="text/javascript">
		$(function(){
			  initFormSubimt();
			  $("#aac006").xfdaterangepicker({singleDatePicker:true,
				  autoUpdateInput:false,
				  formValidatorId:"wageStandardForm",
				  "opens":"right",
				  "drops": "down",
	            "locale": {
	                "format": "YYYY-MM-DD"
	            }
	        });
			  $("#expStartJobDate").xfdaterangepicker({singleDatePicker:true,
				  autoUpdateInput:false,
				  formValidatorId:"wageStandardForm",
				  "opens":"right",
				  "drops": "down",
	            "locale": {
	                "format": "YYYY-MM-DD"
	            }
	        });
	        $("#adjustDate").xfdaterangepicker({singleDatePicker:true,
	      	  autoUpdateInput:false,
	      	  formValidatorId:"wageStandardForm",
				  "opens":"right",
				  "drops": "down",
	            "locale": {
	                "format": "YYYY-MM-DD"
	            }
	        });
		 })
	</script>
</head>
	<!-- 工资标准调整 -->
	<form:form modelAttribute="wageStandardForm" method="post" action="${ctx}/business/personagency/storage/wageStandard/save.xf" onsubmit="return submitForm()">
		<form:hidden path="id" ></form:hidden>
		<form:hidden path="archivesId" ></form:hidden>
		<form:hidden path="personId" ></form:hidden>
		<form:hidden path="createrId" ></form:hidden>
		<form:hidden path="createrOrgId" ></form:hidden>
		<form:hidden path="ccpr08" ></form:hidden>
		<form:hidden path="aac004" ></form:hidden>
		<form:hidden path="aac005" ></form:hidden>
	<div class="moduleWrapNobg">
		<div class="moduleTit">工资标准调整</div>
		<div class="moduleCont">
			<div class="row">
				<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
				<div class="col-xs-9 col-sm-2">
					<form:input class="form-control" type="text" path="aac003" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
				<div class="col-xs-9 col-sm-2">
					<xf:select tableName="TAB_SEX" valueField="code" textField="name" name="aac004"  
									value='${wageStandardForm.aac004}' hasDefault="0" selectClass="form-control" disabled="true"></xf:select>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">民族:</label>
				<div class="col-xs-9 input-group col-sm-2">
                       <xf:select tableName="TAB_NATION" valueField="code" textField="name" name="aac005"
									value='${wageStandardForm.aac005}' hasDefault="0" selectClass="form-control" disabled="true"></xf:select>
                   </div>
				<label class="col-xs-3 col-sm-2" for="inputError">文化程度:</label>
				<div class="col-xs-9 col-sm-2">
					<xf:select  tableName="TAB_EDUCATION" valueField="code" textField="name" name="aac011"  
							value='${wageStandardForm.aac011}' hasDefault="0" selectClass="form-control"></xf:select>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">出生年月:</label>
				<div class="col-xs-9 input-group col-sm-2">
					<div class="input-group row">
	                    <form:input  class="form-control" type="text"  path="aac006" ></form:input>
	                    <span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
	                </div>
                </div>
				<label class="col-xs-3 col-sm-2" for="inputError">参加工作时间:</label>
				<div class="col-xs-9 input-group col-sm-2">
					<div class="input-group row">
	                  	<form:input  class="form-control" type="text"  path="expStartJobDate"></form:input>
	                   	<span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
                   	 </div>
                 </div>
              </div>
              <div class="row">
				<label class="col-xs-3 col-sm-2" for="inputError">现岗位职位工种:</label>
				<div class="col-xs-9 col-sm-2">
					<form:input  class="form-control" type="text"  path="positionType"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>调整日期:</label>
				<div class="col-xs-9 input-group col-sm-2">
					<div class="input-group row required">
	                  	<form:input  class="form-control date" type="text" path="adjustDate" placeholder="请选择日期"></form:input>
	                  	<span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
	                </div>
               </div>	
			</div>
			<hr/>
			<!-- 工资调整情况 -->
			<div class="halfHeight clearfix">
				<div class="halfLeft">
					<h3>调整情况（调整前）</h3>
					<div class="col-xs-12 col-sm-12 twoCol2">
						<div class="row">
							<label class="col-xs-3 col-sm-3" for="inputError" title="执行何工资制度">执行何工资制度:</label>
							<div class="col-xs-9 col-sm-8">
								<form:input  class="form-control" type="text"  path="ja01" ></form:input>
							</div>
						</div>
					</div>
					<!-- 工资标准双input -->
					<div class="row">
						<div class="col-xs-12 col-col-12">
							<label class="col-xs-3 col-sm-3" for="inputError">技能或等级工资级别:</label>
							<div class="col-xs-9 col-sm-4">
								<form:input  class="form-control" type="text"  path="ja02" ></form:input>
							</div>
							<div class="col-xs-9 col-sm-4">
								<form:input  class="form-control" type="text"  path="ja03" onkeyup="TriggerAddition()"></form:input>
							</div>
							<span class="col-xs-3 col-sm-1 pd0">元</span>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-col-12">
							<label class="col-xs-3 col-sm-3" for="inputError">岗位工资级别:</label>
							<div class="col-xs-9 col-sm-4">
								<form:input  class="form-control" type="text"  path="ja04" ></form:input>
							</div>
							<div class="col-xs-9 col-sm-4">
								<form:input  class="form-control" type="text"  path="ja05" onkeyup="TriggerAddition()"></form:input>
							</div>
							<span class="col-xs-3 col-sm-1 pd0">元</span>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-col-12">
							<label class="col-xs-3 col-sm-3" for="inputError">联动工资:</label>
							<div class="col-xs-9 col-sm-4">
							</div>
							<div class="col-xs-9 col-sm-4">
								<form:input  class="form-control" type="text"  path="ja06" id="ja06" onkeyup="TriggerAddition()"></form:input>
							</div>
							<span class="col-xs-3 col-sm-1 pd0">元</span>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-col-12">
							<label class="col-xs-3 col-sm-3" for="inputError">工龄工资:</label>
							<div class="col-xs-9 col-sm-4">&nbsp;
							</div>
							<div class="col-xs-9 col-sm-4">
								<form:input  class="form-control" type="text"  path="ja07" id="ja07" onkeyup="TriggerAddition()"></form:input>
							</div>
							<span class="col-xs-3 col-sm-1 pd0">元</span>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-col-12">
							<label class="col-xs-3 col-sm-3" for="inputError">调整前合计:</label>
							<div class="col-xs-9 col-sm-4">
							</div>
							<div class="col-xs-9 col-sm-4">
								<form:input  class="form-control" type="text"  path="ja08" id="ja08" readonly="true"></form:input>
							</div>
							<span class="col-xs-3 col-sm-1 pd0">元</span>
						</div>
					</div>
				</div>
				<div class="halfRight">
					<h3>调整情况（调整后）</h3>
					<div class="col-xs-12 col-sm-12 twoCol2">
						<div class="row">
							<label class="col-xs-3 col-sm-3" for="inputError" title="执行何工资制度">执行何工资制度:</label>
							<div class="col-xs-9 col-sm-8">
								<form:input  class="form-control" type="text"  path="jb01" ></form:input>
							</div>
						</div>
					</div>
					<!-- 工资标准双input -->
					<div class="row">
						<div class="col-xs-12 col-col-12">
							<label class="col-xs-3 col-sm-3" for="inputError">技能或等级工资级别:</label>
							<div class="col-xs-9 col-sm-4">
								<form:input  class="form-control" type="text"  path="jb02" ></form:input>
							</div>
							<div class="col-xs-9 col-sm-4">
								<form:input  class="form-control" type="text"  path="jb03" id="jb03" onkeyup="HouAddition()"></form:input>
							</div>
							<span class="col-xs-3 col-sm-1 pd0">元</span>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-col-12">
							<label class="col-xs-3 col-sm-3" for="inputError">技能或等级工资级别:</label>
							<div class="col-xs-9 col-sm-4">
								<form:input  class="form-control" type="text"  path="jb04" ></form:input>
							</div>
							<div class="col-xs-9 col-sm-4">
								<form:input  class="form-control" type="text"  path="jb05" id="jb05" onkeyup="HouAddition()"></form:input>
							</div>
							<span class="col-xs-3 col-sm-1 pd0">元</span>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-col-12">
							<label class="col-xs-3 col-sm-3" for="inputError">联动工资:</label>
							<div class="col-xs-9 col-sm-4">
							</div>
							<div class="col-xs-9 col-sm-4">
								<form:input  class="form-control" type="text"  path="jb06" id="jb06" onkeyup="HouAddition()"></form:input>
							</div>
							<span class="col-xs-3 col-sm-1 pd0">元</span>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-col-12">
							<label class="col-xs-3 col-sm-3" for="inputError">工龄工资:</label>
							<div class="col-xs-9 col-sm-4">&nbsp;
							</div>
							<div class="col-xs-9 col-sm-4">
								<form:input  class="form-control" type="text"  path="jb07" id="jb07" onkeyup="HouAddition()"></form:input>
							</div>
							<span class="col-xs-3 col-sm-1 pd0">元</span>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-col-12">
							<label class="col-xs-3 col-sm-3" for="inputError">调整后合计:</label>
							<div class="col-xs-9 col-sm-4">
							</div>
							<div class="col-xs-9 col-sm-4">
								<form:input  class="form-control" type="text"  path="jb08" id="jb08" readonly="true"></form:input>
							</div>
							<span class="col-xs-3 col-sm-1 pd0">元</span>
						</div>
					</div>
				</div>
			</div>
			<hr/>
			<!-- 等级升级情况 -->
			<div class="clearfix">
				<div class="halfLeft">
					<h3>升级情况（升级前）</h3>
					<div class="row">
						<label class="col-xs-3 col-sm-3" for="inputError" title="升级前等级">升级前等级:</label>
						<div class="col-xs-9 col-sm-6">
							<form:input  class="form-control" type="text"  path="ja09" ></form:input>
						</div>
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-3" for="inputError" title="升级前月工资标准">升级前月工资标准:</label>
						<div class="col-xs-9 col-sm-6">
							<form:input  class="form-control" type="text"  path="ja10" ></form:input>
						</div>
						<span class="col-xs-3 col-sm-1 pd0">元</span>
					</div>
				</div>
				<div class="halfRight">
					<h3>升级情况（升级后）</h3>
					<div class="row">
						<label class="col-xs-3 col-sm-3" for="inputError" title="升级后等级">升级后等级:</label>
						<div class="col-xs-9 col-sm-6">
							<form:input  class="form-control" type="text"  path="jb09" ></form:input>
						</div>
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-3" for="inputError" title="升级后月工资标准">升级后月工资标准:</label>
						<div class="col-xs-9 col-sm-6">
							<form:input  class="form-control" type="text"  path="jb10" ></form:input>
						</div>
						<span class="col-xs-3 col-sm-1 pd0">元</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<hr />
	<div class="col-xs-12 col-sm-12">
		<div class="row">
            <label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
		    <div class="col-xs-9 input-group col-sm-2">
             	<form:input  class="form-control" type="text"  path="createrDate" readonly="true"></form:input>
             	<span class="input-group-addon">
                 	<i class="icon-calendar bigger-110"></i>
             	</span>
            </div>	
			<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
			<div class="col-xs-9 col-sm-2">
				<form:input  class="form-control" type="text"  path="createrOrgName" readonly="true"></form:input>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
			<div class="col-xs-9 col-sm-2">
				<form:input  class="form-control" type="text"  path="createrName" readonly="true"></form:input>
			</div>
		</div>
	</div>
	<div class="bottomBtn">
   		<div class="h50">&nbsp;</div>
   		<div class="floatBtn">
	   		<button type="submit" class="btn btn-primary"><i class="icon-save"></i>保存</button>
	   		<a role="button" class="btn btn-success" href="javascript:removeDiv()"><i class="icon-plus"></i>新增</a>
	   		<a role="button" class="btn btn-danger" href="javascript:delWageStandard()"><i class="icon-trash"></i>删除</a>
	   		<a role="button" class="btn btn-primary btn-border1" href="javascript:printWageStandard()" ><i class="icon-print"></i>打印调整表</a>
   		</div>
   	</div>
</form:form>

<script type="text/javascript">
	 //调整前合计
	 function TriggerAddition(){
		var ja03 = $("#ja03").val();
		var ja05 = $("#ja05").val();
		var ja06 = $("#ja06").val();
		var ja07 = $("#ja07").val();
		var total = 0 ;
		if(parseInt(ja03)>0){
			total+=parseFloat(ja03);
		}
		if(parseInt(ja05)>0){
			total+=parseFloat(ja05);
		}
		if(parseInt(ja06)>0){
			total+=parseFloat(ja06);
		}
		if(parseInt(ja07)>0){
			total+=parseFloat(ja07);
		}
		total = parseFloat(total.toFixed(2));
		$("#ja08").val(total);
	 }
	 
	 //调整后合计
	 function HouAddition(){
		var jb03 = $("#jb03").val();
		var jb05 = $("#jb05").val();
		var jb06 = $("#jb06").val();
		var jb07 = $("#jb07").val();
		var total = 0 ;
		if(parseInt(jb03)>0){
			total+=parseFloat(jb03);
		}
		if(parseInt(jb05)>0){
			total+=parseFloat(jb05);
		}
		if(parseInt(jb06)>0){
			total+=parseFloat(jb06);
		}
		if(parseInt(jb07)>0){
			total+=parseFloat(jb07);
		}
		total = parseFloat(total.toFixed(2));
		$("#jb08").val(total);
	 }
</script>
</html>