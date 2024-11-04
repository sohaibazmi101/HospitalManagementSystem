import java.util.ArrayList;
import java.util.List;

class PatientData {
    private String id;
    private String name;
    private int age;

    public PatientData(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = generateId();
    }

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