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
<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" /> 
<link rel="stylesheet" href="${ctx}/assets/css/daterangepicker.css" />
<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/daterangepicker.css" />
<script src="${ctx}/js/lib/bootstrap-select/bootstrap-select.js"></script>
<link href="${ctx}/assets/css/bootstrap.min.css" rel="stylesheet" />
<link type="text/css" href="${ctx}/js/lib/bootstrap-select/bootstrap-select.css" rel="stylesheet" />
<link rel="stylesheet" href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css" type="text/css" />
<title>求职信息查询</title>
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
	$(function() {
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
			actionsBox : false,
			noneResultsText : "没有相关信息",liveSearchPlaceholder:"请输入搜索.."
		});
		$("#aae017n").treeorg({callBack:function(data){
			$("#aae017n").val(data.orgName);
			$("#aae017").val(data.orgId);
			}
		});
		/**
		 初始化表格显示
		 */
		var columns = [ {
			field : 'AAC003',
			title : '姓名',
			width : '5%',
			align : 'center'
		}, {
			field : 'AAC004',
			title : '性别',
			width : '5%',
			align : 'center'
		}, {
			field : 'AAC005',
			title : '民族',
			width : '6%',
			align : 'center'
		}, {
			field : 'AAC006',
			title : '出生日期',
			width : '6%',
			align : 'center'
		}, {
			field : 'AAC011',
			title : '文化程度',
			width : '6%',
			align : 'center'
		},

		{
			field : 'AAC002',
			title : '身份证号',
			width : '5%',
			align : 'center'
		}, {
			field : 'AAE005',
			title : '联系电话',
			width : '5%',
			align : 'center'
		}, 
		 {
			field : 'ACB208',
			title : '冻结标记',
			width : '5%',
			align : 'center'
		},
		{
			field : 'BCA112',
			title : '意愿职位1',
			width : '10%',
			align : 'center'
		}, {
			field : 'BCC20C',
			title : '意愿职位说明1',
			width : '10%',
			align : 'center'
		}, {
			field : 'BCAA12',
			title : '意愿职位2',
			width : '10%',
			align : 'center'
		}, {
			field : 'BCC20D',
			title : '意愿职位说明2',
			width : '10%',
			align : 'center'
		}, {
			field : 'BCAB12',
			title : '意愿职位3',
			width : '10%',
			align : 'center'
		}, {
			field : 'BCC20E',
			title : '意愿职位说明3',
			width : '10%',
			align : 'center'
		}, {
			field : 'AAE043',
			title : '登记日期',
			width : '7%',
			align : 'center'
		}, {
			field : 'ACE014',
			title : '有效日期',
			width : '7%',
			align : 'center'
		}
		, {
			field : 'AAE020',
			title : '经办机构',
			width : '7%',
			align : 'center'
		}
		, {
			field : 'AAE019',
			title : '经办人',
			width : '7%',
			align : 'center'
		}
		, {
			field : 'AAE036',
			title : '经办日期',
			width : '7%',
			align : 'center'
		}
		, {
			field : 'BCB209',
			title : '数据来源',
			width : '7%',
			align : 'center'
		}
		// 	                ,{field:'acb330',title:'操作',width:100,formatter: function(value,row,index){	 
		// 				           return "<a href=\"javascript:void(0)\" onclick=\"editJobFairInfo('"+value+"')\" >编辑</a>|"+
		// 								"<a href=\"javascript:void(0)\" onclick=\"delJobFairInfo('"+value+"')\" >删除</a>";
		// 							}
		// 					 }
		];
		$('#jobFairInfoList').bootstrapTable({
			url : '${ctx}/business/person/personBaseInfo/listJsonView.xf',
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
	function addJobFairInfo() {
		xfui.open_dialog({
			title : '新增招聘会信息',
			width : 800,
			height : 500,
			closed : false,
			cache : false,
			url : "${ctx}/business/jobfair/jobFairInfo/add.xf",
			modal : true
		})
	}
	function editJobFairInfo() {
		var row = $('#jobFairInfoList').datagrid('getSelected');
		if (row) {
			var acb330 = row.acb330;
			//xfui.open_tabs("编辑人员","${ctx}/sys/uums/sysUser/edit.xf?acd230="+acd230,"人员管理");
			xfui.open_dialog({
				title : '编辑招聘会信息',
				width : 800,
				height : 500,
				closed : false,
				cache : false,
				url : "${ctx}/business/jobfair/jobFairInfo/edit.xf?acb330="
						+ acb330,
				modal : true
			})
		} else {
			$.messager.alert('提示', '请选择记录');
		}
	}

	function delJobFairInfo() {
		var row = $('#jobFairInfoList').datagrid('getSelections');
		if (row && row.length > 0) {
			var acb330 = "";
			$.each(row, function(i, e) {
				if (i == 0) {
					acb330 += e.acb330;
				} else {
					acb330 += "," + e.acb330;
				}

			});
			$.messager.confirm('确认', '您确认想要删除记录吗？', function(r) {
				if (r) {
					$.ajax({
						url : '${ctx}/business/jobfair/jobFairInfo/del.xf',
						data : {
							acb330 : acb330
						},
						dataType : 'json',
						success : function(data) {
							if (data.message) {
								$.messager.alert('提示', data.message);
							} else {
								$.messager.alert('提示', "未知错误");
							}

							refresh();
						}
					});
				}
			});
		} else {
			$.messager.alert('提示', '请选择记录');
		}
	}
	function refresh() {
		$('#jobFairInfoList').bootstrapTable('refresh');
	}
	function getSeachJson(params) {
		if(isDosearch){
			params.offset = 0;
			isDosearch = false;
		}
		return $("form").serialize() + "&limit=" + params.limit + "&offset="
				+ params.offset + "&order=" + params.order;
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
	var isDosearch = false;
	function doSearch() {
		//多选框数据设置到隐藏域中
		$('.selectpicker').each(function() {
			var inputId = $(this).attr('id').replace('_select', '');
			$('#' + inputId).val(getSelectValues($(this).attr('id')));
		});
		isDosearch = true;
		$("#jobFairInfoList").bootstrapTable('refresh', {
			query : getSeachJson
		})
	}
	function doClear() {
		$('.selectpicker').selectpicker('val', '');
		$('.form-control').each(function() {
			if (!$(this).hasClass("selectpicker")) {
				$(this).val('');
			}
		});
		$("#aae011").val('');
		resetForm("searchForm");
	}
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="mhyBody">
			<div class="mhySearch">
				<div class="mhyTitle">查询条件</div>
				<form id="searchForm" class="mhySearchInput">
					<div class="form-group">
						<!-- 						<div class="row"> -->
						<!-- 							<div class="col-sm-3 marginbottom20"> -->
						<!-- 								<input class="form-control" id="searchText" type="text" -->
						<!-- 									name="Q_findKeyword_SL" placeholder="姓名/身份证号/联系电话/经办机构1" -->
						<!-- 									title="姓名/身份证号/联系电话/经办机构1" data-placement="bottom" /> -->
						<!-- 							</div> -->
						<!-- 						</div> -->
						<div class="row">
						<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">机构信息:</label>
<!-- 								<input type="hidden" name="aae017" id="aae017" /> -->
<!-- 								<div class="col-xs-10 col-sm-8 mhyOrgId" id="selectDxdiv"> -->
<!-- 									<select id="aae017_select" class="selectpicker form-control" -->
<!-- 										data-live-search="true" data-live-search-placeholder="Search" -->
<!-- 										data-actions-box="true"> -->
										
<!-- 									</select> -->
<!--                                     <ul id="articleColumnTree" class="ztree" data-toggle="context" ></ul> -->
<!-- 								</div> -->
								<div class="col-xs-9 col-sm-8 ">
												<input id="aae017" name="aae017" type="hidden"></input>  
												<input class="form-control" id="aae017n" name="aae017n" type="text"  readonly="true" ></input>  
									</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">数据来源:</label>
								<div class="col-xs-10 col-sm-8 mhyNoSelect">
									<xf:select id="bcb209_select" name="bcb209" textField="name"
										tableName="TAB_DATASOURCES" selectClass="form-control"
										valueField="code" isNoStyle="true" hasDefault="0"
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
						<div class="row">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">姓名:</label>
								<div class="col-xs-10 col-sm-8">
									<input class="form-control" type="text" name="aac003"
										id="aac003_id" data-placement="bottom">
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">身份证:</label>
								<div class="col-xs-10 col-sm-8">
									<input class="form-control" type="text" name="aac002"
										id="aac002_id" data-placement="bottom">
								</div>
							</div>
						<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">求职区域:</label>
								<div class="col-xs-10 col-sm-8">
									<input class="form-control" type="text" name="bcb202"
										id="aac003_id" data-placement="bottom">
								</div>
							</div>
						</div>
						<div class="row">
				
								<div class="col-xs-12 col-sm-4" style="height: 32px;">
								<label class="col-xs-2 col-sm-4" for="inputError">经办日期:</label>
								<div class="col-xs-10 input-group col-sm-8"
									style="padding-left: 15px">
									<input id="startdate" name="startdate"
										class="form-control date-picker dp mhydatepicker" type="text"
										placeholder="请选择经办最小日期" name="beginaac006"> <span
										class="input-group-addon"> <i
										class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4" style="height: 32px;">
								<label class="col-xs-2 col-sm-4" for="inputError">经办日期:</label>
								<div class="col-xs-10 input-group col-sm-8"
									style="padding-left: 15px">
									<input id="enddate" name="enddate"
										class="form-control date-picker dp mhydatepicker" type="text"
										placeholder="请选择经办最大日期" name="beginaac006"> <span
										class="input-group-addon"> <i
										class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
								<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">意愿职位名称:</label>
								<div class="col-xs-10 col-sm-8">
									<input class="form-control" type="text" name="bca112"
										id="bca112_id" data-placement="bottom">
								</div>
							</div>
						</div>
						<div class="row" style="display: none;">
									<div class="col-xs-12 col-sm-4" style="height: 32px;">
								<label class="col-xs-2 col-sm-4" for="inputError">出生日期:</label>
								<div class="col-xs-10 input-group col-sm-8"
									style="padding-left: 15px">
									<input  name="minaac006"
										class="form-control date-picker dp mhydatepicker" type="text"
										placeholder="请选择出生最小日期" name="beginaac006"> <span
										class="input-group-addon"> <i
										class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4" style="height: 32px;">
								<label class="col-xs-2 col-sm-4" for="inputError">出生日期:</label>
								<div class="col-xs-10 input-group col-sm-8"
									style="padding-left: 15px">
									<input   name="maxaac006"
										class="form-control date-picker dp mhydatepicker" type="text"
										placeholder="请选择出生最大日期" name="beginaac006"> <span
										class="input-group-addon"> <i
										class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">政治面貌:</label>
								<div class="col-xs-10 col-sm-8">
									<xf:select name="aac024" textField="name" tableName="TAB_AFFIL"
										selectClass="form-control" isNoStyle="true" valueField="code"
										hasDefault="0" hasDefaultName="全部"></xf:select>
								</div>
							</div>
						</div>
						<div class="row" style="display: none;">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">健康状况:</label>
								<div class="col-xs-10 col-sm-8">
									<xf:select name="aac033" textField="name"
										tableName="TAB_HEALTH" selectClass="form-control"
										isNoStyle="true" valueField="code" hasDefault="0"
										hasDefaultName="全部"></xf:select>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">婚姻状况:</label>
								<div class="col-xs-10 col-sm-8">
									<xf:select name="aac017" textField="name"
										tableName="TAB_MARRIAGE" selectClass="form-control"
										isNoStyle="true" valueField="code" hasDefault="0"
										hasDefaultName="全部"></xf:select>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">登记类别:</label>
								<div class="col-xs-10 col-sm-8">
									<xf:select name="acc201" textField="name"
										tableName="TAB_REGTYPE" selectClass="form-control"
										isNoStyle="true" valueField="code" hasDefault="0"
										hasDefaultName="全部"></xf:select>
								</div>
							</div>
						</div>
						<div class="row" style="display: none;">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">性别:</label>
								<div class="col-xs-10 col-sm-8">
									<xf:select name="aac004" selectClass="form-control"
										id="aac004_select" isNoStyle="true" textField="name"
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
								<label class="col-xs-2 col-sm-4" for="inputError">食宿要求:</label>
								<div class="col-xs-10 col-sm-8">
									<xf:select name="acb228" textField="name" isNoStyle="true"
										tableName="TAB_SREQUIREMENT" selectClass="form-control"
										valueField="code" hasDefault="0" hasDefaultName="全部"></xf:select>

								</div>
							</div>
						</div>
						<div class="row" style="display: none;">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">证书:</label>
								<div class="col-xs-10 col-sm-8">
									<xf:select name="bcc02i" textField="name" isNoStyle="true"
										tableName="TAB_CERFORM" selectClass="form-control"
										valueField="code" hasDefault="0" hasDefaultName="全部"></xf:select>

								</div>
							</div>
								<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">户口性质:</label>
								<div class="col-xs-10 col-sm-8">
									<xf:select name="aac009" textField="name"
										tableName="TAB_CATEGORY" selectClass="form-control"
										isNoStyle="true" valueField="code" hasDefault="0"
										hasDefaultName="全部"></xf:select>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">月工资:</label>
								<div class="col-xs-10 col-sm-8">
									<xf:select name="acc034" textField="name"
										tableName="TAB_SALARY" selectClass="form-control"
										isNoStyle="true" valueField="code" hasDefault="0"
										hasDefaultName="全部"></xf:select>
								</div>
							</div>
						</div>
						<div class="row" >
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">冻结标记:</label>
								<div class="col-xs-10 col-sm-8">
									<select class="form-control" name="acb208" id="acb208_select">
										<option value="">全部</option>
										<option value="0">未冻结</option>
										<option value="1">已冻结</option>
									</select>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">登记方式:</label>
								<div class="col-xs-10 col-sm-8">
									<select class="form-control" name="bcb207n" id="bcb207n_select">
										<option value="">全部</option>
										<option value="个人求职添加">个人求职添加</option>
										<option value="达成意向添加">达成意向添加</option>
									</select>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4 mhyBtn">
								<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary btn-border1 mhyBtnLeft">
									<i class="icon-search"></i>查询
								</a>
								<a href="#modal-form" class="btn btn-primary btn-border1 mhyBtnLeft" onclick="hideRows(2)" ><i id="view_class" class="icon-plus"></i>高级查询</a>
								<a href="#modal-form" role="button" onclick="doClear()"	class="btn btn-info">
									<i class="icon-repeat"></i>重置
								</a>
							</div>

						</div>
					</div>
				</form>
			</div>
			<div class="mhyMain">
				<div class="mhyTitle">查询结果</div>
				<div class="mhyInfo mhyConter">
					<table id="jobFairInfoList" class="tableClassNoworks table-striped"></table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


