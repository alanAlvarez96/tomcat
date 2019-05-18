package WS;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import Modelos.Clasificacion;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
@Path("/Clasificaciones")
public class WSClasificacion {
    @GET
    @Path("/get")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Clasificaciones";
    }
    @POST
    @Path("/insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Clasificacion post(Clasificacion clasificacion){
        clasificacion.insert();
        return clasificacion;
    }
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Clasificacion put(Clasificacion clasificacion){
        clasificacion.update();
        return clasificacion;
    }
    @DELETE
    @Path("/delete/{id_clasificacion}")
    @Produces(MediaType.APPLICATION_JSON)
    public Clasificacion delete(@PathParam("id_clasificacion")int idClasificacion){
        Clasificacion clasificacion=new Clasificacion();
        clasificacion.setIdClasificacion(idClasificacion);
        clasificacion.delete();
        return clasificacion;
    }

    @GET
    @Path("/listado")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Clasificacion> getAll(){
        Clasificacion clasificaciones=new Clasificacion();
        clasificaciones.listado();
        return clasificaciones.listado();
    }
}
