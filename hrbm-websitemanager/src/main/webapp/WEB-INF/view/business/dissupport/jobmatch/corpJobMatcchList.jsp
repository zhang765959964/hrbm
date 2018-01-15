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
	function hideRows(obj) {
		var rows = $("form").find(".row");
		var cl = $("#view_class").attr('class');
		$("#view_class").attr('class',
				cl == 'icon-plus' ? 'icon-minus' : 'icon-plus');
		rows.each(function(index) {
			if (index > obj && index < rows.length - 2) {
				$(this).toggle("slow");
			}
		});
	}

	$(function() {
		/**
		 初始化表格显示
		 */
		var columns = [
				{
					field : 'ACB210',
					title : 'Id号',
					width : 100,
					align : 'center',
					visible : false
				},
				{
					field : 'status',
					title : '选择',
					checkbox : 'true',
					width : '5%',
					align : 'center'
				},
				{
					field : 'ACB2101',
					title : '操作',
					width : '5%',
					align : 'center',
					formatter : function(value, row, index) {
						return "<a class=\"mhyNoA\" href=\"javascript:void(0)\" onclick=\"edit('"
								+ row.ACB210
								+ "')\" ><i class=\"icon-pencil\" title=\"编辑\"></i></a>";
					}
				} ]
		var isEdit = '${isEdit}';
		if (!isEdit) {
			columns = [];
		}
		columns = columns.concat([ {
			field : 'status',
			title : '选择',
			radio : 'true',
			width : '2%',
			align : 'center',
			visible : true
		}, {
			field : 'ACC200',
			title : '求职登记号',
			width : '2%',
			align : 'center'
		}, {
			field : 'AAC002',
			title : '身份证号',
			width : '5%',
			align : 'center'
		},
		 {
			field : 'AAC003',
			title : '姓名',
			width : '5%',
			align : 'center'
		},
		 {
			field : 'AAC004',
			title : '性别',
			width : '5%',
			align : 'center'
		},
		 {
			field : 'AAC005',
			title : '民族',
			width : '5%',
			align : 'center'
		},
		 {
			field : 'AAC006',
			title : '出生日期',
			width : '5%',
			align : 'center'
		},
		{
			field : 'AAC009',
			title : '户口性质',
			width : '5%',
			align : 'center'
		},
		{
			field : 'AAC011',
			title : '文化程度',
			width : '5%',
			align : 'center'
		},
		{
			field : 'BAC014',
			title : '专业技术服务',
			width : '5%',
			align : 'center'
		},
		{
			field : 'AAC038',
			title : '外语语种',
			width : '5%',
			align : 'center'
		},
		{
			field : 'AAC039',
			title : '外语水平',
			width : '5%',
			align : 'center'
		},
		{
			field : 'AAE005',
			title : '联系电话',
			width : '5%',
			align : 'center'
		},
		{
			field : 'ACE014',
			title : '有效期',
			width : '5%',
			align : 'center'
		},
		{
			field : 'AAE019',
			title : '经办人',
			width : '5%',
			align : 'center'
		},
		{
			field : 'AAE020',
			title : '经办机构',
			width : '5%',
			align : 'center'
		},
		{
			field : 'AAE036',
			title : '经办日期',
			width : '5%',
			align : 'center'
		} 
		]);
		$('#jobFairInfoList')
				.bootstrapTable(
						{
							url : '${ctx}/business/dissupport/jobmatch/jobMatchCorpListJson.xf',
							columns : columns,
							method : "post",
							contentType : "application/x-www-form-urlencoded",
							pagination : true,
							pageSize : 10,
							pageList : [ 10, 15, 20 ],
							clickToSelect : true,
							singleSelect : true,
							sidePagination : "server",
							striped : true,
							height : 450,
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
		if (isDosearch) {
			params.offset = 0;
			isDosearch = false;
		}
		return $("form").serialize() + "&limit=" + params.limit + "&offset="
				+ params.offset + "&order=" + params.order + "&aac001="
				+ aac001;
	}
	function getSelectValues(objId) {
		var selectValueStr = '';
		$("#" + objId + " option:selected")
				.each(
						function() {
							selectValueStr = selectValueStr ? (selectValueStr
									+ "," + $(this).val().trim()) : $(this)
									.val().trim();
						});
		return selectValueStr;
	}
	function getSelectTexts(objId) {
		var selectValueStr = '';
		$("#" + objId + " option:selected")
				.each(
						function() {
							selectValueStr = selectValueStr ? (selectValueStr
									+ "," + $(this).text().trim()) : $(this)
									.text().trim();
						});
		if (selectValueStr == '--请选择--') {
			return '';
		}
		return selectValueStr;
	}
	var isDosearch = false;
	function doSearch() {
		if (acb210) {
		} else {
			bootbox.alert("请选择单位信息");
		}
		isDosearch = true;
		//多选框数据设置到隐藏域中
		$('.selectpicker').each(function() {
			var inputId = $(this).attr('id').replace('_select', '');
			$('#' + inputId).val(getSelectValues($(this).attr('id')));
		});
 
		$("#jobFairInfoList").bootstrapTable('refresh', {
			url : '${ctx}/business/dissupport/jobmatch/jobMatchCorpListJson.xf',
			query : getSeachJson
		})
	}
	function doClear() {
		$('.selectpicker').selectpicker('val', '');
		$('.form-control').each(
				function() {
					if (!$(this).hasClass("selectpicker")
							&& $(this).attr("id") != "aac002_view") {
						if (!$(this).attr("readonly"))
							$(this).val('');
					}

				});
		$("#aab004_view").val('');
		$("#aae011").val('');
		$("#aab001").val('');
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
			title : '个人基本信息检索',
			width : "95%",
			height : 600,
			closed : false,
			cache : false,
			url : "${ctx}/business/component/component/viewUsers.xf",
			modal : true
		})
	}
	var acb210 = '';
	var acc200 = '';
	var corpPostionData = '';
    var aac001 = '';
    var personData = '';
    function checkAac001CallBack(row){
    	personData = row;
    	$("#aac002_view").val(row.AAC002);
    	
    }
	//单位招聘信息返回回调函数
	function checkCorpPostionCallBack(row) {
		acb210 = row.ACB210;
		$("#acb210_hidden").val(acb210);
		//设置个人基本信息
		$("#aab004_view").val(row.AAB004);
		$("#aab007").val(row.AAB007);
		 $("#aab003n").val(row.AAB003N);
		 $("#bcb201").val(row.BCB201);
		 $("#acb200").val(row.ACB200);
		 $("#acb210").val(row.ACB210);
		 $("#eaae030").val(row.EAAE030);
		 $("#eaae031").val(row.EAAE031);
		 //工种及待遇
		 $("#aca112").val(row.ACA112);
		 $("#acb21r").val(row.ACB21R);
		 $("#aad004").val(row.AAD004);
		 
		 $("#acb228").val(row.ACB228);
		 $("#acc214").val(row.ACC214);
		 $("#acc214").attr("title",row.ACC214);
		 $("#acc034").val(row.ACC034);
		 $("#bcb202").val(row.BCB202);
		 if(row.BCB202){
			 $("#bcb202").attr("title",row.BCB202);
		 }
		 $("#acc217").val(row.ACC217);
		 $("#acc20t").val(row.ACC20T);
		 $("#aac011").val(row.AAC011);
		 $("#acb222").val(row.ACB222);
		 $("#acb221").val(row.ACB221);
		 $("#cca114").val(row.CCA114);
		 $("#cca113").val(row.CCA113);
		 $("#cca112").val(row.CCA112);
		 
		 corpPostionData = row;
	}
	
	//求职人员查询列表
	function viewAc001() {
		xfui.open_dialog({
			title : '个人基本信息检索',
			width : "95%",
			height : "600",
			closed : false,
			cache : false,
			url : "${ctx}/business/component/component/personBaseList.xf",
			modal : true
		})
	}
	
	function viewDetail() {
		if (acb210) {
			xfui.open_dialog({
						title : '招聘信息详细信息',
						width : "95%",
						height : "600",
						closed : false,
						cache : false,
						resizable:true,						
						url : "${ctx}/business/dissupport/jobmatch/personJobRecommend/corpPostionView.xf?acb210="+ acb210,
						modal : true
					});
		} else {
			bootbox.alert("请选择单位信息");
		}
	}
	//求职人员查询列表
	function viewCorpPostion() {
		xfui
				.open_dialog({
					title : '招聘信息检索',
					width : "95%",
					height : 600,
					closed : false,
					cache : false,
					url : "${ctx}/business/component/component/corpPositionListView.xf",
					modal : true
				})
	}
	function viewCorp() {
		xfui.open_dialog({
			title : '单位基本信息检索',
			width : 1481,
			height : 780,
			closed : false,
			cache : false,
			url : "${ctx}/business/component/component/corpList.xf",
			modal : true
		})
	}
	//单位数据返回
	function checkCorpCallBack(row) {
		$("#aab004_view").val(row.aab004);
		$("#aab001").val(row.aab001);

	}
	function getCheckRowDetail() {
		var row = $('#jobFairInfoList').bootstrapTable('getAllSelections');
		if (row && row.length > 0) {
			return row[0];
		}
	}
	//推荐
	function matchRecommend() {
		var row = $('#jobFairInfoList').bootstrapTable('getAllSelections');
		var res = false;
		if(!acb210){
			bootbox.alert("请选择单位信息");
			return ;
		}
		if (row && row.length > 0) {
			$.ajax({
						contentType : "application/x-www-form-urlencoded; charset=utf-8",
						url : '${ctx}/business/dissupport/jobmatch/personJobRecommend/isHasRecommend.xf',
						data : {
							'acb210' : acb210,
							'acc200' : row[0].ACC200
						},
						async : false,
						type : "post",
						dataType : 'json',
						success : function(data) {
							if (data == 'true') {
								res = true;
							}
						},
						error : function() {
							res = true;
						}
					});
			if (res) {
				bootbox.alert('该求职者已经推荐过这个岗位,不允许再次推荐!');
				return;
			}
			xfui
					.open_dialog({
						title : '推荐信息',
						width : 1481,
						height : 780,
						closed : false,
						cache : true,
						url : "${ctx}/business/dissupport/jobmatch/personJobRecommend/edit.xf?aac001="+row[0].AAC001+"&acb210="+acb210,
						modal : true
					})
		} else {
			bootbox.alert('请选择一条招聘信息');
			return;
		}
	}
</script>
<style type="text/css">
.rightIcon {
	position: absolute;
	right: 25px;
	top: 7px;
	font-size: 1.15em;
	color: #307ecc;
}
</style>
</head>
<body>
	<div class="main-container">
		<div class="container-fluid">
			<div class="mhyBody">
				<div class="mhySearch">
					<div class="mhyTitle">单位信息</div>
					<div class="mhySearchInput">
						<div class="row">
							<input type="hidden" name="bca112match" id="bca112match"
								class="form-control" /> <input type="hidden" name="bcaa12match"
								id="bcaa12match" class="form-control" />
								<label class="col-xs-3 col-sm-2" for="inputError">单位名称:</label>
								<div class="col-xs-9 col-sm-6 pr">
									<input class="form-control" onclick="viewCorpPostion()"
										readonly="true" type="text" name="aab004" id="aab004_view" />
									<i class="icon-search rightIcon"></i>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">工商执照号码:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" readonly="readonly" type="text"
										id="aab007" data-placement="bottom">
								</div>
						</div>
						<div class="row">
								<label class="col-xs-3 col-sm-2" for="inputError">组织机构代码:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" readonly="readonly" type="text"
										id="aab003n" data-placement="bottom">
								</div>
									<label class="col-xs-3 col-sm-2" for="inputError">招聘套餐:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" readonly="readonly" type="text"
										id="bcb201" data-placement="bottom">
								</div>
									<label class="col-xs-3 col-sm-2" for="inputError">招聘登记号码:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" readonly="readonly" type="text"
										id="acb200" data-placement="bottom">
								</div>
						</div>
						<div class="row">
								<label class="col-xs-3 col-sm-2" for="inputError">岗位编号:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" readonly="readonly" type="text"
										id="acb210" data-placement="bottom">
								</div>
									<label class="col-xs-3 col-sm-2" for="inputError">招聘起始日期:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" readonly="readonly" type="text"
										id="eaae030" data-placement="bottom">
								</div>
									<label class="col-xs-3 col-sm-2" for="inputError">招聘终止日期:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" readonly="readonly" type="text"
										id="eaae031" data-placement="bottom">
								</div>
						</div>
					</div>
					<div class="mhyTitle1">工种及待遇</div>
					<div class="mhySearchInput">
				 		<div class="row">
								<label class="col-xs-3 col-sm-2" for="inputError">工种名称:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" readonly="readonly" type="text"
										id="aca112" data-placement="bottom">
								</div>
									<label class="col-xs-3 col-sm-2" for="inputError">招聘人数:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" readonly="readonly" type="text"
										id="acb21r" data-placement="bottom">
								</div>
									<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" readonly="readonly" type="text"
										id="aad004" data-placement="bottom">
								</div>
						</div>
						 		<div class="row">
								<label class="col-xs-3 col-sm-2" for="inputError">工种描述:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" readonly="readonly" type="text"
										id="cca112" data-placement="bottom">
								</div>
									<label class="col-xs-3 col-sm-2" for="inputError">工种说明:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" readonly="readonly" type="text"
										id="cca113" data-placement="bottom">
								</div>
									<label class="col-xs-3 col-sm-2" for="inputError">岗位描述:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" readonly="readonly" type="text"
										id="cca114" data-placement="bottom">
								</div>
						</div>
							<div class="row">
								<label class="col-xs-3 col-sm-2" for="inputError">最低年龄:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" readonly="readonly" type="text"
										id="acb221" data-placement="bottom">
								</div>
									<label class="col-xs-3 col-sm-2" for="inputError">最高年龄:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" readonly="readonly" type="text"
										id="acb222" data-placement="bottom">
								</div>
									<label class="col-xs-3 col-sm-2" for="inputError">文化程度:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" readonly="readonly" type="text"
										id="aac011" data-placement="bottom">
								</div>
						</div>
							<div class="row">
								<label class="col-xs-3 col-sm-2" for="inputError">招聘对象:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" readonly="readonly" type="text"
										id="acc20t" data-placement="bottom">
								</div>
									<label class="col-xs-3 col-sm-2" for="inputError">工作年限:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" readonly="readonly" type="text"
										id="acc217" data-placement="bottom">
								</div>
									<label class="col-xs-3 col-sm-2" for="inputError">工作地点:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" readonly="readonly" type="text"
										id="bcb202" data-placement="bottom">
								</div>
						</div>
							<div class="row">
								<label class="col-xs-3 col-sm-2" for="inputError">月工资:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" readonly="readonly" type="text"
										id="acc034" data-placement="bottom">
								</div>
									<label class="col-xs-3 col-sm-2" for="inputError">福利待遇:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" readonly="readonly" type="text"
										id="acc214" data-placement="bottom">
								</div>
									<label class="col-xs-3 col-sm-2" for="inputError">食宿要求:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" readonly="readonly" type="text"
										id="acb228" data-placement="bottom">
								</div>
						</div>
						<div class="row">
							<form id="searchForm">
							<input id="acb210_hidden" name="acb210" type="hidden" />
							<label class="col-xs-3 col-sm-2" for="inputError">匹配条件:</label>
								<div class="col-xs-9 col-sm-2 mhyOrgId" id="selectDxdiv">
								  		<input type="hidden" name="queryobjs" id="queryobjs"> 
								  		<select id="queryobjs_select" multiple="multiple" class="selectpicker form-control" data-live-search="true"
										data-live-search-placeholder="Search" data-actions-box="true">
										<optgroup>
											<c:forEach items="${queryobjs}" begin="0" var="objOrg">
												<option value="${objOrg.value}">${objOrg.name}</option>
											</c:forEach>
										</optgroup>
									</select>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">身份证号:</label>
								<div class="col-xs-9 col-sm-2">
											<input class="form-control"  onclick="viewAc001()"
										readonly="true" type="text" name="aac002"   id="aac002_view" />
									<i class="icon-search rightIcon" ></i>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError"></label>
								<div class="col-xs-9 col-sm-2">
								<button type="button" role="button" onclick="viewDetail()"
										class="btn btn-primary btn-border1 mhyBtnLeft">
										<i class="icon-search"></i> 招聘详情
									</button>
									<a href="#modal-form" role="button" onclick="doSearch()"
										class="btn btn-primary btn-border1 mhyBtnLeft"> <i
										class="icon-search"></i> 匹配
									</a>
<!-- 									<a href="#modal-form" role="button" onclick="doClear()" -->
<!-- 										class="btn btn-info"> <i class="icon-repeat"></i> 重置 -->
<!-- 									</a> -->
									</div></form>
						</div>
					</div>
					 
				</div>
				<div class="mhyMain">
					<div class="mhyTitle">匹配结果</div>
					<div class="mhyInfo">
						<div class="mgy10">
							<a href="javascript:void(0)" onclick="matchRecommend()"
								role="button" class="btn btn-success" data-toggle="modal"> <i
								class="icon-check"></i> <!-- <i class="icon-plus align-top bigger-125"></i> -->推荐
							</a>
						</div>

						<div class="mhyConter">
							<table id="jobFairInfoList"
								class="tableClassNoworks  table-striped"></table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			jQuery(function($) {
				$('#queryobjs_select').selectpicker({
					selectAllText : '全选',//全选的checkbox名称  
					deselectAllText : '取消',
					selectAllNumber : true,
					actionsBox : true,
					noneResultsText : "没有相关信息",
					liveSearchPlaceholder : "请输入搜索.."
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