<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:url var="productAPI" value="/api/product"/>
<c:url var="listProduct" value="/quan-tri/san-pham/danh-sach"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Chi tiết phiếu bán hàng</title>
</head>
<body>
<div class="container container-customer">
    <!-- Page Heading -->
    <div class="row">
        <div class="col-xs-12 col-md-12 col-lg-12">
            <div>
                <div class="title-bar">
                    <div class="title-bar-heading">
                        <h3>Chi tiết phiếu bán hàng</h3>
                        <div class="title-bar-heading-action-container">
                            <a href="#" class="btn-null-background">
                                <i class="fas fa-arrow-down"></i> Xuất file excel</a>
                            <a href="#" class="btn-null-background">
                                <i class="fas fa-arrow-up"></i> Nhập danh sách</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-12 col-md-12 col-lg-12" style="margin-top:2rem">
            <div class="form-control dis-flex form-info">
                <p>Tên khách hàng: </p>
                <p>${model.customer.name}</p>
            </div>
            <div class="form-control dis-flex  form-info">
                <p>Số điện thoại: </p>
                <p>${model.customer.phone}</p>
            </div>
            <div class="form-control dis-flex  form-info">
                <p>Email: </p>
                <p>${model.customer.email}</p>
            </div>
            <div class="form-control dis-flex  form-info">
                <p>Địa chỉ: </p>
                <p>${model.customer.address}</p>
            </div>
            <div class="form-control dis-flex  form-info">
                <p>Thành phố: </p>
                <p>${model.customer.city}</p>
            </div>
        </div>
        <form action="#" id="formSubmit" method="get" class="col-12" style="margin-top:50px;">
            <!--End Nav Button  -->
            <div class="input-group" style="margin:0px 0px;">
                <input class="form-control" type="text" placeholder="Tìm kiếm..."
                       aria-label="Search" aria-describedby="basic-addon2">
                <div class="input-group-append">
                    <button class="btn btn-primary" type="button" value="Tìm kiếm">Tìm kiếm</button>
                </div>
            </div>
            <div class="table-responsive" id="nav-home" role="tabpanel" style="background-color: #f1f1f1;"
                 aria-labelledby="nav-home-tab">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th><input type="checkbox" id="checkAll"></th>
                        <th style="width:100px;">Hình ảnh</th>
                        <th>Tên sản phẩm</th>
                        <th>Size</th>
                        <th>Số lượng</th>
                        <th>Tổng tiền</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${model.listResultDetailProduct}">
                        <tr>
                            <td><input type="checkbox" id="checkbox_${item.id}"
                                       value="${item.id}"></td>
                            <td>
                                <img alt="" src="<c:out value="${item.productFullSize.images}"/>"
                                     style="float: left; height: 100px; width: 100px;">
                            </td>
                            <td>${item.productFullSize.product.name}</td>
                            <td>${item.productFullSize.productSize.size}</td>
                            <td>${item.quantity}</td>
                            <td><fmt:setLocale value="en_CA"/>
                                <fmt:formatNumber type="currency" currencySymbol=""
                                                  maxFractionDigits="0" value="${item.price}"/></td></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="align-center">
                    <ul class="pagination" id="pagination"></ul>
                    <input type="hidden" value="" id="page" name="page" />
                    <input type="hidden" value="" id="limit" name="limit" />
                </div>
            </div>
        </form>
    </div>
</div>

<script type="text/javascript">
    var totalPages = ${model.totalPage};
    var currentPage = ${model.page};
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $('#limit').val(10);
                    $('#page').val(page);
                    $('#formSubmit').submit();
                }
            }
        });
    });


</script>
</body>
</html>