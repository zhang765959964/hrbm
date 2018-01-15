<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>个人求职登记表管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<script>

$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [
	                   {name:'ACC200',label:'登记编号',align:'center'},
	                   {name:'ACB208',label:'冻结标记',align:'center'},
	                   {name:'BCB207',label:'登记方式',align:'center'},
	                   {name:'AAC002',label:'身份证号码',align:'center'},
	                   {name:'AAC003',label:'姓名',align:'center'},
	                   {name:'BCA112',label:'意愿职位名称1',align:'center'},
	                   {name:'BCC20C',label:'意愿职位说明',align:'center'},
	                   {name:'AAC004',label:'性别',align:'center'},
	                   {name:'AAC005',label:'民族',align:'center'},
	                   {name:'AAC006',label:'出生日期',align:'center',formatter:function(value,row,index){
	                	   if(value==null){return "";}else{return formateDate(value);}}},
	                   {name:'AAE005',label:'联系电话',align:'center'},
	                   
	                   {name:'AAE015',label:'电子信箱',align:'center'},
	                   {name:'AAE007',label:'邮政编码',align:'center'},
	                   
	                   {name:'BAB305',label:'户口所在地',align:'center'},
	                   {name:'AAC009',label:'户口性质',align:'center'},
	                   {name:'AAB301',label:'居住所在地',align:'center'},
	                   {name:'AAC011',label:'文化程度',align:'center'},
	                   {name:'AAC024',label:'政治面貌',align:'center'},
	                   {name:'AAC017',label:'婚姻状况',align:'center'},
	                   
	                   {name:'AAC033',label:'健康状况',align:'center'},
	                   {name:'AAC034',label:'身高',align:'center'},
	                   
	                   {name:'ACC201',label:'登记类别',align:'center'}
	                   
	                   
	                {name:'ACC200',label:'操作',width:100,formatter: function(cellvalue, options, rowObject){	 
				           return "<a href=\"javascript:void(0)\" onclick=\"stickTop('"+cellvalue+"')\" >编辑</a>|"+
								"<a href=\"javascript:void(0)\" onclick=\"previewArticle('"+cellvalue+"')\" >删除</a>";
							}
					 }
      	        	];
	$("#personJobRegistList").jqGrid({
		   url:'${ctx}/business/person/personJobRegist/listJson.xf',
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
           shrinkToFit: false,
           multiselect:true,
           autowidth: true
       });
})

function addpersonJobRegist(){	
		xfui.open_dialog({    
		    title: '新增个人求职登记表',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: "${ctx}/business/person/personJobRegist/add.xf",
		    modal: true   
		})
}
function editpersonJobRegist(){
	//var row = $('#personJobRegistList').bootstrapTable('getAllSelections');
	var rowid=$("#personJobRegistList").jqGrid("getGridParam","selrow");
	if(rowid){
		var acc200=rowid;
		xfui.open_dialog({    
	  		    title: '编辑个人求职登记表',    
	  		    width: 800,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: "${ctx}/business/person/personJobRegist/edit.xf?acc200="+acc200,
	  		    modal: true   
	  		})
	}else{
		bootbox.alert('请选择记录');
	}			
} 

function delpersonJobRegist(){

	var rowids=$("#personJobRegistList").jqGrid("getGridParam","selarrrow");
	if(rowids&&rowids.length>0){
		var acc200="";
		$.each(rowids,function(i,e){
			if(i==0){
				acc200+=e;
			}else{
				acc200+=","+e;
			}
			
		});
		bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
		    if (r){    
		    	$.ajax({ url: '${ctx}/business/person/personJobRegist/del.xf',
		    		data:{acc200:acc200},
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
	$("#personJobRegistList").trigger("reloadGrid");
}
function doSearch(){
	
	var json=$("#searchForm").serializeJson();
	$("#personJobRegistList").jqGrid("setGridParam",{postData:json}).trigger("reloadGrid");
}
</script>
</head>
<body>
		<div class="main-container">
			<div class="container-fluid">
				<div class="row">
			    <div class="moduleWrapNobg">
				<div class="moduleTit">查询条件</div>
				<div class="moduleCont">
					<form id="searchForm">
						<div class="row">
								<label class="col-xs-3 col-sm-2" for="inputError">个人编号:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aac001" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">学历信息编号:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aac0d0" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">工作经历编号:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aac0b0" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">人员类别:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc20t" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">就业困难对象:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aac029" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">技能培训要求:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc20d" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">食宿要求:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acb228" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">求职区域:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bcb202" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">求职区域2:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bcb203" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">求职区域3:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bcb204" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">月工资:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc034" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">报酬福利要求:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc214" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">登记类别:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc201" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">信息发布方式:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc20q" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">登记日期:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aae043" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">有效日期:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="ace014" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">工种代码1:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aca111" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">工种名称1:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aca112" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">形式工种代码1:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bca111" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">形式工种名称1:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bca112" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">工种代码2:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acaa11" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">工种名称2:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acaa12" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">形式工种代码2:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bcaa11" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">形式工种名称2:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bcaa12" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">工种代码3:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acab11" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">工种名称3:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acab12" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">形式工种代码3:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bcab11" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">形式工种名称3:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bcab12" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">冻结标记,0未冻结,1已冻结:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acb208" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">冻结人员:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acb20d" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">冻结日期:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acb20e" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">冻结原因:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc20l" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">推荐比例:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc21p" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">已推荐次数:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc21q" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">未反馈数:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc21f" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">已成功次数:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc21t" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">剩余推荐次数:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc21g" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">备注:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aae013" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">经办人代码:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aae011" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">经办机构代码:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aae017" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aae036" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aae019" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aae020" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">经办机构区划:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aae022" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">高级人才:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc20p" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">历史未反馈校验:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc20u" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">有效就业校验:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc20y" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">就业失业登记证号码:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc0m1" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">普通话水平:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bcc20x" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">是否定向报名:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bcc20a" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">结业院校:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aac045" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">毕业时间:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aac046" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">所学专业代码:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc01g" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">资格证书类型:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bcc02i" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">求职区域:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acb202" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">求职区域2:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acb203" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">求职区域3:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acb204" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">计算机水平TAB_CLEVEL:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aac038" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">英语水平TAB_fLEVEL:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aac039" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">工作要求:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bcc201" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">人员细类:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bcc20t" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">单位类型:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aab019" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">经济类型:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aab020" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">参加工作时间:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aac007" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">所学专业名称:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bcc01g" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">专业技术职务:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bac014" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">掌握语言:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bcc038" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">匹配条件:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="ccppcb" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">数据开放对象:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acb207" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">数据开放程度:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acb209" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">数据分类（用作登记方式1-个人求职添加2-达成意向添加3-劳务输出添加:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bcb207" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">数据来源:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bcb209" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">定向信息编号:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acb210" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">定向单位及岗位:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aab004" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">输出组织编号:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acb450" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">输出组织名称:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acb451" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">审核标识:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="abb561" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">审核时间:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="abb771" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">审核人:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="abb769" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">审核机构:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="abb770" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">审核意见:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="abb772" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">审核标记,0审核未通过,1审核已通过:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="abb773" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">申请时间:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acf271" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">高级人才申请状态:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acf272" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">是否已转高级人才:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acf273" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">信息保密:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bcc20b" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">意愿工种描述:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bcc20c" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">意愿2工种描述:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bcc20d" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">意愿3工种描述:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bcc20e" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">是否上岗:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bcc20f" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">上岗证名称 :</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bcc20g" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">求职用工形式要求:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aac013" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">地区要求:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc213" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">推荐次数:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc215" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">推荐情况:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc223" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">求职成功日期:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc22c" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">录用单位编号:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aab001" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">第二学历:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc20i" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">第二外语:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aac041" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">第二外语熟练程度:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aac042" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">其它外语:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc20e" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">从事本职业工种的时间
:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aae162" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">下岗证号:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aac20c" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">再就业优惠证编号:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc101" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">职业资格等级:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc20g" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">联系人:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aae004" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">通讯地址:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="aae006" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">原工作单位:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc010" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">因何原因去过哪些国家:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc206" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">是否境外求职:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc207" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">是否4050人员:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc02a" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">失业登记编号:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc020" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">是否持有再就业优惠证:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc03a" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">是否享受失业保险待遇:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc20f" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">分配日期:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc20a" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">信息采集员:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="acc20b" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">申请高级人才状态:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="ccpr01" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">被查看次数:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="ccpr02" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">刷新时间:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="ccpr03" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">推荐值:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="ccpr04" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">最后修改时间:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="ccpr05" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">修改人:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="ccpr06" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">修改来源:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="ccpr07" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">是否删除状态（0-否1-是）:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="ccpr08" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">其他要求:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="bae013" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">设备编号:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="div001" data-placement="bottom" />
								</div>
						</div>
						<div class="row">
							<div class="col-sm-12 mgb20 tar pdx20">
								<a href="#" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-zoom-in"></i>查询</a>
								<a href="javascript:void(0)" class="btn btn-primary highSearch" ><i class="icon-plus"></i>高级查询</a>
								<a href="#modal-form" role="button" class="btn btn-border1" ><i class="icon-repeat"></i>重置</a>
							</div>
						</div>
					</form>
				</div>
			</div>		
				<div class="moduleWrapNob">
				<div class="moduleTit">查询结果</div>
				<div class="moduleCont">
					<div class="mgy10">
						<a href="javascript:void(0)" onclick="addpersonJobRegist()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus align-top"></i>添加</a>
						<a href="javascript:void(0)" onclick="editpersonJobRegist()" role="button" class="btn btn-info" data-toggle="modal"><i class="icon-pencil align-top"></i>修改</a>
						<a href="javascript:void(0)"  onclick="delpersonJobRegist()" role="button" class="btn btn-danger" ><i class="icon-trash align-top"></i>移除</a>
						<a href="javascript:void(0)"  role="button" class="btn  btn-light" ><i class="icon-edit align-top"></i>导入</a>
						<a href="javascript:void(0)"  role="button" class="btn btn-grey" ><i class="icon-external-link align-top"></i>导出</a>
						<!-- <a href="javascript:void(0)" role="button" onclick="delCorp()" class="btn btn-danger" data-toggle="modal"><i class="icon-trash align-top"></i>删除</a> -->
					</div>
					<div class="row">
						<div class="col-xs-12">
								<table id="personJobRegistList"  class="datagridClass"  ></table>
								<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
			</div>	
				</div>
			</div>
		</div>
</body>		
</html>


