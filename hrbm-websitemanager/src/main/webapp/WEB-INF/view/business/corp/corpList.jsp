<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>单位基本信息管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>


<script>
	var dataJson = {};
	$(function() {
		/**
		 初始化表格显示
		 */
		initTable();
		initDataExp();
	})
	function initTable() {
		var columns = [
					   
	                   {name:'aab001',label:'操作',key:true,align:'center',formatter: function(value,row,index){	 
				           return "<a class=\"mhyNoA\" href=\"javascript:void(0)\" onclick=\"corpDetails('"+value+"')\" ><i class=\"icon-zoom-in\" title=\"查看详情\"></i></a>";
						}},
	                   {name:'aab004',label:'单位名称',align:'center'},
	                   {name:'aab020',label:'经济类型',align:'center'},
	                   {name:'aab054',label:'产业类别',align:'center'},
	                   {name:'aab022',label:'行业代码',align:'center'},
	                   {name:'aae004',label:'劳动保障工作联系人',align:'center'},
	                   {name:'aae005',label:'联系电话',align:'center'},
	                   {name:'aaa021',label:'所在地区',align:'center'},
	                   {name:'aab007',label:'工商登记执照号码',align:'center'},
					   {name:'aab003',label:'组织机构代码',align:'center'},
	                   {name:'aab010',label:'工商执照起始日期',align:'center',formatter:function(value,row,index){
	                	   if(value==null){return "";}else{return formateDate(value);}}},
	                   {name:'aab011',label:'工商执照终止日期',formatter:function(value,row,index){
	                	   if(value==null){return "";}else{return formateDate(value);}}},
	                   {name:'aab021',label:'隶属关系',align:'center'},
	                   {name:'aab013',label:'法定代表人',align:'center'},
	                   {name:'aab014',label:'法定代表人身份证号码',align:'center'},
	                   {name:'cczy06',label:'数据来源',align:'center'},
	                   {name:'aab023',label:'主管部门',align:'center'},
	                   {name:'aae020',label:'经办机构',align:'center'},
	                   {name:'aae019',label:'经办人',align:'center'},
	                   {name:'aae036',label:'经办日期',align:'center',formatter:function(value,row,index){
	                	   if(value==null){return "";}else{return formateDate(value);}}}
	                   
	                   ] ;
		$("#corpList").jqGrid({
	           mtype: "GET",
			   styleUI : 'Bootstrap',
	           datatype: "local",
	           colModel: columns,
			   viewrecords: true,
	           rowNum: 10,
	           rowList:[10,20,30],
	           pager: "#jqGridPager",
	           pagerpos:'left',
	           regional : 'cn',
	           recordpos:'right',
	           shrinkToFit: false,
	           multiselect:true,
	           autowidth: true,
	           height:'100%',
	           rownumbers : true
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
  		    url: "${ctx}/business/corp/corp/corpDetails.xf?cczy=${cczy}&aab001="+value,
  		    modal: true   
  		})
		// xfui.open_tabs("信息详情","${ctx}/business/corp/corp/corpDetails.xf?aab001="+value,"单位基本信息详情");				
	}
	
	function refresh(){
		$('#corpList').bootstrapTable('refresh');
	} 

	function doSearch(){
		$("#corpList").jqGrid("clearGridData");	
		var json = $("#searchForm").serializeJson();
		dataJson  = json;
		$("#corpList").jqGrid("setGridParam",{datatype:'json',url:'${ctx}/business/corp/corp/listJson.xf?ccpr08=0',postData:json}).trigger("reloadGrid");

	}
	
	function initDataExp(){
		$('#exp').dataexp({
			gridId:"corpList",
			serviceId:'retiredDeclareExpServiceImpl',
			fileName:'单位信息查询',
			sheetName:'单位信息查询',
			menuItem:[{title:"导出全部数据",paramCallBack:function(){
				dataJson.level = 'z';
				debugger;
				var id = $("#corpList").jqGrid("getDataIDs");	   
	        		if(id&&id.length>0){
	        			return dataJson;
	        		}else{
	        			bootbox.alert("无可导出的数据！");
	        			return false;
	        		}	
			           }},
				        {title:"导出当前页数据",paramCallBack:function(){
				        	var ids = $("#corpList").jqGrid("getDataIDs");	        		
				        	if(ids&&ids.length>0){
			        			var id="";
			        			$.each(ids,function(i,e){
			        				if(i==0){
			        					id+="'"+e+"'";
			        				}else{
			        					id+=","+"'"+e+"'";
			        				}
			        			});
			        			return {level:'z',ids:id};
			        		}else{
			        			bootbox.alert("请选择记录！");
			        			return false;
			        		}			        		
			  				 }
					     }
			          ]
		});
	}
	
	
</script>

</head>
 <body>
 	<div class="container-fluid">
		<div class="row">
 			<div class="moduleWrapNobg">
				<div class="moduleTit"><i class="icon-minus icon-rotate-90"></i>查询条件</div>
				<div class="moduleCont">
	                 <form id="searchForm" >
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
							<label class="col-xs-2 col-sm-4" for="inputError">经济类型:</label>
							<div class="col-xs-10 col-sm-8 mhyNoSelect">
								<xf:select textField="name" tableName="TAB_ECONOMIC" hasDefault="0" id="aab020" name="aab020" valueField="code"></xf:select>
							</div>
						</div>
						<div class="col-xs-12 col-sm-4" >
							<label class="col-xs-2 col-sm-4" for="inputError">单位性质:</label>
							<div class="col-xs-10 col-sm-8 mhyNoSelect">
								<xf:select textField="name" tableName="TAB_UNITNATURE" hasDefault="0" id="aab019" name="aab019" valueField="code"></xf:select>  
							</div>
						</div>
						<div class="col-xs-12 col-sm-4" >
							<label class="col-xs-2 col-sm-4" for="inputError">产业类别:</label>
							<div class="col-xs-10 col-sm-8 mhyNoSelect">
								<xf:select textField="name" tableName="TAB_INDUSTRYCLASSES" hasDefault="0" id="aab054" name="aab054" valueField="code"></xf:select>
							</div>
						</div>
						</div>
						<div class="row">
						<div class="col-xs-12 col-sm-4" >
							<label class="col-xs-2 col-sm-4" for="inputError">联系电话:</label>
							<div class="col-xs-10 col-sm-8 mhyNoSelect">
								<input class="form-control" type="text" id="aae005" name="Q_aae005_SL" data-placement="bottom" />
							</div>
						</div>
						<div class="col-xs-12 col-sm-4" >
							<label class="col-xs-2 col-sm-4" title="劳动保障工作联系人" for="inputError">劳动保障工作联系人:</label>
							<div class="col-xs-10 col-sm-8 mhyNoSelect">
								<input class="form-control" type="text" id="aae004" name="Q_aae004_SL" data-placement="bottom" />
							</div>
						</div>
						<div class="col-xs-12 col-sm-4">
							<label class="col-xs-2 mhyNoPadding  col-sm-4" for="inputError">所在地区:</label>
							<div class="col-xs-10 input-group col-sm-8"  style="padding-left:15px">
                              <input class="form-control" type="text" id="aaa021" name="Q_aaa021_SL" data-placement="bottom" />
                              <!-- <input class="form-control" type="text" name="aab301" data-placement="bottom" /> -->
                           </div>
						</div>
						</div>
						<div class="row">
							<div class="col-sm-12 mgb20 tar pdx20">
								<a href="javascript:void(0)" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
								<a class="btn btn-info" href="javascript:void(0)" onclick="$('#reset').click()" role="button" ><i class="icon-repeat"></i>重置</a>
								<input id="reset" class="dn" type="reset">
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="moduleWrapNobg">
				<div class="moduleTit"><i class="icon-minus icon-rotate-90"></i>单位列表</div>
				<div class="moduleCont">
					<div class="mgy10">
						<div class="keep-open btn-group" title="Columns">
							<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
							<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i></a>
						</div>
					</div>
					<div class="row">
					  <div class="col-xs-12">
						<table id="corpList" class="datagridClass"></table>
						<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
			</div>
			<!-- <div class="moduleWrapNobg">
				<div class="moduleTit"><i class="icon-minus icon-rotate-90"></i>变更列表</div>
				<div class="moduleCont">
				 <table id="corpLogsList"  class="datagridClass " ></table>
			 </div>
			</div> -->
		</div>	
	</div>
	
</body>
<script type="text/javascript">
  jQuery(function($) {
 		// 日期选择
//       $("#datepicker01").xfdaterangepicker({autoUpdateInput:false,singleDatePicker:true,
// 		  "opens":"right",
// 		  "drops": "down",
//           "locale": {
//               "format": "YYYY-MM"
//           }
//       });
//      $(".dp").xfdaterangepicker({autoUpdateInput:false,singleDatePicker:true,
// 		  "opens":"right",
// 		  "drops": "down",
//           "locale": {
//               "format": "YYYY-MM"
//           }
//       });
//       $(".dpMonth").xfdaterangepicker({autoUpdateInput:false,singleDatePicker:true,
// 		  "opens":"right",
// 		  "drops": "down",
//           "locale": {
//               "format": "YYYY-MM"
//           }
//       });
      $(".resetBtn").click(function(){
    		$("#searchForm")[0].reset();
    	});
    });
</script> 
</html>	



