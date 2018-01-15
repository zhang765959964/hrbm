<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>个人工作经历表管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<%@include file="/commons/include/bootstrapInc.jsp" %>
<script>
var cczy06='${cczy06}';
$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [ {field:'',title:'',checkbox:'true',width:100,align:'center'},
                   {field:'aac045',title:'工作单位',width:100,align:'center'},
                   {field:'aae030',title:'工作年月起',width:100,align:'center',formatter:function(value,row,index){return formateDate(value);}},
                   {field:'aae031',title:'工作年月止',width:100,align:'center',formatter:function(value,row,index){
                	   if(value==null){
	                 		  return "";
	                 	  }else{
	                 		  return formateDate(value);
	                 	  }
                	   }},
                   {field:'aac0b4',title:'主要工作内容',width:100,align:'center'},
                   {field:'aac217',title:'劳动合同期限(年)',width:100,align:'center'},
                   {field:'aac014name',title:'专业技术职务',width:100,align:'center'},
                   {field:'aac0b1name',title:'职称',width:100,align:'center'},
                   {field:'aac015name',title:'职业资格等级',width:100,align:'center'},
                   {field:'aac0b2',title:'执业资格情况',width:100,align:'center'},
                   {field:'aac0b3',title:'岗位',width:100,align:'center'},
                   {field:'aac0b5',title:'成绩及奖惩',width:100,align:'center'},
                   {field:'aac0b6',title:'见习标志',width:100,align:'center'},
                   {field:'aac0b7',title:'在职培训情况',width:100,align:'center'},
                   {field:'aac0b8name',title:'离职原因',width:100,align:'center'},
                   {field:'aac0ba',title:'离职日期',width:100,align:'center',formatter:function(value,row,index){
                	  if(value==null){
                		  return "";
                	  }else{
                		  return formateDate(value);
                	  }
                   }},
                   {field:'aae013',title:'备注',width:100,align:'center'}
      	        	];
	$('#personWorkExpceList').bootstrapTable({
	    url:'${ctx}/business/person/personWorkExpce/listJson.xf?aac001=${aac001}',
	    columns: columns,
		pagination:true,
		pageSize:10,
		pageList:[10, 15, 20],
	    clickToSelect:true,
	    sidePagination:"server",
	    singleSelect: true,
	    striped:true
	});
	disableButton();
})

function addPersonWorkExpce(){	
		xfui.open_dialog({    
		    title: '新增个人工作经历表',    
		    width: 950,    
		    height: 510,    
		    closed: false,    
		    cache: false,    
		    url: "${ctx}/business/person/personWorkExpce/add.xf?aac001=${aac001}",
		    modal: true   
		})
}
function editPersonWorkExpce(){
	var row = $('#personWorkExpceList').bootstrapTable('getAllSelections');
	if(row&&row.length>0){
		var aac0b0=row[0].aac0b0;
		xfui.open_dialog({    
	  		    title: '编辑个人工作经历表',    
	  		    width: 950,    
	  		    height: 510,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: "${ctx}/business/person/personWorkExpce/edit.xf?aac0b0="+aac0b0,
	  		    modal: true   
	  		})
	}else{
		bootbox.alert('请选择记录');
	}			
} 

function delPersonWorkExpce(){
	var row = $('#personWorkExpceList').bootstrapTable('getAllSelections');
	if(row&&row.length>0){
		var aac0b0="";
		$.each(row,function(i,e){
			if(i==0){
				aac0b0+=e.aac0b0;
			}else{
				aac0b0+=","+e.aac0b0;
			}
			
		});
		bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
		    if (r){    
		    	$.ajax({ url: '${ctx}/business/person/personWorkExpce/del.xf',
		    		data:{aac0b0:aac0b0},
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
	$('#personWorkExpceList').bootstrapTable('refresh');
}
//返回基本信息页面
function personSelect(){
	window.location.href = "${ctx}/business/person/personBaseInfo/edit.xf?aac001=${aac001}&cczy06="+cczy06;
 } 

function educationSelect(){
	window.location.href = "${ctx}/business/person/personBaseInfo/selectEducation.xf?aac001=${aac001}&cczy06="+cczy06;
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
		   					<li onclick="educationSelect()">教育背景</li>
		   					<li class="active">工作经历</li>
		   				</ul>
		   				<div class="mhyEducationInfo1">
			   				<table id="personWorkExpceList" class="datagridClass tableClassNoworks" ></table>
	   					</div>
	   					
	   					
	   			</div>
	   			<div> </div>
	   </div>
	 </div>	
</div>

<div class="bottomBtn">
				   					<div class="h50">&nbsp;</div>
				   					<div class="floatBtn">
				   					<button type="button" class="btn btn-primary"  onclick="addPersonWorkExpce()">新增</button>
				   					<button type="button" class="btn btn-primary" onclick="editPersonWorkExpce()">修改</button>
				   					<button type="button" class="btn btn-primary"  onclick="delPersonWorkExpce()">刪除</button>
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


