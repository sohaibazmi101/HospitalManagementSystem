class NurseRole implements Role {
    private HospitalMediator mediator;

    @Override
    public void setMediator(HospitalMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void performDuty(Patient patient) {
        System.out.println("Nurse assisting patient: " + patient.getId());
        mediator.assignRoom(patient);
    }
}
