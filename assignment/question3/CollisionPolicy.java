package question3;

import java.time.LocalDate;

class CollisionPolicy extends InsurancePolicy {
    private boolean isSafeDriver;

    public CollisionPolicy(String policyId, Vehicle vehicle, Person policyHolder,double coverageAmount, LocalDate startDate, LocalDate endDate, boolean isSafeDriver) {
        super(policyId, vehicle, policyHolder, coverageAmount, startDate, endDate);
        this.isSafeDriver = isSafeDriver;
    }

    @Override
    public void calculatePremium() {
        premiumAmount = coverageAmount * 0.03; 
        if (isSafeDriver) {
            premiumAmount *= 0.9; 
        }
    }

    @Override
    public void processClaim(double claimAmount) {
        if (claimAmount <= coverageAmount) {
            System.out.println("Collision claim approved for amount: RWF" + claimAmount);
        } else {
            System.out.println("Claim denied: exceeds collision coverage.");
        }
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("Collision Policy Report for " + policyHolder.getFullName());
        System.out.println("Safe Driver Discount: " + (isSafeDriver ? "Applied" : "No Discount"));
        System.out.println("Coverage: RWF" + coverageAmount);
        System.out.println("Premium: RWF" + premiumAmount);
    }

    @Override
    public void validatePolicy() {
        System.out.println("Vehicle safety check passed for Collision Policy.");
    }
}

