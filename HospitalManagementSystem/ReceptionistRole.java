

class ReceptionistRole implements Role {
    @SuppressWarnings("unused")
    private HospitalMediator mediator;

    @Override
    public void setMediator(HospitalMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void performDuty(String idString) {
        System.out.println("Receptionist registering patient: " + idString);
        System.out.println("Room has Been Assigned To patient "+idString);
        DoctorRole.isTestRequired(idString);
    }
}
