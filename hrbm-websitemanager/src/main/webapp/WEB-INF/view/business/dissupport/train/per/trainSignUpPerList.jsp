<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>个人报名管理</title>
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
		
		$(".mhyInputReset").click(function(){
			
			$("#searchForm")[0].reset();
		});
	})
	
	function initTable() {
		
		var columns= [[{field:'',title:'Id号',checkbox:'true',width:40,align:'center'},
		            /*    {field:'pxOrgTypeName',title:'机构类别'},
		               {field:'pxOrgName',title:'机构名称'},
	                   {field:'courseTypeName',title:'开班类型'}, */
	                   {field:'courseName',title:'开班名称'},
	                   {field:'userName',title:'个人姓名'},
	                   {field:'userCard',title:'身份证号'},
	                   {field:'phone',title:'联系电话'},
	                   {field:'userSex',title:'个人性别'},
	                   {field:'userNation',title:'所属民族'},
	                   {field:'cczy06',title:'数据来源'},
	                   {field:'signUpStatus',title:'报名状态',formatter:function(value,row,index){if(value==4)return '已报名';else return '未报名'}},
	                   {field:'isCheck',title:'查看状态',formatter:function(value,row,index){if(value==1)return '已查看';else return '未查看'}},
	                   {field:'isContact',title:'联系状态',formatter:function(value,row,index){if(value==1)return '已联系';else return '未联系'}},
	                   {field:'aae036',title:'经办日期',formatter:function(value,row,index){if(value)return formateDate(value);}}
      	        	]];
		$('#trainSignUpPerList').bootstrapTable({
			url : '${ctx}/business/dissupport/train/trainSignUp/per/listJson.xf?orgId=${orgId}&pxCourseId=${pxCourseId}',
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
			'courseName' : $("#courseName").val(),
			'courseType' : $("#courseType").val(),
			'orgType' : $("#orgType").val(),
			'pxOrgId' : $("#pxOrgId").val(),
			'orgName' :$('#orgName').val(),
			'name' : $("#name").val(),
			'aac004' : $("#aac004").val(),
			'phone' : $("#phone").val()
		};
	}
	
	function exportTrainSignUp(obj){
		var flag=obj; //1:表示导出选中数据; 2:表示导出全部数据
		var pxSignUpId="";
		if(flag==1){
			var row = $('#trainSignUpPerList').bootstrapTable('getAllSelections');
			if(!row||row.length<=0){
				bootbox.alert("请选择要导出的记录");
				return;
			}else{
				$.each(row,function(i,e){
					if(i==0){
						pxSignUpId+=e.pxSignUpId;
					}else{
						pxSignUpId+=","+e.pxSignUpId;
					}
				});
			}
		}
		window.location.href="${ctx}/business/dissupport/train/trainSignUp/per/export.xf?pxCourseId=${pxCourseId}&pxSignUpId="+pxSignUpId+"&orgId=${orgId}";
	}
	
	function refreshTable(){
		if(leftClickTreeNode){
			var id=leftClickTreeNode.id;
			$('#trainSignUpPerList').bootstrapTable('refresh', {query:{
				colId: id
			  }				
			});
		}else{
			$('#laborColList').bootstrapTable('refresh');
		}				
	} 
	
	/**
	 * 查看标记
	 */
	function checkTrainSignUp(){
		var pxSignUpId="";
		var row = $('#trainSignUpPerList').bootstrapTable('getAllSelections');
		if(!row||row.length<=0){
			bootbox.alert("请选择要标记的记录");
			return;
		}else{
			$.each(row,function(i,e){
				if(i==0){
					pxSignUpId+=e.pxSignUpId;
				}else{
					pxSignUpId+=","+e.pxSignUpId;
				}
			});
		}
		bootbox.confirm({ 
		    size: 'small',
		    message: "请确认是否标记为已查看", 
		    callback: function(r){ 	    	
		    	 if (r){   
		 	    	$.ajax({ url: '${ctx}/business/dissupport/train/trainSignUp/per/updateBatch.xf',
		 	    		data:{pxSignUpId:pxSignUpId,flag:"1"},
		 	    		dataType:'json',
		 	    		success: function(data){
		 	    			if(data.result){
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
	
	/**
	 * 联系标记
	 */
	function contactTrainSignUp(){
		var pxSignUpId="";
		var row = $('#trainSignUpPerList').bootstrapTable('getAllSelections');
		if(!row||row.length<=0){
			bootbox.alert("请选择要标记的记录");
			return;
		}else{
			$.each(row,function(i,e){
				if(i==0){
					pxSignUpId+=e.pxSignUpId;
				}else{
					pxSignUpId+=","+e.pxSignUpId;
				}
			});
		}
		bootbox.confirm({ 
		    size: 'small',
		    message: "请确认是否标记为已联系", 
		    callback: function(r){ 	    	
		    	 if (r){   
		 	    	$.ajax({ url: '${ctx}/business/dissupport/train/trainSignUp/per/updateBatch.xf',
		 	    		data:{pxSignUpId:pxSignUpId,flag:"2"},
		 	    		dataType:'json',
		 	    		success: function(data){
		 	    			if(data.result){
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
	
	function refresh(){
		$("#trainSignUpPerList").bootstrapTable('refresh');
	}
	
	function doSearch(){
		/* var json = $("#searchForm").serializeJson();
		json["offset"]=0;
		$("#trainSignUpPerList").bootstrapTable('refresh', {	
			query: json
		}) */
		var params=$("#searchForm").serialize();
		
		$("#trainSignUpPerList").bootstrapTable('refresh', {url:"${ctx}/business/dissupport/train/trainSignUp/per/listJson.xf?orgId=${orgId}&pxCourseId=${pxCourseId}&"+params});
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
			                 <%--    <div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">机构类别：</label>
									<div class="col-xs-10 col-sm-8 mhyNoSelect">
										<select class="" id="orgType" name="orgType" >
											    <option value="">--请选择--</option>
												<c:forEach items="${orgTypeList}" var="item">
													 <option value="${item.typeId}"> ${item.name} </option>
												</c:forEach>	
										 </select>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-2 col-sm-4" for="inputError">机构名称：</label>
										<div class="col-xs-10 col-sm-8">
											<input class="form-control" type="text" id="orgName" name="orgName" data-placement="bottom" />
										</div>
								</div>
								<div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">开班类型：</label>
									<div class="col-xs-10 col-sm-8 mhyNoSelect">
										<select class="form-control" id="courseType" name="courseType" >
											    <option value="">--请选择--</option>
												<c:forEach items="${courseTypeList}" var="item">
													 <option value="${item.typeId}"> ${item.name} </option> 
												</c:forEach>	
										</select>
									</div>
								</div> --%>
								<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-2 col-sm-4" for="inputError">开班名称：</label>
										<div class="col-xs-10 col-sm-8">
											<input class="form-control" type="text" id="courseName" name="courseName" data-placement="bottom" />
										</div>
								</div>
							
								<div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">报名姓名：</label>
									<div class="col-xs-10 col-sm-8">
											<input class="form-control" type="text" id="name" name="name" data-placement="bottom" />
									</div>
								</div>
								
								<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-2 col-sm-4" for="inputError">联系电话：</label>
										<div class="col-xs-10 col-sm-8">
												<input class="form-control" type="text" id="phone" name="phone" data-placement="bottom" />
										</div>
								</div>
								
								 <div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">报名性别：</label>
									<div class="col-xs-10 col-sm-8 mhyNoSelect">
										<xf:select textField="name" tableName="TAB_SEX" hasDefault="0" id="aac004" name="aac004" valueField="code"></xf:select>  
									</div>
								 </div> 
								 
								 <div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">查看状态：</label>
									<div class="col-xs-10 col-sm-8 mhyNoSelect">
										<select class="form-control" id="isCheck" name="isCheck" >
											<option value=" ">--请选择--</option>
											<option value="0">未查看</option>
											<option value="1">已查看</option>
										</select>
									</div>
								 </div> 
								 
								 <div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">联系状态：</label>
									<div class="col-xs-10 col-sm-8 mhyNoSelect">
										<select class="form-control" id="isContact" name="isContact" >
											<option value=" ">--请选择--</option>
											<option value="0">未联系</option>
											<option value="1">已联系</option>
										</select>
									</div>
								  </div> 
								
							    <div class="col-xs-12 col-sm-12 marginbottom20">
									<div class="col-xs-2 col-sm-4"></div>
									<div class="col-xs-10 col-sm-8 mhyBtn">
									<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary mhyBtnLeft" >
									<i class="icon-search"></i>
									查询</a>
									<a href="#modal-form" role="button" class="btn btn-info mhyInputReset" >
								<i class="icon-repeat"></i>重置
							</a></div>
								</div>
							</div>
						</form>
					</div> 
					
					<div class="mhyMain">
					<div class="mhyTitle">查询结果</div>
					<div class="mhyInfo">
					<div class="mgy10">
					<a href="javascript:void(0)" onclick="checkTrainSignUp()" role="button" class="btn btn-primary mhyBtnLeft" data-toggle="modal"><i class="icon-bookmark"></i>查看标记</a>
					<a href="javascript:void(0)" onclick="contactTrainSignUp()" role="button" class="btn btn-info mhyBtnLeft" data-toggle="modal"><i class="icon-phone"></i>联系标记</a>
					
<!-- 					<a href="javascript:void(0)" onclick="exportTrainSignUp('1')" role="button" class="btn btn-grey mhyBtnLeft" data-toggle="modal"><i class="icon-external-link"></i>导出选中</a>
					<a href="javascript:void(0)" onclick="exportTrainSignUp('2')" role="button" class="btn btn-grey" data-toggle="modal"><i class="icon-external-link"></i>导出全部</a>
						 -->
						
						
						<div class="keep-open btn-group mhyBtnLeft" title="Columns">
							<a href="javascript:void(0)"  role="button" class="btn btn-grey export1 dropdown-toggle" data-toggle="dropdown"><i class="icon-external-link"></i>导出<i class="icon-caret-down"></i></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="javascript:void(0)" onclick="exportTrainSignUp('1')">导出选中内容</a></li>
			
								<li><a href="javascript:void(0)" onclick="exportTrainSignUp('2')">导出所有记录</a></li>
							</ul>
						</div>
						
						
						</div><div class="row mhyConter">
							<div class="col-xs-12">
								<div class="table-responsive">
									<table id="trainSignUpPerList"  class="datagridClass"  >
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


