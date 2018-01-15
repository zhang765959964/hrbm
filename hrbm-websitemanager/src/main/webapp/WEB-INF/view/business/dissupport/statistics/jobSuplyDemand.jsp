<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp"%>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${ctx}/assets/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/daterangepicker.css" />
<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />
<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/ui/xf.treeorg.js?version=201609231008"></script>
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
<title>供求关系统计</title>
<script>
function checkData(){
	var reg= /^\+?[0-9][0-9]*$/;
	var REDUNDANCE_DAYS1 = $("#REDUNDANCE_DAYS").val();
	if(REDUNDANCE_DAYS1){
		if(REDUNDANCE_DAYS1.match(reg)){
			$('#error_id').hide();
			$('#error_id').html("");
			$("#search_button").removeAttr('disabled');
		}else{
			$('#error_id').show();
			$('#error_id').html("冗余天数请输入正整数");
			$("#search_button").attr('disabled',true);
			return ;
		}
	}else{
		$('#error_id').hide();
		$('#error_id').html("");
		$("#search_button").removeAttr('disabled');
	}
}
	$(function() {
		$("#aae017n").treeorg({callBack:function(data){
			$("#aae017n").val(data.orgName);
			$("#aae017").val(data.orgId);
			}
		});
		$("#REDUNDANCE_DAYS").on('input',checkData);
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
		},{
			field : 'AAE017N',
			title : '统计机构',
			width : '8%',
			align : 'center'
		},
		{
		 field : 'ACA111N',
		 title : '部标职位',
			width : '4%',
			align : 'center',
			visible : false 
	   },
				{
					field : 'BCA111N',
					title : '自定职位',
					width : '4%',
					align : 'center',
					visible : false
				},
		{
			field : 'AAD004N',
			title : '性别',
			width : '5%',
			align : 'center',
			visible : false
		}, {
			field : 'ACB223N',
			title : '年龄',
			width : '5%',
			align : 'center',
			visible : false
		}, {
			field : 'AAC011N',
			title : '学历',
			width : '5%',
			align : 'center',
			visible : false
		}, {
			field : 'ACC01GN',
			title : '专业要求',
			width : '5%',
			align : 'center',
			visible : false
		},
		{
			field : 'BQ_GRQZS',
			title : '个人求职数',
			width : '5%',
			align : 'center'
		},
		{
			field : 'BQ_GRQZS_RATE',
			title : '求职所占比例(%)',
			visible : false,
			width : '5%',
			align : 'center'
		},
		{
			field : 'SQ_GRQZS',
			title : '上期求职人数',
			visible : false,
			width : '5%',
			align : 'center'
		},
		{
			field : 'BQ_SQ_GRQZS',
			title : '本期减上期人数',
			visible : false,
			width : '5%',
			align : 'center'
		},
		{
			field : 'HB_GRQZS_RATE',
			title : '求职人数环比(%)',
			visible : false,
			width : '5%',
			align : 'center'
		},
		{
			field : 'TQ_GRQZS',
			title : '同期求职人数',
			visible : false,
			width : '5%',
			align : 'center'
		},
		{
			field : 'BQ_TQ_GRQZS',
			title : '本期减同期人数',
			visible : false,
			width : '5%',
			align : 'center'
		},
		{
			field : 'TB_GRQZS_RATE',
			title : '求职人数同比(%)',
			visible : false,
			width : '5%',
			align : 'center'
		}
		, {
			field : 'BQ_ZPRS',
			title : '需求人数',
			width : '5%',
			align : 'center'
		}, {
			field : 'BQ_ZPRS_RATE',
			title : '需求人数所占比',
			visible : false,
			width : '5%',
			align : 'center'
		}, {
			field : 'SQ_ZPRS',
			title : '上期招聘人数',
			visible : false,
			width : '6%',
			align : 'center'
		},
		//AAE139,ACB204,ACB20D,AAE019,AAE020,BAE036
		{
			field : 'BQ_SQ_ZPRS',
			title : '本期减上期人数',
			visible : false,
			visible : false,
			width : '6%',
			align : 'center'
		},
		{
			field : 'HB_ZPRS_RATE',
			title : '需求人数环比',
			width : '6%',
			align : 'center'
		},
		{
			field : 'TQ_ZPRS',
			title : '同期需求人数',
			width : '6%',
			align : 'center'
		},
		{
			field : 'BQ_TQ_ZPRS',
			title : '本期减同期人数',
			visible : false,
			width : '6%',
			align : 'center'
		}
		
		, {
			field : 'QRBL_RATE',
			title : '求人倍率',
			width : '5%',
			align : 'center'
		}
		// 	                ,{field:'acb330',title:'操作',width:100,formatter: function(value,row,index){	 
		// 				           return "<a href=\"javascript:void(0)\" onclick=\"editJobFairInfo('"+value+"')\" >编辑</a>|"+
		// 								"<a href=\"javascript:void(0)\" onclick=\"delJobFairInfo('"+value+"')\" >删除</a>";
		// 							}
		// 					 }
		];
		$('#jobFairInfoList')
				.bootstrapTable(
						{
							url : '${ctx}/business/dissupport/statistics/statistics/jobSuplyDemandListJson.xf',
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
		var SEX = getSelectValues('select_sex');
		$("#jobFairInfoList").bootstrapTable(SEX ? 'showColumn' : 'hideColumn', 'AAD004N');
		var AGE = getSelectValues('select_age');
		$("#jobFairInfoList").bootstrapTable(AGE ? 'showColumn' : 'hideColumn', 'ACB223N');
		var ACA111 = getSelectValues("aca111_select");
		$("#jobFairInfoList").bootstrapTable(ACA111 ? 'showColumn' : 'hideColumn', 'ACA111N');
		var BCA111 = getSelectValues("bca111_select");
		$("#jobFairInfoList").bootstrapTable(
				BCA111 ? 'showColumn' : 'hideColumn', 'BCA111N');
		
		var ACB208 = getSelectValues("acb208_select");
		var ACC01G = getSelectValues("acc01g_select");
		$("#jobFairInfoList").bootstrapTable(
				ACC01G ? 'showColumn' : 'hideColumn', 'ACC01GN');
		var AAC011 = getSelectValues("aac011_select");
		$("#jobFairInfoList").bootstrapTable(
				AAC011 ? 'showColumn' : 'hideColumn', 'AAC011N');
		return {
			'STARTDATE' : $("#startdate").val(),
			'ENDDATE' : $("#enddate").val(),
			'AAE017' : $("#aae017").val(),
// 			'CCZY06' : $("#select_read").val(),
			'SEX' : SEX,
			'AGE' : AGE,
			'ACA111' : ACA111,
			'BCA111' : BCA111,
			'ACB208' : ACB208,
			'ACC01G' : ACC01G,
			'AAC011' : AAC011
		};
	}
	function doSearch() {
		$("#jobFairInfoList").bootstrapTable('refresh', {
			query : getSeachJson
		})
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
	function doClear() {
		$("#startdate").val('')
		$("#enddate").val('');
		$("#REDUNDANCE_DAYS").val('');
		$("#error_id").html('');
		$("#search_button").removeAttr('disabled');
		$("#error_id").hide();
// 		$("#select_read").val('');
		$('.selectpicker').selectpicker('deselectAll');
		resetForm("searchForm");
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
								<div class="col-xs-12 col-sm-4" >
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
								<div class="col-xs-12 col-sm-4" >
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
									<%-- <div class="col-xs-10 col-sm-8 mhyOrgId "
										id="selectDxdiv">
										<select id="org_select" class="selectpicker form-control" multiple
											data-live-search="true" data-live-search-placeholder="Search"
											data-actions-box="true">
											<optgroup>
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

							<div class="row" >
<!-- 								<div class="col-xs-12 col-sm-4"> -->
<!-- 									<label class="col-xs-2 col-sm-4" for="inputError">数据来源:</label> -->
<!-- 									<div class="col-xs-10 col-sm-8 mhyNoSelect"> -->
<%-- 										<xf:select id="select_read" name="funplat" textField="name" --%>
<%-- 											tableName="TAB_DATASOURCES" valueField="code" --%>
<%-- 											isNoStyle="true" hasDefault="0" hasDefaultName="全部"></xf:select> --%>
<!-- 									</div> -->
<!-- 								</div> -->
									<div class="col-xs-12 col-sm-4 ">
									<label class="col-xs-2 col-sm-4" for="inputError">部标职位:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId " id="selectDxdiv">
											<select id="aca111_select" class="selectpicker" multiple
											data-live-search="true" data-live-search-placeholder="Search"
											data-actions-box="true">
											<optgroup>
											<xf:select   name="ACA111" textField="name"
											tableName="TAB_CRAFT" isOnlyOptions="true" valueField="code" pidName="PCODE" pidValue="0" isNoStyle="true"
											 ></xf:select>
											 </optgroup>
											</select>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4 ">
									<label class="col-xs-2 col-sm-4" for="inputError">自定职位:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId " id="selectDxdiv">
									<select id="bca111_select" class="selectpicker" multiple
											data-live-search="true" data-live-search-placeholder="Search"
											data-actions-box="true">
											<optgroup>
										<xf:select   name="BCA111" textField="name"
											tableName="CRAFT_AS" valueField="id"  pidName="PID" pidValue="0" isOnlyOptions="true"
											 ></xf:select></optgroup> </select>
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
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-4 ">
									<label class="col-xs-2 col-sm-4" for="inputError">性别:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId " id="selectDxdiv">
									<select id="select_sex" class="selectpicker" multiple
											data-live-search="true" data-live-search-placeholder="Search"
											data-actions-box="true">
											<optgroup>
										<xf:select   name="tab_sex" textField="name"
											tableName="TAB_SEX" valueField="code" isOnlyOptions="true"
											 ></xf:select></optgroup> </select>
									</div>
								</div>
								 	<div class="col-xs-12 col-sm-4 ">
									<label class="col-xs-2 col-sm-4" for="inputError">年龄:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId " id="selectDxdiv">
									<select id="select_age" class="selectpicker" multiple
											data-live-search="true" data-live-search-placeholder="Search"
											data-actions-box="true">
											<optgroup>
										<xf:select   name="tab_ages" textField="name"
											tableName="TAB_AGES" valueField="code" isOnlyOptions="true"
											 ></xf:select></optgroup> </select>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4">
								 <label class="col-xs-2 col-sm-4" for="inputError">去冗余天数:</label>
								 <div class="col-xs-10 col-sm-8">
										 <input    class="form-control" id="REDUNDANCE_DAYS" type="number" min="0"  />
										 <span style="color: red; margin-right: 5px;display: none;"  id="error_id"></span>
										 </div>
								</div>
							</div>
							<div class="row">
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
								<div class="col-xs-12 col-sm-4 marginbottom20">
									<label class="col-xs-2 col-sm-4" for="inputError"></label>
									<div class="col-xs-10 col-sm-8 mhyBtn">
										<button   role="button" id="search_button"   type="submit" class="btn btn-primary mhyBtnLeft">
										<i class="icon-search"></i>
										查询</button> 
										<button href="#modal-form" type="button" role="button" onclick="doClear()"
											class="btn btn-info">
											<i class="icon-repeat"></i>
											重置</button>
									</div>
								</div>
							</div>
					</form>
				</div>
				<div class="mhyMain">
					<div class="mhyTitle">查询结果</div>
					<div class="mhyInfo mhyConter" >
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
					actionsBox:true,
					noneResultsText : "没有相关信息",liveSearchPlaceholder:"请输入搜索.."
				});
			});
			//取选中值
			//   var selectValueStr = [];
			//   $(".select2_sample1 option:selected").each(function () {
			//       selectValueStr.push($(this).val());
			//   });
		</script>
	</div>
</body>
</html>