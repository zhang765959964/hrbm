<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>单位档案批量调出界面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<script type="text/javascript" src="${ctx}/js/business/personagency/archive/resultCorpArchiveLend.js?verson=20170110"></script>
	<script type="text/javascript">
		$(function(){
			initDataExp();
		})
		//导出
		function initDataExp(){
			var aab001=${aab001};
			$('#exp').dataexp({
				gridId:"corpArchiveResultList",
				serviceId:'archivesExpServiceImpl',
				fileName:'单位档案批量调出',
				sheetName:'单位档案批量调出',
				menuItem:[{title:"导出全部数据",paramCallBack:function(){
								var ids=$("#corpArchiveResultList").jqGrid("getDataIDs");
								if(ids&&ids.length>0){
									return {menuNumber:'f',ids:ids,aab001:aab001};
								}else{
									bootbox.alert('无可导出的数据！');
									return false;
								}
				           }},
					        {title:"导出当前页数据",paramCallBack:function(){
					        		var ids=$("#corpArchiveResultList").jqGrid("getDataIDs");
					      		    if(ids&&ids.length>0){	
							      		return {menuNumber:'f',ids:ids,aab001:aab001};
						      	    }else{
						      		    bootbox.alert('请选择记录');
						      		    return false;
						      	    }	
				  				}
						    }
				     ]
			});
		}
	</script>
</head>
<body>
<div class="moduleWrapNobg">
		<div class="moduleTit">单位协议信息</div>
		<div class="moduleCont">
			<form:form modelAttribute="corpUnitAgreementForm" method="post" action="">
				<div class="row">
					<div class="col-xs-12 col-sm-8 mgb0">
					<div class="row mgb0">
						<label class="col-xs-3 col-sm-3" for="inputError" title="单位名称">单位名称:</label>
						<div class="col-xs-12 col-sm-9">
							<form:input  class="form-control" type="text"  path="aab004" readonly="true"></form:input>
						</div>
					</div>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">工商登记执照号码:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="aab007" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">单位协议编号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="uaNo" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">协议签订日期:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="uaCreatetime" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">单位联系人:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="uaName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">联系电话:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="uaPhone" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">办理人身份证号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="uaCard" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">单位性质:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="aab019Name" readonly="true"></form:input>
					</div>
					<div class="col-xs-12 col-sm-12 threeCol">
					<div class="row rowTextarea">
						<label class="col-xs-3 col-sm-2" for="inputError" title="备注">协议主要内容:</label>
						<div class="col-xs-9 col-sm-10">
							<form:textarea  type="text"  path="uaContent" row="2" col="5" readonly="true"></form:textarea>
						</div>
					</div>
				</div>
				</div>
			</form:form>
		</div>
	</div>
	<div class="moduleWrapNob">
		<div class="moduleTit">在档信息列表</div>
		<div class="moduleCont">
			<div class="mgy10">
				<div class="keep-open  btn-group vat" title="">
					<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
						<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i>
					</a>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<table id="corpArchiveResultList"  class="datagridClass"></table>
					<div id="jqGridPager"></div>
				</div>
			</div>
		</div>
	</div>
		<!-- 档案调出-带点击按钮 -->
<form:form modelAttribute="archiveLendForm" method="post" action="${ctx}/business/personagency/corp/archiveLend/save.xf">
	<div class="moduleWrapNobg">
		<div class="moduleTit">档案调出信息</div>
		<div class="moduleCont">
			<form:hidden path="lendId" ></form:hidden>
			<form:hidden path="archivesId" ></form:hidden>
			<form:hidden path="lendCreaterId" ></form:hidden>
			<form:hidden path="lendCreaterOrgId" ></form:hidden>
			<form:hidden path="lendFlowStatus" ></form:hidden>
			<form:hidden path="archiveIds" id="archiveIds"></form:hidden>
			<div class="row">
				<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>调出时间:</label>
				<div class="col-xs-9 input-group col-sm-2">
					<div class="input-group row required">
                          	<form:input  class="form-control" type="text" path="lendDate" placeholder="请选择日期"></form:input>
                          	<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i></span>
                       </div>
                      </div>
				<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>调出办理人:</label>
				<div class="col-xs-9 col-sm-2 required">
					<form:input  class="form-control" type="text" path="lendName"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>档案去向（单位）:</label>
				<div class="col-xs-9 col-sm-2 required">
					<form:input  class="form-control" type="text" path="archivesLendWhere"></form:input>
				</div>
			</div>
			<div class="row">
				<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>调出原因:</label>
				<div class="col-xs-9 col-sm-2 required">
					<xf:select  tableName="RSDA_TAB_LEND_REASON" valueField="code" textField="name" name="lendReason"
				 		value='${archiveLendForm.lendReason}' hasDefault="0" selectClass="form-control"></xf:select>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">调出办理人身份证号:</label>
				<div class="col-xs-9 col-sm-2">
					<form:input  class="form-control" type="text" path="lendIdNumber"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">调出办理人联系电话:</label>
				<div class="col-xs-9 col-sm-2">
					<form:input  class="form-control" type="text" path="lendPhone"></form:input>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-12 threeCol">
					<div class="row rowTextarea">
						<label class="col-xs-3 col-sm-2" for="inputError" title="调出备注">调出备注:</label>
						<div class="col-xs-9 col-sm-10">
							<form:textarea  type="text"  path="lendRemarks" row="2" col="5"></form:textarea>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<hr/>
	<div class="col-xs-12 col-sm-12">
		<div class="row">
			<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
			<div class="col-xs-9 col-sm-2">
                      <form:input  class="form-control" type="text" path="lendCreaterDate" readonly="true"></form:input>
                  </div>
			<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
			<div class="col-xs-9 col-sm-2">
				<form:input  class="form-control" type="text" path="lendCreaterOrgName" readonly="true"></form:input>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
			<div class="col-xs-9 col-sm-2">
				<form:input  class="form-control" type="text" path="lendCreaterName" readonly="true"></form:input>
			</div>
		</div>
	</div>
	<div class="bottomBtn">
   		<div class="h50">&nbsp;</div>
   		<div class="floatBtn">
	   		<button type="submit" class="btn btn-primary"><i class="icon-pencil"></i>调出登记</button>
   		</div>
   	</div>
   </form:form>
<script>
$(function(){
	initFormSubimt();
	var columns= [
	                {name:'ID',label:'',align:'center',hidden:true,key:true},
                   	{name:'archiveCode',label:'档案编号',align:'center',frozen : true},
                    {name:'aac003',label:'姓名',align:'center',frozen : true},
                    {name:'aac002',label:'身份证号',align:'center',frozen : true},
                    {name:'genderName',label:'性别',align:'center'},
	                {name:'expEntrustCompany',label:'委托单位名称',align:'center'},
                    {name:'expOldCompany',label:'原单位名称',align:'center'},
                    {name:'expStartJobDate',label:'参加工作时间',align:'center'},
	                {name:'expPersonPhone',label:'联系电话',align:'center'},
                    {name:'aae005',label:'手机号',align:'center'},
                    {name:'archiveTypeName',label:'存档类型',align:'center'},
                    {name:'archiveReceiveStatusName',label:'接收状态',align:'center'},
                    {name:'receiveDate',label:'档案转入日期',align:'center'},
                    {name:'marketPosition',label:'市场位置',align:'center'},
                    {name:'cabinetsLibrary',label:'区',align:'center'},
                    {name:'cabinetsCode',label:'柜',align:'center'},
                    {name:'cabinetsLayer',label:'排',align:'center'},
                    {name:'cabinetsLattice',label:'列',align:'center'},
                    {name:'archiveStorageName',label:'入库经办人',align:'center'},
	                {name:'archiveStorageOrgName',label:'入库经办机构',align:'center'},
	                {name:'archiveStorageDate',label:'入库经办日期',align:'center'}
                   

      	        ];
	$("#corpArchiveResultList").jqGrid({
		   url:'${ctx}/business/personagency/corp/archiveLend/listJson.xf?aab001=${aab001}',
           mtype: "GET",
		   styleUI : 'Bootstrap',
           datatype: "json",
           colModel: columns,
		   viewrecords: true,
           rowNum: 10,
           rowList:[10,20,30],
           altRows: true,
           pager: "#jqGridPager",
           pagerpos:'left',
           regional : 'cn',
           recordpos:'right',
           altRows:true,
           shrinkToFit: false,
           multiselect:true,
           autowidth: true,
           height:'100%'
       });
	$("#corpArchiveResultList").jqGrid('setFrozenColumns');
})

//单位档案批量调出登记
/* function addCorpArchivesLend(){
	var ids=$("#corpArchiveResultList").jqGrid("getGridParam","selarrrow");
	if(ids&&ids.length>0){
		var id="";
		$.each(ids,function(i,e){
			if(i==0){
				id+=e;
			}else{
				id+=","+e;
			}
		});
		$("#archiveIds").val(id);
		return true;
	  }else{
		 bootbox.alert('请选择记录');
		 return false;
	 }
} */
//单位批量登记保存
function initFormSubimt(){
  $('#archiveLendForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	//调出时间
        	lendDate : {
                validators: {
                    notEmpty: {
                 	   message: '调出时间不允许为空'
                    }, date: {
                        format: 'YYYY-MM-DD',
                        message: '请输入正确的时间格式'
                    }
                }
            },
            //调出办理人
           lendName :{
           	validators: {
           			notEmpty: {
           				message: '调出办理人不允许为空'
                    },stringLength: {
                        min: 2,
                        max: 15
                    }
           		}
           },
            //档案去向
           archivesLendWhere :{
           	validators: {
           			notEmpty: {
           				message: '档案去向不允许为空'
                    },stringLength: {
                        min: 2,
                        max: 50
                    }
           		}
           },
            //调出原因
           lendReason :{
           	validators: {
           			notEmpty: {
           				message: '调出原因不允许为空'
                    }
           		}
           },
           //调出办理人身份证号
    	   lendIdNumber : {
               validators: {
	            	   callback: {
	   					message: '身份证号格式不正确',
	   					callback:function(value, validator,$field){
	   						if(!value){
	   							return true;
	   						}
	   						return validateIdCard(value);
	   					}
	   			   }
               }
           },
          //调出办理人联系电话
           lendPhone : {
               validators: {
            	    stringLength: { max: 15 },
              		regexp: {
       				regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
             			message: '电话号码或手机号码格式不正确'
              		}
               }
           },
          //调出备注
           lendRemarks : {
               validators: {
           		   stringLength: {min: 1,max: 50, message:'长度在1-50位之间' } 
               }
           }
           
        }
	     }).on('success.form.bv', function(e) {
             e.preventDefault();
             var $form = $(e.target);
             var bv = $form.data('bootstrapValidator');
             bv.disableSubmitButtons(true);
             var ids=$("#corpArchiveResultList").jqGrid("getGridParam","selarrrow");
             if(ids&&ids.length>0){
      			  var id="";
      			  $.each(ids,function(i,e){
      					if(i==0){
      						id+=e;
      					}else{
      						id+=","+e;
      					}
      				});
      			$("#archiveIds").val(id);
      			$.post($form.attr('action'), $form.serialize(), function(data) {
                 	console.info(data);
                     bootbox.alert({
                         size: 'small',
                         width:"100px",
                         message: data.message,
                         callback: function(){
                        	 bv.disableSubmitButtons(false);
                        	 $("#corpArchiveReceive").load("${ctx}/business/personagency/corp/archiveLend/resultList.xf?aab001=${aab001}");
                         }
                     })
                 }, 'json');
              }else{
            	  bootbox.alert('请选择记录');	
            	  bv.disableSubmitButtons(false);
              }
         });
}

</script>
</body>
</html>