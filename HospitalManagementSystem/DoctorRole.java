class DoctorRole implements Role {
    private HospitalMediator mediator;

    @Override
    public void setMediator(HospitalMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void performDuty(Patient patient) {
        System.out.println("Doctor examining patient: " + patient.getId());
        if (patient.isTestRequired()) {
            mediator.requestTest(patient);
        } else {
            mediator.prescribeMedication(patient);
        }
    }

    public void examineResults(Patient patient) {
        System.out.println("Doctor received test results for patient: " + patient.getId());
        if (patient.isTestResultPositive()) {
            mediator.prescribeMedication(patient);
        }
    }
}
