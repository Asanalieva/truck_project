package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import javax.sound.midi.Track;

public class Truck {
    private int id;
    private String name;
    private String driver;
    private State state;

    public Truck() {
    }

    public Truck(int id, String name, String driver, State state) {
        this.id = id;
        this.name = name;
        this.driver = driver;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void changeDriver(Truck truck, Driver[] drivers) {
        for (Driver driver : drivers) {
            if (driver.getTruck() == null) {
                driver.setTruck(truck.getName());
                truck.setDriver(driver.getName());
                break;
            } else if (driver.getName() != null) {
                System.out.println("Driver changed successfully!");
            } else {
                System.err.println("Driver is already exists!");
            }
        }
    }

    public void startDriving(Truck truck) {
        if(truck.getState().equals(State.BASE) ){
            truck.setState(State.ROUTE);
            if(truck.getDriver() == null){
                System.err.println("Truck doesn't have a driver!");
                throw new RuntimeException();
//                System.out.println("Driver sent to route successfully!");
            }
            }else if(truck.getState().equals(State.REPAIR)){
                System.err.println("Truck is on route, you can't repair it!");
                throw new RuntimeException();
            }
    }

    public void startRepairing(Truck truck) {
        if(truck.getState().equals(State.REPAIR)){
            System.err.println("Truck is already on Repair!");
            throw new RuntimeException();
        }else if(truck.getState().equals(State.ROUTE)){
            System.err.println("Truck is on the Rote! You can't Repair it!");
            throw new RuntimeException();
        }if(truck.getState().equals(State.BASE)){
            truck.setState(State.REPAIR);
        }
    }



    @Override
    public String toString() {
        return id + "   |" + name + "     |   " + driver + "  | on " + state + '\n';
    }
}
