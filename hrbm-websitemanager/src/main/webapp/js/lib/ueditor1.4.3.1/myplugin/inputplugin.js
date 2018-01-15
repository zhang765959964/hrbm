UE.registerUI('span',function(editor,uiName){
    //创建dialog
    var dialog = new UE.ui.Dialog({
        //指定弹出层中页面的路径
        iframeUrl:'../../../../js/lib/ueditor1.4.3.1/myplugin/span/span.html',
        //需要指定当前的编辑器实例
        editor:editor,
        //指定dialog的名字
        name:"spanDialog",
        //dialog的标题
        title:"数据绑定插件",

        //指定dialog的外围样式
        cssRules:"width:300px;height:170px;",

        //如果给出了buttons就代表dialog有确定和取消
        buttons:[
            {
                className:'edui-okbutton',
                label:'确定',
                onclick:function () {
                    dialog.close(true);
                }
            },
            {
                className:'edui-cancelbutton',
                label:'取消',
                onclick:function () {
                    dialog.close(false);
                }
            }
        ]});
    editor.ui._dialogs.spanDialog=dialog;
    //参考myspan.js
    var btn = new UE.ui.Button({
        name:'spanbutton',
        title: uiName,
        //需要添加的额外样式，指定icon图标，这里默认使用一个重复的icon
        cssRules :'background-position: -500px 0;',
        onclick:function () {
            //渲染dialog
            dialog.render();
            dialog.open();
        }
    });
    var popup = new baidu.editor.ui.Popup({
        editor:editor,
        content:'',
        className:'edui-bubble',
        _onInputDelButtonClick:function(){
        	this.hide();
        	if(popup.anchorEl){
        		popup.anchorEl.parentNode.removeChild(popup.anchorEl);
        	}
        },
        //⑤扩展
        //处理输入框的修改
        _onInputEditButtonClick:function(){
        	this.hide();
        	var child=popup.anchorEl.childNodes[0];
        	var el=popup.anchorEl;
        	var external = popup.anchorEl.getAttribute("external");
        	debugger;
    		if(external){
    			if (el.tagName == 'SPAN'){
            			editor.curInputElement = popup.anchorEl;
            			editor.ui._dialogs.spanDialog.open();          		          
            	}else if(el.tagName == 'TABLE'){
            		   editor.curInputElement = popup.anchorEl;
        			   editor.ui._dialogs.subTableDialog.open();   
            	}
    		}
        	
        		
        	
        }
       
    });
    popup.render();
    editor.addListener('mouseover', function (t, evt) {
    	//⑧扩展
    	debugger;
    	 evt = evt || window.event;
         var el = evt.target || evt.srcElement;
		if(!(el.tagName&&el.parentElement))return;
		var external=el.getAttribute("external");
		//var parent=$G("dateTable");//$(el).parent("table[external]");
		var parent=document.getElementById("dateTable");
		var tableNode = UE.dom.domUtils.findParent( el, function ( node ) {

		     //由于查找的终点是body节点， 所以永远也不会匹配当前过滤器的条件， 即这里永远会返回false		    
		     if( node.tagName === "TABLE"&&node.getAttribute("external")){
		    	 return true;
		     }else{return false}

		 } );
		
		if(external){
			 html = popup.formatHtml(
	                '<nobr>'+editor.getLang("property")+': <span onclick="$$._onInputDelButtonClick()" class="edui-clickable">'+editor.getLang("delete")+'</span>&nbsp;&nbsp;' +	                       
	                '<span onclick="$$._onInputEditButtonClick(event, this);" class="edui-clickable">' + editor.getLang("modify") + '</span>&nbsp;&nbsp;'+
	                '</nobr>' );
			 popup.getDom( 'content' ).innerHTML = html;
			 popup.anchorEl = el;
			 popup.showAnchor(popup.anchorEl);
		}else if(tableNode){
			 html = popup.formatHtml(
	                '<nobr>'+editor.getLang("property")+': <span onclick="$$._onInputDelButtonClick()" class="edui-clickable">'+editor.getLang("delete")+'</span>&nbsp;&nbsp;' +	                       
	                '<span onclick="$$._onInputEditButtonClick(event, this);" class="edui-clickable">' + editor.getLang("modify") + '</span>&nbsp;&nbsp;'+
	                '</nobr>');
			 popup.getDom( 'content' ).innerHTML = html;
			 popup.anchorEl = tableNode;
			 popup.showAnchor(popup.anchorEl);
		}else{
			popup.hide();
		}				
    });
    
    return btn;
})
UE.plugins['span'] = function(){

    UE.commands['span'] = {
        execCommand : function( cmdName, opt,el ) {
        	debugger;
        	   var me=this;
               if(el){
               	var external="{\"key\":\""+opt.key+"\",\"name\":\""+opt.name+"\",\"type\":\""+opt.type+"\"}";
               	$(el).attr("external",external);
               	$(el).text("["+opt.name+"]");
               	
               }else{
               	var externalValue='<span  external="{&quot;key&quot;:&quot;'+opt.key+'&quot;,&quot;name&quot;:&quot;'+opt.name+'&quot;,&quot;type&quot;:&quot;'+opt.type+'&quot;}">['+opt.name+']</span>';
               	me.execCommand('inserthtml', externalValue);
               	
               }
        }

    };
};

//表格对话框

UE.registerUI('subTable',function(editor,uiName){
    //创建dialog
    var dialog = new UE.ui.Dialog({
        //指定弹出层中页面的路径
        iframeUrl:'../../../../js/lib/ueditor1.4.3.1/myplugin/table/table.html?version',
        //需要指定当前的编辑器实例
        editor:editor,
        //指定dialog的名字
        name:"subTableDialog",
        //dialog的标题
        title:"子表",

        //指定dialog的外围样式
        cssRules:"width:300px;height:170px;",

        //如果给出了buttons就代表dialog有确定和取消
        buttons:[
            {
                className:'edui-okbutton',
                label:'确定',
                onclick:function () {
                    dialog.close(true);
                }
            },
            {
                className:'edui-cancelbutton',
                label:'取消',
                onclick:function () {
                    dialog.close(false);
                }
            }
        ]});
    editor.ui._dialogs.subTableDialog=dialog;
    //参考myspan.js
    var btn = new UE.ui.Button({
        name:'subTablebutton',
        title: uiName,
        //需要添加的额外样式，指定icon图标，这里默认使用一个重复的icon
        cssRules :'background-position: -700px 0;',
        onclick:function () {
            //渲染dialog
            dialog.render();
            dialog.open();
        }
    });
    
    return btn;
})

UE.plugins['subtable'] = function(){

    UE.commands['subtable'] = {
        execCommand : function( cmdName, opt,el ) {
        	
            var me=this;
            var external="{\"key\":\""+opt.key+"\",\"colNum\":\""+opt.colNum+"\",\"rowNum\":\""+opt.rowNum+"\"}";
            if(el){
            	$(el).attr("external",external);
//            	var trWidth=$( "<tr class=\"firstRow\"></tr>");
//            	var trTitle=$( "<tr style=\"height:30pt;\"></tr>");
//            	var trFirst=$( "<tr style=\"height:35pt;\" formtype=\"datarow\"></tr>");
//            	$(el).find("tbody").html("");
//            	$(el).find("tbody").append(trWidth);
//            	$(el).find("tbody").append(trTitle);
//            	$(el).find("tbody").append(trFirst);
//            	
//            	for(var i=0;i<parseInt(opt.colNum);i++){
//            		trWidth.append("<td style=\"width:70pt; height:0pt;\"></td>");
//            		trTitle.append("<td class=\"u_r05\"></td>");
//            		trFirst.append("<td class=\"u_r010\"></td>");
//            		
//            	}
            }else{
            	var table=$("<table  class=\"dataTable\" style=\" border-collapse: collapse;table-layout: fixed;margin: 0px;padding: 0px;width:820.0pt;\"><tbody></tbody></table>");
            	var trWidth=$( "<tr class=\"firstRow\"></tr>");
            	var trTitle=$( "<tr style=\"height:30pt;\"></tr>");
            	var trFirst=$( "<tr style=\"height:35pt;\" formtype=\"datarow\"></tr>");
            	$(table).find("tbody").append(trWidth);
            	$(table).find("tbody").append(trTitle);
            	$(table).find("tbody").append(trFirst);
            	$(table).attr("external",external);
            	for(var i=0;i<parseInt(opt.colNum);i++){
            		trWidth.append("<td style=\"width:70pt; height:0pt;\"></td>");
            		trTitle.append("<td class=\"u_r05\"></td>");
            		trFirst.append("<td class=\"u_r010\"></td>");
            		
            	}
            	me.execCommand('inserthtml', table.prop("outerHTML"));
            	 
            }
            
            
        }

    };
};
