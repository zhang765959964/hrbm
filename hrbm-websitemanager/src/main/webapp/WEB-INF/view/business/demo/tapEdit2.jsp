<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="h100p">
<head>
	<title>编辑基本信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   	<%@include file="/commons/include/commonInc.jsp" %>
<%--    	<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" /> --%>
<%--    	<link rel="stylesheet" href="${ctx}/assets/css/bootstrap-datetimepicker.min.css" /> --%>
<%-- 	<link rel="stylesheet" href="${ctx}/assets/css/daterangepicker.css" /> --%>
<%-- 	<link rel="stylesheet" media="screen" href="${ctx}/assets/css/ui.jqgrid-bootstrap.css" /> --%>

<%--    	<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.min.js"></script> --%>
<%-- 	<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script> --%>
<%-- 	<script src="${ctx}/assets/js/jqGrid/i18n/grid.locale-en.js"></script> --%>
<%--     <script src="${ctx}/assets/js/jqGrid/jquery.jqGrid.min.js"></script> --%>
    <style>
    	ul,li{list-style: none; margin:0; padding: 0;}
    </style>
    <script type="text/javascript">
	//全选 obj全选内容对象
	function selectAll(obj){
		var childrenList = $(obj).find("input[type='checkbox']");
		childrenList.each(function(){
			$(this).prop("checked","true");
		})
	}
	//取消全选
	function cancleSelectAll(obj){
		var childrenList = $(obj).find("input[type='checkbox']");
		childrenList.each(function(){
			$(this).removeProp("checked");
		})
	}
    </script>
</head>
<body class="h100p">
	<div class="container-fluid h100p">
		<div class="row h100p">
			<div class="col-xs-12 col-sm-3 colLeft">
				<div class="treeWrap">
					<div class="moduleTit">个人信息</div>
					<ul class="catTree">
						<li class="selected"><a href="#">个人基本信息</a></li>
						<li><a href="#">家庭关系</a></li>
						<li><a href="#">教育背景</a></li>
						<li><a href="#">工作经历</a></li>
						<li><a href="#">工作经历</a></li>
						<li><a href="#">工作经历</a></li>
						<li><a href="#">工作经历</a></li>
						<li><a href="#">其他</a></li>
					</ul>
				</div>
				<ul class="selWrap selWrap1">
					<div class="moduleTit">信息详情</div>
					<li class="selList">
						<a href="#"><img src="/websitem/styles/default/images/idcard.jpg"/></a>
						<input type="checkbox" name="">
						<a href="javascript:void(0)">删除</a>
					</li>
					<li class="selList">
						<a href="#"><img src="/websitem/styles/default/images/idcard.jpg"/></a>
						<input type="checkbox" name="">
						<a href="javascript:void(0)">删除</a>
					</li>
					<li class="selList">
						<a href="#"><img src="/websitem/styles/default/images/idcard.jpg"/></a>
						<input type="checkbox" name="">
						<a href="javascript:void(0)">删除</a>
					</li>
					<li class="selList">
						<a href="#"><img src="/websitem/styles/default/images/idcard.jpg"/></a>
						<input type="checkbox" name="">
						<a href="javascript:void(0)">删除</a>
					</li>
					<li class="selList">
						<a href="#"><img src="/websitem/styles/default/images/idcard.jpg"/></a>
						<input type="checkbox" name="">
						<a href="javascript:void(0)">删除</a>
					</li>
					<li class="selList">
						<a href="#"><img src="/websitem/styles/default/images/idcard.jpg"/></a>
						<input type="checkbox" name="">
						<a href="javascript:void(0)">删除</a>
					</li>
					<li class="selList">
						<a href="#"><img src="/websitem/styles/default/images/idcard.jpg"/></a>
						<input type="checkbox" name="">
						<a href="javascript:void(0)">删除</a>
					</li>
					<li class="selList">
						<a href="#"><img src="/websitem/styles/default/images/idcard.jpg"/></a>
						<input type="checkbox" name="">
						<a href="javascript:void(0)">删除</a>
					</li>
					<li class="selList">
						<a href="#"><img src="/websitem/styles/default/images/idcard.jpg"/></a>
						<input type="checkbox" name="">
						<a href="javascript:void(0)">删除</a>
					</li>
					<li class="selList">
						<a href="#"><img src="/websitem/styles/default/images/idcard.jpg"/></a>
						<input type="checkbox" name="">
						<a href="javascript:void(0)">删除</a>
					</li>
				</ul>
				<nav>
                    <ul class="showpage">
                        <li class="noPage"><a href="#"><i class="icon-step-backward"></i></a></li>
                        <li class="noPage"><a href="#"><i class="icon-backward"></i></a></li>
                        <li class="nowpage"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li class="omitpage">...</li>
                        <li><a href="#">6</a></li>
                        <li><a href="#">7</a></li>
                        <li><a href="#">8</a></li>
                        <li><a href="#"><i class="icon-forward"></i></a></li>
                        <li><a href="#"><i class="icon-step-forward"></i></a></li>
                    </ul>
                </nav>
				<div class="btnWrap">
					<a href="javascript:void(0)" role="button" class="btn btn-danger btn-border1" ><i class="icon-trash"></i>批量删除</a>
					<a href="javascript:selectAll($('.selWrap1'))" class="btn btn-primary btn-border1 selectAll" ><i class="icon-ok"></i>全部选择</a>
					<a href="javascript:cancleSelectAll($('.selWrap'))" class="btn btn-info btn-border1 cancleSelAll" ><i class="icon-remove"></i>取消全选</a>
				</div>
			</div>
			<div class="col-xs-12 col-sm-6 colCenter">
				<div class="moduleWrapNobg">
					<div class="moduleTit">预览</div>
					<div class="previewBasic">
						<div class="row mg0">
							<label class="col-sm-12p5" for="inputError">身份证号：</label>
							<div class="col-sm-20p5">
								<input class="form-control" value="331254789654" placeholder="331254789654" readonly="readonly"/>
							</div>
							<label class="col-sm-12p5" for="inputError">姓名：</label>
							<div class="col-sm-20p5">
								<input class="form-control" value="张凉" placeholder="张凉" readonly="readonly"/>
							</div>
							<label class="col-sm-12p5" for="inputError">出生日期：</label>
							<div class="col-sm-20p5">
                              	<input class="form-control" value="18960504" placeholder="18960504" readonly="readonly"/>
                            </div>
                        </div>
                        <div class="row mg0">
							<label class="col-sm-12p5" for="inputError">性别：</label>
							<div class="col-sm-20p5">
								<input class="form-control" name="sex" value="男" placeholder="男" readonly="readonly"/>
							</div>
							<label class="col-sm-12p5" for="inputError">档案姓名：</label>
							<div class="col-sm-20p5">
								<input class="form-control" name="" value="张凉" placeholder="张凉" readonly="readonly"/>
							</div>
						</div>
					</div>
					<div class="previewImg">
						<div class="previewBox">
							<img src="" alt="扫描预览">
						</div>
					</div>
					<div class="previewBtn">
						<a href="javascript:void(0)" role="button" class="btn btn-primary btn-border1" ><i class="icon-camera"></i>拍照</a>
						<a href="javascript:void(0)" class="btn btn-success btn-border1" ><i class="icon-refresh"></i>旋转</a>
						<a class="btn btn-info" href="javascript:void(0)" role="button" ><i class="icon-retweet"></i>切换摄像头</a>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-3 colLast">
				<div class="moduleTit">已采集信息</div>
				<ul class="selWrap selWrap2">
					<div class="moduleTit">信息详情</div>
					<li class="selList selList">
						<a href="#"><img src="/websitem/styles/default/images/idcard.jpg"/></a>
						<input type="checkbox" name="">
						<a href="javascript:void(0)">删除</a>
					</li>
					<li class="selList">
						<a href="#"><img src="/websitem/styles/default/images/idcard.jpg"/></a>
						<input type="checkbox" name="">
						<a href="javascript:void(0)">删除</a>
					</li>
					<li class="selList">
						<a href="#"><img src="/websitem/styles/default/images/idcard.jpg"/></a>
						<input type="checkbox" name="">
						<a href="javascript:void(0)">删除</a>
					</li>
					<li class="selList">
						<a href="#"><img src="/websitem/styles/default/images/idcard.jpg"/></a>
						<input type="checkbox" name="">
						<a href="javascript:void(0)">删除</a>
					</li>
					<li class="selList">
						<a href="#"><img src="/websitem/styles/default/images/idcard.jpg"/></a>
						<input type="checkbox" name="">
						<a href="javascript:void(0)">删除</a>
					</li>
					<li class="selList">
						<a href="#"><img src="/websitem/styles/default/images/idcard.jpg"/></a>
						<input type="checkbox" name="">
						<a href="javascript:void(0)">删除</a>
					</li>
					<li class="selList">
						<a href="#"><img src="/websitem/styles/default/images/idcard.jpg"/></a>
						<input type="checkbox" name="">
						<a href="javascript:void(0)">删除</a>
					</li>
					<li class="selList">
						<a href="#"><img src="/websitem/styles/default/images/idcard.jpg"/></a>
						<input type="checkbox" name="">
						<a href="javascript:void(0)">删除</a>
					</li>
					<li class="selList">
						<a href="#"><img src="/websitem/styles/default/images/idcard.jpg"/></a>
						<input type="checkbox" name="">
						<a href="javascript:void(0)">删除</a>
					</li>
					<li class="selList">
						<a href="#"><img src="/websitem/styles/default/images/idcard.jpg"/></a>
						<input type="checkbox" name="">
						<a href="javascript:void(0)">删除</a>
					</li>
				</ul>
				<nav>
                    <ul class="showpage">
                        <li class="noPage"><a href="#"><i class="icon-step-backward"></i></a></li>
                        <li class="noPage"><a href="#"><i class="icon-backward"></i></a></li>
                        <li class="nowpage"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li class="omitpage">...</li>
                        <li><a href="#">6</a></li>
                        <li><a href="#">7</a></li>
                        <li><a href="#">8</a></li>
                        <li><a href="#"><i class="icon-forward"></i></a></li>
                        <li><a href="#"><i class="icon-step-forward"></i></a></li>
                    </ul>
                </nav>
				<div class="btnWrap">
					<a href="javascript:void(0)" role="button" class="btn btn-purple btn-border1" ><i class="icon-check"></i>批量采集</a>
					<a href="javascript:selectAll($('.selWrap2'))" class="btn btn-primary btn-border1" ><i class="icon-ok"></i>全部选择</a>
					<a href="javascript:cancleSelectAll($('.selWrap2'))" class="btn btn-info btn-border1" ><i class="icon-remove"></i>取消全选</a>
				</div>
			</div>
		</div><!-- row end -->

	</div>
	<script type="text/javascript">
	jQuery(function($) {

	});
	</script>
</body>
</html>
