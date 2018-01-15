	$(function() {
		initTable();
		initFormSubimt();
	});
	function initTable() {
		var columns= [
	                   {name:'AAC002',label:'身份证号',align:'center',frozen : true},
	                   {name:'AAC003',label:'姓名',align:'center',frozen : true},
	                   {name:'GENDERNAME',label:'性别',align:'center',frozen : true},
	                   {name:'ARCHIVECODE',label:'档案编号',align:'center'},
	                   {name:'RECEIVEDATE',label:'档案接收日期',align:'center'},
	                   {name:'MARKETPOSITIONNAME',label:'市场位置',align:'center'},
	                   {name:'CABINETSLIBRARY',label:'区',align:'center'},
	                   {name:'CABINETSCODE',label:'柜',align:'center'},
	                   {name:'CABINETSLAYER',label:'排',align:'center'},
	                   {name:'CABINETSLATTICE',label:'列',align:'center'},
	                   {name:'EXPENTRUSTCOMPANY',label:'所属单位名称',align:'center'},
	                   {name:'ARCHIVENAME',label:'档案姓名',align:'center'},
	                   {name:'ARCHIVEBIRTHDATE',label:'档案出生日期',align:'center'},
	                   {name:'ARCHIVESTATUSNAME',label:'档案状态',align:'center'},
	                   {name:'ARCHIVETYPENAME',label:'存档类型',align:'center'},
	                   {name:'ARCHIVERECEIVENAME',label:'窗口经办人',align:'center'},
	                   {name:'ARCHIVERECEIVEDATE',label:'窗口经办日期',align:'center'},
	                   {name:'ARCHIVERECEIVEORGNAME',label:'窗口经办机构',align:'center'},
	                   {name:'ID',label:'',hidden:true,key:true}

      	        	];

		$("#archivesList").jqGrid({
			//url:CTX+'/business/personagency/batch/archiveCheckout/searchListJson.xf',
	        mtype: "GET",
			styleUI : 'Bootstrap',
	        datatype: "local",
	        colModel: columns,
			viewrecords: true,
	        /*rowNum: 10,
	        rowList:[10,20,30],
	        pager: "#jqGridPager",
	        pagerpos:'left',*/
	        regional : 'cn',
	        recordpos:'right',
	        shrinkToFit: false,
	        multiselect:true,
	        autowidth: true,
	        altRows:true,
	        height:'100%'
	    });
		$("#archivesList").jqGrid('setFrozenColumns');
	}
	
	function addSearch(){
		var archiveCode = $("#archiveCode").val();
		var aac002 = $("#aac002").val();
		//var archiveFlowStatusValue = '4,9';
		if(archiveCode==''&&aac002==''){
			bootbox.alert("请填写查询条件！");
		}else{
			$.ajax({
				type: "post",
				url:CTX+'/business/personagency/batch/archiveCheckout/searchListJson.xf',
				data:{taac002:aac002,tarchiveCode:archiveCode},
				cache:false,  
				success :function (data){
					if(data.length>0){
						$.each(data,function(i,e){
							if(e.ARCHIVESTATUS==2){
								 bootbox.alert("当前档案已经调出！不能操作！");
							}else{
								 if(e.ARCHIVERECEIVESTATUS==1){
									 //没有考虑档案死亡状态
									 bootbox.alert("当前档案在档，但是没有入库！不能借阅登记！");
								 }else{
									 if(e.ARCHIVEFLOWSTATUS==1){
										 bootbox.alert("当前档案正在借阅登记！不能重复借阅登记！");
									 }else if(e.ARCHIVEFLOWSTATUS==2){
										 bootbox.alert("当前档案正在借阅确认中！不能借阅登记！");
									 }else if(e.ARCHIVEFLOWSTATUS==3){
										 bootbox.alert("当前档案正在返还登记中！不能借阅登记！");
									 }else if(e.ARCHIVEFLOWSTATUS==5){
										 bootbox.alert("当前档案正在调出登记中！不能借阅登记！");
									 }else{
										var flag =  verifyExist("archivesList","ID",e.ID);
										if(flag){
											bootbox.alert("表格中已经存在！");
										}else{
											 var arr = $("#archivesList").jqGrid("getRowData");
											 $("#archivesList").jqGrid("addRowData",e.ID,e, "first");  
											 var arrs =  $("#archivesList").jqGrid("getRowData");
										}
									 }
								 }
							}
						})
					}else{
						bootbox.alert("没有查询到记录！");
					}
				}
			})
		}
	}
	
function clearJqGrid(){
	bootbox.confirm({message:'是否清空列表？',callback:function(r){
	    if(r){
	    	$("#archivesList").jqGrid("clearGridData");
	    }
	}});
}

function subtractSearch(){
	var ids=$("#archivesList").jqGrid("getGridParam","selarrrow");
	var str = new Array();
	if(ids&&ids.length>0){
		$.each(ids,function(i,e){
			str.push(e)
		});
		for(var i=0;i<str.length;i++){
			$("#archivesList").jqGrid("delRowData",str[i]);
		}
	  }else{
		 bootbox.alert('请选择记录');
	 }	
}
//档案批量借阅登记
function resgisterOneDiv(){
	 $("#resgisterOne").load(CTX+"/business/personagency/batch/archiveCheckout/resgisterOne.xf");
}
//档案批量归还登记
function resgisterTwoDiv(){
	 $("#resgisterTwo").load(CTX+"/business/personagency/batch/archiveCheckout/resgisterTwo.xf");
}

//单位档案批量借阅登记
/*function addBatchArchivesCheckOut1(){
	var bootstrapValidator = $("#archiveCheckoutForm").data('bootstrapValidator');  
	var ids=$("#archivesList").jqGrid("getGridParam","selarrrow");
	if(ids&&ids.length>0){
		var id="";
		$.each(ids,function(i,e){
			if(i==0){
				id+=e;
			}else{
				id+=","+e;
			}
		});
		$("#archiveIds").val(id);
		bootstrapValidator.setAllowSubmit(true);
	  }else{
		 bootbox.alert('请选择记录');
		 return false;
		 bootstrapValidator.disableSubmitButtons(false);
	 }	
}*/
//单位批量登记保存
function initFormSubimt(){
  $('#archiveCheckoutForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	//借阅类别
        	checkoutType : {
                validators: {
                    notEmpty: {
                 	   message: '借阅类别不允许为空'
                    }
                }
            },
      	   //借阅人
            checkoutPerson: {
                 validators: { stringLength: {min: 0,max: 16 } }
        	  },
        	  //借阅人电话
           checkoutPersonPhone:{
          	validators: {
          		 stringLength: { max: 15 },
            		regexp: {
        					regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
              			message: '电话号码或手机号码格式不正确'
            		}
        	  }
           },
           //借阅单位
           checkoutCorp: {
                validators: { stringLength: {min: 0,max: 32 } }
       	  },
          //生成批次名
          batchName :{
           	validators: {
           			notEmpty: {
           				message: '生成批次名不允许为空'
                    },remote: {
                        type: 'POST',
                        url: CTX+'/business/personagency/batch/archiveCheckout/checkedBatchName.xf',
                        message: '已有此批次名',
                        delay: 1000
                    },
       	  			stringLength: {min: 0,max: 16 }
           		}
          },
          //借阅期限日期
          checkoutPeriodDate: {
                validators: { 
                    date: {
                        format: 'YYYY-MM-DD',
                        message: '请输入正确的时间格式'
                    }
       	  	   }
       	  }
        }
         }).on('success.form.bv', function(e) {
             e.preventDefault();
             var $form = $(e.target);
             var bv = $form.data('bootstrapValidator');
             bv.disableSubmitButtons(true);
             
            /* $.post($form.attr('action'), $form.serialize(), function(data) {
             	console.info(data);
                 bootbox.alert({
                     size: 'small',
                     width:"100px",
                     message: data.message,
                     callback: function(){
                    	 bv.disableSubmitButtons(false);
                    	 refreshR(data.result);
                     }
                 })
             }, 'json');*/
             
             var ids=$("#archivesList").jqGrid("getGridParam","selarrrow");
             if(ids&&ids.length>0){
      			  var id="";
      			  $.each(ids,function(i,e){
      					if(i==0){
      						id+=e;
      					}else{
      						id+=","+e;
      					}
      				});
      			$("#archiveIds").val(id);
      			$.post($form.attr('action'), $form.serialize(), function(data) {
                 	console.info(data);
                     bootbox.alert({
                         size: 'small',
                         width:"100px",
                         message: data.message,
                         callback: function(){
                        	 bv.disableSubmitButtons(false);
                        	 refreshR(data.result);
                         }
                     })
                 }, 'json');
              }else{
            	  bootbox.alert('请选择记录');	
            	  bv.disableSubmitButtons(false);
              }
             
         });
}

function refreshR(value){
	if(value){
		var str  = $("#archiveIds").val();
		str =  str.split(",");
		for(var i=0;i<str.length;i++){
			$("#archivesList").jqGrid("delRowData",str[i]);
		}
	}
}