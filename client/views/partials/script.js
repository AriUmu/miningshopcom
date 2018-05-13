function a() {
    var name = $('#name').val();
    var lastname = $('#lastname').val();
    var email = $('#email').val();
    var password = $('#password').val();

    if (name == '' || lastname == '' || email == '' || password == '') {
        console.log("no name");
        return;
    }
    else {
        console.log(name, lastname, email, password);
        $.post("http://localhost:8080/add", {
            firstName: name,
            lastName: lastname,
            email: email,
            password: password
        }, function (data) {
        }).done(function () {
            alert("Вы успешно зарегестрировались!")

        }).fail(function (xhr, textStatus, errorThrown) {
            alert("Такой email уже существует!")
        });
    }
}

// function login() {
//     $.post("http://localhost:8080/login", {
//         email: $('#emaillog').val(),
//         password: $('#passwordlog').val()
//     }, function (data) {
//     }).done(function () {
//         console.log("enter access");
//     }).fail(function (xhr, textStatus, errorThrown) {
//         alert("Такой email не зарегестрирован!")
//     });
// }