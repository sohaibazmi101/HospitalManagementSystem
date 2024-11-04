class LabRole implements Role {
    private HospitalMediator mediator;

    @Override
    public void setMediator(HospitalMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void performDuty(Patient patient) {
        System.out.println("Lab conducting tests for patient: " + patient.getId());
        mediator.notifyDoctor(patient);
    }

    public static void labTest(String idString){
        System.out.println("Initial Test Conducted");
        System.out.println("Sample Collecting");
        System.out.println("Report Generated");
        DoctorRole.reviewReport(idString);
    }
}
