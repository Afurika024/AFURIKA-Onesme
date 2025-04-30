package question3;

import java.time.LocalDate;

class ComprehensivePolicy extends InsurancePolicy {

    public ComprehensivePolicy(String policyId, Vehicle vehicle, Person policyHolder, double coverageAmount, LocalDate startDate, LocalDate endDate) {
        super(policyId, vehicle, policyHolder, coverageAmount, startDate, endDate);
    }

    @Override
    public void calculatePremium() {
        int currentYear = LocalDate.now().getYear();
        int vehicleAge = currentYear - vehicle.getVehicleYear();
        premiumAmount = (coverageAmount * 0.02) + (vehicleAge * 50); 
    }

    @Override
    public void processClaim(double claimAmount) {
        if (claimAmount <= coverageAmount) {
            System.out.println("Comprehensive claim approved for amount: RWF" + claimAmount);
        } else {
            System.out.println("Claim denied: exceeds coverage amount.");
        }
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("Comprehensive Policy Report for " + policyHolder.getFullName());
        System.out.println("Vehicle: " + vehicle);
        System.out.println("Coverage: RWF" + coverageAmount);
        System.out.println("Premium: RWF" + premiumAmount);
    }

    @Override
    public void validatePolicy() {
        if (vehicle.getVehicleYear() < 2000) {
            throw new IllegalArgumentException("Vehicle too old for Comprehensive Policy.");
        }
        System.out.println("Vehicle validated for Comprehensive Policy.");
    }
}

