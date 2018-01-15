$(function() {
		initFormSubimt();
		xfui.initUi();
		dateValidator();
		dateInitl();
		
		
	})
	
	function dateValidator(){
		var bootstrapValidator = $("#retiredCareForm").data('bootstrapValidator');  
		bootstrapValidator.updateStatus('fillDate','VALID', null).validateField('fillDate');
	}
	
	function dateInitl(){
		  $("#firstDate").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput :false,
			  formValidatorId : "retiredCareForm",
			  "opens":"right",
			  "drops": "down",
              "locale": {
                  "format": "YYYY-MM-DD"
              }
          });
		  var data = CurentTime();
		  $("#firstDate").val(data);
		  var fillDate = $("#fillDate").val();
		  if(fillDate==""){
			  $("#fillDate").val(data)
		  }
		  
		  
	}
	
	
	
	function initFormSubimt() {
		$('#retiredCareForm').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				//手机号
				mobilePhone : {
					validators : {
						notEmpty : {
							message : '手机号不能为空！'
						},
                        regexp: {
                			regexp: /^1[34578]\d{9}$/,
                			message: '手机号码格式不正确'
                        }
					}
				},
				
				//联系电话
				phone : {
					validators : {
						 stringLength: { max: 15 },
		               		regexp: {
	               					regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
	                     			message: '电话号码或手机号码格式不正确'
		               		}
					}
				},
				//初次填报日期
				firstFillDate : {
                   validators: {
                	   notEmpty: {
                			message : '初次填报日期不能为空'
                		},
                	   date: {
                           format: 'YYYY-MM-DD',
                           message: '请输入正确的时间格式'
                       }
                   }
               },
               //填报日期
               fillDate: {
                   validators: {
                	   date: {
                           format: 'YYYY-MM-DD',
                           message: '请输入正确的时间格式'
                       }
                   }
               },
			   //大病医保所在区域
               addre  : {
					validators : {
						 stringLength: { max: 50 }
					}
				},
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
			$.post($form.attr('action'), $form.serialize(), function(data) {
				bootbox.alert({
					size : 'small',
					width : "100px",
					message : data.message,
					callback : function() {
						var parentIframe = xfui.getParentIframe();
						if (parentIframe) {
							parentIframe.refresh();
						}
						closeItem();
					}
				})
			}, 'json');

		});
	}

	
function editRetiredCare(id){
		xfui.open_dialog({    
	  		    title: '大病医保信息',    
	  		    width: 1000,    
	  		    height: 600,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: CTX+"/business/personagency/retired/care/edit.xf?personId="+id,
	  		    modal: true   
	  		})
}




function careReload(){
	window.location.href=window.location.href;
	
}

function closeItem(){
	  
	  xfui.closeDialog();
}


//进入工作维护页面
function openWork(){
		var personIds  = $("#personId").val();
		if(personIds>0){
			xfui.open_dialog({    
			    title: '工作经历维护页面',    
			    width: 1000,    
			    height: 500,    
			    closed: false,    
			    cache: false,    
			    url: CTX+"/business/personagency/experience/list.xf?personId="+personIds,
			    modal: true   
			})
		}
		
}
