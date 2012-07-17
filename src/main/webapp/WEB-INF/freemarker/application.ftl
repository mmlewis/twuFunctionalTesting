<#macro template title>
<!DOCTYPE html>

<html>
    <head>
        <link href="/functionalTestingProject/static/css/order.css" rel="stylesheet"/>
        <link href="/functionalTestingProject/static/css/bootstrap.css" rel="stylesheet"/>

        <script src="/functionalTestingProject/static/js/lib/jquery-1.7.1.min.js" type="text/javascript"></script>
        <script src="/functionalTestingProject/static/js/order_validator.js" type="text/javascript"></script>
        <script src="/functionalTestingProject/static/js/order.js" type="text/javascript"></script>
    </head>
    <body>
        <title>${title}</title>

         <#nested/>
    </body>
</html>

</#macro>