<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp"%>
<link rel="stylesheet" href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css" type="text/css">
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.excheck-3.5.js"></script>
		<script type="text/javascript" src="${ctx}/js/ui/xf.treeorg.js?version=201609231008"></script>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${ctx}/assets/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/daterangepicker.css" />


<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />

<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
<script
	src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script>
	<link href="${ctx}/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet"
	href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css"
	type="text/css" />
<script src="${ctx}/js/lib/bootstrap-select/bootstrap-select.js"></script>

<link type="text/css"
	href="${ctx}/js/lib/bootstrap-select/bootstrap-select.css"
	rel="stylesheet" />
	<link rel="stylesheet"
	href="${ctx}/js/lib/bootstrap-validator/css/bootstrapValidator.css"
	type="text/css">
	<script type="text/javascript"
	src="${ctx}/js/lib/jquery/bootstrap-contextmenu.js"></script>

<title>个人求职统计</title>
<script>
	function hideRows(obj){
		var rows = $("form").find(".row");
		var cl = $("#view_class").attr('class');
		$("#view_class").attr('class',cl=='icon-plus'?'icon-minus':'icon-plus');
		rows.each(function(index){
			 if(index>obj&&index<rows.length-1){
				 $(this).toggle("slow");
			 }
		});
	}
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
			field : 'DATA_DATE',
			title : '统计时间',
			width : '10%',
			align : 'center',
			formatter : function(value, row, index) {
				return value;
			}
		}, {
			field : 'AAE017N',
			title : '统计机构',
			width : '10%',
			align : 'center'
		}, {
			field : 'BCB209N',
			title : '数据来源',
			width : '5%',
			align : 'center',
			visible : false,
		}, {
			field : 'AAD004N',
			title : '性别',
			width : '8%',
			align : 'center',
			visible : false
		}, {
			field : 'ACC01GN',
			title : '专业要求',
			width : '8%',
			align : 'center',
			visible : false
		}, {
			field : 'AAC011N',
			title : '学历',
			width : '8%',
			align : 'center',
			visible : false
		}, {
			field : 'ACC217N',
			title : '工作经验',
			width : '8%',
			align : 'center',
			visible : false
		}, {
			field : 'ACB223N',
			title : '年龄',
			width : '8%',
			align : 'center',
			visible : false
		}, {
			field : 'AAC009N',
			title : '户口性质',
			width : '8%',
			align : 'center',
			visible : false
		}, {
			field : 'ACC20GN',
			title : '技术等级',
			width : '8%',
			align : 'center',
			visible : false
		}, {
			field : 'AAB019N',
			title : '单位性质',
			width : '8%',
			align : 'center',
			visible : false
		}, {
			field : 'ACC034N',
			title : '月工资',
			width : '8%',
			align : 'center',
			visible : false
		}, {
			field : 'ACC201N',
			title : '登记类别',
			width : '8%',
			align : 'center',
			visible : false
		}, {
			field : 'ACC20TN',
			title : '人员类别',
			width : '8%',
			align : 'center',
			visible : false
		}, {
			field : 'BCA111N',
			title : '自定职位',
			width : '8%',
			align : 'center',
			visible : false
		}, {
			field : 'ACA111N',
			title : '部标职位',
			width : '8%',
			align : 'center',
			visible : false
		}, {
			field : 'ACC214N',
			title : '福利待遇',
			width : '8%',
			align : 'center',
			visible : false
		}, {
			field : 'IS_NEWN',
			title : '新增',
			width : '8%',
			align : 'center',
			visible : false
		}, {
			field : 'ACB208N',
			title : '冻结',
			width : '8%',
			align : 'center',
			visible : false
		},

		{
			field : 'BQ_GRQZS',
			title : '个人求职数',
			width : '4%',
			align : 'center'
		}, {
			field : 'BQ_RATE',
			title : '求职所占比例(%)',
			width : '4%',
			align : 'center',
			visible : false
		}, {
			field : 'SQ_GRQZS',
			title : '上期求职数',
			visible : false,
			width : '4%',
			align : 'center'
		}, {
			field : 'BQ_SQ_GRQZS',
			title : '本期减上期求职数',
			visible : false,
			width : '4%',
			align : 'center'
		}, {
			field : 'HB_RATE',
			title : '求职人数环比(%)',
			width : '4%',
			align : 'center',
			visible : false
		}, {
			field : 'TQ_GRQZS',
			title : '同期求职人数',
			visible : false,
			width : '4%',
			align : 'center'
		}, {
			field : 'BQ_TQ_GRQZS',
			title : '本期减同期人数',
			visible : false,
			width : '4%',
			align : 'center'
		}, {
			field : 'TB_RATE',
			title : '求职人数同比',
			width : '4%',
			align : 'center'
		} ];
		$('#jobFairInfoList')
				.bootstrapTable(
						{
							url : '${ctx}/business/dissupport/statistics/statistics/jobregStatisticsJson.xf',
							columns : columns,
							method : "post",
							contentType : "application/x-www-form-urlencoded",
							pagination : false,
							pageSize : 10,
							pageList : [ 10, 15, 20 ],
							clickToSelect : true,
							singleSelect : false,
							sidePagination : "server",
							striped : true,
							queryParams : getSeachJson,
							onLoadSuccess:function(){
								$("#search_button").removeAttr("disabled");
							},
							onLoadError :function (status){
								$("#search_button").removeAttr("disabled");
								bootbox.alert("加载数据超时");
							}
						});
		$('#searchForm').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				startdate : {
					validators : {
						notEmpty : {message:'开始日期不能为空'}
					},
					date : {
						format : 'YYYY/DD/MM'
					}

				},
				enddate : {
					validators : {
						notEmpty : {message:'结束日期不能为空'}
					},
					date : {
						format : 'YYYY/DD/MM'
					}

				}
			}
		}).on('success.form.bv', function(e) {
			e.preventDefault();
			var $form = $(e.target);
			var bv = $form.data('bootstrapValidator');
			$(".btn").removeAttr("disabled");
			doSearch();
		});
		$('#startdate').on('change',
				function(e) {
					if ($(this).val() != "") {
						$('#searchForm').data('bootstrapValidator')
								.updateStatus('startdate', 'VALID', null)
								.validateField('startdate');

					}
				});
		$('#enddate').on('change',
				function(e) {
					if ($(this).val() != "") {
						$('#searchForm').data('bootstrapValidator')
								.updateStatus('enddate', 'VALID', null)
								.validateField('enddate');

					}});
	})
	function refresh() {
		$('#jobFairInfoList').bootstrapTable('refresh');
	}
	function getSeachJson(params) {
		var AAD004 = getSelectValues("aad004_select");
		$("#jobFairInfoList").bootstrapTable(
				AAD004 ? 'showColumn' : 'hideColumn', 'AAD004N');
		var ACC01G = getSelectValues("acc01g_select");
		$("#jobFairInfoList").bootstrapTable(
				ACC01G ? 'showColumn' : 'hideColumn', 'ACC01GN');
		var AAC011 = getSelectValues("aac011_select");
		$("#jobFairInfoList").bootstrapTable(
				AAC011 ? 'showColumn' : 'hideColumn', 'AAC011N');
		var ACC217 = getSelectValues("acc217_select");
		$("#jobFairInfoList").bootstrapTable(
				ACC217 ? 'showColumn' : 'hideColumn', 'ACC217N');
		var ACB223 = getSelectValues("acb223_select");
		$("#jobFairInfoList").bootstrapTable(
				ACB223 ? 'showColumn' : 'hideColumn', 'ACB223N');
		var AAC009 = getSelectValues("aac009_select");
		$("#jobFairInfoList").bootstrapTable(
				AAC009 ? 'showColumn' : 'hideColumn', 'AAC009N');
		var ACC20G = getSelectValues("acc20g_select");
		$("#jobFairInfoList").bootstrapTable(
				ACC20G ? 'showColumn' : 'hideColumn', 'ACC20GN');
		var AAB019 = getSelectValues("aab019_select");
		$("#jobFairInfoList").bootstrapTable(
				AAB019 ? 'showColumn' : 'hideColumn', 'AAB019N');
		var ACC034 = getSelectValues("acc034_select");
		$("#jobFairInfoList").bootstrapTable(
				ACC034 ? 'showColumn' : 'hideColumn', 'ACC034N');
		var BCB209 = getSelectValues("bcb209_select");
		$("#jobFairInfoList").bootstrapTable(
				BCB209 ? 'showColumn' : 'hideColumn', 'BCB209N');
		var ACC201 = getSelectValues("acc201_select");
		$("#jobFairInfoList").bootstrapTable(
				ACC201 ? 'showColumn' : 'hideColumn', 'ACC201N');
		var ACC20T = getSelectValues("acc20t_select");
		$("#jobFairInfoList").bootstrapTable(
				ACC20T ? 'showColumn' : 'hideColumn', 'ACC20TN');
		var BCA111 = getSelectValues("bca111_select");
		$("#jobFairInfoList").bootstrapTable(
				BCA111 ? 'showColumn' : 'hideColumn', 'BCA111N');
		var ACA111 = getSelectValues("aca111_select");
		$("#jobFairInfoList").bootstrapTable(
				ACA111 ? 'showColumn' : 'hideColumn', 'ACA111N');
		var ACC214 = getSelectValues("acc214_select");
		$("#jobFairInfoList").bootstrapTable(
				ACC214 ? 'showColumn' : 'hideColumn', 'ACC214N');
		var IS_NEW = getSelectValues("is_new_select");
		$("#jobFairInfoList").bootstrapTable(
				IS_NEW ? 'showColumn' : 'hideColumn', 'IS_NEWN');
		var ACB208 = getSelectValues("acb208_select");
		return {
			'limit' : params.limit,
			'offset' : params.offset,
			'order' : params.order,
			'STARTDATE' : $("#startdate").val(),
			'ENDDATE' : $("#enddate").val(),
			'AAE017' : $("#aae017").val(),
			'AAD004' : AAD004,
			'ACC01G' : ACC01G,
			'AAC011' : AAC011,
			'ACC217' : ACC217,
			'ACB223' : ACB223,
			'AAC009' : AAC009,
			'ACC20G' : ACC20G,
			'AAB019' : AAB019,
			'ACC034' : ACC034,
			'BCB209' : BCB209,
			'ACC201' : ACC201,
			'ACC20T' : ACC20T,
			'BCA111' : BCA111,
			'ACA111' : ACA111,
			'ACC214' : ACC214,
			'IS_NEW' : IS_NEW,
			'ACB208':ACB208
		};
	}
	function doSearch() {
		$("#jobFairInfoList").bootstrapTable('refresh', {
			query : getSeachJson
		})
	}
	function doClear() {
		$("#startdate").val('')
		$("#enddate").val('');
		$('.selectpicker').selectpicker('val', '');
		resetForm("searchForm");
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
								<div class="col-xs-12 col-sm-4">
									<label class="col-xs-2 col-sm-4" for="inputError"><i style="color: red; margin-right: 5px;">*</i>开始日期:</label>
									<div class="col-xs-10 input-group col-sm-8"
										style="padding-left: 15px">
										<div class="input-group" style="padding: 0 !important;">
										<input id="startdate"
											class="form-control date-picker dp mhydatepicker" type="text"
											placeholder="请选择日期" name="startdate"> <span
											class="input-group-addon"> <i
											class="icon-calendar bigger-110"></i>
										</span></div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4">
									<label class="col-xs-2 col-sm-4" for="inputError"><i style="color: red; margin-right: 5px;">*</i>结束日期:</label>
									<div class="col-xs-10 input-group col-sm-8"
										style="padding-left: 15px">
										<div class="input-group" style="padding: 0 !important;">
										<input id="enddate"
											class="form-control date-picker dp mhydatepicker" type="text"
											placeholder="请选择日期" name="enddate"> <span
											class="input-group-addon"> <i
											class="icon-calendar bigger-110"></i>
										</span></div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4">
									<label class="col-xs-2 col-sm-4" for="inputError">统计机构:</label>
									<div class="col-xs-10 col-sm-8 ">
												<input id="aae017" name="aae017" type="hidden"></input>  
												<input class="form-control" id="aae017n" name="aae017n" type="text"  readonly="true" ></input>  
									</div>
<!-- 									<div class="col-xs-10 col-sm-8 mhyOrgId " -->
<!-- 										id="selectDxdiv"> -->
<!-- 										<select id="aae017_select" class="selectpicker" -->
<!-- 											data-live-search="true" multiple="multiple" -->
<!-- 											data-live-search-placeholder="Search" data-actions-box="true"> -->
<!-- 											<optgroup> -->
<%-- 												<c:forEach items="${orgs}" begin="0" var="objOrg"> --%>
<%-- 													<option value="${objOrg.acd200}">${objOrg.acd202}</option> --%>
<%-- 												</c:forEach> --%>
<!-- 											</optgroup> -->
<!-- 										</select> -->
<!-- 									</div> -->
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-4">
									<label class="col-xs-2 col-sm-4" for="inputError">数据来源:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId "
										id="selectDxdiv">
										<select id="bcb209_select" class="selectpicker"
											data-live-search="true" multiple="multiple"
											data-live-search-placeholder="Search" data-actions-box="true">
											<xf:select name="funt66" textField="name"
												tableName="TAB_DATASOURCES" valueField="code"
												isOnlyOptions="true"></xf:select>
										</select>
									</div>
								</div>
									<div class="col-xs-12 col-sm-4">
									<label class="col-xs-2 col-sm-4" for="inputError">部标职位:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId "
										id="selectDxdiv">
										<select id="aca111_select" class="selectpicker"
											data-live-search="true" multiple="multiple"
											data-live-search-placeholder="Search" data-actions-box="true">
											<xf:select name="funt66" textField="name"
												tableName="TAB_CRAFT" pidName="PCODE" pidValue="0"
												valueField="code" isOnlyOptions="true"></xf:select>
										</select>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4">
									<label class="col-xs-2 col-sm-4" for="inputError">自定职位:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId "
										id="selectDxdiv">
										<select id="bca111_select" class="selectpicker"
											data-live-search="true" multiple="multiple"
											data-live-search-placeholder="Search" data-actions-box="true">
											<xf:select name="funt66" textField="name"
												tableName="CRAFT_AS" pidName="PID" pidValue="0"
												valueField="id" isOnlyOptions="true"></xf:select>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
									<div class="col-xs-12 col-sm-4">
									<label class="col-xs-2 col-sm-4" for="inputError">单位性质:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId "
										id="selectDxdiv">
										<select id="aab019_select" class="selectpicker"
											data-live-search="true" multiple="multiple"
											data-live-search-placeholder="Search" data-actions-box="true">
											<xf:select name="funt66" textField="name"
												tableName="TAB_UNITNATURE" valueField="code"
												isOnlyOptions="true"></xf:select>
										</select>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4">
									<label class="col-xs-2 col-sm-4" for="inputError">登记类别:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId "
										id="selectDxdiv">
										<select id="acc201_select" class="selectpicker"
											data-live-search="true" multiple="multiple"
											data-live-search-placeholder="Search" data-actions-box="true">
											<xf:select name="funt66" textField="name"
												tableName="TAB_REGTYPE" valueField="code"
												isOnlyOptions="true"></xf:select>
										</select>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4">
									<label class="col-xs-2 col-sm-4" for="inputError">专业要求:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId "
										id="selectDxdiv">
										<select id="acc01g_select" class="selectpicker"
											data-live-search="true" multiple="multiple"
											data-live-search-placeholder="Search" data-actions-box="true">
											<xf:select name="funt66" textField="name"
												tableName="TAB_PROFESSION" pidName="PCODE" pidValue=""
												valueField="code" isOnlyOptions="true"></xf:select>
										</select>
									</div>
								</div>
							</div>
							<div class="row" style="display: none;">
								<div class="col-xs-12 col-sm-4">
									<label class="col-xs-2 col-sm-4" for="inputError">福利待遇:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId "
										id="selectDxdiv">
										<select id="acc214_select" class="selectpicker"
											data-live-search="true" multiple="multiple"
											data-live-search-placeholder="Search" data-actions-box="true">
											<xf:select name="funt66" textField="name"
												tableName="TAB_WELFARE" valueField="code"
												isOnlyOptions="true"></xf:select>
										</select>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4">
									<label class="col-xs-2 col-sm-4" for="inputError">年龄:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId "
										id="selectDxdiv">
										<select id="acb223_select" class="selectpicker"
											data-live-search="true" multiple="multiple"
											data-live-search-placeholder="Search" data-actions-box="true">
											<xf:select name="funt66" textField="name"
												tableName="TAB_AGES" valueField="code" isOnlyOptions="true"></xf:select>
										</select>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4">
									<label class="col-xs-2 col-sm-4" for="inputError">月工资:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId "
										id="selectDxdiv">
										<select id="acc034_select" class="selectpicker"
											data-live-search="true" multiple="multiple"
											data-live-search-placeholder="Search" data-actions-box="true">
											<xf:select name="funt66" textField="name"
												tableName="TAB_SALARY" valueField="code"
												isOnlyOptions="true"></xf:select>
										</select>
									</div>
								</div>
							</div>
							<div class="row" style="display: none;">
								<div class="col-xs-12 col-sm-4">
									<label class="col-xs-2 col-sm-4" for="inputError">性别:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId "
										id="selectDxdiv">
										<select id="aad004_select" class="selectpicker"
											data-live-search="true" multiple="multiple"
											data-live-search-placeholder="Search" data-actions-box="true">
											<xf:select name="funt66" textField="name" tableName="TAB_SEX"
												valueField="code" isOnlyOptions="true"></xf:select>
										</select>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4">
									<label class="col-xs-2 col-sm-4" for="inputError">学历:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId "
										id="selectDxdiv">
										<select id="aac011_select" class="selectpicker"
											data-live-search="true" multiple="multiple"
											data-live-search-placeholder="Search" data-actions-box="true">
											<xf:select name="funt66" textField="name"
												tableName="TAB_EDUCATION" valueField="code"
												isOnlyOptions="true"></xf:select>
										</select>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4">
									<label class="col-xs-2 col-sm-4" for="inputError">人员类别:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId "
										id="selectDxdiv">
										<select id="acc20t_select" class="selectpicker"
											data-live-search="true" multiple="multiple"
											data-live-search-placeholder="Search" data-actions-box="true">
											<xf:select name="funt66" textField="name"
												tableName="TAB_STAFFTYPE" valueField="code"
												isOnlyOptions="true"></xf:select>
										</select>
									</div>
								</div>
							</div>
							<div class="row" style="display: none;">
								<div class="col-xs-12 col-sm-4">
									<label class="col-xs-2 col-sm-4" for="inputError">工作经验:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId "
										id="selectDxdiv">
										<select id="acc217_select" class="selectpicker"
											data-live-search="true" multiple="multiple"
											data-live-search-placeholder="Search" data-actions-box="true">
											<xf:select name="funt66" textField="name"
												tableName="TAB_WORKYEARS" valueField="code"
												isOnlyOptions="true"></xf:select>
										</select>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4">
									<label class="col-xs-2 col-sm-4" for="inputError">技术等级:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId "
										id="selectDxdiv">
										<select id="acc20g_select" class="selectpicker"
											data-live-search="true" multiple="multiple"
											data-live-search-placeholder="Search" data-actions-box="true">
											<xf:select name="funt66" textField="name" tableName="TAB_COQ"
												valueField="code" isOnlyOptions="true"></xf:select>
										</select>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4">
									<label class="col-xs-2 col-sm-4" for="inputError">新增:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId "
										id="selectDxdiv">
										<select id="is_new_select" class="selectpicker"
											data-live-search="true" multiple="multiple"
											data-live-search-placeholder="Search" data-actions-box="true">
											<option value="1">是</option>
											<option value="0">否</option>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-4">
																		<label class="col-xs-2 col-sm-4" for="inputError">冻结:</label>
																		<div class="col-xs-10 col-sm-8 mhyOrgId "
																			id="selectDxdiv">
																			<select id="acb208_select" class="selectpicker"
																				data-live-search="true" multiple="multiple"
																				data-live-search-placeholder="Search" data-actions-box="true">
																				<option value="1">冻结</option>
																				<option value="0">未冻结</option>
																			</select>
																		</div>
								</div>
								<div class="col-xs-12 col-sm-4"></div>
								<div class="col-xs-12 col-sm-4 marginbottom20">
									<div class="col-xs-2 col-sm-4"></div>
									<div class="col-xs-10 col-sm-8 mhyBtn">
										<button href="#modal-form" role="button" id="search_button" onclick="doSearch()"
											class="btn btn-primary btn-border1 mhyBtnLeft" type="submit">
											<i class="icon-search"></i>
											查询</button>
												<a href="#modal-form" class="btn btn-primary btn-border1 mhyBtnLeft" onclick="hideRows(2)" ><i id="view_class" class="icon-plus"></i>高级查询</a>
											 <a href="#modal-form" role="button" onclick="doClear()"
											class="btn btn-info">
											<i class="icon-repeat"></i>
											重置</a>
									</div>
								</div>
							</div>
					</form>
				</div>
				<div class="mhyMain"> 
					<div class="mhyTitle">查询结果</div>
					<div class="mhyInfo mhyConter">
						<table id="jobFairInfoList" class="tableClassNoworks  table-striped"></table>
					</div>
				</div> 
			</div>
		</div>
		<script type="text/javascript">
			jQuery(function($) {
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
				$('.selectpicker').selectpicker({
					selectAllText : '全选',//全选的checkbox名称  
					deselectAllText : '取消',
					selectAllNumber : true,
					actionsBox : true,
					noneResultsText : "没有相关信息",liveSearchPlaceholder:"请输入搜索.."
				});
			});
		</script>
	</div>
</body>
</html>