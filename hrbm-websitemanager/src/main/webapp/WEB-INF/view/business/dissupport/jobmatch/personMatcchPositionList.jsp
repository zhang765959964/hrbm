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
		$('#queryobjs_select').selectpicker({
			selectAllText : '全选',//全选的checkbox名称  
			deselectAllText : '取消',
			selectAllNumber : true,
			actionsBox : true,
			noneResultsText : "没有相关信息",
			liveSearchPlaceholder : "请输入搜索.."
		});
		$('#aab020_select').selectpicker({
			selectAllText : '全选',//全选的checkbox名称  
			deselectAllText : '取消',
			selectAllNumber : true,
			actionsBox : false,
			noneResultsText : "没有相关信息",
			liveSearchPlaceholder : "请输入搜索.."
		});
		$('#aae017_select').selectpicker({
			selectAllText : '全选',//全选的checkbox名称  
			deselectAllText : '取消',
			selectAllNumber : true,
			actionsBox : false,
			noneResultsText : "没有相关信息",
			liveSearchPlaceholder : "请输入搜索.."
		});
		$('#aab022_select').selectpicker({
			selectAllText : '全选',//全选的checkbox名称  
			deselectAllText : '取消',
			selectAllNumber : true,
			actionsBox : false,
			noneResultsText : "没有相关信息",
			liveSearchPlaceholder : "请输入搜索.."
		});
		$('#acc214_select').selectpicker({
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
		columns = columns.concat([ 
		                           {
			field : 'status',
			title : '选择',
			radio : 'true',
			width : '5%',
			align : 'center',
			visible:true
		},
		{
			field : 'BCB201',
			title : '招聘套餐',
			width : '8%',
			align : 'center'
		}, {
			field : 'ACB210',
			title : '空位编号',
			width : '3%',
			align : 'center'
		}, {
			field : 'AAB004',
			title : '单位名称',
			width : '10%',
			align : 'center'
		}, {
			field : 'ACA112',
			title : '工种名称',
			width : '7%',
			align : 'center'
		}, {
			field : 'BCA112',
			title : '岗位名称',
			width : '7%',
			align : 'center'
		}, {
			field : 'CCA114',
			title : '岗位描述',
			width : '7%',
			align : 'center'
		}, {
			field : 'AAE006',
			title : '单位地址',
			width : '7%',
			align : 'center'
		}, {
			field : 'BCB202',
			title : '工作地点',
			width : '7%',
			align : 'center'
		}, {
			field : 'ACC034',
			title : '月工资',
			width : '8%',
			align : 'center'
		}, {
			field : 'ACC214',
			title : '福利待遇',
			width : '8%',
			align : 'center'
		}, {
			field : 'ACB228',
			title : '食宿要求',
			width : '5%',
			align : 'center'
		}, {
			field : 'ACB21R',
			title : '招聘人数',
			width : '3%',
			align : 'center'
		}, {
			field : 'ACB21T',
			title : '已成功人数',
			width : '3%',
			align : 'center'
		}, {
			field : 'ACB21G',
			title : '可推荐总数',
			width : '3%',
			align : 'center'
		}, {
			field : 'EAAE030',
			title : '招聘起始日期',
			width : '5%',
			align : 'center'
		}, {
			field : 'EAAE031',
			title : '招聘终止日期',
			width : '5%',
			align : 'center'
		}, {
			field : 'AAE004',
			title : '单位联系人',
			width : '5%',
			align : 'center'
		}, {
			field : 'AAE005',
			title : '联系人电话',
			width : '5%',
			align : 'center'
		}, {
			field : 'AAE139',
			title : '联系人手机号码',
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
			field : 'AAE030',
			title : '经办日期',
			width : '5%',
			align : 'center'
		}, {
			field : 'BCB209',
			title : '数据来源',
			width : '5%',
			align : 'center'
		} ]);
		// 		var col = 

		$('#jobFairInfoList').bootstrapTable({
			url : '${ctx}/business/dissupport/jobmatch/jobMatchListJson.xf',
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
			height:450,
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
		}else{
			initPersonData();
		}
		//多选框数据设置到隐藏域中
		$('.selectpicker').each(function() {
			var inputId = $(this).attr('id').replace('_select', '');
			$('#' + inputId).val(getSelectValues($(this).attr('id')));
		});
		 
		$('#acc214query').val(getSelectValues('acc214_select'));
		$('#bcb201').val(getSelectTexts('bcb201_select'));
		$('#acb228_query').val(getSelectTexts('acb228_select'));
		$('#acb20l').val(getSelectTexts('acb20l_select'));
	
		return $("form").serialize() + "&limit=" + params.limit + "&offset="
				+ params.offset + "&order=" + params.order + "&aac001="+ aac001;
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
		if (aac001) {
		} else {
			bootbox.alert("请选择人员信息");
		}
		isDosearch = true;
		$("#jobFairInfoList").bootstrapTable('refresh', {
			url : '${ctx}/business/dissupport/jobmatch/jobMatchListJson.xf',
			query : getSeachJson})
	}
	function doClear() {
		$('.selectpicker').selectpicker('val', '');
		$('.form-control').each(function() {
			if (!$(this).hasClass("selectpicker")&&$(this).attr("id")!="aac002_view") {
				if(!$(this).attr("readonly"))
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
			title : '人员基本信息检索',
			width : 1185,
			height : 690,
			closed : false,
			cache : false,
			url : "${ctx}/business/component/component/viewUsers.xf",
			modal : true
		})
	}
	var aac001 = '';
	var acc200 = '';
	var personData = '';
	var personMatchData = '';
	function getPersonData(){
		return personData;
	}
	function getPersonMatchData(){
		return personMatchData;
	}
	function initPersonData(){
    //获取个人求职信息
    var aac001 = '${aac001}';
    if(aac001){
        $('#queryobjs_select').selectpicker('val',1);
		$.ajax({
			url : '${ctx}/business/component/component/personListJson.xf',
			async:false,
			data : {
				'aac001' : aac001,
				'limit'  :10,
				'offset' :0
			},
			dataType : 'json',
			success : function(data) {
			    if(data.rows){
			    	checkAac001CallBack(data.rows[0]);	
			    }
			}
		});}
	}
	//个人信息数据返回
	function checkAac001CallBack(row) {
		aac001 = row.AAC001;
		//设置个人基本信息
		$("#aac002_view").val(row.AAC002);
		$("#aac003").val(row.AAC003);
		$("#aac004").val(row.AAC004);
		$("#aac005").val(row.AAC005);
		$("#aac006").val(row.AAC006);
		$("#aac011").val(row.AAC011);
		$("#bab305").val(row.BAB305);
		$("#aac009").val(row.AAC009);
		$("#aab301").val(row.AAB301);
		$("#aae005").val(row.AAE005);
		personData = row;
		if (row)
			$.ajax({
				url : '${ctx}/business/component/component/personJobReg.xf',
				data : {
					'aac001' : row.AAC001
				},
				dataType : 'json',
				success : function(data) {
					//求职信息设置
					$("#bca112").val(data.bca112);
					$("#bcaa12").val(data.bcaa12);
					$("#bcab12").val(data.bcab12);
					$("#bcc20c").val(data.bcc20c);
					$("#bcc20d").val(data.bcc20d);
					$("#bcc20e").val(data.bcc20e);
					$("#bcb202").val(data.bcb202);
					$("#bcb203").val(data.bcb203);
					$("#bcb204").val(data.bcb204);
					$("#acc034").val(data.salay);
					$("#acc214").val(data.acc214n);
					$("#acb228").val(data.acb228n);
					acc200 = data.acc200;
					personMatchData = data;
					//bca112match
				}
			});
	}
	function viewDetail() {
		if (aac001) {
			xfui.open_dialog({
						title : '个人基本信息详情',
						width : 900,
						height : 500,
						closed : false,
						cache : false,
						url : "${ctx}/business/person/personBaseInfo/selctPerson.xf?aac001="
								+ aac001,
						modal : false
					});
		} else {
			bootbox.alert("请选择人员信息");
		}
	}
	//求职人员查询列表
	function viewAc001() {
		xfui.open_dialog({
			title : '个人基本信息检索',
			width : "95%",
			height :"600",
			closed : false,
			cache : false,
			url : "${ctx}/business/component/component/personList.xf",
			modal : true
		})
	}
	function viewCorp() {
		xfui.open_dialog({
			title : '单位基本信息检索',
			width : "95%",
			height : "600",
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
	function getCheckRowDetail(){
		var row = $('#jobFairInfoList').bootstrapTable('getAllSelections');
		if (row && row.length > 0) {
			return row[0];
		}
	}
	//推荐
	function matchRecommend(){
		var row = $('#jobFairInfoList').bootstrapTable('getAllSelections');
		var res = false;
		if (row && row.length > 0) {
			$.ajax({
				contentType: "application/x-www-form-urlencoded; charset=utf-8",
				url : '${ctx}/business/dissupport/jobmatch/personJobRecommend/isHasRecommend.xf',
				data : {
					'acb210' : row[0].ACB210,
					'acc200' : acc200
				},
				async : false,
				type: "post", 
				dataType : 'json',
				success : function(data) {
					 if(data=='true'){
						 res=true;
					 }
				},
				error : function() {
					res=true;
				}
			});
			if(res){
				bootbox.alert('该求职者已经推荐过这个岗位,不允许再次推荐!');
				return;
			}
			
			xfui.open_dialog({
				title : '推荐信息',
				width : 1481,
				height : 780,
				closed : false,
				cache : true,
				url : "${ctx}/business/dissupport/jobmatch/personJobRecommend/edit.xf?aac001="+aac001+"&acb210="+row[0].ACB210,
				modal : true
			})
		} else {
			bootbox.alert('请选择一条招聘信息');
			return;
		}
	}
</script>
<style type="text/css">
.rightIcon{position:absolute; right: 25px; top: 7px; font-size: 1.15em; color: #307ecc;}
</style>
</head>
<body>
	<div class="main-container">
		<div class="container-fluid">
			<div class="mhyBody">
				<div class="mhySearch">
					<div class="mhyTitle">个人信息</div>
					<div class="mhySearchInput">
						<div class="row">
							<input type="hidden" name="bca112match" id="bca112match"
								class="form-control" /> <input type="hidden" name="bcaa12match"
								id="bcaa12match" class="form-control" />

							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">身份证号:</label>
								<div class="col-xs-10 col-sm-8 pr">
									<input class="form-control"  onclick="viewAc001()"
										readonly="true" type="text" name="aac002"   id="aac002_view" />
									<i class="icon-search rightIcon" ></i>
								</div>
							</div>
							
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">姓名:</label>
								<div class="col-xs-10 col-sm-8">
										<input class="form-control" readonly="readonly" type="text"  id="aac003"
										  data-placement="bottom">
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">性别:</label>
								<div class="col-xs-10 col-sm-8">
										<input class="form-control" readonly="readonly" type="text"  id="aac004"
										  data-placement="bottom">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">民族:</label>
								<div class="col-xs-10 col-sm-8">
										<input class="form-control" readonly="readonly" type="text"  id="aac005"
										  data-placement="bottom">
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">出生日期:</label>
								<div class="col-xs-10 col-sm-8">
										<input class="form-control" readonly="readonly" type="text"  id="aac006"
										  data-placement="bottom">
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">文化程度:</label>
								<div class="col-xs-10 col-sm-8">
										<input class="form-control" readonly="readonly" type="text"  id="aac011"
										  data-placement="bottom">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">联系电话:</label>
								<div class="col-xs-10 col-sm-8">
										<input class="form-control" readonly="readonly" type="text"  id="aae005"
										  data-placement="bottom">
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">户口所在地:</label>
								<div class="col-xs-10 col-sm-8">
										<input class="form-control" readonly="readonly" type="text"  id="bab305"
										  data-placement="bottom">
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">居住所在地:</label>
								<div class="col-xs-10 col-sm-8">
										<input class="form-control" readonly="readonly" type="text"  id="aab301"
										  data-placement="bottom">
								</div>
							</div>
						</div>
						<div class="row" style="display: none;">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">户口性质:</label>
								<div class="col-xs-10 col-sm-8">
										<input class="form-control" readonly="readonly" type="text"  id="aac009"
										  data-placement="bottom">
								</div>
							</div>
						</div>
					</div>
					<div class="mhyTitle1">意向及待遇</div>
					<div class="mhySearchInput">
						<div class="row">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">意愿工种名称1:</label>
								<div class="col-xs-10 col-sm-8">
													<input class="form-control" readonly="readonly" type="text"  id="bca112"
										  data-placement="bottom">
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">意愿工种名称2:</label>
								<div class="col-xs-10 col-sm-8">
										<input class="form-control" readonly="readonly" type="text" id="bcaa12"
										  data-placement="bottom">
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">意愿工种名称3:</label>
								<div class="col-xs-10 col-sm-8">
									<input class="form-control" readonly="readonly" type="text" id="bcab12"
										  data-placement="bottom">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">意愿工种说明1:</label>
								<div class="col-xs-10 col-sm-8">
										<input class="form-control" readonly="readonly" type="text" id="bcc20c"
										  data-placement="bottom">
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">意愿工种说明2:</label>
								<div class="col-xs-10 col-sm-8">
										<input class="form-control" readonly="readonly" type="text" id="bcc20d"
										  data-placement="bottom">
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">意愿工种说明3:</label>
								<div class="col-xs-10 col-sm-8">
										<input class="form-control" readonly="readonly" type="text" id="bcc20e"
										  data-placement="bottom">
								</div>
							</div>

						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">求职区域1:</label>
								<div class="col-xs-10 col-sm-8">
										<input class="form-control" readonly="readonly" type="text" id="bcb202"
										  data-placement="bottom">
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">求职区域2:</label>
								<div class="col-xs-10 col-sm-8">
										<input class="form-control" readonly="readonly" type="text" id="bcb203"
										  data-placement="bottom">
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">求职区域3:</label>
								<div class="col-xs-10 col-sm-8">
										<input class="form-control" readonly="readonly" type="text" id="bcb204"
										  data-placement="bottom">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">月工资:</label>
								<div class="col-xs-10 col-sm-8">
										<input class="form-control" readonly="readonly" type="text" id="acc034"
										  data-placement="bottom">
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">福利待遇:</label>
								<div class="col-xs-10 col-sm-8">
										<input class="form-control" readonly="readonly" type="text" id="acc214"
										  data-placement="bottom">
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">食宿要求:</label>
								<div class="col-xs-10 col-sm-8">
										<input class="form-control" readonly="readonly" type="text" id="acb228"
										  data-placement="bottom">
								</div>
							</div>

						</div>
					</div>
					<div class="mhyTitle1">查询条件</div>
					<form id="searchForm" class="mhySearchInput">

						<div class="row">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">匹配条件:</label>
								<div class="col-xs-10 col-sm-8 mhyOrgId" id="selectDxdiv">
									<input type="hidden" name="queryobjs" id="queryobjs"> <select
										id="queryobjs_select" multiple="multiple"
										class="selectpicker form-control" data-live-search="true"
										data-live-search-placeholder="Search" data-actions-box="true">
										<optgroup>
											<c:forEach items="${queryobjs}" begin="0" var="objOrg">
												<option value="${objOrg.value}">${objOrg.name}</option>
											</c:forEach>
										</optgroup>
									</select>

								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">经办日期:</label>
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
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">至:</label>
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
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">单位名称:</label>
								<div class="col-xs-10 col-sm-8 pr">
									<input class="form-control" 
										readonly="true" type="text" id="aab004_view" onclick="viewCorp()" /> <input
										type="hidden" name="aab001" id="aab001" />
										<i class="icon-search rightIcon" ></i>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">岗位编号:</label>
								<div class="col-xs-10 col-sm-8">
									<input class="form-control" type="text" name="acb210"
										id="acb210" data-placement="bottom">
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">岗位名称:</label>
								<div class="col-xs-10 col-sm-8">
									<input class="form-control" type="text" name="bca112"
										id="aca112" data-placement="bottom">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">月工资:</label>
								<div class="col-xs-10 col-sm-8">
									<xf:select name="acc034n" id="acc034n_select" textField="name"
										tableName="TAB_SALARY" valueField="code"
										selectClass="form-control" isNoStyle="true" hasDefault="0"></xf:select>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">求职区域:</label>
								<div class="col-xs-10 col-sm-8">
									<input class="form-control" type="text" name="bcb202"
										id="aca112_bak" data-placement="bottom">
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">福利待遇</label>
								<div class="col-xs-10 col-sm-8 mhyOrgId" id="selectDxdiv">
									<input type="hidden" name="acc214" id="acc214query"
										class="form-control" /> <select id="acc214_select"
										class="selectpicker" data-live-search="true"
										multiple="multiple" data-live-search-placeholder="Search"
										data-actions-box="true">
										<xf:select name="funt66" textField="name"
											tableName="TAB_WELFARE" valueField="code"
											isOnlyOptions="true"></xf:select>
									</select>
								</div>
							</div>

						</div>
						<div class="row" style="display: none;">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">数据来源:</label>
								<div class="col-xs-10 col-sm-8 mhyNoSelect">
									<xf:select id="cczy06_select" name="cczy06" textField="name"
										tableName="TAB_DATASOURCES" selectClass="form-control"
										valueField="code" isNoStyle="true" hasDefault="0"></xf:select>
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
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">机构信息:</label>
								<div class="col-xs-10 col-sm-8 mhyOrgId" id="selectDxdiv">
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
									<input type="hidden" name="bcb201" id="bcb201" />
									<xf:select name="bcb201_select" id="bcb201_select"
										textField="name" isNoStyle="true" tableName="TAB_JFFORM"
										selectClass="form-control" valueField="code" hasDefault="0"></xf:select>

								</div>
							</div>
						</div>
						<div class="row" style="display: none;">
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
									<xf:select name="acb20l_select" id="acb20l_select"
										textField="name" isNoStyle="true" tableName="TAB_UFREASONS"
										selectClass="form-control" valueField="code" hasDefault="0"></xf:select>
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
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">食宿要求:</label>
								<div class="col-xs-10 col-sm-8">
									<input type="hidden" name="acb228" id="acb228_query" />
									<xf:select name="acb228_select" id="acb228_select"
										textField="name" isNoStyle="true" tableName="TAB_SREQUIREMENT"
										selectClass="form-control" valueField="code" hasDefault="0"></xf:select>

								</div>
							</div>

							<div class="col-xs-12 col-sm-8 marginbottom20">

								<div class="col-xs-12 col-sm-12 mhyBtn">
									<button type="button" role="button" onclick="viewDetail()"
										class="btn btn-primary btn-border1 mhyBtnLeft">
										<i class="icon-search"></i> 求职详情
									</button>
									<a href="#modal-form" role="button" onclick="doSearch()"
										class="btn btn-primary btn-border1 mhyBtnLeft"> <i
										class="icon-search"></i> 匹配
									</a>
									<!-- 									<a href="#modal-form" class="btn btn-primary btn-border1 mhyBtnLeft" onclick="hideRows(2)"><i id="view_class" class="icon-plus"></i>高级查询</a> -->
									<a href="#modal-form" role="button" onclick="doClear()"
										class="btn btn-info"> <i class="icon-repeat"></i> 重置
									</a>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="mhyMain">
					<div class="mhyTitle">匹配结果</div>
					<div class="mhyInfo">
						<div class="mgy10">
							<a href="javascript:void(0)" onclick="matchRecommend()" role="button"
								class="btn btn-success" data-toggle="modal"> <i
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
	</div>
</body>
</html>