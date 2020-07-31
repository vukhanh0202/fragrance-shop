<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<c:url var="themGioHang" value="/AddCart/"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${model.product.name} - 4S Perfume</title>
</head>
<body>
<div class="container-fluid" style="height: 128.2px;background-color: #121b22">
</div>
<!-- Content -->
<section class="content" style="margin-top: 5rem">
    <div class="container">
        <div class="row">
            <div class="col-lg-8">
                <div class="detail-product-top">
                    <div class="image-wrap">
                        <img id="img-product" src="<c:out value="${model.images}"/>"
                             height="100%" width="100%" alt="">
                    </div>
                    <div class="cboth"></div>
                </div>
            </div>
            <div class="general-info-wrap col-lg-4">
                <h1>${model.product.name}</h1>
                <c:if test="${model.product.bestSeller == true}">
                    <p>Best Seller</p>
                </c:if>
                <p><a>Thông tin thêm</a></p>
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                <div class="price-selection-wrap">
                    <div class="price-selection">
                        <del id="del-price">
                            <fmt:setLocale value="en_CA"/>
                            <fmt:formatNumber type="currency" currencySymbol=""
                                              maxFractionDigits="0" value=" ${model.oldPriceSale}"/>
                        </del>
                        <span id="sale-price">
                            <fmt:setLocale value="en_CA"/>
                                            <fmt:formatNumber type="currency" currencySymbol=""
                                                              maxFractionDigits="0" value=" ${model.newPriceSale}"/>
                        </span>
                        <span class="tag">khuyến mãi</span>
                    </div>
                </div>

                <p style="margin-bottom:0.5rem">${listProduct.size()} sizes có sẵn</p>
                <select id="selectSize" onchange="clickChooseSize(this.selectedIndex)" name="cars" class="custom-select custom-select-lg mb-3">
                    <c:forEach var="item" items="${listProduct}">
                        <c:if test="${listProduct.get(0) == item}">
                            <option value="${item.id}" selected>${item.productSize.size}</option>
                        </c:if>
                        <c:if test="${listProduct.get(0) != item}">
                            <option value="${item.id}">${item.productSize.size}</option>
                        </c:if>
                    </c:forEach>
                </select>
                <c:if test="${listProduct.size() == 0}">
                    <button class="btn"  ><a href="">HẾT HÀNG</a> </button>
                </c:if>
                <c:if test="${listProduct.size() != 0}">
                    <button class="btn" onclick="addCart()" ><a href="">THÊM VÀO GIỎ</a> </button>
                </c:if>

                <div id="accordion">
                    <div class="card">
                        <div class="card-header" id="headingOne">
                            <h5 class="mb-0" >
                                <a  data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    Mô tả<i class="fas fa-angle-down" style="margin-left:0.5rem"></i>
                                </a>
                            </h5>
                        </div>
                        <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                            <div class="card-body">
                                <div class="info-wrap">
                                    <div class="info-item">
                                        <strong>Độ lưu hương: </strong>
                                        <a>${model.product.longevity}</a>
                                    </div>
                                    <div class="info-item">
                                        <strong>Giới tính: </strong>
                                        <a>${model.product.gender}</a>
                                    </div>
                                    <div class="info-item">
                                        <strong>Nhóm hương: </strong>
                                        <a>${model.product.incenseGroup.name}</a>
                                    </div>
                                    <div class="info-item">
                                        <strong>Phong cách: </strong>
                                        <a>${model.product.style}</a>
                                    </div>
                                    <div class="info-item">
                                        <strong>Size nước hoa: </strong>
                                        <c:forEach var="item" items="${listProduct}">
                                            <c:if test="${listProduct.get(listProduct.size()-1) == item}">
                                                ${item.productSize.size}
                                            </c:if>
                                            <c:if test="${listProduct.get(listProduct.size()-1) != item}">
                                                ${item.productSize.size} ,
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <a href="#policy" class="a_link">Chính sách</a>
                <br>
                <a id="relate" href="#product-relate" class="a_link">Sản phẩm tương tự</a>
                <!--
                                    <form class="cart-shopping">
                                        <table class="choose-size">
                                            <tbody>
                                                <td class="label"> <label for="size_nuoc_hoa">Size nước hoa</label></td>
                                                <td class="value">
                                                    <div class="radio-toolbar">
                                                        <input type="radio" id="radioApple" name="radioSize" value="10ml"
                                                            onclick="myRadioFunc()" checked>
                                                        <label for="radioApple">10ml</label>
                                                        <input type="radio" id="radioBanana" name="radioSize" value="100ml"
                                                            onclick="myRadioFunc()">
                                                        <label for="radioBanana">100ml</label>
                                                    </div>
                                                </td>
                                            </tbody>
                                        </table>
                                    </form> -->
            </div>
            <div class="detail-product-bottom col-12">
                <div class="tab">
                    <button class="tablinks active" value="info">Thông tin chi tiết</button>
                    <button class="tablinks" value="commitment">Cam kết từ 4S Perfume</button>
                    <button id="policy" class="tablinks" value="guarantee">Bảo hành - Đổi trả</button>
                </div>
                <div id="info" class="tabcontent">
                    <table class="full-size-table">
                        <tbody>
                        <tr>
                            <th colspan="2">Sản phẩm</th>
                            <th>Giá 4S Perfume</th>
                            <th>Giá thị trường</th>
                            <th>Tiết kiệm</th>
                        </tr>
                        <c:forEach var="item" items="${listProduct}">
                            <tr itemprop="offers" itemscope="">
                                <td width="90"><img data-thumb="small" original-height="900"
                                                    original-width="900" width="90px" height="90px"
                                                    src="<c:out value="${item.images}"/>">
                                </td>
                                <td><strong>${item.product.name}&nbsp;</strong><b>${item.productSize.size}</b></td>
                                <td><b> <fmt:setLocale value="de_DE" scope="session"/>
                                    <fmt:formatNumber type="currency" currencySymbol=""
                                                      maxFractionDigits="0" value="${item.newPriceSale}"/> VNĐ</b>
                                </td>
                                <td>
                                    <fmt:formatNumber type="currency" currencySymbol="" pattern=""
                                                      maxFractionDigits="0" value="${item.oldPriceSale}"/> VNĐ
                                </td>
                                <td><b>
                                    <fmt:formatNumber type="currency" currencySymbol=""
                                                      maxFractionDigits="0"
                                                      value="${item.oldPriceSale - item.newPriceSale}"/> VNĐ</b>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="info-more">
                        ${model.product.description}
                    </div>
                </div>

                <div id="commitment" class="tabcontent">
                    <section class="tab-item" style="display: block;">
                        <p><strong>Mua hàng tại 4S Perfume khách hàng luôn yên tâm tuyệt đối:</strong></p>
                        <ul>
                            <li>* 100% sản phẩm được nhập trực tiếp từ Pháp,<span
                                    style="color: #333399"><strong> có bill gốc</strong></span>, tem và phiếu
                                bảo hành chính hãng.
                            </li>
                            <li>* 100% sản phẩm <span style="color: #ff6600"><strong>được bảo hành trọn
                                                đời</strong></span>, được hoàn tiền không mất phí nếu khách hàng không
                                hài lòng về chất lượng sản phẩm.
                            </li>
                            <!-- <li>* Hơn <span style="color: #0000ff"><strong>8.000 khách hàng</strong></span> đã
                                tin tưởng vào <span style="color: #800080"><strong>Missi </strong></span>trong
                                hơn 8 năm qua, Quý khách có thể xem thêm review của khách hàng<strong><span
                                        style="color: #800080"><a style="color: #800080"
                                            href="https://www.missi.vn/danh-muc/cam-nhan-k-hang-3111"
                                            target="_blank" rel="noopener"> tại đây</a>.&nbsp;</span></strong>
                            </li> -->
                        </ul>
                    </section>
                </div>

                <div id="guarantee" class="tabcontent">
                    <section id="sing-pro-tab03" class="single-pro-tab-content-item single-content"
                             style="display: block;">
                                <span style="font-size: 12pt"><em>4S Perfume cam kết <span
                                        style="color: #333399"><strong>bảo hành trọn đời</strong></span> về mùi
                                        hương của chai nước hoa. Nếu không hài lòng về sản phẩm, khách hàng có thể
                                        đối trả <span style="color: #800080"><strong>hoàn tiền
                                                100%</strong></span></em></span>
                        <p><strong>ĐIỀU KIỆN BẢO HÀNH</strong></p>
                        <ul>
                            <li>Sản phẩm phải còn đầy đủ tem, hộp của nhà sản xuất &amp; và tem bảo hành của
                                4S Perfume.
                            </li>
                        </ul>
                        <p><strong>QUY TRÌNH BẢO HÀNH</strong></p>
                        <ul>
                            <li>Khách hàng gửi sản phẩm về 29 Nguyễn Khoái, P.2, Q.4, TpHCM</li>
                            <li>4S Perfume sẽ kiểm tra và tiến hành hoàn tiền cho quý khách từ 1-2 ngày làm
                                việc.
                            </li>
                        </ul>
                        <p><strong>CÁC TRƯỜNG HỢP KHÔNG HỖ TRỢ BẢO HÀNH</strong></p>
                        <ul>
                            <li>Sản phẩm không phải do 4S Perfume trực tiếp bán.</li>
                            <li>Sản phẩm đã bị can thiệp vào các phần vòi, tem</li>
                        </ul>
                        <p><strong>HỖ TRỢ&nbsp;</strong></p>
                        <ul>
                            <li>Hotline: 0858100938 (Zalo)</li>
                            <li>Email:&nbsp;<a href="#">forsweetperfume@gmail.com</a></li>
                        </ul>
                    </section>
                </div>
            </div>

        </div>
    </div>
</section>
<!-- Product more -->
<div id="product-relate" class="highlight-product show-list detail-product-involve">
    <div class="container">
        <h3 class="mx-auto d-block">Sản phẩm liên quan</h3>
        <div id="carousel-example" class="carousel">
            <div class="carousel-inner row w-100 mx-auto">
                <c:forEach var="item" items="${model.listResult}">
                    <div class="carousel-items col-6 col-lg-3 ">
                        <div class="card">
                            <img class="card-img-top"
                                 src="<c:out value="${item.images}"/>"
                                 alt="${item.product.name}">
                            <div class="card-body">
                                <h5 class="card-title" style="color: #212529"><a>${item.product.name}</a></h5>
                                <div class="stars"
                                     style="text-align: center;font-size: 0.8rem;color: #212529; padding-top: 0.5rem;">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                </div>
                                <div class="row">
                                    <div class="price col-6" style="text-align: right;padding-right: 0.3rem;padding-left: 0">
                                    <span class="woocommerce-Price-amount amount"
                                          style="text-decoration: line-through; color: #666666;">
                                        <fmt:setLocale value="de_DE" scope="session"/>
                                                     <fmt:formatNumber type="currency" currencySymbol=""
                                                                       maxFractionDigits="0"
                                                                       value="${item.oldPriceSale}"/>
                                    </span>
                                    </div>
                                    <div class="price col-6" style="text-align: left;padding-left: 0.3rem;padding-right:0">
                                    <span class="woocommerce-Price-amount amount" style="color: #212529">
                                        <fmt:setLocale value="de_DE" scope="session"/>
                                                     <fmt:formatNumber type="currency" currencySymbol=""
                                                                       maxFractionDigits="0"
                                                                       value="${item.newPriceSale}"/>
                                    </span>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<content tag="script">
    <script type="text/javascript">
        const formatter = new Intl.NumberFormat('de-DE', {
            style: 'currency',
            currency: 'EUR',
            minimumFractionDigits: 0,

        })

        function clickChooseSize(value) {

            var count = 0;
            <c:forEach var="item" items="${listProduct}">
                if (count == value){
                    document.getElementById("del-price").innerText = formatter.format(${item.oldPriceSale}).split("€")[0];
                    document.getElementById("sale-price").innerText = formatter.format(${item.newPriceSale}).split("€")[0];
                    document.getElementById("img-product").src = "<c:out value="${item.images}"/>"
                }
                count++;
            </c:forEach>
        }

        function addCart() {
            var radios = document.getElementsByTagName('input');
            //var values;
            var values = document.getElementById("selectSize").value;
           /* for (var i = 0; i < radios.length; i++) {
                if (radios[i].type === 'radio' && radios[i].checked) {
                    // get value, set checked flag or do whatever you need to
                    values = radios[i].value;
                }
            }*/
            $.ajax({
                url: '${themGioHang}' + '/' + values,
                type: 'GET',
            });
            location.reload();
        }


        /*Auto complete*/
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
                window.location = "<c:url value="/tim-kiem?page=1&limit=12"/>" + "&tim-kiem=" + searchText;
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
