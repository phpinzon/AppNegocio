
package webservice;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Servicios", targetNamespace = "http://WebService/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Servicios {


    /**
     * 
     * @param buscar
     * @return
     *     returns java.util.List<webservice.User>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarPorCodigoONombre", targetNamespace = "http://WebService/", className = "webservice.BuscarPorCodigoONombre")
    @ResponseWrapper(localName = "buscarPorCodigoONombreResponse", targetNamespace = "http://WebService/", className = "webservice.BuscarPorCodigoONombreResponse")
    @Action(input = "http://WebService/Servicios/buscarPorCodigoONombreRequest", output = "http://WebService/Servicios/buscarPorCodigoONombreResponse")
    public List<User> buscarPorCodigoONombre(
        @WebParam(name = "buscar", targetNamespace = "")
        String buscar);

    /**
     * 
     * @param codigo
     * @param precio
     * @param cantidad
     * @param nombre
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "Agregar")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Agregar", targetNamespace = "http://WebService/", className = "webservice.Agregar")
    @ResponseWrapper(localName = "AgregarResponse", targetNamespace = "http://WebService/", className = "webservice.AgregarResponse")
    @Action(input = "http://WebService/Servicios/AgregarRequest", output = "http://WebService/Servicios/AgregarResponse")
    public String agregar(
        @WebParam(name = "Codigo", targetNamespace = "")
        String codigo,
        @WebParam(name = "Nombre", targetNamespace = "")
        String nombre,
        @WebParam(name = "Precio", targetNamespace = "")
        float precio,
        @WebParam(name = "Cantidad", targetNamespace = "")
        int cantidad);

    /**
     * 
     * @param codigo
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "Eliminar")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Eliminar", targetNamespace = "http://WebService/", className = "webservice.Eliminar")
    @ResponseWrapper(localName = "EliminarResponse", targetNamespace = "http://WebService/", className = "webservice.EliminarResponse")
    @Action(input = "http://WebService/Servicios/EliminarRequest", output = "http://WebService/Servicios/EliminarResponse")
    public String eliminar(
        @WebParam(name = "Codigo", targetNamespace = "")
        String codigo);

    /**
     * 
     * @return
     *     returns java.util.List<webservice.User>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listar", targetNamespace = "http://WebService/", className = "webservice.Listar")
    @ResponseWrapper(localName = "listarResponse", targetNamespace = "http://WebService/", className = "webservice.ListarResponse")
    @Action(input = "http://WebService/Servicios/listarRequest", output = "http://WebService/Servicios/listarResponse")
    public List<User> listar();

    /**
     * 
     * @param codigoProducto
     * @return
     *     returns webservice.User
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarID", targetNamespace = "http://WebService/", className = "webservice.ListarID")
    @ResponseWrapper(localName = "listarIDResponse", targetNamespace = "http://WebService/", className = "webservice.ListarIDResponse")
    @Action(input = "http://WebService/Servicios/listarIDRequest", output = "http://WebService/Servicios/listarIDResponse")
    public User listarID(
        @WebParam(name = "codigoProducto", targetNamespace = "")
        String codigoProducto);

    /**
     * 
     * @param codigo
     * @param precio
     * @param cantidad
     * @param nombre
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "Actualizar")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Actualizar", targetNamespace = "http://WebService/", className = "webservice.Actualizar")
    @ResponseWrapper(localName = "ActualizarResponse", targetNamespace = "http://WebService/", className = "webservice.ActualizarResponse")
    @Action(input = "http://WebService/Servicios/ActualizarRequest", output = "http://WebService/Servicios/ActualizarResponse")
    public String actualizar(
        @WebParam(name = "Codigo", targetNamespace = "")
        String codigo,
        @WebParam(name = "Nombre", targetNamespace = "")
        String nombre,
        @WebParam(name = "Precio", targetNamespace = "")
        float precio,
        @WebParam(name = "Cantidad", targetNamespace = "")
        int cantidad);

}
