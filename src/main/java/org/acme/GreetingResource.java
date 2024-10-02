package org.acme;

import java.util.List;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MyEntity> list() {
        return MyEntity.listAll();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public void create(MyEntity myEntity) {
        MyEntity newEntity = new MyEntity();
        newEntity.field = myEntity.field;
        MyEntity.persist(newEntity);
    }
}
