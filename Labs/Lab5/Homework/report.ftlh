<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Catalog Report</title>
</head>
<body>
    <h1>${catalog.name} Catalog</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Type</th>
                <th>Path</th>
                <th>Tags</th>
            </tr>
        </thead>
        <tbody>
            <#list catalog.documents as document>
                <tr>
                    <td>${document.id}</td>
                    <td>${document.type}</td>
                    <td>${document.path}</td>
                    <td>
                        <ul>
                            <#list document.tags as key, value>
                                <li>${key}: ${value}</li>
                            </#list>
                        </ul>
                    </td>
                </tr>
            </#list>
        </tbody>
    </table>
</body>
</html>