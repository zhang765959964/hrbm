$(function(){
	$("#lendDate").xfdaterangepicker({singleDatePicker:true,
		    autoUpdateInput:false,
		    formValidatorId:"archiveLendForm",
		    "opens":"right",
		    "drops": "up",
	        "locale": {
	            "format": "YYYY-MM-DD"
	        }
    });
})

function refresh(){
	$("#corpArchiveResultList").trigger("reloadGrid");
}

