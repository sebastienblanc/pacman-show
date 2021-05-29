package org.sebi;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import io.smallrye.reactive.messaging.kafka.Record;

@Path("/score")
public class ScoreResource {

    @Inject
    UsernameGenerator nameGenerator;

    @Inject
    IdentifierGenerator idGenerator;

    @Inject @Channel("score-event") Emitter<Record<String, String>> scoreEmitter;
    @Inject @Channel("players") Emitter<Record<String, String>> playerEmitter;


        
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addScoreEvent(ScoreEvent event) {
        scoreEmitter.send(Record.of(event.getPlayer(),event.getGhost()));
    }

    @GET
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUser() {        
        String username = nameGenerator.getName();
        Player player = new Player();
        player.setName(username);
        player.setId(idGenerator.generateId(username));
        playerEmitter.send(Record.of(player.getId(),"{ \"id\" : \"" + player.getId() +
        "\", \"name\" : \"" + player.getName() + "\" }"));
        return Response.ok(player).build();
    }
}