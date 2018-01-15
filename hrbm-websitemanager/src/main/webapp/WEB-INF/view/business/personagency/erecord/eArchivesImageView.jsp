<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>电子档案办理</title>
	<link rel="stylesheet" type="text/css" href="${ctx}/js/lib/elastislide/css/style.css" />
	<link rel="stylesheet" type="text/css" href="${ctx}/js/lib/elastislide/css/elastislide.css" />
	<script type="text/javascript" src="${ctx}/js/lib/elastislide/js/jquery.tmpl.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/lib/elastislide/js/jquery.easing.1.3.js"></script>
	<script type="text/javascript" src="${ctx}/js/lib/elastislide/js/jquery.elastislide.js"></script>
	<script type="text/javascript" src="${ctx}/js/lib/elastislide/js/gallery.js"></script>
	<noscript>
		<style>
			.es-carousel ul{
				display:block;
			}
		</style>
	</noscript>
	<script id="img-wrapper-tmpl" type="text/x-jquery-tmpl">
			<div class="rg-image-wrapper">
				{{if itemsCount > 1}}
					<div class="rg-image-nav">
						<a href="#" class="rg-image-nav-prev">Previous Image</a>
						<a href="#" class="rg-image-nav-next">Next Image</a>
					</div>
				{{/if}}
				<div class="rg-image"></div>
				<div class="rg-loading"></div>
				<div class="rg-caption-wrapper">
					<div class="rg-caption" style="display:none;">
						<p></p>
					</div>
				</div>
			</div>
		</script>
		<style>
		.rg-gallery{width:1140px;height:820px;overflow:auto;}
		</style>
</head>
<body>
<div class="container">
	<div class="content">
		<div id="rg-gallery" class="rg-gallery">
			<div class="rg-thumbs">
				<!-- Elastislide Carousel Thumbnail Viewer -->
				<div class="es-carousel-wrapper" style="background-color: #C7C7C7">
					<div class="es-nav">
						<span class="es-nav-prev">Previous</span>
						<span class="es-nav-next">Next</span>
					</div>
					<div class="es-carousel" style="background-color: papayawhip;">
						<ul style="margin-bottom: 5px">
							<c:forEach var="eArchives" items="${eArchivesList}">
								<li><a href="#"><img width="70px" height="100px" src="${fileDirectory}/${eArchives.imagePath}" data-large="${fileDirectory}/${eArchives.imageCompressPath}" alt="image01" data-description="图片大小：16M" /></a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<!-- End Elastislide Carousel Thumbnail Viewer -->
			</div><!-- rg-thumbs -->
		</div><!-- rg-gallery -->
	</div><!-- content -->
</div><!-- container -->
</body>
</html>