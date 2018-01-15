<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>个人工作经历表管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@include file="/commons/include/commonInc.jsp" %>
</head>
<body>
	<input type="hidden" id="aae030Date" />
	<input type="hidden" id="aae031Date" />
	<div class="container-fluid">
		<div class="row pd-none-wrap">
			<div class="moduleWrapNob change-bg-iframe">
				<div class="moduleCont">
					<div class="mgy10">
						<a href="javascript:void(0)" onclick="addRsdaPersonWorkExpce()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus"></i>添加</a>
						<a href="javascript:void(0)" onclick="delRsdaPersonWorkExpce()" role="button" class="btn btn-danger" ><i class="icon-trash"></i>删除</a>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<table id="rsdaPersonWorkExpceList" class="datagridClass"></table>
							<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
			</div>	
		</div>
	</div>
<script type="text/javascript">
		$(function(){
			var columns= [	  
						   {name:'aac0b0',label:'操作',key: true,align:'center',width:80,frozen : true,	formatter:'actions',formatoptions:{
								keys: false,
								editbutton : true,
								delbutton : false
						   },frozen : true},
		                   {name:'aac045',label:'工作单位',align:'center',editable : true,edittype:'text',editoptions:{size:10,maxlength:15},editrules:{required:true}},
		                   {name:'aae030',label:'工作年月起',align:'center',editable : true,unformat: pickDate,editrules:{
		                	   required : true,
		                	   date:true,
		                	   custom:true, 
		                	   custom_func:function(value, colNames){    
		                		   if(!(/^[0-9]{4}-(0?[0-9]|1[0-2])-(0?[1-9]|[12]?[0-9]|3[01])$/.test(value))){
		                			   return [false,"请输入YYYY-MM-DD日期格式！"];
		                		   }else{
		                			   $("#aae030Date").val(value);
			                		   return [true,""];
		                		   }
		                   	  }
		                   }},
		                   {name:'aae031',label:'工作年月止',align:'center',editable : true,unformat: pickDate,editrules : {
			                	   required : false,
			                	   date:true,
			                	   custom:true, 
			                	   custom_func:function(value, colNames){    
			                		  if(!(/^[0-9]{4}-(0?[0-9]|1[0-2])-(0?[1-9]|[12]?[0-9]|3[01])$/.test(value))){
			                			   return [false,"请输入YYYY-MM-DD日期格式！"];
			                		  }else{
			                			  $("#aae031Date").val(value);
				                		  var bb = $("#aae030Date").val();
				                		  var ee = $("#aae031Date").val();
				                		  if(bb>ee){
				                			   return [false,"工作年月起不能大于工作年月止"];
				                		   }else{
				                			   return [true,""];
				                		   }
			                		  }  
			                	   }}
		                   },
		                   {name:'aac0b4',label:'主要工作内容',align:'center',editable : true,edittype:'text',editoptions:{size:10,maxlength:200}},
		                   {name:'aac217',label:'劳动合同期限(年)',align:'center',editable : true,edittype:'text',editoptions:{size:10,maxlength:200},
		                	   editrules:{
		                		   number:true
		                	   }
		                   },
		                   {name:'aac014name',label:'专业技术职务',align:'center',editable : true,edittype:'select',editoptions: { value: ":--请选择--;${aac014Value}" }},
		                   {name:'aac0b1name',label:'职称',align:'center',editable : true,edittype:'select',editoptions: { value: ":--请选择--;${aac0b1Value}" }},
		                   {name:'aac015name',label:'职业资格等级',align:'center',editable : true,edittype:'select',editoptions: { value: ":--请选择--;${aac015Value}" }},
		                   {name:'aac0b2',label:'执业资格情况',align:'center',editable : true,edittype:'text',editoptions:{size:10,maxlength:25}},
		                   {name:'aac0b3',label:'岗位',align:'center',editable : true,edittype:'text',editoptions:{size:10,maxlength:25}},
		                   {name:'aac0b5',label:'成绩及奖惩',align:'center',editable : true,edittype:'text',editoptions:{size:10,maxlength:50}},
		                   {name:'aac0b6',label:'见习标志',align:'center',editable : true,edittype:'select',editoptions: { value: "0:非见习;1:见习" },
				                   formatter:function(value,row,index){
				                	   if(value==null){
				                		   return "";
				                	   }
				                	   if(value=="非见习"){
				                		   return "非见习";
				                	   }
				                	   if(value=="见习"){
				                		   return "见习";
				                	   }
				                  }
		                   },
		                   {name:'aac0b7',label:'在职培训情况',align:'center',editable : true,edittype:'text',editoptions:{size:10,maxlength:50}},
		                   {name:'aac0b8name',label:'离职原因',align:'center',editable : true,edittype:'select',editoptions: { value: ":--请选择--;${aac0b8Value}" }},
		                   {name:'aac0ba',label:'离职日期',align:'center'
		                   			,editable : true,unformat: pickDate},
		                   {name:'aae013',label:'备注',align:'center',editable : true,edittype:'text',editoptions:{size:10,maxlength:50}},
		                   {name:'aac001',label:'1',align:'center',hidden:true,editable : true}
			                   
		      	        	];
			$("#rsdaPersonWorkExpceList").jqGrid({
				   url:'${ctx}/business/personagency/receive/rsdaPersonWorkExpce/listJson.xf?aac001=${AAC001}',
				   editurl:'${ctx}/business/personagency/receive/rsdaPersonWorkExpce/save.xf',
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
		           autowidth: true,
		           height:'100%',
		           multiboxonly: true,
		           gridComplete:function(){
		         	  $(".ui-inline-edit").on("click",function(){
		         		  jQuery.fn.fmatter.rowactions.call(this,'edit');
		         	  })
		         	  $(".ui-inline-save").on("click",function(){
		         		  jQuery.fn.fmatter.rowactions.call(this,'save');
		         	  })
		         	  $(".ui-inline-cancel").on("click",function(){
		         		  jQuery.fn.fmatter.rowactions.call(this,'cancel');
		         	  })
			      }
		       });
			$("#rsdaPersonWorkExpceList").jqGrid('setFrozenColumns');
		})
					
		function pickDate( cellvalue, options, cell ) {
			setTimeout(function(){
				$(cell) .find('input[type=text]')
						.xfdaterangepicker({singleDatePicker:true,
					      autoUpdateInput:false,
						  "opens":"right",
						  "drops": "down",
				          "locale": {
				          "format": "YYYY-MM-DD"
				         }
				     });
			}, 0);
		}
		function addRsdaPersonWorkExpce(){	
			//获取主键
			var  zhi = 0;
		    $.ajax({
		        type: "post",
		        url: "${ctx}/business/personagency/receive/receive/getPrimaryKey.xf",
		        data: {name:"PersonWorkExpce"},
		        dataType: "json",
		        success: function(data){
		        	zhi= data.message + "";
		        	var selectedId = $("#gridTable").jqGrid("getGridParam", "selrow");  
		            var dataRow = {   
		            	aac0b0 : zhi,  
		            	aac001 : "${AAC001}",
		            	aac0b6 : "非见习"
		            };  
		            if (selectedId) {  
		                $("#rsdaPersonWorkExpceList").jqGrid("addRowData", zhi, dataRow, "before", selectedId);  
		            } else {  
		                $("#rsdaPersonWorkExpceList").jqGrid("addRowData", zhi, dataRow, "first");  
		            } 
		        }
		    });
		}
		
		//删除表格数据
		function delRsdaPersonWorkExpce(){
			var row =$("#rsdaPersonWorkExpceList").jqGrid("getGridParam","selarrrow");
			if(row&&row.length>0){
				var aac0b0="";
				$.each(row,function(i,e){
					if(i==0){
						aac0b0+=e;
					}else{
						aac0b0+=","+e;
					}
				});
				bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
				    if (r){    
				    	$.ajax({ url: '${ctx}/business/personagency/receive/rsdaPersonWorkExpce/del.xf',
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
			$("#rsdaPersonWorkExpceList").trigger("reloadGrid");
		}
	</script>
</body>	
</html>