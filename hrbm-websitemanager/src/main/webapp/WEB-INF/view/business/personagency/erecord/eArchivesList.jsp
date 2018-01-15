<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>借阅登记</title>
	<%@include file="/commons/include/commonInc.jsp" %>
	<script>
	$(function(){
		xfui.initUi();
		/**
		 初始化表格显示
		*/
		var columns= [	   
		                   {name:'ARCHIVECODE',label:'档案编号',align:'center',frozen : true},
		                   {name:'AAC003',label:'姓名',align:'center',frozen : true},
		                   {name:'AAC002',label:'身份证号',align:'center',frozen : true},
		                   {name:'ARCHIVEFLOWSTATUSNAME',label:'借阅状态',align:'center',frozen : true},
		                   {name:'CHECKOUTDATE',label:'借阅日期',align:'center'},
		                   {name:'CHECKOUTPERIODDATE',label:'到期时间',align:'center'},
		                   {name:'AAE005',label:'手机号',align:'center'},
		                   {name:'EXPPERSONPHONE',label:'联系电话',align:'center'},
		                   {name:'GENDERNAME',label:'性别',align:'center'},
		                   {name:'AAC006',label:'出生日期',align:'center'},
		                   {name:'EXPSOCTALNUMBER',label:'社会保障号',align:'center'},
		                   {name:'CONTRACTCODE',label:'合同编号',align:'center'},
		                   {name:'ARCHIVETYPENAME',label:'存档类型',align:'center'},
		                   {name:'NATIONNAME',label:'民族',align:'center'},
		                   {name:'EXPPERSONNUMBER',label:'个人编号',align:'center'},
		                   {name:'EXPOLDCOMPANY',label:'原单位名称',align:'center'},
		                   {name:'EXPENTRUSTCOMPANY',label:'委托单位名称',align:'center'},
		                   {name:'EXPPOST',label:'职务',align:'center'},
		                   {name:'EXPSTARTJOBDATE',label:'参加工作时间',align:'center'},
		                   {name:'EDUCATIONNAME',label:'文化程度',align:'center'},
		                   {name:'MARITALSTATUSNAME',label:'婚姻状况',align:'center'},
		                   {name:'POLITICALLANDSCAPE',label:'政治面貌',align:'center'},
		                   {name:'EXPISDISCOUNT',label:'是否享有再就业优惠证标准',align:'center'},
		                   {name:'AAB301',label:'现居住地址',align:'center'},
		                   {name:'FANAME',label:'配偶姓名',align:'center'},
		                   {name:'ARCHIVEBIRTHDATE',label:'档案出生日期',align:'center'},
		                   {name:'PLANRETIREDDATE',label:'退休参考日期',align:'center'},
		                   {name:'RECEIVEDATE',label:'档案接收日期',align:'center'},
		                   {name:'ARCHIVESTATUSNAME',label:'档案状态',align:'center'},
		                   {name:'ARCHIVEPRINTLABEL',label:'打印档案标签',align:'center'},
		                   {name:'ARCHIVERECEIVEDESC',label:'备注',align:'center'},
		                   {name:'ARCHIVERECEIVENAME',label:'窗口经办人',align:'center'},
		                   {name:'ARCHIVERECEIVEORGNAME',label:'窗口经办机构',align:'center'},
		                   {name:'ARCHIVERECEIVEDATE',label:'窗口经办日期',align:'center'},
		                   {name:'RECEIVEDESC',label:'档案存放备注',align:'center'},
		                   {name:'ARCHIVERECEIVESTATUSNAME',label:'接收状态',align:'center'},
		                   {name:'MARKETPOSITION',label:'市场位置',align:'center'},
		                   {name:'CABINETSLIBRARY',label:'库',align:'center'},
		                   {name:'CABINETSCODE',label:'排',align:'center'},
		                   {name:'CABINETSLAYER',label:'层',align:'center'},
		                   {name:'CABINETSLATTICE',label:'号',align:'center'},
		                   {name:'ARCHIVESTORAGENAME',label:'入库经办人',align:'center'},
		                   {name:'ARCHIVESTORAGEORGNAME',label:'入库经办机构',align:'center'},
		                   {name:'ARCHIVESTORAGEDATE',label:'入库经办日期',align:'center'},
		                   {name:'LENDDATE',label:'调出时间',align:'center'},
		                   {name:'ARCHIVESLENDWHERE',label:'档案去向',align:'center'},
		                   {name:'LENDPEOPLEMENTION',label:'提档人',align:'center'},
		                   {name:'LENDIDNUMBER',label:'调出人身份证号',align:'center'},
		                   {name:'LENDSTRINGREASON',label:'调出原因',align:'center'},
		                   {name:'LENDPHONE',label:'调出人联系方式',align:'center'},
		                   {name:'LENDREMARKS',label:'调出备注',align:'center'},
		                   {name:'LENDCREATERNAME',label:'调出经办人',align:'center'},
		                   {name:'LENDCREATERORGNAME',label:'调出经办机构',align:'center'},
		                   {name:'LENDCREATERDATE',label:'调出时间',align:'center'},
		                   {name:'PERSONID',label:'',hidden:true,key:true}
		                   
	      	        	];
		
		$("#archivesList").jqGrid({
// 			url:'${ctx}/business/personagency/archive/archives/listJson.xf',
	        mtype: "GET",
			styleUI : 'Bootstrap',
	        datatype: "local",
	        colModel: columns,
			viewrecords: true,
	        rowNum: 10,
	        rowList:[10,20,30],
	        pager: "#jqGridPager",
	        pagerpos:'left',
	        regional : 'cn',
	        recordpos:'right',
	        shrinkToFit: false,
// 	        multiselect:true,
	        autowidth: true,
	        altRow:true,
	        height : "100%"
	    });
		$("#archivesList").jqGrid('setFrozenColumns');
		
		// $(".highSearch").click(function(){
		// 	$(".highCondition").toggle();
		// });
		
	})


	function refresh(){
		$("#archivesList").trigger("reloadGrid");
	}
	function doSearch(){
		var json=$("#searchForm").serializeJson();
		
		$("#archivesList").jqGrid("setGridParam",{url:'${ctx}/business/personagency/archive/archives/listJson.xf',datatype:'json',postData:json}).trigger("reloadGrid");
	}



		function ecollection(){
			var rowid=$("#archivesList").jqGrid("getGridParam","selrow");
			if(rowid){
				xfui.open_tabs("电子档案采集","${ctx}/business/erecord/eArchives/add.xf?personId="+rowid,"电子档案办理");
			}else{
				bootbox.alert('请选择记录');
			}
		}
		function view(){
			var rowid=$("#archivesList").jqGrid("getGridParam","selrow");
			if(rowid){
				xfui.open_tabs("查看","${ctx}/business/erecord/eArchives/search.xf?personId="+rowid,"电子档案查询");
			}else{
				bootbox.alert('请选择记录');
			}
		}
	</script>
</head>
<body>

<div class="container-fluid">
				<div class="row">
					<div class="moduleWrapNobg">
						<div class="moduleTit">查询条件</div>
						<div class="moduleCont">
							<form id="searchForm">
								<div class="row">
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">档案编号:</label>
										<div class="col-xs-12 col-sm-7">
											<input class="form-control" type="text" name="Q_archiveCode_SL" placeholder="" title="档案编号" data-placement="bottom" />
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">身份证号:</label>
										<div class="col-xs-12 col-sm-7">
											<input class="form-control" type="text" name="Q_aac002_SUPL" placeholder="" title="身份证号" data-placement="bottom" />
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">存档类型:</label>
										<div class="col-xs-12 col-sm-7">
											<xf:select  tableName="RSDA_TAB_ARCHIVETYPE" valueField="code" hasDefault="0" textField="name" name="Q_archiveType_S" ></xf:select>
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">姓名:</label>
										<div class="col-xs-12 col-sm-7">
											<input class="form-control" type="text" name="Q_aac003_SL" placeholder="" title="" data-placement="bottom" />
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError" title="姓名拼音码">姓名拼音码:</label>
										<div class="col-xs-12 col-sm-7">
											<input class="form-control" type="text" name="Q_aac022_SLOL" placeholder="" title="" data-placement="bottom" />
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError" title="档案状态">档案状态:</label>
										<div class="col-xs-12 col-sm-7">
											<xf:select  tableName="RSDA_TAB_ARCHIVESTATUS" valueField="code" textField="name" name="Q_archiveStatus_S"  hasDefault="0" ></xf:select>
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">出生日期起:</label>
										<div class="col-xs-12 input-group col-sm-7"  style="padding-left:15px">
			                              <input class="form-control date-picker dp date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginaac006" name="Q_beginaac006_DL" type="text" placeholder="请选择日期"/>
			                              <span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                              </span>
			                           </div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">出生日期止:</label>
										<div class="col-xs-12 input-group col-sm-7"  style="padding-left:15px">
			                              <input class="form-control date-picker dp date" format="YYYY-MM-DD" autoUpdateInput="false" id="endaac006" name="Q_endaac006_DL" type="text" placeholder="请选择日期"/>
			                              <span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                              </span>
			                           </div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">接收状态:</label>
										<div class="col-xs-12 col-sm-7">
											<xf:select  tableName="RSDA_TAB_ARECEIVESTATUS" valueField="code" textField="name" name="Q_archiveReceiveStatus_S"  hasDefault="0" ></xf:select>
										</div>
									</div>
								</div>
								<div class="row highCondition dnn">
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">性别:</label>
										<div class="col-xs-12 col-sm-7">
											<xf:select  tableName="TAB_SEX" valueField="code" textField="name" name="Q_aac004_S"  hasDefault="0" valueCon="1,2"></xf:select>
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError" title="文化程度">文化程度:</label>
										<div class="col-xs-12 col-sm-7">
											<xf:select  tableName="TAB_EDUCATION" valueField="code" textField="name" name="Q_aac011_S"  hasDefault="0" ></xf:select>
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError" title="婚姻状况">婚姻状况:</label>
										<div class="col-xs-12 col-sm-7">
											<xf:select  tableName="TAB_MARRIAGE" valueField="code" textField="name" name="Q_faMarriage_S"  hasDefault="0" ></xf:select>
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError" title="档案姓名">档案姓名:</label>
										<div class="col-xs-12 col-sm-7">
											<input class="form-control" type="text" name="Q_archiveName_SL" placeholder="" title="" data-placement="bottom" />
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">档案转入日期起:</label>
										<div class="col-xs-12 input-group col-sm-7" >
			                              <input class="form-control date-picker dp date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginreceiveDate" name="Q_beginreceiveDate_DL" type="text" placeholder="请选择日期"/>
			                              <span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                              </span>
			                           </div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">档案转入日期止:</label>
										<div class="col-xs-12 input-group col-sm-7">
			                              <input class="form-control date-picker dp date" format="YYYY-MM-DD" autoUpdateInput="false" id="endreceiveDate" name="Q_endreceiveDate_DG" type="text" placeholder="请选择日期"/>
			                              <span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                              </span>
			                           </div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">社会保障号:</label>
										<div class="col-xs-12 col-sm-7">
											<input class="form-control" type="text" name="Q_expSoctalNumber_SL" placeholder="" title="" data-placement="bottom" />
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">退休参考日期起:</label>
										<div class="col-xs-12 input-group col-sm-7" >
			                              <input class="form-control date-picker dp date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginplanRetiredDate" name="Q_beginplanRetiredDate_DL" type="text" placeholder="请选择日期"/>
			                              <span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                              </span>
			                           </div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">退休参考日期止:</label>
										<div class="col-xs-12 input-group col-sm-7">
			                              <input class="form-control date-picker dp date" format="YYYY-MM-DD" autoUpdateInput="false" id="endplanRetiredDate" name="Q_endplanRetiredDate_DG" type="text" placeholder="请选择日期"/>
			                              <span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                              </span>
			                           </div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">市场位置:</label>
										<div class="col-xs-12 col-sm-7">
											<input class="form-control" type="text" name="Q_marketPosition_SL" placeholder="" title="" data-placement="bottom" />
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">库:</label>
										<div class="col-xs-12 col-sm-7">
											<input class="form-control" type="text" name="Q_cabinetsLibrary_SL" placeholder="" title="" data-placement="bottom" />
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">排:</label>
										<div class="col-xs-12 col-sm-7">
											<input class="form-control" type="text" name="Q_cabinetsCode_SL" placeholder="" title="" data-placement="bottom" />
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">层:</label>
										<div class="col-xs-12 col-sm-7">
											<input class="form-control" type="text" name="Q_cabinetsLayer_SL" placeholder="" title="" data-placement="bottom" />
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">号:</label>
										<div class="col-xs-12 col-sm-7">
											<input class="form-control" type="text" name="Q_cabinetsLattice_SL" placeholder="" title="" data-placement="bottom" />
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">委托单位名称:</label>
										<div class="col-xs-12 col-sm-7">
											<input class="form-control" type="text" name="Q_expEntrustCompany_SL" placeholder="" title="" data-placement="bottom" />
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">打印档案标签次数起:</label>
										<div class="col-xs-12 col-sm-7">
											<input class="form-control" type="text" name="Q_beginArchivePrintLabel_SL" placeholder="" title="" data-placement="bottom" />
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">打印档案标签次数止:</label>
										<div class="col-xs-12 col-sm-7">
											<input class="form-control" type="text" name="Q_endArchivePrintLabel_SL" placeholder="" title="" data-placement="bottom" />
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">窗口经办人:</label>
										<div class="col-xs-12 col-sm-7">
											<input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" type="text" name="Q_archiveReceiveName_SL" placeholder="" title="" data-placement="bottom" />
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">窗口经办机构:</label>
										<div class="col-xs-12 col-sm-7">
											<input class="form-control" type="text" name="Q_archiveReceiveOrgName_SL" placeholder="" title="" data-placement="bottom" />
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">窗口经办日期起:</label>
										<div class="col-xs-12 input-group col-sm-7" >
			                              <input class="form-control date-picker dp date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginarchiveReceiveDate" name="Q_beginarchiveReceiveDate_DL" type="text" placeholder="请选择日期"/>
			                              <span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                              </span>
			                           </div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">窗口经办日期止:</label>
										<div class="col-xs-12 input-group col-sm-7">
			                              <input class="form-control date-picker dp date" format="YYYY-MM-DD" autoUpdateInput="false" id="endarchiveReceiveDate" name="Q_endarchiveReceiveDate_DG" type="text" placeholder="请选择日期"/>
			                              <span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                              </span>
			                           </div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">入库经办机构:</label>
										<div class="col-xs-12 col-sm-7">
											<input class="form-control" type="text" name="Q_archiveStorageOrgName_SL" placeholder="" title="" data-placement="bottom" />
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">入库经办日期起:</label>
										<div class="col-xs-12 input-group col-sm-7" >
			                              <input class="form-control date-picker dp date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginarchiveStorageDate" name="Q_beginarchiveStorageDate_DL" type="text" placeholder="请选择日期"/>
			                              <span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                              </span>
			                           </div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">入库经办日期止:</label>
										<div class="col-xs-12 input-group col-sm-7">
			                              <input class="form-control date-picker dp date" format="YYYY-MM-DD" autoUpdateInput="false" id="endarchiveStorageDate" name="Q_endarchiveStorageDate_DG" type="text" placeholder="请选择日期"/>
			                              <span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                              </span>
			                           </div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">入库经办人:</label>
										<div class="col-xs-12 col-sm-7">
											<input class="form-control" type="text" name="Q_archiveStorageName_SL" placeholder="" title="" data-placement="bottom" />
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">调出经办人:</label>
										<div class="col-xs-12 col-sm-7">
											<input class="form-control" type="text" name="Q_lendCreaterName_SL" placeholder="" title="" data-placement="bottom" />
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">调出原因:</label>
										<div class="col-xs-12 col-sm-7">
											<input class="form-control" type="text" name="Q_lendStringReason_SL" placeholder="" title="" data-placement="bottom" />
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">调出经办机构:</label>
										<div class="col-xs-12 col-sm-7">
											<input class="form-control" type="text" name="Q_lendCreaterOrgName_SL" placeholder="" title="" data-placement="bottom" />
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">调出经办日期起:</label>
										<div class="col-xs-12 input-group col-sm-7" >
			                              <input class="form-control date-picker dp date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginlendCreaterDate" name="Q_beginlendCreaterDate_DL" type="text" placeholder="请选择日期"/>
			                              <span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                              </span>
			                           </div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">调出经办日期止:</label>
										<div class="col-xs-12 input-group col-sm-7">
			                              <input class="form-control date-picker dp date" format="YYYY-MM-DD" autoUpdateInput="false" id="endlendCreaterDate" name="Q_endlendCreaterDate_DG" type="text" placeholder="请选择日期"/>
			                              <span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                              </span>
			                           </div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">是否转干部:</label>
										<div class="col-xs-12 col-sm-7">
											<select style='width: 205px' class='easyui-combobox' editable='false' name='Q_expIsCadre_N'>
													<option value="" selected="selected">--请选择--</option>
													<option value="1">是</option>
													<option value="0">否</option>
											</select>
										</div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">档案出生日期起:</label>
										<div class="col-xs-12 input-group col-sm-7" >
			                              <input class="form-control date-picker dp date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginarchiveBirthDate" name="Q_beginarchiveBirthDate_DL" type="text" placeholder="请选择日期"/>
			                              <span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                              </span>
			                           </div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">档案出生日期止:</label>
										<div class="col-xs-12 input-group col-sm-7">
			                              <input class="form-control date-picker dp date" format="YYYY-MM-DD" autoUpdateInput="false" id="endarchiveBirthDate" name="Q_endarchiveBirthDate_DG" type="text" placeholder="请选择日期"/>
			                              <span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                              </span>
			                           </div>
									</div>
									<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-12 col-sm-5" for="inputError">是否享受在就业优惠证标准:</label>
										<div class="col-xs-12 col-sm-7">
											<select style='width: 205px' class='easyui-combobox' editable='false' name='Q_expIsDiscount_N'>
													<option value="" selected="selected">--请选择--</option>
													<option value="1">是</option>
													<option value="0">否</option>
											</select>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 mgb20 tar pdx20">
										<a href="#resultWrap" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
										<a href="javascript:void(0)" class="btn btn-success highSearch" onclick="toggleMore('highCondition',this)"><i class="icon-plus"></i>高级查询</a>
										<a href="#modal-form" onclick="resetForm('searchForm')" role="button" class="btn btn-info"><i class="icon-repeat"></i>重置</a>
									</div>
								</div>
							</form>
						</div>
					</div>
					<!-- 查询条件结束 -->
					<!-- 查询结果开始 -->
					<div class="col-xs-12 pd0">
						<div class="moduleWrapNob" id="resultWrap">
							<div class="moduleTit">结果列表</div>
							<div class="moduleCont">
								<div class="mgy10">
									<c:if test="${type==0}">
										<a href="javascript:void(0)" onclick="ecollection()"role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus"></i>电子采集</a>
									</c:if>
									<c:if test="${type==1}">
										<a href="javascript:void(0)" onclick="view()"  role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-zoom-in"></i>查看</a>
									</c:if>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<table id="archivesList" class="datagridClass"></table>
										<div id="jqGridPager"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- 查询结果结束-->
				</div>
			</div>
</body>
</html>