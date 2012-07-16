<html>
    <link href="/functionalTestingProject/static/css/order.css" rel="stylesheet"/>
    <link href="/functionalTestingProject/static/css/bootstrap.css" rel="stylesheet"/>

<head>
    <#import "/spring.ftl" as spring />
    <title>Order Page</title>
</head>

<body>
    <div class="form_background">
        <#if order??>
           <div class="header">Order Saved!</div>

           <div>
               <label for="name">Name: </label>
               <input name="name" value=${order.name} readonly="readonly" type="text" size="300"/>
           </div>

           <div>
               <label for="email">Email: </label>
               <input name="email" value=${order.email} readonly="readonly" type="text"/>
           </div>

           <div>
               <label for="item">Item Name: </label>
               <input name="item" value=${order.item.name} readonly="readonly" type="text" size="300"/>
           </div>

           <div>
               <label for="total">Total: </label>
               <input name="total" value=${order.total} readonly="readonly" type="text"/>
           </div>
        <#else>
            <div>Sorry the order was not saved..</div>
        </#if>
    </div>

</body>

</html>
