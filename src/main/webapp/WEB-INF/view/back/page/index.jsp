<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>钱袋宝后台管理系统</title>
<%@include file="../common/head.jsp" %>
</head>
<body class="page-header-fixed">
<%@include file="../common/top.jsp" %>

<div class="page-container">
	<%@include file="../common/left.jsp" %>	
	
	<div id="content" class="page-content">
		
	</div>
	
</div>

<div class="footer">

	<div class="footer-inner">

		2016 &copy; 北京钱袋宝公司 <a href="http://www.qiandai.com/" title="钱袋宝" target="_blank">钱袋宝后台管理</a>

	</div>

	<div class="footer-tools">

		<span class="go-top">

		<i class="icon-angle-up"></i>

		</span>

	</div>

</div>

<%@include file="../common/footer.jsp" %>	
	
<script>
	var url = "${ctxPath}/a/home.do";// 默认url
	
	jQuery(document).ready(function() {    

	   App.init(); // initlayout and core plugins

	   Index.init();

	   Index.initJQVMAP(); // init index page's custom scripts

	   Index.initCalendar(); // init index page's custom scripts

	   Index.initCharts(); // init index page's custom scripts

	   Index.initChat();

	   Index.initMiniCharts();

	   Index.initDashboardDaterange();

	   Index.initIntro();
	   
	   loadPage(url); // 加载默认页面

	});
	
	function loadPage(url) {
		$.ajax({ 
			url: url,
			async: false, 
			success: function(obj) {
	        	$("#content").html(obj);
	    	}
		});
	}
</script>
</body>
</html>