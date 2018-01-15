$(function() {
		$("#fillDate").xfdaterangepicker({autoUpdateInput:false,
			singleDatePicker : true,
			"opens" : "right",
			"drops" : "down",
			"locale" : {
				"format" : "YYYY-MM-DD"
			}
		});
		initFormSubimt();
		 var columns= [
	                   {field:'batchName',title:'批次名称',width:80,align:'center'},
	                   {field:'aab004',title:'单位名称',width:80,align:'center'},
      	        	];
		 $("#corpId").selectcommon({
			 url:CTX+'/business/personagency/subsidy/socialCorpDeclare/corpBatchList.xf',
			 columns: columns,
			 callBack:function(data){
				 if(data){
					 $("#tabcontext").load(CTX+"/business/personagency/subsidy/socialCorpDeclare/batchUpdateEdit.xf?id="+data.id);
					    
					}else{
						 bootbox.alert("未查到记录")
					}
				 
			   
			}
		 })
         initUserSearch();
		 $('a[href="#perEdu"]').on('show.bs.tab',function(e){

				var corpDeclareId=$("#id").val();
				if(!corpDeclareId){
					bootbox.alert("请先选择单位批次");
					return false;
				}
	
		 }).on('shown.bs.tab', function (e) {

		  var target =e.target;
		  var href=$(target).attr("href");
		   if(href=="#perEdu"){
			   initTable();
		   }
		  
		  
		})
	})
	
	function initUserSearch(){
		 var columns= [
	                   {field:'aac003',title:'人员姓名',width:80,align:'center'},
	                   {field:'aac002',title:'身份证号',width:80,align:'center'},
      	        	];
		$("#personSearch").selectcommon({
			 url:CTX+'/business/personagency/subsidy/socialSubsidy/batchUserListJson.xf?batchId='+$("#batchId").val(),
			 columns: columns,
			 callBack:function(data){
				 
				 if(data){
					 $("#batchList").jqGrid("setGridParam",{url:CTX+'/business/personagency/subsidy/socialSubsidy/batchListJson.xf?aac001='+data.personId+'&batchId='+$("#batchId").val()}).trigger("reloadGrid");
					}else{
						 bootbox.alert("未查到记录")
					}
				 
			}
		 })
	}
	function initFormSubimt() {
		$('#socialCorpDeclareForm').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				//发布名称
				pensionStand : {
					validators : {
						notEmpty : {},
						stringLength : {
							max : 6
						},
						regexp: {
                            regexp: /^([+-]?)\d*\.?\d+$/
                        }
					}
				},
				medicalStand : {
					validators : {
						notEmpty : {},
						stringLength : {
							max : 6
						},
						regexp: {
                            regexp: /^([+-]?)\d*\.?\d+$/
                        }
					}
				}
			}
		}).on('success.form.bv', function(e) {
			e.preventDefault();
			var $form = $(e.target);
			var bv = $form.data('bootstrapValidator');
			bv.disableSubmitButtons(true);
			updateItem(bv);

		});
	}
	function initTable(){
		
		var columns= [ {name:'batchName',label:'批次名称',align:'center',frozen : true},
		               {name:'aac002',label:'身份证号',align:'center',frozen : true},
		               {name:'aac003',label:'姓名',align:'center',frozen : true},
	                   {name:'subsidyNum',label:'编号',align:'center',frozen : true},
	                   {name:'oldSubsidyNum',label:'老编号',align:'center'},
	                   {name:'pensionMonths',label:'养老保险补贴月数',align:'center'},
	                   {name:'pensionStartDate',label:'养老补贴开始年份',align:'center'},
	                   {name:'pensionEndDate',label:'养老补贴结束年份',align:'center'},
	                   {name:'medicalMonths',label:'医疗保险补贴月数',align:'center'},
	                   {name:'medicalStartDate',label:'医疗补贴开始年份',align:'center'},
	                   {name:'medicalEndDate',label:'医疗补贴结束年份',align:'center'},
	                   {name:'contractSignDate',label:'签订劳动合同开始时间',align:'center'},
	                   {name:'contractEndDate',label:'签订劳动合同终止时间',align:'center'},
	                   {name:'contractDestoryDate',label:'劳动合同解除日期',align:'center'},
	                   {name:'isPassed',label:'是否通过',align:'center' },
	                   {name:'checkState',label:'审核标记',align:'center'},
	                   {name:'isHasBusLic',label:'是否持有营业执照',align:'center'},
	                   {name:'bankName',label:'开户银行',align:'center'},
	                   {name:'bankCardNo',label:'银行帐号',align:'center'},
	                   {name:'busLicNum',label:'营业执照编号',align:'center'},
	                   {name:'outerSubsidyMonths',label:'已在外单位享受补贴月数',align:'center'},
	                   {name:'createrNum',label:'登记次数',align:'center'},
	                   {name:'expOldCompany',label:'原工作单位',align:'center'},
	                   {name:'description',label:'备注',align:'center'},
	                   {name:'createrName',label:'经办人',align:'center'},
	                   {name:'createrDate',label:'经办日期',width:200,align:'center'},	                
	                   {name:'createrOrgName',label:'经办机构',align:'center'},
     	        	];
	$("#batchList").jqGrid({
		   url:CTX+'/business/personagency/subsidy/socialSubsidy/batchListJson.xf?batchId='+$("#batchId").val(),
	      mtype: "GET",
		   styleUI : 'Bootstrap',
	      datatype: "json",
	      colModel: columns,
		   viewrecords: true,
	      rowNum: 10,
	      rowList:[10,20,30],
	      pager: "#jqGridPager",
	      pagerpos:'left',
	      regional : 'cn',
	      recordpos:'right',
	      shrinkToFit: false,
	      multiselect:true,
	      height:"100%",
	      altRow:true,
	      autowidth: true
	  });
	//$("#batchList").jqGrid('setFrozenColumns');
	}

	function  updateItem(bv){
		var id=$("#id").val();
		if(!id){
		 bootbox.alert("请先选择单位批次");	
		 return;
		}
		var pensionStand=$("#pensionStand").val();
		var medicalStand=$("#medicalStand").val();
		var batchId=$("#batchId").val();
		$.ajax({ url: CTX+'/business/personagency/subsidy/socialSubsidy/batchUpdate.xf',
    		data:{id:id,batchId:batchId,pensionStand:pensionStand,medicalStand:medicalStand},
    		dataType:'json',
    		success: function(data){
    			if(data.message){
    				var id=$("#id").val();
    				bootbox.alert({ 
                        size: 'small',
                        width:"100px",
                        message: data.message,
                        callback:function(){
                        	bv.disableSubmitButtons(false);
                        	$("#tabcontext").load(CTX+"/business/personagency/subsidy/socialCorpDeclare/batchUpdateEdit.xf?id="+id);	
                        }
                    })
    				
    			}else{
    				bootbox.alert("未知错误"); 
    			}
             }
    	});
		
	}
//	
//	function selPerBase(obj){
//		$("#perBase").show();
//		$("#perEdu").hide();
//		$(obj).parent().siblings().removeClass("active");
//		$(obj).parent().addClass("active");
//	}
//	var flag=true;
//	function selPerEdu(obj){
//		var corpDeclareId=$("#id").val();
//		if(!corpDeclareId){
//			bootbox.alert("请先选择单位批次");
//			return;
//		}
//		$("#perBase").hide();
//		$("#perEdu").show();
//		$(obj).parent().siblings().removeClass("active");
//		$(obj).parent().addClass("active");
//		if(flag){
//			initTable();
//			flag=false;
//		}
//		
//	}