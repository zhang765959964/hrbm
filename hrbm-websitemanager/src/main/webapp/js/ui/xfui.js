/**author :wanghan 
 * UI 公共js
 */
// 全局UI对象
window['xfui'] || (window['xfui'] = {});
//window['tab_content'] || (window['tab_content'] = $("#tab_content"));
$(function(){
	window['xfui_tab_Top'] =parent.window['xfui_tab_Top']||$("#navrightTop");
	window['xfui_tab_content'] =parent.window['xfui_tab_content']||$("#tabContent");
	window['tabIndex'] =parent.window['tabIndex']||0;
	window['frameIndex'] =parent.window['frameIndex']||0;
	window['rootWin'] =parent.window||window;
	docheight=$(document).height();
	winheight=$(window).height();
	//var currentFrame=xfui.getCurrentFrame();
	//$(currentFrame).parent(".tab-pane").height(docheight);
	window.onresize=function(){
		//alert(3)
		//docheight=$(document).height();
		//xfui.setTabHeight(docheight);
	}
	
//    $(window).resize(function(){
//    	 $(".datagridClass").each(function(i,e){
//    		 var width=$(e).closest(".moduleCont").width();
//    		 
//    		 $(e).setGridWidth(width*0.99); 
//    	 })
//	  })
	  
})

var basexfui={
	   
	    iframeDialog:{},
		//使用iframe添加页签
	   open_tabs:function(title, href,parentTitle,icon){
//		   $('#navLeft li').removeClass('active');
//           $(_this).addClass('active');
		   if(!href){
			   return;
		   }
           var l = this.tab_exist(title);
           if (l.toString().length > 0) {
        	   xfui_tab_Top.find('a:eq(' + l + ')').tab('show');
        	   this.refresh_tabs({index:l,url:href});  
               return;
           }
       	 if(xfui_tab_Top.find('li').length>=8){
    		bootbox.alert("最多只能打开8个窗口");
    		return;
    	 }
           var newtabId=this.autoTabId();
           
           var currentId=this.getCurrentFrameId()||0;
           var xfui_tab_Top_li=$('<li ><a href="#a_' + newtabId + '" data-toggle="tab">' + title + '<i class="icon-remove" onclick="xfui.closePrivateTab(this)" style=" margin-left:8px;width:10px;height:10px;display:inline" ></i></a></li>');
           xfui_tab_Top.append(xfui_tab_Top_li);
//           xfui_tab_Top_li.find("a i.icon-remove").on("click",function(){
//        	   window.xfui.closePrivateTab(this);
//           })
           xfui_tab_content.append($('<div class="tab-pane" id="a_' + newtabId + '" style="height:100%;margin-top:5px;"><iframe pid="'+currentId+'" openmodel="0" scrolling="yes" src="' + href + '" style="border:0px;width:100%;height:100%;" id="frm_' + newtabId + '"></iframe></div>'));
           xfui_tab_Top.find('a:last').tab('show');
		},
		 tab_exist:function(title) {
            var c = xfui_tab_Top.find("li a");
            var aid = "";
            for (var i = 0; i < c.length; i++) {
                if ($(c[i]).text() == title) {
                    aid = i;
                }
            }
            return aid;
        },
		//使用iframe添加页签
		   open_old_dialog:function(params){
			  var  id=this.autoFrameId();

			  //在一个窗口上只能弹出一个子窗口，所以一个窗口下只需保留一个dialag 实例
	           var currentId=params.currentId;
	           params.close=function(event, ui){
	        	   
	        	   xfui.showParentDialog(currentId);
	           }
	           
	           
	           var  _iframe=$("div .mhyDialog:has(iframe[pid="+currentId+"])");
			   if(_iframe.length>0){
				   _iframe.dialog(params);
				   _iframe.find("iframe").attr("src",params.url);
				   _iframe.dialog('open');
				   this.hideParentDialog(currentId);
				   return;
			   }
			    _iframe = $('<div class="mhyDialog"><iframe pid="'+currentId+'" width="100%" height="100%" frameborder=0 openmodel="1" id="' + id + '"  ></iframe></div>');
			   $(document.body).append(_iframe);
			   _iframe.dialog(params);
			   _iframe.dialog('open');
			   this.hideParentDialog(currentId);
			   _iframe.find("iframe").attr("src",params.url);

			   this.iframeDialog[id]=_iframe;
			},	
			//使用iframe添加页签
			   open_dialog:function(params){
				   var currentId=this.getCurrentFrameId()||0;
				   var rootWin=window['rootWin'];
				   params.currentId=currentId;
				   rootWin.xfui.open_old_dialog(params);
				   
				},		
		//刷新页签
		 refresh_tabs:function(cfg){
			var refresh_tab=xfui_tab_content.find('div:eq(' + cfg.index + ')')
			if(refresh_tab && refresh_tab.find('iframe').length > 0){  
			    var _refresh_ifram = refresh_tab.find('iframe')[0];  
			    var refresh_url = cfg.url?cfg.url:_refresh_ifram.src;
			    _refresh_ifram.contentWindow.location.href=refresh_url;  
		   }  
		},
		autoFrameId: function () {
			if(parent.window['frameIndex']){
        		parent.window['frameIndex']=parent.window['frameIndex']+1;
        		frameIndex=parent.window['frameIndex'];
        	}else{
        		frameIndex++;
        	}
            return "_xf_frame_id_" + frameIndex;
        },
        autoTabId: function () {

        	if(parent.window['tabIndex']){
        		parent.window['tabIndex']=parent.window['tabIndex']+1;
        		tabIndex=parent.window['tabIndex'];
        	}else{
        		tabIndex++;
        	}
        	
            return "xf_tab_id_" +tabIndex;
        },
        getCurrentFrameId: function () {
            if (this.frameId) {
                return this.frameId;
            }
            var iframes = $(window['rootWin'].document).find("iframe");
            for (var i = 0; i < iframes.length; i++) {
                if (iframes[i].contentWindow == window) {
                    this.frameId = iframes[i].id;
                    return this.frameId;
                }
            }
            return null;
        },
        getCurrentFrame: function () {
            var iframes = $(window['rootWin'].document).find("iframe");
            for (var i = 0; i < iframes.length; i++) {
                if (iframes[i].contentWindow == window) {
                	return iframes[i];
                }
            }
            return null;
        },
        getFrameTabTitle: function () {
            if (this.tabTitle) {
                return this.tabTitle;
            }
            var iframes = $(window.parent.document).find("iframe");
            for (var i = 0; i < iframes.length; i++) {
                if (iframes[i].contentWindow == window) {
                    this.tabTitle = $(iframes[i]).attr("tabtitle");
                    return this.tabTitle;
                }
            }
            return null;
        },
        getFrameOpenModel: function () {
            if (this.openModel) {
                return this.openModel;
            }
            var iframes = $(window.parent.document).find("iframe");
            for (var i = 0; i < iframes.length; i++) {
                if (iframes[i].contentWindow == window) {
                    this.openModel = $(iframes[i]).attr("openmodel");
                    return this.openModel;
                }
            }
            return null;
        },
        closeDialog:function(){

        	var frameId=this.getCurrentFrameId();
        	var currentFrame=this.getCurrentFrame();
        	var currentFrame_dialog=window['rootWin'].xfui.iframeDialog[frameId];
        	currentFrame_dialog.dialog('close');
        	var parentId = $(currentFrame).attr("pid"); 
        	//this.showParentDialog(parentId);
//        	currentFrame.dialog('destroy');
        	//window.parent.xfui.iframeDialog[frameId]=null;
        },
        
        closePrivateTab:function(_this){
               $(_this).parent().parent().remove();
               $('#' + $(_this).parent().attr("href").substring(1)).remove();
               xfui_tab_Top.find('a:last').tab('show');
        },
        closeTab:function(){
        	var currentFrame=this.getCurrentFrame();
            var parentTab=$(currentFrame).parent(".tab-pane");
            var tabId=parentTab.attr("id");
            var top_tab=$("a[href='#"+tabId+"']",xfui_tab_Top);
            $(top_tab).parent().remove();
            
            xfui_tab_Top.find('a:last').tab('show');
            parentTab.remove();
       },
        getParentIframe:function(){
        	
        	var currentFrame=this.getCurrentFrame();
        	var openModel = $(currentFrame).attr("openmodel");      
        	var parentIframe=null;
//        	if(openModel=="0"){
        		var parentId = $(currentFrame).attr("pid"); 
        		var refresh_tab=$("#"+parentId,$(window['rootWin'].document));
    			if(refresh_tab&&refresh_tab.length>0 ){ 
    				
    				parentIframe = refresh_tab.get(0).contentWindow;
    			    
    			 }  
//    	    	
//        	}else if(openModel=="1"){
//        		var parentId = $(currentFrame).attr("pid"); 
//        		parentIframe = $("#"+parentId,$(window['rootWin'].document)).get(0).contentWindow;
//        	}
        	
        	return parentIframe;
        },
        hideParentDialog:function(parentId){
        	 var dialogUI=$("div[role=dialog]:has(iframe[id="+parentId+"])",$(window['rootWin'].document.body));
	           if(dialogUI.length>0){
	        	   dialogUI.css("z-index",1035);  
			   }
        },
        showParentDialog:function(parentId){
	        var dialogUI=$("div[role=dialog]:has(iframe[id="+parentId+"])",$(window['rootWin'].document.body));
	           if(dialogUI.length>0){
	        	   dialogUI.css("z-index",1050);  
			  }
        },
        setTabHeight:function(docheight){
        	var currentFrame=this.getCurrentFrame();
        	$(currentFrame).parent(".tab-pane").height(docheight);
        },
        initUi:function(){
        	$.each($(".date"),function(i,e){
        		var format=$(e).attr("format");
        		var autoUpdateInput=$(e).attr("autoUpdateInput")=="false"?false:true;
        		var formValidatorId=$(e).attr("formValidatorId");
        		$(e).xfdaterangepicker({singleDatePicker:true,autoUpdateInput:autoUpdateInput,formValidatorId:formValidatorId,
  				  "opens":"right",
  				  "drops": "down",
  	              "locale": {
  	                  "format": format
  	              }
  	          });
        	})
        	 
        },
        getRootWindow :function(currentwin){
        	
        	var win=currentwin.parent.window
        	return win;
//        	if(win==null){
//        		return currentwin;
//        	}else{
//        		return  this.getRootWindow(win)
//        	}
        }
}
$.extend(true, xfui, basexfui);
$.fn.xfload=function(url,callBack){
	
	var ajaxbg = $("#background,#progressBar"); 
	ajaxbg.show(); 
	$(this).load(url,function(){
		ajaxbg.hide(); 
		callBack();
	});
}

