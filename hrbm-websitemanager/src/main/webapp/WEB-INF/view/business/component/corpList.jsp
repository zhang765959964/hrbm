<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>单位基本信息管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<%@include file="/commons/include/bootstrapInc.jsp" %>

<script>
	$(function() {
		/**
		 初始化表格显示
		 */
		initTable();
	})
	function initTable() {
		var columns = [
					   {field:'',title:'序号',formatter:function(value, row, index){
						   return index+1;  
					   }},
// 	                   {field:'aab001',title:'操作',width:80,formatter: function(value,row,index){	 
// 				           return "<a class=\"mhyNoA\" href=\"javascript:void(0)\" onclick=\"corpDetails('"+value+"')\" ><i class=\"icon-zoom-in\" title=\"查看详情\"></i></a>";
// 						}},
	                   {field:'aab004',title:'单位名称'},
	                   {field:'aab020',title:'经济类型'},
	                   {field:'aab054',title:'产业类别'},
	                   {field:'aab022',title:'所属行业'},
	                   {field:'aab003',title:'组织机构代码'},
					   {field:'aab007',title:'工商登记执照号码'},
	                   {field:'aae004',title:'联系人'},
	                   {field:'aae005',title:'联系电话'},
	                   {field:'aaa021',title:'所在地区'},
	                   {field:'aab010',title:'工商执照起始日期',formatter:function(value,row,index){
	                	   if(value==null){return "";}else{return formateDate(value);}}},
	                   {field:'aab011',title:'工商执照终止日期',formatter:function(value,row,index){
	                	   if(value==null){return "";}else{return formateDate(value);}}},
	                   {field:'aab021',title:'隶属关系'},
	                   {field:'aab013',title:'法定代表人'},
	                   {field:'aab014',title:'法定代表人身份证号码'},
	                   {field:'aab023',title:'主管部门'},
	                   {field:'aae020',title:'经办机构'},
	                   {field:'aae019',title:'经办人'},
	                   {field:'aae036',title:'经办日期',formatter:function(value,row,index){return formateDate(value);}},
	                   
	                   ] ;
		$('#corpList').bootstrapTable({
			url : '${ctx}/business/component/component/listCorpJson.xf',
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
				parentIframe.checkCorpCallBack(rowIndex);
				closeItem();
			}
		});
	}
	function getSeachJson(params) {
		if(isDosearch){
			params.offset = 0;
			isDosearch = false;
		}
		return $("form").serialize()+"&limit="+params.limit+"&offset="+params.offset+"&order="+params.order;
	}
	function corpDetails(value){
		xfui.open_dialog({    
  		    title: '单位基本信息详情',    
  		    width: 800,    
  		    height: 500,    
  		    closed: false,    
  		    cache: false,    
  		    url: "${ctx}/business/corp/corp/corpDetails.xf?aab001="+value,
  		    modal: true   
  		})
		// xfui.open_tabs("信息详情","${ctx}/business/corp/corp/corpDetails.xf?aab001="+value,"单位基本信息详情");				
	}
	
	function refresh(){
		$('#corpList').bootstrapTable('refresh');
	} 
	var isDosearch = false;
	function doSearch() {
		var json = $("#searchForm").serializeJson();
		isDosearch = true;
		$("#corpList").bootstrapTable('refresh', {	
			url:'${ctx}/business/component/component/listCorpJson.xf',
			query: json
		})
	}
	function doClear(){
		$("#searchForm").find(".form-control").each(function(){
			$(this).val("");
		});
	}
	function closeItem() {
		xfui.closeDialog();
	}
</script>
</head>
 <body>
	<div class="main-container">
		<div class="container-fluid">
			<div class="mhyBody">
				<div class="mhySearch">
<!-- 				<div class="mhyTitle"> -->
<!-- 					查询条件 -->
<!-- 				</div> -->
				<form id="searchForm" class="mhySearchInput">
					<div class="row">
						<div class="col-xs-12 col-sm-4" >
							<label class="col-xs-2 col-sm-4" for="inputError">单位名称:</label>
							<div class="col-xs-10 col-sm-8">
								<input class="form-control" type="text" id="aab004" name="Q_aab004_SL" data-placement="bottom" />
							</div>
						</div>
						<div class="col-xs-12 col-sm-4" >
							<label class="col-xs-2 col-sm-4" for="inputError">组织机构代码:</label>
							<div class="col-xs-10 col-sm-8">
								<input class="form-control" type="text" id="aab003" name="Q_aab003_SL" data-placement="bottom" />
							</div>
						</div>
						<div class="col-xs-12 col-sm-4" >
							<label class="col-xs-2 col-sm-4" title="工商营业执照号码" for="inputError">工商营业执照号码:</label>
							<div class="col-xs-10 col-sm-8">
								<input class="form-control" type="text" id="aab007" name="Q_aab007_SL" data-placement="bottom" />
							</div>
						</div>
						</div>
						<div class="row">
						<div class="col-xs-12 col-sm-4" >
							<label class="col-xs-2 col-sm-4" for="inputError">产业类别:</label>
							<div class="col-xs-10 col-sm-8 mhyNoSelect">
								<xf:select selectClass="form-control" textField="name" tableName="TAB_INDUSTRYCLASSES" hasDefault="0" id="aab054" name="aab054" valueField="code"></xf:select>
							</div>
						</div>
					
						<div class="col-xs-12 col-sm-4" >
							<label class="col-xs-2 col-sm-4" for="inputError">单位性质:</label>
							<div class="col-xs-10 col-sm-8 mhyNoSelect">
								<xf:select selectClass="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" id="aab019" name="aab019" valueField="code"></xf:select>  
							</div>
						</div>
							<div class="col-xs-12 col-sm-4" >
						
							<label class="col-xs-2 col-sm-4" for="inputError">经济类型:</label>
							<div class="col-xs-10 col-sm-8 mhyNoSelect">
								<xf:select selectClass="form-control" textField="name" tableName="TAB_ECONOMIC" hasDefault="0" id="aab020" name="aab020" valueField="code"></xf:select>
							</div>
						</div>
						</div><div class="row">
						<div class="col-xs-12 col-sm-4">
							<label class="col-xs-2 mhyNoPadding  col-sm-4" for="inputError">所属行业:</label>
							<div class="col-xs-10 input-group col-sm-8"  style="padding-left:15px">
                              <input class="form-control" type="text" id="aab022_name" name="Q_aab022_name_SL" data-placement="bottom" />
                              <!-- <input class="form-control" type="text" name="aab301" data-placement="bottom" /> -->
                           </div>
						</div>
						<div class="col-xs-12 col-sm-4" >
							<label class="col-xs-2 col-sm-4" title="联系人" for="inputError">联系人:</label>
							<div class="col-xs-10 col-sm-8 mhyNoSelect">
								<input class="form-control" type="text" id="aae004" name="Q_aae004_SL" data-placement="bottom" />
							</div>
						</div>
						<div class="col-xs-12 col-sm-4" >
							<label class="col-xs-2 col-sm-4" for="inputError">联系电话:</label>
							<div class="col-xs-10 col-sm-8 mhyNoSelect">
								<input class="form-control" type="text" id="aae005" name="Q_aae005_SL" data-placement="bottom" />
							</div>
						</div>
						</div><div class="row">
						<div class="col-xs-12 col-sm-4"></div>
						<div class="col-xs-12 col-sm-4"></div>
						<div class="col-xs-12 col-sm-4 marginbottom20">
						<label class="col-xs-2 mhyNoPadding  col-sm-4"></label>
							<div class="col-xs-10 col-sm-8 mhyBtn">
							<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary mhyBtnLeft" >
								<i class="icon-search"></i>
								查询
							</a>
		<!-- 					<a  class="btn btn-info">
							<i class="icon-repeat"></i>
							<input role="button"  class="btn mhyInputBtn" type="reset"/>
							</a> -->
							
							<button type="button" onclick="doClear()" href="#modal-form" role="button"  class="btn btn-info resetBtn" >
								<i class="icon-repeat"></i>重置
							</button>
						
							</div>
						</div>
						</div>
					</form>
				</div>
				<div class="mhyMain"> 
<!-- 					<div class="mhyTitle">查询结果</div> -->
					<div class="mhyInfo" >
						<div class="row mhyConter">
							<div class="col-xs-12">
								<div class="table-responsive">
									<table id="corpList"  class="datagridClass tableClassNoworks"  >
									</table>
								</div>
								<!-- <div style="margin-left: 450px;margin-top: -55px;">
									<a href="javascript:void(0)" onclick="exportData()" role="button" class="btn btn-primary" data-toggle="modal">导出</a>
									<a href="javascript:void(0)" onclick="addCorp()" role="button" class="btn btn-primary" data-toggle="modal">导入</a>
								</div> -->
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
      $("#datepicker01").datetimepicker({
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
     $(".dp").datetimepicker({
          todayBtn: true,
          format: "yyyy-mm-dd",
          startView: 2,
          minView: 2,
          maxView: "decade",
          viewSelect: 2,
          language: 'cn',
          autocomplete:true,
          autoclose:true
      });
      $(".dpMonth").datetimepicker({
          todayBtn: true,
          format: "yyyy-mm",
          startView: 3,
          minView: 3,
          maxView: "decade",
          language: 'cn',
          viewSelect: 3,
          autocomplete:true,
          autoclose:true
      });
    });
</script> 
</html>	



