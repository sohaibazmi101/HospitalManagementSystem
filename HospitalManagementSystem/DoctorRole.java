import java.util.Scanner;

class DoctorRole implements Role {
    static LabRole labRole = new LabRole();
    static NurseRole nurseRole = new NurseRole();
    ReceptionistRole receptionistRole = new ReceptionistRole();
    static PharmacyRole pharmacyRole = new PharmacyRole();
    static SurgeryRole surgeryRole = new SurgeryRole();

    @SuppressWarnings("unused")
    private HospitalMediator mediator;

    @Override
    public void setMediator(HospitalMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void performDuty(String idString) {
        System.out.println("Doctor examining patient: " + idString);
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Is the condition critical for patient " + idString + "? (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("y")) {
            System.out.println("Condition is critical. Assigned Room for patient ID: " + idString);
            receptionistRole.performDuty(idString);
        } else if (input.equals("n")) {
            System.out.println("Condition is not critical. Medication will be served to patient ID: " + idString);
            pharmacyRole.performDuty(idString);
        } else {
            System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
        }
    }

    public static void isTestRequired(String idString) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is Test Required (y or n)");
        String input = scanner.nextLine().trim().toLowerCase();
        if (input.equals("y")) {
            System.out.println("Go to Lab Section");
            labRole.performDuty(idString);
        } else if (input.equals("n")) {
            System.out.println("Go to Nurse Role");
            nurseRole.performDuty(idString);
        } else {
            System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
        }
    }

    public static void reviewReport(String idString) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is Report Positive(y for Yes n for No)");
        String input = scanner.nextLine().trim().toLowerCase();
        if (input.equals("y")) {
            System.out.println("Report is Normal");
            nurseRole.performDuty(idString);
        } else if (input.equals("n")) {
            System.out.println("Report is Negative Required for further treatment");
            System.out.println("Is Surgery Required(y for Yes n for No)");
            String input2 = scanner.nextLine().trim().toLowerCase();
            if (input2.equals("y")) {
                System.out.println("Go to Surgery Ward");
                surgeryRole.performDuty(idString);
            } else if (input2.equals("n")) {
                System.out.println("Go to Nurse Ward");
                nurseRole.performDuty(idString);
            } else {
                System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
            }
        } else {
            System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
        }
    }

    public static void ableToDischarge(String idString) {
        System.out.println("Is patient able to Discharge (y for Yes n for No)");
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().toLowerCase();
        if (input.equals("y")) {
            System.out.println("Proceed to discharge");
            NurseRole.proceedToDischarge(idString);

        } else if (input.equals("n")) {
            System.out.println("Not able to discharge");
            nurseRole.performDuty(idString);
        } else {
            System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
        }
    }
}
