var OrderForm = function() {
    var self = {};

    self.calculate_total = function() {
        var total = parseFloat(self.get_price()) + parseFloat(self.get_total_tax());
        self.total.text(total);
        self.hidden_total.val(total);
    };

    self.get_price = function() {
        return self.get_formatted_field(self.price);
    };

    self.get_total_tax = function() {
        return parseFloat(self.get_formatted_field(self.price) * self.get_formatted_field(self.tax)).toFixed(2);
    };

    self.get_formatted_field = function(field) {
        return parseFloat(field.text()).toFixed(2);
    }

    self.update = function(new_price, new_tax) {
        self.price.text(new_price);
        self.tax.text(new_tax);
    }

    init = function(price_field, tax_field, total_field) {
        self.price = price_field;
        self.tax = tax_field;
        self.total = total_field;
        self.hidden_total = $("#hidden_current_total");

        return self;
    };

    return { init:init };
}();

$(function(){
    var order_form = OrderForm.init($("#current_price"), $("#current_tax"), $("#current_total"));
    order_form.calculate_total();

    $("#submitButton").click(function(event) {
        validator = OrderFormValidator.init($("#name_field"), $("#email_field"));
        if(validator.validate()) {
            var new_form = $("#newOrderForm");
            var action = new_form.attr("action");
            var selected_item_index = $("#items option:selected").val();

            new_form.attr("action", (action + selected_item_index));
        } else {
            event.preventDefault();
        }
    });

    $("#items").change(function() {
        var id = $(this).val();
        var data_as_json;

        $.ajax({
            url: "/functionalTestingProject/item",
            data: {item_id : id},
            success: function(data) {
                data_as_json = JSON.parse(data);
                order_form.update(data_as_json["price"], data_as_json["tax"]);
                order_form.calculate_total();
            },
            error: function() {
                alert('An error occurred, please try selecting another item.');
            }
        });
    });
});