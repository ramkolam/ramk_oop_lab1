package com.greatlearning.employee.credmanager;

import com.greatlearning.employee.credmanager.model.Employee;
import com.greatlearning.employee.credmanager.service.CredentialsManagerServiceImpl;
import com.greatlearning.employee.credmanager.utils.EmailAppUtils;

import java.util.Scanner;

public class EmailApplication {

	public void init() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your first name");
		String firstname = input.nextLine().trim().replace(" ","");
		
		System.out.println("Enter your last name");		
		String lastname = input.nextLine().trim().replace(" ","");;
		
		System.out.println("Enter your department \nSpecify the following department code values\n1. Technical\n2. Admin\n3. Human Resource\n4. Legal");
		// Handling exception: if user enters a non numerical value for department code
		Object nextInput = input.nextLine();
		int departmentCode = 0;
		try{
			departmentCode = Integer.valueOf((String)nextInput);
		}catch(Exception e){
			System.out.println("Invalid Department Code");
			System.out.println("Enter a department code between 1 and 4");
			System.out.println("Please try running the application again...");
			System.exit(-1);
		}

		if (EmailAppUtils.validateDepartmentCode(departmentCode)) {
			CredentialsManagerServiceImpl credentialsManagerService =
				new CredentialsManagerServiceImpl();
			Employee empObj = credentialsManagerService.generateCredentials(firstname, lastname, departmentCode);
			credentialsManagerService.showCredentials(empObj);
		}else {
			System.out.println("Invalid Department Code");
			System.out.println("Enter a department code between 1 and 4");
			System.out.println("Please try again...");
		}
	}
}