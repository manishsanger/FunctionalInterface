package com.manishsanger.Predicate;

import com.manishsanger.Vehicle;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by manishsanger on 04/01/18.
 */
public class VehiclePredicate {
    public static Predicate<Vehicle> isDisplacementAbove1500() {
        return vehicle -> vehicle.getDisplacement() >= 1500;
    }

    public static Predicate<Vehicle> isTypeSUV() {
        return vehicle -> vehicle.getType().equals("SUV");
    }

    public static List<Vehicle> filterVehicles(List<Vehicle> vehicles, Predicate<Vehicle> predicate) {
        return vehicles.stream().filter(predicate).collect(Collectors.toList());
    }
}
