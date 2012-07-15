<!DOCTYPE html>
<html>
<head>
    <#import "/spring.ftl" as spring />
    <title>Order Page</title>
</head>

<body>
   <#if savedOrder??>
       <div>Order Saved!</div>

       <label for="name">Name: </label>
       <div name="name">${order.name}</div>
   <#else>
        Sorry the order was not saved..
   </#if>

</body>

</html>
