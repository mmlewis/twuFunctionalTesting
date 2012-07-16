var OrderFormValidator = function() {
    var self = {};

    self.validate_not_blank = function(field_to_validate) {
        value_is_not_blank = field_to_validate !== null && field_to_validate.val() !== "";
        if(!value_is_not_blank) {
            field_to_validate.addClass("error");
        }

        return value_is_not_blank;
    };

    self.validate = function() {
        var name_not_blank = self.validate_not_blank(self.name);
        var email_not_blank = self.validate_not_blank(self.email);
        var valid_email_format = self.validate_email_format(self.email);

        return name_not_blank && email_not_blank && valid_email_format;
    };

    self.validate_email_format = function(email_field) {
        var email_pattern = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
        return email_field.val().match(email_pattern);
    };

    var init = function(name_field, email_field) {
        self.name = name_field;
        self.email = email_field;
        return self;
    }

    return { init: init };
}();