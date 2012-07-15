<!DOCTYPE html>
    <link href="/functionalTestingProject/static/css/order.css" rel="stylesheet"/>
    <link href="/functionalTestingProject/static/css/bootstrap.css" rel="stylesheet"/>

    <script src="/functionalTestingProject/static/js/lib/jquery-1.7.1.min.js" type="text/javascript"></script>
    <script src="/functionalTestingProject/static/js/item_ajax.js" type="text/javascript"></script>

    <#import "/spring.ftl" as spring />
<html>

<head>
    <title>Order Page</title>
</head>

<body>
    <form action="<@spring.url '/order/create'/>" id="newOrderForm" method="POST">
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
            <select id="items" name="item">
                <#list items as item>
                    <option class="order_item" value=${item.id}>${item.name}</option>
                </#list>
            </select>
        </div>

        <div>Price: <span id="current_price"/></div>
        <div>Tax: <span id="current_tax"/></div>
        <div>Total: <span id="current_total" name="total"/></div>

        <input id="submitButton" type="submit" name="submitButton" />

    </form>
</body>

</html>
