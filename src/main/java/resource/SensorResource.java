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
            throw new RuntimeException("Invalid room");
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

    @Path("/{id}/readings")
    public SensorReadingResource getReadings() {
        return new SensorReadingResource();
    }

    public static Map<String, Sensor> getSensorsMap() {
        return sensors;
    }
}
