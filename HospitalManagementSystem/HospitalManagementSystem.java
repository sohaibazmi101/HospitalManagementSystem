import java.util.Scanner;

public class HospitalManagementSystem {
    public static void main(String[] args) {

        PatientDetails patientDetails = new PatientDetails();

        // Initialize with 5 existing patients
        patientDetails.initializePatients();

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Show all existing patients");
            System.out.println("2. Add new patient");
            System.out.println("3. Find existing patient by ID");
            System.out.println("4. Assign Patients");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    patientDetails.showAllPatients();
                    break;
                case 2:
                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter patient age: ");
                    int age = scanner.nextInt();
                    patientDetails.addPatient(name, age);
                    break;
                case 3:
                    System.out.print("Enter patient ID: ");
                    String id = scanner.nextLine();
                    patientDetails.findPatientById(id);
                    break;
                case 4:
                    System.out.print("Enter patient ID: ");
                    String idString = scanner.nextLine();
                    if (patientDetails.findPatientById(idString) == true) {
                        Patient patient = new Patient(idString, patientDetails.patientName(idString));
                        patient.setTestRequired(true);

                        HospitalMediatorImpl mediator = new HospitalMediatorImpl();

                        Role doctor = new DoctorRole();
                        Role nurse = new NurseRole();
                        Role receptionist = new ReceptionistRole();
                        Role lab = new LabRole();
                        Role pharmacy = new PharmacyRole();
                        Role billing = new BillingRole();

                        mediator.setDoctor(doctor);
                        mediator.setNurse(nurse);
                        mediator.setReceptionist(receptionist);

                        receptionist.performDuty(patient);
                        nurse.performDuty(patient);
                    }
                    break;
                case 5:
                    System.out.println("Exiting.....");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
