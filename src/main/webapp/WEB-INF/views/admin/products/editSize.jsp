<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:url var="listProductSize" value="/quan-tri/san-pham/danh-sach-size"/>
<c:url var="editProductSize" value="/quan-tri/san-pham/chinh-sua-size"/>
<c:url var="productSizeAPI" value="/api/product-size"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Chỉnh sửa size sản phẩm</title>
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
                <h1 class="h3 mb-0 text-gray-800">Cập nhật size</h1>
            </c:if>
            <c:if test="${empty model.id}">
                <h1 class="h3 mb-0 text-gray-800">Thêm size mới</h1>
            </c:if>
        </div>
    </div>
    <%--    <form action="<c:url value='/quan-tri/san-pham/danh-sach'/>" id="formSubmit" method="get">--%>
    <form:form action="<c:url value='/quan-tri/san-pham/chinh-sua-size'/>" id="formSubmit" method="get"
               modelAttribute="model" style=" margin: 50px 0px 50px 0px" enctype="multipart/form-data">
        <div class="row">
            <div class="form-group col-md-6">
                <label for="InputName">Tên size</label>
                <form:input type="text" class="form-control test" id="InputName" path="size"
                            placeholder="Nhập tên size"/>
            </div>
        </div>
        <form:hidden path="id" id="productSizeId"/>
    </form:form>


    <%-- <input type="file" id="InputImages" style="width:500px; margin: 15px 15px 50px 0px"/>
     <div class="image-preview" id="imagePreview"
          style="width: 300px; min-height: 200px; border: 2px solid #dddddd; margin: 15px 15px 50px 0px">
         <c:if test="${empty model.images}">
             <img src="" alt="Image Preview" class="image-preview-image" style="display: none;width: 100%">
             <span class="image-preview-default-text"
                   style="display: flex;align-items: center; justify-content: center;font-weight: bold; color: #CCCCCC">Image Preview</span>
         </c:if>

         <c:if test="${not empty model.images}">
             <img src="data:image/jpeg;base64,<c:out value="${model.images}"/>" alt="Image Preview" class="image-preview-image" style="display: block;width: 100%">
             <span class="image-preview-default-text"
                   style="display: none;align-items: center; justify-content: center;font-weight: bold; color: #CCCCCC">Image Preview</span>
         </c:if>
     </div>--%>
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

    $('#AddOrUpdateProduct').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();

        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });

        var id = $('#productId').val();
        if (id == "") {
            addProductSize(data);
        } else {
            updateProductSize(data);
        }

    });

    function addProductSize(data) {
        $.ajax({
            url: '${productSizeAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editProductSize}?id=" + result.id + "&message=insert_success";
            },
            error: function (error) {
                window.location.href = "${listProductSize}?page=1&limit=10&message=error_system";
                console.log(error);
            }
        });
    }

    function updateProductSize(data) {
        $.ajax({
            url: '${productSizeAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editProductSize}?id=" + result.id + "&message=update_success";
            },
            error: function (error) {
                window.location.href = "${editProductSize}?id=" + error.id + "&message=error_system";
            }
        });
    }
</script>
</body>
</html>