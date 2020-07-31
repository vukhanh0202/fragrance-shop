<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<c:url var="themGioHang" value="/AddCart/"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${titleTab}</title>
</head>
<body >
<div class="container-fluid" style="height: 128.2px;background-color: #121b22">
</div>
<div class="container main-collection" style="margin-top: 5rem">
    <div class="row">
        <!-- Collection -->
        <div class="collection col-md-12">
            <div class="category-products">
                <!-- Sort -->
                <%--<div class="sortPagiBar">
                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-12 text-xs-left text-sm-right">
                            <div class="bg-white clearfix" style="font-size: 2rem; padding: 25px 0px">
                                <div class="col-xs-12 col-sm-12 col-md-12 text-xs-left text-sm-right">
                                    <div style=" float: left;text-transform: uppercase; font-weight: 500;">${title}</div>
                                <div id="sort-by">
                                    <label class="left hidden-xs">Sắp xếp: </label>
                                    <form:form action=""
                                               id="formSubmit" method="get"
                                               modelAttribute="model" enctype="multipart/form-data">
                                        <form:select cssStyle="padding: 10px" onchange="filter(this)" path="orderBy" class="form-control">
                                            <form:option value="default" label="Mặc định"></form:option>
                                            <form:option value="asc">A &rarr; Z</form:option>
                                            <form:option value="desc">Z &rarr; A</form:option>
                                            <form:option value="price-asc">Giá tăng dần</form:option>
                                            <form:option value="price-desc">Giá giảm dần</form:option>
                                        </form:select>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>--%>
                <div class="sortPagiBar">
                    <div class="row" style="padding:20px 0px;">
                        <div class="col-xs-12 col-sm-12 col-lg-9"
                             style="font-size: 2rem ;text-transform: uppercase; font-weight: 500;">${title}</div>
                        <div id="sort-by" class="col-xs-12 col-sm-12 col-lg-3">
                            <label class="left hidden-xs">Sắp xếp: </label>
                            <form:form action=""
                                       id="formSubmit" method="get"
                                       modelAttribute="model" enctype="multipart/form-data">
                                <form:select cssStyle="padding: 0.3rem" onchange="filter(this)" path="orderBy"
                                             class="form-control">
                                    <form:option value="default" label="Mặc định"></form:option>
                                    <form:option value="asc">A &rarr; Z</form:option>
                                    <form:option value="desc">Z &rarr; A</form:option>
                             <%--       <form:option value="price-asc">Giá tăng dần</form:option>
                                    <form:option value="price-desc">Giá giảm dần</form:option>--%>
                                </form:select>
                            </form:form>
                        </div>
                    </div>
                </div>
                <!-- List Product -->
                <section class="products-view">
                    <div class="row">
                        <c:forEach var="item" items="${model.listResult}">
                            <div class="col-6 col-sm-6 col-md-4">
                                <div class="product-box">
                                    <c:set var="string1" value="${item.name}"/>
                                    <c:set var="detail" value="${fn:replace(string1, ' ', '-')}"/>
                                    <a href="<c:url value="/chi-tiet/${detail}?id=${item.listResultAllProduct.get(0).id}"/>">
                                        <img class="card-img-top"
                                             src="<c:out value="${item.listResultAllProduct.get(0).images}"/>"
                                             alt="${item.name}">
                                        <div class="card-body">
                                            <h5 class="card-title"><a>${item.name}</a></h5>
                                            <div class="price-box">
                                                <%--Chỉ có 1 sản phẩm--%>
                                                <c:if test="${item.listResultAllProduct.size() == 1}">
                                                    <div class="old-price">
                                                    <span class="price product-price-old">
                                                         <fmt:setLocale value="de_DE" scope="session"/>
                                                 <fmt:formatNumber type="currency" currencySymbol=""
                                                                   maxFractionDigits="0"
                                                                   value="${item.listResultAllProduct.get(0).oldPriceSale}"/>
                                                    </span>
                                                    </div>
                                                    <div class="special-price">
                                                        <span class="price product-price">
                                                           <fmt:formatNumber type="currency" currencySymbol=""
                                                                             maxFractionDigits="0"
                                                                             value="${item.listResultAllProduct.get(0).newPriceSale}"/>
                                                        </span>
                                                    </div>

                                                </c:if>
                                                <%--Có 2 sản phẩm trở lên--%>
                                                    <c:if test="${item.listResultAllProduct.size() > 1}">
                                                        <div class="price-from">
                                                            <span class="price product-price-from">
                                                                 <fmt:setLocale value="de_DE" scope="session"/>
                                                                    <fmt:formatNumber type="currency" currencySymbol=""
                                                                       maxFractionDigits="0"
                                                                       value="${item.listResultAllProduct.get(0).newPriceSale}"/>
                                                            </span>
                                                        </div>
                                                        <div class="to"> – </div>
                                                        <div class="special-price">
                                                            <span class="price product-price">
                                                                <fmt:formatNumber type="currency" currencySymbol=""
                                                                                  maxFractionDigits="0"
                                                                                  value="${item.listResultAllProduct.get(item.listResultAllProduct.size() -1).newPriceSale}"/>
                                                            </span>
                                                        </div>
                                                    </c:if>

                                            </div>
                                        </div>
                                    </a>
                                    <div class="btn-wrap">
                                        <button class="btn">
                                            <a href="<c:url value="/chi-tiet/${detail}?id=${item.listResultAllProduct.get(0).id}" />">THÊM VÀO GIỎ</a>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                    </div>
                    <!-- Pagination -->
                    <div class="align-center " style="margin-top: 3rem">
                        <ul class="pagination" id="pagination"></ul>
                        <input type="hidden" value="" id="page" name="page"/>
                        <input type="hidden" value="" id="limit" name="limit"/>
                    </div>
                </section>
            </div>
        </div>
    </div>
</div>
</div>


<content tag="script">
    <script type="text/javascript">
        var totalPages = ${model.totalPage};
        var currentPage = ${model.page};
        $(function () {
            window.pagObj = $('#pagination').twbsPagination({
                totalPages: totalPages,
                visiblePages: 5,
                startPage: currentPage,
                onPageClick: function (event, page) {
                    if (currentPage != page) {
                        $('#limit').val(12);
                        $('#page').val(page);
                        var limit = $('#limit').val();
                        var page = $('#page').val();

                        var link = location.href.split("#")[0];
                        //window.location = "/" + location.href.split("/")[3].split("?")[0] + "?page=" + page + "&limit=" + limit + "&orderby=" + "${model.orderBy}";
                        window.location = "/" + link.split("/")[3].split("?")[0] + "?page=" + page + "&limit=" + limit + "&orderby=" + "${model.orderBy}";
                    }
                }
            });
        });


        function addCart(id) {

            $.ajax({
                url: '${themGioHang}' + '/' + id,
                type: 'GET',
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
