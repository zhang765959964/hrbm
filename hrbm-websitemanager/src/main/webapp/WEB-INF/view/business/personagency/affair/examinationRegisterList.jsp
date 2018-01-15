<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>考试报名登记表管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript" src="${ctx}/js/business/personagency/affair/examinationRegisterList.js"></script>
	<script>
		$(function(){
			var columns1= [
		                   {name:'ARCHIVECODE',label:'档案编号',align:'center',frozen : true},
		                   {name:'AAC002',label:'公民身份号码',align:'center',frozen : true},
		                   {name:'AAC003',label:'姓名',align:'center',frozen : true},
		                   {name:'AAC022',label:'姓名拼音码',align:'center'},
		                   {name:'MARITALSTATUSNAME',label:'婚姻状况',align:'center'},
		                   {name:'EXPSOCTALNUMBER',label:'社会保障号',align:'center'},
		                   {name:'POLITICALLANDSCAPE',label:'政治面貌',align:'center'},
		                   {name:'FANAME',label:'配偶姓名',align:'center'},
		                   {name:'EXPISCADRENAME',label:'是否转干部',align:'center'},
		                   {name:'EXPISDISCOUNTNAME',label:'是否持再就业优惠证',align:'center'},
		                   {name:'EDUCATIONNAME',label:'文化程度',align:'center'},
		                   {name:'AAE005',label:'联系电话',align:'center'}, 
		                   {name:'AAB301',label:'现居住地址',align:'center'},
		                   {name:'ARCHIVETYPENAME',label:'存档类型',align:'center'},
		                   {name:'EXPENTRUSTCOMPANY',label:'所属单位名称',align:'center'},
		                   {name:'ARCHIVENAME',label:'档案姓名',align:'center'},
		                   {name:'ARCHIVEBIRTHDATE',label:'档案出生日期',align:'center'},
		                   {name:'RETIREDAGE',label:'退休年数',align:'center'},
		                   {name:'RECEIVEDATE',label:'档案转入日期',align:'center'},
		                   {name:'ARCHIVESTATUSNAME',label:'档案状态',align:'center'},
		                   {name:'EXPOLDCOMPANY',label:'原单位名称',align:'center'},
		                   {name:'EXPPOST',label:'职务',align:'center'},
		                   {name:'ARCHIVERECEIVENAME',label:'接收人',align:'center'},
		                   {name:'RECEIVEDESC',label:'档案存放备注',align:'center'},
		                   {name:'LENDDATE',label:'调出时间',align:'center'},
		                   {name:'ARCHIVESLENDWHERE',label:'档案去向（单位）',align:'center'},
		                   {name:'LENDNAME',label:'调出经办人',align:'center'},
		                   {name:'LENDIDNUMBER',label:'调出经办人身份证号',align:'center'},
		                   {name:'ID',label:'档案id',align:'center',hidden:true}
	
	      	        	];
	
			$("#examinationArchivesList").jqGrid({
		        mtype: "GET",
				styleUI : 'Bootstrap',
		        datatype: "local",
		        colModel: columns1,
				viewrecords: true,
		        rowNum: 10,
		        rowList:[10,20,30],
		        pager: "#jqGridPager1",
		        pagerpos:'left',
		        regional : 'cn',
		        recordpos:'right',
		        shrinkToFit: false,
		        multiselect:false,
		        autowidth: true,
		        altRows:true,
		        height:'100%',
		        onSelectRow:function(rowId){
			    	  var rowData=$(this).jqGrid("getRowData",rowId);
			    	  $('#examinationRegisterList').jqGrid("setGridParam",{datatype: "json",url:'${ctx}/business/personagency/affair/examinationRegister/listJson.xf?archivesId='+rowData.ID}).trigger("reloadGrid");
			    	  dataJson.archivesId=rowData.ID;
			      }
		    });
			
			$("#examinationArchivesList").jqGrid('setFrozenColumns');
		})
		function doSearch(){
			var json=$("#searchForm").serializeJson();
			$("#examinationArchivesList").jqGrid("clearGridData");	
			$("#examinationArchivesList").jqGrid("setGridParam",{datatype: "json",url:'${ctx}/business/personagency/archive/archives/listJson.xf?dataSources=1&archiveStatus=1',postData:json}).trigger("reloadGrid");
		}
	</script>
</head>
<body>
	<div class="main-container">
		<div class="container-fluid">
			<div class="row">
				<div class="moduleWrapNobg">
					<div class="moduleTit">查询条件</div>
					<div class="moduleCont">
						<form id="searchForm">
							<div class="row">
								<label class="col-xs-3 col-sm-2" for="inputError">身份证号:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_aac002_SUPL" placeholder="" title="身份证号" data-placement="bottom"/>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_aac003_SL" placeholder="" title="" data-placement="bottom"/>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_archiveCode_SL" placeholder="" title="档案编号" data-placement="bottom"/>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError" title="档案姓名">档案姓名:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_archiveName_SL" placeholder="" title="" data-placement="bottom"/>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">档案状态:</label>
								<div class="col-xs-9 col-sm-2">
									<xf:select  tableName="RSDA_TAB_ARCHIVESTATUS" valueField="code" textField="name" name="Q_archiveStatus_S" valueCon="1" selectClass="form-control"></xf:select>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">存档类型:</label>
								<div class="col-xs-9 col-sm-2">
									<xf:select  tableName="RSDA_TAB_ARCHIVETYPE" valueField="code" hasDefault="0" textField="name" name="Q_archiveType_S" selectClass="form-control"></xf:select>
								</div>
							</div>
							<div class="row highCondition dnn">
								<label class="col-xs-3 col-sm-2" for="inputError" title="所属单位名称">所属单位名称:</label>
								<div class="col-xs-9 col-sm-6">
									<input class="form-control" type="text" name="Q_aab004_SL" data-placement="bottom"/>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError" title="姓名拼音码">姓名拼音码:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_aac022_SLOL" placeholder="" title="" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">是否转干部:</label>
								<div class="col-xs-9 col-sm-2">
									<select style='width: 205px' class='easyui-combobox' editable='false' name='Q_expIsCadre_N'>
										<option value="" selected="selected">--请选择--</option>
										<option value="1">是</option>
										<option value="0">否</option>
									</select>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">是否持再就业优惠证:</label>
								<div class="col-xs-9 col-sm-2">
									<select style='width: 205px' class='easyui-combobox' editable='false' name='Q_expIsDiscount_N'>
											<option value="" selected="selected">--请选择--</option>
											<option value="1">是</option>
											<option value="0">否</option>
									</select>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError" title="社会保障号">社会保障号:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_expSoctalNumber_SL" placeholder="" data-placement="bottom"/>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError" title="原单位名称">原单位名称:</label>
								<div class="col-xs-9 col-sm-6">
									<input class="form-control" type="text" name="Q_expOldCompany_SL" placeholder="" data-placement="bottom"/>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12 mgb20 tar pdx20">
									<a href="javascript:void(0)" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
									<a href="javascript:void(0)" class="btn btn-success highSearch"  onclick="toggleMore('highCondition',this)"><i class="icon-plus"></i>高级查询</a>
									<a href="javascript:void(0)" onclick="resetForm('searchForm')" role="button" class="btn btn-info"><i class="icon-repeat"></i>重置</a>
								</div>
							</div>
						</form>
					</div>
				</div>
				<!-- 存档列表数据 -->
				<div class="moduleWrapNob">
					<div class="moduleTit">存档信息列表</div>
					<div class="moduleCont">
						<div class="row">
							<div class="col-xs-12">
								<table id="examinationArchivesList" class="datagridClass"></table>
								<div id="jqGridPager1"></div>
							</div>
						</div>
					</div>
				</div>
				<!--  -->
				<div class="moduleWrapNob">
					<div class="moduleTit">考试报名及结果信息</div>
					<div class="moduleCont">
						<div class="mgy10">
							<a href="javascript:void(0)" onclick="addExaminationRegister()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus"></i>添加</a>
							<a href="javascript:void(0)" onclick="editExaminationRegister()" role="button" class="btn btn-info" data-toggle="modal"><i class="icon-pencil"></i>修改</a>
							<a href="javascript:void(0)" onclick="delExaminationRegister()" role="button" class="btn btn-danger" ><i class="icon-trash"></i>删除</a>
							<div class="keep-open  btn-group vat" title="">
								<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
									<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i>
								</a>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<table id="examinationRegisterList" class="datagridClass"></table>
								<div id="jqGridPager"></div>
							</div>
						</div>
					</div>
				</div>	
			</div>
		</div>
	</div>
</body>		
</html>