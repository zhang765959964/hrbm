
//初始化	
$(function(){
	//init_datagrid();
	//init_form();
	
});
		
	//读身份证
	function Idcard(){
		var PortOpened=0;
		var CpuCardFound=0;
		var genderCode=9;
		var result;
		//注意：第一个参数为对应的设备端口，USB型为1001，串口型为1至16
		result=IdrControl1.ReadCard("1001","d:\\test\\test.jpg");
		//result=IdrControl1.ReadCard("1001","");
		if (result==1){
			$("#hzName").textbox("setValue",IdrControl1.GetName());
			$("#unId").textbox("setValue",IdrControl1.GetCode());
			var gender = IdrControl1.GetSex();
			gender=="男"?genderCode=1:genderCode=2;
			$("#genderCode").combobox("setValue",genderCode);
			doSearch();
		}else{
			if (result==-1)
				alert("端口初始化失败！");
			if (result==-2)
				alert("请重新将卡片放到读卡器上！");
			if (result==-3)
				alert("读取数据失败！");
			if (result==-4)
				alert("生成照片文件失败，请检查设定路径和磁盘空间！");
		}
	}
	
	
