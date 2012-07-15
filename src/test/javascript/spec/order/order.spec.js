describe("OrderForm", function() {
    it("can get the correct tax", function() {
        OrderForm.get_price = function() { return "40.00" };
        OrderForm.get_tax = function() { return "0.10" };

        expect(OrderForm.calculate_total()).toBe(44);
    });
});