<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>开班信息管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<%@include file="/commons/include/bootstrapInc.jsp" %>
<style type="text/css">
  #trainCourseList td {white-space: nowrap;}
</style>
<script>
var flag=false;
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
	                
	                   {field:'pxCourseId',title:'操作',width:80,formatter: function(value,row,index){	 
				           return "<a class='mhyNoA' href=\"javascript:void(0)\" id=\'"+value+"'\" onclick=\"editTrainCourse('"+value+"')\" ><i class='icon-pencil' title='编辑'></i></a>"+
				              "<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"goSignUp('"+value+"')\" ><i class='icon-zoom-in' title='查看报名'></i></a>";
							}
					 },
		               {field:'pxOrgName',title:'所属机构'},
		               {field:'courseName',title:'开班名称'/* ,formatter: function(value,row,index){	 
				           return "<a href=\"javascript:void(0)\" onclick=\"editTCourse(this)\" >"+value+"</a>";
						} */},
	                   {field:'aac022',title:'名称简码'},
	                   {field:'courseType',title:'开班类别'},
	                   {field:'contactsName',title:'联系人'},
	                   {field:'contactsTel',title:'联系电话'},
	                   {field:'cost',title:'培训费用'},
	                   {field:'courseStartTime',title:'开班时间'},
	                   {field:'coursePeriod',title:'学习周期'},
	                   /* {field:'courseAddr',title:'培训地点'},
	                   {field:'courseFeature',title:'培训特色'},
	                   {field:'courseContent',title:'培训内容'}, */
	                   {field:'isDisable',title:'禁用状态',formatter:function(value,row,index){if(value==1)return '是';else return '否'}},
	                   {field:'isAudit',title:'审核状态',formatter:function(value,row,index){if(value==0)return '未审核';if(value==1)return '审核通过';else return '审核未通过'}},
	                   {field:'acb208',title:'冻结状态',formatter:function(value,row,index){if(value==1)return '是';else return '否'}},
	                   {field:'aae019',title:'经办人'},
	                   {field:'aae020',title:'经办机构'},
	                   {field:'aae036',title:'经办日期',formatter:function(value,row,index){if(value)return formateDate(value);}}
      	        	]];
		$('#trainCourseList').bootstrapTable({
			url : '${ctx}/business/dissupport/train/trainCourse/listJson.xf',
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
			'aac022' : $("#aac022").val(),
			'courseType' : $("#courseType").val(),
			'contactsName' : $("#contactsName").val(),
			'contactsTel' : $("#contactsTel").val(),
			'pxOrgId' : $("#pxOrgId").val(),
			'isAudit' : $("#isAudit").val(),
			'isDisable' : $("#isDisable").val()
		};
	}
	
    function editTCourse(obj){
	   var pxCourseId=$(obj).parent().parent().find("a[id]").attr("id");	  
	   xfui.open_tabs("编辑开班信息","${ctx}/business/dissupport/train/trainCourse/edit.xf?pxCourseId="+pxCourseId,"开班信息管理");
    }
	/**
	 * 查看单个开班对应的个人报名信息
	 */
	 function goSignUp(obj){
		var courseId=obj;
		xfui.open_tabs("个人报名管理","${ctx}/business/dissupport/train/trainSignUp/list.xf?courseId="+courseId,"个人报名信息管理"); 
	}
   
	function addTrainCourse(){	
		 xfui.open_tabs("添加开班信息","${ctx}/business/dissupport/train/trainCourse/add.xf","开班信息管理"); 
	}
	
	function editTrainCourse(value){
			var pxCourseId=value;
			xfui.open_tabs("编辑开班信息","${ctx}/business/dissupport/train/trainCourse/edit.xf?pxCourseId="+pxCourseId,"开班信息管理");
	}
	
	function exportTrainCourse(obj){
		var flag=obj; //1:表示导出选中数据; 2:表示导出全部数据
		var pxCourseId="";
		if(flag==1){
			var row = $('#trainCourseList').bootstrapTable('getAllSelections');
			if(!row||row.length<=0){
				bootbox.alert("请选择要导出的记录");
				return;
			}else{
				$.each(row,function(i,e){
					if(i==0){
						pxCourseId+=e.pxCourseId;
					}else{
						pxCourseId+=","+e.pxCourseId;
					}
				});
			}
		}
		window.location.href="${ctx}/business/dissupport/train/trainCourse/export.xf?pxCourseId="+pxCourseId;
	}
	
	function updateTrainCourse(obj){
		var info="";
		var flag=obj;
		if(flag=='del'){
			info="删除";
		}else if(flag=='disable'){
			info="禁用";
		}else{
			info="冻结";
		}
		var pxCourseId="";
		var row = $('#trainCourseList').bootstrapTable('getAllSelections');
		if(!row||row.length<=0){
			bootbox.alert("请选择记录");
			return;
		}else{
			if(row.length>=2){
				bootbox.alert("只能选择一条记录");
				return;
			}else{
				pxCourseId+=row[0].pxCourseId;
			}
			
			/* $.each(row,function(i,e){
				if(i==0){
					pxCourseId+=e.pxCourseId;
				}else{
					pxCourseId+=","+e.pxCourseId;
				}
				
			}); */
		}
		bootbox.confirm({ 
		    size: 'small',
		    message: "请确认是否"+info+"选中的培训班", 
		    callback: function(r){ 	    	
		    	 if (r){    
		 	    	$.ajax({ url: '${ctx}/business/dissupport/train/trainCourse/update.xf',
		 	    		data:{pxCourseId:pxCourseId,flag:flag},
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
	 *  解禁已禁用的开班信息
	 */
	function enableTrainCourse(){
		
		var pxCourseId="";
		var row = $('#trainCourseList').bootstrapTable('getAllSelections');
		if(!row||row.length<=0){
			bootbox.alert("请选择记录");
			return;
		}else{
			if(row.length>=2){
				bootbox.alert("只能选择一条记录");
				return;
			}else{
				pxCourseId+=row[0].pxCourseId;
			}
			
			/* $.each(row,function(i,e){
				if(i==0){
					pxCourseId+=e.pxCourseId;
				}else{
					pxCourseId+=","+e.pxCourseId;
				}
				
			}); */
		}
		bootbox.confirm({ 
		    size: 'small',
		    message: "请确认是否解禁选中的培训班", 
		    callback: function(r){ 	    	
		    	 if (r){    
		 	    	$.ajax({ url: '${ctx}/business/dissupport/train/trainCourse/enable.xf',
		 	    		data:{pxCourseId:pxCourseId},
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
			$('#trainCourseList').bootstrapTable('refresh', {query:{
				colId: id
			  }				
			});
		}else{
			$('#laborColList').bootstrapTable('refresh');
		}				
	} 
	
	function refresh(){
		$("#trainCourseList").bootstrapTable('refresh');
	}
	
	function doSearch(){
		/*  var json = $("#searchForm").serializeJson();
		json["offset"]=0; 
		$("#trainCourseList").bootstrapTable('refresh', {	
			query: json
		}) */
        var params=$("#searchForm").serialize();
		
		$("#trainCourseList").bootstrapTable('refresh', 
				{url:"${ctx}/business/dissupport/train/trainCourse/listJson.xf?"+params});
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
									<label class="col-xs-2 col-sm-4" for="inputError">开班名称：</label>
									<div class="col-xs-10 col-sm-8">
										<input class="form-control" type="text" id="courseName" name="courseName" data-placement="bottom" />
									</div>
								</div>
								<div class="col-xs-12 col-sm-4" >
										<label class="col-xs-2 col-sm-4" for="inputError">名称简码：</label>
										<div class="col-xs-10 col-sm-8">
											<input class="form-control" type="text" id="aac022" name="aac022" data-placement="bottom" />
										</div>
								</div>
								
								<div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">开班类别：</label>
									<div class="col-xs-10 col-sm-8 mhyNoSelect">
										<select class="form-control" id="courseType" name="courseType" >
										    <option value="">--请选择--</option>
											<c:forEach items="${courseTypeList}" var="item">
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
										<label class="col-xs-2 col-sm-4" for="inputError">手机号：</label>
										<div class="col-xs-10 col-sm-8">
											<input class="form-control" type="text" id="contactsTel" name="contactsTel" data-placement="bottom" />
										</div>
								</div>
							
								<div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">所属机构：</label>
									<div class="col-xs-10 col-sm-8 mhyNoSelect">
										<select class="form-control" id="pxOrgId" name="pxOrgId" >
										    <option value="">--请选择--</option>
											<c:forEach items="${orgList}" var="item">
												 <option value="${item.pxOrgId}"> ${item.orgName} </option> 
											</c:forEach>	
										</select>
										<%-- <xf:select textField="org_name" tableName="PX_ORG" hasDefault="0" name="pxOrgId" valueField="px_org_id"></xf:select>   --%>
									</div>
								</div>
								
								 <div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">开班审核状态：</label>
									<div class="col-xs-10 col-sm-8 mhyNoSelect">
										<select class="form-control" id="isAudit" name="isAudit" >
											<option value=" ">--请选择--</option>
											<option value="0">未审核</option>
											<option value="1">审核通过</option>
											<option value="2">审核未通过</option>
										</select>
									</div>
								 </div> 
								 
								  <div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">开班禁用状态：</label>
									<div class="col-xs-10 col-sm-8 mhyNoSelect">
										<select class="form-control" id="isDisable" name="isDisable" >
											<option value=" ">--请选择--</option>
											<option value="0">未禁用</option>
											<option value="1">已禁用</option>
										</select>
									</div>
								 </div> 
								 
							<!-- 	<div class="col-xs-12 col-sm-4" >
									<label class="col-xs-2 col-sm-4" for="inputError">开班冻结状态：</label>
									<div class="col-xs-10 col-sm-8 mhyNoSelect">
										<select class="" id="" name="acb208" >
											<option value=" ">--请选择--</option>
											<option value="0">未冻结</option>
											<option value="1">已冻结</option>
										</select>
									</div>
								</div> -->
								<!-- <div class="col-xs-12 col-sm-4">
										<label class="col-xs-2 col-sm-4" for="inputError">开班时间：</label>
										<div class="col-xs-10 input-group col-sm-8"  style="padding-left:15px">
			                              <input class="form-control date-picker dp" id="datepicker01" name="courseStartTime" type="text" placeholder="请选择日期"/>
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
									查询</a>
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
					<a href="javascript:void(0)" role="button" onclick="addTrainCourse()" class="btn btn-primary mhyBtnLeft" data-toggle="modal">
					<i class="icon-plus"></i>
					添加</a>
					<a href="javascript:void(0)" role="button" onclick="updateTrainCourse('del')" class="btn btn-danger mhyBtnLeft" data-toggle="modal">
					<i class="icon-trash"></i>删除</a>
                    <a href="javascript:void(0)" role="button" onclick="updateTrainCourse('disable')" class="btn btn-grey mhyBtnLeft" data-toggle="modal">
                    <i class="icon-ban-circle"></i>禁用</a>
                    <a href="javascript:void(0)" role="button" onclick="enableTrainCourse()" class="btn btn-inverse mhyBtnLeft" data-toggle="modal">
                    <i class="icon-ok-circle"></i>解禁</a> 	
                    
                     	
<!-- 					<a href="javascript:void(0)" onclick="exportTrainCourse('1')" role="button" class="btn btn-grey mhyBtnLeft" data-toggle="modal">
					 <i class="icon-external-link"></i>导出选中</a>
					<a href="javascript:void(0)" onclick="exportTrainCourse('2')" role="button" class="btn btn-grey" data-toggle="modal">
					 <i class="icon-external-link"></i>导出全部</a> -->
					 
					 <div class="keep-open btn-group mhyBtnLeft" title="Columns">
							<a href="javascript:void(0)"  role="button" class="btn btn-grey export1 dropdown-toggle" data-toggle="dropdown"><i class="icon-external-link"></i>导出<i class="icon-caret-down"></i></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="javascript:void(0)" onclick="exportTrainCourse('1')">导出选中内容</a></li>
			
								<li><a href="javascript:void(0)" onclick="exportTrainCourse('2')">导出所有记录</a></li>
							</ul>
						</div>
					 
					 
					 </div>
					<!-- <a href="javascript:void(0)" role="button" onclick="updateTrainCourse('freeze')" class="btn btn-primary" data-toggle="modal">冻结</a>	 -->
						
						<div class="row mhyConter">
							<div class="col-xs-12">
							<div class="table-responsive">
									<table id="trainCourseList"  class="datagridClass"  >
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

	$(function() {
		/**双击任一行进入编辑页面*/
		 $("table > tbody > tr").click(function () {
			 alert(1);
		       // alert(this.pxCourseId);
		    });
	})

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


