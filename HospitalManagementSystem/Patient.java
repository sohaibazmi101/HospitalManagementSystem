public class Patient {
    private String id;
    private String name;
    private boolean testRequired;

    public Patient(String id, String name) {
        this.id = id;
        this.name = name;
        this.testRequired = false; // Default to false
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isTestRequired() {
        return testRequired;
    }

    public void setTestRequired(boolean testRequired) {
        this.testRequired = testRequired;
    }
}