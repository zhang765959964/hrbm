<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>单位下档案数</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
</head>
<body>
	<div id="serArchive">
		<div class="col-xs-12 col-sm-12 threeCol">
			<div class="row rowTextarea">
				<label class="col-xs-3 col-sm-2" for="inputError" title="当前单位下存档人数">当前单位下存档人数:</label>
				<div class="col-xs-9 col-sm-10">
					<span style="color:red;">${archiveCount } </span> (人)
				</div>
			</div>
		</div>
	</div>
</body>		
</html>