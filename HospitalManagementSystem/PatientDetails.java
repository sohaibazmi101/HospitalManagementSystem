import java.util.ArrayList;
import java.util.List;

class PatientDetails {
    private List<PatientData> patients = new ArrayList<>();
    private static int patientCount = 0;

    public void addPatient(String name, int age) {
        PatientData newPatient = new PatientData(name, age);
        patients.add(newPatient);
        System.out.println("New patient added: " + newPatient);
    }

    public boolean findPatientById(String id) {
        for (PatientData patient : patients) {
            if (patient.getId().equals(id)) {
                System.out.println("Patient found: " + patient);
                return true;
            }
        }
        System.out.println("No patient found with ID: " + id);
        return false;
    }

    public String patientName(String id) {
        for (PatientData patient : patients) {
            if (patient.getId().equals(id)) {
                return patient.getName();
            }
        }
        return "No patient found with ID: " + id;
    }

    public void showAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients in the system.");
        } else {
            System.out.println("Existing patients:");
            for (PatientData patient : patients) {
                System.out.println(patient);
            }
        }
    }

    public void initializePatients() {
        addPatient("Hari Dass", 30);
        addPatient("Jane Alam", 25);
        addPatient("Ali Haidar", 40);
        addPatient("Harish Kumar", 50);
        addPatient("Kamla Devi", 35);
    }

    public static int getNextIdCount() {
        return ++patientCount;
    }
}