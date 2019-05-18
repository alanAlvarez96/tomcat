package WS;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import Modelos.Usuario;


import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
@Path("/Usuarios")
public class WSUsuario {
    @GET
    @Path("/listado")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getAll(){
        Usuario usuario=new Usuario();
        return usuario.listado();
    }
    @DELETE
    @Path("/delete/{idUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario delete(@PathParam("idUsuario")int idUsuario){
        Usuario usuario=new Usuario();
        usuario.setIdusuario(idUsuario);
        usuario.delete();
        return usuario;
    }
    @POST
    @Path("/insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario post(Usuario usuario){
        usuario.insert();
        return usuario;
    }
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String login(Usuario usuario){
        if(usuario.login())
            return "{valid:1}";
        return "{valid:0}";
    }

}
