$().ready(function () {

    $("#register").validate({

        rules: {
            email: {
                required: true,
                email: true
            },
            name: "required",
            surname: "required",
            phone_number: {
                required: true,
                number: true,
                minlength: 10,
                maxlength: 10
            },
            password: {
                required: true,
                minlength: 5
            },
            confirm_password: {
                required: true,
                minlength: 5,
                equalTo: "#password"
            },
        },

        messages: {
            email: {
                required:
                    " Please enter an email",
                email:
                    " Please enter a valid email"
            },
            name:
                " Please enter your name",
            surname:
                " Please enter your surname",
            phone_number: {
                required:
                    " Please enter a phone number",
                number:
                    " Please enter a valid number",
                minlength:
                    " Please enter a valid number",
                maxlength:
                    "Please enter a valid number"
            },
            password: {
                required:
                    " Please enter a password",
                minlength:
                    " Your password must be consist of at least 5 characters"
            },
            confirm_password: {
                required:
                    " Please enter a password",
                minlength:
                    " Your password must be consist of at least 5 characters",
                equalTo:
                    " Please enter the same password as above"
            },
        }
    });

});

// Girilen değeri 10 karaktere kadar kırpar"

document.getElementById("phone_number").addEventListener("input", function() {
    if (this.value.length > 10) {
        this.value = this.value.slice(0, 10);
    }
});