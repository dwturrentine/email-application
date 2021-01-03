package emailapp;

import java.util.Scanner;

public class Email {
	
	/*
	 Email Application
		
		Email accounts for new hires

		Generate email with syntax firstname.lastname@department.company.com
		
		Determine the department (sales, development, accounting), if none leave blank
		
		Generate a random string for password
		
		Have set methods to change password, set mailbox capacity, and define an alternate email address
		
		Have get methods to display name, email, and mailbox capacity
	 */
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "xyzcompany.com";
	

	// Constructor to receive the first and last name
	
	public Email(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		
		
		// Call a method for the department - return the department
		this.department = setDepartment();
		
		
		// Call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
		// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;  
		
	}
	
	// Ask for the department
	
	private String setDepartment( ) {
		System.out.println("New worker: " + firstName + ". Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if (depChoice == 1) {
			return "sales";
		}
		else if (depChoice == 2) {
			return "dev"; 
		}
		else if (depChoice == 3 ) {
			return "acct";
		}
		else {
			return "";
		}
		
	}
	
	// Generate random password
	
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int rand = (int)
				(Math.random() * passwordSet.length());
				password[i] = passwordSet.charAt(rand);
			}
			return new String(password);
	
	}

	// Change the password
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	//Set mailbox capacity
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	public void setMailboxCapacity(int mailboxCapacity) {
		this.mailboxCapacity = mailboxCapacity;
	}
	
	// Set alternate email
	public String getAlternateEmail() {
		return alternateEmail;
	}

	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName +
				"\nCOMPANY EMAIL: " + email + 
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
		}
	
	
}
