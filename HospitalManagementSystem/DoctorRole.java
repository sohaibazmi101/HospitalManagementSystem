import java.util.Scanner;

class DoctorRole implements Role {
    private HospitalMediator mediator;

    @Override
    public void setMediator(HospitalMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void performDuty(Patient patient) {
        System.out.println("Doctor examining patient: " + patient.getId());
        if (patient.isTestRequired()) {
            mediator.requestTest(patient);
        } else {
            mediator.prescribeMedication(patient);
        }
    }

    public static void checkCondition(String patientId) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Is the condition critical for patient " + patientId + "? (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("y")) {
            System.out.println("Condition is critical. Assigned Room for patient ID: " + patientId);
            ReceptionistRole.assignRoom(patientId);
        } else if (input.equals("n")) {
            System.out.println("Condition is not critical. Medication will be served to patient ID: " + patientId);
            PharmacyRole.serveMedication(patientId);
        } else {
            System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
        }
    }

    public static void isTestRequired(String idString){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is Test Required (y or n)");
        String input = scanner.nextLine().trim().toLowerCase();
        if(input.equals("y")){
            System.out.println("Go to Lab Section");
            LabRole.labTest(idString);
        }else if(input.equals("n")){
            System.out.println("Go to Nurse Role");
            NurseRole.continueTreatment(idString);
        }else {
            System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
        }
    }

    public static void reviewReport(String idString){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is Report Positive(y for Yes n for No)");
        String input = scanner.nextLine().trim().toLowerCase();
        if(input.equals("y")){
            System.out.println("Report is Normal");
            NurseRole.continueTreatment(idString);
        }else if(input.equals("n")){
            System.out.println("Report is Negative Required for further treatment");
            System.out.println("Is Surgery Required(y for Yes n for No)");
            String input2 = scanner.nextLine().trim().toLowerCase();
            if(input2.equals("y")){
                System.out.println("Go to Surgery Ward");
                SurgeryRole.surgeryWard(idString);
            }else if(input2.equals("n")){
                System.out.println("Go to Nurse Ward");
                NurseRole.continueTreatment(idString);
            }else {
                System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
            }
        }else {
            System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
        }
    }

    public static void ableToDischarge(String idString){
        System.out.println("Is patient able to Discharge (y for Yes n for No)");
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().toLowerCase();
        if(input.equals("y")){
            System.out.println("Proceed to discharge");
            NurseRole.proceedToDischarge(idString);

        }else if(input.equals("n")){
            System.out.println("Not able to discharge");
            NurseRole.continueTreatment(idString);
        }else {
            System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
        }
    }
}
