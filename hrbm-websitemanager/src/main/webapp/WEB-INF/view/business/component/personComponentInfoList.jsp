<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>工具箱模板栏目管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<%@include file="/commons/include/bootstrapInc.jsp" %>
<script>
	var sign='${sign}';
	$(function() {
		/**
		 初始化表格显示
		 */
		initTable();
	})
		function initTable() {
			var columns= [[
							{field:'',title:'序号',formatter:function(value, row, index){
								   return index+1;
							}},
// 			                {field : 'status',title : '选择',radio : 'true',width : '5%',align : 'center'
// 			       		   },
		                   {field:'AAC002',title:'身份证号'},
		                   {field:'AAC003',width:80,title:'姓名'},
		                   {field:'AAC004',title:'性别'},
		                   {field:'AAC005',title:'民族'},
		                   {field:'AAC006',title:'出生日期',formatter:function(value,row,index){return formateDate(value);}},
		                   {field:'AAC009',title:'户口性质'},
		                   {field:'BAB305',title:'户口所在地'},
		                   {field:'AAC011',title:'文化程度'},
		                   {field:'AAC024',title:'政治面貌'},
		                   {field:'AAE005',title:'联系电话'},
		                   {field:'AAB301',title:'居住所在地'},

		                   {field:'AAC00B',title:'楼院'},
		                   {field:'AAC00C',title:'单元'},
		                   {field:'AAC00D',title:'门牌号'},
		                   {field:'AAC025',title:'祖籍'},
		                   {field:'AAC036',title:'视力'},
		                   {field:'AAC034',title:'身高'},
		                   {field:'AAC035',title:'体重'},
		                   {field:'AAC032',title:'血型'},
		                   {field:'AAC033',title:'健康状况'},

		                   {field:'AAC022',title:'姓名拼音码'},
		                   {field:'AAC023',title:'个人英文名'},
		                   {field:'AAE007',title:'邮编'},
		                   {field:'AAE015',title:'电子信箱'},
		                   {field:'AAC180',title:'毕业学校'},
		                   {field:'AAC181',title:'毕业时间'},
		                   {field:'AAC00E',title:'目前住房情况'},
		                   {field:'AAC00A',title:'军人证号'},
		                   {field:'AAE013',title:'备注'},

		                   {field:'AAE036',title:'经办日期'},
		                   {field:'AAE020',title:'经办机构'},
		                   {field:'AAE019',title:'经办人'},
		                   {field:'ECZY06',title:'数据来源'}

// 		                   ,
// 			               {field:'aac001',title:'操作',width:150,formatter: function(value,row,index){
// 					           return  "<a href=\"javascript:void(0)\" onclick=\"selctPerson('"+value+"')\" >详情</a>";
// 							}
// 		                   }
	      	        	]];
			$('#personBaseInfoList').bootstrapTable({
				url : '${ctx}/business/component/component/personBaseListJson.xf?cczy06=${cczy06}',
				columns: columns,
			    method:"post",
			    contentType:"application/x-www-form-urlencoded",
				pagination:true,
				pageSize:10,
				pageList:[10, 15, 20],
			    clickToSelect:true,
			    sidePagination:"server",
			    striped:true,
			    queryParams : getSeachJson,
			    onDblClickRow :function(rowIndex, rowData){
			    	var parentIframe=xfui.getParentIframe();
					parentIframe.checkAac001CallBack(rowIndex);
					closeItem();
				}
			    /* ,
			    onClickRow :function(rowIndex, rowData){
			    	var id=rowIndex.aac001;
		        	logsTable(id);
		        	} */
			});
		}
	function getSeachJson(params) {
		if(isDosearch){
			params.offset = 0;
			isDosearch = false;
		}
		return $("form").serialize()+"&limit="+params.limit+"&offset="+params.offset+"&order="+params.order;
	}
	/* 劳动力采集系统编辑个人基本信息 */
	function editPerson(value){
		xfui.open_tabs("个人基本信息维护","/business/laborcollection/laborAccom/returnList.xf?aac001="+value,"个人基本信息查询");
	}
	function selctPerson(value){
		if(sign==""){
			xfui.open_dialog({
	  		    title: '查看个人基本信息',
	  		    width: 900,
	  		    height: 500,
	  		    closed: false,
	  		    cache: false,
	  		    url: "${ctx}/business/person/personBaseInfo/selctPerson.xf?aac001="+value,
	  		    modal: true
	  		})
		}else{
			xfui.open_dialog({
	  		    title: '查看个人基本信息',
	  		    width: 900,
	  		    height: 500,
	  		    closed: false,
	  		    cache: false,
	  		    url: "${ctx}/business/laborcollection/laborAccom/selctPerson.xf?aac001="+value,
	  		    modal: true
	  		})
		}

	}
	function refresh(){
		$("#personBaseInfoList").bootstrapTable('refresh');
	}
	var isDosearch = false;
	function doSearch(){
		var json = $("#searchForm").serializeJson();
		isDosearch = true;
		$("#personBaseInfoList").bootstrapTable('refresh', {
			url:'${ctx}/business/component/component/personListJson.xf?cczy06=${cczy06}',
			query: json
		})
	}
	function closeItem() {
		xfui.closeDialog();
	}
	function saveSubmit() {
		var row = $('#personBaseInfoList').bootstrapTable('getAllSelections');
		$(".btn-submit").attr("disabled");
		if (row) {
		var parentIframe=xfui.getParentIframe();
		parentIframe.checkAac001CallBack(row[0]);
		}else{
			bootbox.alert('请选择一条信息');
			return;
		}
		closeItem();
	}

	function doClearParent(){
		var utype = '${utype}';
		var parentIframe=xfui.getParentIframe();
		if(utype=='1'){
			parentIframe.clearUserMessageUpdate();
		}else{
			parentIframe.clearUserMessageAdd();
		}
		xfui.closeDialog();
	}
</script>
</head>
<body>
		<div class="main-container">
			<div class="container-fluid">
				<div class="mhyBody">
					<div class="mhySearch">
					<form id="searchForm" class="mhySearchInput">
							<div class="row">
								<div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">身份证号:</label>
									<div class="col-xs-10 col-sm-8">
										<input class="form-control" type="text" id="aac002" name="Q_aac002_SUPL" data-placement="bottom" />
									</div>
								</div>
								<div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">姓名:</label>
									<div class="col-xs-10 col-sm-8">
										<input class="form-control" type="text" id="aac003" name="Q_aac003_SL" data-placement="bottom" />
									</div>
								</div>
									<div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">联系电话:</label>
									<div class="col-xs-10 col-sm-8">
										<input class="form-control" type="text" id="aac003" name="Q_aae005_SL" data-placement="bottom" />
									</div>
								</div>
								</div>
								<div class="row">
								 	<div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">性别:</label>
									<div class="col-xs-10 col-sm-8  mhyNoSelect">
										<xf:select textField="name" tableName="TAB_SEX" hasDefault="0" id="aac004" name="aac004n" valueField="code"></xf:select>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">户口性质:</label>
									<div class="col-xs-10 col-sm-8  mhyNoSelect">
										<xf:select textField="name" tableName="TAB_CATEGORY" hasDefault="0" id="aac009" name="aac009n" valueField="code"></xf:select>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">户口所在地:</label>
									<div class="col-xs-10 col-sm-8">
										<input class="form-control" type="text" id="aab301" name="Q_bab305_SL" data-placement="bottom" />
									</div>
								</div>
								</div>
								<div class="row" >
								<div class="col-xs-12 col-sm-4" >
									<label style="display: none;" class="col-xs-2 col-sm-4" for="inputError">个人状态:</label>
									<div style="display: none;" class="col-xs-10 col-sm-8  mhyNoSelect">
										<xf:select textField="name"  tableName="TAB_PSTATUS" hasDefault="0" id="expPersonStatus" name="expPersonStatus" valueField="code" ></xf:select>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4" >
									<label style="display: none;" class="col-xs-2 col-sm-4" for="inputError">文化程度:</label>
									<div style="display: none;" class="col-xs-10 col-sm-8 mhyNoSelect">
										<xf:select textField="name" tableName="TAB_EDUCATION" id="aac011" name="aac011n"  valueField="code" hasDefault="0"></xf:select>
									</div>
								</div>
									<div class="col-xs-12 col-sm-4 marginbottom20">
											<div class="col-xs-2 col-sm-4"></div>
											<div class="col-xs-10 col-sm-8 mhyBtn">
												<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary btn-border1 mhyBtnLeft" >
												<i class="icon-search"></i>查询
												</a>

												<!-- <input role="button" type="reset" class="btn" /> -->
												<a class="btn btn-info resetBtn" role="button"  href="#modal-form">
													<i class="icon-repeat"></i>重置
												</a>
											</div>
										</div>
								</div>

						</form>
					</div>
					 <div class="mhyMain">
						<div class="mhyInfo">
						<div class="row mhyConter">
							<div class="col-xs-12">
								<div class="table-responsive">
									<table id="personBaseInfoList" class="datagridClass tableClassNoworks" >
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
  jQuery(function($) {
 		// 日期选择
      $(".datepicker01").datetimepicker({
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
      $(".resetBtn").click(function(){
  		$("#searchForm")[0].reset();
  		});
    });
</script>
</html>
