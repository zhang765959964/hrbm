<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>单位档案批量调出</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript">
		$(function (){
			 $("#corpArchiveReceive").load("${ctx}/business/personagency/corp/archiveLend/resultList.xf");
			 var columns= [
							{field:'aab004',title:'单位名称',width:100,align:'center'},
							{field:'uaNo',title:'代理单位编码',width:100,align:'center'}
		 	        	];
			 $("#aab004").selectcommon({
				 url: '${ctx}/sys/component/uums/selCorp.xf',
				 columns: columns,
				 callBack:function(data){
					 if(!data){
						 bootbox.alert("未查到该企业！");
					 }else{
						 $("#corpArchiveReceive").load("${ctx}/business/personagency/corp/archiveLend/resultList.xf?aab001="+data.aab001);
					 }
				}
			 });
		});
	</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 pd0 tar">
				<div class="col-xs-6 col-sm-6"></div>
				<div class="col-xs-6 col-sm-6">
					<label class="col-xs-3 col-sm-2" for="inputError">查询:</label>
					<div class="col-xs-6 col-sm-7 pr">
						<input class="form-control" type="text" name="aab001" id="aab004" data-placement="bottom"  placeholder="根据单位名称/协议编号查询" title="根据单位名称/协议编号查询"/>
					</div>
				</div>
			</div>
		</div>
		<div id="corpArchiveReceive"></div>	
	</div>
</body>
</html>