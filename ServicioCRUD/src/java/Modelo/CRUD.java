
package Modelo;

import java.util.List;

public interface CRUD {
    public List listar();
    public User listarID(String codigoProducto);
    public String add(String codigoProducto, String nombreProducto, float precioUnitario, int cantidadProducto);
    public String edit(String codigoProducto, String nombreProducto, float precioUnitario, int cantidadProducto);
    public User delete(String codigoProducto);
    List<User> buscarPorCodigoONombre(String buscar);
}
