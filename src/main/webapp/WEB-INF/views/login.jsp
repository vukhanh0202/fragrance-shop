<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng Nhập - 4S Perfume</title>
</head>
<body>
<c:if test="${param.incorrectAccount != null}">
    <div class="alert alert-danger">Sai tài khoản hoặc mật khẩu
    </div>
</c:if>
<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger">Bạn không đủ quyền để truy cập</div>
</c:if>

<c:if test="${status != null}">
    <div class="alert alert-success">${status}</div>
</c:if>

<h1 class="w3ls">FOR SWEET PERFUME</h1>
<div class="content-w3ls">
    <div class="content-agile1">
        <h2 class="agileits1">4S Perfume</h2>
        <p class="agileits2">"Vì một mùi hương thoảng qua</p>
        <p class="agileits2">Người ta có thể nhớ ai đó cả cuộc đời"</p>
    </div>
    <div class="content-agile2" style="padding: 125px 0 0">
        <form action="j_spring_security_check" id="formLogin" method="POST">
            <div class="form-control w3layouts">
                <input type="text" class="form-control" placeholder="Tên Đăng Nhập" id="firstname"
                       name="j_username">
            </div>
            <div class="form-control agileinfo">
                <input type="password" class="form-control" placeholder="Mật Khẩu" id="password1"
                       name="j_password">
            </div>
            <input type="submit" class="register" value="Đăng nhập">
            <input type="button" class="register-btn" onclick="registerbtn()" value="Đăng ký">
        </form>
        <p class="wthree w3l">Follow Fanpage</p>
        <ul class="social-icons social-agileinfo wthree2">
            <li><a href="https://www.facebook.com/ForSweetPerfume/"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
            <li><a href="https://www.instagram.com/4s_perfume/"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
        </ul>
    </div>
    <div class="clear"></div>
</div>
<script type="text/javascript">
    function registerbtn() {
        window.location = '<c:url value="/dang-ky"/>';
    }
</script>
<%--<div class="d-flex justify-content-center h-100">
    <div class="card">
        <div class="card-header">
            <h3>ĐĂNG NHẬP</h3>
        </div>
        <div class="card-body">
            <form action="j_spring_security_check" id="formLogin" method="POST">
                <div class="input-group form-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-user"></i></span>
                    </div>
                    <input type="text" class="form-control" placeholder="Tên Đăng Nhập" id="username"
                           name="j_username">

                </div>
                <div class="input-group form-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-key"></i></span>
                    </div>
                    <input type="password" class="form-control" placeholder="Mật Khẩu" id="password"
                           name="j_password">
                </div>
                <div class="form-group">
                    <input type="submit" value="Đăng nhập" class="btn btn-primary form-control login_btn">
                </div>
            </form>
        </div>

    </div>
</div>--%>
</body>
</html>
