<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>档案借阅返还登记查询页面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
    <script type="text/javascript" src="${ctx}/js/ui/xf.idcard.js?v=201609191639"></script>
	<script type="text/javascript" src="${ctx}/js/ui/xf.seccard.js?v=201609191639"></script>
<script type="text/javascript">
	$(function() {
		 var columns= [
						{field:'AAC002',title:'身份证号',width:100,align:'center'},
	                    {field:'AAC003',title:'姓名',width:100,align:'center'},
	                    {field:'ARCHIVECODE',title:'档案编号',width:100,align:'center'}
      	        	];
		 $("#personCard").selectcommon({
			 url:'${ctx}/business/personagency/archive/archives/searchArchives.xf?dataSources=1',
			 columns: columns,
			 callBack:function(data){
				 if(!data){
					 bootbox.alert("没有找到可操作的数据");
				 }else{
					 if(data.ARCHIVESTATUS==2){
						 bootbox.alert("当前档案已经调出！不能操作！");
					 }else{
						 $("#archiveConfirmCheckoutList").load("${ctx}/business/personagency/archive/archiveCheckout/confirmResultList.xf?personId="+ data.PERSONID);
					 }
				 }
			}
		 })
		 
		 $("#idcard").idcard({callBack:function(personId,data){
			 	var aac002 = data.aac002;
			    $("#personCard").val(aac002);
			    $(".singleSearchBtn").click();
		 }})
		 $("#seccard").seccard({callBack:function(personId,data){
			var aac002 = data.aac002;
		    $("#personCard").val(aac002);
		    $(".singleSearchBtn").click();
	      }})
		
		$("#archiveConfirmCheckoutList").load("${ctx}/business/personagency/archive/archiveCheckout/confirmResultList.xf");
	})
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 pd0 tar">
				<div class="col-xs-6 col-sm-6">
					<a href="javascript:void(0)" role="button" class="btn btn-info" data-toggle="modal" id="seccard">社保卡已配置</a>
					<a href="javascript:void(0)" role="button" class="btn" data-toggle="modal" id="idcard">身份证未配置</a>
				</div>
				<div class="col-xs-6 col-sm-6">
					<label class="col-xs-3 col-sm-2" for="inputError">查询:</label>
					<div class="col-xs-6 col-sm-7 pr">
						<input class="form-control" placeholder="请输入身份证号或档案编号" type="text" name="personCard" id="personCard"/>
					</div>
				</div>
			</div>
		</div>
		<div id="archiveConfirmCheckoutList"></div>
	</div>
</body>
</html>