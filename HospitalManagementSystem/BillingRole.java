import java.util.Scanner;

class BillingRole implements Role {
    @Override
    public void setMediator(HospitalMediator mediator) {
    }

    @Override
    public void performDuty(String idString) {
        System.out.println("Billing generating invoice for patient: " + idString);
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is Payment Successful(y or n)");
        String input = scanner.nextLine().trim().toLowerCase();
        if(input.equals("y")){
            System.out.println("Patients "+idString+" Discharged");
        }
        else if (input.equals("n")) {
            System.out.println("Please Try Again");
            performDuty(idString);
        }else{
            System.out.println("Incorrect Input (y for Yes n for No)");
            performDuty(idString);
        }
    }
}
