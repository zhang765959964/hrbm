<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 单位补贴申报</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
<script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/ueditor.all.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript">
	 $(function(){
		 
		  $("#perBase").load("${ctx}/business/personagency/print/printProveTemplate/add.xf");
			var columns= [
		                   {field:'fdModelName',title:'模版名称',width:80,align:'center'}
	      	        	];
			 $("#corpId").selectcommon({
				 url:CTX+'/business/personagency/print/printProveTemplate/allListJson.xf?fkModelType=0&page=1&rows=10',
				 columns: columns,
				 callBack:function(data){
					 if(data){
						 $("#perBase").load("${ctx}/business/personagency/print/printProveTemplate/edit.xf?pkId="+data.pkId);
					 }else{
						 bootbox.alert("未找到模版")
					 }
					 
					 
// 					 $("#myEditor").val("23333333333");
// 					 UE.getEditor('myEditor').setContent('23333333333');
// 					 $("#fdModelName").val("dsdd");
					 

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
				<div class="col-xs-6 col-sm-6"></div>
				<div class="col-xs-6 col-sm-6">
					<label class="col-xs-3 col-sm-2" for="inputError">查询:</label>
					<div class="col-xs-6 col-sm-7 pr">
						<input class="form-control"  name="corpId" id="corpId" placeholder="请输入证明模版名称" type="text"/>
						<!-- 多条结果 -->
					</div>
				
				</div>
			</div>
			
		</div>
		<div id="perBase"></div>
	</div>	
</body>
</html>
