
	$(function(){
		
		$("#refresh").on("click",function(){
			refresh();
		})
		/**
		 初始化表格显示
		*/
		var columns= [	   
		                   {name:'archiveCode',label:'档案编号',align:'center'},
		                   {name:'aac003',label:'姓名',align:'center',formatter:function(cellvalue, options, rowObject){
		                	     return "<a href='javascript:editPaymentRecord("+rowObject.fkPersonId+","+rowObject.pkId+")' >"+cellvalue+"</a>";
		                      }
		                   },
		                   {name:'aac002',label:'身份证号',align:'center'},
		                   {name:'fdPaymentDate',label:'缴费日期',align:'center'},
		                   {name:'fdPaymentAmount',label:'缴费金额',align:'center'},	                                   
		                   {name:'fdPaymentStatus',label:'缴费状态',align:'center'},	                  
		                   {name:'fdCreaterName',label:'窗口经办人',align:'center'},  
		                   {name:'fkPersonId',label:'操作',hidden:true},
		                   {name:'pkId',label:'操作',hidden:true,key:true}
	      	        	];
		$("#paymentRecordList").jqGrid({
	           mtype: "GET",
			   url:CTX+'/business/personagency/payment/paymentReceive/listJson.xf?fitlerType=0',
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
	           autowidth: true,
	           height:320
	       });
		var concolumns= [	   
	                   {name:'archiveCode',label:'档案编号',align:'center'},
	                   {name:'aac003',label:'姓名',align:'center',formatter:function(cellvalue, options, rowObject){
	                	     return "<a href='javascript:viewPaymentRecord("+rowObject.fkPersonId+","+rowObject.pkId+")' >"+cellvalue+"</a>";
	                      }},
	                   {name:'aac002',label:'身份证号',align:'center'},
	                   {name:'fdPaymentAmount',label:'缴费金额',align:'center'},	                                   
	                   {name:'fdPaymentStatus',label:'缴费状态',align:'center'},	
	                   
	                   {name:'fdConfirmsDate',label:'经办日期',align:'center'}, 
	                   {name:'fdConfirmsName',label:'经办人',align:'center'}, 
	                   {name:'fdConfirmsOrgName',label:'经办机构',align:'center'}, 
	                   {name:'fkPersonId',label:'操作',hidden:true}
     	        	];
		$("#paymentRecordList1").jqGrid({
	           mtype: "GET",
			   url:CTX+'/business/personagency/payment/paymentReceive/listOverJson.xf',
			   styleUI : 'Bootstrap',
	           datatype: "json",
	           colModel: concolumns,
			   viewrecords: true,
	           rowNum: 10,
	           rowList:[10,20,30],
	           pager: "#jqGridPager1",
	           pagerpos:'left',
	           regional : 'cn',
	           recordpos:'right',
	           shrinkToFit: false,
	           multiselect:true,
	           autowidth: true,
	           height:'100%'
	       });
		
		$("#fitlerSel").on("change",function(){
            var fitlerType=$(this).val(); 
			$("#paymentRecordList").jqGrid("clearGridData");	
			$("#paymentRecordList").jqGrid("setGridParam",{url:CTX+'/business/personagency/payment/paymentReceive/listJson.xf?fitlerType='+fitlerType}).trigger("reloadGrid");

		})
		
	})
	
	function editPaymentRecord(personId,recordId){
		xfui.open_dialog({    
  		    title: '个人缴费',    
  		    width: 850,    
  		    height: 550,    
  		    closed: false,    
  		    cache: false,    
  		    url: CTX+"/business/personagency/payment/paymentReceive/edit.xf?personId="+personId+"&recordId="+recordId,
  		    modal: true   
  		})			
	} 
	function viewPaymentRecord(personId,recordId){
		xfui.open_dialog({    
  		    title: '查看缴费记录',    
  		    width: 850,    
  		    height: 550,    
  		    closed: false,    
  		    cache: false,    
  		    url: CTX+"/business/personagency/payment/paymentReceive/view.xf?personId="+personId+"&recordId="+recordId,
  		    modal: true   
  		})			
	} 
	
	function  refresh(){
		$('#paymentRecordList').trigger("reloadGrid");
		$('#paymentRecordList1').trigger("reloadGrid");
	}
