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

<strong>Reference:${boat.reference}</strong><br>
<strong>Manufacturer:${boat.manufacturer}</strong><br>
<strong>Model:${boat.model}</strong><br>
</body>
</html>
