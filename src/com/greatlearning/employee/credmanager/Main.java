package com.greatlearning.employee.credmanager;

public class Main {

	public static void main(String[] args) {
		generateCredentials();
	}

	static void generateCredentials() {
		EmailApplication emailApplication = new EmailApplication();
		emailApplication.init();
	}
}