var OrderForm = function() {
    var self = {
        price: "#current_price",
        tax: "#current_tax"
    };

    self.init = function(new_price, new_tax) {
        $(self.price).text(new_price);
        $(self.tax).text(new_tax);
    };

    self.calculate_total = function() {
        var total = parseInt(self.get_price()) + parseInt(self.get_price() * self.get_tax());
        $("#current_total").text(total);
        $("#hidden_current_total").val(total);
    };

    self.get_price = function() {
        var price = $(self.price).text();
        return parseFloat(price).toFixed(2);
    }

    self.get_tax = function() {
        var tax = $(self.tax).text();
        return parseFloat(tax).toFixed(2);
    }

    return self;
}();

$(function(){
    OrderForm.calculate_total();

    $("#submitButton").click(function() {
        if(OrderFormValidator.validate()) {
            var new_form = $("#newOrderForm");
            var action = new_form.attr("action");
            var selected_item_index = $("#items option:selected").val();

            new_form.attr("action", (action + selected_item_index));
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
                OrderForm.init(data_as_json["price"], data_as_json["tax"]);
                OrderForm.calculate_total();
            },
            error: function() {
                alert('An error occurred, please try selecting another item.');
            }
        });
    });
});