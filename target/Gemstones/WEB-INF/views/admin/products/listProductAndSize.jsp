<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:url var="productAndSizeAPI" value="/api/product-productsize"/>
<c:url var="listProductAndSize" value="/quan-tri/san-pham/danh-sach-san-pham-day-du"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách sản phẩm đầy đủ</title>
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
                    <h3>Sản phẩm đầy đủ</h3>
                    <div class="title-bar-heading-action-container">
                        <a href="#" class="btn-null-background">
                            <i class="fas fa-arrow-down"></i> Xuất file excel</a>
                        <a href="#" class="btn-null-background">
                            <i class="fas fa-arrow-up"></i> Nhập danh sách</a>
                    </div>
                </div>
                <div class="title-bar-action">
                    <div class="align-center">
                        <a href="<c:url value="/quan-tri/san-pham/chinh-sua-san-pham-day-du"/>"
                           class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">Thêm sản
                            phẩm đầy đủ</a>
                    </div>
                    <div class="align-center">
                        <button value="Loại bỏ" type="button" id="btnDelete" onclick="warningBeforeDelete()"
                                class="d-none d-sm-inline-block btn btn-sm btn-secondary shadow-sm"> Loại bỏ
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
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" id="all-tab" data-toggle="tab" href="#all"
                           role="tab" aria-controls="all" aria-selected="true">Tất cả sản phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="male-tab" data-toggle="tab" href="#male"
                           role="tab" aria-controls="male" aria-selected="false">Sản phẩm cho nam</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="female-tab" data-toggle="tab" href="#female"
                           role="tab" aria-controls="female" aria-selected="false">Sản phẩm cho nữ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="active-tab" data-toggle="tab" href="#active"
                           role="tab" aria-controls="active" aria-selected="false">Đang hoạt động</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="inactive-tab" data-toggle="tab" href="#inactive"
                           role="tab" aria-controls="inactive" aria-selected="false">Ngừng hoạt động</a>
                    </li>
                </ul>
                <!--End Nav Button  -->
                <div class="input-group row" style="margin:20px 0px;">
                    <input id="search-input" class="form-control col-12 col-md-9" type="text" placeholder="Tìm kiếm..."
                           aria-label="Search"
                           aria-describedby="basic-addon2" autocomplete="off"
                           onkeypress="if(event.key === 'Enter') search()">
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
                            <form:option value="size-asc">Size tăng dần</form:option>
                            <form:option value="size-desc">Size giảm dần</form:option>
                        </form:select>
                    </form:form>
                </div>
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="all" role="tabpanel" aria-labelledby="all-tab">
                        <div class="table-responsive" id="nav-home">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" id="checkAll"></th>
                                    <th>Thao tác</th>
                                    <th style="width:100px;">Hình ảnh</th>
                                    <th>Tên Sản phẩm</th>
                                    <th>Giới tính</th>
                                    <th>Size</th>
                                    <th>Giá nhập</th>
                                    <th>Giá bán</th>
                                    <th>Giá thị trường</th>
                                    <th>Ngày lập</th>
                                    <th>Cập nhật lần cuối</th>
                                    <th>Trạng thái</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${model.listResult}">
                                    <tr>
                                        <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                        <td>
                                            <c:url var="updateProductAndSize"
                                                   value="/quan-tri/san-pham/chinh-sua-san-pham-day-du">
                                                <c:param name="id" value="${item.id}"/>
                                            </c:url>
                                            <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                               title="Cập nhật" href='${updateProductAndSize}'><i
                                                    class="fas fa-edit"></i>
                                            </a>
                                        </td>
                                        <td>
                                            <img alt="" src="<c:out value="${item.images}"/>"
                                                 style="float: left; height: 100px; width: 100px;">
                                        </td>
                                        <td>${item.product.name}</td>
                                        <td>${item.product.gender}</td>
                                        <td>${item.productSize.size}</td>
                                        <td>
                                            <fmt:setLocale value="de_DE" scope="session"/>
                                            <fmt:formatNumber type="currency" currencySymbol=""
                                                              maxFractionDigits="0"
                                                              value="${item.importPrice}"/>
                                        </td>
                                        <td>
                                            <fmt:setLocale value="de_DE" scope="session"/>
                                            <fmt:formatNumber type="currency" currencySymbol=""
                                                              maxFractionDigits="0"
                                                              value="${item.newPriceSale}"/>
                                        </td>
                                        <td>
                                            <fmt:setLocale value="de_DE" scope="session"/>
                                            <fmt:formatNumber type="currency" currencySymbol=""
                                                              maxFractionDigits="0"
                                                              value="${item.oldPriceSale}"/>
                                        </td>
                                        <td>${item.createdDate}</td>
                                        <td>${item.modifiedDate}</td>
                                        <td>${item.status}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="male" role="tabpanel"
                         aria-labelledby="male-tab">
                        <div class="table-responsive">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th><input type="checkbox"></th>
                                    <th>Thao tác</th>
                                    <th style="width:100px;">Hình ảnh</th>
                                    <th>Tên Sản phẩm</th>
                                    <th>Giới tính</th>
                                    <th>Size</th>
                                    <th>Giá nhập</th>
                                    <th>Giá bán</th>
                                    <th>Giá thị trường</th>
                                    <th>Ngày lập</th>
                                    <th>Cập nhật lần cuối</th>
                                    <th>Trạng thái</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${modelMale.listResult}">
                                    <tr>
                                        <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                        <td>
                                            <c:url var="updateProductAndSize"
                                                   value="/quan-tri/san-pham/chinh-sua-san-pham-day-du">
                                                <c:param name="id" value="${item.id}"/>
                                            </c:url>
                                            <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                               title="Cập nhật" href='${updateProductAndSize}'><i
                                                    class="fas fa-edit"></i>
                                            </a>
                                        </td>
                                        <td>
                                            <img alt="" src="<c:out value="${item.images}"/>"
                                                 style="float: left; height: 100px; width: 100px;">
                                        </td>
                                        <td>${item.product.name}</td>
                                        <td>${item.product.gender}</td>
                                        <td>${item.productSize.size}</td>
                                        <td>
                                            <fmt:setLocale value="de_DE" scope="session"/>
                                            <fmt:formatNumber type="currency" currencySymbol=""
                                                              maxFractionDigits="0"
                                                              value="${item.importPrice}"/>
                                        </td>
                                        <td>
                                            <fmt:setLocale value="de_DE" scope="session"/>
                                            <fmt:formatNumber type="currency" currencySymbol=""
                                                              maxFractionDigits="0"
                                                              value="${item.newPriceSale}"/>
                                        </td>
                                        <td>
                                            <fmt:setLocale value="de_DE" scope="session"/>
                                            <fmt:formatNumber type="currency" currencySymbol=""
                                                              maxFractionDigits="0"
                                                              value="${item.oldPriceSale}"/>
                                        </td>
                                        <td>${item.createdDate}</td>
                                        <td>${item.modifiedDate}</td>
                                        <td>${item.status}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="female" role="tabpanel"
                         aria-labelledby="female-tab">
                        <div class="table-responsive">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th><input type="checkbox"></th>
                                    <th>Thao tác</th>
                                    <th style="width:100px;">Hình ảnh</th>
                                    <th>Tên Sản phẩm</th>
                                    <th>Giới tính</th>
                                    <th>Size</th>
                                    <th>Giá nhập</th>
                                    <th>Giá bán</th>
                                    <th>Giá thị trường</th>
                                    <th>Ngày lập</th>
                                    <th>Cập nhật lần cuối</th>
                                    <th>Trạng thái</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${modelFemale.listResult}">
                                    <tr>
                                        <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                        <td>
                                            <c:url var="updateProductAndSize"
                                                   value="/quan-tri/san-pham/chinh-sua-san-pham-day-du">
                                                <c:param name="id" value="${item.id}"/>
                                            </c:url>
                                            <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                               title="Cập nhật" href='${updateProductAndSize}'><i
                                                    class="fas fa-edit"></i>
                                            </a>
                                        </td>
                                        <td>
                                            <img alt="" src="<c:out value="${item.images}"/>"
                                                 style="float: left; height: 100px; width: 100px;">
                                        </td>
                                        <td>${item.product.name}</td>
                                        <td>${item.product.gender}</td>
                                        <td>${item.productSize.size}</td>
                                        <td>
                                            <fmt:setLocale value="de_DE" scope="session"/>
                                            <fmt:formatNumber type="currency" currencySymbol=""
                                                              maxFractionDigits="0"
                                                              value="${item.importPrice}"/>
                                        </td>
                                        <td>
                                            <fmt:setLocale value="de_DE" scope="session"/>
                                            <fmt:formatNumber type="currency" currencySymbol=""
                                                              maxFractionDigits="0"
                                                              value="${item.newPriceSale}"/>
                                        </td>
                                        <td>
                                            <fmt:setLocale value="de_DE" scope="session"/>
                                            <fmt:formatNumber type="currency" currencySymbol=""
                                                              maxFractionDigits="0"
                                                              value="${item.oldPriceSale}"/>
                                        </td>
                                        <td>${item.createdDate}</td>
                                        <td>${item.modifiedDate}</td>
                                        <td>${item.status}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="active" role="tabpanel"
                         aria-labelledby="active-tab">
                        <div class="table-responsive">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th><input type="checkbox"></th>
                                    <th>Thao tác</th>
                                    <th style="width:100px;">Hình ảnh</th>
                                    <th>Tên Sản phẩm</th>
                                    <th>Giới tính</th>
                                    <th>Size</th>
                                    <th>Giá nhập</th>
                                    <th>Giá bán</th>
                                    <th>Giá thị trường</th>
                                    <th>Ngày lập</th>
                                    <th>Cập nhật lần cuối</th>
                                    <th>Trạng thái</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${modelActive.listResult}">
                                    <tr>
                                        <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                        <td>
                                            <c:url var="updateProductAndSize"
                                                   value="/quan-tri/san-pham/chinh-sua-san-pham-day-du">
                                                <c:param name="id" value="${item.id}"/>
                                            </c:url>
                                            <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                               title="Cập nhật" href='${updateProductAndSize}'><i
                                                    class="fas fa-edit"></i>
                                            </a>
                                        </td>
                                        <td>
                                            <img alt="" src="<c:out value="${item.images}"/>"
                                                 style="float: left; height: 100px; width: 100px;">
                                        </td>
                                        <td>${item.product.name}</td>
                                        <td>${item.product.gender}</td>
                                        <td>${item.productSize.size}</td>
                                        <td>
                                            <fmt:setLocale value="de_DE" scope="session"/>
                                            <fmt:formatNumber type="currency" currencySymbol=""
                                                              maxFractionDigits="0"
                                                              value="${item.importPrice}"/>
                                        </td>
                                        <td>
                                            <fmt:setLocale value="de_DE" scope="session"/>
                                            <fmt:formatNumber type="currency" currencySymbol=""
                                                              maxFractionDigits="0"
                                                              value="${item.newPriceSale}"/>
                                        </td>
                                        <td>
                                            <fmt:setLocale value="de_DE" scope="session"/>
                                            <fmt:formatNumber type="currency" currencySymbol=""
                                                              maxFractionDigits="0"
                                                              value="${item.oldPriceSale}"/>
                                        </td>
                                        <td>${item.createdDate}</td>
                                        <td>${item.modifiedDate}</td>
                                        <td>${item.status}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="inactive" role="tabpanel"
                         aria-labelledby="inactive-tab">
                        <div class="table-responsive">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th><input type="checkbox"></th>
                                    <th>Thao tác</th>
                                    <th style="width:100px;">Hình ảnh</th>
                                    <th>Tên Sản phẩm</th>
                                    <th>Giới tính</th>
                                    <th>Size</th>
                                    <th>Giá nhập</th>
                                    <th>Giá bán</th>
                                    <th>Giá thị trường</th>
                                    <th>Ngày lập</th>
                                    <th>Cập nhật lần cuối</th>
                                    <th>Trạng thái</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${modelInactive.listResult}">
                                    <tr>
                                        <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                        <td>
                                            <c:url var="updateProductAndSize"
                                                   value="/quan-tri/san-pham/chinh-sua-san-pham-day-du">
                                                <c:param name="id" value="${item.id}"/>
                                            </c:url>
                                            <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                               title="Cập nhật" href='${updateProductAndSize}'><i
                                                    class="fas fa-edit"></i>
                                            </a>
                                        </td>
                                        <td>
                                            <img alt="" src="<c:out value="${item.images}"/>"
                                                 style="float: left; height: 100px; width: 100px;">
                                        </td>
                                        <td>${item.product.name}</td>
                                        <td>${item.product.gender}</td>
                                        <td>${item.productSize.size}</td>
                                        <td>
                                            <fmt:setLocale value="de_DE" scope="session"/>
                                            <fmt:formatNumber type="currency" currencySymbol=""
                                                              maxFractionDigits="0"
                                                              value="${item.importPrice}"/>
                                        </td>
                                        <td>
                                            <fmt:setLocale value="de_DE" scope="session"/>
                                            <fmt:formatNumber type="currency" currencySymbol=""
                                                              maxFractionDigits="0"
                                                              value="${item.newPriceSale}"/>
                                        </td>
                                        <td>
                                            <fmt:setLocale value="de_DE" scope="session"/>
                                            <fmt:formatNumber type="currency" currencySymbol=""
                                                              maxFractionDigits="0"
                                                              value="${item.oldPriceSale}"/>
                                        </td>
                                        <td>${item.createdDate}</td>
                                        <td>${item.modifiedDate}</td>
                                        <td>${item.status}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="align-center">
                    <ul class="pagination" id="pagination"></ul>
                    <input type="hidden" value="" id="page" name="page"/>
                    <input type="hidden" value="" id="limit" name="limit"/>
                </div>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript">
    /*Full model*/
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

    /*End Full model*/

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
                deleteProduct(ids);
            }
        });

        function deleteProduct(data) {
            $.ajax({
                url: '${productAndSizeAPI}',
                type: 'DELETE',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (result) {
                    window.location.href = "${listProductAndSize}?page=1&limit=10&message=delete_success";
                },
                error: function (error) {
                    window.location.href = "${listProductAndSize}?page=1&limit=10&message=error_system";
                }
            });
        }

    }

    /* function filter_productSize(obj) {
         var value = obj.value;

         var link = location.href.split("/")[5];
         if (link.includes("orderby")) {
             window.location = link.split("&orderby")[0] + "&orderby=" + value;
         } else {
             window.location = link + "&orderby=" + value;
         }
     }

     function search() {
         var searchText = $('#search-input').val();

         var link =  location.href.split("/")[5];
         var xx = link + "&tim-kiem=" + searchText;
         if (link.includes("tim-kiem")) {
             window.location = link.split("&tim-kiem")[0] + "&tim-kiem=" + searchText;
         } else {
             window.location = link + "&tim-kiem=" + searchText;
         }
     }

     $('#formSubmit').keypress(function(event)
     {
         if (event.keyCode == 13)
         {
             event.preventDefault();
         }
     });*/
</script>
</body>
</html>