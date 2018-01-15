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

<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
<script
	src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet"
	href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css"
	type="text/css" />
<script src="${ctx}/js/lib/bootstrap-select/bootstrap-select.js"></script>
<link href="${ctx}/assets/css/bootstrap.min.css" rel="stylesheet" />
<link type="text/css"
	href="${ctx}/js/lib/bootstrap-select/bootstrap-select.css"
	rel="stylesheet" />
<title>招聘会信息情况查询</title>
<script>
	$(function() {
		/**
		 初始化表格显示
		 */
		var columns = [{
			field : 'AAE020',
			title : '机构信息',
			width : '5%',
			align : 'center',
			formatter : function(value, row, index) {
				if (value) {
					return value;
				} else {
					return "其他";
				}
			}
		}, {
			field : 'ECZY06',
			title : '数据来源',
			width : '5%',
			align : 'center',
			formatter : function(value, row, index) {
				if (value) {
					return value;
				} else {
					if(row.LAST){
						return "-";
					}
					return "未知";
				}
			}
		},{
			field : 'COLUMNNAME',
			title : '细类',
			width : '5%',
			align : 'center'
		}, {
			field : 'PERNUM',
			title : '人数',
			width : '5%',
			align : 'center',
			formatter : function(value, row, index) {
				if(row.LAST){
					return row.TOTAL_NUM;
				}else{
					return value;
				}
			}
		}, {
			field : 'PERCENT',
			title : '比例',
			width : '5%',
			align : 'center',
			formatter : function(value, row, index) {
				return value?(value*100+'%'):'-';
			}
		}
		// 	                ,{field:'acb330',title:'操作',width:100,formatter: function(value,row,index){	 
		// 				           return "<a href=\"javascript:void(0)\" onclick=\"editJobFairInfo('"+value+"')\" >编辑</a>|"+
		// 								"<a href=\"javascript:void(0)\" onclick=\"delJobFairInfo('"+value+"')\" >删除</a>";
		// 							}
		// 					 }
		];
		$('#jobFairInfoList').bootstrapTable({
			url : '${ctx}/business/person/personBaseInfo/listStatisticsJson.xf',
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
	function refresh() {
		$('#jobFairInfoList').bootstrapTable('refresh');
	}
	function getSeachJson(params) {
		return {
			'limit' : params.limit,
			'offset' : params.offset,
			'order' : params.order,
			'startdate':$("#startdate").val(),
			'enddate':$("#enddate").val(),
			'aae017' :getSelectValues("org_select"),
			'cczy06' :$("#select_read").val(),
			'groupvalue' : $("#groupvalue").val()
		};
	}
	function doSearch() {
		$("#jobFairInfoList").bootstrapTable('refresh', {
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
		$("#select_read").val('');
		$("#groupvalue").val('');
	}
	function statisticsChange(obj){
		var datanamevalues = [];
		var title = "个人信息数据统计图";
	 	$.ajax({ url: '${ctx}/business/person/personBaseInfo/listStatisticsChartsJson.xf',
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
			<div class="mhySearch">
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
			<div class="mhyMain">
				<div class="mhyTitle">查询条件</div>
				<form id="searchForm" class="mhySearchInput">
					<div class="form-group">
						<div class="row">

							<div class="col-xs-12 col-sm-4" style="height: 32px;">
								<label class="col-xs-2 col-sm-4" for="inputError">开始日期:</label>
								<div class="col-xs-10 input-group col-sm-8"
									style="padding-left: 15px">
									<input id="startdate"
										class="form-control date-picker dp mhydatepicker" type="text"
										placeholder="请选择日期" name="beginaac006"> <span
										class="input-group-addon"> <i
										class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4" style="height: 32px;">
								<label class="col-xs-2 col-sm-4" for="inputError">结束日期:</label>
								<div class="col-xs-10 input-group col-sm-8"
									style="padding-left: 15px">
									<input id="enddate"
										class="form-control date-picker dp mhydatepicker" type="text"
										placeholder="请选择日期" name="beginaac006"> <span
										class="input-group-addon"> <i
										class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">机构信息:</label>
								<div class="col-xs-10 col-sm-8 mhyOrgId form-group"
									id="selectDxdiv">
									<select id="org_select" class="selectpicker"
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


						<div class="row">
							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">数据来源:</label>
								<div class="col-xs-10 col-sm-8 mhyNoSelect">
									<xf:select id="select_read" name="funplat" textField="name"
										tableName="TAB_DATASOURCES" valueField="code" isNoStyle="true"
										hasDefault="0" hasDefaultName="全部"></xf:select>
								</div>
							</div>

							<div class="col-xs-12 col-sm-4">
								<label class="col-xs-2 col-sm-4" for="inputError">细类信息:</label>
								<div class="col-xs-10 col-sm-8 mhyNoSelect">
									<select name="groupvalue" id="groupvalue">
										<c:forEach items="${stas}" begin="0" var="item">
											<option value="${item.value}">${item.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>


							<div class="col-xs-12 col-sm-4 marginbottom20">
								<div class="col-xs-2 col-sm-4"></div>
								<div class="col-xs-10 col-sm-8 mhyBtn">
									<a href="#modal-form" role="button" onclick="doSearch()"
										class="btn btn-primary btn-border1 mhyBtnLeft">查询</a> <a
										href="#modal-form" role="button" onclick="doClear()"
										class="btn">重置</a>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="mhyMain"> 
				<div class="mhyTitle">查询结果</div>
				<div class="mhyInfo">
					<table id="jobFairInfoList" class="tableClassNoworks"></table>
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
		actionsBox:false,
		noneResultsText : "没有相关信息",liveSearchPlaceholder:"请输入搜索.."
	});
    });
</script>
</body>
</html>