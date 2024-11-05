class LabRole implements Role {
    private HospitalMediator mediator;

    @Override
    public void setMediator(HospitalMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void performDuty(String idString) {
        System.out.println("Lab conducting tests for patient: " + idString);
        mediator.notifyDoctor(idString);
        System.out.println("Initial Test Conducted");
        System.out.println("Sample Collecting");
        System.out.println("Report Generated");
        DoctorRole.reviewReport(idString);
    }
}
