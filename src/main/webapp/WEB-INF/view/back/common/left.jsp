<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="default.jsp"%>
<!-- BEGIN SIDEBAR -->

<div class="page-sidebar nav-collapse collapse">

	<!-- BEGIN SIDEBAR MENU -->        

	<ul class="page-sidebar-menu">

	<li>

		<!-- BEGIN SIDEBAR TOGGLER BUTTON -->

		<div class="sidebar-toggler hidden-phone"></div>

		<!-- BEGIN SIDEBAR TOGGLER BUTTON -->

	</li>

	<li>

		<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->

		<form class="sidebar-search">

			<div class="input-box">

				<a href="javascript:;" class="remove"></a>

				<input type="text" placeholder="Search..." />

				<input type="button" class="submit" value=" " />

			</div>

		</form>

		<!-- END RESPONSIVE QUICK SEARCH FORM -->

	</li>

	<li class="start active ">

		<a href="javascript:void(0);" onclick="loadPage('${ctxPath}/a/home.do')">

		<i class="icon-home"></i> 

		<span class="title">首页</span>

		<span class="selected"></span>

		</a>

	</li>

	<li class="">

		<a href="javascript:;" >

		<i class="icon-cogs"></i> 

		<span class="title">订单管理</span>

		<span class="arrow "></span>

		</a>

		<ul class="sub-menu">

			<li >

				<a href="javascript:void(0);" onclick="loadPage('${ctxPath}/a/order.do')">

				订单查询</a>

			</li>


		</ul>

	</li>


	<li class="">

		<a href="javascript:;">

		<i class="icon-briefcase"></i> 

		<span class="title">用户管理</span>

		<span class="arrow "></span>

		</a>

		<ul class="sub-menu">

			<li >
				<a href="javascript:void(0);" onclick="loadPage('${ctxPath}/a/user.do')">

				<i class="icon-time"></i>

				用户查询</a>

			</li>

		</ul>

	</li>
	
</ul>

<!-- END SIDEBAR MENU -->

</div>