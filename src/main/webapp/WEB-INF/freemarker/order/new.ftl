<!DOCTYPE html>
    <link href="/functionalTestingProject/static/css/order.css" rel="stylesheet"/>
    <link href="/functionalTestingProject/static/css/bootstrap.css" rel="stylesheet"/>

    <script src="/functionalTestingProject/static/js/lib/jquery-1.7.1.min.js" type="text/javascript"></script>
    <script src="/functionalTestingProject/static/js/order_validations.js" type="text/javascript"></script>
    <script src="/functionalTestingProject/static/js/order.js" type="text/javascript"></script>

    <#import "/spring.ftl" as spring />
<html>

<head>
    <title>Order Page</title>
</head>

<body>
    <#assign first_item=items[0]/>
    <#assign create_url='/order/create?itemId='/>
    <form action="<@spring.url '${create_url}'/>" id="newOrderForm" class="form_background" method="POST">
        <h4 id="form_title">Place Your Order</h4>

        <div>
            <label for="name">Name: </label>
            <input id="name_field" name="name" value="${order.name!}"></input>
        </div>

        <div>
            <label for="email">E-Mail: </label>
            <input id="email_field" name="email" value="${order.email!}"></input>
        </div>

        <div>
            <label for="item">Item: </label>
            <select id="items">
                <#list items as item>
                    <option class="order_item" name="item" value=${item.id}>${item.name}</option>
                </#list>
            </select>
        </div>

        <div class="cost">Price: $<span id="current_price">${first_item.price}</span></div>
        <div class="cost">Tax: <span id="current_tax">${first_item.tax}</span>%</div>
        <div class="cost">Total: $<span id="current_total"/></div>
        <input type="hidden" id="hidden_current_total" name="total" value=${order.total}/>

        <input id="submitButton" type="submit" name="submitButton" />

    </form>
</body>

</html>
