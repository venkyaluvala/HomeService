package RevatureProject1.Maven1;

import java.sql.SQLException;
import java.util.Scanner;

public class home_service {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String str ="yes";
		Scanner sc = new Scanner(System.in);
		while(str == "yes") {
	    System.out.println("$$$$$$$$$ WELCOME TO HOME SERVICES  $$$$$$$$$$$");
		System.out.println("Enter 1 for creating user account : ");
		System.out.println("Enter 2 for login user account : ");
		int choice1 = sc.nextInt();
		
		Login lg = new Login();
		switch (choice1){
			case 1:lg.Create_Acc();
			       break;
			case 2:lg.Validate_Acc();
			       
			       break;
			default :System.out.println("choose correct option ");
		}
		System.out.println("**** ENTER yes TO CONTINUE no FOR EXIT ");
		String s = sc.next();
		if(s.equals("no")) {
			break;
		}

	}

  }
}
