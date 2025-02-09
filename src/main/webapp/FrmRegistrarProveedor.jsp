<%@page import="model.TblProveedorcl2"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registrar Proveedor</title>
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
        td a {
            text-decoration: none;
            padding: 5px 10px;
            border-radius: 4px;
        }
        .update-btn {
            background-color: #2c5f2d;
            color: white;
        }
        .delete-btn {
            background-color: #c0392b;
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
        .message {
            color: green;
            font-weight: bold;
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>
	
    <h1>Registrar Proveedor</h1>
    
    <form method="post" action="ControladorProveedor">
        <table>
            <tr>
                <td>Nombre</td>
                <td><input type="text" name="nombre" required></td>
            </tr>
            <tr>
                <td>RUC</td>
                <td><input type="text" name="rucprov" required></td>
            </tr>
            <tr>
                <td>Razón Social</td>
                <td><input type="text" name="rsocial" required></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="email" name="email" required></td>
            </tr>
            <tr>
                <td>Fecha de Ingreso</td>
                <td><input type="date" name="fechaing" required></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Registrar" class="submit-btn"></td>
            </tr>
        </table>
    </form>

    <% 
    String mensaje = (String) request.getAttribute("mensaje");
    if (mensaje != null) { 
    %>
        <div class="message"><%= mensaje %></div>
    <% 
    } 
    %>

    <h1>Listado de Proveedores</h1>
    
    <table>
        <tr>
            <th>Código</th>
            <th>Nombre</th>
            <th>RUC</th>
            <th>Razón Social</th>
            <th>Email</th>
            <th>Fecha de Ingreso</th>
            <th colspan="2">Acciones</th>
        </tr>
        <%
        List<TblProveedorcl2> listadoproveedores = (List<TblProveedorcl2>) request.getAttribute("listado");
        if (listadoproveedores != null) {
            for (TblProveedorcl2 prov : listadoproveedores) {
        %>
            <tr>
                <td><%= prov.getIdproveedorcl2() %></td>
                <td><%= prov.getNomproveecl2() %></td>
                <td><%= prov.getRucproveecl2() %></td>
                <td><%= prov.getRsocialproveecl2() %></td>
                <td><%= prov.getEmailproveecl2() %></td>
                <%
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
%>
<td><%= sdf.format(prov.getFeingproveecl2()) %></td>
                <td><a href="ControladorProveedor?accion=Modificar&cod=<%= prov.getIdproveedorcl2() %>" class="update-btn">Actualizar</a></td>
                <td><a href="ControladorProveedor?accion=Eliminar&cod=<%= prov.getIdproveedorcl2() %>" class="delete-btn">Eliminar</a></td>
            </tr>
        <%
            }
        }
        %>
    </table>

</body>
</html>
