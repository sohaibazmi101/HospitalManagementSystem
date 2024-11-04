class PatientData {
    private static int nextId = 1;
    private String id;
    private String name;
    private int age;

    public PatientData(String name, int age) {
        this.id = String.format("P%03d", nextId++);
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