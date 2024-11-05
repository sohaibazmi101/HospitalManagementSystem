class LabRole implements Role {
    @SuppressWarnings("unused")
    private HospitalMediator mediator;

    @Override
    public void setMediator(HospitalMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void performDuty(String idString) {
        System.out.println("Lab conducting tests for patient: " + idString);
        System.out.println("Initial Test Conducted");
        System.out.println("Sample Collecting");
        System.out.println("Report Generated");
        System.out.println("Report Forwarded to Doctor");
        DoctorRole.reviewReport(idString);
    }
}
