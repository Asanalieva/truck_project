package com.company;

public class ServiceImplent implements Services{
    @Override
    public void changeDriver(Truck[] trucks, Driver[] drivers) {
        for (Truck truck1 : trucks) {
//            truck1.getId()

            if (truck1.getState().equals(State.BASE)) {
                for (Driver driver : drivers) {
                    if (driver.getTruck().matches("[^a-zA-Z]*")) {
                        truck1.setDriver(driver.getName());
                        driver.setTruck(truck1.getName());
                        break;
                    }
                    if (!truck1.getDriver().equals("")) {
                        System.out.println("Driver changed successfully!");
                    } else {
                        System.err.println("Driver is already exists!");
                    }
                }
            }
        }
    }

    @Override
    public void startDriving(Truck truck,Driver driver) {
        if(truck.getState().equals(State.BASE) && !truck.getDriver().equals(" ")) {
            truck.setState(State.ROUTE);
//            if (truck.getDriver() != null) {
//                truck.setState(State.ROUTE);
                System.out.println("Driver sent to route successfully!");
            }
        else if (truck.getState().equals(State.ROUTE)) {
                System.err.println("Truc is already on route");
        } else if (truck.getState().equals(State.REPAIR)) {
            System.err.println("Truck is on route, you can't repair it!");
        }else {
            System.err.println("Truck doesn't have a driver!");
        }
    }

    @Override
    public void startRepair(Truck[] trucks, Driver[] drivers) {
        for(Truck truck :trucks) {
            if (truck.getState().equals(State.REPAIR)) {
                changeDriver(trucks,drivers);//error
            }else if (truck.getState().equals(State.REPAIR)) {
                System.out.println("Already in repair");
            }
        }
    }

}
