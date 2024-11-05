class NurseRole implements Role {

    static PharmacyRole pharmacyRole = new PharmacyRole();

    @SuppressWarnings("unused")
    private HospitalMediator mediator;

    @Override
    public void setMediator(HospitalMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void performDuty(String idString) {
        System.out.println("Nurse assisting patient: " + idString);
        System.out.println("Treatment is Continued");
        DoctorRole.ableToDischarge(idString);
    }

    public static void proceedToDischarge(String idString){
        System.out.println("Patients "+idString+" is Ready to discharge");
        pharmacyRole.performDuty(idString);
    }
}
