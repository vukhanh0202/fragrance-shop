<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <title><dec:title default="Trang chủ"/></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--    <link rel="manifest" href="site.webmanifest">--%>
    <link href="<c:url value='/template/web/assets/img/4SIcon.ico'/>" rel="shortcut icon">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,700,900">
    <link rel="stylesheet" href="<c:url value='/template/web/assets/header/fonts/icomoon/style.css'/>">
    <link rel="stylesheet" href="<c:url value='/template/web/assets/header/css/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/template/web/assets/header/css/style.css'/>">

    <!-- CSS here -->
    <link rel="stylesheet" href="<c:url value='/template/web/assets/css/HomePage.css'/>">
    <link rel="stylesheet" href="<c:url value='/template/web/assets/css/listProduct.css'/>">
    <link rel="stylesheet" href="<c:url value='/template/web/assets/css/detailProduct.css'/>">
    <link rel="stylesheet" href="<c:url value='/template/web/assets/css/listCart.css'/>">
    <link rel="stylesheet" href="<c:url value='/template/web/assets/css/payment.css'/>">
    <link rel="stylesheet" href="<c:url value='/template/web/assets/css/listBlog.css'/>">
    <link rel="stylesheet" href="<c:url value='/template/web/assets/css/detailBlog.css'/>">
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
 <%--   <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
            integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous">
    </script>--%>
    <link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

 <%--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>--%>
    <%-- <script src="<c:url value='/template/web/assets/js/header.js'/>" ></script>--%>

    <%--<link rel="stylesheet" href="<c:url value='/template/web/assets/css/header.css'/>">--%>
    <%-- <link rel="stylesheet" href="<c:url value='/template/web/assets/css/footer.css'/>">--%>

</head>
<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">

<!-- 	header -->
<%@ include file="/common/web/header.jsp" %>

<!-- 	body -->
<dec:body/>

<!-- 	footer -->
<%@ include file="/common/web/footer.jsp" %>

<!-- JS here -->


<!-- All JS Custom Plugins Link Here here -->
<%--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>--%>

<script src="<c:url value='/template/web/assets/header/js/jquery-3.3.1.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/header/js/jquery-ui.js'/>"></script>
<script src="<c:url value='/template/web/assets/header/js/popper.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/header/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/header/js/owl.carousel.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/header/js/jquery.countdown.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/header/js/jquery.magnific-popup.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/header/js/bootstrap-datepicker.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/header/js/aos.js'/>"></script>
<script src="<c:url value='/template/web/assets/header/js/jquery.sticky.js'/>"></script>
<script src="<c:url value='/template/web/assets/header/js/jquery.easing.1.3.js'/>"></script>
<script src="<c:url value='/template/web/assets/header/js/jquery.fancybox.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/header/js/main.js'/>"></script>

<%--<script src="<c:url value='/template/web/assets/js/vendor/modernizr-3.5.0.min.js'/>"></script>
<!-- Jquery, Popper, Bootstrap -->
<script src="<c:url value='/template/web/assets/js/vendor/jquery-1.12.4.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/popper.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/bootstrap.min.js'/>"></script>
<!-- Jquery Mobile Menu -->
<script src="<c:url value='/template/web/assets/js/jquery.slicknav.min.js'/>"></script>--%>

<%--Pagination--%>
<script src="<c:url value='/template/web/assets/paging/jquery.twbsPagination.js' />"></script>
<script src="<c:url value='/template/web/assets/js/detailProduct.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/vendor/listProduct.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/HomePage.js'/>"></script>
<dec:getProperty property="page.script"></dec:getProperty>

<!-- Jquery Slick , Owl-Carousel Plugins -->
<%--<script src="<c:url value='/template/web/assets/js/owl.carousel.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/slick.min.js'/>"></script>

<!-- One Page, Animated-HeadLin -->
<script src="<c:url value='/template/web/assets/js/wow.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/animated.headline.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/jquery.magnific-popup.js'/>"></script>

<!-- Scrollup, nice-select, sticky -->
<script src="<c:url value='/template/web/assets/js/jquery.scrollUp.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/jquery.nice-select.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/jquery.sticky.js'/>"></script>

<!-- contact js -->
<script src="<c:url value='/template/web/assets/js/contact.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/jquery.form.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/jquery.validate.min.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/mail-script.js'/>"></script>
<script src="<c:url value='/template/web/assets/js/jquery.ajaxchimp.min.js'/>"></script>

<!-- Jquery Plugins, main Jquery -->
<script src="<c:url value='/template/web/assets/js/plugins.js'/>"></script>--%>
<%--<script src="<c:url value='/template/web/assets/js/main.js'/>"></script>--%>
</body>
</html>