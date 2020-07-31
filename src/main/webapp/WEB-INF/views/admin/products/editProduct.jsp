<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:url var="listProduct" value="/quan-tri/san-pham/danh-sach"/>
<c:url var="editProduct" value="/quan-tri/san-pham/chinh-sua-san-pham"/>
<c:url var="productAPI" value="/api/product"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Chỉnh sửa sản phẩm</title>
</head>
<body>

<!-- Begin Page Content -->
<div class="container">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center mb-4" style="margin-top: 40px">
        <div>
            <c:if test="${not empty message}">
                <div class="alert alert-${alert}">
                    <strong>${message}</strong>
                </div>
            </c:if>
            <c:if test="${not empty model.id}">
                <h1 class="h3 mb-0 text-gray-800">Cập nhật sản phẩm</h1>
            </c:if>
            <c:if test="${empty model.id}">
                <h1 class="h3 mb-0 text-gray-800">Thêm sản phẩm mới</h1>
            </c:if>
        </div>
    </div>
    <%--    <form action="<c:url value='/quan-tri/san-pham/danh-sach'/>" id="formSubmit" method="get">--%>
    <form:form action="<c:url value='/quan-tri/san-pham/chinh-sua-san-pham' />" id="formSubmit" method="get"
               modelAttribute="model" style=" margin: 50px 0px 50px 0px" enctype="multipart/form-data">
        <div class="row">
            <div class="form-group col-lg-6">
                <label for="InputName">Tên sản phẩm</label>
                <form:input type="text" class="form-control test" id="InputName" path="name"
                            placeholder="Nhập tên sản phẩm"/>
            </div>
            <div class="form-group col-lg-6">
                <label for="gender">Giới tính</label>
                <form:select class="form-control test" id="gender" path="gender">
                    <form:option value="" label="--Chọn giới tính--"></form:option>
                    <form:option value="Nam" label="Nam"></form:option>
                    <form:option value="Nữ" label="Nữ"></form:option>
                </form:select>
            </div>
            <div class="form-group col-md-6">
                <label for="longevity">Độ lưu hương</label>
                <form:input type="text" class="form-control" id="longevity" path="longevity"
                            placeholder="Độ lưu hương"/>
            </div>
            <div class="form-group col-md-6">
                <label for="style">Phong cách</label>
                <form:input type="text" class="form-control" id="style" path="style"
                            placeholder="Phong cách"/>
            </div>
            <div class="form-group col-md-6">
                <label for="incenseGroupId">Chọn nhóm hương</label>
                <form:select class="form-control" id="incenseGroupId" path="incenseGroupId">
                    <form:option value="" label="--Chọn nhóm hương--"></form:option>
                    <form:options items="${listIncenseGroup}" itemValue="id"
                                  itemLabel="name"/>
                </form:select>
            </div>
            <div class="form-group col-md-6">
            </div>
            <div class="form-group col-md-6">
                <label for="newRelease">Sản phẩm mới ra mắt</label>
                <form:checkbox style="width:10%" path="newRelease" class="form-control" id="newRelease"/>
            </div>
            <div class="form-group col-md-6">
                <label for="hotTrend">Sản phẩm được ưa chuộng</label>
                <form:checkbox style="width:10%" path="hotTrend" class="form-control" id="hotTrend"/>
            </div>
            <div class="form-group col-md-6">
                <label for="bestSeller">Sản phẩm bán chạy nhất</label>
                <form:checkbox style="width:10%" path="bestSeller" class="form-control" id="bestSeller"/>
            </div>
            <div class="form-group col-md-6">
                <label for="seasonal">Sản phẩm theo mùa</label>
                <form:checkbox style="width:10%" path="seasonal" class="form-control" id="seasonal"/>
            </div>
            <div class="form-group col-md-12">
                <label for="description">Mô tả</label>
                <textarea class="form-control" id="description" name="description" placeholder="Nhập mô tả">${model.description}</textarea>
                    <%-- <form:input type="text" class="form-control" id="description"
                                 path="description" placeholder="Nhập mô tả"/>--%>
            </div>
        </div>

        <form:hidden path="id" id="productId"/>
    </form:form>

    <div class="form-group" style="width:500px; margin: 15px 15px 50px 50px">
        <c:if test="${ not empty model.id }">
            <input type="button"
                   class="btn btn-primary"
                   value="Cập nhật" id="AddOrUpdateProduct"/>
        </c:if>
        <c:if test="${empty model.id }">
            <input type="button"
                   class="btn btn-primary"
                   value="Thêm mới" id="AddOrUpdateProduct"/>
        </c:if>
    </div>

</div>
<!-- /.container-fluid -->
<script type="text/javascript">

    /*  const inpFile = document.getElementById("InputImages");
      const previewContainer = document.getElementById("imagePreview");
      const previewImage = previewContainer.querySelector(".image-preview-image");
      const previewDefaultText = previewContainer.querySelector(".image-preview-default-text");

      inpFile.addEventListener("change", function () {
          const file = this.files[0];

          if (file) {
              const reader = new FileReader();

              previewDefaultText.style.display = "none";
              previewImage.style.display = "block";

              reader.addEventListener("load", function () {
                  previewImage.setAttribute("src", this.result);
              });

              reader.readAsDataURL(file);
          } else {
              previewDefaultText.style.display = null;
              previewImage.style.display = null;
              previewImage.setAttribute("src", "");
          }
      });*/

    /* $('#AddOrUpdateProduct').click(function (e) {
         e.preventDefault();
         var data = {};
         var formData = $('#formSubmit').serializeArray();

         $.each(formData, function (i, v) {
             data["" + v.name + ""] = v.value;
         });
         var files = $('#InputImages')[0].files[0];
         if (files !== undefined) {
             var reader = new FileReader();
             reader.readAsDataURL(files);

             reader.onload = function (e) {
                 data["test"] = files.name;
                 data["images"] = e.target.result;
                 var id = $('#productId').val();
                 if (id == "") {
                     addProduct(data);
                 } else {
                     updateProduct(data);
                 }
             };

         } else {
             var id = $('#productId').val();
             if (id == "") {
                 addProduct(data);
             } else {
                 updateProduct(data);
             }
         }

     });*/
    var editor = "";
    $(document).ready(function () {
        editor = CKEDITOR.replace('description')
    });

    $('#AddOrUpdateProduct').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();

        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });
        data["description"] = editor.getData();
        var id = $('#productId').val();
        if (id == "") {
            addProduct(data);
        } else {
            updateProduct(data);
        }

    });

    function addProduct(data) {
        $.ajax({
            url: '${productAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editProduct}?id=" + result.id + "&message=insert_success";
            },
            error: function (error) {
                window.location.href = "${listProduct}?page=1&limit=10&message=error_system";
                console.log(error);
            }
        });
    }

    function updateProduct(data) {
        $.ajax({
            url: '${productAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editProduct}?id=" + result.id + "&message=update_success";
            },
            error: function (error) {
                window.location.href = "${editProduct}?id=" + error.id + "&message=error_system";
            }
        });
    }
</script>
</body>
</html>