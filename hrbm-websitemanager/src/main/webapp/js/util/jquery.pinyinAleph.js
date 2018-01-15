;(function($, window, document,undefined) {
	
	$.fn.pinyinAleph = function(callback) {
		
		var $hzName = $(this);
		$hzName.bind(' change blur', function(e){
			  var pinyin=$(this).toPinyin();
			  if(pinyin.length>0){
				  var nameCode ="";
				  var pinyins =pinyin.split(" ");
				   $.each(pinyins,function(index,value){
					  	if(value){
					  		nameCode+=value.substr(0,1);
					  	}
				   });
				   callback(nameCode);
			  }
		});
		
	}
	
})(jQuery, window, document);

