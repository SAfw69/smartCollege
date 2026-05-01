/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

/**
 *
 * @author poema
 */

import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.*;
import exceptions.*;

import java.util.Map;


@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Throwable>{
    
    @Override
    public Response toResponse(Throwable ex){
        if (ex instanceof RoomNotEmptyException) {
            return Response.status(409)
                    .entity(Map.of("error", ex.getMessage()))
                    .build();
        }

        if (ex instanceof InvalidRoomException) {
            return Response.status(422)
                    .entity(Map.of("error", ex.getMessage()))
                    .build();
        }

        if (ex instanceof ResourceNotFoundException) {
            return Response.status(404)
                    .entity(Map.of("error", ex.getMessage()))
                    .build();
        }

        if (ex instanceof SensorUnavailableException) {
            return Response.status(403)
                    .entity(Map.of("error", ex.getMessage()))
                    .build();
        }

        return Response.status(500)
                .entity(Map.of("error", "Internal Server Error"))
                .build();

    }
    
}
