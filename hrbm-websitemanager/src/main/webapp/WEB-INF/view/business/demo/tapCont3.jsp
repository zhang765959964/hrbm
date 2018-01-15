<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 家庭情况-可折叠展开 -->
<div class="moduleWrap mgt5">
	<div class="moduleTit dbToggle">
		<span class="fl"><i class="icon-minus icon-rotate-90"></i>家庭情况</span>
	</div>
	<div class="moduleCont">
		<div class="row">
			<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>身份证号:</label>
			<div class="col-xs-9 col-sm-2 required">
				<input class="form-control" data-container="body" data-toggle="popover" data-placement="bottom" data-content="必填项"/>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
			<div class="col-xs-9 col-sm-2 required">
				<input class="form-control" readonly="true" />
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">出生日期:</label>
			<div class="col-xs-9 input-group col-sm-2">
              	<input class="form-control date-picker dp" id="datepicker01" name="beginaae036" type="text" placeholder="请选择日期"/>
              	<span class="input-group-addon">
                  	<i class="icon-calendar bigger-110"></i>
              	</span>
            </div>
			<label class="col-xs-3 col-sm-2" for="inputError">曾用名:</label>
			<div class="col-xs-9 col-sm-2 required">
				<input class="form-control"/>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
			<div class="col-xs-9 col-sm-2">
				<input class="form-control" type="text" name="" readonly="readonly"/>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">档案姓名:</label>
			<div class="col-xs-9 col-sm-2">
				<input class="form-control" type="text" name=""/>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError">民族:</label>
			<div class="col-xs-9 col-sm-2">
				<select class="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code">
					<option value="1">汉族</option>
					<option value="">回族</option>
					<option value="">傣族</option>
					<option value="">其他少数民族</option>
				</select>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError" title="政治面貌">政治面貌:</label>
			<div class="col-xs-9 col-sm-2">
				<select class="form-control" textField="name" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code">
					<option value="1">中共党员</option>
					<option value="">团员</option>
					<option value="">无党人士</option>
					<option value="">其他团体</option>
				</select>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError" title="文化程度">文化程度:</label>
			<div class="col-xs-9 col-sm-2">
				<select class="form-control" textField="name" hasDefault="0" valueField="code">
					<option value="1">中共党员</option>
					<option value="">团员</option>
					<option value="">无党人士</option>
					<option value="">其他团体</option>
				</select>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError" title="联系电话">联系电话:</label>
			<div class="col-xs-9 col-sm-2">
				<input class="form-control" type="text" name=""/>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError" title="手机号">手机号:</label>
			<div class="col-xs-9 col-sm-2">
				<input class="form-control" type="text" name=""/>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError" title="是否军转干部">是否军转干部:</label>
			<div class="col-xs-9 col-sm-2">
				<select class="form-control" textField="name" hasDefault="0" valueField="code">
					<option value="1">中共党员</option>
					<option value="">团员</option>
					<option value="">无党人士</option>
					<option value="">其他团体</option>
				</select>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError" title="是否享有再就业优惠证标准">是否享有再就业优惠证标准:</label>
			<div class="col-xs-9 col-sm-2">
				<select class="form-control" textField="name" hasDefault="0" valueField="code">
					<option value="1">中共党员</option>
					<option value="">团员</option>
					<option value="">无党人士</option>
					<option value="">其他团体</option>
				</select>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError" title="是否持有就业失业登记证">是否持有就业失业登记证:</label>
			<div class="col-xs-9 col-sm-2">
				<select class="form-control" textField="name" hasDefault="0" valueField="code">
					<option value="1">中共党员</option>
					<option value="">团员</option>
					<option value="">无党人士</option>
					<option value="">其他团体</option>
				</select>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError" title="再就业优惠证编号">再就业优惠证编号:</label>
			<div class="col-xs-9 col-sm-2">
				<input class="form-control" type="text" name=""/>
			</div>
			<div class="col-xs-12 col-sm-8 mgb0">
				<div class="row mgb0">
					<label class="col-xs-3 col-sm-3" for="inputError" title="身份证住址">身份证住址:</label>
					<div class="col-xs-9 col-sm-9">
						<input class="form-control" type="text" name=""/>
					</div>
				</div>
			</div>
			<label class="col-xs-3 col-sm-2" for="inputError" title="就业失业登记证号">就业失业登记证号:</label>
			<div class="col-xs-9 col-sm-2">
				<input class="form-control" type="text" name=""/>
			</div>
			<div class="col-xs-12 col-sm-8 mgb0">
				<div class="row mgb0">
					<label class="col-xs-3 col-sm-3" for="inputError" title="现居住地址">现居住地址:</label>
					<div class="col-xs-9 col-sm-9">
						<input class="form-control" type="text" name=""/>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-12 mgb0">
				<div class="row rowTextarea">
					<label class="col-xs-3 col-sm-2" for="inputError" title="基本情况备注">基本情况备注:</label>
					<div class="col-xs-9 col-sm-10">
						<textarea row="5" col="5" ></textarea>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
