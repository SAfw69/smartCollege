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

import java.util.Map;


@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Throwable>{
    
    @Override
    public Response toResponse(Throwable ex){
        return Response.status(500).entity(Map.of("error", ex.getMessage())).build();
    }
    
}
