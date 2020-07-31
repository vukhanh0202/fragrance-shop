// Xử lí tab
var buttons = document.getElementsByClassName('tablinks');
var contents = document.getElementsByClassName('tabcontent');
function showContent(id){
    for (var i = 0; i < contents.length; i++) {
        contents[i].style.display = 'none';
    }
    var content = document.getElementById(id);
    content.style.display = 'block';
}
for (var i = 0; i < buttons.length; i++) {
    buttons[i].addEventListener("click", function(){
        var id = this.getAttribute("value");
        console.log(id);
        for (var i = 0; i < buttons.length; i++) {
            buttons[i].classList.remove("active");
        }
        this.className += " active";
        showContent(id);
    });
}
showContent('info');



$('#relate').click(function (event) {
    event.preventDefault();

    part = $(this).attr('href'); // lấy id của thẻ h2 tương ứng

    position = $(part).offset().top; // tìm vị trí thẻ h2

    $('html, body').animate({
        scrollTop: position
    }, 800, 'easeInOutSine');
});