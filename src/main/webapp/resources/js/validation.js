$(document).ready(function () {
    jQuery.validator.addMethod("lettersonly", function(value, element) {
        return this.optional(element) || /^[a-z ]+$/i.test(value);
    }, "Letters and spaces only please");

    $("#updateDepartment").validate({
        rules: {
            name: {
                required: true,
                lettersonly: true,
                minlength: 3,
                maxlength: 30
            }
        },
        messages: {
            name: {
                required: "Please enter the Name of Department",
                lettersonly: "Department can't contains any numbers",
                minlength: "Please enter the Department Name more than 2 chars",
                maxlength: "Please enter the Department Name less than 30 chars"
            }
        }
    });


    $("#updateEmployee").validate({
        rules: {
            firstName: {
                required: true,
                lettersonly: true,
                minlength: 3,
                maxlength: 30
            },
            secondName: {
                required: true,
                lettersonly: true,
                minlength: 3,
                maxlength: 30
            }
        },
        messages: {
            firstName: {
                required: "Please enter the FirstName of Employee",
                lettersonly: "Employee's FirstName can't contains any numbers",
                minlength: "Please enter the Employee FirstName more than 2 chars",
                maxlength: "Please enter the Employee FirstName less than 30 chars"
            },
            secondName: {
                required: "Please enter the SecondName of Employee",
                lettersonly: "Employee's SecondName can't contains any numbers",
                minlength: "Please enter the Employee SecondName more than 2 chars",
                maxlength: "Please enter the Employee SecondName less than 30 chars"
            }
        }
    });
});