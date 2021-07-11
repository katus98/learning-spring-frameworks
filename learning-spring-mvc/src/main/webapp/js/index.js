$(document).ready(function () {
    $("#btn1").click(function () {
        $.ajax({
            url: "/user/testAjax",
            contentType: "application/json;charset=UTF-8",
            data: '{"username": "katus", "password": "skr", "age": 22}',
            dataType: "json",
            type: "post",
            success: function (data, error) {
                alert("success");   // 没有返回值就不会触发
            }
        });
    });
    $("#btn2").click(function () {
        $.ajax({
            url: "/user/testAjax2",
            contentType: "application/json;charset=UTF-8",
            data: '{"username": "katus", "password": "skr", "age": 22}',
            dataType: "json",
            type: "post",
            success: function (data, error) {
                alert(data.username);
            }
        });
    });
});