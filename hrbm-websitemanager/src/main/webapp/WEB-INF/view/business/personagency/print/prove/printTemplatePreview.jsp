<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title></title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<style type="text/css" media=print>
.noprint {
	display: none
}
</style>
<script type="text/javascript">
	function printTure() //打印函数
	{
		pagesetup_null();//打印之前去掉页眉，页脚
		//document.all("dayinDiv").style.display = "none";
		window.print();
		//document.all("dayinDiv").style.display = "";
	}
	function doPage() {
		layLoading.style.display = "none";
	}
	var hkey_key;
	var hkey_root = "HKEY_CURRENT_USER";
	var hkey_path = "\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
	//设置网页打印的页眉页脚为空
	function pagesetup_null() {
		var RegWsh = new ActiveXObject("WScript.Shell");
		hkey_key = "header";
		RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "");
		hkey_key = "footer";
		RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "");
	}
	//设置网页打印的页眉页脚为默认值
	function pagesetup_default() {
		try {
			var RegWsh = new ActiveXObject("WScript.Shell");
			hkey_key = "header";
			RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "&w&b页码，&p/&P");
			hkey_key = "footer";
			RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "&u&b&d");
		} catch (e) {
		}
	}
	function printHTML(){  
        var bdhtml=window.document.body.innerHTML;//获取当前页的html代码    
        var sprnstr="<!--begin-->";//设置打印开始区域    
        var eprnstr="<!--end-->";//设置打印结束区域    
        var prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)+18); //从开始代码向后取html    
        var prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));//从结束代码向前取html    
        window.document.body.innerHTML=prnhtml;    
        window.print();    
        window.document.body.innerHTML=bdhtml;    
    }  
</script>
</head>
<body>
<object ID='wb' WIDTH=0 HEIGHT=0 CLASSID='CLSID:8856F961-340A-11D0-A96B-00C04FD705A2'></object> 
    <!--begin-->
	<a href="javascript:wb.ExecWB(6,1); " role="button" id="closeItem"
		class="btn btn-info noprint"><i class="icon-print"></i>打印</a>
		<a href="javascript:wb.ExecWB(8,1); " role="button" id="closeItem"
		class="btn btn-info noprint"><i class="icon-print"></i>打印设置</a>
		<a href="javascript:wb.ExecWB(7,1); " role="button" id="closeItem"
		class="btn btn-info noprint"><i class="icon-print"></i>打印预览</a>
	${printTemplateForm.fdModelHtml}
<!--end-->
</body>
</html>
