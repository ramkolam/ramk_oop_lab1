package com.greatlearning.employee.credmanager.service;

import com.greatlearning.employee.credmanager.model.Employee;

public interface CredentialsManagerService {
	Employee generateCredentials(String firstname, String lastname, int departmentCode);
	void showCredentials(Employee employee);

}