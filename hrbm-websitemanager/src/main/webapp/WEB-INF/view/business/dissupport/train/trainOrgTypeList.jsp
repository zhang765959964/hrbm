<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>培训类别管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<%@include file="/commons/include/bootstrapInc.jsp" %>
<script>

	$(function() {
		/**
		 初始化表格显示
		 */
		initTable();
	})
	
	
	function initTable() {
		
		var columns= [[{field:'',title:'Id号',checkbox:'true',width:40,align:'center'},
	                   {field:'typeId',title:'操作',width:100,formatter: function(value,row,index){	 
				           return "<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"editTrainOrgType('"+value+"')\" ><i class=\"icon-pencil\" title=\"编辑\"></i></a>"+
								"<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"delTrainOrgType('"+value+"')\" ><i class=\"icon-trash\" title=\"删除\"></i></a>";
							}
					 },
	                   {field:'pName',title:'上级类别'},
	                   {field:'name',title:'类别名称'},
	                   {field:'aae019',title:'经办人'},
	                   {field:'aae020',title:'经办机构'},
	                   {field:'aae036',title:'经办日期',formatter:function(value,row,index){if(value)return formateDate(value);}}
      	        	]];
		$('#trainOrgTypeList').bootstrapTable({
			url : '${ctx}/business/dissupport/train/trainOrgType/listJson.xf',
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
	}

	function addTrainOrgType(){	
		 xfui.open_tabs("添加培训类别信息","${ctx}/business/dissupport/train/trainOrgType/add.xf","培训机构类别信息管理"); 
	}
	
	function editTrainOrgType(value){
			var typeId=value;
			xfui.open_tabs("编辑培训类别信息","${ctx}/business/dissupport/train/trainOrgType/edit.xf?typeId="+typeId,"培训机构类别信息管理");
	}
	
	function delTrainOrgType(obj){
		var typeId="";
		if(obj!=null && obj!=""){
			typeId=obj;
		}else{
			var row = $('#trainOrgTypeList').bootstrapTable('getAllSelections');
			if(!row||row.length<=0){
				bootbox.alert('请选择记录');
				return;
			}else{
				if(row.length>=2){
					bootbox.alert("只能选择一条记录");
					return;
				}else{
					typeId+=row[0].typeId;
				}
				/* $.each(row,function(i,e){
					if(i==0){
						typeId+=e.typeId;
					}else{
						typeId+=","+e.typeId;
					}
					
				}); */
			}
		}
		bootbox.confirm({ 
		    size: 'small',
		    message: "您确认想要删除吗", 
		    callback: function(r){ 	    	
		    	 if (r){    
		 	    	$.ajax({ url: '${ctx}/business/dissupport/train/trainOrgType/del.xf',
		 	    		data:{typeId:typeId},
		 	    		dataType:'json',
		 	    		success: function(data){
		 	    			if(data.result==2){
		 	    				bootbox.alert(data.message);
		 	    				return;
		 	    			}else if(data.message){
		 	    				refresh(); 
		 	    			}else{
		 	    				bootbox.alert("未知错误"); 
		 	    			}
		 	             }
		 	    	});
		 	    } 
		    }
		}) 
	} 
	
	function refresh(){
		$("#trainOrgTypeList").bootstrapTable('refresh');
	}

</script>
</head>
<body>
	<div class="main-container">
		<div class="container-fluid">
			<div class="mhyBody">
	
				<div class="">
				<div class="mhyTitle">查询结果</div>
				<div class="mhyInfo">
				<div class="mgy10">
									<a href="javascript:void(0)" role="button" onclick="addTrainOrgType()"  class="btn btn-primary mhyBtnLeft" data-toggle="modal">
					<i class="icon-plus"></i>
					新增</a>
					<a href="javascript:void(0)" role="button" onclick="delTrainOrgType()" class="btn btn-danger" data-toggle="modal">
					<i class="icon-trash"></i>
					删除</a>
				</div>

					<div class="row mhyConter">
						<div class="col-xs-12">
							<div class="table-responsive">
								<table id="trainOrgTypeList"  class="datagridClass"  >
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			
         </div>
       </div>
    </div>
</body>
<script type="text/javascript">
  jQuery(function($) {
 		// 日期选择
      $("#datepicker01").datetimepicker({
          todayBtn: true,
          format: "yyyy-mm-dd hh:mm:ss",
          startView: 2,
          minView: 2,
          language: 'cn',
          maxView: "decade",
          viewSelect: 2,
          autocomplete:true,
          autoclose:true
      });
     $(".dp").datetimepicker({
          todayBtn: true,
          format: "yyyy-mm-dd",
          startView: 2,
          minView: 2,
          maxView: "decade",
          viewSelect: 2,
          language: 'cn',
          autocomplete:true,
          autoclose:true
      });
      $(".dpMonth").datetimepicker({
          todayBtn: true,
          format: "yyyy-mm",
          startView: 3,
          minView: 3,
          maxView: "decade",
          language: 'cn',
          viewSelect: 3,
          autocomplete:true,
          autoclose:true
      });
    });
</script> 
</html>


