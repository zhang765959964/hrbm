<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<title>编辑招聘会信息</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp"%>
<%@include file="/commons/include/bootstrapInc.jsp"%>
<script src="${ctx}/js/lib/bootstrap-select/bootstrap-select.js"></script>
<link type="text/css"
	href="${ctx}/js/lib/bootstrap-select/bootstrap-select.css"
	rel="stylesheet" />
<script type="text/javascript" src="${ctx}/js/ui/xf.seljob.js"></script>
</head>
<script type="text/javascript">
	var isCheck = true;
	var isDosearch = false;
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
		 
		$('#jobFairInfoList').bootstrapTable(
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
					 onDblClickRow :function(rowIndex, rowData){
						 
							$.ajax({
								contentType : "application/x-www-form-urlencoded; charset=utf-8",
								url : '${ctx}/business/jobfair/corpPosition/editJson.xf',
								data : {
									'acb210' : rowIndex.ACB210
								},
								async : false,
								type : "post",
								dataType : 'json',
								success : function(data) {
										//
										$("#bca112").val(data.bca112);
										$("#aab004").val(data.aab004);
										$("#aab004_div").html(data.aab004);
									 	//岗位信息设置
										$("#acb210").val(data.acb210);
										$("#acb200").val(data.acb200);
										$("#aab001").val(data.aab001);
										$("#aae030").val(data.aae030);
										$("#acb208").val(data.acb208);
										$("#abb770").val(data.abb770);
										$("#abb771").val(data.abb771);
										$("#abb773").val(data.abb773);
										$("#abb769").val(data.abb769);
										$("#aca111").val(data.aca111);
										$("#bca111").val(data.bca111);
										$("#aca112").val(data.aca112);
										$("#acc034").val(data.acc034);
										$("#acb21r").val(data.acb21r);
										$("#cca113").val(data.cca113);
										$("#aac011").val(data.aac011);
										$("#bcb202").val(data.bcb202);
										$("#acb21i").val(data.acb21i);
										$("#acc217").val(data.acc217);
										//性别
										$("#aad004").val(data.aad004);
										//岗位描述
										$("#cca114").html(data.cca114);
// 										$(".ace").checked(); 
										if(data.acb20q){
											var acb20qv = data.acb20q.split(",");
											$(".ace").each(function(){
												if($(this).val()){
													if(jQuery.inArray($(this).val(), acb20qv)>-1){
													  $(this).attr("checked","checked");
													}else{
													 $(this).removeAttr("checked");
													}
												}else{
													$(this).removeAttr("checked");
												}
											});
										 
										}
										if(data.acc214){
										 $("#acc214_select").selectpicker('val',data.acc214);
										}
								},
								error : function() {
								}
							});
						 
// 							xfui.open_tabs("单位招聘信息维护", "${ctx}/business/jobfair/corpPosition/edit.xf?acb200="+rowIndex.ACB200+"&acb210="+rowIndex.ACB210+"&aab001="+rowIndex.AAB001,"岗位基本信息");
						},
					striped : true,
					height:350,
							queryParams : getSeachJson
						});
	});
	function getSeachJson(params) {
		if(isDosearch){
			params.offset = 0;
			isDosearch = false;
		}
		var acb200 = '${acb200}';
		if (!acb200) {
			acb200 = $("#acb200").val();
		}
		return "limit="+params.limit+"&offset="+params.offset+"&order="+params.order+"&acb200="+acb200;
	}
	function checkAca111() {
		var res = false;
		var acb200 = '${acb200}';
		if (!acb200) {
			acb200 = $("#acb200").val();
		}
		$.ajax({
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			url : '${ctx}/business/jobfair/corpPosition/isExist.xf',
			data : {
				'acb200' : acb200,
				'acb210' : $("#acb210").val(),
				'aab001' : $("#aab001").val(),
				'code' : $("#aca111").val()
			},
			async : false,
			type : "post",
			dataType : 'json',
			success : function(data) {
				res = (data.result == '0');
			},
			error : function() {
				res = false
			}
		});
		//岗位是否已存在
		if (!res) {
			$("small[data-bv-validator$='notEmpty'][data-bv-for$='bca112']")
					.html("当前招聘信息该岗位已存在");
			$("small[data-bv-validator$='notEmpty'][data-bv-for$='bca112']")
					.show();
			$("#button_submit").attr("disabled", true);
			return false;
		} else {
			return true;
		}
	}
	function initTable() {
		var json = $("#searchForm").serializeJson();
		var columns = [ {
			field : 'aab004',
			title : '单位名称'
		}, {
			field : 'aab007',
			title : '营业执照号码'
		} ];
		$('#corpList').bootstrapTable({
			url : '${ctx}/business/corp/corp/listSelect.xf?ccpr08=0',
			columns : columns,
			method : "post",
			contentType : "application/x-www-form-urlencoded",
			sidePagination : "server",
			onClickRow : function(rowIndex, rowData) {
				//设置企业信息
				$("#aab001").val(rowIndex.aab001);
				$("#aab004").val(rowIndex.aab004);
				$("#aae004").val(rowIndex.aae004);
				$("#aae005").val(rowIndex.aae005);
				$("#aae006").val(rowIndex.aae006);
				$("#aae139").val(rowIndex.aae139);
				$("#aac002").val(rowIndex.bab014);
				$("#acb20c").val(rowIndex.aae006);
				$("#acb205").val(rowIndex.acb205);
				if (rowIndex.acb206)
					$("#acb206").text(rowIndex.acb206);
				//ACB205
				//BAB014,
				//AAE139
			},
		});
		$("#corpList").bootstrapTable('refresh', {
			query : json
		})
	}
	$(function() {
		initFormSubimt();
		//initTable();
	})
	function initFormSubimt() {
		$('#corpPositionForm').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				//单位描述
				cca114 : {
					validators : {
						notEmpty : {
							message : '请填写岗位描述'
						},
						stringLength : {
							min : 2,
							max : 1000
						}
					}
				},
				bca112 : {
					validators : {
						notEmpty : {
							message : '请选择职位名称'
						}
					}
				},
				//职位说明
				cca113 : {
					validators : {
						notEmpty : {
							message : '请填写职位说明'
						},
						stringLength : {
							min : 2,
							max : 50
						}
					}
				},
				bcb202 : {
					validators : {
						stringLength : {
							min : 0,
							max : 30
						}
					}
				},
				//发布范围
				acb20q : {
					validators : {
						notEmpty : {
							message : '请选择发布范围'
						}
					}
				},
				//招聘人数
				acb21r : {
					validators : {
						notEmpty : {
							message : '招聘人数不能为空'
						},
						regexp : {
							regexp : /^[0-9]*$/,
							message : "请输入正确的招聘人数"
						},
						stringLength : {
							min : 0,
							max : 6
						}
					}
				},
				//居住所在地
				aab301 : {
					validators : {
						notEmpty : {
							message : '请填写居住所在地'
						}
					}
				}
			}
		}).on('success.form.bv', function(e) {
			e.preventDefault();
			//设置福利
			$("#acc214").val(getSelectValues("acc214_select"));
			var $form = $(e.target);
			var bv = $form.data('bootstrapValidator');
			if (!checkAca111()) {
				return;
			}
			$.post($form.attr('action'), $form.serialize(), function(data) {
				console.info(data);
				var arry = data.message;
				var messages = arry.substring(0, 11);
				var aac001 = arry.substring(11);
				$("#acb210").val(data.jobId);
				$("#button_submit").removeAttr("disabled");
				bootbox.alert({
					size : 'small',
					width : "100px",
					message : messages,
					callback : function(rowIndex, rowData) {
						$("#jobFairInfoList").bootstrapTable('refresh');
					}
				})

			}, 'json');

		});
	}
	function setCorpPostion(acb210){
		$.ajax({
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			url : '${ctx}/business/jobfair/corpPosition/editJson.xf',
			data : {
				'acb210' : acb210
			},
			async : false,
			type : "post",
			dataType : 'json',
			success : function(data) {
			 
			},
			error : function() {
			}
		});
		
	}
	function editrecruitment() {
		var acb210 = $("#acb210").val();
		var acb200 = '${acb200}';
		if (!acb200) {
			acb200 = $("#acb200").val();
		}
		xfui.open_tabs("单位招聘信息维护",
				"${ctx}/business/jobfair/corpPosition/editrecruitment.xf?acb200="
						+ acb200 + "&acb210=" + acb210, "单位招聘信息维护");
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
	function remind() {
		bootbox.alert('请先招聘基本信息');
	}

	function refresh() {
		var acb200 = '${acb200}';
		if (!acb200) {
			acb200 = $("#acb200").val();
		}
		var acb210 = $("#acb210").val();
		xfui
				.open_tabs("单位招聘信息维护",
						"${ctx}/business/jobfair/corpPosition/edit.xf?acb200="
								+ acb200, "岗位基本信息");
	}
</script>
<body>
	<div class="main-container">
		<div class="container-fluid">
			<div class="mhyMain">
				<div class="mhyTitle">岗位基本信息</div>
				<div class="row mhyUnitSearch">
					<div class="col-sm-4"></div>
					<div class="col-sm-8">
						<form id="searchForm" class="mhySearchInput">
							<div class="col-sm-12 mhycorp"
								style="visibility: true; display: none;">
								<label class="col-xs-4 col-sm-4"> 单位信息查询: </label>
								<div class="col-xs-6 col-sm-6 mhyUnitInput">
									<input class="form-control" type="text" name="nameNumber"
										data-placement="bottom" placeholder="请输入单位名称或工商登记执照号" />
									<div class="mhyCorpSearchValue">
										<table id="corpList"></table>
									</div>
								</div>
								<div class="col-xs-2 col-sm-2 mhyBtn">
									<a class="btn btn-primary btn-border1 mhyBtnLeft" role="button"
										onclick="initTable()">查询</a>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="mhyPersonTabs">
					<ul id="personTab">
						<li onclick="editrecruitment()"><div>单位招聘基本信息</div></li>
						<li class="active">岗位信息</li>
					</ul>
					<div class="mhyPersonInfo">
						<form:form modelAttribute="corpPositionForm" method="post"
							action="${ctx}/business/jobfair/corpPosition/save.xf">
							<!-- 							<div class="form-group"> -->
							<form:hidden path="acb210"></form:hidden>
							<form:hidden path="acb200"></form:hidden>
							<form:hidden path="aab001"></form:hidden>
							<form:hidden path="aab004"></form:hidden>
							<form:hidden path="aae030"></form:hidden>
							<form:hidden path="acb208"></form:hidden>
							<form:hidden path="abb770"></form:hidden>
							<form:hidden path="abb771"></form:hidden>
							<form:hidden path="abb773"></form:hidden>
							<form:hidden path="abb769"></form:hidden>

							<div class="mhySearchInput mhyInputDiv">
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError"><i
										style="color: red; margin-right: 5px;">*</i>单位名称:</label>
									<div class="col-xs-9 input-group col-sm-6">
										<div id="aab004_div">${corpPositionForm.aab004}</div>
									</div>
								</div>
								<div class="row">
									<label class="col-xs-3 input-group col-sm-2" for="inputError"><i
										style="color: red; margin-right: 5px;">*</i>职位名称:</label>
									<div class="col-xs-9 col-sm-2" id="bca112_div">
										<form:input class="form-control" type="text" readonly="true"
											path="bca112"></form:input>
										<form:hidden path="aca111" />
										<form:hidden path="bca111" />
										<form:hidden path="aca112" />
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError"><i
										style="color: red; margin-right: 5px;">*</i>月工资:</label>
									<div class="col-xs-9 input-group col-sm-2 mhyNoSelect">
										<xf:select name="acc034" textField="name"
											tableName="TAB_SALARY" valueField="code"
											value="${corpPositionForm.acc034}" isNoStyle="true"></xf:select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError"><i
										style="color: red; margin-right: 5px;">*</i>招聘人数:</label>
									<div class="col-xs-9 col-sm-2">
										<form:input class="form-control" type="text" path="acb21r"></form:input>
									</div>
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError"><i
										style="color: red; margin-right: 5px;">*</i>职位说明:</label>
									<div class="col-xs-9 input-group col-sm-10">
										<form:input class="form-control" type="text" path="cca113"></form:input>
									</div>
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError"><i
										style="color: red; margin-right: 5px;">*</i>岗位描述:</label>
									<div class="col-xs-9 col-sm-10">
										<form:textarea type="text" path="cca114"></form:textarea>
									</div>
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError"><i
										style="color: red; margin-right: 5px;">*</i>发布范围:</label>
									<div class="col-xs-9 col-sm-3">
										<c:forEach items="${acb20qs}" var="item">
											<label class="inline mhyInline"> <input class="ace"
												type="checkbox"
												<c:if test="${item.CHECKED}"> checked="checked"</c:if>
												name="acb20q" value="${item.CODE}" /> <span class="lbl">${item.NAME}</span>
											</label>
										</c:forEach>
										<div class="form-group">
											<label class="inline mhyInline" style="display: none">
												<input class="ace" type="checkbox" name="acb20q" value="" />
												<span class="lbl"></span>
											</label>
										</div>
									</div>
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError">福利待遇:</label>
									<form:hidden path="acc214" />
									<div class="col-xs-9 col-sm-2 mhyOrgId form-group"
										id="selectDxdiv">
										<select id="acc214_select" class="selectpicker"
											data-live-search="true" multiple="multiple"
											data-live-search-placeholder="Search" data-actions-box="true">
											<optgroup>
												<xf:select name="acc21411" textField="name"
													tableName="TAB_WELFARE" valueField="code"
													isOnlyOptions="true" isNoStyle="true"></xf:select>
											</optgroup>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">工作地点:</label>
									<div class="col-xs-9 input-group col-sm-6 mhyNoSelect">
										<form:input path="bcb202" class="form-control" type="text" />
										<%-- 											<xf:select name="acb202" textField="name" --%>
										<%-- 												tableName="TAB_NATURE" hasDefault="0" valueField="code" --%>
										<%-- 												value="${corpPositionForm.acb202}" isNoStyle="true"></xf:select> --%>
									</div>
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError">文化程度:</label>
									<div class="col-xs-9 input-group col-sm-2 mhyNoSelect">
										<xf:select name="aac011" textField="name"
											tableName="TAB_EDUCATION" hasDefault="0" valueField="code"
											value="${corpPositionForm.aac011}" isNoStyle="true"></xf:select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">工作性质:</label>
									<div class="col-xs-9 input-group col-sm-2 mhyNoSelect">
										<xf:select name="acb21i" textField="name"
											tableName="TAB_NATURE" hasDefault="0" valueField="code"
											value="${corpPositionForm.acb21i}" isNoStyle="true"></xf:select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">工作年限:</label>
									<div class="col-xs-9 input-group col-sm-2 mhyNoSelect">
										<xf:select name="acc217" textField="name"
											tableName="TAB_WORKYEARS" hasDefault="0" valueField="code"
											value="${corpPositionForm.acc217}" isNoStyle="true"></xf:select>
									</div>
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
									<div class="col-xs-9 input-group col-sm-2 mhyNoSelect">
										<xf:select name="aad004" textField="name" id="aad004"
											tableName="TAB_SEX" hasDefault="0" valueField="code"
											value="${corpPositionForm.aad004}" isNoStyle="true"></xf:select>
									</div>
								</div>
							</div>
							 <div class="mhyConter" >
						  	  <table id="jobFairInfoList" class="tableClassNoworks  table-striped"></table>
						 	</div>
							<div class="bottomBtn">
				   					<div class="h50">&nbsp;</div>
				   					<div class="floatBtn">
					   					<a class="btn btn-primary mhyBtnLeft" role="button" onclick="refresh()">
					   					<i class="icon-plus"></i>
					   					新增
					   					</a>
										<a class="btn btn-info mhyBtnLeft" onclick="refresh()" role="button">
										<i class="icon-repeat"></i>
										重置
										</a>
					   					<button class="btn btn-primary mhyBtn"  id="button_submit" type="submit">
					   					<i class="icon-save"></i>
					   					保存	
					   					</button>
				   					</div>
				   				</div>
						</form:form>
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${!empty corpPositionForm.acb200}">
		<script>
			$(function() {
				$("#personTab li").click(
						function() {
							var _this = this;
							$("#personTab li").removeClass("active")
									&& $(_this).addClass("active");
							;

						});

			})
		</script>
	</c:if>
	<script type="text/javascript">
		function restCheckField(fieldName) {
			$('#corpPositionForm').data('bootstrapValidator').updateStatus(
					fieldName, 'VALID', null).validateField(fieldName);
		}
		jQuery(function($) {
			//设置职位类别
			$("#bca112_div").seljob({
				width : 865,
				height:455,
				totalSelect : 1,
				callBack : function(returnData) {
					$("#cca113").val(returnData[0].name);
					$("#bca111").val(returnData[0].code);
					$("#bca112").val(returnData[0].name);
					$("#aca111").val(returnData[0].btCode);
					$("#aca112").val(returnData[0].btName);
					//$('#corpPositionForm').bootstrapValidator('resetForm', true);
					restCheckField('cca113');
					restCheckField('bca112');
					isCheck = !checkAca111();
				}
			});
			$('.selectpicker').selectpicker({
				selectAllText : '全选',//全选的checkbox名称  
				deselectAllText : '取消',
				selectAllNumber : true,
				actionsBox : true,
				liveSearch : false,
				noneResultsText : "没有相关信息",liveSearchPlaceholder:"请输入搜索.."
			});
			var acc214str = '${corpPositionForm.acc214}';
			if (acc214str) {
				$("#acc214_select").selectpicker('val', acc214str.split(','));
			}
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
			$("[data-toggle='popover']").popover();
		});
	</script>
</body>
</html>