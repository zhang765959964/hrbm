<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp"%>
<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />
<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
<script
	src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/ui/xf.treeorg.js?version=201609231008"></script>
<link rel="stylesheet"
	href="${ctx}/assets/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/daterangepicker.css" />
<script src="${ctx}/js/lib/bootstrap-select/bootstrap-select.js"></script>
<link href="${ctx}/assets/css/bootstrap.min.css" rel="stylesheet" />
<link type="text/css"  href="${ctx}/js/lib/bootstrap-select/bootstrap-select.css" rel="stylesheet" />
<script src="${ctx}/assets/js/echarts/echarts.min.js"></script>
<link rel="stylesheet" href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css" type="text/css" />
<title>工种工资统计</title>
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
		var columns = [ 
			  {
				field : 'DATA_DATE',
				title : '统计时间',
				width : '10%',
				align : 'center',
				formatter : function(value, row, index) {
					return value;
				}
			},
		                {
			field : 'AAE017N',
			title : '统计机构',
			width : '13%',
			align : 'center'
		},
		{
			field : 'AAB054N',
			title : '产业类别',
			width : '5%',
			align : 'center',
			visible:false
		}, 
		{
			field : 'AAB022N',
			title : '部标行业',
			width : '4%',
			align : 'center',
			visible:false
		},
		{
			field : 'CCPR10N',
			title : '自定行业',
			width : '4%',
			align : 'center',
			visible:false
		},
		{
			field : 'ACA111N',
			title : '部标职位',
			width : '4%',
			align : 'center',
			visible:false
		},
		{
			field : 'BCA111N',
			title : '自定职位',
			width : '4%',
			align : 'center',visible:false
		},
		{
			field : 'DWS',
			title : '缺工企业数',
			width : '5%',
			align : 'center'
		}, {
			field : 'GRS',
			title : '缺工人数',
			width : '5%',
			align : 'center'
		}, {
			field : 'MIN_NAME',
			title : '最低工资',
			width : '6%',
			align : 'center'
		}, {
			field : 'MAX_NAME',
			title : '最高工资',
			width : '6%',
			align : 'center'
		}, {
			field : 'AVG_NAME',
			title : '加权平均工资',
			width : '5%',
			align : 'center'
		} ];
		$('#jobFairInfoList')
				.bootstrapTable(
						{
							url : '${ctx}/business/dissupport/statistics/statistics/jobSalariesStatisticsJson.xf',
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

					} 
				});
	})
	function refresh() {
		$('#jobFairInfoList').bootstrapTable('refresh');
	}
	function getSelectValues(objId){
		var selectValueStr ='';
		$("#"+objId+" option:selected").each(
				function() {
					selectValueStr = selectValueStr ? (selectValueStr
							+ "," + $(this).val()) : $(this).val();
				});
		return selectValueStr;
	}
	function getSeachJson(params) {
		var AAB054 = getSelectValues("aab054_select");
		$("#jobFairInfoList").bootstrapTable(AAB054?'showColumn':'hideColumn', 'AAB054N');
		var AAB022 = getSelectValues("aab022_select");
		$("#jobFairInfoList").bootstrapTable(AAB022?'showColumn':'hideColumn', 'AAB022N');
		var CCPR10 = getSelectValues("ccpr10_select");
		$("#jobFairInfoList").bootstrapTable(CCPR10?'showColumn':'hideColumn', 'CCPR10N');
		var ACA111 = getSelectValues("aca111_select");
		$("#jobFairInfoList").bootstrapTable(ACA111?'showColumn':'hideColumn', 'ACA111N');
		var BCA111 = getSelectValues("bca111_select");
		$("#jobFairInfoList").bootstrapTable(BCA111?'showColumn':'hideColumn', 'BCA111N');
		//取选中值
		return {
			'STARTDATE' : $("#startdate").val(),
			'ENDDATE' : $("#enddate").val(),
			'AAE017' : $("#aae017").val(),
			'AAB054' : AAB054,
			'AAB022' : AAB022,
			'CCPR10' : CCPR10,
			'ACA111' : ACA111,
			'BCA111' : BCA111
		};
	}
	function doSearch() {
		var reg= /^\+?[0-9][0-9]*$/;
		var REDUNDANCE_DAYS1 = $("#REDUNDANCE_DAYS").val();
		if(REDUNDANCE_DAYS1){
			if(REDUNDANCE_DAYS1.match(reg)){
				$('#error_id').html("");
			}else{
				$('#error_id').html("冗余天数请输入正整数");
				return ;
			}
		}
		$("#jobFairInfoList").bootstrapTable('refresh', {
			query : getSeachJson
		})
	}
	function doClear() {
		$("#startdate").val('')
		$("#enddate").val('');
		// 		$("#select_read").val('');
		// 		$("#aab004_id").val('');
		$('.selectpicker').selectpicker('deselectAll');
		$("#REDUNDANCE_DAYS").val('');
		$("#error_id").html('');
		$("#search_button").removeAttr('disabled');
		$("#error_id").hide();
		//TAB_INDUSTRY
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
								<div class="col-xs-12 col-sm-4"  >
									<label class="col-xs-2 col-sm-4" for="inputError"><i style="color: red; margin-right: 5px;">*</i>开始日期:</label>
									<div class="col-xs-10 col-sm-8"
										 >
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
									<div class="col-xs-10 col-sm-8"
										 >
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
										<select id="org_select" class="selectpicker" multiple
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
<!-- 								<div class="col-xs-12 col-sm-4" style="display: none;" > -->
<!-- 									<label class="col-xs-2 col-sm-4" for="inputError">数据来源:</label> -->
<!-- 									<div class="col-xs-10 col-sm-8 mhyNoSelect"> -->
<%-- 										<xf:select id="select_read" name="funplat" textField="name" --%>
<%-- 											tableName="TAB_DATASOURCES" valueField="code" --%>
<%-- 											isNoStyle="true" hasDefault="0" hasDefaultName="全部"></xf:select> --%>
<!-- 									</div> -->
<!-- 								</div> -->
									<div class="col-xs-12 col-sm-4 marginbottom20">
									<label class="col-xs-2 col-sm-4" for="inputError">产业类别:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId "
										id="selectDxdiv">
										<select id="aab054_select" class="selectpicker" multiple
											data-live-search="true" data-live-search-placeholder="Search"
											data-actions-box="true">
											<optgroup>
												<xf:select  name="sex" textField="name"
												tableName="TAB_INDUSTRYCLASSES" valueField="code" isOnlyOptions="true"
											 ></xf:select>
											</optgroup>
										</select>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4 marginbottom20">
									<label class="col-xs-2 col-sm-4" for="inputError">部标职位:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId " id="selectDxdiv">
											<select id="aca111_select" class="selectpicker" multiple
											data-live-search="true" data-live-search-placeholder="Search"
											data-actions-box="true">
											<optgroup>
											<xf:select   name="ACA111" textField="name"
											tableName="TAB_CRAFT" isOnlyOptions="true" pidName="PCODE" pidValue="0" valueField="code" isNoStyle="true"
											 ></xf:select>
											 </optgroup>
											</select>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4 marginbottom20">
									<label class="col-xs-2 col-sm-4" for="inputError">自定职位:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId " id="selectDxdiv">
									<select id="bca111_select" class="selectpicker" multiple
											data-live-search="true" data-live-search-placeholder="Search"
											data-actions-box="true">
											<optgroup>
										<xf:select   name="BCA111" textField="name"
											tableName="CRAFT_AS" valueField="id" pidName="PID" pidValue="0" isOnlyOptions="true"
											 ></xf:select></optgroup> </select>
									</div>
								</div>
							</div>
							<div class="row">
									<div class="col-xs-12 col-sm-4 marginbottom20">
									<label class="col-xs-2 col-sm-4" for="inputError">部标行业:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId " id="selectDxdiv">
									<select id="aab022_select" class="selectpicker" multiple
											data-live-search="true" data-live-search-placeholder="Search"
											data-actions-box="true">
										<optgroup><xf:select  name="tab_industry" pidName="pcode" pidValue="0" textField="name" tableName="TAB_INDUSTRY" valueField="code" isOnlyOptions="true" ></xf:select>
											</optgroup> </select>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4 marginbottom20">
									<label class="col-xs-2 col-sm-4" for="inputError">自定行业:</label>
									<div class="col-xs-10 col-sm-8 mhyOrgId " id="selectDxdiv">
									<select id="ccpr10_select" class="selectpicker" multiple
											data-live-search="true" data-live-search-placeholder="Search"
											data-actions-box="true">
										<optgroup><xf:select   name="industry_as"  pidName="pid" pidValue="1"  textField="name"
											tableName="INDUSTRY_AS" valueField="id" isOnlyOptions="true"
											 ></xf:select> </optgroup> </select>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4">
								 <label class="col-xs-2 col-sm-4" for="inputError">去冗余天数:</label>
								 <div class="col-xs-10 col-sm-8  "  
										 >
										 <input   class="form-control" id="REDUNDANCE_DAYS" type="number" min="0"  />
										 <span style="color: red; margin-right: 5px;display: none;" id="error_id"></span>
										 </div>
								</div>
								</div>
								<div class="row">
									<div class="col-xs-12 col-sm-4 "></div>
							<div class="col-xs-12 col-sm-4 "></div>
									<div class="col-xs-12 col-sm-4 marginbottom20">
									<div class="col-xs-2 col-sm-4"></div>
									<div class="col-xs-10 col-sm-8 mhyBtn">
										<button  id="search_button" role="button" id="search_button"
											class="btn btn-primary btn-border1 mhyBtnLeft" type="submit">
											<i class="icon-search"></i>
											查询</button> <button
											href="#modal-form" type="button" role="button" onclick="doClear()"
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
				$('.selectpicker').selectpicker({
					selectAllText : '全选',//全选的checkbox名称  
					deselectAllText : '取消',
					selectAllNumber : true,
					actionsBox:true,
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