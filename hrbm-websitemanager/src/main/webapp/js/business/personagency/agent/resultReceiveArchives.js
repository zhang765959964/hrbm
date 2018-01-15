	
	
	jQuery(function($) {
	 	// 日期选择
		$("[data-toggle='popover']").popover();

		$(".dbToggle").dblclick(function(){
			$(this).siblings(".moduleCont").slideToggle(400);
		});
	});
	
	//同步档案姓名
	function SyncContent(){
		var archiveNameOne = $("#archiveNameOne").val();
		$("#archiveNameTwo").val(archiveNameOne);
	}
	
