package RevatureProject1.Maven1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;



public class Login {
	
	Db_connection db = new Db_connection();
	Scanner sc = new Scanner(System.in);
	Connection con = db.getMyConnection();
	public void Create_Acc() throws SQLException {
		System.out.println("Enter your User name : ");
	    String User_name = sc.next();
	    System.out.println("Enter your password : ");
	    String password = sc.next();
		System.out.println("Enter your phone no : ");
	    String phone_no = sc.next();
		PreparedStatement st = con.prepareStatement("insert into Userdata(User_name,password,phone_no) values (? , ? ,? )");
		st.setString(1, User_name);
		st.setString(2, password);
		st.setString(3, phone_no);
		
		int i = st.executeUpdate();
		switch (i) {
		case 1 :System.out.println("######## ACCOUNT CREATED SUCCESSFULLY ########");
		       break;
		default:System.out.println("######## ACCOUNT NOT CREATED ########");
		}
		con.close();
	}
	public void Update_pswd(String User_name) throws SQLException {
		System.out.println("Enter your new password :");
		String newPassword = sc.next();
		 PreparedStatement st = con.prepareStatement("update Userdata set password = ? where User_name = ? " );
         st.setString(2,User_name);
         st.setString(1,newPassword);
         int i = st.executeUpdate();
         if (i == 1) {
        	 System.out.println("***** YOUR PASSWORD UPDATED SUCCESSFULLY *****");
         }
         else {
        	 System.out.println("***** YOUR PASSWORD NOT UPDATED *****");
         }
	}
	public String address() {
		Scanner sc1 = new Scanner(System.in);
		return sc1.nextLine();
	}
	public void Homeservices(String User_name) throws SQLException {
		 System.out.println("Enter 1 for Electritian service :");
   	  System.out.println("Enter 2 for Plumber service :");
   	  System.out.println("Enter 3 for Gas repair service :");
   	  
   	  
   	  int s = sc.nextInt();
   	  
   	 

   	  String str1 = "Electritian : Shanker | phone no : 9103465254 | charges per hr : 90 Rs ";
   	  String str2 = "plumber : Ramesh | phone no : 8303465243 | charges per hr : 99 Rs ";
   	  String str3 = "Gas service man : Rahul | phone no : 7804464253 | charges per hr : 110 Rs ";
   	  String str4 = null;
   	  switch (s) {
   	  case 1 : str4 = str1;
   	           break;
   	  case 2 : str4 = str2;
               break;
   	  case 3 : str4 = str3;
   	           break;
   	  default:System.out.println("choose correct service ");
   	  }
   	  
   	  
        System.out.println(str4);
        System.out.println("Enter your address :");
        Login lg = new Login();
        String Address = lg.address();
        
   	 System.out.println("Enter yes to conform order :");
        String o = sc.next();
        if(o.equals("yes")) {
        	 PreparedStatement st = con.prepareStatement("update Userdata set orders =?,Address = ? where User_name = ?");
        	 st.setString(1, str4);
        	 st.setString(2, Address );
        	 st.setString(3, User_name );
        	 int l = st.executeUpdate();
        	 if(l == 1) {
        		 System.out.println("your order confirmed successfully");
        	 }
        }
	}
	public void orders(String User_name) throws SQLException {
		 PreparedStatement st = con.prepareStatement("select orders from Userdata where User_name = ?");
    	 st.setString(1,User_name );
    	 ResultSet rs = st.executeQuery();
    	 while(rs.next()) {
    		 if(rs.getString(1) != null) {
    		 System.out.println(rs.getString(1));
    		 }
    		 else {
    			 System.out.println("You have no orders placed "); 
    		 }
    	 }
	}
	
	public void Validate_Acc() throws SQLException {
		System.out.println("Enter your User name : ");
	    String User_name = sc.next();
	    System.out.println("Enter your password : ");
	    String password = sc.next();
		HashMap<String,String> ht = new HashMap<String,String>();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from Userdata");    
	     //   boolean b=rs.next();
	       // System.out.println(b);
	         while(rs.next()){    
	             // System.out.println(rs.getString(1)); 
	             // System.out.println(rs.getString(2));
	              ht.put(rs.getString(1), rs.getString(2));
	            
	         }  
	         // Closing connection  
	        con.close();
	        String str;
	        Login lg = new Login();
	        
	        	
	            str = ht.get(User_name);
	         
	            if(str == null) {
	        	 
	        	 System.out.println("**** Entered User name or password is wrong try again ****");
	 			 lg.Validate_Acc();
	 			 }
	        
	        System.out.println(str);
	 		if(str.equals(password)) {
	 			
	 		System.out.println("********* LOGGED INTO YOUR ACCOUNT SUCCESSFULLY **********"+"\n");
	 		
			System.out.println("********** MAIN MENU ***********");
			System.out.println("Enter 1 to update password : ");
			System.out.println("For Homeservices enter 2 :");
			System.out.println("To see your orders enter 3 :");
			int choice2 = sc.nextInt();
			
			switch (choice2) {
			case 1:lg.Update_pswd(User_name);
			       break;
			case 2:lg.Homeservices(User_name);
			      break;
			case 3:lg.orders(User_name);
			      break;
		  //  defualt : System.out.println("***** Choose correct option *****");
			}
		}
	 		else {
	 			System.out.println("**** Entered User name or password is wrong try again ****");
	 			lg.Validate_Acc();
	 			
	 		}
	 				
	 			
	}

	 		
	 		
 }
	

