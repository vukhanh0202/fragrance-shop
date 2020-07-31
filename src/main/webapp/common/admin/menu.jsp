<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.gemstones.utils.SecurityUtils" %>
<%@include file="/common/taglib.jsp" %>
<nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
    <div class="sb-sidenav-menu">
        <div class="nav">
            <div class="sb-sidenav-menu-heading">Chức năng chính</div>
            <a class="nav-link" href="<c:url value="/quan-tri/trang-chu"/>">
                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                Tổng quan</a>
            <div class="sb-sidenav-menu-heading">Giao diện</div>

            <%-- Sản Phẩm--%>
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts"
               aria-expanded="false" aria-controls="collapseLayouts">
                <div class="sb-nav-link-icon"><i class="fas fa-th-list"></i></div>
                Sản phẩm
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionLayouts">
                    <a class="nav-link collapsed" href="<c:url value="/quan-tri/san-pham/danh-sach?page=1&limit=10"/>"
                       data-target="#pagesCollapseProduct"
                       aria-expanded="false" aria-controls="pagesCollapseProduct">Danh sách sản phẩm
                    </a>
                    <a class="nav-link collapsed" href="<c:url value="/quan-tri/san-pham/danh-sach-size?page=1&limit=10"/>" data-target="#pagesCollapseSize"
                       aria-expanded="false" aria-controls="pagesCollapseSize">Danh sách size
                    </a>
                    <a class="nav-link collapsed" href="<c:url value="/quan-tri/san-pham/danh-sach-nhom-huong?page=1&limit=10"/>" data-target="#pagesCollapseIncenseGroup"
                       aria-expanded="false" aria-controls="pagesCollapseIncenseGroup">Nhóm hương
                    </a>
                    <a class="nav-link collapsed" href="<c:url value="/quan-tri/san-pham/danh-sach-san-pham-day-du?page=1&limit=10"/>" data-target="#pagesCollapseFullProduct"
                       aria-expanded="false" aria-controls="pagesCollapseFullProduct">Danh sách đầy đủ
                    </a>
                </nav>
            </div>

            <%--Đối tác--%>
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
               aria-expanded="false" aria-controls="collapsePages">
                <div class="sb-nav-link-icon"><i class="fas fa-handshake"></i></div>
                Đối tác
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                    <a class="nav-link collapsed" href="<c:url value="/quan-tri/doi-tac/khach-hang?page=1&limit=10"/>" data-target="#pagesCollapseAuth"
                       aria-expanded="false" aria-controls="pagesCollapseAuth">Khách hàng
                    </a>
                </nav>
            </div>

            <%-- Hóa đơn--%>
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseBills"
               aria-expanded="false" aria-controls="collapseBills">
                <div class="sb-nav-link-icon"><i class="fas fa-database"></i></div>
                Hóa đơn
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseBills" aria-labelledby="headingThree" data-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionBills">
                    <a class="nav-link collapsed" href="<c:url value="/quan-tri/hoa-don/danh-sach-phieu-ban-hang?page=1&limit=10"/>" data-target="#pagesCollapseBillSell"
                       aria-expanded="false" aria-controls="pagesCollapseBillSell">Hóa đơn bán hàng
                    </a>
                </nav>
            </div>

            <%-- Blog--%>
            <a class="nav-link" href="<c:url value="/quan-tri/blog/danh-sach-blog?page=1&limit=10"/>" >
                <div class="sb-nav-link-icon"><i class="fas fa-blog"></i></div>
                Blog
            </a>
        </div>
    </div>
    <div class="sb-sidenav-footer">
        <div class="small">Đăng nhập bởi:</div>
        <%=SecurityUtils.getPrincipal().getFullName()%>
    </div>
</nav>



