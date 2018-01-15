<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp"%>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${ctx}/assets/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/daterangepicker.css" />


<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />
<script src="${ctx}/assets/js/echarts/echarts.min.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/ui/xf.treeorg.js?version=201609231008"></script>
<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
<script
	src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script>
	<link href="${ctx}/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet"
	href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css"
	type="text/css" />
<script src="${ctx}/js/lib/bootstrap-select/bootstrap-select.js"></script>

<link type="text/css"
	href="${ctx}/js/lib/bootstrap-select/bootstrap-select.css"
	rel="stylesheet" />
	<link rel="stylesheet"
	href="${ctx}/js/lib/bootstrap-validator/css/bootstrapValidator.css"
	type="text/css">
	<script type="text/javascript"
	src="${ctx}/js/lib/jquery/bootstrap-contextmenu.js"></script>
<title>招聘会信息情况查询</title>
<script>
var columns = null;
	$(function() {
		$("#aae017n").treeorg({callBack:function(data){
			$("#aae017n").val(data.orgName);
			$("#aae017").val(data.orgId);
			}
		});
		/**
		 初始化表格显示
		 */
		 columns = [
		               {
			field : 'DATA_DATE',
			title : '统计时间',
			width : '5%',
			align : 'center'
				,
				formatter : function(value, row, index) {
					return  value.replace("1900-01-01","");
				}
		},{
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
		}
		, {
			field : 'BCB209N',
			title : '数据来源',
			width : '5%',
			align : 'center',
			visible:false
		}
		, {
			field : 'AAD004N',
			title : '性别',
			width : '5%',
			align : 'center',
			visible:false
		}
		, {
			field : 'ACB223N',
			title : '年龄',
			width : '5%',
			align : 'center',
			visible:false
		}
		, {
			field : 'AAC011N',
			title : '学历',
			width : '5%',
			align : 'center',
			visible:false
		}
		, {
			field : 'AAC009N',
			title : '户口性质',
			width : '5%',
			align : 'center',
			visible:false
		}
		, {
			field : 'ACC01GN',
			title : '专业要求',
			width : '5%',
			align : 'center',
			visible:false
		}
		, {
			field : 'BQ_GRQZS',
			title : '统计人数',
			width : '5%',
			align : 'center'
		},{
			field : 'BQ_RATE',
			title : '统计人数所占比例(%)',
			width : '5%',
			visible:false,
			align : 'center'
		}, {
			field : 'SQ_GRQZS',
			title : '上期统计人数',
			width : '5%',
			visible:false,
			align : 'center',
			formatter : function(value, row, index) {
				if(row.LAST){
					return row.TOTAL_NUM;
				}else{
					return value;
				}
			}
		}, {
			field : 'BQ_SQ_GRQZS',
			title : '本期减上期人数',
			width : '5%',
			visible:false,
			align : 'center' 
		}
		, {
			field : 'HB_RATE',
			title : '统计人数环比(%)',
			visible:false,
			width : '5%',
			align : 'center' 
		}
		, {
			field : 'TQ_GRQZS',
			title : '同期统计人数',
			width : '5%',
			visible : false,
			align : 'center' 
		}
		, {
			field : 'BQ_TQ_GRQZS',
			title : '本期减同期人数',
			visible : false,
			width : '5%',
			align : 'center' 
		}
		, {
			field : 'TB_RATE',
			title : '统计人数同比(%)',
			visible:false,
			width : '5%',
			align : 'center' 
		}
		// 	                ,{field:'acb330',title:'操作',width:100,formatter: function(value,row,index){	 
		// 				           return "<a href=\"javascript:void(0)\" onclick=\"editJobFairInfo('"+value+"')\" >编辑</a>|"+
		// 								"<a href=\"javascript:void(0)\" onclick=\"delJobFairInfo('"+value+"')\" >删除</a>";
		// 							}
		// 					 }
		];
		$('#jobFairInfoList').bootstrapTable({
			url : '${ctx}/business/dissupport/statistics/statistics/getPersonBaseInfoStatisticsJson.xf',
			columns : columns,
			method : "post",
			contentType : "application/x-www-form-urlencoded",
			pagination : false,
			pageSize : 10,
			pageList : [ 10, 15, 20 ],
			clickToSelect : true,
			singleSelect : false,
			sidePagination : "server",
			striped : true,
			queryParams : getSeachJson,
			onLoadSuccess:function(){
				$("#search_id").removeAttr("disabled");
			},
			onLoadError :function (status){
				$("#search_id").removeAttr("disabled");
				bootbox.alert("加载数据超时");
			}
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
			$(".btn").removeAttr("disabled");
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
	function getSeachJson(params) {
		var AAD004 = getSelectValues("sex_select");
		var BCB209 = getSelectValues("bcb209_select");
		var ACC01G = getSelectValues("acc01g_select");
		var AAC011 = getSelectValues("aac011_select");
		var ACB223 = getSelectValues("acb223_select");
		var AAC009 = getSelectValues("aac009_select");
		$("#jobFairInfoList").bootstrapTable(AAD004?'showColumn':'hideColumn', 'AAD004N');
		$("#jobFairInfoList").bootstrapTable(BCB209?'showColumn':'hideColumn', 'BCB209N');
		$("#jobFairInfoList").bootstrapTable(AAC011?'showColumn':'hideColumn', 'AAC011N');
		$("#jobFairInfoList").bootstrapTable(ACB223?'showColumn':'hideColumn', 'ACB223N');
		$("#jobFairInfoList").bootstrapTable(AAC009?'showColumn':'hideColumn', 'AAC009N');
		$("#jobFairInfoList").bootstrapTable(ACC01G?'showColumn':'hideColumn', 'ACC01GN');
		return {
			'limit' : params.limit,
			'offset' : params.offset,
			'order' : params.order,
			'STARTDATE':$("#startdate").val(),
			'ENDDATE':$("#enddate").val(),
			'AAE017' :$("#aae017").val(),
			'BCB209' :BCB209,
			'AAD004' :AAD004,
			'ACC01G' :ACC01G,
			'AAC011' :AAC011,
			'ACB223' :ACB223,
			'AAC009' :AAC009
		};
	}
	function doSearch() {
		$("#search_id").attr("disabled",true);
		$("#jobFairInfoList").bootstrapTable('refresh', {
			columns : columns,
			query : getSeachJson
		})
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
	function doClear() {
		$("#startdate").val('')
		$("#enddate").val('');
		$('.selectpicker').selectpicker('val','');
		resetForm("searchForm");
	}
	function statisticsChange(obj){
		var datanamevalues = [];
		var title = "个人信息数据统计图";
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
	             x: 60,
	             x2: 100,
	             y2: 120,// y2可以控制 X轴跟Zoom控件之间的间隔，避免以为倾斜后造成 label重叠到zoom上
	         },
		    legend: {
		        data:[]
		    },
		    xAxis: [
		        {
		            type: 'category',
		            data: datanames,
		            axisLabel:{'interval':0,
	                     rotate:45,
                        margin:2,
                        textStyle:{
                            color:"#222"
                        }}
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            name: '人数',
		       
		            axisLabel: {
		                formatter: '{value}'
		            }
		        }
		     
		    ],
		    series: [
		        {
		            name:'人数',
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
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="mhyBody">
			<div class="mhySearch" style="display: none;">
				<div class="mhyTitle" >机构个人信息数据统计图</div>

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
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">
								<i style="color: red; margin-right: 5px;">*</i>开始日期:</label>
								<div class="col-xs-10 col-sm-8">
									<div class="input-group" style="padding: 0 !important;">
									<input id="startdate" class="form-control date-picker dp mhydatepicker"  type="text"
										placeholder="请选择日期" name="startdate"  data-options="required:false"> 
										<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i> </span>
										</div>
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
									<select id="bcb209_select" class="selectpicker"
										data-live-search="true" multiple="multiple"
										data-live-search-placeholder="Search" data-actions-box="true">
										<xf:select  name="funplat"
											isOnlyOptions="true" textField="name"
											tableName="TAB_DATASOURCES" valueField="code"
											isNoStyle="true" hasDefault="0" hasDefaultName="全部"></xf:select>
									</select>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">性别:</label>
									 <div class="col-xs-10 col-sm-8 mhyOrgId "
									id="selectDxdiv">
									<select id="sex_select" class="selectpicker"
										data-live-search="true" multiple="multiple"
										data-live-search-placeholder="Search" data-actions-box="true">
										<xf:select  name="funplat"
											isOnlyOptions="true" textField="name"
											tableName="TAB_SEX" valueField="code"
											isNoStyle="true" hasDefault="0" ></xf:select>
									</select>
								</div>
							</div>
                       <div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">专业要求:</label>
									 <div class="col-xs-10 col-sm-8 mhyOrgId "
									id="selectDxdiv">
									<select id="acc01g_select" class="selectpicker"
										data-live-search="true" multiple="multiple"
										data-live-search-placeholder="Search" data-actions-box="true">
										<xf:select  name="funplat" pidName="pcode"
											isOnlyOptions="true" textField="name"
											tableName="TAB_PROFESSION" valueField="code" 
											isNoStyle="true" hasDefault="0" ></xf:select>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
						           <div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">学历:</label>
									 <div class="col-xs-10 col-sm-8 mhyOrgId "
									id="selectDxdiv">
									<select id="aac011_select" class="selectpicker"
										data-live-search="true" multiple="multiple"
										data-live-search-placeholder="Search" data-actions-box="true">
										<xf:select  name="funplat"
											isOnlyOptions="true" textField="name"
											tableName="TAB_EDUCATION" valueField="code"
											  ></xf:select>
									</select>
								</div>
							</div>
							           <div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">年龄:</label>
									 <div class="col-xs-10 col-sm-8 mhyOrgId "
									id="selectDxdiv">
									<select id="acb223_select" class="selectpicker"
										data-live-search="true" multiple="multiple"
										data-live-search-placeholder="Search" data-actions-box="true">
										<xf:select  name="funplat"
											isOnlyOptions="true" textField="name"
											tableName="TAB_AGES" valueField="code"
											isNoStyle="true" hasDefault="0" ></xf:select>
									</select>
								</div>
							</div>
							           <div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">户口性质:</label>
									 <div class="col-xs-10 col-sm-8 mhyOrgId "
									id="selectDxdiv">
									<select id="aac009_select" class="selectpicker"
										data-live-search="true" multiple="multiple"
										data-live-search-placeholder="Search" data-actions-box="true">
										<xf:select  name="funplat"
											isOnlyOptions="true" textField="name"
											tableName="TAB_CATEGORY" valueField="code"
											isNoStyle="true" hasDefault="0" ></xf:select>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
						   <div class="col-xs-12 col-sm-4"></div>
						    <div class="col-xs-12 col-sm-4"></div>
							<div class="col-xs-12 col-sm-4 marginbottom20">
									<div class="col-xs-2 col-sm-4"></div>
									<div class="col-xs-10 col-sm-8 mhyBtn">
										<button role="button" id="search_id"
											class="btn btn-primary btn-border1 mhyBtnLeft" type="submit">
											<i class="icon-search"></i>
											查询
											</button> <button
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
				<div class="mhyInfo mhyConter" >
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