<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<title>编辑 个人基本信息表</title>
 	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
    <%@include file="/commons/include/bootstrapInc.jsp" %>
    <script src="${ctx}/js/lib/bootstrap-select/bootstrap-select.js"></script>
	<link type="text/css" rel="stylesheet"  href="${ctx}/js/lib/bootstrap-select/bootstrap-select.css"	/>
	<script type="text/javascript" src="${ctx}/js/ui/xf.seljob.js"></script>
</head>
<script type="text/javascript">
	var sign='${sign}';
	var cczy06='${cczy06}';
	 $(function(){
		 initFormSubimt();
		 disableButton();
	 });
		function checkAca111() {
			var res = false;
			var aac001 = '${aac001}';
			var	acc200 = $("#acc200").val();
			var	bca111 = $("#bca111").val();
			var	bcaa11 = $("#bcaa11").val();
			var	bcab11 = $("#bcab11").val();
			if (!aac001) {
				aac001 = $("#aac001").val();
			}
			$.ajax({
				contentType : "application/x-www-form-urlencoded; charset=utf-8",
				url : '${ctx}/business/person/personJobRegist/isExist.xf',
				data : {
					'aac001' : aac001,
					'acc200' : acc200,
					'bca111' : bca111,
					'bcaa11' : bcaa11,
					'bcab11' : bcab11
					
				},
				async : false,
				type : "post",
				dataType : 'json',
				success : function(data) {
					res = (data.result == '0');
				},
				error : function() {
					res = false
				}
			});
			//岗位是否已存在
			if (!res) {
				$("small[data-bv-validator$='notEmpty'][data-bv-for$='bca112']")
						.html("当前职位信息已存在");
				$("small[data-bv-validator$='notEmpty'][data-bv-for$='bca112']")
						.show();
				$("#button_submit").attr("disabled", true);
				return false;
			} else {
				return true;
			}
		}
		function checkAcaa11() {
			var res = false;
			var aac001 = '${aac001}';
			var	acc200 = $("#acc200").val();
			var	bca111 = $("#bca111").val();
			var	bcaa11 = $("#bcaa11").val();
			var	bcab11 = $("#bcab11").val();
			if (!aac001) {
				aac001 = $("#aac001").val();
			}
			$.ajax({
				contentType : "application/x-www-form-urlencoded; charset=utf-8",
				url : '${ctx}/business/person/personJobRegist/isExist.xf',
				data : {
					'aac001' : aac001,
					'acc200' : acc200,
					'bca111' : bca111,
					'bcaa11' : bcaa11,
					'bcab11' : bcab11
					
				},
				async : false,
				type : "post",
				dataType : 'json',
				success : function(data) {
					res = (data.result == '0');
				},
				error : function() {
					res = false
				}
			});
			//岗位是否已存在
			if (!res) {
				$("small[data-bv-validator$='stringLength'][data-bv-for$='bcaa12']")
						.html("当前职位信息已存在");
				$("small[data-bv-validator$='stringLength'][data-bv-for$='bcaa12']")
						.show();
				$("#button_submit").attr("disabled", true);
				return false;
			} else {
				return true;
			}
		}
		function checkAcab11() {
			var res = false;
			var aac001 = '${aac001}';
			var	acc200 = $("#acc200").val();
			var	bca111 = $("#bca111").val();
			var	bcaa11 = $("#bcaa11").val();
			var	bcab11 = $("#bcab11").val();
			if (!aac001) {
				aac001 = $("#aac001").val();
			}
			$.ajax({
				contentType : "application/x-www-form-urlencoded; charset=utf-8",
				url : '${ctx}/business/person/personJobRegist/isExist.xf',
				data : {
					'aac001' : aac001,
					'acc200' : acc200,
					'bca111' : bca111,
					'bcaa11' : bcaa11,
					'bcab11' : bcab11
					
				},
				async : false,
				type : "post",
				dataType : 'json',
				success : function(data) {
					res = (data.result == '0');
				},
				error : function() {
					res = false
				}
			});
			//岗位是否已存在
			if (!res) {
				$("small[data-bv-validator$='stringLength'][data-bv-for$='bcab12']")
						.html("当前职位信息已存在");
				$("small[data-bv-validator$='stringLength'][data-bv-for$='bcab12']")
						.show();
				$("#button_submit").attr("disabled", true);
				return false;
			} else {
				return true;
			}
		}
		 function disableButton(){
			 var aac001=$("#aac001").val();
			 if(aac001){
				
				 if(!hasEditPermi(aac001,1)){
					 $("button .btn-primary").attr("disabled","disabled");
					 $("button .btn-primary").attr("title","无编辑权限");
				 }
			 }

		 }	
     function initFormSubimt(){
         $('#personJobRegistForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   //信息发布方式
            	   acc20q: {
            		   validators: { notEmpty : {message : '请选择信息发布方式'}}
                   },
                   //求职意向1
                   bca112: {
            		   validators: { notEmpty : {message : '求职意向1不能为空'}}
                   },
                   //求职意向2
                   bcaa12: {
            		   validators: { stringLength : {min : 0,max : 40}}
                   },
                   //求职意向2
                   bcab12: {
            		   validators: { stringLength : {min : 0,max : 40}}
                   },
                   
                   //求职区域1
                   bcb202: {
            		   validators: { stringLength : {min : 0,max : 25}}
                   },
                   //求职区域2
                   bcb203: {
            		   validators: { stringLength : {min : 0,max : 25}}
                   },
                   //求职区域3
                   bcb204: {
            		   validators: { stringLength : {min : 0,max : 25}}
                   },
                   
            	   acc201: {
            		   validators: { notEmpty : {message : '请选择登记类别'}}
                   },
					//人员类别
            	   acc20t: {
            		   validators: { notEmpty : {message : '请选择人员类别'}}
                   } 
               }
           }).on('success.form.bv', function(e) {
               e.preventDefault();
               var $form = $(e.target);
               var bv = $form.data('bootstrapValidator');
             	//设置福利
   				$("#acc214").val(getSelectValues("acc214_select"));
               $.post($form.attr('action'), $form.serialize(), function(data) {
               	console.info(data);
               	var arry = data.message;
                var messages=arry.substring(0,12);
                var aac001 = arry.substring(12);
                   $(".btn-submit").removeAttr("disabled");
                   bootbox.alert({ 
                       size: 'small',
                       width:"100px",
                       message:messages, 
                       callback: function(rowIndex, rowData){
                    	   if(aac001==1){
                    		   return;
                    	   }else{
                    	   		window.location.href = "${ctx}/business/person/personJobRegist/edit.xf?sign=${sign}&aac001="+aac001;
                    	   }
                       }
                   })
                   
               }, 'json');
               
           });
       }	 
     
     
     function refresh(){
     		var aac001='${aac001}';
     		var acc201=$("#acc201").val();
     		var acc20t=$("#acc20t").val();
     		var bca111=$("#bca111").val();
     		if(bca111==""&&acc201==""&&acc20t==""){
     			bootbox.alert("当前已是新增页面！");
     		}else{
     			$.ajax({ url: '${ctx}/business/person/personJobRegist/inspect.xf',
 		    		data:{aac001:aac001},
 		    		dataType:'json',
 		    		success: function(data){
 		    			if(data.message){
 		    				bootbox.confirm({message:'本人存在有效求职信息，是否修改？',callback:function(r){
 		    					if (r){
 	 		   	     		    	$.ajax({ url: '${ctx}/business/person/personJobRegist/edit.xf',
 	 		   	     		    		data:{aac001:aac001,sign:sign},
 	 		   	     		    		dataType:'json',
 	 		   	     		    		success: function(data){
 	 		   	     		    			if(data.message){
 	 		   	     		    				bootbox.alert(data.message);
 	 		   	     		    			}else{
 	 		   	     		    				bootbox.alert("未知错误");
 	 		   	     		    			}
 	 		   	     		             }
 	 		   	     		    	});
 	 		   	     		    }
 	 		   	     	}});
 		    			}else{
 		    				bootbox.confirm({message:'您确定要清空当前所填信息？',callback:function(r){
 	 		   	     		    if (r){
	 		   	     		  		$(".jrForm")[0].reset();
 	 		   	     		    }
 	 		   	     		   }});
 		    			}
 		             }
 		    	});
     		}
     	  
     }
 	function getSelectValues(objId) {
		var selectValueStr = '';
		$("#" + objId + " option:selected")
				.each(
						function() {
							selectValueStr = selectValueStr ? (selectValueStr
									+ "," + $(this).val()) : $(this).val();
						});
		return selectValueStr;
	}
     //返回基本信息页面
     function personSelect(){
    	 if(sign=="1"){
    		 window.location.href = "${ctx}/business/laborcollection/laborAccom/returnList.xf?aac001=${aac001}";
    	 }else{
	     	window.location.href = "${ctx}/business/person/personBaseInfo/edit.xf?aac001=${aac001}&cczy06="+cczy06;
    	 }
      } 
	//教育背景
	function educationSelect(){
		window.location.href = "${ctx}/business/person/personBaseInfo/selectEducation.xf?aac001=${aac001}&cczy06="+cczy06;
	 } 
	
	//工作经历
	function workExpceSelect(){
		window.location.href = "${ctx}/business/person/personBaseInfo/selectWorkExpce.xf?aac001=${aac001}&cczy06="+cczy06;
	 } 
	//就业失业情况
	function laborCollection(){
		window.location.href = "${ctx}/business/laborcollection/laborAccom/edit.xf?aac001=${aac001}";
	 }
</script>
<body>
<div class="main-container">
	<div class="container-fluid">
		<div class="mhySearch1">
	   		<div class="mhyTitle">个人基本信息维护</div>
	   			<div class="row mhyUnitSearch">
		   			<form id="searchForm" class="mhySearchInput">
			   			<div class="col-sm-6"></div>
			   			<div class="col-xs-12 col-sm-6">
			   				<label class="col-xs-4 col-sm-4">
			   					基本信息查询:
			   				</label>
				   				<div class="col-xs-6 col-sm-6 " >
									<input class="easyui-textbox" style="width: 100%;" type="text" id="unId" value="${personBaseInfoForm.aac002 }" placeholder="请输入身份证号" >
								</div>
								<div class="col-xs-2 col-sm-2 mhyBtn">
									<a href="javascript:void(0)" class="btn btn-primary btn-border1 mhyBtnLeft" style="margin-top: -5px;" onClick="Idcard()" data-options="iconCls:'icon-print'">
									<i class="icon-search"></i>
									查询
									</a>
								</div>
			   			</div>
		   			</form>
		   			</div>
		   			<div class="mhyPersonTabs">
		   				<ul id="personTab">
		   					<li onclick="personSelect()">个人基本信息</li>
		   					<c:if test="${empty sign }">
			   					<li class="active">求职登记</li>
			   					<li onclick="educationSelect()">教育背景</li>
			   					<li onclick="workExpceSelect()">工作经历</li>
		   					</c:if>
		   					<c:if test="${!empty sign }">
		   						<li onclick="laborCollection()">就业失业情况</li>
			   					<li class="active">求职登记</li>
		   					</c:if>
		   				</ul>
		   				<div class="mhyPersonInfo">
			   				<form:form  class="jrForm" modelAttribute="personJobRegistForm" method="post" action="${ctx}/business/person/personJobRegist/save.xf">
							  <form:hidden path="aac001" value="${aac001 }"></form:hidden>
							  <form:hidden path="ccpr07" value="${cczy06 }"></form:hidden>
							  <form:hidden path="aac0d0" ></form:hidden>
							  <form:hidden path="aac0b0" ></form:hidden>
							  <form:hidden path="aae043" ></form:hidden>
							  <form:hidden path="ace014" ></form:hidden>
							  <form:hidden path="acb210" ></form:hidden>
							  <form:hidden path="abb561" ></form:hidden>
							  <form:hidden path="abb771" ></form:hidden>
							  <form:hidden path="abb773" ></form:hidden>
							   <div class="mhySearchInput mhyInputDiv">
							    <div class="mhyTitle1">个人基本信息</div>
							    <div class="row">
							         <label class="col-xs-3 col-sm-2" for="inputError">身份证号:</label>
										 <div class="col-xs-9 col-sm-2 ">
											<input  class="form-control" type="text" value="${personForm.aac002 }" readonly="readonly"/>
										</div>
									<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
										 <div class="col-xs-9 col-sm-2">
											<input  class="form-control" type="text" value="${personForm.aac003 }" readonly="readonly"/>
										</div>
										 
									<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
										 <div class="col-xs-9 col-sm-2">
											<input  class="form-control" type="text" value="${personForm.aac004 }" readonly="readonly"/>
									</div>
							    </div>
							    <div class="row">
							         <label class="col-xs-3 col-sm-2" for="inputError">出生日期:</label>
										 <div class="col-xs-9 col-sm-2 ">
											<input  class="form-control" type="text" value="<fmt:formatDate value="${personForm.aac006 }" pattern="yyyy-MM-dd " />" readonly="readonly"/>
										</div>
									<label class="col-xs-3 col-sm-2" for="inputError">户口性质:</label>
										 <div class="col-xs-9 col-sm-2">
											<input  class="form-control" type="text" value="${personForm.aac009 }" readonly="readonly"/>
										</div>
										 
									<label class="col-xs-3 col-sm-2" for="inputError">文化程度:</label>
										 <div class="col-xs-9 col-sm-2 ">
											<input  class="form-control" type="text" value="${personForm.aac011 }" readonly="readonly"/>
									</div>
							    </div>
							    <div class="row">
							         <label class="col-xs-3 col-sm-2" for="inputError">户口所在地:</label>
										 <div class="col-xs-9 col-sm-6 ">
											<input  class="form-control" type="text" value="${personForm.bab305 }" readonly="readonly"/>
										</div>
									<label class="col-xs-3 col-sm-2" for="inputError">联系电话:</label>
										 <div class="col-xs-9 col-sm-2">
											<input  class="form-control" type="text" value="${personForm.aae005 }" readonly="readonly"/>
										</div>
							    </div>
							   <div class="mhyTitle1">求职信息登记</div>
							   <form:hidden path="acb208"></form:hidden>
							   <form:hidden path="ccpr08"></form:hidden>
							    <div class="row">
							    	<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>登记类别:</label>
										 <div class="col-xs-9 col-sm-2 required mhyNoSelect">
										 	<xf:select textField="name" tableName="TAB_REGTYPE" id="acc201"  name="acc201" value="${personJobRegistForm.acc201 }"  valueField="code" hasDefault="0"></xf:select>
										 </div>
									<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>人员类别:</label>
										 <div class="col-xs-9 col-sm-2 required mhyNoSelect">
										 	<xf:select textField="name" tableName="TAB_STAFFTYPE" id="acc20t" name="acc20t" value="${personJobRegistForm.acc20t }"  valueField="code" hasDefault="0"></xf:select>
										 </div>
									 <label class="col-xs-3 col-sm-2" for="inputError">来源:</label>
										 <div class="col-xs-9 col-sm-2">
										 	<form:hidden path="bcb209" value="${cczy06 }"></form:hidden>
											<input  class="form-control" type="text" value="${personJobRegistForm.bcb209 }" readonly="readonly"/>
										</div>
								</div>
							    <div class="row">
							    	<label class="col-xs-3 col-sm-2" for="inputError">资格证书:</label>
										 <div class="col-xs-9 col-sm-2 mhyNoSelect">
										 	<xf:select textField="name" tableName="TAB_CERFORM"  name="bcc02i" value="${personJobRegistForm.bcc02i }"  valueField="code" hasDefault="0"></xf:select>
										 </div>
							    	<label class="col-xs-3 col-sm-2" for="inputError">人员细类:</label>
										 <div class="col-xs-9 col-sm-2 mhyNoSelect">
										 	<xf:select textField="name" tableName="TAB_STATHINTYP"  name="bcc20t" value="${personJobRegistForm.bcc20t }"  valueField="code" hasDefault="0"></xf:select>
										 </div>
									<label class="col-xs-3 col-sm-2" for="inputError">登记编码:</label>
										 <div class="col-xs-9 col-sm-2">
											<form:input  class="form-control" type="text"  path="acc200" readonly="true"></form:input>
										</div>
								</div>
							    <div class="row">
							    	<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
										 <div class="col-xs-9 col-sm-2">
										 	<form:hidden path="aae011" ></form:hidden><!-- 经办人代码 -->
											<form:input  class="form-control" type="text"  path="aae019" readonly="true"></form:input>
										</div>
									<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
										 <div class="col-xs-9 col-sm-2 ">
										 <form:hidden path="aae017" ></form:hidden><!-- 经办机构代码 -->
											<form:input  class="form-control" type="text"  path="aae020" readonly="true"></form:input>
										</div>
									<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
										 <div class="col-xs-9 col-sm-2 ">
											<form:input  class="form-control" type="text"  path="aae036" readonly="true"></form:input>
										</div>
								</div>
								 <div class="mhyTitle1">意向及待遇</div>
								<div class="row">
								 <form:hidden path="bcb207" value="1" ></form:hidden><!-- 数据分类1-个人登记添加，2-达成意向添加，3-劳务输出添加 -->
									<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>意愿职位1:</label>
									 <div class="col-xs-9 col-sm-2 required" id="bca112_div">
										<form:input class="form-control" type="text" 
											path="bca112"></form:input>
										   <form:hidden id="bca111" path="bca111" />
									 </div>
									<label class="col-xs-3 col-sm-2" for="inputError">意愿职位2:</label>
									 <div class="col-xs-9 col-sm-2" id="bcaa12_div">
										<form:input class="form-control" type="text" path="bcaa12"></form:input>
										<form:hidden id="bcaa11" path="bcaa11" />
									 </div>
									<label class="col-xs-3 col-sm-2" for="inputError">意愿职位3:</label>
									 <div class="col-xs-9 col-sm-2" id="bcab12_div">
										<form:input class="form-control" type="text" path="bcab12"></form:input>
										<form:hidden id="bcab11" path="bcab11" />
									 </div>
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError">意愿职位1说明:</label>
										 <div class="col-xs-9 col-sm-2">
											<form:input class="form-control" id="bcc20c" type="text" path="bcc20c"></form:input>
										 	<form:hidden id="aca112" path="aca112" />
										 	<form:hidden id="aca111" path="aca111" />
										 </div>
									<label class="col-xs-3 col-sm-2" for="inputError">意愿职位2说明:</label>
										 <div class="col-xs-9 col-sm-2">
											 <form:input class="form-control" id="bcc20d" type="text" path="bcc20d"></form:input>
											 <form:hidden id="acaa12" path="acaa12" />
											 <form:hidden id="acaa11" path="acaa11" />
										</div>
									<label class="col-xs-3 col-sm-2" for="inputError">意愿职位3说明:</label>
										 <div class="col-xs-9 col-sm-2">
										 	<form:input class="form-control" id="bcc20e" type="text" path="bcc20e"></form:input>
										    <form:hidden id="acab12" path="acab12" />
										    <form:hidden id="acab11" path="acab11" />
										</div>
								</div>
								<div class="row">
								   <label class="col-xs-3 col-sm-2" for="inputError">求职区域1:</label>
										 <div class="col-xs-9 col-sm-2">
											<form:input  class="form-control" type="text"  path="bcb202" ></form:input>
										</div>
								   <label class="col-xs-3 col-sm-2" for="inputError">求职区域2:</label>
										 <div class="col-xs-9 col-sm-2">
											<form:input  class="form-control" type="text"  path="bcb203" ></form:input>
										</div>
								   <label class="col-xs-3 col-sm-2" for="inputError">求职区域3:</label>
										 <div class="col-xs-9 col-sm-2">
											<form:input  class="form-control" type="text"  path="bcb204" ></form:input>
										</div>
								
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError">月工资:</label>
										 <div class="col-xs-9 col-sm-2 mhyNoSelect">
										 	<xf:select textField="name" tableName="TAB_SALARY"  name="acc034" value="${personJobRegistForm.acc034 }"  valueField="code" ></xf:select>
										 </div>
									<label class="col-xs-3 col-sm-2" for="inputError">福利待遇:</label>
									<form:hidden path="acc214" />
									<div class="col-xs-9 col-sm-2 mhyOrgId form-group"
										id="selectDxdiv">
										<select id="acc214_select" class="selectpicker"
											data-live-search="true" multiple="multiple"
											data-live-search-placeholder="Search" data-actions-box="true">
											<optgroup>
												<xf:select name="acc21411" textField="name"
													tableName="TAB_WELFARE" valueField="code"
													isOnlyOptions="true" isNoStyle="true"></xf:select>
											</optgroup>
										</select>
									</div>
<!-- 										 <div class="col-xs-9 col-sm-2 mhyNoSelect"> -->
<%-- 										 	<xf:select textField="name" tableName="TAB_WELFARE"  name="acc214" value="${personJobRegistForm.acc214 }"  valueField="code" hasDefault="0"></xf:select> --%>
<!-- 										 </div> -->
									<label class="col-xs-3 col-sm-2" for="inputError">食宿要求:</label>
										<div class="col-xs-9 col-sm-2 mhyNoSelect">
										 	<xf:select textField="name" tableName="TAB_SREQUIREMENT"  name="acb228" value="${personJobRegistForm.acb228 }"  valueField="code" hasDefault="0"></xf:select>
										 </div>
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError">单位性质:</label>
										 <div class="col-xs-9 col-sm-2 mhyNoSelect">
										 	<xf:select textField="name" tableName="TAB_UNITNATURE"  name="aab019" value="${personJobRegistForm.aab019 }"  valueField="code" hasDefault="0"></xf:select>
										 </div>
									<label class="col-xs-3 col-sm-2" for="inputError">经济类型:</label>
										 <div class="col-xs-9 col-sm-2 mhyNoSelect">
										 	<xf:select textField="name" tableName="TAB_ECONOMIC"  name="aab020" value="${personJobRegistForm.aab020 }"  valueField="code" hasDefault="0"></xf:select>
										 </div>
									<label class="col-xs-3 col-sm-2" for="inputError">参加工作时间:</label>
									<div class="col-xs-9 input-group col-sm-2" style="float:left">
										<form:input class="form-control date-picker dp mhydatepicker" path="aac007" type="text" placeholder="请选择日期" />
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>信息发布方式:</label>
										<div class="col-xs-9 col-sm-3">
										<c:forEach items="${listForm}" var="item">
											<label class="inline mhyInline"> <input class="ace"
												type="checkbox"
												<c:if test="${item.CHECKED}"> checked="checked"</c:if>
												name="acc20q" value="${item.CODE}" /> <span class="lbl">${item.NAME}</span>
											</label>
										</c:forEach>
										<div class="form-group">
										<br/>
											<label class="inline mhyInline" style="display: none">
												<input class="ace" type="checkbox" name="acc20q" value="" />
												<span class="lbl"></span>
											</label>
										</div>
									</div>
								</div>

						   			</div>
						   			<div class="bottomBtn">
				   					<div class="floatBtn">
					   					<a class="btn  btn-primary mhyBtnLeft" role="button" onclick="refresh()">
					   					<i class="icon-plus"></i>
					   					新增
					   					</a>
					   					<button class="btn btn-primary mhyBtn"  type="submit">
					   					<i class="icon-save"></i>
					   					保存	
					   					</button>
				   					</div>
				   				</div>
							   	</form:form>
	   					</div>
	   			</div>
	   </div>
	 </div>	
</div>
<div class="h50">&nbsp;</div>		   				
<script type="text/javascript">
	jQuery(function($){
		$(".mhydatepicker").datetimepicker({
	          todayBtn: true,
	          format: "yyyy-mm-dd",
	          startView: 2,
	          minView: 2,
	          language: 'cn',
	          maxView: "decade",
	          viewSelect: 2,
	          autocomplete:true,
	          autoclose:true
	      });
	})
</script>
<script type="text/javascript">
		function restCheckField(fieldName) {
			$('#personJobRegistForm').data('bootstrapValidator').updateStatus(
					fieldName, 'VALID', null).validateField(fieldName);
		}
		jQuery(function($) {
			//设置职位类别(意向职位1)
			var isCheck = true;
			$("#bca112_div").seljob({
				totalSelect : 1,
				callBack : function(returnData) {
					$("#bca111").val(returnData[0].code);
					$("#bca112").val(returnData[0].name);
					$("#bcc20c").val(returnData[0].name);
					$("#aca111").val(returnData[0].btCode);
					$("#aca112").val(returnData[0].btName);
					restCheckField('bca112');
					isCheck = !checkAca111();
				}
			});
			//设置职位类别(意向职位2)
			var isChecka = true;
			$("#bcaa12_div").seljob({
				totalSelect : 1,
				callBack : function(returnData) {
					$("#bcaa11").val(returnData[0].code);
					$("#bcaa12").val(returnData[0].name);
					$("#bcc20d").val(returnData[0].name);
					$("#acaa11").val(returnData[0].btCode);
					$("#acaa12").val(returnData[0].btName);
					restCheckField('bcaa12');
					isChecka = !checkAcaa11();
				}
			});
			//设置职位类别(意向职位3)
			var isCheckb = true;
			$("#bcab12_div").seljob({
				totalSelect : 1,
				callBack : function(returnData) {
					$("#bcab11").val(returnData[0].code);
					$("#bcab12").val(returnData[0].name);
					$("#bcc20e").val(returnData[0].name);
					$("#acab11").val(returnData[0].btCode);
					$("#acab12").val(returnData[0].btName);
					restCheckField('bcab12');
					isCheckb = !checkAcab11();
				}
			});
			$('.selectpicker').selectpicker({
				selectAllText : '全选',//全选的checkbox名称  
				deselectAllText : '取消',
				selectAllNumber : true,
				actionsBox : true,
				liveSearch : false,
				noneResultsText : "没有相关信息",liveSearchPlaceholder:"请输入搜索.."
			});
			var acc214str = '${personJobRegistForm.acc214}';
			if (acc214str) {
				$("#acc214_select").selectpicker('val', acc214str.split(','));
			}
		});
		$("[data-toggle='popover']").popover();
	</script>
</body>

</html>

