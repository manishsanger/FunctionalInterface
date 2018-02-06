package com.manishsanger.Predicate;

import com.manishsanger.Vehicle;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Example {

    public static void main(String[] args) {
        List<Vehicle> vehicles = Arrays.asList(
                new Vehicle("SUV", 2200),
                new Vehicle("SUV", 1800),
                new Vehicle("SEDAN", 1600),
                new Vehicle("HATCHBACK", 1400),
                new Vehicle("SUV", 2800)
        );

        //Using default filter() method, using stream and lambda expression.

        //return all Vehicles those have displacement more than 1500
        System.out.println("All vehicles those have displacement more than 1500, Using default filter() method.");
        vehicles.stream().filter(vehicle -> {
            return vehicle.getDisplacement() >= 1500;
        }).collect(Collectors.toList()).forEach(System.out::println);

        //All SUV those have displacement more than 1500
        System.out.println("\nAll SUV those have displacement more than 1500, Using default filter() method.");
        vehicles.stream().filter(vehicle -> {
            return vehicle.getType().equals("SUV") && vehicle.getDisplacement() >= 1500;
        }).collect(Collectors.toList()).forEach(System.out::println);


        //Using custom filter method and java 8 lambda
        System.out.println("\nAll vehicles those have displacement more than 1500, Using custom predicate filter.");
        VehiclePredicate.filterVehicles(vehicles, vehicle -> {
            return vehicle.getDisplacement() >= 1500;
        }).forEach(System.out::println);


        //Using custom filter method and without lambda
        System.out.println("\nAll vehicles those have displacement more than 1500, Using custom predicate filter  without lambda.");
        VehiclePredicate.filterVehicles(vehicles, VehiclePredicate.isDisplacementAbove1500()).forEach(System.out::println);


        //Multiple filter with AND logical operator
        System.out.println("\nAll SUV those have displacement more than 1500, Using custom Predicate filter without lambda.");
        VehiclePredicate.filterVehicles(vehicles, VehiclePredicate.isDisplacementAbove1500().and(VehiclePredicate.isTypeSUV())).forEach(System.out::println);

        //Multiple filter with OR logical operator
        System.out.println("\nAll Vehicle those have displacement more than 1500 or SUV, Using custom Predicate filter without lambda.");
        VehiclePredicate.filterVehicles(vehicles, VehiclePredicate.isDisplacementAbove1500().or(VehiclePredicate.isTypeSUV())).forEach(System.out::println);

        //default negate(), Logical NOT operator. All vehicles other than SUV
        System.out.println("\nAll vehicles other than SUV, using negate()");
        VehiclePredicate.filterVehicles(vehicles, VehiclePredicate.isTypeSUV().negate()).forEach(System.out::println);


        //boolean test predicate
        System.out.println("\nboolean test(T t) predicate");
        Vehicle testVehicle = new Vehicle("SUV", 1000);
        System.out.println(VehiclePredicate.isTypeSUV().test(testVehicle));
        System.out.println(VehiclePredicate.isDisplacementAbove1500().test(testVehicle));

        //static Predicate isEqual(Object targetRef)
        System.out.println("\nstatic Predicate isEqual(Object targetRef)");
        Predicate<Vehicle> standardVehiclePredicate = Predicate.isEqual(new Vehicle("SUV", 1800));

        System.out.println(standardVehiclePredicate.test(new Vehicle("SUV", 1800)));
        System.out.println(standardVehiclePredicate.test(new Vehicle("SUV", 1500)));






    }
}
