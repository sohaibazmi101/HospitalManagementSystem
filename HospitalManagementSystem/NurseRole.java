class NurseRole implements Role {

    static HospitalMediatorImpl mediator = new HospitalMediatorImpl();

    @Override
    public void setMediator(HospitalMediator mediator) {
    }

    @Override
    public void performDuty(String idString) {
        System.out.println("Nurse assisting patient: " + idString);
        System.out.println("Treatment is Continued");
    }

    public static void proceedToDischarge(String idString) {
        Role pharmacy = new PharmacyRole();
        mediator.setPharmacy(pharmacy);
        System.out.println("Patients " + idString + " is Ready to discharge");
        mediator.prescribeMedication(idString);
    }
}
