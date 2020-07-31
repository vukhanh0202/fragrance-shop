<%@ page import="com.gemstones.utils.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<header >
    <div class="site-wrap">
        <div class="site-mobile-menu site-navbar-target">
            <div class="site-mobile-menu-header">
                <div class="site-mobile-menu-close mt-3">
                    <span class="icon-close2 js-menu-toggle"></span>
                </div>
            </div>
            <div class="site-mobile-menu-body">

            </div>
        </div> <!-- .site-mobile-menu -->
        <div class="site-navbar-wrap">
            <div class="site-navbar-top">
                <div class="container py-3">
                    <div class="row align-items-center">
                        <div class="col-6">
                            <a href="https://www.facebook.com/ForSweetPerfume/" class="p-2 pl-0"><span
                                    class="icon-facebook"></span></a>
                            <a href="https://www.instagram.com/4s_perfume/" class="p-2 pl-0"><span
                                    class="icon-instagram"></span></a>
                        </div>
                        <div class="col-6">
                            <div class="d-flex ml-auto">
                                <a href="#" class="d-flex align-items-center ml-auto mr-4">
                                    <span class="icon-envelope mr-2"></span>
                                    <span class="d-none d-md-inline-block">forsweetperfume@gmail.com</span>
                                </a>
                                <a href="#" class="d-flex align-items-center">
                                    <span class="icon-phone mr-2"></span>
                                    <span class="d-none d-md-inline-block">+84 918 741 662</span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="site-navbar site-navbar-target js-sticky-header" style="padding: 5px 0;">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-2">
                            <h1 class="my-0 site-logo"><a href="<c:url value='/trang-chu'/>"><img
                                    src="<c:url value='/template/web/assets/header/images/logo.png'/>" alt=""
                                    height="50rem" style="margin-top: 1rem;"></a></h1>
                        </div>
                        <div class="col-10">
                            <nav class="site-navigation text-right" role="navigation">
                                <div class="container">
                                    <div class="d-inline-block d-lg-none ml-md-0 mr-auto py-3"><a href="#"
                                                                                                  class="site-menu-toggle js-menu-toggle text-white"><span
                                            class="icon-menu h3"></span></a></div>

                                    <ul class="site-menu main-menu js-clone-nav d-none d-lg-block">
                                        <li>
                                            <a href="<c:url value='/trang-chu'/>" class="nav-link">Trang chủ</a>
                                        </li>
                                        <li class="has-children">
                                            <a href="<c:url value="/tat-ca?page=1&limit=12"/>" class="nav-link">Nước hoa Pháp</a>
                                            <ul class="dropdown arrow-top">
                                                <li><a href="<c:url value="/nuoc-hoa-nam?page=1&limit=12"/>" class="nav-link">Nước hoa nam</a></li>
                                                <li><a href="<c:url value="/nuoc-hoa-nu?page=1&limit=12"/>" class="nav-link">Nước hoa nữ</a></li>
                                            </ul>
                                        </li>
                                        <li class="has-children">
                                            <a href="<c:url value="/nuoc-hoa-mini?page=1&limit=12"/>" class="nav-link">Nước hoa mini</a>
                                            <ul class="dropdown arrow-top">
                                                <li><a href="<c:url value="/nuoc-hoa-mini-nam?page=1&limit=12"/>" class="nav-link">Nước hoa nam</a></li>
                                                <li><a href="<c:url value="/nuoc-hoa-mini-nu?page=1&limit=12"/>" class="nav-link">Nước hoa nữ</a></li>
                                            </ul>
                                        </li>
                                        <li>
                                            <a href="<c:url value='/danh-sach-bai-viet?page=1&limit=12'/>" class="nav-link">Kiến thức hay</a>
                                        </li>
                                        <li class="has-children">
                                            <a href="#contact-section" class="nav-link">Tài khoản</a>
                                            <ul class="dropdown arrow-top">
                                                <security:authorize access="isAnonymous()">
                                                    <li><a href="<c:url value='/dang-nhap'/>" class="nav-link">Đăng
                                                        nhập</a></li>
                                                    <li><a href="<c:url value='/dang-ky'/>" class="nav-link">Đăng ký</a>
                                                    </li>
                                                </security:authorize>
                                                <security:authorize access="isAuthenticated()">
                                                    <li><a href="#" class="nav-link">Xin
                                                        chào, <%=SecurityUtils.getPrincipal().getFullName()%>
                                                    </a></li>
                                                    <li><a href="<c:url value='/thoat'/>" class="nav-link">Thoát</a>
                                                    </li>
                                                </security:authorize>
                                            </ul>
                                        </li>
                                        <li class="search ">
                                            <a href="#home-section" class="nav-link" onclick="myFunction()">
                                                <i class="fas fa-search"></i>
                                            </a>
                                            <div class="search-bar" id="search-bars">
                                                <form autocomplete="off" id="formSubmit"
                                                      action="#">
                                                    <div class="autocomplete">
                                                        <input id="myInput" class="search-bar-input" type="text"
                                                               placeholder="Nhập từ khóa...">
                                                    </div>
                                                </form>
                                            </div>
                                        </li>
                                        <li class="search" id="cart">
                                            <a href="/gio-hang" class="nav-link">
                                                <i class="fas fa-shopping-cart"><span class="badge badge-primary" style="background-color: #E32124;">${Cart.totalQuantity}</span></i>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>