package org.acme;

import io.vertx.core.json.JsonObject;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("putri")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ResourceAja {

    @GET

    public List<Tugas6> list(){
        return Tugas6.listAll();
    }
    @POST
    @Transactional
    public Tugas6 insert(JsonObject body){
        Tugas6 tugas6 = new Tugas6();
        tugas6.bias = body.getString("bias");
        tugas6.field=body.getString("field");
        tugas6.nama=body.getString("nama");
        tugas6.productName= body.getString("productName");

        tugas6.persistAndFlush();
        return tugas6;

    }
    @PUT
    @Path("{name}")
    @Transactional
    public JsonObject updateProduct(@PathParam("name") String name, JsonObject body){
        String bias = body.getString("bias");
        String field=body.getString("field");
        String nama=body.getString("nama");
        String productName= body.getString("productName");

        Tugas6.update("bias=?1,field=?2,nama=?3,product_name=?4 where nama=?5",bias,field,nama,productName,nama);
        return body;

    }

    @DELETE
    @Path("{nama}")
    @Transactional
    public String deleted(@PathParam("nama") String name){
        Tugas6.delete("nama",name);
        return "Success deleted";
    }
}
