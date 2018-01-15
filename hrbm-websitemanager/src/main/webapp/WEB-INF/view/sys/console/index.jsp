<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>${sysTitle }-管理中心</title>
<script>
/*
 * @wang
 * 初始化工作
 * */
var CTX="${ctx}";
$(function(){
	initTree();
	init_tree_menu_event();
	initTabMenu();
// 	$("#desktop").attr("src","${ctx}/sys/console/my/desktop.xf");
	$('#reset_modify').splitbutton({
		iconCls:'icon-edit',
		menu:'#mm1'
	});
});
var setting = {
		async : {
			enable : true,
			type : "GET",
			dataFilter : function(treeId, parentNode, childNodes) {
				return childNodes;
			}
		},
		callback : {
			onClick : function(event, treeId, treeNode){
				//判断是否为文件夹

				var isLeaf = treeNode.isParent;
				var title = treeNode.resName;
				if(!isLeaf&&treeNode.resUrl){
					xfui.open_tabs(title,"${ctx}"+treeNode.resUrl);

				}else{
					var treeObj = $.fn.zTree.getZTreeObj(treeId);
					var expandFlag = treeNode.open==true?false:true;
					treeObj.expandNode(treeNode, expandFlag, false, true);

				}
			}
		},
		data: {
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey: "pId",
				rootPId: 0
			}
		},
		check : {
			enable : true,
			chkStyle : "radio",
			radioType : "all"
		}
	};

function initTree(){

	$(".ztree").each(function(i,e){
		var resId=$(e).attr("resId");
		setting.async.url= function(treeId, node) {
			return "${ctx}/sys/resource/sysResource/treeJson.xf?resId="+resId;
		},
		$.fn.zTree.init($("#menu_"+i), setting);
	})


}

function init_tree_menu_event(){
	$('.tree_menu').tree({
		onClick: function(node){
			//判断是否为文件夹
			var isLeaf = $(this).tree("isLeaf",node.target);
			var title = node.text;
			if(isLeaf){
				xfui.open_tabs(title,node.href);

			}else{
				//做点击文件夹的操作 当前开则关闭
				var state = node.state;
				if(state=='open'){
					$(this).tree("collapse",node.target);
				}else{
					$(this).tree("expand",node.target);
				}
			}
		}
	});
}
/**
 * 消息提示
 */
function show_message(message,title){
	if(!title) title = "提示信息";
	$.messager.show({
		title:title,
		msg:message,
		timeout:5000,
		showType:'slide'
	});
};
function initTabMenu(){

	/* $(document).bind('contextmenu',function(e){
		return false;
		});
	$(".tabs-selected").bind("mousedown",function(e){
		if(e.which==3){
			alert(e.which)
			$('#mm').menu('show', {
				left: event.pageX,
				top: event.pageY
			});
		}

	}); */
	$("#tab_content").tabs({
		onContextMenu:function(e,title,index){
			$(this).tabs("select",index);
			e.preventDefault();
            $('#tabContextMenu').menu('show',{
                left: e.pageX,
                top: e.pageY
            });
		}
	});


}
function tabMenuHandler(item){
	var id = item.id;
	switch(id){
		case 'closeCurrent':closeCurrent();break;
		case 'closeOthers':closeOthers();break;
		case 'closeAll':closeAll();break;
		default:alert("error");
	}
}
function closeCurrent(){
	var currentTab =  $("#tab_content").tabs("getSelected");
	$("#tab_content").tabs("close",currentTab.panel('options').title);
}
function closeOthers(item){
	 var currentTab =  $("#tab_content").tabs("getSelected");
	 var currentTabIndex = currentTab.panel('options').index;
	 var excludeIndex =new Array();
	 excludeIndex.push(0);
	 excludeIndex.push(currentTabIndex);
	 menuCloseTab(excludeIndex);
}
function closeAll(){
	 var excludeIndex =new Array();
	 excludeIndex.push(0);
	menuCloseTab(excludeIndex);
}

function menuCloseTab(excludeIndex){
	var allTabs =  $("#tab_content").tabs("tabs");
	$(allTabs).each(function(i,tab){
		var options = tab.panel('options');
		 var title =options.title;
		 var index = options.index;
		  if(!excludeIndex||excludeIndex.length==0){
			 $("#tab_content").tabs("close",title);
			 return;
		 }else{
			if(-1==$.inArray(index, excludeIndex)){
				 $("#tab_content").tabs("close",title);
				 return ;
			 }
		  }


	});
}

function modifyUser(){
	var id = ${sysUser.acd230};
	if(id){
	   xfui.open_dialog({
 		    title: '修改用户密码',
 		    width: 850,
 		    height: 500,
 		    closed: false,
 		    cache: false,
 		    url: '${ctx}/sys/uums/sysUser/modify.xf?acd230='+id,
 		    modal: true
 	  })
   }else{
	   $.messager.alert("提示","出错，请联系管理员");
   }
}
function aboutCompany(){
	xfui.open_dialog({
		    title: '关于公司',
		    width: 650,
		    height: 400,
		    closed: false,
		    cache: false,
		    url: '${ctx}/sys/uums/sysUser/about.xf',
		    modal: true
	  })
}
</script>
</head>
<div id="tabContextMenu" class="easyui-menu" style="width:120px;" data-options="onClick:tabMenuHandler">
    <div id="closeCurrent" >关闭当前页签</div>
    <div  id="closeOthers" >
        关闭其他页签
    </div>
    <div  id="closeAll"  >全部关闭</div>
</div>
	<div id="mm1" style="width:150px;">
	     <div id="select1"  onclick="aboutCompany()">关于</div>
	     <div id="select2" onclick="modifyUser()" icon="icon-edit">修改密码</div>
	</div>
<body class="easyui-layout" style="fit: true;">
	<div data-options="region:'north',border:false" class="head_bg">
		<div class="left_label">
		  	  ${indexTitle.value }

		</div>

	   <div class="right_bg" >
	       <div style="margin:15px;font-size:14px;" >
	                    欢迎您 ,
	                    <c:if test="${not empty sysOrg.acd202 }">
	                       ${sysOrg.acd202} >
	                    </c:if>
	                    <c:if test="${not empty sysDept.dep002 }">
	                       ${sysDept.dep002}  >
	                    </c:if>

	                    <span style="color:#0042ff;">${sysUser.aac003}</span>

	                    <!-- <a class="right_set" href="#" onclick="modifyUser()" id="" >设置</a> -->
	                        <font href="#" id="reset_modify" data-options ="icon:'icon-edit'" style="margin-right:6px;">设置</font>
	                    <a class="right_exit" href="${ctx}/logout">注销</a>
	           			<a class="right_help" title='帮助' href="${ctx}/help.chm">帮助</a>
	       </div>
	   </div>
	</div>
	<div data-options="region:'west',split:true,title:'导航菜单'"
		style="width: 180px; border: false;">
		<div class="easyui-accordion" data-options="fit:true,border:false">
           <c:forEach var="res" items="${sysResourceList}" varStatus="status">
                <div title="${res.resName}" data-options="selected:false" style="padding: 0px;">
                  <ul id="menu_${status.index}" class="ztree" resId="${res.resId}"></ul>
                </div>
			</c:forEach>

		</div>
	</div>
<!-- 	<div -->
<!-- 		data-options="region:'east',split:true,collapsed:true,title:'East'" -->
<!-- 		style="width: 100px; padding: 10px;">east region</div> -->
	<div data-options="region:'south',border:false" class="bottom_bg">
	 		<div >
             技术支持：河南讯丰信息技术有限公司 电话：0371-86502018
		  </div>
		</div>
	<div data-options="region:'center',border:false">
		<div class="easyui-tabs" id="tab_content" style="width: 100%;"
			data-options="fit:true,border:false">
<!-- 			<div title="我的桌面"  class="mydesktop" style="padding: 10px"> -->
<!-- 				<iframe id="desktop" scrolling="no" frameborder="0"  src="" style="width:100%;height:100%;"></iframe> -->
<!-- 			</div> -->
		</div>
	</div>
</body>
</html>
