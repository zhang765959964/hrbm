<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>单位基本信息表管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/common.jsp" %>
<script>

$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [[{field:'',title:'Id号',checkbox:'true',width:100,align:'center'},
	                   {field:'aab002',title:'社会保险登记证编码',width:100,align:'center'},
	                   {field:'aab036',title:'社会保险登记证发证日期',width:100,align:'center'},
	                   {field:'aab003',title:'组织机构代码',width:100,align:'center'},
	                   {field:'aab004',title:'单位名称',width:100,align:'center'},
	                   {field:'aab041',title:'单位英文名称',width:100,align:'center'},
	                   {field:'aab042',title:'单位简称',width:100,align:'center'},
	                   {field:'aab043',title:'单位拼音码',width:100,align:'center'},
	                   {field:'aab038',title:'单位IC卡号',width:100,align:'center'},
	                   {field:'aab019',title:'单位性质',width:100,align:'center'},
	                   {field:'aab020',title:'经济类型',width:100,align:'center'},
	                   {field:'aab054',title:'产业类别',width:100,align:'center'},
	                   {field:'aab022',title:'所属行业',width:100,align:'center'},
	                   {field:'aae007',title:'邮政编码',width:100,align:'center'},
	                   {field:'aae004',title:'联系人',width:100,align:'center'},
	                   {field:'aae005',title:'联系电话',width:100,align:'center'},
	                   {field:'aae006',title:'地址',width:100,align:'center'},
	                   {field:'aae015',title:'电子信箱',width:100,align:'center'},
	                   {field:'aae016',title:'网址',width:100,align:'center'},
	                   {field:'aab301',title:'所属地区行政区划代码',width:100,align:'center'},
	                   {field:'aaa021',title:'行政区划名称',width:100,align:'center'},
	                   {field:'aab007',title:'工商登记执照号码',width:100,align:'center'},
	                   {field:'aab010',title:'工商执照起始日期',width:100,align:'center'},
	                   {field:'aab011',title:'工商执照终止日期',width:100,align:'center'},
	                   {field:'cabq05',title:'是否已经发送执照年检提醒(0-未发送1-已发送)',width:100,align:'center'},
	                   {field:'cabq06',title:'组织机构代码或营业执照图片',width:100,align:'center'},
	                   {field:'cabq07',title:'网上后台验证是否通过(0-未通过1-已通过)',width:100,align:'center'},
	                   {field:'cabq08',title:'窗口验证是否通过(0-未通过1-手工认证2-设备认证3-公办认证)',width:100,align:'center'},
	                   {field:'aab006',title:'工商登记执照种类',width:100,align:'center'},
	                   {field:'aab008',title:'工商登记发照日期',width:100,align:'center'},
	                   {field:'aab021',title:'隶属关系',width:100,align:'center'},
	                   {field:'aab013',title:'法定代表人',width:100,align:'center'},
	                   {field:'aab014',title:'法定代表人身份证号码',width:100,align:'center'},
	                   {field:'aab015',title:'法定代表人电话',width:100,align:'center'},
	                   {field:'aab052',title:'主营范围',width:100,align:'center'},
	                   {field:'aab023',title:'主管部门',width:100,align:'center'},
	                   {field:'aab048',title:'经营方式',width:100,align:'center'},
	                   {field:'aab053',title:'兼营范围',width:100,align:'center'},
	                   {field:'acb101',title:'享受优惠政策单位类型',width:100,align:'center'},
	                   {field:'aab01d',title:'注销标记',width:100,align:'center'},
	                   {field:'aae013',title:'备注',width:100,align:'center'},
	                   {field:'aae011',title:'经办人代码',width:100,align:'center'},
	                   {field:'aae017',title:'经办机构代码',width:100,align:'center'},
	                   {field:'aae036',title:'经办日期',width:100,align:'center'},
	                   {field:'aae019',title:'经办人',width:100,align:'center'},
	                   {field:'aae020',title:'经办机构',width:100,align:'center'},
	                   {field:'bae011',title:'注销经办人代码',width:100,align:'center'},
	                   {field:'bae017',title:'注销经办机构代码',width:100,align:'center'},
	                   {field:'bae036',title:'注销日期',width:100,align:'center'},
	                   {field:'bae019',title:'注销经办人',width:100,align:'center'},
	                   {field:'bae020',title:'注销经办机构',width:100,align:'center'},
	                   {field:'bae022',title:'注销经办机构行政区划',width:100,align:'center'},
	                   {field:'aab025',title:'行业细类',width:100,align:'center'},
	                   {field:'aab026',title:'细类说明',width:100,align:'center'},
	                   {field:'aab01e',title:'从业人员总数',width:100,align:'center'},
	                   {field:'aab01f',title:'其中本市人员',width:100,align:'center'},
	                   {field:'aab01g',title:'其中外来人员',width:100,align:'center'},
	                   {field:'aae119',title:'单位状态',width:100,align:'center'},
	                   {field:'aab039',title:'用工登记证号',width:100,align:'center'},
	                   {field:'aaa130',title:'国别代码',width:100,align:'center'},
	                   {field:'aab040',title:'工资基金使用手册编号（用作公司办公地址）',width:100,align:'center'},
	                   {field:'aab056',title:'人员规模',width:100,align:'center'},
	                   {field:'aab045',title:'主办部门',width:100,align:'center'},
	                   {field:'bab002',title:'传真',width:100,align:'center'},
	                   {field:'aab012',title:'批准文号',width:100,align:'center'},
	                   {field:'aae008',title:'银行行号',width:100,align:'center'},
	                   {field:'aae009',title:'银行户名',width:100,align:'center'},
	                   {field:'aae010',title:'银行账号',width:100,align:'center'},
	                   {field:'aab027',title:'支付开户银行行号',width:100,align:'center'},
	                   {field:'aab028',title:'支付开户户名',width:100,align:'center'},
	                   {field:'aab029',title:'支付开户账号',width:100,align:'center'},
	                   {field:'aab030',title:'国税税务登记号',width:100,align:'center'},
	                   {field:'aab031',title:'国税税务机构编号',width:100,align:'center'},
	                   {field:'aab032',title:'国税税务机构名称',width:100,align:'center'},
	                   {field:'aab037',title:'国税税务证批准日期',width:100,align:'center'},
	                   {field:'aab046',title:'地税税务登记号',width:100,align:'center'},
	                   {field:'aab047',title:'地税税务机构名称',width:100,align:'center'},
	                   {field:'aab016',title:'缴费单位专管员姓名',width:100,align:'center'},
	                   {field:'aab017',title:'缴费单位专管员所在部门',width:100,align:'center'},
	                   {field:'aab018',title:'缴费单位专管员电话',width:100,align:'center'},
	                   {field:'aab024',title:'缴费开户银行行号',width:100,align:'center'},
	                   {field:'aab033',title:'缴费方式',width:100,align:'center'},
	                   {field:'aab500',title:'缴费周期',width:100,align:'center'},
	                   {field:'aab034',title:'社会保险经办机构编码',width:100,align:'center'},
	                   {field:'aab341',title:'单位年检情况',width:100,align:'center'},
	                   {field:'aab342',title:'单位级别',width:100,align:'center'},
	                   {field:'aab343',title:'一级单位编号',width:100,align:'center'},
	                   {field:'ccmu01',title:'用户编号',width:100,align:'center'},
	                   {field:'cabq01',title:'是否开通地图',width:100,align:'center'},
	                   {field:'cabq02',title:'X坐标',width:100,align:'center'},
	                   {field:'cabq03',title:'Y坐标',width:100,align:'center'},
	                   {field:'cabq04',title:'缩放比例',width:100,align:'center'},
	                   {field:'cabq09',title:'窗口认证时间',width:100,align:'center'},
	                   {field:'cabq10',title:'窗口认证到期时间',width:100,align:'center'},
	                   {field:'cabq11',title:'网上认证时间',width:100,align:'center'},
	                   {field:'cabq12',title:'网上认证到期时间',width:100,align:'center'},
	                   {field:'cabq13',title:'是否持卡会员F否T是',width:100,align:'center'},
	                   {field:'cabq14',title:'信用等级',width:100,align:'center'},
	                   {field:'cabq15',title:'有效期',width:100,align:'center'},
	                   {field:'cabq16',title:'申请时间',width:100,align:'center'},
	                   {field:'acb206',title:'单位简介',width:100,align:'center'},
	                   {field:'acb205',title:'乘车路线',width:100,align:'center'},
	                   {field:'cab011',title:'单位证件年检期',width:100,align:'center'},
	                   {field:'cczy06',title:'数据来源0未知1网站2窗口',width:100,align:'center'},
	                   {field:'cabq17',title:'会员积分',width:100,align:'center'},
	                   {field:'ccpr05',title:'最后修改时间',width:100,align:'center'},
	                   {field:'aae139',title:'联系人手机号码',width:100,align:'center'},
	                   {field:'aab049',title:'注册资金(万元)',width:100,align:'center'},
	                   {field:'ccpr06',title:'修改人',width:100,align:'center'},
	                   {field:'ccpr07',title:'修改来源',width:100,align:'center'},
	                   {field:'ccpr08',title:'暂不用使用AAE119',width:100,align:'center'},
	                   {field:'ccpr09',title:'是否推荐单位（0-否1-是）',width:100,align:'center'},
	                   {field:'ccpr10',title:'自建行业代码',width:100,align:'center'},
	                   {field:'ccpr11',title:'本月置顶次数',width:100,align:'center'},
	                   {field:'ccpr12',title:'最后置顶月份2013-01',width:100,align:'center'},
	                   {field:'ccpr13',title:'是否用人单位协会',width:100,align:'center'},
	                   {field:'bab014',title:'联系人身份证号码',width:100,align:'center'},
	                   {field:'bab015',title:'联系人职务',width:100,align:'center'},
	                   {field:'cahy12',title:'卡SN号',width:100,align:'center'},
	                   {field:'aab113',title:'代办人姓名',width:100,align:'center'},
	                   {field:'aab114',title:'代办人身份证号码',width:100,align:'center'},
	                   {field:'aab115',title:'代办人联系电话',width:100,align:'center'},
	                   {field:'ccpr14',title:'完善标记0-未完善1-已完善2-已合并',width:100,align:'center'},
	                   {field:'ccpr15',title:'是否存档0-否1-是',width:100,align:'center'},
	                   {field:'ccpr16',title:'CCPR16',width:100,align:'center'},
	                   {field:'ccpr17',title:'提交高拍仪证件照的地址',width:100,align:'center'},
	                   {field:'ccpr18',title:'是否推荐单位（0-否1-是）用于BS专题:网络招聘月',width:100,align:'center'},
	                   {field:'ccpr19',title:'用于劳务输出标志 0:非劳务输出单位 1:是劳务输出单位',width:100,align:'center'},
	                   {field:'ccpr20',title:'图片是否上传 0:未上传 1:已上传',width:100,align:'center'},
	                   {field:'ccpr21',title:'视频是否上传 0:未上传 1:已上传',width:100,align:'center'},
	                   {field:'ccpr22',title:'是否境外就业企业 0:否 1:是',width:100,align:'center'},
	                   {field:'ccpr23',title:'是否开通即时通信 0:未开通 1:已开通',width:100,align:'center'},
	                   {field:'ccpr24',title:'是否开通素质测评 0:未开通 1:已开通',width:100,align:'center'},
	                {field:'aab001',title:'操作',width:100,formatter: function(value,row,index){	 
				           return "<a href=\"javascript:void(0)\" onclick=\"stickTop('"+value+"')\" >编辑</a>|"+
								"<a href=\"javascript:void(0)\" onclick=\"previewArticle('"+value+"')\" >删除</a>";
							}
					 }
      	        	]];
	$('#enterpriseList').datagrid({
	    url:'${ctx}/business/enterprise/enterprise/listJson.xf',
	    columns:columns,
	    fitColumns:true,
		rownumbers: true,
        singleSelect: true,
        checkOnSelect:false,
        selectOnCheck:false,
		pagination: true, 
        rownumbers: true,
        multiSort:true,
		onLoadSuccess:function(data){
			if(data.total>0){
				$(this).datagrid("selectRow",0);
			}
			
		},
        pageList:[1,5,10]
	});
	
})

function addEnterprise(){	
		xfui.open_dialog({    
		    title: '新增单位基本信息表',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: "${ctx}/business/enterprise/enterprise/add.xf",
		    modal: true   
		})
}
function editEnterprise(){
	var row = $('#enterpriseList').datagrid('getSelected');
	if(row){
		var aab001=row.aab001;
		//xfui.open_tabs("编辑人员","${ctx}/sys/uums/sysUser/edit.xf?acd230="+acd230,"人员管理");
		xfui.open_dialog({    
	  		    title: '编辑单位基本信息表',    
	  		    width: 800,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: "${ctx}/business/enterprise/enterprise/edit.xf?aab001="+aab001,
	  		    modal: true   
	  		})
	}else{
		$.messager.alert('提示','请选择记录');
	}			
} 

function delEnterprise(){
	var row = $('#enterpriseList').datagrid('getSelections');
	if(row&&row.length>0){
		var aab001="";
		$.each(row,function(i,e){
			if(i==0){
				aab001+=e.aab001;
			}else{
				aab001+=","+e.aab001;
			}
			
		});
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
		    	$.ajax({ url: '${ctx}/business/enterprise/enterprise/del.xf',
		    		data:{aab001:aab001},
		    		dataType:'json',
		    		success: function(data){
		    			if(data.message){
		    				$.messager.alert('提示',data.message); 	
		    			}else{
		    				$.messager.alert('提示',"未知错误"); 
		    			}
		    			
		    			refresh();
		             }
		    	});
		    }    
		}); 
	  }else{
		 $.messager.alert('提示','请选择记录');
	 }			
} 
function refresh(){
	$('#enterpriseList').datagrid('load');
}
function doSearch(){
	
	var json=$("#searchForm").serializeJson();
	
	$("#enterpriseList").datagrid("load",json);
}
</script>
</head>
<body>
   <div id="dg_toolbar" style="padding: 5px 5px;">
		<a href="javascript:void(0)" class="easyui-linkbutton tb_add" onclick="addEnterprise()" data-options="iconCls:'icon-add'">添加</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton tb_edit" onclick="editEnterprise()" data-options="iconCls:'icon-edit'">修改</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton tb_destory" onclick="delEnterprise()" iconCls="icon-remove">删除</a>
	</div>
	<div class="div-line"></div>		
	<table id="enterpriseList" class="datagridClass"></table>
</body>
</html>


