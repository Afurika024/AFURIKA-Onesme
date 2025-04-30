package question3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<InsurancePolicy> policies = new ArrayList<>();
    private static double totalPremiums = 0;
    private static double totalClaims = 0;
    private static int totalClaimsCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        System.out.println("=== Welcome to Advanced Motor Vehicle Insurance System ===");

        while (running) {
            System.out.println("\n1. Create New Policy");
            System.out.println("2. Process a Claim");
            System.out.println("3. View Policy Reports");
            System.out.println("4. View System Report");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    createPolicy(scanner);
                    break;
                case 2:
                    processClaim(scanner);
                    break;
                case 3:
                    generateAllReports();
                    break;
                case 4:
                    generateSystemReport();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for using the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void createPolicy(Scanner scanner) {
        try {
            System.out.print("\nEnter Policy ID: ");
            String policyId = scanner.nextLine();

            System.out.println("Enter Vehicle Details:");
            System.out.print("Vehicle ID: ");
            String vehicleId = scanner.nextLine();
            System.out.print("Brand: ");
            String make = scanner.nextLine();
            System.out.print("Model: ");
            String model = scanner.nextLine();
            System.out.print("Year: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Type (Car, Truck, Bike, etc.): ");
            String type = scanner.nextLine();
            Vehicle vehicle = new Vehicle(vehicleId, make, model, year, type);

            System.out.println("Enter Policy Holder Details:");
            System.out.print("Person ID: ");
            String personId = scanner.nextLine();
            System.out.print("Full Name: ");
            String fullName = scanner.nextLine();
            System.out.print("Date of Birth (yyyy-mm-dd): ");
            LocalDate dob = LocalDate.parse(scanner.nextLine());
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Phone: ");
            String phone = scanner.nextLine();
            Person person = new Person(personId, fullName, dob, email, phone);

            System.out.print("Coverage Amount: ");
            double coverageAmount = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Policy Start Date (yyyy-mm-dd): ");
            LocalDate startDate = LocalDate.parse(scanner.nextLine());
            if (startDate.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("Policy Start Date cannot be in the past. It must be today or a future date.");
            }
            System.out.print("Policy End Date (yyyy-mm-dd): ");
            LocalDate endDate = LocalDate.parse(scanner.nextLine());
            if (!endDate.isAfter(startDate)) {
                throw new IllegalArgumentException("Policy End Date must be after the Start Date.");
            }

            System.out.println("\nSelect Policy Type:");
            System.out.println("1. Comprehensive Policy");
            System.out.println("2. Third Party Policy");
            System.out.println("3. Collision Policy");
            System.out.println("4. Liability Policy");
            System.out.println("5. Roadside Assistance Policy");
            System.out.print("Enter choice: ");
            int policyType = scanner.nextInt();
            scanner.nextLine();

            InsurancePolicy policy = null;

            switch (policyType) {
                case 1:
                    policy = new ComprehensivePolicy(policyId, vehicle, person, coverageAmount, startDate, endDate);
                    break;
                case 2:
                    System.out.print("Include Additional Coverage? (true/false): ");
                    boolean addCoverage = scanner.nextBoolean();
                    scanner.nextLine();
                    policy = new ThirdPartyPolicy(policyId, vehicle, person, coverageAmount, startDate, endDate, addCoverage);
                    break;
                case 3:
                    System.out.print("Safe Driver? (true/false): ");
                    boolean safeDriver = scanner.nextBoolean();
                    scanner.nextLine();
                    policy = new CollisionPolicy(policyId, vehicle, person, coverageAmount, startDate, endDate, safeDriver);
                    break;
                case 4:
                    System.out.print("Medical Clearance Obtained? (true/false): ");
                    boolean medicalClearance = scanner.nextBoolean();
                    scanner.nextLine();
                    policy = new LiabilityPolicy(policyId, vehicle, person, coverageAmount, startDate, endDate, medicalClearance);
                    break;
                case 5:
                    System.out.print("Vehicle Registration Verified? (true/false): ");
                    boolean registrationVerified = scanner.nextBoolean();
                    scanner.nextLine();
                    policy = new RoadsideAssistancePolicy(policyId, vehicle, person, coverageAmount, startDate, endDate, registrationVerified);
                    break;
                default:
                    System.out.println("Invalid policy type selected.");
                    return;
            }

            policy.validatePolicy();
            policy.calculatePremium();
            policies.add(policy);
            totalPremiums += policy.premiumAmount;
            System.out.println("Policy created successfully!");

        } catch (Exception e) {
            System.out.println("Error creating policy: " + e.getMessage());
        }
    }

    private static void processClaim(Scanner scanner) {
        if (policies.isEmpty()) {
            System.out.println("No policies found. Please create a policy first.");
            return;
        }

        System.out.print("\nEnter Policy ID for claim: ");
        String policyId = scanner.nextLine();

        InsurancePolicy policy = findPolicyById(policyId);

        if (policy == null) {
            System.out.println("Policy not found.");
            return;
        }

        System.out.print("Enter Claim Amount: ");
        double claimAmount = scanner.nextDouble();
        scanner.nextLine();

        if (claimAmount > policy.coverageAmount) {
            System.out.println("Claim amount exceeds coverage. Claim rejected.");
        } else {
            policy.processClaim(claimAmount);
            totalClaims += claimAmount;
            totalClaimsCount++;
        }
    }

    private static InsurancePolicy findPolicyById(String policyId) {
        for (InsurancePolicy p : policies) {
            if (p.policyId.equalsIgnoreCase(policyId)) {
                return p;
            }
        }
        return null;
    }

    private static void generateAllReports() {
        if (policies.isEmpty()) {
            System.out.println("No policies to display.");
            return;
        }

        System.out.println("\n=== Policy Reports ===");
        for (InsurancePolicy p : policies) {
            p.generatePolicyReport();
            System.out.println("----------------------------");
        }
    }

    private static void generateSystemReport() {
        System.out.println("\n=== System Report ===");
        System.out.println("Total Premiums Collected: RWF" + totalPremiums);
        System.out.println("Total Claims Processed: " + totalClaimsCount);
        System.out.println("Total Claims Amount: RWF" + totalClaims);
        System.out.println("Number of Active Policies: " + policies.size());
    }
}

