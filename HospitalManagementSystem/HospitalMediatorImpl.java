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

    public void setLab(Role lab) 
{
 this.lab = lab;
 this.lab.setMediator(this); 
}
 public void setPharmacy(Role pharmacy) {
 this.pharmacy = pharmacy; 
this.pharmacy.setMediator(this);
 }
 public void setBilling(Role billing) {
 this.billing = billing;
 this.billing.setMediator(this); }

    @Override
    public void assignRoom(Patient patient) {
        System.out.println("Assigning room for patient: " + patient.getId());
        notifyDoctor(patient);
    }

    @Override
    public void notifyDoctor(Patient patient) {
        System.out.println("Notifying doctor about patient: " + patient.getId());
        doctor.performDuty(patient);
    }

    @Override
    public void requestTest(Patient patient) {
        System.out.println("Requesting test for patient: " + patient.getId());
        if (lab != null) lab.performDuty(patient);
    }

    @Override
    public void prescribeMedication(Patient patient) {
        System.out.println("Doctor prescribing medication for patient: " + patient.getId());
        if (pharmacy != null) pharmacy.performDuty(patient);
    }

    @Override
    public void dispenseMedication(Patient patient) {
        System.out.println("Dispensing medication for patient: " + patient.getId());
    }

    @Override
    public void generateInvoice(Patient patient) {
        System.out.println("Generating invoice for patient: " + patient.getId());
    }
}
