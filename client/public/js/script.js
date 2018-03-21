function a() {
    console.log('hi');
            var user = {};
            user.name = document.getElementById("name").val;
            user.email = document.getElementById("email").val;
            user.password = document.getElementById("password").val;
            user.isAdmin = false;
            // data.passwordConfirm  = document.getElementById("password-confirm");

            console.log(user);
            $.ajax({
                type: 'POST',
                data: user,
                contentType: 'application/json',
                url: '/mining/dev/add',
                success: function(data) {
                    console.log('success');
                    console.log(JSON.stringify(data));
                }
            });
}

function f() {
    console.log('hi');
}