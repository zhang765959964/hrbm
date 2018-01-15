<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 单位基本信息表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/common.jsp" %>
	<script type="text/javascript">
	 function  submit(){
		 $('#enterpriseForm').form('submit', {    
			    url:"${ctx}/business/enterprise/enterprise/save.xf",    
			    onSubmit: function(params){    
			    	var isValid = $(this).form('validate');
	                return isValid;
			    },    
			    success:function(data){   
			    	var data = eval('(' + data + ')');  
			    	if(data.message){
			    		$.messager.alert('系统提示',data.message,'',function(r){		    			
			    				xfui.closeDialog();
			    		}) 	
	    			}else{
	    				$.messager.alert('系统提示',"出现未知错误") ;
	    			}
			    	var parentIframe=xfui.getParentIframe();
			    	if(parentIframe){
			    		parentIframe.refresh();
			    	}
			    }    
			}); 
	 }
	  function closeItem(){
		  
		  xfui.closeDialog();
	  }
	</script>
</head>
<body>
	<div id="dg_toolbar" style="padding: 5px 5px;">
		<a href="javascript:void(0)" class="easyui-linkbutton tb_add" onclick="submit()" data-options="iconCls:'icon-save'">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton tb_destory" onclick="closeItem()" iconCls="icon-clear">关闭</a>
	</div>
   <div class="div-line"></div>
   	  <form:form modelAttribute="enterpriseForm" method="post" >

				<table class="formTable">
				 <form:hidden path="aab001" ></form:hidden>
					<tr>
					 <td class="formHead" colspan="2">单位基本信息表基本信息</td>
					</tr>
						<tr>
							<td class="formTitle">社会保险登记证编码: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab002"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle" width="200px">社会保险登记证发证日期: </td>
							<td class="formInput"><form:input class="easyui-datebox" type="text" path="aab036" data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle">组织机构代码: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab003"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">单位名称: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab004"  data-options="required:true"></form:input>
						</tr>
						<tr>
							<td class="formTitle">单位英文名称: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab041"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">单位简称: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab042"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">单位拼音码: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab043"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">单位IC卡号: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab038"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">单位性质: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab019"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">经济类型: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab020"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">产业类别: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab054"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">所属行业: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab022"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">邮政编码: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae007"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">联系人: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae004"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">联系电话: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae005"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">地址: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae006"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">电子信箱: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae015"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">网址: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae016"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">所属地区行政区划代码: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab301"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">行政区划名称: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aaa021"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">工商登记执照号码: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab007"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle" width="200px">工商执照起始日期: </td>
							<td class="formInput"><form:input class="easyui-datebox" type="text" path="aab010" data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle" width="200px">工商执照终止日期: </td>
							<td class="formInput"><form:input class="easyui-datebox" type="text" path="aab011" data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle">是否已经发送执照年检提醒(0-未发送1-已发送): </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="cabq05"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">组织机构代码或营业执照图片: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="cabq06"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">网上后台验证是否通过(0-未通过1-已通过): </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="cabq07"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">窗口验证是否通过(0-未通过1-手工认证2-设备认证3-公办认证): </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="cabq08"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">工商登记执照种类: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab006"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle" width="200px">工商登记发照日期: </td>
							<td class="formInput"><form:input class="easyui-datebox" type="text" path="aab008" data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle">隶属关系: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab021"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">法定代表人: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab013"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">法定代表人身份证号码: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab014"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">法定代表人电话: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab015"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">主营范围: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab052"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">主管部门: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab023"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">经营方式: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab048"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">兼营范围: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab053"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">享受优惠政策单位类型: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="acb101"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">注销标记: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab01d"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">备注: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae013"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">经办人代码: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae011"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">经办机构代码: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae017"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle" width="200px">经办日期: </td>
							<td class="formInput"><form:input class="easyui-datebox" type="text" path="aae036" data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle">经办人: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae019"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">经办机构: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae020"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">注销经办人代码: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="bae011"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">注销经办机构代码: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="bae017"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle" width="200px">注销日期: </td>
							<td class="formInput"><form:input class="easyui-datebox" type="text" path="bae036" data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle">注销经办人: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="bae019"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">注销经办机构: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="bae020"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">注销经办机构行政区划: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="bae022"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">行业细类: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab025"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">细类说明: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab026"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">从业人员总数: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab01e"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">其中本市人员: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab01f"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">其中外来人员: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab01g"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">单位状态，用作删除标志1	登记在册
2	破产
3	注销
4	被兼并
9	其它
: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae119"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">用工登记证号: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab039"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">国别代码: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aaa130"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">工资基金使用手册编号（用作公司办公地址）: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab040"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">人员规模: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab056"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">主办部门: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab045"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">传真: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="bab002"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">批准文号: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab012"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">银行行号: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae008"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">银行户名: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae009"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">银行账号: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae010"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">支付开户银行行号: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab027"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">支付开户户名: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab028"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">支付开户账号: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab029"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">国税税务登记号: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab030"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">国税税务机构编号: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab031"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">国税税务机构名称: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab032"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle" width="200px">国税税务证批准日期: </td>
							<td class="formInput"><form:input class="easyui-datebox" type="text" path="aab037" data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle">地税税务登记号: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab046"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">地税税务机构名称: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab047"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">缴费单位专管员姓名: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab016"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">缴费单位专管员所在部门: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab017"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">缴费单位专管员电话: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab018"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">缴费开户银行行号: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab024"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">缴费方式: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab033"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">缴费周期: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab500"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">社会保险经办机构编码: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab034"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">单位年检情况: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab341"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">单位级别: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab342"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">一级单位编号: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab343"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">用户编号: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccmu01"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">是否开通地图: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="cabq01"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">X坐标: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="cabq02"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">Y坐标: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="cabq03"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">缩放比例: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="cabq04"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle" width="200px">窗口认证时间: </td>
							<td class="formInput"><form:input class="easyui-datebox" type="text" path="cabq09" data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle" width="200px">窗口认证到期时间: </td>
							<td class="formInput"><form:input class="easyui-datebox" type="text" path="cabq10" data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle" width="200px">网上认证时间: </td>
							<td class="formInput"><form:input class="easyui-datebox" type="text" path="cabq11" data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle" width="200px">网上认证到期时间: </td>
							<td class="formInput"><form:input class="easyui-datebox" type="text" path="cabq12" data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle">是否持卡会员F否T是: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="cabq13"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">信用等级: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="cabq14"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle" width="200px">有效期: </td>
							<td class="formInput"><form:input class="easyui-datebox" type="text" path="cabq15" data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle" width="200px">申请时间: </td>
							<td class="formInput"><form:input class="easyui-datebox" type="text" path="cabq16" data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle">单位简介: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="acb206"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">乘车路线: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="acb205"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle" width="200px">单位证件年检期: </td>
							<td class="formInput"><form:input class="easyui-datebox" type="text" path="cab011" data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle">数据来源0未知1网站2窗口: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="cczy06"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">会员积分: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="cabq17"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle" width="200px">最后修改时间: </td>
							<td class="formInput"><form:input class="easyui-datebox" type="text" path="ccpr05" data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle">联系人手机号码: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae139"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">注册资金(万元): </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab049"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">修改人: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr06"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">修改来源: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr07"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">暂不用使用AAE119: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr08"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">是否推荐单位（0-否1-是）: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr09"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">自建行业代码: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr10"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">本月置顶次数: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr11"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">最后置顶月份2013-01: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr12"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">是否用人单位协会会员0-否1-是
: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr13"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">联系人身份证号码: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="bab014"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">联系人职务: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="bab015"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">卡SN号: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="cahy12"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">代办人姓名: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab113"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">代办人身份证号码: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab114"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">代办人联系电话: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab115"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">完善标记0-未完善1-已完善2-已合并: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr14"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">是否存档0-否1-是: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr15"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">CCPR16: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr16"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">提交高拍仪证件照的地址: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr17"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">是否推荐单位（0-否1-是）用于BS专题:网络招聘月: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr18"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">用于劳务输出标志 0:非劳务输出单位 1:是劳务输出单位: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr19"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">图片是否上传 0:未上传 1:已上传: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr20"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">视频是否上传 0:未上传 1:已上传: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr21"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">是否境外就业企业 0:否 1:是: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr22"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">是否开通即时通信 0:未开通 1:已开通: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr23"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">是否开通素质测评 0:未开通 1:已开通: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr24"  data-options="required:false"></form:input>
						</tr>
				</table>
        </form:form>
</body>
</html>
