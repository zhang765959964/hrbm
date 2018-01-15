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
	<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />

   	<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
	<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script>
	<script src="${ctx}/assets/js/clipboard.min.js"></script>

	<script>
		$(function() {
			$("#cityInput").selcity({callBack:function(data){
				$("#cityInput").val(data.allname);
				}
			});
			$("#cityInput2").selcity({callBack:function(data){
				$("#cityInput2").val(data.allname);
				}
			});
		});
	</script>
</head>
<body>
	<div class="container-fluid pd-none-wrap">
		<div class="row change-bg-iframe">

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

			<div class="copyBtn">
				<a href="javascript:void(0)" role="button" class="btn btn-info" >复制模块代码</a>
			</div>
			<!-- 个人档案接收模块 -->
			<div class="moduleWrapNobg">
				<div class="moduleTit">存档信息1</div>
				<div class="moduleCont">
					<form id="searchForm">
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>身份证号:</label>
							<div class="col-xs-9 col-sm-2 required">
								<input class="form-control" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>姓名:</label>
							<div class="col-xs-9 col-sm-2 required">
								<input class="form-control" readonly="true" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>出生日期:</label>
							<div class="col-xs-9 input-group col-sm-2 required">
                              	<input class="form-control date-picker dp" id="datepicker01" name="beginaae036" type="text" placeholder="请选择日期"/>
                              	<span class="input-group-addon dp">
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
							<div class="col-xs-9 col-sm-2 required">
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

							<!-- 两列 -->
							<div class="col-xs-12 col-sm-8 twoCol">
								<div class="row">
									<label class="col-xs-3 col-sm-3" for="inputError" title="现居住地址">现居住地址:</label>
									<div class="col-xs-9 col-sm-9">
										<input class="form-control" type="text" name=""/>
									</div>
								</div>
							</div>
							<!-- 三列 -->
							<div class="col-xs-12 col-sm-12 threeCol">
								<div class="row rowTextarea">
									<label class="col-xs-3 col-sm-2" for="inputError" title="基本情况备注">基本情况备注:</label>
									<div class="col-xs-9 col-sm-10">
										<textarea row="5" col="5" readonly="ture"></textarea>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>

			<div class="copyBtn">
				<a href="javascript:void(0)" role="button" class="btn btn-info" >复制模块代码</a>
			</div>
			<!-- 个人信息带身份证图片 -->
			<div class="moduleWrapNobg">
				<div class="moduleTit dbToggle">存档信息2</div>
				<div class="moduleCont">
					<form id="searchForm">
						<div class="row">
							<div class="col-xs-12 col-sm-10 hauto">
								<div class="row">
									<label class="col-xs-3 w1995" for="inputError"><em>*</em>身份证号:</label>
									<div class="col-xs-9 w2009 required">
										<input class="form-control" data-container="body" data-toggle="popover" data-placement="bottom" data-content="必填项"/>
									</div>
									<label class="col-xs-3 w199" for="inputError">姓名:</label>
									<div class="col-xs-9 w361 required">
										<input class="form-control" readonly="readonly" />
									</div>
								</div>
								<div class="row">
									<label class="col-xs-3  w1995" for="inputError">出生日期:</label>
									<div class="col-xs-9 w2009 required">
										<input class="form-control" readonly="readonly" />
									</div>
									<label class="col-xs-3 w199" for="inputError">曾用名:</label>
									<div class="col-xs-9 w361 required">
										<input class="form-control"/>
									</div>
								</div>
								<div class="row">
									<label class="col-xs-3 w1995" for="inputError">性别:</label>
									<div class="col-xs-9 w2009">
										<input class="form-control" type="text" name="Q_aab007_SL" readonly="readonly"/>
									</div>
									<label class="col-xs-3 w199" for="inputError">档案姓名:</label>
									<div class="col-xs-9 w361">
										<input class="form-control" type="text" name=""/>
									</div>
								</div>
								<div class="row">
									<label class="col-xs-3 w1995" for="inputError">民族:</label>
									<div class="col-xs-9 w2009">
										<select class="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code">
											<option value="1">汉族</option>
											<option value="">回族</option>
											<option value="">傣族</option>
											<option value="">其他少数民族</option>
										</select>
									</div>
									<label class="col-xs-3 w199" for="inputError" title="政治面貌">政治面貌:</label>
									<div class="col-xs-9 w361">
										<select class="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code">
											<option value="1">中共党员</option>
											<option value="">团员</option>
											<option value="">无党人士</option>
											<option value="">其他团体</option>
										</select>
									</div>
								</div>
								<div class="row">
									<label class="col-xs-3 w1995" for="inputError" title="文化程度">文化程度:</label>
									<div class="col-xs-9 w2009">
										<select class="form-control" textField="name" hasDefault="0" valueField="code">
											<option value="1">中共党员</option>
											<option value="">团员</option>
											<option value="">无党人士</option>
											<option value="">其他团体</option>
										</select>
									</div>
									<label class="col-xs-3 w199" for="inputError" title="联系电话">联系电话:</label>
									<div class="col-xs-9 w361">
										<input class="form-control" type="text" name=""/>
									</div>
								</div>
								<div class="row">
									<label class="col-xs-3 w1995" for="inputError" title="手机号">手机号:</label>
									<div class="col-xs-9 w2009">
										<input class="form-control" type="text" name=""/>
									</div>
									<label class="col-xs-3 w199" for="inputError" title="是否军转干部">是否军转干部:</label>
									<div class="col-xs-9 w361">
										<select class="form-control" textField="name" hasDefault="0" valueField="code">
											<option value="1">是</option>
											<option value="">否</option>
										</select>
									</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-2 hauto rightImgWrap tar">
								<img class="bd idcard" src="${ctx}/styles/default/images/idcard.jpg" alt="个人身份证图片" width="140" height="196">
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError" title="选择地区">选择地区:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" id="cityInput" name="" value="1" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="是否享有再就业优惠证标准">是否享有再就业优惠证标准:</label>
							<div class="col-xs-9 col-sm-2">
								<select class="form-control" textField="name" hasDefault="0" valueField="code">
									<option value="1">是</option>
									<option value="">否</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="是否持有就业失业登记证">是否持有就业失业登记证:</label>
							<div class="col-xs-9 col-sm-2">
								<select class="form-control" textField="name" hasDefault="0" valueField="code">
									<option value="1">是</option>
									<option value="">否</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="再就业优惠证编号">再就业优惠证编号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" id="cityInput2" type="text" name=""/>
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
					</form>
				</div>
			</div>

			<div class="copyBtn">
				<a href="javascript:void(0)" role="button" class="btn btn-info" >复制模块代码</a>
			</div>
			<!-- 家庭情况-可折叠展开 -->
			<div class="moduleWrapNobg">
				<div class="moduleTit dbToggle">
					<span class="fl">家庭情况</span>
					<span class="fr mgr15">
						<a href="javascript:void(0)" class="btnToggle" onclick="collapseWrap('collapseWrap',this)">
							<i class="icon-double-angle-down collapseBtn"></i>
						</a>
					</span>
				</div>
				<div class="moduleCont dnn" id="collapseWrap">
					<form id="searchForm">
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
					</form>
				</div>
			</div>

			<div class="copyBtn">
				<a href="javascript:void(0)" role="button" class="btn btn-info" >复制模块代码</a>
			</div>
			<!-- 工作情况-带点击按钮 -->
			<div class="moduleWrapNobg">
				<div class="moduleTit"><span class="fl">工作情况</span><span class="mBtn fr mgr15"><a href="javascript:void(0)" onclick="addCorp()" role="button" class="btn btn-danger" data-toggle="modal">编辑工作情况详细资料</a></span></div>
				<div class="moduleCont">
					<form id="searchForm">
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
							<div class="col-xs-12 col-sm-8 twpCol">
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
					</form>
				</div>
			</div>

			<div class="copyBtn">
				<a href="javascript:void(0)" role="button" class="btn btn-info" >复制模块代码</a>
			</div>
			<!-- 工资标准调整 -->
			<div class="moduleWrapNobg">
				<div class="moduleTit">工资标准调整</div>
				<div class="moduleCont">
					<form>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" readonly="true" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" readonly="true" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">民族:</label>
							<div class="col-xs-9 input-group col-sm-2">
                              	<input class="form-control" readonly="true" />
                            </div>
							<label class="col-xs-3 col-sm-2" for="inputError">文化程度:</label>
							<div class="col-xs-9 col-sm-2">
								<select class="form-control">
									<option value="1">高中</option>
									<option value="">本科</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">出生年月:</label>
							<div class="col-xs-9 input-group col-sm-2">
                              	<input class="form-control date-picker dp" id="datepicker01" name="beginaae036" type="text" placeholder="请选择日期"/>
                              	<span class="input-group-addon">
                                  	<i class="icon-calendar bigger-110"></i>
                              	</span>
                            </div>
							<label class="col-xs-3 col-sm-2" for="inputError">参加工作时间:</label>
							<div class="col-xs-9 input-group col-sm-2">
                              	<input class="form-control date-picker dp" id="datepicker01" name="beginaae036" type="text" placeholder="请选择日期"/>
                              	<span class="input-group-addon">
                                  	<i class="icon-calendar bigger-110"></i>
                              	</span>
                            </div>
							<label class="col-xs-3 col-sm-2" for="inputError">现岗位职位工种:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name=""/>
							</div>
						</div>
						<hr/>

						<!-- 工资调整情况 -->
						<div class="clearfix">
							<div class="halfLeft">
								<h3>调整情况（调整前）</h3>
								<div class="col-xs-12 col-sm-12 twoCol2">
									<div class="row">
										<label class="col-xs-3 col-sm-3" for="inputError" title="执行何工资制度">执行何工资制度:</label>
										<div class="col-xs-9 col-sm-8">
											<input class="form-control" type="text" name=""/>
										</div>
									</div>
								</div>
								<!-- 工资标准双input -->
								<div class="row">
									<div class="col-xs-12 col-col-12">
										<label class="col-xs-3 col-sm-3" for="inputError">技能或等级工资级别:</label>
										<div class="col-xs-9 col-sm-4">
											<input class="form-control" />
										</div>
										<div class="col-xs-9 col-sm-4">
											<input class="form-control" />
										</div>
										<span class="col-xs-3 col-sm-1 pd0">元</span>
									</div>
								</div>

								<div class="row">
									<div class="col-xs-12 col-col-12">
										<label class="col-xs-3 col-sm-3" for="inputError">技能或等级工资级别:</label>
										<div class="col-xs-9 col-sm-4">
											<input class="form-control" />
										</div>
										<div class="col-xs-9 col-sm-4">
											<input class="form-control" />
										</div>
										<span class="col-xs-3 col-sm-1 pd0">元</span>
									</div>
								</div>

								<div class="row">
									<div class="col-xs-12 col-col-12">
										<label class="col-xs-3 col-sm-3" for="inputError">联动工资:</label>
										<div class="col-xs-9 col-sm-4">
										</div>
										<div class="col-xs-9 col-sm-4">
											<input class="form-control" />
										</div>
										<span class="col-xs-3 col-sm-1 pd0">元</span>
									</div>
								</div>

								<div class="row">
									<div class="col-xs-12 col-col-12">
										<label class="col-xs-3 col-sm-3" for="inputError">工龄工资:</label>
										<div class="col-xs-9 col-sm-4">&nbsp;
										</div>
										<div class="col-xs-9 col-sm-4">
											<input class="form-control" />
										</div>
										<span class="col-xs-3 col-sm-1 pd0">元</span>
									</div>
								</div>

								<div class="row">
									<div class="col-xs-12 col-col-12">
										<label class="col-xs-3 col-sm-3" for="inputError">调整前合计:</label>
										<div class="col-xs-9 col-sm-4">
										</div>
										<div class="col-xs-9 col-sm-4">
											<input class="form-control" readonly="true" />
										</div>
										<span class="col-xs-3 col-sm-1 pd0">元</span>
									</div>
								</div>

							</div>
							<div class="halfRight">
								<h3>调整情况（调整后）</h3>
								<div class="col-xs-12 col-sm-12 twoCol">
									<div class="row">
										<label class="col-xs-3 col-sm-3" for="inputError" title="执行何工资制度">执行何工资制度:</label>
										<div class="col-xs-9 col-sm-8">
											<input class="form-control" type="text" name=""/>
										</div>
									</div>
								</div>
								<!-- 工资标准双input -->
								<div class="row">
									<div class="col-xs-12 col-col-12">
										<label class="col-xs-3 col-sm-3" for="inputError">技能或等级工资级别:</label>
										<div class="col-xs-9 col-sm-4">
											<input class="form-control" />
										</div>
										<div class="col-xs-9 col-sm-4">
											<input class="form-control" />
										</div>
										<span class="col-xs-3 col-sm-1 pd0">元</span>
									</div>
								</div>

								<div class="row">
									<div class="col-xs-12 col-col-12">
										<label class="col-xs-3 col-sm-3" for="inputError">技能或等级工资级别:</label>
										<div class="col-xs-9 col-sm-4">
											<input class="form-control" />
										</div>
										<div class="col-xs-9 col-sm-4">
											<input class="form-control" />
										</div>
										<span class="col-xs-3 col-sm-1 pd0">元</span>
									</div>
								</div>

								<div class="row">
									<div class="col-xs-12 col-col-12">
										<label class="col-xs-3 col-sm-3" for="inputError">联动工资:</label>
										<div class="col-xs-9 col-sm-4">
										</div>
										<div class="col-xs-9 col-sm-4">
											<input class="form-control" />
										</div>
										<span class="col-xs-3 col-sm-1 pd0">元</span>
									</div>
								</div>

								<div class="row">
									<div class="col-xs-12 col-col-12">
										<label class="col-xs-3 col-sm-3" for="inputError">工龄工资:</label>
										<div class="col-xs-9 col-sm-4">&nbsp;
										</div>
										<div class="col-xs-9 col-sm-4">
											<input class="form-control" />
										</div>
										<span class="col-xs-3 col-sm-1 pd0">元</span>
									</div>
								</div>

								<div class="row">
									<div class="col-xs-12 col-col-12">
										<label class="col-xs-3 col-sm-3" for="inputError">调整后合计:</label>
										<div class="col-xs-9 col-sm-4">
										</div>
										<div class="col-xs-9 col-sm-4">
											<input class="form-control" readonly="true" />
										</div>
										<span class="col-xs-3 col-sm-1 pd0">元</span>
									</div>
								</div>
							</div>
						</div>

						<hr/>
						<!-- 等级升级情况 -->
						<div class="clearfix">
							<div class="halfLeft">
								<h3>升级情况（升级前）</h3>
								<div class="row">
									<label class="col-xs-3 col-sm-3" for="inputError" title="升级前等级">升级前等级:</label>
									<div class="col-xs-9 col-sm-6">
										<input class="form-control" type="text" name=""/>
									</div>
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-3" for="inputError" title="升级前月工资标准">升级前月工资标准:</label>
									<div class="col-xs-9 col-sm-6">
										<input class="form-control" type="text" name=""/>
									</div>
								</div>
							</div>
							<div class="halfRight">
								<h3>升级情况（升级后）</h3>
								<div class="row">
									<label class="col-xs-3 col-sm-3" for="inputError" title="升级后等级">升级后等级:</label>
									<div class="col-xs-9 col-sm-6">
										<input class="form-control" type="text" name=""/>
									</div>
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-3" for="inputError" title="升级后月工资标准">升级后月工资标准:</label>
									<div class="col-xs-9 col-sm-6">
										<input class="form-control" type="text" name=""/>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>

			<div class="moduleWrapNobg">
				<div class="moduleTit">统计信息</div>
				<div class="moduleCont">
					<p class="tal textIndent">统计信息</p>
					<p class="tac colorRed">党费管理人数共计&nbsp;58&nbsp;人，已缴费人数&nbsp;40&nbsp;人，未交费人数&nbsp;18&nbsp;人</p>
				</div>
			</div>

			<hr />
			<div class="col-xs-12 col-sm-12">
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
					<div class="col-xs-9 col-sm-2">
	                  	<input class="form-control" readonly="readonly" />
	                </div>
					<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
					<div class="col-xs-9 col-sm-2">
						<input class="form-control" readonly="readonly" />
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
					<div class="col-xs-9 col-sm-2">
						<input class="form-control" readonly="readonly" />
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-6">
				<a href="javascript:void(0)" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-camera"></i>拍照</a>
				<a href="javascript:void(0)" role="button" class="btn btn-info fileSc"><i class="icon-upload-alt"></i><input type="file" name="" id="">照片上传</a>
				<a href="javascript:void(0)" role="button" class="btn btn-danger"><i class="icon-trash"></i>照片删除</a>
			</div>

			<div class="col-xs-12 col-sm-6">
				<a href="javascript:;" class="fileSc btn btn-info">
					<i class="icon-upload-alt"></i>选择文件
				    <input type="file" name="" id="">
				</a>
			</div>


	   	</div><!-- row end -->

   		<div class="floatBtn">
	   		<a href="javascript:void(0)" role="button" class="btn btn-primary" onclick="submitForm()"><i class="icon-save"></i>保存</a>
	   		<a href="javascript:void(0)" role="button" class="btn btn-info" onclick="closeItem()"><i class="icon-remove"></i>关闭</a>
	   		<a href="javascript:void(0)" role="button" class="btn btn-success">打印条码标签</a>
   		</div>

	</div>

	<script type="text/javascript">
	jQuery(function($) {
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
		//多条结果展示隐藏
		$(".singleSearchBtn").click(function(){
			$(".moreResult").toggle("200");
		});
		$(".dbToggle").dblclick(function(){
			$(this).siblings(".moduleCont").slideToggle(400);
		});

		$("span.input-group-addon").click(function(){
			console.log($("span.input-group-addon").length);
			console.log($(this).index());
		})

		for(var i = 0; i<$(".input-group-addon").length; i++){
			$(".input-group-addon").eq(i).click(function(){
				$(".datetimepicker").eq(i).toggle();

			})
		}
		// $(".dbToggle").dblclick(function(){
		// 	$(this).siblings(".moduleCont").slideToggle(400);
		// 	$(this).children("i").toggleClass("icon-double-angle-down");
		// 	$(this).children("i").toggleClass("icon-double-angle-up");
		// });

	});

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
	    // console.log(e.text);
	    alert("代码已复制到剪切板，粘贴即可使用！");
	});

	</script>
</body>
</html>
