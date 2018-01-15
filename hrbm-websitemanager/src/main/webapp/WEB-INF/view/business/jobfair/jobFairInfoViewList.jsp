<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp"%>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />
<link rel="stylesheet" href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css" type="text/css">
<title>招聘会信息情况查询</title>
<script>
	$(function() {
		/**
		 初始化表格显示
		 */
		var columns = [ {
			field : 'acb331',
			title : '招聘会名称',
			width : 200,
			align : 'center'
		}, {
			field : 'acb332',
			title : '招聘会主题',
			width : 100,
			align : 'center'
		}, {
			field : 'acb337',
			title : '招聘会介绍',
			width : 100,
			align : 'center'
		}, {
			field : 'aab045',
			title : '主办单位',
			width : 100,
			align : 'center'
		},
		/* {field:'acb338',title:'承办单位代码',width:100,align:'center'},
		   {field:'aab301',title:'举办城市代码',width:100,align:'center'},
		   {field:'acb336',title:'举办城市',width:100,align:'center'}, */
		{
			field : 'acb333',
			title : '开始日期',
			width : 120,
			align : 'center',
			formatter : function(value, row, index) {
				return formateHouse(value);
			}
		}, {
			field : 'acb334',
			title : '结束日期',
			width : 120,
			align : 'center',
			formatter : function(value, row, index) {
				return formateHouse(value);
			}
		}, {
			field : 'aae004',
			title : '联系人',
			width : 80,
			align : 'center'
		}, {
			field : 'aae005',
			title : '联系人电话',
			width : 100,
			align : 'center'
		}, {
			field : 'acb335',
			title : '大会类型',
			width : 100,
			align : 'center',
			formatter : function(value, row, index) {
				if (value == 01)
					return '综合类';
				if (value == 02)
					return '下刚失业人员专场';
				if (value == 03)
					return '大中专毕业生专场';
				if (value == 04)
					return '残疾人专场';
				if (value == 05)
					return '技校毕业生专场';
				if (value == 06)
					return '农民工专场';
				if (value == 07)
					return '失业农民专场';
				if (value == 08)
					return '高级人才专场';
				return '其他';
			}
		}, {
			field : 'cb33_status',
			title : '大会状态',
			width : 80,
			align : 'center'
		}
		// 	                ,{field:'acb330',title:'操作',width:100,formatter: function(value,row,index){	 
		// 				           return "<a href=\"javascript:void(0)\" onclick=\"editJobFairInfo('"+value+"')\" >编辑</a>|"+
		// 								"<a href=\"javascript:void(0)\" onclick=\"delJobFairInfo('"+value+"')\" >删除</a>";
		// 							}
		// 					 }
		];
		$('#jobFairInfoList').bootstrapTable({
			url : '${ctx}/business/jobfair/jobFairInfo/listJsonView.xf',
			columns : columns,
			method : "get",
			pagination : true,
			pageSize : 10,
			pageList : [ 10, 15, 20 ],
			clickToSelect : true,
			singleSelect : false,
			sidePagination : "server",
			striped : true
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
		$('#userList').bootstrapTable('refresh');
	}
	function doSearch() {
		debugger;
		$('#searchText').val($.trim($('#searchText').val()));	
		var params=$("#searchForm").serialize();
		$("#jobFairInfoList").bootstrapTable('refresh', {url:"${ctx}/business/jobfair/jobFairInfo/listJsonView.xf?"+params});
	}
	function doClear() {
		$("#searchText").val('');
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
						<div class="row">
							<div class="col-sm-3 marginbottom20">
								<input class="form-control" id="searchText" type="text"
									name="Q_findKeyword_SL" placeholder="招聘会名称"
									title="姓名/账户名/联系电话" data-placement="bottom" />
							</div>
							<div class="col-sm-6 mhySearchRight">
								<a href="javascript:void(0)" role="button" onclick="doSearch()"
									class="btn btn-primary btn-border1 mhyBtnLeft">查询</a> <a
									href="#modal-form" role="button" onclick="doClear()"
									class="btn btn-primary btn-border1">重置</a>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="mhyMain">
				<div class="mhyTitle">查询结果</div>
				<div class="mhyInfo" >
					<table id="jobFairInfoList" class="datagridClass"></table>
				</div>
			</div> 
		</div>
	</div>
</body>
</html>


