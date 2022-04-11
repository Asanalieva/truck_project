package com.company;

public interface Services {
    void changeDriver(Truck[] trucks, Driver[] drivers);
    void startDriving(Truck truck,Driver driver);
    void startRepair(Truck[] trucks,Driver[] drivers);
}
