package Modelos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="Genero")
public class Genero {
    private int idGenero;
    private String genero;
    @XmlElement (required=true)
    public int getIdGenero() {
        return idGenero;
    }
    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    @XmlElement (required=true)
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void insert(){
        String query;
        query="insert into genero(genero) values('"+genero+"')";
        sqlUpdates(query);
    }
    public void update(){
        String query;
        query="update genero set genero='"+genero+"' where idgenero="+idGenero;
        sqlUpdates(query);
    }
    public void delete(){
        String query;
        query="delete from genero where idgenero="+idGenero;
        sqlUpdates(query);
    }
    public List<Genero>listado(){
        ArrayList<Genero> generos=new ArrayList<Genero>();
        Genero genero;
        Conexion conexion=new Conexion();
        Connection connection=conexion.getConnection();
        ResultSet resultSet;
        Statement statement;
        String query;
        query="select * from genero";
        try {
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            while (resultSet.next()){
                genero=new Genero();
                genero.setIdGenero(resultSet.getInt("idgenero"));
                genero.setGenero(resultSet.getString("genero"));
                generos.add(genero);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return generos;
    }
    private void sqlUpdates(String query){
        Conexion conexion=new Conexion();
        Statement statement;
        Connection connection=conexion.getConnection();
        try {
            statement=connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
