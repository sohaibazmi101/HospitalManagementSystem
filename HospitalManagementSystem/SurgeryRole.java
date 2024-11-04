import java.util.Scanner;

public class SurgeryRole {
    public static void surgeryWard(String idString){
        System.out.println("Is Surgery Successful(y for Yes  for No)");
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().toLowerCase();
        if(input.equals("y")){
            System.out.println("Congrates Surgery is successful");
            NurseRole.continueTreatment(idString);
        }else if(input.equals("n")){
            System.out.println("Surgery is not successful");
            System.out.println("Is patients Alive(y for yes n for No)");
            String input2 = scanner.nextLine().trim().toLowerCase();
            if(input2.equals("y")){
                System.out.println("Go to Nurse ward");
                NurseRole.continueTreatment(idString);
            }else if(input2.equals("n")){
                System.out.println("Go to Billing Role");
                BillingRole.paymentGateway(idString);
            }
        }
    }
}
