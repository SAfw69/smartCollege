/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resource;

/**
 *
 * @author poema
 */

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import model.Room;
import exceptions.*;


import java.util.*;


@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomResource {
    
    private static Map<String,Room> rooms = new HashMap<>();
    
    @GET
    public Collection<Room> getAllRooms(){
        return rooms.values();
    }
    
    @POST
    public Response createRoom(Room room){
        rooms.put(room.getID(), room);
        return Response.status(201).entity(room).build();
        
        
    }
    
    @GET
    @Path("/{id}")
    public Room getRoom(@PathParam("id") String ID){
        
        Room room = rooms.get(ID);
        if (room == null) {
            throw new ResourceNotFoundException("Room not found");
        }

        return room;
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteRoom(@PathParam("id") String id) {

        Room room = rooms.get(id);
        
        if(room == null){
            throw new ResourceNotFoundException("Room not found");

        }else if (!room.getSensorIds().isEmpty()) {
            throw new RoomNotEmptyException("Room not empty");
        }else{
        rooms.remove(id);
        return Response.ok().build();
        }
    }

    public static Map<String, Room> getRooms() {
        return rooms;
    }
    
}
