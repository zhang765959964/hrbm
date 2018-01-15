<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>培训机构维护</title>
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
		
		$(".mhyInputReset").click(function(){
			
			$("#searchForm")[0].reset();
		});
	})
	
	
	function initTable() {
		
		var columns= [[{field:'',title:'Id号',checkbox:'true',width:40,align:'center'},
	                
	                   {field:'pxOrgId',title:'操作',width:80,formatter: function(value,row,index){	 
				           return "<a class=\"mhyNoA\" href=\"javascript:void(0)\" id=\'"+value+"'\" onclick=\"editTrainOrg('"+value+"')\" ><i class=\"icon-pencil\" title=\"编辑\"></i></a>";/* +
								 "<a href=\"javascript:void(0)\" onclick=\"searchLocation()\">地图标注</a>"  */
							}},
	                 /*   {field:'orgName',title:'机构名称'}, */
	                   {field:'orgName',title:'机构名称'/* ,formatter: function(value,row,index){	 
				           return "<a href=\"javascript:void(0)\" onclick=\"editTOrg(this)\" >"+value+"</a>";
						} */},
	                   {field:'orgPublishName',title:'发布名称'},
	                   {field:'aac022',title:'机构简码'},
	                   {field:'orgAccount',title:'机构帐号'},
	                   {field:'orgPwd',title:'机构密码'},
	                   {field:'contactsName',title:'联系人'},
	                   {field:'contactsTel',title:'手机号'},
	                   {field:'orgCertificateId',title:'机构证件号'},
	                   {field:'orgEstablishDate',title:'注册日期',formatter:function(value,row,index){if(value)return formateDate(value);}},
	                   {field:'orgType',title:'机构类别'},
	                   {field:'orgLegalPersonId',title:'法人身份证'},
	                   {field:'orgEmail',title:'机构邮箱'},
	                  /*  {field:'orgManageRange',title:'机构介绍'}, */
	                   {field:'orgAdminDivisionn',title:'行政区划'},
	                   {field:'orgAddr',title:'机构地址'}, 
	                   {field:'isDisable',title:'禁用状态',formatter:function(value,row,index){if(value==1)return '是';else return '否'}},
	                   {field:'isAudit',title:'审核状态',formatter:function(value,row,index){if(value==0)return '未审核';if(value==1)return '审核通过';else return '审核未通过'}},
	                   {field:'aae019',title:'经办人'},
	                   {field:'aae020',title:'经办机构'},
	                  /*  {field:'cabq02',title:'x坐标'},
	                   {field:'cabq03',title:'y坐标'},  */
	                   {field:'aae036',title:'经办日期',formatter:function(value,row,index){if(value)return formateDate(value);}}
					 
      	        	]];
		$('#trainOrgList').bootstrapTable({
			url : '${ctx}/business/dissupport/train/trainOrg/listJson.xf',
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

   /**
    *  封装翻页查询条件
    */
	function getSeachJson(params) {
		return {
			'limit' : params.limit,
			'offset' : params.offset,
			'order' : params.order,
			'orgName' : $("#orgName").val(),
			'aac022' : $("#aac022").val(),
			'orgAccount' : $("#orgAccount").val(),
			'contactsName' : $("#contactsName").val(),
			'contactsTel' : $("#contactsTel").val(),
			'orgType' : $("#orgType").val(),
			'isAudit' : $("#isAudit").val(),
			'isDisable' : $("#isDisable").val()
		};
	}
   
	 function editTOrg(obj){
		   var pxOrgId=$(obj).parent().parent().find("a[id]").attr("id");	  
		   xfui.open_tabs("编辑培训机构信息","${ctx}/business/dissupport/train/trainOrg/edit.xf?pxOrgId="+pxOrgId,"培训机构信息管理");
	    }
	
	function addTrainOrg(){	
		 xfui.open_tabs("添加培训机构信息","${ctx}/business/dissupport/train/trainOrg/add.xf","培训机构信息管理"); 
	}
	
	function editTrainOrg(value){
			var pxOrgId=value;
			xfui.open_tabs("编辑培训机构信息","${ctx}/business/dissupport/train/trainOrg/edit.xf?pxOrgId="+pxOrgId,"培训机构信息管理");
	}
	
	function exportTrainOrg(obj){
		var flag=obj; //1:表示导出选中数据; 2:表示导出全部数据
		var pxOrgId="";
		if(flag==1){
			var row = $('#trainOrgList').bootstrapTable('getAllSelections');
			if(!row||row.length<=0){
				bootbox.alert("请选择要导出的记录");
				return;
			}else{
				$.each(row,function(i,e){
					if(i==0){
						pxOrgId+=e.pxOrgId;
					}else{
						pxOrgId+=","+e.pxOrgId;
					}
				});
			}
		}
		window.location.href="${ctx}/business/dissupport/train/trainOrg/export.xf?pxOrgId="+pxOrgId;
	}
	
	/* function searchLocation(){
		alert(1);
		var row = $('#trainOrgList').bootstrapTable('getAllSelections');
		alert(row.length);
		$.each(row,function(i,e){
			if(i==0){
				alert(e.cabq02);
				alert(e.cabq03);
			}	
		}); 
	} */
	/**
	 *  删除培训机构
	 */
	function delTrainOrg(){
		var pxOrgId="";
		var row = $('#trainOrgList').bootstrapTable('getAllSelections');
		if(!row||row.length<=0){
			bootbox.alert("请选择记录");
			return;
		}else{
			if(row.length>=2){
				bootbox.alert("只能选择一条记录");
				return;
			}else{
				pxOrgId+=row[0].pxOrgId;
			}
		/* 	$.each(row,function(i,e){
				if(i==0){
					
				}else{
					bootbox.alert("只能选择一条记录");
					return;
					pxOrgId+=","+e.pxOrgId;
				}
				
			}); */
		}
		bootbox.confirm({ 
		    size: 'small',
		    message: "您确认想要删除吗", 
		    callback: function(r){ 	    	
		    	 if (r){    
		 	    	$.ajax({ url: '${ctx}/business/dissupport/train/trainOrg/del.xf',
		 	    		data:{pxOrgId:pxOrgId},
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
	/**
	 * 禁用或者解禁培训机构
	 * "1" :表示禁用操作，"2":表示解除禁用操作
	 */
	function disableTrainOrg(value){
		var pxOrgId="";
		var message="";
		/* if(value){
			pxOrgId=value;
		}else{ */
			if(value=='1'){
				message="请确认是否禁用选中的培训机构";
			}else{
				message="请确认是否解禁选中的培训机构";
			}
			var row = $('#trainOrgList').bootstrapTable('getAllSelections');
			if(!row||row.length<=0){
				bootbox.alert('请选择记录');
				return;
			}else{
				if(row.length>=2){
					bootbox.alert("只能选择一条记录");
					return;
				}else{
					pxOrgId+=row[0].pxOrgId;
				}
				/* $.each(row,function(i,e){
					if(i==0){
						pxOrgId+=e.pxOrgId;
					}else{
						bootbox.alert("只能选择一条记录");
						return;
						pxOrgId+=","+e.pxOrgId;
					}
					
				}); */
			}
		//}
		bootbox.confirm({ 
		    size: 'small',
		    message: message, 
		    callback: function(r){ 	    	
		    	 if (r){    
		 	    	$.ajax({ url: '${ctx}/business/dissupport/train/trainOrg/dis.xf',
		 	    		data:{pxOrgId:pxOrgId,flag:value},
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
	
	function doSearch(){
		var params=$("#searchForm").serialize();
		
		$("#trainOrgList").bootstrapTable('refresh', {url:"${ctx}/business/dissupport/train/trainOrg/listJson.xf?"+params});
	}

</script>
</head>
<body>
		<div class="main-container">
			<div class="container-fluid">
				<div class="mhyBody">
					<div class="mhySearch">
					<div class="mhyTitle">
						查询条件
				    </div>
					<form id="searchForm"  class="mhySearchInput">
							<div class="row">
			                    <div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">机构名称：</label>
									<div class="col-xs-10 col-sm-8">
										<input class="form-control" type="text" id="orgName" name="orgName" data-placement="bottom" />
									</div>
								</div>
								<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-2 col-sm-4" for="inputError">机构简码：</label>
										<div class="col-xs-10 col-sm-8">
											<input class="form-control" type="text" id="aac022" name="aac022" data-placement="bottom" />
										</div>
								</div>
								<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-2 col-sm-4" for="inputError">机构账号：</label>
										<div class="col-xs-10 col-sm-8">
											<input class="form-control" type="text" id="orgAccount" name="orgAccount" data-placement="bottom" />
										</div>
								</div>
								<div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">联系人：</label>
									<div class="col-xs-10 col-sm-8">
										<input class="form-control" type="text" id="contactsName" name="contactsName" data-placement="bottom" />
									</div>
								</div>
								<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-2 col-sm-4" for="inputError">手机号：</label>
										<div class="col-xs-10 col-sm-8">
											<input class="form-control" type="text" id="contactsTel" name="contactsTel" data-placement="bottom" />
										</div>
								</div>
							
								<div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">机构类别：</label>
									<div class="col-xs-10 col-sm-8 mhyNoSelect" style="height:32px;">
										<select class="" id="orgType" name="orgType" >
										    <option value="">--请选择--</option>
											<c:forEach items="${orgTypeList}" var="item">
												 <option value="${item.typeId}"> ${item.name} </option>
											</c:forEach>	
									    </select>
								     </div>
								</div>
								
								 <div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">机构审核状态：</label>
									<div class="col-xs-10 col-sm-8 mhyNoSelect" style="height:32px;">
										<select class="" id="isAudit" name="isAudit" >
											<option value=" ">--请选择--</option>
											<option value="0">未审核</option>
											<option value="1">审核通过</option>
											<option value="2">审核未通过</option>
										</select>
									</div>
								 </div> 
								<div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">机构禁用状态：</label>
									<div class="col-xs-10 col-sm-8 mhyNoSelect" style="height:32px;">
										<select class="" id="isDisable" name="isDisable" >
											<option value=" ">--请选择--</option>
											<option value="0">未禁用</option>
											<option value="1">已禁用</option>
										</select>
									</div>
								</div>
								<!-- <div class="col-xs-12 col-sm-4">
										<label class="col-xs-2 col-sm-4" for="inputError">机构注册日期：</label>
										<div class="col-xs-10 input-group col-sm-8"  style="padding-left:15px">
			                              <input class="form-control date-picker dp" id="datepicker01" name="orgEstablishDate" type="text" placeholder="请选择日期"/>
			                              <span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                              </span>
			                           </div>
						        </div>  -->
						        
							    <div class="col-xs-12 col-sm-4 marginbottom20">
									<div class="col-xs-2 col-sm-4"></div>
									<div class="col-xs-10 col-sm-8 mhyBtn">
									<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary mhyBtnLeft" >
									<i class="icon-search"></i>
									查询
									</a>
									<a href="#modal-form" role="button" class="btn btn-info mhyInputReset" >
								<i class="icon-repeat"></i>重置
							</a>
									</div>
								</div>
							</div>
						</form>
					</div>
					
					<div class="mhyMain">
					<div class="mhyTitle">查询结果</div>
					<div class="mhyInfo">
					<div class="mgy10">
											<a href="javascript:void(0)" role="button" onclick="addTrainOrg()" class="btn btn-primary mhyBtnLeft" data-toggle="modal">
											<i class="icon-plus"></i>添加</a>
					<a href="javascript:void(0)" role="button" onclick="delTrainOrg()" class="btn btn-danger mhyBtnLeft" data-toggle="modal">
					<i class="icon-trash"></i>删除</a>
					<a href="javascript:void(0)" role="button" onclick="disableTrainOrg('1')" class="btn btn-grey mhyBtnLeft" data-toggle="modal">
					<i class="icon-ban-circle"></i>
					禁用</a>	
					<a href="javascript:void(0)" role="button" onclick="disableTrainOrg('2')" class="btn btn-inverse mhyBtnLeft" data-toggle="modal">
					<i class="icon-ok-circle"></i>解禁</a>
<!-- 					<a href="javascript:void(0)" role="button" onclick="exportTrainOrg('1')" class="btn btn-grey mhyBtnLeft" >
					<i class="icon-external-link"></i>导出选中</a>
				    <a href="javascript:void(0)" role="button" onclick="exportTrainOrg('2')" class="btn btn-grey" >
				    <i class="icon-external-link"></i>导出全部</a>	 -->
				    
				    
				    
				    
				    						<div class="keep-open btn-group mhyBtnLeft" title="Columns">
							<a href="javascript:void(0)"  role="button" class="btn btn-grey export1 dropdown-toggle" data-toggle="dropdown"><i class="icon-external-link"></i>导出<i class="icon-caret-down"></i></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="javascript:void(0)" onclick="exportTrainOrg('1')">导出选中内容</a></li>
			
								<li><a href="javascript:void(0)" onclick="exportTrainOrg('2')">导出所有记录</a></li>
							</ul>
						</div>
						
				    
				    
				    
					</div>

						<div class="row mhyConter">
							<div class="col-xs-12">
								<div class="table-responsive">
									<table id="trainOrgList"  class="datagridClass"  >
									</table>
								</div>
								<!-- <div style="margin-left: 450px;margin-top: -55px;">
									<a href="javascript:void(0)" role="button" onclick="exportTrainOrg('1')" class="btn btn-primary" >导出选中</a>
				                    <a href="javascript:void(0)" role="button" onclick="exportTrainOrg('2')" class="btn btn-primary" >导出全部</a>	
								</div> -->
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


