import java.util.Scanner;

class PharmacyRole implements Role {
    HospitalMediatorImpl mediator = new HospitalMediatorImpl();
    Role doctor = new DoctorRole();
    Role billing = new BillingRole();
    @Override
    public void setMediator(HospitalMediator mediator) {
    }

    @Override
    public void performDuty(String idString) {
        System.out.println("Pharmacy dispensing medication for patient: " + idString);
        System.out.println("Medication Recieved (y or n) : ");
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().toLowerCase();
        if(input.equals("y")){
            System.out.println("Go To Billing Section");
            mediator.setBilling(billing);
            mediator.generateInvoice(idString);
        }
        else if(input.equals("n")){
            mediator.setDoctor(doctor);
            mediator.assignRoom(idString);
        }
        else{
            System.out.println("Wrong Input (y for Yes n for No)");
            performDuty(idString);
        }
    }
}
