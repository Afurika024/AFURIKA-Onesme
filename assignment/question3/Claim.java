package question3;

import java.time.LocalDate;

class Claim {
    private String claimId;
    private double claimAmount;
    private LocalDate claimDate;
    private String claimStatus;

    public Claim(String claimId, double claimAmount, LocalDate claimDate) {
        this.claimId = claimId;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.claimStatus = "Pending";
    }

    public void approveClaim() {
        this.claimStatus = "Approved";
    }

    public void rejectClaim() {
        this.claimStatus = "Rejected";
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    @Override
    public String toString() {
        return "Claim ID: " + claimId + ", Amount: " + claimAmount + ", Status: " + claimStatus;
    }
}
