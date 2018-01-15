<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>档案借阅归还登记</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<script type="text/javascript" src="${ctx}/js/util/form.js"></script>
<script>
	$(function() {
		initTable2();
		xfui.initUi();
	});
	function initTable2() {
		var columns= [
	                   {name:'AAC002',label:'身份证号',align:'center',frozen : true},
	                   {name:'AAC003',label:'姓名',align:'center',frozen : true},
	                   {name:'GENDERNAME',label:'性别',align:'center',frozen : true},
	                   {name:'ARCHIVECODE',label:'档案编号',align:'center'},
	                   {name:'RECEIVEDATE',label:'档案接收日期',align:'center'},
	                   {name:'MARKETPOSITIONNAME',label:'市场位置',align:'center'},
	                   {name:'CABINETSLIBRARY',label:'区',align:'center'},
	                   {name:'CABINETSCODE',label:'柜',align:'center'},
	                   {name:'CABINETSLAYER',label:'排',align:'center'},
	                   {name:'CABINETSLATTICE',label:'列',align:'center'},
	                   {name:'EXPENTRUSTCOMPANY',label:'所属单位名称',align:'center'},
	                   {name:'UANO',label:'单位协议编号',align:'center'},
	                   {name:'ARCHIVENAME',label:'档案姓名',align:'center'},
	                   {name:'ARCHIVEBIRTHDATE',label:'档案出生日期',align:'center'},
	                   {name:'ARCHIVESTATUSNAME',label:'档案状态',align:'center'},
	                   {name:'ARCHIVETYPENAME',label:'存档类型',align:'center'},
	                   {name:'ARCHIVERECEIVENAME',label:'窗口经办人',align:'center'},
	                   {name:'ARCHIVERECEIVEDATE',label:'窗口经办日期',align:'center'},
	                   {name:'ARCHIVERECEIVEORGNAME',label:'窗口经办机构',align:'center'},
	                   {name:'ID',label:'',hidden:true,key:true}

      	        	];

		$("#archiveResgisterOne").jqGrid({
	        mtype: "GET",
			styleUI : 'Bootstrap',
	        datatype: "local",
	        colModel: columns,
			viewrecords: true,
	        rowNum: 10,
	        rowList:[10,20,30],
	        pager: "#jqGridPager2",
	        pagerpos:'left',
	        regional : 'cn',
	        recordpos:'right',
	        shrinkToFit: false,
	        multiselect:true,
	        autowidth: true,
	        altRows:true,
	        height:'100%'
	    });
		$("#archiveResgisterOne").jqGrid('setFrozenColumns');
	}
	function doSearch2(){
		var json=$("#searchForm2").serializeJson();
		$("#archiveResgisterOne").jqGrid("clearGridData");	
		$("#archiveResgisterOne").jqGrid("setGridParam",{datatype: "json",url:'${ctx}/business/personagency/batch/archiveCheckout/listJson.xf',postData:json}).trigger("reloadGrid");
	}
	function refresh(){
		$("#archiveResgisterOne").jqGrid("setGridParam",{datatype: "json",url:'${ctx}/business/personagency/batch/archiveCheckout/listJson.xf'}).trigger("reloadGrid");
	}
</script>
</head>
	<form id="searchForm2">
		<div class="row">
			<label class="col-xs-3 col-sm-2" for="inputError">档案编号起:</label>
			<div class="col-xs-9 col-sm-2">
				<input class="form-control" type="text" name="beginArchiveCode" title="档案编号" data-placement="bottom"/>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">档案编号止:</label>
			<div class="col-xs-9 col-sm-2">
				<input class="form-control" type="text" name="endArchiveCode" title="档案编号" data-placement="bottom"/>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">存档类型:</label>
			<div class="col-xs-9 col-sm-2">
				<xf:select  tableName="RSDA_TAB_ARCHIVETYPE" valueField="code" hasDefault="0" textField="name" name="Q_archiveType_S" selectClass="form-control"></xf:select>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">档案出生日期起:</label>
			<div class="col-xs-9 input-group col-sm-2" >
               <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginarchiveBirthDate" name="beginarchiveBirthDate" type="text" placeholder="请选择日期"/>
               <span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
            </div>
			<label class="col-xs-3 col-sm-2" for="inputError">档案出生日期止:</label>
			<div class="col-xs-9 input-group col-sm-2">
               <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="endarchiveBirthDate" name="endarchiveBirthDate" type="text" placeholder="请选择日期"/>
               <span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
            </div>
			<label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">档案状态:</label>
			<div class="col-xs-9 col-sm-2">
				<xf:select  tableName="RSDA_TAB_ARCHIVESTATUS" valueField="code" textField="name" name="Q_archiveStatus_S"  hasDefault="0" selectClass="form-control"></xf:select>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">档案转入日期起:</label>
			<div class="col-xs-9 input-group col-sm-2" >
               <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginreceiveDate" name="beginreceiveDate" type="text" placeholder="请选择日期"/>
               <span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
            </div>
			<label class="col-xs-3 col-sm-2" for="inputError">档案转入日期止:</label>
			<div class="col-xs-9 input-group col-sm-2">
               <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="endreceiveDate" name="endreceiveDate" type="text" placeholder="请选择日期"/>
               <span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
            </div>
			<label class="col-xs-3 col-sm-2" for="inputError">单位名称:</label>
			<div class="col-xs-9 col-sm-2">
				<input class="form-control" type="text" name="Q_expEntrustCompany_SL" placeholder="" title="" data-placement="bottom"/>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">窗口经办日期起:</label>
			<div class="col-xs-9 input-group col-sm-2" >
               <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginarchiveReceiveDate" name="beginarchiveReceiveDate" type="text" placeholder="请选择日期"/>
               <span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
            </div>
			<label class="col-xs-3 col-sm-2" for="inputError">窗口经办日期止:</label>
			<div class="col-xs-9 input-group col-sm-2">
               <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="endarchiveReceiveDate" name="endarchiveReceiveDate" type="text" placeholder="请选择日期"/>
               <span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
            </div>
			<label class="col-xs-3 col-sm-2" for="inputError">单位协议编号:</label>
			<div class="col-xs-9 col-sm-2">
				<input class="form-control" type="text" name="Q_uaNo_SL" placeholder="" title="" data-placement="bottom"/>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">窗口经办机构:</label>
			<div class="col-xs-9 col-sm-2">
				<input class="form-control" type="text" name="Q_archiveReceiveOrgName_SL" placeholder="" title="" data-placement="bottom"/>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">窗口经办人:</label>
			<div class="col-xs-9 col-sm-2">
				<input class="form-control" type="text" name="Q_archiveReceiveName_SL" placeholder="" title="" data-placement="bottom"/>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12 mgb20 tar pdx20">
				<a href="javascript:doSearch2()" role="button"  class="btn btn-primary btn-border1"><i class="icon-search"></i>查询</a>
				<a href="javascript:resetForm('searchForm2')"  role="button" class="btn btn-info"><i class="icon-repeat"></i>重置</a>
			</div>
		</div>
		</form>
	<div class="moduleWrapNob">
		<div class="moduleTit">查询结果</div>
		<div class="moduleCont">
			<div class="mgy10"></div>
			<div class="row">
				<div class="col-xs-12">
					<table id="archiveResgisterOne" class="datagridClass"></table>
					<div id="jqGridPager2"></div>
				</div>
			</div>
		</div>
	</div>	
	<form:form modelAttribute="archiveCheckoutForm2" method="post" action="${ctx}/business/personagency/batch/archiveCheckout/resgisterSave.xf">
	<div class="moduleWrapNobg">
			<div class="moduleTit">借阅登记信息</div>
			<div class="moduleCont">
				<form:hidden path="id" ></form:hidden>
				<form:hidden path="archiveId" ></form:hidden>
				<form:hidden path="checkoutRegisterId" ></form:hidden>
				<form:hidden path="checkoutRegisterOrgId" ></form:hidden>
				<form:hidden path="archiveIds" id="archiveIds2"></form:hidden>
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>借阅类别:</label>
					 <div class="col-xs-9 col-sm-2 required">
						<xf:select textField="name" tableName="RSDA_TAB_CHECKOUTTYPE" name="checkoutType" value="${archiveCheckoutForm2.checkoutType }" valueField="code" 
							hasDefault="0" selectClass="form-control"></xf:select>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">借阅人:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="checkoutPerson"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">借阅人电话:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="checkoutPersonPhone"></form:input>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">借阅单位:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" path="checkoutCorp"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>生成批次名:</label>
					<div class="col-xs-9 col-sm-2 required">
						<form:input  class="form-control" type="text" path="batchName"></form:input>
					</div>
		            <label class="col-xs-3 col-sm-2" for="inputError">借阅期限日期:</label>
					<div class="col-xs-9 input-group col-sm-2">
		              <form:input  class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" type="text"  path="checkoutPeriodDate"></form:input>
		              <span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
		            </div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
					<div class="col-xs-9 input-group col-sm-2">
		              	<form:input  class="form-control" type="text"  path="checkoutRegisterDate" readonly="true"></form:input>
		            </div>
					<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="checkoutRegisterOrgName" readonly="true"></form:input>
				  	</div>
					<label class="col-xs-3 col-sm-2" for="inputError">经办人姓名:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="checkoutRegisterName" readonly="true"></form:input>
					</div>
				</div>
			</div>
	</div>
	<div class="bottomBtn">
   		<div class="h50">&nbsp;</div>
   		<div class="floatBtn">
	   		<button type="submit" class="btn btn-success"><i class="icon-edit"></i>批量借阅登记</button>
	   		<a role="button" class="btn btn-info" href="javascript:resetForm('archiveCheckoutForm2');resetValid()"><i class="icon-repeat"></i>重置</a>
   		</div>
   	</div>
   	</form:form>
<script type="text/javascript">
$(function(){
	initFormSubimt2();
})

 function resetValid(){
	 $('#archiveCheckoutForm2').data('bootstrapValidator').updateStatus('checkoutType', 'NOT_VALIDATED').validateField('checkoutType');
	 $('#archiveCheckoutForm2').data('bootstrapValidator').updateStatus('batchName', 'NOT_VALIDATED').validateField('batchName');
}
//单位档案批量借阅登记
/* function addBatchArchivesCheckOut(){
	var bootstrapValidator = $("#archiveCheckoutForm2").data('bootstrapValidator');  
	var ids=$("#archiveResgisterOne").jqGrid("getGridParam","selarrrow");
	if(ids&&ids.length>0){
		var id="";
		$.each(ids,function(i,e){
			if(i==0){
				id+=e;
			}else{
				id+=","+e;
			}
		});
		 $("#archiveIds2").val(id);
		 bootstrapValidator.setAllowSubmit(true);
	  }else{
		 bootbox.alert('请选择记录');
		 bootstrapValidator.disableSubmitButtons(false);
	 }	
} */
//单位批量登记保存
function initFormSubimt2(){
  $('#archiveCheckoutForm2').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	//借阅类别
        	checkoutType : {
                validators: {
                    notEmpty: {
                 	   message: '借阅类别不允许为空'
                    }
                }
            },
      	   //借阅人
            checkoutPerson: {
                 validators: { stringLength: {min: 0,max: 16 } }
        	  },
        	  //借阅人电话
           checkoutPersonPhone:{
	          	validators: {
	          		stringLength: { max: 15 },
               		regexp: {
        				regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
              			message: '电话号码或手机号码格式不正确'
               		}
	          	 }
           },
           //借阅单位
           checkoutCorp: {
                validators: { stringLength: {min: 0,max: 32 } }
       	  },
            //生成批次名
           batchName :{
           	validators: {
           			notEmpty: {
           				message: '生成批次名不允许为空'
                    },remote: {
                        type: 'POST',
                        url: '${ctx}/business/personagency/batch/archiveCheckout/checkedBatchName.xf',
                        message: '已有此批次名',
                        delay: 1000
                    },stringLength: {min: 0,max: 16 }
           		}
           }
        }
	     }).on('success.form.bv', function(e) {
             e.preventDefault();
             var $form = $(e.target);
             var bv = $form.data('bootstrapValidator');
             bv.disableSubmitButtons(true);
             /* $.post($form.attr('action'), $form.serialize(), function(data) {
                 bootbox.alert({
                     size: 'small',
                     width:"100px",
                     message: data.message,
                     callback: function(){
                    	 bv.disableSubmitButtons(false);
                    	 refresh();
                     }
                 })
             }, 'json'); */
             
             var ids=$("#archiveResgisterOne").jqGrid("getGridParam","selarrrow");
             if(ids&&ids.length>0){
      			  var id="";
      			  $.each(ids,function(i,e){
      					if(i==0){
      						id+=e;
      					}else{
      						id+=","+e;
      					}
      				});
      			$("#archiveIds2").val(id);
      			$.post($form.attr('action'), $form.serialize(), function(data) {
                 	console.info(data);
                     bootbox.alert({
                         size: 'small',
                         width:"100px",
                         message: data.message,
                         callback: function(){
                        	 bv.disableSubmitButtons(false);
                        	 refresh();
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
</html>