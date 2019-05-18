package Modelos;
//imports de utilidades
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//imports de  utilidades para regreso de datos
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="Categorias")
public class Clasificacion {
    private int idClasificacion;
    private String clasificacion;
    @XmlElement (required=true)
    public int getIdClasificacion() {
        return idClasificacion;
    }
    public void setIdClasificacion(int idClasificacion) {
        this.idClasificacion = idClasificacion;
    }
    @XmlElement (required=true)
    public String getClasificacion() {
        return clasificacion;
    }
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void insert(){
        Conexion conexion=new Conexion();
        Connection connection=conexion.getConnection();
        String query="insert into clasificacion(clasificacion) values('"+clasificacion+"')";
        try {
            Statement statement=connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void update(){
        Conexion conexion=new Conexion();
        Connection connection=conexion.getConnection();
        String query="update clasificacion values set clasificacion='"+clasificacion+"'where idclasificacion="+idClasificacion;
        try {
            Statement statement=connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void delete(){
        Conexion conexion=new Conexion();
        Connection connection=conexion.getConnection();
        String query="delete from clasificacion where idclasificacion="+idClasificacion;
        try {
            Statement statement=connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public List<Clasificacion>listado() {
        ArrayList<Clasificacion> clasificaciones = new ArrayList<Clasificacion>();
        Conexion conexion = new Conexion();
        Clasificacion clasificacion;
        Connection connection = conexion.getConnection();
        ResultSet resultSet;
        Statement statement1;
        String query = "select * from clasificacion";
                try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                clasificacion = new Clasificacion();
                clasificacion.setIdClasificacion(resultSet.getInt("idclasificacion"));
                clasificacion.setClasificacion(resultSet.getString("clasificacion"));
                clasificaciones.add(clasificacion);
            }
        } catch (SQLException e) {
        }
        return clasificaciones;
    }
}


