<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>

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
<div class="detail-blog container" style="margin: 3rem auto">
    <h2 class="title">${model.title}</h2>
    <p class="create-date"><i class="far fa-calendar-alt"></i> Ngày đăng: <span>${model.modifiedDate}</span></p>

    <!-- Content -->
    <section class="single-content single-content-page">
        ${model.content}
    </section>
    <hr>
    <!-- Relate -->
    <section class="single-new-related">
        <section class="sidebar-item-head"> Bài viết liên quan</section>
        <section class="single-new-related-content">
            <section class="">
                <ul>
                    <c:forEach var="item" items="${listRelateBlog}">
                        <li> <a href="<c:url value="/chi-tiet-bai-viet?id=${item.id}"/>"><i
                                class="fas fa-caret-right" aria-hidden="true"></i>${item.title}</a></li>
                    </c:forEach>
                </ul>
            </section>
        </section>
    </section>
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
