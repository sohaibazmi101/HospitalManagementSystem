import java.util.Scanner;

public class HospitalManagementSystem {
    public static void main(String[] args) {

        PatientDetails patientDetails = new PatientDetails();

        HospitalMediatorImpl mediator = new HospitalMediatorImpl();

        Role doctor = new DoctorRole();

        mediator.setDoctor(doctor);

        patientDetails.initializePatients();

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Show all existing patients");
            System.out.println("2. Add new patient");
            System.out.println("3. Find existing patient by ID");
            System.out.println("4. Assign Patient to Doctor");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

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
                        mediator.notifyDoctor(idString);
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
