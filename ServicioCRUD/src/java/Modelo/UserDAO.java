
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements CRUD{
        PreparedStatement ps;
        ResultSet rs;
        Connection con;
        Conexion conex=new Conexion();
        int res;
        String msj;
        User user=new User();
        
    @Override
    public List listar() {
       List<User>  datos=new ArrayList<>();
       String sql="select * from producto";
       try{
           con=conex.getConnection();
           ps=con.prepareStatement(sql);
           rs=ps.executeQuery();
           while(rs.next()){
               User u=new User();
               u.setCodigoProducto(rs.getString("codigoProducto"));
               u.setNombreProducto(rs.getString("nombreProducto"));
               u.setPrecioUnitario(rs.getFloat("precioUnitario"));
               u.setCantidadProducto(rs.getInt("cantidadProducto"));
               datos.add(u);
           }
       }catch (Exception e){   
       }
       return datos;
    }

    @Override
    public User listarID(String codigoProducto) {
    String sql="select * from producto where codigoProducto = ?";
    try {
        con=conex.getConnection();
        ps=con.prepareStatement(sql);
        ps.setString(1, codigoProducto);
        rs=ps.executeQuery();
        while(rs.next()){
            user.setCodigoProducto(rs.getString("codigoProducto"));
            user.setNombreProducto(rs.getString("nombreProducto"));
            user.setPrecioUnitario(rs.getFloat("precioUnitario"));
            user.setCantidadProducto(rs.getInt("cantidadProducto"));
        }
    } catch (Exception e){
                
    }
    return user;
}


    @Override
    public String add(String codigoProducto, String nombreProducto, float precioUnitario, int cantidadProducto) {
        String sql="insert into producto(codigoProducto, nombreProducto, precioUnitario, cantidadProducto)values(?,?,?,?)";
        try{
            con=conex.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, codigoProducto);
            ps.setString(2, nombreProducto);
            ps.setFloat(3, precioUnitario);
            ps.setInt(4, cantidadProducto);
            res=ps.executeUpdate();
            if(res==1){
                msj="Usuario Agregado";
            }else{
                msj="Error";
            }
            
        } catch (Exception e){   
        }
        return msj;
    }

    @Override
    public String edit(String codigoProducto, String nombreProducto, float precioUnitario, int cantidadProducto) {
        String sql="update producto set nombreProducto=?, precioUnitario=?, cantidadProducto=? where codigoProducto="+codigoProducto;
        try{
           con=conex.getConnection();
           ps=con.prepareStatement(sql);
           ps.setString(1, nombreProducto);
           ps.setFloat(2, precioUnitario);
           ps.setInt(3, cantidadProducto);
           res=ps.executeUpdate();
           if (res==1){
               msj="Usuario Actualizado";
           }else{
               msj="Error";
           }
        }catch(Exception e){
            
        }
        return msj;
    }

    @Override
    public User delete(String codigoProducto) {
    String sql="delete from producto where codigoProducto=?";
    try{
        con=conex.getConnection();
        ps=con.prepareStatement(sql);
        ps.setString(1, codigoProducto);
        ps.executeUpdate();
    }catch(Exception e){
    }
    return user;   
}  

    @Override
    public List<User> buscarPorCodigoONombre(String buscar) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE codigoProducto LIKE ? OR nombreProducto LIKE ?";
    try {
        con = conex.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, "%" + buscar + "%");
        ps.setString(2, "%" + buscar + "%");
        rs = ps.executeQuery();
        while (rs.next()) {
            User u = new User();
            u.setCodigoProducto(rs.getString("codigoProducto"));
            u.setNombreProducto(rs.getString("nombreProducto"));
            u.setPrecioUnitario(rs.getFloat("precioUnitario"));
            u.setCantidadProducto(rs.getInt("cantidadProducto"));
            users.add(u);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return users;
}

}
