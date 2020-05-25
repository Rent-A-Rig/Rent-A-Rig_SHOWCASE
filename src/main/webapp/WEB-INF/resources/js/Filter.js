/*

 */

$(document).ready(function(){
    $("#myInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $(".dropdown-menu li").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});


// desktop functions
function showAll() {
    $("div").filter(".cm").show();
    $("div").filter(".rosewell").show();
    $("div").filter(".asus").show();
    $("div").filter(".acer").show();
    $("div").filter(".rog").show();
    $("div").filter(".abs").show();
    $("div").filter(".msi").show();
}
function showCM() {
    $("div").filter(".cm").show();
    $("div").filter(".rosewell").hide();
    $("div").filter(".asus").hide();
    $("div").filter(".acer").hide();
    $("div").filter(".rog").hide();
    $("div").filter(".abs").hide();
    $("div").filter(".msi").hide();
}
function showasus() {
    $("div").filter(".cm").hide();
    $("div").filter(".rosewell").hide();
    $("div").filter(".asus").show();
    $("div").filter(".acer").hide();
    $("div").filter(".rog").hide();
    $("div").filter(".abs").hide();
    $("div").filter(".msi").hide();
}
function showROG() {
    $("div").filter(".cm").hide();
    $("div").filter(".rosewell").hide();
    $("div").filter(".asus").hide();
    $("div").filter(".acer").show();
    $("div").filter(".rog").hide();
    $("div").filter(".abs").hide();
    $("div").filter(".msi").hide();
}
function showacer() {
    $("div").filter(".cm").hide();
    $("div").filter(".rosewell").hide();
    $("div").filter(".asus").hide();
    $("div").filter(".acer").show();
    $("div").filter(".rog").hide();
    $("div").filter(".abs").hide();
    $("div").filter(".msi").hide();
}
function showmsi() {
    $("div").filter(".cm").hide();
    $("div").filter(".rosewell").hide();
    $("div").filter(".asus").hide();
    $("div").filter(".acer").hide();
    $("div").filter(".rog").hide();
    $("div").filter(".abs").hide();
    $("div").filter(".msi").show();
}
function showABS() {
    $("div").filter(".cm").hide();
    $("div").filter(".rosewell").hide();
    $("div").filter(".asus").hide();
    $("div").filter(".acer").hide();
    $("div").filter(".rog").hide();
    $("div").filter(".abs").show();
    $("div").filter(".msi").hide();
}
function showRosewell() {
    $("div").filter(".cm").hide();
    $("div").filter(".rosewell").show();
    $("div").filter(".asus").hide();
    $("div").filter(".acer").hide();
    $("div").filter(".rog").hide();
    $("div").filter(".abs").hide();
    $("div").filter(".msi").hide();
    }

    //Functions for all portable products
function showAllPort() {
    $("div").filter(".MSI").show();
    $("div").filter(".ASUS").show();
    $("div").filter(".ACER").show();
    $("div").filter(".Surface").show();
    $("div").filter(".Apple").show();
    $("div").filter(".Lenovo").show();
}
function showMSIPort() {
    $("div").filter(".MSI").show();
    $("div").filter(".ASUS").hide();
    $("div").filter(".ACER").hide();
    $("div").filter(".Surface").hide();
    $("div").filter(".Apple").hide();
    $("div").filter(".Lenovo").hide();
}
function showAsusPort() {
    $("div").filter(".MSI").hide();
    $("div").filter(".ASUS").show();
    $("div").filter(".ACER").hide();
    $("div").filter(".Surface").hide();
    $("div").filter(".Apple").hide();
    $("div").filter(".Lenovo").hide();
}
function showAcerPort() {
    $("div").filter(".MSI").hide();
    $("div").filter(".ASUS").hide();
    $("div").filter(".ACER").show();
    $("div").filter(".Surface").hide();
    $("div").filter(".Apple").hide();
    $("div").filter(".Lenovo").hide();
}
function showSurface() {
    $("div").filter(".MSI").hide();
    $("div").filter(".ASUS").hide();
    $("div").filter(".ACER").hide();
    $("div").filter(".Surface").show();
    $("div").filter(".Apple").hide();
    $("div").filter(".Lenovo").hide();
}
function showApple() {
    $("div").filter(".MSI").hide();
    $("div").filter(".ASUS").hide();
    $("div").filter(".ACER").hide();
    $("div").filter(".Surface").hide();
    $("div").filter(".Apple").show();
    $("div").filter(".Lenovo").hide();
}
function showLenovo() {
    $("div").filter(".MSI").hide();
    $("div").filter(".ASUS").hide();
    $("div").filter(".ACER").hide();
    $("div").filter(".Surface").hide();
    $("div").filter(".Apple").hide();
    $("div").filter(".Lenovo").show();
}