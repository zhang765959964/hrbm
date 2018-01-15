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
	<script src="${ctx}/assets/js/clipboard.min.js"></script>
	<script>
		$(function() {
			/**初始化表格显示**/
			var columns= [
                   {name:'CCMU01',label:'',align:'center',hidden:true,frozen : true},
                   {name:'AAC001',label:'',align:'center',hidden:true,frozen : true},
                   {name:'CCZY06',label:'',align:'center',hidden:true,frozen : true},
                   {name:'CCMU02',label:'账号',align:'center',frozen : true},
                   {name:'CCMU03',label:'密码',align:'center',frozen : true},
                   {name:'CCMU10',label:'账号状态',align:'center'},
                   {name:'AAC002',label:'公民身份证号码',align:'center'},
                   {name:'AAC003',label:'姓名',align:'center'},
                   {name:'AAC004',label:'性别',align:'center'},
                   {name:'CCMU22',label:'数据来源',align:'center'},
                   {name:'AAC005',label:'民族',align:'center'},
                   {name:'AAC006',label:'出生日期',align:'center'},
                   {name:'AAC009',label:'户口性质',align:'center'},
                   {name:'AAB305',label:'户口所在地',align:'center'},
                   {name:'AAC011',label:'文化程度',align:'center'},
                   {name:'AAE005',label:'联系电话',align:'center'},
                   {name:'AAC017',label:'婚姻状况',align:'center'},
                   {name:'AAC024',label:'政治面貌',align:'center'},
                   {name:'AAB301',label:'居住所在地',align:'center'},
                   {name:'AAC00B',label:'楼院',align:'center'},
                   {name:'AAC00C',label:'单元',align:'center'},
                   {name:'AAC00D',label:'门牌号',align:'center'},
                   {name:'AAC025',label:'祖籍',align:'center'},
                   {name:'AAC036',label:'视力',align:'center'},
                   {name:'AAC035',label:'体重',align:'center'},
                   {name:'AAC034',label:'身高',align:'center'},
                   {name:'AAC032',label:'血型',align:'center'},
                   {name:'AAC033',label:'健康状况',align:'center'},
                   {name:'AAC022',label:'姓名拼音码',align:'center'},
                   {name:'AAC023',label:'个人英文名称',align:'center'},
                   {name:'AAE007',label:'邮编',align:'center'},
                   {name:'AAE015',label:'电子信箱',align:'center'},
                   {name:'AAC180',label:'毕业学校',align:'center'},
                   {name:'AAC181',label:'毕业时间',align:'center'},
                   {name:'AAC00E',label:'目前住房情况',align:'center'},
                   {name:'AAC00A',label:'军人证号',align:'center'},
                   {name:'AAE013',label:'备注',align:'center'},
                   {name:'AAE020',label:'经办机构',align:'center'},
                   {name:'AAE019',label:'经办人',align:'center'},
                   {name:'AAE036',label:'经办日期',align:'center'}
  	        	];
  	        $("#accountsList").jqGrid({
			   url:'${ctx}/sys/accounts/accounts/listJson.xf',
	           mtype: "GET",
			   styleUI : 'Bootstrap',
	           datatype: "json",
	           colModel: columns,
			   viewrecords: true,
	           rowNum: 10,
	           rowList:[10,20,30],
	           height:240,
	           pager: "#jqGridPager",
	           pagerpos:'left',
	           regional : 'cn',
	           recordpos:'right',
	           altRows:true,
	           shrinkToFit: false,//固定列时必须设置该项
	           multiselect:false,
	           onSelectRow:function(cellvalue){
	        	   var rowDatas = $("#accountsList").jqGrid('getRowData', cellvalue);
	        	   		$("#ccmu01").val(rowDatas.CCMU01);
	        	   		$("#account").val(rowDatas.CCMU02);
	        	   		$("#pword").val(rowDatas.CCMU03);
	        	 },
	           ondblClickRow:function(cellvalue){
	        	   var rowDatas = $("#accountsList").jqGrid('getRowData', cellvalue);
	        	   var cczy06 = rowDatas.CCZY06;
	        	   var aac001 = rowDatas.AAC001;
	        	    xfui.open_dialog({
		   	  		    title: '查看个人基本信息',
		   	  		    width: 900,
		   	  		    height: 500,
		   	  		    closed: false,
		   	  		    cache: false,
		   	  		    url: "${ctx}/business/person/personBaseInfo/selctPerson.xf?cczy06="+cczy06+"&aac001="+aac001,
		   	  		    modal: true
	   	  			})
	        	},
	           autowidth: true
	        });
  	        $("#accountsList").jqGrid('setFrozenColumns');//设置固定列

  	        $("#accountsList1").jqGrid({
			   url:'${ctx}/business/dissupport/jobmatch/jobMatchCorpListJson.xf',
	           mtype: "GET",
			   styleUI : 'Bootstrap',
	           datatype: "json",
	           colModel: columns,
			   viewrecords: true,
	           rowNum: 10,
	           rowList:[10,20,30],
	           pager: "#jqGridPager1",
	           pagerpos:'left',
	           regional : 'cn',
	           recordpos:'right',
	           altRows:true,
	           shrinkToFit: false,//固定列时必须设置该项
	           multiselect:false,
	           onSelectRow:function(cellvalue){
	        	   var rowDatas = $("#accountsList1").jqGrid('getRowData', cellvalue);
	        	   		$("#ccmu01").val(rowDatas.CCMU01);
	        	   		$("#account").val(rowDatas.CCMU02);
	        	   		$("#pword").val(rowDatas.CCMU03);
	        	 },
	           autowidth: true,
	           // 查询不到数据时提示
	           loadComplete: function(){
					var re_records = $(this).getGridParam('records');
					if(re_records == 0 || re_records == null){
						if($(".norecords").html() == null){
							$("#accountsList1").parent().append("<div class=\"norecords\">没有符合的数据</div>");
						}
						$(".norecords").show();
					}
				}
				// loadComplete: function() {
				// 	 var rowNum = parseInt($("#accountsList1").getGridParam("records"), 10);
				// 	 if (rowNum <= 0) { alert("没有符合条件的记录！"); }
				// }
	        });
  	        $("#accountsList1").jqGrid('setFrozenColumns');//设置固定列
		});
		function addCorp(){
			xfui.open_dialog({
			    title: '新增单位基本信息表',
			    width: 900,
			    height: 500,
			    closed: false,
			    cache: false,
			    url: "${ctx}/business/demo/tabEdit1.xf",
			    modal: true
			})
		}
		function refresh(){
			$("#accountsList").trigger("reloadGrid");
		}
		function doSearch(){
			var json=$("#searchForm").serializeJson();
			$("#accountsList").jqGrid("setGridParam",{postData:json}).trigger("reloadGrid");
		}
	</script>
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
			<div class="copyBtn">
				<a href="javascript:void(0)" role="button" class="btn btn-info" >复制查询模块代码</a>
			</div>
			<!-- 查询条件 -->
			<div class="moduleWrapNobg">
				<div class="moduleTit">查询条件</div>
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
							<div class="col-xs-12 col-sm-12 mgb20 tar pdx20">
								<a href="javascript:void(0)" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
								<a href="javascript:void(0)" class="btn btn-success btn-border1 highSearch" onclick="toggleMore('highCondition',this)"><i class="icon-plus"></i>高级查询</a>
								<a class="btn btn-info" href="javascript:void(0)" onclick="$('#reset').click()" role="button" ><i class="icon-repeat"></i>重置</a>
								<input id="reset" hidden="hidden" type="reset">
							</div>
						</div>
					</form>
				</div>
			</div>

			<!-- <div class="copyBtn">
				<a href="javascript:void(0)" role="button" class="btn btn-info" >复制表格模块代码</a>
			</div> -->
			<!-- 结果列表1 -->
			<div class="moduleWrapNob">
				<div class="moduleTit">查询结果1</div>
				<div class="moduleCont">
					<div class="mgy10">
						<a href="javascript:void(0)" onclick="addCorp()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus"></i>添加</a>
						<a href="#modal-form1" onclick="editCorp()" role="button" class="btn btn-info" data-toggle="modal"><i class="icon-pencil"></i>修改</a>
						<a href="javascript:void(0)"  role="button" class="btn btn-danger" ><i class="icon-trash"></i>移除</a>
						<a href="javascript:void(0)"  role="button" class="btn  btn-light" ><i class="icon-edit"></i>导入</a>
						<div class="keep-open btn-group" title="Columns">
							<a href="javascript:void(0)"  role="button" class="btn btn-grey export1 dropdown-toggle" data-toggle="dropdown"><i class="icon-external-link"></i>导出<i class="icon-caret-down"></i></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="javascript:void(0)">导出选中内容</a></li>
								<li><a href="javascript:void(0)">导出当前页</a></li>
								<li><a href="javascript:void(0)">导出所有记录</a></li>
							</ul>
						</div>
					</div>
					<div class="dataTableWrap">
						<table id="accountsList"  class="datagridClass"  ></table>
						<div id="jqGridPager"></div>
					</div>
				</div>
			</div>

			<!-- <div class="copyBtn">
				<a href="javascript:void(0)" role="button" class="btn btn-info" >复制带检索条件表格模块代码</a>
			</div> -->
			<!-- 结果列表2 带检索条件 -->
			<div class="moduleWrapNob">
				<div class="moduleTit"><span class="fl">查询结果带检索按钮</span><span class="fr mgr15"><a href="javascript:void(0)" role="button" class="btn btn-danger">到期未返还名单</a></span></div>
				<div class="moduleCont">
					<div class="mgy10">
						<a href="javascript:void(0)" onclick="addCorp()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus"></i>添加</a>
						<a href="#modal-form1" onclick="editCorp()" role="button" class="btn btn-info" data-toggle="modal"><i class="icon-pencil"></i>修改</a>
						<a href="javascript:void(0)"  role="button" class="btn btn-danger" ><i class="icon-trash"></i>移除</a>
						<a href="javascript:void(0)"  role="button" class="btn  btn-light" ><i class="icon-edit"></i>导入</a>
						<div class="keep-open btn-group" title="Columns">
							<a href="javascript:void(0)"  role="button" class="btn btn-grey export1 dropdown-toggle" data-toggle="dropdown"><i class="icon-external-link"></i>导出<i class="icon-caret-down"></i></a>
							<ul class="dropdown-menu" role="menu">
								<li><label><input type="radio" name="export" value="1" checked="checked">导出选中内容</label></li>
								<li><label><input type="radio" name="export" value="2">导出当前页</label></li>
								<li><label><input type="radio" name="export" value="3">导出所有记录</label></li>
							</ul>
						</div>
					</div>
					<table id="accountsList1" class="datagridClass" ></table>
					<div id="jqGridPager1"></div>
				</div>
			</div>

		</div>
	</div>
	<!-- </div> -->
</body>
<script type="text/javascript">
	// 列表单击复制
	var listClipboard = new Clipboard(".copyBtn",{
		target: function(trigger){
	        return trigger.nextElementSibling;
	    },
	    text: function(trigger){
	        return $(trigger).next().prop("outerHTML");
	    }
	});

	listClipboard.on('success', function(e) {
	    console.log(e);
	    console.log(e.text);
	    alert("代码已复制到剪切板，粘贴即可使用！");
	});

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
		// $(".highSearch").click(function(){
		// 	$(".highCondition").toggle();
		// });
		// $(".highSearch").click(function(){
		// 	$(".highCondition").toggle();
		// 	$(this).children("i").toggleClass("icon-plus");
		// 	$(this).children("i").toggleClass("icon-minus");
		// });
    });
</script>
</html>



