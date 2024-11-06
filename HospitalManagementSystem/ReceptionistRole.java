

class ReceptionistRole implements Role {

    @Override
    public void setMediator(HospitalMediator mediator) {
    }

    @Override
    public void performDuty(String idString) {
        System.out.println("Receptionist registering patient: " + idString);
        System.out.println("Room has Been Assigned To patient "+idString);
    }
}
