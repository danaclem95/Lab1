import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class SavingMoney {
	
	// Note: this program ASSUMES that numbers are going in.

	public static void main(String[] args) {
		System.out.println("Who's ready for RETIREMENT?");
		System.out.println("Let's figure out how much money you should be saving!");
		System.out.println("");
		Scanner in = new Scanner(System.in);
		
        System.out.println("How many years do you plan to work? ");
        int years = in.nextInt();
        
        System.out.println("What is your annual return for your investments? (Write as a number, not a percent.)");
        double IROI = in.nextDouble();
        while (IROI > .2){
        	System.out.println("The annual return must be .20 or lower. Try again: ");
        	IROI = in.nextDouble();
        }
        
        System.out.println("How many years do you want to use your retirement funds?");
        int retirementyears = in.nextInt();
        
        System.out.println("What is your annual return for your payback?  (Write as a number, not a percent.)");
        double PROI = in.nextDouble();
        while (PROI > .03){
        	System.out.println("The annual return must be .03 or lower. Try again: ");
        	PROI = in.nextDouble();
        }
        
        System.out.println("What is your required income?");
        double requiredIncome = in.nextDouble();
        
        System.out.println("What is your monthly Social Security Income?");
        double SSI = in.nextDouble();
        
        in.close();
        
        System.out.println("");
        
        double desiredMonthlySalary = requiredIncome - SSI;
        double answer = 0;
        
        for (int i = 0; i < retirementyears; i ++){
        	for (int j = 0; j < 12; j ++){
        		answer = answer + desiredMonthlySalary;
        	}
        	desiredMonthlySalary = desiredMonthlySalary / (1 + PROI);
        }
 
        NumberFormat moneys = new DecimalFormat("#.00");
        System.out.println("You need to save up $" + moneys.format(answer) + " to have that salary after retirement.");
        System.out.println("");
        
        answer = (answer*IROI / 12) / (Math.pow((1 + IROI), years) - 1);
        
        System.out.println("Every month, you should save up $" + moneys.format(answer) + " to save up for retirement.");
	}

}
