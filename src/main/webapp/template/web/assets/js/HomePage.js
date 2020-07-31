document.addEventListener("DOMContentLoaded", function () {
    var addActiveClass = document.querySelectorAll('.highlight-product #carousel-example .carousel-inner div:first-child ')[0];
    var addActiveMaleClass = document.querySelectorAll('.new-product #carousel-new-product .carousel-inner div:first-child ')[0];
    var addActiveFeMaleClass = document.querySelectorAll('.new-post #carousel-new-post .carousel-inner div:first-child ')[0];

    var x = addActiveClass.getAttribute("class");
    var y = addActiveMaleClass.getAttribute("class");
    var z = addActiveFeMaleClass.getAttribute("class");

    addActiveClass.setAttribute("class", x + " active");
    addActiveMaleClass.setAttribute("class", y + " active");
    addActiveFeMaleClass.setAttribute("class", z + " active");

});

/* Showw list highlight product*/
$('#carousel-example').on('slide.bs.carousel', function (e) {
    var $e = $(e.relatedTarget);
    var idx = $e.index();
    var itemsPerSlide = 4;
    var totalItems = $('.highlight-product .carousel-item').length;

    if (idx >= totalItems - (itemsPerSlide - 1)) {
        var it = itemsPerSlide - (totalItems - idx);
        for (var i = 0; i < it; i++) {
            // append slides to end
            if (e.direction == "left") {
                $('.highlight-product .carousel-item').eq(i).appendTo('.highlight-product .carousel-inner');
            } else {
                $('.highlight-product .carousel-item').eq(0).appendTo('.highlight-product .carousel-inner');
            }
        }
    }
});


/* Showw list new product*/
$('#carousel-new-product').on('slide.bs.carousel', function (e) {
    var $e = $(e.relatedTarget);
    var idx = $e.index();
    var itemsPerSlide = 4;
    var totalItems = document.querySelectorAll('.new-product .carousel-item').length;

    if (idx >= totalItems - (itemsPerSlide - 1)) {
        var it = itemsPerSlide - (totalItems - idx);
        for (var i = 0; i < it; i++) {
            // append slides to end
            if (e.direction == "left") {
                $('.new-product  .carousel-item').eq(i).appendTo('.new-product  .carousel-inner');
            } else {
                $('.new-product  .carousel-item').eq(0).appendTo('.new-product  .carousel-inner');
            }
        }
    }
});
// Showw list new post
$('#carousel-new-post').on('slide.bs.carousel', function (e) {
    var $e = $(e.relatedTarget);
    var idx = $e.index();
    var itemsPerSlide = 4;
    var totalItems = document.querySelectorAll('.new-post .carousel-item').length;

    if (idx >= totalItems - (itemsPerSlide - 1)) {
        var it = itemsPerSlide - (totalItems - idx);
        for (var i = 0; i < it; i++) {
            // append slides to end
            if (e.direction == "left") {
                $('.new-post .carousel-item').eq(i).appendTo('.new-post .carousel-inner');
            } else {
                $('.new-post .carousel-item').eq(0).appendTo('.new-post .carousel-inner');
            }
        }
    }
});


// Giới hạn kí tự
$(document).ready(function () {
    $(".sub-title").each(function (i) {
        var len = $(this).text().length;
        if (len > 100) {
            $(this).text($(this).text().substr(0, 100) + '[...]');
        }
    });
});

// Scroll top
$(window).scroll(function () {
    if ($(this).scrollTop() >= 400) {
        console.log($(this).scrollTop());
        $('#go-to-top').fadeIn();
    } else {
        $('#go-to-top').fadeOut();
    }
});
$('#go-to-top').click(function () {
    $('html,body').animate({
        scrollTop: 0
    }, 'slow');
});