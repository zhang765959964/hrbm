<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="moduleWrapNobg">
	<div class="moduleTit">查询条件</div>
	<div class="moduleCont">
		<form id="searchForm">
			<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_archiveCode_SL" placeholder="" title="档案编号" data-placement="bottom"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">身份证号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_aac002_SUPL" placeholder="" title="身份证号" data-placement="bottom"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">存档类型:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select  tableName="RSDA_TAB_ARCHIVETYPE" valueField="code" hasDefault="0" textField="name" name="Q_archiveType_S" selectClass="form-control"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_aac003_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="姓名拼音码">姓名拼音码:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_aac022_SLOL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">档案状态:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select  tableName="RSDA_TAB_ARCHIVESTATUS" valueField="code" textField="name" name="Q_archiveStatus_S"  hasDefault="0" selectClass="form-control"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">出生日期起:</label>
							<div class="col-xs-9 input-group col-sm-2"  style="padding-left:15px">
                              <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginaac006" name="beginaac006" type="text" placeholder="请选择日期"/>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                            </div>
							<label class="col-xs-3 col-sm-2" for="inputError">出生日期止:</label>
							<div class="col-xs-9 input-group col-sm-2"  style="padding-left:15px">
                              <input class="form-control date"  format="YYYY-MM-DD" autoUpdateInput="false" id="endaac006" name="endaac006" type="text" placeholder="请选择日期"/>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                            </div>
							<label class="col-xs-3 col-sm-2" for="inputError">接收状态:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select  tableName="RSDA_TAB_ARECEIVESTATUS" valueField="code" textField="name" name="Q_archiveReceiveStatus_S"  hasDefault="0" selectClass="form-control"></xf:select>
							</div>
						</div>
						<div class="row highCondition dnn">
							<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select  tableName="TAB_SEX" valueField="code" textField="name" name="Q_aac004_S"  hasDefault="0" selectClass="form-control" valueCon="1,2"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="文化程度">文化程度:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select  tableName="TAB_EDUCATION" valueField="code" textField="name" name="Q_aac011_S"  hasDefault="0" selectClass="form-control"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="婚姻状况">婚姻状况:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select  tableName="TAB_MARRIAGE" valueField="code" textField="name" name="Q_faMarriage_S"  hasDefault="0" selectClass="form-control"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="档案姓名">档案姓名:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_archiveName_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">档案转入日期起:</label>
							<div class="col-xs-9 input-group col-sm-2" >
                              <input class="form-control date"  format="YYYY-MM-DD" autoUpdateInput="false" id="beginreceiveDate" name="beginreceiveDate" type="text" placeholder="请选择日期"/>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                           </div>
							<label class="col-xs-3 col-sm-2" for="inputError">档案转入日期止:</label>
							<div class="col-xs-9 input-group col-sm-2">
                              <input class="form-control date"  format="YYYY-MM-DD" autoUpdateInput="false" id="endreceiveDate" name="endreceiveDate" type="text" placeholder="请选择日期"/>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                           </div>
							<label class="col-xs-3 col-sm-2" for="inputError">社会保障号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_expSoctalNumber_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">退休参考日期起:</label>
							<div class="col-xs-9 input-group col-sm-2" >
                              <input class="form-control date"  format="YYYY-MM-DD" autoUpdateInput="false" id="beginplanRetiredDate" name="beginplanRetiredDate" type="text" placeholder="请选择日期"/>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                           </div>
							<label class="col-xs-3 col-sm-2" for="inputError">退休参考日期止:</label>
							<div class="col-xs-9 input-group col-sm-2">
                              <input class="form-control date"  format="YYYY-MM-DD" autoUpdateInput="false" id="endplanRetiredDate" name="endplanRetiredDate" type="text" placeholder="请选择日期"/>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                           </div>
							<label class="col-xs-3 col-sm-2" for="inputError">市场位置:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select  tableName="RSDA_TAB_MARKET_POSITION" valueField="code" textField="name" name="Q_marketPosition_S"  hasDefault="0" selectClass="form-control"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">库:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_cabinetsLibrary_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">排:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_cabinetsCode_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">层:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_cabinetsLayer_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_cabinetsLattice_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">委托单位名称:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_expEntrustCompany_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">打印档案标签次数起:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_beginArchivePrintLabel_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">打印档案标签次数止:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_endArchivePrintLabel_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">窗口经办人:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_archiveReceiveName_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">窗口经办机构:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_archiveReceiveOrgName_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">窗口经办日期起:</label>
							<div class="col-xs-9 input-group col-sm-2" >
                              <input class="form-control date"  format="YYYY-MM-DD" autoUpdateInput="false" id="beginarchiveReceiveDate" name="beginarchiveReceiveDate" type="text" placeholder="请选择日期"/>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                           </div>
							<label class="col-xs-3 col-sm-2" for="inputError">窗口经办日期止:</label>
							<div class="col-xs-9 input-group col-sm-2">
                              <input class="form-control date"  format="YYYY-MM-DD" autoUpdateInput="false" id="endarchiveReceiveDate" name="endarchiveReceiveDate" type="text" placeholder="请选择日期"/>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                           </div>
							<label class="col-xs-3 col-sm-2" for="inputError">入库经办机构:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_archiveStorageOrgName_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">入库经办日期起:</label>
							<div class="col-xs-9 input-group col-sm-2" >
                              <input class="form-control date"  format="YYYY-MM-DD" autoUpdateInput="false" id="beginarchiveStorageDate" name="beginarchiveStorageDate" type="text" placeholder="请选择日期"/>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                           </div>
							<label class="col-xs-3 col-sm-2" for="inputError">入库经办日期止:</label>
							<div class="col-xs-9 input-group col-sm-2">
                              <input class="form-control date"  format="YYYY-MM-DD" autoUpdateInput="false" id="endarchiveStorageDate" name="endarchiveStorageDate" type="text" placeholder="请选择日期"/>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                           </div>
							<label class="col-xs-3 col-sm-2" for="inputError">入库经办人:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_archiveStorageName_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">调出经办人:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_lendCreaterName_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">调出原因:</label>
							<div class="col-xs-9 col-sm-2">
						 		<xf:select  tableName="RSDA_TAB_LEND_REASON" valueField="code" textField="name" name="Q_lendReason_S"  hasDefault="0" selectClass="form-control"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">调出经办机构:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_lendCreaterOrgName_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">调出经办日期起:</label>
							<div class="col-xs-9 input-group col-sm-2" >
                              <input class="form-control date"  format="YYYY-MM-DD" autoUpdateInput="false" id="beginlendCreaterDate" name="beginlendCreaterDate" type="text" placeholder="请选择日期"/>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                           </div>
							<label class="col-xs-3 col-sm-2" for="inputError">调出经办日期止:</label>
							<div class="col-xs-9 input-group col-sm-2">
                              <input class="form-control date"  format="YYYY-MM-DD" autoUpdateInput="false" id="endlendCreaterDate" name="endlendCreaterDate" type="text" placeholder="请选择日期"/>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                           </div>
							<label class="col-xs-3 col-sm-2" for="inputError">是否转干部:</label>
							<div class="col-xs-9 col-sm-2">
								<select style='width: 205px' class='easyui-combobox' editable='false' name='Q_expIsCadre_N'>
										<option value="" selected="selected">--请选择--</option>
										<option value="1">是</option>
										<option value="0">否</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">档案出生日期起:</label>
							<div class="col-xs-9 input-group col-sm-2" >
                              <input class="form-control date"  format="YYYY-MM-DD" autoUpdateInput="false" id="beginarchiveBirthDate" name="beginarchiveBirthDate" type="text" placeholder="请选择日期"/>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                           </div>
							<label class="col-xs-3 col-sm-2" for="inputError">档案出生日期止:</label>
							<div class="col-xs-9 input-group col-sm-2">
                              <input class="form-control date"  format="YYYY-MM-DD" autoUpdateInput="false" id="endarchiveBirthDate" name="endarchiveBirthDate" type="text" placeholder="请选择日期"/>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                           </div>
							<label class="col-xs-3 col-sm-2" for="inputError">是否享受在就业优惠证标准:</label>
							<div class="col-xs-9 col-sm-2">
								<select style='width: 205px' class='easyui-combobox' editable='false' name='Q_expIsDiscount_N'>
										<option value="" selected="selected">--请选择--</option>
										<option value="1">是</option>
										<option value="0">否</option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 mgb20 tar pdx20">
								<a href="javascript:void(0)" role="button" onclick="doSearch()" class="btn btn-primary btn-border1"><i class="icon-search"></i>查询</a>
								<a href="javascript:void(0)" class="btn btn-success highSearch" onclick="toggleMore('highCondition',this)"><i class="icon-plus"></i>高级查询</a>
								<a href="javascript:void(0)" onclick="resetForm('searchForm')" role="button" class="btn btn-info"><i class="icon-repeat"></i>重置</a>
							</div>
						</div>
		</form>
	</div>
</div>