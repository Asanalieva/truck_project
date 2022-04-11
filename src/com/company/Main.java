package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static com.company.State.*;

public class Main {

    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path PATH = Paths.get("./traki");
    public static final Path PATH2 = Paths.get("./drivers");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Truck truck = new Truck(1, "Honda", "", BASE);
        Truck truck2 = new Truck(2, "Lexus", "", BASE);
        Truck truck3 = new Truck(3, "BMW  ", "", BASE);
        Truck[] trucks = {truck, truck2, truck3};

        Driver driver1 = new Driver(1, "Steve", "");
        Driver driver2 = new Driver(2, "Bill", "");
        Driver driver3 = new Driver(3, "Yson", "");
        Driver[] drivers = {driver1, driver2, driver3};


        String json = GSON.toJson(trucks);
        String json2 = GSON.toJson(drivers);
//        write(json);
//        writeDrivers(json2);
        System.out.println("#   | Bus     | Driver   | State   ");
        System.out.println("____+_________+__________+__________");
        for (Truck truck1 : trucks) {
            System.out.println(truck1);
        }
        ServiceImplent services = new ServiceImplent();

        while (true) {

            System.out.println("Choose one of the trucks: ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                truckInformation(truck);
            } else if (choice == 2) {
                truckInformation(truck2);
            } else if (choice == 3) {
                truckInformation(truck3);
            }
            choice3();
            System.out.print("Choose one of the methods: ");

            int servicesInput = scanner.nextInt();
            if (servicesInput == 1) {
                services.changeDriver(trucks, drivers);
            } else if (servicesInput == 2) {
                services.startDriving(trucks[servicesInput - 2], drivers[servicesInput - 2]);
            }


//            methodToChanging1(truck, truck2, truck3, driver1, driver2, driver3);
            printAllInformation(trucks, drivers);


            write(json);
            writeDrivers(json2);
        }

//            State[] states = {BASE,ROUTE,REPAIR};
//            startDriving(states, drivers);
//

//        if (changing == 1) {
//            for (Truck truck1 : trucks) {
//                for(Driver driver : drivers){
//
//
//                }truck1.changeDriver(driver1);
//            }
//        }

//        for (Truck truck1 : trucks) {

//        }
//
//        else if (changing == 2) {
//            route();
//
//        } else if (changing == 3) {
//            repair();
//            truck.setDriver(driver3.getName());
//        }
//    System.out.println("#   | Bus     | Driver   | State   ");
//    System.out.println("____+_________+__________+__________");
//    for (Truck truck1 : trucks) {
//        System.out.println(truck1);
//    }
//            printAllInformation(trucks, drivers);
    }

//    }


    public static void write(String object) {
        try {
            Path write = Paths.get(String.valueOf(PATH));
            Files.writeString(write, object, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDrivers(String drivers) {
        Path write = Paths.get(String.valueOf(PATH2));
        try {
            Files.writeString(write, drivers, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void truckInformation(Truck truck) {
        System.out.println("N          : " + truck.getId());
        System.out.println("Bus        : " + truck.getName());
        System.out.println("Driver     : " + truck.getDriver());
        System.out.println("Bus state  : " + truck.getState());
    }


    public static void repair() {
        System.out.println("Repair");

    }

    public static void route() {
        System.out.println("Route");
    }

    public static void choice3() {
        System.out.println("Press 1 to change Driver");
        System.out.println("Press 2 to send to the Route");
        System.out.println("Press 3 to send to the Repairing");
    }

    public static void drivers(Driver driver) {
        System.out.println("----------Drivers----------");
        System.out.println(" # | id     | Driver   | Bus");
        System.out.println("-------------------------------");
        System.out.println(" 1 | " + driver.getId() + "      | " + driver.getName() + "    | " + driver.getTruck());
    }

    public static void printAllInformation(Truck[] trucks, Driver[] drivers) {
        System.out.println("#   | Bus     | Driver   | State");
        System.out.println("____+_____________+_____________");
        System.out.println("-----------------------------___");
        Arrays.stream(trucks).forEach(System.out::println);
        System.out.println(" #  | Driver      | Bus");
        System.out.println("____+_____________+______________");
        System.out.println("---------------------------------");
        Arrays.stream(drivers).forEach(System.out::println);
    }


}