<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:url var="listBlog" value="/quan-tri/blog/danh-sach-blog"/>
<c:url var="editBlog" value="/quan-tri/blog/chinh-sua-blog"/>
<c:url var="blogAPI" value="/api/blog"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Chỉnh sửa Blog</title>
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
                <h1 class="h3 mb-0 text-gray-800">Cập nhật bài viết</h1>
            </c:if>
            <c:if test="${empty model.id}">
                <h1 class="h3 mb-0 text-gray-800">Thêm bài viết mới</h1>
            </c:if>
        </div>
    </div>
    <%--    <form action="<c:url value='/quan-tri/san-pham/danh-sach'/>" id="formSubmit" method="get">--%>
    <form:form action="<c:url value='/quan-tri/blog/danh-sach-blog' />" id="formSubmit" method="get"
               modelAttribute="model" style=" margin: 50px 0px 50px 0px" enctype="multipart/form-data">
        <div class="row">
            <div class="form-group col-md-6">
                <label for="title">Tiêu đề</label>
                <form:input type="text" class="form-control" id="title" path="title"
                            placeholder="Tiêu đề"/>
            </div>
            <div class="form-group col-md-6">
                <label for="shortDescription">Mô tả ngắn</label>
                <form:textarea type="text" class="form-control" id="shortDescription" path="shortDescription"
                            placeholder="Mô tả ngắn"/>
            </div>
            <div class="form-group col-md-6">
                <label for="typeBlog">Loại bài viết</label>
                <form:select class="form-control test" id="typeBlog" path="typeBlog">
                    <form:option value="" label="--Chọn loại bài viết--"></form:option>
                    <form:option value="Kiến thức nước hoa" label="Kiến thức nước hoa"></form:option>
                    <form:option value="Review nước hoa" label="Review nước hoa"></form:option>
                </form:select>
            </div>
            <div class="form-group col-md-12">
                <label for="description">Nội dung</label>
                <textarea class="form-control" id="description" name="description" placeholder="Nhập mô tả">${model.content}</textarea>
            </div>
        </div>

        <form:hidden path="id" id="productAndSizeId"/>
    </form:form>

    <%--Upload ảnh--%>
    <input type="file" id="InputImages" style="width:500px; margin: 15px 15px 50px 0px"/>
    <div class="image-preview" id="imagePreview"
         style="width: 300px; min-height: 200px; border: 2px solid #dddddd; margin: 15px 15px 50px 0px">
        <c:if test="${empty model.thumbnail}">
            <img src="" alt="Image Preview"
                 class="image-preview-image" style="display: none;width: 100%">
            <span class="image-preview-default-text"
                  style="display: flex;align-items: center; justify-content: center;font-weight: bold; color: #CCCCCC">Image Preview</span>
        </c:if>

        <c:if test="${not empty model.thumbnail}">
            <img src="<c:out value="${model.thumbnail}"/>" alt="Image Preview"
                 class="image-preview-image" style="display: block;width: 100%">
            <span class="image-preview-default-text"
                  style="display: none;align-items: center; justify-content: center;font-weight: bold; color: #CCCCCC">Image Preview</span>
        </c:if>
    </div>


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

    var editor = "";
    $(document).ready(function () {
        editor = CKEDITOR.replace('description')
    });

    const inpFile = document.getElementById("InputImages");
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
    });


    $('#AddOrUpdateProduct').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();

        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });

        data["content"] = editor.getData();
        var files = $('#InputImages')[0].files[0];
        if (files !== undefined) {
            var reader = new FileReader();
            reader.readAsDataURL(files);

            reader.onload = function (e) {
                //data["test"] = files.name;
                data["thumbnail"] = e.target.result;
                var id = $('#productAndSizeId').val();
                if (id == "") {
                    addProductAndSize(data);
                } else {
                    updateProductAndSize(data);
                }
            };

        }else{
            var id = $('#productAndSizeId').val();
            if (id == "") {
                addProductAndSize(data);
            } else {
                updateProductAndSize(data);
            }
        }


    });

    /*$('#AddOrUpdateProduct').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();

        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });

        var id = $('#productId').val();
        if (id == "") {
            addProduct(data);
        } else {
            updateProduct(data);
        }

    });*/

    function addProductAndSize(data) {
        $.ajax({
            url: '${blogAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editBlog}?id=" + result.id + "&message=insert_success";
            },
            error: function (error) {
                window.location.href = "${listBlog}?page=1&limit=10&message=error_system";
                console.log(error);
            }
        });
    }

    function updateProductAndSize(data) {
        $.ajax({
            url: '${blogAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editBlog}?id=" + result.id + "&message=update_success";
            },
            error: function (error) {
                window.location.href = "${editBlog}?id=" + error.id + "&message=error_system";
            }
        });
    }
</script>
</body>
</html>