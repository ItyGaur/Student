package com.example.Student;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private List<Vehicle> vehicles = new ArrayList<>();

    @GetMapping
    public List<Vehicle> getAll() {
        return vehicles;
    }

    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        vehicles.add(vehicle);
        return vehicle;
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable int id, @RequestBody Vehicle updatedVehicle) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                vehicle.setVehicleNumber(updatedVehicle.getVehicleNumber());
                vehicle.setOwnerName(updatedVehicle.getOwnerName());
                return vehicle;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteVehicle(@PathVariable int id) {
        boolean removed = vehicles.removeIf(vehicle -> vehicle.getId() == id);

        if (removed) {
            return "Vehicle deleted successfully!";
        } else {
            return "Vehicle not found!";
        }
    }
}
