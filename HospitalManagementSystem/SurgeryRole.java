import java.util.Scanner;

public class SurgeryRole implements Role{


    HospitalMediatorImpl mediator = new HospitalMediatorImpl();
    Role nurse = new NurseRole();
    Role billing = new BillingRole();

    @Override
    public void setMediator(HospitalMediator mediator) {
    }

    @Override
    public void performDuty(String idString) {
        mediator.setNurse(nurse);
        mediator.setBilling(billing);
        System.out.println("Is Surgery Successful(y for Yes  for No)");
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().toLowerCase();
        if(input.equals("y")){
            System.out.println("Congrates Surgery is successful");
            mediator.dispenseMedication(idString);
            System.out.println("Proceed To Discharge");
            mediator.generateInvoice(idString);
        }else if(input.equals("n")){
            System.out.println("Surgery is not successful");
            System.out.println("Is patients Alive(y for yes n for No)");
            String input2 = scanner.nextLine().trim().toLowerCase();
            if(input2.equals("y")){
                System.out.println("Go to Nurse ward");
                mediator.dispenseMedication(idString);
                mediator.generateInvoice(idString);
            }else if(input2.equals("n")){
                System.out.println("Go to Billing Role");
                mediator.generateInvoice(idString);
            }
        }
    }
}
