<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:url var="productAPI" value="/api/product"/>
<c:url var="listProduct" value="/quan-tri/san-pham/danh-sach"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách sản phẩm</title>
</head>
<%--<body>
<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center mb-4">
        <div>
            <c:if test="${not empty message}">
                <div class="alert alert-${alert}">
                    <strong>${message}</strong>
                </div>
            </c:if>
            <h1 class="h3 mb-0 text-gray-800">Sản phẩm</h1>
            <a href="<c:url value="/quan-tri/san-pham/chinh-sua"/>"
               class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                    class="fa fa-plus-circle bigger-110 purple"></i> Thêm mới</a>
            <button value="Loại bỏ" type="button" id="btnDelete" onclick="warningBeforeDelete()" class="d-none d-sm-inline-block btn btn-sm btn-secondary shadow-sm"><i
                    class="fa fa-trash-o bigger-110 pink"></i> Loại bỏ</button>
        </div>
    </div>
    <form action="<c:url value="/quan-tri/san-pham/danh-sach"/>" id="formSubmit" method="get">
        <legend>Danh sách sản phẩm</legend>
        <div class="row">
            <div class="col-xs-12">
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th><input type="checkbox" id="checkAll"></th>
                            <th>Tên sản phẩm</th>
                            <th>Loại sản phẩm</th>
                            <th>Giá gốc</th>
                            <th>Giá bán</th>
                            <th>Mô tả thêm</th>
                            <th>Ngày tạo</th>
                            <th>Người tạo</th>
                            <th>Ảnh</th>
                            <th>Thao tác</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${model.listResult}">
                            <tr>
                                <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                <td>${item.name}</td>
                                <td>${item.typeProductName}</td>
                                <td>${item.purchase_price}</td>
                                <td>${item.sale_price}</td>
                                <td>${item.description}</td>
                                <td>${item.createdDate}</td>
                                <td>${item.createdBy}</td>
                                <td>
                                    <img alt="" src="data:image/jpeg;base64,<c:out value="${item.images}"/>" style="float: left; max-height: 100px;">
                                  &lt;%&ndash;  <img alt="Image" src="data:image/jpeg;base64,new String(${item.images})" />&ndash;%&gt;
                                </td>
                                <td>
                                    <c:url var="updateProductURL" value="/quan-tri/san-pham/chinh-sua">
                                        <c:param name="id" value="${item.id}"/>
                                    </c:url>
                                    <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                       title="Cập nhật sản phẩm" href='${updateProductURL}'><i class="fa fa-pencil-square-o" aria-hidden="true">Cập nhật</i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                    <ul class="pagination" id="pagination"></ul>
                    <input type="hidden" value="" id="page" name="page"/>
                    <input type="hidden" value="" id="limit" name="limit"/>
                </div>
            </div>
        </div>
    </form>


</div>
<!-- /.container-fluid -->
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
        }).then(function(isConfirm) {
            if (isConfirm) {
                var ids = $('tbody input[type=checkbox]:checked').map(function () {
                    return $(this).val();
                }).get();
                deleteProduct(ids);
            }
        });

        function deleteProduct(data) {
            $.ajax({
                url: '${productAPI}',
                type: 'DELETE',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (result) {
                    window.location.href = "${listProduct}?page=1&limit=10&message=delete_success";
                },
                error: function (error) {
                    window.location.href = "${listProduct}?page=1&limit=10&message=error_system";
                }
            });
        }
    }
</script>
</body>--%>
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
                    <h3>Sản phẩm</h3>
                    <div class="title-bar-heading-action-container">
                        <a href="#" class="btn-null-background">
                            <i class="fas fa-arrow-down"></i> Xuất file excel</a>
                        <a href="#" class="btn-null-background">
                            <i class="fas fa-arrow-up"></i> Nhập danh sách</a>
                    </div>
                </div>
                <div class="title-bar-action">
                    <div class="align-center">
                        <a href="<c:url value="/quan-tri/san-pham/chinh-sua-san-pham"/>"
                           class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">Thêm sản
                            phẩm</a>
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
                        <a class="nav-link" id="newRelease-tab" data-toggle="tab" href="#newRelease"
                           role="tab" aria-controls="newRelease" aria-selected="false">Mới nhất</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="bestSeller-tab" data-toggle="tab" href="#bestSeller"
                           role="tab" aria-controls="bestSeller" aria-selected="false">Bán chạy</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="hotTrend-tab" data-toggle="tab" href="#hotTrend"
                           role="tab" aria-controls="hotTrend" aria-selected="false">Ưa chuộng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="seasonal-tab" data-toggle="tab" href="#seasonal"
                           role="tab" aria-controls="seasonal" aria-selected="false">Theo mùa</a>
                    </li>
                </ul>
                <!--End Nav Button  -->
                <div class="input-group row" style="margin:20px 0px;">
                    <input id="search-input" autocomplete="off" class="form-control col-12 col-md-9" type="text"
                           placeholder="Tìm kiếm..."
                           aria-label="Search" onkeypress="if(event.key === 'Enter') search()"
                           aria-describedby="basic-addon2">
                    <div class="input-group-append ">
                        <button class="btn btn-primary" type="button" onclick="search()">
                            <svg class="svg-inline--fa fa-search fa-w-16" aria-hidden="true" focusable="false"
                                 data-prefix="fas" data-icon="search" role="img" xmlns="http://www.w3.org/2000/svg"
                                 viewBox="0 0 512 512" data-fa-i2svg="">
                                <path fill="currentColor"
                                      d="M505 442.7L405.3 343c-4.5-4.5-10.6-7-17-7H372c27.6-35.3 44-79.7 44-128C416 93.1 322.9 0 208 0S0 93.1 0 208s93.1 208 208 208c48.3 0 92.7-16.4 128-44v16.3c0 6.4 2.5 12.5 7 17l99.7 99.7c9.4 9.4 24.6 9.4 33.9 0l28.3-28.3c9.4-9.4 9.4-24.6.1-34zM208 336c-70.7 0-128-57.2-128-128 0-70.7 57.2-128 128-128 70.7 0 128 57.2 128 128 0 70.7-57.2 128-128 128z"></path>
                            </svg><!-- <i class="fas fa-search"></i> --></button>
                    </div>
                    <%--    <select class="form-control col-12 col-md-2" style="margin-left: 5%">
                            <option value="default" label="Mặc định"></option>
                            <option value="asc">A &rarr; Z</option>
                            <option value="desc">Z &rarr; A</option>
                            <option value="price-asc">Ngày tăng dần</option>
                            <option value="price-desc">Ngày giảm dần</option>
                        </select>--%>
                    <form:form action=""
                               id="formOrderBy" method="get"
                               modelAttribute="model" enctype="multipart/form-data">
                        <form:select onchange="filter_product(this)" path="orderBy" cssStyle="margin-left: 5%"
                                     class="form-control col-12 col-md-2">
                            <form:option value="asc" label="Mặc định"></form:option>
                            <form:option value="asc">A &rarr; Z</form:option>
                            <form:option value="desc">Z &rarr; A</form:option>
                        </form:select>
                    </form:form>
                </div>

                <%--Content--%>
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="all" role="tabpanel" aria-labelledby="all-tab">
                        <div class="table-responsive" id="nav-home">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" id="checkAll"></th>
                                    <th>Tên Sản phẩm</th>
                                    <th>Giới tính</th>
                                    <th>Tổng size HĐ</th>
                                    <th>Mới ra mắt</th>
                                    <th>Bán chạy</th>
                                    <th>Ưa chuộng</th>
                                    <th>Theo mùa</th>
                                    <th>Cập nhật lần cuối</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${model.listResult}">
                                    <tr>
                                        <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                        <td>${item.name}</td>
                                        <td>${item.gender}</td>
                                        <td>${item.totalProductSize}</td>
                                        <c:if test="${item.newRelease == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.newRelease == false}">
                                            <td></td>
                                        </c:if>
                                        <c:if test="${item.bestSeller == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.bestSeller == false}">
                                            <td></td>
                                        </c:if>
                                        <c:if test="${item.hotTrend == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.hotTrend == false}">
                                            <td></td>
                                        </c:if>
                                        <c:if test="${item.seasonal == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.seasonal == false}">
                                            <td></td>
                                        </c:if>
                                        <td>${item.modifiedDate}</td>
                                        <td>
                                            <c:url var="updateProduct" value="/quan-tri/san-pham/chinh-sua-san-pham">
                                                <c:param name="id" value="${item.id}"/>
                                            </c:url>
                                            <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                               title="Cập nhật" href='${updateProduct}'><i class="fas fa-edit"></i>
                                            </a>
                                        </td>
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
                                    <th>Tên Sản phẩm</th>
                                    <th>Giới tính</th>
                                    <th>Mới ra mắt</th>
                                    <th>Bán chạy</th>
                                    <th>Ưa chuộng</th>
                                    <th>Theo mùa</th>
                                    <th>Cập nhật lần cuối</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${modelMale.listResult}">
                                    <tr>
                                        <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                        <td>${item.name}</td>
                                        <td>${item.gender}</td>
                                        <c:if test="${item.newRelease == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.newRelease == false}">
                                            <td></td>
                                        </c:if>
                                        <c:if test="${item.bestSeller == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.bestSeller == false}">
                                            <td></td>
                                        </c:if>
                                        <c:if test="${item.hotTrend == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.hotTrend == false}">
                                            <td></td>
                                        </c:if>
                                        <c:if test="${item.seasonal == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.seasonal == false}">
                                            <td></td>
                                        </c:if>
                                        <td>${item.modifiedDate}</td>
                                        <td>
                                            <c:url var="updateProduct" value="/quan-tri/san-pham/chinh-sua-san-pham">
                                                <c:param name="id" value="${item.id}"/>
                                            </c:url>
                                            <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                               title="Cập nhật" href='${updateProduct}'><i class="fas fa-edit"></i>
                                            </a>
                                        </td>
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
                                    <%--<th style="width:40px;"></th>--%>
                                    <th>Tên Sản phẩm</th>
                                    <th>Giới tính</th>
                                    <th>Mới ra mắt</th>
                                    <th>Bán chạy</th>
                                    <th>Ưa chuộng</th>
                                    <th>Theo mùa</th>
                                    <th>Cập nhật lần cuối</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${modelFemale.listResult}">
                                    <tr>
                                        <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                            <%-- <td>
                                                 <img alt="" src="data:image/jpeg;base64,<c:out value="${item.images}"/>"
                                                      style="float: left; height: 40px; width: 40px;">
                                             </td>--%>
                                        <td>${item.name}</td>
                                        <td>${item.gender}</td>
                                        <c:if test="${item.newRelease == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.newRelease == false}">
                                            <td></td>
                                        </c:if>
                                        <c:if test="${item.bestSeller == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.bestSeller == false}">
                                            <td></td>
                                        </c:if>
                                        <c:if test="${item.hotTrend == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.hotTrend == false}">
                                            <td></td>
                                        </c:if>
                                        <c:if test="${item.seasonal == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.seasonal == false}">
                                            <td></td>
                                        </c:if>
                                        <td>${item.modifiedDate}</td>
                                        <td>
                                            <c:url var="updateProduct" value="/quan-tri/san-pham/chinh-sua-san-pham">
                                                <c:param name="id" value="${item.id}"/>
                                            </c:url>
                                            <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                               title="Cập nhật" href='${updateProduct}'><i class="fas fa-edit"></i>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>

                        </div>
                    </div>
                    <div class="tab-pane fade" id="newRelease" role="tabpanel"
                         aria-labelledby="newRelease-tab">
                        <div class="table-responsive">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th><input type="checkbox"></th>
                                    <%--<th style="width:40px;"></th>--%>
                                    <th>Tên Sản phẩm</th>
                                    <th>Giới tính</th>
                                    <th>Mới ra mắt</th>
                                    <th>Bán chạy</th>
                                    <th>Ưa chuộng</th>
                                    <th>Theo mùa</th>
                                    <th>Cập nhật lần cuối</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${modelNewRelease.listResult}">
                                    <tr>
                                        <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                            <%-- <td>
                                                 <img alt="" src="data:image/jpeg;base64,<c:out value="${item.images}"/>"
                                                      style="float: left; height: 40px; width: 40px;">
                                             </td>--%>
                                        <td>${item.name}</td>
                                        <td>${item.gender}</td>
                                        <c:if test="${item.newRelease == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.newRelease == false}">
                                            <td></td>
                                        </c:if>
                                        <c:if test="${item.bestSeller == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.bestSeller == false}">
                                            <td></td>
                                        </c:if>
                                        <c:if test="${item.hotTrend == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.hotTrend == false}">
                                            <td></td>
                                        </c:if>
                                        <c:if test="${item.seasonal == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.seasonal == false}">
                                            <td></td>
                                        </c:if>
                                        <td>${item.modifiedDate}</td>
                                        <td>
                                            <c:url var="updateProduct" value="/quan-tri/san-pham/chinh-sua-san-pham">
                                                <c:param name="id" value="${item.id}"/>
                                            </c:url>
                                            <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                               title="Cập nhật" href='${updateProduct}'><i class="fas fa-edit"></i>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>

                        </div>
                    </div>
                    <div class="tab-pane fade" id="bestSeller" role="tabpanel"
                         aria-labelledby="bestSeller-tab">
                        <div class="table-responsive">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th><input type="checkbox"></th>
                                    <%--<th style="width:40px;"></th>--%>
                                    <th>Tên Sản phẩm</th>
                                    <th>Giới tính</th>
                                    <th>Mới ra mắt</th>
                                    <th>Bán chạy</th>
                                    <th>Ưa chuộng</th>
                                    <th>Theo mùa</th>
                                    <th>Cập nhật lần cuối</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${modelBestSeller.listResult}">
                                    <tr>
                                        <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                            <%-- <td>
                                                 <img alt="" src="data:image/jpeg;base64,<c:out value="${item.images}"/>"
                                                      style="float: left; height: 40px; width: 40px;">
                                             </td>--%>
                                        <td>${item.name}</td>
                                        <td>${item.gender}</td>
                                        <c:if test="${item.newRelease == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.newRelease == false}">
                                            <td></td>
                                        </c:if>
                                        <c:if test="${item.bestSeller == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.bestSeller == false}">
                                            <td></td>
                                        </c:if>
                                        <c:if test="${item.hotTrend == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.hotTrend == false}">
                                            <td></td>
                                        </c:if>
                                        <c:if test="${item.seasonal == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.seasonal == false}">
                                            <td></td>
                                        </c:if>
                                        <td>${item.modifiedDate}</td>
                                        <td>
                                            <c:url var="updateProduct" value="/quan-tri/san-pham/chinh-sua-san-pham">
                                                <c:param name="id" value="${item.id}"/>
                                            </c:url>
                                            <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                               title="Cập nhật" href='${updateProduct}'><i class="fas fa-edit"></i>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>

                        </div>
                    </div>
                    <div class="tab-pane fade" id="hotTrend" role="tabpanel"
                         aria-labelledby="hotTrend-tab">
                        <div class="table-responsive">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th><input type="checkbox"></th>
                                    <%--<th style="width:40px;"></th>--%>
                                    <th>Tên Sản phẩm</th>
                                    <th>Giới tính</th>
                                    <th>Mới ra mắt</th>
                                    <th>Bán chạy</th>
                                    <th>Ưa chuộng</th>
                                    <th>Theo mùa</th>
                                    <th>Cập nhật lần cuối</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${modelHotTrend.listResult}">
                                    <tr>
                                        <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                            <%-- <td>
                                                 <img alt="" src="data:image/jpeg;base64,<c:out value="${item.images}"/>"
                                                      style="float: left; height: 40px; width: 40px;">
                                             </td>--%>
                                        <td>${item.name}</td>
                                        <td>${item.gender}</td>
                                        <c:if test="${item.newRelease == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.newRelease == false}">
                                            <td></td>
                                        </c:if>
                                        <c:if test="${item.bestSeller == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.bestSeller == false}">
                                            <td></td>
                                        </c:if>
                                        <c:if test="${item.hotTrend == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.hotTrend == false}">
                                            <td></td>
                                        </c:if>
                                        <c:if test="${item.seasonal == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.seasonal == false}">
                                            <td></td>
                                        </c:if>
                                        <td>${item.modifiedDate}</td>
                                        <td>
                                            <c:url var="updateProduct" value="/quan-tri/san-pham/chinh-sua-san-pham">
                                                <c:param name="id" value="${item.id}"/>
                                            </c:url>
                                            <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                               title="Cập nhật" href='${updateProduct}'><i class="fas fa-edit"></i>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>

                        </div>
                    </div>
                    <div class="tab-pane fade" id="seasonal" role="tabpanel"
                         aria-labelledby="seasonal-tab">
                        <div class="table-responsive">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th><input type="checkbox"></th>
                                    <%--<th style="width:40px;"></th>--%>
                                    <th>Tên Sản phẩm</th>
                                    <th>Giới tính</th>
                                    <th>Mới ra mắt</th>
                                    <th>Bán chạy</th>
                                    <th>Ưa chuộng</th>
                                    <th>Theo mùa</th>
                                    <th>Cập nhật lần cuối</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${modelSeasonal.listResult}">
                                    <tr>
                                        <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                            <%-- <td>
                                                 <img alt="" src="data:image/jpeg;base64,<c:out value="${item.images}"/>"
                                                      style="float: left; height: 40px; width: 40px;">
                                             </td>--%>
                                        <td>${item.name}</td>
                                        <td>${item.gender}</td>
                                        <c:if test="${item.newRelease == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.newRelease == false}">
                                            <td></td>
                                        </c:if>
                                        <c:if test="${item.bestSeller == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.bestSeller == false}">
                                            <td></td>
                                        </c:if>
                                        <c:if test="${item.hotTrend == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.hotTrend == false}">
                                            <td></td>
                                        </c:if>
                                        <c:if test="${item.seasonal == true}">
                                            <td><i class="fas fa-check"></i></td>
                                        </c:if>
                                        <c:if test="${item.seasonal == false}">
                                            <td></td>
                                        </c:if>
                                        <td>${item.modifiedDate}</td>
                                        <td>
                                            <c:url var="updateProduct" value="/quan-tri/san-pham/chinh-sua-san-pham">
                                                <c:param name="id" value="${item.id}"/>
                                            </c:url>
                                            <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                               title="Cập nhật" href='${updateProduct}'><i class="fas fa-edit"></i>
                                            </a>
                                        </td>
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
                deleteProduct(ids);
            }
        });

        function deleteProduct(data) {
            $.ajax({
                url: '${productAPI}',
                type: 'DELETE',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (result) {
                    window.location.href = "${listProduct}?page=1&limit=10&message=delete_success";
                },
                error: function (error) {
                    window.location.href = "${listProduct}?page=1&limit=10&message=error_system";
                }
            });
        }
    }


</script>
</body>
</html>