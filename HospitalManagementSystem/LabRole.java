class LabRole implements Role {
    private HospitalMediator mediator;

    @Override
    public void setMediator(HospitalMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void performDuty(Patient patient) {
        System.out.println("Lab conducting tests for patient: " + patient.getId());
        patient.setTestResultPositive(true); // Simulated test result
        mediator.notifyDoctor(patient);
    }
}
