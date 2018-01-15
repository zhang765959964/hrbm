<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp"%>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/daterangepicker.css" />
<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />
<script src="${ctx}/assets/js/echarts/echarts.min.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/ui/xf.treeorg.js?version=201609231008"></script>
<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet" href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css" type="text/css" />
<script src="${ctx}/js/lib/bootstrap-select/bootstrap-select.js"></script>
<link href="${ctx}/assets/css/bootstrap.min.css" rel="stylesheet" />
<link type="text/css" href="${ctx}/js/lib/bootstrap-select/bootstrap-select.css" rel="stylesheet" />
<title>招聘会信息情况查询</title>
<script>
	$(function() {
		$("#aae017n").treeorg({callBack:function(data){
			$("#aae017n").val(data.orgName);
			$("#aae017").val(data.orgId);
			}
		});
		/**
		 初始化表格显示
		 */
		var columns = [
		               {
		       			field : 'DATA_DATE',
		       			title : '统计时间',
		       			width : '5%',
		       			align : 'center'
		       				,
		       				formatter : function(value, row, index) {
		       					return  value.replace("1900-01-01","");
		       				}
		       		}, {
			field : 'AAE017N',
			title : '统计机构',
			width : '5%',
			align : 'center',
			formatter : function(value, row, index) {
				if (value) {
					return value;
				} else {
					return "-";
				}
			}
		},
		{
			field : 'CCZY06N',
			title : '数据来源',
			width : '5%',
			align : 'center',
			visible : false
		},{
			field : 'AAB054N',
			title : '产业',
			width : '5%',
			align : 'center',
			visible : false
		}
		,{
			field : 'AAB019N',
			title : '单位性质',
			width : '5%',
			align : 'center',
			visible : false
		}
		,{
			field : 'AAB020N',
			title : '经济类型',
			width : '5%',
			align : 'center',
			visible : false
		}
		,{
			field : 'CCPR10N',
			title : '自定行业',
			width : '5%',
			align : 'center',
			visible : false
		}
		,{
			field : 'AAB022N',
			title : '部标行业',
			width : '5%',
			align : 'center',
			visible : false
		}
		,{
			field : 'AAB056N',
			title : '人员规模',
			width : '5%',
			align : 'center',
			visible : false
		}
		,{
			field : 'RECRUITN',
			title : '有无招聘',
			width : '5%',
			align : 'center',
			visible : false
		}
		,{
			field : 'PKG_NAME',
			title : '套餐类型',
			width : '5%',
			align : 'center',
			visible : false
		}
		,{
			field : 'MEMN',
			title : '是否会员',
			width : '5%',
			align : 'center',
			visible : false
		}
		,{
			field : 'DWS',
			title : '单位数',
			width : '5%',
			align : 'center'
		} 
		,{
			field : 'BQ_NEW_DWS',
			title : '新增单位家数',
			width : '5%',
			align : 'center'
		},{
			field : 'BQ_NEW_RATE',
			title : '新增单位家数占总数比率(%)',
			
			visible:false,
			width : '5%',
			align : 'center'
		},{
			field : 'SQ_NEW_DWS',
			title : '上期新增单位家数',
			width : '5%',
			align : 'center'
		},{
			field : 'BQ_SQ_NEW_DWS',
			title : '本期减上期家数',
			width : '5%',
			align : 'center'
		},{
			field : 'HB_NEW_RATE',
			title : '新增单位家数环比(%)',
			visible:false,
			width : '5%',
			align : 'center'
		}
		,{
			field : 'TQ_NEW_DWS',
			title : '同期新增单位家数',
			visible : false,
			width : '5%',
			align : 'center'
		},{
			field : 'BQ_TQ_NEW_DWS',
			title : '本期减同期家数',
			visible : false,
			width : '5%',
			align : 'center'
		}
		,{
			field : 'TB_NEW_RATE',
			title : '新增单位家数同比(%)',
			visible:false,
			width : '5%',
			align : 'center'
		}
		];
		$('#jobFairInfoList').bootstrapTable({
			url : '${ctx}/business/dissupport/statistics/statistics/listStatisticsJson.xf',
			columns : columns,
			method : "get",
			pagination : false,
			pageSize : 10,
			pageList : [ 10, 15, 20 ],
			clickToSelect : true,
			singleSelect : false,
			sidePagination : "server",
			striped : true,
			queryParams : getSeachJson
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
		var AAE017 = getSelectValues("org_select");
		var CCZY06 = getSelectValues("cczy06_select");
		var AAB054 = getSelectValues("aab054_select");
		var AAB019 = getSelectValues("aab019_select");
		var AAB020 = getSelectValues("aab020_select");
		var CCPR10 = getSelectValues("ccpr10_select");
		var AAB022 = getSelectValues("aab022_select");
		var AAB056 = getSelectValues("aab056_select");
		var RECRUIT = getSelectValues("recruit_select");
// 		var PKG_CODE = getSelectValues("pkg_code_select");
		var MEM = getSelectValues("mem_select");
		$("#jobFairInfoList").bootstrapTable(CCZY06?'showColumn':'hideColumn', 'CCZY06N');
		$("#jobFairInfoList").bootstrapTable(AAB054?'showColumn':'hideColumn', 'AAB054N');
		$("#jobFairInfoList").bootstrapTable(AAB019?'showColumn':'hideColumn', 'AAB019N');
		$("#jobFairInfoList").bootstrapTable(AAB020?'showColumn':'hideColumn', 'AAB020N');
		$("#jobFairInfoList").bootstrapTable(CCPR10?'showColumn':'hideColumn', 'CCPR10N');
		$("#jobFairInfoList").bootstrapTable(AAB022?'showColumn':'hideColumn', 'AAB022N');
		$("#jobFairInfoList").bootstrapTable(AAB056?'showColumn':'hideColumn', 'AAB056N');
		$("#jobFairInfoList").bootstrapTable(RECRUIT?'showColumn':'hideColumn', 'RECRUITN');
// 		$("#jobFairInfoList").bootstrapTable(PKG_CODE?'showColumn':'hideColumn', 'PKG_NAME');
		$("#jobFairInfoList").bootstrapTable(MEM?'showColumn':'hideColumn', 'MEMN');
		return {
			'limit' : params.limit,
			'offset' : params.offset,
			'order' : params.order,
			'STARTDATE':$("#startdate").val(),
			'ENDDATE':$("#enddate").val(),
			'AAE017' :$("#aae017").val(),
			'CCZY06' : CCZY06,
			'AAB054' :AAB054,
			'AAB019' :AAB019,
			'AAB020' :AAB020,
			'CCPR10' :CCPR10,
			'AAB022' :AAB022,
			'AAB056' :AAB056,
			'RECRUIT' :RECRUIT,
// 			'PKG_CODE' :PKG_CODE,
			'MEM' :MEM
		};
	}
	function doSearch() {

		var params=$("#searchForm").serialize();


	    $("#jobFairInfoList").bootstrapTable('refresh', {url:"${ctx}/business/dissupport/statistics/statistics/listStatisticsJson.xf?"+params});
		
	}
	function doClear() {
		$("#startdate").val('')
		$("#enddate").val('');
		$('.selectpicker').selectpicker('val','');
		resetForm("searchForm");
	}
	function statisticsChange(obj){
		var datanamevalues = [];
		var title = "单位信息数据统计图";
	 	$.ajax({ url: '${ctx}/business/dissupport/statistics/statistics/listStatisticsChartsJson.xf',
	 		async : false,
	 		data:{'groupvalue':obj},
    		success: function(data){
    			datanamevalues = data.datanamevalues;
    			datanames =data.datanames;
    			datavalues=data.datavalues;
             }
    	});
		initEcharts(title,datanamevalues);
	}
	function initEcharts(title,data){
		var optionBar ={
			title : {
				text : title,
				subtext : '',
				x : 'center'
			},
		    tooltip: {
		        trigger: 'axis'
		    },
		    grid: { // 控制图的大小，调整下面这些值就可以，
	             x: 40,
	             x2: 100,
	             y2: 150,// y2可以控制 X轴跟Zoom控件之间的间隔，避免以为倾斜后造成 label重叠到zoom上
	         },
		    legend: {
		        data:[]
		    },
		    xAxis: [
		        {
		        	'type':'category',
	                 axisLabel:{'interval':0,
	                     rotate:65,
                         margin:2,
                         textStyle:{
                             color:"#222"
                         }
// 		                 ,
// 	                	 formatter:function(val){  
// 	                         return val.split("").join("\n");  
// 	                       } 	 
	                 },
		             data: datanames,
		             splitLine: {show: false}
		            
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            name: '单位数',
		       
		            axisLabel: {
		                formatter: '{value}'
		            }
		        }
		     
		    ],
		    series: [
		        {
		            name:'单位数',
		            type:'bar',
		            data:datavalues
		        }
		    ]
		};
		var option = {
				title : {
					text : title,
					subtext : '',
					x : 'center'
				},
				tooltip : {
					trigger : 'item',
					//         	        formatter: "{a} <br/>{b} : {c} ({d}%)"
					formatter : "{b} : {c} ({d}%)"
				},
				legend : {
					orient : 'vertical',
					left : 'left',
					data : []
				},
				series : [ {
					name : '',
					type : 'pie',
					radius : '55%',
					center : [ '50%', '60%' ],
					data : data,
					itemStyle : {
						emphasis : {
							shadowBlur : 10,
							shadowOffsetX : 0,
							shadowColor : 'rgba(0, 0, 0, 0.5)'
						}
					}
				} ]
			};
		
		myChart.setOption(option);
		myChartBar.setOption(optionBar);
		setTimeout(function (){

			window.onresize = function () {

			myChart.resize();

			myChartBar.resize();

			}

			},1)

	}
	function submitForm(){
		$("#searchForm").submit();
	}
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="mhyBody">
			<div class="mhySearch" style="display: none;">
				<div class="mhyTitle">机构个人信息数据统计图</div>

				<div class="row mhyCensus">
					<div class="col-xs-12 col-sm-6">
						<div class="censusChartsInfo">
							<div id="myechartsPie" class="censusCharts"></div>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6">
						<div class="censusChartsInfo0">
							<div id="myechartsBar" class="censusCharts"></div>
						</div>
					</div>
				</div>

				<%-- 		<div class="row">	机构:<input type="radio" name="radio" value="666" onclick="statisticsChange(666)"/> 
				平台:<input type="radio" name="radio" value="666" onclick="statisticsChange(888)"/> 
				<c:forEach items="${stas}" begin="1" var="item">
				   ${item.name}:<input type="radio" name="radio" value="666" onclick="statisticsChange(${item.value})"/>
				</c:forEach>
		</div> --%>

				<div class="row chartsTabs">
					<label onclick="statisticsChange(666)"> <input class="ace"
						type="radio" checked="checked" name="form-field-radio"> <span
						class="lbl"> 机构</span>
					</label> <label onclick="statisticsChange(888)"> <input class="ace"
						type="radio" name="form-field-radio"> <span class="lbl">
							平台</span>
					</label>

					<c:forEach items="${stas}" begin="1" var="item">
						<label onclick="statisticsChange(${item.value})"> <input
							class="ace" type="radio" name="form-field-radio"> <span
							class="lbl"> ${item.name}</span>
						</label>
					</c:forEach>
				</div>

			</div>
			<div class="mhySearch">
				<div class="mhyTitle">查询条件</div>
				<form id="searchForm" class="mhySearchInput">
						<div class="row">
							<div class="col-xs-12 col-sm-4" style="height: 32px;">
								<label class="col-xs-2 col-sm-4" for="inputError"><i style="color: red; margin-right: 5px;">*</i>开始日期:</label>
								<div class="col-xs-10 input-group col-sm-8"
									style="padding-left: 15px">
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
								<div class="col-xs-10 input-group col-sm-8"
									style="padding-left: 15px">
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
									<select id="org_select" class="selectpicker"
										data-live-search="true" multiple="multiple"
										data-live-search-placeholder="Search" data-actions-box="true">
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


						<div class="row">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">数据来源:</label>
								<div class="col-xs-10 col-sm-8 mhyOrgId "
									id="selectDxdiv">
									<select id="cczy06_select" class="selectpicker"
										data-live-search="true" multiple="multiple"
										data-live-search-placeholder="Search" data-actions-box="true">
										<xf:select isOnlyOptions="true" name="funplat"
											textField="name" tableName="TAB_DATASOURCES"
											valueField="code" isNoStyle="true" hasDefault="0"
											hasDefaultName="全部"></xf:select>
									</select>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">企业性质:</label>
								<div class="col-xs-10 col-sm-8 mhyOrgId "
									id="selectDxdiv">
									<select id="aab019_select" class="selectpicker"
										data-live-search="true" multiple="multiple"
										data-live-search-placeholder="Search" data-actions-box="true">
										<xf:select isOnlyOptions="true" name="funplat"
											textField="name" tableName="TAB_UNITNATURE" valueField="code"
											isNoStyle="true" hasDefault="0" hasDefaultName="全部"></xf:select>
									</select>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">自定行业:</label>
								<div class="col-xs-10 col-sm-8 mhyOrgId "
									id="selectDxdiv">
									<select id="ccpr10_select" class="selectpicker"
										data-live-search="true" multiple="multiple"
										data-live-search-placeholder="Search" data-actions-box="true">
										<xf:select isOnlyOptions="true" name="funplat"
											textField="name" tableName="INDUSTRY_AS" valueField="id" pidName="pid" pidValue="1"
											isNoStyle="true" hasDefault="0" hasDefaultName="全部"></xf:select>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">部标行业:</label>
								<div class="col-xs-10 col-sm-8 mhyOrgId "
									id="selectDxdiv">
									<select id="aab022_select" class="selectpicker"
										data-live-search="true" multiple="multiple"
										data-live-search-placeholder="Search" data-actions-box="true">
										<xf:select isOnlyOptions="true" name="funplat"
											textField="name" tableName="TAB_INDUSTRY" valueField="code" pidName="pcode" pidValue="0"
											isNoStyle="true" hasDefault="0" hasDefaultName="全部"></xf:select>
									</select>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">经济类型:</label>
								<div class="col-xs-10 col-sm-8 mhyOrgId "
									id="selectDxdiv">
									<select id="aab020_select" class="selectpicker"
										data-live-search="true" multiple="multiple"
										data-live-search-placeholder="Search" data-actions-box="true">
										<xf:select isOnlyOptions="true" name="funplat"
											textField="name" tableName="TAB_ECONOMIC" valueField="code"
											isNoStyle="true" hasDefault="0" hasDefaultName="全部"></xf:select>
									</select>
								</div>
							</div>
								<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">产业类别:</label>
								<div class="col-xs-10 col-sm-8 mhyOrgId "
									id="selectDxdiv">
									<select id="aab054_select" class="selectpicker"
										data-live-search="true" multiple="multiple"
										data-live-search-placeholder="Search" data-actions-box="true">
										<xf:select isOnlyOptions="true" name="funplat"
											textField="name" tableName="TAB_INDUSTRYCLASSES" valueField="code"
											isNoStyle="true" hasDefault="0" hasDefaultName="全部"></xf:select>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">人员规模:</label>
								<div class="col-xs-10 col-sm-8 mhyOrgId "
									id="selectDxdiv">
									<select id="aab056_select" class="selectpicker"
										data-live-search="true" multiple="multiple"
										data-live-search-placeholder="Search" data-actions-box="true">
										<xf:select isOnlyOptions="true" name="funplat"
											textField="name" tableName="TAB_PSCALE" valueField="code"
											isNoStyle="true" hasDefault="0" hasDefaultName="全部"></xf:select>
									</select>
								</div>
							</div>
						
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">有无招聘:</label>
								<div class="col-xs-10 col-sm-8 mhyOrgId "
									id="selectDxdiv">
									<select id="recruit_select" class="selectpicker"
										data-live-search="true" multiple="multiple"
										data-live-search-placeholder="Search" data-actions-box="true">
										 <option value="1">有</option>
										  <option value="0">无</option>
									</select>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">是否会员:</label>
								<div class="col-xs-10 col-sm-8 mhyOrgId "
									id="selectDxdiv">
									<select id="mem_select" class="selectpicker"
										data-live-search="true" multiple="multiple"
										data-live-search-placeholder="Search" data-actions-box="true">
										 <option value="1">有</option>
										  <option value="0">无</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
<!-- 							<div class="col-xs-12 col-sm-4"> -->
<!-- 								<label class="col-xs-2 col-sm-4" for="inputError">套餐类型:</label> -->
<!-- 								<div class="col-xs-10 col-sm-8 mhyOrgId " -->
<!-- 									id="selectDxdiv"> -->
<!-- 									<select id="pkg_code_select" class="selectpicker" -->
<!-- 										data-live-search="true" multiple="multiple" -->
<!-- 										data-live-search-placeholder="Search" data-actions-box="true"> -->
<%-- 										<xf:select isOnlyOptions="true" name="funplat" --%>
<%-- 											textField="name" tableName="TAB_JFFORM" valueField="code" --%>
<%-- 											isNoStyle="true" hasDefault="0" hasDefaultName="全部"></xf:select> --%>
<!-- 									</select> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="col-xs-12 col-sm-4"> -->
<!-- 								<label class="col-xs-2 col-sm-4" for="inputError">是否会员:</label> -->
<!-- 								<div class="col-xs-10 col-sm-8 mhyOrgId " -->
<!-- 									id="selectDxdiv"> -->
<!-- 									<select id="mem_select" class="selectpicker" -->
<!-- 										data-live-search="true" multiple="multiple" -->
<!-- 										data-live-search-placeholder="Search" data-actions-box="true"> -->
<!-- 										 <option value="1">有</option> -->
<!-- 										  <option value="0">无</option> -->
<!-- 									</select> -->
<!-- 								</div> -->
<!-- 							</div> -->
							<div class="col-xs-12 col-sm-8"></div>
							<div class="col-xs-12 col-sm-4 marginbottom20">
								<div class="col-xs-2 col-sm-4"></div>
								<div class="col-xs-10 col-sm-8 mhyBtn">
									<a href="javascript:void(0)" role="button"  id="search_button"
										class="btn btn-primary btn-border1 mhyBtnLeft" onclick="submitForm()">
										<i class="icon-search"></i>
										查询</a> <button
										href="#modal-form" role="button" type="button" onclick="doClear()"
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
				<div class="mhyInfo mhyConter" style="padding:0px !important;">
					<table id="jobFairInfoList" class="tableClassNoworks  table-striped"></table>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('myechartsPie'));
		var myChartBar = echarts.init(document.getElementById('myechartsBar'));
		statisticsChange('666');
		setTimeout(function (){

			window.onresize = function () {

			myChart.resize();

			myChartBar.resize();

			}

			},1)

	</script>

	<script type="text/javascript">
  jQuery(function($) {
 		// 日期选择
      $(".mhydatepicker").datetimepicker({
          todayBtn: true,
          format: "yyyy-mm-dd",
          startView: 2,
          minView: 2,
          language: 'cn',
          maxView: "decade",
          viewSelect: 2,
          autocomplete:true,
          autoclose:true
      });
  	$('.selectpicker').selectpicker({
		selectAllText : '全选',//全选的checkbox名称  
		deselectAllText : '取消',
		selectAllNumber : true,
		actionsBox:true,
		noneResultsText : "没有相关信息",liveSearchPlaceholder:"请输入搜索.."
	});
    });
</script>
</body>
</html>