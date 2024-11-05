interface HospitalMediator {
    void assignRoom(String idString);
    void notifyDoctor(String idString);
    void requestTest(String idString);
    void prescribeMedication(String idString);
    void dispenseMedication(String idString);
    void generateInvoice(String iString);
}
