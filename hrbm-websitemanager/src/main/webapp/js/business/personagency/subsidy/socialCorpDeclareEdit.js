	$(function() {
		initFormSubimt();
		$("#fillDate").xfdaterangepicker({autoUpdateInput:false,formValidatorId:'socialCorpDeclareForm',
			singleDatePicker : true,
			"opens" : "right",
			"drops" : "down",
			"locale" : {
				"format" : "YYYY-MM-DD"
			}
		});
		$("select[name=batchId]").on("change",function(){
			
			var corpId=$("#aab001").val();
			var id=$("#id").val();
			var batchId=$(this).val();
			$("#tabcontext").load(CTX+"/business/personagency/subsidy/socialCorpDeclare/edit.xf?id="+id+"&corpId="+corpId+"&batchId="+batchId,function(){
				var isOverBatch=$("#isOverBatch").val();
				
				if(isOverBatch=="true"){
					bootbox.alert("该批次已申报");
				}
			});
		})
		 var columns= [
	                   {field:'batchName',title:'批次名称',width:80,align:'center'},
	                   {field:'aab004',title:'单位名称',width:80,align:'center'},
      	        	];
		 $("#corpId").selectcommon({
			 url:CTX+'/business/personagency/subsidy/socialCorpDeclare/corpBatchList.xf',
			 columns: columns,
			 callBack:function(data){
				 if(data){
					 $("#tabcontext").load(CTX+"/business/personagency/subsidy/socialCorpDeclare/edit.xf?id="+data.id);
					    
					}else{
						 bootbox.alert("未查到记录")
					}
				 
			   
			}
		 })
         initUserSearch();
		 $('a[href="#perEdu"]').on('show.bs.tab',function(e){
 
				var mvcMethod=$("#mvcMethod").val();
				if(mvcMethod=="add"){
					bootbox.alert("请选择批次或者保存当前批次后操作");
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
					 $("#batchList").jqGrid("clearGridData");
					 $("#batchList").jqGrid("setGridParam",{url:CTX+'/business/personagency/subsidy/socialSubsidy/batchListJson.xf?aac001='+data.personId+'&batchId='+$("#batchId").val()}).trigger("reloadGrid");
					}else{
						 bootbox.alert("未查到记录")
					}
				 
			   
			}
		 })
	}
	
	function initTable(){
		
		var columns= [ {name:'batchName',label:'批次名称',align:'center',frozen : true},
		               {name:'aac002',label:'身份证号',align:'center',frozen : true,formatter:function(cellvalue, options, rowObject){
		            	   return "<a href='javascript:viewSocialSubsidy("+rowObject.personId+")' style='color:#337ab7' >"+cellvalue+"</a>";
		               }},
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
	                   {name:'oldWorkCorp',label:'原工作单位',align:'center'},
	                   {name:'description',label:'备注',align:'center'},
	                   {name:'createrName',label:'经办人名称',align:'center'},
	                   {name:'createrDate',label:'经办日期',width:200,align:'center'},	                
	                   {name:'createrOrgName',label:'经办机构名称',align:'center'},
	                   {name:'id',label:'ds',align:'center',hidden:true}
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
//	      multiselect:true,
	      height:"100%",
	      altRow:true,
	      autowidth: true
	  });
	$("#batchList").jqGrid('setFrozenColumns');
	
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
				bankName : {
					validators : {
						notEmpty : {},
						stringLength : {
							max : 20
						}
					}
				},			
				batchId : {
					validators : {
						notEmpty : {}
					}
				},
				fillDate:{
					validators : {
						notEmpty : {},
						date: {
		                    format: 'YYYY-MM-DD',
		                    message: '请输入正确的时间格式'
		                }
					}
				},
				bankCardNo : {
					validators : {
						notEmpty : {},
						regexp: {
          					regexp :/^([+-]?)\d*\.?\d+$/,
                			message: '只能输入数字'
               		  },
						stringLength : {
							max : 20
						}
					}
				},
				bankOwnerName : {
					validators : {
						notEmpty : {},
						stringLength : {
							max : 20
						}
					}
				},
				description: {
					validators : {
						stringLength : {
							max : 50
						}
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
					callback:function(){
						bv.disableSubmitButtons(false);
						if(data.result===1){
							$("#mvcMethod").val("edit");
						}
					}
				})
			}, 'json');

		});
	}
	function closeItem() {

		xfui.closeDialog();
	}
	function submitForm() {
		$('#socialCorpDeclareForm').submit();
	}
	function  addItem(){
		$("#tabcontext").load(CTX+"/business/personagency/subsidy/socialCorpDeclare/edit.xf");
	}
//	function selPerBase(obj){
//		$("#perBase").show();
//		$("#perEdu").hide();
//		$(obj).parent().siblings().removeClass("active");
//		$(obj).parent().addClass("active");
//	}
//	var flag=true;
//	function selPerEdu(obj){
//		console.info($("#batchId").val());
//		var corpDeclareId=$("#id").val();
//		if(!corpDeclareId){
//			bootbox.alert("请选选择批次或者保存当前批次后操作");
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
	function delBatchPerson(){
		var pkId=$("#batchList").jqGrid("getGridParam","selrow");
		if(pkId){
			bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
			    if (r){  
			    	var batchId=$("#batchId").val();
			    	$.ajax({ url: CTX+'/business/personagency/subsidy/socialBatch/delBatchPerson.xf',
			    		data:{subsidyId:pkId,batchId:batchId},
			    		dataType:'json',
			    		success: function(data){
			    			
			    			if(data.result===1){
			    				refresh()	
			    			}else{
			    				bootbox.alert("未知错误"); 
			    			}
			    			
			             }
			    	});
			    }    
			}}); 
		  }else{
			 bootbox.alert('请选择记录');
		 }			
	} 
	function refresh(){
		
		$("#batchList").trigger("reloadGrid");
	}
	function addBatchPerson(){
		var batchId=$("#batchId").val();
		var corpDeclareId=$("#id").val();
		xfui.open_dialog({    
		    title: '新增批次人员',    
		    width: 800,    
		    height: 550,    
		    closed: false,    
		    cache: false,    
		    url: CTX+"/business/personagency/subsidy/socialBatch/addList.xf?corpDeclareId="+corpDeclareId+"&batchId="+batchId,
		    modal: true   
		})
       			
	}
	
	function viewSocialSubsidy(personId){
		xfui.open_dialog({    
		    title: '查看个人社保补贴',    
		    width: '95%',    
		    height: 550,    
		    closed: false,    
		    cache: false,    
		    url: CTX+"/business/personagency/subsidy/socialSubsidy/view.xf?personId="+ personId,
		    modal: true   
		})
       			
	} 
	
	function refreshBatchPerson(){
		$("#batchList").jqGrid("clearGridData");
		 $("#batchList").jqGrid("setGridParam",{url:CTX+'/business/personagency/subsidy/socialSubsidy/batchListJson.xf?batchId='+$("#batchId").val()}).trigger("reloadGrid");
	
		
	}
	