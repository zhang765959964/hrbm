<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑基本信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   	<%@include file="/commons/include/commonInc.jsp" %>
   	<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
   	<link rel="stylesheet" href="${ctx}/assets/css/bootstrap-datetimepicker.min.css" />
	<link rel="stylesheet" href="${ctx}/assets/css/daterangepicker.css" />
	<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />

   	<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
	<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script>
	<script src="${ctx}/assets/js/clipboard.min.js"></script>

	<!-- ueditor js -->
	<script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/lang/zh-cn/zh-cn.js"></script>
    <!-- ueditor js end -->

    <!-- umeditor -->
    <link href="${ctx}/js/lib/umeditor-1.2.2/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/umeditor-1.2.2/umeditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/umeditor-1.2.2/umeditor.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/lib/umeditor-1.2.2/lang/zh-cn/zh-cn.js"></script>
    <!-- umeditor  end -->

	<script>
		$(function() {
			$("#cityInput").selcity({callBack:function(data){
				$("#cityInput").val(data.allname);
				}
			});
			$("#cityInput2").selcity({callBack:function(data){
				$("#cityInput2").val(data.allname);
				}
			});
		});
	</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">

			<!-- <div class="copyBtn">
				<a href="javascript:void(0)" role="button" class="btn btn-info" >复制模块代码</a>
			</div> -->
			<script id="editor" type="text/plain" style="width:100%;height:200px;"></script>
			<script>var ue = UE.getEditor('editor');</script>
			<div class="editor">
				<pre>
ueditor编辑器代码
	&lt;script id="editor" type="text/plain" style="width:100%;height:200px;"&gt; &lt;/script&gt;
	&lt;script&gt;var ue = UE.getEditor('editor');&lt;/script&gt;
需引入js
	ueditor.config.js
	ueditor.all.min.js
	lang/zh-cn/zh-cn.js
				</pre>
			</div>

			<hr/>
			<!-- 分割线 umeidtor -->
			<script type="text/plain" id="umEditor" style="width:99%;height:200px;"></script>
			<script type="text/javascript">var um = UM.getEditor('umEditor');</script>
<pre>
umeditor编辑器代码
	&lt;script id="umEditor" type="text/plain" style="width:99%;height:200px;"&gt; &lt;/script&gt;
	&lt;script&gt;var um = UM.getEditor('umEditor');&lt;/script&gt;
需引入js
	umeditor.config.js
	umeditor.min.js
	lang/zh-cn/zh-cn.js
需引入css
	themes/default/css/umeditor.css
</pre>


	</div>

</body>
</html>
