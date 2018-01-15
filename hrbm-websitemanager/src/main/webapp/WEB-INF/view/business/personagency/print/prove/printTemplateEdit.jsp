<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>编辑 RSDA_BS_PRINT_MODEL</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">

<script type="text/javascript">
var um 
	$(function() {
		if(um){
			um.destroy();
		}
		
		initFormSubimt();
		xfui.initUi();
		   um = UE.getEditor('myEditor',{autoHeightEnabled: false,
				 toolbars: [[
					 'fullscreen', 'source', '|', 'undo', 'redo', '|',
					 'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
					 'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
					 'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|', 'indent', '|',
					 'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
					 'link', 'unlink', 'anchor', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
					 'simpleupload', 'insertimage', 'emotion', 'insertvideo', 'music','attachment', 'map', 'insertframe', 'insertcode', 'pagebreak', 'template',  '|',
					 'horizontal', 'date', 'time', 'spechars', 'snapscreen', 'wordimage', '|',
					 'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols', 'charts', '|',
					 'print', 'searchreplace', 'help'
				 ]]
			 });
	})
	function initFormSubimt() {
		$('#printTemplateForm').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				//发布名称
				fdModelName : {
					validators : {
						notEmpty : {},
						stringLength : {
							min : 2,
							max : 50
						}
					}
				}
			}
		}).on('success.form.bv', function(e) {
			e.preventDefault();
			var $form = $(e.target);
			var bv = $form.data('bootstrapValidator');
            var content=UE.getEditor('myEditor').getContent();
            $("#fdModelHtml").val(content);
			$.post($form.attr('action'), $form.serialize(), function(data) {
				 bv.disableSubmitButtons(false);
				bootbox.alert({
					size : 'small',
					width : "100px",
					message : data.message
				})

			}, 'json');

		});
	}
	
	function insertValue(key,value){
		var externalValue='<span external="{key:&#39;'+key+'&#39;,name:&#39;'+value+'&#39;,type:&#39;text&#39;}">['+value+']</span>';
		um.execCommand('inserthtml', externalValue);
	}
	
	function addTemp(){
		
		$("#perBase").load("${ctx}/business/personagency/print/printProveTemplate/add.xf");
	}
	function preview(){
		if($("#pkId").val()){
			xfui.open_dialog({    
	  		    title: '打印预览',    
	  		    width: 900,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: "${ctx}/business/personagency/print/printProveTemplate/preview.xf?pkId="+$("#pkId").val(),
	  		    modal: true   
	  		})
		}else{
			bootbox.alert("请选择模版");
		}
		
	}
	function delTemp(){
		
		$.ajax({ url: '${ctx}/business/personagency/print/printProveTemplate/del.xf',
    		data:{pkId:$("#pkId").val()},
    		dataType:'json',
    		success: function(data){
    			if(data.result===1){
    				 bootbox.alert({ 
                         size: 'small',
                         width:"100px",
                         message: data.message, 
                         callback: function(){ 
                        	 addTemp();
                         }
                     }) 	
    			}else{
    				bootbox.alert("未知错误"); 
    			}
             }
    	});
	}
	
	
</script>
</head>
<body>

				<div class="col-sm-3 pd0">
					<div class="moduleWrapNob" style="height: 550px">
						<div class="moduleTit">变量</div>
						<div class="moduleCont">
						   <ul class="catTree" style="height:445px; overflow-y: auto" >
								            <c:forEach items="${personProMap}" var="item">  
								               <li onclick="insertValue('${item.key}','${item.value}')">
													<a href="javascript:void(0)" >${item.value}</a>
												</li>
								            </c:forEach>  
									
											
							</ul>
						</div>
					</div>
				</div>
				<div class="col-sm-9 colRight">
					<div class="moduleWrapNob" style="height: 550px">
						<div class="moduleTit">
							<span class="fl">编辑模版</span>
						</div>
						<div class="moduleCont">
							<form:form modelAttribute="printTemplateForm" method="post"
								action="${ctx}/business/personagency/print/printProveTemplate/save.xf">
								<form:hidden path="pkId"></form:hidden>
								<form:hidden path="fkModelType"  value="0"></form:hidden>
								<form:hidden path="fdModelHtml" ></form:hidden>
								<div class="container-fluid">
									<div class="row">
										<div class="">
											<div class="moduleCont">

												<div class="row">
													<label class="col-xs-3 col-sm-2" for="inputError">模版名称:</label>
													<div class="col-xs-9 col-sm-10 required">
														<form:input class="form-control" type="text" path="fdModelName" ></form:input>
													</div>
													<label class="col-xs-3 col-sm-2" for="inputError">html模版:</label>
													<div class="col-xs-9 col-sm-10 required">
													  
														<script type="text/plain" id="myEditor" style="height:300px;" >
                                                     <c:choose>
													   <c:when test="${empty printTemplateForm.fdModelHtml}">
	<style>span{line-height:2.0;}</style>
	<table align="center" width="603px">
    <tbody>
        <tr class="firstRow">
            <td valign="top" style="word-break: break-all; border-color: rgb(221, 221, 221);" align="center">
                <p>
                    <strong><span style="letter-spacing: 0;font-size: 24px"><span style="font-family:sans-serif">证</span>&nbsp; 明</span></strong>
                </p>
            </td>
        </tr>
        <tr>
            <td valign="top" style="word-break: break-all; border-color: rgb(221, 221, 221);">
                <p style="text-indent: 2em;">
                <span style="font-size: 24px;">&nbsp;</span>
                </p> 
            </td>
        </tr>
        <tr>
            <td valign="top" style="word-break: break-all; border-color: rgb(221, 221, 221);">
                <p>
                    <span style="letter-spacing: 0;font-size: 24px"><span style="font-family:sans-serif">&nbsp; &nbsp;特此证明</span></span>
                </p>
            </td>
        </tr>
        <tr>
            <td valign="top" style="word-break: break-all; border-color: rgb(221, 221, 221);" align="right">
                <span style="font-size: 24px;"><span external="{key:&#39;BAE036&#39;,name:&#39;证明开具日期&#39;text&#39;}">[证明开具日期] &nbsp; &nbsp;&nbsp;</span></span>
            </td>
        </tr>
        <tr>
            <td valign="bottom" colspan="1" rowspan="1" style="word-break: break-all; border-color: rgb(221, 221, 221);" align="right">
                <span style="letter-spacing: 0px; text-align: center; font-size: 24px;">郑州市职业介绍</span><span style="letter-spacing: 0px; text-align: center; font-size: 24px;">中心</span>
            </td>
        </tr>
    </tbody>
</table>
													   
													   </c:when>
													   <c:otherwise>${printTemplateForm.fdModelHtml}</c:otherwise>
													  </c:choose>
															
														</script>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="h60">&nbsp;</div>
									<div class="floatBtn">
										
										<button type="submit" class="btn btn-primary"><i class="icon-save"></i>保存</button>
										<a href="javascript:addTemp()" role="button" class="btn btn-info" ><i class="icon-plus"></i>新增</a>
										<a href="javascript:delTemp()" role="button" class="btn btn-danger" ><i class="icon-trash"></i>删除</a>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>

</body>
</html>
