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
import model.*;
import exceptions.*;

import java.util.*;



@Path("/sensors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorResource {
    private static Map<String, Sensor> sensors = new HashMap<>();

    @POST
    public Response createSensor(Sensor sensor) {

        Room room = RoomResource.getRooms().get(sensor.getRoomId());

        if (room == null) {
            throw new InvalidRoomException("Invalid room, Room does not exist.");
        }

        sensors.put(sensor.getId(), sensor);
        room.getSensorIds().add(sensor.getId());

        return Response.status(201).entity(sensor).build();
    }

    @GET
    public List<Sensor> getSensors(@QueryParam("type") String type) {

        List<Sensor> result = new ArrayList<>();

        for (Sensor s : sensors.values()) {
            if (type == null || s.getType().equalsIgnoreCase(type)) {
                result.add(s);
            }
        }

        return result;
    }

    @GET
    @Path("/{id}")
    public Sensor getSensor(@PathParam("id") String id) {

        Sensor sensor = sensors.get(id);

        if (sensor == null) {
            throw new ResourceNotFoundException("Sensor not found");
        }

        return sensor;
    }
    
    @Path("/{id}/readings")
    public SensorReadingResource getReadings() {
        return new SensorReadingResource();
    }

    public static Map<String, Sensor> getSensorsMap() {
        return sensors;
    }
}
