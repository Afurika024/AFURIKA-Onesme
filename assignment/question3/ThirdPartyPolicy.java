package question3;

import java.time.LocalDate;

class ThirdPartyPolicy extends InsurancePolicy {
    private boolean additionalCoverage;

    public ThirdPartyPolicy(String policyId, Vehicle vehicle, Person policyHolder,double coverageAmount, LocalDate startDate, LocalDate endDate, boolean additionalCoverage) {
        super(policyId, vehicle, policyHolder, coverageAmount, startDate, endDate);
        this.additionalCoverage = additionalCoverage;
    }

    @Override
    public void calculatePremium() {
        premiumAmount = coverageAmount * 0.01; 
        if (additionalCoverage) {
            premiumAmount += 100; 
        }
    }

    @Override
    public void processClaim(double claimAmount) {
        if (claimAmount <= coverageAmount) {
            System.out.println("Third Party claim approved: RWF" + claimAmount);
        } else {
            System.out.println("Claim denied: exceeds third party coverage.");
        }
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("Third Party Policy Report for " + policyHolder.getFullName());
        System.out.println("Additional Coverage: " + (additionalCoverage ? "Yes" : "No"));
        System.out.println("Coverage: RWF" + coverageAmount);
        System.out.println("Premium: RWF" + premiumAmount);
    }

    @Override
    public void validatePolicy() {
        if (vehicle.getVehicleType().equalsIgnoreCase("Heavy Truck")) {
            throw new IllegalArgumentException("Third Party Policy not allowed for Heavy Trucks.");
        }
        System.out.println("Vehicle validated for Third Party Policy.");
    }
}

