<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp"%>
<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />
<link href="${ctx}/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="${ctx}/assets/css/daterangepicker.css" />
<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/ui/xf.treeorg.js?version=201609231008"></script>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/daterangepicker.css" />
<script src="${ctx}/js/lib/bootstrap-select/bootstrap-select.js"></script>
<link href="${ctx}/assets/css/bootstrap.min.css" rel="stylesheet" />
<link type="text/css" href="${ctx}/js/lib/bootstrap-select/bootstrap-select.css" rel="stylesheet" />
<link href="${ctx}/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css" type="text/css" />
<title>招聘信息查询</title>
<script>
	$(function() {
		$("#aae017n").treeorg({callBack:function(data){
			$("#aae017n").val(data.orgName);
			$("#aae017").val(data.orgId);
			}
		});
		/**
		 初始化表格显示
		 */
		var columns = [ {
			field : 'status',
			title : '选择',
			checkbox : 'true',
			width : '5%',
			align : 'center'
		},{
			field : 'ACB200',
			title : '操作',
			width : '10%',
			align : 'center',
			formatter : function(value, row, index) {
				return "<a class=\"mhyNoA\"  href=\"javascript:void(0)\" onclick=\"edit('"
						+ value + "')\" ><i class=\"icon-pencil\" title='编辑'></i></a>";
			}} ]
		var isEdit = '${isEdit}';
		if (!isEdit) {
			columns = [];
		}
		columns = columns.concat([ {
			field : 'ACB200',
			title : '招聘编号',
			width : '4%',
			align : 'center'
		}, {
			field : 'AAB004',
			title : '单位名称',
			width : '13%',
			align : 'center'
		}, {
			field : 'ACB208',
			title : '冻结标记',
			width : '4%',
			align : 'center'
		}, {
			field : 'BCB201',
			title : '招聘方式',
			width : '5%',
			align : 'center'
		}, {
			field : 'AAE030',
			title : '招聘开始时间',
			width : '5%',
			align : 'center'
		}, {
			field : 'AAE031',
			title : '招聘终止时间',
			width : '5%',
			align : 'center'
		}, {
			field : 'AAE004',
			title : '招聘联系人',
			width : '5%',
			align : 'center'
		}, {
			field : 'AAE005',
			title : '联系人电话',
			width : '6%',
			align : 'center'
		},
		//AAE139,ACB204,ACB20D,AAE019,AAE020,BAE036
		{
			field : 'AAE139',
			title : '联系人手机',
			width : '6%',
			align : 'center'
		}, {
			field : 'AAE006',
			title : '联系地址',
			width : '18%',
			align : 'center'
		}, {
			field : 'ACB20D',
			title : '冻结人',
			width : '5%',
			align : 'center'
		}, {
			field : 'AAE019',
			title : '招聘经办人',
			width : '5%',
			align : 'center'
		}, {
			field : 'AAE020',
			title : '招聘经办机构',
			width : '8%',
			align : 'center'
		}, {
			field : 'AAE036',
			title : '招聘经办日期',
			width : '5%',
			align : 'center'
		}, {
			field : 'ECB209',
			title : '数据来源',
			width : '5%',
			align : 'center'
		} ]);
		var col = {
			field : 'ACB200',
			title : '操作',
			width : '10%',
			align : 'center',
			formatter : function(value, row, index) {
				return "<a href=\"javascript:void(0)\" onclick=\"edit('"
						+ value + "')\" >编辑</a>";
			}
		}
/* 		if (isEdit) {
			columns.push(col);
		} */
		$('#jobFairInfoList')
				.bootstrapTable(
						{
							url : '${ctx}/business/dissupport/statistics/statistics/jobListJson.xf',
							columns : columns,
							method : "post",
							contentType : "application/x-www-form-urlencoded",
							pagination : true,
							pageSize : 10,
							pageList : [ 10, 15, 20 ],
							clickToSelect : true,
							singleSelect : false,
							sidePagination : "server",
							striped : true,
							queryParams : getSeachJson,
							onLoadSuccess:function(data){
								 if(data.result=='0'&&data.message=='登录超时，请重新登录！'){
									 window.location = '${ctx}';
								 }
							},
							onLoadError :function (status){
								$("#search_button").removeAttr("disabled",true);
								bootbox.alert("加载数据超时");
							}
						});
	})
	function getParentSelectValues() {
		var row = $('#jobFairInfoList').bootstrapTable('getAllSelections');
		var obj = '';
		$.each(row, function(i, e) {
			if (i == 0) {
				obj += e.ACB200;
			} else {
				obj += "," + e.ACB200;
			}

		});
		return obj;
	}
	function edit(obj) {
		xfui.open_tabs("单位招聘信息维护",
				"${ctx}/business/jobfair/corpPosition/editrecruitment.xf?acb200="
						+ obj, "单位招聘信息维护");
	}
	function refresh() {
		$('#jobFairInfoList').bootstrapTable('refresh');
	}
	function getSeachJson(params) {
		return {
			'limit' : params.limit,
			'offset' : clearNumber?0:params.offset,
			'order' : params.order,
			'startdate' : $("#startdate").val(),
			'enddate' : $("#enddate").val(),
			'aae017' : $("#aae017").val(),
			'cczy06' : $("#select_read").val(),
			'groupvalue' : $("#groupvalue").val(),
			'aab004' : $("#aab004_id").val(),
			'acb201': $("#acb201_select").val(),
			'acb208n':$("#acb208n_select").val(),
			'aab019n':$("#aab019n_select").val()
		};
	}
	function getSelectValues(objId) {
		var selectValueStr = '';
		$("#" + objId + " option:selected")
				.each(
						function() {
							selectValueStr = selectValueStr ? (selectValueStr
									+ "," + $(this).val()) : $(this).val();
						});
		return selectValueStr;
	}
	var clearNumber = false;
	function doSearch() {
		clearNumber = true;
		$("#jobFairInfoList").bootstrapTable('refresh', {
			url : '${ctx}/business/dissupport/statistics/statistics/jobListJson.xf',
			query : getSeachJson
		})
	}
	function doClear() {
		$('.selectpicker').selectpicker('val', '');
		$("#startdate").val('')
		$("#enddate").val('');
		$("#select_read").val('');
		$("#groupvalue").val('');
		$("#aab004_id").val('');
		 $("#acb201_select").val('');
		 $("#acb208n_select").val('');
		 $("#aab019n_select").val('');
		 resetForm("searchForm");
	}
	function delfreezeCorpPosition() {
		var row = $('#jobFairInfoList').bootstrapTable('getAllSelections');
		if (row && row.length > 0) {
			var obj = '';
			$.each(row, function(i, e) {
				if (i == 0) {
					obj += e.AAB001;
				} else {
					obj += "," + e.AAB001;
				}

			});
			
			if(!hasEditPermi(obj,2)){
				bootbox.alert('您选取的数据有无权操作的记录，请重新选择');
				return;
			 }
		} else {
			bootbox.alert('请选择招聘信息');
			return;
		}
		$
				.post(
						'${ctx}/business/jobfair/corpPosition/unfreezeCorpPublicPosition.xf',
						{
							'acb200' : getParentSelectValues()
						}, function(data) {
							$(".btn-submit").removeAttr("disabled");
							bootbox.alert({
								size : 'small',
								width : "100px",
								message : data.message,
								callback : function() {
									doSearch();
								}
							})

						}, 'json');
	}
	function tofreezeCorpPosition() {
		
		var row = $('#jobFairInfoList').bootstrapTable('getAllSelections');
		if (row && row.length > 0) {
			var obj = '';
			$.each(row, function(i, e) {
				if (i == 0) {
					obj += e.AAB001;
				} else {
					obj += "," + e.AAB001;
				}

			});
			
			if(!hasEditPermi(obj,2)){
				bootbox.alert('您选取的数据有无权操作的记录，请重新选择');
				return;
			 }
		} else {
			bootbox.alert('请选择招聘信息');
			return;
		}
		
		xfui.open_dialog({
					title : '冻结招聘岗位',
					width : 500,
					height : 200,
					closed : false,
					cache : false,
					url : "${ctx}/business/jobfair/corpPosition/tofreezeCorpPublicPosition.xf",
					modal : true
				})
	}
</script>
</head>
<body>
	<div class="main-container">
		<div class="container-fluid">
			<div class="mhyBody">
				<div class="mhySearch">
					<div class="mhyTitle">查询条件</div>
					<form id="searchForm" class="mhySearchInput">
						<div class="row">
							<div class="col-xs-12 col-sm-4" style="height: 32px;">
								<label class="col-xs-2 col-sm-4" for="inputError">开始日期:</label>
								<div class="col-xs-10 input-group col-sm-8"
									style="padding-left: 15px">
									<input id="startdate"
										 class="form-control date-picker dp mhydatepicker" type="text"
										placeholder="请选择日期" name="beginaac006"> <span
										class="input-group-addon"> <i
										class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4" style="height: 32px;">
								<label class="col-xs-2 col-sm-4" for="inputError">结束日期:</label>
								<div class="col-xs-10 input-group col-sm-8"
									style="padding-left: 15px">
									<input id="enddate"
										class="form-control date-picker dp mhydatepicker" type="text"
										placeholder="请选择日期" name="beginaac006"> <span
										class="input-group-addon"> <i
										class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
								<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">单位名称:</label>
								<div class="col-xs-10 col-sm-8">
									<input class="form-control" type="text" id="aab004_id"
										data-placement="bottom">
								</div>
							</div>
							
						</div>

						<div class="row">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">数据来源:</label>
								<div class="col-xs-10 col-sm-8">
									<xf:select id="select_read" name="funplat" selectClass="form-control" textField="name"
										tableName="TAB_DATASOURCES" valueField="code" isNoStyle="true"
										hasDefault="0" hasDefaultName="全部"></xf:select>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">招聘方式:</label>
								<div class="col-xs-10 col-sm-8">
									<xf:select id="acb201_select" selectClass="form-control" name="acb201" textField="name"
										tableName="TAB_JFFORM" valueField="code" isNoStyle="true"
										hasDefault="0" hasDefaultName="全部"></xf:select>

								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">机构信息:</label>
								<%-- <div class="col-xs-10 col-sm-8 mhyOrgId " id="selectDxdiv">
									<select id="org_select" class="selectpicker form-control"
										data-live-search="true" data-live-search-placeholder="Search"
										data-actions-box="true">
										<optgroup>
											<option value="">全部</option>
											<c:forEach items="${orgs}" begin="0" var="objOrg">
												<option value="${objOrg.acd200}">${objOrg.acd202}</option>
											</c:forEach>
										</optgroup>
									</select>
								</div> --%>
								<div class="col-xs-9 col-sm-8 ">
									<input id="aae017" name="aae017" type="hidden"></input>  
									<input class="form-control" id="aae017n" name="aae017n" type="text" readonly="true"></input>  
								</div>
							</div>
									
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">冻结标记:</label>
								<div class="col-xs-10 col-sm-8">
								<select class="form-control" name="acb208n" id="acb208n_select">
								<option value="">全部</option>
								<option value="0">未冻结</option>
								<option value="1">已冻结</option>
								</select>
								</div></div>
							<div class="col-xs-12 col-sm-4">
									<label class="col-xs-2 col-sm-4" for="inputError">单位性质:</label>
									<div class="col-xs-10 col-sm-8" >
											<xf:select name="aab019n" id="aab019n_select" textField="name"
												tableName="TAB_UNITNATURE" valueField="code"
												 selectClass="form-control" isNoStyle="true" hasDefault="0" hasDefaultName="全部"></xf:select>
									</div>
								</div>
						
						 		<div class="col-xs-12 col-sm-4 marginbottom20">
				
								<div class="col-xs-12 col-sm-12 mhyBtn">
									<a href="#modal-form" role="button" id="search_button" onclick="doSearch()"
										class="btn btn-primary btn-border1 mhyBtnLeft">
										<i class="icon-search"></i>
										查询
										</a> 
										<a
										href="#modal-form" role="button" onclick="doClear()"
										class="btn btn-info">
										<i class="icon-repeat"></i>
										重置
										</a>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="mhyMain">
				<div class="mhyTitle">查询结果</div>
				<div class="mhyInfo" >
				<div class="mgy10">
					<c:if test="${isEdit}">
						<a href="javascript:void(0)" onclick="tofreezeCorpPosition()"
							role="button" class="btn btn-inverse mhyBtnLeft" data-toggle="modal">
							<i class="icon-asterisk"></i>
							冻结
							</a>
						<a href="javascript:void(0)" onclick="delfreezeCorpPosition()"
							role="button" class="btn btn-grey" data-toggle="modal">
							<i class="icon-move"></i>
							解冻
							</a>
					</c:if></div>
					<div class="mhyConter">
						<table id="jobFairInfoList" class="tableClassNoworks  table-striped"></table>
					</div>
				</div>
			</div> 
			</div>
		</div>
		<script type="text/javascript">
			jQuery(function($) {
				$('.selectpicker').selectpicker({
					selectAllText : '全选',//全选的checkbox名称  
					deselectAllText : '取消',
					selectAllNumber : true,
					actionsBox : false,
					noneResultsText : "没有相关信息",liveSearchPlaceholder:"请输入搜索.."
				});
				// 日期选择
				$(".mhydatepicker").datetimepicker({
					todayBtn : true,
					format : "yyyy-mm-dd",
					startView : 2,
					minView : 2,
					language : 'cn',
					maxView : "decade",
					viewSelect : 2,
					autocomplete : true,
					autoclose : true
				});

			});
		</script>
	</div>
</body>
</html>