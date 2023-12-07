package com.greatlearning.employee.credmanager.service;

import com.greatlearning.employee.credmanager.model.Employee;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CredentialsManagerServiceImpl
	implements CredentialsManagerService {

	public Employee generateCredentials(String firstname, String lastname, int departmentCode) {
		Employee empObj = new Employee(firstname, lastname);

		// use credential service to generate email address
		String emailAddress  = generateEmailAddress(
				firstname, lastname, departmentCode);

		// use credential service to generate password
		String password = generatePassword();
		empObj.setEmailAddress(emailAddress);
		empObj.setPassword(password);
		return empObj;
	}

	@Override
	public void showCredentials(Employee employee) {
		System.out.println("Dear " + employee.getFirstname()
				+ ", your generated credentials are as follows"+"\nEmail        --->  "
				+ employee.getEmailAddress()+"\nPassword     --->  " + employee.getPassword());
	}


	private String generateEmailAddress(
			String firstName, String lastName, int departmentCode) {

		StringBuilder emailAddressBuilder =
				new StringBuilder();

		// lower case conversion
		emailAddressBuilder.append(firstName.toLowerCase());

		//emailAddressBuilder.append(".");

		// lower case conversion
		emailAddressBuilder.append(lastName.toLowerCase());

		emailAddressBuilder.append("@");

		String departmentName = "";

		if (departmentCode == 1) {
			departmentName = "tech";
		}else if (departmentCode == 2) {
			departmentName = "admin";
		}else if (departmentCode == 3) {
			departmentName = "hr";
		}else if (departmentCode == 4) {
			departmentName = "legal";
		}else {

			System.out.println("Incorrect department code value");
		}

		emailAddressBuilder.append(departmentName);
		emailAddressBuilder.append(".");
		emailAddressBuilder.append("gl.com");
		return emailAddressBuilder.toString();
	}


	private String generatePassword() {
		String capitalLeters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallCaseLetters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String specialCharacters = "~@#$%^&*()-=+<>?'][}{";
		List<String> password = new ArrayList<String>();
		final Random rng = new SecureRandom();

		java.util.Random randomObj
				= new java.util.Random();
		// 1st category - 2 capital-case characters
		password.add(String.valueOf(capitalLeters.charAt(randomObj.nextInt(capitalLeters.length()))));
		password.add(String.valueOf(capitalLeters.charAt(randomObj.nextInt(capitalLeters.length()))));

		// 2nd category - 2 small-case characters
		password.add(String.valueOf(smallCaseLetters.charAt(randomObj.nextInt(smallCaseLetters.length()))));
		password.add(String.valueOf(smallCaseLetters.charAt(randomObj.nextInt(smallCaseLetters.length()))));
		// 3rd category - 2 numbers
		password.add(String.valueOf(numbers.charAt(randomObj.nextInt(numbers.length()))));
		password.add(String.valueOf(numbers.charAt(randomObj.nextInt(numbers.length()))));

		// 4th category - 2 special characters
		password.add(String.valueOf(specialCharacters.charAt(randomObj.nextInt(specialCharacters.length()))));
		password.add(String.valueOf(specialCharacters.charAt(randomObj.nextInt(specialCharacters.length()))));
		Collections.shuffle(password, rng);
		String listString = "";

		for (String s : password)
		{
			listString += s;
		}
		return listString;
	}
}