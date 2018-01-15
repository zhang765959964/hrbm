<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>人员档案表管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<script type="text/javascript" src="${ctx}/js/business/personagency/storage/normalResultStorageArchives.js"></script>
<script>
	$(function(){
		initDataExp();
	})
	$(function(){
		var columns= [
							
							{name:'ARCHIVECODE',label:'档案编号',align:'center',frozen : true},
							{name:'AAC003',label:'姓名',align:'center',frozen : true},
							{name:'AAC002',label:'身份证号',align:'center',frozen : true},
							{name:'AAE005',label:'手机号',align:'center'},
							{name:'EXPPERSONPHONE',label:'联系电话',align:'center'},
							{name:'GENDERNAME',label:'性别',align:'center'},
							{name:'AAC006',label:'出生日期',align:'center'},
							{name:'ARCHIVETYPENAME',label:'存档类型',align:'center'},
							{name:'ARCHIVERECEIVESTATUSNAME',label:'接收状态',align:'center'},
							{name:'ARCHIVENAME',label:'档案姓名',align:'center'},
							{name:'ARCHIVEBIRTHDATE',label:'档案出生日期',align:'center'},
							{name:'RECEIVEDATE',label:'档案接收日期',align:'center'},
							{name:'MARKETPOSITION',label:'市场位置',align:'center'},
							{name:'CABINETSLIBRARY',label:'区',align:'center'},
							{name:'CABINETSCODE',label:'柜',align:'center'},
							{name:'CABINETSLAYER',label:'排',align:'center'},
							{name:'CABINETSLATTICE',label:'列',align:'center'},
							{name:'ARCHIVESOURCE',label:'档案来源',align:'center'},
							{name:'EXPENTRUSTCOMPANY',label:'委托单位名称',align:'center'},
							{name:'RECEIVEDESC',label:'档案存放备注',align:'center'},
							{name:'ARCHIVERECEIVENAME',label:'档案接收经办人',align:'center'},
							{name:'ARCHIVERECEIVEDATE',label:'档案接收经办日期',align:'center'},
							{name:'ARCHIVERECEIVEORGNAME',label:'档案接收经办机构',align:'center'},
							{name:'ARCHIVESTORAGENAME',label:'入库经办人',align:'center'},
							{name:'ARCHIVESTORAGEDATE',label:'入库经办日期',align:'center'},
							{name:'ARCHIVESTORAGEORGNAME',label:'入库经办机构',align:'center'},
							{name:'ID',label:'',hidden:true,key:true},
							{name:'PERSONID',label:'',hidden:true},
	      	        	];
		
		$("#storageArchivesList").jqGrid({
			   url:'${ctx}/business/personagency/storage/storage/listJson.xf?personId=${personId}',
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
	           multiselect:true,
	           autowidth: true,
	           height:'100%',
	           beforeSelectRow :function(row,e){
	   		   		var rowData = $("#storageArchivesList").jqGrid('getRowData',row);	
	   		   		$("#normalArchiveDiv").load("${ctx}/business/personagency/storage/storage/normalArchiveDiv.xf?personId="+rowData.PERSONID);
	   		   },
		   	   loadComplete : function(){
		   			jQuery('#storageArchivesList').jqGrid('setSelection', 1, true);
		   	   }
		 
	       });
		$("#storageArchivesList").jqGrid('setFrozenColumns');
	})
	//导出
	function initDataExp(){
		var personId = ${personId};
		$('#exp').dataexp({
			gridId:"storageArchivesList",
			serviceId:'archivesExpServiceImpl',
			fileName:'档案入库',
			sheetName:'档案入库',
			menuItem:[{title:"导出全部数据",paramCallBack:function(){
							var ids=$("#storageArchivesList").jqGrid("getDataIDs");
							if(ids&&ids.length>0){
								return {menuNumber:'e',ids:ids,personId:personId};
							}else{
								bootbox.alert('无可导出的数据！');
								return false;
							}
			           }},
				        {title:"导出当前页数据",paramCallBack:function(){
				        		var ids=$("#storageArchivesList").jqGrid("getDataIDs");
				      		    if(ids&&ids.length>0){
						      		return {menuNumber:'e',ids:ids,personId:personId};
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
	    <div class="moduleWrapNobg" id="normalArchiveDiv">
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
						<label class="col-xs-3 col-sm-2" for="inputError" title="档案姓名">档案姓名:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="archiveName" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError" title="档案编号">档案编号:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="archiveCode" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="genderName" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">民族:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="nationName" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">出生日期:</label>
						<div class="col-xs-9 input-group col-sm-2">
                          	<form:input  class="form-control" type="text"  path="aac006" readonly="true"></form:input>
                          	<span class="input-group-addon">
                              	<i class="icon-calendar bigger-110"></i>
                          	</span>
                        </div>
                        <label class="col-xs-3 col-sm-2" for="inputError">档案出生日期:</label>
						<div class="col-xs-9 input-group col-sm-2">
                          	<form:input  class="form-control" type="text"  path="archiveBirthDate" readonly="true"></form:input>
                          	<span class="input-group-addon">
                              	<i class="icon-calendar bigger-110"></i>
                          	</span>
                        </div>
                        <label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">档案状态:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="archiveStatusName" readonly="true"></form:input>
						</div>
                        <label class="col-xs-3 col-sm-2" for="inputError" title="联系电话">联系电话:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="expPersonPhone" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError" title="手机号">手机号:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="aae005" readonly="true"></form:input>
						</div>
                        <label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">存档类型:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="archiveTypeName" readonly="true"></form:input>
						</div>
                        <label class="col-xs-3 col-sm-2" for="inputError">档案转入日期:</label>
						<div class="col-xs-9 input-group col-sm-2">
                          	<form:input  class="form-control" type="text"  path="receiveDate" readonly="true"></form:input>
                          	<span class="input-group-addon">
                              	<i class="icon-calendar bigger-110"></i>
                          	</span>
                        </div>
                        <label class="col-xs-3 col-sm-2" for="inputError">退休参考日期:</label>
						<div class="col-xs-9 input-group col-sm-2">
                          	<form:input  class="form-control" type="text"  path="planRetiredDate" readonly="true"></form:input>
                          	<span class="input-group-addon">
                              	<i class="icon-calendar bigger-110"></i>
                          	</span>
                        </div>
                        <label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">委托单位名称:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="expEntrustCompany" readonly="true"></form:input>
						</div>
                        <div class="col-xs-12 col-sm-8 mgb0">
							<div class="row mgb0">
								<label class="col-xs-3 col-sm-3" for="inputError" title="现居住地址">现居住地址:</label>
								<div class="col-xs-12 col-sm-9">
									<form:input  class="form-control" type="text"  path="aab301" readonly="true"></form:input>
								</div>
							</div>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">市场位置:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="marketPositionName" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">区:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text" path="cabinetsLibrary" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">柜:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text" path="cabinetsCode" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">排:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text" path="cabinetsLayer" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">列:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text" path="cabinetsLattice" readonly="true"></form:input>
						</div>
                        <label class="col-xs-3 col-sm-2" for="inputError" title="档案来源">档案来源:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="archiveSource" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError" title="接收状态">接收状态:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input  class="form-control" type="text"  path="archiveReceiveStatusName" readonly="true"></form:input>
						</div>
						<div class="col-xs-12 col-sm-12">
							<div class="row">
								<label class="col-xs-3 col-sm-2" for="inputError" title="档案存放位置备注">档案存放位置备注:</label>
								<div class="col-xs-9 col-sm-10">
									<form:textarea  type="text"  path="archiveReceiveDesc" row="1" col="5" readonly="true"></form:textarea>
								</div>
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>	
		<div class="moduleWrapNob">
			<div class="moduleTit">档案入库信息</div>
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
						<table id="storageArchivesList" class="datagridClass"></table>
						<div id="jqGridPager"></div>
					</div>
				</div>
			</div>
		</div>	
		<div class="col-xs-12 col-sm-12">
			<div class="row">
				<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
				<div class="col-xs-9 col-sm-2">
                       <input class="form-control" type="text" value="${archiveStorageDate }" readonly="true">
                   </div>
				<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
				<div class="col-xs-9 col-sm-2">
					  <input class="form-control" type="text" value="${archiveStorageOrgName }" readonly="true">
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
				<div class="col-xs-9 col-sm-2">
					  <input class="form-control" type="text" value="${archiveStorageName }" readonly="true">
				</div>
			</div>
		</div>
		<div class="bottomBtn">
	   		<div class="h50">&nbsp;</div>
	   		<div class="floatBtn">
		   		<a role="button" class="btn btn-info" href="javascript:storeConfirm()"><i class="icon-ok"></i>入库确认</a>
				<a role="button" class="btn btn-yellow"  href="javascript:refresh()"><i class="icon-refresh"></i>刷新列表</a>
	   		</div>
	   	</div>
</html>