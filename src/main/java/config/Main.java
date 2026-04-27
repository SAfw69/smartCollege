/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

/**
 *
 * @author poema
 */

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import config.AppConfig;
import java.net.URI;

public class Main {
    public static void main(String[] args) {
        
        String BASE_URI="http://localhost:8000";
        try{
            HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI),new AppConfig());
            
            System.out.println("The Server has been Initialized...");
        }
        catch(Exception e)
        {
            System.out.println("The Server Failed to Initialize...");
        }
        
    }
}