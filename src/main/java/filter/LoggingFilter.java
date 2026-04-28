/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filter;

/**
 *
 * @author poema
 */

import jakarta.ws.rs.container.*;
import jakarta.ws.rs.ext.Provider;

import java.util.logging.Logger;

@Provider
public class LoggingFilter implements ContainerRequestFilter,ContainerResponseFilter {
    
    private static final Logger logger= Logger.getLogger("API");
    
    @Override
    public void filter(ContainerRequestContext req){
        logger.info(req.getMethod() + " " + req.getUriInfo().getPath());
        
    }
    
    @Override
    public void filter(ContainerRequestContext req, ContainerResponseContext res){
        logger.info("Status: "+ res.getStatus());
        
    }
    
}
