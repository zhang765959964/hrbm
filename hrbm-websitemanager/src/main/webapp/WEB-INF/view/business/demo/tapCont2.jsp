<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row topSearch">
	<!-- 单条件查询 -->
	<div class="col-xs-12 pd0 tar">
		<div class="col-xs-6 col-sm-6">
			<a href="javascript:void(0)" role="button" class="btn btn-info" data-toggle="modal">社保卡已配置</a>
			<a href="javascript:void(0)" role="button" class="btn" data-toggle="modal">身份证未配置</a>
		</div>
		<div class="col-xs-6 col-sm-6">
			<form class="" action="" method="post">
				<label class="col-xs-3 col-sm-2" for="inputError">查询:</label>
				<div class="col-xs-6 col-sm-7 pr">
					<input class="form-control" placeholder="请输入身份证号" type="text"/>
					<!-- 多条结果 -->
					<div class="pa moreResult dnn">
						<table class="srtable">
							<thead>
								<tr>
									<th class="sid">身份证号</th>
									<th class="sname">姓名</th>
									<th class="ssex">性别</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="sid">311525198605258796</td>
									<td class="sname">端木利亚</td>
									<td class="ssex">女</td>
								</tr>
								<tr>
									<td class="sid">311525198605258796</td>
									<td class="sname">端木利亚</td>
									<td class="ssex">女</td>
								</tr>
								<tr>
									<td class="sid">311525198605258796</td>
									<td class="sname">端木利亚</td>
									<td class="ssex">女</td>
								</tr>
								<tr>
									<td class="sid">311525198605258796</td>
									<td class="sname">端木利亚</td>
									<td class="ssex">女</td>
								</tr>
								<tr>
									<td class="sid">311525198605258796</td>
									<td class="sname">端木利亚</td>
									<td class="ssex">女</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="fl">
					<a href="javascript:void(0)"  class="btn btn-primary singleSearchBtn">查询</a>
				</div>
			</form>
		</div>
	</div>
</div><!-- row end -->

