<#macro template title>
<!DOCTYPE html>

<html>
    <head>
        <link href="/twuFunctionalTesting/static/css/order.css" rel="stylesheet"/>
        <link href="/twuFunctionalTesting/static/css/bootstrap.css" rel="stylesheet"/>

        <script src="/twuFunctionalTesting/static/js/lib/jquery-1.7.1.min.js" type="text/javascript"></script>
        <script src="/twuFunctionalTesting/static/js/order_validator.js" type="text/javascript"></script>
        <script src="/twuFunctionalTesting/static/js/order.js" type="text/javascript"></script>
    </head>
    <body>
        <title>${title}</title>

         <#nested/>
    </body>
</html>

</#macro>