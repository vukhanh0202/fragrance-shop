<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
	<a class="navbar-brand" href="#">4S PERFUME</a><button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button>
><!-- Navbar Search-->
	<form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
		<div class="input-group">
			<input class="form-control" type="text" placeholder="Tìm kiếm ..." aria-label="Search" aria-describedby="basic-addon2" />
			<div class="input-group-append">
				<button class="btn btn-primary" type="button"><i class="fas fa-search"></i></button>
			</div>
		</div>
	</form>
	<!-- Navbar-->
	<ul class="navbar-nav ml-auto ml-md-0">
		<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
			<div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
				<a class="dropdown-item" href="#">Cài đặt</a><a class="dropdown-item" href="#">Hoạt động khác</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="<c:url value="/dang-nhap"/>">Đăng xuất</a>
			</div>
		</li>
	</ul>
</nav>