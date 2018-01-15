<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑基本信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   	<%@include file="/commons/include/commonInc.jsp" %>
   	<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
   	<link rel="stylesheet" href="${ctx}/assets/css/bootstrap-datetimepicker.min.css" />
	<link rel="stylesheet" href="${ctx}/assets/css/daterangepicker.css" />
   	<link href="/assets/styleNew/mhy_style.css" rel="stylesheet">

   	<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
	<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script>
	<script>
		$(function() {
			/**
			 初始化表格显示
			 */
			initTable();
		});
		function initTable() {
			var columns = [
						   {field:'',title:'Id号',checkbox:'true',width:40,align:'left'},
						   {field:'aab007',title:'营业执照号码',width:220,align:'left'},
		                   {field:'aab004',title:'单位名称',width:220,align:'left'},
		                   {field:'aab019',title:'单位性质',width:80,align:'left',
		                	   formatter:function(value,row,index){if(value==1)return '企业';
		                	   if(value==2)return"事业";if(value==3)return"机关";if(value==4)return"社团";
		                	   if(value==5)return"个体经济组织";if(value==8)return"非正规就业组织"; else return "其它";}},
		                   {field:'aae004',title:'联系人',width:60,align:'left'},
		                   {field:'aae005',title:'联系电话',width:100,align:'left'},
		                   {field:'aae006',title:'地址',width:200,align:'left'},
		                   {field:'aae036',title:'经办日期',width:100,align:'left',formatter:function(value,row,index){return formateDate(value);}},
		                   {field:'aae020',title:'经办机构',width:100,align:'left'},
		                   {field:'aae119',title:'单位状态',width:80,align:'left',
		                	   formatter:function(value,row,index){if(value==1)return '登记在册';
		                	   if(value==2)return"破产";if(value==3)return"注销";if(value==4)return"被兼并"; else return "其它";}},
		                   {field:'aab001',title:'操作',width:60,formatter: function(value,row,index){
					           return "<a href=\"javascript:void(0)\" onclick=\"editCorpOne('"+value+"')\" >编辑</a>";
					           /* +"<a href=\"javascript:void(0)\" onclick=\"delCorp('"+value+"')\" >删除</a>" */
								}
					} ] ;
			$('#corpList').bootstrapTable({
				url : '${ctx}/business/corp/corp/listJson.xf',
				columns: columns,
			    method:"post",
			    contentType:"application/x-www-form-urlencoded",
				pagination:true,
				pageSize:10,
				pageList:[10, 15, 20],
			    clickToSelect:true,
			    sidePagination:"server",
			    striped:true
			});
			$('#corpList1').bootstrapTable({
				url : '${ctx}/business/corp/corp/listJson.xf',
				columns: columns,
			    method:"post",
			    contentType:"application/x-www-form-urlencoded",
				pagination:true,
				pageSize:10,
				pageList:[10, 15, 20],
			    clickToSelect:true,
			    sidePagination:"server",
			    striped:true
			});
		}
		function addCorp(){
			xfui.open_dialog({
			    title: '新增单位基本信息表',
			    width: 900,
			    height: 500,
			    closed: false,
			    cache: false,
			    url: "${ctx}/business/demo/demoAdd.xf",
			    modal: true
			})
		}
		function editCorpOne(value){
			var aab001=value;
				xfui.open_dialog({
			  		    title: '编辑单位基本信息表',
			  		    width: 850,
			  		    height: 500,
			  		    closed: false,
			  		    cache: false,
			  		    url: "${ctx}/business/corp/corp/edit.xf?aab001="+aab001,
			  		    modal: true
			  		})
		}
		function editCorp(){
			var row = $('#corpList').bootstrapTable('getAllSelections');
			if(row&&row.length>0){
				var aab001=row[0].aab001;
				xfui.open_dialog({
		  		    title: '编辑单位基本信息表',
		  		    width: 850,
		  		    height: 500,
		  		    closed: false,
		  		    cache: false,
		  		    url: "${ctx}/business/corp/corp/edit.xf?aab001="+aab001,
		  		    modal: true
		  		})
			}else{
				bootbox.alert('请选择记录');
				return;
			}
		}

		function refresh(){
			$('#corpList').bootstrapTable('refresh');
		}
		function resetSearchForm(){
			 alert("111123");
			 $('#searchForm').bootstrapTable('reset');
			 alert("214454");
			 $('.easyui-combobox').combobox("setValue","");
		}
		function doSearch() {
			var json = $("#searchForm").serializeJson();
			$("#corpList").bootstrapTable('refresh', {
				query: json
			})
		}
	</script>
	<style>
		#corpList1{height:300px;overflow: hidden;}
	</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 col-sm-5 pd0 moduleWrapNobg">
				<div class="moduleTit">单位批次列表</div>
				<!-- 查询条件 -->
				<form id="searchForm" class="searchWrap">
					<div class="row">
						<label class="col-xs-3 col-sm-3" for="inputError">单位名称:</label>
						<div class="col-xs-9 col-sm-3">
							<input class="form-control" type="text" name="" data-placement="bottom" />
						</div>
						<label class="col-xs-3 col-sm-3" for="inputError">单位性质:</label>
						<div class="col-xs-9 col-sm-3">
							<select class="form-control" textField="name" hasDefault="0" valueField="code">
								<option value="1">私有</option>
								<option value="">公有</option>
								<option value="">国营企业</option>
								<option value="">民营</option>
							</select>
						</div>
						<label class="col-xs-3 col-sm-3" for="inputError">营业执照号码:</label>
						<div class="col-xs-9 col-sm-3">
							<input class="form-control" type="text" data-placement="bottom" />
						</div>
						<label class="col-xs-3 col-sm-3" for="inputError">经济类型:</label>
						<div class="col-xs-9 col-sm-3">
							<select class="form-control" textField="name" hasDefault="0" valueField="code">
								<option value="1">私有</option>
								<option value="">公有</option>
								<option value="">国营企业</option>
								<option value="">民营</option>
							</select>
						</div>
						<label class="col-xs-3 col-sm-3" for="inputError" title="产业类别">产业类别:</label>
						<div class="col-xs-9 col-sm-3">
							<select class="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code">
								<option value="1">私有</option>
								<option value="">公有</option>
								<option value="">国营企业</option>
								<option value="">民营</option>
							</select>
						</div>
						<label class="col-xs-3 col-sm-3" for="inputError" title="产业类别">产业类别:</label>
						<div class="col-xs-9 col-sm-3">
							<select class="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code">
								<option value="1">私有</option>
								<option value="">公有</option>
								<option value="">国营企业</option>
								<option value="">民营</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-12 mgb20 tar pdx20">
							<a href="#" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" >查询</a>
							<a href="javascript:void(0)" class="btn btn-primary highSearch" >高级查询</a>
							<a href="#modal-form" role="button" class="btn btn-border1" >重置</a>
						</div>
					</div>
				</form>
				<hr/>

				<!-- 结果列表1 -->
				<div class="resultWrap">
					<div class="table-responsive">
						<table id="corpList"  class="datagridClass"  >
						</table>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-7 colRight">
				<!-- 查询条件 -->
				<div class="moduleWrapNobg">
					<div class="moduleTit">批次人员列表</div>
					<form id="searchForm" class="searchWrap">
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">单位名称:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">单位性质:</label>
							<div class="col-xs-9 col-sm-2">
								<select class="form-control" textField="name" hasDefault="0" valueField="code">
									<option value="1">私有</option>
									<option value="">公有</option>
									<option value="">国营企业</option>
									<option value="">民营</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">营业执照号码:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经济类型:</label>
							<div class="col-xs-9 col-sm-2">
								<select class="form-control" textField="name" hasDefault="0" valueField="code">
									<option value="1">私有</option>
									<option value="">公有</option>
									<option value="">国营企业</option>
									<option value="">民营</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="产业类别">产业类别:</label>
							<div class="col-xs-9 col-sm-2">
								<select class="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code">
									<option value="1">私有</option>
									<option value="">公有</option>
									<option value="">国营企业</option>
									<option value="">民营</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="产业类别">产业类别:</label>
							<div class="col-xs-9 col-sm-2">
								<select class="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code">
									<option value="1">私有</option>
									<option value="">公有</option>
									<option value="">国营企业</option>
									<option value="">民营</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="产业类别">产业类别:</label>
							<div class="col-xs-9 col-sm-2">
								<select class="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code">
									<option value="1">私有</option>
									<option value="">公有</option>
									<option value="">国营企业</option>
									<option value="">民营</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="产业类别">产业类别:</label>
							<div class="col-xs-9 col-sm-2">
								<select class="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code">
									<option value="1">私有</option>
									<option value="">公有</option>
									<option value="">国营企业</option>
									<option value="">民营</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
							<div class="col-xs-9 input-group col-sm-2">
                              	<input class="form-control date-picker dp" id="datepicker01" name="beginaae036" type="text" placeholder="请选择日期"/>
                              	<span class="input-group-addon">
                                  	<i class="icon-calendar bigger-110"></i>
                              	</span>
                            </div>
                            <div class="col-xs-12 col-sm-8 mgb0">
								<div class="row mgb0">
									<label class="col-xs-3 col-sm-3" for="inputError" title="现居住地址">现居住地址:</label>
									<div class="col-xs-9 col-sm-9">
										<input class="form-control" type="text" name=""/>
									</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-12 mgb0">
	                            <div class="row rowTextarea">
									<label class="col-xs-3 col-sm-2" for="inputError" title="基本情况备注">基本情况备注:</label>
									<div class="col-xs-9 col-sm-10">
										<textarea row="5" col="5" ></textarea>
									</div>
								</div>
							</div>
						</div>
						<div class="row highCondition dnn">
							<label class="col-xs-3 col-sm-2" for="inputError">经济类型:</label>
							<div class="col-xs-9 col-sm-2">
								<select class="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code">
									<option value="1">私有</option>
									<option value="">公有</option>
									<option value="">国营企业</option>
									<option value="">民营</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="产业类别">产业类别:</label>
							<div class="col-xs-9 col-sm-2">
								<select class="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code">
									<option value="1">私有</option>
									<option value="">公有</option>
									<option value="">国营企业</option>
									<option value="">民营</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="企业所属行业">企业所属行业:</label>
							<div class="col-xs-9 col-sm-2">
								<select class="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code">
									<option value="1">私有</option>
									<option value="">公有</option>
									<option value="">国营企业</option>
									<option value="">民营</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="就/失业登记证号码">就/失业登记证号码:</label>
							<div class="col-xs-9 col-sm-2">
								<select class="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code">
									<option value="1">私有</option>
									<option value="">公有</option>
									<option value="">国营企业</option>
									<option value="">民营</option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-12 mgb20 tar pdx20">
								<a href="#" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" >查询</a>
								<a href="javascript:void(0)" class="btn btn-primary highSearch" >高级查询</a>
								<a href="#modal-form" role="button" class="btn btn-border1" >重置</a>
							</div>
						</div>
					</form>
					<hr/>
					<!-- 结果列表2 带检索条件 -->
					<div class="moduleCont resultWrap">
						<div class="mgy10">
							<a href="javascript:void(0)" onclick="addCorp()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus align-top"></i>添加</a>
							<a href="#modal-form1" onclick="editCorp()" role="button" class="btn btn-info" data-toggle="modal"><i class="icon-pencil align-top"></i>修改</a>
							<a href="javascript:void(0)"  role="button" class="btn btn-danger" ><i class="icon-trash align-top"></i>移除</a>
							<a href="javascript:void(0)"  role="button" class="btn  btn-light" ><i class="icon-edit align-top"></i>导入</a>
							<a href="javascript:void(0)"  role="button" class="btn btn-grey" ><i class="icon-external-link align-top"></i>导出</a>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<div class="table-responsive">
									<table id="corpList1"  class="datagridClass"  >
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div><!-- row end -->

	</div>

	<script type="text/javascript">
	jQuery(function($) {
		//多条结果展示隐藏
		$(".singleSearchBtn").click(function(){
			$(".moreResult").toggle("200");
		});
		$(".highSearch").click(function(){
			$(".highCondition").toggle();
		});
	 	// 日期选择
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
		$("[data-toggle='popover']").popover();
		// 折叠展示按钮
		$(".btnToggle").click(function(){
			//alert($(this).parents(".moduleTit").siblings());
			$(this).parents(".moduleTit").siblings(".moduleCont").toggle();
			$(this).children(".showTab").toggle();
			$(this).children(".hideTab").toggle();
		});
	});
	</script>
</body>
</html>
