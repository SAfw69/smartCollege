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

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class SensorReadingResource {
    
    private static Map<String, List<SensorReading>> readings= new HashMap<>();
    
    @GET
    public List<SensorReading> getreadings(@PathParam("id") String sensorId){
        return readings.getOrDefault(sensorId, new ArrayList<>());
    }
    
    @POST
    public Response addReading(@PathParam("id") String SensorID, SensorReading Reading){
        Sensor sensor = SensorResource.getSensorsMap().get(SensorID);
        
        if(sensor==null){
            throw new ResourceNotFoundException("Sensor not found");
        }else if ("MAINTENANCE".equalsIgnoreCase(sensor.getStatus())) {
            throw new SensorUnavailableException("Sensor under maintenance");
        }else{
        sensor.setCurrentValue(Reading.getValue());
        
        readings.putIfAbsent(SensorID, new ArrayList<>());
        readings.get(SensorID).add(Reading);
        
        return Response.status(201).entity(Reading).build();
        }
        
        
        
    }
    
}
