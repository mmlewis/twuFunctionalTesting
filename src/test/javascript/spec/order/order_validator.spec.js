describe("OrderFormValidator", function() {
    it("should add error if value is blank", function() {
        var name_field = $("<input />");
        spyOn(name_field, "addClass");

        order_form_validator = OrderFormValidator.init(name_field)

        expect(order_form_validator.validate_not_blank(name_field)).toBeFalsy();
        expect(name_field.addClass).wasCalledWith("error");
    });

    it("should not add error if value is not blank", function() {
        var name_field = $("<input value=\"Entered Name\" />");
        spyOn(name_field, "addClass");

        order_form_validator = OrderFormValidator.init(name_field)

        expect(order_form_validator.validate_not_blank(name_field)).toBeTruthy();
        expect(name_field.addClass).not.wasCalledWith("error");
    });

    it("should call validate not blank for name and email fields", function() {
        var name_field = $("<input value=\"Entered Name\" />");
        var email_field = $("<input value=\"entered@email.com\" />");

        var order_form_validator = OrderFormValidator.init(name_field, email_field);
        spyOn(order_form_validator, "validate_not_blank");
        spyOn(order_form_validator, "validate_email_format");

        order_form_validator.validate();

        expect(order_form_validator.validate_not_blank).wasCalledWith(name_field);
        expect(order_form_validator.validate_not_blank).wasCalledWith(email_field);
        expect(order_form_validator.validate_email_format).wasCalledWith(email_field);
    });

    it("should return true when both fields are not blank", function() {
        var name_field = $("<input value=\"Entered Name\" />");
        var email_field = $("<input value=\"entered@email.com\" />");

        var order_form_validator = OrderFormValidator.init(name_field, email_field);
        spyOn(order_form_validator, "validate_not_blank").andCallFake(function() {return true;});

        expect(order_form_validator.validate()).toBeTruthy();
    });

    it("should return false when both fields are blank", function() {
        var name_field = $("<input />");
        var email_field = $("<input />");

        var order_form_validator = OrderFormValidator.init(name_field, email_field);
        spyOn(order_form_validator, "validate_not_blank").andCallFake(function() {return false;});

        expect(order_form_validator.validate()).toBeFalsy();
    });

    it("should return false when email is thre wrong format but both fields are not blank", function() {
        var name_field = $("<input />");
        var email_field = $("<input />");

        var order_form_validator = OrderFormValidator.init(name_field, email_field);
        spyOn(order_form_validator, "validate_not_blank").andCallFake(function() {return true;});
        spyOn(order_form_validator, "validate_email_format").andCallFake(function() {return false;});

        expect(order_form_validator.validate()).toBeFalsy();
    });

    it("should return true if value matches email format", function() {
        var email_field = $("<input value=\"entered@email.com\"/>");

        var order_form_validator = OrderFormValidator.init(null, email_field);

        expect(order_form_validator.validate_email_format(email_field)).toBeTruthy();
    });

    it("should return false if value does not match email format", function() {
        var email_field = $("<input value=\"enteredemail.com\"/>");

        var order_form_validator = OrderFormValidator.init(null, email_field);

        expect(order_form_validator.validate_email_format(email_field)).toBeFalsy();
    });
});