function filter(obj)
{
    var value = obj.value;
    //window.location = location.href.split("/")[3].split("?")[0] +"?page=1&limit=20&orderby="+value;
    var locate = location.href.split("#")[0];
    var link = locate.split("/")[3];
    //var link = location.href.split("/")[3];
    if (link.includes("orderby")){
        window.location = link.split("&orderby")[0] + "&orderby="+value;
    }else{
        window.location = link +"&orderby="+value;
    }
}
