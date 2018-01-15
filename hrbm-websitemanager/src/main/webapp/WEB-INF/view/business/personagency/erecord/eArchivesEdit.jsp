<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="/commons/include/commonInc.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>电子档案办理</title>
    <style>
    	ul,li{list-style: none; margin:0; padding: 0;}
    </style>
	<Script language="javascript">

//     $(function () {
//         var width = $(document).width();
//         var height = $(document).height();
//         $("#globeDiv").css("left", (width - 848) / 2);
//     });
    
    function date2str(){//打开读卡器
				var d = new Date(); 
    		var ret = d.getFullYear()+'-';
    		ret += ("00"+(d.getMonth()+1)).slice(-2)+'-';
    		ret += ("00"+d.getDate()).slice(-2)+' ';
    		ret += ("00"+d.getHours()).slice(-2)+':';  
    		ret += ("00"+d.getMinutes()).slice(-2)+':';
    		ret += ("00"+d.getSeconds()).slice(-2);   
    		return ret;  
			}  

			function SS_AX_CMR_OPEN() {
				var pVal;
				pVal=capture.SS_AX_CMR_Close(document.getElementById("cameraId").value);
				//showMsg(pVal);
					//showMsg(document.getElementById("cameraId").value);

// 					showMsg('Close:'+pVal);
// 					showError(pVal);
					
					document.getElementById("cameraId").value=2;
					pVal = capture.SS_AX_CMR_Open(document.getElementById("cameraId").value);
					
					//showMsg('ret：'+pVal);
					//showError(pVal);
    }
    function SS_AX_CMR_CHANGE() {
					var pVal;
					pVal = capture.SS_AX_CMR_Close(document.getElementById("cameraId").value);
// 					showMsg('Close:'+pVal);
// 					showError(pVal);
					
					document.getElementById("cameraId").value=(document.getElementById("cameraId").value+1)%3;
					
					pVal = capture.SS_AX_CMR_Open(document.getElementById("cameraId").value);
// 					showMsg('Open:'+pVal);
// 					showError(pVal);
					
    }
    function SS_AX_CMR_PHOTO() {
					var pVal;
					//pVal = capture.SS_AX_CMR_SetImgPath(document.getElementById("cameraId").value,"C:\\");
					var filePath="D:\\img\\";
					var uuid=getUuid();
					var strFile=uuid+".jpg";
					var personId=$("#personId").val();
					var catalogId=$("#catalogId").val();
					
                    if(!catalogId){
                    	alert("请选择目录!")
                    	return;
                    }
                    pVal = capture.SS_AX_CMR_Photo(document.getElementById("cameraId").value,filePath+strFile);
					window.showModalDialog("${ctx}/applet/eArchivesApplet.jsp?filePath="+filePath+"&fileName="+strFile
							+"&personId="+personId+"&catalogId="+catalogId,window,'dialogWidth=700px;dialogHeight=700px;top=0;left=0;toolbar=yes;menubar=yes;scrollbars=yes; resizable=yes;location=yes; status=yes'); 
// 					xfui.open_dialog({
// 						title: '本地图片预览',
// 						width: 700,
// 						height: 700,
// 						closed: false,
// 						cache: false,
// 						url: "${ctx}/applet/eArchivesApplet.jsp?filePath="+filePath+"&fileName="+strFile
// 						+"&personId="+personId+"&catalogId="+catalogId,
// 						modal: true
// 					})
    }
    function SS_AX_CMR_VIDEOSTART() {
					var pVal;
					pVal = capture.SS_AX_CMR_VideoStart(document.getElementById("cameraId").value, "./1.wmv",1);
					showMsg('ret:'+pVal);
					showError(pVal);
    }
    function SS_AX_CMR_VIDEOSTOP() {
					var pVal;
					pVal = capture.SS_AX_CMR_VideoStop(document.getElementById("cameraId").value);
					showMsg('ret:'+pVal);
					showError(pVal);
    }
    function SS_CMR_AX_CLOSE() {
					var pVal;
					pVal = capture.SS_AX_CMR_Close(document.getElementById("cameraId").value);
					showMsg('ret:'+pVal);
					showError(pVal);
    }
    function SS_AX_CMR_ZOOMIN() {
					var pVal;
					pVal = capture.SS_AX_CMR_ZOOMIN(document.getElementById("cameraId").value);
					showMsg('ret:'+pVal);
					showError(pVal);
    }
    function SS_AX_CMR_ZOOMOUT() {
					var pVal;
					pVal = capture.SS_AX_CMR_ZOOMOUT(document.getElementById("cameraId").value);
					showMsg('ret:'+pVal);
					showError(pVal);
    }
    function SS_AX_CMR_ROTATELEFT() {
					var pVal;
					pVal = capture.SS_AX_CMR_ROTATELEFT(document.getElementById("cameraId").value);
					showMsg('ret:'+pVal);
					showError(pVal);
    }
    function SS_AX_CMR_ROTATERIGHT() {
					var pVal;
					pVal = capture.SS_AX_CMR_ROTATERIGHT(document.getElementById("cameraId").value);
					showMsg('ret:'+pVal);
					showError(pVal);
    }
    function SS_AX_CMR_WATERADD() {
					var pVal;
					showMsg('SS_AX_CMR_WATERADD');
					pVal = capture.SS_AX_CMR_WaterMarkAdd(document.getElementById("cameraId").value);
					showMsg('ret:'+pVal);
					showError(pVal);
    }
    function SS_AX_CMR_WATERSET() {
					var pVal;
					pVal = capture.SS_AX_CMR_WaterMarkSet(document.getElementById("cameraId").value);
					showMsg('ret:'+pVal);
					showError(pVal);
    }
    function SS_AX_CMR_PARASET() {
					var pVal;
					pVal = capture.SS_AX_CMR_ParaSet(document.getElementById("cameraId").value);
					showMsg('ret:'+pVal);
					showError(pVal);
    }
    function SS_AX_CMR_VIDEOPROP() {
					var pVal;
					pVal = capture.SS_AX_CMR_ShowVideoProp(document.getElementById("cameraId").value);
					showMsg('ret:'+pVal);
					showError(pVal);
    }
    function SS_AX_CMR_AudioStart() {
					var pVal;
					pVal = capture.SS_AX_CMR_AudioStart("./1.wma");
					showMsg('ret:'+pVal);
					showError(pVal);
    }
    function SS_AX_CMR_AudioStop() {
					var pVal;
					pVal = capture.SS_AX_CMR_AudioStop();
					showMsg('ret:'+pVal);
					showError(pVal);
    }
    
    function SS_AX_CMR_MakePDF() {
					var pVal;
					pVal = capture.SS_AX_CMR_MakePDF("C:\\工作室\\软件部\\高拍仪\\通用\\bin\\image","hechengpdf.pdf");
					showMsg('ret:'+pVal);
					showError(pVal);
    }
    function SS_AX_CMR_StartTimerCapture() {
					var pVal;
					pVal = capture.SS_AX_CMR_SetImgPath(document.getElementById("cameraId").value,"C://");
					showMsg('ret:'+pVal);
					showError(pVal);
					pVal = capture.SS_AX_CMR_StartTimerCapture(document.getElementById("cameraId").value,10);
					showMsg('ret:'+pVal);
					showError(pVal);
    }
    function SS_AX_CMR_StopTimerCapture() {
					var pVal;
					pVal = capture.SS_AX_CMR_StopTimerCapture(document.getElementById("cameraId").value);
					showMsg('ret:'+pVal);
					showError(pVal);
    }


			function SelectCutmode(el) {
					capture.SS_AX_CMR_SetCutMode(document.getElementById("cameraId").value, el.value);
    }



		function showMsg(msg) {
			var tm ='';
	    x = document.getElementById("area");
	    tm=x.value + '\n' + date2str()+ '--->';
	    x.value = tm + msg ;
		}
		function showError(errorcode) {
			switch(errorcode)
			{
				case 0:
					showMsg(errorcode+':'+'操作成功');
					break;
				case -2:
					showMsg(errorcode+':'+'操作超时');
					break;
				case -3:
					showMsg(errorcode+':'+'硬件故障');
					break;
				case -4:
					showMsg(errorcode+':'+'给出的要保存到的图片路径无效');
					break;
				case -6:
					showMsg(errorcode+':'+'设备已关闭');
					break;
				case -7:
					showMsg(errorcode+':'+'操作被取消');
					break;
				case -10001:
					showMsg(errorcode+':'+'读取到的IC卡数据有问题');
					break;
				case -20002:
					showMsg(errorcode+':'+'给出的特征码无效');
					break;
				case -20003:
					showMsg(errorcode+':'+'给出的模板值无效');
					break;
				case -40021:
					showMsg(errorcode+':'+'无卡可读');
					break;
				case -60021:
					showMsg(errorcode+':'+'无卡可读');
					break;
				case -60023:
					showMsg(errorcode+':'+'读写失败');
					break;
				case -99999:
					showMsg(errorcode+':'+'其他错误');
					break;
			}
		}
		function loadCataLog(obj,page,rows){
			var catalogId=$(obj).attr("catalogid");
			$("#catalogId").val(catalogId);
			$(obj).addClass("selected");
			$(obj).siblings().removeClass("selected");
			loadAlreadyCataLog(page,rows);
			loadProcessCataLog();
		}

		function loadAlreadyCataLog(page,rows){
			if(!page){
				page=1
			}
			if(!rows){
				rows=6
			}
			var catalogId=$("#catalogId").val();
			var personId=$("#personId").val();
			$("#alreadyCollect").load("${ctx}/business/erecord/eArchives/alreadyColl.xf?page="+page+"&rows="+rows+"&personId="+personId+"&catalogId="+catalogId,function(response,status,xhr){
				$("#currentPageShow").text($("#currentPage").val());
				$("#totalPageShow").text($("#totalPage").val());

				//$("#totalCountShow").text($("#totalCount").val());
				if($("#isHasPreviousPage").val()=="false"){
					//$('#prePage').linkbutton('disable');
				}else{
					//$('#prePage').linkbutton('enable');
				}
				if($("#isHasNextPage").val()=="false"){
					//$('#nextPage').linkbutton('disable');
				}else{
					//$('#nextPage').linkbutton('enable');
				}
 				if(response.indexOf('超时')!=-1){
 					 window.location='${ctx}/login.jsp';
 				}
			});

		}

		function loadProcessCataLog(catalogId){
			var catalogId=$("#catalogId").val();
			var personId=$("#personId").val();
			$("#processCollect").load("${ctx}/business/erecord/eArchives/processColl.xf?personId="+personId+"&catalogId="+catalogId);
		}
        function imageShow(id){
			<%--xfui.open_dialog({--%>
				<%--title: '调出记录详情',--%>
				<%--width: 850,--%>
				<%--height: 500,--%>
				<%--closed: false,--%>
				<%--cache: false,--%>
				<%--url: '${ctx}/business/erecord/eArchives/getImageById.xf?id='+id,--%>
				<%--modal: true--%>
			<%--})--%>
			xfui.open_tabs("预览","${ctx}/business/erecord/eArchives/imageShow.xf?id="+id,"电子档案采集");
		}
		function deleteEArch(obj,id){
			bootbox.confirm({message:'您确认要删除该图片？',callback:function(r){    
				if(r){
					$.ajax({ url: '${ctx}/business/erecord/eArchives/del.xf',
						data:{id:id},
						success: function(data){
							$(obj).parent(".selList").remove();
						}
					});
				}  
			}});
			
		}
		//批量删除
		function pacthDeleteEArch(divId){
			var checkboxArray=$("#"+divId).find("input[type='checkbox']:checked");
			if(checkboxArray.length<=0){
				alert('请选择要删除的图片');
				return;
			}
			bootbox.confirm({message:'您确认要删除该图片？',callback:function(r){    
				if(r){
					var id="";
					$.each(checkboxArray,function(i,e){
						if(i==0){
							id+=$(e).val();
						}else{
							id+=","+$(e).val();
						}
					})

					$.ajax({ url: '${ctx}/business/erecord/eArchives/del.xf',
						data:{id:id},
						success: function(data){
							$.each(checkboxArray,function(i,e){
								$(e).parent(".selList").remove();
							})
						}
					});
				}
			}});
		
		}
//采用
		function  useEArch(obj,id){

					$.ajax({ url: '${ctx}/business/erecord/eArchives/useEArch.xf',
						data:{id:id},
						success: function(data){
							loadAlreadyCataLog();
							$(obj).parent(".selList").remove();
						}
					});
		}
		//批量采用
		function pacthUseEArch(){
			var checkboxArray=$("#processCollect").find("input[type='checkbox']:checked");
			if(checkboxArray.length<=0){
				alert('请选择要采用的图片');
				return;
			}
			var id="";
			$.each(checkboxArray,function(i,e){
				if(i==0){
					id+=$(e).val();
				}else{
					id+=","+$(e).val();
				}
			})
			$.ajax({ url: '${ctx}/business/erecord/eArchives/useEArch.xf',
				data:{id:id},
				success: function(data){
					$.each(checkboxArray,function(i,e){
						//$("#alreadyCollect").append($(e).parents(".imgContent"));
						loadAlreadyCataLog();
						$(e).parent(".selList").remove();
					})
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
		$(function(){
			$("#rootCat").click();
		})

		function nextPage(){
			var page=$("#currentPage").val();
			loadAlreadyCataLog(parseInt(page)+1)
		}
		function prePage(){
			var page=$("#currentPage").val();
			loadAlreadyCataLog(parseInt(page)-1);
		}
		function getUuid(){
			  var len=32;//32长度
			  var radix=16;//16进制
			  var chars='0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');var uuid=[],i;radix=radix||chars.length;if(len){for(i=0;i<len;i++)uuid[i]=chars[0|Math.random()*radix];}else{var r;uuid[8]=uuid[13]=uuid[18]=uuid[23]='-';uuid[14]='4';for(i=0;i<36;i++){if(!uuid[i]){r=0|Math.random()*16;uuid[i]=chars[(i==19)?(r&0x3)|0x8:r];}}}
			  return uuid.join('');
			} 
	</script>
</head>
<body class="h100p">
	<div class="container-fluid h100p">
		<div class="row h100p">
			<div class="col-xs-12 col-sm-3 colLeft">
				<div class="treeWrap">
					<div class="moduleTit">目录信息</div>
					<ul class="catTree">
						<li  id="rootCat" onclick="loadCataLog(this)" catalogid=""><a href="#" >全部</a></li>
						<c:forEach var="erecordCatalog" items="${erecordCatalogList}">
							<li onclick="loadCataLog(this)" catalogid="${erecordCatalog.id}">
								<a href="javascript:void(0)" >${erecordCatalog.name}</a>
							</li>
						</c:forEach>
					</ul>
				</div>
				<ul class="selWrap" id="alreadyCollect">
				</ul>
				<div class="btnWrap">
					<a href="javascript:void(0)" class="btn btn-purple btn-border1 highSearch"  onclick="pacthDeleteEArch('alreadyCollect')"><i class="icon-remove"></i>批量删除</a>
					<a href="javascript:void(0)" class="btn btn-info btn-border1 highSearch"  onclick="selectAll('alreadyCollect')"></i>全部选中</a>
					<a href="javascript:void(0)" class="btn btn-info btn-border1 highSearch"  onclick="releaseAll('alreadyCollect')">全部取消</a>
					<!-- 						<a href="javascript:void(0)" class="easyui-linkbutton tb_add"  onclick="pacthDeleteEArch('alreadyCollect')" data-options="iconCls:'icon-add'">批量删除</a> -->
<!-- 						<a href="javascript:void(0)" class="easyui-linkbutton tb_add"  onclick="selectAll('alreadyCollect')" data-options="iconCls:'icon-add'">全部选中</a> -->
<!-- 						<a href="javascript:void(0)" class="easyui-linkbutton tb_add"  onclick="releaseAll('alreadyCollect')" data-options="iconCls:'icon-add'">全部取消</a> -->
<!-- 						<a href="javascript:void(0)" class="easyui-linkbutton tb_add"  id="prePage" onclick="prePage()" disabled>上一页</a> -->
<!-- 						<a href="javascript:void(0)" class=""   data-options="disabled:true">第<span id="currentPageShow"></span>页 共<span id="totalPageShow"></span>页</a> -->
<!-- 						<a href="javascript:void(0)" class="easyui-linkbutton tb_add"  id="nextPage" onclick="nextPage()" disabled>下一页</a> -->

				</div>
			</div>
			<div class="col-xs-12 col-sm-6 colCenter">
				<div class="moduleWrapNobg">
					<div class="moduleTit">预览</div>
					<div class="previewBasic">
						<div class="row mg0">
							<label class="col-sm-12p5" for="inputError">身份证号：</label>
							<div class="col-sm-20p5">
								<input class="form-control" value="${personBaseInfo.aac002}" placeholder="331254789654" readonly="readonly"/>
							</div>
							<label class="col-sm-12p5" for="inputError">姓名：</label>
							<div class="col-sm-20p5">
								<input class="form-control" value="${personBaseInfo.aac003}" placeholder="张凉" readonly="readonly"/>
							</div>
							<label class="col-sm-12p5" for="inputError">出生日期：</label>
							<div class="col-sm-20p5">
                              	<input class="form-control" value="<fmt:formatDate value="${personBaseInfo.aac006}" pattern="yyyy-MM-dd"/>" placeholder="18960504" readonly="readonly"/>
                            
                            </div>
                        </div>
<!--                         <div class="row mg0"> -->
<!-- 							<label class="col-sm-12p5" for="inputError">性别：</label> -->
<!-- 							<div class="col-sm-20p5"> -->
<%-- 								<input class="form-control" name="sex" value="${personBaseInfo.aac004}" placeholder="男" readonly="readonly"/> --%>
<!-- 							</div> -->
<!-- 							<label class="col-sm-12p5" for="inputError">档案姓名：</label> -->
<!-- 							<div class="col-sm-20p5"> -->
<!-- 								<input class="form-control" name="" value="张凉" placeholder="张凉" readonly="readonly"/> -->
<!-- 							</div> -->
<!-- 						</div> -->
					</div>
					<div class="previewImg">
						<div class="previewBox">
							 <div style="position: relative;">
				            <div style="border: 1px solid #ccc;width:640px;height:480px;">
				                <object classid="clsid:2B44A159-C1D6-4ED2-A3E6-0FD1708ADE09" id="capture" width="640" height="480"></object>
				            </div>
				        </div>
						</div>
					</div>
					<div class="previewBtn">
					 <form method="POST" action="--WEBBOT-SELF--" name="form1" id="form1">
								<select id="Cutmode" onchange="SelectCutmode(this)">
				                    <option value="0" selected="selected">不剪切</option>
				                    <option value="1">画框裁切</option>
				                    <option value="2">固定矩形框</option>
				                    <option value="3">自动纠裁</option>
				                </select>
						<a href="javascript:void(0)" role="button" onclick="SS_AX_CMR_OPEN()" class="btn btn-primary btn-border1" ><i class="icon-camera"></i>打开高拍仪</a>
						<a href="javascript:void(0)" role="button" onclick="SS_AX_CMR_PHOTO()"  class="btn btn-primary btn-border1" ><i class="icon-camera"></i>拍照</a>
						<a href="javascript:void(0)" onclick="SS_AX_CMR_ROTATELEFT()" class="btn btn-success btn-border1 highSearch" ><i class="icon-refresh"></i>旋转</a>
						<a class="btn btn-info" href="javascript:void(0)" onclick="SS_AX_CMR_CHANGE()" role="button" ><i class="icon-retweet"></i>切换摄像头</a>
						<a class="btn btn-info" href="javascript:void(0)" onclick="SS_CMR_AX_CLOSE()" role="button" ><i class="icon-retweet"></i>关闭摄像头</a>										    
				        <input type="hidden" id="cameraId" value=0 />
<!-- 				        <textarea id="area" cols="100" rows="25" style="overflow-y:auto"></textarea> -->
				        <input type="hidden" name="personId" id="personId" value="${eArchivesForm.personId}"/>
				 		<input type="hidden" id="catalogId" name="catalogId" value=""/>
				       </form>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-3 colLast">
				<div class="moduleTit">已采集信息</div>
				<ul class="selWrap" id="processCollect">
				</ul>
				<div class="btnWrap">
					<a href="javascript:void(0)" role="button" class="btn btn-primary btn-border1"   onclick="pacthUseEArch()" >批量采用</a>
					<a href="javascript:void(0)" role="button" class="btn btn-info btn-border1 highSearch"   onclick="pacthDeleteEArch('processCollect')" >批量删除</a>
					<a href="javascript:void(0)" role="button" class="btn btn-info btn-border1 highSearch"   onclick="selectAll('processCollect')" >全部选中</a>
					<a href="javascript:void(0)" role="button" class="btn btn-info btn-border1 highSearch"   onclick="releaseAll('processCollect')" >全部取消</a>
				</div>
			</div>
		</div><!-- row end -->

	</div>
</body>

</html>