function formateDate(timeStamp){
		var date = new Date(timeStamp);
		var y = date.getFullYear();
	    var m = date.getMonth()+1;
	    var d = date.getDate();
	    return  y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
	}
	  function parseDate(s){
		if (s){
			return  new Date(s);
		} else {
			return new Date();
		}
	}
	  function formateTime(timeStamp){
			var date = new Date(timeStamp);
			var y = date.getFullYear();
		    var m = date.getMonth()+1;
		    var d = date.getDate();
		    var h = date.getHours();
		    var mt = date.getMinutes();
		    return  y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d)+' '+(h<10?('0'+h):h)+':'+(mt<10?('0'+mt):mt);
		}
	  
	  function formateHouse(timeStamp){
			var date = new Date(timeStamp);
			var y = date.getFullYear();
		    var m = date.getMonth()+1;
		    var d = date.getDate();
		    var h = date.getHours();
		    var mt = date.getMinutes();
		    return  y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d)+' '+(h<10?('0'+h):h)+':'+(mt<10?('0'+mt):mt);
		}