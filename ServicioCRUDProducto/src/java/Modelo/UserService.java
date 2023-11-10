
package Modelo;

import java.util.List;
import webservice.User;

public class UserService {
    
    public UserService(){
    }

    public java.util.List<webservice.User> listar() {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listar();
    }

    public String agregar(java.lang.String codigo, java.lang.String nombre, float precio, int cantidad) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.agregar(codigo, nombre, precio, cantidad);
    }


    public User listarID(java.lang.String codigoProducto) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.listarID(codigoProducto);
    }
    
    
    public String actualizar(java.lang.String codigo, java.lang.String nombre, float precio, int cantidad) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.actualizar(codigo, nombre, precio, cantidad);
    }

    public String eliminar(java.lang.String codigo) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.eliminar(codigo);
    }

    public java.util.List<webservice.User> buscarPorCodigoONombre(java.lang.String buscar) {
        webservice.Servicios_Service service = new webservice.Servicios_Service();
        webservice.Servicios port = service.getServiciosPort();
        return port.buscarPorCodigoONombre(buscar);
    }

}


