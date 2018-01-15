<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>就业失业情况信息表管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<%@include file="/commons/include/bootstrapInc.jsp" %>
<link rel="stylesheet" href="${ctx}/js/lib/bootstrap-validator/css/bootstrapValidator.min.css" type="text/css"> 
<link rel="stylesheet" href="${ctx}/assets/css/chosen.css" />
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/normal.css" />
<script>
$(function(){
	initFormSubimt();
})
function initFormSubimt(){
    $('#laborAccomForm').bootstrapValidator({
          message: 'This value is not valid',
          feedbackIcons: {
              valid: 'glyphicon glyphicon-ok',
              invalid: 'glyphicon glyphicon-remove',
              validating: 'glyphicon glyphicon-refresh'
          },
          fields: {
          }
      }).on('success.form.bv', function(e) {
          e.preventDefault();
          var $form = $(e.target);
          var bv = $form.data('bootstrapValidator');
          $.post($form.attr('action'), $form.serialize(), function(data) {
          	console.info(data);
              $(".btn-submit").removeAttr("disabled");
              bootbox.alert({ 
                  size: 'small',
                  width:"100px",
                  message:data.message, 
                  callback: function(rowIndex, rowData){
                	  laborCollection();	
                  }
              })
              
          }, 'json');

      });
  }


//返回基本信息页面
function personSelect(){
	window.location.href = "${ctx}/business/laborcollection/laborAccom/returnList.xf?aac001=${aac001}";
 }
function laborCollection(){
	window.location.href = "${ctx}/business/laborcollection/laborAccom/edit.xf?aac001=${aac001}";
 } 
function personJobRegist(){
	window.location.href = "${ctx}/business/person/personJobRegist/edit.xf?aac001=${aac001}&sign=1";
 } 
</script>
</head>
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
		   					<li class="active">就业失业情况</li>
		   					<li onclick="personJobRegist()">求职登记</li>
		   				</ul>
		   			<div class="mhyEducationInfo1">
		   			<form:form  modelAttribute="laborAccomForm" method="post" action="${ctx}/business/laborcollection/laborAccom/save.xf">
						<form:hidden path="aac001" value="${aac001}"></form:hidden> 
						<form:hidden path="acc0m01"></form:hidden> 
						<form:hidden path="acpost01"></form:hidden> 
						<form:hidden path="acemp01"></form:hidden> 
					   		<table class="mhyFormTable"> 
		                      <tr>
		                      <td class="mhyFormTaTd" colspan="6">
		                      	<label  class="clickEmploye">
									<form:radiobutton path="acc0m"  value="1"  class="ace" name="acc0m"/>
									<span class="lbl">就业</span>
								</label>
								
								<label  class="clickAbsent">
									<form:radiobutton path="acc0m" value="2"  class="ace" name="acc0m"/>
									<span class="lbl">不在岗</span>
								</label>
								
								<label class="clickUnemploye">
								
									<form:radiobutton path="acc0m" value="3" class="ace" name="acc0m"/>
									<span class="lbl">未就业及失业</span>
								</label>
								
								<label class="clickHide">
								<form:radiobutton path="acc0m" value="4" class="ace" name="acc0m"/>
									<span class="lbl">服刑</span>
								</label>
								
								<label class="clickHide">
									<form:radiobutton path="acc0m" value="5" class="ace" name="acc0m"/>
									<span class="lbl">出国定居</span>
								</label>
								
								<label class="clickHide">
									<form:radiobutton path="acc0m" value="6" class="ace" name="acc0m"/>
									<span class="lbl">在学</span>
								</label>
		                   </td>
		                  </tr>
		                  <!-- employment modual 灵活就业-->
		                 <tr class="employment">
		                     <td width="13%" class="right">工作单位:</td>
		                     <td width="20%">
		                     	<form:input class="col-xs-12 col-sm-10" path="aab004" type="text" />
		                     </td>
		                     <td width="13%" class="right">单位性质:</td>
		                     <td width="20%">
		                      		<xf:select textField="name" tableName="TAB_UNITNATURE" name="aab019" value="${laborAccomForm.aab019 }"  valueField="code" hasDefault="0"></xf:select> 
		                     </td>
		                     <td width="13%" class="right">产业类别:</td>
		                     <td width="20%">
		                      	<xf:select textField="name" tableName="TAB_INDUSTRYCLASSES" name="aab054" value="${laborAccomForm.aab054 }"  valueField="code" hasDefault="0"></xf:select>
		                     </td>
		                 </tr>
		                 <tr class="employment">
		                     <td width="13%" class="right">经济类型:</td>
		                     <td width="20%">
		                      	<xf:select textField="name" tableName="TAB_ECONOMIC" name="aab020" value="${laborAccomForm.aab020 }"  valueField="code" hasDefault="0"></xf:select>
		                     </td>
		                     <td width="13%" class="right">就业形势:</td>
		                     <td width="20%">
		                         <form:input class="col-xs-12 col-sm-12" path="accm02" type="text" />
		                     </td>
		                     <td width="13%" class="right">就业时间:</td>
		                     <td width="20%">
		                         	<div class="input-group" style="padding:0 !important">
		                             <form:input class="form-control date-picker mhydatepicker" path="accm03"  id="dp" type="date"  data-date-format="dd-mm-yyyy" placeholder="请选择日期"/>
		                             <span class="input-group-addon">
		                                 <i class="icon-calendar bigger-110"></i>
		                             </span></div>
		                     </td>
		                 </tr>
		                 <tr class="employment">
		                     <td width="13%" class="right">签订劳动合同情况:</td>
		                     <td width="20%">
		                     <div>
		                     	<form:radiobutton class="ace" path="accm04" value="1" /><span class="lbl">是</span>
		                     	<form:radiobutton class="ace" path="accm04" value="2" /><span class="lbl">否</span>
		                     </div>
		                     </td>
		                     <td width="13%" class="right">合同期限:</td>
		                     <td colspan="3">
		                         <span class="trainCont clearfix">
		                             <div class="input-group col-sm-5" style="padding-left:0px !important;">
		                                 <form:input class="form-control date-picker mhydatepicker" path="accm05" id="dp" type="date" data-date-format="dd-mm-yyyy"  placeholder="请选择日期"/>
		                                 <span class="input-group-addon">
		                                     <i class="icon-calendar bigger-110"></i>
		                                 </span>
		                             </div>
		                             <span class="fl vtat lh2">&nbsp;至&nbsp;</span>
		                             <div class="input-group col-sm-5" style="padding-right:0px !important;">
		                                 <form:input class="form-control date-picker mhydatepicker" path="accm06" id="dp" type="date" data-date-format="dd-mm-yyyy"  placeholder="请选择日期"/>
		                                 <span class="input-group-addon">
		                                     <i class="icon-calendar bigger-110"></i>
		                                 </span>
		                             </div>
		                         </span>
		                     </td>
		                 </tr>
		                 <tr class="employment">
		                     <td width="13%" class="right">合同情况:</td>
		                     <td colspan="5" class="tal">
		                         
		                             <label ><form:radiobutton class="ace" path="accm07" value="1" name="form-field-radio"/><span class="lbl">本县内</span></label>
		                         
		                        
		                             <label ><form:radiobutton class="ace" path="accm07" value="2" name="form-field-radio"/><span class="lbl">本镇内</span></label>
		                         
		                             <label ><form:radiobutton class="ace" path="accm07" value="3" name="form-field-radio"/><span class="lbl">本镇外</span></label>
		                         
		                             <label ><form:radiobutton class="ace" path="accm07" value="4" name="form-field-radio"/><span class="lbl">本市外区</span></label>
		                         
		                             <label><form:radiobutton class="ace" path="accm07" value="5" name="form-field-radio"/><span class="lbl">出国务工（外出时间:</span> </label>
		                                 <div class="dib dph" style="width:160px;">
		                                     <div class="col-xs-8 input-group col-sm-8" style="width:88%;"> 
		                                         <form:input class="form-control date-picker mhydatepicker" id="mhydatepicker" path="accm08" type="text" data-date-format="dd-mm-yyyy" placeholder="请选择日期"/>
		                                         <span class="input-group-addon">
		                                             <i class="icon-calendar bigger-110"></i>
		                                         </span>
		                                     </div>
		                                         <span class="lbl">）</span>
		                                 </div>
		                         
		                             <label><form:radiobutton class="ace" path="accm07" value="6" name="form-field-radio"/><span class="lbl">外省市&nbsp;&nbsp;&nbsp;（外出时间:</span></label>
		                                 <div class="dib dph" style="width:160px;">
		                                     <div class="col-xs-12 input-group col-sm-8" style="width:88%;">
		                                         <form:input class="form-control date-picker mhydatepicker" id="mhydatepicker" path="accm09" type="text" data-date-format="dd-mm-yyyy" placeholder="请选择日期"/>
		                                         <span class="input-group-addon">
		                                             <i class="icon-calendar bigger-110"></i>
		                                         </span>
		                                     </div>
		                                     <span class="lbl">）</span>
		                                 </div>
		                     </td>
		                 </tr>
		                 <tr class="employment">
		                     <td  class="right">对目前工作状况是否满意？</td>
		                     <td  colspan="3">
		                         <label><form:radiobutton path="accm11" class="ace" value="1" name="form-field-radio"/><span class="lbl">是</span></label>
		                         <label><form:radiobutton class="ace" path="accm11" value="2" name="form-field-radio"/><span class="lbl">否(原因</span>
		                             <form:input  path="accm12" type="text"/>
		                             )</label>
		                     </td>
		                     <td width="13%" class="right">人员类别:</td>
		                     <td >
		                         <div class="col-xs-12 col-sm-6" style="width: 100% !important;padding: 0px !important;">
		                      		<xf:select textField="name" tableName="TAB_STAFFTYPE" name="acc20t" value="${laborAccomForm.acc20t }"  valueField="code" hasDefault="0"></xf:select>
		                      	 </div>
		                     </td>
		                 </tr>
		                 
		                 <tr class="employment">
		                     <td width="13%" class="right">灵活就业登记类别:</td>
		                     <td colspan="5">
								 <label ><form:radiobutton class="ace" path="accm13" value="1" /><span class="lbl">企业零散用工</span></label>
		                         <label ><form:radiobutton class="ace" path="accm13" value="2" /><span class="lbl">弹性就业</span></label>
		                         <label ><form:radiobutton class="ace" path="accm13" value="3" /><span class="lbl">家政服务</span></label>
		                         <label ><form:radiobutton class="ace" path="accm13" value="4" /><span class="lbl">自由职业</span></label>
		                         <label ><form:radiobutton class="ace" path="accm13" value="5" /><span class="lbl">街头自营</span></label>
		                         <label ><form:radiobutton class="ace" path="accm13" value="6" /><span class="lbl">打零工</span></label>
		                         <label ><form:radiobutton class="ace" path="accm13" value="7" /><span class="lbl">其他</span></label>
		                     </td>
		                 </tr>
		                  
		                    <!-- absent 不在岗 -->
		                  <tr class="absent">
		                      <td width="13%" class="right">工作单位:</td>
		                      <td width="20%">
		                          <form:input class="col-xs-12 col-sm-10" path="aab004t" type="text" />
		                      </td>
		                      <td width="13%" class="right">单位性质:</td>
		                      <td width="20%">
		                      	<xf:select textField="name" tableName="TAB_UNITNATURE" name="aab019t" value="${laborAccomForm.aab019t }"  valueField="code" hasDefault="0"></xf:select>
		                      </td>
		                      <td width="13%" class="right">经济类型:</td>
		                      <td width="20%">
		                      	<xf:select textField="name" tableName="TAB_ECONOMIC" name="aab020t" value="${laborAccomForm.aab020t }"  valueField="code" hasDefault="0"></xf:select>
		                      </td>
		                  </tr>
		                  <tr class="absent">
		                      <td width="13%" class="right">不在岗原因:</td>
		                      <td width="20%">
		                      	<xf:select textField="name" tableName="TAB_LEAVEREASONS" name="accm14" value="${laborAccomForm.accm14 }"  valueField="code" hasDefault="0"></xf:select>
		                      </td>
		                      <td width="13%" class="right">不在岗时间:</td>
		                      <td class="input-group">
                                 <form:input class="form-control date-picker mhydatepicker"  style="width:200px;" path="accm16" type="date" data-date-format="dd-mm-yyyy"  placeholder="请选择日期"/>
                                 <span class="input-group-addon">
                                     <i class="icon-calendar bigger-110"></i>
                                 </span>
		                      </td>
		                  </tr>
		                  <tr class="absent">
		                      <td width="13%" class="right">是否发放生活费:</td>
		                      <td width="20%">
		                          <label><form:radiobutton class="ace" path="accm17" value="1" checked="true"/><span class="lbl">是</span></label>
		                          <label><form:radiobutton class="ace" path="accm17" value="2" /><span class="lbl">否</span></label>
		                      </td>
		                      <td width="13%" class="right">生活费标准(元):</td>
		                      <td width="20%"><form:input class="col-xs-9 col-sm-9" path="accm18" type="text" /></td>
		                  </tr>
		                  <!-- unemployment 未就业及失业 -->
		                  <tr class="unemployment">
		                      <td width="13%" class="right">未就业及失业人员类别:</td>
		                      <td width="20%">
		                          <xf:select textField="name" tableName="TAB_STAFFTYPE" isNoStyle="true" name="acc20m" valueField="code" hasDefault="0" value="${laborAccomForm.acc20m }"></xf:select>
		                      </td>
		                      <td width="13%" class="right">失业主要原因(失业人员填写):</td>
		                      <td width="20%">
		                          <xf:select textField="name" tableName="TAB_LEAVEREASONS" isNoStyle="true" name="accm20" valueField="code" hasDefault="0" value="${laborAccomForm.accm20 }"></xf:select>
		                      </td>
		                      <td width="13%" class="right">失业登记时间:</td>
		                      <td width="20%">
			                      <div class="input-group" style="padding:0 !important">
		                              <form:input class="form-control date-picker mhydatepicker" id="mhydatepicker" path="accm21" type="date"  placeholder="请选择日期"/>
		                              <span class="input-group-addon">
		                                  <i class="icon-calendar bigger-110"></i>
		                              </span>
			                       </div>
		                      </td>
		                  </tr>
		                  <tr class="unemployment">
		                      <td width="13%" class="right">未就业原因(未就业人员填写):</td>
		                      <td width="20%">
		                      		<form:select class="col-xs-12 col-sm-12" path="accm19">
		                              <form:option value="" label="--请选择--"/>
		                              <form:option value="1" label="无就业愿望"/>
		                              <form:option value="2" label="家庭原因"/>
		                              <form:option value="3" label="无就业能力"/>
		                              <form:option value="4" label="正在培训"/>
		                              <form:option value="5" label="没有合适的工作"/>
		                              <form:option value="6" label="年龄偏大"/>
		                              <form:option value="7" label="对找工作丧失信心"/>
		                              <form:option value="8" label="其他原因"/>
		                           </form:select>
		                      </td>
		                      <td width="13%" class="right">上一次劳动合同终止或解除时间:</td>
		                      <td width="20%">
		                         	<div class="input-group" style="padding:0 !important">
		                             <form:input class="form-control date-picker mhydatepicker" path="accm22"  id="dp" type="date"  data-date-format="dd-mm-yyyy" placeholder="请选择日期"/>
		                             <span class="input-group-addon">
		                                 <i class="icon-calendar bigger-110"></i>
		                             </span></div>
		                     </td>
		                      <td width="13%" class="right">经劳动部门认定的困难群体:</td>
		                      <td >
		                          <xf:select textField="name" tableName="TAB_EDO" isNoStyle="true" name="accm23" valueField="code" hasDefault="0" value="${laborAccomForm.accm23 }"></xf:select>
		                      </td>
		                  </tr>
		                  <tr class="unemployment">
		                      <td width="13%" class="right">原工作单位:</td>
		                      <td width="20%">
		                          <form:input class="col-xs-12 col-sm-10" path="aab004m" type="text" value="${laborAccomForm.aab004m }"/>
		                      </td>
		                      <td width="13%" class="right">单位性质:</td>
		                      <td width="20%">
		                      		<xf:select textField="name" tableName="TAB_UNITNATURE" name="aab019m" value="${laborAccomForm.aab019m }"  valueField="code" hasDefault="0"></xf:select>
		                      </td>
		                      <td width="13%" class="right">经济类型:</td>
		                      <td width="20%">
		                      		<xf:select textField="name" tableName="TAB_ECONOMIC" name="aab020m" value="${laborAccomForm.aab020m }"  valueField="code" hasDefault="0"></xf:select>
		                      </td>
		                  </tr>
					   	</table>
					   	<div class="bottomBtn">
			   					<div class="h50">&nbsp;</div>
			   					<div class="floatBtn">
			   					<a  onclick="laborCollection()" class="btn btn-info mhyBtnLeft" >
			   					<i class="icon-repeat"></i>
			   					重置
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
	   			<div> </div>
	   </div>
	 </div>	
</div>
<script>
	var acc0m='${laborAccomForm.acc0m}';
	$(function(){
		if(acc0m==1){
			$(".employment").css("display","table-row");
  		}else if(acc0m==2){
  			$(".absent").css("display","table-row");
  		}else if(acc0m==3){
  			$(".unemployment").css("display","table-row");
  		}
		// 就业失业情况显示与隐藏
	  	$(".clickEmploye").click(function(){
	  		$(".employment").css("display","table-row");
	  		$(".absent").css("display","none");
	  		$(".unemployment").css("display","none");
	  		
	  	});
	  	$(".clickAbsent").click(function(){
	  		$(".employment").css("display","none");
	  		$(".unemployment").css("display","none");
	  		$(".absent").css("display","table-row");
	  	});
	  	$(".clickUnemploye").click(function(){
	  		$(".absent").css("display","none");
	  		$(".employment").css("display","none");
	  		$(".unemployment").css("display","table-row");
	  	});
	  	$(".clickHide").click(function(){
	  		$(".absent").css("display","none");
	  		$(".employment").css("display","none");
	  		$(".unemployment").css("display","none");
	  	});
	 	// 日期选择
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
	    $("[data-toggle='popover']").popover();
	})
</script>
</body>			
</html>


