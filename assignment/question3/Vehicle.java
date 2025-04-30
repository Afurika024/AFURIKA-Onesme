package question3;

import java.time.LocalDate;

class Vehicle {
    private String vehicleId;
    private String vehicleMake;
    private String vehicleModel;
    private int vehicleYear;
    private String vehicleType;

    public Vehicle(String vehicleId, String vehicleMake, String vehicleModel, int vehicleYear, String vehicleType) {
        this.vehicleId = vehicleId;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.vehicleYear = vehicleYear;
        this.vehicleType = vehicleType;
        validateVehicle();
    }

    private void validateVehicle() {
        if (vehicleYear < 1980 || vehicleYear > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Invalid vehicle year.");
        }
        if (vehicleMake.isEmpty() || vehicleModel.isEmpty() || vehicleType.isEmpty()) {
            throw new IllegalArgumentException("Vehicle details must be provided.");
        }
    }

    public int getVehicleYear() {
        return vehicleYear;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void updateVehicle(String make, String model, int year, String type) {
        this.vehicleMake = make;
        this.vehicleModel = model;
        this.vehicleYear = year;
        this.vehicleType = type;
        validateVehicle();
    }

    @Override
    public String toString() {
        return vehicleMake + " " + vehicleModel + " (" + vehicleYear + ", " + vehicleType + ")";
    }
}
