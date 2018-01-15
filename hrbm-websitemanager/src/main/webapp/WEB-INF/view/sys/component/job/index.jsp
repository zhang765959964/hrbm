<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title></title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%>
<link rel="shortcut icon" href="${ctx}/styles/main/img/favicon.ico"/>
<link rel="stylesheet" type="text/css" href="${ctx}/styles/main/fonts/css/font-awesome.min.css"></link>
<link rel="stylesheet" type="text/css" href="${ctx}/js/lib/jquery/plugins/jquery-dialogbox/css/jquery.dialogbox.css"></link>
<link rel="stylesheet" type="text/css" href="${ctx}/js/lib/jquery/plugins/jquery-ui/jquery-ui.css"></link>
<link rel="stylesheet" type="text/css" href="${ctx}/js/lib/jquery/plugins/jquery-validation-1.15/jquery.validate.css"></link>
<link rel="stylesheet" type="text/css" href="${ctx}/stylesheets/index.css"></link>
<link rel="stylesheet" type="text/css" href="${ctx}/stylesheets/normal.css"></link>
<link rel="stylesheet" type="text/css" href="${ctx}/stylesheets/common.css"></link>
<link rel="stylesheet" type="text/css" href="${ctx}/stylesheets/usercenter.css"></link>

<script type="text/javascript" src="${ctx}/js/lib/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/jquery/jquery.form.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/jquery/jquery.mousewheel.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/jquery/plugins/jquery-dialogbox/js/jquery.dialogBox.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/jquery/plugins/jquery-ui/jquery-ui.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/jquery/plugins/jquery-validation-1.15/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/jquery/plugins/jquery-validation-1.15/jquery.validation_localization_cn.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/jquery/jquery.validate.ext.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/jquery/jquery.placeholder.js"></script>
<script type="text/javascript" src="${ctx}/js/ui/xf.seljob.js"></script>
<script type="text/javascript" src="${ctx}/js/ui/xf.dialog.js"></script>
<script type="text/javascript" src="${ctx}/js/ui/xf.messageBox.js"></script>
<script type="text/javascript" src="${ctx}/js/ui/xf.dialogBox.js"></script>

<style>
  body{width:auto;height:auto;min-width:100px}
</style>
</head>

<script>
// document.domain = "${mainDomain}";
     $(function(){
    	 initWorkType();
     })
	    function  initWorkType(){
    	$(".subclass-default").click(function() {
    		var p = $(this);
    		var length_c=p.siblings(".jobsubclass-sec-item").find(".jobthirdclass-list").children().length;
    		if(length_c==0){
    			getJobTypes(p.attr("id"), function (results) {
                    var jobHtml="";
                    $.each(results,function(index,value){
                    	jobHtml+= '<a href="javascript:void(0)" class="jobthirdclass-item  ellipsis"><label title="'+value.name+'"><input type="checkbox" onclick="addSelJobType(this)" btcode="'+value.bt+'" btname="'+value.btName+'" value="'+value.id+'" pid="'+p.attr("id")+'">'+value.name+'</label> </a>';
                    });
                    p.siblings(".jobsubclass-sec-item").find(".jobthirdclass-list").html(jobHtml);               
                });
    		}
    		
			$(this).siblings(".jobsubclass-sec-item").find(".subclass-active").css({
				"display" : "block"
			});
			$(this).siblings(".jobsubclass-sec-item").find(".jobthirdclass-list").css({
				"display" : "block"
			});
		});
		$(".jobsubclass-sec-item").mouseleave(function(){
			$(this).find(".subclass-active").css({
				"display" : "none"
			});
			$(this).find(".jobthirdclass-list").css({
				"display" : "none"
			});
		})
    }
     
    function addSelJobType(obj){
    	
    	
    	var value=$(obj).val();
    	var jobLevel=$(obj).attr("jobLevel");
    	if($(obj).get(0).checked){
    		//选中
    		var jobLevel=$(obj).attr("jobLevel");
    		if(jobLevel=="2"){
    			$(".selected-list .selected-item[pid='"+value+"']").each(function(){
    				var num=$("#selected-num").text();
    				$(this).remove();  
    				$("#selected-num").text(parseInt(num)-1);
    			})
    			if(isMax(obj)){
            		return;
            	}
    			$(obj).parents(".jobsubclass-sec-item").find(".jobthirdclass-list input").prop("checked",true);
    			$(obj).parents(".jobsubclass-sec-item").find(".jobthirdclass-list input").attr("disabled",true);
    			addOneJobType(obj);
    		}else{
    			if(isMax(obj)){
            		return;
            	}
        		addOneJobType(obj);
    		}
    	}else{
    		//取消
    		var num=$("#selected-num").text();
            if($(".selected-list .selected-item[data='"+value+"']").length>0){
        		$(".selected-list .selected-item[data='"+value+"']").remove();
        		$("#selected-num").text(parseInt(num)-1);
            }
    		if(jobLevel=="2"){
    			$(obj).parents(".jobsubclass-sec-item").find(".jobthirdclass-list input").prop("checked",false);
    			$(obj).parents(".jobsubclass-sec-item").find(".jobthirdclass-list input").attr("disabled",false);
    		}
    	}
    }
   function isMax(obj){
	   var flag=false;
	   var num=$("#selected-num").text();
		if(parseInt(num)=='${totalSelect}'){
			$(obj).get(0).checked=false;
			$.messageBox({type:'error',content:"最多选择"+'${totalSelect}'+"项"});  
			flag=true;
		}
		return flag;
   } 
   function addOneJobType(obj){
	    var pid=$(obj).attr("pid");
	    var btcode=$(obj).attr("btcode");
	    var btname=$(obj).attr("btname");
	    var value=$(obj).val();
		var name=$(obj).parent().text();  
		var num=$("#selected-num").text();
		$(".selected-list").append("<span class=\"selected-item ellipsis\" btcode='"+btcode+"' btname='"+btname+"' data='"+value+"' pid='"+pid+"'> "+name+"<i class=\"job-del\" onclick=\"removeOneSelJobType(this)\"></i></span>");
		$("#selected-num").text(parseInt(num)+1);
   }
   //全部清除
   function removeAllSelJobType(){
    		var choiceJob = $("#choiceJobSelectTab").children("span");
    		if(choiceJob){
	    		for(var i = 0 ;i<choiceJob.length;i++){
	    			var valId = $(choiceJob[i]).attr("data");
	    			$("input[value="+valId+"]").prop("checked",false);
	    		}
    		}
    		$("#selected-num").text(0);
    		$(".selected-list span").remove();  
    }
   //单个清除
   function removeOneSelJobType(obj){
	    var num=$("#selected-num").text();
		$(obj).parent().remove();  
		$("#selected-num").text(parseInt(num)-1);
		var parentNode = $(obj).parent();
		var valId = parentNode.attr("data");
		$("input[value="+valId+"]").prop("checked",false);
  }
   function removeOneSelJobTypea(obj){
	    var num=$("#selected-num").text();
		$(obj).parent().remove();  
		$("#selected-num").text(parseInt(num)-1);
 }
   function confirmSel(obj){

	   var returnData=[];
	   $(".selected-list .selected-item").each(function(i,e){
		   returnData.push({name:$.trim($(this).text()),
			                code:$.trim($(this).attr("data")),
			                btCode:$.trim($(this).attr("btcode")),
			                btName:$.trim($(this).attr("btname"))			                
		   });
		})
		if(returnData.length==0){
			$.messageBox({type:'error',content:"至少选择一项求职意向"});  
			return;
		}
	   //alert("d");
/* 		top.window.seljob.callBack(window,returnData);
		top.window.seljob.closeDialog(window); */
	   	window.parent.seljob.callBack(window,returnData);
		window.parent.seljob.closeDialog(window);
   }
   function getJobTypes(pId,callback){
       $.post("${ctx}/sys/component/job/job-json.xf",{pId:pId},callback,"JSON");
   }
</script>
	<div class="per-jobsort grey bd">
		<div class="per-jobsort-header clearfix">
			<strong>职位选择：</strong> <span class="jobsort-btn">
				<button onclick="confirmSel(this)" class="x-btn red"
					>确定选择</button>
			</span> 
		</div>
		<div class="per-jobsort-selected bd clearfix">
			<div class="selected-txt fl">
				最多选<strong>${totalSelect }</strong>项&nbsp;&nbsp;已选<strong id="selected-num">0</strong>项
			</div>
			<div class="selected-list fr" id="choiceJobSelectTab">
				<i class="fa fa-trash" onclick="removeAllSelJobType()" title="全部清除"></i>
			</div>
		</div>
		<div class="per-jobsort-con bd">
			<c:forEach items="${jobList}" var="job">
				<div class="per-jobsort-row bd-b clearfix">
					<div class="per-jobmainclss fl">${job.name}</div>
					<div class="per-jobsubclss fr">
						<ul class="jobsubclass-list clearfix">
							<c:forEach items="${job.subJobList}" var="subJob">
								<li class="jobsubclass-item"><a href="javascript:void(0)"
									title="${subJob.name}" id="${subJob.id}"
									class="subclass-default ellipsis"><i
										class="fa fa-plus-square-o"></i>${subJob.name}</a>
									  <!--<div class="pr">-->
										<div class="jobsubclass-sec-item">
											<a href="javascript:void(0)" class="subclass-active ellipsis"><label
												title="${subJob.name}">${subJob.name}</label></a>
											<div class="jobthirdclass-list clearfix"></div>
										</div>
									<!-- </div>-->
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</html>
