<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 查询机管理表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/common.jsp" %>
	<script type="text/javascript">
	 function  submit(){
		 $('#machineForm').form('submit', {    
			    url:"${ctx}/business/machine/machine/save.xf",    
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
   	  <form:form modelAttribute="machineForm" method="post" >

				<table class="formTable">
				 <form:hidden path="id" ></form:hidden>
					<tr>
					 <td class="formHead" colspan="2">查询机管理表基本信息</td>
					</tr>
						<tr>
							<td class="formTitle">查询机名称: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="machineName"  data-options="required:true"></form:input>
						</tr>
						<tr>
							<td class="formTitle">查询机位置: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="machineAddress"  data-options="required:true"></form:input>
						</tr>
						<tr>
							<td class="formTitle">查询机Ip地址: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="machineIp"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">查询机编号: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="machineCode"  data-options="required:false"></form:input>
						</tr>
				</table>
        </form:form>
	<div class="alert alert-success" role="alert">
		<span class="glyphicon glyphicon-info-sign"></span>
		<br/>
		设置电子地图的提示：  使用选择按钮进行精确定位<br/>
		<br/>
		<form id="fmmachine" method="post" class="form-horizontal">
			<div class="form-group">
				<%--<label class="col-sm-2 control-label">请输入:</label>--%>
				<%--<div class="col-sm-4">--%>
					<%--<div id="r-result"><input type="text" id="suggestId" class="form-control"></div>--%>
					<%--<div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>--%>
				<%--</div>--%>
				<div class="col-sm-6">
					<button class="btn btn-success" id="mySelect">选择</button>
					<button class="btn btn-success" id="endSelect">结束选择</button>
					<button class="btn btn-success" id="complete">提交</button>
				</div>
			</div>
		</form>
	</div>
	<br/>
	<div class="container-fluid" id="map" style="height: 420px;"></div>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=l5kCK1PnCuM4Tavr03T6aZx9"></script>
	<script type="text/javascript" src="http://developer.baidu.com/map/jsdemo/demo/convertor.js"></script>
	<script type="text/javascript">
		// 百度地图API功能
		function G(id) {
			return document.getElementById(id);
		}
		var opts = {
			width : 200,     // 信息窗口宽度
			height: 100,     // 信息窗口高度
			title : '${machine.machineName}' , //信息窗口标题
			enableMessage:true,//设置允许信息窗发送短息
			message:'${machine.machineAddress}<br>'
		}
		var infoWindow = new BMap.InfoWindow('${machine.machineAddress}', opts);  // 创建信息窗口对象
		var map = new BMap.Map("map");          // 创建地图实例
		var point = new BMap.Point(113.664694,34.753963);  // 创建点坐标
		var marker = new BMap.Marker(point);
		marker.addEventListener("click", function(){
			map.openInfoWindow(infoWindow, point); //开启信息窗口
		});
		var zoom=15;
		<c:if test="${!empty machine.gprsX}">
		point = new  BMap.Point(${machine.gprsX}, ${machine.gprsY});
		zoom = ${machine.zoom};
		newMarker(point);
		map.openInfoWindow(infoWindow, point); //开启信息窗口
		</c:if>


		map.centerAndZoom(point, zoom);
		map.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
		map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用

		var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});// 左上角，添加比例尺
		var top_left_navigation = new BMap.NavigationControl();  //左上角，添加默认缩放平移控件
		function add_control(){
			map.addControl(top_left_control);
			map.addControl(top_left_navigation);
		}
		var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
				{"input" : "suggestId"
					,"location" : map
				});
		ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
			var str = "";
			var _value = e.fromitem.value;
			var value = "";
			if (e.fromitem.index > -1) {
				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
			}
			str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;

			value = "";
			if (e.toitem.index > -1) {
				_value = e.toitem.value;
				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
			}
			str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
			G("searchResultPanel").innerHTML = str;
		});

		var myValue;
		ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
			var _value = e.item.value;
			myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
			G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;

			setPlace();
		});
		function setPlace(){
			map.clearOverlays();    //清除地图上所有覆盖物
			function myFun(){
				point = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
				map.centerAndZoom(point, 18);
				marker = new BMap.Marker(point);
				map.addOverlay(marker);    //添加标注
				map.openInfoWindow(infoWindow, point); //开启信息窗口
			}
			var local = new BMap.LocalSearch(map, { //智能搜索
				onSearchComplete: myFun
			});
			local.search(myValue);
		}


		$(function(){
			add_control();
			mySelect();
			endSelect();
			//保存地图
			$("#complete").on("click",function(){
				$(this).attr("disabled","disabled");
				var markerPosition = marker.getPosition();
				var params = {};
				params.zoom=map.getZoom();
				params.x=markerPosition["lng"];
				params.y=markerPosition["lat"];
				params.id=$("#id").val();
				$.post("${ctx}/business/machine/machine/open-map.xf", params, function(data) {
					$("#complete").removeAttr("disabled");
					var title = '系统提示';
					if(data.result===1){
						$.messager.alert(title,"设置成功")
					}else{
						$.messager.alert(title,"出现未知错误") ;
					}

				}, 'json');

			});
		});
		//自己选择位置
		var myPushpin;
		function mySelect(){
			$("#mySelect").on("click",function(e){
				e.preventDefault();
				myPushpin = new BMapLib.MarkerTool(map,{autoClose: false, followText: ""})         // 创建标注工具实例
				myPushpin.addEventListener("markend", function(ee){  // 监听事件，提示标注点坐标信息
					map.removeOverlay(marker);    //清除地图上所有覆盖物
					point = ee.marker.point;
					marker = ee.marker;
					map.openInfoWindow(infoWindow, point); //开启信息窗口.
					ee.marker.addEventListener("click", function(){
						map.openInfoWindow(infoWindow, point); //开启信息窗口
					});
				});
				myPushpin.open();
			});
		};
		function newMarker(point){
			map.clearOverlays();    //清除地图上所有覆盖物
			map.openInfoWindow(infoWindow, point);
			marker = new BMap.Marker(point);
			map.addOverlay(marker);
			marker.addEventListener("click", function(){
				map.openInfoWindow(infoWindow, point); //开启信息窗口
			});
		}

		function endSelect(){
			$("#endSelect").on("click",function(e){
				e.preventDefault();
				myPushpin.close();
			});
		}

	</script>
	<script src="${ctx}/js/lib/map/MarkerTool_min.js"></script>
</body>
</html>
