import java.util.ArrayList;
import java.util.List;

class PatientData {
    private String id;
    private String name;
    private int age;

    // Constructor
    public PatientData(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = generateId(); // Generate an ID when creating a new patient
    }

    // Method to generate a unique ID for the patient
    private String generateId() {
        return "P" + String.format("%03d", PatientDetails.getNextIdCount());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "PatientData{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", age=" + age + '}';
    }
}

class PatientDetails {
    private List<PatientData> patients = new ArrayList<>();
    private static int patientCount = 0; // Static counter to assign IDs

    // Method to add a new patient
    public void addPatient(String name, int age) {
        PatientData newPatient = new PatientData(name, age);
        patients.add(newPatient);
        System.out.println("New patient added: " + newPatient);
    }

    // Method to find a patient by ID
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

    // Method to retrieve a patient's name using their ID
    public String patientName(String id) {
        for (PatientData patient : patients) {
            if (patient.getId().equals(id)) {
                return patient.getName();
            }
        }
        return "No patient found with ID: " + id;
    }

    // Method to show all existing patients
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

    // Method to initialize the system with some existing patients
    public void initializePatients() {
        addPatient("John Doe", 30);
        addPatient("Jane Smith", 25);
        addPatient("Alice Johnson", 40);
        addPatient("Bob Brown", 50);
        addPatient("Charlie Davis", 35);
    }

    // Static method to get the next patient ID count
    public static int getNextIdCount() {
        return ++patientCount;
    }
}