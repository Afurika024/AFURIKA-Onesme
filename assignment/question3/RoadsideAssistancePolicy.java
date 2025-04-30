package question3;

import java.time.LocalDate;

class RoadsideAssistancePolicy extends InsurancePolicy {
    private boolean registrationVerified;

    public RoadsideAssistancePolicy(String policyId, Vehicle vehicle, Person policyHolder, double coverageAmount, LocalDate startDate, LocalDate endDate, boolean registrationVerified) {
        super(policyId, vehicle, policyHolder, coverageAmount, startDate, endDate);
        this.registrationVerified = registrationVerified;
    }

    @Override
    public void calculatePremium() {
        premiumAmount = 150; 
    }

    @Override
    public void processClaim(double claimAmount) {
        if (claimAmount <= 500) { 
            System.out.println("Roadside assistance claim approved for amount: RWF" + claimAmount);
        } else {
            System.out.println("Claim denied: exceeds roadside assistance limit.");
        }
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("Roadside Assistance Policy Report for " + policyHolder.getFullName());
        System.out.println("Registration Verified: " + (registrationVerified ? "Yes" : "No"));
        System.out.println("Coverage: RWF" + coverageAmount);
        System.out.println("Premium: RWF" + premiumAmount);
    }

    @Override
    public void validatePolicy() {
        if (!registrationVerified) {
            throw new IllegalArgumentException("Vehicle registration must be verified for Roadside Assistance Policy.");
        }
        System.out.println("Registration validated for Roadside Assistance Policy.");
    }
}

