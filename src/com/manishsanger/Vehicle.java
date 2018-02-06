package com.manishsanger;

/**
 * Created by manishsanger on 03/01/18.
 */
public class Vehicle {
    private String type;
    private Integer displacement;

    public Vehicle(String type, Integer displacement) {
        this.type = type;
        this.displacement = displacement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Integer displacement) {
        this.displacement = displacement;
    }

    @Override
    public String toString() {
        return "Vehicle - Type:" + this.getType() + ", Displacement:" + this.getDisplacement() + "cc";
    }

    @Override
    public boolean equals(Object obj) {
        Vehicle vehicle = (Vehicle) obj;
        if (this.getType().equals(vehicle.getType()) && this.getDisplacement().equals(vehicle.getDisplacement())) {
            return true;
        }
        return false;
    }
}
