/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import Modelo.User;
import Modelo.UserDAO;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "Servicios")
public class Servicios {
    UserDAO dao=new UserDAO();
    @WebMethod(operationName = "listar")
    public List<User> listar() {
        List datos=dao.listar();
        return datos;
    }

    
    @WebMethod(operationName = "Agregar")
    public String Agregar(@WebParam(name="Codigo") String Codigo, @WebParam(name = "Nombre") String Nombre, @WebParam(name = "Precio") float Precio, @WebParam(name = "Cantidad") int Cantidad) {
        String datos=dao.add(Codigo, Nombre, Precio, Cantidad);
        return datos;
    }

   
    @WebMethod(operationName = "listarID")
    public User listarID(@WebParam(name = "codigoProducto") String codigoProducto) {
        User user=dao.listarID(codigoProducto);
        return user;
    }

 
    @WebMethod(operationName = "Actualizar")
    public String Actualizar(@WebParam(name = "Codigo") String Codigo, @WebParam(name = "Nombre") String Nombre, @WebParam(name = "Precio") float Precio, @WebParam(name = "Cantidad") int Cantidad) {
        String datos=dao.edit(Codigo, Nombre, Precio, Cantidad);
        return datos;
    }


    @WebMethod(operationName = "Eliminar")
    public String Eliminar(@WebParam(name = "Codigo") String Codigo) {
        dao.delete(Codigo);
        return "Producto eliminado";
    }

    @WebMethod(operationName = "buscarPorCodigoONombre")
    public List<User> buscarPorCodigoONombre(@WebParam(name = "buscar") String buscar) {
        return dao.buscarPorCodigoONombre(buscar);
    }

}
