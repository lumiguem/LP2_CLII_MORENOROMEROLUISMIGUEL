<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Actualizar Proveedor</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #c5dec9;
            margin: 0;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        h1 {
            color: #2c5f2d;
            text-align: center;
        }
        form {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.2);
            width: 400px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            background: white;
        }
        th, td {
            border: 1px solid #4a7c59;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #4a7c59;
            color: white;
        }
        .submit-btn {
            width: 100%;
            padding: 10px;
            background-color: #4a7c59;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 16px;
        }
        .submit-btn:hover {
            background-color: #355e3b;
        }
    </style>
</head>
<body>

    <h1>Actualizar Proveedor</h1>

    <form method="post" action="ControladorProveedor">
        <% 
        String codigo = request.getAttribute("codigo").toString();
        String nombre = (request.getAttribute("nombre") != null) ? request.getAttribute("nombre").toString() : "";
        String rucprov = (request.getAttribute("rucprov") != null) ? request.getAttribute("rucprov").toString() : "";
        String rsocial = (request.getAttribute("rsocial") != null) ? request.getAttribute("rsocial").toString() : "";
        String email = (request.getAttribute("email") != null) ? request.getAttribute("email").toString() : "";
        String fechaing = (request.getAttribute("fechaing") != null) ? request.getAttribute("fechaing").toString() : "";
        %>
        
        <input type="hidden" name="codigo" value="<%= codigo %>">
        
        <table>
            <tr>
                <td>Nombre</td>
                <td><input type="text" name="nombre" value="<%= nombre %>" required></td>
            </tr>
            <tr>
                <td>RUC</td>
                <td><input type="text" name="rucprov" value="<%= rucprov %>" required></td>
            </tr>
            <tr>
                <td>Razón Social</td>
                <td><input type="text" name="rsocial" value="<%= rsocial %>" required></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="email" name="email" value="<%= email %>" required></td>
            </tr>
            <tr>
                <td>Fecha de Ingreso</td>
                <td><input type="date" name="fechaing" value="<%= fechaing %>" required></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Actualizar" class="submit-btn"></td>
            </tr>
        </table>
    </form>

</body>
</html>
