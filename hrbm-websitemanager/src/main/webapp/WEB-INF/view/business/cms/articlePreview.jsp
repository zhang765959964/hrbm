<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp" %>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />

<title>栏目管理</title>
<style type="text/css">
  .info-view{background:#f4f4f4;}
.info-view .optbar{background:#f4f4f4;width:auto;right:0;}
.info-view .optbar-inner{float:right}
.info-view .subTitle {padding: 0 0 15px 0;border-bottom: 1px #ccc solid;margin-bottom: 20px;}
.info-view .mainDiv {padding: 20px 30px;margin: 20px auto;border-left: 1px solid #efefef;border-right: 1px solid #efefef;border-bottom: 0px solid #d3d3d3;border-top: 0px solid #d3d3d3;box-shadow: 0 1px 1px rgba(0, 0, 0, 0.02);background: #fff;margin-bottom: 10px;width: 800px;}
.info-view .subjectDiv {font-size: 24px;font-weight: 600;text-align: center;margin-top: 20px;color: #000;font-family: "微锟斤拷锟脚猴拷", "锟斤拷锟斤拷";word-break:break-all;}
.info-view .newsInfo {margin-bottom: 5px;margin-top: 20px;}
.info-view .contentDiv {text-align: left;height: auto !important;min-height: 400px;color: #383838;margin-top: 10px;}
.info-view .toTopDiv {padding: 20px 0px 20px 0px;text-align: right;}
.info-view .roomBg {width: 114px;height: 25px;background: url('../images/fontBig.jpg') no-repeat;padding-top: -2px;color: #737373;}
.info-view .roomFont {margin-left: 43px;font-size: 12px;}
.info-view .center{text-align: center;}
  
</style>
<script>
 
  function closeItem(){
	  xfui.closeTab();
  }
  function ZoomContent(zoomValue) {
      var z = document.getElementById("contentDiv").style.zoom;
      if (!z) {
          z = 1.0;
      }
      if (typeof z == 'string') z = parseFloat(z);
      document.getElementById("contentDiv").style.zoom = z + zoomValue;
  }
  function ResetContent() {
      document.getElementById("contentDiv").style.zoom = 1;
  }
  function editArticle(){

		xfui.open_tabs("编辑新闻","${ctx}/business/cms/article/edit.xf?cand01=${articleForm.cand01}","栏目管理");

	}
</script>
</head>
<body class="info-view">
<div class="main">
	<div class="div-line"></div>
    <!-- ==================== 工具栏 end ================== -->
    <div class="main-content" style="text-align: center">
        <div class="mainDiv" style="width: 800px; margin: 0 auto; text-align: left;overflow:auto">
            <div class="subjectDiv">
                <b>${articleForm.cand03}</b>
            </div>

            <div class="subTitle center" >
               <table class="newsInfo center" style="margin:auto">
                    <tbody>
                    <tr>
                        <!-- 作者 -->
                        <td>创建者: ${articleForm.publishUserName}&nbsp;|&nbsp;</td>
                        <!-- 创建时间 -->
                        <td> 发布时间:	<fmt:formatDate value="${articleForm.cand07}" pattern="yyyy-MM-dd HH:mm" />&nbsp;|&nbsp;</td>
                        <!-- 点击量 -->
                        <td>点击量 :${articleForm.cand13}&nbsp;</td>
                    </tr>
                    </tbody>
                </table>
                
            </div>
            <div id="contentDiv">${articleForm.cand04}</div>
        </div>
    </div>
</div>
</body>
</html>