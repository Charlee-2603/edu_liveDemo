$(function () {
    $(document).on('click', '.toolbar a[data-target]', function (e) {
        e.preventDefault();
        var target = $(this).data('target');
        $('.widget-box.visible').removeClass('visible');//hide others
        $(target).addClass('visible');//show target
    });

    $("#regBtn").on('click', function () {
        var username = $("#username").val();
        var password = $("#password").val();
        var email = $("#email").val();
        var myreg = /^\w+((.\w+)|(-\w+))@[A-Za-z0-9]+((.|-)[A-Za-z0-9]+).[A-Za-z0-9]+$/;

        if (username.length == 0) {
            alert("请输入用户名");
        } else if (password.length < 6 || password.length > 20) {
            alert("密码必须由大小写英文字母、数字组成，长度6－20位");
        } else if (!myreg.test(email)) {
            alert("需要填写有效的email地址");
        } else {
            $.ajax({
                type: "post",
                url: "register",
                dataType: "json",
                data: {
                    name: username,
                    password: password,
                    email: email
                },
                success: function (data) {
                    console.log(data);
                    if (data.type == "success") {
                        alert(data.msg);
                        window.location.href = "/api/sys/login";
                    } else {
                        alert(data.msg);
                    }
                },
            });
        }
    });

    jQuery(function () {
        $('#btn-login-dark').on('click', function (e) {
            $('body').attr('class', 'login-layout');
            $('#id-text2').attr('class', 'white');
            $('#id-company-text').attr('class', 'blue');

            e.preventDefault();
        });
        $('#btn-login-light').on('click', function (e) {
            $('body').attr('class', 'login-layout light-login');
            $('#id-text2').attr('class', 'grey');
            $('#id-company-text').attr('class', 'blue');

            e.preventDefault();
        });
        $('#btn-login-blur').on('click', function (e) {
            $('body').attr('class', 'login-layout blur-login');
            $('#id-text2').attr('class', 'white');
            $('#id-company-text').attr('class', 'light-blue');

            e.preventDefault();
        });

    });
});