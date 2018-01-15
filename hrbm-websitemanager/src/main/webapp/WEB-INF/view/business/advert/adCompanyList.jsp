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
ul,li{list-style: none; margin: 0; padding: 0;}
#adCategoryList{
	list-style:none;
	padding:0px;
	margin: 0;
	text-align: center;
}
ul,li,ol{list-style:none; margin:0 !important;}
.duodong{
	color: red;
    font-size: 12px;
    display: block;
    font-weight: 500;
    text-align: center;
    line-height: 51px;
    }

/* .bg_bigBack {
     position: fixed;
     top: 0;
     bottom: 0;
     left: 0;
     right: 0;
     background-color: rgba(0,0,0,0.8);
     z-index: 100;
    }

.imgbig_div {
  	  position: absolute;
      left: 50%;
      top: 50%;
      -webkit-transform: translate(-50%,-50%);
      transform: translate(-50%,-50%);
      z-index: 1000;
    }
.bigImg .close{
       display:block;
       width:64px;height:64px;
       background: url(${ctx}/img/cl_01.png) no-repeat center center;
       position:fixed;top:15px;right:15px;
       z-index:1000;
    } */
</style>
<script type="text/javascript">
var indent = "";
$(function(){
	/**
	 初始化表格显示
	*/
	var columns = [{field:'',title:'Id号',checkbox:'true',width:100,align:'center'}, {field:'caozuo',align:'center',title:'操作',width:100,formatter: function(value,row,index){
        return "<a href=\"javascript:void(0)\" onclick=\"addAdCompany('"+index+"')\" ><i class=\"icon-cog\" title=\"设为广告\"></i></a>";

	}
 },
                   {field:'aab004',title:'企业名称',width:230,align:'center'},
                   {field:'aab019',title:'企业性质',width:90,align:'center'},
                   {field:'aab022',title:'行业类型',width:130,align:'center'},
                   {field:'aae036',title:'经办日期',width:110,align:'center',formatter:function(value,row,index){return formateDate(value);}},
                   {field:'aae004',title:'联系人姓名',width:80,align:'center'},
                   {field:'aae005',title:'联系电话',width:110,align:'center'}
                  
  	        	];
	$('#adCompanyList').bootstrapTable({
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
	var columnsCompanyAd= [{field:'',title:'Id号',checkbox:'true',width:30,align:'center'},
	  	                 {field:'caozuo',align:'center',title:'操作',width:100,formatter: function(value,row,index){
					           return "<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"delAdCompany('"+index+"')\" ><i class=' icon-remove-circle' title='解除广告'></i></a>"+
									"<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"editAdCompany('"+index+"')\" ><i class='icon-pencil' title='编辑'></i></a>";
								}
						 },
	                   {field:'AAB004',title:'公司名称',width:240,align:'center'},
	                   {field:'CAAC02',title:'广告类别',width:120,align:'center'},
	                   {field:'AAE036',title:'广告创建时间',width:100,align:'center'},
	                   {field:'AAE019',title:'广告经办人',width:100,align:'center'},
	                   {field:'CAAE03',title:'图片缩略图',width:100,align:'center',
	                	   formatter: function(value,row,index){
	                		   if(!value){
									return "暂未上传图片";
	                		   }else{
									return "<img max-width='120' height='30' src=${fileDirectory}/"+value+"' onclick='clickImg(this)'/>";
	                		   }
	                	   }
	                   },
	                 {field:'CAAD14',title:'点击次数',width:100,align:'center'}
      	        	];
	$('#adCompanyCategoryList').bootstrapTable({
	    columns:columnsCompanyAd,
	    method:"post",
	    contentType:"application/x-www-form-urlencoded",
// 		pagination:true,
// 		pageSize:10,
// 		pageList:[10, 15, 20],
	    clickToSelect:true,
	    //sidePagination:"server",
	    reorderableRows:true,
        useRowAttrFunc:true,
	    striped:true,
	    onReorderRowsDrop:function(){
        	var rowsArray = $("#adCompanyCategoryList").bootstrapTable('getData');
    		sortrowNum(rowsArray);
		}
// 		onDrop:function(targetRow,sourceRow,point){//拖拽结束
// 			var rowsArray = $(this).datagrid('getRows');
// 			sortrowNum(rowsArray);
// 		}
	});

	/**
	   左边广告分类数据
	**/
	var websitCategoryUrl = "${ctx}/business/advert/adCategory/nameList.xf";
	$.post(websitCategoryUrl,{"flag":2},function(data){
		var content ="";
		for(var i=0;i<data.length;i++){
			if(i==0){
				indent = data[i].INDENT;
				content+="<li class='choiceCategory channel' data-name="+data[i].CAAC02+" data-value="+data[i].CAAC01+" data-val="+data[i].INDENT+" onclick='getLeftData(this)'><a href='javascript:void(0)'>"+data[i].CAAC02+"</a></li>";
			}else{
				content+="<li class='channel' data-name="+data[i].CAAC02+" data-value="+data[i].CAAC01+" data-val="+data[i].INDENT+" onclick='getLeftData(this)'><a href='javascript:void(0)'>"+data[i].CAAC02+"</a></li>";
			}
		}
		$("#adCategoryList").append(content);
		refresh();
	});

})

/**
       点击左边广告分类刷新右边数据
**/
function getLeftData(obj){
	var jobj = $(obj);
	$("#adCategoryList").children().removeClass("choiceCategory");
	jobj.addClass("choiceCategory");
	var indentobj = jobj.attr("data-val");
	if(!indentobj){
		var firstLi =$("#adCategoryList").children().first();
		indentobj = firstLi.attr("data-val");
		if(!indentobj){
			bootbox.alert('param is not correct');
			return;
		}
	}
	indent = indentobj;
	refresh();
}

/**
 * 为公司添加广告  弹出添加页面
 * 携带数据 广告分类id,分类名称 公司id，公司名称
 */
function addAdCompany(index){
	 var choiceObject = $(".choiceCategory");
	 $('#adCompanyList').bootstrapTable("check",index);
	 var row =  $('#adCompanyList').bootstrapTable("getAllSelections");
	 if(!choiceObject||!row||row.length<=0){
		  bootbox.alert("error");
		   return;
	   }
	 var id = choiceObject.attr("data-value");
	 var name = choiceObject.attr("data-name");
	 var comid = row[0].aab001;
	 var comname = row[0].aab004;
	 if(!id || !name || !comid || !comname){
		   bootbox.alert("error");
		   return;
	 }
	xfui.open_dialog({
		    title: '添加广告',
		    width: 800,
		    height: 600,
		    closed: false,
		    cache: false,
		    url: "${ctx}/business/advert/adCompany/add.xf?caid="+id+"&caname="+encodeURI(encodeURI(name))+"&comid="+comid+"&comname="+encodeURI(encodeURI(comname)),
		    modal: true
	});
}

/**
 *编辑广告
 */
function editAdCompany(index){
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
	$('#adCompanyCategoryList').bootstrapTable("check",index);
	var row =  $('#adCompanyCategoryList').bootstrapTable("getAllSelections");
	if(row&&row.length>0){
		var caae01=row[0].CAAE01;//信息id
		var comname = row[0].AAB004;//公司名称
		xfui.open_dialog({
	  		    title: '编辑广告',
	  		    width: 800,
	  		    height: 700,
	  		    closed: false,
	  		    cache: false,
	  		    url: "${ctx}/business/advert/adCompany/edit.xf?caae01="+caae01+"&caname="+encodeURI(encodeURI(caname))+"&comname="+encodeURI(encodeURI(comname)),
	  		    modal: true
	  		})
	}else{
		bootbox.alert('请选择记录');
	}
}

/**
 * 删除广告
 */
function delAdCompany(index){
	$('#adCompanyCategoryList').bootstrapTable("check",index);
	var row =  $('#adCompanyCategoryList').bootstrapTable("getAllSelections");
	if(row&&row.length>0){
		var caae01 = row[0].CAAE01;
		bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){
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
		}});
	  }else{
		 bootbox.alert('请选择记录');
	 }
}
/**
 * 为添加广告的公司排序
 */
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
	$('#adCompanyList').bootstrapTable("refresh",{url:'${ctx}/business/advert/adCompany/listNoAdCompany.xf?indent='+indent});
	$('#adCompanyCategoryList').bootstrapTable("refresh",{url:'${ctx}/business/advert/adCompany/listAdCompany.xf?indent='+indent});
}
function doSearch(){
	var json=$("#searchFormCompany").serializeJson();
	$("#adCompanyList").bootstrapTable("refresh",{query:json});
}
function doClearSearchValue(){
	$("input[name='aab004']").val("");
	$('#adCompanyList').bootstrapTable("refresh");
}
function clickImg(_this) {
    var _thisImg = $(_this).attr("src");
    $(".imgbig_div img").attr("src",_thisImg);
    $(".bigImg").show();

}

function closeBg() {
    $(".bigImg").hide();
}
</script>
</head>
<body class="h100p">
<div class='bigImg' style='display:none'>

   <div class='bg_bigBack' onclick='closeBg()'></div>
   <div class='imgbig_div'>
      <span class='closeimg' onclick='closeBg()'></span>
      <img src='' />
   </div>
</div>
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
					<li class="active"><a data-toggle="tab" href="#companyList">公司列表</a></li>
					<li><a data-toggle="tab" href="#adCompanyCateList">广告管理</a></li>
				</ul>

				<div class="tab-content">
					<div class="tab-pane in active" id="companyList">
						<!-- 查询条件 -->
						<div class="moduleWrapNobg">
					 		<div class="moduleTit">查询条件</div>
					 		<div class="moduleCont">
								<form id="searchFormCompany">
									<div class="row">
									<div class="col-xs-1 col-sm-4"></div>
										
										<div class="col-xs-6 col-sm-6">
											<label class="col-xs-2 col-sm-4"> 企业名称: </label>
												<div class="col-sm-8 col-xs-10 mgb20">
													<input class="form-control" type="text" name="aab004" placeholder="企业名称" title="企业名称" data-placement="bottom" />
												</div>
							
										
										</div>
															<div class="col-xs-2 col-sm-2">
													<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary  btn-border1" ><i class="icon-search"></i>查询</a>
													<!-- <a href="#modal-form" role="button" onclick="doClearSearchValue();" class="btn btn-info" ><i class="icon-repeat"></i>重置</a> -->
												</div>
									</div>
								</form>
							</div>
						</div>

						<!-- 查询结果 -->
						<div class="moduleWrapNob">
							<div class="moduleTit"> 查询结果 </div>
							<div class="moduleCont" style="margin:0">
								<div class="row">
									<div class="col-xs-12">
										<table id="adCompanyList"></table>
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
										<table id="adCompanyCategoryList"></table>
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
</div>
</body>

</html>

