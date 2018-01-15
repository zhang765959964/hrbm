 $(function(){
		 var batchUpdate=$("#batchUpdate").val();

		//判断是不是批量更新 
		var batchUpdate=$("#batchUpdate").val();
		if(batchUpdate=="true"){
			$("#tabcontext").load(CTX+"/business/personagency/subsidy/socialCorpDeclare/batchUpdateEdit.xf");
		}else{
			$("#tabcontext").load(CTX+"/business/personagency/subsidy/socialCorpDeclare/edit.xf");
		}
	 })
	 
     function refresh(corpDeclareId){
		 var corpDeclareId=$("#id").val();
//		 $("#batchList").trigger("reloadGrid");
		 $("#tabcontext").load("${ctx}/business/personagency/subsidy/socialCorpDeclare/edit.xf?id="+corpDeclareId);
	 }