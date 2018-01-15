<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>户口信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
	<script type="text/javascript" src="${ctx}/js/business/personagency/residence/resultTotalResidenceList.js"></script>
<script>
	$(function() {
		initTable();
		initTransferTable();
		initResidenceReturnTable();
		$("#residenceMoveOut").removeClass("in").removeClass("active");
		$("#residenceBorrowReturn").removeClass("in").removeClass("active");
		refresh();
	});
	
	function initTable() {
		var columns= [
	                  {name:'applicationDate',label:'申请日期',align:'center',frozen : true},
	                  {name:'materialCategoryName',label:'材料类别 ',align:'center',frozen : true},
	                  {name:'materialName',label:'提交材料名称',align:'center',frozen : true},
	                  {name:'aae005',label:'联系方式',align:'center'},
	                  {name:'isBackName',label:'是否退回',align:'center'},
	                  {name:'backReason',label:'退回原因',align:'center'},
	                  {name:'applicationOneselfDate',label:'材料退回本人日期',align:'center'},
	                  {name:'isNoticeName',label:'是否通知',align:'center'},
	                  {name:'noticeDate',label:'通知日期',align:'center'},
	                  {name:'createrName',label:'经办人',align:'center'},
	                  {name:'createrDate',label:'经办日期',align:'center'},
	                  {name:'createrOrgName',label:'经办机构',align:'center'}
	               
	 	        	];
		$("#residenceList").jqGrid({
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
		      multiselect:true,
		      autowidth: true,
		      height : '100%'
		  });
		
		$("#residenceList").jqGrid('setFrozenColumns');
	}
	
	function initTransferTable() {
		var columns2 = [
		                   {name:'residenceNumber',label:'户口编号',align:'center',frozen : true},
		                   {name:'residenceStatusName',label:'户口状态',align:'center',frozen : true},
		                   {name:'moveDate',label:'迁入日期',align:'center',frozen : true},
		                   {name:'outDate',label:'迁移日期',align:'center'},
		                   {name:'settleDepartment',label:'落户地户籍部门',align:'center'},
		                   {name:'originalDomicile',label:'原户籍所在地',align:'center'},
		                   {name:'settleAddress',label:'落户地址',align:'center'},
		                   {name:'openDate',label:'开具日期',align:'center'},
		                   {name:'thoseGraduates',label:'毕业生届期',align:'center'},
		                   {name:'moveToAddress',label:'迁移地址',align:'center'},
		                   {name:'description',label:'备注',align:'center'},
		                   {name:'createrName',label:'经办人',align:'center'},
		                   {name:'createrOrgName',label:'经办机构',align:'center'},
		                   {name:'createrDate',label:'经办日期',align:'center'}
	                
	 	        	];
		$("#residenceMoveOutList").jqGrid({
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
          multiselect:true,
          autowidth: true,
          height:'100%'
      });
		/* $("#residenceMoveOutList").jqGrid('setFrozenColumns'); */
	}
	
	function initResidenceReturnTable() {
		var columns3= [
	                 
	                   {name:'borrowerName',label:'借用人姓名',align:'center',frozen : true},
	                   {name:'borrowerCard',label:'借用人身份证号',align:'center',frozen : true},
	                   {name:'borrowerPhone',label:'借用人联系电话',align:'center',frozen : true},
	                   {name:'borrowerDate',label:'借用日期',align:'center'},
	                   {name:'maturityDate',label:'到期日期',align:'center'},
	                   {name:'returnDate',label:'归还日期',align:'center',cellattr: addCellAttr},
	                   {name:'createrName',label:'经办人',align:'center'},
	                   {name:'createrOrgName',label:'经办机构',align:'center'},
	                   {name:'createrDate',label:'经办日期',align:'center'}
	                
     	        	];
		$("#residenceReturnList").jqGrid({
	          mtype: "GET",
			  styleUI : 'Bootstrap',
	          datatype: "local",
	          colModel: columns3,
			  viewrecords: true,
	          rowNum: 10,
	          rowList:[10,20,30],
	          pager: "#jqGridPager3",
	          pagerpos:'left',
	          regional : 'cn',
	          recordpos:'right',
	          shrinkToFit: false,
	          multiselect:true,
	          autowidth: true,
	          height : '100%'
	      });
	
		/* $("#residenceReturnList").jqGrid('setFrozenColumns'); */
	}
	
	function refresh(){
		$("#residenceList").jqGrid("setGridParam",{datatype: "json",url:'${ctx}/business/personagency/residence/residence/listJson.xf?personId=${personId}'}).trigger("reloadGrid");
		$("#residenceMoveOutList").jqGrid("setGridParam",{datatype: "json",url:'${ctx}/business/personagency/residence/residenceMoveOut/listJson.xf?personId=${personId}'}).trigger("reloadGrid");
		$("#residenceReturnList").jqGrid("setGridParam",{datatype: "json",url:'${ctx}/business/personagency/residence/residenceReturn/listJson.xf?personId=${personId}'}).trigger("reloadGrid");
	}
	function refresh3(){
		$("#residenceReturnList").jqGrid("setGridParam",{datatype: "json",url:'${ctx}/business/personagency/residence/residenceReturn/listJson.xf?personId=${personId}'}).trigger("reloadGrid");
	}
	function addCellAttr(rowId, val, rawObject, cm, rdata) {
        return "style='color:red'";
    }


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
	<!-- tab选项卡 -->
	<div class="tabable">
		<ul class="nav nav-tabs padding-12 tab-color-blue background-blue">
			<li class="active"><a data-toggle="tab" href="#residence">户口材料信息</a></li>
			<li><a data-toggle="tab" href="#residenceMoveOut">户口迁入迁移信息</a></li>
			<li><a data-toggle="tab" href="#residenceBorrowReturn">户口借用归还信息</a></li>
		</ul>
		<div class="tab-content">
			<div id="residence" class="tab-pane in active">
				<div class="moduleWrapNob">
					<div class="moduleCont">
						<div class="mgy10">
							<a  href="javascript:addResidence('${id}')" role="button" class="btn btn-primary" ><i class="icon-plus"></i>添加</a>
							<a  href="javascript:delResidence()" role="button" class="btn btn-danger"><i class="icon-trash"></i>删除</a>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<table id="residenceList" class="datagridClass"></table>
								<div id="jqGridPager1"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="residenceMoveOut" class="tab-pane in active">
				<div class="moduleWrapNob">
					<div class="moduleCont">
						<div class="mgy10">
							<a  href="javascript:addResidenceMoveOut('${id}')"  role="button" class="btn btn-primary" ><i class="icon-edit"></i>迁入</a>
							<a  href="javascript:editResidenceMoveOut()" role="button" class="btn btn-info" ><i class="icon-external-link"></i>迁移</a>
							<a  href="javascript:delResidenceMoveOut()"  role="button" class="btn btn-danger" ><i class="icon-trash"></i>删除</a>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<table id="residenceMoveOutList"  class="datagridClass"></table>
								<div id="jqGridPager2"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="residenceBorrowReturn" class="tab-pane in active">
				<div class="moduleWrapNob">
					<div class="moduleCont">
						<div class="mgy10">
							<a  href="javascript:addResidenceReturn('${id}')"  role="button" class="btn btn-primary" ><i class="icon-external-link"></i>借用</a>
							<a  href="javascript:editResidenceReturn()" role="button" class="btn btn-info" ><i class="icon-edit"></i>归还</a>
							<a  href="javascript:delResidenceReturn()"  role="button" class="btn btn-danger" ><i class="icon-trash"></i>删除</a>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<table id="residenceReturnList"  class="datagridClass"></table>
								<div id="jqGridPager3"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
	//添加户口材料信息
	function addResidence(id){
		if(id>0){
			xfui.open_dialog({    
			    title: '添加户口材料',    
			    width: 950,    
			    height: 500,    
			    closed: false,    
			    cache: false,    
			    url: "${ctx}/business/personagency/residence/residence/add.xf?id=${id}",
			    modal: true   
			})
		}else{
			bootbox.alert('请先选择一条人员档案信息！');
		}
	}
	
	//添加户口迁入迁出信息
	function addResidenceMoveOut(id){	
		if(id>0){
			xfui.open_dialog({    
			    title: '添加户口迁入信息',    
			    width: 950,    
			    height: 500,    
			    closed: false,    
			    cache: false,    
			    url: "${ctx}/business/personagency/residence/residenceMoveOut/add.xf?id=${id}",
			    modal: true   
			})
		}else{
			bootbox.alert('请先选择一条人员档案信息！');
		}
	}
	
	//添加借用归还信息
	function addResidenceReturn(archiveId){	
		if(archiveId>0){
			var id=$("#residenceMoveOutList").jqGrid("getGridParam","selrow");
			var rowData = $("#residenceMoveOutList").jqGrid('getRowData',id);	
			var residenceStatusName = rowData.residenceStatusName;
			if(id){
				if(residenceStatusName=="迁移"){
					bootbox.alert('户口已经迁移出去，不能借用户口信息');
				}else{
					var ids=$("#residenceReturnList").jqGrid("getDataIDs");
					var returnDate="aa";
					if(ids&&ids.length>0){
						$.each(ids,function(i,e){
							var rowData = $("#residenceReturnList").jqGrid('getRowData',e);	
							var aa = rowData.returnDate;
							if(aa==""){
								returnDate = "";
							}
						})
					}
					if(returnDate==""){
						bootbox.alert('户口已经借用出去、还没有归还，不能重复借用！');
					}else{
						var id=id;
						xfui.open_dialog({    
						    title: '户口借用信息',    
						    width: 950,    
						    height: 500,    
						    closed: false,    
						    cache: false,    
						    url: "${ctx}/business/personagency/residence/residenceReturn/add.xf?moId="+id,
						    modal: true   
						})
					}
				}
			}else{
				bootbox.alert('请先选择一条户口迁入信息！');
			}	
		}else{
			bootbox.alert('请先选择一条人员档案信息！');
		}
	}

</script>
</html>