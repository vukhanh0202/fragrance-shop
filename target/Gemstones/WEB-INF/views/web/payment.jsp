<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<c:url var="exportBillAPI" value="/api/export-bill"/>
<c:url var="payment" value="/thanh-toan"/>
<!DOCTYPE html>
<html style="font-size: 16px">
<head>
    <meta charset="UTF-8">
    <title>Thanh toán - 4S Perfume</title>
</head>
<body>
<div class="container-fluid" style="height: 128.2px;background-color: #121b22">
</div>
<!-- Content -->
<div class="container payment-page" style="font-size: 16px;margin-top: 5rem">
    <c:if test="${not empty message}">
        <div class="alert alert-${alert}">
            <strong>${message}</strong>
        </div>
    </c:if>
    <h1 class="text-left">Thanh toán</h1>
    <div class="row">
        <div class="col-xs-12 col-sm-12  well well-sm col-md-offset-4">
            <form:form action="#" method="get" class="form" id="paySubmit" role="form" enctype="multipart/form-data"
                       modelAttribute="customer">
                <div class="row">
                    <div class="col-12">
                        <legend><a href="#"><i class="glyphicon glyphicon-globe"></i></a>
                            Thông tin thanh
                            toán
                        </legend>
                    </div>
                    <div class="col-xs-12 col-md-6">
                        <div class="col-xs-12 col-md-12">
                            <label>Họ và tên
                                <abbr class="required" title="bắt buộc">*</abbr>
                            </label>
                            <form:input type="text" class="form-control" id="name" path="name" required=""
                                        autofocus=""
                                        placeholder="Họ và tên"/>
                                <%-- <input class="form-control" name="firstname" placeholder="Họ và tên" required=""
                                        autofocus="" type="text">--%>
                        </div>
                        <div class="col-xs-12 col-md-12">
                            <label>Số điện thoại
                                <abbr class="required" title="bắt buộc">*</abbr>
                            </label>
                            <form:input type="text" class="form-control" id="phone" path="phone" required=""
                                        autofocus=""
                                        placeholder="Số điện thoại"/>
                                <%--  <input class="form-control" name="phone" placeholder="Số điện thoại" required=""
                                         autofocus="" type="text">--%>
                        </div>
                        <div class="col-xs-12 col-md-12">
                            <label>Địa chỉ email
                                <abbr class="required" title="bắt buộc">*</abbr>
                            </label>
                            <form:input type="email" class="form-control" id="email" path="email" required=""
                                        autofocus=""
                                        placeholder="Email"/>
                                <%--<input class="form-control" name="email" placeholder="Email" required="" autofocus=""
                                       type="text">--%>
                        </div>
                        <div class="col-xs-12 col-md-12">
                            <label>Tỉnh/ Thành phố
                                <abbr class="required" title="bắt buộc">*</abbr>
                            </label>
                            <form:select class="form-control test" id="city" path="city">
                                <form:option value="" label="--Chọn Thành phố--"></form:option>
                                <form:option value="Hồ Chí Minh">Hồ Chí Minh</form:option>
                                <form:option value="Hà Nội">Hà Nội</form:option>
                                <form:option value="An Giang">An Giang</form:option>
                                <form:option value="Bà Rịa - Vũng Tàu">Bà Rịa - Vũng Tàu</form:option>
                                <form:option value="Bạc Liêu">Bạc Liêu</form:option>
                                <form:option value="Bắc Giang">Bắc Giang</form:option>
                                <form:option value="Bắc Kạn">Bắc Kạn</form:option>
                                <form:option value="Bắc Ninh">Bắc Ninh</form:option>
                                <form:option value="Bến Tre">Bến Tre</form:option>
                                <form:option value="Bình Dương">Bình Dương</form:option>
                                <form:option value="Bình Định">Bình Định</form:option>
                                <form:option value="Bình Phước">Bình Phước</form:option>
                                <form:option value="Bình Thuận">Bình Thuận</form:option>
                                <form:option value="Cà Mau">Cà Mau</form:option>
                                <form:option value="Cao Bằng">Cao Bằng</form:option>
                                <form:option value="Cần Thơ">Cần Thơ</form:option>
                                <form:option value="Đà Nẵng">Đà Nẵng</form:option>
                                <form:option value="Đắk Lắk">Đắk Lắk</form:option>
                                <form:option value="Đắk Nông">Đắk Nông</form:option>
                                <form:option value="Điện Biên">Điện Biên</form:option>
                                <form:option value="Đồng Nai">Đồng Nai</form:option>
                                <form:option value="Đồng Tháp">Đồng Tháp</form:option>
                                <form:option value="Gia Lai">Gia Lai</form:option>
                                <form:option value="Hà Giang">Hà Giang</form:option>
                                <form:option value="Hà Nam">Hà Nam</form:option>
                                <form:option value="Hà Tĩnh">Hà Tĩnh</form:option>
                                <form:option value="Hải Dương">Hải Dương</form:option>
                                <form:option value="Hải Phòng">Hải Phòng</form:option>
                                <form:option value="Hậu Giang">Hậu Giang</form:option>
                                <form:option value="Hòa Bình">Hòa Bình</form:option>
                                <form:option value="Hưng Yên">Hưng Yên</form:option>
                                <form:option value="Khánh Hòa">Khánh Hòa</form:option>
                                <form:option value="Kiên Giang">Kiên Giang</form:option>
                                <form:option value="Kon Tum">Kon Tum</form:option>
                                <form:option value="Lai Châu">Lai Châu</form:option>
                                <form:option value="Lạng Sơn">Lạng Sơn</form:option>
                                <form:option value="Lào Cai">Lào Cai</form:option>
                                <form:option value="Lâm Đồng">Lâm Đồng</form:option>
                                <form:option value="Long An">Long An</form:option>
                                <form:option value="Nam Định">Nam Định</form:option>
                                <form:option value="Nghệ An">Nghệ An</form:option>
                                <form:option value="Ninh Bình">Ninh Bình</form:option>
                                <form:option value="Ninh Thuận">Ninh Thuận</form:option>
                                <form:option value="Phú Thọ">Phú Thọ</form:option>
                                <form:option value="Phú Yên">Phú Yên</form:option>
                                <form:option value="Quảng Bình">Quảng Bình</form:option>
                                <form:option value="Quảng Nam">Quảng Nam</form:option>
                                <form:option value="Quảng Ngãi">Quảng Ngãi</form:option>
                                <form:option value="Quảng Ninh">Quảng Ninh</form:option>
                                <form:option value="Quảng Trị">Quảng Trị</form:option>
                                <form:option value="Sóc Trăng">Sóc Trăng</form:option>
                                <form:option value="Sơn La">Sơn La</form:option>
                                <form:option value="Tây Ninh">Tây Ninh</form:option>
                                <form:option value="Thái Bình">Thái Bình</form:option>
                                <form:option value="Thái Nguyên">Thái Nguyên</form:option>
                                <form:option value="Thanh Hóa">Thanh Hóa</form:option>
                                <form:option value="Thừa Thiên Huế">Thừa Thiên Huế</form:option>
                                <form:option value="Tiền Giang">Tiền Giang</form:option>
                                <form:option value="Trà Vinh">Trà Vinh</form:option>
                                <form:option value="Tuyên Quang">Tuyên Quang</form:option>
                                <form:option value="Vĩnh Long">Vĩnh Long</form:option>
                                <form:option value="Vĩnh Phúc">Vĩnh Phúc</form:option>
                                <form:option value="Yên Bái">Yên Bái</form:option>
                            </form:select>
                        </div>
                        <div class="col-xs-12 col-md-12">
                            <label>Địa chỉ
                                <abbr class="required" title="bắt buộc">*</abbr>
                            </label>
                            <form:input type="text" class="form-control" id="address" path="address" required=""
                                        autofocus=""
                                        placeholder="Nhập địa chỉ"/>
                                <%-- <input class="form-control" name="address" placeholder="Nhập địa chỉ" required=""
                                        autofocus="" type="text">--%>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-6">
                        <div class="col-xs-12 col-md-12">
                            <label>Ghi chú
                            </label>
                            <textarea class="form-control" id="exampleFormControlTextarea1" rows="14" name="description"
                                      placeholder="Ghi chú về đơn hàng. Ví dụ: Thời gian hay chỉ dẫn địa điểm giao hàng chi tiết hơn..."></textarea>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <legend><a href="#"><i class="glyphicon glyphicon-globe"></i></a> Đơn
                            hàng của bạn
                        </legend>
                    </div>
                    <div class="col-12">
                        <table class="table table-bordered table-striped">
                            <thead>
                            <tr>
                                <th>Sản phẩm</th>
                                <th>Tổng</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${Cart.listResultDetailProduct}">
                                <tr>
                                    <td>
                                            ${item.productFullSize.product.name}
                                        - ${item.productFullSize.productSize.size}&nbsp; <strong
                                            class="product-quantity">
                                        × ${item.quantity}</strong>
                                    </td>
                                    <td>
                                        <span class="woocommerce-Price-amount amount">
                                            <c:if test="${not empty item.price}">
                                                <fmt:setLocale value="en_CA"/>
                                                <fmt:formatNumber type="currency" currencySymbol=""
                                                                  maxFractionDigits="0" value="  ${item.price}"/>
                                                <span class="woocommerce-Price-currencySymbol"></span>
                                            </c:if>
                                        </span>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                            <tfoot>
                            <tr>
                                <th>Tạm tính</th>
                                <td>
                                    <c:if test="${not empty Cart.totalPrice}">
                                         <span><fmt:setLocale value="en_CA"/>
                                         <fmt:formatNumber type="currency" currencySymbol=""
                                                           maxFractionDigits="0" value=" ${Cart.totalPrice}"/></span>
                                    </c:if>


                                </td>
                            </tr>
                            <tr>
                                <th>Giao hàng</th>
                                <td data-title="Giao hàng">
                                    <c:if test="${not empty Ship}">
                                        <fmt:setLocale value="en_CA"/>
                                        <fmt:formatNumber type="currency" currencySymbol=""
                                                          maxFractionDigits="0" value="${Ship}"/>
                                    </c:if>

                                </td>
                            </tr>
                            <tr>
                                <th>Tổng</th>
                                <td>
                                    <c:if test="${not empty Cart.totalPrice}">
                                        <strong><span><fmt:setLocale value="en_CA"/>
                <fmt:formatNumber type="currency" currencySymbol=""
                                  maxFractionDigits="0"
                                  value=" ${Cart.totalPrice + Ship}"/><span></span></span></strong>
                                    </c:if>

                                </td>
                            </tr>
                            </tfoot>
                        </table>
                    </div>
                    <div class="col-12">
                        <div id="payment-wrap">
                            <ul class="payment">
                                <li class="wc_payment_method payment_method_cod">
                                    <input id="payment_method_cod" type="radio" class="input-radio"
                                           name="payment_method" value="cod" checked="checked"
                                           data-order_button_text="" style="display: none;">

                                    <label for="payment_method_cod">
                                        Trả tiền mặt khi nhận hàng </label>
                                    <div class="payment_box payment_method_cod">
                                        <p style="margin:5px 0">Trả tiền mặt khi giao hàng.</p>
                                    </div>
                                </li>
                            </ul>
                            <div>
                                <input id="pay" type="submit" href="" class="btn btn-danger btn-custom"
                                       value="Thanh toán"></input>
                            </div>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </div>

</div>

<content tag="script">
    <script type="text/javascript">

        $('#pay').click(function (e) {
            e.preventDefault();
            var data = {};
            var formData = $('#paySubmit').serializeArray();

            var flag = true;
            $.each(formData, function (i, v) {
                if (v.name == "description") {
                    data["" + v.name + ""] = v.value;
                } else if (v.value == "" && flag == true) {
                    flag = false;
                    alert("Vui lòng nhập đủ thông tin ");
                } else {
                    data["" + v.name + ""] = v.value;
                }
            });
            if (flag == true) {
                Pay(data);
            }
        });
        function Pay(data) {
            $.ajax({
                url: '${exportBillAPI}',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (result) {
                    window.location.href = "${payment}?&message=insert_success";
                },
                error: function (error) {
                    window.location.href = "${payment}?message=error_system";
                }
            });
        }

        function autocomplete(inp, arr, imgs, listIds) {
            /*the autocomplete function takes two arguments,
            the text field element and an array of possible autocompleted values:*/
            var currentFocus;
            /*execute a function when someone writes in the text field:*/
            inp.addEventListener("input", function (e) {
                var a, b, i, val = this.value;
                /*close any already open lists of autocompleted values*/
                closeAllLists();
                if (!val) {
                    return false;
                }
                currentFocus = -1;
                /*create a DIV element that will contain the items (values):*/
                a = document.createElement("DIV");
                a.setAttribute("id", this.id + "autocomplete-list");
                a.setAttribute("class", "autocomplete-items");
                /*append the DIV element as a child of the autocomplete container:*/
                this.parentNode.appendChild(a);
                /*for each item in the array...*/
                for (i = 0; i < arr.length; i++) {
                    /*check if the item starts with the same letters as the text field value:*/
                    if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
                        /*create a DIV element for each matching element:*/
                        b = document.createElement("DIV");
                        b.setAttribute("onclick", "clickChoose('" + arr[i] + "','" + listIds[i] + "')");
                        /*make the matching letters bold:*/
                        b.innerHTML =
                            '<img src=' + imgs[i] + ' alt="" height="50px" width="50px" style="margin-right:5px">';
                        b.innerHTML += "<strong>" + arr[i].substr(0, val.length) + "</strong>";
                        b.innerHTML += arr[i].substr(val.length);
                        /*insert a input field that will hold the current array item's value:*/
                        b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
                        /*execute a function when someone clicks on the item value (DIV element):*/
                        b.addEventListener("click", function (e) {
                            /*insert the value for the autocomplete text field:*/
                            inp.value = this.getElementsByTagName("input")[0].value;
                            /*close the list of autocompleted values,
                            (or any other open lists of autocompleted values:*/
                            closeAllLists();
                        });
                        a.appendChild(b);
                    }
                }
            });
            /*execute a function presses a key on the keyboard:*/
            inp.addEventListener("keydown", function (e) {
                var x = document.getElementById(this.id + "autocomplete-list");
                if (x) x = x.getElementsByTagName("div");
                if (e.keyCode == 40) {
                    /*If the arrow DOWN key is pressed,
                    increase the currentFocus variable:*/
                    currentFocus++;
                    /*and and make the current item more visible:*/
                    addActive(x);
                } else if (e.keyCode == 38) { //up
                    /*If the arrow UP key is pressed,
                    decrease the currentFocus variable:*/
                    currentFocus--;
                    /*and and make the current item more visible:*/
                    addActive(x);
                } else if (e.keyCode == 13) {
                    /*If the ENTER key is pressed, prevent the form from being submitted,*/
                    e.preventDefault();
                    if (currentFocus > -1) {
                        /*and simulate a click on the "active" item:*/
                        if (x) x[currentFocus].click();
                    }
                }
            });

            function addActive(x) {
                /*a function to classify an item as "active":*/
                if (!x) return false;
                /*start by removing the "active" class on all items:*/
                removeActive(x);
                if (currentFocus >= x.length) currentFocus = 0;
                if (currentFocus < 0) currentFocus = (x.length - 1);
                /*add class "autocomplete-active":*/
                x[currentFocus].classList.add("autocomplete-active");
            }

            function removeActive(x) {
                /*a function to remove the "active" class from all autocomplete items:*/
                for (var i = 0; i < x.length; i++) {
                    x[i].classList.remove("autocomplete-active");
                }
            }

            function closeAllLists(elmnt) {
                /*close all autocomplete lists in the document,
                except the one passed as an argument:*/
                var x = document.getElementsByClassName("autocomplete-items");
                for (var i = 0; i < x.length; i++) {
                    if (elmnt != x[i] && elmnt != inp) {
                        x[i].parentNode.removeChild(x[i]);
                    }
                }
            }

            /*execute a function when someone clicks in the document:*/
            document.addEventListener("click", function (e) {
                closeAllLists(e.target);
            });
        }

        /*initiate the autocomplete function on the "myInput" element, and pass along the countries array as possible autocomplete values:*/
        var names = ${names};
        var imgs = ${images};
        var listIds = ${ids};
        autocomplete(document.getElementById("myInput"), names, imgs, listIds);
        var searchText;
        document.getElementById("myInput").addEventListener("input", function (e) {
            searchText = this.value;
        });
        $("#myInput").keyup(function (event) {
            if (event.keyCode == 13) {
                window.location = "<c:url value="/tim-kiem?page=1&limit=12"/>" + "&tim-kiem="+ searchText ;
            }
        });
        var x = document.getElementById('search-bars');
        x.style.display = 'none';

        function myFunction() {
            if (x.style.display === 'none') {
                //x.setAttribute("style", "display:block");
                x.style.display = 'block';
            } else {
                //x.setAttribute("style", "display:none");
                //x.setAttribute("display", "none");
                x.style.display = 'none';
            }
        }

        function clickChoose(name, id) {
            window.location = "<c:url value="/chi-tiet/"/>" + name + "?id=" + id;
        }
    </script>
</content>

</body>
</html>
