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
@XmlRootElement(name="Pelicula")
public class Pelicula {
    private int idPelicula;
    private int duracion;
    private int idgenero;
    private int idclasificacion;
    private String titulo,sinopsis;

    @XmlElement (required=true)
    public int getIdPelicula() {
        return idPelicula;
    }
    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    @XmlElement (required=true)
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @XmlElement (required=true)
    public int getIdgenero() {
        return idgenero;
    }
    public void setIdgenero(int idgenero) {
        this.idgenero = idgenero;
    }

    @XmlElement (required=true)
    public int getIdclasificacion() {
        return idclasificacion;
    }
    public void setIdclasificacion(int idclasificacion) {
        this.idclasificacion = idclasificacion;
    }

    @XmlElement (required=true)
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @XmlElement (required=true)
    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void insert(){
        String query;
        query="insert into pelicula(titulo, sinopsis, duracion, idgenero, idclasificacion) values ('"+titulo+"','"+sinopsis+"',"+duracion+","+idgenero+","+idclasificacion+")";
        sqlUpdates(query);
    }
    public void update(){
        String query;
        query="update pelicula set duracion="+duracion+",idgenero="+idgenero+",idclasificacion="+idclasificacion+",sinopsis='"+sinopsis+"',"+"titulo='"+titulo+"' where idpelicula="+idPelicula;
        sqlUpdates(query);
    }
    public void delete(){
        String query;
        query="delete from pelicula where idpelicula="+idPelicula;
        sqlUpdates(query);
    }
    public List<Pelicula> listado(){
        ArrayList<Pelicula> peliculas=new ArrayList<Pelicula>();
        Pelicula pelicula;
        Conexion conexion=new Conexion();
        Connection connection=conexion.getConnection();
        ResultSet resultSet;
        Statement statement;
        String query;
        query="select * from pelicula";
        try {
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            while (resultSet.next()){
                pelicula=new Pelicula();
                pelicula.setIdPelicula(resultSet.getInt("idPelicula"));
                pelicula.setDuracion(resultSet.getInt("duracion"));
                pelicula.setIdclasificacion(resultSet.getInt("idclasificacion"));
                pelicula.setIdgenero(resultSet.getInt("idgenero"));
                pelicula.setSinopsis(resultSet.getString("sinopsis"));
                pelicula.setTitulo(resultSet.getString("titulo"));
                peliculas.add(pelicula);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return peliculas;
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
