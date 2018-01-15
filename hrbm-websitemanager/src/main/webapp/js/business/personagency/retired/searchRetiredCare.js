$(function (){
	initFormSubimt();
});

function initFormSubimt(){
    $('#retiredCareForm').bootstrapValidator({
           message: 'This value is not valid',
           feedbackIcons: {
               valid: 'glyphicon glyphicon-ok',
               invalid: 'glyphicon glyphicon-remove',
               validating: 'glyphicon glyphicon-refresh'
           },
           fields: {
        		//原因
				reason :{
					validators : {
						 stringLength: { max: 50 }
					}
				},
				//备注
				note :{
					validators : {
						 stringLength: { max: 100 }
					}
				}
               
           }
       }).on('success.form.bv', function(e) {
           e.preventDefault();
           var $form = $(e.target);
           var bv = $form.data('bootstrapValidator');
           bv.disableSubmitButtons(true);
             var ids=$("#retiredCareList").jqGrid("getGridParam","selarrrow");
             if(ids&&ids.length>0){
      			  var id="";
      			  $.each(ids,function(i,e){
      					if(i==0){
      						id+=e;
      					}else{
      						id+=","+e;
      					}
      				});
      		  var toJson=$("#retiredCareForm").serializeJson();
      		  toJson.pk_id=id;
      		  $.post($form.attr('action'), toJson, function(data) {
                   bootbox.alert({ 
                       size: 'small',
                       width:"100px",
                       message: data.message,
                       callback :function (){
	   					 bv.disableSubmitButtons(false);
	   					 $("#retiredCareList").trigger("reloadGrid");
                       }
                   })
                  }, 'json'); 
              }else{
            	  bootbox.alert('请选择记录');	
            	  bv.disableSubmitButtons(false);
              }
           });
   }
  function closeItem(){
	  
	  xfui.closeDialog();
  }
  
  //查询困难企业
  function searchParamsDiffCorp() {
		xfui.open_dialog({
			title : '查询困难企业',
			width : 800,
			height : 500,
			closed : false,
			cache : false,
			url : CTX + "/business/personagency/params/paramsDiffCorp/list.xf?type=1",
			modal : true
		})
	}
  
  
  