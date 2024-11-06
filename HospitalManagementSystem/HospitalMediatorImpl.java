class HospitalMediatorImpl implements HospitalMediator {
    private Role doctor;
    private Role nurse;
    private Role receptionist;
    private Role lab;
    private Role pharmacy;
    private Role billing;

    public void setDoctor(Role doctor) {
        this.doctor = doctor;
        this.doctor.setMediator(this);
    }

    public void setNurse(Role nurse) {
        this.nurse = nurse;
        this.nurse.setMediator(this);
    }

    public void setReceptionist(Role receptionist) {
        this.receptionist = receptionist;
        this.receptionist.setMediator(this);
    }

    public void setLab(Role lab) {
        this.lab = lab;
        this.lab.setMediator(this);
    }

    public void setPharmacy(Role pharmacy) {
        this.pharmacy = pharmacy;
        this.pharmacy.setMediator(this);
    }

    public void setBilling(Role billing) {
        this.billing = billing;
        this.billing.setMediator(this);
    }

    @Override
    public void assignRoom(String idString) {
        System.out.println("Assigning room for patient: " + idString);
        receptionist.performDuty(idString);
    }

    @Override
    public void notifyDoctor(String idString) {
        System.out.println("Notifying doctor about patient: " + idString);
        doctor.performDuty(idString);
    }

    @Override
    public void requestTest(String idString) {
        System.out.println("Requesting test for patient: " + idString);
        lab.performDuty(idString);
    }

    @Override
    public void prescribeMedication(String idString) {// Pharmacy Role
        System.out.println("Doctor prescribing medication for patient: " + idString);
        pharmacy.performDuty(idString);
    }

    @Override
    public void dispenseMedication(String idString) {//Nurse Role
        System.out.println("Dispensing medication for patient: " + idString);
        nurse.performDuty(idString);
    }

    @Override
    public void generateInvoice(String idString) {// Billing Role
        System.out.println("Generating invoice for patient: " + idString);
        billing.performDuty(idString);
    }
}
