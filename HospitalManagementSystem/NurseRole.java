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

    public static void continueTreatment(String idString){
        System.out.println("Treatment is Continued");
        DoctorRole.ableToDischarge(idString);
    }

    public static void proceedToDischarge(String idString){
        System.out.println("Patients "+idString+" is Ready to discharge");
        PharmacyRole.serveMedication(idString);
    }
}
