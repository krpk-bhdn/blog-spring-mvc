function answer(article, id) {
    var form = document.getElementById(id);
    var csrf = document.getElementById("csrf").value;
    form.innerHTML =
        "<div>" +
        "<form class=\"mt-5\" action=\"/article/" + article + "/" + id + "/addSubComment\" method=\"post\">" +
        "<input type=\"hidden\" name=\"_csrf\" value=\"" + csrf + "\">" +
        "<div class=\"form-group\">" +
        "<label for=\"exampleFormControlTextarea1\">Comment:</label>" +
        "<textarea class=\"form-control\" id=\"exampleFormControlTextarea1\" name=\"text\" rows=\"3\"></textarea>" +
        "</div>" +
        "<button type=\"submit\" class=\"btn btn-dark\">Submit</button>" +
        "</form>" +
        "</div>";
}