<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div>
	<input type="button" value="下载" onclick="downLoad()">
</div>

<script>
	function downLoad(){
		window.location.href="${ctxPath}/FundServer/downLoad.do";
	}
</script>