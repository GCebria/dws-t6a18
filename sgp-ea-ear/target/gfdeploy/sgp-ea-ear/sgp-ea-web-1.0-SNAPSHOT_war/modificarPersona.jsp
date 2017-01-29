<%-- 
    Document   : modificarPersona
    Created on : 07-nov-2016, 11:47:02
    Author     : lodiade
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Modificar Persona</title>
</head>
<body>

    <h1>Modificar Persona</h1>

    <form action="ModificarPersona?accion=modificar&id=${persona.id}" method="post">

        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" value="${persona.nombre}" style="display: block;" />

        <label for="email">eMail:</label>
        <input type="text" name="email" value="${persona.email}" style="display: block;"/>

        <label for="telefono">Teléfono:</label>
        <input type="text" name="telefono" value="${persona.telefono}" style="display: block;"/>

        <input type="submit" name="guardar" value="guardar">
    </form>
</body>
</html>
