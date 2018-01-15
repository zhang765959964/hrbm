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
<script type="text/javascript">
var cczy06='${cczy06}';
$(function() {
	/**
	 初始化表格显示
	 */
	initTable();
	disableButton();
})
function initTable() {
	var columns= [[{field:'',title:'',checkbox:'true',width:100,align:'center'},
	               {field:'aac0d0',title:'序号',rownumbers:'true',formatter:function(value, row, index) {return index+1;}}, 
                   {field:'aac045',title:'毕业院校'},
                   {field:'aac0d2',width:80,title:'学校性质'},
                   {field:'aac0d3',title:'培养方式'},
                   {field:'aac046',title:'毕（肄）业时间',formatter:function(value,row,index){return formateDate(value);}},
                   {field:'aac0d5',title:'毕业证书（认证）编号'},
                   {field:'aac0d6name',title:'学制'},
                   {field:'atc011',title:'学历'},
                   {field:'aac037',title:'学位'},
                   {field:'acc01g',title:'所学专业'},
                   {field:'aac0d4',title:'专业描述'},
                   {field:'atc01g',title:'第二专业'}, 
                   {field:'aac038',title:'所学外语'},
                   {field:'aac039',title:'外语水平'},
                   {field:'aac041',title:'第二外语'},
                   {field:'aac042',title:'二外水平'}, 
                   {field:'aac0d7',title:'其他外语'},
                   {field:'aac043',title:'计算机水平'},
                   {field:'aac0d1',title:'学习经历'},
                   {field:'aae013',title:'备注'}
  	        	]];
			$('#personEducationList').bootstrapTable({
				url : '${ctx}/business/person/personEducation/listJson.xf?aac001=${aac001}',
				columns: columns,
			    method:"post",
			    contentType:"application/x-www-form-urlencoded",
				pagination:true,
				pageSize:10,
				pageList:[10, 15, 20],
			    clickToSelect:true,
			    sidePagination:"server",
			    singleSelect: true,
			    striped:true
			});
}
function addEducation(){
	xfui.open_dialog({    
	    title: '新增个人教育背景表',    
	    width: 900,    
	    height: 500,    
	    closed: false,    
	    cache: false,    
	    url: "${ctx}/business/person/personEducation/add.xf?aac001=${aac001}",
	    modal: true   
	})
 }
function editPersonEducation(){
	var row = $('#personEducationList').bootstrapTable('getAllSelections');
	if(row&&row.length>0){
		var aac0d0=row[0].aac0d0;
		xfui.open_dialog({    
	  		    title: '编辑个人教育背景',    
	  		    width: 900,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: "${ctx}/business/person/personEducation/edit.xf?aac0d0="+aac0d0,
	  		    modal: true   
	  		})
	}else{
		bootbox.alert('请选择记录');
	}			
} 
function delPersonEducation(){
	var row = $('#personEducationList').bootstrapTable('getAllSelections');
	if(row&&row.length>0){
		var aac0d0="";
		$.each(row,function(i,e){
			if(i==0){
				aac0d0+=e.aac0d0;
			}else{
				aac0d0+=","+e.aac0d0;
			}
			
		});
		bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
		    if (r){    
		    	$.ajax({ url: '${ctx}/business/person/personEducation/del.xf',
		    		data:{aac0d0:aac0d0},
		    		dataType:'json',
		    		success: function(data){
		    			if(data.message){
		    				bootbox.alert(data.message); 	
		    			}else{
		    				bootbox.alert("未知错误"); 
		    			}
		    			
		    			refresh();
		             }
		    	});
		    }    
		}}); 
	  }else{
		 bootbox.alert('请选择记录');
	 }			
} 

function refresh(){
	$('#personEducationList').bootstrapTable('refresh');
}
//返回基本信息页面
function personSelect(){
	window.location.href = "${ctx}/business/person/personBaseInfo/edit.xf?aac001=${aac001}&cczy06="+cczy06;
 } 
//跳转到工作经历页面
function workExpceSelect(){
	window.location.href = "${ctx}/business/person/personBaseInfo/selectWorkExpce.xf?aac001=${aac001}&cczy06="+cczy06;
 }
function personJobRegist(){
	window.location.href = "${ctx}/business/person/personJobRegist/edit.xf?aac001=${aac001}&cczy06="+cczy06;
 } 
function disableButton(){
	 var aac001='${aac001}';
	 if(aac001){
		 if(!hasEditPermi(aac001,1)){
			 $(".btn-primary").attr("disabled","disabled");
			 $(".btn-primary").attr("title","无编辑权限");
		 }
	 }

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
									<a href="javascript:void(0)" class="btn btn-primary btn-border1" style="margin-top: -5px;" onClick="Idcard()" data-options="iconCls:'icon-print'">
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
		   					<li onclick="personJobRegist()">求职登记</li>
		   					<li class="active">教育背景</li>
		   					<li onclick="workExpceSelect()">工作经历</li>
		   				</ul>
		   				<div class="mhyEducationInfo1">
			   				<table id="personEducationList" class="datagridClass tableClassNoworks" ></table>
	   					</div>
	   						
	   					
	   			</div>
	   			<div> </div>
	   </div>
	 </div>	
</div>
<div class="bottomBtn">
				   					<div class="h50">&nbsp;</div>
				   					<div class="floatBtn">
<!-- 				   					<a class="btn btn-primary mhyBtnLeft" role="button" onclick="addEducation()"> -->
<!-- 				   					<i class="icon-plus"></i> -->
<!-- 				   					新增 -->
<!-- 				   					</a> -->
				   					<button type="button" class="btn btn-primary"  onclick="addEducation()">新增</button>
				   					<button type="button" class="btn btn-primary" onclick="editPersonEducation()">修改</button>
				   					<button type="button" class="btn btn-primary"  onclick="delPersonEducation()">刪除</button>
			   					</div>
			   			</div>
<script>
	$(function(){
		$("#personTab li").click(function(){
			var _this=this;
			$("#personTab li").removeClass("active")&&$(_this).addClass("active");;
			
		});
	
	$("[data-toggle='popover']").popover();
	})
</script>
  	
</body>

</html>
