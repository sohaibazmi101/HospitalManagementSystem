import java.util.Scanner;

class PharmacyRole implements Role {
    @Override
    public void setMediator(HospitalMediator mediator) {
    }

    @Override
    public void performDuty(Patient patient) {
        System.out.println("Pharmacy dispensing medication for patient: " + patient.getId());
    }

    public static void serveMedication(String idString){
        System.out.println("Medication Recieved (y or n) : ");
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().toLowerCase();
        if(input.equals("y")){
            System.out.println("Go To Billing Section");
            BillingRole.paymentGateway(idString);
        }
        else if(input.equals("n")){
            DoctorRole.checkCondition(idString);
        }
        else{
            System.out.println("Wrong Input (y for Yes n for No)");
            serveMedication(idString);
        }
    }
}
