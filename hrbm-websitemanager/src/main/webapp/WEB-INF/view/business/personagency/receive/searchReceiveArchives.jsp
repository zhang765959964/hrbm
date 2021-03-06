<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>个人档案接收查询页面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
    <script type="text/javascript" src="${ctx}/js/ui/xf.idcard.js?v=2016091916340"></script>
	<script type="text/javascript" src="${ctx}/js/ui/xf.seccard.js?v=201609191639"></script>
<script type="text/javascript">
	$(function() {
		 var columns= [
						{field:'AAC002',title:'身份证号',width:100,align:'center'},
	                    {field:'AAC003',title:'姓名',width:100,align:'center'},
	                    {field:'ARCHIVECODE',title:'档案编号',width:100,align:'center'}
     	        	];
		 $("#personCard").selectcommon({
			 url:'${ctx}/business/personagency/archive/archives/searchPersonAndArchives.xf',
			 columns: columns,
			 callBack:function(data){
				 if(!data){
					 bootbox.confirm({  
					        buttons: {  
					            confirm: {  
					                label: '否',  
					                className: 'btn-myStyle'  
					            },  
					            cancel: {  
					                label: '是',  
					                className: 'btn btn-primary'  
					            }  
					        },  
					        message: '当前没有该个人信息，是不是需要添加？',  
					        callback: function(result) {  
					            if(result) {  
					            	
					            } else {  
					            	//添加个人信息
						    		xfui.open_dialog({
						    		    title: '添加个人基本信息',
						    		    width: 1000,
						    		    height: 600,
						    		    closed: false,
						    		    cache: false,
						    		    url: "${ctx}/business/personagency/person/personBaseInfo/index.xf?cczy06=16",
						    		    modal: true
						    		})
					            }  
					        }
					}) 
				 }else{
					 if(data.ARCHIVESTATUS==2){
						 bootbox.confirm({  
						        buttons: {  
						            confirm: {  
						                label: '否',  
						                className: 'btn-myStyle'  
						            },  
						            cancel: {  
						                label: '是',  
						                className: 'btn btn-primary'  
						            }  
						        },  
						        message: '当前档案已经调出，是不是需要重新接收？',  
						        callback: function(result) {  
						            if(result) {  
						            	
						            } else {  
						            	$("#receiveArchivesResultList").load("${ctx}/business/personagency/receive/receive/resultList.xf?type=2&personId="+ data.AAC001 );
						            }  
						        }
						}) 
					 }else{
						 loadPage(data.AAC001);
					 }
				 }
			}
		 })
		 
	   $("#idcard").idcard({callBack:function(personId,data){
		 	var aac002 = data.aac002;
		    $("#personCard").val(aac002);
		    $(".singleSearchBtn").click();
	   }})
	   
	   $("#seccard").seccard({callBack:function(personId,data){
			var aac002 = data.aac002;
		    $("#personCard").val(aac002);
		    $(".singleSearchBtn").click();
	   	}})
		 
	  $("#receiveArchivesResultList").load("${ctx}/business/personagency/receive/receive/resultList.xf");
	})
	function doSearch() {
		 var personId = $("#personId").val();
		 $("#receiveArchivesResultList").load("${ctx}/business/personagency/receive/receive/resultList.xf?personId="+ personId);
	}
	function loadPage(personId){
		$("#receiveArchivesResultList").load("${ctx}/business/personagency/receive/receive/resultList.xf?personId="+ personId);
	}
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 pd0 tar">
				<div class="col-xs-6 col-sm-6">
					<a href="javascript:void(0)" role="button" class="btn btn-info" data-toggle="modal" id="seccard">社保卡已配置</a>
					<a href="javascript:void(0)" role="button" class="btn" data-toggle="modal" id="idcard">身份证未配置</a>
				</div>
				<div class="col-xs-6 col-sm-6">
					<label class="col-xs-3 col-sm-2" for="inputError">查询:</label>
					<div class="col-xs-6 col-sm-7 pr">
						<input class="form-control" placeholder="请输入身份证号或档案编号" type="text" name="personCard" id="personCard"/>
					</div>
				</div>
			</div>
		</div>
		<div id="receiveArchivesResultList"></div>
	</div>
</body>
</html>