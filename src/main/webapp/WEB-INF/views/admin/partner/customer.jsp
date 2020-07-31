<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:url var="customerAPI" value="/api/customer"/>
<c:url var="listCustomer" value="/quan-tri/doi-tac/khach-hang"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách khách hàng</title>
</head>
<body>
<div class="container-fluid container-customer">
    <!-- Page Heading -->
    <div class="col-xs-12">
        <div>
            <c:if test="${not empty message}">
                <div class="alert alert-${alert}">
                    <strong>${message}</strong>
                </div>
            </c:if>
            <div class="title-bar">
                <div class="title-bar-heading">
                    <h3>Danh sách khách hàng</h3>
                    <div class="title-bar-heading-action-container">
                        <a href="#" class="btn-null-background">
                            <i class="fas fa-arrow-down"></i> Xuất file excel</a>
                        <a href="#" class="btn-null-background">
                            <i class="fas fa-arrow-up"></i> Nhập danh sách</a>
                    </div>
                </div>
                <div class="title-bar-action">
                    <div class="align-center">
                        <button value="Loại bỏ" type="button" id="btnDelete" onclick="warningBeforeDelete()"
                                class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"> Xóa khách hàng
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <form action="#" id="formSubmit" method="get">
        <div class="row">
            <div class="col-xs-12 content">
                <!--Nav Button  -->
                <nav style="margin-bottom:15px;">
                    <div class="nav nav-tabs" id="nav-tab" role="tablist">
                        <a class="nav-item nav-link active" id="nav-all-tab" data-toggle="tab" href="#nav-all"
                           role="tab" aria-controls="nav-all" aria-selected="true">Tất cả khách hàng</a>
                    </div>
                </nav>
                <!--End Nav Button  -->
                <div class="input-group row" style="margin:20px 0px;">
                    <input id="search-input" class="form-control col-12 col-md-9" type="text" placeholder="Tìm kiếm..." aria-label="Search"
                           aria-describedby="basic-addon2" autocomplete="off" onkeypress="if(event.key === 'Enter') search()">
                    <div class="input-group-append ">
                        <button class="btn btn-primary" type="button" onclick="search()">
                            <svg class="svg-inline--fa fa-search fa-w-16" aria-hidden="true" focusable="false"
                                 data-prefix="fas" data-icon="search" role="img" xmlns="http://www.w3.org/2000/svg"
                                 viewBox="0 0 512 512" data-fa-i2svg="">
                                <path fill="currentColor"
                                      d="M505 442.7L405.3 343c-4.5-4.5-10.6-7-17-7H372c27.6-35.3 44-79.7 44-128C416 93.1 322.9 0 208 0S0 93.1 0 208s93.1 208 208 208c48.3 0 92.7-16.4 128-44v16.3c0 6.4 2.5 12.5 7 17l99.7 99.7c9.4 9.4 24.6 9.4 33.9 0l28.3-28.3c9.4-9.4 9.4-24.6.1-34zM208 336c-70.7 0-128-57.2-128-128 0-70.7 57.2-128 128-128 70.7 0 128 57.2 128 128 0 70.7-57.2 128-128 128z"></path>
                            </svg><!-- <i class="fas fa-search"></i> --></button>
                    </div>
                    <form:form action=""
                               id="formOrderBy" method="get"
                               modelAttribute="model" enctype="multipart/form-data">
                        <form:select onchange="filter_product(this)" path="orderBy" cssStyle="margin-left: 5%"
                                     class="form-control col-12 col-md-2">
                            <form:option value="asc" label="Mặc định"></form:option>
                            <form:option value="asc">A &rarr; Z</form:option>
                            <form:option value="desc">Z &rarr; A</form:option>
                            <form:option value="date-asc">Ngày tạo tăng</form:option>
                            <form:option value="date-desc">Ngày tạo giảm</form:option>
                        </form:select>
                    </form:form>
                </div>
                <div class="table-responsive" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th><input type="checkbox" id="checkAll"></th>
                            <th>Ngày tạo</th>
                            <th>Tên khách hàng</th>
                            <th>Địa chỉ</th>
                            <th>Thành phố</th>
                            <th>Số điện thoại</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${model.listResult}">
                            <tr>
                                <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                <td>${item.createdDate}</td>
                                <td>${item.name}</td>
                                <td>${item.address}</td>
                                <td>${item.city}</td>
                                <td>${item.phone}</td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="align-center">
                        <ul class="pagination" id="pagination"></ul>
                        <input type="hidden" value="" id="page" name="page"/>
                        <input type="hidden" value="" id="limit" name="limit"/>
                    </div>
                </div>
            </div>
        </div>
    </form>
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
                    var limit = $('#limit').val();
                    var page = $('#page').val();

                    var link = location.href.split("#")[0];
                    window.location = "/" + link.split("/")[3] + "/" + link.split("/")[4] + "/" + link.split("/")[5].split("?")[0] + "?page=" + page + "&limit=" + limit + "&orderby=" + "${model.orderBy}";

                }
            }
        });
    });

    function warningBeforeDelete() {
        swal({
            title: "Xác nhận xóa",
            text: "Bạn có chắc chắn muốn xóa hay không",
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: "btn-success",
            cancelButtonClass: "btn-danger",
            confirmButtonText: "Xác nhận",
            cancelButtonText: "Hủy bỏ",
        }).then(function (isConfirm) {
            if (isConfirm) {
                var ids = $('tbody input[type=checkbox]:checked').map(function () {
                    return $(this).val();
                }).get();
                deleteCustomer(ids);
            }
        });

        function deleteCustomer(data) {
            $.ajax({
                url: '${customerAPI}',
                type: 'DELETE',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (result) {
                    window.location.href = "${listCustomer}?page=1&limit=10&message=delete_success";
                },
                error: function (error) {
                    window.location.href = "${listCustomer}?page=1&limit=10&message=error_system";
                }
            });
        }
    }
</script>
</body>
</html>