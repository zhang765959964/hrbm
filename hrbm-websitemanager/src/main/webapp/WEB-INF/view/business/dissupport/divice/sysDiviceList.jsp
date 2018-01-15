<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>设备表管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp"%>
<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<script src="${ctx}/js/lib/bootstrap-select/bootstrap-select.js"></script>
<link type="text/css"
	href="${ctx}/js/lib/bootstrap-select/bootstrap-select.css"
	rel="stylesheet" />
<script>
	$(function() {
		changeSty001();
		/**
		 初始化表格显示
		 */
		var columns = [{
			field : 'DIV001',
			title : '操作',
			width : '10%',
			formatter : function(value, row, index) {
				return "<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"editRow('"
						+ value + "')\" ><i class='icon-pencil' title='编辑'></i></a>"
			}
		},
				{
					field : 'ACD202',
					title : '所属机构',
					width : '10%',
					align : 'left'
				},
				
				{
					field : 'MOD002',
					title : '所属型号',
					width : '10%',
					align : 'left'
				},
				{
					field : 'MOD003',
					title : '所属样式',
					width : '10%',
					align : 'left'
				},
				{
					field : 'DIV012',
					title : '设备编号',
					width : '10%',
					align : 'left'
				},
				{
					field : 'DIV002',
					title : '设备名称',
					width : '10%',
					align : 'left'
				},
				{
					field : 'DIV014N',
					title : '设备类型',
					width : '10%',
					align : 'left'
				},
				{
					field : 'DIV018',
					title : '机器码',
					width : '10%',
					align : 'left'
				},
				{
					field : 'div019',
					title : '授权码',
					width : '10%',
					align : 'left'
				},
				{
					field : 'DIV016N',
					title : '显示机制',
					width : '10%',
					align : 'left'
				},
				{
					field : 'DIV021N',
					title : '运行模式',
					width : '10%',
					align : 'left'
				},
				{
					field : 'DIV003',
					title : '设备管理员',
					width : '10%',
					align : 'left'
				},
				{
					field : 'DIV004',
					title : '管理员电话',
					width : '10%',
					align : 'left'
				},
				{
					field : 'DIV005',
					title : '最后读取时间',
					width : '10%',
					align : 'left'
				},
				{
					field : 'DIV006',
					title : '设备运行时间',
					width : '10%',
					align : 'left'
				},
				{
					field : 'DIV007',
					title : '摆放位置',
					width : '10%',
					align : 'left'
				},
				{
					field : 'AAE013',
					title : '备注信息',
					width : '10%',
					align : 'left'
				},
				{
					field : 'AAE019',
					title : '经办人',
					width : '10%',
					align : 'left'
				},
				{
					field : 'AAE020',
					title : '经办机构',
					width : '10%',
					align : 'left'
				},
				{
					field : 'AAE036',
					title : '经办时间',
					width : '10%',
					align : 'left'
				},
				{
					field : 'DIV001',
					title : '设备ID号',
					width : '10%',
					align : 'left'
				} ];
		$('#sysDiviceList').bootstrapTable({
			url : '${ctx}/business/dissupport/divice/sysDivice/listJson.xf',
			columns : columns,
			method : "post",
			contentType : "application/x-www-form-urlencoded",
			pagination : true,
			pageSize : 10,
			pageList : [ 10, 15, 20 ],
			clickToSelect : true,
			sidePagination : "server",
			striped : true,
		});

	})
	function getSeachJson(params) {
		return {
			'limit' : params.limit,
			'offset' : params.offset,
			'order' : params.order,
			'div002' : $("#div002").val()
		};
	}
	function addSysDivice() {
		xfui.open_dialog({
			title : '新增设备信息',
			width : 960,
			height : 480,
			closed : false,
			cache : true,
			url : "${ctx}/business/dissupport/divice/sysDivice/add.xf",
			modal : true
		})
	}
	function editRow(obj){
		xfui.open_dialog({
			title : '编辑设备信息',
			width : 960,
			height : 480,
			closed : false,
			cache : true,
			url : "${ctx}/business/dissupport/divice/sysDivice/edit.xf?div001="+ obj,
			modal : true
		})
	}
	function editSysDivice() {
		var row = $('#sysDiviceList').bootstrapTable('getAllSelections');
		if (row && row.length > 0) {
			var div001 = row[0].div001;
			xfui.open_dialog({
						title : '编辑设备信息',
						width : 960,
						height : 480,
						closed : false,
						cache : true,
						url : "${ctx}/business/dissupport/divice/sysDivice/edit.xf?div001="
								+ div001,
						modal : true
					})
		} else {
			bootbox.alert('请选择记录');
		}
	}

	function delSysDivice() {
		var row = $('#sysDiviceList').bootstrapTable('getAllSelections');
		if (row && row.length > 0) {
			var div001 = "";
			$.each(row, function(i, e) {
				if (i == 0) {
					div001 += e.div001;
				} else {
					div001 += "," + e.div001;
				}

			});
			bootbox
					.confirm({
						message : '您确认想要删除记录吗？',
						callback : function(r) {
							if (r) {
								$
										.ajax({
											url : '${ctx}/business/dissupport/divice/sysDivice/del.xf',
											data : {
												div001 : div001
											},
											dataType : 'json',
											success : function(data) {
												if (data.message) {
													bootbox.alert(data.message);
												} else {
													bootbox.alert("未知错误");
												}

												refresh();
											}
										});
							}
						}
					});
		} else {
			bootbox.alert('请选择记录');
		}
	}
	function refresh() {
		$('#sysDiviceList').bootstrapTable('refresh');
	}
	function doSearch() {
		var json = $("#searchForm").serializeJson();
		alert(json);
		$("#sysDiviceList").bootstrapTable("refresh", {
			query : json
		});
	}
	function changeSty001() {
		$
				.ajax({
					url : '${ctx}/business/dissupport/divice/diviceStyle/listStyleJson.xf',
					data : {
						'mod001' : $("#mod001").val()
					},
					dataType : 'json',
					success : function(data) {
						$("#sty001").empty();
						var option = $("<option>").val("").text("全部");
						$("#sty001").append(option);
						if (data) {
							$.each(data, function(i, value) {
								var option = $("<option>").val(value.sty001)
										.text(value.sty003);
								$("#sty001").append(option);
							});
						}
						$('#sty001').selectpicker('refresh');
					},
					error : function() {
						bootbox.alert('加载设备型号信息失败');
					}
				});
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
							<label class="col-xs-3 col-sm-2" for="inputError">所属机构:</label>
							<div class="col-xs-9 col-sm-2 mhyOrgId " id="selectDxdiv">
								<select id="org_select" name="acd200"
									class="form-control selectpicker" data-live-search="true"
									data-live-search-placeholder="Search" data-actions-box="true">
									<optgroup>
										<option value="">全部</option>
										<c:forEach items="${orgs}" begin="0" var="objOrg">
											<option value="${objOrg.acd200}">${objOrg.acd202}</option>
										</c:forEach>
									</optgroup>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">所属型号:</label>
							<div class="col-xs-9 col-sm-2 mhyOrgId " id="selectDxdiv">
								<select id="mod001" name="mod001"
									class="form-control selectpicker" onchange="changeSty001()"
									data-live-search="true" data-live-search-placeholder="Search"
									data-actions-box="true">
									<optgroup>
										<option value="">全部</option>
										<c:forEach items="${models}" begin="0" var="objOrg">
											<option value="${objOrg.mod001}">${objOrg.mod002}</option>
										</c:forEach>
									</optgroup>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">中心样式:</label>
							<div class="col-xs-9 col-sm-2 mhyOrgId " id="selectDxdiv">
								<select id="sty001" name="sty001"
									class="form-control selectpicker" data-live-search="true"
									data-live-search-placeholder="Search" data-actions-box="true">
								</select>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">设备类型:</label>
							<div class="col-xs-9 col-sm-2 mhyOrgId " id="selectDxdiv">
								<select id="div014" name="div014"
									class="form-control selectpicker" data-live-search="true"
									data-live-search-placeholder="Search" data-actions-box="true">
									<option value="">全部</option>
									<xf:select name="div014" isNoStyle="true" isOnlyOptions="true"
										textField="TYPE_NAME" tableName="DEV_TYPE"
										valueField="TYPE_ID"></xf:select>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">设备名称:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="div002"
									id="div002" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">设备管理员:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" id="div003"
									name="div003" data-placement="bottom" />
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">管理员电话:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="div004"
									data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">机器码:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="div018"
									data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">授权码:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="div019"
									data-placement="bottom" />
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">运行模式:</label>
							<div class="col-xs-9 col-sm-2 required">
								<select class="form-control" id="div021" name="div021">
									<option value="">全部</option>
									<option value="0">无</option>
									<option value="1">招聘会模式</option>
									<option value="2">户外模式</option>
									<option value="3">面试模式</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">是否禁用:</label>
							<div class="col-xs-9 col-sm-2">
									<select class="form-control" id="div010" name="div010">
									<option value="">全部</option>
									<option value="T">是</option>
									<option value="F">否</option>
								</select>
							</div>
							<div class="col-xs-9 col-sm-4 mgb20 tar pdx20 mhyBtn">
								<a href="#" role="button" onclick="doSearch()"
									class="btn btn-primary btn-border1 mhyBtnLeft">
									<i class="icon-search"></i>
									查询</a>
								<!-- 								<a href="javascript:void(0)" class="btn btn-primary highSearch" >高级查询</a> -->
								<a href="#modal-form" role="button" class="btn btn-info">
								<i class="icon-repeat"></i>
								重置</a>
							</div>
						</div>
					</form>

				</div>
				<div class="mhyMain">
					<div class="mhyTitle">查询结果</div>
					<div class="mhyInfo">
						<div class="mgy10">
							<a href="javascript:void(0)" onclick="addSysDivice()"
								role="button" class="btn btn-primary" data-toggle="modal">
								<i class="icon-plus"></i>
								添加</a>

							<!-- 						<a href="javascript:void(0)" onclick="editSysDivice()" role="button" class="btn btn-info" data-toggle="modal"><i class="icon-pencil align-top"></i>修改</a> -->
							<!-- 						<a href="javascript:void(0)"  onclick="delSysDivice()" role="button" class="btn btn-danger" ><i class="icon-trash align-top"></i>移除</a> -->
							<!-- 						<a href="javascript:void(0)"  role="button" class="btn  btn-light" ><i class="icon-edit align-top"></i>导入</a> -->
							<!-- 						<a href="javascript:void(0)"  role="button" class="btn btn-grey" ><i class="icon-external-link align-top"></i>导出</a> -->
						</div>
						<div class="row">
							<div class="col-xs-12">
								<div class="table-responsive tableClassNoworks">
									<table id="sysDiviceList" class="datagridClass">
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


