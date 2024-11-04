interface HospitalMediator {
    void assignRoom(Patient patient);
    void notifyDoctor(Patient patient);
    void requestTest(Patient patient);
    void prescribeMedication(Patient patient);
    void dispenseMedication(Patient patient);
    void generateInvoice(Patient patient);
}
