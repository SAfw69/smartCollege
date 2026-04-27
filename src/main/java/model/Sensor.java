package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author poema
 */
public class Sensor {
    private String id;
    private String type; // temp, CO2, etc
    private String status; // Maintenance or Active
    private double currentValue;
    private String roomId;

    public Sensor() {}

    public String getId() { return this.id; }
    public void setId(String id) { this.id = id; }

    public String getType() { return this.type; }
    public void setType(String type) { this.type = type; }

    public String getStatus() { return this.status; }
    public void setStatus(String status) { this.status = status; }

    public double getCurrentValue() { return this.currentValue; }
    public void setCurrentValue(double v) { this.currentValue = v; }

    public String getRoomId() { return this.roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }
}
