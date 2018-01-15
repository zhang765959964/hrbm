<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<title>编辑招聘信息</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp"%>
<%@include file="/commons/include/bootstrapInc.jsp"%>
<style type="text/css">
.mhyCorpSearchValue{display:none;}
.mhycorp:hover .mhyCorpSearchValue{display:block;}
</style>
</head>
<script type="text/javascript">
function restCheckField(fieldName){
	$('#corpPublicPositionForm').data('bootstrapValidator')
		.updateStatus(fieldName, 'VALID', null)
		.validateField(fieldName);
}
function initTable() {
 	var json = $("#searchForm").serializeJson();
	var columns = [
                   {field:'aab004',title:'单位名称'},
				   {field:'aab007',title:'营业执照号码'}
                   ] ;
	$('#corpList').bootstrapTable({
		url : '${ctx}/business/corp/corp/listSelect.xf?ccpr08=0',
		columns: columns,
		method:"post",
	    contentType:"application/x-www-form-urlencoded",
	    sidePagination:"server",
	    onClickRow :function(rowIndex, rowData){
        	//设置企业信息
        	$("#aab001").val(rowIndex.aab001);
        	$("#aab004").val(rowIndex.aab004);
        	//发布名称默认为企业名称
        	$("#bab004").val(rowIndex.aab004);
        	$("#aae004").val(rowIndex.aae004);
        	$("#aae005").val(rowIndex.aae005);
        	$("#aae006").val(rowIndex.aae006);
        	$("#aae139").val(rowIndex.aae139);
        	$("#aac002").val(rowIndex.bab014);
        	$("#acb20c").val(rowIndex.aae006);
        	$("#acb205").val(rowIndex.acb205);
        	if(rowIndex.acb206)
        	$("#acb206").text(rowIndex.acb206);
        	restCheckField('aab004');
//         	restCheckField('bab004');
//         	restCheckField('aae004');
//         	restCheckField('aae005');
//         	restCheckField('aae006');
        	//ACB205
        	//BAB014,
        	//AAE139
        	disableButton();
		},
	});
	$("#corpList").bootstrapTable('refresh', {	
		query: json
	})
}
	$(function() {
		initFormSubimt();
		 $('#aae030').on('change', function (e) {
             if ($(this).val() != "")
             {
                $('#corpPublicPositionForm')
               .data('bootstrapValidator')
               .updateStatus('aae030','VALID', null)
               .validateField('aae030');
    
             }
             
          });
		 $('#aae031').on('change', function (e) {
             if ($(this).val() != "")
             {
                $('#corpPublicPositionForm')
               .data('bootstrapValidator')
               .updateStatus('aae031','VALID', null)
               .validateField('aae031');
    
             }
             
          });
		//initTable();
	})
	 function disableButton(){
	 var aab001=$("#aab001").val();
	 if(aab001){
		 if(!hasEditPermi(aab001,2)){
			 $(".btn-primary").attr("disabled","disabled");
			 $(".btn-primary").attr("title","无编辑权限");
		 }
	 }

 }
	function initFormSubimt() {
		$('#corpPublicPositionForm').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				//单位名称
				aab004 : {
					validators : {
						notEmpty : {
							message : '单位名称不能为空'
						},
						stringLength : {
							min : 2,
							max : 50
						}
					}
				},
				aae005: {
	                  validators: {
		                	  notEmpty : {
									message : '联系电话不能为空'
								},
		                      regexp:{
		                    	  regexp:/((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/,
		                    	  message:'电话格式不正确'
		                      }
	                      }
	                   },
				//发布职位名称
				bab004 : {
					validators : {
						notEmpty : {
							message : '请填写发布职位名称'
						},
						stringLength : {
							min : 2,
							max : 50
						}
					}
				},
				//日期
				aae030 : {
					validators : {
						notEmpty : {
							message : '招聘起始日期不能为空'
						}
					},
					 date: {
                         format: 'YYYY/DD/MM'
                     }
				},
				//日期
				aae031 : {
					validators : {
						notEmpty : {
							message : '招聘终止日期不能为空'
						}
					}
					,
					 date: {
                        format: 'YYYY/DD/MM'
                    }
				},
				//联系人
				aae004 : {
					validators : {
						notEmpty : {
							message : '请填写招聘联系人'
						},
						stringLength : {
							min : 2,
							max : 10
						}
					}
				},
				//联系地址
				aae006 : {
					validators : {
						notEmpty : {
							message : '联系地址不能为空'
						}
						,
						stringLength : {
							min : 2,
							max : 50
						}
					}
				},
				//联系人手机号
				aae139 : {
					validators : {
						 regexp:{
	                    	  regexp:/((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/,
	                    	  message:'格式不正确'
	                      }
					}
				},
				//联系人身份证
				aac002: {
	                  validators: {
	                	  regexp:{
	                		  regexp:/^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/,
	                    	  message:'身份证格式不正确'
	                      }
	                      }
	            },
				//面试地点
				acb20c : {
					validators : {
						stringLength : {
							min : 0,
							max : 75
						}
					}
				},
				//乘车路线
				acb205 : {
					validators : {
						stringLength : {
							min : 0,
							max : 50
						}
					}
				},
				//面试详情说明
				acb205 : {
					validators : {
						stringLength : {
							min : 0,
							max : 100
						}
					}
				}
				,//单位简介
				acb205 : {
					validators : {
						stringLength : {
							min : 0,
							max : 1000
						}
					}
				}
			}
		}).on(
				'success.form.bv',
				function(e) {
					e.preventDefault();
					var $form = $(e.target);
					var bv = $form.data('bootstrapValidator');
					$.post($form.attr('action'), $form.serialize(), function(
							data) {
						console.info(data);
						var arry = data.message;
						var messages = arry.substring(0, 11);
						var aac001 = arry.substring(11);
						$("#acb200").val(data.jobId);
						$("#buuton_submit").removeAttr("disabled");
						bootbox.alert({
							size : 'small',
							width : "100px",
							message : messages,
							callback : function(rowIndex, rowData) {
								//TODO 发布招聘完成后执行操作
							}
						})

					}, 'json');

				});
	}
	function remind() {
		//${corpPublicPositionForm.acb200}
		var acb200 = $("#acb200").val();
		if(acb200){
			xfui.open_tabs("单位招聘信息维护",
					"${ctx}/business/jobfair/corpPosition/edit.xf?acb200="+acb200+"&acb210=${acb210}&aab001="+$("#aab001").val(),
					"岗位基本信息");
		}else{
		bootbox.alert('请先填写招聘基本信息');
		}
	}
	function refresh() {
		xfui.open_tabs("单位招聘信息维护",
				"${ctx}/business/jobfair/corpPosition/addrecruitment.xf", "单位招聘信息维护");
	}
	function workExpceSelect() {
		xfui.open_tabs(
						"个人基本信息维护",
						"${ctx}/business/person/personBaseInfo/selectWorkExpce.xf?aac001=${corpPublicPositionForm.acb200}",
						"个人基本信息");
	}
</script>
<body>
	<div class="main-container">
		<div class="container-fluid">
			<div class="mhySearch">
				<div class="mhyTitle">单位招聘基本信息</div>
				 		<div class="row mhyUnitSearch">
		   			<div class="col-sm-4"></div>
		   			<div class="col-sm-8">
		   			<form id="searchForm" class="mhySearchInput">
				   			<div class="col-sm-12 mhycorp">
				   				<label class="col-xs-4 col-sm-4">
				   					单位信息查询:
				   				</label>
				   				<div class="col-xs-6 col-sm-6 mhyUnitInput">
									<input class="form-control mhycorp" type="text" name="nameNumber" data-placement="bottom"  placeholder="请输入单位名称或工商登记执照号" />
									<div class="mhyCorpSearchValue">
										<table id="corpList" ></table>
									</div>
								</div>
								<div class="col-xs-2 col-sm-2 mhyBtn">
									<a class="btn btn-primary btn-border1 mhyBtnLeft" role="button" onclick="initTable()">
									<i class="icon-search"></i>
									查询
									</a>
								</div>
				   			</div>
		   				</form>
		   			</div>
		   		</div>
				<div class="mhyPersonTabs">
					<ul id="personTab">
						<li class="active">单位招聘基本信息</li>
						<li onclick="remind()" >岗位信息</li>
					</ul>
					<div class="mhyPersonInfo ">
						<form:form modelAttribute="corpPublicPositionForm" method="post"
							action="${ctx}/business/jobfair/corpPosition/saveCorpPosition.xf">
<!-- 							<div class="form-group"> -->
							<form:hidden path="acb200"></form:hidden>
							<form:hidden path="aab001"  ></form:hidden>
							<%-- 						   		<form:hidden path="expandId" ></form:hidden> --%>
							<%-- 						   		<form:hidden path="ccpr08" value="0"></form:hidden>	 --%>
							<%-- 						   		<form:hidden path="id" ></form:hidden> --%>
							<div class="mhySearchInput mhyInputDiv">
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError"><i
										style="color: red; margin-right: 5px;">*</i>单位名称:</label>
									<div class="col-xs-9 input-group col-sm-10">
										<form:input  class="form-control" readonly="true" type="text" path="aab004"></form:input>
									</div>
								</div>
								<div class="row">
									<label class="col-xs-3 input-group col-sm-2" for="inputError"><i
										style="color: red; margin-right: 5px;">*</i>发布名称:</label>
									<div class="col-xs-9 col-sm-10">
										<form:input class="form-control" type="text" path="bab004"></form:input>
									</div>
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError"><i
										style="color: red; margin-right: 5px;">*</i>招聘起始日期:</label>
									<div class="col-xs-9  col-sm-2" style="float: left">
									<div class="input-group" style="padding: 0 !important;">
										<form:input class="form-control date-picker dp mhydatepicker"
											path="aae030" type="text" readonly="true" placeholder="请选择日期"  title="系统默认当前日期"/>
										<span class="input-group-addon"> <i
											class="icon-calendar bigger-110"></i>
										</span></div>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError"><i
										style="color: red; margin-right: 5px;">*</i>招聘终止日期:</label>
									<div class="col-xs-9 col-sm-2" style="float: left">
									<div class="input-group" style="padding: 0 !important;">
										<form:input readonly="true" class="form-control  date-picker dp mhydatepicker"
											path="aae031" type="text" placeholder="请选择日期"  />
										<span class="input-group-addon"> <i
											class="icon-calendar bigger-110"></i>
										</span></div>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError"><i
										style="color: red; margin-right: 5px;">*</i>招聘联系人:</label>
									<div class="col-xs-9 col-sm-2">
										<form:input class="form-control"   type="text" path="aae004"></form:input>
									</div>
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError"><i
										style="color: red; margin-right: 5px;">*</i>联系电话:</label>
									<div class="col-xs-9 col-sm-2">
										<form:input class="form-control" type="text" path="aae005"></form:input>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError"><i
										style="color: red; margin-right: 5px;">*</i>联系地址:</label>
									<div class="col-xs-9 col-sm-6">
										<form:input class="form-control" type="text" path="aae006"></form:input>
									</div>
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError">联系人手机号:</label>
									<div class="col-xs-9 col-sm-2">
										<form:input class="form-control" type="text" path="aae139"></form:input>
									</div>
								   <label class="col-xs-3 col-sm-2" for="inputError">面试地点:</label>
									<div class="col-xs-9 col-sm-6">
										<form:input class="form-control" type="text" path="acb20c"></form:input>
									</div>
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError">联系人身份证:</label>
									<div class="col-xs-9 col-sm-2">
										<form:input class="form-control" type="text" path="aac002"></form:input>
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">乘车路线:</label>
									<div class="col-xs-9 col-sm-6">
										<form:input class="form-control" type="text" path="acb205"></form:input>
									</div>
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError">面试详细说明:</label>
										<div class="col-xs-9 col-sm-10">
											<form:textarea class="form-control"  type="text" path="acb20f"></form:textarea>
										</div>
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError">单位简介:</label>
										<div class="col-xs-9 col-sm-10">
											<form:textarea   type="text" path="acb206" ></form:textarea>
										</div>
								</div>
									<div class="bottomBtn">
						   					<div class="h50">&nbsp;</div>
						   					<div class="floatBtn">
							   					<a class="btn btn-primary mhyBtnLeft" role="button" onclick="refresh()">
							   					<i class="icon-plus"></i>
							   					新增
							   					</a>
							   					<a class="btn btn-info mhyBtnLeft" role="button" onclick="refresh()">
							   					<i class="icon-repeat"></i>
							   					重置
							   					</a>
							   					<button class="btn btn-primary mhyBtn" id="buuton_submit" type="submit">
							   					<i class="icon-save"></i>
							   					保存	
							   					</button>
						   					</div>
						   				</div>
							</div>
<!-- 							</div> -->
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${!empty corpPublicPositionForm.acb200}">
		<script>
			$(function() {
				$("#personTab li").click(
						function() {
							var _this = this;
							$("#personTab li").removeClass("active")
									&& $(_this).addClass("active");
							;

						});

			})
		</script>
	</c:if>

	<script type="text/javascript">
		jQuery(function($) {
// 			// 日期选择
// 			$(".mhydatepicker").datetimepicker({
// 				todayBtn : true,
// 				format : "yyyy-mm-dd",
// 				startView : 2,
// 				minView : 2,
// 				language : 'cn',
// 				maxView : "decade",
// 				viewSelect : 2,
// 				autocomplete : true,
// 				autoclose : true
// 			});
			$("[data-toggle='popover']").popover();
		});
	</script>
</body>

</html>
