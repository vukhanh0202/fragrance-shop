function filter_product(obj) {
    var value = obj.value;

    var locate = location.href.split("#")[0];
    locate = locate.toLowerCase();
    var link = locate.split("/")[5];
    if (link.includes("orderby")) {
        window.location = link.split("&orderby")[0] + "&orderby=" + value;
    } else {
        window.location = link + "&orderby=" + value;
    }
}

function search() {
    var searchText = $('#search-input').val();

    var locate = location.href.split("#")[0];
    locate = locate.toLowerCase();
    var link =  locate.split("/")[5];
    var xx = link + "&tim-kiem=" + searchText;
    if (link.includes("tim-kiem")) {
        window.location = link.split("&tim-kiem")[0] + "&tim-kiem=" + searchText;
    } else {
        window.location = link + "&tim-kiem=" + searchText;
    }
}

$('#formSubmit').keypress(function(event)
{
    if (event.keyCode == 13)
    {
        event.preventDefault();
    }
});