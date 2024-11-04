class PatientData {
    private static int nextId = 1; // Base number for auto-increment
    private String id;
    private String name;
    private int age;

    public PatientData(String name, int age) {
        this.id = String.format("P%03d", nextId++); // Format ID as P001, P002, etc.
        this.name = name;
        this.age = age;
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
        return "Patient ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}