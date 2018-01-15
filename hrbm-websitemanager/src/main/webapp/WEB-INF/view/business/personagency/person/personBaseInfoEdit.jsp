<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript">
	$("#resetPerson").on("click",function(e){
		$("#personBaseEdit").xfload("${ctx}/business/personagency/person/personBaseInfo/add.xf");
	});	
</script>
<div class="tabable tabable1 row">
	<ul class="nav nav-tabs padding-12 tab-color-blue background-blue">
		<li class="active"><a data-toggle="tab" href="#perBase">个人基本信息</a></li>
		<li><a data-toggle="tab" href="#perEdu">教育背景</a></li>
		<li><a data-toggle="tab" href="#perExp">工作简历</a></li>
	</ul>
	<div class="tab-content">
	    <div id="perBase" class="tab-pane in active">
		    <form:form class="mhyform" modelAttribute="personBaseInfoForm" method="post" action="${ctx}/business/personagency/person/personBaseInfo/save.xf">
				<form:hidden path="mvcMethod" ></form:hidden>	
				<div class="moduleWrapNobg">
					<div class="moduleTit">个人基本信息维护</div>
				    <div class="moduleCont">
			   			<c:import url="/WEB-INF/view/business/person/include/personBaseInfoEdit_include.jsp">
							<c:param name="formName" value="personBaseInfoForm"/>
						</c:import>							   	
					</div>
				</div>
				<div class="moduleWrapNobg">
					<div class="moduleTit">家庭情况</div>
					<div class="moduleCont">
					   <c:import url="/WEB-INF/view/business/person/include/personFamilyEdit_include.jsp">
						   <c:param name="formName" value="personBaseInfoForm"/>
					   </c:import>								      
					</div>
				</div>
				<div class="bottomBtn">
			   		<div class="h50">&nbsp;</div>
		   			<div class="floatBtn">
				   		<button class="btn btn-primary mhyBtn"  type="submit"><i class="icon-save"></i>保存</button>
				   		<a href="javascript:void(0)" class="btn btn-info mhyBtnLeft" id="resetPerson" role="button"><i class="icon-repeat"></i>重置</a>
						<a href="javascript:xfui.closeDialog()" role="button" class="btn btn-info"><i class="icon-remove"></i>关闭</a>							   					
				   </div>
				</div>							  
		   </form:form>
		</div>
		<div id="perEdu" class="tab-pane in active">
			<c:import url="/WEB-INF/view/business/person/include/personEducation_include.jsp">
					<c:param name="cczy06" value="${personBaseInfoForm.cczy06}"/>
					<c:param name="aac001" value="${personBaseInfoForm.aac001}"/>				
			</c:import>	
		</div>
		<div id="perExp" class="tab-pane in active">
			<c:import url="/WEB-INF/view/business/person/include/personWorkExpceList_include.jsp">
				<c:param name="cczy06" value="${personBaseInfoForm.cczy06}"/>
				<c:param name="aac001" value="${personBaseInfoForm.aac001}"/>
			</c:import>	
		</div>
   </div>
</div>	
<div class="h50">&nbsp;</div>
<script type="text/javascript">
  jQuery(function($) {
	  $('a[data-toggle="tab"]').on('show.bs.tab', function (e) {
		  var mvcMethod=$("#mvcMethod").val();
		  if(mvcMethod=="add"){
			  bootbox.alert("请先保存人员基本信息");
			  return false;
		  }
		  
		})
		xfui.initUi();
    });
	 $(function(){
		 initFormSubimt();
		 $("#cityInput").selcity({callBack:function(data){
				$("#cityInput").val(data.allname);
				$("#cityLive").val(data.allname);
				if (data.allname!= "")
	             {
	                $('#personBaseInfoForm')
	               .data('bootstrapValidator')
	               .updateStatus('bab305','VALID', null)
	               .validateField('bab305');
	    
	             }
				}
			});

	 });

  function initFormSubimt(){
      $('#personBaseInfoForm').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
         	   //姓名
                aac003: {
                     validators: {
                         notEmpty: {	message:'请填写姓名' },
                         stringLength: {min: 1,max: 10, message:'字数在1到10个汉字之间' } } 
            		},
                //身份证号
                aac002: {
             	   validators: {
		            		notEmpty: {message: '请填写身份证号码'},
		            		callback: {
            					message: '身份证号格式不正确',
            					callback:function(value, validator,$field){
            						if(!value){
            							return true;
            						}
            						return validateIdCard(value);
            					}
            			   },
		                   remote: {
	                             type: 'POST',
	                             url: '${ctx}/business/person/personBaseInfo/isPersonExist.xf?noaac001='+$("#aac001").val(),
	                             message: '人身份证号已存在',
	                             delay: 1000
	                      }
		           }
            	},
                //就业失业登记证号码
                acc0m1: {
                    validators: {
                    	   stringLength: {min: 1,max: 20, message:'长度在1-20位之间' }, 
		                   regexp: {
		                       regexp: /^[a-zA-Z0-9]+$/,
		                       message: '只能包含字母和数字'
		                   }
            		} 
            	},
                //军人证号
                aac00a: {
                    validators: {
                        stringLength: { min: 0, max: 18 }  } },
                //性别
                aac004: {
                     validators: { notEmpty: {message: '请选择性别' } } 
                },
                //手机号
                aae005: {
                     validators: { 
                     	notEmpty: {
                     		message: '请填写手机联系电话' 
                     	},
                  		regexp: {
                            regexp: /^1[3|4|5|7|8]\d{9}$/,
                            message: '手机号格式不正确'
                        }
                     } 
                },
               //身份证地址
                expCardNumber : {
                    validators: {
                		   stringLength: {min: 1,max: 50, message:'长度在1-50位之间' } 
                    }
                },
                //参加工作时间
                expStartJobDate: {
                     validators: {  
	                     date: {
	                         format: 'YYYY-MM-DD',
	                         message: '请输入正确的时间格式'
	                     }
                     } 
                },
                //联系电话
                expPersonPhone : {
                    validators: {
                    	stringLength: { max: 15 },
	               		regexp: {
	        				regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
	              			message: '电话号码或手机号码格式不正确'
	               		}
                    }
                },
                //出生日期
                aac006: {
                     validators: {  notEmpty: { message: '请填写出生日期' },
	                     date: {
	                         format: 'YYYY-MM-DD',
	                         message: '请输入正确的时间格式'
	                     }
                     } 
                },
                //民族
                aac005: {
                     validators: {  notEmpty: { message: '请选择民族' } } 
                },
                //个人状态
                expPersonStatus: {
                     validators: {  notEmpty: { message: '请选择个人状态' } } 
                },
                //配偶单位
                faSpouseCompany: {
                     validators: {  stringLength: { min: 0, max: 50,message:'最多输入50个汉字'  } } 
                },
                //配偶身份证号
                faSpouseCard: {
             	   validators: {
             		  callback: {
	      					message: '身份证号格式不正确',
	      					callback:function(value, validator,$field){
	      						if(!value){
	      							return true;
	      						}
	      						return validateIdCard(value);
	      					}
	      			   }
		            }
                },
                //户口性质
                aac009: {
                     validators: {  notEmpty: { message: '请选择户口性质' } } 
                },
                //户口所在地
                bab305: {
                     validators: {  notEmpty: { message: '请填写户口所在地' },
                     	stringLength: { min: 0, max: 50 } } 
                },
                //籍贯
                aac025: {
                     validators: { stringLength: { min: 0, max: 50, message:'最多输入50个汉字' } } 
                },
                //详细地址
                expAddress: {
                     validators: { 
                     	stringLength: { min: 0, max: 50, message:'最多输入50个汉字' } } 
                },
                //毕业学校
                aac180: {
                     validators: {  stringLength: { min: 0, max: 50 , message:'最多输入50个汉字'}  }  
                },
                //原工作单位
                expOldCompany: {
                     validators: {  stringLength: { min: 0, max: 25 , message:'最多输入25个汉字'}  }  
                },
                //职务
                expPost: {
                     validators: {  stringLength: { min: 0, max: 25 , message:'最多输入25个汉字'}  }  
                },
                //电子信箱
                aae015: {
                     validators: {  
                     	 emailAddress: {
                         	message: '邮箱格式不对'
	                     },
	                     stringLength: {
	                         min: 0,
	                         max: 50,
	                         message: '邮箱账号长度不能超过50个字符'
	                     } 
                     }  
                },
                //邮编
                aae007: {
                	validators: { 
                		regexp: {
    	       		        regexp: /^[1-9][0-9]{5}$/,
    	       		        message: '邮政编码不正确'
                	    }
               		}
                },
                //备注
                aae013: {validators: {  stringLength: {
                         min: 0,
                         max: 50,
                         message: '最多输入50个汉字'
                     }  }
                },
                //居住所在地
                aab301: {
                     validators: {  notEmpty: { message: '请填写居住所在地' },
                     	stringLength: { min: 0, max: 50 , message:'最多输入50个汉字'}	
                     } 
                } ,
                //配偶姓名
                faName: {
                     validators: { stringLength: { min: 0, max: 10 ,message:'最多输入10个汉字' }} 
                },
                //配偶电话
                faSpousePhone: {
                     validators: { 
                    	 stringLength: { max: 15 },
	 	               	 regexp: {
	 	        				regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
	 	              			message: '电话号码或手机号码格式不正确'
	 	               	 }             
                } 
                },
                //家庭情况备注
                faFamilyBark: {
                     validators: { 
                     	stringLength: { min: 0, max: 250 , message:'最多输入250个汉字'}	
                     } 
                },
                //毕业时间
                aac181: {
                     validators: {  
	                     date: {
	                         format: 'YYYY-MM-DD',
	                         message: '请输入正确的时间格式'
	                     }
                     } 
                },
               //户口登记日期
                expHourseDate: {
                     validators: {  
	                     date: {
	                         format: 'YYYY-MM-DD',
	                         message: '请输入正确的时间格式'
	                     }
                     } 
                },
               //取得职业资格等级日期
                expLevelDate: {
                     validators: {  
	                     date: {
	                         format: 'YYYY-MM-DD',
	                         message: '请输入正确的时间格式'
	                     }
                     } 
                },
              //取得专技资格日期
                expTechnicalDate: {
                     validators: {  
	                     date: {
	                         format: 'YYYY-MM-DD',
	                         message: '请输入正确的时间格式'
	                     }
                     } 
                },
              //结婚时间
                faMarriageDate: {
                     validators: {  
	                     date: {
	                         format: 'YYYY-MM-DD',
	                         message: '请输入正确的时间格式'
	                     }
                     } 
                },
              //配偶出生日期
                faSpouseBirth: {
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
            $.post($form.attr('action'), $form.serialize(), function(data) {
                bootbox.alert({ 
                    size: 'small',
                    width:"100px",
                    message:data.message,
                    callback:function(){
                    	bv.disableSubmitButtons(false);
                    	if(data.result===1){
                    		$("#mvcMethod").val("edit");
                    		var parentIframe=xfui.getParentIframe();
        			    	if(parentIframe){
        			    		parentIframe.loadPage($("#aac001").val());
        			    	}
                    	}
                    	
                    }
                })
                
            }, 'json');
            
        });
    }	 
</script>	
</body>
</html>