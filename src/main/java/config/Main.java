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
import java.io.IOException;
import java.net.URI;

public class Main {
    public static void main(String[] args) throws IOException {
        
        String BASE_URI="http://localhost:8000";
        //try{
            HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI),new AppConfig());
            server.start();
            System.out.println("The Server has been Initialized...");
        /*
        }
        catch(Exception e)
        {
            System.out.println("The Server Failed to Initialize...");
        }*/
        
    }
}