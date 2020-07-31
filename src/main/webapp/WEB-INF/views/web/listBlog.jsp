<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html style="font-size: 16px">
<head>
    <meta charset="UTF-8">
    <title>Kiến thức hay - 4S Perfume</title>
</head>
<body>
<div class="container-fluid" style="height: 128.2px;background-color: #121b22">
</div>
<!-- Content -->
<div class="content-blog container" style="margin: 3rem auto">
    <div class="title-wrap">
        <h1 class="primary-title">
            Kiến thức và Review
        </h1>
        <p class="sub-title display-5">
            Theo dõi 4S Perfume để được biết thêm về những kiến thức hay cũng như review thực tế về nước hoa
        </p>
    </div>
    <div class="grid-view">
        <div class="row">
            <div class="col-12 col-md-3">
                <div class="aside-blog">
                    <div class="search-bar-blog input-group">
                        <input id="search-blog" type="text" class="form-control" placeholder="Tìm kiếm...." onkeypress="if(event.key === 'Enter') searchBlog()">
                        <div class="input-group-append">
                            <button class="btn btn-secondary btn-custom" type="button" onclick="searchBlog()"><i
                                    class="fas fa-search"></i></button>
                        </div>
                    </div>
                    <div id="accordion">
                        <div class="type-blog-wrap">
                            <div class="type-header" id="headingOne">
                                <h5 class="mb-0">
                                    <p data-toggle="collapse" data-target="#collapseOne" aria-expanded="true"
                                       aria-controls="collapseOne">
                                        <i class="fas fa-angle-down" style="margin-right:  0.5rem;"></i>Kiến thức
                                        hay
                                    </p>
                                </h5>
                            </div>
                            <div id="collapseOne" class="collapse show" aria-labelledby="headingOne"
                                 data-parent="#accordion">
                                <div class="type-body">
                                    <a class="knowledge" href="<c:url value='/danh-sach-bai-viet-kien-thuc-nuoc-hoa?page=1&limit=12'/>">
                                        <i class="fas fa-caret-right"></i>
                                        Kiến thức nước hoa
                                    </a>
                                    <br>
                                    <a class="review" href="<c:url value='/danh-sach-bai-viet-review-nuoc-hoa?page=1&limit=12'/>">
                                        <i class="fas fa-caret-right"></i>
                                        Review nước hoa
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <div class="col-12 col-md-9">
                <div class="view-blog">
                    <div class="row">
                        <c:if test="${!title.equals('')}">
                            <div class="col-12" style="font-size: 2rem ;text-transform: uppercase; font-weight: 500;">
                                ${title}
                            </div>
                        </c:if>
                        <c:forEach var="item" items="${model.listResult}">
                            <div class="col-12 col-lg-4">
                                <div class="view-item">
                                    <a href="<c:url value="/chi-tiet-bai-viet?id=${item.id}"/>">
                                        <img width="100%" height="100%"
                                             src="<c:out value="${item.thumbnail}"/>"
                                             alt="${item.title}">
                                        <div class="item-content">
                                            <h3>
                                                    ${item.title}
                                            </h3>
                                            <span>${item.shortDescription}
                                            </span>
                                        </div>
                                        <div class="item-btn">
                                            <button class="btn">
                                                <a href="<c:url value="/chi-tiet-bai-viet?id=${item.id}"/>">XEM THÊM</a>
                                            </button>
                                        </div>
                                    </a>
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

                        var locate = location.href.split("#")[0];
                        window.location = "/" + locate.split("/")[3].split("?")[0] + "?page=" + page + "&limit=" + limit ;
                    }
                }
            });
        });


        function searchBlog() {
            var searchText = $('#search-blog').val();

            var locate = location.href.split("#")[0];
            var link =  locate.split("/")[3];
            var xx = link + "&tra-cuu=" + searchText;
            if (link.includes("tra-cuu")) {
                window.location = link.split("&tra-cuu")[0] + "&tra-cuu=" + searchText;
            } else {
                window.location = link + "&tra-cuu=" + searchText;
            }
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
