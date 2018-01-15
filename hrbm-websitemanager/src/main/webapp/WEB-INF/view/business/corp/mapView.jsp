<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=l5kCK1PnCuM4Tavr03T6aZx9"></script>
<script type="text/javascript" src="http://developer.baidu.com/map/jsdemo/demo/convertor.js"></script>
<body>

<div class="alert alert-success" role="alert">
		<span class="glyphicon glyphicon-info-sign"></span>
		<form id="fmmachine" method="post" class="form-horizontal">
			<div class="form-group">
				<div class="col-sm-6">
					<button class="btn btn-success" id="mySelect" >选择</button>
					<button class="btn btn-success" id="complete">结束选择</button>
				</div>
			</div>
		</form>
	</div>
	<br/>
	<div class="container-fluid" id="map" style="height: 420px;"></div>
	<script type="text/javascript">
	var corpName='${corpName}';
	var corpAddress='${corpAddress}';
		// 百度地图API功能
		function G(id) {
			return document.getElementById(id);
		}
		var opts = {
			width : 200,     // 信息窗口宽度
			height: 100,     // 信息窗口高度
			title : corpName, //信息窗口标题
			enableMessage:true,//设置允许信息窗发送短息
			message:corpAddress
		}
		var infoWindow = new BMap.InfoWindow(corpAddress, opts);  // 创建信息窗口对象
		var map = new BMap.Map("map");          // 创建地图实例
		var point = new BMap.Point(113.664694,34.753963);  // 创建点坐标
		var marker = new BMap.Marker(point);
		marker.addEventListener("click", function(){
			map.openInfoWindow(infoWindow, point); //开启信息窗口
		});
		var zoom=15;
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
				$("#cabq02").val(markerPosition["lng"]);
				$("#cabq03").val(markerPosition["lat"]);
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
	</script>
	<script src="${ctx}/js/lib/map/MarkerTool_min.js"></script>
</body>
</html>
