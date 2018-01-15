 <%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="${ctx}/styles/erecold/css/navstyle.css" type="text/css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>校园风采</title>
	<%@include file="/commons/include/common.jsp" %>
	<script type="text/javascript" src="${ctx}/js/lib/jquery/jquery.messager.js"></script>
	<script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/ueditor.all.js"></script>
	<script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript" src="${ctx}/js/lib/ajaxfileupload/ajaxfileupload.js"></script>
</head>
<script type="text/javascript">
	$(function(){
	    //上传图片
	    $("#btnUpload").click(function() {
	       ajaxFileUpload();
	    });
	    loadAlreadyCataLog(1,14);
	 });
	function ajaxFileUpload() {
		  if(!isValidateFile()){
			  return;
		  }
	     // 开始上传文件时显示一个图片
	     $("#wait_loading").ajaxStart(function() {
	         $(this).show();
	     // 文件上传完成将图片隐藏起来
	     }).ajaxComplete(function() {
	         $(this).hide();
	     });
	     var elementIds=["flag"];        //flag为id、name属性名
	     $.ajaxFileUpload({
	         url: 'fileUpload.xf', 
	         type: 'post',
	         secureuri: false,          //一般设置为false
	         fileElementId: 'file',      // 上传文件的id、name属性名
	         dataType: 'text',           //返回值类型，一般设置为json、application/json
	         elementIds: elementIds,    //传递参数到服务器
	         success: function(data, status){  
	      	 	 $("#imgContext").empty() ;   		 
	    		 $("#imgContext").append("<img  src=\"getImageById.xf?filePath="+data+"\"  width=\"200px\"  height=\"200px\"/>")
	    		 $("#filePath").val(data);
	    		 $("#showSave").show();
	         },
	         error: function(data, status, e){ 
	      	   $.messager.alert('系统提示',e) ;
	         }
	     });
	     //return false;
	 }
	
	  function isValidateFile(obj){   
		  var fileValue= $("#file").val();
		  if(!fileValue){
			  $.messager.alert('系统提示',"请选择图片") ;
			  return false;
		  }
		  var extend = fileValue.substring(fileValue.lastIndexOf(".")+1);    
		  if(extend==""){  
			  $.messager.alert('系统提示',"请选择图片") ;
			  return false;
		  }else{    
			   if(!(extend=="jpg"||extend=="gif"||extend=="bmp"||extend=="png")){    
			      $.messager.alert('系统提示',"请上传后缀名为jpg/gif/bmp/png的文件!") ;
			      return false;    
			   }    
		  }    
		  return true;    
	}
	  function loadAlreadyCataLog(page,rows){
			if(!page){
				page=1
			}
			if(!rows){
				rows=14
			}
			$("#alreadyCollect").load("${ctx}/sys/attachment/attachment/alreadyColl.xf?page="+page+"&rows="+rows,function(response,status,xhr){
				$("#currentPageShow").text($("#currentPage").val());
				$("#totalPageShow").text($("#totalPage").val());
				if($("#isHasPreviousPage").val()=="false"){
					$('#prePage').linkbutton('disable');
				}else{
					$('#prePage').linkbutton('enable');
				}
				if($("#isHasNextPage").val()=="false"){
					$('#nextPage').linkbutton('disable');
				}else{
					$('#nextPage').linkbutton('enable');
				}
			});
		}
	  
	//全部选中
	function selectAll(divId){
		$("#"+divId).find("input[type='checkbox']").each(function(){
			this.checked = true
		})

	}
	//全部取消
	function releaseAll(divId){
		$("#"+divId).find("input[type='checkbox']").each(function(){
			this.checked = false;
		})
	}
	function nextPage(){
		var page=$("#currentPage").val();
		loadAlreadyCataLog(parseInt(page)+1)
	}
	function prePage(){
		var page=$("#currentPage").val();
		loadAlreadyCataLog(parseInt(page)-1);
	}
	
	//批量删除
	function pacthDeleteEArch(divId){
		var checkboxArray=$("#"+divId).find("input[type='checkbox']:checked");
		if(checkboxArray.length<=0){
			alert('请选择要删除的图片');
			return;
		}
		var r=confirm("您确认要删除该图片？");
		if(r){
			var id="";
			$.each(checkboxArray,function(i,e){
				if(i==0){
					id+=$(e).val();
				}else{
					id+=","+$(e).val();
				}
			})

			$.ajax({ url: '${ctx}/sys/attachment/attachment/del.xf',
				data:{caoa01:id},
				success: function(data){
					$.each(checkboxArray,function(i,e){
						$(e).parents(".imgContent").remove();
					})
				}
			});
		}

	}
	//单个删除
	function deleteEArch(obj,id){
		var r=confirm("您确认要删除该图片？");
		if(r){
			$.ajax({ url: '${ctx}/sys/attachment/attachment/del.xf',
				data:{caoa01:id},
				success: function(data){
					$(obj).parents(".imgContent").remove();
				}
			});
		}
	}
	function imageShow(id){
		xfui.open_tabs("预览","${ctx}/sys/attachment/attachment/imageShow.xf?caoa01="+id);
	}
	//移除图片
	function removePicture(){
		$("#imgContext").empty() ; 
		$("#CAOA03").val("");
	}
	//保存图片
	function savePicture(){
		var caoa03 = $("#CAOA03").val();
		var filePath = $("#filePath").val();
		$.ajax({ url: '${ctx}/sys/attachment/attachment/savePicture.xf',
			data:{caoa03:caoa03,caoa02:filePath},
			success: function(data){
				loadAlreadyCataLog(1,14);
			}
		});
	}
</script>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px" align="center">
		<p style="font-size: 12px;">校园风采</p>
	</div>
	<div data-options="region:'west',split:true,title:'操作区域'" style="width:30%;padding:10px;">
	    <table>
		     <tr>
		       <td>
			        <input type="file" id="file" name="file"><br/>
				    <input type="hidden" id="flag" name="flag" value="ajax文件上传"/>
				    <input type="button" id="btnUpload" value="上传图片" />
		       </td>
		     </tr>
	    </table>
	    <div id="wait_loading" style="padding: 50px 0 0 0;display:none;">
	        <div style="width: 103px;margin: 0 auto;"><img src=""/></div>
	        <br></br>
	        <div style="width: 103px;margin: 0 auto;"><span>请稍等...</span></div>
	        <br></br>
	    </div>
	    <div id="imgContext" style="margin-top: 100px;">
		</div>
		<div style="display: none;" id="showSave">
			<form action="" method="post">
				<table>
					<tr>
						<td>图片名称：</td>
						<td><input type="text" id="CAOA03" name="CAOA03" style="height: 30px;width: 400px;"></td>
					</tr>
					<tr>
						<td><input type="button" value="应用" onclick="savePicture()"></td>
						<td><input type="button" value="移除" onclick="removePicture()"></td>
					</tr>
				</table>
				<input type="hidden" id="filePath" name="filePath">
			</form>
		</div>
	</div>
	<div data-options="region:'center',title:'已上传图片'">
		<div  style="padding: 5px 5px;">
			<a href="javascript:void(0)" class="easyui-linkbutton tb_add"  onclick="pacthDeleteEArch('alreadyCollect')" data-options="iconCls:'icon-remove'">批量删除</a>
			<a href="javascript:void(0)" class="easyui-linkbutton tb_add"  onclick="selectAll('alreadyCollect')" data-options="iconCls:'icon-add'">全部选中</a>
			<a href="javascript:void(0)" class="easyui-linkbutton tb_add"  onclick="releaseAll('alreadyCollect')" data-options="iconCls:'icon-add'">全部取消</a>
			<a href="javascript:void(0)" class="easyui-linkbutton tb_add"  id="prePage" onclick="prePage()" disabled>上一页</a>
			<a href="javascript:void(0)" class=""   data-options="disabled:true">第<span id="currentPageShow"></span>页 共<span id="totalPageShow"></span>页</a>
			<a href="javascript:void(0)" class="easyui-linkbutton tb_add"  id="nextPage" onclick="nextPage()" disabled>下一页</a>
		</div>
		<hr/>
        <div id="alreadyCollect">
        	
	    </div>
	</div>
</body>
</html>