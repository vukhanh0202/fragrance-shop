
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>4S Perfume</title>
</head>
<body>
<main>
    <!-- Carousel -->
    <div id="slides" class="carousel slide" data-ride="carousel">
        <ul class="carousel-indicators">
            <li data-target="#slides" data-slide-to="0" class="active"></li>
        </ul>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="<c:url value='/template/web/assets/images/AnhHome.jpg'/>" alt="" width="100%">
            </div>
        </div>
    </div>
    <!-- Highlight Products -->
    <div class="highlight-product show-list">
        <div class="container">
            <h3 class="mx-auto d-block">SẢN PHẨM MỚI RA MẮT</h3>
            <div id="carousel-example" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner row w-100 mx-auto" role="listbox">
                    <c:forEach var="item" items="${newRelease.listResult}">
                        <div class="carousel-item col-6 col-md-4 ">
                            <div class="card">
                                <c:set var="string1" value="${item.name}"/>
                                <c:set var="detail" value="${fn:replace(string1, ' ', '-')}"></c:set>
                                <a href="<c:url value="/chi-tiet/${detail}?id=${item.listResultAllProduct.get(0).id}" />">
                                    <img class="card-img-top"
                                         src="<c:out value="${item.listResultAllProduct.get(0).images}"/>"
                                         alt="${item.name}">
                                    <div class="card-body">
                                        <h5 class="card-title"><a>${item.name}</a></h5>
                                        <p class="price-from" >Giá chỉ từ</p>
                                        <div class="price-box">
                                            <div class="old-price">
                                            <span class="price product-price-old">
                                                <fmt:setLocale value="de_DE" scope="session"/>
                                            <span class="woocommerce-Price-amount amount"> <fmt:formatNumber
                                                    type="currency" currencySymbol=""
                                                    maxFractionDigits="0" value="${item.listResultAllProduct.get(0).oldPriceSale}"/>
                                            </span>
                                            </div>
                                            <div class="special-price">
                                            <span class="price product-price">
                                               <fmt:setLocale value="de_DE" scope="session"/>
                                                <span class="woocommerce-Price-amount amount"> <fmt:formatNumber
                                                    type="currency" currencySymbol=""
                                                    maxFractionDigits="0" value="${item.listResultAllProduct.get(0).newPriceSale}"/>
                                            </span>
                                            </div>
                                        </div>
                                    </div>
                                    <button class="btn">
                                        <a href="<c:url value="/chi-tiet/${detail}?id=${item.listResultAllProduct.get(0).id}" />">THÊM VÀO GIỎ</a>
                                    </button>
                                       <%-- <div class="price-box">
                                            <fmt:setLocale value="de_DE" scope="session"/>
                                            <span class="woocommerce-Price-amount amount"> <fmt:formatNumber
                                                    type="currency" currencySymbol=""
                                                    maxFractionDigits="0" value="${item.newPriceSale}"/>
                                        </span>
                                        </div>
                                    </div>--%>
                                </a>
                            </div>
                        </div>
                    </c:forEach>

                </div>
                <a class="carousel-control-prev" href="#carousel-example" role="button" data-slide="prev">
                    <span class="" aria-hidden="true">
                          <i class="icon fas fa-chevron-left"></i>
                    </span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carousel-example" role="button" data-slide="next">
                    <span class="" aria-hidden="true">
                         <i class="icon fas fa-chevron-right"></i>
                    </span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
    <!-- banner -->
    <div id="banner"
         style="background: url('<c:url value='/template/web/assets/images/banner.png'/>') no-repeat border-box"
         class="jumbotron">
        <!-- <img src="./images/Design.png" height="10%" width="20%"> -->
        <h2 class="display-5">Tinh tế trong từng chi tiết</h2>
        <hr>
        <button type="button" class="btn btn-outline-light btn-md">
            Đặt ngay thôi
        </button>
    </div>
    <!-- New products -->
    <div class="new-product show-list">
        <div class="container">
            <h3 class="mx-auto d-block">SẢN PHẨM BÁN CHẠY NHẤT</h3>
            <div id="carousel-new-product" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner row w-100 mx-auto" role="listbox">
                    <c:forEach var="item" items="${bestSeller.listResult}">
                        <div class="carousel-item col-6 col-md-4">
                            <div class="card">
                                <c:set var="string1" value="${item.name}"/>
                                <c:set var="detail" value="${fn:replace(string1, ' ', '-')}"></c:set>
                                <a href="<c:url value="/chi-tiet/${detail}?id=${item.listResultAllProduct.get(0).id}" />">
                                    <div class="img-wrap">
                                        <img class="card-img-top"
                                             src="<c:out value="${item.listResultAllProduct.get(0).images}"/>"
                                             alt="${item.name}">
                                    </div>
                                    <div class="card-body">
                                        <h5 class="card-title"><a>${item.name}</a></h5>
                                        <p class="price-from" >Giá chỉ từ</p>
                                        <div class="price-box">
                                            <div class="old-price">
                                            <span class="price product-price-old">
                                                 <span class="woocommerce-Price-amount amount">
                                                <fmt:formatNumber type="currency" currencySymbol=""
                                                                  maxFractionDigits="0" value="${item.listResultAllProduct.get(0).oldPriceSale}"/>
                                            </span>
                                            </span>
                                            </div>
                                            <div class="special-price">
                                            <span class="price product-price">
                                                <span class="woocommerce-Price-amount amount">
                                                <fmt:formatNumber type="currency" currencySymbol=""
                                                                  maxFractionDigits="0" value="${item.listResultAllProduct.get(0).newPriceSale}"/>
                                            </span>
                                            </span>
                                            </div>
                                        </div>
                                    </div>
                                </a>
                                <button class="btn">
                                    <a href="<c:url value="/chi-tiet/${detail}?id=${item.listResultAllProduct.get(0).id}" />">THÊM VÀO GIỎ</a>
                                </button>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <a class="carousel-control-prev" href="#carousel-new-product" role="button" data-slide="prev">
                    <span class="" aria-hidden="true">
                        <i class="icon fas fa-chevron-left"></i>
                    </span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carousel-new-product" role="button" data-slide="next">
                    <span class="" aria-hidden="true">
                        <i class="icon fas fa-chevron-right"></i>
                    </span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
    <!-- New post-->
    <!-- New post-->
    <div class="new-post show-list">
        <div class="container">
            <h3 class="mx-auto d-block">SẢN PHẨM THEO XU HƯỚNG</h3>
            <div id="carousel-new-post" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner row w-100 mx-auto " role="listbox">
                    <c:forEach var="item" items="${hotTrend.listResult}">
                        <div class="carousel-item col-6 col-md-4">
                            <div class="card">
                                <c:set var="string1" value="${item.name}"/>
                                <c:set var="detail" value="${fn:replace(string1, ' ', '-')}"></c:set>
                                <a href="<c:url value="/chi-tiet/${detail}?id=${item.listResultAllProduct.get(0).id}" />">
                                    <img class="card-img-top"
                                         src="<c:out value="${item.listResultAllProduct.get(0).images}"/>"
                                         alt="${item.name}">
                                    <div class="card-body">
                                        <h5 class="card-title"><a>${item.name}</a></h5>
                                        <p class="price-from" >Giá chỉ từ</p>
                                        <div class="price-box">
                                            <div class="old-price">
                                            <span class="price product-price-old">
                                                <span class="woocommerce-Price-amount amount">
                                                <fmt:formatNumber type="currency" currencySymbol=""
                                                                  maxFractionDigits="0" value="${item.listResultAllProduct.get(0).oldPriceSale}"/>
                                            </span>
                                            </span>
                                            </div>
                                            <div class="special-price">
                                            <span class="price product-price">
                                                <span class="woocommerce-Price-amount amount">
                                                <fmt:formatNumber type="currency" currencySymbol=""
                                                                  maxFractionDigits="0" value="${item.listResultAllProduct.get(0).newPriceSale}"/>
                                            </span>
                                            </span>
                                            </div>
                                        </div>
                                    </div>
                                </a>
                                <button class="btn">
                                    <a href="<c:url value="/chi-tiet/${detail}?id=${item.listResultAllProduct.get(0).id}" />">THÊM VÀO GIỎ</a>
                                </button>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <a class="carousel-control-prev" href="#carousel-new-post" role="button" data-slide="prev">
                    <span class="" aria-hidden="true">
                         <i class="icon fas fa-chevron-left"></i>
                    </span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carousel-new-post" role="button" data-slide="next">
                    <span class="" aria-hidden="true">
                         <i class="icon fas fa-chevron-right"></i>
                    </span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>


</main>
<content tag="script">
    <script type="text/javascript">
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
                        b.setAttribute("onclick", "clickChoose('" + arr[i] + "','" + listIds[i]+ "')");
                        /*make the matching letters bold:*/
                        b.innerHTML =
                            '<img src='+ imgs[i] +' alt="" height="50px" width="50px" style="margin-right:5px">';
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
        function clickChoose(name,id) {
            window.location = "<c:url value="/chi-tiet/"/>" + name +"?id="+id;
        }
    </script>
</content>
</body>
</html>
