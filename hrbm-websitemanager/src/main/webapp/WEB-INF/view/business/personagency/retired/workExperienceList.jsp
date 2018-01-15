<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>工作经历维护</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp"%>
<script type="text/javascript" src="${ctx}/js/business/personagency/retired/workExperienceList.js?v=20161227"></script>
<script type="text/javascript">
$(function (){
	initlWorkEx();
})
//工作经历		 
function initlWorkEx(){
	  var columns= [
		            {name:'id',label:'操作',key: true,align:'center',width:80,frozen : true,	formatter:'actions',formatoptions:{
							keys: false,
							editbutton : true,
							delbutton : false,
							onSuccess :function (){
								var parentIframe=xfui.getParentIframe();
								parentIframe.careReload();
								whrefresh();
							}
				   }},
                   {name:'personId',label:'人员id',align:'center',editable : true,hidden:true},
                   {name:'createTime',label:'起始时间',align:'center',editable : true,unformat: pickDate,editrules : {
                	   required : true,
                	   date:true,
                	   custom:true, 
                	   date:true,
                	   custom:true, 
                	   custom_func:function(value, colNames){    
                		  if(!(/^[0-9]{4}-(0?[0-9]|1[0-2])-(0?[1-9]|[12]?[0-9]|3[01])$/.test(value))){
                			   return [false,"请输入YYYY-MM-DD日期格式！"];
                		  }else{
                			  $("#workWhBeginDate").val(value);
	                		   return [true,""];
	                	  }
                	   }}
            	   },
                   {name:'endTime',label:'终止时间',align:'center',editable : true,unformat: pickDate,editrules : {
                	   required : true,
                	   date:true,
                	   custom:true, 
                	   custom_func:function(value, colNames){   
                		   if(!(/^[0-9]{4}-(0?[0-9]|1[0-2])-(0?[1-9]|[12]?[0-9]|3[01])$/.test(value))){
                			   return [false,"请输入YYYY-MM-DD日期格式！"];
                			   
                		  }else{
                			  $("#workWhEndDate").val(value);
	                		  var bb = $("#workWhBeginDate").val();
	                		  var ee = $("#workWhEndDate").val();
	                		  if(bb>ee){
	                			   return [false,"起始时间不能大于终止时间"];
	                		  }else{		
	                			   return [true,""];
	                		  }		
	                	 }
                   	}}
            	   },
                   {name:'workUnit',label:'工作单位',align:'center',editable : true,editrules :{ required : true}, editoptions:{size:10,maxlength:15}},
                   {name:'gzName',label:'工种',align:'center',
                   		editable:true,edittype:"select",editoptions:{value: "#:--请选择--;${gzValue}" }
                   },
                   {name:'createrName',label:'经办人',align:'center'},
                   {name:'createrOrgName',label:'经办机构',align:'center'},
                   {name:'createrDate',label:'经办日期',align:'center'}
  	        	];

		var personIds = $("#personId").val();
	  
    $("#workExList").jqGrid({
    	   url:CTX+'/business/personagency/experience/listJson.xf?personId='+personIds,
    	   editurl:CTX+'/business/personagency/experience/saveOrUpdate.xf',
           mtype: "GET",
		   styleUI : 'Bootstrap',
           datatype: "json",
           colModel: columns,
		   viewrecords: true,
           rowNum: 10,
           rowList:[10,20,30],
           pager: "#jqGridPager",
           pagerpos:'left',
           regional : 'cn',
           recordpos:'right',
           height:'100%',
           altRows:true,
           shrinkToFit: false,
           multiselect:true,
           autowidth: true,
           multiboxonly: true,
           gridComplete:function(){
            	  $(".ui-inline-edit").removeAttr("onclick").on("click",function(){
            		  jQuery.fn.fmatter.rowactions.call(this,'edit');
            	  })
            	  $(".ui-inline-save").removeAttr("onclick").on("click",function(){
            		  jQuery.fn.fmatter.rowactions.call(this,'save');
            	  })
            	  $(".ui-inline-cancel").removeAttr("onclick").on("click",function(){
            		  jQuery.fn.fmatter.rowactions.call(this,'cancel');
            	  })
            	  
             }
       });  
}
</script>
</head>
<body>
	<div class="container-fluid">
		<form:form modelAttribute="workExperienceForm">
			<form:hidden path="createrId"/>
			<form:hidden path="createrName"/>
			<form:hidden path="createrDate"/>
			<form:hidden path="createrOrgId"/>
			<form:hidden path="createrOrgName"/>
		</form:form>
		<input type="hidden" id="personId" value="${personId}">
		<input type="hidden" id="workWhBeginDate" />
		<input type="hidden" id="workWhEndDate" />
		<div class="moduleWrapNobg">
			<div class="moduleCont">
				<div class="mgy10">
					<a href="javascript:addWorkWh()" role="button" class="btn btn-primary">
						<i class="icon-plus"></i>添加
					</a>
					<a href="javascript:delWorkWh()" role="button" class="btn btn-danger">
						<i class="icon-trash"></i>删除
					</a>
				</div>
				<div class="row">
					<div class="col-xs-12">
						<table id="workExList"></table>
						<div id="jqGridPager"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


