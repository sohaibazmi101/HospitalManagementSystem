import java.util.Scanner;

class DoctorRole implements Role {

    Role receptionist = new ReceptionistRole();
    static HospitalMediatorImpl mediator = new HospitalMediatorImpl();

    static SurgeryRole surgeryRole = new SurgeryRole();

    @Override
    public void setMediator(HospitalMediator mediator) {
    }

    @Override
    public void performDuty(String idString) {
        Role pharmacy = new PharmacyRole();
        mediator.setPharmacy(pharmacy);
        System.out.println("Doctor examining patient: " + idString);
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Is the condition critical for patient " + idString + "? (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("y")) {
            System.out.println("Condition is critical. Assigned Room for patient ID: " + idString);
            mediator.setReceptionist(receptionist);
            mediator.assignRoom(idString);
            isTestRequired(idString);
        } else if (input.equals("n")) {
            System.out.println("Condition is not critical. Medication will be served to patient ID: " + idString);
            mediator.prescribeMedication(idString);
        } else {
            System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
            performDuty(idString);
        }
    }

    private void isTestRequired(String idString) {
        Role lab = new LabRole();
        Role nurse = new NurseRole();
        mediator.setLab(lab);
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is Test Required (y or n)");
        String input = scanner.nextLine().trim().toLowerCase();
        if (input.equals("y")) {
            System.out.println("Go to Lab Section");
            mediator.requestTest(idString);
            reviewReport(idString);
        } else if (input.equals("n")) {
            System.out.println("Go to Nurse Role");
            mediator.setNurse(nurse);
            mediator.dispenseMedication(idString);
            ableToDischarge(idString);
        } else {
            System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
            isTestRequired(idString);
        }
    }

    private void reviewReport(String idString) {
        Role nurse = new NurseRole();
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is Report Positive(y for Yes n for No)");
        String input = scanner.nextLine().trim().toLowerCase();
        if (input.equals("y")) {
            System.out.println("Report is Normal");
            mediator.setNurse(nurse);
            mediator.dispenseMedication(idString);
            ableToDischarge(idString);
        } else if (input.equals("n")) {
            System.out.println("Report is Not Normal");
            System.out.println("Is Surgery Required(y for Yes n for No)");
            String input2 = scanner.nextLine().trim().toLowerCase();
            if (input2.equals("y")) {
                System.out.println("Go to Surgery Ward");
                surgeryRole.performDuty(idString);
            } else if (input2.equals("n")) {
                System.out.println("Go to Nurse Ward");
                mediator.dispenseMedication(idString);
            } else {
                System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
                reviewReport(idString);
            }
        } else {
            System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
            reviewReport(idString);
        }
    }

    private void ableToDischarge(String idString) {
        Role nurse = new NurseRole();
        mediator.setNurse(nurse);
        System.out.println("Is patient able to Discharge (y for Yes n for No)");
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().toLowerCase();
        if (input.equals("y")) {
            System.out.println("Proceed to discharge");
            NurseRole.proceedToDischarge(idString);

        } else if (input.equals("n")) {
            System.out.println("Not able to discharge");
            mediator.dispenseMedication(idString);
        } else {
            System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
            ableToDischarge(idString);
        }
    }
}
