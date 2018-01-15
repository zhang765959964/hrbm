<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
var cczy06='${param.cczy06}';
$(function() {
	initTable();
})
$(function(){
		$("#personTab li").click(function(){
			var _this=this;
			$("#personTab li").removeClass("active")&&$(_this).addClass("active");;
		});
	
	$("[data-toggle='popover']").popover();
	 $("#addEducation").on("click",function(){
		 addEducation();
	 })
	$("#editPersonEducation").on("click",function(){
		editPersonEducation();
	 })
	 $("#delPersonEducation").on("click",function(){
		 delPersonEducation();
	 })
	})
function initTable() {
	var columns= [
                   {name:'aac045',label:'毕业院校',align:'center'},
                   {name:'aac0d2',width:80,label:'学校性质',align:'center'},
                   {name:'aac0d3',label:'培养方式',align:'center'},
                   {name:'aac046',label:'毕（肄）业时间',align:'center',formatter:function(value,row,index){return formateDate(value);}},
                   {name:'aac0d5',label:'毕业证书（认证）编号',align:'center'},
                   {name:'aac0d6name',label:'学制',align:'center'},
                   {name:'atc011',label:'学历',align:'center'},
                   {name:'aac037',label:'学位',align:'center'},
                   {name:'acc01g',label:'所学专业',align:'center'},
                   {name:'aac0d4',label:'专业描述',align:'center'},
                   {name:'atc01g',label:'第二专业',align:'center'}, 
                   {name:'aac038',label:'所学外语',align:'center'},
                   {name:'aac039',label:'外语水平',align:'center'},
                   {name:'aac041',label:'第二外语',align:'center'},
                   {name:'aac042',label:'二外水平',align:'center'}, 
                   {name:'aac0d7',label:'其他外语',align:'center'},
                   {name:'aac043',label:'计算机水平',align:'center'},
                   {name:'aac0d1',label:'学习经历',align:'center'},
                   {name:'aae013',label:'备注',align:'center'},
                   {name:'aac0d0',label:'主键',key:true,hidden:true}
                   
  	        	];

			$("#personEducationList").jqGrid({
				   //url:'${ctx}/business/person/personEducation/listJson.xf?aac001=${param.aac001}',
		           mtype: "GET",
				   styleUI : 'Bootstrap',
		           datatype: "local",
		           colModel: columns,
				   viewrecords: true,
		           rowNum: 10,
		           rowList:[10,20,30],
		           pager: "#jqGridEduPager",
		           pagerpos:'left',
		           regional : 'cn',
		           recordpos:'right',
		           shrinkToFit: false,
		           multiselect:true,
		           autowidth: true,
		           height:'100%',
		           rownumbers : true
		       });
			$("#perEdu").removeClass("in").removeClass("active");
			loadEducation();
}

function loadEducation(){
	var aac001='${param.aac001}'
	if(aac001){
		$("#personEducationList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/person/personEducation/listJson.xf?aac001='+aac001}).trigger("reloadGrid");
	}
}
function addEducation(){
	xfui.open_dialog({    
	    title: '新增个人教育背景信息',    
	    width: 800,    
	    height: 520,    
	    closed: false,    
	    cache: false,    
	    url: "${ctx}/business/person/personEducation/add.xf?aac001=${param.aac001}",
	    modal: true   
	})
 }
function editPersonEducation(){
	var rowid = $("#personEducationList").jqGrid("getGridParam", "selrow");
	if(rowid){
		var aac0d0=rowid;
		xfui.open_dialog({    
	  		    title: '编辑个人教育背景信息',    
	  		    width: 800,    
	  		    height: 520,    
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
	var rowids = $('#personEducationList').jqGrid("getGridParam","selarrrow");
	if(rowids && rowids.length > 0){
		var aac0d0="";
		$.each(rowids,function(i,e){
			if(i==0){
				aac0d0+=e;
			}else{
				aac0d0+=","+e;
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
		    			
		    			refreshEducationList();
		             }
		    	});
		    }    
		}}); 
	  }else{
		 bootbox.alert('请选择记录');
	 }			
} 

function refreshEducationList(){

	$("#personEducationList").trigger("reloadGrid");
	//$("#personEducationList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/person/personEducation/listJson.xf?aac001=${param.aac001}'}).trigger("reloadGrid");

}
//返回基本信息页面
// function personSelect(){
// 	window.location.href = "${ctx}/business/person/personBaseInfo/edit.xf?aac001=${param.aac001}&cczy06="+cczy06;
//  } 
// //跳转到工作经历页面
// function workExpceSelect(){
// 	window.location.href = "${ctx}/business/person/personBaseInfo/selectWorkExpce.xf?aac001=${param.aac001}&cczy06="+cczy06;
//  }
// function personJobRegist(){
// 	window.location.href = "${ctx}/business/person/personJobRegist/edit.xf?aac001=${param.aac001}&cczy06="+cczy06;
//  } 
function disableButton(){
	 var aac001='${param.aac001}';
	 if(aac001){
		 if(!hasEditPermi(aac001,1)){
			 $(".btn-primary").attr("disabled","disabled");
			 $(".btn-primary").attr("title","无编辑权限");
		 }
	 }

}
</script>
<!--  	<div class="row"> -->
 		<div class="moduleCont">
	  		<table id="personEducationList" class="datagridClass tableClassNoworks" ></table>
	  		<div id="jqGridEduPager"></div>
  		</div>
<!-- 	</div> -->
<div class="bottomBtn">
	<div class="h50">&nbsp;</div>
		<div class="floatBtn">
		 <button type="button" class="btn btn-primary"  id="addEducation" ><i class="icon-plus"></i>新增</button>
		 <button type="button" class="btn btn-info" id="editPersonEducation"><i class="icon-pencil align-top"></i>修改</button>
		 <button type="button" class="btn btn-danger" id="delPersonEducation"><i class="icon-trash"></i>刪除</button>
	</div>
</div>