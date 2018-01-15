	$(function(){
		$("#expStartJobDate").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput:false,
			  formValidatorId : "receiveArchivesPersonForm",
			  "opens":"right",
			  "drops": "down",
	          "locale": {
	              "format": "YYYY-MM-DD"
	          }
	   });
		$("#faMarriageDate").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput:false,
			  formValidatorId : "receiveArchivesPersonForm",
			  "opens":"right",
			  "drops": "down",
	          "locale": {
	              "format": "YYYY-MM-DD"
	          }
	   });
		$("#faSpouseBirth").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput:false,
			  formValidatorId : "receiveArchivesPersonForm",
			  "opens":"right",
			  "drops": "down",
	          "locale": {
	              "format": "YYYY-MM-DD"
	          }
	   });
	   $("#aac046").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput:false,
			  formValidatorId : "receiveArchivesPersonForm",
			  "opens":"right",
			  "drops": "down",
	          "locale": {
	              "format": "YYYY-MM-DD"
	          }
	   });
	   $("#expPensionDate").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput:false,
			  formValidatorId : "receiveArchivesPersonForm",
			  "opens":"right",
			  "drops": "down",
	          "locale": {
	              "format": "YYYY-MM-DD"
	          }
	   });
	   $("#expMedicalDate").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput:false,
			  formValidatorId : "receiveArchivesPersonForm",
			  "opens":"right",
			  "drops": "down",
	          "locale": {
	              "format": "YYYY-MM-DD"
	          }
	   });
	   $("#receiveDate").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput:false,
			  formValidatorId : "receiveArchivesPersonForm",
			  "opens":"right",
			  "drops": "down",
	          "locale": {
	              "format": "YYYY-MM-DD"
	          }
	   });
	   $("#archiveBirthDate").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput:false,
			  formValidatorId : "receiveArchivesPersonForm",
			  "opens":"right",
			  "drops": "down",
	          "locale": {
	              "format": "YYYY-MM-DD"
	          }
	   });
	   $("#planRetiredDate").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput:false,
			  formValidatorId : "receiveArchivesPersonForm",
			  "opens":"right",
			  "drops": "down",
	          "locale": {
	              "format": "YYYY-MM-DD"
	          }
	   });
	   $("#collapseWrap1").on("click",function(e){
			collapseWrap('familyWrap',this);
	   });
	   $("#collapseWrap2").on("click",function(e){
		   collapseWrap('studyWrap',this);
	   });
	   $("#collapseWrap3").on("click",function(e){
		   collapseWrap('insuranceWrap',this);
	   });
	   
	 //根据身份证号自动填充年龄、性别
	  $("#faSpouseCard").bind('change blur', function(e){
		  var faSpouseCard = $("#faSpouseCard").val();
		   if(faSpouseCard){
			   $("#faSpouseBirth").val($(this).getBirthday());
			   $('#personBaseInfoForm').data('bootstrapValidator').updateStatus('faSpouseBirth','VALID', null).validateField('faSpouseBirth');
		   }else{
			   $("#faSpouseBirth").val('');
		   }
		})
	})
	//同步档案姓名
	function SyncContentUp(){
		var archiveNameOne = $("#archiveNameOne").val();
		$("#archiveNameTwo").val(archiveNameOne);
	}
	
	function SyncContentDown(){
		var archiveNameTwo = $("#archiveNameTwo").val();
		$("#archiveNameOne").val(archiveNameTwo);
	}
