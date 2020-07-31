<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:url var="listIncenseGroup" value="/quan-tri/san-pham/danh-sach-nhom-huong"/>
<c:url var="editIncenseGroup" value="/quan-tri/san-pham/chinh-sua-nhom-huong"/>
<c:url var="incenseGroupAPI" value="/api/incense-group"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Chỉnh sửa nhóm hương</title>
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
                <h1 class="h3 mb-0 text-gray-800">Cập nhật nhóm hương</h1>
            </c:if>
            <c:if test="${empty model.id}">
                <h1 class="h3 mb-0 text-gray-800">Thêm nhóm hương</h1>
            </c:if>
        </div>
    </div>
    <%--    <form action="<c:url value='/quan-tri/san-pham/danh-sach'/>" id="formSubmit" method="get">--%>
    <form:form action="<c:url value='/quan-tri/san-pham/chinh-sua-nhom-huong'/>" id="formSubmit" method="get"
               modelAttribute="model" style="margin: 50px 0px 50px 0px" enctype="multipart/form-data">
        <div class="row">
            <div class="form-group col-md-12">
                <label for="InputName">Tên size</label>
                <form:input type="text" class="form-control test" id="InputName" path="name"
                            placeholder="Nhập tên nhóm hương"/>
            </div>
            <div class="form-group col-md-12">
                <label for="InputCode">Code (không dấu, viết liền, cách nhau -)</label>
                <form:input type="text" class="form-control test" id="InputCode" path="code"
                            placeholder="Nhập code"/>
            </div>
        </div>
        <form:hidden path="id" id="incenseGroupId"/>
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


    $('#AddOrUpdateProduct').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();

        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });

        var id = $('#productId').val();
        if (id == "") {
            addIncenseGroup(data);
        } else {
            updateIncenseGroup(data);
        }

    });

    function addIncenseGroup(data) {
        $.ajax({
            url: '${incenseGroupAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editIncenseGroup}?id=" + result.id + "&message=insert_success";
            },
            error: function (error) {
                window.location.href = "${listIncenseGroup}?page=1&limit=10&message=error_system";
                console.log(error);
            }
        });
    }

    function updateIncenseGroup(data) {
        $.ajax({
            url: '${incenseGroupAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editIncenseGroup}?id=" + result.id + "&message=update_success";
            },
            error: function (error) {
                window.location.href = "${editIncenseGroup}?id=" + error.id + "&message=error_system";
            }
        });
    }
</script>
</body>
</html>