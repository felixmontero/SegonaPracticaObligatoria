<%@ page isELIgnored="false" %> <%@ taglib uri
="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ page
contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MAZE</title>
    <link rel="stylesheet" href="../../css/maps.css">
</head>
<body>
    <form method="post" action="/start">
        <label for="mapElection">Benvingut! Elegeix un Mapa</label>

        <select name="maps" id="maps">
            <c:forEach var="maze" items="${mazeList}">
                <option value="${maze.id}">${maze.name}</option>
            </c:forEach>
        </select>
        <input type="submit" value="jugar" class="btn">
    </form>
</body>
</html>