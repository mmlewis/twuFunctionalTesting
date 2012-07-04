<!DOCTYPE html>
<html>
<head>
    <title>kabaddi</title>
</head>

<body>
    <#if user??>
        <h1>Hallo ${user.name}</a>
    <#else>
        <#if username??>
            <h1>Sorry, didn't find a user called "${username}"</h1>
        </#if>
        <p><a href="?username=bill">Try me</a></p>
    </#if>
</h1>

</body>
</html>
