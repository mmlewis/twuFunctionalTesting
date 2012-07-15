var OrderForm = function() {
    var self = {
        name_field = $("#name_field"),
        email_field = $("#email_field");
    };

    self.validate_name = function() {
        valid_name = self.name_field.val().length === 0
        if(!valid_name) {
            name_field.
        }
    };

    self.validate_email = function() {
        if(self.email_field.val().length === 0);
    };

    self.validateSubmission = function() {
        self.validate_name();
        self.validate_email();
    }

    return self;
}();

//function() {
//    $("#submitButton").submit(function() {
//        OrderForm.validateSubmission();
//    });
//};