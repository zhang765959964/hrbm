<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>培训机构信息管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<%@include file="/commons/include/bootstrapInc.jsp" %>
<style type="text/css">
  #trainOrgList td {white-space: nowrap;}
</style>

<script>

	$(function() {
		/**
		 初始化表格显示
		 */
		initTable();
	})
	
	
	function initTable() {
		
		var columns= [[{field:'',title:'Id号',checkbox:'true',width:40,align:'center'},
	                   {field:'orgName',title:'机构名称'},
	                   {field:'aac022',title:'机构简码'},
	                   {field:'orgAccount',title:'机构帐号'},
	                   {field:'orgPwd',title:'机构密码'},
	                   {field:'contactsName',title:'联系人'},
	                   {field:'contactsTel',title:'手机号'},
	                   {field:'orgCertificate',title:'机构证件'},
	                   {field:'orgEstablishDate',title:'注册日期',formatter:function(value,row,index){if(value)return formateDate(value);}},
	                   {field:'orgType',title:'机构类别'},
	                   {field:'orgLegalPersonId',title:'法人身份证'},
	                   {field:'orgEmail',title:'机构邮箱'},
	                   {field:'orgManageRange',title:'经营范围'},
	                  /*  {field:'orgAdminDivision',title:'行政区划'}, */
	                   {field:'orgAddr',title:'机构地址'}, 
	                   {field:'isDisable',title:'禁用状态',formatter:function(value,row,index){if(value==1)return '是';else return '否'}},
	                   {field:'isAudit',title:'审核状态',formatter:function(value,row,index){if(value==0)return '未审核';if(value==1)return '审核通过';else return '审核未通过'}},
	                   {field:'aae019',title:'经办人'},
	                   {field:'aae020',title:'经办机构'},
	                   {field:'aae036',title:'经办日期',formatter:function(value,row,index){if(value)return formateDate(value);}},
	                
	                   {field:'pxOrgId',title:'操作',width:80,formatter: function(value,row,index){	 
				           return "<a href=\"javascript:void(0)\" onclick=\"editTrainOrg('"+value+"')\" >编辑</a>";/* +
								 "<a href=\"javascript:void(0)\" onclick=\"searchLocation()\">地图标注</a>"  */
							}
					 }
      	        	]];
		$('#trainOrgList').bootstrapTable({
			url : '${ctx}/business/dissupport/train/trainOrg/per/listJson.xf?orgId=${orgId}',
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

	function editTrainOrg(value){
			var pxOrgId=value;
			xfui.open_tabs("编辑培训机构基本信息","${ctx}/business/dissupport/train/trainOrg/per/edit.xf?pxOrgId="+pxOrgId+"&orgId=${orgId}","培训机构信息管理");
	}
	
	
	function refreshTable(){

		if(leftClickTreeNode){
			var id=leftClickTreeNode.id;
			$('#trainOrgList').bootstrapTable('refresh', {query:{
				colId: id
			  }				
			});
		}else{
			$('#laborColList').bootstrapTable('refresh');
		}				
	} 
	
	function refresh(){
		$("#trainOrgList").bootstrapTable('refresh');
	}

</script>
</head>
<body>
		<div class="main-container">
			<div class="container-fluid">
				<div class="mhyBody">
					<div class="mhyMain">
					<div class="mhyTitle">查询结果</div>
					<div class="mhyInfo">
						<div class="row mhyConter">
							<div class="col-xs-12">
								<div class="table-responsive">
									<table id="trainOrgList"  class="datagridClass"  >
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
          format: "yyyy-mm-dd",
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


