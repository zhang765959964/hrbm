<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="corpForm" value="${requestScope[param.corpForm]}" />
<script type="text/javascript" src="${ctx}/js/ui/xf.selectcomcorp.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/ajaxfileupload/ajaxfileupload.js"></script>
<script type="text/javascript">
 $(function(){
	 $("#aab004").selectcomcorp({callBack:function(aab001){
		 if(aab001){
			 xfui.open_tabs("单位信息维护","${ctx}/business/corp/corp/edit.xf?cczy06=${param.cczy06n}&aab001="+aab001);
		 }else{
			 bootbox.alert("单位信息不存在");
		 }
		 
		}})
		 initFormSubimt();
			$("#cityInput").selcity({callBack:function(data){
				$("#cityInput").val(data.allname);
				$("#cityCode").val(data.code);
				if (data.allname!= "")
	             {
	                $('#corpForm')
	               .data('bootstrapValidator')
	               .updateStatus('aaa021','VALID', null)
	               .validateField('aaa021');
	    
	             }
				}
			});
			 xfui.initUi();		
	 })

     function initFormSubimt(){
         $('#corpForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   	//单位名称
		            aab004:{validators: {notEmpty: {message: '请填写单位名称'},stringLength: {min:0,max: 50,message:'单位名称最多50个汉字'}}},
            	   	//执照号码
		            aab007:{validators: {notEmpty: {message: '请填写工商执照号码'},stringLength: {min: 0,max: 50}}},
            	   	//法人公民身份号码
            	   	aab014: {validators: {
            	   		callback: {
        					message: '身份证号格式不正确',
        					callback:function(value, validator,$field){
        						if(!value){
        							return true;
        						}
        						return validateIdCard(value);
        					}
        			   }
            	   	}},
            	   	//单位性质
		            aab019:{validators: {notEmpty: {message: '请选择单位性质'}}},
		            //单位证件类型
		            aab006:{validators: {notEmpty: {message: '请选择单位证件类型'}}},
		        	//所在地区
		            aaa021:{validators: {notEmpty: {message: '请填写所在地区'},stringLength: {min: 0,max: 30,message: '最多输入30个汉字'}}},
		        	//行业代码
		            aab022:{validators: {notEmpty: {message: '请选择行业'}}},
		        	//主营范围
		            aab052:{validators: {notEmpty: {message: '请填写主营范围'},stringLength: {min: 0,max: 200,message:'最多能输入200个汉字'}}},
		            aab053:{validators: {stringLength: {min: 0,max: 200,message:'最多能输入200个汉字'}}},
		        	//注册资金
		            aab049:{validators: {notEmpty: {message: '请填写注册资金'},stringLength: {min: 0,max: 6,message:'最多能输入6个字符'}}},
		        	//单位简介
		            acb206:{validators: {notEmpty: {message: '请填写单位简介'},stringLength: {min: 0,max: 1500,message:'最多能输入1500个汉字'}}},
		        	//工商营业执照图片
		            caoa02:{validators: {notEmpty: {message: '请上传工商营业执照图片'} }},
		        	//法人身份证图片
		            caoa10:{validators: {notEmpty: {message: '请上传身份证正面图片'} }},
		        	//代办人姓名
		            aab113:{validators: {notEmpty: {message: '请填写代办人'},stringLength: {min: 0,max: 10,message:'最多能输入10个汉字'}}},
		        	//代办人电话
		            aab115:{validators: {notEmpty: {message: '请填写代办人电话'},stringLength: {min: 0,max: 20,message:'最多能输入20个字符或数字'}}},
		        	//联系地址
		            aab040:{validators: {notEmpty: {message: '请填写联系地址'},stringLength: {min: 0,max: 50,message:'最多能输入50个汉字'}}},
		        	//地址
		            aae006:{validators: {notEmpty: {message: '请填写注册地址'},stringLength: {min: 0,max: 50,message:'最多能输入50个汉字'}}},
		        	//法定代表人
		            aab013:{validators: {notEmpty: {message: '请填写法定代表人'},stringLength: {min: 0,max: 10,message:'字数在1至10个汉字之间'}}},
		        	//劳动保障联系人
		            aae004:{validators: {stringLength: {min: 0,max: 10,message:'字数在1至10个汉字之间'}}},
                    //联系电话
                    aae005: {validators: {
                    		notEmpty: {message: '请填写联系电话'},
                    		stringLength: { max: 15 },
    	               		regexp: {
    	        				regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
    	              			message: '电话号码或手机号码格式不正确'
    	               		}
                    }},
                    //代办人手机（短信）
                    aae139: {validators: {
                    			notEmpty: {message: '请填写代办人手机（短信）'},
                    			regexp: {
  	                              regexp: /^1[3|4|5|7|8]\d{9}$/,
  	                              message: '手机号格式不正确'
  	                            }
                     }},
	                 //代办人身份证    
	                 aab114: {validators: {
	                	 notEmpty: {
                      	   message: '身份证号不允许为空'
                         }, 
	                       callback: {
          					message: '身份证号格式不正确',
          					callback:function(value, validator,$field){
          						if(!value){
          							return true;
          						}
          						return validateIdCard(value);
          					}
          			   }
	                 }},
		        	//联系地址
		            aab040:{validators: {notEmpty: {message: '请填写联系地址'},stringLength: {min: 0,max: 50,message:'最多能输入50个汉字'}}},
                    //组织机构代码
                    aab003: {validators: {stringLength: {min: 0,max: 15,message: '最多填写15个字符'}}},
                    //备注
                    aae013: {validators: {stringLength: {min: 0,max: 50,message: '最多填写50个汉字'}}},
                    //乘车路线
                    acb205: {validators: {stringLength: {min: 0,max: 50,message: '最多填写50个汉字'}}},
                    //细类说明
                    aab026: {validators: {stringLength: {min: 0,max: 30,message: '最多填写30个汉字'}}},
                  	//传真
                    bab002: {validators: {stringLength: {min: 0,max: 30 ,message: '长度不能超过50个字符'}}},
                    //网址
                    aae016: {validators: {stringLength: {min: 0,max: 30 ,message: '长度不能超过50个字符'}}},
                    //电子信箱
                    aae015: {validators: {  emailAddress: {  message: '邮箱格式不对' },
                    	stringLength: { min: 0, max: 50, message: '邮箱账号长度不能超过50个字符' } }  },
                    //邮政编码
                    aae007: {validators: {  stringLength: {min: 6,max: 6,message: '邮编长度为6个数字' }  }},
	                //代表法人联系电话
                    aab015: {validators: {stringLength: {min: 11,max: 11,message: '请输入11电话号码' }}},
                    aab010:{validators: {
                    	notEmpty: {message: '请填写工商执照起始日期'},
                    	date: {
                            format: 'YYYY-MM-DD',
                            message: '请输入正确的时间格式'
                        },
          				callback: {
          					message: '起始日期不能大于终止日期',
          					callback:function(value, validator,$field,options){
      							var end = $("#aab011").val();
      							var begin = value;
          						var flag =  dateBetween(begin,end);
          						if(flag){
          							return false;
          						}else{
          							validator.updateStatus("aab011", "VALID");
          							return true;
          						}
          					}
          				}
                    }},
                    aab011:{validators: {
                    	notEmpty: {message: '请填写工商执照终止日期'},
                    	date: {
                            format: 'YYYY-MM-DD',
                            message: '请输入正确的时间格式'
                        },
          				callback: {
          					message: '终止日期不能小于起始日期',
          					callback:function(value, validator,$field){
          						var begin = $("#aab010").val();		//开始时间
          						var flag = dateBetween(begin,value);
          						if(flag){
          							return false;
          						}else{
          							validator.updateStatus("aab010", "VALID");
          							return true;
          						}
          					}
          				}
                    }}
		         }
		     }).on('success.form.bv', function(e) {
                    e.preventDefault();
                    var $form = $(e.target);
                    var bv = $form.data('bootstrapValidator');
//                     if (!checkAab003()) {
//         				return;
//         			}
                    $.post($form.attr('action'), $form.serialize(), function(data) {
                    	console.info(data);
                    	var arry = data.message;
                        var messages=arry.substring(0,11);
                        var aab001 = arry.substring(11);
                        bv.disableSubmitButtons(false);
                        bootbox.alert({ 
                            size: 'small',
                            width:"100px",
                            message: messages, 
                            callback: function(rowIndex, rowData){ 
                            	//window.location.href = "${ctx}/business/corp/corp/edit.xf?cczy06=${param.cczy06n}&aab001="+aab001;
                            }
                        })
                        
                    }, 'json');

                });
       }
 function refresh(){
	 window.location.href = "${ctx}/business/corp/corp/add.xf?cczy06=${param.cczy06n}";
 } 
 

</script>
<style type="text/css">
.mhyCorpSearchValue{display:none;}
.mhycorp:hover .mhyCorpSearchValue{display:block;}
.mapContent{display:none;}
.mapDiv{ bottom: 20px;height: 90%;left: 6%;position: fixed;top: 30px;width: 90%;z-index: 100;}
.mapDiv .alert-success{margin-bottom:0;padding-bottom:0px !important;}
.mapDivBg{background:rgba(0,0,0,0.8);position: fixed;top:0;left:0;right:0;bottom:0;z-index:10;}
.mapDiv .close{margin-right:20px;}}
</style>
<form:form modelAttribute="corpForm" method="post" action="${ctx}/business/corp/corp/save.xf">
			   		<form:hidden path="aab001" ></form:hidden>  
		   			<div class="mhySearchInput mhyInputDiv">
		   				<div class="row">
								<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>单位名称:</label>
								<div class="col-xs-9 col-sm-6 required">
									<form:input class="form-control" id="corpName" type="text" path="aab004"></form:input>
								</div>

									<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>工商登记执照号码:</label>
									<div class="col-xs-9 col-sm-2 required">
										<form:input class="form-control" type="text" path="aab007"></form:input>
									</div>

		   				</div>
		   					<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>单位性质:</label>
								<div class="col-xs-9 col-sm-2 required mhyNoSelect">
									<xf:select textField="name" tableName="TAB_UNITNATURE" name="aab019" value="${corpForm.aab019}"  valueField="code" hasDefault="0"></xf:select>
								</div>
							<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>工商执照起始日期:</label>
							<div class="col-xs-9 col-sm-2 " style="float:left" >
								<div class="input-group required" style="padding: 0 !important;">
									<form:input class="form-control date-picker dp mhydatepicker date" format="YYYY-MM-DD" autoUpdateInput="false" formValidatorId="corpForm" path="aab010" type="text" placeholder="请选择日期" />
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
								</div>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>工商执照终止日期:</label>
							<div class="col-xs-9 col-sm-2 " style="float:left" >
								<div class="input-group required" style="padding: 0 !important;">
									<form:input class="form-control date-picker dp mhydatepicker date" format="YYYY-MM-DD" autoUpdateInput="false" formValidatorId="corpForm" path="aab011" type="text" placeholder="请选择日期" />
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
		   					</div>
				   				<div class="row">
			   						<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>法定代表人:</label>
									<div class="col-xs-9 col-sm-2 required">
										<form:input class="form-control" type="text" path="aab013"></form:input>
									</div>		

										<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>联系电话:</label>
									<div class="col-xs-9 col-sm-2 required">
										<form:input class="form-control" type="text" path="aae005"></form:input>
									</div>	
									<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>行业代码:</label>
									<div class="col-xs-9 col-sm-2 required mhyNoSelect">
										<form:select class="combobox" path="aab022" style="width: 100%;">
										    <form:option value="" label="--请选择--"/>
											<c:forEach items="${industry}" var="stry">
											    <form:option value="${stry.code }" label="${stry.code }  ${stry.name }"/>
											</c:forEach>								
									    </form:select>
									</div>					
				   				</div>
							   			<div class="row">
							   				<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>所在地区:</label>
											<div class="col-xs-9 col-sm-2 required">
												<form:hidden id="cityCode" path="aab301" ></form:hidden>  
												<form:input class="form-control"  readonly="true" id="cityInput" path="aaa021"/>
											</div>
											<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>地址:</label>
											<div class="col-xs-9 col-sm-6 required">
												<form:input class="form-control" type="text" path="aae006"></form:input>
											</div>
						   				</div>
										<div class="row">
						   					<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>主营范围:</label>
						   					<div class="col-xs-9 col-sm-10 required">
												<form:textarea row="5" col="5" style="width:100%;resize:none;" path="aab052"></form:textarea>
											</div>
						   				</div>
						   				<div class="row">
						   					<label class="col-xs-3 col-sm-2" for="inputError">兼营范围:</label>
						   					<div class="col-xs-9 col-sm-10">
												<form:textarea row="5" col="5" style="width:100%;resize:none;" path="aab053"></form:textarea>
											</div>
						   				</div>
				   				<div class="row">
				   			
									<label class="col-xs-3 col-sm-2" for="inputError">组织机构代码:</label>
									<div class="col-xs-9 col-sm-2">
										<form:input class="form-control" type="text" path="aab003"></form:input>
									</div>

									<label class="col-xs-3 col-sm-2" for="inputError">行业细类:</label>
										<div class="col-xs-9 col-sm-2 mhyNoSelect">
											<xf:select textField="name" tableName="TAB_INDETIL" isNoStyle="false" name="aab025" value="${corpForm.aab025 }"  valueField="code" hasDefault="0"></xf:select>
										</div>
									<label class="col-xs-3 col-sm-2" for="inputError">细类说明:</label>
										<div class="col-xs-9 col-sm-2">
											<form:input class="form-control" type="text" path="aab026"></form:input>
										</div>		
								</div>
				   				<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError">经营方式:</label>
										<div class="col-xs-9 col-sm-2 mhyNoSelect">
											<xf:select textField="name" tableName="TAB_BUSMOD" isNoStyle="false" name="aab048" value="${corpForm.aab048 }"  valueField="code" hasDefault="0"></xf:select>
										</div>
									<label class="col-xs-3 col-sm-2" for="inputError">经济类型:</label>
										<div class="col-xs-9 col-sm-2 mhyNoSelect">
											<xf:select textField="name" tableName="TAB_ECONOMIC" name="aab020" value="${corpForm.aab020 }"  valueField="code" hasDefault="0"></xf:select>
										</div>
									<label class="col-xs-3 col-sm-2" for="inputError">产业类别:</label>
										<div class="col-xs-9 col-sm-2 mhyNoSelect">
											<xf:select textField="name" tableName="TAB_INDUSTRYCLASSES" name="aab054" value="${corpForm.aab054 }"  valueField="code" hasDefault="0"></xf:select>
										</div>	
								</div>
				   		  <div class="row">
				   		
				   				<label class="col-xs-3 col-sm-2" for="inputError">劳动保障联系人:</label>
									<div class="col-xs-9 col-sm-2">
										<form:input class="form-control" type="text" path="aae004"></form:input>
									</div>	
				   					<label class="col-xs-3 col-sm-2" for="inputError">法人公民身份号码:</label>
									<div class="col-xs-9 col-sm-2">
										<form:input class="form-control" type="text" path="aab014"></form:input>
									</div>
								<label class="col-xs-3 col-sm-2" for="inputError">传真:</label>
									<div class="col-xs-9 col-sm-2">
										<form:input class="form-control" type="text" path="bab002"></form:input>
									</div>	
				   					
						</div>
			   			<div class="row">
			   				<label class="col-xs-3 col-sm-2" for="inputError">网址:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="aae016"></form:input>
								</div>	
			   				<label class="col-xs-3 col-sm-2" for="inputError">电子信箱:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="aae015"></form:input>
								</div>	
			   				<label class="col-xs-3 col-sm-2" for="inputError">邮政编码:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="aae007"></form:input>
								</div>		
						</div>
						
							<div class="row">
				   				<label class="col-xs-3 col-sm-2" for="inputError">主管部门:</label>
									<div class="col-xs-9 col-sm-2 mhyNoSelect">
										<xf:select textField="name" tableName="TAB_DEPARTMENT" name="aab023" value="${corpForm.aab023 }"  valueField="code" hasDefault="0"></xf:select>
									</div>
								<label class="col-xs-3 col-sm-2" for="inputError">隶属关系:</label>
									<div class="col-xs-9 col-sm-2 mhyNoSelect">
										<xf:select textField="name" tableName="TAB_RELATIONSHIP" name="aab021" value="${corpForm.aab021 }"  valueField="code" hasDefault="0"></xf:select>
									</div>
								<label class="col-xs-3 col-sm-2" for="inputError">享受优惠政策单位类型:</label>
									<div class="col-xs-9 col-sm-2 mhyNoSelect"> 
										<xf:select textField="name" tableName="TAB_ENJOYPRI" name="acb101" value="${corpForm.acb101 }"  valueField="code" hasDefault="0"></xf:select>
									</div>	
							</div>
				   			<div class="row">
				   				<label class="col-xs-3 col-sm-2" for="inputError">单位状态:</label>
									<div class="col-xs-9 col-sm-2">
										
										<input class="form-control" type="text" readonly="true"  value="登记在册"></input>
									</div>		
								<label class="col-xs-3 col-sm-2" for="inputError">备注:</label>
									<div class="col-xs-9 col-sm-6">
										<form:input class="form-control" type="text" path="aae013"></form:input>
									</div>
				   			</div>
			   			
			   			<div class="row">
			   				<label class="col-xs-3 col-sm-2" for="inputError">从业人员总数:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="number" path="aab01e"></form:input>
								</div>	
			   				<label class="col-xs-3 col-sm-2" for="inputError">其中本市人员:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="number" path="aab01f"></form:input>
								</div>	
			   				<label class="col-xs-3 col-sm-2" for="inputError">其中外来人员:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="number" path="aab01g"></form:input>
								</div>		
						</div>
						
		   			   <div class="row">
			   				<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="aae036" readonly="true"  data-date-format="dd-mm-yyyy"></form:input>
								</div>	
			   				<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
								<div class="col-xs-9 col-sm-2">
									<form:hidden path="aae017" ></form:hidden>
									<form:input class="form-control" type="text" path="aae020"  readonly="true" data-options="required:false"></form:input>
								</div>	
			   				<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
								<div class="col-xs-9 col-sm-2">
									<form:hidden path="aae011" ></form:hidden>
									<form:input class="form-control" type="text"  path="aae019"  readonly="true" data-options="required:false;readonly:true"></form:input>
								</div>		
						</div>
					
	   				<div class="bottomBtn">
   					<div class="h50">&nbsp;</div>
   					<div class="floatBtn">
   							<button class="btn btn-primary"  type="submit">
		   					<i class="icon-save"></i>
		   					保存	
		   					</button>
		   					<a class="btn btn-info" role="button" onclick="refresh()">
		   					<i class="icon-plus"></i>
		   					新增
		   					</a>
		   					</div>
		   				</div>
		   		</div>		   		
		   	</form:form>


