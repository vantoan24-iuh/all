package vn.edu.iuh.fit.backend.api;

import jakarta.ejb.EJB;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.entities.Thuoc;
import vn.edu.iuh.fit.backend.services.QLThuocService;

@Path("/medicine")
public class ThuocResource {
   @EJB
   private QLThuocService qLThuocService;

   @GET
   @Produces("application/json")
    public Response getAll_Thuoc() {
        return Response.ok(qLThuocService.getAllDTO()).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Transactional
    public Response add_Thuoc(Thuoc thuoc) {
        qLThuocService.save(thuoc);
        return Response.ok().build();
    }
}