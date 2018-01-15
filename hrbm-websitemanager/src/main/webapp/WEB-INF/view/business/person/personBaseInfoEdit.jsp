<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<title>编辑 个人基本信息表</title>
 	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
    <%@include file="/commons/include/bootstrapInc.jsp" %>
</head>

<body>
	<div class="container-fluid">
			<div class="row">
				 <div class="col-xs-12 pd0 tar" >
					<div class="col-xs-6 col-sm-6">
						<a href="javascript:void(0)" role="button" class="btn btn-info" data-toggle="modal" id="seccard">社保卡已配置</a>
						<a href="javascript:void(0)" role="button" class="btn" data-toggle="modal" id="idcard">身份证未配置</a>
					</div>
					<div class="col-xs-6 col-sm-6">
						<label class="col-xs-3 col-sm-2" for="inputError">查询:</label>
						<div class="col-xs-6 col-sm-7 pr">
							<input class="form-control"  name="personSearch" id="personSearch" placeholder="请输入身份证号 姓名" type="text"/>
							<!-- 多条结果 -->
						</div>				
					</div>
				</div>
			</div>
		<div class="tabable tabable1 row">
			<ul class="nav nav-tabs padding-12 tab-color-blue background-blue">
				<li class="active"><a data-toggle="tab" href="#perBase">个人基本信息</a></li>
				<li><a data-toggle="tab" href="#perEdu">教育背景</a></li>
				<li><a data-toggle="tab" href="#perExp">工作简历</a></li>
			</ul>
			<div class="tab-content">
			    <div id="perBase" class="tab-pane in active">
						<c:import url="/WEB-INF/view/business/person/include/personBaseInfoEdit_include.jsp">
							<c:param name="formName" value="personBaseInfoForm"/>
						</c:import>	
				</div>
				<div id="perEdu" class="tab-pane in active">
					<c:import url="/WEB-INF/view/business/person/include/personEducation_include.jsp">
							<c:param name="cczy06" value="${personBaseInfoForm.cczy06}"/>
							<c:param name="aac001" value="${personBaseInfoForm.aac001}"/>				
					</c:import>	
				</div>
				<div id="perExp" class="tab-pane in active">
					<c:import url="/WEB-INF/view/business/person/include/personWorkExpceList_include.jsp">
							<c:param name="cczy06" value="${personBaseInfoForm.cczy06}"/>
							<c:param name="aac001" value="${personBaseInfoForm.aac001}"/>
					 </c:import>	
				</div>
		   </div>

				
	 </div>	
</div>

<div class="h50">&nbsp;</div>
<script type="text/javascript">
  jQuery(function($) {
	  $("#personSearch").selectuser({callBack:function(personId){
			if(personId){
				window.location.href = "${ctx}/business/person/personBaseInfo/personCard.xf?cczy06=${personBaseInfoForm.cczy06}&aac001="+personId;
			}else{
				bootbox.alert('未查到记录');
			}
		  }})
      $("[data-toggle='popover']").popover();
	  $('a[data-toggle="tab"]').on('show.bs.tab', function (e) {
		  var aac001=$("#aac001").val();
		  if(!aac001){
			  bootbox.alert("请先保存人员基本信息");
			  return false;
		  }
		  //alert(2)
		  //e.target // 激活的标签页
		  //e.relatedTarget // 前一个激活的标签页
		  
		})
    });
</script>  	
</body>

</html>

