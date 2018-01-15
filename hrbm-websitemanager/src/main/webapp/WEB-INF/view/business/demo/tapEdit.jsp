<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>编辑基本信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   	<%@include file="/commons/include/commonInc.jsp" %>
   	<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
   	<link rel="stylesheet" href="${ctx}/assets/css/bootstrap-datetimepicker.min.css" />
	<link rel="stylesheet" href="${ctx}/assets/css/daterangepicker.css" />

   	<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
	<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script>

	<script>
		$(function() {
			//多条结果展示隐藏
			$(".singleSearchBtn").click(function(){
				$(".moreResult").toggle("200");
			});
			$(".highSearch").click(function(){
				$(".highCondition").toggle();
			});

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
	           height:300,
	           pager: "#jqGridPager",
	           pagerpos:'left',
	           regional : 'cn',
	           recordpos:'right',
	           height:'100%',
	           autowidth: true,
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
	        	}
	        });
  	        $("#accountsList").jqGrid('setFrozenColumns');//设置固定列
  	        $("#perEdu").removeClass("in").removeClass("active");
		});
	</script>
	<style>
	.tabable1{display: none;}
	.tabable1>ul.nav-tabs{background: #337ab7; border: 1px solid #337ab7;border-bottom: none;}
	.tabable1 .nav-tabs>li>a{background: #f2f2f2 !important;}
	.tabable1 .nav-tabs>li.active>a{background: #fff !important; color:#337ab7 !important; height:40px !important;}
	.tabable1>.tab-content{border: 1px solid #337ab7;}
	</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row topSearch">
			<!-- 单条件查询 -->
			<div class="col-xs-12 pd0 tar">
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
							<a href="javascript:void(0)"  class="btn btn-primary singleSearchBtn">查询</a>
						</div>
					</form>
				</div>
			</div>
		</div><!-- row end -->

		<!-- tab选项卡 -->
		<div class="tabable row">
			<ul class="nav nav-tabs padding-12 tab-color-blue background-blue">
				<li class="active"><a data-toggle="tab" href="#perBase">个人基本信息</a></li>
				<li><a data-toggle="tab" href="#perEdu">教育背景</a></li>
				<li><a data-toggle="tab" href="#perExp">工作简历</a></li>
			</ul>

			<div class="tab-content">
				<div id="perBase" class="tab-pane in active">
					<form id="searchForm">
						<div class="moduleWrap mgt5">
							<div class="moduleTit"><span claass="fl"><i class="icon-minus icon-rotate-90"></i>基本信息</span></div>
							<div class="moduleCont">
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>身份证号:</label>
									<div class="col-xs-9 col-sm-2 required">
										<input class="form-control" data-container="body" data-toggle="popover" data-placement="bottom" data-content="必填项"/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
									<div class="col-xs-9 col-sm-2 required">
										<input class="form-control" readonly="true" />
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">出生日期:</label>
									<div class="col-xs-9 input-group col-sm-2">
		                              	<input class="form-control date-picker dp" id="datepicker01" name="beginaae036" type="text" placeholder="请选择日期"/>
		                              	<span class="input-group-addon">
		                                  	<i class="icon-calendar bigger-110"></i>
		                              	</span>
		                            </div>
									<label class="col-xs-3 col-sm-2" for="inputError">曾用名:</label>
									<div class="col-xs-9 col-sm-2 required">
										<input class="form-control"/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name="" readonly="readonly"/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">档案姓名:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name=""/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">民族:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code">
											<option value="1">汉族</option>
											<option value="">回族</option>
											<option value="">傣族</option>
											<option value="">其他少数民族</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="政治面貌">政治面貌:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code">
											<option value="1">中共党员</option>
											<option value="">团员</option>
											<option value="">无党人士</option>
											<option value="">其他团体</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="文化程度">文化程度:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" hasDefault="0" valueField="code">
											<option value="1">中共党员</option>
											<option value="">团员</option>
											<option value="">无党人士</option>
											<option value="">其他团体</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="联系电话">联系电话:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name=""/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="手机号">手机号:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name=""/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="是否军转干部">是否军转干部:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" hasDefault="0" valueField="code">
											<option value="1">中共党员</option>
											<option value="">团员</option>
											<option value="">无党人士</option>
											<option value="">其他团体</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="是否享有再就业优惠证标准">是否享有再就业优惠证标准:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" hasDefault="0" valueField="code">
											<option value="1">中共党员</option>
											<option value="">团员</option>
											<option value="">无党人士</option>
											<option value="">其他团体</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="是否持有就业失业登记证">是否持有就业失业登记证:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" hasDefault="0" valueField="code">
											<option value="1">中共党员</option>
											<option value="">团员</option>
											<option value="">无党人士</option>
											<option value="">其他团体</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="再就业优惠证编号">再就业优惠证编号:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name=""/>
									</div>
									<div class="col-xs-12 col-sm-8 mgb0">
										<div class="row mgb0">
											<label class="col-xs-3 col-sm-3" for="inputError" title="身份证住址">身份证住址:</label>
											<div class="col-xs-9 col-sm-9">
												<input class="form-control" type="text" name=""/>
											</div>
										</div>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="就业失业登记证号">就业失业登记证号:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name=""/>
									</div>
									<div class="col-xs-12 col-sm-8 twoCol">
										<div class="row">
											<label class="col-xs-3 col-sm-3" for="inputError" title="现居住地址">现居住地址:</label>
											<div class="col-xs-9 col-sm-9">
												<input class="form-control" type="text" name=""/>
											</div>
										</div>
									</div>
									<div class="col-xs-12 col-sm-12 threeCol">
										<div class="row rowTextarea">
											<label class="col-xs-3 col-sm-2" for="inputError" title="基本情况备注">基本情况备注:</label>
											<div class="col-xs-9 col-sm-10">
												<textarea row="5" col="5" ></textarea>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- 家庭情况-可折叠展开 -->
						<div class="moduleWrap mgt5">
							<div class="moduleTit dbToggle">
								<span class="fl"><i class="icon-minus icon-rotate-90"></i>家庭情况</span>
								<span class="fr mgr15">
									<!-- <a href="javascript:void(0)" class="btnToggle"><span class="showTab fwhite"><i class="collapseBtn icon-double-angle-down"></i></span><span class="hideTab fwhite dnn"><i class="collapseBtn icon-double-angle-down"></i></span></a> -->
									<a href="javascript:void(0)" class="btnToggle" onclick="collapseWrap('collapseWrap',this)">
										<i class="icon-double-angle-down"></i>
									</a>
								</span>
							</div>
							<div class="moduleCont dnn">
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>身份证号:</label>
									<div class="col-xs-9 col-sm-2 required">
										<input class="form-control" data-container="body" data-toggle="popover" data-placement="bottom" data-content="必填项"/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
									<div class="col-xs-9 col-sm-2 required">
										<input class="form-control" readonly="true" />
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">出生日期:</label>
									<div class="col-xs-9 input-group col-sm-2">
		                              	<input class="form-control date-picker dp" id="datepicker01" name="beginaae036" type="text" placeholder="请选择日期"/>
		                              	<span class="input-group-addon">
		                                  	<i class="icon-calendar bigger-110"></i>
		                              	</span>
		                            </div>
									<label class="col-xs-3 col-sm-2" for="inputError">曾用名:</label>
									<div class="col-xs-9 col-sm-2 required">
										<input class="form-control"/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name="" readonly="readonly"/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">档案姓名:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name=""/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">民族:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code">
											<option value="1">汉族</option>
											<option value="">回族</option>
											<option value="">傣族</option>
											<option value="">其他少数民族</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="政治面貌">政治面貌:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code">
											<option value="1">中共党员</option>
											<option value="">团员</option>
											<option value="">无党人士</option>
											<option value="">其他团体</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="文化程度">文化程度:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" hasDefault="0" valueField="code">
											<option value="1">中共党员</option>
											<option value="">团员</option>
											<option value="">无党人士</option>
											<option value="">其他团体</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="联系电话">联系电话:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name=""/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="手机号">手机号:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name=""/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="是否军转干部">是否军转干部:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" hasDefault="0" valueField="code">
											<option value="1">中共党员</option>
											<option value="">团员</option>
											<option value="">无党人士</option>
											<option value="">其他团体</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="是否享有再就业优惠证标准">是否享有再就业优惠证标准:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" hasDefault="0" valueField="code">
											<option value="1">中共党员</option>
											<option value="">团员</option>
											<option value="">无党人士</option>
											<option value="">其他团体</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="是否持有就业失业登记证">是否持有就业失业登记证:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" hasDefault="0" valueField="code">
											<option value="1">中共党员</option>
											<option value="">团员</option>
											<option value="">无党人士</option>
											<option value="">其他团体</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="再就业优惠证编号">再就业优惠证编号:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name=""/>
									</div>
									<div class="col-xs-12 col-sm-8 mgb0">
										<div class="row mgb0">
											<label class="col-xs-3 col-sm-3" for="inputError" title="身份证住址">身份证住址:</label>
											<div class="col-xs-9 col-sm-9">
												<input class="form-control" type="text" name=""/>
											</div>
										</div>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="就业失业登记证号">就业失业登记证号:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name=""/>
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
							</div>
						</div>

				   		<div class="floatBtn">
					   		<a href="javascript:void(0)" role="button" class="btn btn-primary"  >保存</a>
					   		<a href="javascript:void(0)" role="button" class="btn btn-info" data-toggle="modal">登记新户</a>
					   		<a href="javascript:void(0)" role="button" class="btn btn-success">打印条码标签</a>
				   		</div>
					</form>
				</div>

				<div id="perEdu" class="tab-pane in active">
					<!-- <div class="moduleWrapNob">
						<div class="moduleCont">
							<div class="row">
								<div class="col-xs-12">
									<table id="accountsList" class="datagridClass" ></table>
									<div id="jqGridPager"></div>
								</div>
							</div>
						</div>
					</div> -->
					<table id="accountsList" class="datagridClass" ></table>
					<div id="jqGridPager"></div>
				</div>

				<div id="perExp" class="tab-pane">
				</div>
			</div>
		</div>
		<!-- tabMore选项卡 -->
		<div class="tabable tabMore row">
			<ul class="nav nav-tabs padding-12 tab-color-blue background-blue tabMoreNav">
				<li class="active"><a href="javascript:void(0)">个人基本信息</a></li>
				<li><a href="javascript:void(0)">跳转1</a></li>
				<li><a href="javascript:void(0)">跳转2</a></li>
			</ul>

			<div class="tab-content" id="tabMoreCont">
				<div id="perBase1" class="active">
				</div>
				<div id="perEdu1" class="dn">
				</div>

				<div id="perExp1" class="dn">
				</div>
			</div>
		</div>
		<script>
		loadTab('perBase1','${ctx}/business/demo/tapCont1.xf');
		var tabCont = [
						{id:"perBase1",url:"${ctx}/business/demo/tapCont1.xf"},
						{id:"perEdu1",url:"${ctx}/business/demo/tapCont2.xf"},
						{id:"perExp1",url:"${ctx}/business/demo/tapCont3.xf"}
					];
		$(".tabMoreNav>li").click(function(){
			var index = $(this).index();
			$(this).siblings().removeClass('active');
			$(this).addClass('active');
			$('#tabMoreCont>div').eq(index).siblings().addClass('dn');
			$('#tabMoreCont>div').eq(index).removeClass('dn');
			loadTab(tabCont[index].id,tabCont[index].url );
		});

		function loadTab(id,url){
			$("#"+id).load(url);
			// alert(1);
		}
		</script>
		<!-- tab选项卡 -->
		<div class="tabable tabable1 row">
			<ul class="nav nav-tabs padding-12 tab-color-blue background-blue">
				<li class="active"><a data-toggle="tab" href="#perBase">个人基本信息</a></li>
				<li><a data-toggle="tab" href="#perEdu">教育背景</a></li>
				<li><a data-toggle="tab" href="#perExp">工作简历</a></li>
			</ul>

			<div class="tab-content">
				<div id="perBase" class="tab-pane in active">
					<form id="searchForm">
						<div class="moduleWrap mgt5">
							<div class="moduleTit"><span claass="fl"><i class="icon-minus icon-rotate-90"></i>基本信息</span></div>
							<div class="moduleCont">
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>身份证号:</label>
									<div class="col-xs-9 col-sm-2 required">
										<input class="form-control" data-container="body" data-toggle="popover" data-placement="bottom" data-content="必填项"/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
									<div class="col-xs-9 col-sm-2 required">
										<input class="form-control" readonly="true" />
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">出生日期:</label>
									<div class="col-xs-9 input-group col-sm-2">
		                              	<input class="form-control date-picker dp" id="datepicker01" name="beginaae036" type="text" placeholder="请选择日期"/>
		                              	<span class="input-group-addon">
		                                  	<i class="icon-calendar bigger-110"></i>
		                              	</span>
		                            </div>
									<label class="col-xs-3 col-sm-2" for="inputError">曾用名:</label>
									<div class="col-xs-9 col-sm-2 required">
										<input class="form-control"/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name="" readonly="readonly"/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">档案姓名:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name=""/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">民族:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code">
											<option value="1">汉族</option>
											<option value="">回族</option>
											<option value="">傣族</option>
											<option value="">其他少数民族</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="政治面貌">政治面貌:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code">
											<option value="1">中共党员</option>
											<option value="">团员</option>
											<option value="">无党人士</option>
											<option value="">其他团体</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="文化程度">文化程度:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" hasDefault="0" valueField="code">
											<option value="1">中共党员</option>
											<option value="">团员</option>
											<option value="">无党人士</option>
											<option value="">其他团体</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="联系电话">联系电话:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name=""/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="手机号">手机号:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name=""/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="是否军转干部">是否军转干部:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" hasDefault="0" valueField="code">
											<option value="1">中共党员</option>
											<option value="">团员</option>
											<option value="">无党人士</option>
											<option value="">其他团体</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="是否享有再就业优惠证标准">是否享有再就业优惠证标准:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" hasDefault="0" valueField="code">
											<option value="1">中共党员</option>
											<option value="">团员</option>
											<option value="">无党人士</option>
											<option value="">其他团体</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="是否持有就业失业登记证">是否持有就业失业登记证:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" hasDefault="0" valueField="code">
											<option value="1">中共党员</option>
											<option value="">团员</option>
											<option value="">无党人士</option>
											<option value="">其他团体</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="再就业优惠证编号">再就业优惠证编号:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name=""/>
									</div>
									<div class="col-xs-12 col-sm-8 mgb0">
										<div class="row mgb0">
											<label class="col-xs-3 col-sm-3" for="inputError" title="身份证住址">身份证住址:</label>
											<div class="col-xs-9 col-sm-9">
												<input class="form-control" type="text" name=""/>
											</div>
										</div>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="就业失业登记证号">就业失业登记证号:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name=""/>
									</div>
									<div class="col-xs-12 col-sm-8 twoCol">
										<div class="row">
											<label class="col-xs-3 col-sm-3" for="inputError" title="现居住地址">现居住地址:</label>
											<div class="col-xs-9 col-sm-9">
												<input class="form-control" type="text" name=""/>
											</div>
										</div>
									</div>
									<div class="col-xs-12 col-sm-12 threeCol">
										<div class="row rowTextarea">
											<label class="col-xs-3 col-sm-2" for="inputError" title="基本情况备注">基本情况备注:</label>
											<div class="col-xs-9 col-sm-10">
												<textarea row="5" col="5" ></textarea>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- 家庭情况-可折叠展开 -->
						<div class="moduleWrap mgt5">
							<div class="moduleTit dbToggle">
								<span class="fl"><i class="icon-minus icon-rotate-90"></i>家庭情况</span>
								<span class="fr mgr15">
									<!-- <a href="javascript:void(0)" class="btnToggle"><span class="showTab fwhite"><i class="collapseBtn icon-double-angle-down"></i></span><span class="hideTab fwhite dnn"><i class="collapseBtn icon-double-angle-down"></i></span></a> -->
									<a href="javascript:void(0)" class="btnToggle" onclick="collapseWrap('collapseWrap',this)">
										<i class="icon-double-angle-down"></i>
									</a>
								</span>
							</div>
							<div class="moduleCont dnn">
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>身份证号:</label>
									<div class="col-xs-9 col-sm-2 required">
										<input class="form-control" data-container="body" data-toggle="popover" data-placement="bottom" data-content="必填项"/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
									<div class="col-xs-9 col-sm-2 required">
										<input class="form-control" readonly="true" />
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">出生日期:</label>
									<div class="col-xs-9 input-group col-sm-2">
		                              	<input class="form-control date-picker dp" id="datepicker01" name="beginaae036" type="text" placeholder="请选择日期"/>
		                              	<span class="input-group-addon">
		                                  	<i class="icon-calendar bigger-110"></i>
		                              	</span>
		                            </div>
									<label class="col-xs-3 col-sm-2" for="inputError">曾用名:</label>
									<div class="col-xs-9 col-sm-2 required">
										<input class="form-control"/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name="" readonly="readonly"/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">档案姓名:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name=""/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">民族:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code">
											<option value="1">汉族</option>
											<option value="">回族</option>
											<option value="">傣族</option>
											<option value="">其他少数民族</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="政治面貌">政治面貌:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code">
											<option value="1">中共党员</option>
											<option value="">团员</option>
											<option value="">无党人士</option>
											<option value="">其他团体</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="文化程度">文化程度:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" hasDefault="0" valueField="code">
											<option value="1">中共党员</option>
											<option value="">团员</option>
											<option value="">无党人士</option>
											<option value="">其他团体</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="联系电话">联系电话:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name=""/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="手机号">手机号:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name=""/>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="是否军转干部">是否军转干部:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" hasDefault="0" valueField="code">
											<option value="1">中共党员</option>
											<option value="">团员</option>
											<option value="">无党人士</option>
											<option value="">其他团体</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="是否享有再就业优惠证标准">是否享有再就业优惠证标准:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" hasDefault="0" valueField="code">
											<option value="1">中共党员</option>
											<option value="">团员</option>
											<option value="">无党人士</option>
											<option value="">其他团体</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="是否持有就业失业登记证">是否持有就业失业登记证:</label>
									<div class="col-xs-9 col-sm-2">
										<select class="form-control" textField="name" hasDefault="0" valueField="code">
											<option value="1">中共党员</option>
											<option value="">团员</option>
											<option value="">无党人士</option>
											<option value="">其他团体</option>
										</select>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="再就业优惠证编号">再就业优惠证编号:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name=""/>
									</div>
									<div class="col-xs-12 col-sm-8 mgb0">
										<div class="row mgb0">
											<label class="col-xs-3 col-sm-3" for="inputError" title="身份证住址">身份证住址:</label>
											<div class="col-xs-9 col-sm-9">
												<input class="form-control" type="text" name=""/>
											</div>
										</div>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError" title="就业失业登记证号">就业失业登记证号:</label>
									<div class="col-xs-9 col-sm-2">
										<input class="form-control" type="text" name=""/>
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
							</div>
						</div>

						<div class="bottomBtn">
					   		<div class="h50">&nbsp;</div>
					   		<div class="floatBtn">
						   		<a href="javascript:void(0)" role="button" class="btn btn-primary"  >保存</a>
						   		<a href="javascript:void(0)" role="button" class="btn btn-info" data-toggle="modal">登记新户</a>
						   		<a href="javascript:void(0)" role="button" class="btn btn-success">打印条码标签</a>
					   		</div>
					   	</div>
					</form>
				</div>

				<div id="perEdu" class="tab-pane">
					<!-- 结果列表1 -->
					<div class="mgy10">
						<a href="javascript:void(0)" onclick="addCorp()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus align-top"></i>添加</a>
						<a href="#modal-form1" onclick="editCorp()" role="button" class="btn btn-info" data-toggle="modal"><i class="icon-pencil align-top"></i>修改</a>
						<a href="javascript:void(0)"  role="button" class="btn btn-danger" ><i class="icon-trash align-top"></i>移除</a>
						<a href="javascript:void(0)"  role="button" class="btn  btn-light" ><i class="icon-edit align-top"></i>导入</a>
						<a href="javascript:void(0)"  role="button" class="btn btn-grey" ><i class="icon-external-link align-top"></i>导出</a>
					</div>

					<table id="accountsList"  class="datagridClass"  ></table>
					<div id="jqGridPager"></div>

					<div class="h60">&nbsp;</div>

				   	<div class="floatBtn">
				   		<a href="javascript:void(0)" role="button" class="btn btn-primary">新增</a>
				   		<a href="javascript:void(0)" role="button" class="btn btn-info" data-toggle="modal">修改</a>
				   		<a href="javascript:void(0)" role="button" class="btn btn-danger">保存</a>
				   	</div>

				</div>

				<div id="perExp" class="tab-pane">
				</div>
			</div>
		</div>

	</div>

	<script type="text/javascript">
	$(function() {
	  	//多条结果展示隐藏
		$(".singleSearchBtn").click(function(){
			$(".moreResult").toggle("200");
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
		//折叠展示按钮
		$(".btnToggle").click(function(){
			$(this).parents(".moduleTit").siblings(".moduleCont").slideToggle();
			$(this).children(".showTab").toggle();
			$(this).children(".hideTab").toggle();
		});

		$(".dbToggle").dblclick(function(){
			$(this).siblings(".moduleCont").slideToggle(400);
		});


	});
	</script>
</body>
</html>
