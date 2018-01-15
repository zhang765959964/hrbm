var dataJson = {};
$(function(){
	initl();
	xfui.initUi();
	initDataExp();
	
})
	/**
	 初始化表格显示
	*/
	function  initl(){
	
	var columns= [{name:'id',label:'操作',key: true,align:'center',width:80,frozen : true,	formatter:'actions',formatoptions:{
					keys: false,
					editbutton : true,
					delbutton : false
				  }},
				  {name:'AAC001',label:'人员id',hidden:true,frozen : true},
				  {name:'AAC003',label:'姓名',align:'center',frozen : true},
				  {name:'AAC002',label:'身份证号',align:'center',frozen : true},
            	  {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
            	  {name:'AAC006',label:'出生日期',align:'center'},
            	  {name:'AAC004',label:'性别',align:'center' },
            	  {name:'AAE005',label:'手机号',align:'center'},
            	  {name:'createWorkDate',label:'参加工作时间',editable : true,unformat:pickDate},
                  {name:'xh',label:'序号',align:'center',editable : true,frozen : true},
                  {name:'retiredPeopleBm',label:'退休个人编码',align:'center',editable : true},
            	  {name:'retiredPeopleNo',label:'个人编号',align:'center',editable : true},
                  {name:'nationName',label:'民族',align:'center'},
                  {name:'retiredStatus',label:'是否正式退休',align:'center'},
                 {name:'retiredDeclareStatus',label:'申报状态',align:'center'  },
                 {name:'isRetiredCard',label:'是否领退取证',align:'center'},
                 {name:'retiredArea',label:'退休人员所属区域',align:'center',editable : true},
                 {name:'expPersonPhone',label:'联系电话',align:'center',editable : true},
                 {name:'ylName',label:'符合离退休规定条款',align:'center'},
                 {name:'payDate',label:'缴费年月',align:'center',editable : true,unformat: pickDate},
                 {name:'retiredDate',label:'应退休时间',align:'center',editable : true,unformat: pickDate},
                 {name:'declareNote',label:'申报备注',align:'center',editable : true},
                 {name:'createrName',label:'经办人',align:'center'},
                 {name:'createrDate',label:'经办日期',align:'center'},
                 {name:'createrOrgName',label:'经办机构',align:'center'}
     	        	];
	$("#retiredList").jqGrid({
		   editurl:CTX+'/business/personagency/retired/declare/updateRetiredAll.xf',
          mtype: "GET",
		   styleUI : 'Bootstrap',
          datatype: "local",
          colModel: columns,
		   viewrecords: true,
          rowNum: 10,
          rowList:[10,20,30],
          pager: "#jqGridPager",
          pagerpos:'left',
          regional : 'cn',
          recordpos:'right',
          height:'100%',
          shrinkToFit: false,
          multiselect:true,
          autowidth: true,
          multiboxonly : true,
          multiselect : false,
		   onSelectRow :function(row,e){
		   		   	var rowData = $("#retiredList").jqGrid('getRowData',row);	
		   		   	var personId = rowData.AAC001;
					$("#personId").val(personId);
		   },
		   gridComplete:function(){
	         	  $(".ui-inline-edit").on("click",function(){
	         		  jQuery.fn.fmatter.rowactions.call(this,'edit');
	         	  })
	         	  $(".ui-inline-save").on("click",function(){
	         		  jQuery.fn.fmatter.rowactions.call(this,'save');
	         	  })
	         	  $(".ui-inline-cancel").on("click",function(){
	         		  jQuery.fn.fmatter.rowactions.call(this,'cancel');
	         	  })
	         	  
	        }
      });
	  $("#retiredList").jqGrid('setFrozenColumns');
	
	}




	function pickDate( cellvalue, options, cell ) {
		setTimeout(function(){
			$(cell) .find('input[type=text]')
					.xfdaterangepicker({singleDatePicker:true,
					autoUpdateInput:false,
					  "opens":"right",
					  "drops": "down",
			          "locale": {
			          "format": "YYYY-MM-DD"
			         }
			     });
		}, 0);
		 
	}
	

//删除退休人员信息
function delByPersonId(){
	var personId = $("#personId").val();
	if(personId>0){
			bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){
		    if (r){	
		    	$.ajax({ url: CTX+'/business/personagency/retired/declare/delByPersonId.xf',
		    		data:{personId:personId},
		    		dataType:'json',
		    		success: function(data){
		    			if(data.message){
		    				bootbox.alert(data.message);
		    			}else{
		    				bootbox.alert("未知错误");
		    			}
		    			refresh();
		             }
		    	});
		    }
		}});
	}else{
		bootbox.alert('请先选择记录！');
	}
}

function refresh(){
	$("#retiredList").trigger("reloadGrid");
}
function doSearch(){
	
	var json=$("#searchForm").serializeJson();
	dataJson = json;
	$("#retiredList").jqGrid("clearGridData");
	$("#retiredList").jqGrid("setGridParam",{datatype:'json',url:CTX+'/business/personagency/agent/retiredListJson.xf',postData:json}).trigger("reloadGrid");
}


//导出
function initDataExp(){
	$('#exp').dataexp({
		gridId:"retiredList",
		serviceId:'agrentExpServiceImpl',
		fileName:'退休人员信息',
		sheetName:'退休人员信息',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			 var id = $("#retiredList").jqGrid("getDataIDs");	   
			 dataJson.status = 'z1';
			 if(id&&id.length>0){
				 dataJson.id= "-1";
				 return dataJson;
			 }else{
				 bootbox.alert("无可导出的数据！");
    			 return false;
			 }
			 
           }},
          /* {title:"导出选中的数据",paramCallBack:function(){			        	   
        	  	var ids=$("#retiredBhList").jqGrid("getGridParam","selarrrow");
        		if(ids&&ids.length>0){
        			var id="";
        			$.each(ids,function(i,e){
        				if(i==0){
        					id+="'"+e+"'";
        				}else{
        					id+=","+"'"+e+"'";
        				}
        			});
        			 return {level:'6',id:id};
        		}else{
        			bootbox.alert("请勾选要选中的记录！");
        			return false;
        		}			        		
        		
					}
	        },*/
	        {title:"导出当前页数据",paramCallBack:function(){
	        	var ids = $("#retiredList").jqGrid("getDataIDs");	        		
	        	if(ids&&ids.length>0){
        			var id="";
        			$.each(ids,function(i,e){
        				if(i==0){
        					id+="'"+e+"'";
        				}else{
        					id+=","+"'"+e+"'";
        				}
        				
        			});
        			return {status:'z1',id:id};
        		}else{
        			bootbox.alert("请选择记录！");
        			return false;
        		}			        		
        	      
  				 }
		     }
          ]
		
	});
}








