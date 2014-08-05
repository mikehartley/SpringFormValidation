<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page session="false" %>
<html>
    <head>
        <title>YOTTR :: Boat Saved Successfully</title>
    </head>
    <body>
        <h3>
            Boat Saved Successfully.
        </h3>

        <strong>Reference: </strong>${boat.reference}<br>
        <strong>Manufacturer: </strong>${boat.manufacturer}<br>
        <strong>Model: </strong>${boat.model}<br>
        <strong>Year of build: </strong>${boat.year}<br>
        <strong>Length: </strong>${boat.length}<br>
        <strong>Hull type: </strong>${boat.hullType}<br>
        <strong>Type of sailing: </strong>${boat.sailStyle}<br>
        <hr>
        <strong>Description</strong><br>
        ${boat.desc}
    </body>
</html>
