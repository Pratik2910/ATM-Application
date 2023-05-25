package Java;
import java.util.*;
import java.text.*;
class Account
{
	double CB=2000;
	double SB=1000;
	private int CN;
	private int PN;
	Scanner s=new Scanner(System.in);
	DecimalFormat df=new DecimalFormat("'Rupee '###,##0.00");
	void setCustomerNumber(int CustomerNumber)
	{
		CN=CustomerNumber;
		//System.out.println("CN ");
	}
	void setPINNumber(int PINNumber)
	{
		PN=PINNumber;
//		System.out.println("PN ");
	}
	int getCustomerNumber() {
		return CN;
	}
	int getPINNumber() {
		return PN;
	}
	double getCurrentBalance()
	{
		return CB;
	}
	double getSavingBalance()
	{
		return SB;
	}
	double calciCurrentWithdraw(double Money)
	{
		CB=CB-Money;
		return CB;
	}
	double calciSavingWithdraw(double Money)
	{
		SB=SB-Money;
		return SB;
	}
	double calciCurrentDeposite(double Money)
	{
		CB=CB+Money;
		return CB;
	}
	double calciSavingDeposite(double Money)
	{
		SB=SB+Money;
		return SB;
	}
	void getCurrentWithdrawInput()
	{
		System.out.println("Your Current Account Balance : "+df.format(CB));
		System.out.print("Please Enter the Amount You Want to Withdraw : ");
		double Amount =s.nextDouble();
		if((CB - Amount)>=0)
		{
			calciCurrentWithdraw(Amount);
			System.out.println("Your New Current Account Balance : " + df.format(CB));
		}
		else
		{
			System.out.println("Insufficient Account Balance,Enter Valid Amount");
		}
	}
	void getSavingWithdrawInput() 
	{
		System.out.println("Your Saving Account Balance : "+df.format(SB));
		System.out.print("Please Enter the Amount You Want to Withdraw : ");
		double Amount =s.nextDouble();
		if((SB - Amount)>=0)
		{
			calciSavingWithdraw(Amount);
			System.out.println("Your New Saving Account Balance : " + df.format(SB));
		}
		else
		{
			System.out.println("Insufficient Account Balance,Enter Valid Amount");
		}
	}
	void getCurrentDepositInput()
	{
		System.out.println("Your Current Account Balance : "+ df.format(CB));
		System.out.print("Please Enter the Amount You Want to Deposite : ");
		double Amount =s.nextDouble();
		calciCurrentDeposite(Amount);
		System.out.println("Your New Current Account Balance : " + df.format(CB));
		
	}
	void getSavingDepositInput()
	{
		System.out.println("Your Saving Account Balance : "+ df.format(SB));
		System.out.print("Please Enter the Amount You Want to Deposite : ");
		double Amount =s.nextDouble();
		calciSavingDeposite(Amount);
		System.out.println("Your New Saving Account Balance : " + df.format(SB));
		
	}
}
class OptionMenu extends Account
{
	Scanner s=new Scanner(System.in);
	HashMap<Integer,Integer> hm=new HashMap<>();
	DecimalFormat df=new DecimalFormat("'Rupee '###,##0.00");
	void getlogin()
	{
		int x=1;
		do
		{
			try
			{
				System.out.println("---------------Welcome to the RSCOE ATM----------------");
				System.out.println();
				System.out.print("Enter your Customer Number : ");
				setCustomerNumber(s.nextInt());
				System.out.println();
				System.out.print("Enter your PIN Number : ");
				setPINNumber(s.nextInt());
				System.out.println();
				hm.put(11111, 11111);
				hm.put(12345, 12345);
				hm.put(67890, 67890);
				hm.put(22222, 22222);
				hm.put(33333, 33333);
				int a=getCustomerNumber();
				int b=getPINNumber();
				if(hm.containsKey(a) && hm.get(a)==b)
				{
					getAccountType();
				}
				else
				{
					System.out.println("Please Try Again");
				}
				
			}
			catch(InputMismatchException A)
			{
				System.out.println("Please Enter only Number ,Characters and Symbol are not Allowed");
				x=2;
			}
			
			
		}while(x==1);	
	}
	void getAccountType()
	{
		System.out.println("Select Account Type : ");
		System.out.println("Type 1: Current Account");
		System.out.println("Type 2: Saving Account");
		System.out.println("Type 3: Exit");
		System.out.print("Choice : ");
		
		int choice=s.nextInt();
		switch(choice)
		{
		case 1: 
			getCurrent();
			break;
		case 2:
			getSaving();
			break;
		case 3:
			System.out.println("Thanks for visiting! Visit Again.");
			break;
		default: 
			System.out.println("Invalid Choice! Please Enter Valid Choice");
			
		}
	}
	void getCurrent()
	{
		System.out.println(" Current Account : ");
		System.out.println("Type 1: View Current Balance");
		System.out.println("Type 2: Withdraw Funds");
		System.out.println("Type 3: Deposite Funds");
		System.out.println("Type 4: Exit");
		System.out.print("Choice : ");
		int choice=s.nextInt();
		switch(choice) 
		{
		case 1:
			System.out.println("Your Current Balance : "+ df.format(getCurrentBalance()));
			getCurrent();
			break;
		case 2:
			getCurrentWithdrawInput();
			getCurrent();
			break;
		case 3:
			getCurrentDepositInput();
			getCurrent();
			break;
		case 4:
			System.out.println("Thank you for Visiting! Visit Again.");
			getAccountType();
			break;
		default:
			System.out.println("Invalid Choice! Enter Valid Choice");
			getCurrent();
			break;
		}
		}
		
	void getSaving()
	{
		System.out.println(" Saving Account : ");
		System.out.println("Type 1: View Saving Balance");
		System.out.println("Type 2: Withdraw Funds");
		System.out.println("Type 3: Deposite Funds");
		System.out.println("Type 4: Exit");
		System.out.print("Choice : ");
		int choice=s.nextInt();
		switch(choice) 
		{
		case 1:
			System.out.println("Your Saving Balance : "+ df.format(getSavingBalance()));
			getSaving();
			break;
		case 2:
			getSavingWithdrawInput();
			getSaving();
			break;
		case 3:
			getSavingDepositInput();
			getSaving();
			break;
		case 4:
			System.out.println("Thank you for Visiting! Visit Again.");
			getAccountType();
			break;
		default:
			System.out.println("Invalid Choice! Enter Valid Choice");
			getSaving();
			break;
		}
	}
}
public class ATM extends OptionMenu
{
	public static void main(String[] args)
	{
		OptionMenu op=new OptionMenu();
		op.getlogin();
	}
}




