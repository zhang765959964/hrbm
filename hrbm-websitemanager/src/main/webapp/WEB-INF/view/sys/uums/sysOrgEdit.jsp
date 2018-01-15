<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>编辑机构信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp"%>
<%@include file="/commons/include/bootstrapInc.jsp"%>
<script type="text/javascript">
//地图显示隐藏
function selectClick(){
	//机构名称
	var corpName=$("#acd202").val();
	//机构地址
	var corpAddress=$("#aae006").val();
	if(corpName==""){
		bootbox.alert("请先填写机构名称");
	}else{
		if(corpAddress==""){
			bootbox.alert("请填写场所地址");
		}else{
			$(".mapContent").toggle();
			if($(".mapContent").attr("display")=="none")
			{
				$("body").css({"overflow-y":"hidden"});
			}
			else{
				$("body").css({"overflow-y":"auto"});
			}
		}
	}
}
//关闭地图
function closeClick(){
	$(".mapContent").hide();
	$("body").css({"overflow-y":"auto"});
	$("#corpX").val(cpX);
	$("#corpY").val(cpY);	
}
	function checkAcd202(){
		var res = false;
		$.ajax({
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			url : '${ctx}/sys/uums/sysOrg/isExist.xf',
			data : {
				'acd200exists':$("#acd200").val(),
				'acd202exists':$("#acd202").val()
			},
			async : false,
			type: "post", 
			dataType : 'json',
			success : function(data) {
				res = (data.result == '0');
			},
			error : function() {
				res = false
			}
		});
		//部门是否已存在
		if (!res) {
			$("small[data-bv-validator$='stringLength'][data-bv-for$='acd202']")
					.html("机构名称已存在");
			$("small[data-bv-validator$='stringLength'][data-bv-for$='acd202']")
					.show();
			 $(".button_submit").attr("disabled",true)
			  return false;
		}else{
			return true;
		}
	}
	function checkAcd201(){
		var res = false;
		$.ajax({
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			url : '${ctx}/sys/uums/sysOrg/isExist.xf',
			data : {
				'acd200exists':$("#acd200").val(),
				'acd201exists':$("#acd201").val()
			},
			async : false,
			type: "post", 
			dataType : 'json',
			success : function(data) {
				res = (data.result == '0');
			},
			error : function() {
				res = false
			}
		});
		//部门是否已存在
		if (!res) {
			$("small[data-bv-validator$='stringLength'][data-bv-for$='acd201']")
					.html("许可证编号已存在");
			$("small[data-bv-validator$='stringLength'][data-bv-for$='acd201']")
					.show();
			 $(".button_submit").attr("disabled",true)
			  return false;
		}else{
			return true;
		}
	}
	$(function() {
	     var cpX ='${sysOrgForm.cabq02}';
         var cpY ='${sysOrgForm.cabq03}';
		initFormSubimt();
		 //行政区划绑定组件
		 $("#aab201").selcity({callBack:function(data){
			    $("#aab201").val(data.allname);
				$("#aab301").val(data.code);
				if (data.allname!= ""){
	                $('#sysOrgForm')
	               .data('bootstrapValidator')
	               .updateStatus('aab201','VALID', null)
	               .validateField('aab201');
	             }
			  }
			});
		$('#acd201').on('blur',
				function(e) {
					var value = $(this).val();
					if (value != "" && value.length >= 1
							&& value.length <= 20) {
						checkAcd201();
					}
				});
		$('#acd202').on('blur',
				function(e) {
					var value = $(this).val();
					if (value != "" && value.length >= 1
							&& value.length <= 25) {
						checkAcd202();
					}
				});
		$('#acd20k').on('change',
				function(e) {
					if ($(this).val() != "") {
						$('#sysOrgForm').data('bootstrapValidator')
								.updateStatus('acd20k', 'VALID', null)
								.validateField('acd20k');

					}
				});
	});
	function initFormSubimt() {
		$('#sysOrgForm')
				.bootstrapValidator(
						{
							message : 'This value is not valid',
							feedbackIcons : {
								valid : 'glyphicon glyphicon-ok',
								invalid : 'glyphicon glyphicon-remove',
								validating : 'glyphicon glyphicon-refresh'
							},
							fields : {
							    //行政区划验证
					            aab201:{
					            	validators: {
					            		notEmpty: {message: '请选择机构所在地'}
					            		}
					            }, 
								acd202 : {
									validators : {
										notEmpty : {
											message : '职介机构名不能为空'
										},
										stringLength : {
											message : '最大长度为25',
											min : 1,
											max : 25
										}
									}
								},
								acd20s : {
									validators : {
										notEmpty : {
											message : '机构分类不能为空'
										}
									}
								},
								acd203 : {
									validators : {
										notEmpty : {
											message : '机构类别不能为空'
										}
									}
								},
								acd204 : {
									validators : {
										notEmpty : {
											message : '机构性质不能为空'
										}
									}
								},
								aab201 : {
									validators : {
										notEmpty : {
											message : '机构所在地不能为空'
										},
										stringLength : {
											message : '最大长度为20',
											min : 1,
											max : 20
										}
									}
								},
								acd201 : {
									validators : {
										notEmpty : {
											message : '许可证编号不能为空'
										},
										stringLength : {
											message : '最大长度为20',
											min : 1,
											max : 20
										}
									}
								},
								acd20k : {
									validators : {
										notEmpty : {
											message : '有效期不能为空'
										},
										stringLength : {
											message : '最大长度为10',
											min : 1,
											max : 10
										}
									},
									date : {
										format : 'YYYY/DD/MM'
									}
								},
								acd20a : {
									validators : {
										regexp : {
											regexp : /((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/,
											message : '格式不正确'
										}
									}
								},
								aab013 : {
									validators : {
										stringLength : {
											message : '最大长度为5',
											min : 1,
											max : 5
										}
									}
								},
								aab014 : {
									validators : {
										regexp : {
											regexp : /^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/,
											message : '身份证格式不正确'
										}
									}
								},
								aab015 : {
									validators : {
										phone : {
											message : '联系电话格式不正确',
											country : 'CN'
										}
									}
								},
								aae004 : {
									validators : {
										stringLength : {
											message : '最大长度为5',
											min : 1,
											max : 5
										}
									}
								},
								aae005 : {
									validators : {
										regexp : {
											regexp : /((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/,
											message : '联系电话格式不正确'
										}
									}
								},
								bcd202 : {
									validators : {
										stringLength : {
											message : '最大长度为25',
											min : 1,
											max : 25
										}
									}
								},
								acd205 : {
									validators : {
										stringLength : {
											message : '最大长度为100',
											min : 1,
											max : 100
										}
									}
								},
								aae007 : {
									validators : {
										regexp : {
											regexp : /^[1-9]\d{5}$/,
											message : '邮政编码格式不正确'
										}
									}
								},
								ccmu04 : {
									validators : {
										stringLength : {
											message : '最大长度为50',
											min : 1,
											max : 50
										}
									}
								},
								aae006 : {
									validators : {
										stringLength : {
											message : '最大长度为30',
											min : 1,
											max : 30
										}
									}
								},
								//场所面积
								acd20b : {
									validators : {
										stringLength : {
											message : '最大长度为30',
											min : 1,
											max : 30
										}
									}
								},
								acd20c : {//设备设施
									validators : {
										stringLength : {
											message : '最大长度为30',
											min : 1,
											max : 30
										}
									}
								},//
								aab049 : {
									validators : {
										stringLength : {
											message : '最大长度为15',
											min : 1,
											max : 15
										},
										regexp : {
											regexp : /^[1-9]\d{0,8}\.\d{1,2}|0\.[1-9]\d{1,2}|[1-9]\d{0,8}$/,
											message : '格式不正确'
										}
									}
								},
								acd20m : {
									validators : {
										stringLength : {
											message : '最大长度为30',
											min : 1,
											max : 30
										}
									}
								},
								acd20d : {
									validators : {
										stringLength : {
											message : '最大长度为15',
											min : 0,
											max : 15
										},
										regexp : {
											regexp : /^\+?[0-9][0-9]*$/,
											message : '请输入正整数'
										}
									}
								},
								acd20e : {
									validators : {
										//
										stringLength : {
											message : '最大长度为15',
											min : 0,
											max : 15
										},
										regexp : {
											regexp : /^\+?[0-9][0-9]*$/,
											message : '请输入正整数'
										}
									}
								},
								acd20f : {
									validators : {
										//
										stringLength : {
											message : '最大长度为15',
											min : 0,
											max : 15
										},
										regexp : {
											regexp : /^\+?[0-9][0-9]*$/,
											message : '请输入正整数'
										}
									}
								},
								acd20g : {
									validators : {
										//
										stringLength : {
											message : '最大长度为15',
											min : 0,
											max : 15
										},
										regexp : {
											regexp : /^\+?[0-9][0-9]*$/,
											message : '请输入正整数'
										}
									}
								}

							}
						})
				.on(
						'success.form.bv',
						function(e) {
							e.preventDefault();
							var $form = $(e.target);
							var isEdit = '${isEdit}';
							if (!isEdit) {
								$("#aae044").val(
										$("#aab034 option:selected").text());
							}
							var bv = $form.data('bootstrapValidator');
							if(checkAcd202()&&checkAcd201()){
								bv.disableSubmitButtons(true);
							$.post(
											$form.attr('action'),
											$form.serialize(),
											function(data) {
												$(".btn-submit").removeAttr(
														"disabled");
												bootbox
														.alert({
															size : 'small',
															width : "100px",
															message : data.message,
															callback : function() {
																bv.disableSubmitButtons(false);
																var parentIframe = xfui
																		.getParentIframe();
																if (parentIframe) {
																	parentIframe
																			.refresh();
																}
																closeItem();

															}
														})

											}, 'json')};

						});
	}
	function closeItem() {
		xfui.closeTab();
		xfui_tab_Top.find("li a").each(function(){
			 if($(this).text().trim()=="机构管理"){
				 $(this).tab('show');
			 }
		});
	}
	
</script>
<style type="text/css">
.mhyCorpSearchValue{display:none;}
.mhycorp:hover .mhyCorpSearchValue{display:block;}
.mapContent{display:none;}
.mapDiv{ bottom: 20px;height: 90%;left: 6%;position: fixed;top: 30px;width: 90%;z-index: 1000;}
.mapDiv .alert-success{margin-bottom:0;padding-bottom:0px !important;}
.mapDivBg{background:rgba(0,0,0,0.8);position: fixed;top:0;left:0;right:0;bottom:0;z-index:10;}
.mapDiv .close{margin-right:20px;}}
</style>
</head>
<body>
	<div class="main-container">
		<div class="container-fluid">
			<div class="mhySearch">
				<div class="mhyTitle">机构基本信息</div>
				<form:form modelAttribute="sysOrgForm" method="post"
					action="${ctx}/sys/uums/sysOrg/save.xf">
					<form:hidden path="acd200"></form:hidden>
					<div class="mhySearchInput mhyInputDiv">
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError"><i
								style="color: red; margin-right: 5px;">*</i>职介机构名称：</label>
							<div class="col-xs-9 col-sm-6">
								<form:input class="form-control" type="text" path="acd202"
									data-options="required:true"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError"><i
								style="color: red; margin-right: 5px;">*</i>许可证编号：</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="text" path="acd201"
									data-options="required:true"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError"><i
								style="color: red; margin-right: 5px;">*</i>机构分类：</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select selectClass="form-control" textField="name"
									tableName="TAB_ORGCLASS" name="acd20s"
									value="${sysOrgForm.acd20s}" valueField="code" hasDefault="0"
									isNoStyle="true">
								</xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError"><i
								style="color: red; margin-right: 5px;">*</i>机构类别：</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select selectClass="form-control" textField="name"
									tableName="TAB_ORGSORT" name="acd203"
									value="${sysOrgForm.acd203}" valueField="code" hasDefault="0"
									isNoStyle="true">
								</xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError"><i
								style="color: red; margin-right: 5px;">*</i>有效期：</label>
							<div class="col-xs-9 col-sm-2">
								<div class="input-group" style="padding: 0 !important;">
									<form:input class="form-control" readonly="true" type="text"
										path="acd20k" data-options="required:false"></form:input>
									<span class="input-group-addon"> <i
										class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError"><i
								style="color: red; margin-right: 5px;">*</i>机构性质：</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select selectClass="form-control" textField="name"
									tableName="TAB_ORGNATURE" name="acd204"
									value="${sysOrgForm.acd204}" hasDefault="0" valueField="code"
									isNoStyle="true">
								</xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError"><i
								style="color: red; margin-right: 5px;">*</i>机构所在地：</label>
							<div class="col-xs-9 col-sm-2 mhyNoSelect">
							    <form:hidden path="aab301"></form:hidden>
								<form:input class="form-control" type="text" path="aab201" value="${sysOrgForm.aab201}"></form:input>
							</div>
					 
						 
							<label class="col-xs-3 col-sm-2" for="inputError">职介机构别名：</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="text" path="bcd202"
									data-options="required:false"></form:input>
							</div>
						</div>
						<!-- +++++++++++++++++++++++++++++++以上为必须++++++++++++++++++++++++++++++++++++++++++++++++ -->
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError"><i
								style="color: red; margin-right: 5px;">*</i>父级机构：</label>
							<div class="col-xs-9 col-sm-2">
								<form:hidden path="aae044" />
								<c:choose>
									<c:when test="${isEdit}">
										<form:hidden path="aab034" />
										<div>${sysOrgForm.aae044}</div>
									</c:when>
									<c:otherwise>
										<form:select path="aab034" items="${sysOrgs}"
											itemLabel="acd202" dir="1" itemValue="acd200">
										</form:select>
									</c:otherwise>
								</c:choose>

							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">法人公司身份证号码：</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="text" path="aab014"
									data-options="required:false"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">机构法定负责人：</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="text" path="aab013"
									data-options="required:false"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">信用等级：</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select selectClass="form-control" textField="name"
									tableName="TAB_ORGRANK" name="acd20u"
									value="${sysOrgForm.acd20u}" hasDefault="0" valueField="code"
									isNoStyle="true">
								</xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">法人联系电话：</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="text" path="aab015"
									data-options="required:false"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">公开服务电话：</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="text" path="acd20a"
									data-options="required:false"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">经费来源：</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select selectClass="form-control" hasDefault="0"
									textField="name" tableName="TAB_FUNDSOURCE" name="acd206"
									value="${sysOrgForm.acd206}" valueField="code" isNoStyle="true">
								</xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">联系人：</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="text" path="aae004"
									data-options="required:false"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">联系人电话：</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="text" path="aae005"
									data-options="required:false"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">人员规模：</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select selectClass="form-control" textField="name"
									tableName="TAB_PSCALE" name="aab056"
									value="${sysOrgForm.aab056}" valueField="code" hasDefault="0"
									isNoStyle="true">
								</xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">场所地址：</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="text" path="aae006"
									data-options="required:false"></form:input>
							</div>
								<label class="col-xs-3 col-sm-2" for="inputError">地图：</label>
							<div class="col-xs-9 col-sm-2">
							    <form:hidden id="corpX" path="cabq02" ></form:hidden>
							    <form:hidden id="corpY" path="cabq03" ></form:hidden>
							    <a href="javascript:void(0)" id="mySelect" onclick="selectClick()">地图标记</a>
							</div>
						</div>
						<!---- --------------------------------------------其他信息---------------------------------------------------------------------->
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">注册机关：</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select selectClass="form-control" textField="name"
									tableName="TAB_REGORG" name="acd20m"
									value="${sysOrgForm.acd20m}" hasDefault="0" valueField="code"
									isNoStyle="true">
								</xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">场所面积：</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="text" path="acd20b"
									data-options="required:false"></form:input>
							</div>
									<label class="col-xs-3 col-sm-2" for="inputError">注册资金(万元)：</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="text" maxlength="15"
									path="aab049" data-options="required:false"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">服务网站个数：</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="number" maxlength="15"
									path="acd20g" data-options="required:false"></form:input>
							</div>
								<label class="col-xs-3 col-sm-2" for="inputError">工作人员数：</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="number" maxlength="15"
									path="acd20d" data-options="required:false"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">其中持证人员数：</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="number" maxlength="15"
									path="acd20e" data-options="required:false"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">固定招聘场所个数：</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="number" maxlength="15"
									path="acd20f" data-options="required:false"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">设备设施：</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="text" path="acd20c"
									data-options="required:false"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">邮政编码：</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="text" path="aae007"
									data-options="required:false"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">乘车路线：</label>
							<div class="col-xs-9 col-sm-10">
								<form:textarea class="form-control" type="text" path="ccmu04"
									data-options="required:false"></form:textarea>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">许可经营范围：</label>
							<div class="col-xs-9 col-sm-10">
								<form:textarea row="5" col="5" style="width:100%;resize:none;"
									path="acd205" data-options="required:false"></form:textarea>
							</div>
						</div>
						<!-- 				申请相关暂隐藏 -->
						<!-- 				<div class="col-xs-12 col-sm-6"> -->
						<!-- 					<label class="col-xs-4" for="inputError">申请标记：</label> -->
						<!-- 					<div class="col-xs-9 col-sm-2"> -->
						<%-- 						<form:input class="form-control" type="text" path="aaea98" --%>
						<%-- 							data-options="required:false"></form:input> --%>
						<!-- 					</div> -->
						<!-- 				</div> -->
						<!-- 				<div class="col-xs-12 col-sm-6"> -->
						<!-- 					<label class="col-xs-4" for="inputError">申请意见：</label> -->
						<!-- 					<div class="col-xs-9 col-sm-2"> -->
						<%-- 						<form:input class="form-control" type="text" path="aaea13" --%>
						<%-- 							data-options="required:false"></form:input> --%>
						<!-- 					</div> -->
						<!-- 				</div> -->
						<!-- 				<div class="col-xs-12 col-sm-6"> -->
						<!-- 					<label class="col-xs-4" for="inputError">申请经办人代码：</label> -->
						<!-- 					<div class="col-xs-9 col-sm-2"> -->
						<%-- 						<form:input class="form-control" type="text" path="aaea11" --%>
						<%-- 							data-options="required:false"></form:input> --%>
						<!-- 					</div> -->
						<!-- 				</div> -->
						<!-- 				<div class="col-xs-12 col-sm-6"> -->
						<!-- 					<label class="col-xs-4" for="inputError">申请经办人：</label> -->
						<!-- 					<div class="col-xs-9 col-sm-2"> -->
						<%-- 						<form:input class="form-control" type="text" path="aaea19" --%>
						<%-- 							data-options="required:false"></form:input> --%>
						<!-- 					</div> -->
						<!-- 				</div> -->
						<!-- ---------------------------------------------------------------------------------------------------------------- -->
						<div class="row">
							<div class="col-sm-12 mhyUnitBtn">
								<!-- onclick="initFormSubimt()" -->
								<a class="btn btn-info mhyBtnLeft" type="button" role="button"
									onclick="closeItem()"><i class="icon-remove"></i>关闭</a>
								<button class="btn btn-primary" id="button_submit" type="submit">
								<i class="icon-save"></i>
								保存
								</button>
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<div class="h50">&nbsp;</div>
<div class="mapContent">
	<div class="mapDivBg"  onclick="selectClick()"></div>
<div class="mapDiv">

	<div class="alert alert-success" role="alert">
		<form id="fmmachine" method="post" class="form-horizontal">
			<div class="form-group">
				<div class="col-sm-6">
					<span class="btn btn-success" onclick="selectClick()">确认选择</span>
				</div>
				<span class="close"  onclick="closeClick()">关闭</span>
			</div>
		</form>
	</div>
<div class="container-fluid" id="map" style="height:90%;"></div>	
 </div>
</div>
</body>
<script type="text/javascript">
	jQuery(function($) {
		// 日期选择
		$("#acd20k").datetimepicker({
			todayBtn : true,
			format : "yyyy-mm-dd",
			startView : 2,
			minView : 2,
			language : 'cn',
			maxView : "decade",
			viewSelect : 2,
			autocomplete : true,
			autoclose : true
		});
		$(".dp").datetimepicker({
			todayBtn : true,
			format : "yyyy-mm-dd",
			startView : 2,
			minView : 2,
			maxView : "decade",
			viewSelect : 2,
			language : 'cn',
			autocomplete : true,
			autoclose : true
		});
		$(".dpMonth").datetimepicker({
			todayBtn : true,
			format : "yyyy-mm",
			startView : 3,
			minView : 3,
			maxView : "decade",
			language : 'cn',
			viewSelect : 3,
			autocomplete : true,
			autoclose : true
		});
	});
</script>

<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=l5kCK1PnCuM4Tavr03T6aZx9"></script>
<script type="text/javascript" src="http://developer.baidu.com/map/jsdemo/demo/convertor.js"></script>
<script type="text/javascript">
	
	$(function(){
			add_control();
			mySelect();
		});
		 // 百度地图API功能
		function G(id) {
			return document.getElementById(id);
		}
		var opts = {
				width : 200,     // 信息窗口宽度
				height: 100,     // 信息窗口高度
				title : '${sysOrgForm.acd202}' , //信息窗口标题
				enableMessage:true,//设置允许信息窗发送短息
				message:'联系地址'
			}
		var infoWindow = new BMap.InfoWindow("地址："+"${sysOrgForm.aae006}", opts);  // 创建信息窗口对象
		var map = new BMap.Map("map");          // 创建地图实例
		var point = new BMap.Point(115.02595,35.772036);  // 创建点坐标
		var marker = new BMap.Marker(point);
		marker.addEventListener("click", function(){
			
			map.openInfoWindow(infoWindow, point); //开启信息窗口
		});
		var zoom=15;
		<c:if test="${!empty sysOrgForm.cabq02}">
		point = new  BMap.Point(${sysOrgForm.cabq02}, ${sysOrgForm.cabq03});
		newMarker(point);
		map.openInfoWindow(infoWindow, point); //开启信息窗口
		</c:if>  
		map.centerAndZoom(point, zoom);
		map.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
		map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用

		var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});// 左上角，添加比例尺
		var top_left_navigation = new BMap.NavigationControl();  //左上角，添加默认缩放平移控件
		function add_control(){
			map.addControl(top_left_control);
			map.addControl(top_left_navigation);
		}
		var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
				{"input" : "suggestId"
					,"location" : map
				});
		ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
			var str = "";
			var _value = e.fromitem.value;
			var value = "";
			if (e.fromitem.index > -1) {
				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
			}
			str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;

			value = "";
			if (e.toitem.index > -1) {
				_value = e.toitem.value;
				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
			}
			str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
			G("searchResultPanel").innerHTML = str;
		});

		var myValue;
		ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
			var _value = e.item.value;
			myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
			G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;

			setPlace();
		});
		function setPlace(){
			map.clearOverlays();    //清除地图上所有覆盖物
			function myFun(){
				point = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
				map.centerAndZoom(point, 18);
				marker = new BMap.Marker(point);
				map.addOverlay(marker);    //添加标注
				//
				
				map.openInfoWindow(infoWindow, point); //开启信息窗口
			}
			var local = new BMap.LocalSearch(map, { //智能搜索
				onSearchComplete: myFun
			});
			local.search(myValue);
		}
		//自己选择位置
		var myPushpin;
		function mySelect(){ 
				$("#mySelect").on("click",function(e){ 
					var mapTitle= $("#acd202").val();
					var mapMessage= $("#aae006").val(); 
					if(mapTitle){
						opts.title=mapTitle;
					}
					mapMessage= mapMessage?mapMessage:"${sysOrgForm.acd202}";
					infoWindow = new BMap.InfoWindow("地址："+mapMessage, opts);  // 创建信息窗口对象
					e.preventDefault();
					myPushpin = new BMapLib.MarkerTool(map,{autoClose: false, followText: ""})         // 创建标注工具实例
					myPushpin.addEventListener("markend", function(ee){  // 监听事件，提示标注点坐标信息
						map.removeOverlay(marker);    //清除地图上所有覆盖物
						point = ee.marker.point;
						marker = ee.marker;
						map.openInfoWindow(infoWindow, point); //开启信息窗口.
						ee.marker.addEventListener("click", function(){
							map.openInfoWindow(infoWindow, point); //开启信息窗口
						});
						var markerPosition = marker.getPosition();
						x=markerPosition["lng"];
						y=markerPosition["lat"];
						$("#corpX").val(x);
						$("#corpY").val(y);
					});
					myPushpin.open();
				});
		};
		function newMarker(point){
			map.clearOverlays();    //清除地图上所有覆盖物
			map.openInfoWindow(infoWindow, point);
			marker = new BMap.Marker(point);
			map.addOverlay(marker);
			marker.addEventListener("click", function(){
				map.openInfoWindow(infoWindow, point); //开启信息窗口
			});
		}
		
	</script>
	<script src="${ctx}/js/lib/map/MarkerTool_min.js"></script>

</html>