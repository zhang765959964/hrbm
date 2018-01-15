<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>查询列表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@include file="/commons/include/commonInc.jsp" %>
	<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
	 <link rel="stylesheet" href="${ctx}/assets/css/bootstrap-datetimepicker.min.css" />
	<script type="text/javascript" src="${ctx}/js/lib/jquery/bootstrap-contextmenu.js"></script>
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
	.moduleWrap, .moduleWrapNob, .moduleWrapNobg{border:none; background: #fff;}
	.moduleTit{background:#fff; border:none;border-bottom:1px solid #c5d0dc; color:#307ecc; height:30px; line-height: 30px;padding-left:0;}
	</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<!-- 单条件查询 -->
			<div class="tar">
				<div class="col-xs-6 col-sm-6">
					<a href="javascript:void(0)" role="button" class="btn btn-info" data-toggle="modal">社保卡已配置</a>
					<a href="javascript:void(0)" role="button" class="btn" data-toggle="modal">身份证未配置</a>
				</div>
				<div class="col-xs-6 col-sm-6">
					<form class="" action="" method="post">
						<label class="col-xs-3 col-sm-2" for="inputError">查询:</label>
						<div class="col-xs-6 col-sm-7 pr">
							<input class="form-control" placeholder="请输入身份证号" type="text"/>
							<!-- 多条结果 -->
							<div class="pa moreResult dnn">
								<table class="srtable">
									<thead>
										<tr>
											<th class="sid">身份证号</th>
											<th class="sname">姓名</th>
											<th class="ssex">性别</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td class="sid">311525198605258796</td>
											<td class="sname">端木利亚</td>
											<td class="ssex">女</td>
										</tr>
										<tr>
											<td class="sid">311525198605258796</td>
											<td class="sname">端木利亚</td>
											<td class="ssex">女</td>
										</tr>
										<tr>
											<td class="sid">311525198605258796</td>
											<td class="sname">端木利亚</td>
											<td class="ssex">女</td>
										</tr>
										<tr>
											<td class="sid">311525198605258796</td>
											<td class="sname">端木利亚</td>
											<td class="ssex">女</td>
										</tr>
										<tr>
											<td class="sid">311525198605258796</td>
											<td class="sname">端木利亚</td>
											<td class="ssex">女</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="fl">
							<a href="javascript:void(0)" onclick="doSearch()"  class="btn btn-primary singleSearchBtn">
								<i class="icon-search"></i>查询</a>
						</div>
					</form>
				</div>
			</div>
			<!-- 查询条件 -->
			<div class="moduleWrapNobg">
				<div class="moduleTit"><i class="icon-minus icon-rotate-90"></i>查询条件</div>
				<div class="moduleCont">
					<form id="searchForm">
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
                            <div class="col-xs-12 col-sm-8  twoCol">
								<div class="row">
									<label class="col-xs-3 col-sm-3" for="inputError" title="现居住地址">现居住地址:</label>
									<div class="col-xs-9 col-sm-9">
										<input class="form-control" type="text" name=""/>
									</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-12 threeCol">
	                            <div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError" title="基本情况备注">基本情况备注:</label>
									<div class="col-xs-9 col-sm-10">
										<textarea row="5" col="5" ></textarea>
									</div>
								</div>
							</div>
						</div>
						<div class="row highCondition dnn" id="collapseWrap">
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
							<div class="col-sm-12 mgb20 tar pdx20">
								<a href="javascript:void(0)" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
								<a href="javascript:void(0)" class="btn btn-success btn-border1 highSearch" onclick="toggleMore('highCondition',this)"><i class="icon-plus"></i>高级查询</a>
								<a class="btn btn-info" href="javascript:void(0)" onclick="$('#reset').click()" role="button" ><i class="icon-repeat"></i>重置</a>
								<input id="reset" class="dn" type="reset">
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- 结果列表1 -->
			<div class="moduleWrapNob">
				<div class="moduleTit"><i class="icon-minus icon-rotate-90"></i>查询结果1</div>
				<div class="moduleCont">
					<div class="mgy10">
						<a href="javascript:void(0)" onclick="addCorp()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus align-top"></i>添加</a>
						<a href="#modal-form1" onclick="editCorp()" role="button" class="btn btn-info" data-toggle="modal"><i class="icon-pencil align-top"></i>修改</a>
						<a href="javascript:void(0)"  role="button" class="btn btn-danger" ><i class="icon-trash align-top"></i>移除</a>
						<a href="javascript:void(0)"  role="button" class="btn  btn-light" ><i class="icon-edit align-top"></i>导入</a>
						<div class="keep-open btn-group" title="Columns">
							<!-- <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
								<i class="glyphicon glyphicon-th icon-th"></i> <span class="caret"></span>
							</button> -->
							<a href="javascript:void(0)"  role="button" class="btn btn-grey export1 dropdown-toggle" data-toggle="dropdown"><i class="icon-external-link align-top"></i>导出<i class="icon-caret-down align-top"></i></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="javascript:void(0)">导出选中内容</a></li>
								<li><a href="javascript:void(0)">导出当前页</a></li>
								<li><a href="javascript:void(0)">导出所有记录</a></li>
							</ul>
						</div>
					</div>
					<!-- <div class="row">
						<div class="col-xs-12"> -->
					<table id="corpList"  class="datagridClass"  >
					</table>
					<!-- 	</div>
					</div> -->
				</div>
			</div>

			<!-- 结果列表2 带检索条件 -->
			<div class="moduleWrapNob">
				<div class="moduleTit"><span class="fl"><i class="icon-minus icon-rotate-90"></i>查询结果2</span><span class="fr mgr15"><a href="javascript:void(0)" role="button" class="btn btn-danger" data-toggle="modal">到期未返还名单</a></span></div>
				<div class="moduleCont">
					<div class="mgy10">
						<a href="javascript:void(0)" onclick="addCorp()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus align-top"></i>添加</a>
						<a href="#modal-form1" onclick="editCorp()" role="button" class="btn btn-info" data-toggle="modal"><i class="icon-pencil align-top"></i>修改</a>
						<a href="javascript:void(0)"  role="button" class="btn btn-danger" ><i class="icon-trash align-top"></i>移除</a>
						<a href="javascript:void(0)"  role="button" class="btn  btn-light" ><i class="icon-edit align-top"></i>导入</a>
						<div class="keep-open btn-group" title="Columns">
							<!-- <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
								<i class="glyphicon glyphicon-th icon-th"></i> <span class="caret"></span>
							</button> -->
							<a href="javascript:void(0)"  role="button" class="btn btn-grey export1 dropdown-toggle" data-toggle="dropdown"><i class="icon-external-link align-top"></i>导出<i class="icon-caret-down align-top"></i></a>
							<ul class="dropdown-menu" role="menu">
								<li><label><input type="radio" name="export" value="1" checked="checked">导出选中内容</label></li>
								<li><label><input type="radio" name="export" value="2">导出当前页</label></li>
								<li><label><input type="radio" name="export" value="3">导出所有记录</label></li>
							</ul>
						</div>
					</div>
					<!-- <div class="row">
						<div class="col-xs-12"> -->
					<div class="table-responsive">
						<table id="corpList1"  class="datagridClass"  >
						</table>
					</div>
						<!-- </div>
					</div> -->
				</div>
			</div>

		</div>
	</div>
	<!-- </div> -->
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


		//多条结果展示隐藏
		$(".singleSearchBtn").click(function(){
			$(".moreResult").toggle("200");
		});

    });
</script>
</html>



