<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>培训机构审核</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<%@include file="/commons/include/bootstrapInc.jsp" %>
<style type="text/css">
  #disAuditTrainOrgList td {white-space: nowrap;}
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
	                   {field:'orgName',title:'机构名称'},
	                   {field:'orgAccount',title:'机构帐号'},
	                   {field:'orgPwd',title:'机构密码'},
	                   {field:'contactsName',title:'联系人'},
	                   {field:'contactsTel',title:'联系电话'},
	                   {field:'orgType',title:'机构类别'},
	                   {field:'orgCertificateId',title:'机构证件号'},
	                   {field:'orgLegalPersonId',title:'法人身份证'},
	                   {field:'isDisable',title:'禁用状态',formatter:function(value,row,index){if(value==1)return '是';else return '否'}},
	                   {field:'isAudit',title:'审核状态',formatter:function(value,row,index){if(value==0)return '未审核';if(value==1)return '审核通过';else return '审核未通过'}},
	                   {field:'aae019',title:'经办人'},
	                   {field:'aae036',title:'经办时间',formatter:function(value,row,index){if(value)return formateDate(value);}},
	                   {field:'aae020',title:'经办机构'},
	                   {field:'cczy06',title:'数据来源'},
	                   {field:'abb772',title:'审核意见'},
	                   {field:'abb769',title:'审核人'},
	                   {field:'abb770',title:'审核机构'},
	                   {field:'abb771',title:'审核时间',formatter:function(value,row,index){if(value)return formateDate(value);}}
	                   
      	        	]];
		$('#disAuditTrainOrgList').bootstrapTable({
			url : '${ctx}/business/dissupport/train/trainOrg/disAuditListJson.xf',
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
			'orgAccount' : $("#orgAccount").val(),
			'contactsName' : $("#contactsName").val(),
			'cczy06' : $("#cczy06").val(),
			'orgType' : $("#orgType").val(),
			'aae036' : $("#datepicker01").val(),
			'isAudit' : $("#isAudit").val(),
			'isDisable' : $("#isDisable").val()
		};
	}
	
	function refreshTable(){

		if(leftClickTreeNode){
			var id=leftClickTreeNode.id;
			$('#disAuditTrainOrgList').bootstrapTable('refresh', {query:{
				colId: id
			  }				
			});
		}else{
			$('#laborColList').bootstrapTable('refresh');
		}				
	} 
	
	function refresh(){
		$('#abb772').val("");
		$("#disAuditTrainOrgList").bootstrapTable('refresh');
	}
	
	function doSearch(){
		$('#abb772').val("");
		/* var json = $("#searchForm").serializeJson();
		json["offset"]=0;
		$("#disAuditTrainOrgList").bootstrapTable('refresh', {	
			query: json
		}) */
        var params=$("#searchForm").serialize();
		
		$("#disAuditTrainOrgList").bootstrapTable('refresh', 
				{url:"${ctx}/business/dissupport/train/trainOrg/disAuditListJson.xf?"+params});
	}
	
	function auditTrainOrg(obj){
		var pxOrgIds="";
		var abb772=encodeURI($('#abb772').val().trim());//审核意见
		var flag=obj;
		var row = $('#disAuditTrainOrgList').bootstrapTable('getAllSelections');
		if(!row||row.length<=0){
			bootbox.alert('请选择记录');
			return;
		}else{
			$.each(row,function(i,e){
				if(i==0){
					pxOrgIds+=e.pxOrgId;
				}else{
					pxOrgIds+=","+e.pxOrgId;
				}
			});
		}
		var message="";
		if(flag=='1'){
			message="您确认审核通过吗";
		}else{
			message="您确认审核不通过吗";
		}
		bootbox.confirm({ 
		    size: 'small',
		    message: message, 
		    callback: function(r){ 	    	
		    	 if (r){ 
		 	    	$.ajax({ url:'${ctx}/business/dissupport/train/trainOrg/audit.xf',
		 	    		data:{pxOrgIds:pxOrgIds,flag:flag,abb772:abb772},
		 	    		dataType:'json',
		 	    		success: function(data){ 
		 	    			if(data.result){
		 	    				$('#abb772').val("");
		 	    				bootbox.alert(data.message);
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
					<form id="searchForm" class="mhySearchInput">
							<div class="row">
			                    <div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">机构名称：</label>
									<div class="col-xs-10 col-sm-8">
										<input class="form-control" type="text" name="orgName" data-placement="bottom" />
									</div>
								</div>
								
								<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-2 col-sm-4" for="inputError">机构账号：</label>
										<div class="col-xs-10 col-sm-8">
											<input class="form-control" type="text" id="orgAccount" name="orgAccount" data-placement="bottom" />
										</div>
								</div>
								
								 <div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">机构类别：</label>
									<div class="col-xs-10 col-sm-8 mhyNoSelect">
										<select class="form-control" id="orgType" name="orgType" >
										    <option value="">--请选择--</option>
											<c:forEach items="${orgTypeList}" var="item">
												 <option value="${item.typeId}"> ${item.name} </option>
											</c:forEach>	
									    </select>
								     </div>
								</div> 
								
								<div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">联系人：</label>
									<div class="col-xs-10 col-sm-8">
										<input class="form-control" type="text" id="contactsName" name="contactsName" data-placement="bottom" />
									</div>
								</div>
								
							    <div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">经办日期：</label>
									<div class="col-xs-10 input-group col-sm-8" style="padding-left:15px">
		                              <input class="form-control date-picker dp" id="datepicker01" name="aae036" type="text" placeholder="请选择日期"/>
		                              <span class="input-group-addon">
		                                  <i class="icon-calendar bigger-110"></i>
		                              </span>
		                           </div>
					            </div>
								
								<div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">禁用状态：</label>
									<div class="col-xs-10 col-sm-8 mhyNoSelect">
										<select class="form-control" id="isDisable" name="isDisable" >
										    <option value=" ">--请选择--</option>
											<option value="0">未禁用</option>
											<option value="1">已禁用</option>
										</select>
									</div>
								</div>
								
								<div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">审核状态：</label>
									<div class="col-xs-10 col-sm-8 mhyNoSelect">
										<select class="form-control" id="isAudit" name="isAudit" >
											<option value="0" selected="selected">未审核</option>
											<option value="1">审核通过</option>
											<option value="2">审核未通过</option>
										</select>
									</div>
								 </div>  
								 
								 <div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">数据来源：</label>
									<div class="col-xs-10 col-sm-8 mhyNoSelect">
										<xf:select textField="name" tableName="TAB_DATASOURCES" id="cczy06" name="cczy06" valueField="code" hasDefault="0"></xf:select> 
									</div>
								 </div> 
								 
								 <div class="col-xs-12 col-sm-4 marginbottom20">
									<div class="col-xs-2 col-sm-4"></div>
									<div class="col-xs-10 col-sm-8 mhyBtn">
									<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary mhyBtnLeft" >
										<i class="icon-search"></i>
									查询
									</a>
									<a href="#modal-form" role="button" class="btn btn-info mhyInputReset" >
										<i class="icon-repeat"></i>
										重置
									</a>
									
									</div>
								 </div>
								
							</div>
						</form>
					</div>
					
					<div class="mhySearch1">
			            <div class="mhyTitle"> 审核操作 </div>
						<div class="mhySearchInput">
							<div class="row">
								<div class="col-xs-12 col-sm-8" >
									<label class="col-xs-2 col-sm-2" for="inputError">审核说明：</label>
									<div class="col-xs-10 col-sm-10">
										<input class="form-control" type="text"  id="abb772" name="abb772" value=""  placeholder="审核说明长度不能超出50字" data-placement="bottom" maxlength="50"/>
								    </div>
								</div>
								
								 <div class="col-xs-12 col-sm-4 marginbottom20">
									
									<div class="col-xs-12 col-sm-12 mhyBtn">
										<a href="#modal-form" role="button" onclick="auditTrainOrg('1')" class="btn btn-success mhyBtnLeft" >
										<i class="icon-check"></i>
										审核通过
										</a>
									    <a href="#modal-form" role="button" onclick="auditTrainOrg('2')" class="btn btn-default btn-border1" >
									   <i class="icon-remove"></i>
									    审核不通过
									    </a>
									</div>
								 </div>
							</div>
						</div>
		            </div>
					
					<div class="mhyMain">
						<div class="mhyTitle">查询结果</div>
						<div class="mhyInfo">
						<!-- <a href="#modal-form" role="button" class="btn btn-primary" ><i class="icon-external-link align-top bigger-125"></i>导出</a> -->
							<div class="row mhyConter">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table id="disAuditTrainOrgList"  class="datagridClass"  >
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


