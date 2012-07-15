var OrderForm = function() {
    var self = {
        price: $("#current_price"),
        tax: $("#current_tax")
    };

    self.set_price = function(new_price) {
        self.price.text(new_price);
    };

    self.set_tax = function(new_tax) {
        self.tax.text(new_tax);
    };

    self.calculate_total = function() {
        $("#current_total").text("5000");
    };

    return self;
}();

$(function(){
    $("#items").change(function() {
        var id = $(this).val();
        var data_as_json;

        $.ajax({
            url: "/functionalTestingProject/item",
            data: {item_id : id},
            success: function(data) {
                data_as_json = JSON.parse(data);
                OrderForm.set_price(data_as_json["price"]);
                $('#current_tax').html(data_as_json["tax"]);
            },
            error: function() {
                alert('An error occurred, please try selecting another item.');
            }
        });

        OrderForm.calculate_total();
    });
});