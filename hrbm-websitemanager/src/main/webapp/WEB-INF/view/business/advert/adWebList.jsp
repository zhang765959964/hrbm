<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="h100p">
<head>
<title>广告位内容表管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />


<link rel="stylesheet" href="${ctx}/js/lib/bootstrap-table-rows/bootstrap-table-reorder-rows.css" type="text/css">
<script type="text/javascript" src="${ctx}/js/lib/bootstrap-table-rows/bootstrap-table-reorder-rows.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/bootstrap-table-rows/jquery.tablednd.js"></script>
<link rel="stylesheet" href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css" type="text/css">
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/jquery/bootstrap-contextmenu.js"></script>
<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />
<style type="text/css">
ul,li{list-style: none; margin: 0; padding: 0;}
#adCategoryList{
	list-style:none;
	margin: 0;
	padding:0px;
	text-align: center;
}
.duodong{color: red;
    font-size: 12px;
    display: block;
    font-weight: 500;

    text-align: center;

    line-height: 51px;}


</style>
<script>
$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [{field:'',title:'Id号',checkbox:'true',width:30,align:'center'},
                  {field:'CAAD01',title:'操作',width:100,align:'center',formatter:function(value,row,index){
			           return "<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"editAdWeb('"+index+"')\" ><i class='icon-pencil' title='编辑'></i></a>"+
							"<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"delAdWeb('"+index+"')\" ><i class='icon-trash' title='删除'></i></a>";
				   }
				 },
	                   //{field:'CAAC01',title:'类别编号',width:100,align:'center',hidden:true},
	                   {field:'CAAD02',title:'广告描述',width:300,align:'center'},
	                   {field:'CAAD16',title:'创建时间',width:100,align:'center'},
// 	                   {field:'CAAD03',title:'上传图片或Flash地址',width:100,align:'center'},
// 	                   {field:'CAAD12',title:'指向地址',width:100,align:'center'},
// 	                   {field:'CAAD04',title:'广告位宽度(px)',width:100,align:'center'},
// 	                   {field:'CAAD05',title:'广告位高度(px)',width:100,align:'center'},
	                   {field:'CAAD03',title:'上传图片缩略图',width:100,align:'center',
	                	   formatter: function(value,row,index){
	                		   if(!value){
									return "暂未上传图片";
	                		   }else{
									return  "<img max-width='160' height='30' src=${fileDirectory}/"+value+"' onclick='clickImg(this)'/>";
								
	                		   }
	                	   }
	                   },
	                   {field:'CAAD06',title:'是否显示',width:100,align:'center',
	                	   formatter: function(value,row,index){
	                		   if(value ==1){
									return "显示";
	                		   }else{
									return "隐藏";
	                		   }
	                	   }
	                   },
	                   {field:'CAAD14',title:'点击次数',width:50,align:'center',hidden:true}
      	        	];
	$('#adWebList').bootstrapTable({
	    //url:'${ctx}/business/advert/adWeb/listJson.xf',
		columns: columns,
	    method:"post",
	    contentType:"application/x-www-form-urlencoded",
		pagination:false,
		pageSize:100,
		pageList:[10, 15, 20],
	    clickToSelect:true,
	    sidePagination:"server",
	    reorderableRows:true,
        useRowAttrFunc:true,
	    striped:true,
	    onReorderRowsDrop:function(){
        	var rowsArray = $("#adWebList").bootstrapTable('getData');
    		sortrowNum(rowsArray);
		}
	});
	//左边选框
	var websitCategoryUrl = "${ctx}/business/advert/adCategory/nameList.xf";
	$.post(websitCategoryUrl,{"flag":1},function(data){
		var content ="";
		for(var i=0;i<data.length;i++){
			if(i==0){
				content+="<li class='channel choiceCategory' data-name="+data[i].CAAC02+" data-value="+data[i].CAAC01+" data-val="+data[i].INDENT+" onclick='getLeftData(this)'><a href='javascript:void(0)'>"+data[i].CAAC02+"</a></li>";
			}else{
				content+="<li class='channel' data-name="+data[i].CAAC02+" data-value="+data[i].CAAC01+" data-val="+data[i].INDENT+" onclick='getLeftData(this)'><a href='javascript:void(0)'>"+data[i].CAAC02+"</a></li>";
			}
		}
		$("#adCategoryList").append(content);
		$('#adWebList').bootstrapTable("refresh",{url:'${ctx}/business/advert/adWeb/listJson.xf?indent='+data[0].INDENT});
	});

});

function getLeftData(obj){
	var jobj = $(obj);
	$("#adCategoryList").children().removeClass("choiceCategory");
	jobj.addClass("choiceCategory");
	var indent = jobj.attr("data-val");
	if(!indent){
		var firstLi =$("#adCategoryList").children().first();
		indent = firstLi.attr("data-val");
		if(!indent){
			bootbox.alert("param is not correct");
			return;
		}
	}
	$('#adWebList').bootstrapTable("refresh",{url:'${ctx}/business/advert/adWeb/listJson.xf?indent='+indent});
}
function addAdWeb(){
	   var choiceObject = $(".choiceCategory");
	   if(!choiceObject){
		   bootbox.alert("error");
		   return;
	   }
	   var id = choiceObject.attr("data-value");
	   var name = choiceObject.attr("data-name");
	   if(!id || !name){
		   bootbox.alert("param is not correct");
		   return;
	   }
		xfui.open_dialog({
		    title: '新增广告位内容',
		    width: 800,
		    height: 570,
		    closed: false,
		    cache: false,
		    url: "${ctx}/business/advert/adWeb/add.xf?caac01="+id,
		    modal: true
		})
}
function editAdWeb(index){
	 var choiceObject = $(".choiceCategory");
	 if(!choiceObject){
		 bootbox.alert("error");
		 return;
	 }
	 var name = choiceObject.attr("data-name");
	 if(!name){
		 bootbox.alert("error");
		  return;
	 }
	 if(index){

		$('#adWebList').bootstrapTable("check",index);
	 }
	var row = $('#adWebList').bootstrapTable('getAllSelections');
	if(row&&row.length>0){
		var caad01=row[0].CAAD01;
		//xfui.open_tabs("编辑人员","${ctx}/sys/uums/sysUser/edit.xf?acd230="+acd230,"人员管理");
		xfui.open_dialog({
	  		    title: '编辑广告位内容',
	  		    width: 800,
	  		    height: 550,
	  		    closed: false,
	  		    cache: false,
	  		    url: "${ctx}/business/advert/adWeb/edit.xf?caad01="+caad01+"&caac02="+encodeURI(encodeURI(name)),
	  		    modal: true
	  		})
	}else{
		bootbox.alert('请选择记录');
	}
}

function delAdWeb(index){
	var caad01="";
	if(index){
		 $('#adWebList').bootstrapTable("check",index);
	 }
	 var row = $('#adWebList').bootstrapTable('getAllSelections');
	 if(row&&row.length>0){

		$.each(row,function(i,e){
			if(i==0){
				caad01+=e.CAAD01;
			}else{
				caad01+=","+e.CAAD01;
			}
		});
	 }else{
		 bootbox.alert('请选择记录');
		 return;
	}
	bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){
	    if (r){
	    	$.ajax({ url: '${ctx}/business/advert/adWeb/del.xf',
	    		data:{caad01:caad01},
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
  }
function refresh(){
	$('#adWebList').bootstrapTable('refresh');
}
function doSearch(){

	var json=$("#searchForm").serializeJson();

	$("#adWebList").bootstrapTable("refresh",{query:json});
}
function doClear(){
	$("#caad02").val("");
	$("#adWebList").bootstrapTable("refresh");
}
function sortrowNum(rowsArray){
	if(!rowsArray || rowsArray.length<=0){
		return;
	}else{
		var id =[];
		for(var i = 0;i<rowsArray.length;i++){
			id.push(rowsArray[i].CAAD01);
		}
		if(id.length>0){
			var url = "${ctx}/business/advert/adWeb/sortOrderNum.xf";
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
<!-- 图片放大div start -->
<div class='bigImg' style='display:none'>

  <div class='bg_bigBack' onclick='closeBg()'></div>
   <div class='imgbig_div'>
     <span class='closeimg' onclick='closeBg()'></span>
       <img src='' />
   </div>
</div>
<!-- 图片放大div end -->
<div class="container-fluid h100p">
	<div class="row h100p">
		<!-- 左侧目录 -->
		<div class="col-md-2 col-xs-3 moduleWrap pd0 h100p">
			<div class="moduleTit">广告分类</div>
			<ul id="adCategoryList" class="moduleCont"></ul>
		</div>
		<!-- 右侧详细内容 -->
		<div class="col-md-10 col-xs-9 h100p colRight">
		 	<div class="moduleWrapNobg">
		 		<div class="moduleTit">查询条件</div>
		 		<div class="moduleCont">
					<form id="searchForm">
						<div class="row">
					
							<div class="col-xs-1 col-sm-4"></div>
							<div class="col-sm-6 col-xs-6 mgb20">
							
								<label class="col-xs-2 col-sm-4" for="inputError">广告描述:  </label>
								<div class="col-xs-10 col-sm-8">
									<input class="form-control" type="text" id="caad02" name="caad02" placeholder="广告描述" title="广告描述" data-placement="bottom" />
								</div>
							</div>
							<div class="col-sm-2 col-xs-2">
								<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
								<!-- <a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-zoom-in"></i>查询</a> -->
							</div>
							
						</div>
					</form>
				</div>
			</div>
			<!-- 结果列表 -->
			<div class="moduleWrapNob">
				<div class="moduleTit"> 查询结果 </div>
				<!-- <div class="moduleCont"> -->
				<div>
					<div class="mgy10" style="float: left;">
						<a href="javascript:void(0)" onclick="addAdWeb()" role="button" class="btn btn-primary mhyBtnLeft" data-toggle="modal"><i class="icon-plus"></i>添加</a>
						<a href="javascript:void(0)" onclick="editAdWeb()" role="button" class="btn btn-info mhyBtnLeft" data-toggle="modal"><i class="icon-pencil"></i>修改</a>
						<a href="javascript:void(0)" role="button" onclick="delAdWeb()" class="btn btn-danger" data-toggle="modal"><i class="icon-trash"></i>删除</a>
						<!-- <a href="javascript:void(0)" onclick="addArticle()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus"></i>新增</a>
						<a href="javascript:void(0)" onclick="editArticle()" role="button" class="btn btn-info" data-toggle="modal"><i class="icon-pencil"></i>编辑</a>
						<a href="javascript:void(0)" role="button" onclick="delArticle()" class="btn btn-danger" data-toggle="modal"><i class="icon-trash"></i>删除</a> -->
						
					</div>
					<span class="duodong">注：拖动行可以进行排序</span>
					<div class="row">
						<div class="col-xs-12">
							<table id="adWebList" ></table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

</body>

</html>


