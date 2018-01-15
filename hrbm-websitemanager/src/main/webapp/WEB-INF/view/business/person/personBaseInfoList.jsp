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
	var dataJson = {};
	var sign='${sign}';
	$(function() {
		initTable();
		xfui.initUi();
		initDataExp();
	})
		function initTable() {
			var columns= [
			               {name:'aac001',label:'操作',align:'center',key:true,width:100,formatter: function(value,row,index){
			            	      var matchjobValue =(row.ccmu51==1)?" title=\"求职信息自动匹配\" ":" title=\"未填写求职意向\" style='color: #c7c7c7;' ";
							       var disabledv =(row.ccmu51==1)?" onclick=\"matchJobPerson('"+value+"')\" " :"";
						           return "<a class=\"mhyNoA\" href=\"javascript:void(0)\" onclick=\"selctPerson('"+value+"')\" ><i class=\"icon-zoom-in\" title=\"查看详情\"></i></a>";
								}
			               ,frozen : true},
		                   {name:'aac002',label:'身份证号',align:'center',frozen : true},
		                   {name:'aac003',label:'姓名',align:'center',frozen : true},
		                   {name:'aac022',label:'姓名拼音码',align:'center'},
		                   {name:'aac004',label:'性别',align:'center'},
		                   {name:'aac005',label:'民族',align:'center'},
		                   {name:'aac006',label:'出生日期',align:'center',formatter:function(value,row,index){
		                	   if(value==null){return "";}else{return formateDate(value);}}},
		                   {name:'aae005',label:'联系电话',align:'center'},
		                   {name:'aac009',label:'户口性质',align:'center'},
		                   {name:'bab305',label:'居住所在地',align:'center'},
		                   {name:'bab305',label:'户口所在地',align:'center'},
		                   {name:'aac011',label:'文化程度',align:'center'},
		                   {name:'aac024',label:'政治面貌',align:'center'},
		                   {name:'acc0m1',label:'就业失业登记证号',align:'center'},
		                   {name:'expHardPerson',name:'就业困难人员类别',align:'center'},
		                   {name:'aae019',label:'经办人',align:'center'},
		                   {name:'aae020',label:'经办机构',align:'center'},
		                   {name:'aae036',label:'经办日期',formatter:function(value,row,index){
		                	   if(value==null){return "";}else{return formateDate(value);}},align:'center'}
		                   /* {name:'cczy06',label:'数据来源',align:'center'} */
	      	        	];
			$("#personBaseInfoList").jqGrid({
		           mtype: "GET",
				   styleUI : 'Bootstrap',
		           datatype: "local",
		           colModel: columns,
				   viewrecords: true,
		           rowNum: 10,
		           rowList:[10,20,30],
		           pager: "#jqGridEduPager",
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
	/* 劳动力采集系统编辑个人基本信息 */
	function editPerson(value){
		xfui.open_tabs("个人基本信息维护","${ctx}/business/laborcollection/laborAccom/returnList.xf?aac001="+value,"个人基本信息查询");
	}
    //公办自动匹配求职信息
	function matchJobPerson(value){
		xfui.open_tabs("求职信息自动匹配","${ctx}/business/dissupport/jobmatch/list.xf?aac001="+value,"求职信息自动匹配");
	}
	function selctPerson(value){
		if(sign==""){
			xfui.open_dialog({
	  		    title: '查看个人基本信息',
	  		    width: 900,
	  		    height: 500,
	  		    closed: false,
	  		    cache: false,
	  		    url: "${ctx}/business/person/personBaseInfo/selctPerson.xf?cczy06=${cczy}&aac001="+value,
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
		dataJson = json;
		$("#personBaseInfoList").jqGrid("clearGridData");	
		$("#personBaseInfoList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/person/personBaseInfo/personListJson.xf',postData:json}).trigger("reloadGrid");
	}
	
	
	//导出退休人员查询数据
	function initDataExp(){
		$('#exp').dataexp({
			gridId:"personBaseInfoList",
			serviceId:'retiredDeclareExpServiceImpl',
			fileName:'个人信息查询',
			sheetName:'个人信息查询',
			menuItem:[{title:"导出全部数据",paramCallBack:function(){
				dataJson.level = 'p';
				debugger;
				var id = $("#personBaseInfoList").jqGrid("getDataIDs");	   
	        		if(id&&id.length>0){
	        			return dataJson;
	        		}else{
	        			bootbox.alert("无可导出的数据！");
	        			return false;
	        		}	
			           }},
				        {title:"导出当前页数据",paramCallBack:function(){
				        	var ids = $("#personBaseInfoList").jqGrid("getDataIDs");
				        	console.info(ids);
				        	if(ids&&ids.length>0){
			        			var id="";
			        			$.each(ids,function(i,e){
			        				if(i==0){
			        					id+="'"+e+"'";
			        				}else{
			        					id+=","+"'"+e+"'";
			        				}
			        			});
			        			return {level:'p',ids:id};
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
	<!-- <div class="main-container"> -->
		<div class="container-fluid">
			<div class="row">
			 <div class="moduleWrapNobg">
				<div class="moduleTit">查询条件</div>
				<div class="moduleCont">
					<form id="searchForm" class="mhySearchInput">
						<input type="hidden" name="cczy06"   value="${cczy06}"/>
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
								<label class="col-xs-2 col-sm-4" for="inputError">性别:</label>
								<div class="col-xs-10 col-sm-8  mhyNoSelect">
									<xf:select textField="name" tableName="TAB_SEX" hasDefault="0" id="aac004" name="aac004n" valueField="code" valueCon="1,2"></xf:select>
								</div>
							</div>
						</div>
						<div class="row">
							<c:if test="${empty sign }">
								<div class="col-xs-12 col-sm-4" >
								<label class="col-xs-2 col-sm-4" for="inputError">个人状态:</label>
								<div class="col-xs-10 col-sm-8  mhyNoSelect">
									<xf:select textField="name"  tableName="TAB_PSTATUS" hasDefault="0" id="expPersonStatus" name="expPersonStatus" valueField="code" ></xf:select>
								</div>
								</div>
							</c:if>
							<c:if test="${!empty sign }">
								<div class="col-xs-12 col-sm-4" >
								<label class="col-xs-2 col-sm-4" for="inputError">民族:</label>
								<div class="col-xs-10 col-sm-8  mhyNoSelect">
									<xf:select textField="name"  tableName="TAB_NATION" hasDefault="0" id="aac005n" name="aac005n" valueField="code" ></xf:select>
								</div>
								</div>
							</c:if>
							<div class="col-xs-12 col-sm-4" >
								<label class="col-xs-2 col-sm-4" for="inputError">户口性质:</label>
								<div class="col-xs-10 col-sm-8  mhyNoSelect">
									<xf:select textField="name" tableName="TAB_CATEGORY" hasDefault="0" id="aac009" name="aac009n" valueField="code"></xf:select>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4" >
								<label class="col-xs-2 col-sm-4" for="inputError">居住所在地:</label>
								<div class="col-xs-10 col-sm-8">
									<input class="form-control" type="text" id="aab301" name="Q_aab301_SL" data-placement="bottom"/>
								</div>
							</div>
						</div>
						<div class="row">
	                        <div class="col-xs-12 col-sm-4" style="height:32px;">
								<label class="col-xs-2 col-sm-4" for="inputError">出生日期:</label>
								<div class="col-xs-10 input-group col-sm-8"  style="padding-left:15px">
	                              <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginaac006" name="beginaac006" type="text"  placeholder="请选择出生日期"/>
	                              <span class="input-group-addon">
	                                  <i class="icon-calendar bigger-110"></i>
	                              </span>
	                           </div>
							</div>
							<div class="col-xs-12 col-sm-4" style="height:32px;">
								<label class="col-xs-2 col-sm-4" for="inputError">至</label>
								<div class="col-xs-10 input-group col-sm-8"  style="padding-left:15px">
	                              <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="endaac006" name="endaac006" type="text"  placeholder="请选择出生日期"/>
	                              <span class="input-group-addon">
	                                  <i class="icon-calendar bigger-110"></i>
	                              </span>
	                           </div>
							</div>
							<div class="col-xs-12 col-sm-4" >
								<label class="col-xs-2 col-sm-4" for="inputError">文化程度:</label>
								<div class="col-xs-10 col-sm-8 mhyNoSelect">
									<xf:select textField="name" tableName="TAB_EDUCATION" id="aac011" name="aac011n"  valueField="code" hasDefault="0"></xf:select>
								</div>
							</div>
						</div>
						<div class="row">
	                        <div class="col-xs-12 col-sm-4" style="height:32px;">
								<label class="col-xs-2 col-sm-4" for="inputError">经办日期起:</label>
								<div class="col-xs-10 input-group col-sm-8"  style="padding-left:15px">
	                              <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginaae036" name="beginaae036" type="text"  placeholder="请选择日期"/>
	                            <span class="input-group-addon">
	                                  <i class="icon-calendar bigger-110"></i>
	                            </span></div>
                            </div>
                            <div class="col-xs-12 col-sm-4" >
                                <label class="col-xs-2 col-sm-4">经办日期止:</label>
								<div class="col-xs-10 input-group col-sm-8"  style="padding-left:15px">
	                              <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="endaae036" name="endaae036" type="text"  placeholder="请选择日期"/>
	                              <span class="input-group-addon">
	                                  <i class="icon-calendar bigger-110"></i>
	                              </span>
	                           </div>
	                        </div>
							<div class="col-xs-12 col-sm-4 marginbottom20">
								<div class="col-xs-12 col-sm-12 mhyBtn">
									<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary btn-border1 mhyBtnLeft" >											<i class="icon-search"></i>查询
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
			</div>
			<div class="moduleWrapNobg">
				<div class="moduleTit">结果列表</div>
				<div class="moduleCont">
					<div class="mgy10">
						<div class="keep-open btn-group" title="Columns">
							<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
							<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i></a>
						</div>
					</div>
				    <div class="row">
							<div class="col-xs-12">
								<table id="personBaseInfoList" class="datagridClass"></table>
								<div id="jqGridEduPager"></div>
							</div>
					</div>
				</div>
			</div>	
		</div>
	</div>
</body>
<script type="text/javascript">
  jQuery(function($) {
      $(".resetBtn").click(function(){
  		$("#searchForm")[0].reset();
  		});
    });
</script>
</html>


