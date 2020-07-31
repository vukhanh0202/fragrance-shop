<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title><dec:title default="Trang chủ"/></title>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="<c:url value='/template/admin/images/4SIcon.ico'/>" rel="shortcut icon">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
            integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous">
    </script>
   <%-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">--%>
    <!-- Custom fonts for this template-->
    <%--<link href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css'/>" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">--%>

    <!-- Custom styles for this template-->
    <%--<link href="<c:url value='/template/admin/css/sb-admin-2.min.css'/>" rel="stylesheet">--%>

    <link href="<c:url value='/template/admin/css/styles-listProduct.css'/>" rel="stylesheet"/>
    <link href="<c:url value='/template/admin/css/styles.css'/>" rel="stylesheet"/>
    <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet"
          crossorigin="anonymous"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"
            crossorigin="anonymous"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="<c:url value='/template/admin/ckeditor/ckeditor.js'/>"></script>
    <!-- sweetalert -->
    <script src="<c:url value='/template/admin/sweetalert2/sweetalert2.min.js' />"></script>
    <link rel="stylesheet" href="<c:url value='/template/admin/sweetalert2/sweetalert2.min.css' />"/>
</head>
<body class="sb-nav-fixed">
<!-- Page Wrapper -->
<div id="wrapper">
    <%--Header--%>
    <%@ include file="/common/admin/header.jsp" %>
    <%--End Header--%>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <!-- Sidebar -->
                <%@ include file="/common/admin/menu.jsp" %>
                <!-- End of Sidebar -->
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <!-- Main Content -->
                    <dec:body/>
                    <!-- End of Main Content -->
                </main>
                <!-- Footer -->
                <%@ include file="/common/admin/footer.jsp" %>
                <!-- End of Footer -->
            </div>
        </div>
</div>
<!-- End of Page Wrapper -->

<!-- Bootstrap core JavaScript-->
<%--<script src="<c:url value='/template/admin/vendor/jquery/jquery.min.js'/>"></script>
<script src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>--%>

<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<script src="<c:url value='/template/admin/js/scripts.js'/>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="<c:url value='/template/admin/assets/demo/chart-area-demo.js'/>"></script>
<script src="<c:url value='/template/admin/assets/demo/chart-bar-demo.js'/>"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
<script src="<c:url value='/template/admin/assets/demo/datatables-demo.js'/>"></script>
<%--Paging--%>
<script src="<c:url value='/template/admin/paging/jquery.twbsPagination.js' />"></script>
<script src="<c:url value='/template/admin/js/ScriptCustom.js' />"></script>

<%--<!-- Core plugin JavaScript-->
<script src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js'/>"></script>

<!-- Custom scripts for all pages-->
<script src="<c:url value='/template/admin/js/sb-admin-2.min.js'/>"></script>

<!-- Page level plugins -->
<script src="<c:url value='/template/admin/vendor/chart.js/Chart.min.js'/>"></script>

<!-- Page level custom scripts -->
<script src="<c:url value='/template/admin/js/demo/chart-area-demo.js'/>"></script>
<script src="<c:url value='/template/admin/js/demo/chart-pie-demo.js'/>"></script>--%>
</body>
</html>