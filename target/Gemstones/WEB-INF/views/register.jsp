<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Đăng ký - 4S Perfume</title>
</head>
<body>
<c:if test="${status != null}">
    <div class="alert alert-danger">${status}</div>
</c:if>
<h1 class="w3ls">FOR SWEET PERFUME</h1>
<div class="content-w3ls">
    <div class="content-agile1">
        <h2 class="agileits1">4S Perfume</h2>
        <p class="agileits2">"Vì một mùi hương thoảng qua</p>
        <p class="agileits2">Người ta có thể nhớ ai đó cả cuộc đời"</p>
    </div>
    <div class="content-agile2">
        <form:form action="#" method="post" modelAttribute="user">
            <div class="form-control w3layouts">
                <form:input type="text" path="fullname" id="firstname"  placeholder="Tên đầy đủ"
                       title="Vui lòng nhập họ và tên" required=""/>
            </div>
            <div class="form-control w3layouts">
                <form:input type="email" path="username" id="email" placeholder="mail@example.com"
                       title="Vui lòng nhập email" required=""/>
            </div>
            <div class="form-control agileinfo">
                <form:input type="password" path="password" class="lock" placeholder="Mật khẩu" id="password1"
                       required=""/>
            </div>
            <div class="form-control agileinfo">
                <input type="password" class="lock" name="confirm-password" placeholder="Nhập lại mật khẩu"
                       id="password2" required="">
            </div>
            <input type="submit" class="register" value="Đăng ký">
        </form:form>
        <script type="text/javascript">
            window.onload = function () {
                document.getElementById("password1").onchange = validatePassword;
                document.getElementById("password2").onchange = validatePassword;
            }

            function validatePassword() {
                var pass2 = document.getElementById("password2").value;
                var pass1 = document.getElementById("password1").value;
                if (pass1 != pass2)
                    document.getElementById("password2").setCustomValidity("Password is not match");
                else
                    document.getElementById("password2").setCustomValidity('');
                //empty string means no validation error
            }
        </script>
        <p class="wthree w3l">Follow Fanpage</p>
        <ul class="social-icons social-agileinfo wthree2">
            <li><a href="https://www.facebook.com/ForSweetPerfume/"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
            <li><a href="https://www.instagram.com/4s_perfume/"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
        </ul>
    </div>
    <div class="clear"></div>
</div>
</body>
</html>
