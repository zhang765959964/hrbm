<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 工具箱模板栏目表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <%@include file="/commons/include/commonInc.jsp" %>
   <link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
	<script type="text/javascript">

	  function closeItem(){
		  
		  xfui.closeDialog();
	  }
	  $(function(){
		  $('#hRToolModelColForm').bootstrapValidator({
		         message: 'This value is not valid',
		         feedbackIcons: {
		             valid: 'glyphicon glyphicon-ok',
		             invalid: 'glyphicon glyphicon-remove',
		             validating: 'glyphicon glyphicon-refresh'
		         },
		         fields: {
		      	   //发布名称
		             name: {
		                 validators: {
		                     notEmpty: {
		                     },
		                     stringLength: {
		                         min: 2,
		                         max: 50
		                     }
		                 }
		             }
		         }
		     }).on('success.form.bv', function(e) {
		              e.preventDefault();
		              var $form = $(e.target);
		              var bv = $form.data('bootstrapValidator');
		              $.post($form.attr('action'), $form.serialize(), function(data) {
		                  $(".btn-submit").removeAttr("disabled");
		                  bootbox.alert({ 
		                      size: 'small',
		                      width:"100px",
		                      message: data.message, 
		                      callback: function(){ 
		                      	var parentIframe=xfui.getParentIframe();
		                      	if(parentIframe){
		        		    		parentIframe.refreshTree();
		        		    	}
		                      	closeItem(); 
		                      	
		                      }
		                  })
		                  
		              }, 'json');

		          });
			 $("#name").pinyinAleph(function(data){
				 $("#code").val(data);
			 });
		 })
	</script>
</head>
<body>
<form:form modelAttribute="hRToolModelColForm" method="post" action="${ctx}/business/hrtool/hRToolModelCol/save.xf">
				 <form:hidden path="id" ></form:hidden>
				 <form:hidden path="parentColId" ></form:hidden>
     <div class="modal-body overflow-visible reportWrap">

				<div class="row" style="padding:0 30px;">
					<div class="col-xs-12 col-sm-6" >
						<label class="col-xs-2" for="inputError">上级栏目：</label>
						<div class="col-xs-8 col-sm-6">
							<form:input  class="form-control" type="text"  path="parentColName"  readonly="true" ></form:input>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6" >
						<label class="col-xs-2" for="inputError">名称：</label>
						<div class="col-xs-8 col-sm-6">
							<form:input  class="form-control" type="text"  path="name"  data-options="required:true"></form:input>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6" >
						<label class="col-xs-2" for="inputError">代码：</label>
						<div class="col-xs-8 col-sm-6">
							<form:input  class="form-control" type="text"  path="code"  data-options="required:true"></form:input>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6" >
						<label class="col-xs-2" for="inputError">排序：</label>
						<div class="col-xs-8 col-sm-6">
							<form:input  class="form-control" type="text"  path="sortNum"  ></form:input>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6" >
						<label class="col-xs-2" for="inputError">栏目描述：</label>
						<div class="col-xs-8 col-sm-6">
							<form:textarea  class="form-control" type="text"  path="description" ></form:textarea>
						</div>
					</div>
				</div>
		 
	</div>
	<div class="modal-footer">
		<button class="btn btn-sm" data-dismiss="modal" onclick="closeItem()">
			<i class="icon-remove"></i>
			关闭
		</button>

		<button class="btn btn-sm btn-primary" type="submit">
			<i class="icon-ok"></i>
			保存
		</button>
	</div>
	</form:form>
</body>
<!-- <body> -->
<!-- 	<div id="dg_toolbar" style="padding: 5px 5px;"> -->
<!-- 		<a href="javascript:void(0)" class="easyui-linkbutton tb_add" onclick="submit()" data-options="iconCls:'icon-save'">保存</a> -->
<!-- 		<a href="javascript:void(0)" class="easyui-linkbutton tb_destory" onclick="closeItem()" iconCls="icon-clear">关闭</a> -->
<!-- 	</div> -->
<!--    <div class="div-line"></div> -->
<%--    	  <form:form modelAttribute="hRToolModelColForm" method="post" > --%>

<!-- 				<table class="formTable"> -->
<%-- 				 <form:hidden path="id" ></form:hidden> --%>
<%-- 				 <form:hidden path="parentColId" ></form:hidden> --%>
<!-- 					<tr> -->
<!-- 					 <td class="formHead" colspan="2">工具箱模板栏目表基本信息</td> -->
<!-- 					</tr> -->
<!-- 					    <tr> -->
<!-- 							<td class="formTitle">上级栏目: </td> -->
<%-- 							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="parentColName" data-options="readonly:true" ></form:input> --%>
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td class="formTitle">名称: </td> -->
<%-- 							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="name"  data-options="required:true"></form:input> --%>
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td class="formTitle">代码: </td> -->
<%-- 							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="code"  data-options="required:false"></form:input> --%>
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td class="formTitle">排序: </td> -->
<%-- 							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="sortNum"  data-options="required:false"></form:input> --%>
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td class="formTitle">描述: </td> -->
<%-- 							<td class="formInput"><form:textarea  class="easyui-validatebox" type="text"  path="description" style="width:200px;height:100px" data-options="required:false"></form:textarea> --%>
<!-- 						</tr> -->
<!-- 				</table> -->
<%--         </form:form> --%>
<!-- </body> -->
</html>
