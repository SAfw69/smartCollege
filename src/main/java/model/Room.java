/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author poema
 */

import java.util.*;

public class Room {
    private String id;
    private String name;
    private int capacity;
    
    private List<String> sensorIDs= new ArrayList<>();
    
    public Room(){}
    
    public String getID(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getCapacity(){
        return this.capacity;
    }
    
    public List<String> getSensorIds(){
        return this.sensorIDs;
    }
    
    
    public void setID(String Id){
        this.id=Id;
    }
    
    public void setName(String Name){
        this.name=Name;
    }
    
    public void setCapacity(int Capacity){
        this.capacity=Capacity;
    }
    
    
}
