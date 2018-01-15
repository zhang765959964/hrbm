/**
 * UI 公共js
 */
// 全局UI对象
window['xfui'] || (window['xfui'] = {});
//window['tab_content'] || (window['tab_content'] = $("#tab_content"));
$(function(){
	window['xfui_tab_content'] =parent.window['xfui_tab_content']||$("#tab_content");
})
var basexfui={
	   
	    iframeDialog:{},
		//使用iframe添加页签
	   open_tabs:function(title, href,parentTitle,icon){
		   var tabs =xfui_tab_content.tabs("tabs");
		  
		    if (xfui_tab_content.tabs('exists', title)){//如果tab已经存在,则选中并刷新该tab          
		    	xfui_tab_content.tabs('select', title);  
		    	this.refresh_tabs({tabTitle:title,url:href});  
		    } else { 
		    	 if(tabs.length>=10){
					   $.messager.alert('提示','本系统默认最多打开10个页签！请先关闭其他再打开！',"info");
					   return ;
				   }
		        if (href){  
		            var content = '<iframe openmodel="0" parenttitle="'+parentTitle+'" tabtitle="'+title+'" scrolling="yes" frameborder="0"  src="'+href+'" style="width:100%;height:100%;"></iframe>';  
		        } else {  
		            var content = '<div style="position: absolute;width:400px;height:200px;left:50%;top:50%;margin-left:-200px;margin-top:-100px;border:1px solid #00F ">建设中。。。。<div>';  
		        }  
		        xfui_tab_content.tabs('add',{  
		            title:title,  
		            closable:true,  
		            content:content,  
		            iconCls:icon  
		        });  
		    }  
		},
		//使用iframe添加页签
		   open_dialog:function(params){
			  var  id=this.autoFrameId();
			   var _iframe = $('<iframe openmodel="1" id="' + id + '"  ></iframe>');
			   _iframe.dialog(params);  
			   _iframe.attr("src",params.url);
			   this.iframeDialog[id]=_iframe;
			},	
		//刷新页签
		 refresh_tabs:function(cfg){
			var refresh_tab = cfg.tabTitle?xfui_tab_content.tabs('getTab',cfg.tabTitle):$('#tabs').tabs('getSelected');  
			if(refresh_tab && refresh_tab.find('iframe').length > 0){  
			    var _refresh_ifram = refresh_tab.find('iframe')[0];  
			    var refresh_url = cfg.url?cfg.url:_refresh_ifram.src;
			    _refresh_ifram.contentWindow.location.href=refresh_url;  
			    }  
		},
		autoFrameId: function () {
            this.frameIndex = this.frameIndex || 0;
            this.frameIndex++;
            return "_xf_frame_id_" + this.frameIndex;
        },
        getFrameId: function () {
            if (this.frameId) {
                return this.frameId;
            }
            var iframes = $(window.parent.document).find("iframe");
            for (var i = 0; i < iframes.length; i++) {
                if (iframes[i].contentWindow == window) {
                    this.frameId = iframes[i].id;
                    return this.frameId;
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
        getFrameParentTabTitle: function () {
            if (this.parentTitle) {
                return this.parentTitle;
            }
            var iframes = $(window.parent.document).find("iframe");
            for (var i = 0; i < iframes.length; i++) {
                if (iframes[i].contentWindow == window) {
                    this.parentTitle = $(iframes[i]).attr("parenttitle");
                    return this.parentTitle;
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
        	var frameId=this.getFrameId();
        	var currentFrame=window.parent.xfui.iframeDialog[frameId];
        	currentFrame.dialog('close');
        	window.parent.xfui.iframeDialog[frameId]=null;
        },
        closeTab:function(){
        	var tabTitle=this.getFrameTabTitle();
        	xfui_tab_content.tabs('close',tabTitle)
        },
        getParentIframe:function(){
        	openModel=this.getFrameOpenModel();
        	var parentIframe=null;
        	if(openModel=="0"){
        		var tabTitle=xfui.getFrameParentTabTitle();
        		if(tabTitle == 'undefined') return ;
    	    	var parentIframeArray=xfui_tab_content.tabs('getTab',tabTitle).find("iframe");
    	    	if(parentIframeArray.length>0){
    	    		parentIframe=parentIframeArray[0].contentWindow;
    	    	}
        	}else if(openModel=="1"){
        		parentIframe=window.parent;
        	}
        	
        	return parentIframe;
        }
}
$.extend(true, xfui, basexfui);

