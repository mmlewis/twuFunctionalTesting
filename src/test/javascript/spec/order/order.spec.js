describe("OrderForm", function() {
    it("should set price and tax fields on initialization", function() {
        var price_field = $("<span />");
        var tax_field = $("<span />");

        var order_form = OrderForm.init(price_field, tax_field);

        expect(order_form.price).toBe(price_field);
    });

    it("should get price with two decimal places", function() {
        var price_field = $("<span>3.00</span>");
        var tax_field = $("<span />");

        var order_form = OrderForm.init(price_field, tax_field);

        expect(order_form.get_formatted_field(price_field)).toBe("3.00");
    });

    it("should get tax with two decimal places", function() {
        var price_field = $("<span>3.00</span>");
        var tax_field = $("<span>0.10</span>");

        var order_form = OrderForm.init(price_field, tax_field);

        expect(order_form.get_formatted_field(tax_field)).toBe("0.10");
    });

    it("should get total tax", function() {
        var price_field = $("<span>3.00</span>");
        var tax_field = $("<span>0.10</span>");

        var order_form = OrderForm.init(price_field, tax_field, null);

        expect(order_form.get_total_tax()).toBe("0.30");
    });

    it("should set total value in total field", function() {
        var price_field = $("<span>3.00</span>");
        var tax_field = $("<span>0.10</span>");
        var total_field = $("<span></span>");
        spyOn(total_field, "text");

        var order_form = OrderForm.init(price_field, tax_field, total_field);
        spyOn(order_form.hidden_total, "val")

        order_form.calculate_total();

        expect(total_field.text).wasCalledWith(3.3);
        expect(order_form.hidden_total.val).wasCalledWith(3.3);
    });

    it("should update price and tax", function() {
        var price_field = $("<span>3.00</span>");
        var tax_field = $("<span>0.10</span>");

        var order_form = OrderForm.init(price_field, tax_field, null);

        order_form.update("75.00", "0.10")

        expect(order_form.price.text()).toBe("75.00");
        expect(order_form.tax.text()).toBe("0.10");
    });
});