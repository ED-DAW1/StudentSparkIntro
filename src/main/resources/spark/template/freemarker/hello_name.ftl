<!DOCTYPE html>
<html>
<head>
        <title>Tu primera página en HTML5</title>
</head>
<body>
        <p>Página dinámica generada por: <em>${name}</em> con freemarker</p>
        <p> numero : <strong>${numero}</strong> </p>

        <p> Lista de colores primarios</p>
        <ul>
            <#list colores as color>
                <li>${color}</li>
            </#list>            
        </ul>
</body>
</html>