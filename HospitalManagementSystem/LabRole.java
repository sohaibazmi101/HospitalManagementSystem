class LabRole implements Role {

    @Override
    public void setMediator(HospitalMediator mediator) {
    }

    @Override
    public void performDuty(String idString) {
        System.out.println("Lab conducting tests for patient: " + idString);
        System.out.println("Initial Test Conducted");
        System.out.println("Sample Collecting");
        System.out.println("Report Generated");
        System.out.println("Report Forwarded to Doctor");
    }
}
