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
@XmlRootElement(name="Usuario")
public class Usuario {
    private int idusuario;
    private String nombre;
    private String apellido;
    private String fecharegistro;
    private int ncompras;
    private String correo;
    private String password;

    @XmlElement (required=true)
    public int getIdusuario() {
        return idusuario;
    }
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    @XmlElement (required=true)
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @XmlElement (required=true)
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    @XmlElement (required=true)
    public String getFecharegistro() {
        return fecharegistro;
    }
    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }
    @XmlElement (required=true)
    public int getNcompras() {
        return ncompras;
    }
    public void setNcompras(int ncompras) {
        this.ncompras = ncompras;
    }
    @XmlElement (required=true)
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    @XmlElement (required=true)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void insert(){
        String query;
        query="insert into usuarios(nombre,apellido,correo,password) values('"+nombre+"','"+apellido+"','"+correo+"','"+password+"')";
        sqlUpdates(query);
    }
    public void delete(){
        String query;
        query="delete from usuarios where idusuario="+idusuario;
        sqlUpdates(query);
    }
    public List<Usuario> listado(){
        ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
        Usuario usuario;
        Conexion conexion=new Conexion();
        Connection connection=conexion.getConnection();
        ResultSet resultSet;
        Statement statement;
        String query;
        query="select * from usuarios";
        try {
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            while (resultSet.next()){
                usuario=new Usuario();
                usuario.setIdusuario(resultSet.getInt("idusuario"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setApellido(resultSet.getString("apellido"));
                usuario.setFecharegistro(resultSet.getString("fecharegistro"));
                usuario.setCorreo(resultSet.getString("correo"));
                usuario.setNcompras(resultSet.getInt("ncompras"));
                usuarios.add(usuario);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return usuarios;
    }
    public boolean login(){
        Conexion conexion=new Conexion();
        Connection connection=conexion.getConnection();
        ResultSet resultSet;
        Statement statement;
        String query;
        query="select * from usuarios where correo='"+correo+"' and password='"+password+"'";
        try {
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            if(resultSet.next())
                return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
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
