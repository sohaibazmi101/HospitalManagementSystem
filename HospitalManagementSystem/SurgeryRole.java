import java.util.Scanner;

public class SurgeryRole implements Role{

    static NurseRole nurseRole = new NurseRole();
    static BillingRole billingRole = new BillingRole();

    @SuppressWarnings("unused")
    private HospitalMediator mediator;

    @Override
    public void setMediator(HospitalMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void performDuty(String idString) {
        System.out.println("Is Surgery Successful(y for Yes  for No)");
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().toLowerCase();
        if(input.equals("y")){
            System.out.println("Congrates Surgery is successful");
            nurseRole.performDuty(idString);
        }else if(input.equals("n")){
            System.out.println("Surgery is not successful");
            System.out.println("Is patients Alive(y for yes n for No)");
            String input2 = scanner.nextLine().trim().toLowerCase();
            if(input2.equals("y")){
                System.out.println("Go to Nurse ward");
                nurseRole.performDuty(idString);
            }else if(input2.equals("n")){
                System.out.println("Go to Billing Role");
                billingRole.performDuty(idString);
            }
        }
    }
}
