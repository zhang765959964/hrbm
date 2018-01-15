<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>设备配置表管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp"%>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<script src="${ctx}/js/lib/bootstrap-select/bootstrap-select.js"></script>
<link type="text/css" href="${ctx}/js/lib/bootstrap-select/bootstrap-select.css" rel="stylesheet" />
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/daterangepicker.css" />
<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/ui/xf.treeorg.js?version=201609231008"></script>
<link rel="stylesheet" href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css" type="text/css"/>
<script>
	$(function() {
		$("#aae017n").treeorg({callBack:function(data){
			$("#aae017n").val(data.orgName);
			$("#aae017").val(data.orgId);
			}
		});
		initFormSubimt();
		$('.selectpicker').selectpicker({
			selectAllText : '全选',//全选的checkbox名称  
			deselectAllText : '取消',
			selectAllNumber : true,
			actionsBox : false,
			noneResultsText : "没有相关信息",liveSearchPlaceholder:"请输入搜索.."
		});
		$("#aab301n").selcity({defaultCode:410900,callBack:function(data){
			$("#aab301n").val(data.allname);
			$("#aab301").val(data.code);
			}
		});
		/**
		 初始化表格显示
		 */
		var columns = [ {
			field : '',
			title : '序号',
			width : '5%',
			align : 'center',
			formatter : function(value, row, index) {
				return index + 1;
			}
		}, {
			field : 'AAB004',
			title : '单位名称',
			width : '20%',
			align : 'center'
		}, {
			field : 'ACA112',
			title : '岗位名称',
			width : '15%',
			align : 'center'
		}, {
			field : 'ACC034',
			title : '月薪范围',
			width : '15%',
			align : 'center'
		}, {
			field : 'ACB21R',
			title : '招聘人数',
			width : '10%',
			align : 'center'
		}, {
			field : 'AAB040',
			title : '单位地址',
			width : '30%',
			align : 'center'
		}
		// 	                   ,{field:'CON001',title:'操作',width:'5%',align:'center',formatter: function(value,row,index){	 
		// 				           return "<a href=\"javascript:void(0)\" onclick=\"editDivi('"+value+"')\" >管理</a>"
		// 							}
		// 					 }
		];
		$('#diviConfigList')
				.bootstrapTable(
						{
							url : '${ctx}/business/dissupport/divice/diviConfig/corpPositionListJson.xf',
							columns : columns,
							method : "get",
							pagination : true,
							pageSize : 10,
							pageList : [ 10, 15, 20 ],
							clickToSelect : true,
							sidePagination : "server",
							striped : true
						});
	});
	function  getSeachJson(){
		//设置分页参数
		return getFormJson();
	}
    function viewUsers(){
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
    function viewUsersUpdate(){
		xfui.open_dialog({
			title : '用户选择列表',
			width : 1185,
			height : 690,
			closed : false,
			cache : false,
			url : "${ctx}/business/component/component/viewUsers.xf?utype=1",
			modal : true
		})
	}
	function addDiviConfig() {
		xfui.open_dialog({
			title : '新增设备配置表',
			width : 800,
			height : 500,
			closed : false,
			cache : false,
			url : "${ctx}/business/dissupport/divice/diviConfig/add.xf",
			modal : true
		})
	}
	function setUserMessageUpdate(id,name){
		$("#con229").val(id);
		$("#con229_view").val(name);
	}
	function setUserMessageAdd(id,name){
		$("#bae019").val(id);
		$("#bae011_view").val(name);
	}
	function clearUserMessageUpdate(){
		$("#con229").val('');
		$("#con229_view").val('');
	}
	function clearUserMessageAdd(){
		$("#bae019").val('');
		$("#bae011_view").val('');
	}
	function editDivi(obj) {
		xfui.open_tabs("发布信息管理",
				"${ctx}/business/dissupport/divice/diviConfig/edit.xf?con001="
						+ obj, "发布信息管理");
		// 	xfui.open_dialog({    
		//   		    title: '编辑设备配置表',    
		//   		    width: 800,    
		//   		    height: 500,    
		//   		    closed: false,    
		//   		    cache: false,    
		//   		    url: "${ctx}/business/dissupport/divice/diviConfig/edit.xf?con001="+obj,
		//   		    modal: true   
		//   		})
	}
	function editDiviConfig() {
		var row = $('#diviConfigList').bootstrapTable('getAllSelections');
		if (row && row.length > 0) {
			var con001 = row[0].con001;
			editDivi(con001);
		} else {
			bootbox.alert('请选择记录');
		}
	}

	function delDiviConfig() {
		var row = $('#diviConfigList').bootstrapTable('getAllSelections');
		if (row && row.length > 0) {
			var con001 = "";
			$.each(row, function(i, e) {
				if (i == 0) {
					con001 += e.con001;
				} else {
					con001 += "," + e.con001;
				}

			});
			bootbox
					.confirm({
						message : '您确认想要删除记录吗？',
						callback : function(r) {
							if (r) {
								$
										.ajax({
											url : '${ctx}/business/dissupport/divice/diviConfig/del.xf',
											data : {
												con001 : con001
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
		$('#diviConfigList').bootstrapTable('refresh');
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
	function getFormJson(){
		$('.selectpicker').each(function() {
			var inputId=$(this).attr('id').replace('_select','');
			$('#'+inputId).val(getSelectValues($(this).attr('id')));
		});
		var json = $("#diviConfigForm").serializeJson();
		return json;
	}
	function doClear() {
		$('.selectpicker').selectpicker('val','');
		$('#bae011').val("");
		$('#con229').val("");
		$('#bae011_view').val("");
		$('#con229_view').val("");
		$('#aab301').val("");		
		$('.form-control').each(function(){
			if(!$(this).hasClass("selectpicker")){
				$(this).val('');
			}
		});
		$('#aae017').val("");
		resetForm("searchForm");
	}
	function doSearch() {
		$('.selectpicker').each(function() {
			var inputId=$(this).attr('id').replace('_select','');
			$('#'+inputId).val(getSelectValues($(this).attr('id')));
		});

		var params=$("#diviConfigForm").serialize();
		$("#diviConfigList").bootstrapTable('refresh', {url:"${ctx}/business/dissupport/divice/diviConfig/corpPositionListJson.xf?"+params});
	}
	function initFormSubimt() {
		$('#diviConfigForm').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				con203 : {
					validators : {
						stringLength : {
							min : 0,
							max : 150
						}
					}
				},
				con210 : {
					validators : {
						stringLength : {
							min : 0,
							max : 150
						}
					}
				}
				,
				con213 : {
					validators : {
						stringLength : {
							min : 0,
							max : 150
						}
					}
				}
				,
				con221 : {
					validators : {
						stringLength : {
							min : 0,
							max : 150
						}
					}
				},
				con217 : {
					validators : {
						stringLength : {
							min : 0,
							max : 150
						}
					}
				}
				,
				con218 : {
					validators : {
						stringLength : {
							min : 0,
							max : 150
						}
					}
				},
				con219 : {
					validators : {
						stringLength : {
							min : 0,
							max : 150
						}
					}
				}
			}
		}).on('success.form.bv', function(e) {
			e.preventDefault();
			var $form = $(e.target);
			var bv = $form.data('bootstrapValidator');
			$.post($form.attr('action'), $form.serialize(), function(data) {
				$(".btn-submit").removeAttr("disabled");
				bootbox.alert({
					size : 'small',
					width : "100px",
					message : data.message,
					callback : function() {
						 //TODO NOTHING
					}
				})

			}, 'json'); 

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
					<form:form modelAttribute="diviConfigForm" method="post" action="${ctx}/business/dissupport/divice/diviConfig/save.xf"
						class="mhySearchInput">
						<form:hidden path="con001"></form:hidden>
						<form:hidden path="acd200"></form:hidden>
						<form:hidden path="div001"></form:hidden>
						<form:hidden path="con002"></form:hidden>
						<form:hidden path="con004"></form:hidden>
						<form:hidden path="con005"></form:hidden>
						<form:hidden path="con006"></form:hidden>
						<form:hidden path="con007"></form:hidden>
						<form:hidden path="con008"></form:hidden>
						<form:hidden path="con009"></form:hidden>
						<form:hidden path="con010"></form:hidden>
						<form:hidden path="con011"></form:hidden>
						<form:hidden path="con012"></form:hidden>
						<form:hidden path="con013"></form:hidden>
						<form:hidden path="con014"></form:hidden>
						<form:hidden path="con015"></form:hidden>
						<form:hidden path="con016"></form:hidden>
						<form:hidden path="con999"></form:hidden>
						<form:hidden path="aae013"></form:hidden>
						<form:hidden path="aae011"></form:hidden>
						<%-- <form:hidden path="aae017"></form:hidden> --%>
						<form:hidden path="aae036"></form:hidden>
						<form:hidden path="aae019"></form:hidden>
						<form:hidden path="aae020"></form:hidden>
						<form:hidden path="con202"></form:hidden>
						<form:hidden path="con212"></form:hidden>
						<form:hidden path="con214"></form:hidden>
						<form:hidden path="con215"></form:hidden>
						<form:hidden path="con099"></form:hidden>
						<form:hidden path="con299"></form:hidden>
						<form:hidden path="con017"></form:hidden>
						<form:hidden path="bae013"></form:hidden>
						<form:hidden path="bae020"></form:hidden>
						<form:hidden path="con018"></form:hidden>
						<form:hidden path="con019"></form:hidden>
						<form:hidden path="con020"></form:hidden>
						<form:hidden path="con021"></form:hidden>
						<form:hidden path="con022"></form:hidden>
						<form:hidden path="con024"></form:hidden>
						<form:hidden path="con025"></form:hidden>
						<form:hidden path="con026"></form:hidden>
						<form:hidden path="con027"></form:hidden>
						<form:hidden path="con028"></form:hidden>
						<form:hidden path="con031"></form:hidden>
						<form:hidden path="con032"></form:hidden>
						<form:hidden path="con033"></form:hidden>
						<form:hidden path="con227"></form:hidden>
						<form:hidden path="con228"></form:hidden>
						<form:hidden path="con230"></form:hidden>
						<form:hidden path="con034"></form:hidden>
						<form:hidden path="con232"></form:hidden>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">信息来源:</label>
							<div class="col-xs-9 col-sm-2 mhyOrgId " id="selectDxdiv">
								<form:hidden path="con216"></form:hidden>
								<select id="con216_select" class="form-control selectpicker"
									data-live-search="true" data-live-search-placeholder="Search"
									data-actions-box="true">
									<optgroup>
										<option value="">全部</option>
										<xf:select id="select_read" name="funplat" textField="name"
											tableName="TAB_DATASOURCES" valueField="code"
											isNoStyle="true" isOnlyOptions="true" hasDefault="0"
											hasDefaultName="全部"></xf:select>
									</optgroup>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">单位名称:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="text" path="con203"
									data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">单位地址:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="text" path="con210"
									data-placement="bottom" />
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
							<%-- <div class="col-xs-9 col-sm-2 mhyOrgId " id="selectDxdiv">
								<form:hidden path="bae017"></form:hidden>
								<select id="bae017_select" class="form-control selectpicker"
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
						<div class="col-xs-9 col-sm-2 mhyOrgId">
							<form:hidden path="bae017" id="aae017"></form:hidden>
							<input class="form-control" id="aae017n" name="aae017n" type="text" readonly="true"></input>  
						</div>
								<label class="col-xs-3 col-sm-2" for="inputError">招聘人数:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="text" path="con221"
									data-placement="bottom" />
							</div>
						<label class="col-xs-3 col-sm-2" for="inputError">联系人:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="text" path="con213"
									data-placement="bottom" />
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
							<div class="col-xs-9 col-sm-2">
								<div class="input-group" style="padding: 0 !important;">
									<form:input class="form-control" readonly="true" type="text"
										path="bae036" data-options="required:false"
										placeholder="请选择日期"></form:input>
									<span class="input-group-addon"> <i
										class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
							<div class="col-xs-9 col-sm-2">
								<form:hidden path="bae019"></form:hidden>
								<form:hidden path="bae011"></form:hidden>
								<input class="form-control" onclick="viewUsers()" value="${addName}" readonly="true" type="text" name="bae011_view" id="bae011_view"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">修改人:</label>
							<div class="col-xs-9 col-sm-2">
								<form:hidden path="con229"></form:hidden>
								<input class="form-control" onclick="viewUsersUpdate()" value="${updateName}" readonly="true" type="text" name="con229_view" id="con229_view"/>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">岗位编号:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="text" path="con217"
									data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">职位名称:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="text" path="con218"
									data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">职位说明:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="text" path="con219"
									data-placement="bottom" />
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">选择岗位:</label>
							<div class="col-xs-9 col-sm-2 mhyOrgId " id="selectDxdiv">
								<select id="con217_select" class="form-control selectpicker"
									data-live-search="true" data-live-search-placeholder="Search"
									data-actions-box="true">
									<optgroup>
										<option value="">全部</option>
										<xf:select name="ACA111" textField="name"
											tableName="TAB_CRAFT" isOnlyOptions="true" valueField="code"
											isNoStyle="true"></xf:select>
									</optgroup>
								</select>

							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select id="con220_read" name="con220"
									selectClass="form-control" textField="name" tableName="TAB_SEX"
									valueField="code" value="${diviConfigForm.con220}"
									isNoStyle="true" hasDefault="0" hasDefaultName="全部"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">年龄要求:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select id="con220_select" name="con222"
									selectClass="form-control" textField="name"
									tableName="TAB_AGES" valueField="code"
									value="${diviConfigForm.con222}" isNoStyle="true"
									hasDefault="0" hasDefaultName="全部"></xf:select>
							</div>
						</div>
						<div class="row">
						<label class="col-xs-3 col-sm-2" for="inputError">人员类别:</label>
							<div class="col-xs-9 col-sm-2 mhyOrgId " id="selectDxdiv">
								<form:hidden path="con224"></form:hidden>
								<select id="con224_select" class="form-control selectpicker"
									data-live-search="true" data-live-search-placeholder="Search"
									data-actions-box="true">
									<optgroup>
										<option value="">全部</option>
										<xf:select name="funplat" textField="name"
											tableName="TAB_STAFFTYPE" valueField="code" isNoStyle="true"
											isOnlyOptions="true"></xf:select>
									</optgroup>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">工作经验:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select id="con223_select" name="con223"
									selectClass="form-control" textField="name"
									tableName="TAB_WORKYEARS" valueField="code"
									value="${diviConfigForm.con223}" isNoStyle="true"
									hasDefault="0" hasDefaultName="全部"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">单位类型:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select id="con204_select" name="con204"
									selectClass="form-control" textField="name"
									tableName="TAB_DWTYPE" valueField="code"
									value="${diviConfigForm.con204}" isNoStyle="true"
									hasDefault="0" hasDefaultName="全部"></xf:select>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">行业类别:</label>
							<div class="col-xs-9 col-sm-2 mhyOrgId " id="selectDxdiv">
								<form:hidden path="con206"></form:hidden>
								<select id="con206_select" class="form-control selectpicker"
									data-live-search="true" data-live-search-placeholder="Search"
									data-actions-box="true">
									<option value="">全部</option>
									<xf:select name="con206" isOnlyOptions="true"
										selectClass="form-control" textField="name"
										tableName="TAB_INDUSTRY" valueField="code"
										value="${diviConfigForm.con206}" isNoStyle="true"
										hasDefault="0" hasDefaultName="全部"></xf:select>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">住宿提供:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select id="con208_select" name="con208"
									selectClass="form-control" textField="name"
									tableName="TAB_SREQUIREMENT" valueField="code"
									value="${diviConfigForm.con208}" isNoStyle="true"
									hasDefault="0" hasDefaultName="全部"></xf:select>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">工作性质:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select id="con207_select" name="con207"
									selectClass="form-control" textField="name"
									tableName="TAB_NATURE" valueField="code"
									value="${diviConfigForm.con207}" isNoStyle="true"
									hasDefault="0" hasDefaultName="全部"></xf:select>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">经济类型:</label>
							<div class="col-xs-9 col-sm-2 mhyOrgId " id="selectDxdiv">
								<form:hidden path="con205"></form:hidden>
								<select id="con205_select" class="form-control selectpicker"
									data-live-search="true" data-live-search-placeholder="Search"
									data-actions-box="true">
									<option value="">全部</option>
									<xf:select name="con205" selectClass="form-control"
										textField="name" tableName="TAB_ECONOMIC" valueField="code"
										value="${diviConfigForm.con205}" isOnlyOptions="true"
										isNoStyle="true"></xf:select>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">学历要求:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select id="con209_select" name="con209"
									selectClass="form-control" textField="name"
									tableName="TAB_EDUCATION" valueField="code"
									value="${diviConfigForm.con209}" isNoStyle="true"
									hasDefault="0" hasDefaultName="全部"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">月薪范围:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select id="con211_select" name="con211"
									selectClass="form-control" textField="name2"
									tableName="TAB_SALARY" valueField="code"
									value="${diviConfigForm.con211}" isNoStyle="true"
									hasDefault="0" hasDefaultName="全部"></xf:select>
							</div>
						</div>
						<div class="row">
<!-- 							<label class="col-xs-3 col-sm-2" for="inputError">单位所在地区:</label> -->
<!-- 							<div class="col-xs-9 input-group col-sm-2" -->
<!-- 								style="padding-left: 15px"> -->
<%-- 								<form:input path="con226" --%>
<%-- 									class="form-control date-picker dp mhydatepicker" --%>
<%-- 									readonly="true" type="text" placeholder="请选择日期" /> --%>
<!-- 								<span class="input-group-addon"> <i -->
<!-- 									class="icon-calendar bigger-110"></i></span> -->
<!-- 							</div> -->
							<label class="col-xs-3 col-sm-2" for="inputError">单位所在地区:</label>
									<div class="col-xs-9 col-sm-2 required">
												<input id="aab301" name="aab301" type="hidden"></input>  
												<input class="form-control" id="aab301n" name="aab301n" type="text"  readonly="true" ></input>  
									</div>
							<label class="col-xs-3 col-sm-2" for="inputError">招聘开始日期:</label>
							<div class="col-xs-9 input-group col-sm-2"
								style="padding-left: 15px">
								<form:input path="con225" readonly="true"
									class="form-control date-picker dp mhydatepicker" type="text"
									placeholder="请选择日期" />
								<span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i></span>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">招聘结束日期:</label>
							<div class="col-xs-9 input-group col-sm-2"
								style="padding-left: 15px">
								<form:input path="con226"
									class="form-control date-picker dp mhydatepicker"
									readonly="true" type="text" placeholder="请选择日期" />
								<span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i></span>
							</div>
						
							
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError"></label>
							<div class="col-xs-9 col-sm-2"></div>
							<div class="col-xs-9 col-sm-2"></div>
							<div class="col-xs-9 col-sm-6 mhyBtn">
								<a href="#" role="button" onclick="doSearch()"
									class="btn btn-primary btn-border1 mhyBtnLeft">
									<i class="icon-search"></i>
									查询</a> <button type="submit"
									role="button"  
									class="btn btn-primary mhyBtnLeft">
									<i class="icon-save"></i>
									保存设置</button> <button
									  role="button"  class="btn btn-border1 btn-info" type="button" onclick="doClear()">
									 <i class="icon-repeat"></i> 
									  重置</button>
							</div>
						</div>
					</form:form>
				</div>


				<div class="mhyMain">
					<div class="mhyTitle">查询结果</div>
					<div class="mhyInfo">
						<div class="mgy10">
							<!-- 						<a href="javascript:void(0)" onclick="addDiviConfig()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus align-top"></i>添加</a> -->
							<!-- 						<a href="javascript:void(0)" onclick="editDiviConfig()" role="button" class="btn btn-info" data-toggle="modal"><i class="icon-pencil align-top"></i>修改</a> -->
							<!-- 						<a href="javascript:void(0)"  onclick="delDiviConfig()" role="button" class="btn btn-danger" ><i class="icon-trash align-top"></i>移除</a> -->
							<!-- 						<a href="javascript:void(0)"  role="button" class="btn  btn-light" ><i class="icon-edit align-top"></i>导入</a> -->
							<!-- 						<a href="javascript:void(0)"  role="button" class="btn btn-grey" ><i class="icon-external-link align-top"></i>导出</a> -->
							<!-- <a href="javascript:void(0)" role="button" onclick="delCorp()" class="btn btn-danger" data-toggle="modal"><i class="icon-trash align-top"></i>删除</a> -->
						</div>
						<div class="row">
							<div class="col-xs-12">
								<div class="table-responsive">
									<table id="diviConfigList" class="datagridClass">
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
<script type="text/javascript">
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
	$("#bae036").datetimepicker({
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
</script>
</html>


