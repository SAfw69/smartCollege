/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author poema
 */
public class SensorReading {
    private String id;
    private long timeStamp;
    private double value;
    
    public SensorReading(){}
    
    public String getId(){
    return this.id;
    }
    
    public long getTimeStamp(){
    return this.timeStamp;
    }
    
    public double getValue(){
    return this.value;
    }
    
    public void setID(String ID){
    this.id=ID;
    }
    
    public void setTimeStamp(long Timestamp){
    this.timeStamp=Timestamp;
    }
    
    public void setValue(double Value){
    this.value=Value;
    }
    
    
}
