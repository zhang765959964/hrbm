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
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/ui/xf.treeorg.js?version=201609231008"></script>
<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/daterangepicker.css" />
<script src="${ctx}/js/lib/bootstrap-select/bootstrap-select.js"></script>
<link type="text/css" href="${ctx}/js/lib/bootstrap-select/bootstrap-select.css" rel="stylesheet" />
<script src="${ctx}/assets/js/echarts/echarts.min.js"></script>
<link rel="stylesheet" href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css" type="text/css" />
<title>岗位信息查询</title>
<script>
function hideRows(obj){
	var rows = $("form").find(".row");
	var cl = $("#view_class").attr('class');
	$("#view_class").attr('class',cl=='icon-plus'?'icon-minus':'icon-plus');
	rows.each(function(index){
		 if(index>obj&&index<rows.length-2){
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
			field : 'ACB210',
			title : 'Id号',
			width : 100,
			align : 'center',
			visible : false
		}, {
			field : 'status',
			title : '选择',
			checkbox : 'true',
			width : '5%',
			align : 'center'
		} ,{
			field : 'ACB2101',
			title : '操作',
			width : '5%',
			align : 'center',
			formatter : function(value, row, index) {
				return "<a class=\"mhyNoA\" href=\"javascript:void(0)\" onclick=\"edit('"
						+ row.ACB210 + "')\" ><i class=\"icon-pencil\" title=\"编辑\"></i></a>";
			}
		}]
		var isEdit = '${isEdit}';
		if (!isEdit) {
			columns = [];
		}
		columns = columns.concat([ {
			field : 'ACB200',
			title : '招聘编号',
			width : '3%',
			align : 'center'
		}, {
			field : 'AAB004',
			title : '单位名称',
			width : '10%',
			align : 'center'
		}, {
			field : 'BCA112',
			title : '职位名称',
			width : '7%',
			align : 'center'
		}, {
			field : 'CCA113',
			title : '职位说明',
			width : '7%',
			align : 'center'
		},
		// 		{
		// 			field : 'AAE030',
		// 			title : '开始时间',
		// 			width : '6%',
		// 			align : 'center'
		// 		}, {
		// 			field : 'AAE031',
		// 			title : '终止时间',
		// 			width : '6%',
		// 			align : 'center'
		// 		},
		{
			field : 'ACB21R',
			title : '招聘人数',
			width : '3%',
			align : 'center'
		},
		{
			field : 'BCB201',
			title : '招聘方式',
			width : '8%',
			align : 'center'
		},
		{
			field : 'ACC034',
			title : '月工资',
			width : '8%',
			align : 'center'
		},	{
			field : 'ACB228',
			title : '食宿要求',
			width : '8%',
			align : 'center'
		},
		{
			field : 'ACC214',
			title : '福利待遇',
			width : '8%',
			align : 'center'
		},
		{
			field : 'ACC217',
			title : '工作年限',
			width : '5%',
			align : 'center'
		}, {
			field : 'AAC011',
			title : '文化程度',
			width : '5%',
			align : 'center'
		}, {
			field : 'ACB208',
			title : '冻结标记',
			width : '4%',
			align : 'center'
		}, {
			field : 'ACB20L',
			title : '冻结原因',
			width : '5%',
			align : 'center'
		}
		, {
			field : 'ACB20D',
			title : '冻结人',
			width : '5%',
			align : 'center'
		}, {
			field : 'ACB20E',
			title : '冻结日期',
			width : '5%',
			align : 'center'
		}, {
			field : 'AAE019',
			title : '经办人',
			width : '5%',
			align : 'center'
		}, {
			field : 'AAE020',
			title : '经办机构',
			width : '5%',
			align : 'center'
		}, {
			field : 'BAE036',
			title : '经办日期',
			width : '5%',
			align : 'center'
		}, {
			field : 'BCB209',
			title : '数据来源',
			width : '5%',
			align : 'center'
		} ]);
		 
		$('#jobFairInfoList')
				.bootstrapTable(
						{
							url : '${ctx}/business/jobfair/corpPosition/corpPositionListJson.xf',
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
							queryParams : getSeachJson
						});
	})
	function edit(obj) {
		xfui.open_tabs("单位招聘信息维护",
				"${ctx}/business/jobfair/corpPosition/edit.xf?acb210=" + obj,
				"单位招聘信息维护");
	}
	function refresh() {
		$('#jobFairInfoList').bootstrapTable('refresh');
	}
	function getParentSelectValues() {
		var row = $('#jobFairInfoList').bootstrapTable('getAllSelections');
		var obj = '';
		$.each(row, function(i, e) {
			if (i == 0) {
				obj += e.ACB210;
			} else {
				obj += "," + e.ACB210;
			}

		});
		return obj;
	}

	function getSeachJson(params) {
		if(isDosearch){
			params.offset = 0;
			isDosearch = false;
		}
		return $("form").serialize()+"&limit="+params.limit+"&offset="+params.offset+"&order="+params.order;
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
	function getSelectTexts(objId) {
		var selectValueStr = '';
		$("#" + objId + " option:selected")
				.each(
						function() {
							selectValueStr = selectValueStr ? (selectValueStr
									+ "," + $(this).text().trim()) : $(this).text().trim();
						});
		if(selectValueStr=='全部'){
			return '';
		}
		return selectValueStr;
	}
    var isDosearch = false;
	function doSearch() {
		isDosearch = true;
		//多选框数据设置到隐藏域中
		$('.selectpicker').each(function() {
			var inputId = $(this).attr('id').replace('_select', '');
			$('#' + inputId).val(getSelectValues($(this).attr('id')));
		});
		$('#acc214').val(getSelectTexts('acc214_select'));
		$('#bcb201').val(getSelectTexts('bcb201_select'));
		$('#acb228').val(getSelectTexts('acb228_select'));
		$('#acb20l').val(getSelectTexts('acb20l_select'));
		$("#jobFairInfoList").bootstrapTable('refresh', {
			query : getSeachJson
		})
	}
	function doClear() {
		$('.selectpicker').selectpicker('val', '');
		$('.form-control').each(function(){
			if(!$(this).hasClass("selectpicker")){
				$(this).val('');
			}
		});
		$("#aae011").val('');
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
			bootbox.alert('请选择一条职位信息');
			return;
		}
		$.post('${ctx}/business/jobfair/corpPosition/delfreezeCorpPosition.xf',
				{
					'acb210' : getParentSelectValues()
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
			bootbox.alert('请选择一条职位信息');
			return;
		}
		xfui
				.open_dialog({
					title : '冻结招聘岗位',
					width : 500,
					height : 200,
					closed : false,
					cache : false,
					url : "${ctx}/business/jobfair/corpPosition/tofreezeCorpPosition.xf",
					modal : true
				})
	}
	function setUserMessageAdd(id, name) {
		$("#aae011").val(id);
		$("#bae011_view").val(name);
	}
	function clearUserMessageAdd() {
		$("#aae011").val('');
		$("#bae011_view").val('');
	}
	function viewUsers() {
		xfui.open_dialog({
			title : '用户选择列表',
			width : 1185,
			height : 690,
			closed : false,
			cache : false,
			url : "${ctx}/business/component/component/viewUsers.xf",
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
									<input id="startdate" name="startdate"
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
									<input id="enddate" name="enddate"
										class="form-control date-picker dp mhydatepicker" type="text"
										placeholder="请选择日期" name="beginaac006"> <span
										class="input-group-addon"> <i
										class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">机构信息:</label>
								<%-- <div class="col-xs-10 col-sm-8 mhyOrgId" id="selectDxdiv">
									<input type="hidden" name="aae017" id="aae017"> <select
										id="aae017_select" class="selectpicker form-control"
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
								<label class="col-xs-2 col-sm-4" for="inputError">数据来源:</label>
								<div class="col-xs-10 col-sm-8 mhyNoSelect">
									<xf:select id="cczy06_select" name="cczy06" textField="name"
										tableName="TAB_DATASOURCES" selectClass="form-control"
										valueField="code" isNoStyle="true" hasDefault="0"
										hasDefaultName="全部"></xf:select>
								</div>
							</div>

							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">单位名称:</label>
								<div class="col-xs-10 col-sm-8">
									<input class="form-control" type="text" name="aab004"
										id="aab004" data-placement="bottom">
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">部标行业:</label>
								<div class="col-xs-10 col-sm-8 mhyOrgId " id="selectDxdiv">
									<input type="hidden" name="aab022" id="aab022" /> <select
										id="aab022_select" class="selectpicker form-control"
										data-live-search="true" data-live-search-placeholder="Search"
										data-actions-box="true">
										<optgroup>
											<option value="">全部</option>
											<xf:select name="tab_industry" pidName="pcode" pidValue="0"
												textField="name" tableName="TAB_INDUSTRY" valueField="code"
												isOnlyOptions="true"></xf:select>
										</optgroup>
									</select>
								</div>
							</div>
						</div>
						<div class="row" style="display: none;">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">单位性质:</label>
								<div class="col-xs-10 col-sm-8">
									<xf:select name="aab019" id="aab019_select" textField="name"
										tableName="TAB_UNITNATURE" valueField="code"
										selectClass="form-control" isNoStyle="true" hasDefault="0"
										hasDefaultName="全部"></xf:select>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">产业类别:</label>
								<div class="col-xs-10 col-sm-8 ">
									<xf:select name="aab054" id="aab054_select"
										selectClass="form-control" isNoStyle="true" textField="name"
										tableName="TAB_INDUSTRYCLASSES" valueField="code"
										hasDefault="0" hasDefaultName="全部"></xf:select>

								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">经济类型:</label>
								<div class="col-xs-10 col-sm-8 mhyOrgId " id="selectDxdiv">
									<input type="hidden" name="aab020" id="aab020" /> <select
										id="aab020_select" class="selectpicker form-control"
										data-live-search="true" data-live-search-placeholder="Search"
										data-actions-box="true">
										<option value="">全部</option>
										<xf:select isOnlyOptions="true" name="funplat"
											textField="name" tableName="TAB_ECONOMIC" valueField="code"
											isNoStyle="true"></xf:select>
									</select>
								</div>
							</div>
						</div>
						<div class="row" style="display: none;">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">性别:</label>
								<div class="col-xs-10 col-sm-8">
									<xf:select name="aad004" selectClass="form-control"
										id="aab056n_select" isNoStyle="true" textField="name"
										tableName="TAB_SEX" hasDefault="0" hasDefaultName="全部"
										valueField="code"></xf:select>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">文化程度:</label>
								<div class="col-xs-10 col-sm-8">
									<xf:select name="aac011" textField="name"
										tableName="TAB_EDUCATION" selectClass="form-control"
										isNoStyle="true" valueField="code" hasDefault="0"
										hasDefaultName="全部"></xf:select>

								</div>
							</div>
								<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">福利待遇</label>
								<div class="col-xs-10 col-sm-8 mhyOrgId" id="selectDxdiv">
								<input type="hidden" name="acc214" id="acc214" />
									<select id="acc214_select" class="selectpicker"
											data-live-search="true" multiple="multiple"
											data-live-search-placeholder="Search" data-actions-box="true">
											<xf:select name="funt66" textField="name"
												tableName="TAB_WELFARE" valueField="code"
												isOnlyOptions="true"></xf:select>
										</select>
								</div></div>
						</div>
						<div class="row" style="display: none;">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">工作年限:</label>
								<div class="col-xs-10 col-sm-8">
									<xf:select name="acc217" textField="name" isNoStyle="true"
										tableName="TAB_WORKYEARS" selectClass="form-control"
										valueField="code" hasDefault="0" hasDefaultName="全部"></xf:select>

								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">人员规模:</label>
								<div class="col-xs-10 col-sm-8">
									<xf:select name="aab056" textField="name"
										tableName="TAB_PSCALE" selectClass="form-control"
										isNoStyle="true" valueField="code" hasDefault="0"
										hasDefaultName="全部"></xf:select>

								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">经办人:</label>
								<div class="col-xs-10 col-sm-8">
									<input name="aae011" type="hidden" id="aae011"> <input
										class="form-control" onclick="viewUsers()" readonly="true"
										type="text" name="bae011_view" id="bae011_view" />
								</div>
							</div>
						</div>
						<div class="row" style="display: none;">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">招聘方式:</label>
								<div class="col-xs-10 col-sm-8">
								    <input type="hidden" name="bcb201" id="bcb201"  />
									<xf:select name="bcb201_select" id="bcb201_select" textField="name" isNoStyle="true"
										tableName="TAB_JFFORM" selectClass="form-control"
										valueField="code" hasDefault="0" hasDefaultName="全部"></xf:select>

								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">职位名称:</label>
								<div class="col-xs-10 col-sm-8">
									<input class="form-control" type="text" name="aca112"
										id="aca112" data-placement="bottom">
								</div>
							</div>
								<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">食宿要求:</label>
								<div class="col-xs-10 col-sm-8">
								<input type="hidden" name="acb228" id="acb228"/>
									<xf:select name="acb228_select" id ="acb228_select" textField="name" isNoStyle="true"
										tableName="TAB_SREQUIREMENT" selectClass="form-control"
										valueField="code" hasDefault="0" hasDefaultName="全部"></xf:select>

								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">冻结标记:</label>
								<div class="col-xs-10 col-sm-8">
									<select class="form-control" name="acb208" id="acb208_select">
										<option value="">全部</option>
										<option value="未冻结">未冻结</option>
										<option value="已冻结">已冻结</option>
									</select>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								 <label class="col-xs-2 col-sm-4" for="inputError">冻结原因:</label>
								<div class="col-xs-10 col-sm-8">
								        <input name="acb20l" id="acb20l" type="hidden" />
										<xf:select name="acb20l_select" id ="acb20l_select" textField="name" isNoStyle="true"
										tableName="TAB_UFREASONS" selectClass="form-control"
										valueField="code" hasDefault="0" hasDefaultName="全部"></xf:select>
								</div>
							</div>
								<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">招聘人数:</label>
								<div class="col-xs-10 col-sm-3">
									<input class="form-control" name="minacb21r" type="number" />
								</div>
								<label class="col-xs-2 col-sm-2" style="text-align: center;"
									for="inputError">至</label>
								<div class="col-xs-10 col-sm-3">
									<input class="form-control" name="maxacb21r" type="number" />
								</div>
							</div>
								
						</div>
						<div class="row">

						<div class="col-xs-12 col-sm-12">
								
								<div class="col-xs-12 col-sm-12 mhyBtn">
									<a href="#modal-form" role="button" onclick="doSearch()"
										class="btn btn-primary btn-border1 mhyBtnLeft">
										<i class="icon-search"></i>
										查询
										</a> 
										<a href="#modal-form" class="btn btn-primary btn-border1 mhyBtnLeft" onclick="hideRows(2)" ><i id="view_class" class="icon-plus"></i>高级查询</a>
										<a
										href="#modal-form" role="button" onclick="doClear()"
										class="btn btn-info">
										<i class="icon-repeat"></i>
										重置
										</a>
								</div></div>
							</div></form>
						</div>
					
				</div>
				<div class="mhyMain"> 
				<div class="mhyTitle">查询结果</div>
				<div class="mhyInfo">
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
				$('#aab020_select').selectpicker({
					selectAllText : '全选',//全选的checkbox名称  
					deselectAllText : '取消',
					selectAllNumber : true,
					actionsBox : false,
					noneResultsText : "没有相关信息",liveSearchPlaceholder:"请输入搜索.."
				});
				$('#aae017_select').selectpicker({
					selectAllText : '全选',//全选的checkbox名称  
					deselectAllText : '取消',
					selectAllNumber : true,
					actionsBox : false,
					noneResultsText : "没有相关信息",liveSearchPlaceholder:"请输入搜索.."
				});
				$('#aab022_select').selectpicker({
					selectAllText : '全选',//全选的checkbox名称  
					deselectAllText : '取消',
					selectAllNumber : true,
					actionsBox : false,
					noneResultsText : "没有相关信息",liveSearchPlaceholder:"请输入搜索.."
				});
				$('#acc214_select').selectpicker({
					selectAllText : '全选',//全选的checkbox名称  
					deselectAllText : '取消',
					selectAllNumber : true,
					actionsBox : true,
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