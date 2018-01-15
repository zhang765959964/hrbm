<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script>
var cczy06='${param.cczy06}';
$(function(){
	
	 $("#addPersonWorkExpce").on("click",function(){
		 addPersonWorkExpce();
	 })
	$("#editPersonWorkExpce").on("click",function(){
		editPersonWorkExpce();
	 })
	 $("#delPersonWorkExpce").on("click",function(){
		 delPersonWorkExpce();
	 })
	/**
	 初始化表格显示
	*/
	var columns= [
	               {name:'aac0b0',label:'主键',key:true,hidden:true},
                   {name:'aac045',label:'工作单位',align:'center'},
                   {name:'aae030',label:'工作年月起',align:'center',formatter:function(value,row,index){return formateDate(value);}},
                   {name:'aae031',label:'工作年月止',align:'center',formatter:function(value,row,index){
                	   if(value==null){
	                 		  return "";
	                 	  }else{
	                 		  return formateDate(value);
	                 	  }
                	   }},
                   {name:'aac0b4',label:'主要工作内容',align:'center'},
                   {name:'aac217',label:'劳动合同期限(年)',align:'center'},
                   {name:'aac014name',label:'专业技术职务',align:'center'},
                   {name:'aac0b1name',label:'职称',align:'center'},
                   {name:'aac015name',label:'职业资格等级',align:'center'},
                   {name:'aac0b2',label:'执业资格情况',align:'center'},
                   {name:'aac0b3',label:'岗位',align:'center'},
                   {name:'aac0b5',label:'成绩及奖惩',align:'center'},
                   {name:'aac0b6',label:'见习标志',align:'center'},
                   {name:'aac0b7',label:'在职培训情况',align:'center'},
                   {name:'aac0b8name',label:'离职原因',align:'center'},
                   {name:'aac0ba',label:'离职日期',align:'center',formatter:function(value,row,index){
                	  if(value==null){
                		  return "";
                	  }else{
                		  return formateDate(value);
                	  }
                   }},
                   {name:'aae013',label:'备注',align:'center'}
      	        	];

	$("#personWorkExpceList").jqGrid({
        mtype: "GET",
		   styleUI : 'Bootstrap',
        datatype: "local",
        colModel: columns,
		   viewrecords: true,
        rowNum: 10,
        rowList:[10,20,30],
        pager: "#jqGridPager",
        pagerpos:'left',
        regional : 'cn',
        recordpos:'right',
        shrinkToFit: false,
        multiselect:true,
        autowidth: true,
        height:'100%',
        rownumbers : true
    });
	$("#perExp").removeClass("in").removeClass("active");
// 	disableButton();
	loadWorkExpce();
})
function loadWorkExpce(){
	var aac001='${param.aac001}'
	if(aac001){
		$("#personWorkExpceList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/person/personWorkExpce/listJson.xf?aac001='+aac001}).trigger("reloadGrid");

	}
}
function addPersonWorkExpce(){	
		xfui.open_dialog({    
		    title: '新增个人工作经历信息',    
		    width: 800,    
		    height: 520,    
		    closed: false,    
		    cache: false,    
		    url: "${ctx}/business/person/personWorkExpce/add.xf?aac001=${param.aac001}",
		    modal: true   
		})
}
function editPersonWorkExpce(){
	var rowid = $("#personWorkExpceList").jqGrid("getGridParam", "selrow");
	if(rowid){
		var aac0b0=rowid;
		xfui.open_dialog({    
	  		    title: '编辑个人工作经历信息',    
	  		    width: 800,    
	  		    height: 520,    
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
	var rowids = $('#personWorkExpceList').jqGrid("getGridParam","selarrrow");
	if(rowids&&rowids.length>0){
		var aac0b0="";
		$.each(rowids,function(i,e){
			if(i==0){
				aac0b0+=e;
			}else{
				aac0b0+=","+e;
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
		    			
		    			refreshWorkExpceList();
		             }
		    	});
		    }    
		}}); 
	  }else{
		 bootbox.alert('请选择记录');
	 }			
} 
function refreshWorkExpceList(){

	$("#personWorkExpceList").trigger("reloadGrid");

}
//返回基本信息页面
function personSelect(){
	window.location.href = "${ctx}/business/person/personBaseInfo/edit.xf?aac001=${param.aac001}&cczy06="+cczy06;
 } 

function educationSelect(){
	window.location.href = "${ctx}/business/person/personBaseInfo/selectEducation.xf?aac001=${param.aac001}&cczy06="+cczy06;
} 
function personJobRegist(){
	window.location.href = "${ctx}/business/person/personJobRegist/edit.xf?aac001=${param.aac001}&cczy06="+cczy06;
 }
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
<!-- <div class="row"> -->
<div class="moduleCont">
	<table id="personWorkExpceList" class="datagridClass tableClassNoworks" ></table>
	<div id="jqGridPager"></div>
</div>
<!-- </div> -->
<div class="bottomBtn">
	<div class="h50">&nbsp;</div>
	<div class="floatBtn">
		<button type="button" class="btn btn-primary"  id="addPersonWorkExpce" ><i class="icon-plus"></i>新增</button>
		<button type="button" class="btn btn-info" id="editPersonWorkExpce"><i class="icon-pencil align-top"></i>修改</button>
		<button type="button" class="btn btn-danger"  id="delPersonWorkExpce"><i class="icon-trash"></i>刪除</button>
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