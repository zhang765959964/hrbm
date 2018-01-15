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
<script
	src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet"
	href="${ctx}/assets/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/daterangepicker.css" />
<script src="${ctx}/js/lib/bootstrap-select/bootstrap-select.js"></script>
<link type="text/css"
	href="${ctx}/js/lib/bootstrap-select/bootstrap-select.css"
	rel="stylesheet" />

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
			field : 'ACB210',
			title : '空位编号',
			width : '3%',
			align : 'center'
		}, {
			field : 'ACA112',
			title : '工种名称',
			width : '7%',
			align : 'center'
		}, {
			field : 'AAB004',
			title : '单位名称',
			width : '10%',
			align : 'center'
		} ]);
		 
		$('#jobFairInfoList')
				.bootstrapTable(
						{
							url : '${ctx}/business/component/component/corpPositionListJson.xf',
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
							 onDblClickRow :function(rowIndex, rowData){
							    	var parentIframe=xfui.getParentIframe();
									parentIframe.checkCorpPostionCallBack(rowIndex);
									closeItem();
								}
						});
	})
	function edit(obj) {
		xfui.open_tabs("单位招聘信息维护",
				"${ctx}/business/jobfair/corpPosition/edit.xf?acb210=" + obj,
				"单位招聘信息维护");
	}
	function closeItem() {
		xfui.closeDialog();
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
					<form id="searchForm" class="mhySearchInput">
				            	<div class="form-group">
								<div class="row">
									<div class="col-xs-12 col-sm-2"></div>
									<div class="col-xs-12 col-sm-6 marginbottom20">
									<label class="col-xs-2 col-sm-4">查询：</label>
									<div  class="col-xs-10 col-sm-8">
										<input class="form-control" id="searchText" type="text" name="Q_findKeyword_SL" placeholder="空位编号/单位名称/职位名称" title="空位编号/单位名称/职位名称" data-placement="bottom" />
									</div></div>
									<div class="col-xs-12 col-sm-4 mhySearchRight">
										<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary mhyBtnLeft" ><i class="icon-search"></i>查询</a>
										<a href="#modal-form" role="button" onclick="doClear()" class="btn btn-info" ><i class="icon-repeat"></i>重置</a>
									</div>
								</div>
							</div>
							</form>
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