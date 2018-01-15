<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入库管理</title>
	<%@include file="/commons/include/commonInc.jsp" %>
	<%@include file="/commons/include/message.jsp" %>
	<script>
	
	   function submit(){
		   
            $("#fm_file").submit();
                  
	   }
	 
	   function checkFileType(str){ 
		   if(!str){
			  return; 
		   }
		    var pos = str.lastIndexOf(".");  
		    var lastname = str.substring(pos,str.length);  
		    var resultName=lastname.toLowerCase();  
		    if ('.xls'!=resultName.toString()&&'.xlsx'!=resultName.toString()){
		    	bootbox.alert('只能上传xls或者xlsx文件，您上传的文件类型为'+lastname+'，请重新上传');  
		    	
		    resetFile();  
		    }  
		}
	   function resetFile(){
		   
		   $("#file").val("");
	   }
	   
	   function   check()   
	   {   
		   var filePath=$("#file").val();
	      if(!filePath) {  
	    	  bootbox.alert("请选择导入文件");  
	              return false;  
	      }else{  
	           return true;  
	      }  
	   }  
	   $(function(){
		   var parentIframe=xfui.getParentIframe();
			if(parentIframe){
				var targetId=$("#targetId").val();
				var columns=parentIframe.dataimp.getColumnArray(targetId);
				$("#columns").val(columns);
			}
	   })
	</script>	
</head>
<body>
<div class="container-fluid">
		<div class="row">
		     	<div class="moduleWrapNob">
				<div class="moduleCont">
					<form id="fm_file" method="post"  onsubmit="return check()" action="${ctx}/sys/component/data/importSave.xf" enctype="multipart/form-data">
						<input  type="hidden" name="serviceId"  value="${serviceId}">
						<input  type="hidden" name="targetId"   id="targetId" value="${targetId}">
						<input  type="hidden" name="columns"   id="columns" value="">						
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>文件:</label>
							<div class="col-xs-9 col-sm-2 required">
								<input class="" data-options="required:true" type="file" name="file" id="file" value="" onchange='checkFileType(this.value)'></input>
							</div>
							
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="bottomBtn">
	   		<div class="h50">&nbsp;</div>
	   		<div class="floatBtn">
		   		<a href="javascript:void(0)" role="button" class="btn  btn-success"  onclick="submit()"><i class="icon-edit"></i>导入</a>
		   		<a href="javascript:void(0)" role="button" class="btn btn-info" onclick="xfui.closeDialog()" data-toggle="modal"><i class="icon-remove"></i>关闭</a>
	   		</div>
	   	</div>
</div>		
</body>
</html>