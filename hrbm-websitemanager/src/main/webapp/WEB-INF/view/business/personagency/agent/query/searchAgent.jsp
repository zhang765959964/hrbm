<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title></title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@include file="/commons/include/commonInc.jsp" %>

	<script type="text/javascript">
		$(function() {
			 $("#adminSel").load("${ctx}/business/personagency/receive/receive/resultList2.xf");
			 var columns= [
							{field:'AAC002',title:'身份证号',width:100,align:'center'},
							{field:'AAC003',title:'姓名',width:100,align:'center'},
		                    {field:'ARCHIVECODE',title:'档案编号',width:100,align:'center'}
	      	        	];
				 $("#personId").selectcommon({
					 url:CTX+'/business/personagency/archive/archives/searchArchives.xf?dataSources=1',
					 columns: columns,
					 callBack:function(data){
						 if(data.PERSONID){
							 $("#adminSel").load("${ctx}/business/personagency/receive/receive/resultList2.xf?personId="+ data.PERSONID); 
						 }
					}
				 })
		})
		
		
	</script>
</head>
<body>		
	<div class="container-fluid">
		<div class="row">
			<!-- 单条查询 -->
			<div class="col-xs-12 pd0 tar">
				<div class="col-xs-6 col-sm-6">
				</div>
				<div class="col-xs-6 col-sm-6">
					<label class="col-xs-3 col-sm-2" for="inputError">查询:</label>
					<div class="col-xs-6 col-sm-7 pr">
						<input class="form-control"  name="personId" id="personId" placeholder="请输入身份证号或档案编号查询" type="text"/>
					</div>
				</div>
			</div>
			<div id="adminSel"></div>
		</div>
			
	
		
	</div>	
</body>
</html>
