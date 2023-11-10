
<%@page import="webservice.User"%>
<%@page import="Modelo.UserService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container mt-4">
            <div class="card">
                <div>
                    <h5>Actualizar Producto</h5>  
                </div>
                <%
                    String Cod = (String) request.getAttribute("codigoProducto");
                UserService user=new UserService();
                User u=user.listarID(Cod);
                
                %>
                <div class="card-body">
                    <form action="Controlador">
                        <label>Codigo</label>
                        <input type="text" value="<%= u.getCodigoProducto()%>" name="txtcodigo" class="form-control">
                        <label>Nombre</label>
                        <input type="text" value="<%= u.getNombreProducto()%>" name="txtnombre" class="form-control">
                        <label>Precio</label>
                        <input type="number" value="<%= u.getPrecioUnitario()%>" name="txtprecio" step="0.01" class="form-control">
                        <label>Cantidad</label>
                        <input type="number" value="<%= u.getCantidadProducto()%>" name="txtcantidad" class="form-control">
                        <input type="submit" name="accion" value="Actualizar">
                        <a href="Controlador?accion=index">Regresar</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
