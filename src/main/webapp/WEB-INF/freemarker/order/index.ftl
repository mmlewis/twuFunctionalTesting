<!DOCTYPE html>
<html>
<head>
    <#import "/spring.ftl" as spring />
    <title>Order Page</title>
</head>

<body>
    <select>
        <#list items as item>
            <option>${item.name}</option>
        </#list>
    </select>

    <div id="current_price">Price: </div>
</body>
</html>
