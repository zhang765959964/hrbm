<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="h100p">
<head>
<title>广告位放置表管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />

<link rel="stylesheet" href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css" type="text/css">
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/jquery/bootstrap-contextmenu.js"></script>
<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />

<link rel="stylesheet" href="${ctx}/js/lib/bootstrap-table-rows/bootstrap-table-reorder-rows.css" type="text/css">
<script type="text/javascript" src="${ctx}/js/lib/bootstrap-table-rows/bootstrap-table-reorder-rows.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/bootstrap-table-rows/jquery.tablednd.js"></script>
<style>
#adCategoryList{
	list-style:none;
	padding:0px;
	text-align: center;
}
/*.channel{
	 padding-top:5px;
	 padding-bottom:5px;
	 margin-top:5px;
	 margin-bottom:5px;
}
.channel>a{
	 text-decoration:none;
	 color:#333333;
}
.channel>a:hover{
 	text-decoration:underline;
}
.choiceCategory{
	background-color:#d9edf7;
}*/
.duodong{
	color: red;
    font-size: 12px;
    display: block;
    font-weight: 500;
    text-align: center;
    line-height: 51px;
    }
ul,li,ol{list-style:none; margin:0 !important;}


/*.background-blue{height:45px;}
.background-blue>li>a{padding: 8px 15px 7px;}
.background-blue>li>a:focus{padding: 10px 15px;}
.background-blue>li>a:hover{background:#7db4d8;}
.background-blue>li.active>a{padding:10px 15px 11px;}*/
</style>
<script type="text/javascript">
var indent = "";
$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [{field:'',title:'Id号',checkbox:'true',width:100,align:'center'},
	              {field:'caozuo',title:'操作',align:'center',width:100,formatter: function(value,row,index){
			           return "<a href=\"javascript:void(0)\" onclick=\"addAdJob('"+index+"')\" ><i class='icon-cog' title='设为广告'></i></a>";
					}
				 },
                   {field:'CCA113',title:'职位名称',width:240,align:'center'},
                   {field:'AAB004',title:'公司名称',width:250,align:'center'},
                   {field:'AAC011',title:'学历要求',width:130,align:'center'},
                   {field:'ACC217',title:'工作年限要求',width:80,align:'center'},
                   {field:'ACC034',title:'月工资待遇',width:110,align:'center'}
                   
  	        	];
	$('#jobList').bootstrapTable({
	    //url:'${ctx}/business/advert/adCompany/listNoAd.xf?indent=11',
		columns: columns,
	    method:"post",
	    contentType:"application/x-www-form-urlencoded",
		pagination:true,
		pageSize:10,
		pageList:[10, 15, 20],
	    clickToSelect:true,
	    sidePagination:"server",
	    striped:true
	});
	var columnsJobAd= [{field:'',title:'',checkbox:'true',width:100,align:'center'},{field:'caozuo',align:'center',title:'操作',width:100,formatter: function(value,row,index){
        return "<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"delAdJob('"+index+"')\" ><i class='icon-remove-circle' title='解除广告'></i></a>"+
		"<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"editAdJob('"+index+"')\" ><i class='icon-pencil' title='编辑'></i></a>";
	}
},
	                   {field:'CAAC02',title:'广告类别',width:100,align:'center'},
	                   {field:'CCA113',title:'职位名称',width:240,align:'center'},
	                   {field:'AAB004',title:'公司名称',width:250,align:'center'},
	                   {field:'AAE036',title:'广告创建时间',width:100,align:'center'},
	                   {field:'AAE019',title:'广告经办人',width:100,align:'center'}
	                  // {field:'CAAE10',title:'状态',width:100,align:'center',
	                	//   formatter: function(value,row,index){
	                		 //  if(value==1){
	                			  // return "正常";
	                		  // }else if(value==2){
	                			   //return "隐藏";
	                		   //}else{
	                			  // return "结束";
	                		   //}
	                	  // }
	                  // },
// 	                {field:'CAAE12',title:'排序',width:100,align:'center',hidden:true},
	                
      	        	];
	$('#adJobList').bootstrapTable({
	    columns:columnsJobAd,
	    method:"post",
	    contentType:"application/x-www-form-urlencoded",
// 		pagination:true,
// 		pageSize:10,
// 		pageList:[10, 15, 20],
	    //sidePagination:"server",
	    reorderableRows:true,
        useRowAttrFunc:true,
	    clickToSelect:true,
	   // sidePagination:"server",
	    striped:true,
	    onReorderRowsDrop:function(){
        	var rowsArray = $("#adJobList").bootstrapTable('getData');
    		sortrowNum(rowsArray);
		}
// 		onDrop:function(targetRow,sourceRow,point){//拖拽结束
// 			var rowsArray = $(this).bootstrapTable('getRows');
// 			sortrowNum(rowsArray);
// 		}
	});
	//左边选框
	var websitCategoryUrl = "${ctx}/business/advert/adCategory/nameList.xf";
	$.post(websitCategoryUrl,{"flag":3},function(data){
		var content ="";
		for(var i=0;i<data.length;i++){
			if(i==0){
				indent = data[i].INDENT;
				content+="<li class='channel choiceCategory' data-name="+data[i].CAAC02+" data-value="+data[i].CAAC01+" data-val="+data[i].INDENT+" onclick='getLeftData(this)'><a href='javascript:void(0)'>"+data[i].CAAC02+"</a></li>";
			}else{
				content+="<li class='channel' data-name="+data[i].CAAC02+" data-value="+data[i].CAAC01+" data-val="+data[i].INDENT+" onclick='getLeftData(this)'><a href='javascript:void(0)'>"+data[i].CAAC02+"</a></li>";
			}
		}
		$("#adCategoryList").append(content);
		$('#jobList').bootstrapTable("refresh",{url:'${ctx}/business/advert/adCompany/listNoAdJob.xf?indent='+data[0].INDENT});
		$('#adJobList').bootstrapTable("refresh",{url:'${ctx}/business/advert/adCompany/listAdJob.xf?indent='+data[0].INDENT});
	});

})
function getLeftData(obj){
	var jobj = $(obj);
	$("#adCategoryList").children().removeClass("choiceCategory");
	jobj.addClass("choiceCategory");
	var indentobj = jobj.attr("data-val");
	if(!indentobj){
		var firstLi =$("#adCategoryList").children().first();
		indentobj = firstLi.attr("data-val");
		if(!indent){
			bootbox.alert("param is not correct");
			return;
		}
	}
	indent = indentobj;
	refresh();
	//$('#jobList').bootstrapTable({url:'${ctx}/business/advert/adCompany/listNoAd.xf?indent='+indent});
	//$('#adJobList').bootstrapTable({url:'${ctx}/business/advert/adCompany/listAdJob.xf?indent='+indent});
}
function addAdJob(index){
	 var choiceObject = $(".choiceCategory");
// 	 $('#jobList').bootstrapTable("check",index);
debugger;
      $('#jobList').bootstrapTable("check",index);
	 var row =  $('#jobList').bootstrapTable("getAllSelections");
	 if(!choiceObject||!row ){
		 bootbox.alert("error");
		   return;
	   }
	   var id = choiceObject.attr("data-value");
	   var name = choiceObject.attr("data-name");
	   var comid = row[0].AAB001;
	   var comname = row[0].AAB004;
	   var jobid = row[0].ACB210;
	   var jobname = row[0].CCA113;
	   if(!id || !name || !comid || !comname){
		   bootbox.alert("error");
		   return;
	   }
		xfui.open_dialog({
		    title: '新增广告位放置',
		    width: 800,
		    height: 420,
		    closed: false,
		    cache: false,
		    url: "${ctx}/business/advert/adCompany/addJob.xf?caid="+id+"&caname="+encodeURI(encodeURI(name))+
		    		"&comid="+comid+"&comname="+encodeURI(encodeURI(comname))+
		    		"&jobid="+jobid+"&jobname="+encodeURI(encodeURI(jobname)),
		    modal: true
		})
}
function editAdJob(index){
	 var choiceObject = $(".choiceCategory");
	 if(!choiceObject){
		 bootbox.alert("error");
		   return;
	   }
    var caname = choiceObject.attr("data-name");
    if (!caname ){
    	bootbox.alert("error");
	   return;
    }
 	$('#adJobList').bootstrapTable("check",index);
	var row =  $('#adJobList').bootstrapTable("getAllSelections");
	if(row){
		var caae01=row[0].CAAE01;//信息id
		var comname = row[0].AAB004;//公司名称
		var jobname = row[0].CCA113;//职位
		//xfui.open_tabs("编辑人员","${ctx}/sys/uums/sysUser/edit.xf?acd230="+acd230,"人员管理");
		xfui.open_dialog({
	  		    title: '编辑广告位放置',
	  		    width: 800,
	  		    height: 420,
	  		    closed: false,
	  		    cache: false,
	  		    url: "${ctx}/business/advert/adCompany/editJob.xf?caae01="+caae01+"&caname="+encodeURI(encodeURI(caname))+"&comname="+encodeURI(encodeURI(comname))
	  		    		+"&jobname="+encodeURI(encodeURI(jobname)),
	  		    modal: true
	  		})
	}else{
		bootbox.alert('请选择记录');
	}
}

function delAdJob(index){
 	$('#adJobList').bootstrapTable("check",index);
	var row =  $('#adJobList').bootstrapTable("getAllSelections");
	if(row){
		var caae01 = row[0].CAAE01;
		bootbox.confirm({message:'您确认想要解除此条广告吗？',callback:function(r){
		    if (r){
		    	$.ajax({ url: '${ctx}/business/advert/adCompany/del.xf',
		    		data:{caae01:caae01},
		    		dataType:'json',
		    		success: function(data){
		    			if(data.message){
		    				bootbox.alert(data.message);
		    				refresh();
		    			}else{
		    				bootbox.alert("未知错误");
		    			}

		             }
		    	});
		    }
		}
		});
	  }else{
		 bootbox.alert('请选择记录');
	 }
}
function sortrowNum(rowsArray){
	if(!rowsArray || rowsArray.length<=0){
		return;
	}else{
		var id =[];
		for(var i = 0;i<rowsArray.length;i++){
			id.push(rowsArray[i].CAAE01);
		}
		if(id.length>0){
			var url = "${ctx}/business/advert/adCompany/sortOrderNum.xf";
			$.post(url,{id:id.join(",")},function(data){
				if(data.result == 1){
					//成功不提示
				}else{
					bootbox.alert('操作失败了');
				}
			});
		}
	}
}
function refresh(){
	$('#jobList').bootstrapTable("refresh",{url:'${ctx}/business/advert/adCompany/listNoAdJob.xf?indent='+indent});
	$('#adJobList').bootstrapTable("refresh",{url:'${ctx}/business/advert/adCompany/listAdJob.xf?indent='+indent});
}
function doSearch(){
	var json=$("#searchFormJob").serializeJson();
	$("#jobList").bootstrapTable("refresh",{query:json});
}
function doClearSearchValue(){
	$("input[name='aab004']").val("");
	$("#jobList").bootstrapTable("refresh");
}
</script>
</head>
<body class="h100p">
<div class="container-fluid h100p">
	<div class="row h100p">
		<!-- 左侧目录 -->
		<div class="col-md-2 col-xs-3 moduleWrap pd0 h100p">
			<div class="moduleTit">广告分类</div>
			<ul id="adCategoryList" class="moduleCont"></ul>
		</div>

		<!-- 右侧详细内容 -->
		<div class="col-md-10 col-xs-9 h100p colRight">

			<!-- tab选项卡 -->
			<div class="tabable">
				<ul class="nav nav-tabs padding-12 tab-color-blue background-blue" id="navrightTop">
					<li class="active"><a data-toggle="tab" href="#companyList">职位列表</a></li>
					<li><a data-toggle="tab" href="#adCompanyCateList">广告管理</a></li>
				</ul>

				<div class="tab-content" id="tabContent">
					<div class="tab-pane in active" id="companyList">
						<!-- 查询条件 -->
						<div class="moduleWrapNobg">
					 		<div class="moduleTit">查询条件</div>
					 		<div class="moduleCont">
								<form id="searchFormJob">
									<div class="row">
							
											
											<div class="col-xs-1 col-sm-4"></div>
												<div class="col-sm-6 col-xs-6 mgb20">
													<label class="col-xs-2 col-sm-4" >企业名称:  </label>
													<div class="col-xs-10 col-sm-8">
													<input class="form-control" type="text" name="aab004" placeholder="企业名称" title="企业名称" data-placement="bottom" />
													</div>
													
												</div>
												<div class="col-sm-2 col-xs-2">
													<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
													<!-- <a href="#modal-form" role="button" class="btn" onclick="doClearSearchValue();">重置</a> -->
													<!-- <a href="#modal-form" role="button" onclick="doClearSearchValue();" class="btn btn-info" ><i class="icon-repeat"></i>重置</a> -->
												</div>
									</div>
									
									
								</form>
							</div>
						</div>

						<!-- 查询结果 -->
						<div class="moduleWrapNob">
							<div class="moduleTit"> 查询结果 </div>
							<div class="moduleCont">
								<div class="row">
									<div class="col-xs-12">
										<table id="jobList" ></table>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="tab-pane" id="adCompanyCateList">
						<div class="moduleWrapNob">
                			<div class="moduleTit">公司广告</div>
            				<div class="moduleCont">
            					<span class="duodong">注：拖动行可以进行排序</span>
            					<div class="row">
									<div class="col-xs-12">
										<table id="adJobList" ></table>
									</div>
								</div>
							</div>
            			</div>
            		</div>
				</div><!-- /tab-content-->
			</div>
		</div>
	</div>
</div>
</body>
</html>

