function initCityTree(callback){
		$.post(CTX+"/sys/tree/cityTree.xf",{},function(data){
			 var setting = {
					 	view: {
							dblClickExpand: false,
							showLine: false
						},
						data: {
							simpleData: {
								enable: true
							}
						},
						callback: {
							beforeExpand: beforeExpand,
							onExpand: onExpand,
							onClick: onClick,
							beforeClick: beforeClick
						}
						 
					};					 
			$.fn.zTree.init($("#treeCity"), setting, data); 
			callback();
		},'JSON');
		
	}

function onBodyDown(event) {
			if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
				hideMenu();
			}
		}
	function hideMenu() {
		$("#menuContent").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}
	var curExpandNode = null;
	function beforeExpand(treeId, treeNode) {
		var pNode = curExpandNode ? curExpandNode.getParentNode():null;
		var treeNodeP = treeNode.parentTId ? treeNode.getParentNode():null;
		var zTree = $.fn.zTree.getZTreeObj("treeCity");
		for(var i=0, l=!treeNodeP ? 0:treeNodeP.children.length; i<l; i++ ) {
			if (treeNode !== treeNodeP.children[i]) {
				zTree.expandNode(treeNodeP.children[i], false);
			}
		}
		while (pNode) {
			if (pNode === treeNode) {
				break;
			}
			pNode = pNode.getParentNode();
		}
		if (!pNode) {
			singlePath(treeNode);
		}

	}
	function singlePath(newNode) {
		if (newNode === curExpandNode) return;

        var zTree = $.fn.zTree.getZTreeObj("treeCity"),
                rootNodes, tmpRoot, tmpTId, i, j, n;

        if (!curExpandNode) {
            tmpRoot = newNode;
            while (tmpRoot) {
                tmpTId = tmpRoot.tId;
                tmpRoot = tmpRoot.getParentNode();
            }
            rootNodes = zTree.getNodes();
            for (i=0, j=rootNodes.length; i<j; i++) {
                n = rootNodes[i];
                if (n.tId != tmpTId) {
                    zTree.expandNode(n, false);
                }
            }
        } else if (curExpandNode && curExpandNode.open) {
			if (newNode.parentTId === curExpandNode.parentTId) {
				zTree.expandNode(curExpandNode, false);
			} else {
				var newParents = [];
				while (newNode) {
					newNode = newNode.getParentNode();
					if (newNode === curExpandNode) {
						newParents = null;
						break;
					} else if (newNode) {
						newParents.push(newNode);
					}
				}
				if (newParents!=null) {
					var oldNode = curExpandNode;
					var oldParents = [];
					while (oldNode) {
						oldNode = oldNode.getParentNode();
						if (oldNode) {
							oldParents.push(oldNode);
						}
					}
					if (newParents.length>0) {
						zTree.expandNode(oldParents[Math.abs(oldParents.length-newParents.length)-1], false);
					} else {
						zTree.expandNode(oldParents[oldParents.length-1], false);
					}
				}
			}
		}
		curExpandNode = newNode;
	}

	function onExpand(event, treeId, treeNode) {
		curExpandNode = treeNode;
	}
	function beforeClick(treeId, treeNode) {
		if (treeNode.isParent) {
			return true;
		} else {
			 var name = treeNode.name;
			/*  var parentNode = treeNode.getParentNode();
			 while(parentNode){
				name = parentNode.name+" "+name;
				parentNode = parentNode.getParentNode();
			 } */
			var treeObj = $.fn.zTree.getZTreeObj("treeCity");
			 treeObj.selectNode(treeNode,false)
			 $("#citySel").val(name);
			 $("#districtCode").val(treeNode.code);
			 hideMenu();
			return false;
		}
	}
	function onClick(e,treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("treeCity");
		zTree.expandNode(treeNode, null, null, null, true);
	}
	function showMenu() {
			var cityObj = $("#citySel");
			var cityOffset = $("#citySel").offset();
			
			$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"})
			.slideDown("fast").css("background","#e8ffff");
			$("body").bind("mousedown", onBodyDown);
			var treeObj = $.fn.zTree.getZTreeObj("treeCity");
			var nodes = treeObj.getSelectedNodes();
			var selectedNode = nodes[0];
		 
			$("#treeCity").scrollTop($("#"+selectedNode.tId).position().top);
			
		}