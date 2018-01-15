<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>个人账号信息维护</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<%@include file="/commons/include/bootstrapInc.jsp" %>
<link rel="stylesheet" href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css" >
<link rel="stylesheet" href="${ctx}/js/lib/bootstrap-select/bootstrap-select.css"/>
<script src="${ctx}/js/lib/bootstrap-select/bootstrap-select.js"></script>
<script>
function hideRows(obj){
	var rows = $("form").find(".row");
	var cl = $("#view_class").attr('class');
	$("#view_class").attr('class',cl=='icon-plus'?'icon-minus':'icon-plus');
	rows.each(function(index){
		 if(index>obj&&index<rows.length-1){
			 $(this).toggle("slow");
		 }
	});
}
$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [
                   {name:'CCMU01',label:'',align:'center',hidden:true},
                   {name:'AAC001',label:'',align:'center',hidden:true},
                   {name:'CCZY06',label:'',align:'center',hidden:true},
                   {name:'CCMU02',label:'账号',align:'center'},
                   {name:'CCMU03',label:'密码',align:'center'},
                   {name:'CCMU10',label:'账号状态',align:'center'},
                   {name:'AAC002',label:'公民身份证号码',align:'center'},
                   {name:'AAC003',label:'姓名',align:'center'},
                   {name:'AAC004',label:'性别',align:'center'},
                   {name:'CCMU22',label:'数据来源',align:'center'},
                   {name:'AAC005',label:'民族',align:'center'},
                   {name:'AAC006',label:'出生日期',align:'center'},
                   {name:'AAC009',label:'户口性质',align:'center'},
                   {name:'AAB305',label:'户口所在地',align:'center'},
                   {name:'AAC011',label:'文化程度',align:'center'},
                   {name:'AAE005',label:'联系电话',align:'center'},
                   {name:'AAC017',label:'婚姻状况',align:'center'},
                   {name:'AAC024',label:'政治面貌',align:'center'},
                   {name:'AAB301',label:'居住所在地',align:'center'},
                   {name:'AAC00B',label:'楼院',align:'center'},
                   {name:'AAC00C',label:'单元',align:'center'},
                   {name:'AAC00D',label:'门牌号',align:'center'},
                   {name:'AAC025',label:'祖籍',align:'center'},
                   {name:'AAC036',label:'视力',align:'center'},
                   {name:'AAC035',label:'体重',align:'center'},
                   {name:'AAC034',label:'身高',align:'center'},
                   {name:'AAC032',label:'血型',align:'center'},
                   {name:'AAC033',label:'健康状况',align:'center'},
                   {name:'AAC022',label:'姓名拼音码',align:'center'},
                   {name:'AAC023',label:'个人英文名称',align:'center'},
                   {name:'AAE007',label:'邮编',align:'center'},
                   {name:'AAE015',label:'电子信箱',align:'center'},
                   {name:'AAC180',label:'毕业学校',align:'center'},
                   {name:'AAC181',label:'毕业时间',align:'center'},
                   {name:'AAC00E',label:'目前住房情况',align:'center'},
                   {name:'AAC00A',label:'军人证号',align:'center'},
                   {name:'AAE013',label:'备注',align:'center'},
                   {name:'AAE020',label:'经办机构',align:'center'},
                   {name:'AAE019',label:'经办人',align:'center'},
                   {name:'AAE036',label:'经办日期',align:'center'}
  	        	];
	$("#accountsList").jqGrid({
		   url:'${ctx}/sys/accounts/accounts/listJson.xf',
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
           altRows:true,
           shrinkToFit: false,
           multiselect:false,
           onSelectRow:function(cellvalue){
        	   var rowDatas = $("#accountsList").jqGrid('getRowData', cellvalue);
        	   		$("#ccmu01").val(rowDatas.CCMU01);
        	   		$("#account").val(rowDatas.CCMU02);
        	   		$("#pword").val(rowDatas.CCMU03);
        	 },
           ondblClickRow:function(cellvalue){
        	   var rowDatas = $("#accountsList").jqGrid('getRowData', cellvalue);
        	   var cczy06 = rowDatas.CCZY06;
        	   var aac001 = rowDatas.AAC001;
        	    xfui.open_dialog({
	   	  		    title: '查看个人基本信息',
	   	  		    width: 900,
	   	  		    height: 500,
	   	  		    closed: false,
	   	  		    cache: false,
	   	  		    url: "${ctx}/business/person/personBaseInfo/selctPerson.xf?cczy06="+cczy06+"&aac001="+aac001,
	   	  		    modal: true
   	  			})
        	},
           autowidth: true
       });
	$("#cityInput").selcity({callBack:function(data){
		$("#cityInput").val(data.allname);
		$("#cityId").val(data.code);
		}
	});

})
function submitForm(){
	var ccmu01=$("#ccmu01").val();
	if(ccmu01==null){
		bootbox.alert('请选择记录');
	}else{
		$.ajax({
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			url : '${ctx}/sys/accounts/accounts/isExist.xf',
			data : {
				'ccmu01':ccmu01,
				'ccmu03':$("#pword").val()
			},
			async : false,
			type: "post",
			dataType : 'json',
			success : function(data) {
				  bootbox.alert({
                      size: 'small',
                      width:"100px",
                      message: data.message,
                      callback: function(){
							window.location.href = "${ctx}/sys/accounts/accounts/list.xf";
                      }
                  });
			},error : function(data) {
				bootbox.alert({
                    size: 'small',
                    width:"100px",
                    message: data.message
                });
			}
		});
	}
	}
function refresh(){
	$("#accountsList").trigger("reloadGrid");
}
function doSearch(){
	//多选框数据设置到隐藏域中
	$('.selectpicker').each(function() {
		var inputId = $(this).attr('id').replace('_select', '');
		$('#' + inputId).val(getSelectValues($(this).attr('id')));
	});
	var json=$("#searchForm").serializeJson();
	$("#accountsList").jqGrid("setGridParam",{postData:json}).trigger("reloadGrid");
}
function getSelectValues(objId) {
	var selectValueStr = '';
	$("#" + objId + " option:selected")
			.each(
					function() {
						selectValueStr = selectValueStr ? (selectValueStr
								+ "," + $(this).val()) : $(this).val();
					});
	return selectValueStr;
}
</script>
</head>
<body>
	<div class="container-fluid">
	    <div class="moduleWrapNobg">
			<div class="moduleTit">查询条件</div>
			<div class="moduleCont">
				<form id="searchForm" class="mhySearchInput">
					<div class="row">
							<div class="col-xs-12 col-sm-4" >
								<label class="col-xs-2 col-sm-4" for="inputError">身份证号:</label>
								<div class="col-xs-10 col-sm-8">
									<input class="form-control" type="text" id="aac002" name="Q_aac002_SUPL" data-placement="bottom" />
								</div>
							</div>
							<div class="col-xs-12 col-sm-4" >
								<label class="col-xs-2 col-sm-4" for="inputError">姓名:</label>
								<div class="col-xs-10 col-sm-8">
									<input class="form-control" type="text" id="aac003" name="Q_aac003_SL" data-placement="bottom" />
								</div>
							</div>
							<div class="col-xs-12 col-sm-4" >
								<label class="col-xs-2 col-sm-4" for="inputError">性别:</label>
								<div class="col-xs-10 col-sm-8  mhyNoSelect">
									<xf:select textField="name" tableName="TAB_SEX" hasDefault="0" id="aac004" name="aac004n" valueField="code"></xf:select>
								</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-4" >
								<label class="col-xs-2 col-sm-4" for="inputError">户口性质:</label>
								<div class="col-xs-10 col-sm-8  mhyNoSelect">
									<xf:select textField="name" tableName="TAB_CATEGORY" hasDefault="0" id="aac009" name="aac009n" valueField="code"></xf:select>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4" >
								<label class="col-xs-2 col-sm-4" for="inputError">户口所在地:</label>
								<div class="col-xs-10 col-sm-8">
									<input class="form-control" type="text" id="cityInput" name="Q_bab305_SL" data-placement="bottom" />
								</div>
							</div>
							<div class="col-xs-12 col-sm-4" >
								<label class="col-xs-2 col-sm-4" for="inputError">文化程度:</label>
								<div class="col-xs-10 col-sm-8 mhyNoSelect">
									<xf:select textField="name" tableName="TAB_EDUCATION" id="aac011" name="aac011n"  valueField="code" hasDefault="0"></xf:select>
								</div>
							</div>
					</div>
					<div class="row">
	                        <div class="col-xs-12 col-sm-4" style="height:32px;">
								<label class="col-xs-2 col-sm-4" for="inputError">出生日期:</label>
								<div class="col-xs-10 input-group col-sm-8"  style="padding-left:15px">
	                              <input class="form-control date-picker datepicker01" id="beginaac006" name="beginaac006" type="text"  placeholder="请选择出生日期"/>
	                              <span class="input-group-addon">
	                                  <i class="icon-calendar bigger-110"></i>
	                              </span>
	                           </div>
							</div>
							<div class="col-xs-12 col-sm-4" style="height:32px;z-index:0;">
							<label class="col-xs-2 col-sm-4" for="inputError">至</label>
								<div class="col-xs-10 input-group col-sm-8"  style="padding-left:15px;z-index:0;">
	                              <input class="form-control date-picker datepicker01" id="endaac006" name="endaac006" type="text"  placeholder="请选择出生日期"/>
	                              <span class="input-group-addon">
	                                  <i class="icon-calendar bigger-110"></i>
	                              </span>
	                           </div>
							</div>
							<div class="col-xs-12 col-sm-4">
							<label class="col-xs-2 col-sm-4" for="inputError">经办人:</label>
								<input type="hidden" name="aae011" id="aae011" />
								<div class="col-xs-10 col-sm-8 mhyOrgId" id="selectDxdiv">
									<select id="aae011_select" class="selectpicker form-control"
										data-live-search="true" data-live-search-placeholder="Search"
										data-actions-box="true">
										<optgroup>
											<option value="">全部</option>
											<c:forEach items="${userList}" var="user">
													<option value="${user.acd230}">${user.aac003} </option>
											</c:forEach>
										</optgroup>
									</select>
								</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-4">
							<label class="col-xs-2 col-sm-4" for="inputError">经办机构:</label>
								<input type="hidden" name="aae017" id="aae017" />
								<div class="col-xs-10 col-sm-8 mhyOrgId" id="selectDxdiv">
									<select id="aae017_select" class="selectpicker form-control"
										data-live-search="true" data-live-search-placeholder="Search"
										data-actions-box="true">
										<optgroup>
											<option value="">全部</option>
											<c:forEach items="${orgs}" begin="0" var="objOrg">
												<option value="${objOrg.acd200}">${objOrg.acd202}</option>
											</c:forEach>
										</optgroup>
									</select>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4" style="height:32px;z-index:0;">
								<label class="col-xs-2 col-sm-4" for="inputError">经办日期:</label>
								<div class="col-xs-10 input-group col-sm-8"  style="padding-left:15px;z-index:0;">
	                              <input class="form-control date-picker datepicker01" id="beginaae036" name="beginaae036" type="text"  placeholder="请选择出生日期"/>
	                              <span class="input-group-addon">
	                                  <i class="icon-calendar bigger-110"></i>
	                              </span>
	                           </div>
							</div>
							<div class="col-xs-12 col-sm-4" style="height:32px;z-index:0;">
							<label class="col-xs-2 col-sm-4" for="inputError">至</label>
								<div class="col-xs-10 input-group col-sm-8"  style="padding-left:15px;z-index:0;">
	                              <input class="form-control date-picker datepicker01" id="endaae036" name="endaae036" type="text"  placeholder="请选择出生日期"/>
	                              <span class="input-group-addon">
	                                  <i class="icon-calendar bigger-110"></i>
	                              </span>
	                           </div>
							</div>
						</div>
					<div class="row">
						<div class="col-xs-12 col-sm-4" >
								<label class="col-xs-2 col-sm-4" for="inputError">账号:</label>
								<div class="col-xs-10 col-sm-8">
									<input class="form-control" type="text" id="ccmu02" name="Q_ccmu02_SL" data-placement="bottom" />
								</div>
							</div>
							<div class="col-xs-12 col-sm-4" >
								<label class="col-xs-2 col-sm-4" for="inputError">信息来源:</label>
								<div class="col-xs-10 col-sm-8">
									<xf:select textField="name" tableName="TAB_DATASOURCES" hasDefault="0" id="ccmu22" name="ccmu22" valueField="code"></xf:select>
								</div>
							</div>
					</div>
					<div class="row">
						<div class="col-sm-12 mgb20 tar pdx20">
							<a href="#" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
							<a class="btn btn-info resetBtn" role="button"  href="#modal-form"><i class="icon-repeat"></i>重置</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="moduleWrapNobg">
			<div class="moduleTit">账号信息维护</div>
			<div class="moduleCont">
				<div class="row" style="margin-top: 10px;margin-bottom: 10px !important;">
					<div class="col-xs-12 col-sm-4" >
						<label class="col-xs-2 col-sm-4" for="inputError">账号:</label>
						<div class="col-xs-10 col-sm-8">
							<input type="hidden" id="ccmu01" name="ccmu01"/>
							<input class="form-control" type="text" id="account" name="ccmu02" readonly="readonly" />
						</div>
					</div>
					<div class="col-xs-12 col-sm-4" >
						<label class="col-xs-2 col-sm-4" for="inputError">密码:</label>
						<div class="col-xs-10 col-sm-8">
							<input class="form-control" type="text" id="pword" name="ccmu03" />
						</div>
					</div>
					<div class="col-xs-12 col-sm-4" >
						<a href="javascript:void(0)" role="button" class="btn btn-primary"  onclick="submitForm()">保存</a>
					</div>
				</div>
			</div>
		</div>
		<div class="moduleWrap">
			<div class="moduleTit">查询结果</div>
			<div class="moduleCont">
				<table id="accountsList"  class="datagridClass"  ></table>
				<div id="jqGridPager"></div>
			</div>
		</div>
</body>
<script type="text/javascript">
	jQuery(function($) {
			// 日期选择
	  $(".datepicker01").datetimepicker({
	      todayBtn: true,
	      format: "yyyy-mm-dd",
	      startView: 2,
	      minView: 2,
	      language: 'cn',
	      maxView: "decade",
	      viewSelect: 2,
	      autocomplete:true,
	      autoclose:true
	  });
	  $('.selectpicker').selectpicker({
			selectAllText : '全选',//全选的checkbox名称
			deselectAllText : '取消',
			selectAllNumber : true,
			actionsBox : false,
			noneResultsText : "没有相关信息",liveSearchPlaceholder:"请输入搜索.."
		});
	  $(".resetBtn").click(function(){
			$("#searchForm")[0].reset();
			$('.selectpicker').selectpicker('val', '');
			$('.form-control').each(function() {
				if (!$(this).hasClass("selectpicker")) {
					$(this).val('');
				}
			});
			});
	});

</script>
</html>


