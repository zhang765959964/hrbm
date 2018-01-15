<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>单位人员档案接收操作界面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<script type="text/javascript" src='${ctx}/js/util/commonUtil.js?version=20170117001'></script>
	<script type="text/javascript" src="${ctx}/js/business/personagency/receive/resultCorpReceiveArchives.js?verson=2017011755"></script>
</head>
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
					<label class="col-xs-3 col-sm-2" for="inputError" title="办理人身份证号">办理人身份证号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="uaCard" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="单位性质">单位性质:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="aab019Name" readonly="true"></form:input>
					</div>
					<%-- <div class="col-xs-12 col-sm-12 threeCol">
						<div class="row rowTextarea">
							<label class="col-xs-3 col-sm-2" for="inputError" title="协议主要内容">协议主要内容:</label>
							<div class="col-xs-9 col-sm-10">
								<form:textarea  type="text"  path="uaContent" row="2" col="5" readonly="true"></form:textarea>
							</div>
						</div>
					</div> --%>
					<div id="serArchive">
						<div class="col-xs-12 col-sm-12 threeCol">
							<div class="row rowTextarea">
								<label class="col-xs-3 col-sm-2" for="inputError" title="当前单位下存档人数">当前单位下存档人数:</label>
								<div class="col-xs-9 col-sm-10">
									<span style="color:red;">${archiveCount } </span> (人)
								</div>
							</div>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<div class="moduleWrapNob">
		<div class="moduleTit"><span class="fl">查询结果带检索按钮</span>
			<span class="fr mgr15">
				<input class="w235" type="text" placeholder="请输入身份证号、姓名、档案编号查询" id="jxResultRecive">
				<a role="button" class="btn btn-danger " href="javascript:searchChildReceive()"><i class="icon-search"></i>查询</a>
			</span>
		</div>
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
	<hr/>
	<div class="col-xs-12 col-sm-12">
		<div class="row">
			<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
			<div class="col-xs-9 col-sm-2">
                <input  class="form-control" type="text" value="${archiveReceiveDate }" readonly="true">
            </div>
			<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
			<div class="col-xs-9 col-sm-2">
				 <input  class="form-control" type="text" value="${archiveReceiveOrgName }" readonly="true">
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
			<div class="col-xs-9 col-sm-2">
				 <input  class="form-control" type="text" value="${archiveReceiveName }" readonly="true">
			</div>
		</div>
	</div>
	<div class="floatBtn">
   		<a href="javascript:addCorpArchives('${aab001}','${uaStatus}')" role="button" class="btn btn-primary" ><i class="icon-plus align-top"></i>添加</a>
		<a href="javascript:editCorpArchives()" role="button" class="btn btn-info" ><i class="icon-pencil align-top"></i>修改</a>
		<a role="button" class="btn btn-success" href="javascript:printCodeLabel()"><i class="icon-barcode"></i>打印条码标签</a>
		<a role="button" class="btn btn-danger" href="javascript:printCorpPerson()"><i class="icon-barcode"></i>打印人员名单</a>
   	</div>
<script>
$(function(){
	initDataExp();
})
$(function(){
	var columns= [
                   	{name:'archiveCode',label:'档案编号',align:'center',frozen : true},
                    {name:'aac003',label:'姓名',align:'center',frozen : true},
                    {name:'aac002',label:'身份证号',align:'center',frozen : true},
                    {name:'genderName',label:'性别',align:'center'},
                    {name:'aac006',label:'出生日期',align:'center'},
                    {name:'ExpSoctalNumber',label:'社会保障号',align:'center'},
                    {name:'ContractCode',label:'合同编号',align:'center'},
                    {name:'archiveTypeName',label:'存档类型',align:'center'},
                    {name:'archiveName',label:'档案姓名',align:'center'},
                    {name:'archiveBirthDate',label:'档案出生日期',align:'center'},
                    {name:'aab301',label:'现居住地址',align:'center'},
                    {name:'FAName',label:'配偶姓名',align:'center'},
                    {name:'planRetiredDate',label:'退休参考日期',align:'center'},
                    {name:'receiveDate',label:'档案转入日期',align:'center'},
                    {name:'archiveStatusName',label:'档案状态',align:'center'},
                    {name:'archiveReceiveDesc',label:'档案存放位置备注',align:'center'},
                    {name:'ArchiveReceiveName',label:'接收人',align:'center'},
                    {name:'ID',label:'',align:'center',hidden:true,key:true},
                    {name:'aac001',label:'',align:'center',hidden:true}
                    
	                
      	        ];
	$("#corpArchiveResultList").jqGrid({
		   url:'${ctx}/business/personagency/corp/receive/listJson.xf?aab001=${aab001}',
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
           shrinkToFit: false,
           multiselect:false,
           autowidth: true,
           height : '100%'
       });
	$("#corpArchiveResultList").jqGrid('setFrozenColumns');
})

//企业下新增档案接收
function addCorpArchives(aab001,uaStatus){
	if(aab001>0){
		if(uaStatus==0){
 		/* 	xfui.open_dialog({    
 			    title: '单位下个人档案接收',    
 			    width: 1300,    
 			    height: 650,    
 			    closed: false,    
 			    cache: false,    
 			    url: "${ctx}/business/personagency/corp/receive/add.xf?aab001=${aab001}",
 			    modal: true   
 			})  */
			 xfui.open_tabs( '单位下个人档案接收', "${ctx}/business/personagency/corp/receive/add.xf?aab001=${aab001}",'单位人员档案接收'); 
			
		}else{
			if(uaStatus==1){
				bootbox.alert('该单位已经终止协议，不能办理个人档案接收！');
			}else{
				bootbox.alert('该单位还没有签订单位协议，不能办理个人档案接收！');
			}
		}
	}else{
		 bootbox.alert('请先选择单位信息！');
	}
}

function refreshArchiveCount(){
	$("#serArchive").load("${ctx}/business/personagency/corp/receive/refreshArchiveCount.xf?aab001=${aab001}");
}
//打印人员名单
function printCorpPerson(){
	var ids=$("#corpArchiveResultList").jqGrid("getDataIDs");
	var aab001 = ${aab001};
	if(ids&&ids.length>0){
		var param = {"id":aab001,"type":"corpPerson"};
		templatePrint("corpPerson",param);
	}else{
		 bootbox.alert('没有可以打印的人员名单');
	}	
}

//导出
function initDataExp(){
	$('#exp').dataexp({
		gridId:"corpArchiveResultList",
		serviceId:'archivesExpServiceImpl',
		fileName:'单位下人员档案信息',
		sheetName:'单位下人员档案信息',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
						var ids=$("#corpArchiveResultList").jqGrid("getDataIDs");
						var aab001 = ${aab001};
						if(ids&&ids.length>0){
							return {menuNumber:'c',aab001:aab001};
						}else{
							bootbox.alert('无可导出的数据！');
							return false;
						}
		           }},
			        {title:"导出当前页数据",paramCallBack:function(){
			        		var ids=$("#corpArchiveResultList").jqGrid("getDataIDs");
			      		    if(ids&&ids.length>0){
					      		return {menuNumber:'c',ids:ids};
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
</html>