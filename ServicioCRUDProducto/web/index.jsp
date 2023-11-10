
<%@page import="Modelo.UserService"%>
<%@page import="webservice.User"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <table style="width:100%; height:15vh; display:table;">
        <tr style="display:table-row;">
            <td style="text-align:center; vertical-align:middle; display:table-cell;">
                <form action="Controlador" method="get">
                    <input type="hidden" name="accion" value="buscar">
                    <label for="buscar"><b>Buscar por código o nombre:</b></label>
                    <input type="search" id="buscar" name="buscar">
                    <input type="submit" value="Buscar">
                </form>
            </td>
        </tr>
        </table>

        <div class="container mt-4">
            <div class="card">
                <div>
                    <a href="Controlador?accion=add" class="ptn btn-primary">Nuevo Producto</a>  
                </div>
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>CODIGO</th>
                                <th>NOMBRE</th>
                                <th>PRECIO</th>
                                <th>CANTIDAD</th>
                            </tr>
                        </thead>
                        <% UserService userService = new UserService();
                       List<User> datos;
                       if (request.getAttribute("productos") != null) {
                           datos = (List<User>) request.getAttribute("productos");
                       } else {
                           datos = userService.listar();
                       }
                       for(User u:datos){ %>
                        <tbody>
                            <tr>
                                <td><%= u.getCodigoProducto()%></td>
                                <td><%= u.getNombreProducto()%></td>
                                <td><%= u.getPrecioUnitario()%></td>
                                <td><%= u.getCantidadProducto()%></td>
                                <td>
                                    <a href="Controlador?accion=editar&codigoProducto=<%= u.getCodigoProducto()%>" class="btn btn-waring">Edit</a>
                                    <a href="Controlador?accion=eliminar&codigoProducto=<%= u.getCodigoProducto()%>" class="btn btn-danger">Delete</a>
                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table> 
                </div>
            </div>
        </div>
    </body>
</html>

