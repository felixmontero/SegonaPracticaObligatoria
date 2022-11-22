<%@ page isELIgnored="false" %> <%@ taglib uri
="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ page
contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MAZE</title>
    <link rel="stylesheet" href="./css/maps.css">
</head>
<body>
    <form method="post" action="/start">
        <div class="form-field">

        <label for="mapElection">Benvingut! Elegeix un Mapa</label>
        </div>
        <select name="maps" id="maps">
            <option value="map1">Mapa</option>
            <option value="map2">Mapa2</option>
        </select>
        <input type="submit" value="jugar" class="btn">
    </form>
</body>
</html>