<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>编辑 单位协议表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="${ctx}/js/business/personagency/retired/searchRetiredList.js?v=201702022"></script>
	<script type="text/javascript">
	$(function (){
		$("#gzName").val("1");
		initlWorkEx();
	})
	//工作经历		 
	function initlWorkEx(){
		  var columns= [
			            {name:'id',label:'操作',key: true,align:'center',width:80,frozen : true,	formatter:'actions',formatoptions:{
								keys: false,
								editbutton : true,
								delbutton : false,
								onSuccess :function (){
									whrefresh();
								}
					   }},
	                   {name:'personId',label:'人员id',align:'center',editable : true,hidden:true},
	                   {name:'createTime',label:'起始时间',align:'center',editable : true,unformat: pickDate,editrules : {
	                	   required : true,
	                	   date:true,
	                	   custom:true, 
	                	   date:true,
	                	   custom:true, 
	                	   custom_func:function(value, colNames){    

	                		  if(!(/^[0-9]{4}-(0?[0-9]|1[0-2])-(0?[1-9]|[12]?[0-9]|3[01])$/.test(value))){
	                			   return [false,"请输入YYYY-MM-DD日期格式！"];
	                			   
	                		  }else{
	                			  $("#workWhBeginDate").val(value);
		                		   return [true,""];
		                	  }
		                	   
	                		 
	                	   }}

                	   },
	                   {name:'endTime',label:'终止时间',align:'center',editable : true,unformat: pickDate,editrules : {
	                	   required : true,
	                	   date:true,
	                	   custom:true, 
	                	   custom_func:function(value, colNames){   
	                		   if(!(/^[0-9]{4}-(0?[0-9]|1[0-2])-(0?[1-9]|[12]?[0-9]|3[01])$/.test(value))){
	                			   return [false,"请输入YYYY-MM-DD日期格式！"];
	                			   
	                		  }else{
	                			  $("#workWhEndDate").val(value);
		                		  var bb = $("#workWhBeginDate").val();
		                		  var ee = $("#workWhEndDate").val();
		                		  if(bb>ee){
		                			   return [false,"起始时间不能大于终止时间"];
		                		  }else{		
		                			   return [true,""];
		                		  }		
		                	 }
	                   	}}
                	   },
	                   {name:'workUnit',label:'工作单位',align:'center',editable : true,editrules :{ required : true}, editoptions:{size:10,maxlength:15}},
	                   {name:'gzName',label:'工种',align:'center',
	                   		editable:true,edittype:"select",editoptions:{value: "${gzValue}" }
	                   },
	                   {name:'createrName',label:'经办人',align:'center'},
	                   {name:'createrOrgName',label:'经办机构',align:'center'},
	                   {name:'createrDate',label:'经办日期',align:'center'}
      	        	];
			var personIds = $("#personIds").val();
			if(personIds==""){
				personIds=0;
			}
	    $("#workExList").jqGrid({
	    	   url:CTX+'/business/personagency/experience/listJson.xf?personId='+personIds,
	    	   editurl:CTX+'/business/personagency/experience/saveOrUpdate.xf',
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
	           height:'100%',
	           altRows:true,
	           multiboxonly : true,
	           shrinkToFit: false,
	           multiselect:true,
	           autowidth: true,
	           gridComplete:function(){
	            	  $(".ui-inline-edit").removeAttr("onclick").on("click",function(){
	            		  jQuery.fn.fmatter.rowactions.call(this,'edit');
	            	  })
	            	  $(".ui-inline-save").removeAttr("onclick").on("click",function(){
	            		  jQuery.fn.fmatter.rowactions.call(this,'save');
	            	  })
	            	  $(".ui-inline-cancel").removeAttr("onclick").on("click",function(){
	            		  jQuery.fn.fmatter.rowactions.call(this,'cancel');
	            	  })
	            	  
	             }
	       });  
	}
	</script>
	
</head>
<body>
	<input type="hidden"  value="${personId }" id="personIds" />
	<form:form modelAttribute="retiredDeclareForm" method="post" action="${ctx}/business/personagency/retired/declare/save.xf">
		<div class="moduleWrapNobg">
			<div class="moduleTit">退休申报信息</div>
			<div class="moduleCont">
				<input type="hidden"  id="gsBsj" value="${gsCreateDate }" />
				<input type="hidden"  id="gsEsj" value="${gsStopDate }" />
				<form:hidden path="id" id="id"></form:hidden>
				<form:hidden path="retiredDto.personId" ></form:hidden>
				<form:hidden path="retiredDto.archivesId"  ></form:hidden>
				<form:hidden path="retiredDto.workId"></form:hidden>
				<form:hidden path="retiredDto.expandId"></form:hidden>
				<form:hidden path="createrOrgId"></form:hidden>
				<form:hidden path="createrId" ></form:hidden>
				<form:hidden  path="peopleId" ></form:hidden>
				<form:hidden  path="archiveId" ></form:hidden>
				<form:hidden  id="createrId1" path="yangLaoForm.createrId" ></form:hidden>
				<form:hidden  id="createrOrgId1" path="yangLaoForm.createrOrgId" ></form:hidden>
				<form:hidden  id="createrName1" path="yangLaoForm.createrName" ></form:hidden>
				<form:hidden  id="createrOrgName1" path="yangLaoForm.createrOrgName" ></form:hidden>
				<form:hidden  id="createrDate1" path="yangLaoForm.createrDate" ></form:hidden>
				<form:hidden id="expStartJobDate" path="retiredDto.expStartJobDate" ></form:hidden>
				<form:hidden id="expPersonNumber" path="retiredDto.expPersonNumber" ></form:hidden>
				
				<input type="hidden" id="workJlBeginDate" />
				<input type="hidden" id="workJlEndDate" />
				<input type="hidden" id="workWhBeginDate" />
				<input type="hidden" id="workWhEndDate" />
				<input type="hidden" id="kjNum1" />
				 
				<div class="row">
	 				<label class="col-xs-3 col-sm-2" for="inputError">身份证号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="retiredDto.personCard"  readonly="true"></form:input>
					</div>
						 
					<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="retiredDto.personName" readonly="true"></form:input>
					</div>
						 
					<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="retiredDto.sex" readonly="true"></form:input>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
						 <div class="col-xs-9 col-sm-2 ">
							<form:input  class="form-control" type="text" id="dabh"  path="retiredDto.dabh" readonly="true"></form:input>
						
						</div>
						 
					<label class="col-xs-3 col-sm-2" for="inputError">社会保障号:</label>
						 <div class="col-xs-9 col-sm-2 ">
							<form:input  class="form-control" type="text"  path="retiredDto.shbzh" ></form:input>
						</div>
						 
					<label class="col-xs-3 col-sm-2" for="inputError">存档类型:</label>
					  <div class="col-xs-9 input-group col-sm-2">
	                  	<form:input  class="form-control" type="text"  path="retiredDto.type"  readonly="true"></form:input>
	                 </div>
	            </div>  
	            <div class="row">
	                <label class="col-xs-3 col-sm-2" for="inputError">档案状态:</label>
					<div class="col-xs-9 col-sm-2 ">
							<form:input  class="form-control" type="text"  path="retiredDto.status" readonly="true"></form:input>
					</div>						
					<label class="col-xs-3 col-sm-2" for="inputError">档案姓名:</label>
					<div class="col-xs-9 col-sm-2 ">
						<form:input  class="form-control" type="text"  path="retiredDto.archiveName" readonly="true"></form:input>
					</div>
						 
					<label class="col-xs-3 col-sm-2" for="inputError">档案出生日期:</label>
						<div class="col-xs-9 input-group col-sm-2">
	                  	<form:input  class="form-control" type="text"  path="retiredDto.birthDate" readonly="true"></form:input>
	                  	<span class="input-group-addon">
	                      	<i class="icon-calendar bigger-110"></i>
	                  	</span>
	                </div> 
		   		</div>
		   	    <div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">就业单位名称:</label>
					<div class="col-xs-9 col-sm-2 ">
						<form:input  class="form-control" type="text"  path="retiredDto.aac045" readonly="true"></form:input>
					</div>
									 
					<label class="col-xs-3 col-sm-2" for="inputError">档案转入日期:</label>
					    <div class="col-xs-9 input-group col-sm-2">
	                  	<form:input  class="form-control" type="text"  path="retiredDto.daStopDate" readonly="true"></form:input>
	                  	<span class="input-group-addon">
	                      	<i class="icon-calendar bigger-110"></i>
	                  	</span>
	                </div>
					<label class="col-xs-3 col-sm-2" for="inputError">现岗位职位工种:</label>
					<div class="col-xs-9 col-sm-2 ">
						<form:input  class="form-control" type="text"  path="retiredDto.zhuanye" readonly="true"></form:input>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">原单位名称:</label>
					<div class="col-xs-9 col-sm-2 ">
						<form:input  class="form-control" type="text"  path="retiredDto.oldCompany" ></form:input>
					</div>
						 
					<label class="col-xs-3 col-sm-2" for="inputError">档案来源:</label>
					<div class="col-xs-9 input-group col-sm-2">
	                  	<form:input  class="form-control" type="text"  path="retiredDto.source" readonly="true"></form:input>
	                </div>	
	           	</div>	
	            <div class="row">
	                <div class="col-xs-12 col-sm-8">
						<div class="row">
							<label class="col-xs-3 col-sm-3" for="inputError" title="现居住地址">现居住地址:</label>
							<div class="col-xs-9 cole -sm-9">
								<form:input  class="form-control" type="text"  path="retiredDto.addre" ></form:input>
							</div>
						</div>
					</div>


					<label class="col-xs-3 col-sm-2" for="inputError">联系电话:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="retiredDto.phone" ></form:input>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-8">
						<div class="row">
							<label class="col-xs-3 col-sm-3" for="inputError" title="身份证地址">身份证地址:</label>
							<div class="col-xs-9 col-sm-9">
								<form:input  class="form-control" type="text"  path="retiredDto.cardAddre" id="expCardNumber"></form:input>
							</div>
						</div>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">手机号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="retiredDto.mobilePhone" ></form:input>
					</div>
			    </div>
								
			</div>
		</div>
		
		<div class="moduleWrapNobg">
			<div class="moduleCont">
			    <div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">单位名称:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" value="郑州市职业介绍中心"  path="unitName"  readonly="true"></form:input>
					</div>
						 
					<label class="col-xs-3 col-sm-2" for="inputError">单位编号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="unitNo" value="410199005071"  readonly="true"></form:input>
					</div>
						 
					<label class="col-xs-3 col-sm-2" for="inputError">郑劳退字（）年（）号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="zltzh" ></form:input>
					</div>
				</div>
				<div class="row">					 
					<label class="col-xs-3 col-sm-2" for="inputError">序号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="xh" readonly="true"></form:input>
					</div>
										 
					<label class="col-xs-3 col-sm-2" for="inputError">工种:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="craft"></form:input>
					</div>
										 
					<label class="col-xs-3 col-sm-2" for="inputError">参加工作日期:</label>
					<div class="col-xs-9 input-group col-sm-2">
						<div class="input-group row">
							<form:input  class="form-control" type="text"  path="createWorkDate" ></form:input>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>	 
									
		        </div>
		        <div class="row">	
		              								
					<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>退休人员所属区域:</label>
					<div class="col-xs-9 col-sm-2 required">
						<form:input  class="form-control" type="text"  path="retiredArea" ></form:input>
					</div>
						 
					<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>退休（退职）依据:</label>
					<div class="col-xs-9 col-sm-2 required">
						<xf:select textField="name" selectClass="form-control" tableName="RSDA_TAB_RETIRED_GIST" id="retiredYj" name="retiredYjId" isShowCode="true" value="${retiredDeclareForm.retiredYjId }"  valueField="code" hasDefault="0" ></xf:select>
					</div>
									
					<label class="col-xs-3 col-sm-2" for="inputError">退休类别:</label>
					<div class="col-xs-9 col-sm-2">
						<xf:select textField="name" selectClass="form-control" tableName="RSDA_TAB_RETIRED_TYPE" id="retiredType" name="retiredTypeId"  value="${retiredDeclareForm.retiredTypeId}"  valueField="code" hasDefault="0"></xf:select>
					</div>
				 </div>		
				 <div class="row">				
					<label class="col-xs-3 col-sm-2" for="inputError">退休后安置点:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  value="郑州" path="retiredSite" ></form:input>
					</div>
										 
					<label class="col-xs-3 col-sm-2" for="inputError">退休申报状态:</label>
					<div class="col-xs-9 col-sm-2">
					
						<c:if test="${retiredDeclareForm.retiredDeclareStatus ==null or  retiredDeclareForm.retiredDeclareStatus =='1' }">
							<form:input  class="form-control" type="text"  value="待申报" readonly="true" path="retiredDeclareStatus" ></form:input> 
						</c:if>
						<c:if test="${retiredDeclareForm.retiredDeclareStatus == '2' }">
							<form:input  class="form-control" type="text"  value="申报中" readonly="true" path="retiredDeclareStatus" ></form:input> 
						</c:if>
						<c:if test="${retiredDeclareForm.retiredDeclareStatus == '3' }">
							<form:input  class="form-control" type="text"  value="申报完毕" readonly="true" path="retiredDeclareStatus" ></form:input> 
						</c:if>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">民族:</label>
					<div class="col-xs-9 col-sm-2">
					 	 <xf:select textField="name" selectClass="form-control" tableName="TAB_NATION" name="nationalId"  value="${retiredDeclareForm.retiredDto.nationId }" valueField="code" hasDefault="0"></xf:select>
					</div>
				</div>
				<div class="row">							 
					<label class="col-xs-3 col-sm-2" for="inputError">申报分类:</label>
					<div class="col-xs-9 col-sm-2">
						<form:select  path="declareType" class="form-control">
							<form:option value="0" label="正常申报"/>是
							<form:option value="1" label="追加申报"/>否
						</form:select>
					</div>
										 
					<label class="col-xs-3 col-sm-2" for="inputError">公示开始时间:</label>
					<div class="col-xs-9 input-group col-sm-2">
						<div class="input-group row">
							<form:input  class="form-control" type="text"  path="gsCreateDate" id="gsBDate"></form:input>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>	 
					<label class="col-xs-3 col-sm-2" for="inputError">公示结束时间:</label>
					<div class="col-xs-9 input-group col-sm-2">
						<div class="input-group row">
							<form:input  class="form-control" type="text"  path="gsStopDate" ></form:input>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>	 
									
		         </div>       
		         <div class="row">	        							
					<label class="col-xs-3 col-sm-2" for="inputError">个人编号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="retiredPeopleNo" ></form:input>
					</div>
						 
					<label class="col-xs-3 col-sm-2" for="inputError">退休个人编码:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="retiredPeopleBm" readonly="true"></form:input>
					</div>
				</div>
				<div class="row">							
					<div class="col-xs-12 col-sm-12">
	                    <div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError" title="申报备注">申报备注:</label>
							<div class="col-xs-9 col-sm-10">
								<form:textarea path="declareNote"  row="5" col="5" type="text"/>
							</div>
						</div>
					 </div>
				 </div>									
			</div>
		</div>
		
	    <div class="moduleWrapNobg">
			<div class="moduleTit">
				<span class="fl">主要工作经历维护</span>
			</div>
			
			<div class="moduleCont">
				<div class="mgy10">
					<a  href="javascript:addWorkWh()" role="button" class="btn btn-primary" ><i class="icon-plus"></i>添加</a>
					<a   href="javascript:delWorkWh()" role="button" class="btn btn-danger" ><i class="icon-trash"></i>删除</a>
				</div>
				<div class="row">
					<div class="col-xs-12">
						<table id="workExList"></table>
					    <div id="jqGridPager"></div>
					</div>
				</div>
			</div>
	    </div>
	    
	    <div class="moduleWrapNobg">
			<div class="moduleTit">
				<span class="fl">工作扣减情况维护</span>
			</div>
			<div class="moduleCont">
				<div class="mgy10">
					<a  href="javascript:addWorkKj()" role="button" class="btn btn-primary" ><i class="icon-plus"></i>添加</a>
					<a   href="javascript:delWorkKj()" role="button" class="btn btn-danger" ><i class="icon-trash"></i>删除</a>
				</div>
				<div class="row">
					<div class="col-xs-12">
						<table id="workKjList"></table>
					    <div id="jqGridPager1"></div>
					</div>
				</div>
			</div>
	    </div>
		<div class="moduleCont">
		    <div class="row">
		    	<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
				<div class="col-xs-9 col-sm-2">
				    <form:input  class="form-control" type="text"  path="createrName" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
				<div class="col-xs-9 col-sm-2">
					<form:input  class="form-control" type="text"  path="createrOrgName" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
				<div class="col-xs-9 input-group col-sm-2">
				 	<form:input  class="form-control" type="text"  path="createrDate" readonly="true"></form:input>
	            </div>
			</div>
		</div>
		
		<div class="bottomBtn">
			 <div class="floatBtn clearfix">
				<button class="btn btn-primary" role="button" type="submit">
					<i class="icon-save"></i>保存
				</button>
				<a  role="button" href="javascript:retiredClear()" class="btn btn-primary"><i class="icon-plus"></i>新增</a>
				<a  role="button" href="javascript:delByPersonId()" class="btn btn-danger"><i class="icon-trash"></i>删除</a>
				<a  role="button" class="btn btn-success" onclick="printRetired()"><i class="icon-barcode"></i>打印审批表</a>
			</div> 
		</div>
	</form:form>	
</body>
</html>	
	
	
	
