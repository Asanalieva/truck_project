package com.company;

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



//    public void startDriving(Driver driver) {
//        switch (state) {
//            case BASE -> {
//                if (driver != null) {
//                    String name = driver.getName();
//                    this.driver = driver.getName();
//
//                    System.out.println("Теперь грузовик " + name + ", ведёт водитель " + driver.getName());
//                } else {
//                    this.driver = driver.getName();
//                    System.out.println("new driver = " + driver.getName() + " to truck " + name);
//                }
//
//            }
//            case ROUTE -> {
//                System.err.println("Грузовик в пути, невозможно сменить водителя.");
//            }
//            case REPAIR -> {
//                System.err.println("Нельзя сменить водителя");
//            }
//        }
//    }




    @Override
    public String toString() {
        return  id+"   |"+name +"     |   "+ driver+"          | on "+ state+'\n';
    }
}
