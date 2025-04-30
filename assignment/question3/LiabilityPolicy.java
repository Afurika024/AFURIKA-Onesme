package question3;

import java.time.LocalDate;

class LiabilityPolicy extends InsurancePolicy {
    private boolean hasMedicalClearance;

    public LiabilityPolicy(String policyId, Vehicle vehicle, Person policyHolder, double coverageAmount, LocalDate startDate, LocalDate endDate, boolean hasMedicalClearance) {
        super(policyId, vehicle, policyHolder, coverageAmount, startDate, endDate);
        this.hasMedicalClearance = hasMedicalClearance;
    }

    @Override
    public void calculatePremium() {
        premiumAmount = coverageAmount * 0.015; 
    }

    @Override
    public void processClaim(double claimAmount) {
        if (claimAmount <= coverageAmount) {
            System.out.println("Liability claim approved for amount: Rwf" + claimAmount);
        } else {
            System.out.println("Claim denied: exceeds liability coverage.");
        }
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("Liability Policy Report for " + policyHolder.getFullName());
        System.out.println("Medical Clearance: " + (hasMedicalClearance ? "Cleared" : "Not Cleared"));
        System.out.println("Coverage: $" + coverageAmount);
        System.out.println("Premium: $" + premiumAmount);
    }

    @Override
    public void validatePolicy() {
        if (!hasMedicalClearance) {
            throw new IllegalArgumentException("Medical clearance required for Liability Policy.");
        }
        System.out.println("Medical check validated for Liability Policy.");
    }
}

